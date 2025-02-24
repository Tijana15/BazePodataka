package org.unibl.etf.projekat_bp.entity;

public class Kategorija {
    private Integer IdKategorija;
    private String Naziv;
    private String Opis;
    private Integer ODJEL_IdOdjela;

    public Kategorija(Integer idKategorija, String naziv, String opis, int ODJEL_IdOdjela) {
        this.IdKategorija = idKategorija;
        this.Naziv = naziv;
        this.Opis = opis;
        this.ODJEL_IdOdjela = ODJEL_IdOdjela;
    }

    public int getIdKategorija() {
        return IdKategorija;
    }

    public void setIdKategorija(int idKategorija) {
        IdKategorija = idKategorija;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        this.Naziv = naziv;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        this.Opis = opis;
    }

    public int getODJEL_IdOdjela() {
        return ODJEL_IdOdjela;
    }

    public void setIdOdjela(int idOdjela) {
        this.ODJEL_IdOdjela = idOdjela;
    }
}
