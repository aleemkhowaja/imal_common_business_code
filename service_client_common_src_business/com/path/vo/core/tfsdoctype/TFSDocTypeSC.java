/**
 * 
 */
package com.path.vo.core.tfsdoctype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author MarwanMaddah
 * 
 */
public class TFSDocTypeSC extends GridParamsSC {
	private String userId;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String language;
	private BigDecimal code;
	private String docType;
	private String source; //added by rany for tpid:715911 called from schema screen

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public BigDecimal getCompCode() {
		return compCode;
	}

	@Override
	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	@Override
	public BigDecimal getBranchCode() {
		return branchCode;
	}

	@Override
	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
