package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cardintegration.CardIntegrationBO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardintegration.CardIntegrationSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Hussein Elhajj
 * 
 *          CardIntegrationLookupAction.java used to
 */
public class CardIntegrationLookupAction extends LookupBaseAction
{
    private CardIntegrationBO cardIntegrationBO;
    private CardIntegrationSC criteria = new CardIntegrationSC();
    private List<CTSCARDSVO> cardTypeVOList;
    
    
    
    
    
    
    public String drawDebitCardTypeGrid()
    {
	try
	{
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Code__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardIntegrationLookupAction_loadDebitCardTypeLookup");
	    final String columnName[] = { "ctsCardsVO.CODE", "ctsCardsVO.BRIEF_NAME_ENG", "ctsCardsVO.BRIEF_NAME_ARAB" };
	    final String columnType[] = { "number", "text", "text" };
	    final String columnTitle[] = { getText("Code__key"), getText("Brief_Name_eng_key"),
		    getText("Brief_Name_Arab_key") };
	    List<LookupGridColumn> gridColumnList = returnStandarColSpecs(columnName, columnType, columnTitle);
	    lookup(grid, gridColumnList, null, criteria);
	}
	catch(Exception e)
	{
	    StringBuilder strBldr = new StringBuilder();
	    strBldr.append("Error message '");
	    strBldr.append(e.getMessage());
	    strBldr.append("; Cause: '");
	    strBldr.append(e.getCause());
	    strBldr.append("'; Class: '");
	    strBldr.append(this.getClass());
	    strBldr.append("'; Method: '");
	    strBldr.append("CardTypeGrid'.");
	    strBldr.trimToSize();
	    log.error(strBldr.toString());
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadDebitCardTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    setRecords(Integer.valueOf(cardIntegrationBO.debitCardTypeLookupCount(criteria)));
	    cardTypeVOList = cardIntegrationBO.debitCardTypeLookupRecs(criteria);
	    setGridModel(cardTypeVOList);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CardIntegrationSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(CardIntegrationSC criteria)
    {
        this.criteria = criteria;
    }

    public List<CTSCARDSVO> getCardTypeVOList()
    {
        return cardTypeVOList;
    }

    public void setCardTypeVOList(List<CTSCARDSVO> cardTypeVOList)
    {
        this.cardTypeVOList = cardTypeVOList;
    }

    public void setCardIntegrationBO(CardIntegrationBO cardIntegrationBO)
    {
        this.cardIntegrationBO = cardIntegrationBO;
    }
    
    
    
    }
