CREATE VIEW RacunStavkeView AS
SELECT
r.IdRačun,
r.DatumVrijemeIzdavanja,
r.NacinPlacanja,
r.Iznos,
r.KASA_IdKasa,
r.NALOG_IdNaloga,
sr.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod,
p.Naziv AS NazivProizvoda,
sr.Količina,
sr.CijenaProdajna
FROM
RAČUN r
JOIN
STAVKA_RACUN sr ON r.IdRačun = sr.RAČUN_IdRačun
JOIN
PRODAJNI_ARTIKL pa ON sr.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = pa.PROIZVOD_IdProizvod
JOIN
PROIZVOD p ON pa.PROIZVOD_IdProizvod = p.IdProizvod;
select * from RacunStavkeView;

DELIMITER $$

CREATE TRIGGER trg_update_iznos_racuna
AFTER INSERT ON STAVKA_RACUN
FOR EACH ROW
BEGIN
    DECLARE total_amount DECIMAL(10,2);
    
    -- Računamo ukupan iznos za račun koji se mijenja
    SELECT SUM(sr.Količina * sr.CijenaProdajna) INTO total_amount
    FROM STAVKA_RACUN sr
    JOIN PRODAJNI_ARTIKL pa ON sr.PRODAJNI_ARTIKL_PROIZVOD_IdProizvod = pa.PROIZVOD_IdProizvod
    WHERE sr.RAČUN_IdRačun = NEW.RAČUN_IdRačun;
    
    -- Ažuriramo iznos u tablici RAČUN
    UPDATE RAČUN
    SET Iznos = total_amount
    WHERE IdRačun = NEW.RAČUN_IdRačun;
END $$
DELIMITER ;

DELIMITER $$


CREATE PROCEDURE kreiraj_racun(
    IN pNacinPlacanja VARCHAR(255),
    IN pKasaId INT,
    IN pNalogId INT,
    OUT pIdRacuna INT
)
BEGIN
    DECLARE vIdRacuna INT DEFAULT 0;

    -- Umetanje novog računa
    INSERT INTO `RAČUN` (DatumVrijemeIzdavanja, NacinPlacanja, KASA_IdKasa, NALOG_IdNaloga)
    VALUES (NOW(), pNacinPlacanja, pKasaId, pNalogId);

    -- Dobijanje ID-a umetnutog računa
    SET vIdRacuna = LAST_INSERT_ID();

    -- Vraćanje ID-a kreiranog računa
    SET pIdRacuna = vIdRacuna;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE dodaj_stavku_racuna(
    IN pIdRacuna INT,
    IN pProdajniArtiklProizvodId INT,
    IN pKolicina INT,
    IN pCijenaProdajna DECIMAL(10, 2)
)
BEGIN
    -- Umetanje stavke računa
    INSERT INTO `STAVKA_RACUN` (PRODAJNI_ARTIKL_PROIZVOD_IdProizvod, RACUN_IdRacuna, Količina, CijenaProdajna)
    VALUES (pProdajniArtiklProizvodId, pIdRacuna, pKolicina, pCijenaProdajna);
END $$

DELIMITER ;

