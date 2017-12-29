package mx.cenitt.www.cenittapp.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.cenitt.www.cenittapp.R;
import mx.cenitt.www.cenittapp.data.response.getEmpleado.GetEmpleadoResponse;
import mx.cenitt.www.cenittapp.super_usuario.RegistroUsuario;
import mx.cenitt.www.cenittapp.super_usuario.SuperPrincipal;
import mx.cenitt.www.cenittapp.tecnico.TecnicoActivity;
import mx.cenitt.www.cenittapp.ventas.VentasActivity;

public class InicioSesion extends AppCompatActivity {

    EditText contrasena, usuario;
    Button accesar;
    GetEmpleadoResponse empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        setTitle(getString(R.string.Iniciar));

        usuario = (EditText) findViewById(R.id.Usuario);
        contrasena = (EditText) findViewById(R.id.Contrasena);
        accesar = (Button) findViewById(R.id.BtnAccesar);
        accesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogIn((usuario.getText().toString()).replaceAll(" ",""),
                               (contrasena.getText().toString()).replaceAll(" ",""))) {

                    logIn(usuario.getText().toString(),contrasena.getText().toString());
                }
            }
        });
    }

    private boolean validateLogIn(String user, String password) {
        ///validaciones do los campos
        boolean flag =true;
        if (user.isEmpty()){
            onUserIsEmpty();
            flag=false; }
        if (password.isEmpty()){
            onPasswordIsEmpty();
            flag =false;}

        return flag;
    }

    private void onUserIsEmpty(){
        usuario.setError("Por favor introduce el usuario");
    }
    private void onPasswordIsEmpty(){
        contrasena.setError("Por favor introduce la Contraseña");
    }

    private void logIn(String user, String password){

        //peticion del servicio

        ExampleServiceLogIn service =new ExampleServiceLogIn();
       empleado = service.exampleLogIn(user,password);
        if (empleado!=null){
            filterUserAccess();
        }
    }

    private void filterUserAccess()
    {
        switch (empleado.getCargo().getId())
        {
            case 0:{startActivity(new Intent(this, SuperPrincipal.class));}break;
            case 1:{startActivity(new Intent(this, VentasActivity.class));}break;
            case 2:{startActivity(new Intent(this, TecnicoActivity.class));}break;
        }
    }
}
