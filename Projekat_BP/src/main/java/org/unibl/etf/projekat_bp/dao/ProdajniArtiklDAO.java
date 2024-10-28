package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.ProdajniArtikl;

import java.util.List;

public interface ProdajniArtiklDAO {
    public List<ProdajniArtikl> selectAll();

    public int insert(ProdajniArtikl proizvod);

    public int update(ProdajniArtikl proizvod);

    public int delete(ProdajniArtikl proizvod);
    public ProdajniArtikl selectById(int id);
    public ProdajniArtikl selectByNaziv(String name);

}
