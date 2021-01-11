package com.path.dao.core.professioncategory;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.professioncategory.ProfessionCategorySC;

public interface ProfessionCategoryDAO
{
    public List professionCategoryList(ProfessionCategorySC professionCategorySC) throws DAOException;

    public int professionCategoryListCount(ProfessionCategorySC professionCategorySC) throws DAOException;

    public CTS_PROFESSION_CATEGORYVO returnDependencyByProfessionCategory(ProfessionCategorySC professionCategorySC) throws DAOException;
    
}
