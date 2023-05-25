package com.mlevensohn.base.controllers;

import com.mlevensohn.base.models.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public ResponseEntity<MessageResponse> hello() {
        return ResponseEntity.ok(new MessageResponse("Hello World!"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<MessageResponse> adminPing() {
        return ResponseEntity.ok(new MessageResponse("Only Admins Can Read This"));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/admin-user")
    public ResponseEntity<MessageResponse> adminUserPing() {
        return ResponseEntity.ok(new MessageResponse("Only Admins and Users Can Read This"));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<MessageResponse> userPing() {
        return ResponseEntity.ok(new MessageResponse("Only Users Can Read This"));
    }

}
