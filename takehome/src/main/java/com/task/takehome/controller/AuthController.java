package com.task.takehome.controller;

import com.task.takehome.model.Permission;
import com.task.takehome.model.Response;
import com.task.takehome.service.DownstreamAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    @Autowired
    private DownstreamAuthService downstreamAuthService;
    @PostMapping("/authorize")
    public Mono<ResponseEntity<Response>> proxyRequest(@RequestBody Mono<Permission> requestMono) {
        return requestMono
                .flatMap(req -> downstreamAuthService.forwardRequest(req.getUserId()))
                .map(auth -> (Boolean)auth
                        ? ResponseEntity.ok(Response.builder().authorized(true).build())
                        : ResponseEntity.status(HttpStatus.FORBIDDEN).body(Response.builder().authorized(false).build()));
    }
}
