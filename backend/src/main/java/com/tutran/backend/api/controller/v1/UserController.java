package com.tutran.backend.api.controller.v1;

import com.tutran.backend.api.payload.ApiResponse;
import com.tutran.backend.api.payload.user.UserCreateRequest;
import com.tutran.backend.api.payload.user.UserDefaultResponse;
import com.tutran.backend.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController extends AbstractV1Controller {

    private final UserService userService;

    @PostMapping(path = "/users")
    public ResponseEntity<ApiResponse<UserDefaultResponse>> createUser(
            @RequestBody @Valid UserCreateRequest request
    ) {
        ApiResponse<UserDefaultResponse> response = new ApiResponse<>(userService.createUser(request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
