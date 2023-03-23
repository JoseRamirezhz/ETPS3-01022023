package sv.edu.utec.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    int layout;
    List<String> pelicula;
    List<String> descripcion;
    int[]imagen;

    public Adaptador(Context contexto, int  layout, List<String> pelicula, List<String> descripcion, int[] imagen) {
        this.contexto = contexto;
        this.layout = layout;
        this.pelicula = pelicula;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    @Override
    public int getCount() {
        return pelicula.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);
        v=layoutInflater.inflate(R.layout.elemento, null);

        TextView txtPeli = v.findViewById(R.id.textView);
        txtPeli.setText(pelicula.get(i));

        TextView txtDesc = v.findViewById(R.id.textView2);
        txtDesc.setText(descripcion.get(i));

        ImageView img = v.findViewById(R.id.imageView2);
        img.setImageResource(imagen[i]);

        return v;
    }
}
