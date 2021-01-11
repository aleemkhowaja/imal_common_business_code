package com.path.dao.core.religion;

import java.util.List;

import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.religion.ReligionSC;

public interface ReligionDAO
{
    public int religionListCount(ReligionSC criteria) throws DAOException;
    public List religionList(ReligionSC criteria) throws DAOException;
    public RELIGIONVO returnReligionById(ReligionSC criteria) throws DAOException;
}
