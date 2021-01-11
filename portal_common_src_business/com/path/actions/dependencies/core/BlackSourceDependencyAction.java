package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.blacklistsource.BlackSourceBO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public class BlackSourceDependencyAction extends RetailBaseAction
{
	private BlackSourceBO blackSourceBO;
	private MOSBLACKSOURCEVO blacksourceVO;
	private BigDecimal CODE;
	//by bilal to separate if the calling dependency from the BL source screen or from BL managemenet
	private String isMainScreen;
	
    public String dependencyByBlackSourceCode() {

		try 
		{
			if (NumberUtil.emptyDecimalToNull(CODE) != null )
        	    {
					SessionCO sessionCO = returnSessionObject();
					BlackSourceSC criteria = new BlackSourceSC();
					criteria.setCompCode(sessionCO.getCompanyCode());
					criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
					criteria.setCode(CODE);
					criteria.setIsMainScreen(isMainScreen);//by bilal
					criteria.setCurrAppName(sessionCO.getCurrentAppName());// added by nour for 777000
					blacksourceVO = blackSourceBO.returnBlackSourceById(criteria);
        	    }
			else // added by nour for tp id 885556
			{
				setCODE(null);
			}
		} 
		catch (Exception e) 
		{
			setCODE(null);// added by nour for tp id 885556
			log.error(e,"Error in dependencyByBlackSourceCode method of BlackSourceDependencyAction");
			handleException(e, null, null);
		}
		return SUCCESS;

	}

	public void setBlackSourceBO(BlackSourceBO blackSourceBO)
	{
		this.blackSourceBO = blackSourceBO;
	}

	public MOSBLACKSOURCEVO getBlacksourceVO()
	{
		return blacksourceVO;
	}

	public void setBlacksourceVO(MOSBLACKSOURCEVO blacksourceVO)
	{
		this.blacksourceVO = blacksourceVO;
	}

	public BigDecimal getCODE()
	{
		return CODE;
	}

	public void setCODE(BigDecimal cODE)
	{
		CODE = cODE;
	}

	public String getIsMainScreen() {
		return isMainScreen;
	}

	public void setIsMainScreen(String isMainScreen) {
		this.isMainScreen = isMainScreen;
	}
	
}
