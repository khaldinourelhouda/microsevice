package com.zosh.tasksubmissionservice.service;

import com.zosh.tasksubmissionservice.modal.Submission;

import java.util.List;

public interface SubmissionService {

    Submission submitTask(Long taskId,String githubLink,Long userId,String jwt) throws Exception;

    Submission getTaskSubmissionById(Long submissionId) throws Exception;

    List<Submission> getAllTasksubmissions();

   List<Submission> getTaskSubmissionByTaskId(Long taskId);

    Submission acceptDeclinesubmissions(Long id,String status)throws Exception;
}
