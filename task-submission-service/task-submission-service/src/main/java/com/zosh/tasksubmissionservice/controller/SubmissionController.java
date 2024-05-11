package com.zosh.tasksubmissionservice.controller;

import com.zosh.tasksubmissionservice.modal.Submission;
import com.zosh.tasksubmissionservice.modal.UserDto;
import com.zosh.tasksubmissionservice.service.SubmissionService;
import com.zosh.tasksubmissionservice.service.TaskService;
import com.zosh.tasksubmissionservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Submission>submitTask(
            @RequestParam Long task_id,
            @RequestParam String github_link,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{

        UserDto user = userService.getUserProfile(jwt);
        Submission submission =submissionService.submitTask(task_id,github_link,user.getId(),jwt);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Submission>getSubmissionById(
            @PathVariable Long id,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{

        UserDto user = userService.getUserProfile(jwt);
        Submission submission =submissionService.getTaskSubmissionById(id);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<List<Submission>>getAllSubmissions(
            @PathVariable Long id,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{

        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submission =submissionService.getAllTasksubmissions();
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }


    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Submission>>getAllSubmission(
            @PathVariable Long taskId,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{

        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submission =submissionService.getTaskSubmissionByTaskId(taskId);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission>acceptOrDeclineLineSubmisssion(
            @PathVariable Long id,
            @RequestParam ("status") String status,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{

        UserDto user = userService.getUserProfile(jwt);
        Submission submission =submissionService.acceptDeclinesubmissions(id,status);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }


}
