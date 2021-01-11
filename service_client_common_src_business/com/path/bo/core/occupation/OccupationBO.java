package com.path.bo.core.occupation;

import java.util.List;

import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.occupation.OccupationSC;

public interface OccupationBO
{

    public int occupationListCount(OccupationSC occupationSC) throws BaseException;

    public List occupationList(OccupationSC occupationSC) throws BaseException;

    public OCCUPATIONSVO returnOccupationById(OccupationSC occupationSC) throws BaseException;
    
    public List cifOccupationStatusList(OccupationSC occupationSC) throws BaseException;

    public int cifOccupationStatusListCount(OccupationSC occupationSC) throws BaseException;
    
    public CIF_OCCUPATIONVO returnCifOccupationStatus(OccupationSC occupationSC) throws BaseException;

}
