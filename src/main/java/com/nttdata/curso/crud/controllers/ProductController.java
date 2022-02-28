package com.nttdata.curso.crud.controllers;

import com.nttdata.curso.crud.entities.Product;
import com.nttdata.curso.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOneById(@PathVariable Long id) {
        Product product = productService.findOneById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        try {
            Product productUpdated = productService.update(id, product);
            if (productUpdated == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Product());
            }
            return new ResponseEntity<>(productService.update(id, product), HttpStatus.CREATED);
        } catch (Error e){
            System.err.println(e);
            return ResponseEntity.badRequest().body(new Product());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Product> deleteById(@PathVariable Long id) {
        boolean deleted = productService.deleteById(id);
        if (deleted){
            return ResponseEntity.ok().body(new Product());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Product>> findByNombre(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

}
