package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.Proizvod;

import java.util.List;

public interface ProizvodDAO {
    public List<Proizvod> selectAll();

    public int insert(Proizvod proizvod);

}
