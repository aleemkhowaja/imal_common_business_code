package com.path.dao.common.global360view.financingDeals.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.common.global360view.financingDeals.FinancingDealsDAO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.FinancingDealDetailsCO;
import com.path.vo.common.global360view.FinancingDealRepaymentPlanCO;
import com.path.vo.common.global360view.FinancingDealStatusCriteriaCO;
import com.path.vo.common.global360view.FinancingDealsCollateralCO;
import com.path.vo.common.global360view.FinancingDealsGuarantorCO;
import com.path.vo.common.global360view.FinancingDealsLimitUtilizationCO;
import com.path.vo.common.global360view.FinancingDealsSC;
import com.path.vo.common.global360view.ProductClassCO;

public class FinancingDealsDAOImpl extends BaseDAO implements FinancingDealsDAO
{

    @Override
    public int getFinancingDealsByProductCount(FinancingDealsSC financingDealsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.financingDealsDetailsCOMap");
	return ((Integer) getSqlMap().queryForObject("financingDealsMapper.selectFinancingDealsByProductCount",
		financingDealsSC)).intValue();
    }

    @Override
    public List<FinancingDealDetailsCO> getFinancingDealsByProduct(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.financingDealsDetailsCOMap");
	if(financingDealsSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("financingDealsMapper.selectFinancingDealsByProductList", financingDealsSC);
	}
	else
	{
	    return getSqlMap().queryForList("financingDealsMapper.selectFinancingDealsByProductList", financingDealsSC,
		    financingDealsSC.getRecToskip(), financingDealsSC.getNbRec());
	}
    }

    @Override
    public List<ProductClassCO> getProductClasses(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return (List<ProductClassCO>) getSqlMap().queryForList("financingDealsMapper.getProductClasses",
		financingDealsSC);
    }

    @Override
    public FinancingDealRepaymentPlanCO getRepaymentPlanHeaderDtls(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	return ((FinancingDealRepaymentPlanCO) getSqlMap()
		.queryForObject("financingDealsMapper.selectRepaymentPlanHeaderDtls", financingDealsSC));
    }

    @Override
    public BigDecimal getRepaymentPlanHeaderOutstandingAmt(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap()
		.queryForObject("financingDealsMapper.selectRepaymentPlanHeaderOutstandingAmount", financingDealsSC));
    }

    @Override
    public BigDecimal getRepaymentPlanHeaderRemainingProfit(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("financingDealsMapper.selectRepaymentPlanHeaderRemainingProfit",
		financingDealsSC));
    }

    @Override
    public BigDecimal getRepaymentPlanHeaderNoOfInstalmment(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("financingDealsMapper.selectRepaymentPlanHeaderNoOfInstallment",
		financingDealsSC));
    }

    @Override
    public TRSDEALVO getTrsDealValues(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return ((TRSDEALVO) getSqlMap().queryForObject("financingDealsMapper.selectgetTrsDealValues",
		financingDealsSC));
    }

    @Override
    public String getUpFrontValue(FinancingDealsSC financingDealsSC) throws DAOException
    {
	return ((String) getSqlMap().queryForObject("financingDealsMapper.selectUpFrontValue", financingDealsSC));
    }

    @Override
    public int getFinancingDealsRepaymentPlanCount(FinancingDealsSC financingDealsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(),
		"financingDealsMapper.financingDealsRepaymentPlanDtlsCOMap");
	return ((Integer) getSqlMap().queryForObject("financingDealsMapper.selectFinancingDealsRepaymentPlanDtlsCount",
		financingDealsSC)).intValue();

    }

    @Override
    public List<FinancingDealRepaymentPlanCO> getFinancingDealsRepaymentPlanData(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	// Libin commented and added as there is not needed when pagination is
	// removed
	// DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(),
	// "financingDealsMapper.financingDealsRepaymentPlanDtlsCOMap");
	// if (financingDealsSC.getNbRec() != -1) {
	// return
	// getSqlMap().queryForList("financingDealsMapper.selectFinancingDealsRepaymentPlanDtlsList",
	// financingDealsSC,
	// financingDealsSC.getRecToskip(),financingDealsSC.getNbRec());
	// } else {
	// return
	// getSqlMap().queryForList("financingDealsMapper.selectFinancingDealsRepaymentPlanDtlsList",
	// financingDealsSC);
	// }
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(),
		"financingDealsMapper.financingDealsRepaymentPlanDtlsCOMap");
	return (List<FinancingDealRepaymentPlanCO>) getSqlMap()
		.queryForList("financingDealsMapper.selectFinancingDealsRepaymentPlanDtlsList", financingDealsSC);
    }

    @Override
    public List<FinancingDealsGuarantorCO> getFinancingDealsGuarantor(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.financingDealsGuarantorCOMap");
	return (List<FinancingDealsGuarantorCO>) getSqlMap()
		.queryForList("financingDealsMapper.selectFinancingDealsGuarantor", financingDealsSC);
    }

    @Override
    public List<FinancingDealsCollateralCO> getFinancingDealsCollateral(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.financingDealsCollateralCOMap");
	return (List<FinancingDealsCollateralCO>) getSqlMap()
		.queryForList("financingDealsMapper.selectFinancingDealsCollateral", financingDealsSC);
    }

    @Override
    public List<FinancingDealsLimitUtilizationCO> getFinancingDealsLimitUtilizationDtls(
	    FinancingDealsSC financingDealsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(),
		"financingDealsMapper.financingDealsLimitUtilizationCOMap");
	return (List<FinancingDealsLimitUtilizationCO>) getSqlMap()
		.queryForList("financingDealsMapper.selectLimitUtilizationDetails", financingDealsSC);
    }

    @Override
    public FinancingDealStatusCriteriaCO getDealColorStatusCriteria(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	return ((FinancingDealStatusCriteriaCO) getSqlMap()
		.queryForObject("financingDealsMapper.getDealColorStatusCriteria", financingDealsSC));
    }

    @Override
    public List<FinancingDealDetailsCO> getFinancingDealsPromissoryNotes(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.financingDealsPromissoryCOMap");
	return (List<FinancingDealDetailsCO>) getSqlMap()
		.queryForList("financingDealsMapper.selectFinancingDealsPromissoryNotes", financingDealsSC);
    }

    @Override
    public FinancingDealRepaymentPlanCO loadUnmaturedInstallmentSummary(FinancingDealsSC financingDealsSC)
	    throws DAOException
    {
	return (FinancingDealRepaymentPlanCO) getSqlMap()
		.queryForObject("financingDealsMapper.loadUnmaturedInstallmentSummary", financingDealsSC);
    }

    // DBU191081 Muhammed Anas Start
    @Override
    public Integer getTreasuryForexDealsCount(FinancingDealsSC financingDealsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.treasuryForexDealsDetailsCOMap");
	return ((Integer) getSqlMap().queryForObject("financingDealsMapper.selectTreasuryForexDealsCount",
		financingDealsSC)).intValue();
    }

    @Override
    public List<FinancingDealDetailsCO> getTreasuryForexDeals(FinancingDealsSC financingDealsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(financingDealsSC, getSqlMap(), "financingDealsMapper.treasuryForexDealsDetailsCOMap");
	if(financingDealsSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("financingDealsMapper.selectTreasuryForexDealsList", financingDealsSC);
	}
	else
	{
	    return getSqlMap().queryForList("financingDealsMapper.selectTreasuryForexDealsList", financingDealsSC,
		    financingDealsSC.getRecToskip(), financingDealsSC.getNbRec());
	}
    }
    // DBU191081 Muhammed Anas End

}
