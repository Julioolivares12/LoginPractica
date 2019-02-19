package com.develop.julio.loginpractica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtcorreo,edtpass;
    private Button btnlogin,btncrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtcorreo = findViewById(R.id.edtcorreo);
        edtpass = findViewById(R.id.edtpass);

        btncrear = findViewById(R.id.btncrearcuenta);
        btnlogin = findViewById(R.id.btnlogin);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void validar (){
        String c = edtcorreo.getText().toString().trim();
        String pass = edtpass.getText().toString().trim();

        if (TextUtils.isEmpty(c)){
            edtcorreo.setError("ingresa un correo");
            edtcorreo.requestFocus();
        }else if (TextUtils.isEmpty(pass)){
            edtpass.setError("ingresa una contraseña");
            edtpass.requestFocus();
        }else if (Patterns.EMAIL_ADDRESS.matcher(c).matches()){
            Intent irAhome = new Intent(MainActivity.this,Home.class);
            startActivity(irAhome);

        }else {
            edtcorreo.setError("Correo no valido");
            edtcorreo.requestFocus();
        }
    }
}
