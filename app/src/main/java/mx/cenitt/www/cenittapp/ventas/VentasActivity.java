package mx.cenitt.www.cenittapp.ventas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import mx.cenitt.www.cenittapp.R;
import mx.cenitt.www.cenittapp.data.response.getPresupuesto.GetPresupuestoResponse;
import mx.cenitt.www.cenittapp.presupuesto.PresupuestoActivity;

public class VentasActivity extends AppCompatActivity implements PresupuestosAdapter.onPresupuestoListener {

    RecyclerView rvPresupuestos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        rvPresupuestos=(RecyclerView) findViewById(R.id.rvPresupuestos);
    }

    @Override
    public void onPresupuestoClicked(GetPresupuestoResponse getPresupuestoResponse) {
        startActivity(new Intent(this, PresupuestoActivity.class));
    }
}
