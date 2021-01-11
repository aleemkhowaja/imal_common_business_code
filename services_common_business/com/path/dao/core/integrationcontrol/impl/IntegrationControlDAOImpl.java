package com.path.dao.core.integrationcontrol.impl;

import java.util.List;

import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.dao.core.integrationcontrol.IntegrationControlDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;

public class IntegrationControlDAOImpl extends BaseDAO implements IntegrationControlDAO{

	@Override
	public List integrationControlList(IntegrationControlSC integrationControlSC)
			throws DAOException {
		if(integrationControlSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("integrationControlListMapper.integrationControlList", integrationControlSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(integrationControlSC, getSqlMap(), "integrationControlListMapper.integrationControlListMap");
		    return getSqlMap().queryForList("integrationControlListMapper.integrationControlList", integrationControlSC, integrationControlSC.getRecToskip(),
		    		integrationControlSC.getNbRec());
		}
	}

	@Override
	public int integrationControlListCount(
			IntegrationControlSC integrationControlSC) throws DAOException {
		DAOHelper.fixGridMaps(integrationControlSC, getSqlMap(), "integrationControlListMapper.integrationControlListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("integrationControlListMapper.integrationControlListCount", integrationControlSC)).intValue();
		return nb;

	}

	@Override
	public CTS_INTEG_PARAMVO returnIntegrationControlById(
			IntegrationControlSC criteria) throws DAOException {
		return (CTS_INTEG_PARAMVO) getSqlMap().queryForObject("integrationControlListMapper.returnIntegrationControlById", criteria);
	}

}
