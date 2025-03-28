package com.allumnova.allumnova.job;

import java.util.List;

public interface JobService {
   List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Integer id);

    boolean deleteJobById(Integer id);

    boolean updateJob(Integer id, Job updatedJob);
}
