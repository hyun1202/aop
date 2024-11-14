package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    @Test
    void name() {
        String str = null;

        Optional.ofNullable(str)
                .map(s -> {
                    System.out.println(s);
                    return "hello";
                })
                .orElseGet(() -> {
                    System.out.println("hello");
                    return null;
                });

    }

    @Test
    void name1() {
        String a = null;

        List<String> list = new ArrayList<>();
        list.add(a);

        for (String str : list) {
            System.out.println(str);
        }
    }
}
