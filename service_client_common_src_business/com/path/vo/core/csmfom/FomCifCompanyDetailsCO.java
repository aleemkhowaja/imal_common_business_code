package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_ASSETS_RATIOSVO;
import com.path.dbmaps.vo.CIF_COMPANY_DETAILSVO;
import com.path.dbmaps.vo.CIF_COMPANY_DETAILS_2VO;
import com.path.dbmaps.vo.CIF_INCOME_RATIOSVO;
import com.path.dbmaps.vo.CIF_LIABILITIES_RATIOSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifCompanyDetailsCO extends RetailBaseVO
{
    private CIF_COMPANY_DETAILSVO cifCompanyDetailsVO = new CIF_COMPANY_DETAILSVO();
    private CIF_COMPANY_DETAILS_2VO cifCompanyDetails2VO = new CIF_COMPANY_DETAILS_2VO();
    private CIF_ASSETS_RATIOSVO cifAssetsRatiosVO = new CIF_ASSETS_RATIOSVO();
    private CIF_LIABILITIES_RATIOSVO cifLiabilitiesRatiosVO = new CIF_LIABILITIES_RATIOSVO();
    private CIF_INCOME_RATIOSVO cifIncomeRatiosVO = new CIF_INCOME_RATIOSVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();

    // Asset
    private BigDecimal total_current_assets_bs;
    private BigDecimal total_long_term_assets;
    private BigDecimal total_assets;

    // Liabilities
    private BigDecimal total_long_term_debt;
    private BigDecimal total_currenct_liabilities;
    private BigDecimal total_long_term_liabilities;
    private BigDecimal total_deferred_liabilities;
    private BigDecimal total_liabilities;

    // Net Worth and Near Equity
    private BigDecimal total_near_equity;
    private BigDecimal total_net_worth;
    private BigDecimal net_worth_near_equity;

    // Income Statement
    private BigDecimal operating_profit;
    private BigDecimal profit_before_interest_taxes;
    private BigDecimal profit_before_tax;
    private BigDecimal profit_pre_extra_items;
    private BigDecimal net_income;

    // Net Worth Reconciliation
    private BigDecimal total_additions_net_worth;
    private BigDecimal ending_net_worth;

    // Fixed Asset Reconciliation
    private BigDecimal dep_for_period;
    private BigDecimal total_additions_net_fixed_assets;
    private BigDecimal ending_net_fixed_assets;
    private BigDecimal total_deductions;

    // FIRAS
    private BigDecimal cash_marketable_securities;
    private BigDecimal inventory;
    private BigDecimal total_current_assets;
    private BigDecimal total_non_current_assets;
    private BigDecimal current_liabilities;
    private BigDecimal net_trade_receivables;
    private BigDecimal gross_fixed_assets;
    private BigDecimal net_fixed_assets;
    private BigDecimal gross_equity;
    private BigDecimal net_equity;
    private BigDecimal total_liabilities_and_owners_equity;
    private BigDecimal taxes;
    private BigDecimal cogs;
    private BigDecimal gross_profit;
    private BigDecimal operating_ebt;
    private BigDecimal ebt;
    private BigDecimal ebitda;
    private BigDecimal ebit;
    private BigDecimal net_interest_income;
    private BigDecimal total_provisions_other_expenses;
    private BigDecimal net_sales;
    private BigDecimal lt_liabilities;
    private BigDecimal pre_tax_earnings;
    private BigDecimal fcff;// Free Cash Flow to the Firm
    private BigDecimal fcfe;// Free Cash Flow to Equity

    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;

    private Boolean accesByTeller = true;

    //to check if the tabs are opened or not
    private String openFinancialStatement;
    private String openFinancialRatio;
    private String openBeginingBalance;
    
    
    
    /**** cifCompanyDetails2VO re-calculated fields *******/
    private BigDecimal d2_receivables_turnover;
    private BigDecimal d2_inventory_turnover;
    private BigDecimal d2_payables_turnover;
    private BigDecimal d2_total_asset_turnover;
    private BigDecimal d2_fixed_asset_turnover;
    private BigDecimal d2_working_capital_turnover;
    private BigDecimal d2_return_on_equity;
    private BigDecimal d2_return_on_common_equity;
    private BigDecimal d2_return_on_total_capital;
    private BigDecimal d2_basic_eps;
    private BigDecimal d2_diluted_eps;
    private BigDecimal d2_financial_leverage;
    /**** cifCompanyDetails2VO re-calculated fields *******/
    
    private String statusDesc;
    //used for webservice 
    private String delete;
    
    

    public BigDecimal getTotal_deductions()
    {
	return total_deductions;
    }

    public void setTotal_deductions(BigDecimal totalDeductions)
    {
	total_deductions = totalDeductions;
    }

    public BigDecimal getTotal_current_assets_bs()
    {
	return total_current_assets_bs;
    }

    public void setTotal_current_assets_bs(BigDecimal totalCurrentAssetsBs)
    {
	total_current_assets_bs = totalCurrentAssetsBs;
    }

    public BigDecimal getTotal_long_term_assets()
    {
	return total_long_term_assets;
    }

    public void setTotal_long_term_assets(BigDecimal totalLongTermAssets)
    {
	total_long_term_assets = totalLongTermAssets;
    }

    public BigDecimal getTotal_assets()
    {
	return total_assets;
    }

    public void setTotal_assets(BigDecimal totalAssets)
    {
	total_assets = totalAssets;
    }

    public BigDecimal getTotal_long_term_debt()
    {
	return total_long_term_debt;
    }

    public void setTotal_long_term_debt(BigDecimal totalLongTermDebt)
    {
	total_long_term_debt = totalLongTermDebt;
    }

    public BigDecimal getTotal_currenct_liabilities()
    {
	return total_currenct_liabilities;
    }

    public void setTotal_currenct_liabilities(BigDecimal totalCurrenctLiabilities)
    {
	total_currenct_liabilities = totalCurrenctLiabilities;
    }

    public BigDecimal getTotal_long_term_liabilities()
    {
	return total_long_term_liabilities;
    }

    public void setTotal_long_term_liabilities(BigDecimal totalLongTermLiabilities)
    {
	total_long_term_liabilities = totalLongTermLiabilities;
    }

    public BigDecimal getTotal_deferred_liabilities()
    {
	return total_deferred_liabilities;
    }

    public void setTotal_deferred_liabilities(BigDecimal totalDeferredLiabilities)
    {
	total_deferred_liabilities = totalDeferredLiabilities;
    }

    public BigDecimal getTotal_liabilities()
    {
	return total_liabilities;
    }

    public void setTotal_liabilities(BigDecimal totalLiabilities)
    {
	total_liabilities = totalLiabilities;
    }

    public BigDecimal getTotal_near_equity()
    {
	return total_near_equity;
    }

    public void setTotal_near_equity(BigDecimal totalNearEquity)
    {
	total_near_equity = totalNearEquity;
    }

    public BigDecimal getTotal_net_worth()
    {
	return total_net_worth;
    }

    public void setTotal_net_worth(BigDecimal totalNetWorth)
    {
	total_net_worth = totalNetWorth;
    }

    public BigDecimal getNet_worth_near_equity()
    {
	return net_worth_near_equity;
    }

    public void setNet_worth_near_equity(BigDecimal netWorthNearEquity)
    {
	net_worth_near_equity = netWorthNearEquity;
    }

    public BigDecimal getOperating_profit()
    {
	return operating_profit;
    }

    public void setOperating_profit(BigDecimal operatingProfit)
    {
	operating_profit = operatingProfit;
    }

    public BigDecimal getProfit_before_interest_taxes()
    {
	return profit_before_interest_taxes;
    }

    public void setProfit_before_interest_taxes(BigDecimal profitBeforeInterestTaxes)
    {
	profit_before_interest_taxes = profitBeforeInterestTaxes;
    }

    public BigDecimal getProfit_before_tax()
    {
	return profit_before_tax;
    }

    public void setProfit_before_tax(BigDecimal profitBeforeTax)
    {
	profit_before_tax = profitBeforeTax;
    }

    public BigDecimal getProfit_pre_extra_items()
    {
	return profit_pre_extra_items;
    }

    public void setProfit_pre_extra_items(BigDecimal profitPreExtraItems)
    {
	profit_pre_extra_items = profitPreExtraItems;
    }

    public BigDecimal getNet_income()
    {
	return net_income;
    }

    public void setNet_income(BigDecimal netIncome)
    {
	net_income = netIncome;
    }

    public BigDecimal getTotal_additions_net_worth()
    {
	return total_additions_net_worth;
    }

    public void setTotal_additions_net_worth(BigDecimal totalAdditionsNetWorth)
    {
	total_additions_net_worth = totalAdditionsNetWorth;
    }

    public BigDecimal getEnding_net_worth()
    {
	return ending_net_worth;
    }

    public void setEnding_net_worth(BigDecimal endingNetWorth)
    {
	ending_net_worth = endingNetWorth;
    }

    public BigDecimal getDep_for_period()
    {
	return dep_for_period;
    }

    public void setDep_for_period(BigDecimal depForPeriod)
    {
	dep_for_period = depForPeriod;
    }

    public BigDecimal getTotal_additions_net_fixed_assets()
    {
	return total_additions_net_fixed_assets;
    }

    public void setTotal_additions_net_fixed_assets(BigDecimal totalAdditionsNetFixedAssets)
    {
	total_additions_net_fixed_assets = totalAdditionsNetFixedAssets;
    }

    public BigDecimal getEnding_net_fixed_assets()
    {
	return ending_net_fixed_assets;
    }

    public void setEnding_net_fixed_assets(BigDecimal endingNetFixedAssets)
    {
	ending_net_fixed_assets = endingNetFixedAssets;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public CIF_COMPANY_DETAILSVO getCifCompanyDetailsVO()
    {
	return cifCompanyDetailsVO;
    }

    public void setCifCompanyDetailsVO(CIF_COMPANY_DETAILSVO cifCompanyDetailsVO)
    {
	this.cifCompanyDetailsVO = cifCompanyDetailsVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public CIF_COMPANY_DETAILS_2VO getCifCompanyDetails2VO()
    {
	return cifCompanyDetails2VO;
    }

    public void setCifCompanyDetails2VO(CIF_COMPANY_DETAILS_2VO cifCompanyDetails2VO)
    {
	this.cifCompanyDetails2VO = cifCompanyDetails2VO;
    }

    public CIF_ASSETS_RATIOSVO getCifAssetsRatiosVO()
    {
	return cifAssetsRatiosVO;
    }

    public void setCifAssetsRatiosVO(CIF_ASSETS_RATIOSVO cifAssetsRatiosVO)
    {
	this.cifAssetsRatiosVO = cifAssetsRatiosVO;
    }

    public CIF_LIABILITIES_RATIOSVO getCifLiabilitiesRatiosVO()
    {
	return cifLiabilitiesRatiosVO;
    }

    public void setCifLiabilitiesRatiosVO(CIF_LIABILITIES_RATIOSVO cifLiabilitiesRatiosVO)
    {
	this.cifLiabilitiesRatiosVO = cifLiabilitiesRatiosVO;
    }

    public CIF_INCOME_RATIOSVO getCifIncomeRatiosVO()
    {
	return cifIncomeRatiosVO;
    }

    public void setCifIncomeRatiosVO(CIF_INCOME_RATIOSVO cifIncomeRatiosVO)
    {
	this.cifIncomeRatiosVO = cifIncomeRatiosVO;
    }

    public BigDecimal getCurrent_liabilities()
    {
	return current_liabilities;
    }

    public void setCurrent_liabilities(BigDecimal currentLiabilities)
    {
	current_liabilities = currentLiabilities;
    }

    public BigDecimal getNet_trade_receivables()
    {
	return net_trade_receivables;
    }

    public void setNet_trade_receivables(BigDecimal netTradeReceivables)
    {
	net_trade_receivables = netTradeReceivables;
    }

    public BigDecimal getGross_fixed_assets()
    {
	return gross_fixed_assets;
    }

    public void setGross_fixed_assets(BigDecimal grossFixedAssets)
    {
	gross_fixed_assets = grossFixedAssets;
    }

    public BigDecimal getNet_fixed_assets()
    {
	return net_fixed_assets;
    }

    public void setNet_fixed_assets(BigDecimal netFixedAssets)
    {
	net_fixed_assets = netFixedAssets;
    }

    public BigDecimal getGross_equity()
    {
	return gross_equity;
    }

    public void setGross_equity(BigDecimal grossEquity)
    {
	gross_equity = grossEquity;
    }

    public BigDecimal getTaxes()
    {
	return taxes;
    }

    public void setTaxes(BigDecimal taxes)
    {
	this.taxes = taxes;
    }

    public BigDecimal getCogs()
    {
	return cogs;
    }

    public void setCogs(BigDecimal cogs)
    {
	this.cogs = cogs;
    }

    public BigDecimal getGross_profit()
    {
	return gross_profit;
    }

    public void setGross_profit(BigDecimal grossProfit)
    {
	gross_profit = grossProfit;
    }

    public BigDecimal getOperating_ebt()
    {
	return operating_ebt;
    }

    public void setOperating_ebt(BigDecimal operatingEbt)
    {
	operating_ebt = operatingEbt;
    }

    public BigDecimal getEbt()
    {
	return ebt;
    }

    public void setEbt(BigDecimal ebt)
    {
	this.ebt = ebt;
    }

    public BigDecimal getEbitda()
    {
	return ebitda;
    }

    public void setEbitda(BigDecimal ebitda)
    {
	this.ebitda = ebitda;
    }

    public BigDecimal getEbit()
    {
	return ebit;
    }

    public void setEbit(BigDecimal ebit)
    {
	this.ebit = ebit;
    }

    public BigDecimal getTotal_provisions_other_expenses()
    {
	return total_provisions_other_expenses;
    }

    public void setTotal_provisions_other_expenses(BigDecimal totalProvisionsOtherExpenses)
    {
	total_provisions_other_expenses = totalProvisionsOtherExpenses;
    }

    public BigDecimal getNet_sales()
    {
	return net_sales;
    }

    public void setNet_sales(BigDecimal netSales)
    {
	net_sales = netSales;
    }

    public BigDecimal getLt_liabilities()
    {
	return lt_liabilities;
    }

    public void setLt_liabilities(BigDecimal ltLiabilities)
    {
	lt_liabilities = ltLiabilities;
    }

    public BigDecimal getFcff()
    {
	return fcff;
    }

    public void setFcff(BigDecimal fcff)
    {
	this.fcff = fcff;
    }

    public BigDecimal getFcfe()
    {
	return fcfe;
    }

    public void setFcfe(BigDecimal fcfe)
    {
	this.fcfe = fcfe;
    }

    public BigDecimal getTotal_current_assets()
    {
	return total_current_assets;
    }

    public void setTotal_current_assets(BigDecimal totalCurrentAssets)
    {
	total_current_assets = totalCurrentAssets;
    }

    public BigDecimal getTotal_non_current_assets()
    {
	return total_non_current_assets;
    }

    public void setTotal_non_current_assets(BigDecimal totalNonCurrentAssets)
    {
	total_non_current_assets = totalNonCurrentAssets;
    }

    public BigDecimal getNet_equity()
    {
	return net_equity;
    }

    public void setNet_equity(BigDecimal netEquity)
    {
	net_equity = netEquity;
    }

    public BigDecimal getTotal_liabilities_and_owners_equity()
    {
	return total_liabilities_and_owners_equity;
    }

    public void setTotal_liabilities_and_owners_equity(BigDecimal totalLiabilitiesAndOwnersEquity)
    {
	total_liabilities_and_owners_equity = totalLiabilitiesAndOwnersEquity;
    }

    public BigDecimal getNet_interest_income()
    {
	return net_interest_income;
    }

    public void setNet_interest_income(BigDecimal netInterestIncome)
    {
	net_interest_income = netInterestIncome;
    }

    public BigDecimal getPre_tax_earnings()
    {
	return pre_tax_earnings;
    }

    public void setPre_tax_earnings(BigDecimal preTaxEarnings)
    {
	pre_tax_earnings = preTaxEarnings;
    }

    public BigDecimal getInventory()
    {
	return inventory;
    }

    public void setInventory(BigDecimal inventory)
    {
	this.inventory = inventory;
    }

    public BigDecimal getCash_marketable_securities()
    {
	return cash_marketable_securities;
    }

    public void setCash_marketable_securities(BigDecimal cashMarketableSecurities)
    {
	cash_marketable_securities = cashMarketableSecurities;
    }

    public String getOpenFinancialStatement()
    {
        return openFinancialStatement;
    }

    public void setOpenFinancialStatement(String openFinancialStatement)
    {
        this.openFinancialStatement = openFinancialStatement;
    }

    public String getOpenFinancialRatio()
    {
        return openFinancialRatio;
    }

    public void setOpenFinancialRatio(String openFinancialRatio)
    {
        this.openFinancialRatio = openFinancialRatio;
    }

    public String getOpenBeginingBalance()
    {
        return openBeginingBalance;
    }

    public void setOpenBeginingBalance(String openBeginingBalance)
    {
        this.openBeginingBalance = openBeginingBalance;
    }

    public BigDecimal getD2_receivables_turnover()
    {
        return d2_receivables_turnover;
    }

    public void setD2_receivables_turnover(BigDecimal d2ReceivablesTurnover)
    {
        d2_receivables_turnover = d2ReceivablesTurnover;
    }

    public BigDecimal getD2_inventory_turnover()
    {
        return d2_inventory_turnover;
    }

    public void setD2_inventory_turnover(BigDecimal d2InventoryTurnover)
    {
        d2_inventory_turnover = d2InventoryTurnover;
    }

    public BigDecimal getD2_payables_turnover()
    {
        return d2_payables_turnover;
    }

    public void setD2_payables_turnover(BigDecimal d2PayablesTurnover)
    {
        d2_payables_turnover = d2PayablesTurnover;
    }

    public BigDecimal getD2_total_asset_turnover()
    {
        return d2_total_asset_turnover;
    }

    public void setD2_total_asset_turnover(BigDecimal d2TotalAssetTurnover)
    {
        d2_total_asset_turnover = d2TotalAssetTurnover;
    }

    public BigDecimal getD2_fixed_asset_turnover()
    {
        return d2_fixed_asset_turnover;
    }

    public void setD2_fixed_asset_turnover(BigDecimal d2FixedAssetTurnover)
    {
        d2_fixed_asset_turnover = d2FixedAssetTurnover;
    }

    public BigDecimal getD2_working_capital_turnover()
    {
        return d2_working_capital_turnover;
    }

    public void setD2_working_capital_turnover(BigDecimal d2WorkingCapitalTurnover)
    {
        d2_working_capital_turnover = d2WorkingCapitalTurnover;
    }

    public BigDecimal getD2_return_on_equity()
    {
        return d2_return_on_equity;
    }

    public void setD2_return_on_equity(BigDecimal d2ReturnOnEquity)
    {
        d2_return_on_equity = d2ReturnOnEquity;
    }

    public BigDecimal getD2_return_on_common_equity()
    {
        return d2_return_on_common_equity;
    }

    public void setD2_return_on_common_equity(BigDecimal d2ReturnOnCommonEquity)
    {
        d2_return_on_common_equity = d2ReturnOnCommonEquity;
    }

    public BigDecimal getD2_return_on_total_capital()
    {
        return d2_return_on_total_capital;
    }

    public void setD2_return_on_total_capital(BigDecimal d2ReturnOnTotalCapital)
    {
        d2_return_on_total_capital = d2ReturnOnTotalCapital;
    }

    public BigDecimal getD2_basic_eps()
    {
        return d2_basic_eps;
    }

    public void setD2_basic_eps(BigDecimal d2BasicEps)
    {
        d2_basic_eps = d2BasicEps;
    }

    public BigDecimal getD2_diluted_eps()
    {
        return d2_diluted_eps;
    }

    public void setD2_diluted_eps(BigDecimal d2DilutedEps)
    {
        d2_diluted_eps = d2DilutedEps;
    }

    public BigDecimal getD2_financial_leverage()
    {
        return d2_financial_leverage;
    }

    public void setD2_financial_leverage(BigDecimal d2FinancialLeverage)
    {
        d2_financial_leverage = d2FinancialLeverage;
    }

    public String getDelete()
    {
        return delete;
    }

    public void setDelete(String delete)
    {
        this.delete = delete;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }

    
}
