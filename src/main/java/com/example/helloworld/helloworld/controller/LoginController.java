package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.Users;
import com.example.helloworld.helloworld.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final String SECRET_KEY = "5R@hP2A+gQkzXK9vS4M*E7jWdGdF5aJd";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds

    @Autowired
    UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(@RequestBody String email) {
        // Calculate token expiration time
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        JsonReader jsonReader = Json.createReader(new StringReader(email));

        // Read the JSON object from the reader
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        // Extract the email field
        String emailId = jsonObject.getString("email");
        List<Users> user = userService.getUserByEmail(emailId);
        if (user.isEmpty()) {
            return new ResponseEntity<>("No user records found for the user ID: " + emailId, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            // Create a JWT token with the email as the subject
            String token = Jwts.builder()
                    .setSubject(emailId)
                    .setExpiration(expirationDate)
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
            responseBody.put("user", user);
            responseBody.put("token", token);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        }
    }
}
