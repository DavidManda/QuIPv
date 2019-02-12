package com.quipv.app.Helpers;

import com.quipv.app.DBO.SdrLiveMaintableEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component @Repository
public interface MaintableRepository extends CrudRepository<SdrLiveMaintableEntity, Integer> {

}
