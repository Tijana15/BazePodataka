package org.unibl.etf.projekat_bp.entity;

public class Racun {

    private int IdRačun;
    private String DatumVrijemeIzdavanja;
    private String NacinPlacanja;
    private double Iznos;
    private int KASA_IdKasa;
    private int NALOG_IdNaloga;

    public Racun(int idRačun, String datumVrijemeIzdavanja, String nacinPlacanja, double iznos, int KASA_IdKasa, int NALOG_IdNaloga) {
        IdRačun = idRačun;
        DatumVrijemeIzdavanja = datumVrijemeIzdavanja;
        NacinPlacanja = nacinPlacanja;
        Iznos = iznos;
        this.KASA_IdKasa = KASA_IdKasa;
        this.NALOG_IdNaloga = NALOG_IdNaloga;
    }

    public Racun(String DatumVrijemeIzdavanja, String nacinPlacanja, int KASA_IdKasa, int NALOG_IdNaloga) {
        this.DatumVrijemeIzdavanja=DatumVrijemeIzdavanja;
        NacinPlacanja = nacinPlacanja;
        this.KASA_IdKasa = KASA_IdKasa;
        this.NALOG_IdNaloga = NALOG_IdNaloga;
    }

    public int getIdRačun() {
        return IdRačun;
    }

    public void setIdRačun(int idRačun) {
        IdRačun = idRačun;
    }

    public String getDatumVrijemeIzdavanja() {
        return DatumVrijemeIzdavanja;
    }

    public void setDatumVrijemeIzdavanja(String datumVrijemeIzdavanja) {
        DatumVrijemeIzdavanja = datumVrijemeIzdavanja;
    }

    public String getNacinPlacanja() {
        return NacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        NacinPlacanja = nacinPlacanja;
    }

    public double getIznos() {
        return Iznos;
    }

    public void setIznos(double iznos) {
        Iznos = iznos;
    }

    public int getKASA_IdKasa() {
        return KASA_IdKasa;
    }

    public void setKASA_IdKasa(int KASA_IdKasa) {
        this.KASA_IdKasa = KASA_IdKasa;
    }

    public int getNALOG_IdNaloga() {
        return NALOG_IdNaloga;
    }

    public void setNALOG_IdNaloga(int NALOG_IdNaloga) {
        this.NALOG_IdNaloga = NALOG_IdNaloga;
    }
}
