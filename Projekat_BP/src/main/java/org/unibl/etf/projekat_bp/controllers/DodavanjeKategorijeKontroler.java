package org.unibl.etf.projekat_bp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.unibl.etf.projekat_bp.dao.KategorijaDAO;
import org.unibl.etf.projekat_bp.dao.OdjelDAO;
import org.unibl.etf.projekat_bp.entity.Kategorija;
import org.unibl.etf.projekat_bp.entity.Odjel;
import org.unibl.etf.projekat_bp.impl.KategorijaDAOImpl;
import org.unibl.etf.projekat_bp.impl.OdjelDAOImpl;

import java.util.List;

public class DodavanjeKategorijeKontroler {
    @FXML
    private TextField fieldIdKategorije;
    @FXML
    private TextField fieldNazivKategorije;

    @FXML
    private TextField fieldOpisKategorije;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void prikaziNaziveOdjela(MouseEvent event) {
        OdjelDAO odjelDAO = new OdjelDAOImpl();
        List<Odjel> odjeli = odjelDAO.selectAll_Naziv();

        choiceBox.getItems().clear();

        for (Odjel odjel : odjeli) {
            choiceBox.getItems().add(odjel.getIdOdjela() + " " + odjel.getNaziv());
        }
    }

    @FXML
    void onKreirajButton(MouseEvent event) {
        int id = Integer.parseInt(fieldIdKategorije.getText());
        String nazivKategorije = fieldNazivKategorije.getText();
        String opisKategorije = fieldOpisKategorije.getText();
        String idOdjela = choiceBox.getValue().split(" ")[0];
        KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
        int IdOdjela = Integer.parseInt(idOdjela);
        Kategorija kategorija = new Kategorija(id, nazivKategorije, opisKategorije, IdOdjela);
        kategorijaDAO.insert(kategorija);
    }
}
