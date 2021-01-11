package com.path.dao.core.legalstatus.impl;

import java.util.List;

import com.path.dao.core.legalstatus.LegalStatusDAO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.legalstatus.LegalStatusSC;

public class LegalStatusDAOImpl extends BaseDAO implements LegalStatusDAO
{

    @Override
    public List legalStatusList(LegalStatusSC legalStatusSC) throws DAOException
    {
	if(legalStatusSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("legalStatusMapper.legalStatusList", legalStatusSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(legalStatusSC, getSqlMap(), "legalStatusMapper.legalStatusList_ResMap");
	    return getSqlMap().queryForList("legalStatusMapper.legalStatusList", legalStatusSC,
		    legalStatusSC.getRecToskip(), legalStatusSC.getNbRec());
	}
    }

    @Override
    public int legalStatusListCount(LegalStatusSC legalStatusSC) throws DAOException
    {
	DAOHelper.fixGridMaps(legalStatusSC, getSqlMap(), "legalStatusMapper.legalStatusList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("legalStatusMapper.legalStatusListCount", legalStatusSC)).intValue();
	return nb;
    }

    @Override
    public LEGAL_STATUSVO returnDependencyByStatusCode(LegalStatusSC legalStatusSC) throws DAOException
    {
	return (LEGAL_STATUSVO)getSqlMap().queryForObject("legalStatusMapper.returnDependencyByStatusCode", legalStatusSC);
    }

}
