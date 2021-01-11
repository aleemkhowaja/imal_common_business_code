package com.path.dao.core.productclass;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public interface ProductClassDAO
{
    public List productClassesList(ProductClassSC productClassSC) throws DAOException;

    public int productClassesListCount(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnProductClassByCode(ProductClassSC productClassSC) throws DAOException;

    public List dealProductClassesList(ProductClassSC productClassSC) throws DAOException;

    public int dealProductClassesListCount(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnDealProductClassByCode(ProductClassSC productClassSC) throws DAOException;

    public List productClassesListFms(ProductClassSC productClassSC) throws DAOException;

    public int productClassesListCountFms(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnProductClassByCodeFms(ProductClassSC productClassSC) throws DAOException;

    public int returnFmsFacilityTypeClassCount(ProductClassSC productClassSC) throws DAOException;

    public List facilityTypeClassesListFms(ProductClassSC productClassSC) throws DAOException;

    public int facilityTypeClassesListCountFms(ProductClassSC productClassSC) throws DAOException;

    public String returnGradeByCif(ProductClassSC productClassSC) throws DAOException;

    // TP#178297; Arun.R.Variyath; 25/06/2014- Start
    public List productClassesListWithoutApp(ProductClassSC productClassSC) throws DAOException;

    public int productClassesListCountWithoutApp(ProductClassSC productClassSC) throws DAOException;
    // TP#178297; Arun.R.Variyath; 25/06/2014- Start

    public List mergeProductClassesList(ProductClassSC productClassSC) throws DAOException;

    public int mergeProductClassesListCount(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnMergeProductClassByCode(ProductClassSC productClassSC) throws DAOException;

    public List mergeproductClassesWithId(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnMergeProductClassById(ProductClassSC productClassSC) throws DAOException;

    public ProductClassCO returnProductClassCodeArRhanu(ProductClassSC productClassSC) throws DAOException;
    
    public Integer productClassesListCountInFms(ProductClassSC productClassSC)throws DAOException;

	public List<ProductClassCO> productClassesListInFms(ProductClassSC productClassSC)throws DAOException;

    public Integer productClassLookupFmsParamCount(ProductClassSC productClassSC) throws DAOException;

    public List productClassLookupFmsParamList(ProductClassSC productClassSC) throws DAOException;

}
