package com.team4.deskbookingappbe.model.api;

public class JwtResponse {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;

    public JwtResponse(String jwttoken) {
        this.jwtToken = jwttoken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
