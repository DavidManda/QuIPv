package com.quipv.app.Repositories;

import com.quipv.app.Models.SankeyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component @Repository
public interface SankeyRepository extends CrudRepository<SankeyEntity, Integer> {
}
