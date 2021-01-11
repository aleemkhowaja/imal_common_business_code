/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.authsignatories;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.authsignatories.AuthSignatoriesCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;

/**
 * @author MarwanMaddah
 * 
 */
public interface AuthSignatoriesBO
{
    public int authSignatoriesListCount(AuthSignatoriesSC criteria) throws BaseException;

    public List authSignatoriesList(AuthSignatoriesSC criteria) throws BaseException;
    
    
    public List checkAuthorizedCIFNo(AuthSignatoriesSC criteria) throws BaseException;

}
