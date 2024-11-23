package com.quoteExpress.quoteExpress.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "nomEntreprise")
    private String nomEntreprise;

    @Column(name = "nomContact")
    private String nomContact;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "codepostal")
    private int codepostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @Column(name = "dateinscription")
    private Date dateinscription = new Date();

    @Column(name = "statut")
    private Status statut;

    @Column(name = "notes")
    private String notes;

    @Column(name = "siret")
    private String siret;

    public enum Status{
        Particulier,
        Entreprise
    }

    public Client(String nomEntreprise,
                  String nomContact,
                  String email,
                  String telephone,
                  String adresse,
                  int codepostal,
                  String ville,
                  String pays,
                  Status statut,
                  String notes,
                  String siret,
                  Date dateinscription ) {
        this.nomEntreprise = nomEntreprise;
        this.nomContact = nomContact;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.pays = pays;
        this.dateinscription = dateinscription;
        this.statut = statut;
        this.notes = notes;
        this.siret = siret;
    }

    public Client(){}

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_postal() {
        return codepostal;
    }

    public void setCode_postal(int code_postal) {
        this.codepostal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateInscription() {
        return dateinscription;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }
}
