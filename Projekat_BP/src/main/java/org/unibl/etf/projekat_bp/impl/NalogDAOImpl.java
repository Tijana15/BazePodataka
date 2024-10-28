package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.NalogDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.Nalog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NalogDAOImpl implements NalogDAO {
    private static final String SELECT_ALL = "SELECT * from NALOG";

    @Override
    public List<Nalog> selectAll() {
        List<Nalog> retVal = new ArrayList<Nalog>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Nalog(rs.getInt("IdNaloga"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"), rs.getInt("RADNIK_IdRadnika")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }
}
