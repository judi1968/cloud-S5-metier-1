package com.example.back_office.Model;

public class Bag {

    Exception exception;
    Object object;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Bag(String titre, String valeur, Object object) {
        Exception exception = new Exception(titre, valeur);
        this.setException(exception);
        this.setObject(object);
    }

    public class Exception {
        String titre = null;
        String valeur = null;

        public Exception(String titre, String valeur) {
            this.setTitre(titre);
            this.setValeur(valeur);
        }


        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public String getValeur() {
            return valeur;
        }

        public void setValeur(String valeur) {
            this.valeur = valeur;
        }
    }

}
