package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDoubleNumberEndpoint() {
        int inputNumber = 5;

        // Construct the URL with the input parameter and call the endpoint
        ResponseEntity<Integer> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/double?number={number}", Integer.class, inputNumber);

        // Check that the response status code is OK (HTTP 200)
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Assert that the response body equals the doubled value of the input number
        assertThat(response.getBody()).isEqualTo(10);
    }
}
