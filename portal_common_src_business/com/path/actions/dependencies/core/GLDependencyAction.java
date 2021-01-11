/**
 * 
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.gl.GLBO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.gl.GLSC;

/**
 * @author MarwanMaddah
 * 
 */
public class GLDependencyAction extends RetailBaseAction
{
    private AMFVO account = new AMFVO();
    private GEN_LEDGERVO genledger = new GEN_LEDGERVO();
    private GLBO glBO;
    private BigDecimal GL_CODE;
    private String allowInternAcc;
    private String dependencyFlag;

    /**
     * used for the dependency By GL ID in account tag default Management.
     *
     * @return
     */
    public String dependencyByGLId()
    {
	try
	{
	    if(dependencyFlag != null && "GlAmfRifatt".equals(dependencyFlag))
	    {
		dependencyByGlByGlAmfRifatt();
	    }
	    else
	    {
		GLSC criteria = new GLSC();
		SessionCO sessionCO = returnSessionObject();

		criteria.setBranchCode(NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE()));
		criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE()));
		criteria.setGlCode(NumberUtil.emptyDecimalToNull(account.getGL_CODE()));
		criteria.setUserId(sessionCO.getUserName());
		criteria.setCompCode(sessionCO.getCompanyCode());
		if(!glBO.checkGLValidation(criteria))
		{
		    account.setGL_CODE(null);
		}
		account.setCIF_SUB_NO(null);
		account.setSL_NO(null);
		account.setBRIEF_NAME_ENG(null);
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByGLId method of GLDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    

