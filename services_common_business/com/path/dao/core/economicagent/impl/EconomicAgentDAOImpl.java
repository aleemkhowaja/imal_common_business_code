package com.path.dao.core.economicagent.impl;

import java.util.List;

import com.path.dao.core.economicagent.EconomicAgentDAO;
import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.economicagent.EconomicAgentSC;

public class EconomicAgentDAOImpl extends BaseDAO implements EconomicAgentDAO
{

    @Override
    public List economicAgentList(EconomicAgentSC economicAgentSC) throws DAOException
    {
	
	if(economicAgentSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("economicAgentListMapper.economicAgentList", economicAgentSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(economicAgentSC, getSqlMap(), "economicAgentListMapper.economicAgentList_ResMap");
	    return getSqlMap().queryForList("economicAgentListMapper.economicAgentList", economicAgentSC,
		    economicAgentSC.getRecToskip(), economicAgentSC.getNbRec());
	}
    }

    public int economicAgentListCount(EconomicAgentSC economicAgentSC) throws DAOException
    {
	DAOHelper.fixGridMaps(economicAgentSC, getSqlMap(), "economicAgentListMapper.economicAgentList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("economicAgentListMapper.economicAgentListCount", economicAgentSC)).intValue();
	return nb;
    }

    public CTS_ECONOMIC_AGENTVO returnDependencyByEconomicAgent(EconomicAgentSC economicAgentSC) throws DAOException
    {
	return (CTS_ECONOMIC_AGENTVO)getSqlMap().queryForObject("economicAgentListMapper.returnDependencyByEconomicAgent", economicAgentSC);
    }
}
