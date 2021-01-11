package com.path.dao.core.remittance.impl;

import java.util.List;

import com.path.dao.core.remittance.RemittanceDAO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.remittance.RemittanceSC;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;

@SuppressWarnings("unchecked")
public class RemittanceDAOImpl extends BaseDAO implements RemittanceDAO
{

    public Integer returnRemittanceTypeLookupCount(RemittanceSC remittanceSC) throws DAOException
    {
	DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.remittanceListMap");
	return ((Integer) getSqlMap().queryForObject("remittanceMapper.returnRemittanceTypeLookupCount", remittanceSC));
    }

    public List<REMITTANCEVO> returnRemittanceTypeLookupData(RemittanceSC remittanceSC) throws DAOException
    {
	DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.remittanceListMap");
	if(remittanceSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("remittanceMapper.returnRemittanceTypeLookupData", remittanceSC);
	}
	else
	{
	    return getSqlMap().queryForList("remittanceMapper.returnRemittanceTypeLookupData", remittanceSC,
		    remittanceSC.getRecToskip(), remittanceSC.getNbRec());
	}
    }
    
    /**
     * Return Remittance Type by values Lookup count
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     */
    public Integer returnRemitTypeLookupCount(RemittanceSC remittanceSC) throws DAOException
    {
	DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.remittanceListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("remittanceMapper.returnRemitTypeLookupCount", remittanceSC))
		.intValue();
	return nb;
    }

    /**
     * Return Remittance Type by values Lookup data
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     */
    public List<REMITTANCEVO> returnRemitTypeLookupData(RemittanceSC remittanceSC) throws DAOException
    {
        DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.remittanceListMap");
        if(remittanceSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("remittanceMapper.returnRemitTypeLookupData", remittanceSC);
        }
        else
        {
            return getSqlMap().queryForList("remittanceMapper.returnRemitTypeLookupData", remittanceSC,
                remittanceSC.getRecToskip(), remittanceSC.getNbRec());
        }
    }

    public REMITTANCEVO returnRemittanceTypeByCode(RemittanceSC remittanceSC) throws DAOException
    {
	return (REMITTANCEVO)getSqlMap().queryForObject("remittanceMapper.returnRemittanceTypeByCode", remittanceSC);
    }
    
    
    public Integer returnTrxRemitTypeCodeCount(RemittanceSC remittanceSC) throws DAOException
    {
	DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.trxRemitTypeMap");
	return ((Integer) getSqlMap().queryForObject("remittanceMapper.returnTrxRemitTypeCodeCount", remittanceSC));
    }

    public List<TrxMgntRemtDenomCO> returnTrxRemitTypeCodeData(RemittanceSC remittanceSC) throws DAOException
    {
	DAOHelper.fixGridMaps(remittanceSC, getSqlMap(), "remittanceMapper.trxRemitTypeMap");
	if(remittanceSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("remittanceMapper.returnTrxRemitTypeCodeData", remittanceSC);
	}
	else
	{
	    return getSqlMap().queryForList("remittanceMapper.returnTrxRemitTypeCodeData", remittanceSC,
		    remittanceSC.getRecToskip(), remittanceSC.getNbRec());
	}
    }
}
