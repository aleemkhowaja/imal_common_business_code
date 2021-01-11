package com.path.dao.core.accountcharges.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.accountcharges.AccountChargesProductsDAO;
import com.path.dbmaps.vo.CTS_SAFEBOX_CHARGESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.accountcharges.AccountChargesSC;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;


public class AccountChargesProductsDAOImpl extends BaseDAO implements AccountChargesProductsDAO
{
	@Override
	public Integer loadSafeboxChargesLookupCount(AccountChargesSC criteria) throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountChargesProductsMapper.safeboxChargesMap");
        return (Integer) getSqlMap().queryForObject("accountChargesProductsMapper.loadSafeboxChargesLookupCount", criteria);
	}

	@Override
	public List<CTS_SAFEBOX_CHARGESVO> loadSafeboxChargesLookup(AccountChargesSC criteria) throws DAOException {
		if(StringUtil.nullToEmpty(criteria.getSidx()).isEmpty())
        {
			criteria.setSidx("CODE");
			criteria.setSord("DESC");
        }
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountChargesProductsMapper.safeboxChargesMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("accountChargesProductsMapper.loadSafeboxChargesLookup", criteria);
        }
        else
        {
            return getSqlMap().queryForList("accountChargesProductsMapper.loadSafeboxChargesLookup", criteria,
            		criteria.getRecToskip(), criteria.getNbRec());
        }
	}

	@Override
	public CTS_SAFEBOX_CHARGESVO loadSafeboxChargesDependency(AccountChargesSC criteria) throws DAOException {
		return (CTS_SAFEBOX_CHARGESVO) getSqlMap().queryForObject("accountChargesProductsMapper.loadSafeboxChargesDependency", criteria);
	}   
}
