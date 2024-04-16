package com.mi19.JPATemplate.abstracts;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SimpleEntity<ID> extends BaseEntity<ID>{

}
