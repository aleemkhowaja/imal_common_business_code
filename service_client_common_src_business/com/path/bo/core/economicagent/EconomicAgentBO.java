package com.path.bo.core.economicagent;

import java.util.List;

import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.economicagent.EconomicAgentSC;
import com.path.vo.core.legalstatus.LegalStatusSC;

public interface EconomicAgentBO
{
    public int economicAgentListCount(EconomicAgentSC economicAgentSC) throws BaseException;

    public List economicAgentList(EconomicAgentSC economicAgentSC) throws BaseException;
    
    public CTS_ECONOMIC_AGENTVO returnDependencyByEconomicAgent(EconomicAgentSC economicAgentSC) throws BaseException;
        
}
