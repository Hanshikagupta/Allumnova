package com.allumnova.allumnova.job;

import com.allumnova.allumnova.company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String company_name;
    private String job_title;
    private String location;
    private String job_type;
    private String description;
    private Float rating;
    private Integer user_id;
    private String created_at;
    @ManyToOne
    private Company company;
    public Job() {
    }

    public Job(Integer id, String company_name, String job_title, String location, String job_type, String description, Float rating, Integer user_id, String created_at, Company company) {
        this.id = id;
        this.company_name = company_name;
        this.job_title = job_title;
        this.location = location;
        this.job_type = job_type;
        this.description = description;
        this.rating = rating;
        this.user_id = user_id;
        this.created_at = created_at;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
