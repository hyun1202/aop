package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponse {
    private final Long postId;
    private final String nickname;
    private final String title;
    private final String content;
    private final String createTime;
    private final String updateTime;
}
