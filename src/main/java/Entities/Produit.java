/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author damie
 */
public class Produit {
    private int reference;
    private String nom;
    private int fournisseur;
    private int categorie;
    private String quantite_par_unite;
    private float prix_unitaire;
    private int unite_en_stock;
    private int unites_commandees;
    private int niveau_de_reapprovi;
    private int indisponible;
    
    public Produit(String nom){
        this.nom = nom;
    }
    
    public Produit(int pf_reference, String pf_nom, int pf_fournisseur, int pf_categorie, String pf_quantite_par_unite, 
            float pf_prix_unitaire, int pf_unite_en_stock, int pf_unites_commandees, int pf_niveau_de_reapprovi, int pf_indisponible){
        this.reference=pf_reference;
        this.nom=pf_nom;
        this.fournisseur=pf_fournisseur;
        this.categorie=pf_categorie;
        this.quantite_par_unite=pf_quantite_par_unite;
        this.prix_unitaire=pf_prix_unitaire;
        this.unite_en_stock=pf_unite_en_stock;
        this.unites_commandees=pf_unites_commandees;
        this.niveau_de_reapprovi=pf_niveau_de_reapprovi;
        this.indisponible=pf_indisponible;
    }



    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getQuantite_par_unite() {
        return quantite_par_unite;
    }

    public void setQuantite_par_unite(String quantite_par_unite) {
        this.quantite_par_unite = quantite_par_unite;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getUnite_en_stock() {
        return unite_en_stock;
    }

    public void setUnite_en_stock(int unite_en_stock) {
        this.unite_en_stock = unite_en_stock;
    }

    public int getUnites_commandees() {
        return unites_commandees;
    }

    public void setUnites_commandees(int unites_commandees) {
        this.unites_commandees = unites_commandees;
    }

    public int getNiveau_de_reapprovi() {
        return niveau_de_reapprovi;
    }

    public void setNiveau_de_reapprovi(int niveau_de_reapprovi) {
        this.niveau_de_reapprovi = niveau_de_reapprovi;
    }

    public int getIndisponible() {
        return indisponible;
    }

    public void setIndisponible(int indisponible) {
        this.indisponible = indisponible;
    }
    
    
}
