package sv.edu.utec.recicleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder {
    // heredamos con eextends RecyclerView.ViewHolder
    //estos elementos se extenderan de la clase older que tiene ek recilce view y creamos el constructor

    static ImageView imvimgPeli;
    static TextView tvnomPeli,tvGenPeli;

    //Constructor
    public Elementos(@NonNull View itemView) {
        super(itemView);
        imvimgPeli = itemView.findViewById(R.id.imvPelicula);
        tvnomPeli = itemView.findViewById(R.id.tvTitulo);
        tvGenPeli = itemView.findViewById(R.id.tvGenero);
    }
}
