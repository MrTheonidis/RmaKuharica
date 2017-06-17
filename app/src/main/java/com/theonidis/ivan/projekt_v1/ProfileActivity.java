package com.theonidis.ivan.projekt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button mButtonLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView)findViewById(R.id.textViewUserEmail);

        textViewUserEmail.setText("Wellcome " + user.getEmail());
        buttonLogout = (Button)findViewById(R.id.buttonLogout);
        mButtonLaunch = (Button)findViewById(R.id.launch_btn);

        buttonLogout.setOnClickListener(this);
        mButtonLaunch.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }else

        launchActivity();
    }

    private void launchActivity() {

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
