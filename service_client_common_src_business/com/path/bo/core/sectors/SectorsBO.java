package com.path.bo.core.sectors;

import java.util.List;

import com.path.dbmaps.vo.SECTORSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.sectors.SectorsSC;

public interface SectorsBO
{
	public int sectorsListCount(SectorsSC criteria) throws BaseException;
    public List sectorsList(SectorsSC criteria) throws BaseException;
    public SECTORSVO returnSectorById(SectorsSC criteria) throws BaseException;
}
