package com.example.demo.service;

import com.example.demo.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {
    private final RestClient restClient;
    private final String url = "http://localhost:8088/api/posts";

    public PostService() {
        this.restClient = RestClient.create();
    }

    public PostResponse getPosts(Long postId) {
        PostResponse res = restClient.get()
                .uri(url + "/" + postId)
                .retrieve()
                .body(PostResponse.class);
        return res;
    }
}
