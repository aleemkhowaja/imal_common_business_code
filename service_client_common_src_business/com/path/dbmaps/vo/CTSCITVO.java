package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTSCITVO extends CTSCITVOKey
{

    /**
     * added by khalid for Testing only This field corresponds to the database
     * column PFT_CY
     */

    private String ROUNDING_TYPE;
    private BigDecimal ROUNDING_NEAREST;

    private String CALCULATE_DEDUCT_LOSS_YN;
    /**
     * This field corresponds to the database column PROV_LOSS_CY
     */
    private BigDecimal PROV_LOSS_CY;

    /**
     * This field corresponds to the database column PROV_LOSS_GL
     */
    private BigDecimal PROV_LOSS_GL;

    /**
     * This field corresponds to the database column PROV_LOSS_CIF
     */
    private BigDecimal PROV_LOSS_CIF;

    /**
     * This field corresponds to the database column PROV_LOSS_SL
     */
    private BigDecimal PROV_LOSS_SL;

    /**
     * This field corresponds to the database column CESS_TAX_CY
     */

    private BigDecimal CESS_TAX_CY;

    /**
     * This field corresponds to the database column CESS_TAX_GL
     */
    private BigDecimal CESS_TAX_GL;

    /**
     * This field corresponds to the database column CESS_TAX_CIF
     */
    private BigDecimal CESS_TAX_CIF;

    /**
     * This field corresponds to the database column CESS_TAX_SL
     */
    private BigDecimal CESS_TAX_SL;
    /**
     * This field corresponds to the database column PAY_LOSS_CY
     */
    private BigDecimal PAY_LOSS_CY;

    /**
     * This field corresponds to the database column PAY_LOSS_GL
     */
    private BigDecimal PAY_LOSS_GL;

    /**
     * This field corresponds to the database column PAY_LOSS_CIF
     */
    private BigDecimal PAY_LOSS_CIF;

    /**
     * This field corresponds to the database column PAY_LOSS_SL
     */
    private BigDecimal PAY_LOSS_SL;
    /**
     * This field corresponds to the database column CTSCIT.BRANCH_CODE by
     * khalid for testing only
     */

    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSCIT.MODARIB_RATE
     */
    private BigDecimal MODARIB_RATE;

    /**
     * This field corresponds to the database column CTSCIT.MODARIB_CY
     */
    private BigDecimal MODARIB_CY;

    /**
     * This field corresponds to the database column CTSCIT.MODARIB_GL
     */
    private BigDecimal MODARIB_GL;

    /**
     * This field corresponds to the database column CTSCIT.MODARIB_CIF
     */
    private BigDecimal MODARIB_CIF;

    /**
     * This field corresponds to the database column CTSCIT.MODARIB_SL
     */
    private BigDecimal MODARIB_SL;

    /**
     * This field corresponds to the database column CTSCIT.RISK_PROV
     */
    private BigDecimal RISK_PROV;

    /**
     * This field corresponds to the database column CTSCIT.RISK_CY
     */
    private BigDecimal RISK_CY;

    /**
     * This field corresponds to the database column CTSCIT.RISK_GL
     */
    private BigDecimal RISK_GL;

    /**
     * This field corresponds to the database column CTSCIT.RISK_CIF
     */
    private BigDecimal RISK_CIF;

    /**
     * This field corresponds to the database column CTSCIT.RISK_SL
     */
    private BigDecimal RISK_SL;

    /**
     * This field corresponds to the database column CTSCIT.COF_CY
     */
    private BigDecimal COF_CY;

    /**
     * This field corresponds to the database column CTSCIT.COF_GL
     */
    private BigDecimal COF_GL;

    /**
     * This field corresponds to the database column CTSCIT.COF_CIF
     */
    private BigDecimal COF_CIF;

    /**
     * This field corresponds to the database column CTSCIT.COF_SL
     */
    private BigDecimal COF_SL;

    /**
     * This field corresponds to the database column CTSCIT.PENALTY_IND
     */
    private String PENALTY_IND;

    /**
     * This field corresponds to the database column CTSCIT.DEPOSIT_IND
     */
    private String DEPOSIT_IND;

    /**
     * This field corresponds to the database column CTSCIT.CHARGE_IND
     */
    private String CHARGE_IND;

    /**
     * This field corresponds to the database column CTSCIT.FOREX_IND
     */
    private String FOREX_IND;

    /**
     * This field corresponds to the database column CTSCIT.WEI_AL_MUDHARABAH
     */
    private BigDecimal WEI_AL_MUDHARABAH;

    /**
     * This field corresponds to the database column
     * CTSCIT.INCLUDE_DEMAND_DEPOSIT
     */
    private BigDecimal INCLUDE_DEMAND_DEPOSIT;

    /**
     * This field corresponds to the database column
     * CTSCIT.POST_PROFIT_INTO_ACOUNTS
     */
    private BigDecimal POST_PROFIT_INTO_ACOUNTS;

    /**
     * This field corresponds to the database column CTSCIT.PROFIT_FROM
     */
    private String PROFIT_FROM;

    /**
     * This field corresponds to the database column CTSCIT.ASSETS_REVENUE
     */
    private String ASSETS_REVENUE;

    /**
     * This field corresponds to the database column CTSCIT.ALL_BRANCHES
     */
    private String ALL_BRANCHES;

    /**
     * This field corresponds to the database column CTSCIT.PCS_JV
     */
    private BigDecimal PCS_JV;

    /**
     * This field corresponds to the database column CTSCIT.ACCRUAL_JV
     */
    private BigDecimal ACCRUAL_JV;

    /**
     * This field corresponds to the database column CTSCIT.MIN_CY
     */
    private BigDecimal MIN_CY;

    /**
     * This field corresponds to the database column CTSCIT.MIN_GL
     */
    private BigDecimal MIN_GL;

    /**
     * This field corresponds to the database column CTSCIT.MIN_CIF
     */
    private BigDecimal MIN_CIF;

    /**
     * This field corresponds to the database column CTSCIT.MIN_SL
     */
    private BigDecimal MIN_SL;

    /**
     * This field corresponds to the database column CTSCIT.DAYS_BASIS
     */
    private String DAYS_BASIS;

    /**
     * This field corresponds to the database column CTSCIT.AR_BASIS
     */
    private String AR_BASIS;

    /**
     * This field corresponds to the database column CTSCIT.LIABILITY_BASIS
     */
    private String LIABILITY_BASIS;

    /**
     * This field corresponds to the database column CTSCIT.TR_CODE
     */
    private BigDecimal TR_CODE;

    /**
     * This field corresponds to the database column CTSCIT.OTHER_CY
     */
    private BigDecimal OTHER_CY;

    /**
     * This field corresponds to the database column CTSCIT.OTHER_GL
     */
    private BigDecimal OTHER_GL;

    /**
     * This field corresponds to the database column CTSCIT.OTHER_CIF
     */
    private BigDecimal OTHER_CIF;

    /**
     * This field corresponds to the database column CTSCIT.OTHER_SL
     */
    private BigDecimal OTHER_SL;

    /**
     * This field corresponds to the database column CTSCIT.COF_ENTRY
     */
    private String COF_ENTRY;

    /**
     * This field corresponds to the database column CTSCIT.ACC_ENTRY
     */
    private String ACC_ENTRY;

    /**
     * This field corresponds to the database column CTSCIT.TEMPLATE_CODE
     */
    private BigDecimal TEMPLATE_CODE;

    /**
     * This field corresponds to the database column CTSCIT.OTHER_PROVISION_NAME
     */
    private String OTHER_PROVISION_NAME;

    /**
     * This field corresponds to the database column CTSCIT.CONSOLIDATED_ENTRY
     */
    private String CONSOLIDATED_ENTRY;

    /**
     * This field corresponds to the database column CTSCIT.GEN_ACC_PERIODICITY
     */
    private String GEN_ACC_PERIODICITY;

    /**
     * This field corresponds to the database column CTSCIT.ACC_FROM
     */
    private String ACC_FROM;

    /**
     * This field corresponds to the database column CTSCIT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTSCIT.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTSCIT.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CTSCIT.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTSCIT.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column CTSCIT.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTSCIT.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column CTSCIT.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CTSCIT.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column CTSCIT.TAX_TR_CODE
     */
    private BigDecimal TAX_TR_CODE;

    /**
     * This field corresponds to the database column CTSCIT.ZAK_TR_CODE
     */
    private BigDecimal ZAK_TR_CODE;

    /**
     * This field corresponds to the database column CTSCIT.CONCAT_ACC
     */
    private String CONCAT_ACC;

    /**
     * This field corresponds to the database column CTSCIT.INCLUDE_EQUITY
     */
    private String INCLUDE_EQUITY;

    /**
     * This field corresponds to the database column CTSCIT.VALUE_DATE_TO
     */
    private String VALUE_DATE_TO;

    /**
     * This field corresponds to the database column CTSCIT.COMPUTATION
     */
    private String COMPUTATION;

    /**
     * This field corresponds to the database column CTSCIT.IBIS_FLAG
     */
    private String IBIS_FLAG;

    /**
     * This field corresponds to the database column CTSCIT.EQUITY_ACC_BR
     */
    private BigDecimal EQUITY_ACC_BR;

    /**
     * This field corresponds to the database column CTSCIT.EQUITY_ACC_CY
     */
    private BigDecimal EQUITY_ACC_CY;

    /**
     * This field corresponds to the database column CTSCIT.EQUITY_ACC_GL
     */
    private BigDecimal EQUITY_ACC_GL;

    /**
     * This field corresponds to the database column CTSCIT.EQUITY_ACC_CIF
     */
    private BigDecimal EQUITY_ACC_CIF;

    /**
     * This field corresponds to the database column CTSCIT.EQUITY_ACC_SL
     */
    private BigDecimal EQUITY_ACC_SL;

    /**
     * This field corresponds to the database column CTSCIT.INCLUDE_EQUITY_ACC
     */
    private String INCLUDE_EQUITY_ACC;

    /**
     * This field corresponds to the database column CTSCIT.RECALC_FLAG
     */
    private String RECALC_FLAG;

    /**
     * This field corresponds to the database column CTSCIT.FINAL_SPECIFIC_LOG
     */
    private String FINAL_SPECIFIC_LOG;

    /**
     * This field corresponds to the database column CTSCIT.CONTRIBUTION_CY
     */
    private BigDecimal CONTRIBUTION_CY;

    /**
     * This field corresponds to the database column CTSCIT.CONTRIBUTION_GL
     */
    private BigDecimal CONTRIBUTION_GL;

    /**
     * This field corresponds to the database column CTSCIT.CONTRIBUTION_CIF
     */
    private BigDecimal CONTRIBUTION_CIF;

    /**
     * This field corresponds to the database column CTSCIT.CONTRIBUTION_SL
     */
    private BigDecimal CONTRIBUTION_SL;

    /**
     * This field corresponds to the database column CTSCIT.PFT_EQU_CY
     */
    private BigDecimal PFT_EQU_CY;

    /**
     * This field corresponds to the database column CTSCIT.PFT_EQU_GL
     */
    private BigDecimal PFT_EQU_GL;

    /**
     * This field corresponds to the database column CTSCIT.PFT_EQU_CIF
     */
    private BigDecimal PFT_EQU_CIF;

    /**
     * This field corresponds to the database column CTSCIT.PFT_EQU_SL
     */
    private BigDecimal PFT_EQU_SL;

    /**
     * This field corresponds to the database column CTSCIT.GRAUSS_PFT_BASIS
     */
    private String GRAUSS_PFT_BASIS;

    /**
     * This field corresponds to the database column CTSCIT.APPLY_CHARGES
     */
    private String APPLY_CHARGES;

    /**
     * This field corresponds to the database column CTSCIT.CHRG_TR_CODE
     */
    private BigDecimal CHRG_TR_CODE;

    /**
     * This field corresponds to the database column CTSCIT.APPROVE_FINAL_RUN
     */
    private String APPROVE_FINAL_RUN;

    /**
     * This field corresponds to the database column CTSCIT.APPLY_DIR_IND_CALC
     */
    private String APPLY_DIR_IND_CALC;

    /**
     * This field corresponds to the database column CTSCIT.POST_EQUITY_PROFIT
     */
    private String POST_EQUITY_PROFIT;

    /**
     * This field corresponds to the database column CTSCIT.POST_ACC_ENTRIES
     */
    private String POST_ACC_ENTRIES;

    /**
     * This field corresponds to the database column
     * CTSCIT.WRITE_OFF_POST_ACC_ENTRIES
     */
    private String WRITE_OFF_POST_ACC_ENTRIES;

    /**
     * This field corresponds to the database column
     * CTSCIT.FINAL_RUN_SEPARATE_ENTRIES
     */
    private String FINAL_RUN_SEPARATE_ENTRIES;

    /**
     * This field corresponds to the database column CTSCIT.CONCAT_DATE_DESC
     */
    private String CONCAT_DATE_DESC;

    /**
     * This field corresponds to the database column CTSCIT.EXCL_BACC_PFCT
     */
    private String EXCL_BACC_PFCT;

    /**
     * This field corresponds to the database column CTSCIT.POPULATE_PT_ACCR
     */
    private String POPULATE_PT_ACCR;

    /**
     * This field corresponds to the database column
     * CTSCIT.MODARIB_EQUITY_CONTRIBUTION
     */
    private BigDecimal MODARIB_EQUITY_CONTRIBUTION;

    /**
     * This field corresponds to the database column
     * CTSCIT.PROFIT_CALCULATION_METHOD
     */
    private BigDecimal PROFIT_CALCULATION_METHOD;

    /**
     * This field corresponds to the database column
     * CTSCIT.DIST_GROSS_PFT_TO_PARTICIPANT
     */
    private BigDecimal DIST_GROSS_PFT_TO_PARTICIPANT;

    /**
     * This field corresponds to the database column CTSCIT.COF_RISK_CY
     */
    private BigDecimal COF_RISK_CY;

    /**
     * This field corresponds to the database column CTSCIT.COF_RISK_GL
     */
    private BigDecimal COF_RISK_GL;

    /**
     * This field corresponds to the database column CTSCIT.COF_RISK_CIF
     */
    private BigDecimal COF_RISK_CIF;

    /**
     * This field corresponds to the database column CTSCIT.COF_RISK_SL
     */
    private BigDecimal COF_RISK_SL;

    /**
     * This field corresponds to the database column CTSCIT.MIN_BR
     */
    private BigDecimal MIN_BR;

    /**
     * This field corresponds to the database column
     * CTSCIT.RISK_PROV_ON_BANK_REV_YN
     */
    private String RISK_PROV_ON_BANK_REV_YN;

    /**
     * This field corresponds to the database column
     * CTSCIT.CONSIDER_WAIVED_PROFIT_YN
     */
    private String CONSIDER_WAIVED_PROFIT_YN;

    /**
     * This field corresponds to the database column
     * CTSCIT.RISK_PROV_ON_BANK_REV_PERC
     */
    private BigDecimal RISK_PROV_ON_BANK_REV_PERC;

    /**
     * This field corresponds to the database column
     * CTSCIT.EXCLUDE_MODARIB_ENTRIES_YN
     */
    private String EXCLUDE_MODARIB_ENTRIES_YN;

    /**
     * This field corresponds to the database column
     * CALC_CURR_MTH_PFT_BY_GROSSRATE
     */
    private String CALC_CURR_MTH_PFT_BY_GROSSRATE;

    /**
     * This field corresponds to the database column CTSCIT.YEARLY_RATE_CALC_YN
     */
    private String YEARLY_RATE_CALC_YN;

    private String ROR_BASED_ON_ACCUM_AMT_YN;
    
    /**
     * This field corresponds to the database column CTSCIT.HIBA_ACC_CY
     */
    private BigDecimal HIBA_ACC_CY;

    /**
     * This field corresponds to the database column CTSCIT.HIBA_ACC_GL
     */
    private BigDecimal HIBA_ACC_GL;

    /**
     * This field corresponds to the database column CTSCIT.HIBA_ACC_CIF
     */
    private BigDecimal HIBA_ACC_CIF;

    /**
     * This field corresponds to the database column CTSCIT.HIBA_ACC_SL
     */
    private BigDecimal HIBA_ACC_SL;

    /**
     * This field corresponds to the database column
     * CTSCIT.EXCLUDE_BELOW_MIN_ACCOUNTS_YN
     */
    private String EXCLUDE_BELOW_MIN_ACCOUNTS_YN;
    
    
    /**
     * This field corresponds to the database column
     * CTSCIT.CONS_EXPENSE_JV_ON_LASTDAY_YN
     */
    private String CONS_EXPENSE_JV_ON_LASTDAY_YN;

    
    
	
	/**
     * This field corresponds to the database column CTSCIT.CONSIDER_EQUITY_DEBIT_BAL_YN
     */
    private BigDecimal CONSIDER_EQUITY_DEBIT_BAL_YN;
	
	
	 /**
     * This field corresponds to the database column CTSCIT.TRANS_DATE_TO
     */
    private String TRANS_DATE_TO;
        

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.BRANCH_CODE
     * 
     * @return the value of CTSCIT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.BRANCH_CODE
     * 
     * @param BRANCH_CODE the value for CTSCIT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE)
    {
	this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_RATE
     * 
     * @return the value of CTSCIT.MODARIB_RATE
     */
    public BigDecimal getMODARIB_RATE()
    {
	return MODARIB_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_RATE
     * 
     * @param MODARIB_RATE the value for CTSCIT.MODARIB_RATE
     */
    public void setMODARIB_RATE(BigDecimal MODARIB_RATE)
    {
	this.MODARIB_RATE = MODARIB_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_CY
     * 
     * @return the value of CTSCIT.MODARIB_CY
     */
    public BigDecimal getMODARIB_CY()
    {
	return MODARIB_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_CY
     * 
     * @param MODARIB_CY the value for CTSCIT.MODARIB_CY
     */
    public void setMODARIB_CY(BigDecimal MODARIB_CY)
    {
	this.MODARIB_CY = MODARIB_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_GL
     * 
     * @return the value of CTSCIT.MODARIB_GL
     */
    public BigDecimal getMODARIB_GL()
    {
	return MODARIB_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_GL
     * 
     * @param MODARIB_GL the value for CTSCIT.MODARIB_GL
     */
    public void setMODARIB_GL(BigDecimal MODARIB_GL)
    {
	this.MODARIB_GL = MODARIB_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_CIF
     * 
     * @return the value of CTSCIT.MODARIB_CIF
     */
    public BigDecimal getMODARIB_CIF()
    {
	return MODARIB_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_CIF
     * 
     * @param MODARIB_CIF the value for CTSCIT.MODARIB_CIF
     */
    public void setMODARIB_CIF(BigDecimal MODARIB_CIF)
    {
	this.MODARIB_CIF = MODARIB_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_SL
     * 
     * @return the value of CTSCIT.MODARIB_SL
     */
    public BigDecimal getMODARIB_SL()
    {
	return MODARIB_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_SL
     * 
     * @param MODARIB_SL the value for CTSCIT.MODARIB_SL
     */
    public void setMODARIB_SL(BigDecimal MODARIB_SL)
    {
	this.MODARIB_SL = MODARIB_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_PROV
     * 
     * @return the value of CTSCIT.RISK_PROV
     */
    public BigDecimal getRISK_PROV()
    {
	return RISK_PROV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_PROV
     * 
     * @param RISK_PROV the value for CTSCIT.RISK_PROV
     */
    public void setRISK_PROV(BigDecimal RISK_PROV)
    {
	this.RISK_PROV = RISK_PROV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_CY
     * 
     * @return the value of CTSCIT.RISK_CY
     */
    public BigDecimal getRISK_CY()
    {
	return RISK_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_CY
     * 
     * @param RISK_CY the value for CTSCIT.RISK_CY
     */
    public void setRISK_CY(BigDecimal RISK_CY)
    {
	this.RISK_CY = RISK_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_GL
     * 
     * @return the value of CTSCIT.RISK_GL
     */
    public BigDecimal getRISK_GL()
    {
	return RISK_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_GL
     * 
     * @param RISK_GL the value for CTSCIT.RISK_GL
     */
    public void setRISK_GL(BigDecimal RISK_GL)
    {
	this.RISK_GL = RISK_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_CIF
     * 
     * @return the value of CTSCIT.RISK_CIF
     */
    public BigDecimal getRISK_CIF()
    {
	return RISK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_CIF
     * 
     * @param RISK_CIF the value for CTSCIT.RISK_CIF
     */
    public void setRISK_CIF(BigDecimal RISK_CIF)
    {
	this.RISK_CIF = RISK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_SL
     * 
     * @return the value of CTSCIT.RISK_SL
     */
    public BigDecimal getRISK_SL()
    {
	return RISK_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_SL
     * 
     * @param RISK_SL the value for CTSCIT.RISK_SL
     */
    public void setRISK_SL(BigDecimal RISK_SL)
    {
	this.RISK_SL = RISK_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_CY
     * 
     * @return the value of CTSCIT.COF_CY
     */
    public BigDecimal getCOF_CY()
    {
	return COF_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_CY
     * 
     * @param COF_CY the value for CTSCIT.COF_CY
     */
    public void setCOF_CY(BigDecimal COF_CY)
    {
	this.COF_CY = COF_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_GL
     * 
     * @return the value of CTSCIT.COF_GL
     */
    public BigDecimal getCOF_GL()
    {
	return COF_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_GL
     * 
     * @param COF_GL the value for CTSCIT.COF_GL
     */
    public void setCOF_GL(BigDecimal COF_GL)
    {
	this.COF_GL = COF_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_CIF
     * 
     * @return the value of CTSCIT.COF_CIF
     */
    public BigDecimal getCOF_CIF()
    {
	return COF_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_CIF
     * 
     * @param COF_CIF the value for CTSCIT.COF_CIF
     */
    public void setCOF_CIF(BigDecimal COF_CIF)
    {
	this.COF_CIF = COF_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_SL
     * 
     * @return the value of CTSCIT.COF_SL
     */
    public BigDecimal getCOF_SL()
    {
	return COF_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_SL
     * 
     * @param COF_SL the value for CTSCIT.COF_SL
     */
    public void setCOF_SL(BigDecimal COF_SL)
    {
	this.COF_SL = COF_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PENALTY_IND
     * 
     * @return the value of CTSCIT.PENALTY_IND
     */
    public String getPENALTY_IND()
    {
	return PENALTY_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PENALTY_IND
     * 
     * @param PENALTY_IND the value for CTSCIT.PENALTY_IND
     */
    public void setPENALTY_IND(String PENALTY_IND)
    {
	this.PENALTY_IND = PENALTY_IND == null ? null : PENALTY_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DEPOSIT_IND
     * 
     * @return the value of CTSCIT.DEPOSIT_IND
     */
    public String getDEPOSIT_IND()
    {
	return DEPOSIT_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DEPOSIT_IND
     * 
     * @param DEPOSIT_IND the value for CTSCIT.DEPOSIT_IND
     */
    public void setDEPOSIT_IND(String DEPOSIT_IND)
    {
	this.DEPOSIT_IND = DEPOSIT_IND == null ? null : DEPOSIT_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CHARGE_IND
     * 
     * @return the value of CTSCIT.CHARGE_IND
     */
    public String getCHARGE_IND()
    {
	return CHARGE_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CHARGE_IND
     * 
     * @param CHARGE_IND the value for CTSCIT.CHARGE_IND
     */
    public void setCHARGE_IND(String CHARGE_IND)
    {
	this.CHARGE_IND = CHARGE_IND == null ? null : CHARGE_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.FOREX_IND
     * 
     * @return the value of CTSCIT.FOREX_IND
     */
    public String getFOREX_IND()
    {
	return FOREX_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.FOREX_IND
     * 
     * @param FOREX_IND the value for CTSCIT.FOREX_IND
     */
    public void setFOREX_IND(String FOREX_IND)
    {
	this.FOREX_IND = FOREX_IND == null ? null : FOREX_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.WEI_AL_MUDHARABAH
     * 
     * @return the value of CTSCIT.WEI_AL_MUDHARABAH
     */
    public BigDecimal getWEI_AL_MUDHARABAH()
    {
	return WEI_AL_MUDHARABAH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.WEI_AL_MUDHARABAH
     * 
     * @param WEI_AL_MUDHARABAH the value for CTSCIT.WEI_AL_MUDHARABAH
     */
    public void setWEI_AL_MUDHARABAH(BigDecimal WEI_AL_MUDHARABAH)
    {
	this.WEI_AL_MUDHARABAH = WEI_AL_MUDHARABAH;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.INCLUDE_DEMAND_DEPOSIT
     * 
     * @return the value of CTSCIT.INCLUDE_DEMAND_DEPOSIT
     */
    public BigDecimal getINCLUDE_DEMAND_DEPOSIT()
    {
	return INCLUDE_DEMAND_DEPOSIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.INCLUDE_DEMAND_DEPOSIT
     * 
     * @param INCLUDE_DEMAND_DEPOSIT the value for CTSCIT.INCLUDE_DEMAND_DEPOSIT
     */
    public void setINCLUDE_DEMAND_DEPOSIT(BigDecimal INCLUDE_DEMAND_DEPOSIT)
    {
	this.INCLUDE_DEMAND_DEPOSIT = INCLUDE_DEMAND_DEPOSIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.POST_PROFIT_INTO_ACOUNTS
     * 
     * @return the value of CTSCIT.POST_PROFIT_INTO_ACOUNTS
     */
    public BigDecimal getPOST_PROFIT_INTO_ACOUNTS()
    {
	return POST_PROFIT_INTO_ACOUNTS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.POST_PROFIT_INTO_ACOUNTS
     * 
     * @param POST_PROFIT_INTO_ACOUNTS the value for
     *            CTSCIT.POST_PROFIT_INTO_ACOUNTS
     */
    public void setPOST_PROFIT_INTO_ACOUNTS(BigDecimal POST_PROFIT_INTO_ACOUNTS)
    {
	this.POST_PROFIT_INTO_ACOUNTS = POST_PROFIT_INTO_ACOUNTS;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PROFIT_FROM
     * 
     * @return the value of CTSCIT.PROFIT_FROM
     */
    public String getPROFIT_FROM()
    {
	return PROFIT_FROM;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PROFIT_FROM
     * 
     * @param PROFIT_FROM the value for CTSCIT.PROFIT_FROM
     */
    public void setPROFIT_FROM(String PROFIT_FROM)
    {
	this.PROFIT_FROM = PROFIT_FROM == null ? null : PROFIT_FROM.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ASSETS_REVENUE
     * 
     * @return the value of CTSCIT.ASSETS_REVENUE
     */
    public String getASSETS_REVENUE()
    {
	return ASSETS_REVENUE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ASSETS_REVENUE
     * 
     * @param ASSETS_REVENUE the value for CTSCIT.ASSETS_REVENUE
     */
    public void setASSETS_REVENUE(String ASSETS_REVENUE)
    {
	this.ASSETS_REVENUE = ASSETS_REVENUE == null ? null : ASSETS_REVENUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ALL_BRANCHES
     * 
     * @return the value of CTSCIT.ALL_BRANCHES
     */
    public String getALL_BRANCHES()
    {
	return ALL_BRANCHES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ALL_BRANCHES
     * 
     * @param ALL_BRANCHES the value for CTSCIT.ALL_BRANCHES
     */
    public void setALL_BRANCHES(String ALL_BRANCHES)
    {
	this.ALL_BRANCHES = ALL_BRANCHES == null ? null : ALL_BRANCHES.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PCS_JV
     * 
     * @return the value of CTSCIT.PCS_JV
     */
    public BigDecimal getPCS_JV()
    {
	return PCS_JV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PCS_JV
     * 
     * @param PCS_JV the value for CTSCIT.PCS_JV
     */
    public void setPCS_JV(BigDecimal PCS_JV)
    {
	this.PCS_JV = PCS_JV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ACCRUAL_JV
     * 
     * @return the value of CTSCIT.ACCRUAL_JV
     */
    public BigDecimal getACCRUAL_JV()
    {
	return ACCRUAL_JV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ACCRUAL_JV
     * 
     * @param ACCRUAL_JV the value for CTSCIT.ACCRUAL_JV
     */
    public void setACCRUAL_JV(BigDecimal ACCRUAL_JV)
    {
	this.ACCRUAL_JV = ACCRUAL_JV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MIN_CY
     * 
     * @return the value of CTSCIT.MIN_CY
     */
    public BigDecimal getMIN_CY()
    {
	return MIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MIN_CY
     * 
     * @param MIN_CY the value for CTSCIT.MIN_CY
     */
    public void setMIN_CY(BigDecimal MIN_CY)
    {
	this.MIN_CY = MIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MIN_GL
     * 
     * @return the value of CTSCIT.MIN_GL
     */
    public BigDecimal getMIN_GL()
    {
	return MIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MIN_GL
     * 
     * @param MIN_GL the value for CTSCIT.MIN_GL
     */
    public void setMIN_GL(BigDecimal MIN_GL)
    {
	this.MIN_GL = MIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MIN_CIF
     * 
     * @return the value of CTSCIT.MIN_CIF
     */
    public BigDecimal getMIN_CIF()
    {
	return MIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MIN_CIF
     * 
     * @param MIN_CIF the value for CTSCIT.MIN_CIF
     */
    public void setMIN_CIF(BigDecimal MIN_CIF)
    {
	this.MIN_CIF = MIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MIN_SL
     * 
     * @return the value of CTSCIT.MIN_SL
     */
    public BigDecimal getMIN_SL()
    {
	return MIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MIN_SL
     * 
     * @param MIN_SL the value for CTSCIT.MIN_SL
     */
    public void setMIN_SL(BigDecimal MIN_SL)
    {
	this.MIN_SL = MIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DAYS_BASIS
     * 
     * @return the value of CTSCIT.DAYS_BASIS
     */
    public String getDAYS_BASIS()
    {
	return DAYS_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DAYS_BASIS
     * 
     * @param DAYS_BASIS the value for CTSCIT.DAYS_BASIS
     */
    public void setDAYS_BASIS(String DAYS_BASIS)
    {
	this.DAYS_BASIS = DAYS_BASIS == null ? null : DAYS_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.AR_BASIS
     * 
     * @return the value of CTSCIT.AR_BASIS
     */
    public String getAR_BASIS()
    {
	return AR_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.AR_BASIS
     * 
     * @param AR_BASIS the value for CTSCIT.AR_BASIS
     */
    public void setAR_BASIS(String AR_BASIS)
    {
	this.AR_BASIS = AR_BASIS == null ? null : AR_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.LIABILITY_BASIS
     * 
     * @return the value of CTSCIT.LIABILITY_BASIS
     */
    public String getLIABILITY_BASIS()
    {
	return LIABILITY_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.LIABILITY_BASIS
     * 
     * @param LIABILITY_BASIS the value for CTSCIT.LIABILITY_BASIS
     */
    public void setLIABILITY_BASIS(String LIABILITY_BASIS)
    {
	this.LIABILITY_BASIS = LIABILITY_BASIS == null ? null : LIABILITY_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.TR_CODE
     * 
     * @return the value of CTSCIT.TR_CODE
     */
    public BigDecimal getTR_CODE()
    {
	return TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.TR_CODE
     * 
     * @param TR_CODE the value for CTSCIT.TR_CODE
     */
    public void setTR_CODE(BigDecimal TR_CODE)
    {
	this.TR_CODE = TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.OTHER_CY
     * 
     * @return the value of CTSCIT.OTHER_CY
     */
    public BigDecimal getOTHER_CY()
    {
	return OTHER_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.OTHER_CY
     * 
     * @param OTHER_CY the value for CTSCIT.OTHER_CY
     */
    public void setOTHER_CY(BigDecimal OTHER_CY)
    {
	this.OTHER_CY = OTHER_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.OTHER_GL
     * 
     * @return the value of CTSCIT.OTHER_GL
     */
    public BigDecimal getOTHER_GL()
    {
	return OTHER_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.OTHER_GL
     * 
     * @param OTHER_GL the value for CTSCIT.OTHER_GL
     */
    public void setOTHER_GL(BigDecimal OTHER_GL)
    {
	this.OTHER_GL = OTHER_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.OTHER_CIF
     * 
     * @return the value of CTSCIT.OTHER_CIF
     */
    public BigDecimal getOTHER_CIF()
    {
	return OTHER_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.OTHER_CIF
     * 
     * @param OTHER_CIF the value for CTSCIT.OTHER_CIF
     */
    public void setOTHER_CIF(BigDecimal OTHER_CIF)
    {
	this.OTHER_CIF = OTHER_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.OTHER_SL
     * 
     * @return the value of CTSCIT.OTHER_SL
     */
    public BigDecimal getOTHER_SL()
    {
	return OTHER_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.OTHER_SL
     * 
     * @param OTHER_SL the value for CTSCIT.OTHER_SL
     */
    public void setOTHER_SL(BigDecimal OTHER_SL)
    {
	this.OTHER_SL = OTHER_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_ENTRY
     * 
     * @return the value of CTSCIT.COF_ENTRY
     */
    public String getCOF_ENTRY()
    {
	return COF_ENTRY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_ENTRY
     * 
     * @param COF_ENTRY the value for CTSCIT.COF_ENTRY
     */
    public void setCOF_ENTRY(String COF_ENTRY)
    {
	this.COF_ENTRY = COF_ENTRY == null ? null : COF_ENTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ACC_ENTRY
     * 
     * @return the value of CTSCIT.ACC_ENTRY
     */
    public String getACC_ENTRY()
    {
	return ACC_ENTRY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ACC_ENTRY
     * 
     * @param ACC_ENTRY the value for CTSCIT.ACC_ENTRY
     */
    public void setACC_ENTRY(String ACC_ENTRY)
    {
	this.ACC_ENTRY = ACC_ENTRY == null ? null : ACC_ENTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.TEMPLATE_CODE
     * 
     * @return the value of CTSCIT.TEMPLATE_CODE
     */
    public BigDecimal getTEMPLATE_CODE()
    {
	return TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.TEMPLATE_CODE
     * 
     * @param TEMPLATE_CODE the value for CTSCIT.TEMPLATE_CODE
     */
    public void setTEMPLATE_CODE(BigDecimal TEMPLATE_CODE)
    {
	this.TEMPLATE_CODE = TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.OTHER_PROVISION_NAME
     * 
     * @return the value of CTSCIT.OTHER_PROVISION_NAME
     */
    public String getOTHER_PROVISION_NAME()
    {
	return OTHER_PROVISION_NAME;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.OTHER_PROVISION_NAME
     * 
     * @param OTHER_PROVISION_NAME the value for CTSCIT.OTHER_PROVISION_NAME
     */
    public void setOTHER_PROVISION_NAME(String OTHER_PROVISION_NAME)
    {
	this.OTHER_PROVISION_NAME = OTHER_PROVISION_NAME == null ? null : OTHER_PROVISION_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONSOLIDATED_ENTRY
     * 
     * @return the value of CTSCIT.CONSOLIDATED_ENTRY
     */
    public String getCONSOLIDATED_ENTRY()
    {
	return CONSOLIDATED_ENTRY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONSOLIDATED_ENTRY
     * 
     * @param CONSOLIDATED_ENTRY the value for CTSCIT.CONSOLIDATED_ENTRY
     */
    public void setCONSOLIDATED_ENTRY(String CONSOLIDATED_ENTRY)
    {
	this.CONSOLIDATED_ENTRY = CONSOLIDATED_ENTRY == null ? null : CONSOLIDATED_ENTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.GEN_ACC_PERIODICITY
     * 
     * @return the value of CTSCIT.GEN_ACC_PERIODICITY
     */
    public String getGEN_ACC_PERIODICITY()
    {
	return GEN_ACC_PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.GEN_ACC_PERIODICITY
     * 
     * @param GEN_ACC_PERIODICITY the value for CTSCIT.GEN_ACC_PERIODICITY
     */
    public void setGEN_ACC_PERIODICITY(String GEN_ACC_PERIODICITY)
    {
	this.GEN_ACC_PERIODICITY = GEN_ACC_PERIODICITY == null ? null : GEN_ACC_PERIODICITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ACC_FROM
     * 
     * @return the value of CTSCIT.ACC_FROM
     */
    public String getACC_FROM()
    {
	return ACC_FROM;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ACC_FROM
     * 
     * @param ACC_FROM the value for CTSCIT.ACC_FROM
     */
    public void setACC_FROM(String ACC_FROM)
    {
	this.ACC_FROM = ACC_FROM == null ? null : ACC_FROM.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.STATUS
     * 
     * @return the value of CTSCIT.STATUS
     */
    public String getSTATUS()
    {
	return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.STATUS
     * 
     * @param STATUS the value for CTSCIT.STATUS
     */
    public void setSTATUS(String STATUS)
    {
	this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CREATED_BY
     * 
     * @return the value of CTSCIT.CREATED_BY
     */
    public String getCREATED_BY()
    {
	return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CREATED_BY
     * 
     * @param CREATED_BY the value for CTSCIT.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY)
    {
	this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DATE_CREATED
     * 
     * @return the value of CTSCIT.DATE_CREATED
     */
    public Date getDATE_CREATED()
    {
	return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DATE_CREATED
     * 
     * @param DATE_CREATED the value for CTSCIT.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED)
    {
	this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.APPROVED_BY
     * 
     * @return the value of CTSCIT.APPROVED_BY
     */
    public String getAPPROVED_BY()
    {
	return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.APPROVED_BY
     * 
     * @param APPROVED_BY the value for CTSCIT.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY)
    {
	this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DATE_APPROVED
     * 
     * @return the value of CTSCIT.DATE_APPROVED
     */
    public Date getDATE_APPROVED()
    {
	return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DATE_APPROVED
     * 
     * @param DATE_APPROVED the value for CTSCIT.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED)
    {
	this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODIFIED_BY
     * 
     * @return the value of CTSCIT.MODIFIED_BY
     */
    public String getMODIFIED_BY()
    {
	return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODIFIED_BY
     * 
     * @param MODIFIED_BY the value for CTSCIT.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY)
    {
	this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DATE_MODIFIED
     * 
     * @return the value of CTSCIT.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED()
    {
	return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DATE_MODIFIED
     * 
     * @param DATE_MODIFIED the value for CTSCIT.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED)
    {
	this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DELETED_BY
     * 
     * @return the value of CTSCIT.DELETED_BY
     */
    public String getDELETED_BY()
    {
	return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DELETED_BY
     * 
     * @param DELETED_BY the value for CTSCIT.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY)
    {
	this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DATE_DELETED
     * 
     * @return the value of CTSCIT.DATE_DELETED
     */
    public Date getDATE_DELETED()
    {
	return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DATE_DELETED
     * 
     * @param DATE_DELETED the value for CTSCIT.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED)
    {
	this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.TAX_TR_CODE
     * 
     * @return the value of CTSCIT.TAX_TR_CODE
     */
    public BigDecimal getTAX_TR_CODE()
    {
	return TAX_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.TAX_TR_CODE
     * 
     * @param TAX_TR_CODE the value for CTSCIT.TAX_TR_CODE
     */
    public void setTAX_TR_CODE(BigDecimal TAX_TR_CODE)
    {
	this.TAX_TR_CODE = TAX_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.ZAK_TR_CODE
     * 
     * @return the value of CTSCIT.ZAK_TR_CODE
     */
    public BigDecimal getZAK_TR_CODE()
    {
	return ZAK_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.ZAK_TR_CODE
     * 
     * @param ZAK_TR_CODE the value for CTSCIT.ZAK_TR_CODE
     */
    public void setZAK_TR_CODE(BigDecimal ZAK_TR_CODE)
    {
	this.ZAK_TR_CODE = ZAK_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONCAT_ACC
     * 
     * @return the value of CTSCIT.CONCAT_ACC
     */
    public String getCONCAT_ACC()
    {
	return CONCAT_ACC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONCAT_ACC
     * 
     * @param CONCAT_ACC the value for CTSCIT.CONCAT_ACC
     */
    public void setCONCAT_ACC(String CONCAT_ACC)
    {
	this.CONCAT_ACC = CONCAT_ACC == null ? null : CONCAT_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.INCLUDE_EQUITY
     * 
     * @return the value of CTSCIT.INCLUDE_EQUITY
     */
    public String getINCLUDE_EQUITY()
    {
	return INCLUDE_EQUITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.INCLUDE_EQUITY
     * 
     * @param INCLUDE_EQUITY the value for CTSCIT.INCLUDE_EQUITY
     */
    public void setINCLUDE_EQUITY(String INCLUDE_EQUITY)
    {
	this.INCLUDE_EQUITY = INCLUDE_EQUITY == null ? null : INCLUDE_EQUITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.VALUE_DATE_TO
     * 
     * @return the value of CTSCIT.VALUE_DATE_TO
     */
    public String getVALUE_DATE_TO()
    {
	return VALUE_DATE_TO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.VALUE_DATE_TO
     * 
     * @param VALUE_DATE_TO the value for CTSCIT.VALUE_DATE_TO
     */
    public void setVALUE_DATE_TO(String VALUE_DATE_TO)
    {
	this.VALUE_DATE_TO = VALUE_DATE_TO == null ? null : VALUE_DATE_TO.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COMPUTATION
     * 
     * @return the value of CTSCIT.COMPUTATION
     */
    public String getCOMPUTATION()
    {
	return COMPUTATION;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COMPUTATION
     * 
     * @param COMPUTATION the value for CTSCIT.COMPUTATION
     */
    public void setCOMPUTATION(String COMPUTATION)
    {
	this.COMPUTATION = COMPUTATION == null ? null : COMPUTATION.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.IBIS_FLAG
     * 
     * @return the value of CTSCIT.IBIS_FLAG
     */
    public String getIBIS_FLAG()
    {
	return IBIS_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.IBIS_FLAG
     * 
     * @param IBIS_FLAG the value for CTSCIT.IBIS_FLAG
     */
    public void setIBIS_FLAG(String IBIS_FLAG)
    {
	this.IBIS_FLAG = IBIS_FLAG == null ? null : IBIS_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EQUITY_ACC_BR
     * 
     * @return the value of CTSCIT.EQUITY_ACC_BR
     */
    public BigDecimal getEQUITY_ACC_BR()
    {
	return EQUITY_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EQUITY_ACC_BR
     * 
     * @param EQUITY_ACC_BR the value for CTSCIT.EQUITY_ACC_BR
     */
    public void setEQUITY_ACC_BR(BigDecimal EQUITY_ACC_BR)
    {
	this.EQUITY_ACC_BR = EQUITY_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EQUITY_ACC_CY
     * 
     * @return the value of CTSCIT.EQUITY_ACC_CY
     */
    public BigDecimal getEQUITY_ACC_CY()
    {
	return EQUITY_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EQUITY_ACC_CY
     * 
     * @param EQUITY_ACC_CY the value for CTSCIT.EQUITY_ACC_CY
     */
    public void setEQUITY_ACC_CY(BigDecimal EQUITY_ACC_CY)
    {
	this.EQUITY_ACC_CY = EQUITY_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EQUITY_ACC_GL
     * 
     * @return the value of CTSCIT.EQUITY_ACC_GL
     */
    public BigDecimal getEQUITY_ACC_GL()
    {
	return EQUITY_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EQUITY_ACC_GL
     * 
     * @param EQUITY_ACC_GL the value for CTSCIT.EQUITY_ACC_GL
     */
    public void setEQUITY_ACC_GL(BigDecimal EQUITY_ACC_GL)
    {
	this.EQUITY_ACC_GL = EQUITY_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EQUITY_ACC_CIF
     * 
     * @return the value of CTSCIT.EQUITY_ACC_CIF
     */
    public BigDecimal getEQUITY_ACC_CIF()
    {
	return EQUITY_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EQUITY_ACC_CIF
     * 
     * @param EQUITY_ACC_CIF the value for CTSCIT.EQUITY_ACC_CIF
     */
    public void setEQUITY_ACC_CIF(BigDecimal EQUITY_ACC_CIF)
    {
	this.EQUITY_ACC_CIF = EQUITY_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EQUITY_ACC_SL
     * 
     * @return the value of CTSCIT.EQUITY_ACC_SL
     */
    public BigDecimal getEQUITY_ACC_SL()
    {
	return EQUITY_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EQUITY_ACC_SL
     * 
     * @param EQUITY_ACC_SL the value for CTSCIT.EQUITY_ACC_SL
     */
    public void setEQUITY_ACC_SL(BigDecimal EQUITY_ACC_SL)
    {
	this.EQUITY_ACC_SL = EQUITY_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.INCLUDE_EQUITY_ACC
     * 
     * @return the value of CTSCIT.INCLUDE_EQUITY_ACC
     */
    public String getINCLUDE_EQUITY_ACC()
    {
	return INCLUDE_EQUITY_ACC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.INCLUDE_EQUITY_ACC
     * 
     * @param INCLUDE_EQUITY_ACC the value for CTSCIT.INCLUDE_EQUITY_ACC
     */
    public void setINCLUDE_EQUITY_ACC(String INCLUDE_EQUITY_ACC)
    {
	this.INCLUDE_EQUITY_ACC = INCLUDE_EQUITY_ACC == null ? null : INCLUDE_EQUITY_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RECALC_FLAG
     * 
     * @return the value of CTSCIT.RECALC_FLAG
     */
    public String getRECALC_FLAG()
    {
	return RECALC_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RECALC_FLAG
     * 
     * @param RECALC_FLAG the value for CTSCIT.RECALC_FLAG
     */
    public void setRECALC_FLAG(String RECALC_FLAG)
    {
	this.RECALC_FLAG = RECALC_FLAG == null ? null : RECALC_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.FINAL_SPECIFIC_LOG
     * 
     * @return the value of CTSCIT.FINAL_SPECIFIC_LOG
     */
    public String getFINAL_SPECIFIC_LOG()
    {
	return FINAL_SPECIFIC_LOG;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.FINAL_SPECIFIC_LOG
     * 
     * @param FINAL_SPECIFIC_LOG the value for CTSCIT.FINAL_SPECIFIC_LOG
     */
    public void setFINAL_SPECIFIC_LOG(String FINAL_SPECIFIC_LOG)
    {
	this.FINAL_SPECIFIC_LOG = FINAL_SPECIFIC_LOG == null ? null : FINAL_SPECIFIC_LOG.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONTRIBUTION_CY
     * 
     * @return the value of CTSCIT.CONTRIBUTION_CY
     */
    public BigDecimal getCONTRIBUTION_CY()
    {
	return CONTRIBUTION_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONTRIBUTION_CY
     * 
     * @param CONTRIBUTION_CY the value for CTSCIT.CONTRIBUTION_CY
     */
    public void setCONTRIBUTION_CY(BigDecimal CONTRIBUTION_CY)
    {
	this.CONTRIBUTION_CY = CONTRIBUTION_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONTRIBUTION_GL
     * 
     * @return the value of CTSCIT.CONTRIBUTION_GL
     */
    public BigDecimal getCONTRIBUTION_GL()
    {
	return CONTRIBUTION_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONTRIBUTION_GL
     * 
     * @param CONTRIBUTION_GL the value for CTSCIT.CONTRIBUTION_GL
     */
    public void setCONTRIBUTION_GL(BigDecimal CONTRIBUTION_GL)
    {
	this.CONTRIBUTION_GL = CONTRIBUTION_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONTRIBUTION_CIF
     * 
     * @return the value of CTSCIT.CONTRIBUTION_CIF
     */
    public BigDecimal getCONTRIBUTION_CIF()
    {
	return CONTRIBUTION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONTRIBUTION_CIF
     * 
     * @param CONTRIBUTION_CIF the value for CTSCIT.CONTRIBUTION_CIF
     */
    public void setCONTRIBUTION_CIF(BigDecimal CONTRIBUTION_CIF)
    {
	this.CONTRIBUTION_CIF = CONTRIBUTION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONTRIBUTION_SL
     * 
     * @return the value of CTSCIT.CONTRIBUTION_SL
     */
    public BigDecimal getCONTRIBUTION_SL()
    {
	return CONTRIBUTION_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONTRIBUTION_SL
     * 
     * @param CONTRIBUTION_SL the value for CTSCIT.CONTRIBUTION_SL
     */
    public void setCONTRIBUTION_SL(BigDecimal CONTRIBUTION_SL)
    {
	this.CONTRIBUTION_SL = CONTRIBUTION_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PFT_EQU_CY
     * 
     * @return the value of CTSCIT.PFT_EQU_CY
     */
    public BigDecimal getPFT_EQU_CY()
    {
	return PFT_EQU_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PFT_EQU_CY
     * 
     * @param PFT_EQU_CY the value for CTSCIT.PFT_EQU_CY
     */
    public void setPFT_EQU_CY(BigDecimal PFT_EQU_CY)
    {
	this.PFT_EQU_CY = PFT_EQU_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PFT_EQU_GL
     * 
     * @return the value of CTSCIT.PFT_EQU_GL
     */
    public BigDecimal getPFT_EQU_GL()
    {
	return PFT_EQU_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PFT_EQU_GL
     * 
     * @param PFT_EQU_GL the value for CTSCIT.PFT_EQU_GL
     */
    public void setPFT_EQU_GL(BigDecimal PFT_EQU_GL)
    {
	this.PFT_EQU_GL = PFT_EQU_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PFT_EQU_CIF
     * 
     * @return the value of CTSCIT.PFT_EQU_CIF
     */
    public BigDecimal getPFT_EQU_CIF()
    {
	return PFT_EQU_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PFT_EQU_CIF
     * 
     * @param PFT_EQU_CIF the value for CTSCIT.PFT_EQU_CIF
     */
    public void setPFT_EQU_CIF(BigDecimal PFT_EQU_CIF)
    {
	this.PFT_EQU_CIF = PFT_EQU_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PFT_EQU_SL
     * 
     * @return the value of CTSCIT.PFT_EQU_SL
     */
    public BigDecimal getPFT_EQU_SL()
    {
	return PFT_EQU_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PFT_EQU_SL
     * 
     * @param PFT_EQU_SL the value for CTSCIT.PFT_EQU_SL
     */
    public void setPFT_EQU_SL(BigDecimal PFT_EQU_SL)
    {
	this.PFT_EQU_SL = PFT_EQU_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.GRAUSS_PFT_BASIS
     * 
     * @return the value of CTSCIT.GRAUSS_PFT_BASIS
     */
    public String getGRAUSS_PFT_BASIS()
    {
	return GRAUSS_PFT_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.GRAUSS_PFT_BASIS
     * 
     * @param GRAUSS_PFT_BASIS the value for CTSCIT.GRAUSS_PFT_BASIS
     */
    public void setGRAUSS_PFT_BASIS(String GRAUSS_PFT_BASIS)
    {
	this.GRAUSS_PFT_BASIS = GRAUSS_PFT_BASIS == null ? null : GRAUSS_PFT_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.APPLY_CHARGES
     * 
     * @return the value of CTSCIT.APPLY_CHARGES
     */
    public String getAPPLY_CHARGES()
    {
	return APPLY_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.APPLY_CHARGES
     * 
     * @param APPLY_CHARGES the value for CTSCIT.APPLY_CHARGES
     */
    public void setAPPLY_CHARGES(String APPLY_CHARGES)
    {
	this.APPLY_CHARGES = APPLY_CHARGES == null ? null : APPLY_CHARGES.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CHRG_TR_CODE
     * 
     * @return the value of CTSCIT.CHRG_TR_CODE
     */
    public BigDecimal getCHRG_TR_CODE()
    {
	return CHRG_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CHRG_TR_CODE
     * 
     * @param CHRG_TR_CODE the value for CTSCIT.CHRG_TR_CODE
     */
    public void setCHRG_TR_CODE(BigDecimal CHRG_TR_CODE)
    {
	this.CHRG_TR_CODE = CHRG_TR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.APPROVE_FINAL_RUN
     * 
     * @return the value of CTSCIT.APPROVE_FINAL_RUN
     */
    public String getAPPROVE_FINAL_RUN()
    {
	return APPROVE_FINAL_RUN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.APPROVE_FINAL_RUN
     * 
     * @param APPROVE_FINAL_RUN the value for CTSCIT.APPROVE_FINAL_RUN
     */
    public void setAPPROVE_FINAL_RUN(String APPROVE_FINAL_RUN)
    {
	this.APPROVE_FINAL_RUN = APPROVE_FINAL_RUN == null ? null : APPROVE_FINAL_RUN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.APPLY_DIR_IND_CALC
     * 
     * @return the value of CTSCIT.APPLY_DIR_IND_CALC
     */
    public String getAPPLY_DIR_IND_CALC()
    {
	return APPLY_DIR_IND_CALC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.APPLY_DIR_IND_CALC
     * 
     * @param APPLY_DIR_IND_CALC the value for CTSCIT.APPLY_DIR_IND_CALC
     */
    public void setAPPLY_DIR_IND_CALC(String APPLY_DIR_IND_CALC)
    {
	this.APPLY_DIR_IND_CALC = APPLY_DIR_IND_CALC == null ? null : APPLY_DIR_IND_CALC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.POST_EQUITY_PROFIT
     * 
     * @return the value of CTSCIT.POST_EQUITY_PROFIT
     */
    public String getPOST_EQUITY_PROFIT()
    {
	return POST_EQUITY_PROFIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.POST_EQUITY_PROFIT
     * 
     * @param POST_EQUITY_PROFIT the value for CTSCIT.POST_EQUITY_PROFIT
     */
    public void setPOST_EQUITY_PROFIT(String POST_EQUITY_PROFIT)
    {
	this.POST_EQUITY_PROFIT = POST_EQUITY_PROFIT == null ? null : POST_EQUITY_PROFIT.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.POST_ACC_ENTRIES
     * 
     * @return the value of CTSCIT.POST_ACC_ENTRIES
     */
    public String getPOST_ACC_ENTRIES()
    {
	return POST_ACC_ENTRIES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.POST_ACC_ENTRIES
     * 
     * @param POST_ACC_ENTRIES the value for CTSCIT.POST_ACC_ENTRIES
     */
    public void setPOST_ACC_ENTRIES(String POST_ACC_ENTRIES)
    {
	this.POST_ACC_ENTRIES = POST_ACC_ENTRIES == null ? null : POST_ACC_ENTRIES.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.WRITE_OFF_POST_ACC_ENTRIES
     * 
     * @return the value of CTSCIT.WRITE_OFF_POST_ACC_ENTRIES
     */
    public String getWRITE_OFF_POST_ACC_ENTRIES()
    {
	return WRITE_OFF_POST_ACC_ENTRIES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.WRITE_OFF_POST_ACC_ENTRIES
     * 
     * @param WRITE_OFF_POST_ACC_ENTRIES the value for
     *            CTSCIT.WRITE_OFF_POST_ACC_ENTRIES
     */
    public void setWRITE_OFF_POST_ACC_ENTRIES(String WRITE_OFF_POST_ACC_ENTRIES)
    {
	this.WRITE_OFF_POST_ACC_ENTRIES = WRITE_OFF_POST_ACC_ENTRIES == null ? null : WRITE_OFF_POST_ACC_ENTRIES.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.FINAL_RUN_SEPARATE_ENTRIES
     * 
     * @return the value of CTSCIT.FINAL_RUN_SEPARATE_ENTRIES
     */
    public String getFINAL_RUN_SEPARATE_ENTRIES()
    {
	return FINAL_RUN_SEPARATE_ENTRIES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.FINAL_RUN_SEPARATE_ENTRIES
     * 
     * @param FINAL_RUN_SEPARATE_ENTRIES the value for
     *            CTSCIT.FINAL_RUN_SEPARATE_ENTRIES
     */
    public void setFINAL_RUN_SEPARATE_ENTRIES(String FINAL_RUN_SEPARATE_ENTRIES)
    {
	this.FINAL_RUN_SEPARATE_ENTRIES = FINAL_RUN_SEPARATE_ENTRIES == null ? null : FINAL_RUN_SEPARATE_ENTRIES.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONCAT_DATE_DESC
     * 
     * @return the value of CTSCIT.CONCAT_DATE_DESC
     */
    public String getCONCAT_DATE_DESC()
    {
	return CONCAT_DATE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONCAT_DATE_DESC
     * 
     * @param CONCAT_DATE_DESC the value for CTSCIT.CONCAT_DATE_DESC
     */
    public void setCONCAT_DATE_DESC(String CONCAT_DATE_DESC)
    {
	this.CONCAT_DATE_DESC = CONCAT_DATE_DESC == null ? null : CONCAT_DATE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EXCL_BACC_PFCT
     * 
     * @return the value of CTSCIT.EXCL_BACC_PFCT
     */
    public String getEXCL_BACC_PFCT()
    {
	return EXCL_BACC_PFCT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EXCL_BACC_PFCT
     * 
     * @param EXCL_BACC_PFCT the value for CTSCIT.EXCL_BACC_PFCT
     */
    public void setEXCL_BACC_PFCT(String EXCL_BACC_PFCT)
    {
	this.EXCL_BACC_PFCT = EXCL_BACC_PFCT == null ? null : EXCL_BACC_PFCT.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.POPULATE_PT_ACCR
     * 
     * @return the value of CTSCIT.POPULATE_PT_ACCR
     */
    public String getPOPULATE_PT_ACCR()
    {
	return POPULATE_PT_ACCR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.POPULATE_PT_ACCR
     * 
     * @param POPULATE_PT_ACCR the value for CTSCIT.POPULATE_PT_ACCR
     */
    public void setPOPULATE_PT_ACCR(String POPULATE_PT_ACCR)
    {
	this.POPULATE_PT_ACCR = POPULATE_PT_ACCR == null ? null : POPULATE_PT_ACCR.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MODARIB_EQUITY_CONTRIBUTION
     * 
     * @return the value of CTSCIT.MODARIB_EQUITY_CONTRIBUTION
     */
    public BigDecimal getMODARIB_EQUITY_CONTRIBUTION()
    {
	return MODARIB_EQUITY_CONTRIBUTION;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MODARIB_EQUITY_CONTRIBUTION
     * 
     * @param MODARIB_EQUITY_CONTRIBUTION the value for
     *            CTSCIT.MODARIB_EQUITY_CONTRIBUTION
     */
    public void setMODARIB_EQUITY_CONTRIBUTION(BigDecimal MODARIB_EQUITY_CONTRIBUTION)
    {
	this.MODARIB_EQUITY_CONTRIBUTION = MODARIB_EQUITY_CONTRIBUTION;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.PROFIT_CALCULATION_METHOD
     * 
     * @return the value of CTSCIT.PROFIT_CALCULATION_METHOD
     */
    public BigDecimal getPROFIT_CALCULATION_METHOD()
    {
	return PROFIT_CALCULATION_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.PROFIT_CALCULATION_METHOD
     * 
     * @param PROFIT_CALCULATION_METHOD the value for
     *            CTSCIT.PROFIT_CALCULATION_METHOD
     */
    public void setPROFIT_CALCULATION_METHOD(BigDecimal PROFIT_CALCULATION_METHOD)
    {
	this.PROFIT_CALCULATION_METHOD = PROFIT_CALCULATION_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.DIST_GROSS_PFT_TO_PARTICIPANT
     * 
     * @return the value of CTSCIT.DIST_GROSS_PFT_TO_PARTICIPANT
     */
    public BigDecimal getDIST_GROSS_PFT_TO_PARTICIPANT()
    {
	return DIST_GROSS_PFT_TO_PARTICIPANT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.DIST_GROSS_PFT_TO_PARTICIPANT
     * 
     * @param DIST_GROSS_PFT_TO_PARTICIPANT the value for
     *            CTSCIT.DIST_GROSS_PFT_TO_PARTICIPANT
     */
    public void setDIST_GROSS_PFT_TO_PARTICIPANT(BigDecimal DIST_GROSS_PFT_TO_PARTICIPANT)
    {
	this.DIST_GROSS_PFT_TO_PARTICIPANT = DIST_GROSS_PFT_TO_PARTICIPANT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_RISK_CY
     * 
     * @return the value of CTSCIT.COF_RISK_CY
     */
    public BigDecimal getCOF_RISK_CY()
    {
	return COF_RISK_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_RISK_CY
     * 
     * @param COF_RISK_CY the value for CTSCIT.COF_RISK_CY
     */
    public void setCOF_RISK_CY(BigDecimal COF_RISK_CY)
    {
	this.COF_RISK_CY = COF_RISK_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_RISK_GL
     * 
     * @return the value of CTSCIT.COF_RISK_GL
     */
    public BigDecimal getCOF_RISK_GL()
    {
	return COF_RISK_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_RISK_GL
     * 
     * @param COF_RISK_GL the value for CTSCIT.COF_RISK_GL
     */
    public void setCOF_RISK_GL(BigDecimal COF_RISK_GL)
    {
	this.COF_RISK_GL = COF_RISK_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_RISK_CIF
     * 
     * @return the value of CTSCIT.COF_RISK_CIF
     */
    public BigDecimal getCOF_RISK_CIF()
    {
	return COF_RISK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_RISK_CIF
     * 
     * @param COF_RISK_CIF the value for CTSCIT.COF_RISK_CIF
     */
    public void setCOF_RISK_CIF(BigDecimal COF_RISK_CIF)
    {
	this.COF_RISK_CIF = COF_RISK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.COF_RISK_SL
     * 
     * @return the value of CTSCIT.COF_RISK_SL
     */
    public BigDecimal getCOF_RISK_SL()
    {
	return COF_RISK_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.COF_RISK_SL
     * 
     * @param COF_RISK_SL the value for CTSCIT.COF_RISK_SL
     */
    public void setCOF_RISK_SL(BigDecimal COF_RISK_SL)
    {
	this.COF_RISK_SL = COF_RISK_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.MIN_BR
     * 
     * @return the value of CTSCIT.MIN_BR
     */
    public BigDecimal getMIN_BR()
    {
	return MIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.MIN_BR
     * 
     * @param MIN_BR the value for CTSCIT.MIN_BR
     */
    public void setMIN_BR(BigDecimal MIN_BR)
    {
	this.MIN_BR = MIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_PROV_ON_BANK_REV_YN
     * 
     * @return the value of CTSCIT.RISK_PROV_ON_BANK_REV_YN
     */
    public String getRISK_PROV_ON_BANK_REV_YN()
    {
	return RISK_PROV_ON_BANK_REV_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_PROV_ON_BANK_REV_YN
     * 
     * @param RISK_PROV_ON_BANK_REV_YN the value for
     *            CTSCIT.RISK_PROV_ON_BANK_REV_YN
     */
    public void setRISK_PROV_ON_BANK_REV_YN(String RISK_PROV_ON_BANK_REV_YN)
    {
	this.RISK_PROV_ON_BANK_REV_YN = RISK_PROV_ON_BANK_REV_YN == null ? null : RISK_PROV_ON_BANK_REV_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.CONSIDER_WAIVED_PROFIT_YN
     * 
     * @return the value of CTSCIT.CONSIDER_WAIVED_PROFIT_YN
     */
    public String getCONSIDER_WAIVED_PROFIT_YN()
    {
	return CONSIDER_WAIVED_PROFIT_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.CONSIDER_WAIVED_PROFIT_YN
     * 
     * @param CONSIDER_WAIVED_PROFIT_YN the value for
     *            CTSCIT.CONSIDER_WAIVED_PROFIT_YN
     */
    public void setCONSIDER_WAIVED_PROFIT_YN(String CONSIDER_WAIVED_PROFIT_YN)
    {
	this.CONSIDER_WAIVED_PROFIT_YN = CONSIDER_WAIVED_PROFIT_YN == null ? null : CONSIDER_WAIVED_PROFIT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.RISK_PROV_ON_BANK_REV_PERC
     * 
     * @return the value of CTSCIT.RISK_PROV_ON_BANK_REV_PERC
     */
    public BigDecimal getRISK_PROV_ON_BANK_REV_PERC()
    {
	return RISK_PROV_ON_BANK_REV_PERC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.RISK_PROV_ON_BANK_REV_PERC
     * 
     * @param RISK_PROV_ON_BANK_REV_PERC the value for
     *            CTSCIT.RISK_PROV_ON_BANK_REV_PERC
     */
    public void setRISK_PROV_ON_BANK_REV_PERC(BigDecimal RISK_PROV_ON_BANK_REV_PERC)
    {
	this.RISK_PROV_ON_BANK_REV_PERC = RISK_PROV_ON_BANK_REV_PERC;
    }

    public String getYEARLY_RATE_CALC_YN()
    {
	return YEARLY_RATE_CALC_YN;
    }

    public void setYEARLY_RATE_CALC_YN(String yEARLYRATECALCYN)
    {
	YEARLY_RATE_CALC_YN = yEARLYRATECALCYN;
    }

    public void setCESS_TAX_CY(BigDecimal cESS_TAX_CY)
    {
	CESS_TAX_CY = cESS_TAX_CY;
    }

    public BigDecimal getCESS_TAX_CY()
    {
	return CESS_TAX_CY;
    }

    public void setCESS_TAX_GL(BigDecimal cESS_TAX_GL)
    {
	CESS_TAX_GL = cESS_TAX_GL;
    }

    public BigDecimal getCESS_TAX_GL()
    {
	return CESS_TAX_GL;
    }

    public void setCESS_TAX_CIF(BigDecimal cESS_TAX_CIF)
    {
	CESS_TAX_CIF = cESS_TAX_CIF;
    }

    public BigDecimal getCESS_TAX_CIF()
    {
	return CESS_TAX_CIF;
    }

    public void setCESS_TAX_SL(BigDecimal cESS_TAX_SL)
    {
	CESS_TAX_SL = cESS_TAX_SL;
    }

    public BigDecimal getCESS_TAX_SL()
    {
	return CESS_TAX_SL;
    }

    public void setPAY_LOSS_CY(BigDecimal pAY_LOSS_CY)
    {
	PAY_LOSS_CY = pAY_LOSS_CY;
    }

    public BigDecimal getPAY_LOSS_CY()
    {
	return PAY_LOSS_CY;
    }

    public void setPAY_LOSS_GL(BigDecimal pAY_LOSS_GL)
    {
	PAY_LOSS_GL = pAY_LOSS_GL;
    }

    public BigDecimal getPAY_LOSS_GL()
    {
	return PAY_LOSS_GL;
    }

    public void setPAY_LOSS_CIF(BigDecimal pAY_LOSS_CIF)
    {
	PAY_LOSS_CIF = pAY_LOSS_CIF;
    }

    public BigDecimal getPAY_LOSS_CIF()
    {
	return PAY_LOSS_CIF;
    }

    public void setPAY_LOSS_SL(BigDecimal pAY_LOSS_SL)
    {
	PAY_LOSS_SL = pAY_LOSS_SL;
    }

    public BigDecimal getPAY_LOSS_SL()
    {
	return PAY_LOSS_SL;
    }

    public void setPROV_LOSS_CY(BigDecimal pROV_LOSS_CY)
    {
	PROV_LOSS_CY = pROV_LOSS_CY;
    }

    public BigDecimal getPROV_LOSS_CY()
    {
	return PROV_LOSS_CY;
    }

    public void setPROV_LOSS_GL(BigDecimal pROV_LOSS_GL)
    {
	PROV_LOSS_GL = pROV_LOSS_GL;
    }

    public BigDecimal getPROV_LOSS_GL()
    {
	return PROV_LOSS_GL;
    }

    public void setPROV_LOSS_CIF(BigDecimal pROV_LOSS_CIF)
    {
	PROV_LOSS_CIF = pROV_LOSS_CIF;
    }

    public BigDecimal getPROV_LOSS_CIF()
    {
	return PROV_LOSS_CIF;
    }

    public void setPROV_LOSS_SL(BigDecimal pROV_LOSS_SL)
    {
	PROV_LOSS_SL = pROV_LOSS_SL;
    }

    public BigDecimal getPROV_LOSS_SL()
    {
	return PROV_LOSS_SL;
    }

    public void setROUNDING_TYPE(String rOUNDING_TYPE)
    {
	ROUNDING_TYPE = rOUNDING_TYPE;
    }

    public String getROUNDING_TYPE()
    {
	return ROUNDING_TYPE;
    }

    public void setCALCULATE_DEDUCT_LOSS_YN(String cALCULATE_DEDUCT_LOSS_YN)
    {
	CALCULATE_DEDUCT_LOSS_YN = cALCULATE_DEDUCT_LOSS_YN;
    }

    public String getCALCULATE_DEDUCT_LOSS_YN()
    {
	return CALCULATE_DEDUCT_LOSS_YN;
    }

    public void setROUNDING_NEAREST(BigDecimal rOUNDING_NEAREST)
    {
	ROUNDING_NEAREST = rOUNDING_NEAREST;
    }

    public BigDecimal getROUNDING_NEAREST()
    {
	return ROUNDING_NEAREST;
    }

    public String getEXCLUDE_MODARIB_ENTRIES_YN()
    {
	return EXCLUDE_MODARIB_ENTRIES_YN;
    }

    public void setEXCLUDE_MODARIB_ENTRIES_YN(String eXCLUDEMODARIBENTRIESYN)
    {
	EXCLUDE_MODARIB_ENTRIES_YN = eXCLUDEMODARIBENTRIESYN;
    }

    public String getCALC_CURR_MTH_PFT_BY_GROSSRATE()
    {
	return CALC_CURR_MTH_PFT_BY_GROSSRATE;
    }

    public void setCALC_CURR_MTH_PFT_BY_GROSSRATE(String cALCCURRMTHPFTBYGROSSRATE)
    {
	CALC_CURR_MTH_PFT_BY_GROSSRATE = cALCCURRMTHPFTBYGROSSRATE;
    }

    public String getROR_BASED_ON_ACCUM_AMT_YN()
    {
	return ROR_BASED_ON_ACCUM_AMT_YN;
    }

    public void setROR_BASED_ON_ACCUM_AMT_YN(String rOR_BASED_ON_ACCUM_AMT_YN)
    {
	ROR_BASED_ON_ACCUM_AMT_YN = rOR_BASED_ON_ACCUM_AMT_YN;
    }
    
    public BigDecimal getHIBA_ACC_CY()
    {
	return HIBA_ACC_CY;
    }

    public void setHIBA_ACC_CY(BigDecimal hIBA_ACC_CY)
    {
	HIBA_ACC_CY = hIBA_ACC_CY;
    }

    public BigDecimal getHIBA_ACC_GL()
    {
	return HIBA_ACC_GL;
    }

    public void setHIBA_ACC_GL(BigDecimal hIBA_ACC_GL)
    {
	HIBA_ACC_GL = hIBA_ACC_GL;
    }

    public BigDecimal getHIBA_ACC_CIF()
    {
	return HIBA_ACC_CIF;
    }

    public void setHIBA_ACC_CIF(BigDecimal hIBA_ACC_CIF)
    {
	HIBA_ACC_CIF = hIBA_ACC_CIF;
    }

    public BigDecimal getHIBA_ACC_SL()
    {
	return HIBA_ACC_SL;
    }

    public void setHIBA_ACC_SL(BigDecimal hIBA_ACC_SL)
    {
	HIBA_ACC_SL = hIBA_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.EXCLUDE_BELOW_MIN_ACCOUNTS_YN
     *
     * @return the value of CTSCIT.EXCLUDE_BELOW_MIN_ACCOUNTS_YN
     */
    public String getEXCLUDE_BELOW_MIN_ACCOUNTS_YN()
    {
	return EXCLUDE_BELOW_MIN_ACCOUNTS_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.EXCLUDE_BELOW_MIN_ACCOUNTS_YN
     *
     * @param EXCLUDE_BELOW_MIN_ACCOUNTS_YN the value for
     *            CTSCIT.EXCLUDE_BELOW_MIN_ACCOUNTS_YN
     */
    public void setEXCLUDE_BELOW_MIN_ACCOUNTS_YN(String EXCLUDE_BELOW_MIN_ACCOUNTS_YN)
    {
	this.EXCLUDE_BELOW_MIN_ACCOUNTS_YN = EXCLUDE_BELOW_MIN_ACCOUNTS_YN == null ? null
		: EXCLUDE_BELOW_MIN_ACCOUNTS_YN.trim();
    }
	
	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCIT.CONSIDER_EQUITY_DEBIT_BAL_YN
     *
     * @return the value of CTSCIT.CONSIDER_EQUITY_DEBIT_BAL_YN
     */
    public BigDecimal getCONSIDER_EQUITY_DEBIT_BAL_YN() {
        return CONSIDER_EQUITY_DEBIT_BAL_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCIT.CONSIDER_EQUITY_DEBIT_BAL_YN
     *
     * @param CONSIDER_EQUITY_DEBIT_BAL_YN the value for CTSCIT.CONSIDER_EQUITY_DEBIT_BAL_YN
     */
    public void setCONSIDER_EQUITY_DEBIT_BAL_YN(BigDecimal CONSIDER_EQUITY_DEBIT_BAL_YN) {
        this.CONSIDER_EQUITY_DEBIT_BAL_YN = CONSIDER_EQUITY_DEBIT_BAL_YN;
    }
	
	/**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSCIT.TRANS_DATE_TO
     * 
     * @return the value of CTSCIT.TRANS_DATE_TO
     */

	public String getTRANS_DATE_TO() {
		return TRANS_DATE_TO;
	}
	
    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSCIT.TRANS_DATE_TO
     * 
     * @param TRANS_DATE_TO the value for CTSCIT.TRANS_DATE_TO
     */

	public void setTRANS_DATE_TO(String tRANS_DATE_TO) {
		TRANS_DATE_TO = tRANS_DATE_TO;
	}
	
	public String getCONS_EXPENSE_JV_ON_LASTDAY_YN() {
		return CONS_EXPENSE_JV_ON_LASTDAY_YN;
	}

	public void setCONS_EXPENSE_JV_ON_LASTDAY_YN(String cONS_EXPENSE_JV_ON_LASTDAY_YN) {
		CONS_EXPENSE_JV_ON_LASTDAY_YN = cONS_EXPENSE_JV_ON_LASTDAY_YN;
	}
}
