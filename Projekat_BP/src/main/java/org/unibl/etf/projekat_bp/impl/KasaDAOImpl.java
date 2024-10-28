package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.KasaDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.Kasa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KasaDAOImpl implements KasaDAO {
    public static final String SELECT_ALL = "SELECT * FROM kasa";

    @Override
    public List<Kasa> selectAll() {
        List<Kasa> retVal = new ArrayList<Kasa>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Kasa(rs.getInt("IdKasa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }
}
