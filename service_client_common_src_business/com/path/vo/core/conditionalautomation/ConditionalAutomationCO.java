/**
 * 
 */
package com.path.vo.core.conditionalautomation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation 
 * ConditionalAutomationCO.java used to
 */
public class ConditionalAutomationCO extends RetailBaseVO
{
    private static final long serialVersionUID = 1L;
    private BigDecimal cifNO;
    private BigDecimal cifType;
    //private String actionStr;
    private Date startDate;
    private Date endDate;
    private Boolean showSpecialConditionMessage = Boolean.TRUE;
    private Integer actionFlag; 
    private String forbidTrx;
    private BigDecimal reasonCode;
    private BigDecimal administration;
    private String recordSource;
    private String reference;
    private BigDecimal condAutCode;
    private BigDecimal errorCode;
    private String errorMessage;
    private String warningMessages;
    
    private BigDecimal compCodeCif;
    
    private BigDecimal id_type;
    private String id_no;
    
    public BigDecimal getId_type()
    {
	return id_type;
    }

    public void setId_type(BigDecimal id_type)
    {
	this.id_type = id_type;
    }

    public String getId_no()
    {
	return id_no;
    }

    public void setId_no(String id_no)
    {
	this.id_no = id_no;
    }

    public BigDecimal getCifNO()
    {
        return cifNO;
    }
    public void setCifNO(BigDecimal cifNO)
    {
        this.cifNO = cifNO;
    }
    public BigDecimal getCifType()
    {
        return cifType;
    }
    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }
//    public String getActionStr()
//    {
//        return actionStr;
//    }
//    public void setActionStr(String actionStr)
//    {
//        this.actionStr = actionStr;
//    }
    public Date getStartDate()
    {
        return startDate;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public Date getEndDate()
    {
        return endDate;
    }
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Boolean getShowSpecialConditionMessage()
    {
        return showSpecialConditionMessage;
    }
    public void setShowSpecialConditionMessage(Boolean showSpecialConditionMessage)
    {
        this.showSpecialConditionMessage = showSpecialConditionMessage;
    }
    public Integer getActionFlag()
    {
        return actionFlag;
    }
    public void setActionFlag(Integer actionFlag)
    {
        this.actionFlag = actionFlag;
    }
    public String getForbidTrx()
    {
        return forbidTrx;
    }
    public void setForbidTrx(String forbidTrx)
    {
        this.forbidTrx = forbidTrx;
    }
    public BigDecimal getReasonCode()
    {
        return reasonCode;
    }
    public void setReasonCode(BigDecimal reasonCode)
    {
        this.reasonCode = reasonCode;
    }
    public BigDecimal getAdministration()
    {
        return administration;
    }
    public void setAdministration(BigDecimal administration)
    {
        this.administration = administration;
    }
    public String getRecordSource()
    {
        return recordSource;
    }
    public void setRecordSource(String recordSource)
    {
        this.recordSource = recordSource;
    }
    public String getReference()
    {
        return reference;
    }
    public void setReference(String reference)
    {
        this.reference = reference;
    }
    public BigDecimal getCondAutCode()
    {
        return condAutCode;
    }
    public void setCondAutCode(BigDecimal condAutCode)
    {
        this.condAutCode = condAutCode;
    }
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    public String getWarningMessages()
    {
        return warningMessages;
    }
    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }
}
