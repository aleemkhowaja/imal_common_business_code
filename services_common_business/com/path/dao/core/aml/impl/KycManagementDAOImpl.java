package com.path.dao.core.aml.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.dao.core.aml.KycManagementDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTS_DYN_CIF_KYCVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
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
 * KycManagementDAOImpl.java used to
 */
public class KycManagementDAOImpl extends BaseDAO implements KycManagementDAO
{

	@Override
	public KycManagementCO returnKycManagement(KycManagementSC kycManagementSC) throws DAOException
	{
		return (KycManagementCO) getSqlMap().queryForObject("kycManagementMapper.kycManagementData", kycManagementSC);

	}

	@Override
	public Integer kycManagementCount(KycManagementSC kycManagementSC) throws DAOException
	{
		DAOHelper.fixGridMaps(kycManagementSC, getSqlMap(), "kycManagementMapper.resKycManagementListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("kycManagementMapper.returnKycManagementCount", kycManagementSC)).intValue();
		return nb;
	}

	@Override
	public List<KycManagementCO> kycManagementList(KycManagementSC kycManagementSC) throws DAOException
	{
		DAOHelper.fixGridMaps(kycManagementSC, getSqlMap(), "kycManagementMapper.resKycManagementListMap");
		if (kycManagementSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("kycManagementMapper.returnKycManagementList", kycManagementSC);
		}
		else
		{
			return getSqlMap().queryForList("kycManagementMapper.returnKycManagementList", kycManagementSC, kycManagementSC.getRecToskip(),
					kycManagementSC.getNbRec());
		}
	}

	@Override
	public Integer returnCodeDuplicateByCode(KycManagementCO kycManagementCO) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("kycManagementMapper.returnCountByCode", kycManagementCO);

	}

	@Override
	public Integer approveKyc(KycManagementCO kycManagementCO) throws DAOException
	{
		return getSqlMap().update("kycManagementMapper.approveKyc", kycManagementCO);

	}

	public KycManagementCO returnCifCode(KycManagementCO kycManagementCO) throws DAOException
	{
		return (KycManagementCO) getSqlMap().queryForObject("kycManagementMapper.returnByCifCode", kycManagementCO);

	}

	@Override
	public Integer returnCodeDuplicateByCifCode(KycManagementCO kycManagementCO) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("kycManagementMapper.returnCountByCifCode", kycManagementCO);

	}

	@Override
	public ArrayList<CTS_DYN_CIF_KYCVO> retDynScreenValues(FomSC fomSC) throws DAOException
	{
		return (ArrayList<CTS_DYN_CIF_KYCVO>) getSqlMap().queryForList("kycManagementMapper.retDynScreenValues", fomSC);

	}

	@Override
	public int retCifCountryInfoGridCount(KycManagementSC kycManagementSC) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("kycManagementMapper.retCifCountryInfoGridCount", kycManagementSC);

	}

	@Override
	public int retKycFinancialInfoCount(KycManagementSC kycManagementSC) throws DAOException
	{
		return ((Integer) getSqlMap().queryForObject("kycManagementMapper.retKycFinancialInfoCount", kycManagementSC)).intValue();
	}

	@Override
	public int retCifAddressCount(FomSC fomSC) throws DAOException
	{
		return ((Integer) getSqlMap().queryForObject("kycManagementMapper.retCifAddressCount", fomSC));

	}

	@Override
	public ArrayList<COUNTRIESVO> retYmcFinancialCountries(FomSC fomSC) throws DAOException
	{
		DAOHelper.fixGridMaps(fomSC, getSqlMap(), "kycManagementMapper.financialCountryMap");
		return (ArrayList<COUNTRIESVO>) getSqlMap().queryForList("kycManagementMapper.retYmcFinancialBirthCountry", fomSC, fomSC.getRecToskip(),
				fomSC.getNbRec());
	}

	public BigDecimal countUSControl(KycManagementSC kycManagementSC) throws DAOException
	{
		return (BigDecimal) getSqlMap().queryForObject("kycManagementMapper.countUSControl", kycManagementSC);
	}

	@Override
	public List<CIFCountryInfoCO> retCifCountryInfoGridWithoutPagination(FomSC fomSC) throws DAOException
	{
		DAOHelper.fixGridMaps(fomSC, getSqlMap(), "kycManagementMapper.cifCountryInfoMap");
		return (List<CIFCountryInfoCO>) getSqlMap().queryForList("kycManagementMapper.retCifCountryInfoGrid", fomSC);
	}

	@Override
	public int retCifCountryInfoGridCount(FomSC fomSC) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("kycManagementMapper.retCifCountryInfoGridCount", fomSC);

	}

	@Override
	public int retYmcFinancialCountriesCount(FomSC fomSC) throws DAOException
	{
		DAOHelper.fixGridMaps(fomSC, getSqlMap(), "kycManagementMapper.financialCountryMap");
		return ((Integer) getSqlMap().queryForObject("kycManagementMapper.retYmcFinancialBirthCountryCount", fomSC)).intValue();
	}

	public void deleteAllINGrid(FomSC fomSC) throws DAOException
	{
		getSqlMap().delete("kycManagementMapper.deleteAllINGrid", fomSC);

	}

	public void deleteCifCountryInfo(FomSC fomSC) throws DAOException
	{
		getSqlMap().delete("kycManagementMapper.deleteCifCountryInfo", fomSC);
	}

	public int returnMaxLineNo(FomPopUpSceensSC fomPopUpSceensSC) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("kycManagementMapper.returnMaxLineNo", fomPopUpSceensSC);

	}

	public int updateMainCifData(FomCO fomCO) throws DAOException
	{
		return getSqlMap().update("kycManagementMapper.updateMainCifData", fomCO);
	}

	public ArrayList<String> returnKycAuditHeaderFields() throws DAOException
	{
		return (ArrayList<String>) getSqlMap().queryForList("kycManagementMapper.returnKycAuditHeaderFields", null);
	}

	@Override
	public String returnPreviousKycStatus(CifSC cifSC) throws DAOException
	{
		return (String) getSqlMap().queryForObject("kycManagementMapper.returnPreviousKycStatus", cifSC);

	}

	@Override
	public int returnMaxAuditLineNO(CifSC cifSC) throws DAOException
	{
		return ((Integer) getSqlMap().queryForObject("kycManagementMapper.returnMaxAuditLineNO", cifSC));
	}

	@Override
	public BigDecimal returnKycSeqNO(CifSC cifSC) throws DAOException
	{
		return ((BigDecimal) getSqlMap().queryForObject("kycManagementMapper.returnKycSeqNO", cifSC));

	}

	public int retKycFinancialInfoCount(FomSC fomSC) throws DAOException
	{
		DAOHelper.fixGridMaps(fomSC, getSqlMap(), "kycManagementMapper.kycFinancialInfoMap");
		return ((Integer) getSqlMap().queryForObject("kycManagementMapper.retKycFinancialInfoCount", fomSC)).intValue();
	}

	public List<CIF_ADDRESSVO> returnFomKycAddress(FomSC fomSC) throws DAOException
	{
		return (List<CIF_ADDRESSVO>) getSqlMap().queryForList("kycManagementMapper.returnFomKycAddress", fomSC);
	}

	public FomCO returnFomKycDescription(FomCO fomCO) throws DAOException
	{
		return (FomCO) getSqlMap().queryForObject("kycManagementMapper.returnFomKycDescription", fomCO);
	}

}
