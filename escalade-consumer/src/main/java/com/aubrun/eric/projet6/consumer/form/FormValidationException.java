package com.aubrun.eric.projet6.consumer.form;

public class FormValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    /*
     * Constructeur
     */
    public FormValidationException( String message ) {
        super( message );
    }
}