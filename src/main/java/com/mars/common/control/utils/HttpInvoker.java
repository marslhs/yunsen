package com.mars.common.control.utils;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mars.common.control.global.impl.GlobalConfig;
import com.mars.common.global.constant.HttpMethodEnum;
import com.mars.common.global.constant.WeixinConst;
/**
 * http方法的调用类。 
 * @author hosen.lhs
 *
 */
public class HttpInvoker {
	public static final Logger logger = LoggerFactory.getLogger(HttpInvoker.class);
	/**
	 * post 方法。 
	 * @param targetURL 调用的目标url。 
	 * @return
	 */
	public static String post(String targetURL) {
		HttpMethodBase method = null;
		try {
			HttpClient client = new HttpClient();
			method = new PostMethod(targetURL);

			byte[] array1 = getContent(client, method);
			String result = new String(array1, "UTF-8");
			return result;
		} catch (Exception e) {
			logger.warn("post method error", e);
			return null;
		}finally{
			if(method != null){
				method.releaseConnection();
			}
		}

	}
	/**
     * get 方法。 
     * @param targetURL 调用的目标url。 
     * @return
     */
	public static String get(String targetURL) {
		HttpMethodBase method = null;
		try {
			HttpClient client = new HttpClient();
			method = new GetMethod(targetURL);

			byte[] array1 = getContent(client, method);
			String result = new String(array1, "UTF-8");
			return result;
		} catch (Exception e) {
			logger.warn("post method error", e);
			return null;
		}finally{
			if(method != null){
				method.releaseConnection();
			}
		}

	}
	public static String getWithToken(String urlWithoutToken){
	    return invokeWithToken(urlWithoutToken, HttpMethodEnum.Get);
	}
	
	public static String postWithToken(String urlWithoutToken){
        return invokeWithToken(urlWithoutToken, HttpMethodEnum.Post);
    }
	
	
	/**
	 * 根据没有token的url， 进行调用微信的方法。
	 * token主要通过全局变量获取。 
	 * @param urlWithoutToken
	 * @param method
	 * @return
	 */
	private static String invokeWithToken(String urlWithoutToken, HttpMethodEnum method){
	    String targetUrl = getTargetUrl(urlWithoutToken);
	    String result = invokeImpl(targetUrl, method);
	    JSONObject jsonResult = JSON.parseObject(result);
	    Integer code = jsonResult.getInteger(WeixinConst.ErrorCodeKey);
	    //token失效， 需要刷新token。 
	    if(isTokenInvalid(code)){
	        logger.warn("token is invalid: " + GlobalConfig.getToken());
	        GlobalConfig.refreshToken();
	        return invokeImpl(targetUrl, method);
	    }
	    return result;
	}
	
	private static String invokeImpl(String targetUrl, HttpMethodEnum method){
	    String result = null;
	    switch (method) {
            case Get:
                result = get(targetUrl);
                break;
            case Post:
                result = post(targetUrl);
                break;
            default:
                logger.debug("unsupport http method: " + method);
                break;
        }
	    return result;
	}
	
	/**
	 * 通过调用的错误码检测token是不是不合法。 
	 * 比如： token过期。
	 * @param code
	 * @return
	 */
	private static boolean isTokenInvalid(Integer code){
	    return code != null && code.intValue() == WeixinConst.TOKEN_EXPIRED;
	}
	
    private static String getTargetUrl(String urlWithoutToken){
        return new StringBuilder(urlWithoutToken).append("&").append(WeixinConst.AccessTokenKey).append("=").append(GlobalConfig.getToken()).toString();
    }
	
	private static byte[] getContent(HttpClient client, HttpMethodBase method)
			throws Exception {
		client.executeMethod(method);

		InputStream input = method.getResponseBodyAsStream();

		int length = input.available();
		byte[] array = new byte[length];
		input.read(array);

		input.close();
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(post("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe2ddd86f6e5138f7&secret=79a7df5812628485e4b5454b9d751e2e"));
	}

}
