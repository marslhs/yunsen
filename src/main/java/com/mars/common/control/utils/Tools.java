package com.mars.common.control.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sword.lang.JaxbParser;
import org.sword.lang.StreamUtils;
import org.sword.wechat4j.request.WechatRequest;
public class Tools {
    private static Logger logger = LoggerFactory.getLogger(Tools.class);
    
    public static String sha1Hex(String decript) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            logger.warn("sha1Hex-> meet exception when sha1Hex", e);
        }
        return "";
    }
    
    public static WechatRequest getWeinParameter(HttpServletRequest request){
        WechatRequest wechatRequest = null;
        try {
             String postDataStr = StreamUtils.streamToString(request.getInputStream());
             JaxbParser jaxbParser = new JaxbParser(WechatRequest.class);
             wechatRequest = (WechatRequest)jaxbParser.toObj(postDataStr);
        } catch (IOException e) {
            logger.error("post data deal failed!");
            e.printStackTrace();
        }
        return wechatRequest;
    }
    
}
