package com.example.demo.controller;

import com.example.demo.domain.Word;
import com.example.demo.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/api/v1/word")
    public Word getWord(
            @RequestParam("userId") Long userId,
            @RequestParam("wordBookId") Long wordBookId
    ) {
        return wordService.findByUserAndWordBook(userId, wordBookId);
    }
}
