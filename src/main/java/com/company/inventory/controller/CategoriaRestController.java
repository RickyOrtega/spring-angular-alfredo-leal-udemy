package com.company.inventory.controller;

import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseREST;
import com.company.inventory.response.ResponseRest;
import com.company.inventory.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService servicioCategorias;

	/**
	 * get all categories
	 * @return
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoriaResponseREST> searchCategories(){

		ResponseEntity<CategoriaResponseREST> response = servicioCategorias.search();
		return response;
	}

	/**
	 * get categories by id
	 * @param id
	 * @return
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoriaResponseREST> searchCategoriesById(@PathVariable Long id){

		ResponseEntity<CategoriaResponseREST> response = servicioCategorias.searchById(id);
		return response;
	}

	/**
	 * save categories on BD
	 * @param categoria
	 * @return
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoriaResponseREST> save(@RequestBody Categoria categoria){
		ResponseEntity<CategoriaResponseREST> response = servicioCategorias.save(categoria);
		return response;
	}

	/**
	 * update categories on BD
	 * @param categoria
	 * @param id
	 * @return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoriaResponseREST> update(@RequestBody Categoria categoria, @PathVariable Long id){
		ResponseEntity<CategoriaResponseREST> response = servicioCategorias.update(categoria, id);
		return response;
	}
}