package com.mars.common.control.global.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mars.common.control.global.constant.GlobalConst;
import com.mars.common.control.global.constant.WeixinConst;
import com.mars.common.control.utils.HttpInvoker;
import com.mars.common.control.utils.WeixinUtil;

public class GlobalConfig {

    private static Logger logger           = LoggerFactory.getLogger(GlobalConfig.class);

    private static String token            = null;
    private static long   refreshTokenTime = 0L;
    public static long    tokenExpiredIn   = 7200000L;

    private static String jsapiTicket      = null;
    private static long   refreshTickTime  = 0L;
    public static long    ticketExpiredIn  = 7200000L;

    public static boolean refreshToken() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - refreshTokenTime) > tokenExpiredIn) {
            String getTokenUrl = GlobalConst.WEIXIN_SERVER + "cgi-bin/token?grant_type=client_credential&appid="
                                 + GlobalConst.AppID + "&secret=" + GlobalConst.AppSecret;
            String result = HttpInvoker.get(getTokenUrl);
            JSONObject json = JSON.parseObject(result);
            token = json.getString(WeixinConst.AccessTokenKey);
            tokenExpiredIn = json.getLong(WeixinConst.ExpiredInKey) * 1000;
            refreshTokenTime = System.currentTimeMillis();
            if (WeixinUtil.hasErrorCode(json)) {
                logger.error("refresh token error:");
                return false;
            }
            return true;
        }
        if (refreshTokenTime > 0) {
            return true;
        }
        logger.error("refresh token error, as no refresh time.");
        return false;
    }

    public static boolean refreshJsTicket() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - refreshTickTime) > ticketExpiredIn) {
            String url = GlobalConst.WEIXIN_SERVER + "cgi-bin/ticket/getticket?type=jsapi";
            String result = HttpInvoker.getWithToken(url);
            JSONObject json = JSON.parseObject(result);
            jsapiTicket = json.getString(WeixinConst.JsApiTicketKey);
            ticketExpiredIn = json.getLong(WeixinConst.ExpiredInKey) * 1000;
            refreshTickTime = System.currentTimeMillis();
            if (WeixinUtil.hasErrorCode(json)) {
                logger.error("refresh ticket error:");
                return false;
            }
            return true;
        }
        if (refreshTickTime > 0) {
            return true;
        }
        logger.error("refresh ticket error, as no refresh ticket time.");
        return false;
    }

    public static String getToken() {
        if (token == null) {
            refreshToken();
        }
        return token;
    }
    public static String getJsTicket() {
        if (jsapiTicket == null) {
            refreshJsTicket();
        }
        return jsapiTicket;
    }

}
