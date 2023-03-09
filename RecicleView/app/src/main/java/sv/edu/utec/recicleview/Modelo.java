package sv.edu.utec.recicleview;

public class Modelo {
    // definir todo lo que tenemos en la vista para luego encapsular datos
    private String nomPeli;
    private String genPeli;
    private String direcPeli;
    private String aniopeli;
    private String imgPeli;
    private String durapeli;
    private String fechPeli;
    private double clasificar;

    public String getNomPeli() {
        return nomPeli;
    }

    public void setNomPeli(String nomPeli) {
        this.nomPeli = nomPeli;
    }

    public String getGenPeli() {
        return genPeli;
    }

    public void setGenPeli(String genPeli) {
        this.genPeli = genPeli;
    }

    public String getDirecPeli() {
        return direcPeli;
    }

    public void setDirecPeli(String direcPeli) {
        this.direcPeli = direcPeli;
    }

    public String getAniopeli() {
        return aniopeli;
    }

    public void setAniopeli(String aniopeli) {
        this.aniopeli = aniopeli;
    }

    public String getImgPeli() {
        return imgPeli;
    }

    public void setImgPeli(String imgPeli) {
        this.imgPeli = imgPeli;
    }

    public String getDurapeli() {
        return durapeli;
    }

    public void setDurapeli(String durapeli) {
        this.durapeli = durapeli;
    }

    public String getFechPeli() {
        return fechPeli;
    }

    public void setFechPeli(String fechPeli) {
        this.fechPeli = fechPeli;
    }

    public double getClasificar() {
        return clasificar;
    }

    public void setClasificar(double clasificar) {
        this.clasificar = clasificar;
    }
}
