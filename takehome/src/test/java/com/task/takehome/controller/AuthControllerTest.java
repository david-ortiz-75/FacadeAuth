package com.task.takehome.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class AuthControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testAuthorizedUserViaPost() {
        webTestClient.post().uri("/authorize")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"userId\": \"123\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("{\"authorized\":true}");
    }

    @Test
    void testUnauthorizedUserViaPost() {
        webTestClient.post().uri("/authorize")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"userId\": \"00000\"}")
                .exchange()
                .expectStatus().isForbidden()
                .expectBody(String.class).isEqualTo("{\"authorized\":false}");
    }
}