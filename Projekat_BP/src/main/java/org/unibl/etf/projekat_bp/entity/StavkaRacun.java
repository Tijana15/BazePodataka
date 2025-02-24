package org.unibl.etf.projekat_bp.entity;

public class StavkaRacun {
    private int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    private int RACUN_IdRačun;
    private int Količina;
    private Double CijenaProdajna;

    public StavkaRacun(int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod, int RACUN_IdRačun, int količina, Double cijenaProdajna) {
        this.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
        this.RACUN_IdRačun = RACUN_IdRačun;
        Količina = količina;
        CijenaProdajna = cijenaProdajna;
    }

    public int getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod() {
        return PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    }

    public void setPRODAJNI_ARTIKL_PROIZVOD_IdProizvod(int PRODAJNI_ARTIKL_PROIZVOD_IdProizvod) {
        this.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = PRODAJNI_ARTIKL_PROIZVOD_IdProizvod;
    }

    public int getRACUN_IdRačun() {
        return RACUN_IdRačun;
    }

    public void setRACUN_IdRačun(int RACUN_IdRačun) {
        this.RACUN_IdRačun = RACUN_IdRačun;
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
