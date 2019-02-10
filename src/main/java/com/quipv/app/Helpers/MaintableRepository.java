package com.quipv.app.Helpers;

import com.quipv.app.DBO.SdrLiveMaintableEntity;
import org.springframework.data.repository.CrudRepository;

public interface MaintableRepository extends CrudRepository<SdrLiveMaintableEntity, Long> {

}
