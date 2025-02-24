package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.RacunStavkeView;

import java.util.List;

public interface RacunStavkeViewDAO {
    public List<RacunStavkeView> selectAll();
    public List<RacunStavkeView> selectByRacunId(int racunId);
    public List<RacunStavkeView> selectByDatum(String datum);
}
