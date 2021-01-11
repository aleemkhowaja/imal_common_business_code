package com.path.vo.core.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * RetailBaseVO.java used to hold common Properties that are used in most of the classes in Retail Module CSM.
 */
public class RetailBaseVO extends BaseVO
{
    private String crud;// mode of Create update read delete
    private String appName; // application Name
    private String language; // language
    private String opt; // Opt Reference
    private String originOpt; // Opt Reference
    private BigDecimal loginCompCode;
    private BigDecimal loginBraCode;
    private String     loginUserId;
    private String     loginPassword; //Used for webservices
    private BigDecimal loginTellerCode;
    private String 	   loginPreferrredLanguage; // User preferred Language
    private BigDecimal originCompCode;//filled by loginCompCode in normal behavior, filled by the alert origin company in case of alert
    private BigDecimal originBraCode;//filled by loginBraCode in normal behavior, filled by the alert origin branch in case of alert
    private String     originUserId;//filled by loginUserId in normal behavior, filled by the alert origin userid in case of alert
    private BigDecimal originTellerCode;////filled by loginTellerCode in normal behavior, filled by the alert origin TellerCode in case of alert
    private Date       runningDate;//should be filled by running date sessionCO.getRunningDateRET()
    private BigDecimal baseCurrDecPoint;
    private String integAction; // Web Service Action
    private String channelId; // Web Service Channel
    private String versionCode; // Web Service version
    public String getCrud()
    {
        return crud;
    }
    public void setCrud(String crud)
    {
        this.crud = crud;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public String getOpt()
    {
        return opt;
    }
    public void setOpt(String opt)
    {
        this.opt = opt;
    }
    public BigDecimal getLoginCompCode()
    {
        return loginCompCode;
    }
    public void setLoginCompCode(BigDecimal loginCompCode)
    {
        this.loginCompCode = loginCompCode;
    }
    public BigDecimal getLoginBraCode()
    {
        return loginBraCode;
    }
    public void setLoginBraCode(BigDecimal loginBraCode)
    {
        this.loginBraCode = loginBraCode;
    }
    public String getLoginUserId()
    {
        return loginUserId;
    }
    public void setLoginUserId(String loginUserId)
    {
        this.loginUserId = loginUserId;
    }
    public BigDecimal getLoginTellerCode()
    {
        return loginTellerCode;
    }
    public void setLoginTellerCode(BigDecimal loginTellerCode)
    {
        this.loginTellerCode = loginTellerCode;
    }
    public BigDecimal getOriginCompCode()
    {
	if ((NumberUtil.nullToZero(originCompCode)).equals(BigDecimal.ZERO))
	{
	    originCompCode = loginCompCode;
	}
        return originCompCode;
    }
    public void setOriginCompCode(BigDecimal originCompCode)
    {
        this.originCompCode = originCompCode;
    }
    public BigDecimal getOriginBraCode()
    {
	if ((NumberUtil.nullToZero(originBraCode)).equals(BigDecimal.ZERO))
	{
	    originBraCode = loginBraCode;
	}
        return originBraCode;
    }
    public void setOriginBraCode(BigDecimal originBraCode)
    {
        this.originBraCode = originBraCode;
    }
    public String getOriginUserId()
    {
	if ((StringUtil.nullToEmpty(originUserId)).equals(""))
	{
	    originUserId = loginUserId;
	}
        return originUserId;
    }
    public void setOriginUserId(String originUserId)
    {
        this.originUserId = originUserId;
    }
    public BigDecimal getOriginTellerCode()
    {
	if ((NumberUtil.nullToZero(originTellerCode)).equals(BigDecimal.ZERO))
	{
	    originTellerCode = loginTellerCode;
	}
        return originTellerCode;
    }
    public void setOriginTellerCode(BigDecimal originTellerCode)
    {
        this.originTellerCode = originTellerCode;
    }
    public Date getRunningDate()
    {
        return runningDate;
    }
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getLoginPreferrredLanguage()
    {
	return loginPreferrredLanguage;
    }

    public void setLoginPreferrredLanguage(String loginPreferrredLanguage)
    {
	this.loginPreferrredLanguage = loginPreferrredLanguage;
    }

    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public String getOriginOpt()
    {
        return originOpt;
    }

    public void setOriginOpt(String originOpt)
    {
	this.originOpt = originOpt;
    }

    public String getIntegAction()
    {
	return integAction;
    }

    public void setIntegAction(String integAction)
    {
	this.integAction = integAction;
    }

    public String getChannelId()
    {
	return channelId;
    }

    public void setChannelId(String channelId)
    {
	this.channelId = channelId;
    }

    public String getVersionCode()
    {
	return versionCode;
    }

    public void setVersionCode(String versionCode)
    {
	this.versionCode = versionCode;
    }
    public String getLoginPassword() {
	return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
    }
}
