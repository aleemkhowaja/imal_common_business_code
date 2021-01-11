package com.path.bo.core.cifswift.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.cifswift.CifSwiftBO;
import com.path.dao.core.cifswift.CifSwiftDAO;
import com.path.dbmaps.vo.CIF_BANK_DETAILSVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

public class CifSwiftBOImpl extends BaseBO implements CifSwiftBO
{
    private CifSwiftDAO cifSwiftDAO;

    public void setCifSwiftDAO(CifSwiftDAO cifSwiftDAO)
    {
	this.cifSwiftDAO = cifSwiftDAO;
    }

    @Override
    public List bankList(CifSwiftSC criteria) throws BaseException
    {
	return cifSwiftDAO.bankList(criteria);
    }

    @Override
    public int bankListCount(CifSwiftSC criteria) throws BaseException
    {
	return cifSwiftDAO.bankListCount(criteria);
    }

    @Override
    public S_PMSCIFSWIFTVO returnBankById(CifSwiftSC criteria) throws BaseException
    {
	return (S_PMSCIFSWIFTVO) cifSwiftDAO.returnBankById(criteria);
    }

    @Override
    public PMSCIFSWIFTVO returnPMSCIFSWIFTMinCIFBIC(CifSwiftSC criteria) throws BaseException
    {
	return (PMSCIFSWIFTVO) cifSwiftDAO.returnPMSCIFSWIFTMinCIFBIC(criteria);
    }

    public PMSCIFSWIFTVO returnPMSCIFSWIFT(CifSwiftSC criteria) throws BaseException
    {
	return (PMSCIFSWIFTVO) cifSwiftDAO.returnPMSCIFSWIFT(criteria);
    }

    public FomCifSwiftCO returnBankStatusBicCodeById(CifSwiftSC criteria) throws BaseException
    {
	FomCifSwiftCO fomCifSwiftCO = (FomCifSwiftCO) cifSwiftDAO.returnBankStatusBicCodeById(criteria);
	//Hasan Bug#592745 BMOUPI170737 29/11/2017 add RETRIEVE_CIF_BANK condition
	if(fomCifSwiftCO != null && fomCifSwiftCO.getCifSwiftVO() != null && !"RETRIEVE_CIF_BANK".equals(StringUtil.nullToEmpty(criteria.getFromWhere())))
	{
	    if(StringUtil.nullToEmpty(fomCifSwiftCO.getStatus()).equals("S"))
	    {
		throw new BOException(MessageCodes.BANK_CIF_IS_SUSPENDED);
	    }
	    if(StringUtil.nullToEmpty(fomCifSwiftCO.getStatus()).equals("D"))
	    {
		throw new BOException(MessageCodes.BANK_CIF_IS_DELETED);
	    }
	    if(StringUtil.nullToEmpty(fomCifSwiftCO.getStatus()).equals("I"))
	    {
		throw new BOException(MessageCodes.CIF_CODE_IS_INACTIVE);
	    }

	}

	return fomCifSwiftCO;
    }

