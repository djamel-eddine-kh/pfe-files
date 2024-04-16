package com.mi19.JPATemplate.abstracts;

import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class ExtensionController<E extends ExtensionEntity<ID,P>,ID,P extends BaseEntity<PID>,PID> extends BaseController<E,ID>{

    public ExtensionController(ExtensionService<E, ID,P,PID> service) {
        super(service);
    }

    @GetMapping("/from")
    List<E> findByParentId(@RequestAttribute("parent_id") PID parentId){
        return ((ExtensionService<E,ID,P,PID>)service).findByParentId(parentId);
    }

    @PostMapping("/from")
    void add(@RequestBody E _new, @RequestAttribute("parent_id") PID parentId){
        ((ExtensionService<E,ID,P,PID>)service).save(_new,parentId);
    }

    @DeleteMapping("/from")
    void deleteByParentId(@RequestAttribute("parent_id") PID parentId){
        ((ExtensionService<E,ID,P,PID>)service).deleteByParentId(parentId);
    }

}
