package com.path.bo.core.economicagent.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.economicagent.EconomicAgentBO;
import com.path.dao.core.economicagent.EconomicAgentDAO;
import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.economicagent.EconomicAgentSC;

public class EconomicAgentBOImpl extends BaseBO implements EconomicAgentBO
{
    private EconomicAgentDAO economicAgentDAO;

 
    public List economicAgentList(EconomicAgentSC economicAgentSC) throws BaseException
    {
	return economicAgentDAO.economicAgentList(economicAgentSC);
    }

    public int economicAgentListCount(EconomicAgentSC economicAgentSC) throws BaseException
    {
	return economicAgentDAO.economicAgentListCount(economicAgentSC);
    }

    public EconomicAgentDAO getEconomicAgentDAO()
    {
        return economicAgentDAO;
    }

    public void setEconomicAgentDAO(EconomicAgentDAO economicAgentDAO)
    {
        this.economicAgentDAO = economicAgentDAO;
    }
    public CTS_ECONOMIC_AGENTVO returnDependencyByEconomicAgent(EconomicAgentSC economicAgentSC) throws BaseException
    {
	CTS_ECONOMIC_AGENTVO ecoAgentSVO = economicAgentDAO.returnDependencyByEconomicAgent(economicAgentSC);
	if(ecoAgentSVO == null) 
	{
	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "eco_agent_key" });
	}
	return ecoAgentSVO;	
    }
    
}
