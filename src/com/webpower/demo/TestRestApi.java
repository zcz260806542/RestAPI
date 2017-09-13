package com.webpower.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.webpower.entitys.SenderAddressInfo;
import com.webpower.models.Contacts;
import com.webpower.models.SenderAddress;
import com.webpower.util.HttpClientUtil;
import com.webpower.util.WpSoapConfig;

public class TestRestApi {
	
	public TestRestApi() {
		WpSoapConfig.init("c1d6303c9de737bc65f9", "28dc284defbe72d739765b6ed888cbf1f9a35a58");
	}
	
	public static void main(String[] args) {
		TestRestApi restApi=new TestRestApi();
		//get SenderAddresses
		//restApi.getSenderAddresses();
		//Create a new senderAddress, either an alias or forward
		//restApi.createSenderAddress();
		//restApi.send(); 
		
		//delete senderAddress
		restApi.deleteSenderAddress();
		
	}
	
	public void getSenderAddresses(){
		Integer page=1;
		Integer pagelength=100;
		List<SenderAddressInfo> addresses = SenderAddress.getSenderAddresses(page,pagelength);
		System.out.println(addresses);
	}
	
	public void createSenderAddress() {
		Map map=new HashMap();
		map.put("type", "alias");/**or forward*/
		map.put("alias_address", "user@example.com");
		map.put("sender_part", "");/**user*/
		map.put("local_domain", "");/**@example.com*/
		map.put("forward_address", "");/**user_forward@example.com*/
		SenderAddress.createSenderAddress(map);
	}
	
	public void deleteSenderAddress() {
		SenderAddress.deleteSenderAddress(195319);
	}
	
	public void send(){
//		{
//			  "mailingId": 1199,
//			  "groups": [
//			    70
//			  ],
//			  "overwrite": true,
//			  "addDuplicateToGroup": true,
//			  "contacts": [
//			    {
//			      "email": "ivan.ding@webpowerchina.com",
//			      "mobile_nr": "+86***********",
//			      "lang": "cn",
//			      "custom": [
//			        {
//			          "field": "testfield",
//			          "value": "string1231231"
//			        }
//			      ]
//			    }
//			  ]
//			}
		
		//联系人组
		List groups=new ArrayList();
		groups.add(70);
		
		//数据库字段
		List customs=new ArrayList();
		Map custom1 = new HashMap();
		custom1.put("field", "testfield");
		custom1.put("value", "对应DMD数据库字段");
		
//		Map custom2 = new HashMap();
//		custom2.put("field", "testfield");
//		custom2.put("value", "对应DMD数据库字段");
//		customs.add(custom2);
		customs.add(custom1);
		
		//发送到
		List contacts = new ArrayList();
		Map contact1 = new HashMap();
		contact1.put("email", "ivan.ding@webpowerchina.com");
		contact1.put("mobile_nr", "+8615570860105");
		contact1.put("lang", "cn");
		contact1.put("custom", customs);
//		Map contact2 = new HashMap();
//		contact2.put("email", "ivan.ding@webpowerchina.com");
//		contact2.put("mobile_nr", "+8615570860105");
//		contact2.put("lang", "cn");
//		contact2.put("custom", custom1);
		contacts.add(contact1);
		
		
		Map body =new HashMap();
		body.put("mailingId", 1199);
		body.put("groups", groups);
		body.put("overwrite", true);
		body.put("addDuplicateToGroup", true);
		body.put("contacts", contacts);
		
		//180 活动ID
		Contacts.send(180, body);
	}
}
