package com.mi19.JPATemplate.abstracts;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ExtensionEntity<ID,P> extends SimpleEntity<ID> {
    public abstract void addTo(P parent);
}
