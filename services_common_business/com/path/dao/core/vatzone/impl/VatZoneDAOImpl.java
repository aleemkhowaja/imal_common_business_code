package com.path.dao.core.vatzone.impl;

import java.util.List;

import com.path.dao.core.vatzone.VatZoneDAO;
import com.path.dbmaps.vo.CTS_VAT_ZONEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.vatzone.VatZoneSC;

public class VatZoneDAOImpl extends BaseDAO implements VatZoneDAO
{

    public CTS_VAT_ZONEVO returnZoneCodeById(VatZoneSC criteria) throws DAOException
    {

	return (CTS_VAT_ZONEVO) getSqlMap().queryForObject("vatZoneListMapper.returnZoneCodeById", criteria);
    }

    public List vatZoneList(VatZoneSC vatZoneSC) throws DAOException
    {

	if(vatZoneSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("vatZoneListMapper.vatZoneList", vatZoneSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(vatZoneSC, getSqlMap(), "vatZoneListMapper.vatZoneListMap");
	    return getSqlMap().queryForList("vatZoneListMapper.vatZoneList", vatZoneSC, vatZoneSC.getRecToskip(),
		    vatZoneSC.getNbRec());
	}
    }

    @Override
    public int vatZoneListCount(VatZoneSC vatZoneSC) throws DAOException
    {

	DAOHelper.fixGridMaps(vatZoneSC, getSqlMap(), "vatZoneListMapper.vatZoneListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("vatZoneListMapper.vatZoneListCount", vatZoneSC)).intValue();
	return nb;
    }

}
