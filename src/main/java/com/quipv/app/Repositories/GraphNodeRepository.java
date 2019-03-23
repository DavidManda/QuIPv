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

    @Query("SELECT n FROM GraphNodeEntity n WHERE n.user = :user AND n.projectId = :pid")
    List<GraphNodeEntity> findNodesForUserAndProject(@Param("user") String user, @Param("pid") Integer pid);

    @Query("SELECT n FROM GraphNodeEntity n WHERE n.user = :user AND n.projectId = :pid and n.nodeIndex = :index")
    GraphNodeEntity findNodeByIndex(@Param("user") String user, @Param("pid") Integer pid, @Param("index") Integer index);
}
