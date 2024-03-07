package com.beta.replyservice.service.impl;

import com.beta.replyservice.exception.ValidateException;
import com.beta.replyservice.service.ReplyService;
import com.beta.replyservice.util.HashUtil;
import com.beta.replyservice.util.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Qualifier("V2")
public class ReplyServiceV2 implements ReplyService {

    @Override
    public String generateReply(String message) {
        if (message.split("-").length < 2) {
            throw new ValidateException("Invalid input");
        }
        String[] arr = message.split("-");
        String rule = arr[0];
        message = arr[1];
        if (!StringUtils.hasLength(rule) || !StringUtils.hasLength(message)) {
            throw new ValidateException("Invalid input");
        }
        if (rule.length() != 2) {
            throw new ValidateException("Invalid input");
        }
        if (rule.charAt(0) != '1' && rule.charAt(0) != '2') {
            throw new ValidateException("Invalid input");
        }
        if (rule.charAt(1) != '1' && rule.charAt(1) != '2') {
            throw new ValidateException("Invalid input");
        }
        if (rule.charAt(0) == '1' && rule.charAt(1) == '1') {
            return message;
        } else if (rule.charAt(0) == '1' && rule.charAt(1) == '2') {
            String updatedMessage = StringUtil.reverseString(message);
            return HashUtil.getMd5Hash(updatedMessage);
        } else if (rule.charAt(0) == '2' && rule.charAt(1) == '2') {
            String updatedMessage = HashUtil.getMd5Hash(message);
            return HashUtil.getMd5Hash(updatedMessage);
        } else {
            String updatedMessage = HashUtil.getMd5Hash(message);
            return StringUtil.reverseString(updatedMessage);
        }
    }

}
