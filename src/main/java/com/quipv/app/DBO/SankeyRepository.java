package com.quipv.app.DBO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component @Repository
public interface SankeyRepository extends CrudRepository<SankeyEntity, Integer> {

}
