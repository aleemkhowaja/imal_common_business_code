package com.path.bo.core.integrationcontrol.impl;

import java.util.List;

import com.path.bo.core.integrationcontrol.IntegrationControlBO;
import com.path.dao.core.integrationcontrol.IntegrationControlDAO;
import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;

public class IntegrationControlBOImpl extends BaseBO implements IntegrationControlBO {
	
	private IntegrationControlDAO integrationControlDAO;
	
	 public IntegrationControlDAO getIntegrationControlDAO()
	    {
		return integrationControlDAO;
	    }

	@Override
	public List integrationControlList(IntegrationControlSC integrationControlSC)
			throws BaseException {
		return integrationControlDAO.integrationControlList(integrationControlSC);
		
	}

	@Override
	public int integrationControlListCount(
			IntegrationControlSC integrationControlSC) throws BaseException {
		return integrationControlDAO.integrationControlListCount(integrationControlSC);
	}
	
	public void setIntegrationControlDAO(IntegrationControlDAO integrationControlDAO) {
		this.integrationControlDAO = integrationControlDAO;
	}

	@Override
	public CTS_INTEG_PARAMVO returnIntegrationControlById(
			IntegrationControlSC criteria) throws BaseException {
		return (CTS_INTEG_PARAMVO) integrationControlDAO.returnIntegrationControlById(criteria);
	}

}
