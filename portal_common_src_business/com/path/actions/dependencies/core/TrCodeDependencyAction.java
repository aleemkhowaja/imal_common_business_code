package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.trtypes.TrTypesLookupBO;
import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          AssetsTrCodeDependencyAction.java used to check up Tr_Code based on
 *          specific company code chosen by the user and not based on any other
 *          parameters from sessionCO.
 */

public class TrCodeDependencyAction extends BaseAction
{
    private TR_TYPESVO trTypesVO = new TR_TYPESVO();
    private TrTypesLookupBO trTypesLookupBO;
    private BigDecimal compCode;
    private BigDecimal trCodeT;
    private TrTypesSC trTypesSC = new TrTypesSC();

    /**
     * Check Tr Type value according to company code entered by the user or
     * taken from the session.
     * 
     * @return String
     */
    public String dependencyByCompCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    trTypesSC.setCompCode(NumberUtil.isEmptyDecimal(getCompCode()) ?  sessionCO
		    .getCompanyCode() :getCompCode());
	    trTypesSC.setTrCode(NumberUtil.emptyDecimalToNull(trCodeT));
	    trTypesSC.setIsRTLDir(sessionCO.getIsRTLDir());

	    /*
	     * If TR_CODE is not empty, then check. Otherwise, return an empty
	     * object.
	     */
	    if(!NumberUtil.isEmptyDecimal(trTypesSC.getTrCode()))
	    {
		trTypesVO = trTypesLookupBO.returnTrTypeDetails(trTypesSC);

		if(trTypesVO == null || NumberUtil.isEmptyDecimal(trTypesVO.getTR_CODE()))
		{
		    trTypesVO = new TR_TYPESVO();
		    throw new BOException(returnCommonLibBO().returnTranslErrorMessage(MessageCodes.INVALID_TR_CODE,
			    sessionCO.getLanguage()));
		}
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCompCode method of AssetsTrCodeDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public TR_TYPESVO getTrTypesVO()
    {
	return trTypesVO;
    }

    public void setTrTypesVO(TR_TYPESVO trTypesVO)
    {
	this.trTypesVO = trTypesVO;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal cOMPCODE)
    {
	compCode = cOMPCODE;
    }

    public void setTrTypesLookupBO(TrTypesLookupBO trTypesLookupBO)
    {
	this.trTypesLookupBO = trTypesLookupBO;
    }

    public TrTypesSC getTrTypesSC()
    {
	return trTypesSC;
    }

    public void setTrTypesSC(TrTypesSC trTypesSC)
    {
	this.trTypesSC = trTypesSC;
    }

    public BigDecimal getTrCodeT()
    {
	return trCodeT;
    }

    public void setTrCodeT(BigDecimal trCodeT)
    {
	this.trCodeT = trCodeT;
    }
}
