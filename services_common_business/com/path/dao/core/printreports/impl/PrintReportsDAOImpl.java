package com.path.dao.core.printreports.impl;

import java.util.List;

import com.path.dao.core.printreports.PrintReportsDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.printreports.PrintReportsSC;

public class PrintReportsDAOImpl extends BaseDAO implements PrintReportsDAO
{
    @Override
    public int printReportsListCount(PrintReportsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "printReportsMapper.printReportsMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("printReportsMapper.printReportsListCount", criteria)).intValue();
	return nb;
    }
    @Override
    public List printReportsList(PrintReportsSC criteria) throws DAOException
    {
	 List lst;
	 DAOHelper.fixGridMaps(criteria, getSqlMap(), "printReportsMapper.printReportsMap");
	    if(criteria.getNbRec() == -1)
		{
		    lst = getSqlMap().queryForList("printReportsMapper.printReportsList", criteria);
		}
		else
		{
		    lst = getSqlMap().queryForList("printReportsMapper.printReportsList", criteria, criteria.getRecToskip(),
			       criteria.getNbRec());
		}
	    return lst;
    }

  


    
}
