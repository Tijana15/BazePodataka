package org.unibl.etf.projekat_bp.entity;

public class Odjel {
    private Integer IdOdjela;
    private String Naziv;

    public Odjel(int idOdjela,String naziv) {
        this.IdOdjela = idOdjela;
        this.Naziv = naziv;
    }

    public int getIdOdjela() {
        return IdOdjela;
    }

    public void setIdOdjela(int idOdjela) {
        IdOdjela = idOdjela;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        this.Naziv = naziv;
    }
}
