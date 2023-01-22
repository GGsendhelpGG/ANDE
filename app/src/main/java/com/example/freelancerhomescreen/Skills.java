package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Skills {

    private String name;
private int skillsID;
    public Skills(String name) {
        this.name = name;
    }
    public Skills() {

    }
    public Skills(int skillsID,String name) {
        this.skillsID = skillsID;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}