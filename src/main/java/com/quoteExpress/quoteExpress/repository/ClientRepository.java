package com.quoteExpress.quoteExpress.repository;

import com.quoteExpress.quoteExpress.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientById(Long utiId);
    Client findByEmail(String email);

}
