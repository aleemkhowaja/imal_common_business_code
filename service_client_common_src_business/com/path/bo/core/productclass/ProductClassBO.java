package com.path.bo.core.productclass;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public interface ProductClassBO
{

    public int productClassesListCount(ProductClassSC productClassSC) throws BaseException;

    public List productClassesList(ProductClassSC productClassSC) throws BaseException;

    public ProductClassCO returnProductClassByCode(ProductClassSC productClassSC) throws BaseException;

    /**
     * This method return the count of Product class for Investment Deal screen
     * (Considering Product/User Limit)
     * 
     * @param ProductClassSC
     * @return int
     */
    public int dealProductClassesListCount(ProductClassSC productClassSC) throws BaseException;

    /**
     * This method return the List of Product class for Investment Deal screen
     * (Considering Product/User Limit)
     * 
     * @param ProductClassCO List
     * @return int
     */
    public List dealProductClassesList(ProductClassSC productClassSC) throws BaseException;

    /**
     * This method return the Product class By code for Investment Deal screen
     * (Considering Product/User Limit)
     * 
     * @param ProductClassSC
     * @return ProductClassCO
     */
    public ProductClassCO returnDealProductClassByCode(ProductClassSC productClassSC) throws BaseException;

    public int productClassesListCountFms(ProductClassSC productClassSC) throws BaseException;

    public List productClassesListFms(ProductClassSC productClassSC) throws BaseException;

    public ProductClassCO returnProductClassByCodeFms(ProductClassSC productClassSC) throws BaseException;

    public String returnGradeByCif(ProductClassSC productClassSC) throws BaseException;

    // TP#178297; Arun.R.Variyath; 25/06/2014- Start
    public int productClassesListCountWithoutApp(ProductClassSC productClassSC) throws BaseException;

    public List productClassesListWithoutApp(ProductClassSC productClassSC) throws BaseException;

    // TP#178297; Arun.R.Variyath; 25/06/2014- End
    public int mergeProductClassesListCount(ProductClassSC productClassSC) throws BaseException;

    public List mergeproductClassesList(ProductClassSC productClassSC) throws BaseException;

    public ProductClassCO returnMergeProductClassByCode(ProductClassSC productClassSC) throws BaseException;

    public List mergeproductClassesWithId(ProductClassSC productClassSC) throws BaseException;

    public ProductClassCO returnMergeProductClassById(ProductClassSC productClassSC) throws BaseException;

    public ProductClassCO returnProductClassCodeArRhanu(ProductClassSC productClassSC) throws BaseException;


    public Integer productClassesListCountInFms(ProductClassSC productClassSC) throws BaseException;

    public List<ProductClassCO> productClassesListInFms(ProductClassSC productClassSC) throws BaseException;
    
    public Integer productClassLookupFmsParamCount(ProductClassSC productClassSC) throws BaseException;

    public List productClassLookupFmsParamList(ProductClassSC productClassSC) throws BaseException;
}
