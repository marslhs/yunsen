package com.mars.common.control.global.constant;

public interface WeixinConst {
    // access_token超时，请检查access_token的有效期，请参考基础支持-获取access_token中，对access_token的详细机制说明
    int    TOKEN_EXPIRED  = 42001;         

    // 错误码对应的key值。
    String ErrorCodeKey   = "errcode";
    // token对应的key值。
    String AccessTokenKey = "access_token";
    //jsticket key 
    String JsApiTicketKey = "ticket";
    String ExpiredInKey   = "expires_in";
    
}
