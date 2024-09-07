package com.reuben.issuetrucker.issuetrucker.Service;

import com.reuben.issuetrucker.issuetrucker.Model.Issue;
import java.util.List;

public interface IssueService {

    Issue findById(Long id);

    void deleteById(Long id);

    Issue save(Issue issue);


    List<Issue> getList();
}
