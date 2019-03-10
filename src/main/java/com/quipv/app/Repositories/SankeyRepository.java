package com.quipv.app.Repositories;

import com.quipv.app.Models.SankeyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component @Repository
public interface SankeyRepository extends CrudRepository<SankeyEntity, Integer> {

}
