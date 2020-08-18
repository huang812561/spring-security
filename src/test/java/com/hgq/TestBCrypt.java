package com.hgq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @ClassName com.hgq.TestBCrypt
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 16:47
 * @Version: 1.0
 */
@SpringBootTest
public class TestBCrypt {

    @Test
    public void testBcrypt(){
        String password = "123";
        System.out.println(BCrypt.hashpw("123",BCrypt.gensalt()));
        String passwordCrypt = "$2a$10$i40HWgmhcg0AOPfQL8QfMuzlcqhNcDGMpLcdoQnp4WG4e8hTUTn1O";
        String passwordCrypt2 = "$2a$10$6TZB5SkSpLajvCgqUZ7Yu.Wk8Pkg28ViFD/vYMToO40b5OcQXtPbO";
        System.out.println(BCrypt.checkpw("123",passwordCrypt));
        System.out.println(BCrypt.checkpw("123",passwordCrypt2));
    }
}
