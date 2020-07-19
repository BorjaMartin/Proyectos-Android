package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imgBtnPhone;
    private ImageButton imageBtnWeb;
    private ImageButton imageBtnCamera;

    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextWeb = (EditText) findViewById(R.id.editTextWeb);
        imgBtnPhone = (ImageButton) findViewById(R.id.imageButtonPhone);
        imageBtnWeb = (ImageButton) findViewById(R.id.imageButtonWeb);
        imageBtnCamera = (ImageButton) findViewById(R.id.imageButtonCamera);


        imgBtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = editTextPhone.getText().toString();
                if (phoneNumber != null) {
                    //Comprobar versión actual de android
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        NewerVersions();
                    }else{
                        OlderVersions(phoneNumber);
                    }
                }
            }

            private void OlderVersions(String phoneNumber){
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                if (CheckPermission(Manifest.permission.CALL_PHONE)){
                    startActivity(intentCall);
                }else{
                    Toast.makeText(ThirdActivity.this,"You declined the access",Toast.LENGTH_LONG).show();
                }
            }

            private void NewerVersions(){
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL_CODE);
            }


        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Estamos en el caso del teléfono
        switch (requestCode) {
            case  PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.CALL_PHONE)){
                    //Comprobar si ha sido aceptada o denegada la petición de permiso
                    if (result == PackageManager.PERMISSION_GRANTED){
                        //Concedió su permiso
                        String phoneNumber = editTextPhone.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        startActivity(intentCall);
                    }else{
                        //No concedió su permiso
                        Toast.makeText(ThirdActivity.this,"You declined the access",Toast.LENGTH_LONG).show();
                    }
                }


                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }


    }

    /* Compronbar si tenemos permisos en el Manifest -- Debemos de agregar el permiso en el Manifest */
    private boolean CheckPermission(String permission){
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }


}