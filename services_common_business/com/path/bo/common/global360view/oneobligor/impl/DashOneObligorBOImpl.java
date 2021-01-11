package com.path.bo.common.global360view.oneobligor.impl;

import java.util.List;

import com.path.bo.common.global360view.oneobligor.DashOneObligorBO;
import com.path.dao.common.global360view.oneobligor.DashOneObligorDAO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;

public class DashOneObligorBOImpl extends BaseBO implements DashOneObligorBO
{

   private DashOneObligorDAO dashOneObligorDAO;

  

    @Override
    public DashOneObligorCO fillOneObligorForm(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	
	return dashOneObligorDAO.fillOneObligorForm(dashOneObligorSC);
	
    }

    @Override
    public Integer oneObligorClassCount(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<TRSCLASSVO> oneObligorClassList(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List oneObligorList(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int oneObligorListCount(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public List oneObligorTrendsList(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	return dashOneObligorDAO.oneObligorTrendsList(dashOneObligorSC);
    }

    @Override
    public int oneObligorTrendsListCount(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	return dashOneObligorDAO.oneObligorTrendsListCount(dashOneObligorSC);
    }

    @Override
    public RIFOBTVO returnOneObligorByCode(DashOneObligorSC dashOneObligorSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }

    public DashOneObligorDAO getDashOneObligorDAO()
    {
        return dashOneObligorDAO;
    }

    public void setDashOneObligorDAO(DashOneObligorDAO dashOneObligorDAO)
    {
        this.dashOneObligorDAO = dashOneObligorDAO;
    }

}
