package org.unibl.etf.projekat_bp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bp.HelloApplication;
import org.unibl.etf.projekat_bp.dao.KategorijaDAO;
import org.unibl.etf.projekat_bp.entity.Kategorija;
import org.unibl.etf.projekat_bp.impl.KategorijaDAOImpl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SifarnikKategorijaKontroler {
    @FXML
    private TextField poljeZaPretragu;

    @FXML
    private TableView<Kategorija> tableKategorijaView;

    @FXML
    private TableColumn<Kategorija, Integer> tableColumnIdKategorija;

    @FXML
    private TableColumn<Kategorija, String> tableColumnNaziv;

    @FXML
    private TableColumn<Kategorija, String> tableColumnOpis;

    @FXML
    private TableColumn<Kategorija, Integer> tableColumnIdOdjela;

    @FXML
    public void initialize() {
        tableColumnIdKategorija.setCellValueFactory(new PropertyValueFactory<>("IdKategorija"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("Naziv"));
        tableColumnOpis.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        tableColumnIdOdjela.setCellValueFactory(new PropertyValueFactory<>("ODJEL_IdOdjela"));

        tableColumnNaziv.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnOpis.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnNaziv.setOnEditCommit(event2 -> {
            Kategorija kategorija = event2.getRowValue();
            kategorija.setNaziv(event2.getNewValue());
            KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
            kategorijaDAO.update(kategorija);
        });

        tableColumnOpis.setOnEditCommit(event2 -> {
            Kategorija kategorija = event2.getRowValue();
            kategorija.setOpis(event2.getNewValue());
            KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
            kategorijaDAO.update(kategorija);
        });
    }

    private void prikaziSveKategorije() {
        KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
        List<Kategorija> kategorije = kategorijaDAO.selectAll();
        tableKategorijaView.getItems().addAll(kategorije);
    }

    @FXML
    void onButtonPrikaziSveKategorije(MouseEvent event) {
        prikaziSveKategorije();
    }

    @FXML
    void onPretraziButton(MouseEvent event) {
        try {
            int idKategorija = Integer.parseInt(poljeZaPretragu.getText());
            KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
            Kategorija kategorija = kategorijaDAO.selectById(idKategorija);
            tableKategorijaView.getItems().clear();
            tableKategorijaView.getItems().add(kategorija);
        } catch (Exception e) {
            String pretraga = poljeZaPretragu.getText();
            KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
            Kategorija kategorija = kategorijaDAO.selectByNaziv(pretraga);
            tableKategorijaView.getItems().clear();
            tableKategorijaView.getItems().add(kategorija);
        }

    }

    @FXML
    void onDodajNovuKategoriju(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DodavanjeKategorijeKontroler.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Dodavanje nove kategorije");
        stage.setScene(scene);
        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    void onIzbrišiKategorijuButton(MouseEvent event) {
        KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
        Kategorija selectedKategorija = tableKategorijaView.getSelectionModel().getSelectedItem();

        if (selectedKategorija != null) {
            kategorijaDAO.delete(selectedKategorija);
            tableKategorijaView.getItems().remove(selectedKategorija);
        }
    }
}
