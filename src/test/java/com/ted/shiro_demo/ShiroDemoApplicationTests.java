package com.ted.shiro_demo;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemoApplicationTests {

    @Test
    void contextLoads() {
        Md5Hash m = new Md5Hash("wmz","666",4);
        System.out.println(m);
    }

}
