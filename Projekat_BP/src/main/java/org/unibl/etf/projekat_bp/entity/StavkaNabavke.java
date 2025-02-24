package org.unibl.etf.projekat_bp.entity;

public class StavkaNabavke {
    private int NABAVLJANJE_IdNabavke;
    private double CijenaNabavna;
    private int Kolicina;

    public StavkaNabavke(int NABAVLJANJE_IdNabavke, double cijenaNabavna, int kolicina) {
        this.NABAVLJANJE_IdNabavke = NABAVLJANJE_IdNabavke;
        CijenaNabavna = cijenaNabavna;
        Kolicina = kolicina;
    }

    public int getNABAVLJANJE_IdNabavke() {
        return NABAVLJANJE_IdNabavke;
    }

    public void setNABAVLJANJE_IdNabavke(int NABAVLJANJE_IdNabavke) {
        this.NABAVLJANJE_IdNabavke = NABAVLJANJE_IdNabavke;
    }

    public double getCijenaNabavna() {
        return CijenaNabavna;
    }

    public void setCijenaNabavna(double cijenaNabavna) {
        CijenaNabavna = cijenaNabavna;
    }

    public int getKolicina() {
        return Kolicina;
    }

    public void setKolicina(int kolicina) {
        Kolicina = kolicina;
    }
}
