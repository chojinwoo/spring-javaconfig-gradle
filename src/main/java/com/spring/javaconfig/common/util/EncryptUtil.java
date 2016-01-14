package com.spring.javaconfig.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

/**
 * Created by bangae1 on 2016-01-13.
 */
public class EncryptUtil {
    public static String encrypt(String pwd) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        return b.encode(pwd);
    }
}
