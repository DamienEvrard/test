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
public class Ligne {
    private int Commande; 
    private int Produit;
    private int Quantite;

    public Ligne(int Commande, int Produit, int Quantite) {
        this.Commande = Commande;
        this.Produit = Produit;
        this.Quantite = Quantite;
    }

    public int getCommande() {
        return Commande;
    }

    public void setCommande(int Commande) {
        this.Commande = Commande;
    }

    public int getProduit() {
        return Produit;
    }

    public void setProduit(int Produit) {
        this.Produit = Produit;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }
    
    
}
