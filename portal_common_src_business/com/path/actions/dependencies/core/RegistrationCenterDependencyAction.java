package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.registrationcenter.RegistrationCenterBO;
import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.common.exception.BOException;
import com.path.vo.common.SessionCO;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;

public class RegistrationCenterDependencyAction extends RetailBaseAction
{
    
    RegistrationCenterSC registrationCenterSC = new RegistrationCenterSC();
    RegistrationCenterBO registrationCenterBO;
    CTS_REGISTER_CENTERVO ctsRegCenterVO = new CTS_REGISTER_CENTERVO();
    
    public String dependencyByRegCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    registrationCenterSC.setCompCode(sessionCO.getCompanyCode());
	    /*registrationCenterSC.setRegCode(ctsInstructionVO.getCODE());*/
	    
	    ctsRegCenterVO = registrationCenterBO.dependencyByRegCode(registrationCenterSC);
	    
	    if(ctsRegCenterVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	}
	catch(Exception e)
	{
	    // TODO: handle exception
	}

	return "success";
    }


    public RegistrationCenterSC getRegistrationCenterSC()
    {
        return registrationCenterSC;
    }


    public void setRegistrationCenterSC(RegistrationCenterSC registrationCenterSC)
    {
        this.registrationCenterSC = registrationCenterSC;
    }


    public void setRegistrationCenterBO(RegistrationCenterBO registrationCenterBO)
    {
        this.registrationCenterBO = registrationCenterBO;
    }


    public CTS_REGISTER_CENTERVO getCtsRegCenterVO()
    {
        return ctsRegCenterVO;
    }


    public void setCtsRegCenterVO(CTS_REGISTER_CENTERVO ctsRegCenterVO)
    {
        this.ctsRegCenterVO = ctsRegCenterVO;
    }


 
    
    
}
