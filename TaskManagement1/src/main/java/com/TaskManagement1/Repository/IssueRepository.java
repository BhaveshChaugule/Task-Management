package com.TaskManagement1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManagement1.Entity.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
	
	Optional<Issue>findByIssueKey(String issueKey);
	List<Issue>findByAssignedEmail(String assignedEmail);
	List<Issue>findBySprintId(Long sprintId);
	List<Issue>findByEpicId(Long epicId);
	List<Issue>findByIssueStatus(String status);

}
