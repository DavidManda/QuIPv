package com.quipv.app.Repositories;

import com.quipv.app.Models.GraphNodeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface GraphNodeRepository extends CrudRepository<GraphNodeEntity, Integer> {

    @Query("SELECT p FROM GraphNodeEntity p WHERE p.user = :user")
    List<GraphNodeEntity> findNodesForUser(@Param("user") String user);
}
