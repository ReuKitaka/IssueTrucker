package com.reuben.issuetrucker.issuetrucker.Service;

import com.reuben.issuetrucker.issuetrucker.Model.Issue;
import com.reuben.issuetrucker.issuetrucker.Repository.IssueRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    @Override
    public Issue findById(Long id) {
        return issueRepository.findById(id).orElseThrow(() -> new RuntimeException("Issue with id " + id + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> getList() {
        return issueRepository.findAll();
    }

}
