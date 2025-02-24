package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.ProdajniArtiklDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.ProdajniArtikl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdajniArtiklDAOImpl implements ProdajniArtiklDAO {
    private static final String SELECT_ALL = "SELECT pa.*, p.Naziv AS Naziv, p.Opis AS Opis FROM PRODAJNI_ARTIKL pa INNER JOIN PROIZVOD p ON pa.PROIZVOD_IdProizvod = p.IdProizvod";
    private static final String INSERT = "INSERT INTO PRODAJNI_ARTIKL (PROIZVOD_IdProizvod,STAVKA_NABAVKE_NABAVLJANJE_IdNabavke,Cijena) VALUES (?,?,?)";
    private static final String UPDATE_CIJENA = "UPDATE PRODAJNI_ARTIKL SET Cijena = ? WHERE PROIZVOD_IdProizvod = ?";
    private static final String DELETE = "DELETE FROM PRODAJNI_ARTIKL WHERE PROIZVOD_IdProizvod=?";
    private static final String SELECT_BY_ID = "SELECT pa.*, p.Naziv as Naziv,p.Opis as Opis from PRODAJNI_ARTIKL pa INNER JOIN PROIZVOD p ON pa.PROIZVOD_IdProizvod=p.IdProizvod WHERE PROIZVOD_IdProizvod=?";
    private static final String SELECT_BY_NAZIV = "SELECT pa.*, p.Naziv as Naziv, p.Opis as Opis FROM PRODAJNI_ARTIKL pa INNER JOIN PROIZVOD p ON pa.PROIZVOD_IdProizvod = p.IdProizvod WHERE p.Naziv=?";

    public List<ProdajniArtikl> selectAll() {
        List<ProdajniArtikl> retVal = new ArrayList<ProdajniArtikl>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                retVal.add(new ProdajniArtikl(rs.getInt("PROIZVOD_IdProizvod"), rs.getInt("STAVKA_NABAVKE_NABAVLJANJE_IdNabavke"), rs.getDouble("Cijena"), rs.getString("Naziv"), rs.getString("Opis")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public int insert(ProdajniArtikl prodajniArtikl) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            Object values[] = {prodajniArtikl.getPROIZVOD_IdProizvod(), prodajniArtikl.getSTAVKA_NABAVKE_NABAVLJANJE_IdNabavke(), prodajniArtikl.getCijena()};
            stmt = DBUtil.prepareStatement(con, INSERT, true, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return retVal;
    }

    public int update(ProdajniArtikl prodajniArtikl) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBUtil.getConnection();
            Object values[] = {prodajniArtikl.getCijena(),prodajniArtikl.getPROIZVOD_IdProizvod()};
            stmt = DBUtil.prepareStatement(con, UPDATE_CIJENA, false, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, con);
        }
        return retVal;
    }

    public int delete(ProdajniArtikl prodajniArtikl) {
        int retVal = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBUtil.getConnection();
            Object values[] = {prodajniArtikl.getPROIZVOD_IdProizvod()};
            stmt = DBUtil.prepareStatement(con, DELETE, false, values);
            retVal = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, con);
        }
        return retVal;
    }

    public ProdajniArtikl selectById(int id) {
        ProdajniArtikl retVal = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            ps = c.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new ProdajniArtikl(rs.getInt("PROIZVOD_IdProizvod"), rs.getInt("STAVKA_NABAVKE_NABAVLJANJE_IdNabavke"), rs.getDouble("Cijena"), rs.getString("Naziv"), rs.getString("Opis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, c);
        }
        return retVal;
    }

    public ProdajniArtikl selectByNaziv(String name) {
        ProdajniArtikl retVal = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            ps = c.prepareStatement(SELECT_BY_NAZIV);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new ProdajniArtikl(rs.getInt("PROIZVOD_IdProizvod"), rs.getInt("STAVKA_NABAVKE_NABAVLJANJE_IdNabavke"), rs.getDouble("Cijena"), rs.getString("Naziv"), rs.getString("Opis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, c);
        }
        return retVal;
    }

}

