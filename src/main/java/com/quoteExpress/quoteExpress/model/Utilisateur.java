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

    @Column(name = "nomEntreprise")
    private String nomEntreprise;

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


    @Column(name = "statut")
    private Status statut;

    @Column(name = "siret")
    private String siret;

    @Column(name = "dateinscription")
    private Date dateinscription = new Date();;

    @Column(name = "dateconnexion")
    private Date dateconnexion;


    @Column(name = "role")
    private String role = "USER";

    public enum Status{
        Particulier,
        Entreprise
    }

    public Utilisateur(String nom,
                       String prenom,
                       String email,
                       String mdp,
                       String nomEntreprise,
                       String telephone,
                       String adresse,
                       int codepostal,
                       String ville,
                       String pays,
                       String role,
                       Status statut,
                       String siret,
                       Date dateinscription,
                       Date dateconnexion) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.nomEntreprise = nomEntreprise;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.pays = pays;
        this.statut = statut;
        this.siret = siret;
        this.role = role;
        this.dateinscription = dateinscription;
        this.dateconnexion = dateconnexion;
    }

    public Utilisateur(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
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

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
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

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public Date getDateconnexion() {
        return dateconnexion;
    }

    public void setDateconnexion(Date dateconnexion) {
        this.dateconnexion = dateconnexion;
    }
}
