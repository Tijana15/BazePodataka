package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.StavkaNabavkeDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.StavkaNabavke;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StavkaNabavkeImpl implements StavkaNabavkeDAO {
    private static String SELECT_ALL = "SELECT * FROM STAVKA_NABAVKE";

    public List<StavkaNabavke> selectAll() {
        List<StavkaNabavke> retVal = new ArrayList<StavkaNabavke>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new StavkaNabavke(rs.getInt("NABAVLJANJE_IdNabavke"), rs.getDouble("CijenaNabavna"), rs.getInt("Kolicina")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

}
