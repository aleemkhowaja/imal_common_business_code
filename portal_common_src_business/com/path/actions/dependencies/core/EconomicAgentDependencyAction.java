/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.economicagent.EconomicAgentBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.economicagent.EconomicAgentSC;


public class EconomicAgentDependencyAction extends RetailBaseAction
{
    private EconomicAgentBO economicAgentBO;
    private EconomicAgentSC economicAgentSC = new EconomicAgentSC();
    private CTS_ECONOMIC_AGENTVO economicAgentVO;

    public String dependencyByEconomicAgent()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(economicAgentSC.getCode()))
	    {
		SessionCO sessionCO = returnSessionObject();
		economicAgentSC.setCompCode(sessionCO.getCompanyCode());
		economicAgentSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
		cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
		economicAgentSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
		economicAgentVO = economicAgentBO.returnDependencyByEconomicAgent(economicAgentSC);

	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByEconomicAgent method of EconomicAgentDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public EconomicAgentSC getModel()
    {
	return economicAgentSC;
    }


    /**
     * @param EconomicAgentBO the EconomicAgentBO to set
     */
    public void setEconomicAgentBO(EconomicAgentBO economicAgentBO)
    {
	this.economicAgentBO = economicAgentBO;
    }

    public CTS_ECONOMIC_AGENTVO getEconomicAgentVO()
    {
        return economicAgentVO;
    }

    public void setEconomicAgentVO(CTS_ECONOMIC_AGENTVO economicAgentVO)
    {
        this.economicAgentVO = economicAgentVO;
    }

    public EconomicAgentSC getEconomicAgentSC()
    {
        return economicAgentSC;
    }

    public void setEconomicAgentSC(EconomicAgentSC economicAgentSC)
    {
        this.economicAgentSC = economicAgentSC;
    }

    public EconomicAgentBO getEconomicAgentBO()
    {
        return economicAgentBO;
    }
}
