package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.dbmaps.vo.CTS_BLACKLIST_LOGVO;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.core.common.RetailBaseVO;

public class BlackListLogCO extends RetailBaseVO
{

    private CTS_BLACKLIST_LOGVO ctsBlackListLogVO = new CTS_BLACKLIST_LOGVO();
    private String blackListLogCOsStr;
    private ArrayList<BlackListLogCO> blackListLog  = new ArrayList<BlackListLogCO>();
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String userId;
    private BigDecimal todoParam;
    private String appName;
    private Date runningDate;
    private BigDecimal entityNo;
    private String trsType;
    private String cbInd;

    //added by rany for tpid:514489-SBI170088 tfa blacklist checking
    private String entityTypeDesc;
    private BigDecimal trxNbr;
    private String entityType;//kept in case used by other systems
    //added by bilal for TP#885556
    private BigDecimal blackListCode;
    private String blackListName;
    private BigDecimal blackListSourceCode;
    private String blackListSourceName;
    private String cifNameArab;
    private BigDecimal documentNbr;
    private Date dateTurnedBlackList;
    private String nationality;
    private String passportNo;
    private Date dateOfBirth;
    //end bilal

    
    public CTS_BLACKLIST_LOGVO getCtsBlackListLogVO()
    {
        return ctsBlackListLogVO;
    }

    public void setCtsBlackListLogVO(CTS_BLACKLIST_LOGVO ctsBlackListLogVO)
    {
        this.ctsBlackListLogVO = ctsBlackListLogVO;
    }

    public String getBlackListLogCOsStr()
    {
        return blackListLogCOsStr;
    }

    public void setBlackListLogCOsStr(String blackListLogCOsStr)
    {
        this.blackListLogCOsStr = blackListLogCOsStr;
    }

    public ArrayList<BlackListLogCO> getBlackListLog()
    {
        return blackListLog;
    }

    public void setBlackListLog(ArrayList<BlackListLogCO> blackListLog)
    {
        this.blackListLog = blackListLog;
    }

    public BigDecimal getCompCode()
    {
        return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public BigDecimal getTodoParam()
    {
        return todoParam;
    }

    public void setTodoParam(BigDecimal todoParam)
    {
        this.todoParam = todoParam;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public BigDecimal getEntityNo()
    {
        return entityNo;
    }

    public void setEntityNo(BigDecimal entityNo)
    {
        this.entityNo = entityNo;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public BigDecimal getTrxNbr()
    {
	return trxNbr;
    }

    public void setTrxNbr(BigDecimal trxNbr)
    {
	this.trxNbr = trxNbr;
    }

    public String getEntityTypeDesc()
    {
        return entityTypeDesc;
    }

    public void setEntityTypeDesc(String entityTypeDesc)
    {
        this.entityTypeDesc = entityTypeDesc;
    }

    public BigDecimal getBlackListCode()
    {
	return blackListCode;
    }

    public void setBlackListCode(BigDecimal blackListCode)
    {
	this.blackListCode = blackListCode;
    }

    public String getBlackListName()
    {
	return blackListName;
    }

    public void setBlackListName(String blackListName)
    {
	this.blackListName = blackListName;
    }

    public BigDecimal getBlackListSourceCode()
    {
	return blackListSourceCode;
    }

    public void setBlackListSourceCode(BigDecimal blackListSourceCode)
    {
	this.blackListSourceCode = blackListSourceCode;
    }

    public String getBlackListSourceName()
    {
	return blackListSourceName;
    }

    public void setBlackListSourceName(String blackListSourceName)
    {
	this.blackListSourceName = blackListSourceName;
    }

    public String getCifNameArab()
    {
	return cifNameArab;
    }

    public void setCifNameArab(String cifNameArab)
    {
	this.cifNameArab = cifNameArab;
    }

    public BigDecimal getDocumentNbr()
    {
	return documentNbr;
    }

    public void setDocumentNbr(BigDecimal documentNbr)
    {
	this.documentNbr = documentNbr;
    }

    public Date getDateTurnedBlackList()
    {
	return dateTurnedBlackList;
    }

    public void setDateTurnedBlackList(Date dateTurnedBlackList)
    {
	this.dateTurnedBlackList = dateTurnedBlackList;
    }

    public String getNationality()
    {
	return nationality;
    }

    public void setNationality(String nationality)
    {
	this.nationality = nationality;
    }

    public String getPassportNo()
    {
	return passportNo;
    }

    public void setPassportNo(String passportNo)
    {
	this.passportNo = passportNo;
    }

    public Date getDateOfBirth()
    {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
	this.dateOfBirth = dateOfBirth;
    }

}
