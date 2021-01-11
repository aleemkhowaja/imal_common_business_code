package com.path.bo.core.avabeneficiaries.impl;



import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.avabeneficiaries.AvaBeneficiariesLkpBO;
import com.path.dao.core.avabeneficiaries.AvaBeneficiariesLkpDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;

public class AvaBeneficiariesLkpBOImpl extends BaseBO implements AvaBeneficiariesLkpBO
{
    AvaBeneficiariesLkpDAO avaBeneficiariesLkpDAO;
    
    
    /**
     * Method used to return Lookup Count of AvaBeneficiaries
     * 
     * @param avaBeneficiariesDefCO Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnAvaBeneficiariesLookupCount(AvaBeneficiariesDefSC criteria) throws BaseException
    {		
	return avaBeneficiariesLkpDAO.returnAvaBeneficiariesLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of AvaBeneficiaries
     * 
     * @param AvaBeneficiariesDefCO Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnAvaBeneficiariesLookupList(AvaBeneficiariesDefSC criteria) throws BaseException
  {
	return avaBeneficiariesLkpDAO.returnAvaBeneficiariesLookupList(criteria);
    }

  /**
   * Method used to return dependency of AvaBeneficiaries
   * 
   * @param AvaBeneficiariesDefCO Search Criteria Parameter
   * @return AvaBeneficiariesVO Result object for dependency
   * @throws BaseException
   */
  public AvaBeneficiariesDefCO dependencyForAvaBeneficiaries(AvaBeneficiariesDefSC criteria) throws BaseException
 {
      	AvaBeneficiariesDefCO avaBeneficiariesDefCO = new AvaBeneficiariesDefCO();
	if(!NumberUtil.isEmptyDecimal(criteria.getLineno()))
	{
	    avaBeneficiariesDefCO = avaBeneficiariesLkpDAO.dependencyForAvaBeneficiaries(criteria);
	    if(null == avaBeneficiariesDefCO || null==avaBeneficiariesDefCO.getAvaBeneficiariesVO())
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_AVA_BENEFICIARY);
	    }
	}
	return avaBeneficiariesDefCO;
	}

/**
 * @return the avaBeneficiariesLkpDAO
 */
public AvaBeneficiariesLkpDAO getAvaBeneficiariesLkpDAO()
{
    return avaBeneficiariesLkpDAO;
}

/**
 * @param avaBeneficiariesLkpDAO the avaBeneficiariesLkpDAO to set
 */
public void setAvaBeneficiariesLkpDAO(AvaBeneficiariesLkpDAO avaBeneficiariesLkpDAO)
{
    this.avaBeneficiariesLkpDAO = avaBeneficiariesLkpDAO;
}

}
