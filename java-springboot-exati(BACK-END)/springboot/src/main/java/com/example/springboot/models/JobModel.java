package com.example.springboot.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_JOBS")
public class JobModel extends RepresentationModel<JobModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idJob;
    private String title;
    private String job_description;
    private BigDecimal salary;
    private String company_info;
    private String job_style;
    private String job_location;

    public UUID getIdJob() {
        return idJob;
    }

    public String getTitle() {
        return title;
    }

    public String getJob_description() {
        return job_description;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getCompany_info() {
        return company_info;
    }

    public String getJob_style() {
        return job_style;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setIdJob(UUID idJob) {
        this.idJob = idJob;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setCompany_info(String company_info) {
        this.company_info = company_info;
    }

    public void setJob_style(String job_style) {
        this.job_style = job_style;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }
}
