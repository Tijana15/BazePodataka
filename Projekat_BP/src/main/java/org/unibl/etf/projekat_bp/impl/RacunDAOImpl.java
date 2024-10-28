package org.unibl.etf.projekat_bp.impl;

import org.unibl.etf.projekat_bp.dao.RacunDAO;
import org.unibl.etf.projekat_bp.db.DBUtil;
import org.unibl.etf.projekat_bp.entity.Racun;
import org.unibl.etf.projekat_bp.entity.StavkaRacun;

import java.sql.*;
import java.util.List;

public class RacunDAOImpl implements RacunDAO {
    private static final String SQL_KREIRAJ_RACUN = "CALL kreiraj_racun(?, ?, ?, ?)";
    private static final String SQL_DODAJ_STAVKU_RACUNA = "INSERT INTO STAVKA_RACUN (RAČUN_IdRačun, PRODAJNI_ARTIKL_PROIZVOD_IdProizvod, Količina, CijenaProdajna) VALUES (?, ?, ?, ?)";

    @Override
    public int kreirajRacun(Racun račun) {
        int idNovogRacuna = 0;
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            if (con != null) {
                stmt = con.prepareCall(SQL_KREIRAJ_RACUN);

                stmt.setString(1, račun.getNacinPlacanja());
                stmt.setInt(2, račun.getKASA_IdKasa());
                stmt.setInt(3, račun.getNALOG_IdNaloga());
                stmt.registerOutParameter(4, java.sql.Types.INTEGER);

                stmt.execute();

                idNovogRacuna = stmt.getInt(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, stmt, con);
        }
        return idNovogRacuna;
    }


    @Override
    public void dodajStavkuRacuna(int idRacuna, int idProdajnogArtikla, int kolicina, double cijenaProdajna) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_DODAJ_STAVKU_RACUNA)) {

            stmt.setInt(1, idRacuna);
            stmt.setInt(2, idProdajnogArtikla);
            stmt.setInt(3, kolicina);
            stmt.setDouble(4, cijenaProdajna);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dodajStavkeRacuna(int idRacuna, List<StavkaRacun> stavke) {
        try (Connection con = DBUtil.getConnection()) {
            for (StavkaRacun stavka : stavke) {
                dodajStavkuRacuna(idRacuna, stavka.getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod(), stavka.getKoličina(), stavka.getCijenaProdajna());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
