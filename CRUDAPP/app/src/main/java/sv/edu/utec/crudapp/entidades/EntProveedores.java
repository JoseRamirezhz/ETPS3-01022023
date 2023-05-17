package sv.edu.utec.crudapp.entidades;

public class EntProveedores {
    private int cod_prov;
    private String nom_prov;
    private  String tel;
    private  String corr;

    public int getCod_prov(int anInt)
    {
        return cod_prov;
    }

    public void setCod_prov(int cod_prov)
    {
        this.cod_prov = cod_prov;
    }

    public String getNom_prov(String string)
    {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov)
    {
        this.nom_prov = nom_prov;
    }

    public String getTel(String string)
    {
        return tel;
    }

    public void setTel(String TELPROV)
    {
        this.tel = tel;
    }

    public String getCorr(String string)
    {
        return corr;
    }

    public void setCorr(String CORPROV)
    {
        this.corr = corr;
    }


}
