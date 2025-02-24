package org.unibl.etf.projekat_bp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.unibl.etf.projekat_bp.dao.ProdajniArtiklDAO;
import org.unibl.etf.projekat_bp.dao.ProizvodDAO;
import org.unibl.etf.projekat_bp.dao.StavkaNabavkeDAO;
import org.unibl.etf.projekat_bp.entity.ProdajniArtikl;
import org.unibl.etf.projekat_bp.entity.Proizvod;
import org.unibl.etf.projekat_bp.entity.StavkaNabavke;
import org.unibl.etf.projekat_bp.impl.ProdajniArtiklDAOImpl;
import org.unibl.etf.projekat_bp.impl.ProizvodDAOImpl;
import org.unibl.etf.projekat_bp.impl.StavkaNabavkeImpl;

import java.util.List;

public class DodavanjeProdajnogArtiklaKontroler {

    @FXML
    private TextField fieldCijena;

    @FXML
    private ComboBox<Integer> comboIdNabavke;

    @FXML
    private ComboBox<Integer> comboIdProizvod;

    @FXML
    void onButtonKreiraj(MouseEvent event) {
        int cijena = Integer.parseInt(fieldCijena.getText());
        int idNabavke = comboIdNabavke.getValue();
        int idProizvod = comboIdProizvod.getValue();
        ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
        ProdajniArtikl prodajniArtikl = new ProdajniArtikl(idProizvod, idNabavke, cijena);
        prodajniArtiklDAO.insert(prodajniArtikl);
    }

    @FXML
    void onIdNabavkeCombo(MouseEvent event) {
        StavkaNabavkeDAO stavkaNabavkeDAO = new StavkaNabavkeImpl();
        List<StavkaNabavke> stavkeNabavke = stavkaNabavkeDAO.selectAll();
        comboIdNabavke.getItems().clear();
        for (StavkaNabavke s : stavkeNabavke) {
            comboIdNabavke.getItems().add(s.getNABAVLJANJE_IdNabavke());
        }
    }

    @FXML
    void onIdProizvodaCombo(MouseEvent event) {
        ProizvodDAO proizvodDAO = new ProizvodDAOImpl();
        List<Proizvod> proizvodi = proizvodDAO.selectAll();

        comboIdProizvod.getItems().clear();

        for (Proizvod proizvod : proizvodi) {
            comboIdProizvod.getItems().add(proizvod.getIdProizvoda());
        }
    }

}
