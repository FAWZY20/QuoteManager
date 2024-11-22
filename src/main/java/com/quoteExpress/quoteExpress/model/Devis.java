package com.quoteExpress.quoteExpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.File;
import java.util.Date;

@Entity
@Table(name = "devis")
public class Devis {

    @Id
    private Long id;

    @Column(name = "clientId")
    private Long clientId;

    @Column(name = "numeroDevis")
    private Long numeroDevis;

    @Column(name = "dateCreation")
    private Date dateCreation;

    @Column(name = "dateValidation")
    private Date dateValidation;

    @Column(name = "montantTotal")
    private float montantTotal;

    @Column(name = "status")
    private Status status;

    @Column(name = "devis")
    private File devis;

    enum Status{
        ATTENTE, ACCEPT, REFUSE, EXPIRE
    }

    public Devis(Long clientId, Long numeroDevis, Date dateCreation, Date dateValidation, float montantTotal, Status status, File devis) {
        this.clientId = clientId;
        this.numeroDevis = numeroDevis;
        this.dateCreation = dateCreation;
        this.dateValidation = dateValidation;
        this.montantTotal = montantTotal;
        this.status = status;
        this.devis = devis;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getNumeroDevis() {
        return numeroDevis;
    }

    public void setNumeroDevis(Long numeroDevis) {
        this.numeroDevis = numeroDevis;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public File getDevis() {
        return devis;
    }

    public void setDevis(File devis) {
        this.devis = devis;
    }
}
