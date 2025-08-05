package com.example.demo.mapper;

import com.example.demo.vo.WordBookVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordMapper {
    WordBookVo findByUserAndWordBook(Long userId, Long wordBookId);
}
