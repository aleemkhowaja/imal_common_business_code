package com.path.bo.core.profession.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.profession.ProfessionBO;
import com.path.dao.core.profession.ProfessionDAO;
import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.profession.ProfessionSC;


public class ProfessionBOImpl extends BaseBO implements ProfessionBO
{
    private ProfessionDAO professionDAO;

 
    public List professionList(ProfessionSC professionSC) throws BaseException
    {
	return professionDAO.professionList(professionSC);
    }

    public int professionListCount(ProfessionSC professionSC) throws BaseException
    {
	return professionDAO.professionListCount(professionSC);
    }

    public ProfessionDAO getProfessionDAO()
    {
        return professionDAO;
    }

    public void setProfessionDAO(ProfessionDAO professionDAO)
    {
        this.professionDAO = professionDAO;
    }

    public CTS_PROFESSIONVO returnDependencyByProfession(ProfessionSC professionSC) throws BaseException
    {
	CTS_PROFESSIONVO professionVO = professionDAO.returnDependencyByProfession(professionSC);
	if(professionVO == null) 
	{
	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "profession_key" });
	}
	return professionVO;
    }
}
