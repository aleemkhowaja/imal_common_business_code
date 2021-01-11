package com.path.core.actions.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordBO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordListAction.java used to
 */
public class ScoringControlRecordListAction extends GridBaseAction
{

	private ScoringControlRecordBO scoringControlRecordBO;
	private ScoringControlRecordSC scoringControlRecordSC = new ScoringControlRecordSC();
	private List<ScoringControlRecordCO> controlRecordGrid = new ArrayList<ScoringControlRecordCO>();

	public String loadScoringControlRecordGrid()
	{

		try
		{

			SessionCO sessionCO = returnSessionObject();
			copyproperties(scoringControlRecordSC);
			scoringControlRecordSC.setBranch(sessionCO.getBranchCode());
			scoringControlRecordSC.setIsRTLDir(sessionCO.getIsRTLDir());

			scoringControlRecordSC.setLanguage(sessionCO.getLanguage());
			scoringControlRecordSC.setIvCrud(getIv_crud());
			scoringControlRecordSC.setNbRec(CoreCommonConstants.INT_MINUS_ONE);
			S_APPVO sAppVO = new S_APPVO();
			sAppVO.setAPP_NAME(sessionCO.getCurrentAppName());
			sAppVO = returnCommonLibBO().returnApplication(sAppVO);
			scoringControlRecordSC.setDualParam(sAppVO.getDUAL_PARAM());
			if(get_pageRef().equals("ACR00AP") || get_pageRef().equals("ACR00M") || get_pageRef().equals("ACR00A") || get_pageRef().equals("ACR00DJ"))
			{
				scoringControlRecordSC.setDualParam(BigDecimal.ZERO);
			}
			if (BigDecimal.ONE.equals(scoringControlRecordSC.getDualParam()))
			{

				scoringControlRecordSC.setCompCode(sessionCO.getCompanyCode());

			}
			else
			{
				scoringControlRecordSC.setCompCode(sessionCO.getCompanyCode());
			}
			
			if (checkNbRec(scoringControlRecordSC))
			{
				setRecords(scoringControlRecordBO.scoringControRecordGridCount(scoringControlRecordSC));
			}
			controlRecordGrid = scoringControlRecordBO.scoringControRecordGrid(scoringControlRecordSC);
			setGridModel(controlRecordGrid);
		}

		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e, "Error in Bond Expiry Grid");
		}
		return SUCCESS;
	}

	public void setScoringControlRecordBO(ScoringControlRecordBO scoringControlRecordBO)
	{
		this.scoringControlRecordBO = scoringControlRecordBO;
	}

	public ScoringControlRecordSC getScoringControlRecordSC()
	{
		return scoringControlRecordSC;
	}

	public void setScoringControlRecordSC(ScoringControlRecordSC scoringControlRecordSC)
	{
		this.scoringControlRecordSC = scoringControlRecordSC;
	}

	public List<ScoringControlRecordCO> getControlRecordGrid()
	{
		return controlRecordGrid;
	}

	public void setControlRecordGrid(List<ScoringControlRecordCO> controlRecordGrid)
	{
		this.controlRecordGrid = controlRecordGrid;
	}

}
