package com.example.freelancerhomescreen;

public class Employer {
    private int employerID;
    private String companyName;
    private String priorities;
private String description;


    public Employer(String companyName, String priorities, String description) {
        this.companyName = companyName;
        this.priorities = priorities;
        this.description = description;

    }
    public Employer(String companyName, String priorities, String description,int employerID) {
        this.companyName = companyName;
        this.priorities = priorities;
        this.description = description;
        this.employerID = employerID;
    }

    public Employer() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryBasedIn() {
        return priorities;
    }

    public void setCountryBasedIn(String countryBasedIn) {
        this.priorities = countryBasedIn;
    }
}
