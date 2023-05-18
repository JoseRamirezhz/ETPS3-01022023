package sv.edu.utec.parcialnumerocuatro.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import sv.edu.utec.parcialnumerocuatro.R;
import sv.edu.utec.parcialnumerocuatro.entidades.EndClientes;

public class LstClientesAdapter extends RecyclerView.Adapter<LstClientesAdapter.ClientesViewHolder> {

    ArrayList<EndClientes> listaClientes;

    public LstClientesAdapter(ArrayList<EndClientes> listaCliente) {
        this.listaClientes = listaCliente;
    }

    public LstClientesAdapter() {

    }

    @NonNull
    @Override
    public LstClientesAdapter.ClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_clientes, null,false);
        return  new ClientesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstClientesAdapter.ClientesViewHolder holder, int position) {
        /*holder.viewNom.setText(listaClientes.get(position).getNombre_cliente());
        holder.viewApell.setText(listaClientes.get(position).getApellido_cliente());
        holder.viewDir.setText(listaClientes.get(position).getDireccion_cliente());
        holder.viewCiud.setText(listaClientes.get(position).getCiudad_cliente());*/
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ClientesViewHolder extends RecyclerView.ViewHolder {
        TextView viewNom, viewApell, viewDir, viewCiud;
        public ClientesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNom = itemView.findViewById(R.id.tvNomCliente);
            viewApell = itemView.findViewById(R.id.tvApellCliente);
            viewDir = itemView.findViewById(R.id.tvDirCLiente);
            viewCiud = itemView.findViewById(R.id.tvCiuCliente);
        }
    }
}
