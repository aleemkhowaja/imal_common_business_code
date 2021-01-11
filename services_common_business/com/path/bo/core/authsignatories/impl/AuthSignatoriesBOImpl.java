/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.authsignatories.impl;

import java.util.List;

import com.path.bo.core.authsignatories.AuthSignatoriesBO;
import com.path.dao.core.authsignatories.AuthSignatoriesDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.authsignatories.AuthSignatoriesCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;

/**
 * @author MarwanMaddah
 * 
 */
public class AuthSignatoriesBOImpl extends BaseBO implements AuthSignatoriesBO
{
    private AuthSignatoriesDAO authSignatoriesDAO;

    /**
     * return the CIF list count...
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int authSignatoriesListCount(AuthSignatoriesSC criteria) throws BaseException
    {
	return authSignatoriesDAO.authSignatoriesListCount(criteria);
    }

    /**
     * return a list contains all CIF ids based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List authSignatoriesList(AuthSignatoriesSC criteria) throws BaseException
    {
	return authSignatoriesDAO.authSignatoriesList(criteria);
    }
    
    public List checkAuthorizedCIFNo(AuthSignatoriesSC criteria) throws BaseException
    {
	return authSignatoriesDAO.checkAuthorizedCIFNo(criteria) ;
    }

    public AuthSignatoriesDAO getAuthSignatoriesDAO()
    {
        return authSignatoriesDAO;
    }

    public void setAuthSignatoriesDAO(AuthSignatoriesDAO authSignatoriesDAO)
    {
        this.authSignatoriesDAO = authSignatoriesDAO;
    }
   
}
