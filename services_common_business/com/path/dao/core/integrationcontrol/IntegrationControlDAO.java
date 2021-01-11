package com.path.dao.core.integrationcontrol;

import java.util.List;

import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;

public interface IntegrationControlDAO {
	
	 public int integrationControlListCount(IntegrationControlSC integrationControlSC) throws DAOException;

	    public List integrationControlList(IntegrationControlSC integrationControlSC) throws DAOException;
	    
	    public CTS_INTEG_PARAMVO returnIntegrationControlById(IntegrationControlSC criteria) throws DAOException;

}
