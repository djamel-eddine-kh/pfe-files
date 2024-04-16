package com.mi19.JPATemplate.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class AssociationEntity<ID> extends BaseEntity<ID> {
}
