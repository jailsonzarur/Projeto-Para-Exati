package com.example.springboot.controller;

import com.example.springboot.dtos.JobRecordDto;
import com.example.springboot.models.JobModel;
import com.example.springboot.repositories.JobRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @PostMapping("/jobs")
    public ResponseEntity<JobModel> saveJob(@RequestBody @Valid JobRecordDto jobRecordDto) {
        var jobModel = new JobModel();
        BeanUtils.copyProperties(jobRecordDto, jobModel); // Conversão do DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(jobRepository.save(jobModel));
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobModel>> getAllJobs() {
        List<JobModel> jobsList = jobRepository.findAll();
        if(!jobsList.isEmpty()) {
            for(JobModel job : jobsList) {
                UUID job_id = job.getIdJob();
                job.add(linkTo(methodOn(JobController.class).getOneJob(job_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(jobsList);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Object> getOneJob(@PathVariable(value = "id") UUID id) {
        Optional<JobModel> jobModelO = jobRepository.findById(id);
        if(jobModelO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found.");
        }
        jobModelO.get().add(linkTo(methodOn(JobController.class).getAllJobs()).withRel("Jobs list"));
        return ResponseEntity.status(HttpStatus.OK).body(jobModelO.get());
    }


    @PutMapping("/jobs/{id}")
    public ResponseEntity<Object> putJob(@PathVariable(value = "id") UUID id, @RequestBody @Valid JobRecordDto jobRecordDto) {
        Optional<JobModel> jobModelO = jobRepository.findById((id));
        if(jobModelO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found.");
        }
        var jobModel = jobModelO.get();
        BeanUtils.copyProperties(jobRecordDto, jobModel);
        return ResponseEntity.status(HttpStatus.OK).body(jobRepository.save(jobModel));
    }


    @DeleteMapping("jobs/{id}")
    public ResponseEntity<Object> deleteJob(@PathVariable(value = "id") UUID id) {
        Optional<JobModel> jobModelO = jobRepository.findById((id));
        if(jobModelO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found.");
        }
        jobRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Job deleted.");
    }
}
