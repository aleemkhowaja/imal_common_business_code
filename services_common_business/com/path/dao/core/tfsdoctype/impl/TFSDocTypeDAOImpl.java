/**
 * 
 */
package com.path.dao.core.tfsdoctype.impl;

import java.util.List;

import com.path.dao.core.tfsdoctype.TFSDocTypeDAO;
import com.path.dbmaps.vo.TFSDOCTYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.tfsdoctype.TFSDocTypeSC;


/**
 * @author MarwanMaddah
 *
 */
public class TFSDocTypeDAOImpl extends BaseDAO implements TFSDocTypeDAO
{

    @Override
    public List tfsDocTypeList(TFSDocTypeSC tfsDocTypeSC) throws DAOException
    {
	if(tfsDocTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("tfsDocTypeMapper.tfsdoctypeList", tfsDocTypeSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(tfsDocTypeSC, getSqlMap(), "tfsDocTypeMapper.tfsDocTypeListMap");
	    return getSqlMap().queryForList("tfsDocTypeMapper.tfsdoctypeList", tfsDocTypeSC, tfsDocTypeSC.getRecToskip(),
		    tfsDocTypeSC.getNbRec());
	}
    }

    @Override
    public int tfsDocTypeListCount(TFSDocTypeSC tfsDocTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(tfsDocTypeSC, getSqlMap(), "tfsDocTypeMapper.tfsDocTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("tfsDocTypeMapper.tfsdoctypeListCount", tfsDocTypeSC)).intValue();
	return nb;
    }
    
    
    public TFSDOCTYPEVO returnTfsdoctype(TFSDocTypeSC tfsdoctypeSC) throws DAOException
    {
	return (TFSDOCTYPEVO)getSqlMap().queryForObject("tfsDocTypeMapper.returnTfsdoctype", tfsdoctypeSC);
    }

}
