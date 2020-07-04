package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormMessage {

    private String message;

    public SearchFormMessage( HttpServletRequest request ) {
        this.message = request.getParameter( "message" );
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}