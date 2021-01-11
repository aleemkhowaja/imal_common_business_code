package com.path.dao.common.iis.dealcharges.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.common.iis.dealcharges.IISDealChargesDAO;
import com.path.dbmaps.vo.CIFVOKey;
import com.path.dbmaps.vo.FMSFACILITYVO;
import com.path.dbmaps.vo.PRODUCT_CLASS_LINK_CHARGESVO;
import com.path.dbmaps.vo.PRODUCT_CLASS_LINK_CHARGESVOKey;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCHARGES_ROSTERVO;
import com.path.dbmaps.vo.TRSCHARGES_ROSTERVOKey;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVOKey;
import com.path.dbmaps.vo.TRSPFXCHARGESVOKey;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesSC;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * DAO Class for IIS Deal Charges.
 * 
 * @see com.path.dao.common.iis.dealcharges.impl.IISDealChargesDAOImpl
 * @author Bejoy
 * 
 */
public class IISDealChargesDAOImpl extends BaseDAO implements IISDealChargesDAO
{

    @Override
    public List<TrsChargesCO> getProductclassCharges(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.getProductclassCharges", trsClassVOKey);
    }

    @Override
    public BigDecimal getCifProfile(CIFVOKey cifVOKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisdealcharges.getCifProfile", cifVOKey);
    }

    @Override
    public Long getChargeRosterExists(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisdealcharges.getChargeRosterExists", trsChargesRosterVO);
    }

    @Override
    public TRSCHARGES_ROSTERVO getChargeRosterDetails(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException
    {
	return (TRSCHARGES_ROSTERVO) getSqlMap().queryForObject("iisdealcharges.getChargeRosterDetails",
		trsChargesRosterVO);
    }

    @Override
    public TRSCHARGES_ROSTERVO getChargeRosterDetailsWithOutCifProfile(TRSCHARGES_ROSTERVO trsChargesRosterVO)
	    throws DAOException
    {
	return (TRSCHARGES_ROSTERVO) getSqlMap().queryForObject(
		"iisdealcharges.getChargeRosterDetailsWithOutCifProfile", trsChargesRosterVO);
    }

    @Override
    public Long getChargeRosterCurrencyExists(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisdealcharges.getChargeRosterCurrencyExists", trsChargesRosterVO);
    }

    @Override
    public TRSCLASSVO getClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisdealcharges.getClassDetails", trsClassVOKey);
    }

    @Override
    public List<PRODUCT_CLASS_LINK_CHARGESVO> getProductclassLinkCharges(TRSCLASSVOKey trsClassVOKey)
	    throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.getProductclassLinkCharges", trsClassVOKey);
    }

    @Override
    public TRSCHARGESVO getTrsChargeDetails(TRSCHARGESVOKey trsChargesVOKey) throws DAOException
    {
	return (TRSCHARGESVO) getSqlMap().queryForObject("iisdealcharges.getTrsChargeDetails", trsChargesVOKey);
    }

    @Override
    public Long getChargeExists(TRSCHARGES_ROSTERVOKey trsChargesRosterVOKey) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisdealcharges.getChargeExists", trsChargesRosterVOKey);
    }

    public PRODUCT_CLASS_LINK_CHARGESVO getProductclassLinkChargesObject(
	    PRODUCT_CLASS_LINK_CHARGESVOKey productCLASSLINKCHARGESVOKey) throws DAOException
    {
	return (PRODUCT_CLASS_LINK_CHARGESVO) getSqlMap().queryForObject(
		"iisdealcharges.getProductclassLinkChargesObject", productCLASSLINKCHARGESVOKey);
    }

    @Override
    public List<TrsDealChargesCO> getDealChargesByDeal(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.getDealChargesByDeal", trsDealChargesSC);
    }

    @Override
    public void deleteDealChargesByDeal(TRSDEALCHARGESVOKey trsdealchargesvokey) throws DAOException
    {
	getSqlMap().delete("iisdealcharges.deleteDealChargesByDeal", trsdealchargesvokey);

    }

    @Override
    public List<TrsDealChargesCO> returnPFXCharges(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.returnPFXCharges", trsDealChargesSC);
    }

    @Override
    public void deletePfxCharges(TRSPFXCHARGESVOKey trspfxchargesvoKey) throws DAOException
    {
	getSqlMap().delete("iisdealcharges.deleteTRSPFXCHARGES", trspfxchargesvoKey);

    }

    // TP#190558; Saheer.Naduthodi; 20/07/2014
    @Override
    public List<TrsDealChargesCO> returnProductClassCharges(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.returnProductClassCharges", trsDealChargesSC);
    }

    @Override
    public BigDecimal returnMaxLineNbrPFX(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	BigDecimal maxLineNo = (BigDecimal) getSqlMap().queryForObject("iisdealcharges.returnMaxLineNbrPFX",
		trsDealChargesSC);
	if(maxLineNo == null)
	{
	    return BigDecimal.ZERO;
	}
	else
	{
	    return maxLineNo;
	}
    }

    @Override
    public int returnTrsClassNostroAccountDetails(IisDealChargesCO iisDealChargesCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("iisdealcharges.returnTrsClassNostroAccountDetails",
		iisDealChargesCO);
    }

    @Override
    public List<TrsDealChargesCO> returnDealChargesFromFacility(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return getSqlMap().queryForList("iisdealcharges.returnDealChargesFromFacility", trsDealChargesSC);
    }

    @Override
    public FMSFACILITYVO returnFMSFacilityDetails(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return (FMSFACILITYVO) getSqlMap().queryForObject("iisdealcharges.getFMSFacilityDetails", trsDealChargesSC);
    }

    @Override
    public TrsDealChargesSC returnSubLimitLineCount(TrsDealChargesSC trsDealChargesSC) throws DAOException
    {
	return (TrsDealChargesSC) getSqlMap().queryForObject("iisdealcharges.getSubLimitLineCount", trsDealChargesSC);
    }

}