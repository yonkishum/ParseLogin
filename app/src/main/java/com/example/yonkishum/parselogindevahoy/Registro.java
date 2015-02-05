package com.example.yonkishum.parselogindevahoy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class Registro extends ActionBarActivity {

    private EditText reUser, rePass, reCop, reEmail;
    private Button reBut;
    private Context reCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        reCon = this;

        reUser = (EditText) findViewById(R.id.rUser);
        rePass = (EditText) findViewById(R.id.rPass);
        reCop = (EditText) findViewById(R.id.rCpass);
        reEmail = (EditText) findViewById(R.id.rEmail);
        reBut = (Button) findViewById(R.id.buttonR);

        reBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usermame = reUser.getText().toString().trim().toLowerCase();
                String password = rePass.getText().toString().trim();
                String conpassw = reCop.getText().toString().trim();
                String correo = reEmail.getText().toString().trim();

                if (password.equals(conpassw)){
                    ParseUser user = new ParseUser();
                    user.setUsername(usermame);
                    user.setPassword(password);
                    user.setEmail(correo);

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){
                                Toast.makeText(getApplicationContext(), "Gracias por Registrarse", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), Login.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error en la Base de Datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Confirme su Contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
