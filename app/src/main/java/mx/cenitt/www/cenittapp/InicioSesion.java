package mx.cenitt.www.cenittapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    EditText contrasena, usuario;
    Button accesar, registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        setTitle(getString(R.string.Iniciar));

        usuario =(EditText) findViewById(R.id.Usuario);
        contrasena = (EditText) findViewById(R.id.NombreCompleto);
        accesar=(Button) findViewById(R.id.BtnAccesar);
        accesar.setOnClickListener(this);
        registrar=(Button) findViewById(R.id.Registrar);
        registrar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnAccesar:
                Intent itento = new Intent(InicioSesion.this, InicioSesion.class);
                startActivity(itento);
                break;
            case R.id.Registrar:
                Intent itento2 = new Intent(InicioSesion.this, RegistroUsuario.class);
                startActivity(itento2);
                break;
        }//fin del switch
    }
}
