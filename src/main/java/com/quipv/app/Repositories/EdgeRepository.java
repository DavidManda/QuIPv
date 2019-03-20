package com.quipv.app.Repositories;

import com.quipv.app.Models.EdgeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface EdgeRepository extends CrudRepository<EdgeEntity, Integer> {

    @Query("SELECT e FROM EdgeEntity e WHERE e.user = :user AND e.projectId = :pid")
    List<EdgeEntity> findEdgesForUserAndProject(@Param("user") String user, @Param("pid") Integer pid);
}
