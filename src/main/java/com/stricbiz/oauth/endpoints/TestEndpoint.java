package com.stricbiz.oauth.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sajeer
 * @date 23/10/20
 */
@RestController
@RequestMapping("/ping")
public class TestEndpoint {
    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private TokenStore tokenStore;

    @GetMapping
    ResponseEntity test() {
        return ResponseEntity.ok("{\"ping\": \"pong\"}");
    }
}
