package com.path.dao.core.jvtypes.impl;

import java.util.List;

import com.path.dao.core.jvtypes.JVTypesDAO;
import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.jvtypes.JVTypeSC;

public class JVTypesDAOImpl extends BaseDAO implements JVTypesDAO
{
    /**
     * Linchu JVType Lookup count
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int getJVTypeLookupCount(JVTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "jvTypesMapper.resultJVTypeLookupMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("jvTypesMapper.selectJVTypeLookupCount", criteria)).intValue();
	return nb;
    }

    /**
     * Linchu JVType Lookup list
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<JV_TYPEVO> getJVTypeLookupList(JVTypeSC criteria) throws DAOException
    {

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "jvTypesMapper.resultJVTypeLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("jvTypesMapper.selectJVTypeLookupList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("jvTypesMapper.selectJVTypeLookupList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * Linchu JVType Dependency
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public JV_TYPEVO checkJVTypeValidation(JVTypeSC criteria) throws DAOException
    {
	return (JV_TYPEVO) getSqlMap().queryForObject("jvTypesMapper.checkJVTypeValidation", criteria);

    }

    // TP#205235; Saheer.Naduthodi; 23/07/2014
    @Override
    public int returnCountJVType(JVTypeSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("jvTypesMapper.returnCountJVType", criteria);
    }
}