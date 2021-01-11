/**
 * 
 */
package com.path.dao.core.gl.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.gl.GLDAO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.gl.GLCO;
import com.path.vo.core.gl.GLSC;

/**
 * @author MarwanMaddah
 * 
 */
public class GLDAOImpl extends BaseDAO implements GLDAO
{
    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int checkGLValidation(GLSC criteria) throws DAOException
    {
	return NumberUtil.nullToZero((Integer)getSqlMap().queryForObject("glMapper.checkGLValidation", criteria));
    }

    public GEN_LEDGERVO dependencyByGlCode(GLSC criteria) throws DAOException
    {
	return (GEN_LEDGERVO) getSqlMap().queryForObject("glMapper.dependencyByGlCode", criteria);
    }

    /***
     * Method for getting the GList for GL lookup
     */
    @Override
    public List glList(GLSC glSc) throws DAOException
    {
	DAOHelper.fixGridMaps(glSc, getSqlMap(), "glMapper.glListMap");
	if(glSc.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("glMapper.glList", glSc);
	}
	else
	{
	    return getSqlMap().queryForList("glMapper.glList", glSc, glSc.getRecToskip(), glSc.getNbRec());
	}
    }

    /***
	 * 
	 */
    @Override
    public int glListCount(GLSC glSc) throws DAOException
    {
	DAOHelper.fixGridMaps(glSc, getSqlMap(), "glMapper.glListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("glMapper.glListCount", glSc)).intValue();
	return nb;
    }

    @Override
    public BigDecimal dependencyByGlAmfRifatt(AccountSC accountSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("glMapper.selectValidateGLByGlAmfRifatt", accountSC);
    }

    /**
     * Method for gl lookup depenedency GEN_LEDGER table only the columns
     * selected here also differ from the above query dw_lookup_common_gl--
     * 
     * @return
     */
    @Override
    public GEN_LEDGERVO dependencyByGlFromGL(GLSC glSc) throws DAOException
    {

	return (GEN_LEDGERVO) getSqlMap().queryForObject("glMapper.selectValidateGLFromGL", glSc);
    }

    /**
     * Method for gl lookup list GEN_LEDGER table only the columns selected here
     * also differ from the above query dw_lookup_common_gl--
     * 
     * @return
     */
    @Override
    public List glListFromGL(GLSC glSc) throws DAOException
    {

	if(glSc.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("glMapper.glListFromGL", glSc);
	}
	else
	{
	    DAOHelper.fixGridMaps(glSc, getSqlMap(), "glMapper.glListMap");
	    return getSqlMap().queryForList("glMapper.glListFromGL", glSc, glSc.getRecToskip(), glSc.getNbRec());
	}
    }

    /**
     * Method for gl lookup count GEN_LEDGER table only the columns selected
     * here also differ from the above query dw_lookup_common_gl--
     * 
     * @return
     */
    @Override
    public int glListFromGLCount(GLSC glSc) throws DAOException
    {
	DAOHelper.fixGridMaps(glSc, getSqlMap(), "glMapper.glListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("glMapper.glListCountFromGL", glSc)).intValue();
	return nb;
    }

    @Override
    public String getBsContra(GLSC glSc) throws DAOException
    {
	return getSqlMap().queryForObject("glMapper.selectBsContra", glSc).toString();
    }

    public int selectgenLedgerglcode(GLSC glSc) throws DAOException
    {
	Integer result = ((Integer) getSqlMap().queryForObject("glMapper.selectgenLedgerglcode", glSc));
	if(result == null)
	{
	    return 0;
	}
	else 
	{
	    return result.intValue();
	}

    }

    /****
     * Method for the dependency of GL in an account component (Window :
     * w_lookup_amf_ret_nonint, Used in : General Account Screen)
     * 
     * @return GEN_LEDGERVO
     */
    @Override
    public GEN_LEDGERVO dependencyByGlFromAmfRifattGL(AccountSC criteria) throws DAOException
    {
	return (GEN_LEDGERVO) getSqlMap().queryForObject("glMapper.selectValidateGlFromAmfRifattGenLedger", criteria);
    }

    @Override
    public Integer glAmfListCount(AccountSC criteria) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("glMapper.glAmfListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public List<GLCO> glAmfList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("glMapper.glAmfList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "glMapper.glListMap");
	    return getSqlMap().queryForList("glMapper.glAmfList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * Returns the details of specific GL Code based on specific search criteria
     * from glSC.
     * 
     * @author HanaaElJazzar
     * @return GEN_LEDGERVO
     * @throws DAOException
     */
    @Override
    public GEN_LEDGERVO getGLDetailsFromGL(GLSC glSC) throws DAOException
    {
	return (GEN_LEDGERVO) getSqlMap().queryForObject("glMapper.glDetailsfromGL", glSC);
    }

}
