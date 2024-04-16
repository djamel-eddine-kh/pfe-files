package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.util.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

abstract class BaseService<E extends BaseEntity<ID>,ID> {
    @Autowired
    protected ApplicationContext context;
    @Autowired
    protected Tester tester;

    protected final BaseRepository<E,ID> repository;

    public BaseService(BaseRepository<E,ID> repository){
        this.repository=repository;
    }

    protected final Class<E> getTClass(){
        return (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected final E dto (E entity){
        E dto = (E) context.getBean(getTClass()).clone();
        dto.setId(entity.getId());
        update(dto, entity);
        return dto;
    }
    protected abstract void update(E old, E _new);

    public List<E> findAll(){
        return repository.findAll().stream().map(this::dto).collect(Collectors.toList());
    }
    public E findById(ID id){
        return dto(repository.findById(id).orElseThrow(()->new IllegalStateException(getTClass().getSimpleName()+" with id "+id+" not exist")));
    }
    @Transactional
    public E getReferenceById(ID id){
        if (repository.existsById(id))
            return repository.getReferenceById(id);
        else throw new IllegalStateException(getTClass().getSimpleName()+" with id "+id+" not exist");
    }

    @Transactional
    public void update(E _new){
        E old=repository.findById(_new.getId()).orElseThrow(()->new IllegalStateException(getTClass().getSimpleName()+" with id "+ _new.getId()+" not exist"));
        update(old,_new);

    }
    public void deleteAll(){repository.deleteAll();}
    @Transactional
    public void deleteById(ID id){
        repository.findById(id).ifPresentOrElse(entity->repository.deleteById(id),()->new IllegalStateException(getTClass().getSimpleName()+" with id "+id+" not exist"));
    }

}
