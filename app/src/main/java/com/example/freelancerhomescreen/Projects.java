package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class Projects {
private int userId;
private String nameOfProject;
    private String startDate;

private String endDate;
private String link;
private String skills;
private String description;

    public Projects(String nameOfProject,String startDate, String endDate, String link, String skills, String description) {
        this.nameOfProject = nameOfProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.skills = skills;
        this.description = description;
    }
    public Projects(String nameOfProject,String startDate, String endDate, String link, String skills, String description, int userId ) {

        this.nameOfProject = nameOfProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.skills = skills;
        this.description = description;
        this.userId = userId;
    }
    public Projects() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getEndDate() {
        return endDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}