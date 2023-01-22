package com.example.freelancerhomescreen;

public class ExperienceRecyclerItem {
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    public ExperienceRecyclerItem(String name, String startDate, String endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}
