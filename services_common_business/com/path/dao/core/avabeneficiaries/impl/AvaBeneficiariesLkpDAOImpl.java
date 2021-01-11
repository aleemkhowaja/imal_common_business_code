package com.path.dao.core.avabeneficiaries.impl;



import java.util.List;

import com.path.dao.core.avabeneficiaries.AvaBeneficiariesLkpDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;

public class AvaBeneficiariesLkpDAOImpl  extends BaseDAO implements  AvaBeneficiariesLkpDAO
{

    /**
     * Method used to return Lookup Count of AvaBeneficiaries
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */	       	
    public int returnAvaBeneficiariesLookupCount(AvaBeneficiariesDefSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaBeneficiariesLkpMapper.resAvaBeneficiariesLookupMap");
	return ((Integer) getSqlMap().queryForObject("avaBeneficiariesLkpMapper.returnAvaBeneficiariesLookupCount", criteria))
		.intValue();
    }
  
    /**
     * Method used to return Lookup of AvaBeneficiaries
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnAvaBeneficiariesLookupList(AvaBeneficiariesDefSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaBeneficiariesLkpMapper.resAvaBeneficiariesLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("avaBeneficiariesLkpMapper.returnAvaBeneficiariesLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("avaBeneficiariesLkpMapper.returnAvaBeneficiariesLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /**
     * Method used to return dependency for AvaBeneficiaries
     * 
     * @param criteria Search Criteria Parameter
     * @return AvaBeneficiariesCO Result Object
     * @throws DAOException
     */
    public AvaBeneficiariesDefCO dependencyForAvaBeneficiaries(AvaBeneficiariesDefSC criteria)
	    throws DAOException
    {
	return (AvaBeneficiariesDefCO) getSqlMap().queryForObject("avaBeneficiariesLkpMapper.dependencyForBeneficiariesLkp", criteria);
	}
 

  
}
