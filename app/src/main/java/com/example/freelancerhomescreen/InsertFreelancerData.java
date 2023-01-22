package com.example.freelancerhomescreen;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertFreelancerData extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateTables db = new CreateTables(this);

        Freelancer f1 = new Freelancer("Rai Shayaan Kharal","rskharal@icloud.com","pgfjfisen21423","I am a driven individual who specialises in object" +
                "oriented languages, with a knack for finishing work to the highest quality");
        Freelancer f2 =  new Freelancer("Jared Jaimon","jumbobeatz@gmail.com","gtfbgdfxvf","I am a driven individual who is willing to put in effort with regards to" +
                "anything i am assigned. I am great with all languages but my best ones are JavaScript, and Java");
        Freelancer f3 =  new Freelancer("Mohd Syauqi","deadingeneral@gmail.com","gtfrefbgdfxvf","I am a driven individual who is willing to put in effort with regards to" +
                "anything i am assigned. I am great with web security and JavaScript, and Java");
        db.addFreelancers(f1);
        db.addFreelancers(f2);
        db.addFreelancers(f3);

    }

    public void insertUserData() {
//        Sha256LayoutBinding sha256LayoutBinding = Sha256LayoutBinding.inflate(getLayoutInflater());
//        String passwordToHash = "password";
//        String salt = sha256LayoutBinding.shaSalt.getText();
//
//        String securePassword = get_SHA_1_SecurePassword(passwordToHash, salt);





    }

//    public static String get_SHA_1_SecurePassword(String passwordToHash, String salt){
//        String generatedPassword = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-1");
//            md.update(salt.getBytes());
//            byte[] bytes = md.digest(passwordToHash.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < bytes.length; i++) {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
//                        .substring(1));
//            }
//            generatedPassword = sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return generatedPassword;
//    }



}
