package com.company.inventory.controller;

import com.company.inventory.response.CategoriaResponseREST;
import com.company.inventory.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService servicioCategorias;

	@GetMapping("/categories")
	public ResponseEntity<CategoriaResponseREST> searchCategories(){

		ResponseEntity<CategoriaResponseREST> response = servicioCategorias.search();
		return response;
	}
}