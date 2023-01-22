package com.example.freelancerhomescreen;

public class YourSkills {

    private String userID;
    private String skillsID;
    private String skillsName;

    public YourSkills(String userID, String skillsID, String skillsName) {
        this.userID = userID;
        this.skillsID = skillsID;
        this.skillsName = skillsName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSkillsID() {
        return skillsID;
    }

    public void setSkillsID(String skillsID) {
        this.skillsID = skillsID;
    }

    public String getSkillsName() {
        return skillsName;
    }

    public void setSkillsName(String skillsName) {
        this.skillsName = skillsName;
    }
}
