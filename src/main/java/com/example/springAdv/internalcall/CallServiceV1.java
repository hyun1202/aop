package com.example.springAdv.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

//    private CallServiceV1 callServiceV1;
//
//    // 생성자 주입은 순환참조 문제가 있어 사용할 수 없음
//    // 특정 버전 이후로 순환참조는 아예 막힘
//    @Autowired
//    public void setCallServiceV1(CallServiceV1 callServiceV1) {
//        this.callServiceV1 = callServiceV1;
//    }

    public void external() {
        log.info("call external");
//        callServiceV1.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
