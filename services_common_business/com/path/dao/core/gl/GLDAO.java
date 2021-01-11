/**
 * 
 */
package com.path.dao.core.gl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.gl.GLCO;
import com.path.vo.core.gl.GLSC;

/**
 * @author MarwanMaddah
 *
 */
public interface GLDAO
{
    public int checkGLValidation(GLSC criteria) throws DAOException;
    public GEN_LEDGERVO dependencyByGlCode(GLSC criteria) throws DAOException;
    public List glList(GLSC glSc) throws DAOException;
    public int glListCount(GLSC glSc) throws DAOException;
    public BigDecimal dependencyByGlAmfRifatt(AccountSC glSc)throws DAOException;
    public int glListFromGLCount(GLSC glSc) throws DAOException;
    public List glListFromGL(GLSC glSc) throws DAOException;
    public GEN_LEDGERVO dependencyByGlFromGL(GLSC glSc) throws DAOException;
    public String getBsContra(GLSC glSc) throws DAOException;
    public int selectgenLedgerglcode(GLSC glSc) throws DAOException;
    public GEN_LEDGERVO dependencyByGlFromAmfRifattGL(AccountSC criteria) throws DAOException;
    public List<GLCO> glAmfList(AccountSC criteria) throws DAOException;
    public Integer glAmfListCount(AccountSC criteria) throws DAOException;
    /**
     * Returns the details of specific GL Code based on specific search criteria
     * from glSC.
     * 
     * @author HanaaElJazzar
     * @return GEN_LEDGERVO
     * @throws DAOException
     */
    public GEN_LEDGERVO getGLDetailsFromGL(GLSC glSC) throws DAOException;
}
