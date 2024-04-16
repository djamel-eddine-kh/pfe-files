package com.mi19.JPATemplate.abstracts;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID> implements Cloneable{

    public abstract void setId(ID id);
    public abstract ID getId();

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


}
