package org.acme.security.jwt;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenTokenJWT {

    public String getToken() {
      String token =
      Jwt.issuer("https://example.com/issuer") 
        .upn("jdoe@quarkus.io") 
        .groups(new HashSet<>(Arrays.asList("User", "Admin", "Guest"))) 
        .claim(Claims.birthdate.name(), "2001-07-13")
        .claim(Claims.email.name(), "alexandre@acline.com.br")
        .sign();
        System.out.println(token);
        return token;
    }    
}
