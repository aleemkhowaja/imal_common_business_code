package com.path.bo.core.professioncategory;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.professioncategory.ProfessionCategorySC;


public interface ProfessionCategoryBO
{
    public int professionCategoryListCount(ProfessionCategorySC professionCategorySC) throws BaseException;

    public List professionCategoryList(ProfessionCategorySC professionCategorySC) throws BaseException;

    public CTS_PROFESSION_CATEGORYVO returnDependencyByProfessionCategory(ProfessionCategorySC professionCategorySC) throws BaseException;
    
}
