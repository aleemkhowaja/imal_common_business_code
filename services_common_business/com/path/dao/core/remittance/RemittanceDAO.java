package com.path.dao.core.remittance;

import java.util.List;

import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.remittance.RemittanceSC;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;

public interface RemittanceDAO
{
    Integer returnRemittanceTypeLookupCount(RemittanceSC remittanceSC) throws DAOException;

    List<REMITTANCEVO> returnRemittanceTypeLookupData(RemittanceSC remittanceSC) throws DAOException;

    /**
     * Return Remittance Type by values Lookup count
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     */
    Integer returnRemitTypeLookupCount(RemittanceSC remittanceSC) throws DAOException;

    /**
     * Return Remittance Type by values Lookup data
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     */
    List<REMITTANCEVO> returnRemitTypeLookupData(RemittanceSC remittanceSC) throws DAOException;

    /**
     * return Remittance Type By Code
     * @param remittanceSC
     * @return
     * @throws DAOException
     */
    public REMITTANCEVO returnRemittanceTypeByCode(RemittanceSC remittanceSC) throws DAOException;
    
    public Integer returnTrxRemitTypeCodeCount(RemittanceSC remittanceSC) throws DAOException;

    public List<TrxMgntRemtDenomCO> returnTrxRemitTypeCodeData(RemittanceSC remittanceSC) throws DAOException;
}
