package com.sample.firebase.auth.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountInfo {
    private String userId;
    private String email;
    private Boolean isEmailVerified;
}
