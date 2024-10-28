package org.unibl.etf.projekat_bp.entity;

public class Proizvod {
    private int IdProizvoda;
    private String Naziv;
    private String Opis;
    private int KoličinaNaStanju;
    private String Sastav;
    private int IdKategorija;
    private String BREND_Naziv;

    public Proizvod(int idProizvoda, String nazivProizvoda, String opis, int kolicinaNaStanju, String sastav, int IdKategorija, String nazivBrenda) {
        this.IdProizvoda = idProizvoda;
        this.Naziv = nazivProizvoda;
        this.Opis = opis;
        this.KoličinaNaStanju = kolicinaNaStanju;
        this.Sastav = sastav;
        this.IdKategorija = IdKategorija;
        this.BREND_Naziv = nazivBrenda;
    }

    public int getIdProizvoda() {
        return IdProizvoda;
    }

    public void setIdProizvoda(int idProizvoda) {
        this.IdProizvoda = idProizvoda;
    }

    public String getNazivProizvoda() {
        return Naziv;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.Naziv = nazivProizvoda;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        this.Opis = opis;
    }

    public int getKolicinaNaStanju() {
        return KoličinaNaStanju;
    }

    public void setKolicinaNaStanju(int kolicinaNaStanju) {
        this.KoličinaNaStanju = kolicinaNaStanju;
    }

    public String getSastav() {
        return Sastav;
    }

    public void setSastav(String sastav) {
        this.Sastav = sastav;
    }

    public int getIdKategorija() {
        return IdKategorija;
    }

    public void setIdKategorija(int idKategorija) {
        IdKategorija = idKategorija;
    }

    public String getNazivBrenda() {
        return BREND_Naziv;
    }

    public void setNazivBrenda(String nazivBrenda) {
        this.BREND_Naziv = nazivBrenda;
    }

}
