package com.webpower.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.security.Init;
import com.webpower.entitys.SenderAddressInfo;

/**
 * REST API Util
 * 
 * @author Administrator
 * 
 */
public class WpSoapConfig {
	public static String access_token = "";
	public static String client_id = "";
	public static String client_secret = "";
	
	
	public static String baseUrl="https://wpsoap.webpower.asia/admin/api/index.php/rest/";
	public static String tokenUrl="https://wpsoap.webpower.asia/admin/oauth2/token.php";
	
	@SuppressWarnings("unchecked")
	public static void init(String client_id, String client_secret) {
		WpSoapConfig.client_id = client_id;
		WpSoapConfig.client_secret = client_secret;

		Map<String, String> map=new HashMap<String, String>();
		map.put("grant_type", "client_credentials");
		map.put("client_id",client_id);
		map.put("client_secret",client_secret);
		String resultString =HttpClientUtil.doPost("https://wpsoap.webpower.asia/admin/oauth2/token.php", map, false);
		map = JSON.parseObject(resultString, map.getClass());
		WpSoapConfig.access_token = map.get("access_token");
	}
}
