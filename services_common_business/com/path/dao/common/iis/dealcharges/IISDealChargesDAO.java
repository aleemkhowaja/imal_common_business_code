package com.path.dao.common.iis.dealcharges;

import java.math.BigDecimal;
import java.util.List;

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
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesSC;

public interface IISDealChargesDAO
{
    public List<TrsChargesCO> getProductclassCharges(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public BigDecimal getCifProfile(CIFVOKey cifVOKey) throws DAOException;

    public Long getChargeRosterExists(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException;

    public TRSCHARGES_ROSTERVO getChargeRosterDetails(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException;

    public TRSCHARGES_ROSTERVO getChargeRosterDetailsWithOutCifProfile(TRSCHARGES_ROSTERVO trsChargesRosterVO)
	    throws DAOException;

    public Long getChargeRosterCurrencyExists(TRSCHARGES_ROSTERVO trsChargesRosterVO) throws DAOException;

    public TRSCLASSVO getClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public List<PRODUCT_CLASS_LINK_CHARGESVO> getProductclassLinkCharges(TRSCLASSVOKey trsClassVOKey)
	    throws DAOException;

    public PRODUCT_CLASS_LINK_CHARGESVO getProductclassLinkChargesObject(
	    PRODUCT_CLASS_LINK_CHARGESVOKey productCLASSLINKCHARGESVOKey) throws DAOException;

    public TRSCHARGESVO getTrsChargeDetails(TRSCHARGESVOKey trsChargesVOKey) throws DAOException;

    public Long getChargeExists(TRSCHARGES_ROSTERVOKey trsChargesRosterVOKey) throws DAOException;

    public List<TrsDealChargesCO> getDealChargesByDeal(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public void deleteDealChargesByDeal(TRSDEALCHARGESVOKey trsdealchargesvokey) throws DAOException;

    public List<TrsDealChargesCO> returnPFXCharges(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public void deletePfxCharges(TRSPFXCHARGESVOKey trspfxchargesvoKey) throws DAOException;

    // TP#190558; Saheer.Naduthodi; 20/07/2014
    public List<TrsDealChargesCO> returnProductClassCharges(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public BigDecimal returnMaxLineNbrPFX(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public int returnTrsClassNostroAccountDetails(IisDealChargesCO iisDealChargesCO) throws DAOException;

    /**
     * @author Ravikant.Singh
     * 
     * @param trsDealChargesSC
     * @return
     * @throws DAOException
     */
    public List<TrsDealChargesCO> returnDealChargesFromFacility(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public FMSFACILITYVO returnFMSFacilityDetails(TrsDealChargesSC trsDealChargesSC) throws DAOException;

    public TrsDealChargesSC returnSubLimitLineCount(TrsDealChargesSC trsDealChargesSC) throws DAOException;

}
