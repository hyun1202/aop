package com.example.demo.service;

import com.example.demo.mapper.WordMapper;
import com.example.demo.vo.WordBookVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordMapper wordMapper;

    public WordBookVo findByUserAndWordBook(Long userId, Long wordBookId) {
        WordBookVo result = wordMapper.findByUserAndWordBook(userId, wordBookId);
        return result;
    }
}
