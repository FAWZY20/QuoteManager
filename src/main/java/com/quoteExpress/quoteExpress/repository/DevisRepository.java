package com.quoteExpress.quoteExpress.repository;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {

}
