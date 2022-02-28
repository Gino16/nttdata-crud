package com.nttdata.curso.crud.services;

import com.nttdata.curso.crud.entities.Product;
import com.nttdata.curso.crud.services.commons.CommonService;

import java.util.List;

public interface ProductService extends CommonService<Product> {

    public Product update(Long id, Product product);
    public List<Product> findByName(String name);
}
