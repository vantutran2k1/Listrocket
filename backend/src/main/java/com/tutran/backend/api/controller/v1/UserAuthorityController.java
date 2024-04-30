package com.tutran.backend.api.controller.v1;

import com.tutran.backend.api.payload.ApiResponse;
import com.tutran.backend.api.payload.userauthority.UserAuthorityCreateRequest;
import com.tutran.backend.api.payload.userauthority.UserAuthorityDefaultResponse;
import com.tutran.backend.api.service.UserAuthorityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthorityController extends AbstractV1Controller {

    private final UserAuthorityService userAuthorityService;

    @PostMapping("/user-authorities")
    public ResponseEntity<ApiResponse<UserAuthorityDefaultResponse>> createUserAuthority(
            @RequestParam(name = "user_id") long userId,
            @RequestBody @Valid UserAuthorityCreateRequest request
    ) {
        ApiResponse<UserAuthorityDefaultResponse> response = new ApiResponse<>(
                userAuthorityService.createUserAuthority(userId, request)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
