package org.unibl.etf.projekat_bp.dao;

import org.unibl.etf.projekat_bp.entity.Odjel;

import java.util.List;

public interface OdjelDAO
{
    public List<Odjel> selectAll();
    public List<Odjel> selectAll_Naziv();
}
