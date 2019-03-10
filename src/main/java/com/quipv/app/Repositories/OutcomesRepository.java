package com.quipv.app.Repositories;

import com.quipv.app.Models.OutcomesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component @Repository
public interface OutcomesRepository extends CrudRepository<OutcomesEntity, Integer> {

}
