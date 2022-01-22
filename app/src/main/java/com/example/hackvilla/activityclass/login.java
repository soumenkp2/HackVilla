package com.example.hackvilla.activityclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackvilla.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public String pacode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        TextView loginbtn = (TextView) findViewById(R.id.loginbtn);
        TextView newuser = (TextView) findViewById(R.id.newuser);

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Registration_form.class);
                startActivity(i);

            }
        });

        mAuth = FirebaseAuth.getInstance();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginbtn.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.blackoutlinebg));

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.isEmpty() || pass.isEmpty())
                {
                    Toast.makeText(login.this, "null", Toast.LENGTH_SHORT).show();
                }

                else
                {


                    mAuth.signInWithEmailAndPassword(user, pass)
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        pacode = username.getText().toString().substring(0,3);

                                        if(pacode.equals("200"))
                                        {
                                            Intent i = new Intent(login.this, MainActivity.class);
                                            i.putExtra("username", user);
                                            i.putExtra("userid", Objects.requireNonNull(mAuth.getCurrentUser()).getUid());
                                            startActivity(i);

                                        }
                                        else if(pacode.equals("100"))
                                        {
                                            Intent i = new Intent(login.this, MainActivity.class);
                                            i.putExtra("username", user);
                                            i.putExtra("userid", Objects.requireNonNull(mAuth.getCurrentUser()).getUid());
                                            startActivity(i);

                                        }


                                        Toast.makeText(login.this, "Sucessfully Logged In", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(login.this, "Failed to Logged In", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });





                }




            }
        });



    }
}