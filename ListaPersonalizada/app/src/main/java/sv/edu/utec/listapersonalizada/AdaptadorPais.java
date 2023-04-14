package sv.edu.utec.listapersonalizada;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AdaptadorPais extends ArrayAdapter<String> {
    Activity contexto;
    String [] paises;
    Integer [] Imgpais;
    ImageView imgBande;
    TextView tvNombre;

    public  AdaptadorPais(Activity contexto, String[] paises, Integer[] ImgPais){
        super(contexto, R.layout.paises,paises);
        this.contexto = contexto;
        this.paises = paises;
        this.Imgpais = ImgPais;
    }

    public View getView(int posicion, View v, ViewGroup parent){
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.paises, null,true);
        tvNombre = rowView.findViewById(R.id.tvNombrePais);
        imgBande = rowView.findViewById(R.id.imgBandera);
        tvNombre.setText(paises[posicion]);
        imgBande.setImageResource(Imgpais[posicion]);
        return  rowView;
    }
}
