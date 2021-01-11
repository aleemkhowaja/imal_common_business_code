/**
 * 
 */
package com.path.bo.core.gl.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.gl.GLBO;
import com.path.dao.core.gl.GLDAO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.gl.GLCO;
import com.path.vo.core.gl.GLSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          GLBOImpl.java used to implement all the needed business for GL
 *          management.
 */
public class GLBOImpl extends BaseBO implements GLBO
{
    private GLDAO glDAO;

    /**
     * Check if the entered GL Code is valid or not.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public Boolean checkGLValidation(GLSC criteria) throws BaseException
    {
	Boolean result = false;
	int theValue = glDAO.checkGLValidation(criteria);
	if(theValue > 0)
	{
	    result = true;
	}
	return result;
    }

    /**
     * 
     * @return
     */
    public GLDAO getGlDAO()
    {
	return glDAO;
    }

    public void setGlDAO(GLDAO glDAO)
    {
	this.glDAO = glDAO;
    }

    public GEN_LEDGERVO returnGenLedgerById(GLSC criteria) throws BaseException
    {
	if(criteria.getGenLedgerType() == null)
	{
	    criteria.setGenLedgerType(ConstantsCommon.NON_INTERNAL_GL_TYPE);
	    if("1".equals(criteria.getAllowInternAcc()))
	    {
		criteria.setGenLedgerType(ConstantsCommon.BOTH_GL_TYPE);
	    }
	}
	criteria.setBalanceSheet(ConstantsCommon.ON_BALANCE_SHEET);
	return returnGl(criteria);
    }

    /**
     * This function returns the GEN_LEDGERVO where all the information needed
     * for the GlCode this is the same function found in PB: f_get_glcode
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public GEN_LEDGERVO returnGl(GLSC criteria) throws BaseException
    {
	GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
	genledgerVO.setCOMP_CODE(criteria.getCompCode());
	genledgerVO.setGL_CODE(criteria.getGlCode());

	//genledgerVO = (GEN_LEDGERVO) genericDAO.selectByPK(genledgerVO);
	genledgerVO = commonLibBO.returnGenralLegder(genledgerVO);

	if(null != genledgerVO)
	{
	    if(null == genledgerVO.getBRIEF_DESC_ENG())
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_GENERAL_LEDGER);
	    }

	    /**
	     * we check if the GL is on balance sheet or not
	     * 
	     */
	    if(!ConstantsCommon.XOR.equals(criteria.getBalanceSheet())
	    
		&&!genledgerVO.getBS_CONTRA().equals(criteria.getBalanceSheet()))
		{
		    if(ConstantsCommon.ON_BALANCE_SHEET.equals(criteria.getBalanceSheet()))
		    {
			throw new BOException(MessageCodes.NOT_VALID_BALANCE_SHEET_GL); // 453
		    }
		   // else
		    //{
			throw new BOException(MessageCodes.NOT_VALID_CONTRA_GL); // 1856
		   // }
		}
	    

	    if(!ConstantsCommon.XOR.equals(criteria.getGenLedgerType())
	     
		&&!genledgerVO.getGL_TYPE().equals(criteria.getGenLedgerType()))
		{
		    if(ConstantsCommon.INTERNAL_GEN_LEDGER_TYPE.equals(criteria.getGenLedgerType()))
		    {
			throw new BOException(MessageCodes.NOT_VALID_INTERNAL_GL); // 1352
		    }
		    else if(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE.equals(criteria.getGenLedgerType()))
		    {
			throw new BOException(MessageCodes.NOT_VALID_NON_INTERNAL_GL); // 1353
		    }
		    return genledgerVO;
		}
	    }
		
	return genledgerVO;
    }

    @Override
    public GEN_LEDGERVO dependencyByGlFromGL(GLSC glSc) throws BaseException
    {
	return glDAO.dependencyByGlFromGL(glSc);
    }

    @Override
    public List glListFromGL(GLSC glSc) throws BaseException
    {
	return glDAO.glListFromGL(glSc);
    }

    @Override
    public int glListFromGLCount(GLSC glSc) throws BaseException
    {
	return glDAO.glListFromGLCount(glSc);
    }

    public GEN_LEDGERVO dependencyByGlCode(GLSC criteria) throws BaseException
    {
	return glDAO.dependencyByGlCode(criteria);
    }

    @Override
    public List glList(GLSC glSc) throws BaseException
    {

	return glDAO.glList(glSc);
    }

    @Override
    public int glListCount(GLSC glSc) throws BaseException
    {

	return glDAO.glListCount(glSc);
    }

    @Override
    public BigDecimal dependencyByGlAmfRifatt(AccountSC glSc) throws BaseException
    {
	return glDAO.dependencyByGlAmfRifatt(glSc);
    }

    @Override
    public String getBsContra(GLSC glSc) throws BaseException
    {
	return glDAO.getBsContra(glSc);
    }

    public int selectgenLedgerglcode(GLSC glSc) throws BaseException
    {
	return glDAO.selectgenLedgerglcode(glSc);

    }

    /****
     * Method for the dependency of GL in an account component (Window :
     * w_lookup_amf_ret_nonint, Used in : General Account Screen)
     * 
     * @return GEN_LEDGERVO
     */
    @Override
    public GEN_LEDGERVO dependencyByGlFromAmfRifattGL(AccountSC criteria) throws BaseException
    {
	return glDAO.dependencyByGlFromAmfRifattGL(criteria);
    }

    @Override
    public Integer glAmfListCount(GLSC glSC) throws BaseException
    {
	AccountSC criteria = new AccountSC();
	copyProperties(criteria, glSC);
	return glDAO.glAmfListCount(criteria);
    }

    private void copyProperties(AccountSC fromObj, GLSC toObj) throws BaseException
    {
	PathPropertyUtil.copyProperties(toObj, fromObj, "nbRec", "recToskip", "colSearchQuery", "sord", "sortOrder",
		"sidx", "filters", "searchQuery", "compCode", "bsContra BS_CONTRA", "genLedgerType GL_TYPE",
		"GMI_FLAG", "AFFECT_CARD", "affectPassChq", "br_code branchCode", "currencyCode");
    }

    @Override
    public List<GLCO> glAmfList(GLSC glSC) throws BaseException
    {
	AccountSC criteria = new AccountSC();
	copyProperties(criteria, glSC);
	return glDAO.glAmfList(criteria);
    }

    /**
     * return the details of specific GL Code based on specific search criteria
     * from glSC
     * 
     * @author HanaaElJazzar
     * @param glSC
     * @return GEN_LEDGERVO
     * @throws BaseException
     */
    @Override
    public GEN_LEDGERVO getGLDetailsFromGL(GLSC glSC) throws BaseException
    {
	return glDAO.getGLDetailsFromGL(glSC);
    }
}
