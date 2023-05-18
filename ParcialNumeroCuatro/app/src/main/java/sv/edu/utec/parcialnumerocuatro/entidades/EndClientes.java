package sv.edu.utec.parcialnumerocuatro.entidades;

public class EndClientes {
    private  int id_cliente;
    private String nombre_cliente;
    private  String apellido_cliente;
    private  String direccion_cliente;
    private  String ciudad_cliente;

    public int getId_cliente(int anInt) {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente(String string) {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente(String string) {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getDireccion_cliente(String string) {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getCiudad_cliente(String string) {
        return ciudad_cliente;
    }

    public void setCiudad_cliente(String ciudad_cliente) {
        this.ciudad_cliente = ciudad_cliente;
    }
}
