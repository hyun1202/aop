package com.example.demo.mapper;

import com.example.demo.domain.Word;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordMapper {
    Word findByUserAndWordBook(Long userId, Long wordBookId);
}
