package com.path.dao.core.occupation;

import java.util.List;

import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.occupation.OccupationSC;

public interface OccupationDAO
{
    public List occupationList(OccupationSC occupationSC) throws DAOException;

    public int occupationListCount(OccupationSC occupationSC) throws DAOException;

    public OCCUPATIONSVO returnOccupationById(OccupationSC occupationSC) throws DAOException;

    public List cifOccupationStatusList(OccupationSC occupationSC) throws DAOException;

    public int cifOccupationStatusListCount(OccupationSC occupationSC) throws DAOException;

    public CIF_OCCUPATIONVO returnCifOccupationStatus(OccupationSC occupationSC) throws DAOException;

}
