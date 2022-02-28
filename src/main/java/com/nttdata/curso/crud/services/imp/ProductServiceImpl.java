package com.nttdata.curso.crud.services.imp;

import com.nttdata.curso.crud.entities.Product;
import com.nttdata.curso.crud.repositories.ProductRepository;
import com.nttdata.curso.crud.services.ProductService;
import com.nttdata.curso.crud.services.commons.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, ProductRepository> implements ProductService  {

    public Product update(Long id, Product product) {
        Product newProduct = this.findOneById(id);
        newProduct.setName(product.getName());
        newProduct.setSku(product.getSku());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        return repository.save(newProduct);
    }


    @Override
    public List<Product> findByName(String name){
        return repository.findByNombre(name);
    }
}
