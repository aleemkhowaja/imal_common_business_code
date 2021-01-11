package com.path.dao.core.sectors;

import java.util.List;

import com.path.dbmaps.vo.SECTORSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.sectors.SectorsSC;

public interface SectorsDAO
{
    public int sectorsListCount(SectorsSC criteria) throws DAOException;

    public List sectorsList(SectorsSC criteria) throws DAOException;

    public SECTORSVO returnSectorById(SectorsSC criteria) throws DAOException;
}
