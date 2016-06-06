package com.mars.common.control.global.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.sword.wechat4j.jsapi.JsApiManager;
import org.sword.wechat4j.jsapi.JsApiParam;

public class SignUtils {
    public static Logger logger = LoggerFactory.getLogger(SignUtils.class);
    
//    public static String getUrl() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        StringBuffer requestUrl = request.getRequestURL();
//        String queryString = request.getQueryString();
//        String url = requestUrl + "?" + queryString;
//        return url;
//    }
    
    public static ModelAndView signModelAndView(HttpServletRequest request){
        String url = SignUtils.getUrl(request);
        JsApiParam signParam = JsApiManager.signature(url);
        ModelAndView mv = new ModelAndView();
        mv.addObject("signature", signParam);
        return mv;
    }
//    
    private static String getUrl(HttpServletRequest request){
        StringBuffer requestUrl = request.getRequestURL();
        String queryString = request.getQueryString();
        String url = requestUrl.toString();
        if(queryString != null){
            url = requestUrl.toString() + "?" + queryString;
        }
        return url;
    }

//    public static Map<String, String> sign(String jsapiTicket, String url) {
//        Map<String, String> ret = new HashMap<String, String>();
//        String nonce_str = create_nonce_str();
//        String timestamp = create_timestamp();
//        String string1;
//        String signature = "";
//
//        // 注意这里参数名必须全部小写，且必须有序
//        string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
//
//        try {
//            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//            crypt.reset();
//            crypt.update(string1.getBytes("UTF-8"));
//            signature = byteToHex(crypt.digest());
//        } catch (Exception e) {
//            logger.error("meet exception when sign.", e);
//        }
//
//        ret.put("url", url);
//        ret.put("jsapi_ticket", jsapiTicket);
//        ret.put("nonceStr", nonce_str);
//        ret.put("timestamp", timestamp);
//        ret.put("signature", signature);
//
//        return ret;
//    }
//
//    private static String byteToHex(final byte[] hash) {
//        Formatter formatter = new Formatter();
//        for (byte b : hash) {
//            formatter.format("%02x", b);
//        }
//        String result = formatter.toString();
//        formatter.close();
//        return result;
//    }
//
//    private static String create_nonce_str() {
//        return UUID.randomUUID().toString();
//    }
//
//    private static String create_timestamp() {
//        return Long.toString(System.currentTimeMillis() / 1000);
//    }
//    
//    public static JsApiParam signature(String jsapiTicket, String timestamp, String nonceStr, String url) {
//        StringBuffer signatureSource = new StringBuffer();
//        signatureSource.append("jsapi_ticket=").append(jsapiTicket);
//        signatureSource.append("&noncestr=").append(nonceStr);
//        signatureSource.append("&timestamp=").append(timestamp);
//        signatureSource.append("&url=").append(url);
//        logger.info("sign source : " + signatureSource);
//        String signature = DigestUtils.sha1Hex(signatureSource.toString());
//        logger.info("sign : " + signature);
//        return new JsApiParam(url, jsapiTicket, nonceStr, timestamp, signature);
//    }
//    
//    public static void main(String[] args) {
//        System.out.println(signature("kgt8ON7yVITDhtdwci0qeTNVjIdhkDgkZJrMDcH9rkKJLQ-uT2GUOUQ4uejvs_4l-jVnALMV0yCCKYoftkhKEw", "1465094199", "pezcp56uwxqsl4cg31gfn7vthfdbv50k", "http://www.yunsensz.com/yunsen/dingshui"));
//    }
}
