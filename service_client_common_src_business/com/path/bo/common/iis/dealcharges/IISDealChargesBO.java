package com.path.bo.common.iis.dealcharges;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.iis.IISReturnMessagesCO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesSC;
import com.path.dbmaps.vo.TRSDEAL_ASSET_VNDR_INCENTIVEVO;

public interface IISDealChargesBO
{

    public List<TrsDealChargesCO> calculateDealCharges(IisDealChargesCO iisDealChargesCO) throws BaseException;

    public TrsDealChargesCO calculateDealChargesForGrid(IisDealChargesCO iisDealChargesCO) throws BaseException;

    public List<TrsDealChargesCO> getDealChargesByDeal(TrsDealChargesSC trsDealChargesSC) throws BaseException;

    public IISReturnMessagesCO saveDealCharges(List<TrsDealChargesCO> trsDealChargesCO,
    	    TrsDealChargesSC trsDealChargesSC, IISReturnMessagesCO iisReturnMessagesCO) throws BaseException;

    public void validateDealChargesGridInputs(IisDealChargesCO iisDealChargesCO) throws BaseException;

    public List<TrsDealChargesCO> returnPFXCharges(TrsDealChargesSC trsDealChargesSC) throws BaseException;

    // TP#190558; Saheer.Naduthodi; 20/07/2014
    public List<TrsDealChargesCO> applyDealCharges(TrsDealChargesSC trsDealChargesSC) throws BaseException;

    /**
     * To return the Charges from FMS facility
     * 
     * @param trsDealChargesSC
     * @return
     * @throws BaseException
     */
    public List<TrsDealChargesCO> returnDealChargesFromFacility(TrsDealChargesSC trsDealChargesSC) throws BaseException;
    
    // TP# 870190 BAJ Fawas.Kuruvakkottil 30/08/2019
    public IISReturnMessagesCO validateDealChargesForLeasedAsset(List<TrsDealChargesCO> trsDealChargesCOList,
	    List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> assetVendorIncentiveGridList, IISReturnMessagesCO iisReturnMessagesCO,
	    BigDecimal compCode, BigDecimal branchCode, BigDecimal serialNo) throws BaseException;
}
