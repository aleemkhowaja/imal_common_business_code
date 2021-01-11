package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.billcollection.BillCollectionBO;
import com.path.dbmaps.vo.TFSBILLVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

public class BillCollectionDependencyAction extends RetailBaseAction
{
    private TFSBILLVO tfsBillVO = new TFSBILLVO();
    private BillCollectionBO billCollectionBO;
    private final BillCollectionSC criteria = new BillCollectionSC();

    /**
     * used for the dependency management on Bill Collection management.
     * 
     * @return
     */
    public String dependencyByBillCollection()
    {
        try
        {
            if(NumberUtil.isEmptyDecimal(criteria.getBillNbr())
                || StringUtil.nullToEmpty(criteria.getBillType()).isEmpty())
            {

                throw new BOException(MessageCodes.INVALID_BILL_REFERENCE_NO);
            }
            else
            {
        	SessionCO sessionCO = returnSessionObject();
        	/**
        	 * set the criteria...
        	 */
        	criteria.setCompCode(sessionCO.getCompanyCode());
        	criteria.setBranchCode(sessionCO.getBranchCode());
        	
        	tfsBillVO = billCollectionBO.checkBillCollectionValidation(criteria);
        	if(tfsBillVO == null)
        	{
        	    throw new BOException(MessageCodes.INVALID_BILL_REFERENCE_NO);
        	}
            }

        }
        catch(Exception e)
        {
            log.error(e, "Error in dependencyByBillCollection method of BillCollectionDependencyAction.");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public TFSBILLVO gettfsBillVO()
    {
        return tfsBillVO;
    }

    public void settfsBillVO(TFSBILLVO tfsBillVO)
    {
        this.tfsBillVO = tfsBillVO;
    }

    public TFSBILLVO getTfsBillVO()
    {
        return tfsBillVO;
    }

    public void setTfsBillVO(TFSBILLVO tfsBillVO)
    {
        this.tfsBillVO = tfsBillVO;
    }

    public void setBillCollectionBO(BillCollectionBO billCollectionBO)
    {
        this.billCollectionBO = billCollectionBO;
    }

    public Object getModel()
    {
        return criteria;
    }

}
