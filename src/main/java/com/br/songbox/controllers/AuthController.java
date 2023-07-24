package com.br.songbox.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.SpotifyApi;

import java.net.URI;

@CrossOrigin
@RestController
public class AuthController {
    @Value("${CLIENT_ID}")
    private static String clientId;
    @Value("${CLIENT_SECRET}")
    private static String clientSecret;
    private static final SpotifyApi spotifyApi = SpotifyApi.builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(URI.create("http://localhost:8080/api/songbox/login"))
            .build();


    @PostMapping("/login")
    public void login(@RequestParam @NotBlank String access_token) {
        System.out.println(access_token);
    }
}
