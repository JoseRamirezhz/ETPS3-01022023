package sv.edu.utec.crudapp.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.crudapp.R;
import sv.edu.utec.crudapp.entidades.EntProveedores;

public class LstProveedoresAdapter extends RecyclerView.Adapter<LstProveedoresAdapter.ProveedoresViewHolder> {

    ArrayList<EntProveedores> listaProvee;

    public LstProveedoresAdapter(ArrayList<EntProveedores> listaProvee) {
        this.listaProvee = listaProvee;
    }

    public LstProveedoresAdapter() {

    }

    @NonNull
    @Override
    public LstProveedoresAdapter.ProveedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_proveedores, null,false);
        return  new ProveedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstProveedoresAdapter.ProveedoresViewHolder holder, int position) {
        holder.viewNomb.setText(listaProvee.get(position).getNom_prov());
        holder.viewTel.setText(listaProvee.get(position).getTel());
        holder.viewCorr.setText(listaProvee.get(position).getCorr());
    }

    @Override
    public int getItemCount() {
        return listaProvee.size();
    }

    public class ProveedoresViewHolder extends RecyclerView.ViewHolder {
        TextView viewNomb, viewTel, viewCorr;
        public ProveedoresViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNomb = itemView.findViewById(R.id.tvNomProve);
            viewCorr = itemView.findViewById(R.id.tvCorrProve);
            viewTel = itemView.findViewById(R.id.tvTelProve);
        }
    }
}
