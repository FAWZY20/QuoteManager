package com.quoteExpress.quoteExpress.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "mdp")
    private String mdp;

    @Column(name = "dateinscription")
    private Date dateinscription = new Date();;

    @Column(name = "dateconnexion")
    private Date dateconnexion;

    public Utilisateur(String nom, String prenom, String email, String mdp, Date dateconnexion, Date dateinscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.dateinscription = dateinscription;
        this.dateconnexion = dateconnexion;
    }

    public Utilisateur(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateInscription() {
        return dateinscription;
    }

    public Date getDateConnexion() {
        return dateconnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateconnexion = dateConnexion;
    }
}
