package com.path.bo.core.teller.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.teller.TellerBO;
import com.path.dao.core.teller.TellerDAO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_ALLOWED_USERSVOKey;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.teller.TellerCO;
import com.path.vo.core.teller.TellerSC;

public class TellerBOImpl extends BaseBO implements TellerBO
{
    private TellerDAO tellerDAO;

    public TellerDAO getTellerDAO()
    {
	return tellerDAO;
    }

    public void setTellerDAO(TellerDAO tellerDAO)
    {
	this.tellerDAO = tellerDAO;
    }

    public Integer returnTellerLookupCount(TellerSC tellerSC) throws BaseException
    {
	return tellerDAO.returnTellerLookupCount(tellerSC);
    }

    public List<CTSTELLERVO> returnTellerLookupData(TellerSC tellerSC) throws BaseException
    {
	//#626607 DASI180069 - ATM tellers
	if("L0VT".equals(tellerSC.getTransferCashReference()))
	{
	    CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	    ctsControlVO.setCOMP_CODE(tellerSC.getCompCode());
	    ctsControlVO.setBRANCH_CODE(tellerSC.getBranchCode());
	    ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
	    if(ctsControlVO != null)
	    {
		tellerSC.setRestrictTransferVaultATM(ctsControlVO.getREST_TRNSF_VAULT_ATM_TELLER_YN());
	    }
	}
	return tellerDAO.returnTellerLookupData(tellerSC);
    }

	@Override
	public CTSTELLERVO returnRoleById(TellerSC criteria) throws BaseException
	{
		return (CTSTELLERVO) tellerDAO.returnRoleById(criteria);
	}

	@Override
	public String returnShowBranchCondition(TellerSC criteria) throws BaseException
	{
		return tellerDAO.returnShowBranchCondition(criteria);
	}

	@Override
	public List<BigDecimal> getAllTellerBranches(TellerSC criteria) throws BaseException
	{
		return tellerDAO.getAllTellerBranches(criteria);
	}
	
	@Override
	public CTSTELLERVO returnCifReservedNo(TellerSC criteria) throws BaseException
	{
		return (CTSTELLERVO) tellerDAO.returnCifReservedNo(criteria);
	}
	    @Override
	    public Integer returnRepresentiveLookupCount(TellerSC tellerSC) throws BaseException
	    {
		return tellerDAO.returnRepresentiveLookupCount(tellerSC);
	    }
	
	@Override
	public Integer returnATMUsersLookupCount(TellerSC tellerSC) throws BaseException
	{
	    return tellerDAO.returnATMUsersLookupCount(tellerSC);
	}

	@Override
	public List<CTSTELLER_ALLOWED_USERSVOKey> returnATMUsersLookupData(TellerSC tellerSC) throws BaseException
	{
	    return tellerDAO.returnATMUsersLookupData(tellerSC);
	}

    @Override
    public List<TellerCO> returnRepresentiveLookupData(TellerSC tellerSC) throws BaseException
    {
	return tellerDAO.returnRepresentiveLookupData(tellerSC);
    }

    @Override
    public TellerCO returnRepresentiveDesc(TellerSC tellerSC) throws BaseException
    {
	return tellerDAO.returnRepresentiveDesc(tellerSC);
    }

}
