package mx.cenitt.www.cenittapp.ventas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.cenitt.www.cenittapp.R;
import mx.cenitt.www.cenittapp.data.response.getPresupuesto.GetPresupuestoResponse;

/**
 * Created by Luis Roberto Zerafin on 01/12/2017.
 */
public class PresupuestosAdapter extends RecyclerView.Adapter<PresupuestosAdapter.ViewHolder> {

    private List<GetPresupuestoResponse> list;
    private onPresupuestoListener listener;
    private Context context;

    public PresupuestosAdapter(List<GetPresupuestoResponse> list, onPresupuestoListener listener, Context context) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_presupuesto,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GetPresupuestoResponse item = list.get(position);
        holder.fecha.setText(item.getmFecha());
        holder.nombreCliente.setText(item.getCliente().getNombre());
        holder.empresa.setText(item.getCliente().getmEmpresa());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onPresupuestoClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView empresa,nombreCliente,fecha;

        public ViewHolder(View itemView) {
            super(itemView);

            empresa=(TextView)itemView.findViewById(R.id.empresTV);
            nombreCliente=(TextView) itemView.findViewById(R.id.nombreClienteTV);
            fecha=(TextView) itemView.findViewById(R.id.fechaTV);
        }
    }

    public interface onPresupuestoListener{

        void onPresupuestoClicked(GetPresupuestoResponse getPresupuestoResponse);

    }
}
