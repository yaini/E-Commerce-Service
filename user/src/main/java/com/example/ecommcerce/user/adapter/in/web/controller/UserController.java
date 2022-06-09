package com.example.ecommcerce.user.adapter.in.web.controller;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import com.example.ecommcerce.user.adapter.in.web.UserWebAdapter;
import com.example.ecommcerce.user.adapter.in.web.request.SaveUserRequest;
import com.example.ecommcerce.user.adapter.in.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserWebAdapter adapter;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> read(final @PathVariable("id") Long id){
        return ResponseEntity.ok(adapter.read(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> add(final SaveUserRequest request){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(adapter.add(request).getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
