package com.quoteExpress.quoteExpress.repository;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {

    List<Devis> findDevisByUtilisateurid(Long utilisateurId);
    Devis findDevisByUtilisateuridAndId(Long utilisateurId, Long devisId);
}
