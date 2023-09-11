package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;

public class activity_Register extends AppCompatActivity {

    private TextInputLayout nameTextInputLayout, edadTextInputLayout, emailTextInputLayout, passwordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        edadTextInputLayout = findViewById(R.id.edadTextInputLayout);
        emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);

        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Realiza el registro aquí, asegurándote de guardar los datos del usuario

                // Después de un registro exitoso, inicia la actividad de inicio de sesión
                Intent intent = new Intent(activity_Register.this, activity_Login.class);

                // Pasa el email y la contraseña a la actividad de inicio de sesión
                String email = emailTextInputLayout.getEditText().getText().toString();
                String password = passwordTextInputLayout.getEditText().getText().toString();

                intent.putExtra("email", email);
                intent.putExtra("password", password);

                startActivity(intent);
            }
        });
    }
}
