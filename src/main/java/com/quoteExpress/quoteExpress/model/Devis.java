package com.quoteExpress.quoteExpress.model;

<<<<<<< HEAD
import jakarta.persistence.*;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.File;
import java.util.Date;
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95

@Entity
@Table(name = "devis")
public class Devis {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "clientid")
    private Long clientid;

    @Column(name = "utilisateurid")
    private Long utilisateurid;
    @Column(name = "numerodevis")
    private Long numerodevis;

    @Column(name = "datecreation")
    private Date datecreation = new Date();

    @Column(name = "datevalidation")
    private Date datevalidation;
=======
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
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95

    @Column(name = "status")
    private Status status;

    @Column(name = "devis")
    private File devis;

<<<<<<< HEAD
    @ElementCollection
    @Column(name = "details")
    private List<DetailsDevis> details;

    @Column(name = "tva")
    private int tva;

=======
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95
    enum Status{
        ATTENTE, ACCEPT, REFUSE, EXPIRE
    }

<<<<<<< HEAD
    public Devis(Long clientid,
                 Long utilisateurid,
                 Long numerodevis,
                 Date datecreation,
                 Date datevalidation,
                 Status status, File devis,
                 List<DetailsDevis> details,
                 int tva) {
        this.clientid = clientid;
        this.utilisateurid = utilisateurid;
        this.numerodevis = numerodevis;
        this.datecreation = datecreation;
        this.datevalidation = datevalidation;
        this.status = status;
        this.devis = devis;
        this.details = details;
        this.tva = tva;
    }

    public Devis(){}

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getUtilisateurid() {
        return utilisateurid;
    }

    public void setUtilisateurid(Long utilisateurid) {
        this.utilisateurid = utilisateurid;
    }

    public Long getNumerodevis() {
        return numerodevis;
    }

    public void setNumerodevis(Long numerodevis) {
        this.numerodevis = numerodevis;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatevalidation() {
        return datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
=======
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
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95
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
<<<<<<< HEAD

    public List<DetailsDevis> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsDevis> details) {
        this.details = details;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }
=======
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95
}
