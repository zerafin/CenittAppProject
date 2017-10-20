package mx.cenitt.www.cenittapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistroUsuario extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    RadioButton rbRadioVenta, rbRadioTecnico;
    RadioGroup rg;
    EditText usuario,nombrecompleto,contrasena,repetircontrasena;
    String valorRadioButton;
    Button BtnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        setTitle(getString(R.string.Registro));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        BtnAceptar= (Button)findViewById(R.id.button);
        usuario =(EditText) findViewById(R.id.Usuario);
        nombrecompleto = (EditText) findViewById(R.id.NombreCompleto);
        contrasena = (EditText) findViewById(R.id.Contrasena);
        repetircontrasena = (EditText) findViewById(R.id.RepetirContrasena);
        rbRadioVenta = (RadioButton) findViewById(R.id.radioVenta);
        rbRadioTecnico = (RadioButton) findViewById(R.id.radioTecnico);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioVenta: valorRadioButton =("" + String.valueOf(rbRadioVenta));break;
            case R.id.radioTecnico: valorRadioButton =("" + String.valueOf(rbRadioTecnico));break;
        }// fin del switch
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                Intent itento = new Intent(RegistroUsuario.this, InicioSesion.class);
                startActivity(itento);
                break;
        }//fin del switch
    }
}
