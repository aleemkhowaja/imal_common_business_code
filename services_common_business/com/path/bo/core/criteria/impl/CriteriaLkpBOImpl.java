package com.path.bo.core.criteria.impl;

import java.util.List;
import com.path.bo.core.criteria.CriteriaLkpBO;
import com.path.dao.core.criteria.CriteriaLkpDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;

public class CriteriaLkpBOImpl extends BaseBO implements CriteriaLkpBO
{

	private CriteriaLkpDAO criteriaLkpDAO;

	public int returnCriteriaLookupCount(GridParamsSC criteria) throws BaseException
	{
		return criteriaLkpDAO.returnCriteriaLookupCount(criteria);
	}

	public List returnCriteriaLookup(GridParamsSC criteria) throws BaseException
	{
		return criteriaLkpDAO.returnCriteriaLookup(criteria);
	}

	public CriteriaLkpDAO getCriteriaLkpDAO()
	{
		return criteriaLkpDAO;
	}

	public void setCriteriaLkpDAO(CriteriaLkpDAO criteriaLkpDAO)
	{
		this.criteriaLkpDAO = criteriaLkpDAO;
	}

}
