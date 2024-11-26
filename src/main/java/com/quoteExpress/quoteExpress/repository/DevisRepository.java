package com.quoteExpress.quoteExpress.repository;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {

    List<Devis> findDevisByUtilisateurid(Long utilisateurId);
    Devis findDevisByUtilisateuridAndId(Long utilisateurId, Long devisId);
=======
@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {

>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95
}
