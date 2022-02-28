package com.nttdata.curso.crud.controllers;

import com.nttdata.curso.crud.entities.Client;
import com.nttdata.curso.crud.entities.Product;
import com.nttdata.curso.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> products = clientService.findAll();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findOneById(@PathVariable Long id) {
        try{
            Client product = clientService.findOneById(id);
            if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(product);
        } catch (Error e){
            System.err.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Client> save(@RequestBody Client product) {
        try {
            return new ResponseEntity<>(clientService.create(product), HttpStatus.CREATED);
        } catch (Error e){
            System.err.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client product) {
        try {
            Client productUpdated = clientService.update(id, product);
            if (productUpdated == null){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Client());
            }
            return new ResponseEntity<>(clientService.update(id, product), HttpStatus.CREATED);
        } catch (Error e){
            System.err.println(e);
            return ResponseEntity.badRequest().body(new Client());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Product> deleteById(@PathVariable Long id) {
        try {
            boolean deleted = clientService.deleteById(id);
            if (deleted){
                return ResponseEntity.ok().body(new Product());
            } else {
                return ResponseEntity.unprocessableEntity().build();
            }
        } catch (Error e){
            System.err.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

}