    @Override
    public FomCifSwiftCO dependencySwiftReceiverBIC(CifSwiftSC criteria) throws BaseException
    {
	//TP 462719
//	    if( !NumberUtil.isNumber(criteria.getBankCode()))
//	    {
		CommonLibSC sc = new CommonLibSC();
		BigDecimal bicCodeLimit = commonLibBO.returnPthCtrl(sc).getBIC_CODE_LIMIT();

		String bankCode = "", branchCode = "", countryCode = "", locationCode = "";
		String terminalCode = "";
		String originalBic = criteria.getBankCode();
		if(originalBic.length() >= 4)
		{
		    bankCode = originalBic.substring(0, 4);
		}
		if(originalBic.length() >= 6)
		{
		    countryCode = originalBic.substring(4, 6);
		}
		if(originalBic.length() >= 8)
		{
		    locationCode = originalBic.substring(6, 8);
		}

		if(originalBic.length() == 12)
		{
		    terminalCode = originalBic.substring(8, 9);
		    branchCode = originalBic.substring(9, 12);
		}
		else
		{
		    if(originalBic.length() >= 11)
		    {
			branchCode = originalBic.substring(8, 11);
		    }
		}
		if(!StringUtil.isNotEmpty(terminalCode))
		{
		    terminalCode = "X";
		}
		if(!StringUtil.isNotEmpty(branchCode))
		{
		    branchCode = "XXX";
		}
		CifSwiftSC cifSwiftSC = new CifSwiftSC();

		cifSwiftSC.setCompCode(criteria.getCompCode());
		cifSwiftSC.setBankCode(bankCode);
		cifSwiftSC.setCountryCode(countryCode);
		cifSwiftSC.setLocationCode(locationCode);
		cifSwiftSC.setStrBranchCode(branchCode);
		cifSwiftSC.setTerminalCode(terminalCode);// 'X'
		cifSwiftSC.setBicCodeLimit(bicCodeLimit);
		PMSCIFSWIFTVO cifSwiftVO = returnPMSCIFSWIFTMinCIFBIC(cifSwiftSC);
		if(cifSwiftVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_BIC_CODE);
		}
		FomCifSwiftCO co = new FomCifSwiftCO();
		co.getCifSwiftVO().setCIF(cifSwiftVO.getCIF());
		co.setBicCodeNumber(originalBic);
		return co;
//	}
//	else
//	{
//	    criteria.setCifCode(new BigDecimal(criteria.getBankCode()));
//	    FomCifSwiftCO co = cifSwiftDAO.dependencySwiftReceiverBIC(criteria);
//	    //488211, throw message in case not found
//	    if(co == null)
//	    {
//		throw new BOException(MessageCodes.INVALID_MISSING_BIC_CODE);
//	    }
//	    return co;
//	}
    }
    
    /**
     * BicCode Lookup count
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnBicCodeLookupCount(CifSwiftSC criteria) throws BaseException
    {
        return cifSwiftDAO.returnBicCodeLookupCount(criteria);
    }

    /**
     * BicCode Lookup list
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<FomCifSwiftCO> returnBicCodeLookupList(CifSwiftSC criteria) throws BaseException
    {
        return cifSwiftDAO.returnBicCodeLookupList(criteria);
    }

    /**
     * BicCode Dependency
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @param criteria
     * @return
     * @throws BaseException
     */
    public FomCifSwiftCO returnBicCodeById(CifSwiftSC criteria) throws BaseException
    {
        return cifSwiftDAO.returnBicCodeById(criteria);
    }
    
    @Override
    public FomCifSwiftCO fillBenefParam(CifSwiftSC criteria) throws BaseException
    {
	FomCifSwiftCO fomCifSwiftCO = new FomCifSwiftCO();
	String isoCountry = "0";
	if("L".equals(criteria.getTransferType()))
	{
	    COMPANIESVO compVO = new COMPANIESVO();
	    compVO.setCOMP_CODE(criteria.getCompCode());
	    compVO = commonLibBO.returnCompany(compVO);
	    if(compVO != null)
	    {
		BigDecimal compCountry = NumberUtil.emptyDecimalToZero(compVO.getCOMP_COUNTRY());
		if(BigDecimal.ZERO.compareTo(compCountry) != 0)
		{
		    COUNTRIESVO countriesVO = new COUNTRIESVO();
		    countriesVO.setCOMP_CODE(criteria.getCompCode());
		    countriesVO.setCOUNTRY_CODE(compCountry);
		    countriesVO = (COUNTRIESVO) genericDAO.selectByPK(countriesVO);
		    if(countriesVO != null)
		    {
			isoCountry = countriesVO.getISO_COUNTRY();
		    }
		}
	    }
	}
	fomCifSwiftCO.setIsoCountry(isoCountry);
	return fomCifSwiftCO;
    }

    public CIF_BANK_DETAILSVO returnCifBankDetails(CIF_BANK_DETAILSVO cifBankDetailsVO) throws BaseException
    {
	return (CIF_BANK_DETAILSVO) cifSwiftDAO.returnCifBankDetails(cifBankDetailsVO);
    }

	@Override
	public FomCifSwiftCO dependencyByPartyWithFlagNo(CifSwiftSC cifSwiftSC)
			throws BaseException {
		FomCifSwiftCO fomCifSwiftCO = (FomCifSwiftCO) cifSwiftDAO.returnBankStatusBicCodeById(cifSwiftSC);
		if(fomCifSwiftCO == null){
			fomCifSwiftCO = new FomCifSwiftCO();
		}
		StringBuffer string;
	    string = new StringBuffer(StringUtil.nullEmptyToValue(fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_BBBB(), "XXXX"));// Bank_Code
	    fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_BBBB();
	    
   		string.append(StringUtil.nullEmptyToValue(fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_CC(),"XX"));// Country_Code
		string.append(StringUtil.nullEmptyToValue(fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_LL(),"XX"));// Location_Code
		string.append(StringUtil.nullEmptyToValue(fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_T(),""));// Location_Code
		string.append(StringUtil.nullEmptyToValue(fomCifSwiftCO.getCifSwiftVO().getSWIFT_BIC_BCD(),"XXX"));// Branch_Code
	    String newString = string.toString();
	    fomCifSwiftCO.setBicCodeNumber(newString);
		return fomCifSwiftCO;
	}
	
	    @Override
	    public List benefBankBicByCountryList(CifSwiftSC criteria) throws BaseException
	    {
		COUNTRIESVO countriesVO = new COUNTRIESVO();
		countriesVO.setCOMP_CODE(criteria.getCompCode());
		countriesVO.setCOUNTRY_CODE(criteria.getDestinCountry());
		countriesVO = (COUNTRIESVO) genericDAO.selectByPK(countriesVO);
		if(null != countriesVO)
		{
		    criteria.setCountryCode(countriesVO.getISO_COUNTRY());
		}
		return cifSwiftDAO.benefBankBicByCountryList(criteria);
	    }

    @Override
    public int benefBankBicByCountryCount(CifSwiftSC criteria) throws BaseException
    {
	COUNTRIESVO countriesVO = new COUNTRIESVO();
	countriesVO.setCOMP_CODE(criteria.getCompCode());
	countriesVO.setCOUNTRY_CODE(criteria.getDestinCountry());
	countriesVO = (COUNTRIESVO) genericDAO.selectByPK(countriesVO);
	if(null != countriesVO)
	{
	    criteria.setCountryCode(countriesVO.getISO_COUNTRY());
	}
	return cifSwiftDAO.benefBankBicByCountryCount(criteria);
    }
}
