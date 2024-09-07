package com.reuben.issuetrucker.issuetrucker.Service;

import com.reuben.issuetrucker.issuetrucker.Model.Issue;
import com.reuben.issuetrucker.issuetrucker.Repository.IssueRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IssueServiceImplTest {

    // findById returns an Issue when the id exists in the repository
    @Test
    public void testFindByIdReturnsIssueWhenIdExists() {
        IssueRepository issueRepository = Mockito.mock(IssueRepository.class);
        IssueServiceImpl issueService = new IssueServiceImpl(issueRepository);
        Issue issue = new Issue();
        issue.setId(1L);
        issue.setTitle("Test Issue");
        issue.setDescription("Test Description");

        Mockito.when(issueRepository.findById(1L)).thenReturn(Optional.of(issue));

        Issue result = issueService.findById(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("Test Issue", result.getTitle());
        Assertions.assertEquals("Test Description", result.getDescription());
    }
    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void getList() {
    }
}