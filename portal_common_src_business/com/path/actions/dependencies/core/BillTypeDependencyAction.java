/**
 * @author GhenoieSaab
 * @Date:June 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.billtype.BillTypeBO;
import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.common.SessionCO;
import com.path.vo.core.billtype.BillTypeSC;
import com.path.vo.core.csmfom.FomBillTypeCO;

public class BillTypeDependencyAction extends RetailBaseAction
{
    private BillTypeBO billTypeBO;
    private final BillTypeSC criteria = new BillTypeSC();
    private BigDecimal BILL_TYPE;
    private BigDecimal TRX_TYPE;
    private BigDecimal TRS_CY;
    private BigDecimal BANK_CIF;
    private CTS_BILL_TYPEVO ctsBillTypeVO;
    private String bnameEngReadOnly  = "true";
    //used to hold grid on dependency
    private String fomBillTypeGrid_jsonStr;

    /**
     * 
     */
    public Object getModel()
    {
	return criteria;
    }
    
    
    public String dependencyByBillTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBillType(BILL_TYPE);
	    criteria.setTrxTypeCode(TRX_TYPE);
	    criteria.setCyCode(TRS_CY);
	    criteria.setCifNo(BANK_CIF);
	    ctsBillTypeVO = billTypeBO.returnBillTypeById(criteria);
	    setBnameEngReadOnly("true");
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByBillTypeCode method of BillTypeDependencyAction");
	    handleException(e, "ERROR in Bill Type Dependency", null);
	}
	return SUCCESS;
    }

    public String dependencyOfNameByBillTypeCode()
    {
	try
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setBillType(BILL_TYPE);
	    criteria.setLanguage(returnSessionObject().getLanguage());
	    if(StringUtil.isNotEmpty(fomBillTypeGrid_jsonStr))
	    {
		GridUpdates gridData = getGridUpdates(fomBillTypeGrid_jsonStr, FomBillTypeCO.class, true);
		List fomBillTypeGridLst = gridData.getLstAllRec();
		criteria.setFomBillTypeGrid_lst(fomBillTypeGridLst);
	    }
	    ctsBillTypeVO = billTypeBO.returnBillTypeNameById(criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyOfNameByBillTypeCode method of BillTypeDependencyAction");
	    ctsBillTypeVO = new CTS_BILL_TYPEVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setBillTypeBO(BillTypeBO billTypeBO)
    {
        this.billTypeBO = billTypeBO;
    }


 

    public CTS_BILL_TYPEVO getCtsBillTypeVO()
    {
	return ctsBillTypeVO;
    }

    public void setCtsBillTypeVO(CTS_BILL_TYPEVO ctsBillTypeVO)
    {
	this.ctsBillTypeVO = ctsBillTypeVO;
    }

    public BigDecimal getBILL_TYPE()
    {
	return BILL_TYPE;
    }

    public void setBILL_TYPE(BigDecimal bILLTYPE)
    {
	BILL_TYPE = bILLTYPE;
    }

    public BigDecimal getTRS_CY()
    {
	return TRS_CY;
    }

    public void setTRS_CY(BigDecimal tRSCY)
    {
	TRS_CY = tRSCY;
    }

    public BigDecimal getBANK_CIF()
    {
	return BANK_CIF;
    }

    public void setBANK_CIF(BigDecimal bANKCIF)
    {
	BANK_CIF = bANKCIF;
    }

    public BigDecimal getTRX_TYPE()
    {
	return TRX_TYPE;
    }

    public void setTRX_TYPE(BigDecimal tRXTYPE)
    {
	TRX_TYPE = tRXTYPE;
    }

    public String getBnameEngReadOnly()
    {
	return bnameEngReadOnly;
    }

    public void setBnameEngReadOnly(String bnameEngReadOnly)
    {
	this.bnameEngReadOnly = bnameEngReadOnly;
    }

    public String getFomBillTypeGrid_jsonStr()
    {
        return fomBillTypeGrid_jsonStr;
    }

    public void setFomBillTypeGrid_jsonStr(String fomBillTypeGridJsonStr)
    {
        fomBillTypeGrid_jsonStr = fomBillTypeGridJsonStr;
    }
 
}


