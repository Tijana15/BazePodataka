package org.unibl.etf.projekat_bp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import org.unibl.etf.projekat_bp.HelloApplication;
import org.unibl.etf.projekat_bp.dao.ProdajniArtiklDAO;
import org.unibl.etf.projekat_bp.entity.ProdajniArtikl;
import org.unibl.etf.projekat_bp.entity.Proizvod;
import org.unibl.etf.projekat_bp.impl.ProdajniArtiklDAOImpl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SifarnikProdajnihArtikalaKontroler {

    @FXML
    private TextField fieldPretraga;
    @FXML
    private TableColumn<ProdajniArtikl, Integer> tableColumnIdProizvoda;

    @FXML
    private TableColumn<ProdajniArtikl, Double> tableColumnCijena;

    @FXML
    private TableColumn<ProdajniArtikl, Integer> tableColumnIdNabavke;

    @FXML
    private TableView<ProdajniArtikl> tableViewProdajniArtikl;
    @FXML
    private TableColumn<Proizvod, String> tableColumnNaziv;

    @FXML
    private TableColumn<Proizvod, String> tableColumnOpis;

    @FXML
    public void initialize() {
        tableColumnIdProizvoda.setCellValueFactory(new PropertyValueFactory<>("PROIZVOD_IdProizvod"));
        tableColumnCijena.setCellValueFactory(new PropertyValueFactory<>("Cijena"));
        tableColumnIdNabavke.setCellValueFactory(new PropertyValueFactory<>("STAVKA_NABAVKE_NABAVLJANJE_IdNabavke"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("Naziv"));
        tableColumnOpis.setCellValueFactory(new PropertyValueFactory<>("Opis"));

        tableColumnCijena.setCellFactory(TextFieldTableCell.<ProdajniArtikl, Double>forTableColumn(new DoubleStringConverter()));

        tableColumnCijena.setOnEditCommit(event -> {
            ProdajniArtikl prodajniArtikl = event.getRowValue();
            prodajniArtikl.setCijena(event.getNewValue());
            ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
            prodajniArtiklDAO.update(prodajniArtikl);
        });

    }

    private void prikaziSveProdajneArtikle() {
        tableViewProdajniArtikl.getItems().clear();
        ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
        List<ProdajniArtikl> prodajniArtiklList = prodajniArtiklDAO.selectAll();
        tableViewProdajniArtikl.getItems().addAll(prodajniArtiklList);
    }

    @FXML
    void onButtonPrikaziSveProdajneArtikle(MouseEvent event) {
        prikaziSveProdajneArtikle();
    }

    @FXML
    void onPretraziButton(MouseEvent event) {
        try {
            int idProizvoda = Integer.parseInt(fieldPretraga.getText());
            ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
            ProdajniArtikl prodajniArtikl = prodajniArtiklDAO.selectById(idProizvoda);
            tableViewProdajniArtikl.getItems().clear();
            tableViewProdajniArtikl.getItems().add(prodajniArtikl);

        } catch (Exception e) {
            String pretraga = fieldPretraga.getText();
            ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
            ProdajniArtikl prodajniArtikl = prodajniArtiklDAO.selectByNaziv(pretraga);
            tableViewProdajniArtikl.getItems().clear();
            tableViewProdajniArtikl.getItems().add(prodajniArtikl);
        }
    }

    @FXML
    void onButtonIzbrisi(MouseEvent event) {
        ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
        ProdajniArtikl prodajniArtikl = tableViewProdajniArtikl.getSelectionModel().getSelectedItem();

        if (prodajniArtikl != null) {
            prodajniArtiklDAO.delete(prodajniArtikl);
            tableViewProdajniArtikl.getItems().remove(prodajniArtikl);
        }
    }

    @FXML
    void onButtonDodajNovi(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DodavanjeProdajnogArtiklaKontroler.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Dodavanje novog prodajnog artikla");
        stage.setScene(scene);
        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();
    }

}
