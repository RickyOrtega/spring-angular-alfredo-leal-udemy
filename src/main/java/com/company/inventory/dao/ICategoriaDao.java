package com.company.inventory.dao;

import com.company.inventory.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>{

}