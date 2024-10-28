package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.StavkaRacunDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.StavkaRacun;

import java.sql.*;

public class StavkaRacunDAOImpl implements StavkaRacunDAO {
    private static final String SQL_DODAJ_STAVKU_RACUNA = "CALL dodaj_stavku_racuna(?, ?, ?, ?)";
    public static final String INSERT = "INSERT INTO STAVKA_RACUN(PRODAJNI_ARTIKL_PROIZVOD_IdProizvod,RACUN_IdRACUN,Količina,CijenaProdajna) VALUES(?,?,?,?)";

    public int insert(StavkaRacun stavkaRacun) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            Object values[] = {stavkaRacun.getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod(), stavkaRacun.getRACUN_IdRačun(), stavkaRacun.getKoličina(), stavkaRacun.getCijenaProdajna()};
            stmt = DBUtil.prepareStatement(con, INSERT, true, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public void dodajStavkuRacuna(int idRacuna, int idProdajnogArtikla, int kolicina, double cijenaProdajna) {
        Connection con = null;
        CallableStatement stmt = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.prepareCall(SQL_DODAJ_STAVKU_RACUNA);
            stmt.setInt(1, idRacuna);
            stmt.setInt(2, idProdajnogArtikla);
            stmt.setInt(3, kolicina);
            stmt.setDouble(4, cijenaProdajna);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, con);
        }
    }
}
