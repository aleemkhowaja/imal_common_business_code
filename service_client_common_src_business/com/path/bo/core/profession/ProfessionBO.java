package com.path.bo.core.profession;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.profession.ProfessionSC;


public interface ProfessionBO
{
    public int professionListCount(ProfessionSC professionSC) throws BaseException;

    public List professionList(ProfessionSC professionSC) throws BaseException;
 
    public CTS_PROFESSIONVO returnDependencyByProfession(ProfessionSC professionSC) throws BaseException;
}
