package com.path.bo.core.aml;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTS_DYN_CIF_KYCVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import com.path.vo.core.csmfom.CIFCountryInfoCO;
import com.path.vo.core.csmfom.CIF_KYC_FINANCIAL_INFOCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomCifAddressCO;
import com.path.vo.core.csmfom.FomSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementBO.java used to
 */
public interface KycManagementBO
{

	public KycManagementCO returnKycManagement(KycManagementSC kycManagementSC) throws BaseException;

	Integer kycManagementCount(KycManagementSC kycManagementSC) throws BaseException;

	List<KycManagementCO> kycManagementList(KycManagementSC kycManagementSC) throws BaseException;

	KycManagementCO returnDepByCode(KycManagementCO kycManagementCO) throws BaseException;

	KycManagementCO saveKyc(KycManagementCO kycManagementCO, FomCO fomCO) throws BaseException;

	KycManagementCO updateKyc(KycManagementCO kycManagementCO, FomCO fomCO) throws BaseException;

	KycManagementCO deleteRecord(KycManagementCO kycManagementCO, AuditRefCO refCO) throws BaseException;

	KycManagementCO approveKyc(KycManagementCO kycManagementCO) throws BaseException;

	KycManagementCO returnDepByCifCode(KycManagementCO kycManagementCO) throws BaseException;

	public FomCO returnAMLKycDetailsRec(FomCO fomCO) throws BaseException;

	public ArrayList<CTS_DYN_CIF_KYCVO> retDynScreenValues(FomSC fomSC, Date retDate, FomCO fomCO) throws BaseException;

	public FomCO checkAmlKYCMandatoryFields(FomCO fomCO) throws BaseException;

	public int retCifCountryInfoCount(KycManagementSC kycManagementSC) throws BaseException;

	public FomCO returnNameDetails(KycManagementSC kycManagementSC) throws BaseException;

	// pasport button dependency
	public FomCO dependencyByPassportNumber(FomCO fomCO) throws BaseException;

	public FomCO dependencyByPassportNumber2(FomCO fomCO) throws BaseException;

	public FomCO dependencyByPassportNumber3(FomCO fomCO) throws BaseException;

	// BUTTON Residency
	public ArrayList<COUNTRIESVO> retYmcFinancialCountries(FomSC fomSC) throws BaseException;

	public CIF_KYC_FINANCIAL_INFOCO formatUSTin(KycManagementSC kycManagementSC) throws BaseException;

	public List<CIFCountryInfoCO> retCifCountryInfoGridWithoutPagination(FomSC fomSC) throws BaseException;

	public int retCifCountryInfoCount(FomSC fomSC) throws BaseException;

	public int retYmcFinancialCountriesCount(FomSC fomSC) throws BaseException;

	public void saveInGrid(CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO) throws BaseException;

	public void saveCifCountryInfo(List<CIFCountryInfoCO> cifCountryInfoList, FomSC fomSC) throws BaseException;

	public CIFVO saveFomCifMoreAddress(FomCifAddressCO cifAddressCO, AddressCommonCO addressCO) throws BaseException;
	
	KycManagementCO checkCif (KycManagementCO kycManagementCO) throws BaseException;

	public FomCO addActionToFOMElement(String element, String actionType, Object value, FomCO fomCO) throws BaseException;

	public FomCO addActionToFOMElement(List<String> elementsList, String actionType, Object value, FomCO fomCO) throws BaseException;

	public FomCO onFomKYCLoad(FomCO fomCO) throws BaseException;

}
