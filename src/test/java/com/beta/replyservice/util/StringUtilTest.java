package com.beta.replyservice.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void testReverseString() {
        String result = StringUtil.reverseString("message");
        Assertions.assertEquals("egassem", result);
    }
}
