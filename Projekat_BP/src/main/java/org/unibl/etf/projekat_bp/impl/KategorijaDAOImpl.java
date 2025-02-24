package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.dao.KategorijaDAO;
import org.unibl.etf.projekat_bp.entity.Kategorija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategorijaDAOImpl implements KategorijaDAO {
    private static final String SELECT_ALL = "select * from KATEGORIJA";
    private static final String INSERT = "INSERT INTO KATEGORIJA (IdKategorija,Naziv,Opis,ODJEL_IdOdjela) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE KATEGORIJA SET Naziv=?, Opis=? WHERE IdKategorija=?";
    private static final String DELETE = "DELETE FROM KATEGORIJA WHERE IdKategorija=?";
    private static final String SELECT_BY_NAZIV = "select * from KATEGORIJA where Naziv=?";
    private static final String SELECT_BY_ID = "select * from KATEGORIJA where IdKategorija=?";

    public List<Kategorija> selectAll() {
        List<Kategorija> retVal = new ArrayList<Kategorija>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new Kategorija(rs.getInt("IdKategorija"), rs.getString("Naziv"), rs.getString("Opis"), rs.getInt("ODJEL_IdOdjela")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public int insert(Kategorija kategorija) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            Object values[] = {kategorija.getIdKategorija(), kategorija.getNaziv(), kategorija.getOpis(), kategorija.getODJEL_IdOdjela()};
            stmt = DBUtil.prepareStatement(con, INSERT, true, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public int update(Kategorija kategorija) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBUtil.getConnection();
            Object values[] = {kategorija.getNaziv(), kategorija.getOpis(), kategorija.getIdKategorija()};
            stmt = DBUtil.prepareStatement(con, UPDATE, false, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, con);
        }
        return retVal;
    }

    public int delete(Kategorija kategorija) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBUtil.getConnection();
            Object values[] = {kategorija.getIdKategorija()};
            stmt = DBUtil.prepareStatement(con, DELETE, false, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, con);
        }
        return retVal;
    }

    public Kategorija selectByNaziv(String naziv) {
        Kategorija retVal = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            ps = c.prepareStatement(SELECT_BY_NAZIV);
            ps.setString(1, naziv);
            rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new Kategorija(rs.getInt("IdKategorija"), rs.getString("Naziv"), rs.getString("Opis"), rs.getInt("ODJEL_IdOdjela"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, c);
        }
        return retVal;
    }

    public Kategorija selectById(int id) {
        Kategorija retVal = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            ps = c.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new Kategorija(rs.getInt("IdKategorija"), rs.getString("Naziv"), rs.getString("Opis"), rs.getInt("ODJEL_IdOdjela"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, c);
        }
        return retVal;
    }
}
