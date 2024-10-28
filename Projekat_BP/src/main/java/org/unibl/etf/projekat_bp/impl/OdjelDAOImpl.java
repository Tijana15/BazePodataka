package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.dao.OdjelDAO;
import org.unibl.etf.projekat_bp.entity.Odjel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdjelDAOImpl implements OdjelDAO {
    private static final String SELECT_ALL = "select * from ODJEL";

    public List<Odjel> selectAll() {
        List<Odjel> retVal = new ArrayList<Odjel>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Odjel(rs.getInt("IdOdjela"), rs.getString("Naziv")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    @Override
    public List<Odjel> selectAll_Naziv() {
        List<Odjel> retVal = new ArrayList<Odjel>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Odjel(rs.getInt("IdOdjela"), rs.getString("Naziv")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }
}
