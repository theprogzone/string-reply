package com.beta.replyservice.service.impl;

import com.beta.replyservice.exception.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplyServiceV2Test {

    ReplyServiceV2 replyServiceV2 = new ReplyServiceV2();

    @Test
    void testGenerateReplyInvalidLength() {
        Assertions.assertThrows(ValidateException.class, ()->replyServiceV2.generateReply("message"));
    }

    @Test
    void testGenerateReplyEmptyRuleAndMessage() {
        Assertions.assertThrows(ValidateException.class, ()->replyServiceV2.generateReply("-"));
    }

    @Test
    void testGenerateReplyInvalidRuleLength() {
        Assertions.assertThrows(ValidateException.class, ()->replyServiceV2.generateReply("1-message"));
    }

    @Test
    void testGenerateReplyInvalidRuleFirstValue() {
        Assertions.assertThrows(ValidateException.class, ()->replyServiceV2.generateReply("32-message"));
    }

    @Test
    void testGenerateReplyInvalidRuleSecondValue() {
        Assertions.assertThrows(ValidateException.class, ()->replyServiceV2.generateReply("14-message"));
    }

    @Test
    void testGenerateReplyBothRuleValues1() {
        String result = replyServiceV2.generateReply("11-message");
        Assertions.assertEquals("message", result);
    }

    @Test
    void testGenerateReplyRuleValues12() {
        String result = replyServiceV2.generateReply("12-message");
        Assertions.assertEquals("4566639776a73c8b533964bf2030b170", result);
    }

    @Test
    void testGenerateReplyRuleValues22() {
        String result = replyServiceV2.generateReply("22-message");
        Assertions.assertEquals("cb5892023c894331a55de5ac7f64582d", result);
    }

    @Test
    void testGenerateReplyRuleValues21() {
        String result = replyServiceV2.generateReply("21-message");
        Assertions.assertEquals("3b36a9c7b043246de05df8d720137e87", result);
    }
}
