package com.path.bo.core.remittance.impl;

import java.util.List;

import com.path.bo.core.remittance.RemittanceBO;
import com.path.dao.core.remittance.RemittanceDAO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.remittance.RemittanceSC;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;

public class RemittanceBOImpl extends BaseBO implements RemittanceBO
{
    private RemittanceDAO remittanceDAO;

    public Integer returnRemittanceTypeLookupCount(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnRemittanceTypeLookupCount(remittanceSC);
    }

    public List<REMITTANCEVO> returnRemittanceTypeLookupData(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnRemittanceTypeLookupData(remittanceSC);
    }

    /**
     * Return Remittance Type by values Lookup count
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type (tfa01.pbl)
     */
    public Integer returnRemitTypeLookupCount(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnRemitTypeLookupCount(remittanceSC);
    }

    public REMITTANCEVO returnRemittanceTypeByCode(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnRemittanceTypeByCode(remittanceSC);
    }

    /**
     * Return Remittance Type by values Lookup data
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type (tfa01.pbl)
     */
    public List<REMITTANCEVO> returnRemitTypeLookupData(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnRemitTypeLookupData(remittanceSC);
    }

    public Integer returnTrxRemitTypeCodeCount(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnTrxRemitTypeCodeCount(remittanceSC);
    }

    public List<TrxMgntRemtDenomCO> returnTrxRemitTypeCodeData(RemittanceSC remittanceSC) throws BaseException
    {
        return remittanceDAO.returnTrxRemitTypeCodeData(remittanceSC);
    }

    public RemittanceDAO getRemittanceDAO()
    {
        return remittanceDAO;
    }

    public void setRemittanceDAO(RemittanceDAO remittanceDAO)
    {
        this.remittanceDAO = remittanceDAO;
    }

}
