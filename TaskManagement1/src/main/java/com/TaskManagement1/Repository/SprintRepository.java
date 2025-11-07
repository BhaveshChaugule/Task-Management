package com.TaskManagement1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManagement1.Entity.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint,Long>{

}
