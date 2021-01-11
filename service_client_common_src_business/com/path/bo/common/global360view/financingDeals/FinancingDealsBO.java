package com.path.bo.common.global360view.financingDeals;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.FinancingDealDetailsCO;
import com.path.vo.common.global360view.FinancingDealRepaymentPlanCO;
import com.path.vo.common.global360view.FinancingDealStatusCriteriaCO;
import com.path.vo.common.global360view.FinancingDealsCollateralCO;
import com.path.vo.common.global360view.FinancingDealsGuarantorCO;
import com.path.vo.common.global360view.FinancingDealsLimitUtilizationCO;
import com.path.vo.common.global360view.FinancingDealsSC;
import com.path.vo.common.global360view.ProductClassCO;

public interface FinancingDealsBO
{

    public int getFinancingDealsByProductCount(FinancingDealsSC financingDealsSC) throws BaseException;

    public List<FinancingDealDetailsCO> getFinancingDealsByProduct(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public List<ProductClassCO> getProductClasses(FinancingDealsSC financingDealsSC) throws BaseException;

    public FinancingDealRepaymentPlanCO getRepaymentPlanHeaderDtls(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public int getFinancingDealsRepaymentPlanCount(FinancingDealsSC financingDealsSC) throws BaseException;

    public List<FinancingDealRepaymentPlanCO> getFinancingDealsRepaymentPlanData(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public List<FinancingDealsGuarantorCO> getFinancingDealsGuarantor(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public List<FinancingDealsCollateralCO> getFinancingDealsCollateral(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public List<FinancingDealsLimitUtilizationCO> getFinancingDealsLimitUtilizationDtls(
	    FinancingDealsSC financingDealsSC) throws BaseException;

    public FinancingDealStatusCriteriaCO getDealColorStatusCriteria(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public List<FinancingDealDetailsCO> getFinancingDealsPromissoryNotes(FinancingDealsSC financingDealsSC)
	    throws BaseException;

    public FinancingDealsSC printScheduleReport(FinancingDealsSC financingDealsSC) throws BaseException;

    public List<FinancingDealRepaymentPlanCO> loadUnmaturedInstallmentSummary(FinancingDealsSC financingDealsSC)
	    throws BaseException;
    // DBU191081 Muhammed Anas Start
    public Integer getTreasuryForexDealsCount(FinancingDealsSC financingDealsSC) throws BaseException;

    public List<FinancingDealDetailsCO> getTreasuryForexDeals(FinancingDealsSC financingDealsSC) throws BaseException;
     // DBU191081 Muhammed Anas End

}
