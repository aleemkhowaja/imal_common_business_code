package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.bo.core.avabeneficiaries.AvaBeneficiariesLkpBO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;

public class AvaBeneciciariesDependencyAction extends BaseAction
{
    AvaBeneficiariesLkpBO avaBeneficiariesLkpBO;
    private AvaBeneficiariesDefSC criteria = new AvaBeneficiariesDefSC();
    private AvaBeneficiariesDefCO avaBeneficiariesCO = new AvaBeneficiariesDefCO();
   
    public String dependencyByBenefLineNo()
	{
	    try
		{  
		    SessionCO sessionCO = returnSessionObject();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    criteria.setBenefStatusLov(new BigDecimal(701)); //relationship to AvaFileConstant.java LovType 
		    criteria.setLanguage(sessionCO.getLanguage());
		    
		    avaBeneficiariesCO = avaBeneficiariesLkpBO.dependencyForAvaBeneficiaries(criteria);
	
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return "success";
	}
  
    @Override
    public Object getModel()
    {
	return criteria;
    }
   
    /**
     * @return the criteria
     */
    public AvaBeneficiariesDefSC getCriteria()
    {
        return criteria;
    }
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(AvaBeneficiariesDefSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @param avaBeneficiariesLkpBO the avaBeneficiariesLkpBO to set
     */
    public void setAvaBeneficiariesLkpBO(AvaBeneficiariesLkpBO avaBeneficiariesLkpBO)
    {
        this.avaBeneficiariesLkpBO = avaBeneficiariesLkpBO;
    }
    /**
     * @return the avaBeneficiariesCO
     */
    public AvaBeneficiariesDefCO getAvaBeneficiariesCO()
    {
        return avaBeneficiariesCO;
    }
    /**
     * @param avaBeneficiariesCO the avaBeneficiariesCO to set
     */
    public void setAvaBeneficiariesCO(AvaBeneficiariesDefCO avaBeneficiariesCO)
    {
        this.avaBeneficiariesCO = avaBeneficiariesCO;
    }
    
    
}
