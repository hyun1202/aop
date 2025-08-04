package com.example.demo.service;

import com.example.demo.domain.Word;
import com.example.demo.mapper.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordMapper wordMapper;

    public Word findByUserAndWordBook(Long userId, Long wordBookId) {
        return wordMapper.findByUserAndWordBook(userId, wordBookId);
    }
}
