package org.unibl.etf.projekat_bp.entity;

public class ProdajniArtikl {
    private Integer PROIZVOD_IdProizvod;
    private Integer STAVKA_NABAVKE_NABAVLJANJE_IdNabavke;
    private Double Cijena;
    private String Naziv;
    private String Opis;

    public ProdajniArtikl(Integer PROIZVOD_IdProizvod, Integer STAVKA_NABAVKE_NABAVLJANJE_IdNabavke, double cijena) {
        this.PROIZVOD_IdProizvod = PROIZVOD_IdProizvod;
        this.STAVKA_NABAVKE_NABAVLJANJE_IdNabavke = STAVKA_NABAVKE_NABAVLJANJE_IdNabavke;
        this.Cijena = cijena;
    }

    public ProdajniArtikl(Integer PROIZVOD_IdProizvod, Integer STAVKA_NABAVKE_NABAVLJANJE_IdNabavke, Double cijena, String naziv, String opis) {
        this.PROIZVOD_IdProizvod = PROIZVOD_IdProizvod;
        this.STAVKA_NABAVKE_NABAVLJANJE_IdNabavke = STAVKA_NABAVKE_NABAVLJANJE_IdNabavke;
        Cijena = cijena;
        Naziv = naziv;
        Opis = opis;
    }

    public Integer getPROIZVOD_IdProizvod() {
        return PROIZVOD_IdProizvod;
    }

    public void setPROIZVOD_IdProizvod(Integer PROIZVOD_IdProizvod) {
        this.PROIZVOD_IdProizvod = PROIZVOD_IdProizvod;
    }

    public Integer getSTAVKA_NABAVKE_NABAVLJANJE_IdNabavke() {
        return STAVKA_NABAVKE_NABAVLJANJE_IdNabavke;
    }

    public void setSTAVKA_NABAVKE_NABAVLJANJE_IdNabavke(Integer STAVKA_NABAVKE_NABAVLJANJE_IdNabavke) {
        this.STAVKA_NABAVKE_NABAVLJANJE_IdNabavke = STAVKA_NABAVKE_NABAVLJANJE_IdNabavke;
    }

    public double getCijena() {
        return Cijena;
    }

    public void setCijena(Double cijena) {
        Cijena = cijena;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }
}
