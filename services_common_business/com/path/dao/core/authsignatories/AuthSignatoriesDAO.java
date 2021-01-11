/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.authsignatories;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.authsignatories.AuthSignatoriesCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;

/**
 * @author MarwanMaddah
 * 
 */
public interface AuthSignatoriesDAO
{
    public int authSignatoriesListCount(AuthSignatoriesSC criteria) throws DAOException;

    public List authSignatoriesList(AuthSignatoriesSC criteria) throws DAOException;

    List checkAuthorizedCIFNo(AuthSignatoriesSC criteria) throws DAOException;

    
}
