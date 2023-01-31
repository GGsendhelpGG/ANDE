package com.example.freelancerhomescreen;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHandler  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FirehireDB";
    private static final String KEY_USERID = "userid";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRIORITIES = "priorities";
    private static final String KEY_EMAIL = "email";
    private static final String TABLE_PROJECTS = "Projects";
    private static final String KEY_PASSWORD = "password";
    private static final String TABLE_EMPLOYERS = "Employers";
    private static final int DATABASE_VERSION = 2;
    private static final String KEY_DESCRIPTION = "description";
    private static final String TABLE_FREELANCERS = "Freelancers";
    private static final String KEY_YOUR_SKILLS ="freelancerSkills";
    private static final String KEY_UEN ="uen";
    private static final String KEY_PROJECTID = "projId";
    private static final String KEY_LINK = "link";
    private static final String KEY_startDATE = "start_date";
    private static final String KEY_DATE = "end_date";
    private static final String KEY_SKILLS = "skills";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists "+TABLE_FREELANCERS);
        String CREATE_EMPLOYERS_TABLE = "CREATE TABLE " + TABLE_EMPLOYERS + "("
                + KEY_USERID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_EMAIL+" TEXT NOT NULL ,"
                + KEY_PASSWORD+" TEXT NOT NULL ,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL,"
                + KEY_PRIORITIES + " TEXT DEFAULT \"start,\" NOT NULL, "
                + KEY_UEN + " TEXT NOT NULL"
                + ");";
        String CREATE_FREELANCERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_FREELANCERS + "("
                + "freelancerId INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_EMAIL + " TEXT NOT NULL,"
                + KEY_PASSWORD + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL, "
                + KEY_YOUR_SKILLS + " TEXT NOT NULL"
                + ");";
        String CREATE_PROJECTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_PROJECTS + "("
                + KEY_PROJECTID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_startDATE + " TEXT NOT NULL,"
                + KEY_DATE + " TEXT NOT NULL,"
                + KEY_LINK + " TEXT NOT NULL,"
                + KEY_SKILLS + " TEXT NOT NULL,"
                + KEY_DESCRIPTION + " TEXT NOT NULL,"
                + "freelancerID INTEGER NOT NULL,"
                + "FOREIGN KEY(freelancerID) REFERENCES Freelancers(freelancerId)"
                + ");";
        db.execSQL(CREATE_EMPLOYERS_TABLE);
        db.execSQL(CREATE_FREELANCERS_TABLE);
        db.execSQL(CREATE_PROJECTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FREELANCERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECTS);
        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    public void addContact(Employer contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cr = new ContentValues();
        cr.put(KEY_EMAIL, "test@test.com");
        cr.put(KEY_PASSWORD, "test");
        cr.put(KEY_DESCRIPTION, "test");
        cr.put(KEY_NAME,"test");
        db.insert(TABLE_EMPLOYERS, null, cr);
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, contact.getEmpEmail());
        values.put(KEY_PASSWORD, contact.getEmpPassword());// Contact Phone
        values.put(KEY_NAME, contact.getCompanyName()); // Contact Name
        values.put(KEY_DESCRIPTION, contact.getDescription()); // Contact Phone
        values.put(KEY_UEN,"start");


        // Inserting Row
        db.insert(TABLE_EMPLOYERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    Employer getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EMPLOYERS, new String[] { KEY_NAME,
                        KEY_DESCRIPTION, KEY_PRIORITIES }, KEY_USERID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employer contact = new Employer(cursor.getString(0) ,
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }
    public void addFreelancers(Freelancer freelancer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, freelancer.getName()); // Contact Name
        values.put(KEY_DESCRIPTION, freelancer.getDescription()); // Contact Phone
        values.put(KEY_EMAIL, freelancer.getEmail());
        values.put(KEY_PASSWORD, freelancer.getHashPassword());
        values.put(KEY_YOUR_SKILLS, freelancer.getSkills());

        // Contact Phone

        // Inserting Row
        db.insert(TABLE_FREELANCERS, null, values);
        //2nd argument is String containing nullColumnHack

        // Closing database connection
    }
    public ArrayList<Freelancer> getAllFreelancer() {
        ArrayList<Freelancer> freelancerList = new ArrayList<Freelancer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FREELANCERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Freelancer contact = new Freelancer();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contact.setHashPassword(cursor.getString(3));
                contact.setDescription(cursor.getString(4));
                contact.setSkills(cursor.getString(5));
                // Adding contact to list
                freelancerList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return freelancerList;
    }

//    // code to get all contacts in a list view
    public ArrayList <Employer> getAllEmployers() {
        ArrayList <Employer> contactList = new ArrayList<Employer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Employer contact = new Employer();
                contact.setEmpEmail(cursor.getString(1));
                contact.setCompanyName(cursor.getString(3));
                contact.setDescription(cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // code to update the single contact
    public int updateEmployer(Employer employer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, employer.getCompanyName());
        values.put(KEY_DESCRIPTION, employer.getDescription());
        values.put(KEY_PRIORITIES,employer.getPriorities());
        Log.d("update debugging", employer.getEmployerID()+"");
        // updating row
        return db.update(TABLE_EMPLOYERS, values, KEY_USERID + " = ?",
                new String[] { String.valueOf(employer.getEmployerID()) });
    }

    Projects get1Project(int projId){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROJECTS, new String[] { KEY_NAME,
                        KEY_startDATE,KEY_DATE,KEY_LINK,KEY_SKILLS, KEY_DESCRIPTION, KEY_USERID }, KEY_PROJECTID + "=?",
                new String[] { String.valueOf(projId) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Projects p1 = new Projects(cursor.getString(0) , cursor.getString(1), cursor.getString(2), cursor.getString(3) ,cursor.getString(4) ,cursor.getString(5), cursor.getInt(6) );
        // return contact
        return p1;
    }

    public ArrayList<Projects> getAllProjects (int userid){
        ArrayList <Projects> projectList = new ArrayList<Projects>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PROJECTS +" WHERE "+KEY_USERID+" = "+userid;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Projects proj = new Projects();
                proj.setNameOfProject(cursor.getString(1));
                proj.setStartDate(cursor.getString(2));
                proj.setEndDate(cursor.getString(3));
                proj.setLink(cursor.getString(4));
                proj.setSkills(cursor.getString(5));
                proj.setDescription(cursor.getString(6));
                // Adding contact to list
                projectList.add(proj);
            } while (cursor.moveToNext());
        }
        // return contact list
        return projectList;
    }
//    // Deleting single contact
//    public void deleteContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.getID()) });
//        db.close();
//    }
//
//    // Getting contacts Count
//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }
}