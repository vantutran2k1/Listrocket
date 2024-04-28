package com.tutran.backend.api.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(
        value = "/api/v1",
        produces = MediaType.APPLICATION_JSON_VALUE
)
abstract class AbstractV1Controller {
}
