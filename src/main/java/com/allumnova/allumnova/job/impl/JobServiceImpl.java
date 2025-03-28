package com.allumnova.allumnova.job.impl;

import com.allumnova.allumnova.job.Job;
import com.allumnova.allumnova.job.JobRespository;
import com.allumnova.allumnova.job.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
 JobRespository jobRespository;


    public JobServiceImpl(JobRespository jobRespository) {
        this.jobRespository = jobRespository;
    }

    @Override
    public List<Job> findAll() {
        return jobRespository.findAll();
    }

    @Override
    @Transactional
    public void createJob(Job job) {

      jobRespository.save(job);
    }

    @Override
    public Job getJobById(Integer id) {
      return   jobRespository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteJobById(Integer id) {
        try {
            jobRespository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    @Transactional
    public boolean updateJob(Integer id, Job updatedJob) {
        Optional<Job> jobOptional=jobRespository.findById(id);

            if (jobOptional.isPresent()){
                Job job =jobOptional.get() ;
                job.setJob_title(updatedJob.getJob_title());
                job.setDescription(updatedJob.getDescription());
                job.setJob_type(updatedJob.getJob_type());
                job.setCompany_name(updatedJob.getCompany_name());
                job.setLocation(updatedJob.getLocation());
                job.setRating(updatedJob.getRating());
                jobRespository.save(job);
                return true;
            }

        return false;
    }

}
