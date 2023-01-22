package com.example.freelancerhomescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CreateTables extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CERTIFICATIONS = "Certifications";
    private static final String TABLE_FREELANCERS = "Freelancers";
    private static final String TABLE_EMPLOYERS = "Employers";

    private static final String TABLE_PROJECTS = "Projects";
    private static final String TABLE_SKILLS = "Skills";
    private static final String TABLE_EXPERIENCE = "Experience";
    private static final String TABLE_YOURSKILLS = "YourSkills";

    private static final String DATABASE_NAME = "FirehireDB";
    private static final String KEY_USERID = "userid";
    private static final String KEY_NAME = "name";
    private static final String KEY_LINK = "link";
    private static final String KEY_startDATE = "start_date";

    private static final String KEY_DATE = "end_date";
    private static final String KEY_SKILLS = "skills";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private static final String KEY_DESCRIPTION = "description";

    public CreateTables(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //DatabaseReference certDBRef;
    @Override
    public void onCreate(SQLiteDatabase db) {
        boolean b = (db == null);
        Log.d("CreateTables onCreate", "Inside Now");

        Log.d("is database null?", Boolean.toString(b));
        //certDBRef = FirebaseDatabase.getInstance().getReference().child("Certifications");
        String CREATE_CERTIFICATIONS_TABLE = "CREATE TABLE " + TABLE_CERTIFICATIONS + "("
                + KEY_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_LINK + " TEXT NOT NULL,"
                + KEY_DATE + " TEXT NOT NULL,"
                + KEY_SKILLS + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL"
                + ");";

        String CREATE_FREELANCERS_TABLE = "CREATE TABLE " + TABLE_FREELANCERS + "("
                + "freelancerId INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_EMAIL + " TEXT NOT NULL,"
                + KEY_PASSWORD + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL"
                + ");";
        String CREATE_EMPLOYERS_TABLE = "CREATE TABLE " + TABLE_EMPLOYERS + "("
                + "employer_id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL," +
                "priorities TEXT NOT NULL"
                + ");";

        String CREATE_PROJECTS_TABLE = "CREATE TABLE " + TABLE_PROJECTS + "("
                + KEY_NAME + " TEXT NOT NULL,"
                + "based_in TEXT NOT NULL,"
                + KEY_startDATE + " TEXT NOT NULL,"
                + KEY_DATE + "TEXT NOT NULL,"
                + KEY_LINK + "TEXT NOT NULL,"
                + KEY_SKILLS + "TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL,"
                + "freelancerID INTEGER NOT NULL,"
                + "FOREIGN KEY(freelancerID) REFERENCES Freelancers(freelancerId)"
                + ");";
        String CREATE_SKILLS_TABLE = "CREATE TABLE " + TABLE_SKILLS + "("
                + "skillsID INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_NAME + " TEXT NOT NULL"
                + ");";

        String CREATE_YOURSKILLS_TABLE = "CREATE TABLE " + TABLE_YOURSKILLS + "("
                + "skillsID INTEGER NOT NULL,"
                + KEY_USERID + "INTEGER NOT NULL,"
                + "skillsName TEXT NOT NULL "
                + ");";
        String CREATE_EXPERIENCE_TABLE = "CREATE TABLE " + TABLE_EXPERIENCE + "("
                + "experienceID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_startDATE + "TEXT NOT NULL, "
                + KEY_DATE + " TEXT NOT NULL, "
                + KEY_DESCRIPTION + " TEXT NOT NULL, "
                + "company_name " + "TEXT NOT NULL"
                + ");";
        db.execSQL(CREATE_CERTIFICATIONS_TABLE);
        db.execSQL(CREATE_FREELANCERS_TABLE);
        db.execSQL(CREATE_EMPLOYERS_TABLE);
        db.execSQL(CREATE_EXPERIENCE_TABLE);
        db.execSQL(CREATE_PROJECTS_TABLE);
        db.execSQL(CREATE_SKILLS_TABLE);
        db.execSQL(CREATE_EXPERIENCE_TABLE);
        db.execSQL(CREATE_YOURSKILLS_TABLE);

        //insertCertificationData();
    }

    void addCertifications(Certification certification) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, certification.getName()); // Contact Name
        values.put(KEY_DESCRIPTION, certification.getDescription()); // Contact Phone
        values.put(KEY_LINK, certification.getLink());
        values.put(KEY_SKILLS, certification.getSkills());
        values.put(KEY_DATE, certification.getEndDate());

        // Contact Phone
        // Inserting Row
        db.insert(TABLE_CERTIFICATIONS, null, values);
        db.execSQL("SELECT * FROM Certifications");

        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    void addFreelancers(Freelancer freelancer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, freelancer.getName()); // Contact Name
        values.put(KEY_DESCRIPTION, freelancer.getDescription()); // Contact Phone
        values.put(KEY_EMAIL, freelancer.getEmail());
        values.put(KEY_PASSWORD, freelancer.getHashPassword());

        // Contact Phone

        // Inserting Row
        db.insert(TABLE_FREELANCERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.execSQL("SELECT * FROM Freelancers");

        db.close(); // Closing database connection
    }

    void addEmployers(Employer employer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, employer.getCompanyName());
        values.put("country_based_in", employer.getCountryBasedIn());// Contact Name
        values.put(KEY_DESCRIPTION, employer.getDescription()); // Contact Phone
        // Inserting Row
        db.insert(TABLE_EMPLOYERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.execSQL("SELECT * FROM Employers");

        db.close(); // Closing database connection
    }

    void addProjects(Projects projects) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, projects.getNameOfProject()); // Contact Name
        values.put("start_date", projects.getStartDate()); // Contact Phone
        values.put(KEY_DATE, projects.getEndDate());
        values.put(KEY_LINK, projects.getLink());
        values.put(KEY_SKILLS, projects.getSkills());
        values.put(KEY_DESCRIPTION, projects.getDescription());

        db.insert(TABLE_PROJECTS, null, values);
        db.execSQL("SELECT * FROM " + TABLE_PROJECTS);

        db.close(); // Closing database connection
    }

    void addSkills(Skills skills) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, skills.getName()); // Contact Name
        db.insert(TABLE_SKILLS, null, values);
        db.execSQL("SELECT * FROM " + TABLE_SKILLS);

        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    void addYourSkills(YourSkills yourskills) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, yourskills.getSkillsName()); // Contact Name
        db.insert(TABLE_YOURSKILLS, null, values);
        db.execSQL("SELECT * FROM " + TABLE_YOURSKILLS);

        db.close(); // Closing database connection
    }

    void addExperience(Experience experience) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, experience.getName());
        values.put(KEY_startDATE, experience.getStartDate());
        values.put(KEY_DATE, experience.getEndDate());
        values.put(KEY_DESCRIPTION, experience.getDescription());
        values.put("company_name", experience.getCompany());


        // Contact Name
        db.insert(TABLE_EXPERIENCE, null, values);
        //2nd argument is String containing nullColumnHack
        db.execSQL("SELECT * FROM " + TABLE_EXPERIENCE);

        db.close(); // Closing database connection
    }

    public List<Certification> getAllCertifications() {
        List<Certification> contactList = new ArrayList<Certification>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CERTIFICATIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Certification contact = new Certification();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setLink(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public List<Freelancer> getAllFreelancers() {
        List<Freelancer> contactList = new ArrayList<Freelancer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FREELANCERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Freelancer freelancer = new Freelancer();
                freelancer.setId(Integer.parseInt(cursor.getString(0)));
                freelancer.setName(cursor.getString(1));
                freelancer.setEmail(cursor.getString(2));
                freelancer.setHashPassword(cursor.getString(3));
                // Adding contact to list
                contactList.add(freelancer);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CERTIFICATIONS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FREELANCERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILLS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPERIENCE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_YOURSKILLS);

        // Create tables again
        onCreate(sqLiteDatabase);

    }
}
