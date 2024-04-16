package com.mi19.JPATemplate.abstracts;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ExtensionService<E extends ExtensionEntity<ID,P>,ID,P extends BaseEntity<PID>,PID> extends BaseService<E,ID> {
    private final BaseService<P,PID> parentService;
    public ExtensionService(ExtensionRepository<E,ID,P,PID> repository, BaseService<P,PID> parentService) {
        super(repository);
        this.parentService=parentService;
    }
    /*protected final P getParent(PID parentId){return parentService.getReferenceById(parentId);}
    protected abstract List<E> getListFromParent(PID parentId);
    @Transactional
    public  List<E>findByParentId(PID parentId){
        return getListFromParent(parentId).stream().map(this::dto).collect(Collectors.toList());
    }*/
    @Transactional
    public  List<E>findByParentId(PID parentId){
        return ((ExtensionRepository<E,ID,P,PID>)repository).findByParentId(parentId).stream().map(this::dto).collect(Collectors.toList());
    }
    @Transactional
    public void save(E _new, PID parentId){
        P parent=parentService.getReferenceById(parentId);
        if (parent!=null) {
            _new.addTo(parent);
            repository.save(_new);
            //((Site)parent).getCondidats().add((Condidat) _new);
        }
    }
    @Transactional
    public void deleteByParentId(PID parentId){
        ((ExtensionRepository<E,ID,P,PID>)repository).deleteByParentId(parentId);
    }
}
