package com.company.inventory.services;

import com.company.inventory.dao.ICategoriaDao;
import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponse;
import com.company.inventory.response.CategoriaResponseREST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
