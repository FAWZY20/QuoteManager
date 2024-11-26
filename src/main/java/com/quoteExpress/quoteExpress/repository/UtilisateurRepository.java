package com.quoteExpress.quoteExpress.repository;

import com.quoteExpress.quoteExpress.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);

    Utilisateur findUtilisateurById(Long utiId);
}
