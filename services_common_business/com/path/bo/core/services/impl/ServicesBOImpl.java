package com.path.bo.core.services.impl;

import java.util.List;

import com.path.bo.core.services.ServicesBO;
import com.path.dao.core.services.ServicesDAO;
import com.path.dbmaps.vo.SERVICESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.services.ServicesSC;

public class ServicesBOImpl extends BaseBO implements ServicesBO
{
    private ServicesDAO servicesDAO;

    public List<SERVICESVO> returnTerminalIdList(ServicesSC criteria) throws BaseException
    {
	return servicesDAO.returnTerminalIdList(criteria);
    }

    public int returnTerminalIdListCount(ServicesSC criteria) throws BaseException
    {
	return servicesDAO.returnTerminalIdListCount(criteria);
    }

    
    
    
    public ServicesDAO getServicesDAO()
    {
	return servicesDAO;
    }

    public void setServicesDAO(ServicesDAO servicesDAO)
    {
	this.servicesDAO = servicesDAO;
    }

}
