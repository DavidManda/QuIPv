package com.quipv.app.Repositories;

import com.quipv.app.Models.ProjectEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component @Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {

    @Query("SELECT p FROM ProjectEntity p WHERE p.user = :user")
    List<ProjectEntity> findProjectForUser(@Param("user") String user);
}
