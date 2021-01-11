package com.path.bo.core.ciftype.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.ciftype.CifTypeBO;
import com.path.dao.core.ciftype.CifTypeDAO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.ciftype.CifTypeSC;

public class CifTypeBOImpl extends BaseBO implements CifTypeBO
{

    private CifTypeDAO cifTypeDAO;

    @Override
    public List cifTypeList(CifTypeSC criteria) throws BaseException
    {

	return cifTypeDAO.cifTypeList(criteria);
    }

    @Override
    public int cifTypeListCount(CifTypeSC criteria) throws BaseException
    {
	return cifTypeDAO.cifTypeListCount(criteria);
    }

    public CifTypeDAO getCifTypeDAO()
    {
	return cifTypeDAO;
    }

    public void setCifTypeDAO(CifTypeDAO cifTypeDAO)
    {
	this.cifTypeDAO = cifTypeDAO;
    }

    @Override
    public RIFCTTVO returnCifTypeById(CifTypeSC criteria) throws BaseException
    {
	// TP#621590 ;13-Feb-2018;d.james
	RIFCTTVO rifcttvo = null;
	if("true".equals(criteria.getAllTypesFlag()))
	{
	    if(BigDecimal.ZERO.equals(criteria.getCifTypeCode()))
	    {
		rifcttvo = new RIFCTTVO();
		rifcttvo.setTYPE_CODE(criteria.getCifTypeCode());
		rifcttvo.setBRIEF_DESC_ENG(criteria.getAllTypes());
	    }
	    else
	    {
		rifcttvo = cifTypeDAO.returnCifTypeById(criteria);
		if(rifcttvo == null || rifcttvo.getTYPE_CODE() == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CIF_TYPE_CODE);//Azhar ; 1057597 ; 17/8/2020
		}
	    }
	}
	else
	{

	    rifcttvo = cifTypeDAO.returnCifTypeById(criteria);
	    if(rifcttvo == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CIF_TYPE_CODE);
	    }
	}
	return rifcttvo;
    }

    public BigDecimal returnIdTypes(CifTypeSC criteria) throws BaseException
    {

	BigDecimal id = cifTypeDAO.returnExpiryDays(criteria);

	if(NumberUtil.isEmptyDecimal(id))
	{
	    throw new BOException(321);
	}
	else
	{
	    return id;
	}
    }

    public String returnCifGender(CifTypeSC criteria) throws BaseException
    {
	return cifTypeDAO.returnCifGender(criteria);
    }
}
