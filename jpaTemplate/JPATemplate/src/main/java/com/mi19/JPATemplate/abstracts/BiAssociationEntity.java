package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.embeddable.BiId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;

@MappedSuperclass
@Getter
@Setter
public abstract class BiAssociationEntity<FE extends SimpleEntity<FID>,FID,SE extends SimpleEntity<SID>,SID> extends AssociationEntity<BiId<FID,SID>>{
    @EmbeddedId
    private BiId<FID,SID> id=new BiId<>();
    @ManyToOne
    @MapsId("firstId")
    private FE first;
    @ManyToOne
    @MapsId("secondId")
    private SE second;
    public void associatedWith(FE first,SE second){
        setFirst(first);
        setSecond(second);
    }
}
