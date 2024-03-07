package com.beta.replyservice.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashUtilTest {

    @Test
    void testGetMd5Hash() {
        String result = HashUtil.getMd5Hash("test-message");
        Assertions.assertEquals("beaa0032306f083e847cbf86a09ba9b2", result);
    }
}
