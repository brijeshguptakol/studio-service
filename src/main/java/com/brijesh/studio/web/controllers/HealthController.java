package com.brijesh.studio.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller provides endpoints to check the health of the service.
 */
@RestController
public class HealthController {

    @GetMapping("/alive")
    public boolean health() {
        return true;
    }
}
