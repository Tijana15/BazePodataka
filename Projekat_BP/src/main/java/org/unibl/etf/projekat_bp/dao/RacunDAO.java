package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.Racun;
import org.unibl.etf.projekat_bp.entity.StavkaRacun;
import java.util.List;

public interface RacunDAO {
    public int kreirajRacun(Racun r);

    public void dodajStavkuRacuna(int idRacuna, int idProdajnogArtikla, int kolicina, double cijenaProdajna);

    public void dodajStavkeRacuna(int id, List<StavkaRacun> stavke);

}
