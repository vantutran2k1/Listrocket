package com.tutran.backend.api.controller.v1;

import com.tutran.backend.api.payload.ApiResponse;
import com.tutran.backend.api.payload.profile.ProfileCreateRequest;
import com.tutran.backend.api.payload.profile.ProfileDefaultResponse;
import com.tutran.backend.api.service.ProfileService;
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
public class ProfileController extends AbstractV1Controller {

    private final ProfileService profileService;

    @PostMapping(path = "/profiles")
    public ResponseEntity<ApiResponse<ProfileDefaultResponse>> createProfile(
            @RequestParam(name = "user_id") long userId,
            @RequestBody @Valid ProfileCreateRequest request
    ) {
        ApiResponse<ProfileDefaultResponse> response = new ApiResponse<>(profileService.createProfile(userId, request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
