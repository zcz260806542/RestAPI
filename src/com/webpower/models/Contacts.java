package com.webpower.models;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.webpower.util.HttpClientUtil;
import com.webpower.util.WpSoapConfig;

public class Contacts {
	public static void send(Integer campaignId,Map map){
		String reString=HttpClientUtil.doPost(WpSoapConfig.baseUrl+campaignId+"/contacts/send", map,true);
		System.out.println(reString);
	}
}
