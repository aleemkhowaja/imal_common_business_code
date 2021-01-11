package com.path.bo.core.remittance;

import java.util.List;

import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.remittance.RemittanceSC;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;

public interface RemittanceBO
{

    Integer returnRemittanceTypeLookupCount(RemittanceSC remittanceSC) throws BaseException;

    List<REMITTANCEVO> returnRemittanceTypeLookupData(RemittanceSC remittanceSC) throws BaseException;

    /**
     * Return Remittance Type by values Lookup count
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type (tfa01.pbl)
     */
    Integer returnRemitTypeLookupCount(RemittanceSC remittanceSC) throws BaseException;

    /**
     * Return Remittance Type by values Lookup data
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type (tfa01.pbl)
     */
    List<REMITTANCEVO> returnRemitTypeLookupData(RemittanceSC remittanceSC) throws BaseException;

    /**
     * Return Remittance Type By Code
     * @param remittanceSC
     * @return
     * @throws BaseException
     */
    REMITTANCEVO returnRemittanceTypeByCode(RemittanceSC remittanceSC) throws BaseException;
    
    public Integer returnTrxRemitTypeCodeCount(RemittanceSC remittanceSC) throws BaseException;

    public List<TrxMgntRemtDenomCO> returnTrxRemitTypeCodeData(RemittanceSC remittanceSC) throws BaseException;
}
