package com.company.inventory.services;

import com.company.inventory.model.Categoria;
import com.company.inventory.response.CategoriaResponseREST;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {
	public ResponseEntity<CategoriaResponseREST> search();
	public ResponseEntity<CategoriaResponseREST> searchById(Long id);
	public ResponseEntity<CategoriaResponseREST> save(Categoria categoria);
	public ResponseEntity<CategoriaResponseREST> update(Categoria categoria, Long id);
	public ResponseEntity<CategoriaResponseREST> deleteById(Long id);
}