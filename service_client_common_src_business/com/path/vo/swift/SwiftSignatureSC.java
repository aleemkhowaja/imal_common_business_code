package com.path.vo.swift;

public class SwiftSignatureSC {
	
	private String content;
	private String keyStoreFileName;
	private String keyStorePassword;
	private String keyAlias;
	private String signed;
	
	private int olErrorCode;
	private String osErrorDesc;
	
	private String digitalSignature;
	
	
	
	public String getDigitalSignature() {
		return digitalSignature;
	}
	public void setDigitalSignature(String digitalSignature) {
		this.digitalSignature = digitalSignature;
	}
	public int getOlErrorCode() {
		return olErrorCode;
	}
	public void setOlErrorCode(int olErrorCode) {
		this.olErrorCode = olErrorCode;
	}
	public String getOsErrorDesc() {
		return osErrorDesc;
	}
	public void setOsErrorDesc(String osErrorDesc) {
		this.osErrorDesc = osErrorDesc;
	}
	public String getSigned() {
		return signed;
	}
	public void setSigned(String signed) {
		this.signed = signed;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyStoreFileName() {
		return keyStoreFileName;
	}
	public void setKeyStoreFileName(String keyStoreFileName) {
		this.keyStoreFileName = keyStoreFileName;
	}
	public String getKeyStorePassword() {
		return keyStorePassword;
	}
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	
	

}