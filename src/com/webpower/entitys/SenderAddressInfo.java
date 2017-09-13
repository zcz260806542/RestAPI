package com.webpower.entitys;

public class SenderAddressInfo {
	int id;
	String type="alias";
	String alias_address;
	String sender_part="string";
	String local_domain="string";
	String forward_address;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAlias_address() {
		return alias_address;
	}
	public void setAlias_address(String aliasAddress) {
		alias_address = aliasAddress;
	}
	public String getSender_part() {
		return sender_part;
	}
	public void setSender_part(String senderPart) {
		sender_part = senderPart;
	}
	public String getLocal_domain() {
		return local_domain;
	}
	public void setLocal_domain(String localDomain) {
		local_domain = localDomain;
	}
	public String getForward_address() {
		return forward_address;
	}
	public void setForward_address(String forwardAddress) {
		forward_address = forwardAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SenderAddressInfo() {
	}
	public SenderAddressInfo(String type, String aliasAddress, String senderPart,
			String localDomain, String forwardAddress) {
		super();
		this.type = type;
		alias_address = aliasAddress;
		sender_part = senderPart;
		local_domain = localDomain;
		forward_address = forwardAddress;
	}
	public SenderAddressInfo(int id, String type, String aliasAddress,
			String senderPart, String localDomain, String forwardAddress) {
		super();
		this.id = id;
		this.type = type;
		alias_address = aliasAddress;
		sender_part = senderPart;
		local_domain = localDomain;
		forward_address = forwardAddress;
	}
}
