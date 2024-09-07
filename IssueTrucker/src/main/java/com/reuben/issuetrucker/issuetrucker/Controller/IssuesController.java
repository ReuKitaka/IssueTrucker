package com.reuben.issuetrucker.issuetrucker.Controller;

import com.reuben.issuetrucker.issuetrucker.DTO.IssueDto;
import com.reuben.issuetrucker.issuetrucker.Model.Issue;
import com.reuben.issuetrucker.issuetrucker.Service.IssueService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/issues")
@Slf4j
public class IssuesController {

    private final IssueService issueService;

    private final ModelMapper modelMapper;

    public IssuesController(IssueService issueService, ModelMapper modelMapper) {
        this.issueService = issueService;
        this.modelMapper = modelMapper;
    }


    @PostMapping()
    public ResponseEntity<IssueDto> save(@RequestBody IssueDto issueDto) {
        Issue issue = issueService.save(modelMapper.map(issueDto, Issue.class));
        IssueDto savedIssue = modelMapper.map(issue, IssueDto.class);
        log.info("Issue saved: {}", savedIssue);
        return new ResponseEntity<>((savedIssue), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<IssueDto> update(@RequestBody IssueDto issueDto, @PathVariable Long id) throws Exception {
        Issue updateIssue = issueService.findById(id);
        updateIssue.setTitle(issueDto.getTitle());
        updateIssue.setDescription(issueDto.getDescription());
        issueService.save(updateIssue);
        IssueDto updateIssueDto =  modelMapper.map(updateIssue, IssueDto.class);
        log.info("Issue updated: {}", updateIssueDto);
        return new ResponseEntity<>((updateIssueDto), HttpStatus.OK);
    }

    @GetMapping
    public List<IssueDto> getList() {
        List<Issue> issuesList = issueService.getList();
        log.info("Issues list: {}", issuesList);
        return issuesList.stream()
                .map(issue -> modelMapper.map(issue, IssueDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public IssueDto findById(@PathVariable Long id) {
        Issue issue =  issueService.findById(id);
        log.info("Issue found: {}", issue);
        return modelMapper.map(issue, IssueDto.class);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) {
        Issue issue = issueService.findById(id);
        issueService.deleteById(issue.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        log.info("Issue deleted: {}", issue);
        return response;

    }

}
