package com.nttdata.curso.crud.services.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class CommonServiceImpl<E, R extends JpaRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findOneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }
}
