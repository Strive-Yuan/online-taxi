package com.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class TestController {

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    public String url;

    @GetMapping("/test")
    public String test() {
        String serviceName = "api-passenger";
        String ip = "192.168.92.1";
        int port = 8080;

        String url = String.format("http://101.43.98.156:8848/nacos/v1/ns/instance?serviceName=%s&ip=%s&port=%d", serviceName, ip, port);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.noBody()).build();

        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        future.thenAccept(response -> {
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response headers: " + response.headers());
            System.out.println("Response body: " + response.body());
        }).join();
        return url;
    }
}
