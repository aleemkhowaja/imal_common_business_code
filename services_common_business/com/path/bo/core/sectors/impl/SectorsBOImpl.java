package com.path.bo.core.sectors.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.sectors.SectorsBO;
import com.path.dao.core.sectors.SectorsDAO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.sectors.SectorsSC;

public class SectorsBOImpl extends BaseBO implements SectorsBO
{
	private SectorsDAO sectorsDAO;
	@Override
	public List sectorsList(SectorsSC criteria) throws BaseException
	{
		return sectorsDAO.sectorsList(criteria);
	}

	@Override
	public int sectorsListCount(SectorsSC criteria) throws BaseException
	{
		return sectorsDAO.sectorsListCount(criteria);
	}

	public SectorsDAO getSectorsDAO()
	{
		return sectorsDAO;
	}

	public void setSectorsDAO(SectorsDAO sectorsDAO)
	{
		this.sectorsDAO = sectorsDAO;
	}

	@Override
	public SECTORSVO returnSectorById(SectorsSC criteria) throws BaseException
	{
	    
	    SECTORSVO sectorsVO =  sectorsDAO.returnSectorById(criteria);
	     
	    if(sectorsVO == null)
	    {
		//throw new BOException(MessageCodes.INVALID_MISSING_CODE);
		throw new BOException(MessageCodes.INVALID_PARAM, new String[] { "Sector__key" });
	    }   
	    
	    
		return sectorsVO;
	}

	

}
