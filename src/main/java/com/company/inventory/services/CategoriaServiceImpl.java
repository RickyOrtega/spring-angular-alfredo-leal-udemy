package com.company.inventory.services;

import com.company.inventory.dao.ICategoriaDao;
import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseREST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	@Autowired
	private ICategoriaDao categoriaDao;
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseREST> search() {
		CategoriaResponseREST response = new CategoriaResponseREST();

		try{
			List<Categoria> categorias = (List<Categoria>) categoriaDao.findAll();

			response.getCategoriaResponse().setCategorias(categorias);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseREST> searchById(Long id){
		CategoriaResponseREST response = new CategoriaResponseREST();
		List<Categoria> categoriasList= new ArrayList<>();

		try{

			Optional<Categoria> categoria = categoriaDao.findById(id);

			if(categoria.isPresent()){
				categoriasList.add(categoria.get());
				response.getCategoriaResponse().setCategorias(categoriasList);
				response.setMetadata("Respuesta nok", "00", "Categoría encontrada");
			} else {
				response.setMetadata("Respuesta nok", "-1", "Categoría no encontrada");
				return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al consultar por id");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseREST> save(Categoria categoria) {
		CategoriaResponseREST response = new CategoriaResponseREST();
		List<Categoria> categoriasList= new ArrayList<>();

		try{

			Categoria categoriaGuardada = categoriaDao.save(categoria);

			if(categoriaGuardada != null){
				categoriasList.add(categoriaGuardada);
				response.getCategoriaResponse().setCategorias(categoriasList);
				response.setMetadata("Respuesta ok", "00", "Categoría guardada");
			} else {
				response.setMetadata("Respuesta nok", "-1", "Categoría no guardada");
				return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al guardar la categoría");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategoriaResponseREST> update(Categoria categoria, Long id) {
		CategoriaResponseREST response = new CategoriaResponseREST();
		List<Categoria> categoriasList= new ArrayList<>();

		try{

			Optional<Categoria> categoriaSearch = categoriaDao.findById(id);

			if(categoriaSearch.isPresent()){
				categoriaDao.save(categoria);
				response.setMetadata("Respuesta ok", "00", "Categoría actualizada");
				categoriasList.add(categoria);
				response.getCategoriaResponse().setCategorias(categoriasList);
				return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.OK);
			} else {
				response.setMetadata("Respuesta nok", "-1", "Categoría no encontrada");
				return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al guardar la categoría");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
