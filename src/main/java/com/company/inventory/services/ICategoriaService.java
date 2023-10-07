package com.company.inventory.services;

import com.company.inventory.response.CategoriaResponseREST;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {
	public ResponseEntity<CategoriaResponseREST> search();
}