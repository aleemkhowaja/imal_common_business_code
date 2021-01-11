package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cifrating.CifRatingBO;
import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.cifrating.CifRatingSC;

public class CifRatingDependencyAction extends RetailBaseAction
{
    private CifRatingBO cifRatingBO;
    private CREDIT_RATINGVO creditRatingVO;
    private BigDecimal CODE;

    public String dependencyByCifRatingCode()
    {

	try
	{
	    CifRatingSC criteria = new CifRatingSC();
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setLanguage(returnSessionObject().getPreferredLanguage());
	    criteria.setCifRatingCode(CODE);
	    creditRatingVO = cifRatingBO.returnCifRatingByCode(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCifRatingCode method of CifRatingDependencyAction");
	    handleException(e, "ERROR in CifRating Dependency", null);
	}

	return SUCCESS;

    }
    
    public String dependencyDetailByCifRatingCode()
    {

	try
	{
	    if (!NumberUtil.isEmptyDecimal(CODE))
		{
		    CifRatingSC criteria = new CifRatingSC();
		    criteria.setCompCode(returnSessionObject().getCompanyCode());
		    criteria.setCifRatingCode(CODE);
		    creditRatingVO = cifRatingBO.returnCifRatingDetailsByCode(criteria);

		    if(creditRatingVO==null)
		    {
			
			throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Credit_Rating_key" });
		    }
		}
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyDetailByCifRatingCode method of CifRatingDependencyAction");
	    creditRatingVO = new CREDIT_RATINGVO();
	    creditRatingVO.setCODE(null);
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    public void setCifRatingBO(CifRatingBO cifRatingBO)
    {
	this.cifRatingBO = cifRatingBO;
    }

    public CREDIT_RATINGVO getCreditRatingVO()
    {
	return creditRatingVO;
    }

    public void setCreditRatingVO(CREDIT_RATINGVO creditRatingVO)
    {
	this.creditRatingVO = creditRatingVO;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

}
