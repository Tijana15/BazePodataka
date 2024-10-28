package org.unibl.etf.projekat_bp.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import org.unibl.etf.projekat_bp.dao.*;
import org.unibl.etf.projekat_bp.entity.*;
import org.unibl.etf.projekat_bp.impl.*;

import java.time.LocalDateTime;
import java.util.List;

public class IzdavanjeRacunaKontroler {
    @FXML
    private TextField fieldNacinPlacanja;

    @FXML
    private ChoiceBox<Integer> nalogChoiceBox;
    @FXML
    private ChoiceBox<Integer> kasaChoiceBox;
    @FXML
    private TableView<ProdajniArtikl> artikliTableView;
    @FXML
    private TableColumn<ProdajniArtikl, String> nazivColumn;
    @FXML
    private TableColumn<ProdajniArtikl, Integer> idColumn;
    @FXML
    private TableColumn<ProdajniArtikl, Double> cijenaColumn;
    @FXML
    private TableView<StavkaRacun> korpaTableView;
    @FXML
    private TableColumn<StavkaRacun, Integer> korpaIdColumn;
    @FXML
    private TableColumn<StavkaRacun, Double> korpaCijenaColumn;
    @FXML
    private TableColumn<StavkaRacun, Integer> korpaKolicinaColumn;
    @FXML
    private Button dodajUKorpuButton;

    private final ObservableList<ProdajniArtikl> artikliList = FXCollections.observableArrayList();
    private final ObservableList<StavkaRacun> korpaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        ProdajniArtiklDAO prodajniArtiklDAO = new ProdajniArtiklDAOImpl();
        List<ProdajniArtikl> artikli = prodajniArtiklDAO.selectAll();
        artikliList.addAll(artikli);

        nazivColumn.setCellValueFactory(new PropertyValueFactory<>("Naziv"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("PROIZVOD_IdProizvod"));
        cijenaColumn.setCellValueFactory(new PropertyValueFactory<>("Cijena"));

        korpaIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod()).asObject());
        korpaCijenaColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCijenaProdajna()).asObject());
        korpaKolicinaColumn.setCellValueFactory(new PropertyValueFactory<>("Količina"));
        korpaKolicinaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        korpaKolicinaColumn.setOnEditCommit(event -> {
            StavkaRacun stavka = event.getRowValue();
            stavka.setKoličina(event.getNewValue());
        });
        artikliTableView.setItems(artikliList);
        korpaTableView.setItems(korpaList);
        korpaTableView.setEditable(true);

        dodajUKorpuButton.setOnAction(event -> onDodajUKorpu());
    }

    @FXML
    private void onDodajUKorpu() {
        ProdajniArtikl selectedArtikl = artikliTableView.getSelectionModel().getSelectedItem();
        if (selectedArtikl != null) {
            boolean artiklPostoji = false;
            for (StavkaRacun stavka : korpaList) {
                if (stavka.getPRODAJNI_ARTIKL_PROIZVOD_IdProizvod() == selectedArtikl.getPROIZVOD_IdProizvod()) {
                    stavka.setKoličina(stavka.getKoličina());
                    artiklPostoji = true;
                    break;
                }
            }
            if (!artiklPostoji) {
                StavkaRacun stavka = new StavkaRacun(
                        selectedArtikl.getPROIZVOD_IdProizvod(),
                        0,
                        1,
                        selectedArtikl.getCijena()
                );
                korpaList.add(stavka);
            }
            korpaTableView.refresh();
        }
    }

    @FXML
    void kreirajRacun() {
        RacunDAO racunDAO = new RacunDAOImpl();

        String nacinPlacanja = fieldNacinPlacanja.getText();
        int idNaloga = nalogChoiceBox.getValue();
        int idKasa = kasaChoiceBox.getValue();
        LocalDateTime datumVrijemeIzdavanja = LocalDateTime.now();

        if (nacinPlacanja.isEmpty()) {
            return;
        }

        Racun noviRacun = new Racun(datumVrijemeIzdavanja.toString(), nacinPlacanja, idKasa, idNaloga);
        int idNovogRacuna = racunDAO.kreirajRacun(noviRacun);

        if (idNovogRacuna != 0) {
            racunDAO.dodajStavkeRacuna(idNovogRacuna, korpaList);
            korpaList.clear();
            korpaTableView.refresh();
        }
    }

    @FXML
    void onIzaberiIDKase(MouseEvent event) {
        KasaDAO kasaDAO = new KasaDAOImpl();
        List<Kasa> kasaList = kasaDAO.selectAll();
        kasaChoiceBox.getItems().clear();
        for (Kasa k : kasaList) {
            kasaChoiceBox.getItems().add(k.getIdKasa());
        }
    }

    @FXML
    void onIzaberiIDNaloga(MouseEvent event) {
        NalogDAO nalogDAO = new NalogDAOImpl();
        List<Nalog> listaNaloga = nalogDAO.selectAll();
        nalogChoiceBox.getItems().clear();
        for (Nalog n : listaNaloga) {
            nalogChoiceBox.getItems().add(n.getIdNaloga());
        }
    }
}
