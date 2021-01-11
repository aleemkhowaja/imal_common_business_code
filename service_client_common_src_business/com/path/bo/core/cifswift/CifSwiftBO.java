package com.path.bo.core.cifswift;

import java.util.List;

import com.path.dbmaps.vo.CIF_BANK_DETAILSVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

public interface CifSwiftBO
{
    public int bankListCount(CifSwiftSC criteria) throws BaseException;

    public List bankList(CifSwiftSC criteria) throws BaseException;

    public S_PMSCIFSWIFTVO returnBankById(CifSwiftSC criteria) throws BaseException;

    public PMSCIFSWIFTVO returnPMSCIFSWIFTMinCIFBIC(CifSwiftSC criteria) throws BaseException;

    public PMSCIFSWIFTVO returnPMSCIFSWIFT(CifSwiftSC criteria) throws BaseException;

    public FomCifSwiftCO returnBankStatusBicCodeById(CifSwiftSC criteria) throws BaseException;

    public FomCifSwiftCO dependencySwiftReceiverBIC(CifSwiftSC criteria) throws BaseException;

    public int returnBicCodeLookupCount(CifSwiftSC criteria) throws BaseException;

    public List<FomCifSwiftCO> returnBicCodeLookupList(CifSwiftSC criteria) throws BaseException;

    public FomCifSwiftCO returnBicCodeById(CifSwiftSC criteria) throws BaseException;
 
    public CIF_BANK_DETAILSVO returnCifBankDetails(CIF_BANK_DETAILSVO cifBankDetailsVO) throws BaseException;

    public FomCifSwiftCO fillBenefParam(CifSwiftSC criteria) throws BaseException;

    public List benefBankBicByCountryList(CifSwiftSC criteria) throws BaseException;

    public int benefBankBicByCountryCount(CifSwiftSC criteria) throws BaseException;
    
	public FomCifSwiftCO dependencyByPartyWithFlagNo(CifSwiftSC cifSwiftSC)throws BaseException;
}
