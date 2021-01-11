package com.path.dao.core.integrationDynamic.impl;

import java.util.ArrayList;
import java.util.List;

import com.path.dao.core.integrationDynamic.IntegrationDynamicDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.integrationDynamic.IntegrationDynamicCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicSC;



public class IntegrationDynamicDAOImpl  extends BaseDAO implements IntegrationDynamicDAO
{

    
    public IntegrationDynamicCO returnColumnsLkpList(IntegrationDynamicSC integrationDynamicSC) throws DAOException
    {
	List<IntegrationDynamicCO> lst = (ArrayList) getSqlMap().queryForList(
		"integrationDynamicMapper.returnColumnsLkpList", integrationDynamicSC);
	return (lst == null || lst.isEmpty()) ? (new IntegrationDynamicCO()) : lst.get(0);
    }
    
    /**
     * Method used to return Count of dynamicIntegration
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    public int returndynamicIntegrationListCount(IntegrationDynamicSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "integrationDynamicMapper.resIntegrationDynamicListMap");
	return ((Integer) getSqlMap().queryForObject("integrationDynamicMapper.returndynamicIntegrationListCount",
		criteria)).intValue();
    }

    /**
     * Method used to return List of dynamicIntegration
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returndynamicIntegrationList(IntegrationDynamicSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "integrationDynamicMapper.resIntegrationDynamicListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("integrationDynamicMapper.returndynamicIntegrationList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("integrationDynamicMapper.returndynamicIntegrationList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
   
}
