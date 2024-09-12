package org.acme.security.jwt;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenerateToken {
    /**
     * Generate JWT token
     */
    public static void main(String[] args) {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("User", "Admin", "Guest"))) 
             .claim(Claims.birthdate.name(), "2001-07-13")
             .claim(Claims.email.name(), "alexandre@acline.com.br")
           .sign();
        System.out.println("-----BEGIN TOKEN JWT-----");
        System.out.println(token);
        System.out.println("-----END TOKEN JWT-----");
    }
}