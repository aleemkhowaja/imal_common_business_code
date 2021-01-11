package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.educationallevel.EducationalLevelBO;
import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public class EducationLevelDependency extends RetailBaseAction
{
    private final EducationalLevelSC educationalLevelSC = new EducationalLevelSC();
    private EducationalLevelBO educationalLevelBO;
    private EDUC_DEGREEVO educationalLevelVO;
    private BigDecimal CODE;
    
    public String dependencyByEducationLevelCode() 
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    educationalLevelSC.setCompCode(sessionCO.getCompanyCode());
	    educationalLevelSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    educationalLevelSC.setCode(CODE);
	    educationalLevelVO = educationalLevelBO.educationLevelDependency(educationalLevelSC);
	}
	catch(Exception e)
	{
	    log.error(e,"Error in dependencyByEducationLevelCode method of EducationLevelDependency");
	    handleException(e, "ERROR in Education Level Dependency", null);
	}
	return SUCCESS;
    }
    
    public EDUC_DEGREEVO getEducationalLevelVO()
    {
        return educationalLevelVO;
    }
    public void setEducationalLevelVO(EDUC_DEGREEVO educationalLevelVO)
    {
        this.educationalLevelVO = educationalLevelVO;
    }
    public void setEducationalLevelBO(EducationalLevelBO educationalLevelBO)
    {
        this.educationalLevelBO = educationalLevelBO;
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