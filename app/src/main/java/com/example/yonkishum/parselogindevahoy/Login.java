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
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class Login extends ActionBarActivity {

    private EditText _username, _password;
    private Button _login;
    private Context _context;
    private TextView _registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _context = this;

        _login = (Button) findViewById(R.id.buttonLo);
        _password = (EditText) findViewById(R.id.password);
        _username = (EditText) findViewById(R.id.usuario);
        _registrar = (TextView) findViewById(R.id.registrar);

        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

        _registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(_context, Registro.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void checkLogin() {

        String username = _username.getText().toString().trim().toLowerCase();
        String password = _password.getText().toString().trim();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (e == null){
                    Intent i = new Intent(_context, Welcome.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
