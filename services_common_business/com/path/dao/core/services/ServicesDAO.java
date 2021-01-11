package com.path.dao.core.services;

import java.util.List;

import com.path.dbmaps.vo.SERVICESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.services.ServicesSC;

public interface ServicesDAO
{

    public int returnTerminalIdListCount(ServicesSC criteria) throws DAOException;

    public List<SERVICESVO> returnTerminalIdList(ServicesSC criteria)throws DAOException;
}
