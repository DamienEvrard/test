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
public class Client {
    
    private String Code;
    private String Contact;
    private String Societe;
    private String Fonction;
    private String Adresse;
    private String Ville;
    private String Region;
    private String Code_Postal;
    private String Pays;
    private String Telephone;
    private String Fax;
    
    public Client(String pf_id, String pf_contact, String pf_societe, String pf_fonction, String pf_adresse, String pf_ville, String pf_region, String pf_code_postal, String pf_pays, String pf_telephne, String pf_fax){
        this.Code=pf_id;
        this.Contact=pf_contact;
        this.Societe=pf_societe;
        this.Fonction=pf_fonction;
        this.Adresse=pf_adresse;
        this.Ville=pf_ville;
        this.Region=pf_region;
        this.Code_Postal=pf_code_postal;
        this.Pays=pf_pays;
        this.Telephone=pf_telephne;
        this.Fax=pf_fax;
    }
    
    public Client(String pf_id, String pf_contact){
        this.Code = pf_id;
        this.Contact = pf_contact;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getSociete() {
        return Societe;
    }

    public void setSociete(String Societe) {
        this.Societe = Societe;
    }

    public String getFonction() {
        return Fonction;
    }

    public void setFonction(String Fonction) {
        this.Fonction = Fonction;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getCode_Postal() {
        return Code_Postal;
    }

    public void setCode_Postal(String Code_Postal) {
        this.Code_Postal = Code_Postal;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }
    
    
    
}
