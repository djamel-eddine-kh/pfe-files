package com.mi19.JPATemplate.abstracts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class ManyExtensionEntity<P> extends ExtensionEntity<Long,P> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@JsonBackReference
    @ManyToOne
    private P parent;

    public void addTo(P parent){
        setParent(parent);
    }
}
