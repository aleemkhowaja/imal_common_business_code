package com.path.bo.core.residencetypes.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.residencetypes.ResidenceTypesBO;
import com.path.dao.core.residencetypes.ResidenceTypesDAO;
import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

public class ResidenceTypesBOImpl extends BaseBO implements ResidenceTypesBO
{
	private ResidenceTypesDAO residenceTypesDAO;
	@Override
	public List residenceTypesList(ResidenceTypesSC criteria) throws BaseException
	{
		return residenceTypesDAO.residenceTypesList(criteria);
	}

	@Override
	public int residenceTypesListCount(ResidenceTypesSC criteria) throws BaseException
	{
		return residenceTypesDAO.residenceTypesListCount(criteria);
	}

	public ResidenceTypesDAO getResidenceTypesDAO()
	{
		return residenceTypesDAO;
	}

	public void setResidenceTypesDAO(ResidenceTypesDAO residenceTypesDAO)
	{
		this.residenceTypesDAO = residenceTypesDAO;
	}

	@Override
	public RESIDENCE_TYPESVO returnDependencyByCode(ResidenceTypesSC criteria) throws BaseException
	{
	    RESIDENCE_TYPESVO  residenceTypesVO = residenceTypesDAO.returnDependencyByCode(criteria);
	    
	    if(residenceTypesVO == null)
	    {
		//throw new BOException(MessageCodes.INVALID_MISSING_CODE);
		throw new BOException(MessageCodes.INVALID_PARAM, new String[] { "Address_Description_key" });
	    }
	    
	    return residenceTypesVO; 
	}

}
