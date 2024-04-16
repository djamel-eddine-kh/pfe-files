package com.mi19.JPATemplate.abstracts;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class MainController<E extends MainEntity<ID>,ID> extends BaseController<E,ID>{
    public MainController(MainService<E, ID> service) {
        super(service);
    }
    @PostMapping
    public void add(@RequestBody E _new){
        ((MainService<E,ID>)service).save(_new);
    }
}
