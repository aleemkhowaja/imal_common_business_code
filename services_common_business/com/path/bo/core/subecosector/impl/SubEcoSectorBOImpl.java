package com.path.bo.core.subecosector.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.subecosector.SubEcoSectorBO;
import com.path.dao.core.subecosector.SubEcoSectorDAO;
import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.subecosector.SubEcoSectorSC;

public class SubEcoSectorBOImpl extends BaseBO implements SubEcoSectorBO
{

    private SubEcoSectorDAO subEcoSectorDAO;

    public SubEcoSectorDAO getSubEcoSectorDAO()
    {
	return subEcoSectorDAO;
    }

    public void setSubEcoSectorDAO(SubEcoSectorDAO subEcoSectorDAO)
    {
	this.subEcoSectorDAO = subEcoSectorDAO;
    }

    @Override
    public List subEcoSectorList(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	return subEcoSectorDAO.subEcoSectorList(subEcoSectorSC);
    }

    @Override
    public int subEcoSectorListCount(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	return subEcoSectorDAO.subEcoSectorListCount(subEcoSectorSC);
    }

    @Override
    public RIFSECVO returnDependencyBySubSectorCode(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	// TP#621590 ;13-Feb-2018;d.james
	RIFSECVO rifsecvo = null;
	if("true".equals(subEcoSectorSC.getAllTypesFlag()))
	{
	    if(BigDecimal.ZERO.equals(subEcoSectorSC.getSubSectorCode()))
	    {
		rifsecvo = new RIFSECVO();
		rifsecvo.setSUB_SECTOR_CODE(subEcoSectorSC.getSubSectorCode());
		rifsecvo.setBRIEF_DESC_ENG(subEcoSectorSC.getAllTypes());
	    }
	    else
	    {
		rifsecvo = subEcoSectorDAO.returnDependencyBySubSectorCode(subEcoSectorSC);
	    }
	}
	else
	{
	    rifsecvo = subEcoSectorDAO.returnDependencyBySubSectorCode(subEcoSectorSC);
	}
	return rifsecvo;

    }

    public List subEcoSectorParentList(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	return subEcoSectorDAO.subEcoSectorParentList(subEcoSectorSC);

    }

    public int subEcoSectorParentListCount(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	return subEcoSectorDAO.subEcoSectorParentListCount(subEcoSectorSC);
    }

    public RIFSECVO returnDependencyBySubSectorCodeforFOM(SubEcoSectorSC subEcoSectorSC) throws BaseException
    {
	return subEcoSectorDAO.returnDependencyBySubSectorCodeforFOM(subEcoSectorSC);
    }

}
