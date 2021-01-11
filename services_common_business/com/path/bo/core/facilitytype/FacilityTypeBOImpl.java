package com.path.bo.core.facilitytype;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.account.AccountsConstant;
import com.path.dao.core.facilitytype.FacilityTypeDAO;
import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.ACC_NV_CONTROLVOKey;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.facilitytype.FacilityCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public class FacilityTypeBOImpl extends BaseBO implements FacilityTypeBO
{
    FacilityTypeDAO facilityTypeDAO;

    public FacilityTypeDAO getFacilityTypeDAO()
    {
	return facilityTypeDAO;
    }

    public void setFacilityTypeDAO(FacilityTypeDAO facilityTypeDAO)
    {
	this.facilityTypeDAO = facilityTypeDAO;
    }

    @Override
    public List facilityTypeList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilityTypeList(facilityTypeSC);
    }

    @Override
    public int facilityTypeListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilityTypeListCount(facilityTypeSC);
    }

    @Override
    public FMSFACILITYTYPEVO returnFacilityTypeById(FacilityTypeSC criteria) throws BaseException
    {
	// TP#621590 ;13-Feb-2018;d.james
	FMSFACILITYTYPEVO fmsFaciltyVO = null;
	if("true".equals(criteria.getAllTypesFlag()))
	{
	    if(BigDecimal.ZERO.equals(criteria.getCode()))
	    {
		fmsFaciltyVO = new FMSFACILITYTYPEVO();
		fmsFaciltyVO.setCODE(criteria.getCode());
		fmsFaciltyVO.setBRIEF_NAME_ENG(criteria.getAllTypes());
	    }
	    else
	    {
		fmsFaciltyVO = facilityTypeDAO.returnFacilityTypeById(criteria);
		if(fmsFaciltyVO == null || fmsFaciltyVO.getCODE() == null)
		{
		    throw new BOException(MessageCodes.MISSING_INVALID_FUNDING_FACILITY);
		}
	    }
	}
	else
	{
	    fmsFaciltyVO = facilityTypeDAO.returnFacilityTypeById(criteria);
	    if(fmsFaciltyVO == null || fmsFaciltyVO.getCODE() == null)
	    {
		throw new BOException(MessageCodes.MISSING_INVALID_FUNDING_FACILITY);
	    }
	}
	return fmsFaciltyVO;
    }

    public List facilityNumberList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	//Raed Saad - [#539366 - AMANA130105]
	if(NumberUtil.isEmptyDecimal(facilityTypeSC.getAccBranch()))
	{
	    facilityTypeSC.setAccBranch(facilityTypeSC.getBranchCode());
	}
	ACC_NV_CONTROLVOKey accNVCONTROLVOKey = new ACC_NV_CONTROLVOKey();
	accNVCONTROLVOKey.setCOMP_CODE(facilityTypeSC.getCompCode());
	accNVCONTROLVOKey.setBRANCH_CODE(facilityTypeSC.getAccBranch());
	ACC_NV_CONTROLVO accNVControlVO = commonLibBO.returnAccountNvCtrl(accNVCONTROLVOKey);

	RIFATTVO rifAttVO = new RIFATTVO();
	rifAttVO.setCOMP_CODE(facilityTypeSC.getCompCode());
	rifAttVO.setTYPE_CODE(facilityTypeSC.getGlCode());
	RIFATTVO rifattVO = commonLibBO.returnRIFATTInfo(rifAttVO);

	if("1".equals(accNVControlVO.getMOUSHARAKA_IJARA_OD_YN())
		&& (AccountsConstant.OD_EXPRESS_CASH.equals(rifattVO.getOD_TYPE())
			|| AccountsConstant.OD_EASY_CASH.equals(rifattVO.getOD_TYPE())))

	{
	    facilityTypeSC.setSectionKey(AccountsConstant.OD_EASY_CASH_OR_OD_EASY_CASH);
	    facilityTypeSC.setOdType(rifattVO.getOD_TYPE());
	}
	// AMANA130105 -- [John Massaad]

	return facilityTypeDAO.facilityNumberList(facilityTypeSC);
    }

    public int facilityNumberListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	// Raed Saad - [#539366 - AMANA130105]
	if(NumberUtil.isEmptyDecimal(facilityTypeSC.getAccBranch()))
	{
	    facilityTypeSC.setAccBranch(facilityTypeSC.getBranchCode());
	}
	ACC_NV_CONTROLVOKey accNVCONTROLVOKey = new ACC_NV_CONTROLVOKey();
	accNVCONTROLVOKey.setCOMP_CODE(facilityTypeSC.getCompCode());
	accNVCONTROLVOKey.setBRANCH_CODE(facilityTypeSC.getAccBranch());
	ACC_NV_CONTROLVO accNVControlVO = commonLibBO.returnAccountNvCtrl(accNVCONTROLVOKey);

	RIFATTVO rifAttVO = new RIFATTVO();
	rifAttVO.setCOMP_CODE(facilityTypeSC.getCompCode());
	rifAttVO.setTYPE_CODE(facilityTypeSC.getGlCode());
	RIFATTVO rifattVO = commonLibBO.returnRIFATTInfo(rifAttVO);

	if("1".equals(accNVControlVO.getMOUSHARAKA_IJARA_OD_YN())
		&& (AccountsConstant.OD_EXPRESS_CASH.equals(rifattVO.getOD_TYPE())
			|| AccountsConstant.OD_EASY_CASH.equals(rifattVO.getOD_TYPE())))

	{
	    facilityTypeSC.setSectionKey(AccountsConstant.OD_EASY_CASH_OR_OD_EASY_CASH);
	    facilityTypeSC.setOdType(rifattVO.getOD_TYPE());
	}
	// END Raed Saad - [#539366 - AMANA130105]
	return facilityTypeDAO.facilityNumberListCount(facilityTypeSC);
    }

    public FacilityCO returnFacilityCOByCode(FacilityTypeSC criteria) throws BaseException
    {
	return facilityTypeDAO.returnFacilityCOByCode(criteria);
    }

    public FMSFACILITYTYPEVO returnFacilityTypeByCode(FacilityTypeSC criteria) throws BaseException
    {
	FMSFACILITYTYPEVO fmsFaciltyVO = facilityTypeDAO.returnFacilityTypeByCode(criteria);

	if(fmsFaciltyVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_CODE);
	}

	return fmsFaciltyVO;

    }

    public List facilitySubLimitList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilitySubLimitList(facilityTypeSC);
    }

    public int facilitySubLimitListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilitySubLimitListCount(facilityTypeSC);
    }

    public FMSFACILITYDETVO returnFacilityDetVOByCode(FacilityTypeSC criteria) throws BaseException
    {
	return facilityTypeDAO.returnFacilityDetVOByCode(criteria);
    }

    @Override
    public List facilityNumberTFAList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilityNumberTFAList(facilityTypeSC);
    }

    @Override
    public int facilityNumberTFAListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return facilityTypeDAO.facilityNumberTFAListCount(facilityTypeSC);
    }
    
    // Raed Saad - BMOI150250
    @Override
    public int cardsFacilityCountList(CardsManagementSC criteria) throws BaseException
    {
 	return facilityTypeDAO.cardsFacilityCountList(criteria);
    }
    
    // Raed Saad - BMOI150250
    @Override
    public List<CardsManagementCO> cardsFacilityList(CardsManagementSC criteria) throws BaseException
    {
 	return facilityTypeDAO.cardsFacilityList(criteria);
    }
    
}
