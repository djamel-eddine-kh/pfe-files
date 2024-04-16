package com.mi19.JPATemplate.abstracts;

import org.springframework.web.bind.annotation.*;

import java.util.List;
public abstract class BaseController<E extends BaseEntity<ID>,ID> {

    protected final BaseService<E,ID> service;
    public BaseController(BaseService<E,ID> service){
        this.service=service;
    }

    @GetMapping("/all")
    public List<E> findAll(){
        return service.findAll();
    }
    @GetMapping
    E findById(@RequestAttribute ID id){
        return service.findById(id);
    }

    @PutMapping
    public void update(@RequestBody E _new){
        service.update(_new);
    }

    @DeleteMapping("/all")
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping
    void deleteById(@RequestAttribute ID id){service.deleteById(id);
    }


}
