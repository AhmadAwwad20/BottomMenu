package com.example.buttommenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homefrag;
    private DashFrag dashFrag;
    private LoginFrag loginFrag;
    private FrameLayout homeFrame,dashFrame,logInFrame;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFrame=findViewById(R.id.homeFrame);
        dashFrame=findViewById(R.id.dashFrame);
        logInFrame=findViewById(R.id.logInFrame);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        begin();
    }
    public void begin(){
        homefrag=new HomeFragment();
        dashFrag=new DashFrag();
        loginFrag=new LoginFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.homeFrame,homefrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.dashFrame,dashFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.logInFrame,loginFrag).commit();
        dashFrame.setVisibility(View.INVISIBLE);
        logInFrame.setVisibility(View.INVISIBLE);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    homeFrame.setVisibility(View.VISIBLE);
                    dashFrame.setVisibility(View.INVISIBLE);
                    logInFrame.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.dashBoard){
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashFrame.setVisibility(View.VISIBLE);
                    logInFrame.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.logIn){
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashFrame.setVisibility(View.INVISIBLE);
                    logInFrame.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
    }
}