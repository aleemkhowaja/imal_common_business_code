package com.path.dao.core.ciftype.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.ciftype.CifTypeDAO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.ciftype.CifTypeSC;
import com.path.vo.core.csmfom.FomSC;

public class CifTypeDAOImpl extends BaseDAO implements CifTypeDAO
{

    @Override
    public List cifTypeList(CifTypeSC criteria) throws DAOException
    {

	if(StringUtil.nullToEmpty(criteria.getSidx()).isEmpty())
	{
	    criteria.setSidx("TYPE_CODE");
	    criteria.setSord("ASC");
	}

	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifTypeMapper.cifTypeList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifTypeMapper.cifTypeListMap");
	    return getSqlMap().queryForList("cifTypeMapper.cifTypeList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int cifTypeListCount(CifTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifTypeMapper.cifTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifTypeMapper.cifTypeListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public RIFCTTVO returnCifTypeById(CifTypeSC criteria) throws DAOException
    {
	return (RIFCTTVO) getSqlMap().queryForObject("cifTypeMapper.returnCifTypeById", criteria);
    }

    public RIFCTTVO returnCifAgeDet(CifTypeSC criteria) throws DAOException
    {
	return (RIFCTTVO) getSqlMap().queryForObject("cifTypeMapper.returnAgeDet", criteria);
    }

    public BigDecimal returnExpiryDays(CifTypeSC criteria) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifTypeMapper.returnExpiryDays", criteria);
    }

    public String returnCifGender(CifTypeSC criteria) throws DAOException
    {
	String result = (String) getSqlMap().queryForObject("cifTypeMapper.returnCifGender", criteria);
	if(result == null)
	{
	    return "";
	}
	else
	{
	    return result;
	}
    }
    @Override
    public void deleteKycYmcRelatedData(FomSC fomSC) throws DAOException
    {
	getSqlMap().delete("cifTypeMapper.deleteKycYmcRelatedData",fomSC);
    }
}
