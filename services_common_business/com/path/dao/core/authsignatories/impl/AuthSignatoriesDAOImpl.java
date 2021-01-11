/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.authsignatories.impl;

import java.util.List;

import com.path.dao.core.authsignatories.AuthSignatoriesDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.authsignatories.AuthSignatoriesCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;

/**
 * @author MarwanMaddah
 * 
 */
public class  AuthSignatoriesDAOImpl extends BaseDAO implements  AuthSignatoriesDAO
{
    /**
     * sql map to get the count of the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int authSignatoriesListCount(AuthSignatoriesSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "authSignatoriesMapper.authSignatoriesListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("authSignatoriesMapper.authSignatoriesListCount", criteria)).intValue();
	return nb;
    }

    /**
     * sql map to get the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List authSignatoriesList(AuthSignatoriesSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("authSignatoriesMapper.authSignatoriesList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "authSignatoriesMapper.authSignatoriesListMap");
	    return getSqlMap()
		    .queryForList("authSignatoriesMapper.authSignatoriesList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    @Override
    public List checkAuthorizedCIFNo(AuthSignatoriesSC criteria) throws DAOException
    {
	 return (List) getSqlMap().queryForList("authSignatoriesMapper.checkAuthorizedCIFNo", criteria);
    }

  
}
