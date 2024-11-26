package com.quoteExpress.quoteExpress.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetailsDevis {

    private String description;

    private int quantite;

    private int prix;

    private int prixTotal;

    public DetailsDevis( String description, int quantite, int prix, int prixTotal) {
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.prixTotal = prixTotal;
    }

    public DetailsDevis(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }
}