    public String returnGenLedgerById()
    {
	try
	{
	    GLSC criteria = new GLSC();
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setGlCode(getGL_CODE());
	    criteria.setAllowInternAcc(getAllowInternAcc());
	    criteria.setBranchCode(NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE()));
	    criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE()));

	    GEN_LEDGERVO genledger = glBO.returnGenLedgerById(criteria);
	    if("1".equals(dependencyFlag) && genledger == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "General_Ledger_key" });
	    }
	    if(null == getGenledger())
	    {
		genledger = new GEN_LEDGERVO();
	    }
	    setGenledger(genledger);
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in returnGenLedgerById method of GLDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String dependencyByGlCode()//reference f_get_glcode
    {
		try
		{
		    GLSC criteria = new GLSC();
		    SessionCO sessionCO = returnSessionObject();
		    
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setGlCode(GL_CODE);
		    criteria.setLang(sessionCO.getLanguage());
		    
		    genledger = glBO.dependencyByGlCode(criteria);
		}
		catch(BOException e)
		{
		    handleException(e, null, null);
		}
		catch(Exception e)
		{
		    log.error(e, "Error in returnGenLedgerById method of GLDependencyAction.java");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }

    /****
     * Method for the dependency of GL code based on GL,AMF,RIATT Window
     * 
     * @return
     */
    private String dependencyByGlByGlAmfRifatt()
    {
	try
	{
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */

	    BigDecimal brCode = NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE());
	    BigDecimal currCode = NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE());
	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE()) ;
	    if(!NumberUtil.isEmptyDecimal(account.getGL_CODE()))
	    {
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(brCode);
		criteria.setCurrencyCode(currCode);
		criteria.setGlCode(glCode);
		criteria.setBS_CONTRA("X");
		criteria.setGL_TYPE("X");
		criteria.setGMI_FLAG("X");
		criteria.setAffectPassChq("-1");
		criteria.setCifType("X");
		criteria.setAFFECT_CARD("0");
		criteria.setUserId(sessionCO.getUserName());
		glCode = null;
		glCode = glBO.dependencyByGlAmfRifatt(criteria);
	    }
	    if(glCode == null)
	    {
		account.setGL_CODE(null);
		account.setCIF_SUB_NO(null);
		account.setSL_NO(null);
		account.setBRIEF_NAME_ENG(null);
	    }
	    else
	    {
		account.setGL_CODE(glCode);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySerialNumber method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * Get the GL CODE list from  GEN_LEDGER table only the columns selected here also 
     * differ from the above query dw_lookup_common_gl : AccountsIntructionsTab.jsp
     * @return
     */
    public String dependencyByGl(){
		try{
		    GLSC glSC = new GLSC();
		    SessionCO sessionCO = returnSessionObject();
		    /**
		     * set the criteria...
		     */
		    
		    BigDecimal glCode   = NumberUtil.emptyDecimalToNull(account.getGL_CODE()); 
		    if(glCode!=null){
		    glSC.setCompCode(sessionCO.getCompanyCode());
		  //TODO, its using B as from the Account Transfer Details Tab, consider this and generalize
		    glSC.setBsContra("B");////TODO (Call the method getBsContra()from GLBO after consulting with service team) This should be taken from GEN_LEDGER by passing the selected gl code of selected record
		    glSC.setGenLedgerType("N");
		    glSC.setGlCode(glCode);
		    glSC.setLang(sessionCO.getLanguage());
		    genledger = glBO.dependencyByGlFromGL(glSC);
		    }
		    if(genledger==null){
			genledger = new GEN_LEDGERVO();
		    }
		}
		catch(Exception e){
			log.error(e, "Error in dependencyByGl method of GLDependencyAction.java");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    
    /****
     * Method for the dependency of GL  in an account component (The where clause is different from the previous method)
     * (Window : w_lookup_amf_ret_nonint,  Used in : General Account Screen)  
     * @return
     */
    public String dependencyByGlFromAmfRifattGL(){
	try{
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE()));
	    criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE()));
	    criteria.setGlCode(NumberUtil.emptyDecimalToNull(account.getGL_CODE()));
	    criteria.setBS_CONTRA("B");
	    criteria.setAffectPassChq("-1");
	    criteria.setAFFECT_CARD("0");
	    criteria.setGMI_FLAG("X");
            criteria.setCifType("X");
            
            
       if (!NumberUtil.isEmptyDecimal(criteria.getGlCode())&& !NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()) &&  !NumberUtil.isEmptyDecimal(criteria.getBranchCode())&& !NumberUtil.isEmptyDecimal(criteria.getBranchCode())
    		   
       )
         { 
	    
            GEN_LEDGERVO accResult = glBO.dependencyByGlFromAmfRifattGL(criteria);
	    if(accResult==null)
	    {
		account.setGL_CODE(null);
	    }
	    else
	    {
		account.setGL_CODE(accResult.getGL_CODE());
	    }
	    account.setCIF_SUB_NO(null);
	    account.setSL_NO(null);
	    account.setBRIEF_NAME_ENG(null);
	    account.setADDITIONAL_REFERENCE(null);
         }
         NumberUtil.resetEmptyValues(account);
	}
	catch(Exception e){
	    log.error(e, "Error in dependencyByGlFromAmfRifattGL method of GLDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String returnGlByCode()
    {
	try
	{
	    GLSC glSC = new GLSC();
	    SessionCO sessionCO = returnSessionObject();

	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE());
	    if(glCode != null)
	    {
		glSC.setCompCode(sessionCO.getCompanyCode());

		glSC.setBalanceSheet("B");
		glSC.setGenLedgerType("N");
		glSC.setGlCode(glCode);
		glSC.setLang(sessionCO.getLanguage());
		genledger = glBO.returnGl(glSC);
	    }
	    else // TP 514512; Fawas
	    {
		account.setGL_CODE(null);
	    }
	    if(genledger == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_GENERAL_LEDGER);
	    }
	}
	catch(Exception e)
	{
	    // TP#235336;Arun.R.Variyath;02/01/2015
	    account.setGL_CODE(null);
	    log.error(e, "Error in dependencyByGl method of GLDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public AMFVO getAccount()
    {
    	return account;
    }

    public void setAccount(AMFVO account)
    {
    	this.account = account;
    }

    public GEN_LEDGERVO getGenledger()
    {
	return genledger;
    }

    public void setGenledger(GEN_LEDGERVO genledger)
    {
	this.genledger = genledger;
    }

    public void setGlBO(GLBO glBO)
    {
	this.glBO = glBO;
    }

    public BigDecimal getGL_CODE()
    {
	return GL_CODE;
    }

    public void setGL_CODE(BigDecimal gLCODE)
    {
	GL_CODE = gLCODE;
    }

    public String getAllowInternAcc()
    {
        return allowInternAcc;
    }


    public void setAllowInternAcc(String allowInternAcc)
    {
        this.allowInternAcc = allowInternAcc;
    }

    public String getDependencyFlag() {
	return dependencyFlag;
    }

    public void setDependencyFlag(String dependencyFlag) {
	this.dependencyFlag = dependencyFlag;
    }

}
