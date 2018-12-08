package com.g_automation.g_master_modbustcp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityConfig extends AppCompatActivity {

    EditText editIP, editporta;
    String IP, Porta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_config );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        editIP = (EditText) findViewById( R.id.editIP );
        editporta = (EditText) findViewById( R.id.editporta );

        //mostra no edit as atuas edições
        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);

            IP = sharedservidor.getString( "IPS","192.168.1.20");
            Porta = sharedservidor.getString("PORTA", "502");
            editIP.setText(IP);
            editporta.setText(Porta);



    }

    public void Salvar_no_sharad (String IP, String PORTA){

        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedservidor.edit();

            editor.putString("IPS", IP);
            editor.putString("PORTA", PORTA);


        editor.commit();

        //chama a proxima tela
        Intent trocatela=new Intent(ActivityConfig.this,ActivityPrincipal.class);
        startActivity(trocatela);
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        String Ips = editIP.getText().toString();
        String Portas = editporta.getText().toString();
        Salvar_no_sharad(Ips, Portas);


    }

}
