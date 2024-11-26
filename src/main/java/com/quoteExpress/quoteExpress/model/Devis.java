package com.quoteExpress.quoteExpress.model;


import jakarta.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "devis")
public class Devis {

    @Id
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

    @Column(name = "status")
    private Status status;

    @Column(name = "devis")
    private File devis;

    @ElementCollection
    @Column(name = "details")
    private List<DetailsDevis> details;

    @Column(name = "tva")
    private int tva;

    enum Status{
        ATTENTE, ACCEPT, REFUSE, EXPIRE
    }

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
}
