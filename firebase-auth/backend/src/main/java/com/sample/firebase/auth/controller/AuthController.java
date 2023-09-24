package com.sample.firebase.auth.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.sample.firebase.auth.data.request.TokenInfo;
import com.sample.firebase.auth.data.response.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@Slf4j
@RestController
public class AuthController {

    private final FirebaseApp firebaseApp;
    private final FirebaseAuth firebaseAuth;

    public AuthController() {
        ClassPathResource resource = new ClassPathResource("firebase-adminsdk.json");

        GoogleCredentials googleCredentials = null;
        try {
            InputStream resourceInputStream = resource.getInputStream();
            googleCredentials = GoogleCredentials.fromStream(resourceInputStream);
        } catch (Exception exception) {
            throw new RuntimeException("Invalid firebase-adminsdk.json");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(googleCredentials)
                .build();

        this.firebaseApp = FirebaseApp.initializeApp(options);
        this.firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
    }

    @RequestMapping(path = "/auth", method = RequestMethod.POST)
    public ResponseEntity<AccountInfo> getAccountInfo(@RequestBody TokenInfo tokenInfo) throws Exception {
        FirebaseToken firebaseToken = this.firebaseAuth.verifyIdToken(tokenInfo.getIdToken());

        log.info("user id: {}", firebaseToken.getUid());
        log.info("email: {}", firebaseToken.getEmail());
        log.info("email verified: {}", firebaseToken.isEmailVerified());

        AccountInfo accountInfo = AccountInfo.builder()
                .userId(firebaseToken.getUid())
                .email(firebaseToken.getEmail())
                .isEmailVerified(firebaseToken.isEmailVerified())
                .build();

        return ResponseEntity.status(200).body(accountInfo);
    }
}
