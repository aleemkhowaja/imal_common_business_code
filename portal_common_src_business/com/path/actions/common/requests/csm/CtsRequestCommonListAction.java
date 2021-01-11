/**
 * 
 */
package com.path.actions.common.requests.csm;

import java.math.BigDecimal;

import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.requests.csm.CtsRequestSC;

import freemarker.template.utility.StringUtil;

/**
 * @author raees
 * 
 */
public class CtsRequestCommonListAction extends GridBaseAction
{
    CtsRequestSC criteria = new CtsRequestSC();
    private CtsRequestBO ctsRequestBO;

    public String loadCtsRequestGrid()
    {
        String[] searchCol = {"REQ_NO", "TYPE", "CIF_NO", "cifIdNoStr", "REQ_REF", "REQ_DESC", "STATUS",
            "requestStatusDesc", "REQ_DATE", "APPLICATION_CODE", "SAVED_AS_DRAFT"};

        try
        {
            SessionCO sessionObject = returnSessionObject();
            criteria.setCompCode(sessionObject.getCompanyCode());
            criteria.setBranchCode(sessionObject.getBranchCode());
            criteria.setAppName(sessionObject.getCurrentAppName());
            criteria.setLanguage(sessionObject.getLanguage());
            criteria.setCrudMode(getIv_crud());
            criteria.setCifNo(BigDecimal.ZERO);
            criteria.setScannedCIFNo(NumberUtil.emptyDecimalToNull(criteria.getScannedCIFNo()));
            criteria.setTfaStatus(StringUtil.emptyToNull(criteria.getTfaStatus()));
            
            // added for tfa request
            criteria.setOriginalAppName(sessionObject.getOriginalAppName());
            if(NumberUtil.isEmptyDecimal(criteria.getRequestType()))
            {
                criteria.setRequestType(BigDecimal.ZERO);
            }
            criteria.setIisAmentFalg("Z");

            criteria.setSearchCols(searchCol);
            copyproperties(criteria);
            if(checkNbRec(criteria))
            {
                setRecords(ctsRequestBO.returnCtsRequestListCount(criteria));
            }
            setGridModel(ctsRequestBO.returnCtsRequestList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in CtsRequest");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    @Override
    public Object getModel()
    {
        return criteria;
    }

    public CtsRequestSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(CtsRequestSC criteria)
    {
        this.criteria = criteria;
    }

    public void setCtsRequestBO(CtsRequestBO ctsRequestBO)
    {
        this.ctsRequestBO = ctsRequestBO;
    }
}
