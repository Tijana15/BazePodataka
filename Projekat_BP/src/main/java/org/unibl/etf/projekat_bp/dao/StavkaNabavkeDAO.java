package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.Proizvod;
import org.unibl.etf.projekat_bp.entity.StavkaNabavke;

import java.util.List;

public interface StavkaNabavkeDAO {
    public List<StavkaNabavke> selectAll();
}
