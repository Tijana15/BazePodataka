package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.dao.ProizvodDAO;
import org.unibl.etf.projekat_bp.entity.Proizvod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProizvodDAOImpl implements ProizvodDAO {
    private static final String SELECT_ALL = "select * from PROIZVOD";
    private static final String INSERT = "INSERT INTO PROIZVOD (IdProizvod,Naziv,Opis,KoličinaNaStanju,Sastav,KATEGORIJA_IdKategorija,BREND_Naziv) VALUES (?,?,?,?,?,?,?)";

    public List<Proizvod> selectAll() {
        List<Proizvod> retVal = new ArrayList<Proizvod>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Proizvod(rs.getInt("IdProizvod"), rs.getString("Naziv"), rs.getString("Opis"), rs.getInt("KoličinaNaStanju"), rs.getString("Sastav"), rs.getInt("KATEGORIJA_IdKategorija"), rs.getString("BREND_Naziv")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public int insert(Proizvod proizvod) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            Object values[] = {proizvod.getIdProizvoda(), proizvod.getNazivProizvoda(), proizvod.getOpis(), proizvod.getKolicinaNaStanju(), proizvod.getSastav(), proizvod.getIdKategorija(), proizvod.getNazivBrenda()};
            stmt = DBUtil.prepareStatement(con, INSERT, true, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

}
