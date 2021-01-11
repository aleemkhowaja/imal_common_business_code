package com.path.dao.core.aml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTS_DYN_CIF_KYCVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.csmfom.CIFCountryInfoCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomPopUpSceensSC;
import com.path.vo.core.csmfom.FomSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementDAO.java used to
 */
public interface KycManagementDAO
{

	KycManagementCO returnKycManagement(KycManagementSC kycManagementSC) throws DAOException;

	Integer kycManagementCount(KycManagementSC kycManagementSC) throws DAOException;

	List<KycManagementCO> kycManagementList(KycManagementSC kycManagementSC) throws DAOException;

	Integer returnCodeDuplicateByCode(KycManagementCO kycManagementCO) throws DAOException;

	Integer approveKyc(KycManagementCO kycManagementCO) throws DAOException;

	KycManagementCO returnCifCode(KycManagementCO kycManagementCO) throws DAOException;

	Integer returnCodeDuplicateByCifCode(KycManagementCO kycManagementCO) throws DAOException;

	public ArrayList<CTS_DYN_CIF_KYCVO> retDynScreenValues(FomSC fomSC) throws DAOException;

	int retCifCountryInfoGridCount(KycManagementSC kycManagementSC) throws DAOException;

	public int retKycFinancialInfoCount(KycManagementSC kycManagementSC) throws DAOException;

	public int retCifAddressCount(FomSC fomSC) throws DAOException;

	public ArrayList<COUNTRIESVO> retYmcFinancialCountries(FomSC fomSC) throws DAOException;

	public int retYmcFinancialCountriesCount(FomSC fomSC) throws DAOException;

	public BigDecimal countUSControl(KycManagementSC kycManagementSC) throws DAOException;

	public List<CIFCountryInfoCO> retCifCountryInfoGridWithoutPagination(FomSC fomSC) throws DAOException;

	public int retCifCountryInfoGridCount(FomSC fomSC) throws DAOException;

	public void deleteAllINGrid(FomSC fomSC) throws DAOException;

	public void deleteCifCountryInfo(FomSC fomSC) throws DAOException;

	public int returnMaxLineNo(FomPopUpSceensSC fomPopUpSceensSC) throws DAOException;

	public int updateMainCifData(FomCO fomCO) throws DAOException;

	public ArrayList<String> returnKycAuditHeaderFields() throws DAOException;

	public String returnPreviousKycStatus(CifSC cifSC) throws DAOException;

	public int returnMaxAuditLineNO(CifSC cifSC) throws DAOException;

	public BigDecimal returnKycSeqNO(CifSC cifSC) throws DAOException;

	public int retKycFinancialInfoCount(FomSC fomSC) throws DAOException;

	public List<CIF_ADDRESSVO> returnFomKycAddress(FomSC fomSC) throws DAOException;

	public FomCO returnFomKycDescription(FomCO fomCO) throws DAOException;


}
