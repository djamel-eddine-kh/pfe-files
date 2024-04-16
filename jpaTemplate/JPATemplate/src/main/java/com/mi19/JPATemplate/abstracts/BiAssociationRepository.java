package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.embeddable.BiId;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BiAssociationRepository<E extends BiAssociationEntity<FE,FID,SE,SID>,FE extends SimpleEntity<FID>,FID,SE extends SimpleEntity<SID>,SID> extends BaseRepository<E, BiId<FID,SID>>{
    List<E> findByFirstId(FID firstId);
    List<E> findByIdSecondId(SID secondId);

    void deleteByFirstId(FID firstId);
    void deleteByIdSecondId(SID secondId);
}
