package com.path.dao.core.economicsector.impl;

import java.util.List;

import com.path.dao.core.economicsector.EconomicSectorDAO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.economicsector.EconomicSectorSC;

public class EconomicSectorDAOImpl extends BaseDAO implements EconomicSectorDAO
{

    @Override
    public List economicSectorList(EconomicSectorSC economicSectorSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(economicSectorSC.getSidx()).isEmpty())
	{
	    economicSectorSC.setSidx("SECTOR_CODE");
	    economicSectorSC.setSord("ASC");
	}
	if(economicSectorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("economicSectorListMapper.economicSectorList", economicSectorSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(economicSectorSC, getSqlMap(), "economicSectorListMapper.economicSectorList_ResMap");
	    return getSqlMap().queryForList("economicSectorListMapper.economicSectorList", economicSectorSC,
		    economicSectorSC.getRecToskip(), economicSectorSC.getNbRec());
	}
    }

    public int economicSectorListCount(EconomicSectorSC economicSectorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(economicSectorSC, getSqlMap(), "economicSectorListMapper.economicSectorList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("economicSectorListMapper.economicSectorListCount",
		economicSectorSC)).intValue();
	return nb;
    }

    public ECO_SECTORSVO returnDependencyBySectorCode(EconomicSectorSC economicSectorSC) throws DAOException
    {
	return (ECO_SECTORSVO) getSqlMap().queryForObject("economicSectorListMapper.returnDependencyBySectorCode",
		economicSectorSC);
    }

    public int economicSectorAddRefListCount(EconomicSectorSC economicSectorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(economicSectorSC, getSqlMap(), "economicSectorListMapper.economicSectorList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("economicSectorListMapper.economicSectorAddRefListCount",
		economicSectorSC)).intValue();
	return nb;
    }

    public List economicSectorAddRefList(EconomicSectorSC economicSectorSC) throws DAOException
    {
	if(economicSectorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("economicSectorListMapper.economicSectorAddRefList", economicSectorSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(economicSectorSC, getSqlMap(), "economicSectorListMapper.economicSectorList_ResMap");
	    return getSqlMap().queryForList("economicSectorListMapper.economicSectorAddRefList", economicSectorSC,
		    economicSectorSC.getRecToskip(), economicSectorSC.getNbRec());
	}
    }

    @Override
    public ECO_SECTORSVO returnDependencyBySectorCodeforFOM(EconomicSectorSC economicSectorSC) throws DAOException
    {
	return (ECO_SECTORSVO) getSqlMap().queryForObject("economicSectorListMapper.returnDependencyBySectorCodeforFOM",
		economicSectorSC);
    }

    @Override
    public boolean checkIfSubEcoSectorMandatoryInAdmin(EconomicSectorSC economicSectorSC)throws DAOException
    {
	//Hala Al Sheikh - BUG TP770534
	String result = (String) getSqlMap().queryForObject("economicSectorListMapper.checkIfSubEcoSectorMandatoryInAdmin",
		economicSectorSC);
	if(StringUtil.isEmptyString(result))
	{
	    return false;
	}
	else if(("1").equals(result))
	{
	    return true;
	}
	return false;	
    }
}
