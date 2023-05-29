package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://loginregister-84934-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText username = findViewById(R.id.username);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);

        final Button signupBtn = findViewById(R.id.signupBtn);
        final TextView loginnowBtn = findViewById(R.id.loginnowBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //gt data from EditTexts into String variables
                final String fullnameTxt = fullname.getText().toString();
                final String usernameTxt = username.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                
                //check if user fill all the fields before sending data to firebase
                if(fullnameTxt.isEmpty() || usernameTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if phone iss not registered before
                            if(snapshot.hasChild(usernameTxt)){
                                Toast.makeText(RegisterActivity.this, "Username is already registered.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //sending data to firebase Realtime Database
                                //we are using phone number as unique identity of every user.
                                databaseReference.child("users").child(usernameTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(usernameTxt).child("usename").setValue(usernameTxt);
                                databaseReference.child("users").child(usernameTxt).child("phone").setValue(phoneTxt);
                                databaseReference.child("users").child(usernameTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(RegisterActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        loginnowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}