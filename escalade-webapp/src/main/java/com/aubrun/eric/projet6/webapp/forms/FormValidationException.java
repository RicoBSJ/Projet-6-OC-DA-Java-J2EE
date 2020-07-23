package com.aubrun.eric.projet6.webapp.forms;

public class FormValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public FormValidationException( String message ) {
        super( message );
    }
}