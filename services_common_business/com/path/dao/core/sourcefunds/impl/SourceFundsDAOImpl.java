package com.path.dao.core.sourcefunds.impl;

import java.util.List;

import com.path.dao.core.sourcefunds.SourceFundsDAO;
import com.path.dbmaps.vo.CTS_SOURCE_FUNDSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.sourcefunds.SourceFundsSC;

public class SourceFundsDAOImpl extends BaseDAO implements SourceFundsDAO
{

    public CTS_SOURCE_FUNDSVO returnSourceFundsCodeById(SourceFundsSC sourceFundsSC) throws DAOException
    {

	return (CTS_SOURCE_FUNDSVO) getSqlMap().queryForObject("sourceFundsMapper.returnSourceFundsCodeById", sourceFundsSC);
    }

    public List sourceFundsList(SourceFundsSC sourceFundsSC) throws DAOException
    {

	if(sourceFundsSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("sourceFundsMapper.empStatusList", sourceFundsSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(sourceFundsSC, getSqlMap(), "sourceFundsMapper.sourceFundsListMap");
	    return getSqlMap().queryForList("sourceFundsMapper.sourceFundsList", sourceFundsSC, sourceFundsSC.getRecToskip(),
	    		sourceFundsSC.getNbRec());
	}
    }

    @Override
    public int sourceFundsListCount(SourceFundsSC sourceFundsSC) throws DAOException
    {

	DAOHelper.fixGridMaps(sourceFundsSC, getSqlMap(), "sourceFundsMapper.sourceFundsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("sourceFundsMapper.sourceFundsListCount", sourceFundsSC)).intValue();
	return nb;
    }

}
