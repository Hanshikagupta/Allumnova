package com.allumnova.allumnova.job;

import com.allumnova.allumnova.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);

        return new ResponseEntity<>("Job added ",HttpStatus.CREATED) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id){

        Job job=jobService.getJobById(id);
        if (job!=null)
          return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Integer id){
        boolean deleted =jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
@PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Integer id,
                                            @RequestBody Job updatedJob){
        boolean updated =jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


/*
get /jobs : getalljos
get /jobs/{id}: get by id
post /jobs: crete a job
delete /job/{id}
put /jobs/{id} update job by id
get /job/{id}/company get company associated with specifci job
 */
