package com.path.dao.core.productclass.impl;

import java.util.List;

import com.path.dao.core.productclass.ProductClassDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public class ProductClassDAOImpl extends BaseDAO implements ProductClassDAO
{

    @Override
    public int productClassesListCount(ProductClassSC productClassSC) throws DAOException
    {

	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.productClassListCount", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public List productClassesList(ProductClassSC productClassSC) throws DAOException
    {

	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassList", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.productClassList", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public ProductClassCO returnProductClassByCode(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnProductClassByCode",
		productClassSC);
    }

    @Override
    public List dealProductClassesList(ProductClassSC productClassSC) throws DAOException
    {
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.dealProductClassList", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.dealProductClassList", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public int dealProductClassesListCount(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.dealProductClassListCount", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public ProductClassCO returnDealProductClassByCode(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnDealProductClassByCode",
		productClassSC);
    }

    @Override
    public int productClassesListCountFms(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.productClassListCountFms", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public List productClassesListFms(ProductClassSC productClassSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(productClassSC.getSidx()).isEmpty())
	{
	    productClassSC.setSidx("CODE");
	    productClassSC.setSord("ASC");
	}
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassListFms", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.productClassListFms", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}

    }

    @Override
    public ProductClassCO returnProductClassByCodeFms(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnProductClassByCodeFms",
		productClassSC);
    }

    @Override
    public int returnFmsFacilityTypeClassCount(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.returnFmsFacilityTypeClassCount",
		productClassSC)).intValue();
	return nb;
    }

    @Override
    public int facilityTypeClassesListCountFms(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.facilityTypeClassListCountFms", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public List facilityTypeClassesListFms(ProductClassSC productClassSC) throws DAOException
    {
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassListFms", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.facilityTypeClassListFms", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public String returnGradeByCif(ProductClassSC productClassSC) throws DAOException

    {
	return StringUtil.nullToEmpty(
		((String) getSqlMap().queryForObject("productClassMapper.returnGradeByCif", productClassSC)));
    }

    // TP#178297; Arun.R.Variyath; 25/06/2014- Start
    // Added by Arun for PROV
    @Override
    public int productClassesListCountWithoutApp(ProductClassSC productClassSC) throws DAOException
    {

	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.productClassListCountWithoutApp",
		productClassSC)).intValue();
	return nb;
    }

    // Added by Arun for PROV
    @Override
    public List productClassesListWithoutApp(ProductClassSC productClassSC) throws DAOException
    {

	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassListWithoutApp", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.productClassListWithoutApp", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }
    // TP#178297; Arun.R.Variyath; 25/06/2014- End

    @Override
    public List mergeProductClassesList(ProductClassSC productClassSC) throws DAOException
    {
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.mergeProductClassList", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.mergeProductClassListMap");
	    return getSqlMap().queryForList("productClassMapper.mergeProductClassList", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public int mergeProductClassesListCount(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.mergeProductClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.mergeProductClassListCount", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public ProductClassCO returnMergeProductClassByCode(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnMergeProductClassByCode",
		productClassSC);
    }

    @Override
    public List mergeproductClassesWithId(ProductClassSC productClassSC) throws DAOException
    {
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.mergeproductClassesWithId", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.mergeProductClassListMap");
	    return getSqlMap().queryForList("productClassMapper.mergeproductClassesWithId", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public ProductClassCO returnMergeProductClassById(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnMergeProductClassById",
		productClassSC);
    }

    @Override
    public ProductClassCO returnProductClassCodeArRhanu(ProductClassSC productClassSC) throws DAOException
    {
	return (ProductClassCO) getSqlMap().queryForObject("productClassMapper.returnProductClassCodeArRhanu",
		productClassSC);
    }

    @Override
    public Integer productClassesListCountInFms(ProductClassSC productClassSC) throws DAOException
    {
	DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("productClassMapper.productClassListCountInFms", productClassSC))
		.intValue();
	return nb;
    }

    @Override
    public List<ProductClassCO> productClassesListInFms(ProductClassSC productClassSC) throws DAOException
    {
	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassListInFms", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassListMap");
	    return getSqlMap().queryForList("productClassMapper.productClassListInFms", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}
    }

    @Override
    public Integer productClassLookupFmsParamCount(ProductClassSC productClassSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("productClassMapper.productClassLookupFmsParamCount",
		productClassSC);
    }

    @Override
    public List productClassLookupFmsParamList(ProductClassSC productClassSC) throws DAOException
    {

	if(productClassSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("productClassMapper.productClassLookupFmsParamList", productClassSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(productClassSC, getSqlMap(), "productClassMapper.productClassParamListMap");
	    return getSqlMap().queryForList("productClassMapper.productClassLookupFmsParamList", productClassSC,
		    productClassSC.getRecToskip(), productClassSC.getNbRec());
	}

    }

}
