package com.example.buttommenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class LoginFrag extends Fragment {

    private TextInputEditText txtUser,txtPass;
    Button btnLogIn;
    public LoginFrag() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        txtUser=view.findViewById(R.id.etName);
        txtPass=view.findViewById(R.id.etPas);
        btnLogIn=view.findViewById(R.id.btn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=txtUser.getText().toString();
                String password=txtPass.getText().toString();
                if (userName.equals("Ahmad")&&password.equals("123456")){
                    Toast.makeText(getContext(), "Login success", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}