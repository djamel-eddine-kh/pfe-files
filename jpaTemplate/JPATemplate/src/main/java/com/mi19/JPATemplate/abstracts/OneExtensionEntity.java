package com.mi19.JPATemplate.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@MappedSuperclass
@Getter
@Setter
public abstract class OneExtensionEntity<ID,P> extends ExtensionEntity<ID,P> {
    @Id
    private ID id;

    @OneToOne
    @MapsId
    //@JoinColumn(name = "id")
    private P parent;

    public void addTo(P parent){
        setParent(parent);
    }
}
