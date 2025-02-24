package org.unibl.etf.projekat_bp.entity;

public class RacunStavkeView {
    private int IdRačun;
    private String DatumVrijemeIzdavanja;
    private String NacinPlacanja;
    private Double Iznos;
    private int KASA_IdKasa;
    private int NALOG_IdNaloga;
    private int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    private String NazivProizvoda;
    private int Količina;
    private Double CijenaProdajna;

    public RacunStavkeView(int idRačun, String datumVrijemeIzdavanja, String nacinPlacanja, Double iznos, int KASA_IdKasa, int NALOG_IdNaloga, int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod, String nazivProizvoda, int količina, Double cijenaProdajna) {
        IdRačun = idRačun;
        DatumVrijemeIzdavanja = datumVrijemeIzdavanja;
        NacinPlacanja = nacinPlacanja;
        Iznos = iznos;
        this.KASA_IdKasa = KASA_IdKasa;
        this.NALOG_IdNaloga = NALOG_IdNaloga;
        this.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
        NazivProizvoda = nazivProizvoda;
        Količina = količina;
        CijenaProdajna = cijenaProdajna;
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

    public Double getIznos() {
        return Iznos;
    }

    public void setIznos(Double iznos) {
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

    public int getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod() {
        return PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    }

    public void setPRODAJNI_ARTIKL_PROIZVOD_IdProizvod(int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod) {
        this.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    }

    public String getNazivProizvoda() {
        return NazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        NazivProizvoda = nazivProizvoda;
    }

    public int getKoličina() {
        return Količina;
    }

    public void setKoličina(int količina) {
        Količina = količina;
    }

    public Double getCijenaProdajna() {
        return CijenaProdajna;
    }

    public void setCijenaProdajna(Double cijenaProdajna) {
        CijenaProdajna = cijenaProdajna;
    }
}
