/**
 * 
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          LostFoundDependencyAction.java used to
 */
public class LostFoundDependencyAction extends RetailBaseAction
{
    //private LostFoundBO lostFoundBO;

    /* dependencies */
    private BigDecimal documentCode;
    private String documentCode_ReadOnly;

    private BigDecimal documentNo;

    private String stopReason;
    private String stopReason_ReadOnly;

    private String cardDescription;
    private String cardDescription_ReadOnly;

    private BigDecimal documentCY;
    private String documentCYDesc;
    private String foundReasonEng;
    private String foundReasonArabic;

    /* parameters */
    private BigDecimal documentTypeCode;
    private String documentCard;

    /**
     * To manage the dependency by doc code...
     * 
     * @return
     */
    public String dependencyByDocType()
    {
	try
	{
	    if(documentCard != null && !documentCard.isEmpty())
	    {
		if(documentCard == null
			|| (!"D".equals(documentCard) && !"R".equals(documentCard) && !"P".equals(documentCard)))
		{
		    documentCode = null;
		    documentCode_ReadOnly = "true";
		    cardDescription = "";

		}
		else if("D".equals(documentCard) || "R".equals(documentCard) || "P".equals(documentCard))
		{
		    documentCode_ReadOnly = "false";
		}
		cardDescription_ReadOnly = "true";

		documentNo = null;
		stopReason = "";
		stopReason_ReadOnly = "false";
	    }

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public BigDecimal getDocumentCode()
    {
	return documentCode;
    }

    public void setDocumentCode(BigDecimal documentCode)
    {
	this.documentCode = documentCode;
    }

    public String getDocumentCode_ReadOnly()
    {
	return documentCode_ReadOnly;
    }

    public void setDocumentCode_ReadOnly(String documentCodeReadOnly)
    {
	documentCode_ReadOnly = documentCodeReadOnly;
    }

    public BigDecimal getDocumentTypeCode()
    {
	return documentTypeCode;
    }

    public void setDocumentTypeCode(BigDecimal documentTypeCode)
    {
	this.documentTypeCode = documentTypeCode;
    }

    //public void setLostFoundBO(LostFoundBO lostFoundBO)
    //{
    //	this.lostFoundBO = lostFoundBO;
    //}

    public BigDecimal getDocumentNo()
    {
	return documentNo;
    }

    public void setDocumentNo(BigDecimal documentNo)
    {
	this.documentNo = documentNo;
    }

    public String getStopReason()
    {
	return stopReason;
    }

    public void setStopReason(String stopReason)
    {
	this.stopReason = stopReason;
    }

    public String getCardDescription()
    {
	return cardDescription;
    }

    public void setCardDescription(String cardDescription)
    {
	this.cardDescription = cardDescription;
    }

    public String getStopReason_ReadOnly()
    {
	return stopReason_ReadOnly;
    }

    public void setStopReason_ReadOnly(String stopReasonReadOnly)
    {
	stopReason_ReadOnly = stopReasonReadOnly;
    }

    public String getCardDescription_ReadOnly()
    {
	return cardDescription_ReadOnly;
    }

    public void setCardDescription_ReadOnly(String cardDescriptionReadOnly)
    {
	cardDescription_ReadOnly = cardDescriptionReadOnly;
    }

    public String getDocumentCard()
    {
	return documentCard;
    }

    public void setDocumentCard(String documentCard)
    {
	this.documentCard = documentCard;
    }

    public BigDecimal getDocumentCY()
    {
	return documentCY;
    }

    public void setDocumentCY(BigDecimal documentCY)
    {
	this.documentCY = documentCY;
    }

    public String getDocumentCYDesc()
    {
	return documentCYDesc;
    }

    public void setDocumentCYDesc(String documentCYDesc)
    {
	this.documentCYDesc = documentCYDesc;
    }

    public String getFoundReasonEng()
    {
        return foundReasonEng;
    }

    public void setFoundReasonEng(String foundReasonEng)
    {
        this.foundReasonEng = foundReasonEng;
    }

    public String getFoundReasonArabic()
    {
	return foundReasonArabic;
    }

    public void setFoundReasonArabic(String foundReasonArabic)
    {
	this.foundReasonArabic = foundReasonArabic;
    }

}
