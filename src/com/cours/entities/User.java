package com.cours.entities;

public class User {
    //attributs
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Boolean etat;
    //constructeurs
    public User(){

    }
    public User(String nom, String prenom, String email, String password, Boolean etat){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.etat = etat;

    }
    //methodes
    public String getNom(){
        return this.nom;
    };
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email =email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public Boolean getEtat(){
        return this.etat;
    }
    public void setEtat(Boolean etat){
        this.etat = etat;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
}
