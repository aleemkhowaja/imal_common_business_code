package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.userlevel.UserLevelBO;
import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.userlevel.UserLevelSC;

public class UserLevelDependencyAction extends RetailBaseAction
{

    private UserLevelBO userLevelBO;
    private USR_LEVELVO userLevelVO;
    private BigDecimal CODE;

    public String dependancyByUserLevel()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    UserLevelSC criteria = new UserLevelSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCode(CODE);

	    userLevelVO = userLevelBO.returnUserLevelById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependancyByTemplateCode method of UserLevel");
	    handleException(e, "ERROR in UserLevel Dependency", null);
	}

	return SUCCESS;
    }

    public void setUserLevelBO(UserLevelBO userLevelBO)
    {
	this.userLevelBO = userLevelBO;
    }

    public USR_LEVELVO getUserLevelVO()
    {
	return userLevelVO;
    }

    public void setUserLevelVO(USR_LEVELVO userLevelVO)
    {
	this.userLevelVO = userLevelVO;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

}
