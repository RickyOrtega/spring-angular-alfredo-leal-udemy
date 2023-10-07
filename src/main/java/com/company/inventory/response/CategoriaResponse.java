package com.company.inventory.response;

import com.company.inventory.model.Categoria;
import lombok.Data;

import java.util.List;

@Data
public class CategoriaResponse {
	private List<Categoria> categorias;
}