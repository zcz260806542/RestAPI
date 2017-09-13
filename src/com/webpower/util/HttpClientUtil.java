package com.webpower.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.Header;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {
	public static String doPost(String url, Map<String, String> map,
			boolean isJson) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			if(map!=null)
				if (!isJson) {
					List<NameValuePair> list = new ArrayList<NameValuePair>();
					Iterator iterator = map.entrySet().iterator();
					while (iterator.hasNext()) {
						Entry elem = (Entry) iterator.next();
						list.add(new BasicNameValuePair(elem.getKey().toString(),
								elem.getValue().toString()));
					}
					if (list.size() > 0) {
						UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
								list, "utf-8");
						httpPost.setEntity(entity);
					}
				} else {
					StringEntity s = new StringEntity(JSON.toJSONString(map),
							"utf-8");
					s.setContentType("application/json");
					httpPost.setEntity(s);
				}

			httpPost.setHeader("Authorization", "Bearer "
					+ WpSoapConfig.access_token);
			// 请求
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static String doGet(String url, Map map) {
		HttpClient httpClient = null;
		HttpGet  httpGet = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpGet = new HttpGet(url);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			if(map!=null)
				for (Object key : map.keySet()) {
					params.add(new BasicNameValuePair(key.toString(), map.get(key).toString()));
				}
				if(params.size()>0){
					String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "utf-8"));  
					url+="?"+str;
				}

			httpGet.setHeader("Authorization", "Bearer "
					+ WpSoapConfig.access_token);
			// 请求
			HttpResponse response = httpClient.execute(httpGet);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static String doPut(String url, Map<String, String> map,
			boolean isJson) {
		HttpClient httpClient = null;
		HttpPut httpPut = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPut = new HttpPut(url);
			if(map!=null)
				if (!isJson) {
					List<NameValuePair> list = new ArrayList<NameValuePair>();
					Iterator iterator = map.entrySet().iterator();
					while (iterator.hasNext()) {
						Entry elem = (Entry) iterator.next();
						list.add(new BasicNameValuePair(elem.getKey().toString(),
								elem.getValue().toString()));
					}
					if (list.size() > 0) {
						UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
								list, "utf-8");
						httpPut.setEntity(entity);
					}
				} else {
					StringEntity s = new StringEntity(JSON.toJSONString(map),
							"utf-8");
					s.setContentType("application/json");
					httpPut.setEntity(s);
				}

			httpPut.setHeader("Authorization", "Bearer "
					+ WpSoapConfig.access_token);
			// 请求
			HttpResponse response = httpClient.execute(httpPut);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	
	public static String doDelete(String url, Map map) {
		HttpClient httpClient = null;
		HttpDelete  httpDelete = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpDelete = new HttpDelete(url);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			if(map!=null)
				for (Object key : map.keySet()) {
					params.add(new BasicNameValuePair(key.toString(), map.get(key).toString()));
				}
				if(params.size()>0){
					String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "utf-8"));  
					url+="?"+str;
				}

			httpDelete.setHeader("Authorization", "Bearer "
					+ WpSoapConfig.access_token);
			// 请求
			HttpResponse response = httpClient.execute(httpDelete);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	
	
}
