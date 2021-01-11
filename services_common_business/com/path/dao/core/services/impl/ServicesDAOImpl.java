package com.path.dao.core.services.impl;

import java.util.List;

import com.path.dao.core.services.ServicesDAO;
import com.path.dbmaps.vo.SERVICESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.services.ServicesSC;

public class ServicesDAOImpl extends BaseDAO implements ServicesDAO
{

    public List<SERVICESVO> returnTerminalIdList(ServicesSC servicesSC) throws DAOException
    {
	if(servicesSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("servicesMapper.returnTerminalIdList", servicesSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(servicesSC, getSqlMap(), "servicesMapper.terminalIdResultMap");
	    return getSqlMap().queryForList("servicesMapper.returnTerminalIdList", servicesSC,
		    servicesSC.getRecToskip(), servicesSC.getNbRec());
	}
    }

    public int returnTerminalIdListCount(ServicesSC servicesSC) throws DAOException
    {
	DAOHelper.fixGridMaps(servicesSC, getSqlMap(), "servicesMapper.terminalIdResultMap");
	return ((Integer) getSqlMap().queryForObject("servicesMapper.returnTerminalIdListCount", servicesSC)).intValue();
    }

}
