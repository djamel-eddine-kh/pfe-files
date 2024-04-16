package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.embeddable.BiId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BiAssociationController<E extends BiAssociationEntity<FE,FID,SE,SID>,FE extends SimpleEntity<FID>,FID,SE extends SimpleEntity<SID>,SID> extends BaseController<E, BiId<FID,SID>> {
    public BiAssociationController(BiAssociationService<E,FE,FID,SE,SID> service) {
        super(service);
    }

    @GetMapping("/select_by_first/{firstId}")
    public List<E> findByFirstId(@PathVariable FID firstId){
        return ((BiAssociationService<E,FE,FID,SE,SID>)service).findByFirstId(firstId);
    }
    @GetMapping("/select_by_second/{secondId}")
    public List<E> findBySecondId(@PathVariable SID secondId){
        return ((BiAssociationService<E,FE,FID,SE,SID>)service).findBySecondId(secondId);
    }

    @PostMapping("/between")
    public void add(@RequestBody E _new, @RequestParam("first_id") FID firstId, @RequestParam("second_id") SID secondId){
        ((BiAssociationService<E,FE,FID,SE,SID>)service).save(_new,firstId,secondId);
    }

    @DeleteMapping("/select_by_first/{firstId}")
    public void deleteByFirstId(@PathVariable FID firstId){
        ((BiAssociationService<E,FE,FID,SE,SID>)service).deleteByFirstId(firstId);
    }
    @DeleteMapping("/select_by_second/{secondId}")
    public void deleteBySecondId(@PathVariable SID secondId){
        ((BiAssociationService<E,FE,FID,SE,SID>)service).deleteBySecondId(secondId);
    }

}
