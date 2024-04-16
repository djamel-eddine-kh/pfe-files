package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.embeddable.BiId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BiAssociationService<E extends BiAssociationEntity<FE,FID,SE,SID>,FE extends SimpleEntity<FID>,FID,SE extends SimpleEntity<SID>,SID> extends BaseService<E, BiId<FID,SID>> {
    BaseService<FE,FID> firstService;
    BaseService<SE,SID> secondService;
    public BiAssociationService(BiAssociationRepository<E,FE,FID,SE,SID> repository, BaseService<FE,FID> firstService, BaseService<SE,SID> secondService) {
        super(repository);
        this.firstService=firstService;
        this.secondService=secondService;
    }

    @Transactional
    public List<E> findByFirstId(FID firstId){
        return ((BiAssociationRepository<E,FE,FID,SE,SID>)repository).findByFirstId(firstId).stream().map(this::dto).collect(Collectors.toList());
    }
    @Transactional
    public List<E> findBySecondId(SID secondId){
        return ((BiAssociationRepository<E,FE,FID,SE,SID>)repository).findByIdSecondId(secondId).stream().map(this::dto).collect(Collectors.toList());
    }
    @Transactional
    public void save(E _new,FID firstId, SID secondId){
        FE first= firstService.getReferenceById(firstId);
        SE second=secondService.getReferenceById(secondId);
        if (first!=null&&second!=null) {
            _new.associatedWith(first,second);
            repository.save(_new);
        }
    }

    public void deleteByFirstId(FID firstId){
        ((BiAssociationRepository<E,FE,FID,SE,SID>)repository).deleteByFirstId(firstId);
    }
    public void deleteBySecondId(SID secondId){
        ((BiAssociationRepository<E,FE,FID,SE,SID>)repository).deleteByIdSecondId(secondId);
    }
}
