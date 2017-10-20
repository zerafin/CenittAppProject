package mx.cenitt.www.cenittapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class TarifaHM extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    Spinner sp_milista;
    ArrayList<String> lista=new ArrayList<String>();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_hm);
        setTitle(getString(R.string.TarifaHm));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp_milista=(Spinner) findViewById(R.id.spinner);
        lista.add("Bim");
        lista.add("Men");
        lista.add("Dia");


        adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);

        sp_milista.setAdapter(adaptador);

        sp_milista.setOnItemSelectedListener(this);

    } // FIN DEL BUNDLE

    public void caso0(){
    }
    public void caso1(){
    }
    public void caso2(){
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:caso0(); //Bimestral
                break;
            case 1:caso1();  //Mensual
                break;
            case 2:caso2();  // Diario
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
