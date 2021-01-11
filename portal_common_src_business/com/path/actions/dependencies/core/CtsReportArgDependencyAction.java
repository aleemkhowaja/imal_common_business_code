package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.ctsreparg.CtsReportArgBO;
import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public class CtsReportArgDependencyAction extends RetailBaseAction{
	
	private CtsReportArgBO ctsReportArgBO;
	private CTS_REP_ARGVO reportArgVO;
	private BigDecimal  ARG_CODE; 
	
	public String dependancyByCtsReportArg()
	{
		try 
		{
			CtsReportArgSC criteria = new CtsReportArgSC();
			criteria.setCompCode(returnSessionObject().getCompanyCode());
			criteria.setAppName(ConstantsCommon.RADM_APP_NAME);
		    criteria.setTrxType("T");
			criteria.setArgCode(ARG_CODE);
						
			reportArgVO = ctsReportArgBO.reportArgById(criteria);
			if(null == reportArgVO)
			{
			    reportArgVO = new CTS_REP_ARGVO();
			}
			
		} 
		catch (Exception e) 
		{
		    reportArgVO.setCODE(null);
			log.error(e,"Error in dependancyByCtsReportArg method of CtsReportArgDependencyAction");
			handleException(e, "ERROR in CtsReportArg", null);
		}

		return SUCCESS;
	}

	public CTS_REP_ARGVO getReportArgVO()
	{
		return reportArgVO;
	}

	public void setReportArgVO(CTS_REP_ARGVO reportArgVO)
	{
		this.reportArgVO = reportArgVO;
	}

	public BigDecimal getARG_CODE()
	{
		return ARG_CODE;
	}

	public void setARG_CODE(BigDecimal aRGCODE)
	{
		ARG_CODE = aRGCODE;
	}

	public void setCtsReportArgBO(CtsReportArgBO ctsReportArgBO)
	{
		this.ctsReportArgBO = ctsReportArgBO;
	}

	
}
