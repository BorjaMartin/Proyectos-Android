package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
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

    //Codigo 100 se corresponde
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
                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    //Comprobar versión actual de android
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                        //Comprobar si el usuario ha aceptado, no ha aceptado o no se le ha preguntado por los permisos
                        if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                            //Ha aceptado
                            Intent intentAccept = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                            if (ActivityCompat.checkSelfPermission(ThirdActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                                return;

                            startActivity(intentAccept);
                        } else {
                            //No ha aceptado, o es la primera vez (Se le pregunta)
                            if (!shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                                //Si no se le ha preguntado aun.
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                            } else {
                                //Ha denegado los permisos
                                //Ha denegado previamente. Puede activar el permiso desde Settings->Apps->Permissions
                                Toast.makeText(ThirdActivity.this, "Please, enable the request permission", Toast.LENGTH_LONG).show();

                                //Pero también podemos llevarle al sitio donde debe activarlo, lo hacemos con un implicit intent.
                                Intent intentSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                //de la categoría default
                                intentSettings.addCategory(Intent.CATEGORY_DEFAULT);
                                //y como datos un uri que apunta a nuestra aplicación. La obtenemos así:
                                intentSettings.setData(Uri.parse("package:" + getPackageName()));
                                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intentSettings.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                startActivity(intentSettings);
                            }
                        }
                    } else {
                        OlderVersions(phoneNumber);
                    }
                } else {
                    Toast.makeText(ThirdActivity.this, "Phone number is Empty", Toast.LENGTH_LONG).show();
                }
            }

            private void OlderVersions(String phoneNumber) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentCall);
                } else {
                    Toast.makeText(ThirdActivity.this, "You declined the access", Toast.LENGTH_LONG).show();
                }
            }

            private void NewerVersions() {
                //Estamos en una versión nueva, tenemos que utilizar requestPermissions() que es un método asincrono que pregunta al
                //usuario si da su permiso.
                //Tras su respuesta se lanzará un callback llamado onRequestPermisionsResults, que tendremos que sobrecargar en nuestra activity.
                //Pasamos un array con los permisos que solicitamos y un código de solicitud que definimos nosotros
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
            }


        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Este método callback se pone en ejecución tras cualquier llamada previa a requestPermissions()
        //Recibimos: el código de petición que pasamos al llamar
        //           un array de permisos solicitados
        //           un array de resultados (granted or denied) correspondiente al array de permisos solicitados
        //Estamos en el caso de permisos del teléfono
        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];
                //Comprobamos el permiso del CALL_PHONE.
                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //Comprobar si ha sido aceptada o denegada la petición de permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        //Permiso concedido
                        //Obtenemos el número, montamos el intent y lo lanzamos.
                        String phoneNumber = editTextPhone.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        //AndroidStudio avisa que hay que poner esta comprobación, que es para determinar si tenemos el permiso asignado.
                        if (ActivityCompat.checkSelfPermission(ThirdActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            return;

                        startActivity(intentCall);
                    } else {
                        //No concedió su permiso
                        Toast.makeText(ThirdActivity.this, "You declined the access", Toast.LENGTH_LONG).show();
                        shouldShowRequestPermissionRationale(permission);

                    }
                }


                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }


    }

    /* Compronbar si tenemos permisos en el Manifest -- Debemos de agregar el permiso en el Manifest
     * Comprueba que el usuario haya aceptado el permiso
     * */
    private boolean CheckPermission(String permission) {
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }


}