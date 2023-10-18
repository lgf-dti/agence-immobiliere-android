package com.example.agence_immobiliere;

import java.io.Serializable;

public class BienImmobilier implements Serializable {
    private String ville;
    private String codePostal;
    private String rue;

    public BienImmobilier(String ville, String codePostal, String rue) {
        this.ville = ville;
        this.codePostal = codePostal;
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getRue() {
        return rue;
    }

    @Override
    public String toString() {
        return "BienImmobilier{" +
                "ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", rue='" + rue + '\'' +
                '}';
    }
}
