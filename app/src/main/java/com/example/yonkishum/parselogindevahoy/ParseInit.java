package com.example.yonkishum.parselogindevahoy;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Yonkishum on 05/02/2015.
 */
public class ParseInit extends Application {

    private final String KEY_APP = "756KacW4nwwb9aqThnCvWfGTxJuBEF185PU6Uq2w";
    private final String KEY_CLIENT = "rNljj0OPDMNhP7quvaMD50co1dtErvKc0HgLh6w6";

    @Override
    public void onCreate() {
        super.onCreate();
        //Inicializando la Aplicacion

        Parse.initialize(this, KEY_APP, KEY_CLIENT);
    }
}
