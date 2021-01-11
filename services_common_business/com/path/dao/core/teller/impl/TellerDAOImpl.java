package com.path.dao.core.teller.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dao.core.teller.TellerDAO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_ALLOWED_USERSVOKey;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.teller.TellerCO;
import com.path.vo.core.teller.TellerSC;

public class TellerDAOImpl extends BaseDAO implements TellerDAO
{

    public Integer returnTellerLookupCount(TellerSC tellerSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("tellerMapper.returnTellerLookupCount", tellerSC);
    }

    public List<CTSTELLERVO> returnTellerLookupData(TellerSC tellerSC) throws DAOException
    {
	DAOHelper.fixGridMaps(tellerSC, getSqlMap(), "tellerMapper.tellerListMap");
	if(tellerSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("tellerMapper.returnTellerLookupData", tellerSC);
	}
	else
	{
	    return getSqlMap().queryForList("tellerMapper.returnTellerLookupData", tellerSC, tellerSC.getRecToskip(),
		    tellerSC.getNbRec());
	}
    }

    @Override
    public CTSTELLERVO returnRoleById(TellerSC criteria) throws DAOException
    {
	return (CTSTELLERVO) getSqlMap().queryForObject("tellerMapper.returnRoleById", criteria);
    }

    @Override
    public String returnShowBranchCondition(TellerSC criteria) throws DAOException
    {
	String result = (String) getSqlMap().queryForObject("tellerMapper.returnShowBranchCondition", criteria);
	return result==null?null: result.toString();
    }

    @Override
    public List<BigDecimal> getAllTellerBranches(TellerSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("tellerMapper.getAllTellerBranches", criteria);
    }

    @Override
    public CTSTELLERVO returnCifReservedNo(TellerSC criteria) throws DAOException
    {
	return (CTSTELLERVO) getSqlMap().queryForObject("tellerMapper.returnCifReservedNo", criteria);
    }
    
	@Override
	public Integer returnRepresentiveLookupCount(TellerSC tellerSC)
			throws DAOException {
		return (Integer) getSqlMap().queryForObject("tellerMapper.returnRepresentiveLookupCount", tellerSC);
	
	}

    @Override
    public Integer returnATMUsersLookupCount(TellerSC tellerSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("tellerMapper.returnATmUsersLookupCount", tellerSC);
    }

    @Override
    public List<CTSTELLER_ALLOWED_USERSVOKey> returnATMUsersLookupData(TellerSC tellerSC) throws DAOException
    {
	DAOHelper.fixGridMaps(tellerSC, getSqlMap(), "tellerMapper.tellerListMap");
	if(tellerSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("tellerMapper.returnATMUsersLookupData", tellerSC);
	}
	else
	{
	    return getSqlMap().queryForList("tellerMapper.returnATMUsersLookupData", tellerSC, tellerSC.getRecToskip(),
		    tellerSC.getNbRec());
	}
    }

    @Override
    public List<TellerCO> returnRepresentiveLookupData(TellerSC tellerSC) throws DAOException
    {

	DAOHelper.fixGridMaps(tellerSC, getSqlMap(), "tellerMapper.representiveListMap");
	if(tellerSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("tellerMapper.returnRepresentiveLookupData", tellerSC);
	}
	else
	{
	    return getSqlMap().queryForList("tellerMapper.returnRepresentiveLookupData", tellerSC,
		    tellerSC.getRecToskip(), tellerSC.getNbRec());
	}

    }

    @Override
    public TellerCO returnRepresentiveDesc(TellerSC criteria) throws DAOException
    {
	return (TellerCO) getSqlMap().queryForObject("tellerMapper.returnRepresentiveLookupDataByID", criteria);
    }

}
