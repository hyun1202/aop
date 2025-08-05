package com.example.demo.controller;

import com.example.demo.dto.PostResponse;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/api/v1/post")
    public ResponseEntity<PostResponse> getPosts(
            @RequestParam("postId") Long postId
    ) {
        return ResponseEntity.ok(postService.getPosts(postId));
    }
}
