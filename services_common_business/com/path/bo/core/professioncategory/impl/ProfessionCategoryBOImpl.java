package com.path.bo.core.professioncategory.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.professioncategory.ProfessionCategoryBO;
import com.path.dao.core.professioncategory.ProfessionCategoryDAO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.economicagent.EconomicAgentSC;
import com.path.vo.core.professioncategory.ProfessionCategorySC;


public class ProfessionCategoryBOImpl extends BaseBO implements ProfessionCategoryBO
{
    private ProfessionCategoryDAO professionCategoryDAO;

 
    public List professionCategoryList(ProfessionCategorySC professionCategorySC) throws BaseException
    {
	return professionCategoryDAO.professionCategoryList(professionCategorySC);
    }

    public int professionCategoryListCount(ProfessionCategorySC professionCategorySC) throws BaseException
    {
	return professionCategoryDAO.professionCategoryListCount(professionCategorySC);
    }

    public ProfessionCategoryDAO getProfessionCategoryDAO()
    {
        return professionCategoryDAO;
    }

    public void setProfessionCategoryDAO(ProfessionCategoryDAO professionCategoryDAO)
    {
        this.professionCategoryDAO = professionCategoryDAO;
    }
    
    public CTS_PROFESSION_CATEGORYVO returnDependencyByProfessionCategory(ProfessionCategorySC professionCategorySC) throws BaseException
    {
	CTS_PROFESSION_CATEGORYVO professionCategoryVO = professionCategoryDAO.returnDependencyByProfessionCategory(professionCategorySC);
	if(professionCategoryVO == null) 
	{
	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "prof_category_key" });
	}
	return professionCategoryVO;	
    }   
}
