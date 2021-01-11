package com.path.vo.core.accountcharges;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Hasan Youssef
 * 
 *          AccountChargesSC.java used to
 */
public class AccountChargesSC extends GridParamsSC
{
    private BigDecimal accBr;
    private BigDecimal accCy;
    private BigDecimal accGl;
    private BigDecimal accCif;
    private BigDecimal accSl;
    private String Status;
    private String ivCrud;
    private BigDecimal lovType;
    private String language;
    private String errorMessage;
    private String action;
    private String charge;
    private String errType;
    private BigDecimal errorCode;
    private String entityType;
    private String entityTypeCode;
    private BigDecimal entityLineNo;
    private String trxTypeCode;
    private BigDecimal entityCode;
    private String screenSrc;
    private String productType;
    private String productCode;
    private String chqbkIssueType;
    private BigDecimal chqbkType;
    private BigDecimal chqbkLeaves;
    private Date segStartDate;
    private ArrayList<String> listOfProductsNames = new ArrayList<String>();
    private BigDecimal cifNo;
    private BigDecimal segmentNo;
    
    
    private BigDecimal code;
    private String flagChange;
    
    
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getIvCrud() {
		return ivCrud;
	}
	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}
	public BigDecimal getLovType() {
		return lovType;
	}
	public void setLovType(BigDecimal lovType) {
		this.lovType = lovType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public BigDecimal getAccBr() {
		return accBr;
	}
	public void setAccBr(BigDecimal accBr) {
		this.accBr = accBr;
	}
	public BigDecimal getAccCy() {
		return accCy;
	}
	public void setAccCy(BigDecimal accCy) {
		this.accCy = accCy;
	}
	public BigDecimal getAccGl() {
		return accGl;
	}
	public void setAccGl(BigDecimal accGl) {
		this.accGl = accGl;
	}
	public BigDecimal getAccCif() {
		return accCif;
	}
	public void setAccCif(BigDecimal accCif) {
		this.accCif = accCif;
	}
	public BigDecimal getAccSl() {
		return accSl;
	}
	public void setAccSl(BigDecimal accSl) {
		this.accSl = accSl;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getErrType() {
		return errType;
	}
	public void setErrType(String errType) {
		this.errType = errType;
	}
	public BigDecimal getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(BigDecimal errorCode) {
		this.errorCode = errorCode;
	}
	/*public String getEntityType() {
		return entityType;
	}*/
	/*public void setEntityType(String entityType) {
		this.entityType = entityType;
	}*/
	public BigDecimal getEntityLineNo() {
		return entityLineNo;
	}
	public void setEntityLineNo(BigDecimal entityLineNo) {
		this.entityLineNo = entityLineNo;
	}
	public String getTrxTypeCode() {
		return trxTypeCode;
	}
	public void setTrxTypeCode(String trxTypeCode) {
		this.trxTypeCode = trxTypeCode;
	}
	public BigDecimal getCode() {
		return code;
	}
	public void setCode(BigDecimal code) {
		this.code = code;
	}
	public String getFlagChange() {
		return flagChange;
	}
	public void setFlagChange(String flagChange) {
		this.flagChange = flagChange;
	}
	public BigDecimal getEntityCode()
	{
	    return entityCode;
	}
	public void setEntityCode(BigDecimal entityCode)
	{
	    this.entityCode = entityCode;
	}
	public String getScreenSrc()
	{
	    return screenSrc;
	}
	public void setScreenSrc(String screenSrc)
	{
	    this.screenSrc = screenSrc;
	}
	public String getEntityTypeCode()
	{
	    return entityTypeCode;
	}
	public void setEntityTypeCode(String entityTypeCode)
	{
	    this.entityTypeCode = entityTypeCode;
	}
	public String getProductType()
	{
	    return productType;
	}
	public void setProductType(String productType)
	{
	    this.productType = productType;
	}
	public String getProductCode()
	{
	    return productCode;
	}
	public void setProductCode(String productCode)
	{
	    this.productCode = productCode;
	}
	public String getEntityType()
	{
	    return entityType;
	}
	public void setEntityType(String entityType)
	{
	    this.entityType = entityType;
	}
	public String getChqbkIssueType()
	{
	    return chqbkIssueType;
	}
	public void setChqbkIssueType(String chqbkIssueType)
	{
	    this.chqbkIssueType = chqbkIssueType;
	}
	public BigDecimal getChqbkType()
	{
	    return chqbkType;
	}
	public void setChqbkType(BigDecimal chqbkType)
	{
	    this.chqbkType = chqbkType;
	}
	public BigDecimal getChqbkLeaves()
	{
	    return chqbkLeaves;
	}
	public void setChqbkLeaves(BigDecimal chqbkLeaves)
	{
	    this.chqbkLeaves = chqbkLeaves;
	}
	public Date getSegStartDate()
	{
	    return segStartDate;
	}
	public void setSegStartDate(Date segStartDate)
	{
	    this.segStartDate = segStartDate;
	}
	public ArrayList<String> getListOfProductsNames()
	{
	    return listOfProductsNames;
	}
	public void setListOfProductsNames(ArrayList<String> listOfProductsNames)
	{
	    this.listOfProductsNames = listOfProductsNames;
	}
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	public BigDecimal getSegmentNo()
	{
	    return segmentNo;
	}
	public void setSegmentNo(BigDecimal segmentNo)
	{
	    this.segmentNo = segmentNo;
	}
}
