package org.unibl.etf.projekat_bp.entity;

public class Nalog {
    private int IdNaloga;
    private String KorisnickoIme;
    private String Lozinka;
    private int RADNIK_IdRadnika;

    public Nalog(int idNaloga, String korisnickoIme, String lozinka, int radnikId) {
        this.IdNaloga = idNaloga;
        this.KorisnickoIme = korisnickoIme;
        this.Lozinka = lozinka;
        this.RADNIK_IdRadnika = radnikId;
    }

    public int getIdNaloga() {
        return IdNaloga;
    }

    public void setIdNaloga(int idNaloga) {
        IdNaloga = idNaloga;
    }

    public String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        KorisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }

    public int getRADNIK_IdRadnika() {
        return RADNIK_IdRadnika;
    }

    public void setRADNIK_IdRadnika(int RADNIK_IdRadnika) {
        this.RADNIK_IdRadnika = RADNIK_IdRadnika;
    }
}
