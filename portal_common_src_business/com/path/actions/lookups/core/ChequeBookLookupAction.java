/**
 * @Auther: Chady Assaf
 * @Date:June 27, 2012
 * @Team:CSM Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.chequebook.ChequeBookLkpBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;


public class ChequeBookLookupAction extends LookupBaseAction
{
    private ChequeBookSC criteria = new ChequeBookSC();
    private List<ChequeBookCO> chequeBookList = new ArrayList<ChequeBookCO>();
    private ChequeBookLkpBO chequeBookLkpBO;

    private BigDecimal accountBr;
    private BigDecimal accountCy;
    private BigDecimal accountGl;
    private BigDecimal accountCif;
    private BigDecimal accountSl; 
    
    @Override
    public Object getModel()
    {
    	return criteria;
    }
    
    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingChequeBookGrid()
    {
	    try
		{
		    String[]  name    =  { "CODE", "CHEQUE_CODE", "ACC_BR", "ACC_CY", 
		    						"ACC_GL", "ACC_CIF", "ACC_SL", "ACC_ADD_REF",
		    						"FROM_NUMBER", "NUMBER_TO", "STATUS" };
		    String[]  colType = { "number", "number", "number", "number", 
		    						"number", "number", "number", "text", 
		    						"number", "number", "text"};

		    String[]  titles  = { getText("Code__key"), getText("cheque_code_key"),getText("Branch_code_key"), getText("Currency_key"),
						    		getText("Gl_Code_key"), getText("CIF_code_key"),getText("SL_No_Key"), getText("acc_add_ref_key"),
						    		getText("from_number_key"),getText("to_number_key"), getText("status_key")};
		    /**
		     * Defining The Grid ...
		     */
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Code__key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/ChequeBookLookup_loadChequeBookLookup");
		    lookup(grid, criteria, name, colType, titles);
	
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadChequeBookLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLang(sessionCO.getLanguage());
	    criteria.setLovType(CoreCommonConstants.CHEQUE_BOOK_SYS_PARAM_LOV_TYPE);

	    setRecords(chequeBookLkpBO.chequeBookLkpCount(criteria));
	    chequeBookList = chequeBookLkpBO.chequeBookLkpList(criteria);
	    setGridModel(chequeBookList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Build a Grid inside the LiveSearch ...
     * This function Will create the chequebook grid filtered by status 
     * PB = w_lookup_chqbook_portal
     */
    public String drawingChequeBookPortalGrid()
    {
	    try
		{
		    String[]  name    = { "BRANCH_CODE", "CHEQUE_CODE", "CODE", "ACC_BR", "ACC_CY", "ACC_GL", "ACC_CIF",
			    		  "ACC_SL", "FROM_NUMBER", "NUMBER_TO", "STATUS"  };
		    String[]  colType = { "number","number", "number", "number", "number", "number", "number", "number", 
		    			  "number", "number", "text"};
		    
		    String[]  titles  = { getText("branchKey"),getText("Code__key"), getText("cheque_code_key"),getText("Branch_code_key"), getText("Currency_key"),
					  getText("Gl_Code_key"), getText("CIF_code_key"),getText("SL_No_Key"),
					  getText("from_number_key"),getText("to_number_key"), getText("status_key")};
		    String originOptRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());

		    /**
		     * Defining The Grid ...
		     */
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Code__key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/ChequeBookLookup_loadChequeBookPortalLookup");
		    lookup(grid, criteria, name, colType, titles);
	
		}
		catch(Exception ex)
		{
		    ex.printStackTrace();
		}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadChequeBookPortalLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLang(sessionCO.getLanguage());
	    criteria.setLovType(CoreCommonConstants.CHEQUE_BOOK_SYS_PARAM_LOV_TYPE);
	    //String originOptRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());
	    String originOptRef = get_pageRef();

	    if("N001MT".equals(originOptRef))
	    {
		criteria.setPortal(2);
		criteria.setStatus("B");
		criteria.setBranchCode(BigDecimal.ZERO);
		criteria.setAll(Boolean.TRUE.toString());
		criteria.setACC_CIF(accountCif);
		criteria.setACC_GL(accountGl);
		criteria.setACC_CY(accountCy);
		criteria.setACC_SL(accountSl);
		
	    }

	    setRecords(chequeBookLkpBO.chequeBookPortalLkpCount(criteria));
	    chequeBookList = chequeBookLkpBO.chequeBookPortalLkpList(criteria);

	    setGridModel(chequeBookList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct Trx Cheque Lookup
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque
     * /w_lookup_chq_trx/dw_lookup_cheque_on_trx_type
     */
    public String constructTfaChqLkp()
    {
        try
        {
            String[] name = null, colType = null, titles = null;

            // Design the Grid by defining the column model and column names
            name = new String[] {"ctsTrsVO.TRS_NO", "ctsTrsVO.REMITTANCE_FR_NUM", "ctsTrsVO.REMITTANCE_TO_NUM",
                "statusDesc", "ctsTrsVO.TRS_DATE", "ctsTrsVO.VALUE_DATE", "ctsTrsVO.TRS_AC_CY",
                "ctsTrsVO.TRS_AC_GL", "ctsTrsVO.TRS_AC_CIF", "ctsTrsVO.TRS_AC_SL", "ctsTrsVO.TRS_CY",
                "ctsTrsVO.AMOUNT", "ctsTrsVO.TRS_AC_AMOUNT", "ctsTrsVO.SO_REFERENCE", "ctsTrsVO.JV_OP_NO",
                "ctsTrsVO.TRX_TYPE"};

            colType = new String[] {"number", "number", "number", "text", "date", "date", "number", "number",
                "number", "number", "number", "number", "number", "text", "number", "number"};

            titles = new String[] {getText("Trs_No_key"), getText("remittanceFrNum_key"),
                getText("remittanceToNum_key"), getText("Status_key"), getText("Trs_Date_key"),
                getText("Value_Date_key"), getText("CY_key"), getText("GL_key"), getText("CIF_key"),
                getText("SL_key"), getText("Trs_CY_key"), getText("Amount_key"), getText("account_amount_key"),
                getText("Reference_key"), getText("jvOpNo_key"), getText("Trx_Type_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Deposits_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/ChequeBookLookup_fillTfaChqLkp");
            List<LookupGridColumn> lkpGridColumn = returnStandarColSpecs(name, colType, titles);
            lkpGridColumn.get(0).setLeadZeros("8"); // ctsTrsVO.TRS_NO
            lkpGridColumn.get(6).setLeadZeros("3"); // ctsTrsVO.TRS_AC_CY
            lkpGridColumn.get(7).setLeadZeros("6"); // ctsTrsVO.TRS_AC_GL
            lkpGridColumn.get(8).setLeadZeros("8"); // ctsTrsVO.TRS_AC_CIF
            lkpGridColumn.get(9).setLeadZeros("3"); // ctsTrsVO.TRS_AC_SL
            lkpGridColumn.get(10).setLeadZeros("3"); // ctsTrsVO.TRS_CY
            lkpGridColumn.get(11).setNbFormat("#,##0.00###"); // ctsTrsVO.AMOUNT
            lkpGridColumn.get(12).setNbFormat("#,##0.00##"); // ctsTrsVO.TRS_AC_AMOUNT
            lookup(grid, lkpGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructTfaChqLkp of ChequeBookLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill Trx Cheque Lookup
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq/dw_lookup_cheque
     * /w_lookup_chq_trx/dw_lookup_cheque_on_trx_type
     */
    public String fillTfaChqLkp()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setLang(sessionCO.getLanguage());
            criteria.setLovType(CoreCommonConstants.CHEQUE_BOOK_SYS_PARAM_LOV_TYPE);

            if(criteria.getCheckTrx() == 0)
            {
                if(ConstantsCommon.PAYMENT_METHOD_DEMAND_DRAFT.equals(StringUtil.nullToEmpty(criteria
                    .getPaymentMethod())))
                {
                    criteria.setRemittType(BigDecimal.ONE);
                }
                else
                {
                    criteria.setRemittType(BigDecimal.valueOf(2));
                }
            }

            if(checkNbRec(criteria))
            {
                if(criteria.getCheckTrx() == 0)
                {
                    criteria.setDefaultBranch(NumberUtil.nullEmptyToValue(criteria.getDefaultBranch(),
                        sessionCO.getBranchCode()));
                    setRecords(chequeBookLkpBO.returnChqLkpCount(criteria));
                    setGridModel(chequeBookLkpBO.returnChqLkpList(criteria));
                }
                else
                {
                    setRecords(chequeBookLkpBO.returnChqTrxLkpCount(criteria));
                    setGridModel(chequeBookLkpBO.returnChqTrxLkpList(criteria));
                }
            }

        }
        catch(Exception e)
        {
            log.error(e, "Error in fillTfaChqLkp of ChequeBookLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public ChequeBookSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ChequeBookSC criteria)
    {
	this.criteria = criteria;
    }

    public List<ChequeBookCO> getChequeBookList()
    {
	return chequeBookList;
    }

    public void setChequeBookList(List<ChequeBookCO> chequeBookList)
    {
	this.chequeBookList = chequeBookList;
    }

    public BigDecimal getAccountBr()
    {
	return accountBr;
    }

    public void setAccountBr(BigDecimal accountBr)
    {
	this.accountBr = accountBr;
    }

    public BigDecimal getAccountCy()
    {
	return accountCy;
    }

    public void setAccountCy(BigDecimal accountCy)
    {
	this.accountCy = accountCy;
    }

    public BigDecimal getAccountGl()
    {
	return accountGl;
    }

    public void setAccountGl(BigDecimal accountGl)
    {
	this.accountGl = accountGl;
    }

    public BigDecimal getAccountCif()
    {
	return accountCif;
    }

    public void setAccountCif(BigDecimal accountCif)
    {
	this.accountCif = accountCif;
    }

    public BigDecimal getAccountSl()
    {
	return accountSl;
    }

    public void setAccountSl(BigDecimal accountSl)
    {
	this.accountSl = accountSl;
    }

    public void setChequeBookLkpBO(ChequeBookLkpBO chequeBookLkpBO)
    {
        this.chequeBookLkpBO = chequeBookLkpBO;
    }

}
