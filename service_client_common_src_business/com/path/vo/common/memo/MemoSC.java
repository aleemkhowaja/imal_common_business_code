package com.path.vo.common.memo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.struts2.lib.common.GridParamsSC;

public class MemoSC extends GridParamsSC
{

    private String appType;
    private BigDecimal cifNo;
    private BigDecimal trxType;
    private BigDecimal accBR;
    private BigDecimal accCY;
    private BigDecimal accGL;
    private BigDecimal accSL;
    private BigDecimal accCIF;
    private String forAccOrCif;
    private Date runningDate;
    private String langCode;
    private BigDecimal memoCode;
    private BigDecimal lovType;
    private String appName;
    private String progRef;
    private String ivCrud;
    private BigDecimal trxNo;
    private String type;
    private String fromScreen;
    private BigDecimal event;
    private String status;
    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    private String optRef;
    private Boolean reviewBtnEnabled = Boolean.TRUE;
    private Boolean checkConditionalAutomation = Boolean.TRUE;
    private Boolean showSpecialConditionMessage = Boolean.TRUE;
    // This attribute is used to display memo with code = 0 created from conditional automations
    private BigDecimal defaultTrxType = BigDecimal.ZERO;
    // Added skipAppName checking for show memo from all application TP 638896
    private String skipAppName;
    // IIAB120195 - iMAL Memo Alert
    List<MemoSC> memoList = new ArrayList<MemoSC>();
    
    //Bassam Eid - BUG# 681162
    private BigDecimal eventType;
    private BigDecimal cifAccNo;
    
    //habib accocunt restriction 372747
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int trxMgntNbRecords;
    private List<MemoCO> listRecords = new ArrayList<>();
    
    //////////////////////////
    
    //Rania - DB180100 - Customers Segmentation Enhancement
    private String forSegment;
    
	
    public BigDecimal getTrxNo()
    {
	return trxNo;
    }

    public void setTrxNo(BigDecimal trxNo)
    {
	this.trxNo = trxNo;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public String getAppType()
    {
	return appType;
    }

    public void setAppType(String appType)
    {
	this.appType = appType;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public BigDecimal getAccBR()
    {
	return accBR;
    }

    public void setAccBR(BigDecimal accBR)
    {
	this.accBR = accBR;
    }

    public BigDecimal getAccCY()
    {
	return accCY;
    }

    public void setAccCY(BigDecimal accCY)
    {
	this.accCY = accCY;
    }

    public BigDecimal getAccGL()
    {
	return accGL;
    }

    public void setAccGL(BigDecimal accGL)
    {
	this.accGL = accGL;
    }

    public BigDecimal getAccSL()
    {
	return accSL;
    }

    public void setAccSL(BigDecimal accSL)
    {
	this.accSL = accSL;
    }

    public BigDecimal getAccCIF()
    {
	return accCIF;
    }

    public void setAccCIF(BigDecimal accCIF)
    {
	this.accCIF = accCIF;
    }

    public String getForAccOrCif()
    {
	return forAccOrCif;
    }

    public void setForAccOrCif(String forAccOrCif)
    {
	this.forAccOrCif = forAccOrCif;
    }

    /**
     * @param runningDate the runningDate to set
     */
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    /**
     * @return the runningDate
     */
    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setMemoCode(BigDecimal memoCode)
    {
	this.memoCode = memoCode;
    }

    public BigDecimal getMemoCode()
    {
	return memoCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getFromScreen()
    {
	return fromScreen;
    }

    public void setFromScreen(String fromScreen)
    {
	this.fromScreen = fromScreen;
    }

    public BigDecimal getEvent()
    {
	return event;
    }

    public void setEvent(BigDecimal event)
    {
	this.event = event;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getOptRef()
    {
	return optRef;
    }

    public void setOptRef(String optRef)
    {
	this.optRef = optRef;
    }

    public Boolean getReviewBtnEnabled()
    {
	return reviewBtnEnabled;
    }

    public void setReviewBtnEnabled(Boolean reviewBtnEnabled)
    {
	this.reviewBtnEnabled = reviewBtnEnabled;
    }

    public Boolean getCheckConditionalAutomation()
    {
	return checkConditionalAutomation;
    }

    public void setCheckConditionalAutomation(Boolean checkConditionalAutomation)
    {
	this.checkConditionalAutomation = checkConditionalAutomation;
    }

    public Boolean getShowSpecialConditionMessage()
    {
	return showSpecialConditionMessage;
    }

    public void setShowSpecialConditionMessage(Boolean showSpecialConditionMessage)
    {
	this.showSpecialConditionMessage = showSpecialConditionMessage;
    }

    public BigDecimal getDefaultTrxType()
    {
	return defaultTrxType;
    }

    public void setDefaultTrxType(BigDecimal defaultTrxType)
    {
	this.defaultTrxType = defaultTrxType;
    }

    public List<MemoSC> getMemoList()
    {
	return memoList;
    }

    public void setMemoList(List<MemoSC> memoList)
    {
	this.memoList = memoList;
    }
    public String getSkipAppName()
    {
	return skipAppName;
    }
    public void setSkipAppName(String skipAppName)
    {
	this.skipAppName = skipAppName;
    }

    public BigDecimal getEventType()
    {
        return eventType;
    }

    public void setEventType(BigDecimal eventType)
    {
        this.eventType = eventType;
    }

    public BigDecimal getCifAccNo()
    {
        return cifAccNo;
    }

    public void setCifAccNo(BigDecimal cifAccNo)
    {
        this.cifAccNo = cifAccNo;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public String getErrType()
    {
        return errType;
    }

    public void setErrType(String errType)
    {
        this.errType = errType;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public BigDecimal getRtrnVal()
    {
        return rtrnVal;
    }

    public void setRtrnVal(BigDecimal rtrnVal)
    {
        this.rtrnVal = rtrnVal;
    }

    public BigDecimal getErrCode()
    {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
        this.errCode = errCode;
    }

    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public List<MemoCO> getListRecords()
    {
        return listRecords;
    }

    public void setListRecords(List<MemoCO> listRecords)
    {
        this.listRecords = listRecords;
    }
    
    public String getForSegment()
    {
        return forSegment;
    }

    public void setForSegment(String forSegment)
    {
        this.forSegment = forSegment;
    }
    

}
