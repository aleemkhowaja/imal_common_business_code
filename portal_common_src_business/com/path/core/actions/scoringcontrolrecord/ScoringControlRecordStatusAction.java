package com.path.core.actions.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordConstant;
import com.path.dbmaps.vo.AML_CIFCONTROL_RECORD_SCOREVO;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordStatusAction.java used to generate Status common Popup for ScoringControlRecord
 */
public class ScoringControlRecordStatusAction extends GridBaseAction
{

	private ScoringControlRecordSC criteria = new ScoringControlRecordSC();
	private String url;

	public String search()
	{
		try
		{
			ServletContext application = ServletActionContext.getServletContext();
			String theRealPath = application.getContextPath();
			// TODO add you criteria parameters to the URL
			setUrl(theRealPath + "/path/scoringControlRecord/ScoringControlRecordStatusAction_loadStatusGrid.action?status=" + criteria.getStatus());
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "SUCCESS_STATUS";
	}

	public String loadStatusGrid()
	{
		String[] searchCol = { "userName", "status_desc", "status_date" };
		AML_CIFCONTROL_RECORD_SCOREVO amlcifCOntrolRecordScoreVO = new AML_CIFCONTROL_RECORD_SCOREVO(); //by bilal for TP#987360
		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			copyproperties(criteria);
			//Add by bilal for TP#987360
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);
			criteria.setDualParam(sAppVO.getDUAL_PARAM());

			//modified by bilal for TP#987360
			if (BigDecimal.ONE.equals(criteria.getDualParam()) )
			{
			 if(criteria.getStatus().equals("A") || criteria.getStatus().equals("U"))
			    {
				 amlcifCOntrolRecordScoreVO.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(sessionCO.getCompanyCode()));

			    }
			    else
			    {
			    	amlcifCOntrolRecordScoreVO.setCOMP_CODE(sessionCO.getCompanyCode());

			    }
			}
			else
			{
				amlcifCOntrolRecordScoreVO.setCOMP_CODE(sessionCO.getCompanyCode());
			}
			
			//cifcontrol_define_score_rangeVO.setSCORE_CODE(criteria.getScoreCode());
			List<String> colList = ScoringControlRecordConstant.scoringControlRecordStatusLst;
			SelectSC lovCriteria = new SelectSC();
			lovCriteria.setLanguage(sessionCO.getLanguage());
			lovCriteria.setLovTypeId(ScoringControlRecordConstant.LOV_TYPE);

			List<StatusCO> resultList = returnCommonLibBO().generateStatusList(amlcifCOntrolRecordScoreVO, colList, lovCriteria);
			setGridModel(resultList);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}

	public ScoringControlRecordSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ScoringControlRecordSC criteria)
	{
		this.criteria = criteria;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
