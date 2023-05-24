package it.develhope.Unit.Test.repositories;

import it.develhope.Unit.Test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository <Utente, Long> {
}
