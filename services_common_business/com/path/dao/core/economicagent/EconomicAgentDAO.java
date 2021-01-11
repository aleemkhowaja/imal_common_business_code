package com.path.dao.core.economicagent;

import java.util.List;

import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.economicagent.EconomicAgentSC;
import com.path.vo.core.economicsector.EconomicSectorSC;

public interface EconomicAgentDAO
{
    public List economicAgentList(EconomicAgentSC economicAgentSC) throws DAOException;

    public int economicAgentListCount(EconomicAgentSC economicAgentSC) throws DAOException;

    public CTS_ECONOMIC_AGENTVO returnDependencyByEconomicAgent(EconomicAgentSC economicAgentSC) throws DAOException;
    
}
