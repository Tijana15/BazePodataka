package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.RacunStavkeViewDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.RacunStavkeView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RacunStavkeViewDAOImpl implements RacunStavkeViewDAO {
    private static final String SELECT_ALL = "SELECT * FROM RacunStavkeView";
    private static final String SELECT_BY_IDRACUNA = "SELECT * FROM RacunStavkeView WHERE IdRačun=?";
    private static final String SELECT_BY_DATUM = "SELECT * FROM RacunStavkeView WHERE Date(DatumVrijemeIzdavanja)=?";

    public List<RacunStavkeView> selectAll() {
        List<RacunStavkeView> retVal = new ArrayList<RacunStavkeView>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new RacunStavkeView(rs.getInt("IdRačun"), rs.getString("DatumVrijemeIzdavanja"),
                        rs.getString("NacinPlacanja"), rs.getDouble("Iznos"), rs.getInt("KASA_IdKasa"),
                        rs.getInt("NALOG_IdNaloga"), rs.getInt("PRODAJNI_ARTIKL_PROIZVOD_IdProizvod"),
                        rs.getString("NazivProizvoda"), rs.getInt("Količina"), rs.getDouble("CijenaProdajna")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public List<RacunStavkeView> selectByRacunId(int racunId) {
        List<RacunStavkeView> retVal = new ArrayList<RacunStavkeView>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.prepareStatement(SELECT_BY_IDRACUNA);
            stmt.setInt(1, racunId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retVal.add(new RacunStavkeView(rs.getInt("IdRačun"), rs.getString("DatumVrijemeIzdavanja"),
                        rs.getString("NacinPlacanja"), rs.getDouble("Iznos"), rs.getInt("KASA_IdKasa"),
                        rs.getInt("NALOG_IdNaloga"), rs.getInt("PRODAJNI_ARTIKL_PROIZVOD_IdProizvod"),
                        rs.getString("NazivProizvoda"), rs.getInt("Količina"), rs.getDouble("CijenaProdajna")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public List<RacunStavkeView> selectByDatum(String datum) {
        List<RacunStavkeView> retVal = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.prepareStatement(SELECT_BY_DATUM);
            stmt.setString(1, datum);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retVal.add(new RacunStavkeView(rs.getInt("IdRačun"), rs.getString("DatumVrijemeIzdavanja"),
                        rs.getString("NacinPlacanja"), rs.getDouble("Iznos"), rs.getInt("KASA_IdKasa"),
                        rs.getInt("NALOG_IdNaloga"), rs.getInt("PRODAJNI_ARTIKL_PROIZVOD_IdProizvod"),
                        rs.getString("NazivProizvoda"), rs.getInt("Količina"), rs.getDouble("CijenaProdajna")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

}
