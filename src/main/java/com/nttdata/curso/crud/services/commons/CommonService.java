package com.nttdata.curso.crud.services.commons;


import java.util.List;

public interface CommonService<E>{
    public List<E> findAll();
    public E findOneById(Long id);
    public E create(E entity);
    public boolean deleteById(Long id);
}
