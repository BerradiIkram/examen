package com.example.commonapi.commands;

public class CreateCustomerCommand extends BaseCommand<String>{
private  String nom;
private String adresse;
private String email;
private  String numTel;
    public CreateCustomerCommand(String id, String nom, String adresse, String email) {
        super(id);
        this.nom=nom;
        this.adresse=adresse;
        this.email=email;
        this.numTel=numTel;
    }

    public CreateCustomerCommand(String id) {
        super(id);
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getNumTel() {
        return numTel;
    }
}
