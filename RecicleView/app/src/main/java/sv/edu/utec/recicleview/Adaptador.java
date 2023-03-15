package sv.edu.utec.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Elementos> {

    Context context;
    ArrayList<Modelo> modelos;

    //Alt+insert = generate para generar el contrusctor
    public Adaptador(Context context, ArrayList<Modelo> modelos) {
        this.context = context;
        this.modelos = modelos;
    }

    @NonNull
    @Override
    public Elementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.peliculas_listado,null);
        return new Elementos(view); // llama los elementos y le agremaois la vista de los elementos que mostrara
    }

    @Override
    public void onBindViewHolder(@NonNull Elementos holder, int position) {
        Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos
        Elementos.tvGenPeli.setText(modelos.get(position).getGenPeli()); //empieza a crear los elementos
        Elementos.imvimgPeli.setImageResource(modelos.get(position).getImgPeli()); //empieza a crear los elementos

       /* Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos
        Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos
        Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos
        Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos
        Elementos.tvnomPeli.setText(modelos.get(position).getNomPeli()); //empieza a crear los elementos*/
    }

    @Override
    public int getItemCount() {
        return modelos.size();
    }
}
