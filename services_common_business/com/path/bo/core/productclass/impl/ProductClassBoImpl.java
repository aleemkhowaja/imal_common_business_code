package com.path.bo.core.productclass.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.core.productclass.ProductClassBO;
import com.path.dao.core.productclass.ProductClassDAO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public class ProductClassBoImpl extends BaseBO implements ProductClassBO
{

    private ProductClassDAO productClassDAO;
    private IISCommonBO iisCommonBO;

    public ProductClassDAO getProductClassDAO()
    {
	return productClassDAO;
    }

    public void setProductClassDAO(ProductClassDAO productClassDAO)
    {
	this.productClassDAO = productClassDAO;
    }

    @Override
    public int productClassesListCount(ProductClassSC productClassSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return productClassDAO.productClassesListCount(productClassSC);
    }

    @Override
    public List productClassesList(ProductClassSC productClassSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return productClassDAO.productClassesList(productClassSC);
    }

    @Override
    public ProductClassCO returnProductClassByCode(ProductClassSC productClassSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return productClassDAO.returnProductClassByCode(productClassSC);
    }

    @Override
    public int dealProductClassesListCount(ProductClassSC productClassSC1) throws BaseException
    {
	ProductClassSC productClassSC = productClassSC1;
	productClassSC = setLimitParameters(productClassSC);
	return productClassDAO.dealProductClassesListCount(productClassSC);
    }

    @Override
    public List dealProductClassesList(ProductClassSC productClassSC1) throws BaseException
    {
	ProductClassSC productClassSC = productClassSC1;
	productClassSC = setLimitParameters(productClassSC);
	return productClassDAO.dealProductClassesList(productClassSC);
    }

    public ProductClassSC setLimitParameters(ProductClassSC productClassSC) throws BaseException
    {
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(productClassSC.getCompCode());
	iisctrlvoKey.setBRANCH_CODE(productClassSC.getBranchCode());
	IISCTRLVO iisctrlVO = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	if(iisctrlVO == null)
	{
	    throw new BOException();
	}
	BigDecimal categoryCode = productClassSC.getCategoryCode();

	if(NumberUtil.nullToZero(categoryCode).compareTo(BigDecimal.ZERO) == 0)
	{
	    // TP#204636;20/07/2014;George Eapen
	    throw new BOException(901601);
	}

	String checkUserLimit = "N";
	String checkParyLimit = "N";
	if("Y".equals(iisctrlVO.getCHECK_USER_PRODUCT_CLASS_LIMIT())
		|| "Y".equals(iisctrlVO.getCHECK_PARTY_PRODUCT_LIMIT()))
	{
	    if("Y".equals(iisctrlVO.getDEFINE_LIMIT_FOR_BORROWINGS_YN()))
	    {
		if("Y".equals(iisctrlVO.getCHECK_USER_PRODUCT_CLASS_LIMIT()))
		{
		    checkUserLimit = "Y";
		}
		if("Y".equals(iisctrlVO.getCHECK_PARTY_PRODUCT_LIMIT()))
		{
		    checkParyLimit = "Y";
		}
	    }
	    else
	    {
		if(categoryCode.compareTo(new BigDecimal(2)) == 0 || categoryCode.compareTo(new BigDecimal(19)) == 0
			|| categoryCode.compareTo(new BigDecimal(23)) == 0
			|| categoryCode.compareTo(new BigDecimal(25)) == 0)
		{
		    checkUserLimit = "N";
		    checkParyLimit = "N";
		}
		else
		{
		    if("Y".equals(iisctrlVO.getCHECK_USER_PRODUCT_CLASS_LIMIT()))
		    {
			checkUserLimit = "Y";
		    }
		    if("Y".equals(iisctrlVO.getCHECK_PARTY_PRODUCT_LIMIT()))
		    {
			checkParyLimit = "Y";
		    }
		}
	    }
	}

	productClassSC.setCheckParyLimit(checkParyLimit);
	productClassSC.setCheckUserLimit(checkUserLimit);

	return productClassSC;
    }

    /**
     * @param iisCommonBO the iisCommonBO to set
     */
    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    @Override
    public ProductClassCO returnDealProductClassByCode(ProductClassSC productClassSC1) throws BaseException
    {
	ProductClassSC productClassSC = productClassSC1;
	productClassSC = setLimitParameters(productClassSC);
	return productClassDAO.returnDealProductClassByCode(productClassSC);
    }

    @Override
    public int productClassesListCountFms(ProductClassSC productClassSC) throws DAOException
    {
	if(!NumberUtil.isEmptyDecimal(productClassSC.getFacilityType()))
	{
	    if(productClassSC.getFacilityType().compareTo(BigDecimal.valueOf(-1)) == 0)
	    {
		return productClassDAO.productClassesListCountFms(productClassSC);
	    }
	    else
	    {
		int facilityTypeClassCount = productClassDAO.returnFmsFacilityTypeClassCount(productClassSC);
		if(facilityTypeClassCount > 0)
		{
		    return productClassDAO.facilityTypeClassesListCountFms(productClassSC);
		}
	    }
	}
	return productClassDAO.productClassesListCountFms(productClassSC);
    }

    @Override
    public List productClassesListFms(ProductClassSC productClassSC) throws DAOException
    {
	if(!NumberUtil.isEmptyDecimal(productClassSC.getFacilityType()))
	{
	    if(productClassSC.getFacilityType().compareTo(BigDecimal.valueOf(-1)) == 0)
	    {
		return productClassDAO.productClassesListFms(productClassSC);

	    }
	    else
	    {
		int facilityTypeClassCount = productClassDAO.returnFmsFacilityTypeClassCount(productClassSC);
		if(facilityTypeClassCount > 0)
		{
		    return productClassDAO.facilityTypeClassesListFms(productClassSC);
		}
	    }
	}
	return productClassDAO.productClassesListFms(productClassSC);
    }

    @Override
    public ProductClassCO returnProductClassCodeArRhanu(ProductClassSC productClassSC) throws BaseException
    {
	ProductClassCO productClassCO = productClassDAO.returnProductClassCodeArRhanu(productClassSC);
	if(productClassCO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	return productClassCO;
    }

    @Override
    public ProductClassCO returnProductClassByCodeFms(ProductClassSC productClassSC) throws BaseException
    {
	// TP#621590 ;13-Feb-2018;d.james
	ProductClassCO productClassCO = null;
	if("true".equals(productClassSC.getAllTypesFlag()))
	{
	    if(BigDecimal.ZERO.equals(productClassSC.getProductClassCode()))
	    {
		productClassCO = new ProductClassCO();
		productClassCO.setCODE(productClassSC.getProductClassCode());
		productClassCO.setBRIEF_NAME_ENG(productClassSC.getAllTypes());
	    }
	    else
	    {
		productClassCO = productClassDAO.returnProductClassByCodeFms(productClassSC);
		//Azhar ; 1057597 ; 17/8/2020
		if(productClassCO==null)
		{
			throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS_NO_PARAM);	
		}
	    }
	}
	else
	{
	    productClassCO = productClassDAO.returnProductClassByCodeFms(productClassSC);
	}
	return productClassCO;
    }

    @Override
    public String returnGradeByCif(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.returnGradeByCif(productClassSC);
    }

    // TP#178297; Arun.R.Variyath; 25/06/2014- Start
    // Added by Arun for PROV
    @Override
    public int productClassesListCountWithoutApp(ProductClassSC productClassSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return productClassDAO.productClassesListCountWithoutApp(productClassSC);
    }

    // Added by Arun for PROV

    @Override
    public List productClassesListWithoutApp(ProductClassSC productClassSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return productClassDAO.productClassesListWithoutApp(productClassSC);
    }

    // TP#178297; Arun.R.Variyath; 25/06/2014- End

    @Override
    public int mergeProductClassesListCount(ProductClassSC productClassSC) throws BaseException
    {

	return productClassDAO.mergeProductClassesListCount(productClassSC);
    }

    @Override
    public List mergeproductClassesList(ProductClassSC productClassSC) throws BaseException
    {

	return productClassDAO.mergeProductClassesList(productClassSC);
    }

    @Override
    public ProductClassCO returnMergeProductClassByCode(ProductClassSC productClassSC) throws BaseException
    {

	return productClassDAO.returnMergeProductClassByCode(productClassSC);

    }

    @Override
    public List mergeproductClassesWithId(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.mergeproductClassesWithId(productClassSC);
    }

    @Override
    public ProductClassCO returnMergeProductClassById(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.returnMergeProductClassById(productClassSC);
    }

    @Override
    public Integer productClassesListCountInFms(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.productClassesListCountInFms(productClassSC);
    }

    @Override
    public List<ProductClassCO> productClassesListInFms(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.productClassesListInFms(productClassSC);
    }

    @Override
    public Integer productClassLookupFmsParamCount(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.productClassLookupFmsParamCount(productClassSC);
    }

    @Override
    public List productClassLookupFmsParamList(ProductClassSC productClassSC) throws BaseException
    {
	return productClassDAO.productClassLookupFmsParamList(productClassSC);
    }

}
