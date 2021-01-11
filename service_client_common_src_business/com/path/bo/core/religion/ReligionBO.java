package com.path.bo.core.religion;

import java.util.List;

import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.religion.ReligionSC;

public interface ReligionBO
{
	public int religionListCount(ReligionSC criteria) throws BaseException;
    public List religionList(ReligionSC criteria) throws BaseException;
    public RELIGIONVO returnReligionById(ReligionSC criteria) throws BaseException;
}
