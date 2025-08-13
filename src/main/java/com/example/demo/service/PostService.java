package com.example.demo.service;

import com.example.demo.dto.PostResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Service
public class PostService {
    private final RestClient restClient;
    private final String url = "http://localhost:8088/api/posts";

    public PostService() {
        this.restClient = RestClient.create();
    }

    public PostResponse getPosts(Long postId) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        PostResponse res = restClient.get()
                .uri(url + "/" + postId)
                .header("User-Agent", httpServletRequest.getHeader("User-Agent"))
                .retrieve()
                .body(PostResponse.class);
        return res;
    }
}
