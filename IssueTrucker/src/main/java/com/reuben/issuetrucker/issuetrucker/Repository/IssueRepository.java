package com.reuben.issuetrucker.issuetrucker.Repository;

import com.reuben.issuetrucker.issuetrucker.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
