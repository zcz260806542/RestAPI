package com.webpower.models;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.webpower.entitys.SenderAddressInfo;
import com.webpower.util.HttpClientUtil;
import com.webpower.util.WpSoapConfig;

public class SenderAddress {

	/** 获取SenderAddress集合
	 * page integer (query)    Which page to retrieve
	 * pagelength integer (query)   The amount of records per page
	 * @param page
	 * @param pagelength
	 * @return List<SenderAddress> 
	 */
	public static List<SenderAddressInfo> getSenderAddresses(Integer page,Integer pagelength) {
		List<SenderAddressInfo> addresses=null;
		try {
			Map paramMap=new HashMap();
			paramMap.put("page",page);
			paramMap.put("pagelength", pagelength);
			String resultString = HttpClientUtil.doGet(WpSoapConfig.baseUrl+"senderAddress", paramMap);
			
			Map<String, List<SenderAddressInfo>> map=new HashMap<String, List<SenderAddressInfo>>();  
			map=JSON.parseObject(resultString, map.getClass());
			addresses=map.get("result");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}
	
	/** 创建SenderAddress
	 * senderAddress{
		type:	string *Enum:
		[ alias, forward ]
		alias_address:	string ($email)
		Required if type is 'alias'
		sender_part:	string
		Required if type is 'forward'
		local_domain:	string
		Required if type is 'forward'
		forward_address:	string ($email)
		Required if type is 'forward'
		}
	 * @param senderAddress
	 */
	public static void createSenderAddress(Map map) {
		String resultString = HttpClientUtil.doPost(WpSoapConfig.baseUrl+"senderAddress",map,true);
		System.err.println(resultString);
	}
	
	public static void deleteSenderAddress(Integer id) {
		String resultString = HttpClientUtil.doDelete(WpSoapConfig.baseUrl+"senderAddress/"+id,null);
		System.err.println(resultString);
	}
}
