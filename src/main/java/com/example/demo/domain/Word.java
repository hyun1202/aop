package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Word {
    private String wordId;
    private String word;
    private String mean;
    private Long userId;
    private Long folderId;
}
