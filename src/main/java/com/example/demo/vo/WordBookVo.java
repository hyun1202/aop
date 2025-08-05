package com.example.demo.vo;

import lombok.Getter;

import java.util.List;

/**
 * mybatis 매핑 시 reflection으로 매핑하므로 기본 생성자가 반드시 필요
 */
@Getter
public class WordBookVo {
    private Long wordBookId;
    private String name;
    private Long totalCount;
    private List<WordVo> words;
}
