package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.Kategorija;
import org.unibl.etf.projekat_bp.entity.Odjel;

import java.util.List;

public interface KategorijaDAO {
    public List<Kategorija> selectAll();

    public int insert(Kategorija k);

    public int update(Kategorija k);

    public int delete(Kategorija k);
    public Kategorija selectByNaziv(String naziv);
    public Kategorija selectById(int id);
}
