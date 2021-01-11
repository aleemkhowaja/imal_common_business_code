package com.path.bo.core.services;

import java.util.List;

import com.path.dbmaps.vo.SERVICESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.services.ServicesSC;

public interface ServicesBO
{
    public int returnTerminalIdListCount(ServicesSC criteria) throws BaseException;

    public List<SERVICESVO> returnTerminalIdList(ServicesSC criteria) throws BaseException;
}
