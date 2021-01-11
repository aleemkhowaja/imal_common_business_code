package com.path.dao.common.global360view.financingDeals;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.TRSDEALVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.FinancingDealDetailsCO;
import com.path.vo.common.global360view.FinancingDealRepaymentPlanCO;
import com.path.vo.common.global360view.FinancingDealStatusCriteriaCO;
import com.path.vo.common.global360view.FinancingDealsCollateralCO;
import com.path.vo.common.global360view.FinancingDealsGuarantorCO;
import com.path.vo.common.global360view.FinancingDealsLimitUtilizationCO;
import com.path.vo.common.global360view.FinancingDealsSC;
import com.path.vo.common.global360view.ProductClassCO;

public interface FinancingDealsDAO
{

    public int getFinancingDealsByProductCount(FinancingDealsSC financingDealsSC) throws DAOException;

    public List<FinancingDealDetailsCO> getFinancingDealsByProduct(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public List<ProductClassCO> getProductClasses(FinancingDealsSC financingDealsSC) throws DAOException;

    public FinancingDealRepaymentPlanCO getRepaymentPlanHeaderDtls(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public int getFinancingDealsRepaymentPlanCount(FinancingDealsSC financingDealsSC) throws DAOException;

    public List<FinancingDealRepaymentPlanCO> getFinancingDealsRepaymentPlanData(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public List<FinancingDealsGuarantorCO> getFinancingDealsGuarantor(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public List<FinancingDealsCollateralCO> getFinancingDealsCollateral(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public List<FinancingDealsLimitUtilizationCO> getFinancingDealsLimitUtilizationDtls(
	    FinancingDealsSC financingDealsSC) throws DAOException;

    public FinancingDealStatusCriteriaCO getDealColorStatusCriteria(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public List<FinancingDealDetailsCO> getFinancingDealsPromissoryNotes(FinancingDealsSC financingDealsSC)
	    throws DAOException;

    public BigDecimal getRepaymentPlanHeaderOutstandingAmt(FinancingDealsSC financingDealsSC) throws DAOException;

    public BigDecimal getRepaymentPlanHeaderRemainingProfit(FinancingDealsSC financingDealsSC) throws DAOException;

    public BigDecimal getRepaymentPlanHeaderNoOfInstalmment(FinancingDealsSC financingDealsSC) throws DAOException;

    public TRSDEALVO getTrsDealValues(FinancingDealsSC financingDealsSC) throws DAOException;

    public String getUpFrontValue(FinancingDealsSC financingDealsSC) throws DAOException;

    FinancingDealRepaymentPlanCO loadUnmaturedInstallmentSummary(FinancingDealsSC financingDealsSC) throws DAOException;
    
    // DBU191081 Muhammed Anas Start
	public Integer getTreasuryForexDealsCount(FinancingDealsSC financingDealsSC) throws DAOException;

	public List<FinancingDealDetailsCO> getTreasuryForexDeals(FinancingDealsSC financingDealsSC) throws DAOException;
    // DBU191081 Muhammed Anas End

}
