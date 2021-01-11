package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.floatingratecode.FloatingRateCodeBO;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;

public class FloatingRateCodeDependencyAction extends RetailBaseAction
{
    private FloatingRateCodeBO floatingRateCodeBO;
    private IBOR_HDRVO iborhdrVO;
    private BigDecimal IBOR_CODE;
    private String IBOR_DESC;

    /**
     * Method for dependency on ibor code
     * 
     * @return
     */
    public String dependencyByIBOR_CODE()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    FloatingRateCodeSC criteria = new FloatingRateCodeSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setIBOR_CODE(IBOR_CODE);

	    iborhdrVO = floatingRateCodeBO.returnFloatingRateCodeById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByDivisionCode method of FloatingRateCodeDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Method for dependency on ibor desc
     * 
     * @return
     */
    public String dependencyByIBOR_DESC()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    FloatingRateCodeSC criteria = new FloatingRateCodeSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBRIEF_DESC_ENG(IBOR_DESC);

	    iborhdrVO = floatingRateCodeBO.returnFloatingRateCodeById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByDivisionCode method of FloatingRateCodeDependencyAction");
	    handleException(e, "ERROR in FloatingRateCode Dependency", null);
	}

	return SUCCESS;

    }

    /**
     * Gets the Ibor VO
     * 
     * @return
     */
    public IBOR_HDRVO getIborhdrVO()
    {
	return iborhdrVO;
    }

    /**
     * Sets the Ibor VO
     * 
     * @param iborhdrVO
     */
    public void setIborhdrVO(IBOR_HDRVO iborhdrVO)
    {
	this.iborhdrVO = iborhdrVO;
    }

    /**
     * Gets the ibor code
     * 
     * @return
     */
    public BigDecimal getIBOR_CODE()
    {
	return IBOR_CODE;
    }

    /**
     * Sets the Ibor code
     * 
     * @param iBORCODE
     */
    public void setIBOR_CODE(BigDecimal iBORCODE)
    {
	IBOR_CODE = iBORCODE;
    }

    /**
     * Sets the floating rade code BO
     * 
     * @param floatingRateCodeBO
     */
    public void setFloatingRateCodeBO(FloatingRateCodeBO floatingRateCodeBO)
    {
	this.floatingRateCodeBO = floatingRateCodeBO;
    }

    /**
     * Get the Ibor Desc
     * 
     * @return
     */
    public String getIBOR_DESC()
    {
	return IBOR_DESC;
    }

    /**
     * Sets the ibor desc
     * 
     * @param iBORDESC
     */
    public void setIBOR_DESC(String iBORDESC)
    {
	IBOR_DESC = iBORDESC;
    }

}
