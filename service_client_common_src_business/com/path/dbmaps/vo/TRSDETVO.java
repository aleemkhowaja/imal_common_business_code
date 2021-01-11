package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDETVO extends TRSDETVOKey {
    /**
     * This field corresponds to the database column TRSDET.DEAL_TYPE
     */
    private BigDecimal DEAL_TYPE;

    /**
     * This field corresponds to the database column TRSDET.PARTY_TYPE
     */
    private String PARTY_TYPE;

    /**
     * This field corresponds to the database column TRSDET.PARTY_NO
     */
    private BigDecimal PARTY_NO;

    /**
     * This field corresponds to the database column TRSDET.PARTY_BRANCH
     */
    private BigDecimal PARTY_BRANCH;

    /**
     * This field corresponds to the database column TRSDET.AMS_TRS_ID
     */
    private String AMS_TRS_ID;

    /**
     * This field corresponds to the database column TRSDET.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column TRSDET.YIELD
     */
    private BigDecimal YIELD;

    /**
     * This field corresponds to the database column TRSDET.BC_FLAG
     */
    private String BC_FLAG;

    /**
     * This field corresponds to the database column TRSDET.TRF_AC_CY
     */
    private BigDecimal TRF_AC_CY;

    /**
     * This field corresponds to the database column TRSDET.TRF_AC_GL
     */
    private BigDecimal TRF_AC_GL;

    /**
     * This field corresponds to the database column TRSDET.TRF_AC_CIF
     */
    private BigDecimal TRF_AC_CIF;

    /**
     * This field corresponds to the database column TRSDET.TRF_AC_SL
     */
    private BigDecimal TRF_AC_SL;

    /**
     * This field corresponds to the database column TRSDET.TRF_RATE
     */
    private BigDecimal TRF_RATE;

    /**
     * This field corresponds to the database column TRSDET.TRF_UNIT
     */
    private BigDecimal TRF_UNIT;

    /**
     * This field corresponds to the database column TRSDET.MATR_AC_CY
     */
    private BigDecimal MATR_AC_CY;

    /**
     * This field corresponds to the database column TRSDET.MATR_AC_GL
     */
    private BigDecimal MATR_AC_GL;

    /**
     * This field corresponds to the database column TRSDET.MATR_AC_CIF
     */
    private BigDecimal MATR_AC_CIF;

    /**
     * This field corresponds to the database column TRSDET.MATR_AC_SL
     */
    private BigDecimal MATR_AC_SL;

    /**
     * This field corresponds to the database column TRSDET.MATR_RATE
     */
    private BigDecimal MATR_RATE;

    /**
     * This field corresponds to the database column TRSDET.MATR_UNIT
     */
    private BigDecimal MATR_UNIT;

    /**
     * This field corresponds to the database column TRSDET.DIFF_AC_CY
     */
    private BigDecimal DIFF_AC_CY;

    /**
     * This field corresponds to the database column TRSDET.DIFF_AC_GL
     */
    private BigDecimal DIFF_AC_GL;

    /**
     * This field corresponds to the database column TRSDET.DIFF_AC_CIF
     */
    private BigDecimal DIFF_AC_CIF;

    /**
     * This field corresponds to the database column TRSDET.DIFF_AC_SL
     */
    private BigDecimal DIFF_AC_SL;

    /**
     * This field corresponds to the database column TRSDET.DIFF_RATE
     */
    private BigDecimal DIFF_RATE;

    /**
     * This field corresponds to the database column TRSDET.DIFF_UNIT
     */
    private BigDecimal DIFF_UNIT;

    /**
     * This field corresponds to the database column TRSDET.INV_AC_CY
     */
    private BigDecimal INV_AC_CY;

    /**
     * This field corresponds to the database column TRSDET.INV_AC_GL
     */
    private BigDecimal INV_AC_GL;

    /**
     * This field corresponds to the database column TRSDET.INV_AC_CIF
     */
    private BigDecimal INV_AC_CIF;

    /**
     * This field corresponds to the database column TRSDET.INV_AC_SL
     */
    private BigDecimal INV_AC_SL;

    /**
     * This field corresponds to the database column TRSDET.BUDGETED_RATE
     */
    private BigDecimal BUDGETED_RATE;

    /**
     * This field corresponds to the database column TRSDET.RATE_FLAG
     */
    private String RATE_FLAG;

    /**
     * This field corresponds to the database column TRSDET.REVALUATION_RATE
     */
    private BigDecimal REVALUATION_RATE;

    /**
     * This field corresponds to the database column TRSDET.MATURED_IND
     */
    private String MATURED_IND;

    /**
     * This field corresponds to the database column TRSDET.MATR_JV
     */
    private String MATR_JV;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_IND
     */
    private String ROLLOVER_IND;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_AMOUNT
     */
    private BigDecimal ROLLOVER_AMOUNT;

    /**
     * This field corresponds to the database column TRSDET.AMOUNT_USED
     */
    private BigDecimal AMOUNT_USED;

    /**
     * This field corresponds to the database column TRSDET.CLASS
     */
    private BigDecimal CLASS;

    /**
     * This field corresponds to the database column TRSDET.PROFIT_SHARE_RATIO
     */
    private BigDecimal PROFIT_SHARE_RATIO;

    /**
     * This field corresponds to the database column TRSDET.CROSS_CY_RATE
     */
    private BigDecimal CROSS_CY_RATE;

    /**
     * This field corresponds to the database column TRSDET.CROSS_CY_MULT_DIV
     */
    private String CROSS_CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSDET.CROSS_CY_AMOUNT
     */
    private BigDecimal CROSS_CY_AMOUNT;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_GL
     */
    private BigDecimal SPECIFIC_MOD_GL;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_CIF
     */
    private BigDecimal SPECIFIC_MOD_CIF;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_SL
     */
    private BigDecimal SPECIFIC_MOD_SL;

    /**
     * This field corresponds to the database column TRSDET.PORTFOLIO_CIF
     */
    private BigDecimal PORTFOLIO_CIF;

    /**
     * This field corresponds to the database column TRSDET.PORTFOLIO_SEQ
     */
    private BigDecimal PORTFOLIO_SEQ;

    /**
     * This field corresponds to the database column TRSDET.REF_DEAL_CLASS
     */
    private BigDecimal REF_DEAL_CLASS;

    /**
     * This field corresponds to the database column TRSDET.REF_DEAL_YIELD
     */
    private BigDecimal REF_DEAL_YIELD;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTOFFBS_FC
     */
    private BigDecimal INVESTMENTOFFBS_FC;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTOFFBS_CV
     */
    private BigDecimal INVESTMENTOFFBS_CV;

    /**
     * This field corresponds to the database column TRSDET.AMOUNT_2
     */
    private BigDecimal AMOUNT_2;

    /**
     * This field corresponds to the database column TRSDET.PROFITPAYABLE_FC
     */
    private BigDecimal PROFITPAYABLE_FC;

    /**
     * This field corresponds to the database column TRSDET.PROFITPAYABLE_CV
     */
    private BigDecimal PROFITPAYABLE_CV;

    /**
     * This field corresponds to the database column TRSDET.EXPECTED_YIELD
     */
    private BigDecimal EXPECTED_YIELD;

    /**
     * This field corresponds to the database column TRSDET.LIBOR_RATE
     */
    private BigDecimal LIBOR_RATE;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_GL_2
     */
    private BigDecimal SPECIFIC_MOD_GL_2;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_CIF_2
     */
    private BigDecimal SPECIFIC_MOD_CIF_2;

    /**
     * This field corresponds to the database column TRSDET.SPECIFIC_MOD_SL_2
     */
    private BigDecimal SPECIFIC_MOD_SL_2;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTONBS_FC
     */
    private BigDecimal INVESTMENTONBS_FC;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTONBS_CV
     */
    private BigDecimal INVESTMENTONBS_CV;

    /**
     * This field corresponds to the database column TRSDET.LEVERAGE_RATIO
     */
    private BigDecimal LEVERAGE_RATIO;

    /**
     * This field corresponds to the database column TRSDET.ORG_EXPECTED_YIELD
     */
    private BigDecimal ORG_EXPECTED_YIELD;

    /**
     * This field corresponds to the database column TRSDET.CROSS_EXCH_MULTDIV
     */
    private String CROSS_EXCH_MULTDIV;

    /**
     * This field corresponds to the database column TRSDET.LIABILITY_CY
     */
    private BigDecimal LIABILITY_CY;

    /**
     * This field corresponds to the database column TRSDET.LIABILITY_GL
     */
    private BigDecimal LIABILITY_GL;

    /**
     * This field corresponds to the database column TRSDET.LIABILITY_CIF
     */
    private BigDecimal LIABILITY_CIF;

    /**
     * This field corresponds to the database column TRSDET.LIABILITY_SL
     */
    private BigDecimal LIABILITY_SL;

    /**
     * This field corresponds to the database column TRSDET.PROFITPAYABLE_FC_2
     */
    private BigDecimal PROFITPAYABLE_FC_2;

    /**
     * This field corresponds to the database column TRSDET.PROFITPAYABLE_CV_2
     */
    private BigDecimal PROFITPAYABLE_CV_2;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTOFFBS_FC_2
     */
    private BigDecimal INVESTMENTOFFBS_FC_2;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTOFFBS_CV_2
     */
    private BigDecimal INVESTMENTOFFBS_CV_2;

    /**
     * This field corresponds to the database column
     * TRSDET.TEMPLATE_CODE_INVESTMENT
     */
    private BigDecimal TEMPLATE_CODE_INVESTMENT;

    /**
     * This field corresponds to the database column
     * TRSDET.TEMPLATE_CODE_SETTLEMENT
     */
    private BigDecimal TEMPLATE_CODE_SETTLEMENT;

    /**
     * This field corresponds to the database column
     * TRSDET.CHANGE_TEMPLATE_INVESTMENT
     */
    private String CHANGE_TEMPLATE_INVESTMENT;

    /**
     * This field corresponds to the database column
     * TRSDET.CHANGE_TEMPLATE_SETTLEMENT
     */
    private String CHANGE_TEMPLATE_SETTLEMENT;

    /**
     * This field corresponds to the database column TRSDET.TEMPLATE_CODE_EOM
     */
    private BigDecimal TEMPLATE_CODE_EOM;

    /**
     * This field corresponds to the database column TRSDET.TEMPLATE_CODE_EOY
     */
    private BigDecimal TEMPLATE_CODE_EOY;

    /**
     * This field corresponds to the database column
     * TRSDET.TEMPLATE_CODE_ACCRUAL
     */
    private BigDecimal TEMPLATE_CODE_ACCRUAL;

    /**
     * This field corresponds to the database column TRSDET.SWITCHED_AMOUNT
     */
    private BigDecimal SWITCHED_AMOUNT;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_METHOD
     */
    private String ROLLOVER_METHOD;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_AMT_TYPE
     */
    private String ROLLOVER_AMT_TYPE;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_POSITION
     */
    private String ROLLOVER_POSITION;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_DATE_TYPE
     */
    private String ROLLOVER_DATE_TYPE;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_CUMULATIVE
     */
    private String ROLLOVER_CUMULATIVE;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_STATUS
     */
    private String ROLLOVER_STATUS;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_NO
     */
    private BigDecimal ROLLOVER_NO;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTONBS_FC_2
     */
    private BigDecimal INVESTMENTONBS_FC_2;

    /**
     * This field corresponds to the database column TRSDET.INVESTMENTONBS_CV_2
     */
    private BigDecimal INVESTMENTONBS_CV_2;

    /**
     * This field corresponds to the database column TRSDET.SUSPENSE_REVENUE_AMT
     */
    private BigDecimal SUSPENSE_REVENUE_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.SUSPENSE_MODARIB_REVENUE_AMT
     */
    private BigDecimal SUSPENSE_MODARIB_REVENUE_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.SUSPENSE_REVENUE_AMT_CV
     */
    private BigDecimal SUSPENSE_REVENUE_AMT_CV;

    /**
     * This field corresponds to the database column
     * TRSDET.SUSPENSE_MODARIB_REVENUE_CV
     */
    private BigDecimal SUSPENSE_MODARIB_REVENUE_CV;

    /**
     * This field corresponds to the database column TRSDET.REQUEST_ID
     */
    private String REQUEST_ID;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_LINE_NO
     */
    private BigDecimal ROLLOVER_LINE_NO;

    /**
     * This field corresponds to the database column TRSDET.MATR_AC_BR
     */
    private BigDecimal MATR_AC_BR;

    /**
     * This field corresponds to the database column TRSDET.DIFF_AC_BR
     */
    private BigDecimal DIFF_AC_BR;

    /**
     * This field corresponds to the database column TRSDET.TRF_AC_BR
     */
    private BigDecimal TRF_AC_BR;

    /**
     * This field corresponds to the database column TRSDET.REQ_NO
     */
    private BigDecimal REQ_NO;

    /**
     * This field corresponds to the database column TRSDET.REQ_BR
     */
    private BigDecimal REQ_BR;

    /**
     * This field corresponds to the database column TRSDET.MGMT_PCNT
     */
    private BigDecimal MGMT_PCNT;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_AMT_TYPE_2
     */
    private String ROLLOVER_AMT_TYPE_2;

    /**
     * This field corresponds to the database column TRSDET.ROLLOVER_AMOUNT_2
     */
    private BigDecimal ROLLOVER_AMOUNT_2;

    /**
     * This field corresponds to the database column TRSDET.VALUE_DATE
     */
    private Date VALUE_DATE;

    /**
     * This field corresponds to the database column
     * TRSDET.USER_AMENDED_VALUE_DATE_YN
     */
    private String USER_AMENDED_VALUE_DATE_YN;

    /**
     * This field corresponds to the database column TRSDET.BLOCK_CONTRIB_AMT_YN
     */
    private String BLOCK_CONTRIB_AMT_YN;

    /**
     * This field corresponds to the database column
     * TRSDET.ADDITNL_INCOME_IN_SUSPENSE
     */
    private BigDecimal ADDITNL_INCOME_IN_SUSPENSE;

    /**
     * This field corresponds to the database column
     * TRSDET.ADDITNL_INCOME_IN_SUSPENSE_CV
     */
    private BigDecimal ADDITNL_INCOME_IN_SUSPENSE_CV;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIB_BLOCKED_AMOUNT
     */
    private BigDecimal CONTRIB_BLOCKED_AMOUNT;

    /**
     * This field corresponds to the database column TRSDET.DISBURSEMENT_NO
     */
    private BigDecimal DISBURSEMENT_NO;

    /**
     * This field corresponds to the database column TRSDET.SWITCHED_DATE
     */
    private Date SWITCHED_DATE;

    /**
     * This field corresponds to the database column TRSDET.SWITCHED_TYPE
     */
    private String SWITCHED_TYPE;

    /**
     * This field corresponds to the database column TRSDET.SWITCHED_PARTY_TYPE
     */
    private String SWITCHED_PARTY_TYPE;

    /**
     * This field corresponds to the database column TRSDET.OLD_LINE_NO
     */
    private BigDecimal OLD_LINE_NO;

    /**
     * This field corresponds to the database column TRSDET.REASONFORCHANGING
     */
    private BigDecimal REASONFORCHANGING;

    /**
     * This field corresponds to the database column TRSDET.CROSS_EXCH_RATE
     */
    private BigDecimal CROSS_EXCH_RATE;

    /**
     * This field corresponds to the database column TRSDET.AMENDMENT_NO
     */
    private BigDecimal AMENDMENT_NO;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_VIA_TRF_YN
     */
    private String CONTRIBBLOCK_VIA_TRF_YN;

    /**
     * This field corresponds to the database column TRSDET.CONTRIBBLOCK_TRF_AMT
     */
    private BigDecimal CONTRIBBLOCK_TRF_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    private BigDecimal CONTRIBBLOCK_TRF_BLOCK_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_REASON
     */
    private String CONTRIBBLOCK_TRF_REASON;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_BR;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_CY;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_GL;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_CIF;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_SL;

    /**
     * This field corresponds to the database column
     * TRSDET.TOTAL_DEPRECIATION_AMT
     */
    private BigDecimal TOTAL_DEPRECIATION_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.DAILY_DEPRECIATION_AMT
     */
    private BigDecimal DAILY_DEPRECIATION_AMT;

    /**
     * This field corresponds to the database column TRSDET.DAILY_ACCRUAL_AMT
     */
    private BigDecimal DAILY_ACCRUAL_AMT;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_29
     */
    private String MT579_CERTIFICATE_NO_29;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_3
     */
    private String MT579_CERTIFICATE_NO_3;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_30
     */
    private String MT579_CERTIFICATE_NO_30;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_31
     */
    private String MT579_CERTIFICATE_NO_31;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_32
     */
    private String MT579_CERTIFICATE_NO_32;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_33
     */
    private String MT579_CERTIFICATE_NO_33;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_34
     */
    private String MT579_CERTIFICATE_NO_34;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_35
     */
    private String MT579_CERTIFICATE_NO_35;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_4
     */
    private String MT579_CERTIFICATE_NO_4;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_5
     */
    private String MT579_CERTIFICATE_NO_5;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_6
     */
    private String MT579_CERTIFICATE_NO_6;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_7
     */
    private String MT579_CERTIFICATE_NO_7;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_8
     */
    private String MT579_CERTIFICATE_NO_8;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_9
     */
    private String MT579_CERTIFICATE_NO_9;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CONTINUATION_CHAR
     */
    private String MT579_CONTINUATION_CHAR;

    /**
     * This field corresponds to the database column TRSDET.PARTY_ACCNO
     */
    private String PARTY_ACCNO;

    /**
     * This field corresponds to the database column TRSDET.PARTY_BANK
     */
    private BigDecimal PARTY_BANK;

    /**
     * This field corresponds to the database column TRSDET.PARTY_BANK_BIC_CODE
     */
    private String PARTY_BANK_BIC_CODE;

    /**
     * This field corresponds to the database column TRSDET.PARTY_BANK_BR
     */
    private String PARTY_BANK_BR;

    /**
     * This field corresponds to the database column TRSDET.PAYMENT_VIA
     */
    private String PAYMENT_VIA;

    /**
     * This field corresponds to the database column TRSDET.RECEIVER_BANK
     */
    private BigDecimal RECEIVER_BANK;

    /**
     * This field corresponds to the database column TRSDET.RECEIVER_BANK_NAME
     */
    private String RECEIVER_BANK_NAME;

    /**
     * This field corresponds to the database column TRSDET.RECEIVER_CHARGES
     */
    private BigDecimal RECEIVER_CHARGES;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_ACC
     */
    private String RECEIVER_CORR_BANK_ACC;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_ADDRESS
     */
    private String RECEIVER_CORR_BANK_ADDRESS;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_ADDRESS1
     */
    private String RECEIVER_CORR_BANK_ADDRESS1;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_ADDRESS2
     */
    private String RECEIVER_CORR_BANK_ADDRESS2;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_BIC_CODE
     */
    private String RECEIVER_CORR_BANK_BIC_CODE;

    /**
     * This field corresponds to the database column
     * TRSDET.RECEIVER_CORR_BANK_BR
     */
    private String RECEIVER_CORR_BANK_BR;

    /**
     * This field corresponds to the database column TRSDET.REMARKS1
     */
    private String REMARKS1;

    /**
     * This field corresponds to the database column TRSDET.REMARKS2
     */
    private String REMARKS2;

    /**
     * This field corresponds to the database column TRSDET.REMARKS3
     */
    private String REMARKS3;

    /**
     * This field corresponds to the database column TRSDET.SWIFT_CHARGE
     */
    private String SWIFT_CHARGE;

    /**
     * This field corresponds to the database column TRSDET.SWIFT_TYPE
     */
    private String SWIFT_TYPE;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK
     */
    private BigDecimal INTERM_BANK;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK_ACC
     */
    private String INTERM_BANK_ACC;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK_ADDRESS
     */
    private String INTERM_BANK_ADDRESS;

    /**
     * This field corresponds to the database column
     * TRSDET.INTERM_BANK_ADDRESS_1
     */
    private String INTERM_BANK_ADDRESS_1;

    /**
     * This field corresponds to the database column
     * TRSDET.INTERM_BANK_ADDRESS_2
     */
    private String INTERM_BANK_ADDRESS_2;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK_BIC
     */
    private String INTERM_BANK_BIC;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK_BR
     */
    private String INTERM_BANK_BR;

    /**
     * This field corresponds to the database column TRSDET.INTERM_BANK_NAME
     */
    private String INTERM_BANK_NAME;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_BANK_OPERATION_CODE
     */
    private String MT103_BANK_OPERATION_CODE;

    /**
     * This field corresponds to the database column TRSDET.MT103_BENEF_ADDRESS1
     */
    private String MT103_BENEF_ADDRESS1;

    /**
     * This field corresponds to the database column TRSDET.MT103_BENEF_ADDRESS2
     */
    private String MT103_BENEF_ADDRESS2;

    /**
     * This field corresponds to the database column TRSDET.MT103_BENEF_ADDRESS3
     */
    private String MT103_BENEF_ADDRESS3;

    /**
     * This field corresponds to the database column TRSDET.MT103_BENEF_NAME
     */
    private String MT103_BENEF_NAME;

    /**
     * This field corresponds to the database column TRSDET.MT103_CURRENCY
     */
    private String MT103_CURRENCY;

    /**
     * This field corresponds to the database column TRSDET.MT103_EXCH_RATE
     */
    private BigDecimal MT103_EXCH_RATE;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD70_1
     */
    private String MT103_FIELD70_1;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD70_2
     */
    private String MT103_FIELD70_2;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD70_3
     */
    private String MT103_FIELD70_3;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD70_4
     */
    private String MT103_FIELD70_4;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD71F
     */
    private BigDecimal MT103_FIELD71F;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_1
     */
    private String MT103_FIELD72_1;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_2
     */
    private String MT103_FIELD72_2;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_3
     */
    private String MT103_FIELD72_3;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_4
     */
    private String MT103_FIELD72_4;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_5
     */
    private String MT103_FIELD72_5;

    /**
     * This field corresponds to the database column TRSDET.MT103_FIELD72_6
     */
    private String MT103_FIELD72_6;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_INSTRUCTION_AMOUNT
     */
    private BigDecimal MT103_INSTRUCTION_AMOUNT;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_INSTRUCTION_CODE
     */
    private String MT103_INSTRUCTION_CODE;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_REGULATORY_REPORT1
     */
    private String MT103_REGULATORY_REPORT1;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_REGULATORY_REPORT2
     */
    private String MT103_REGULATORY_REPORT2;

    /**
     * This field corresponds to the database column
     * TRSDET.MT103_REGULATORY_REPORT3
     */
    private String MT103_REGULATORY_REPORT3;

    /**
     * This field corresponds to the database column TRSDET.MT103_TRX_TYPE_CODE
     */
    private String MT103_TRX_TYPE_CODE;

    /**
     * This field corresponds to the database column TRSDET.MT200_SWIFT_MESSAGE1
     */
    private String MT200_SWIFT_MESSAGE1;

    /**
     * This field corresponds to the database column TRSDET.MT200_SWIFT_MESSAGE2
     */
    private String MT200_SWIFT_MESSAGE2;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD21
     */
    private String MT202_FIELD21;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_1
     */
    private String MT202_FIELD72_1;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_2
     */
    private String MT202_FIELD72_2;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_3
     */
    private String MT202_FIELD72_3;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_4
     */
    private String MT202_FIELD72_4;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_5
     */
    private String MT202_FIELD72_5;

    /**
     * This field corresponds to the database column TRSDET.MT202_FIELD72_6
     */
    private String MT202_FIELD72_6;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_1
     */
    private String MT579_CERTIFICATE_NO_1;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_10
     */
    private String MT579_CERTIFICATE_NO_10;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_11
     */
    private String MT579_CERTIFICATE_NO_11;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_12
     */
    private String MT579_CERTIFICATE_NO_12;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_13
     */
    private String MT579_CERTIFICATE_NO_13;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_14
     */
    private String MT579_CERTIFICATE_NO_14;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_15
     */
    private String MT579_CERTIFICATE_NO_15;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_16
     */
    private String MT579_CERTIFICATE_NO_16;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_17
     */
    private String MT579_CERTIFICATE_NO_17;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_18
     */
    private String MT579_CERTIFICATE_NO_18;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_19
     */
    private String MT579_CERTIFICATE_NO_19;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_2
     */
    private String MT579_CERTIFICATE_NO_2;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_20
     */
    private String MT579_CERTIFICATE_NO_20;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_21
     */
    private String MT579_CERTIFICATE_NO_21;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_22
     */
    private String MT579_CERTIFICATE_NO_22;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_23
     */
    private String MT579_CERTIFICATE_NO_23;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_24
     */
    private String MT579_CERTIFICATE_NO_24;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_25
     */
    private String MT579_CERTIFICATE_NO_25;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_26
     */
    private String MT579_CERTIFICATE_NO_26;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_27
     */
    private String MT579_CERTIFICATE_NO_27;

    /**
     * This field corresponds to the database column
     * TRSDET.MT579_CERTIFICATE_NO_28
     */
    private String MT579_CERTIFICATE_NO_28;

    /**
     * This field corresponds to the database column TRSDET.CONTRIB_PAYABLE_CIF
     */
    private BigDecimal CONTRIB_PAYABLE_CIF;

    /**
     * This field corresponds to the database column TRSDET.CONTRIB_PAYABLE_GL
     */
    private BigDecimal CONTRIB_PAYABLE_GL;

    /**
     * This field corresponds to the database column TRSDET.CONTRIB_PAYABLE_SL
     */
    private BigDecimal CONTRIB_PAYABLE_SL;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIB_RECEIVABLE_CIF
     */
    private BigDecimal CONTRIB_RECEIVABLE_CIF;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIB_RECEIVABLE_GL
     */
    private BigDecimal CONTRIB_RECEIVABLE_GL;

    /**
     * This field corresponds to the database column
     * TRSDET.CONTRIB_RECEIVABLE_SL
     */
    private BigDecimal CONTRIB_RECEIVABLE_SL;

    /**
     * This field corresponds to the database column TRSDET.MUSHARAKA_PSR
     */
    private BigDecimal MUSHARAKA_PSR;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DEAL_TYPE
     *
     * @return the value of TRSDET.DEAL_TYPE
     */
    public BigDecimal getDEAL_TYPE() {
        return DEAL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DEAL_TYPE
     *
     * @param DEAL_TYPE the value for TRSDET.DEAL_TYPE
     */
    public void setDEAL_TYPE(BigDecimal DEAL_TYPE) {
        this.DEAL_TYPE = DEAL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_TYPE
     *
     * @return the value of TRSDET.PARTY_TYPE
     */
    public String getPARTY_TYPE() {
        return PARTY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_TYPE
     *
     * @param PARTY_TYPE the value for TRSDET.PARTY_TYPE
     */
    public void setPARTY_TYPE(String PARTY_TYPE) {
        this.PARTY_TYPE = PARTY_TYPE == null ? null : PARTY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_NO
     *
     * @return the value of TRSDET.PARTY_NO
     */
    public BigDecimal getPARTY_NO() {
        return PARTY_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_NO
     *
     * @param PARTY_NO the value for TRSDET.PARTY_NO
     */
    public void setPARTY_NO(BigDecimal PARTY_NO) {
        this.PARTY_NO = PARTY_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_BRANCH
     *
     * @return the value of TRSDET.PARTY_BRANCH
     */
    public BigDecimal getPARTY_BRANCH() {
        return PARTY_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_BRANCH
     *
     * @param PARTY_BRANCH the value for TRSDET.PARTY_BRANCH
     */
    public void setPARTY_BRANCH(BigDecimal PARTY_BRANCH) {
        this.PARTY_BRANCH = PARTY_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.AMS_TRS_ID
     *
     * @return the value of TRSDET.AMS_TRS_ID
     */
    public String getAMS_TRS_ID() {
        return AMS_TRS_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.AMS_TRS_ID
     *
     * @param AMS_TRS_ID the value for TRSDET.AMS_TRS_ID
     */
    public void setAMS_TRS_ID(String AMS_TRS_ID) {
        this.AMS_TRS_ID = AMS_TRS_ID == null ? null : AMS_TRS_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.AMOUNT
     *
     * @return the value of TRSDET.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.AMOUNT
     *
     * @param AMOUNT the value for TRSDET.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.YIELD
     *
     * @return the value of TRSDET.YIELD
     */
    public BigDecimal getYIELD() {
        return YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.YIELD
     *
     * @param YIELD the value for TRSDET.YIELD
     */
    public void setYIELD(BigDecimal YIELD) {
        this.YIELD = YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.BC_FLAG
     *
     * @return the value of TRSDET.BC_FLAG
     */
    public String getBC_FLAG() {
        return BC_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.BC_FLAG
     *
     * @param BC_FLAG the value for TRSDET.BC_FLAG
     */
    public void setBC_FLAG(String BC_FLAG) {
        this.BC_FLAG = BC_FLAG == null ? null : BC_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_AC_CY
     *
     * @return the value of TRSDET.TRF_AC_CY
     */
    public BigDecimal getTRF_AC_CY() {
        return TRF_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_AC_CY
     *
     * @param TRF_AC_CY the value for TRSDET.TRF_AC_CY
     */
    public void setTRF_AC_CY(BigDecimal TRF_AC_CY) {
        this.TRF_AC_CY = TRF_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_AC_GL
     *
     * @return the value of TRSDET.TRF_AC_GL
     */
    public BigDecimal getTRF_AC_GL() {
        return TRF_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_AC_GL
     *
     * @param TRF_AC_GL the value for TRSDET.TRF_AC_GL
     */
    public void setTRF_AC_GL(BigDecimal TRF_AC_GL) {
        this.TRF_AC_GL = TRF_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_AC_CIF
     *
     * @return the value of TRSDET.TRF_AC_CIF
     */
    public BigDecimal getTRF_AC_CIF() {
        return TRF_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_AC_CIF
     *
     * @param TRF_AC_CIF the value for TRSDET.TRF_AC_CIF
     */
    public void setTRF_AC_CIF(BigDecimal TRF_AC_CIF) {
        this.TRF_AC_CIF = TRF_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_AC_SL
     *
     * @return the value of TRSDET.TRF_AC_SL
     */
    public BigDecimal getTRF_AC_SL() {
        return TRF_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_AC_SL
     *
     * @param TRF_AC_SL the value for TRSDET.TRF_AC_SL
     */
    public void setTRF_AC_SL(BigDecimal TRF_AC_SL) {
        this.TRF_AC_SL = TRF_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_RATE
     *
     * @return the value of TRSDET.TRF_RATE
     */
    public BigDecimal getTRF_RATE() {
        return TRF_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_RATE
     *
     * @param TRF_RATE the value for TRSDET.TRF_RATE
     */
    public void setTRF_RATE(BigDecimal TRF_RATE) {
        this.TRF_RATE = TRF_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_UNIT
     *
     * @return the value of TRSDET.TRF_UNIT
     */
    public BigDecimal getTRF_UNIT() {
        return TRF_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_UNIT
     *
     * @param TRF_UNIT the value for TRSDET.TRF_UNIT
     */
    public void setTRF_UNIT(BigDecimal TRF_UNIT) {
        this.TRF_UNIT = TRF_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_AC_CY
     *
     * @return the value of TRSDET.MATR_AC_CY
     */
    public BigDecimal getMATR_AC_CY() {
        return MATR_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_AC_CY
     *
     * @param MATR_AC_CY the value for TRSDET.MATR_AC_CY
     */
    public void setMATR_AC_CY(BigDecimal MATR_AC_CY) {
        this.MATR_AC_CY = MATR_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_AC_GL
     *
     * @return the value of TRSDET.MATR_AC_GL
     */
    public BigDecimal getMATR_AC_GL() {
        return MATR_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_AC_GL
     *
     * @param MATR_AC_GL the value for TRSDET.MATR_AC_GL
     */
    public void setMATR_AC_GL(BigDecimal MATR_AC_GL) {
        this.MATR_AC_GL = MATR_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_AC_CIF
     *
     * @return the value of TRSDET.MATR_AC_CIF
     */
    public BigDecimal getMATR_AC_CIF() {
        return MATR_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_AC_CIF
     *
     * @param MATR_AC_CIF the value for TRSDET.MATR_AC_CIF
     */
    public void setMATR_AC_CIF(BigDecimal MATR_AC_CIF) {
        this.MATR_AC_CIF = MATR_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_AC_SL
     *
     * @return the value of TRSDET.MATR_AC_SL
     */
    public BigDecimal getMATR_AC_SL() {
        return MATR_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_AC_SL
     *
     * @param MATR_AC_SL the value for TRSDET.MATR_AC_SL
     */
    public void setMATR_AC_SL(BigDecimal MATR_AC_SL) {
        this.MATR_AC_SL = MATR_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_RATE
     *
     * @return the value of TRSDET.MATR_RATE
     */
    public BigDecimal getMATR_RATE() {
        return MATR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_RATE
     *
     * @param MATR_RATE the value for TRSDET.MATR_RATE
     */
    public void setMATR_RATE(BigDecimal MATR_RATE) {
        this.MATR_RATE = MATR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_UNIT
     *
     * @return the value of TRSDET.MATR_UNIT
     */
    public BigDecimal getMATR_UNIT() {
        return MATR_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_UNIT
     *
     * @param MATR_UNIT the value for TRSDET.MATR_UNIT
     */
    public void setMATR_UNIT(BigDecimal MATR_UNIT) {
        this.MATR_UNIT = MATR_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_AC_CY
     *
     * @return the value of TRSDET.DIFF_AC_CY
     */
    public BigDecimal getDIFF_AC_CY() {
        return DIFF_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_AC_CY
     *
     * @param DIFF_AC_CY the value for TRSDET.DIFF_AC_CY
     */
    public void setDIFF_AC_CY(BigDecimal DIFF_AC_CY) {
        this.DIFF_AC_CY = DIFF_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_AC_GL
     *
     * @return the value of TRSDET.DIFF_AC_GL
     */
    public BigDecimal getDIFF_AC_GL() {
        return DIFF_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_AC_GL
     *
     * @param DIFF_AC_GL the value for TRSDET.DIFF_AC_GL
     */
    public void setDIFF_AC_GL(BigDecimal DIFF_AC_GL) {
        this.DIFF_AC_GL = DIFF_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_AC_CIF
     *
     * @return the value of TRSDET.DIFF_AC_CIF
     */
    public BigDecimal getDIFF_AC_CIF() {
        return DIFF_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_AC_CIF
     *
     * @param DIFF_AC_CIF the value for TRSDET.DIFF_AC_CIF
     */
    public void setDIFF_AC_CIF(BigDecimal DIFF_AC_CIF) {
        this.DIFF_AC_CIF = DIFF_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_AC_SL
     *
     * @return the value of TRSDET.DIFF_AC_SL
     */
    public BigDecimal getDIFF_AC_SL() {
        return DIFF_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_AC_SL
     *
     * @param DIFF_AC_SL the value for TRSDET.DIFF_AC_SL
     */
    public void setDIFF_AC_SL(BigDecimal DIFF_AC_SL) {
        this.DIFF_AC_SL = DIFF_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_RATE
     *
     * @return the value of TRSDET.DIFF_RATE
     */
    public BigDecimal getDIFF_RATE() {
        return DIFF_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_RATE
     *
     * @param DIFF_RATE the value for TRSDET.DIFF_RATE
     */
    public void setDIFF_RATE(BigDecimal DIFF_RATE) {
        this.DIFF_RATE = DIFF_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_UNIT
     *
     * @return the value of TRSDET.DIFF_UNIT
     */
    public BigDecimal getDIFF_UNIT() {
        return DIFF_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_UNIT
     *
     * @param DIFF_UNIT the value for TRSDET.DIFF_UNIT
     */
    public void setDIFF_UNIT(BigDecimal DIFF_UNIT) {
        this.DIFF_UNIT = DIFF_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INV_AC_CY
     *
     * @return the value of TRSDET.INV_AC_CY
     */
    public BigDecimal getINV_AC_CY() {
        return INV_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INV_AC_CY
     *
     * @param INV_AC_CY the value for TRSDET.INV_AC_CY
     */
    public void setINV_AC_CY(BigDecimal INV_AC_CY) {
        this.INV_AC_CY = INV_AC_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INV_AC_GL
     *
     * @return the value of TRSDET.INV_AC_GL
     */
    public BigDecimal getINV_AC_GL() {
        return INV_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INV_AC_GL
     *
     * @param INV_AC_GL the value for TRSDET.INV_AC_GL
     */
    public void setINV_AC_GL(BigDecimal INV_AC_GL) {
        this.INV_AC_GL = INV_AC_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INV_AC_CIF
     *
     * @return the value of TRSDET.INV_AC_CIF
     */
    public BigDecimal getINV_AC_CIF() {
        return INV_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INV_AC_CIF
     *
     * @param INV_AC_CIF the value for TRSDET.INV_AC_CIF
     */
    public void setINV_AC_CIF(BigDecimal INV_AC_CIF) {
        this.INV_AC_CIF = INV_AC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INV_AC_SL
     *
     * @return the value of TRSDET.INV_AC_SL
     */
    public BigDecimal getINV_AC_SL() {
        return INV_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INV_AC_SL
     *
     * @param INV_AC_SL the value for TRSDET.INV_AC_SL
     */
    public void setINV_AC_SL(BigDecimal INV_AC_SL) {
        this.INV_AC_SL = INV_AC_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.BUDGETED_RATE
     *
     * @return the value of TRSDET.BUDGETED_RATE
     */
    public BigDecimal getBUDGETED_RATE() {
        return BUDGETED_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.BUDGETED_RATE
     *
     * @param BUDGETED_RATE the value for TRSDET.BUDGETED_RATE
     */
    public void setBUDGETED_RATE(BigDecimal BUDGETED_RATE) {
        this.BUDGETED_RATE = BUDGETED_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RATE_FLAG
     *
     * @return the value of TRSDET.RATE_FLAG
     */
    public String getRATE_FLAG() {
        return RATE_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RATE_FLAG
     *
     * @param RATE_FLAG the value for TRSDET.RATE_FLAG
     */
    public void setRATE_FLAG(String RATE_FLAG) {
        this.RATE_FLAG = RATE_FLAG == null ? null : RATE_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REVALUATION_RATE
     *
     * @return the value of TRSDET.REVALUATION_RATE
     */
    public BigDecimal getREVALUATION_RATE() {
        return REVALUATION_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REVALUATION_RATE
     *
     * @param REVALUATION_RATE the value for TRSDET.REVALUATION_RATE
     */
    public void setREVALUATION_RATE(BigDecimal REVALUATION_RATE) {
        this.REVALUATION_RATE = REVALUATION_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATURED_IND
     *
     * @return the value of TRSDET.MATURED_IND
     */
    public String getMATURED_IND() {
        return MATURED_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATURED_IND
     *
     * @param MATURED_IND the value for TRSDET.MATURED_IND
     */
    public void setMATURED_IND(String MATURED_IND) {
        this.MATURED_IND = MATURED_IND == null ? null : MATURED_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_JV
     *
     * @return the value of TRSDET.MATR_JV
     */
    public String getMATR_JV() {
        return MATR_JV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_JV
     *
     * @param MATR_JV the value for TRSDET.MATR_JV
     */
    public void setMATR_JV(String MATR_JV) {
        this.MATR_JV = MATR_JV == null ? null : MATR_JV.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_IND
     *
     * @return the value of TRSDET.ROLLOVER_IND
     */
    public String getROLLOVER_IND() {
        return ROLLOVER_IND;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_IND
     *
     * @param ROLLOVER_IND the value for TRSDET.ROLLOVER_IND
     */
    public void setROLLOVER_IND(String ROLLOVER_IND) {
        this.ROLLOVER_IND = ROLLOVER_IND == null ? null : ROLLOVER_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_AMOUNT
     *
     * @return the value of TRSDET.ROLLOVER_AMOUNT
     */
    public BigDecimal getROLLOVER_AMOUNT() {
        return ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_AMOUNT
     *
     * @param ROLLOVER_AMOUNT the value for TRSDET.ROLLOVER_AMOUNT
     */
    public void setROLLOVER_AMOUNT(BigDecimal ROLLOVER_AMOUNT) {
        this.ROLLOVER_AMOUNT = ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.AMOUNT_USED
     *
     * @return the value of TRSDET.AMOUNT_USED
     */
    public BigDecimal getAMOUNT_USED() {
        return AMOUNT_USED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.AMOUNT_USED
     *
     * @param AMOUNT_USED the value for TRSDET.AMOUNT_USED
     */
    public void setAMOUNT_USED(BigDecimal AMOUNT_USED) {
        this.AMOUNT_USED = AMOUNT_USED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CLASS
     *
     * @return the value of TRSDET.CLASS
     */
    public BigDecimal getCLASS() {
        return CLASS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CLASS
     *
     * @param CLASS the value for TRSDET.CLASS
     */
    public void setCLASS(BigDecimal CLASS) {
        this.CLASS = CLASS;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PROFIT_SHARE_RATIO
     *
     * @return the value of TRSDET.PROFIT_SHARE_RATIO
     */
    public BigDecimal getPROFIT_SHARE_RATIO() {
        return PROFIT_SHARE_RATIO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PROFIT_SHARE_RATIO
     *
     * @param PROFIT_SHARE_RATIO the value for TRSDET.PROFIT_SHARE_RATIO
     */
    public void setPROFIT_SHARE_RATIO(BigDecimal PROFIT_SHARE_RATIO) {
        this.PROFIT_SHARE_RATIO = PROFIT_SHARE_RATIO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CROSS_CY_RATE
     *
     * @return the value of TRSDET.CROSS_CY_RATE
     */
    public BigDecimal getCROSS_CY_RATE() {
        return CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CROSS_CY_RATE
     *
     * @param CROSS_CY_RATE the value for TRSDET.CROSS_CY_RATE
     */
    public void setCROSS_CY_RATE(BigDecimal CROSS_CY_RATE) {
        this.CROSS_CY_RATE = CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CROSS_CY_MULT_DIV
     *
     * @return the value of TRSDET.CROSS_CY_MULT_DIV
     */
    public String getCROSS_CY_MULT_DIV() {
        return CROSS_CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CROSS_CY_MULT_DIV
     *
     * @param CROSS_CY_MULT_DIV the value for TRSDET.CROSS_CY_MULT_DIV
     */
    public void setCROSS_CY_MULT_DIV(String CROSS_CY_MULT_DIV) {
        this.CROSS_CY_MULT_DIV = CROSS_CY_MULT_DIV == null ? null : CROSS_CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CROSS_CY_AMOUNT
     *
     * @return the value of TRSDET.CROSS_CY_AMOUNT
     */
    public BigDecimal getCROSS_CY_AMOUNT() {
        return CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CROSS_CY_AMOUNT
     *
     * @param CROSS_CY_AMOUNT the value for TRSDET.CROSS_CY_AMOUNT
     */
    public void setCROSS_CY_AMOUNT(BigDecimal CROSS_CY_AMOUNT) {
        this.CROSS_CY_AMOUNT = CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_GL
     *
     * @return the value of TRSDET.SPECIFIC_MOD_GL
     */
    public BigDecimal getSPECIFIC_MOD_GL() {
        return SPECIFIC_MOD_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_GL
     *
     * @param SPECIFIC_MOD_GL the value for TRSDET.SPECIFIC_MOD_GL
     */
    public void setSPECIFIC_MOD_GL(BigDecimal SPECIFIC_MOD_GL) {
        this.SPECIFIC_MOD_GL = SPECIFIC_MOD_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_CIF
     *
     * @return the value of TRSDET.SPECIFIC_MOD_CIF
     */
    public BigDecimal getSPECIFIC_MOD_CIF() {
        return SPECIFIC_MOD_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_CIF
     *
     * @param SPECIFIC_MOD_CIF the value for TRSDET.SPECIFIC_MOD_CIF
     */
    public void setSPECIFIC_MOD_CIF(BigDecimal SPECIFIC_MOD_CIF) {
        this.SPECIFIC_MOD_CIF = SPECIFIC_MOD_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_SL
     *
     * @return the value of TRSDET.SPECIFIC_MOD_SL
     */
    public BigDecimal getSPECIFIC_MOD_SL() {
        return SPECIFIC_MOD_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_SL
     *
     * @param SPECIFIC_MOD_SL the value for TRSDET.SPECIFIC_MOD_SL
     */
    public void setSPECIFIC_MOD_SL(BigDecimal SPECIFIC_MOD_SL) {
        this.SPECIFIC_MOD_SL = SPECIFIC_MOD_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PORTFOLIO_CIF
     *
     * @return the value of TRSDET.PORTFOLIO_CIF
     */
    public BigDecimal getPORTFOLIO_CIF() {
        return PORTFOLIO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PORTFOLIO_CIF
     *
     * @param PORTFOLIO_CIF the value for TRSDET.PORTFOLIO_CIF
     */
    public void setPORTFOLIO_CIF(BigDecimal PORTFOLIO_CIF) {
        this.PORTFOLIO_CIF = PORTFOLIO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PORTFOLIO_SEQ
     *
     * @return the value of TRSDET.PORTFOLIO_SEQ
     */
    public BigDecimal getPORTFOLIO_SEQ() {
        return PORTFOLIO_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PORTFOLIO_SEQ
     *
     * @param PORTFOLIO_SEQ the value for TRSDET.PORTFOLIO_SEQ
     */
    public void setPORTFOLIO_SEQ(BigDecimal PORTFOLIO_SEQ) {
        this.PORTFOLIO_SEQ = PORTFOLIO_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REF_DEAL_CLASS
     *
     * @return the value of TRSDET.REF_DEAL_CLASS
     */
    public BigDecimal getREF_DEAL_CLASS() {
        return REF_DEAL_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REF_DEAL_CLASS
     *
     * @param REF_DEAL_CLASS the value for TRSDET.REF_DEAL_CLASS
     */
    public void setREF_DEAL_CLASS(BigDecimal REF_DEAL_CLASS) {
        this.REF_DEAL_CLASS = REF_DEAL_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REF_DEAL_YIELD
     *
     * @return the value of TRSDET.REF_DEAL_YIELD
     */
    public BigDecimal getREF_DEAL_YIELD() {
        return REF_DEAL_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REF_DEAL_YIELD
     *
     * @param REF_DEAL_YIELD the value for TRSDET.REF_DEAL_YIELD
     */
    public void setREF_DEAL_YIELD(BigDecimal REF_DEAL_YIELD) {
        this.REF_DEAL_YIELD = REF_DEAL_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTOFFBS_FC
     *
     * @return the value of TRSDET.INVESTMENTOFFBS_FC
     */
    public BigDecimal getINVESTMENTOFFBS_FC() {
        return INVESTMENTOFFBS_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTOFFBS_FC
     *
     * @param INVESTMENTOFFBS_FC the value for TRSDET.INVESTMENTOFFBS_FC
     */
    public void setINVESTMENTOFFBS_FC(BigDecimal INVESTMENTOFFBS_FC) {
        this.INVESTMENTOFFBS_FC = INVESTMENTOFFBS_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTOFFBS_CV
     *
     * @return the value of TRSDET.INVESTMENTOFFBS_CV
     */
    public BigDecimal getINVESTMENTOFFBS_CV() {
        return INVESTMENTOFFBS_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTOFFBS_CV
     *
     * @param INVESTMENTOFFBS_CV the value for TRSDET.INVESTMENTOFFBS_CV
     */
    public void setINVESTMENTOFFBS_CV(BigDecimal INVESTMENTOFFBS_CV) {
        this.INVESTMENTOFFBS_CV = INVESTMENTOFFBS_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.AMOUNT_2
     *
     * @return the value of TRSDET.AMOUNT_2
     */
    public BigDecimal getAMOUNT_2() {
        return AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.AMOUNT_2
     *
     * @param AMOUNT_2 the value for TRSDET.AMOUNT_2
     */
    public void setAMOUNT_2(BigDecimal AMOUNT_2) {
        this.AMOUNT_2 = AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PROFITPAYABLE_FC
     *
     * @return the value of TRSDET.PROFITPAYABLE_FC
     */
    public BigDecimal getPROFITPAYABLE_FC() {
        return PROFITPAYABLE_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PROFITPAYABLE_FC
     *
     * @param PROFITPAYABLE_FC the value for TRSDET.PROFITPAYABLE_FC
     */
    public void setPROFITPAYABLE_FC(BigDecimal PROFITPAYABLE_FC) {
        this.PROFITPAYABLE_FC = PROFITPAYABLE_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PROFITPAYABLE_CV
     *
     * @return the value of TRSDET.PROFITPAYABLE_CV
     */
    public BigDecimal getPROFITPAYABLE_CV() {
        return PROFITPAYABLE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PROFITPAYABLE_CV
     *
     * @param PROFITPAYABLE_CV the value for TRSDET.PROFITPAYABLE_CV
     */
    public void setPROFITPAYABLE_CV(BigDecimal PROFITPAYABLE_CV) {
        this.PROFITPAYABLE_CV = PROFITPAYABLE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.EXPECTED_YIELD
     *
     * @return the value of TRSDET.EXPECTED_YIELD
     */
    public BigDecimal getEXPECTED_YIELD() {
        return EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.EXPECTED_YIELD
     *
     * @param EXPECTED_YIELD the value for TRSDET.EXPECTED_YIELD
     */
    public void setEXPECTED_YIELD(BigDecimal EXPECTED_YIELD) {
        this.EXPECTED_YIELD = EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LIBOR_RATE
     *
     * @return the value of TRSDET.LIBOR_RATE
     */
    public BigDecimal getLIBOR_RATE() {
        return LIBOR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LIBOR_RATE
     *
     * @param LIBOR_RATE the value for TRSDET.LIBOR_RATE
     */
    public void setLIBOR_RATE(BigDecimal LIBOR_RATE) {
        this.LIBOR_RATE = LIBOR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_GL_2
     *
     * @return the value of TRSDET.SPECIFIC_MOD_GL_2
     */
    public BigDecimal getSPECIFIC_MOD_GL_2() {
        return SPECIFIC_MOD_GL_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_GL_2
     *
     * @param SPECIFIC_MOD_GL_2 the value for TRSDET.SPECIFIC_MOD_GL_2
     */
    public void setSPECIFIC_MOD_GL_2(BigDecimal SPECIFIC_MOD_GL_2) {
        this.SPECIFIC_MOD_GL_2 = SPECIFIC_MOD_GL_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_CIF_2
     *
     * @return the value of TRSDET.SPECIFIC_MOD_CIF_2
     */
    public BigDecimal getSPECIFIC_MOD_CIF_2() {
        return SPECIFIC_MOD_CIF_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_CIF_2
     *
     * @param SPECIFIC_MOD_CIF_2 the value for TRSDET.SPECIFIC_MOD_CIF_2
     */
    public void setSPECIFIC_MOD_CIF_2(BigDecimal SPECIFIC_MOD_CIF_2) {
        this.SPECIFIC_MOD_CIF_2 = SPECIFIC_MOD_CIF_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SPECIFIC_MOD_SL_2
     *
     * @return the value of TRSDET.SPECIFIC_MOD_SL_2
     */
    public BigDecimal getSPECIFIC_MOD_SL_2() {
        return SPECIFIC_MOD_SL_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SPECIFIC_MOD_SL_2
     *
     * @param SPECIFIC_MOD_SL_2 the value for TRSDET.SPECIFIC_MOD_SL_2
     */
    public void setSPECIFIC_MOD_SL_2(BigDecimal SPECIFIC_MOD_SL_2) {
        this.SPECIFIC_MOD_SL_2 = SPECIFIC_MOD_SL_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTONBS_FC
     *
     * @return the value of TRSDET.INVESTMENTONBS_FC
     */
    public BigDecimal getINVESTMENTONBS_FC() {
        return INVESTMENTONBS_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTONBS_FC
     *
     * @param INVESTMENTONBS_FC the value for TRSDET.INVESTMENTONBS_FC
     */
    public void setINVESTMENTONBS_FC(BigDecimal INVESTMENTONBS_FC) {
        this.INVESTMENTONBS_FC = INVESTMENTONBS_FC;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTONBS_CV
     *
     * @return the value of TRSDET.INVESTMENTONBS_CV
     */
    public BigDecimal getINVESTMENTONBS_CV() {
        return INVESTMENTONBS_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTONBS_CV
     *
     * @param INVESTMENTONBS_CV the value for TRSDET.INVESTMENTONBS_CV
     */
    public void setINVESTMENTONBS_CV(BigDecimal INVESTMENTONBS_CV) {
        this.INVESTMENTONBS_CV = INVESTMENTONBS_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LEVERAGE_RATIO
     *
     * @return the value of TRSDET.LEVERAGE_RATIO
     */
    public BigDecimal getLEVERAGE_RATIO() {
        return LEVERAGE_RATIO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LEVERAGE_RATIO
     *
     * @param LEVERAGE_RATIO the value for TRSDET.LEVERAGE_RATIO
     */
    public void setLEVERAGE_RATIO(BigDecimal LEVERAGE_RATIO) {
        this.LEVERAGE_RATIO = LEVERAGE_RATIO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ORG_EXPECTED_YIELD
     *
     * @return the value of TRSDET.ORG_EXPECTED_YIELD
     */
    public BigDecimal getORG_EXPECTED_YIELD() {
        return ORG_EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ORG_EXPECTED_YIELD
     *
     * @param ORG_EXPECTED_YIELD the value for TRSDET.ORG_EXPECTED_YIELD
     */
    public void setORG_EXPECTED_YIELD(BigDecimal ORG_EXPECTED_YIELD) {
        this.ORG_EXPECTED_YIELD = ORG_EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CROSS_EXCH_MULTDIV
     *
     * @return the value of TRSDET.CROSS_EXCH_MULTDIV
     */
    public String getCROSS_EXCH_MULTDIV() {
        return CROSS_EXCH_MULTDIV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CROSS_EXCH_MULTDIV
     *
     * @param CROSS_EXCH_MULTDIV the value for TRSDET.CROSS_EXCH_MULTDIV
     */
    public void setCROSS_EXCH_MULTDIV(String CROSS_EXCH_MULTDIV) {
        this.CROSS_EXCH_MULTDIV = CROSS_EXCH_MULTDIV == null ? null : CROSS_EXCH_MULTDIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LIABILITY_CY
     *
     * @return the value of TRSDET.LIABILITY_CY
     */
    public BigDecimal getLIABILITY_CY() {
        return LIABILITY_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LIABILITY_CY
     *
     * @param LIABILITY_CY the value for TRSDET.LIABILITY_CY
     */
    public void setLIABILITY_CY(BigDecimal LIABILITY_CY) {
        this.LIABILITY_CY = LIABILITY_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LIABILITY_GL
     *
     * @return the value of TRSDET.LIABILITY_GL
     */
    public BigDecimal getLIABILITY_GL() {
        return LIABILITY_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LIABILITY_GL
     *
     * @param LIABILITY_GL the value for TRSDET.LIABILITY_GL
     */
    public void setLIABILITY_GL(BigDecimal LIABILITY_GL) {
        this.LIABILITY_GL = LIABILITY_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LIABILITY_CIF
     *
     * @return the value of TRSDET.LIABILITY_CIF
     */
    public BigDecimal getLIABILITY_CIF() {
        return LIABILITY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LIABILITY_CIF
     *
     * @param LIABILITY_CIF the value for TRSDET.LIABILITY_CIF
     */
    public void setLIABILITY_CIF(BigDecimal LIABILITY_CIF) {
        this.LIABILITY_CIF = LIABILITY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.LIABILITY_SL
     *
     * @return the value of TRSDET.LIABILITY_SL
     */
    public BigDecimal getLIABILITY_SL() {
        return LIABILITY_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.LIABILITY_SL
     *
     * @param LIABILITY_SL the value for TRSDET.LIABILITY_SL
     */
    public void setLIABILITY_SL(BigDecimal LIABILITY_SL) {
        this.LIABILITY_SL = LIABILITY_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PROFITPAYABLE_FC_2
     *
     * @return the value of TRSDET.PROFITPAYABLE_FC_2
     */
    public BigDecimal getPROFITPAYABLE_FC_2() {
        return PROFITPAYABLE_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PROFITPAYABLE_FC_2
     *
     * @param PROFITPAYABLE_FC_2 the value for TRSDET.PROFITPAYABLE_FC_2
     */
    public void setPROFITPAYABLE_FC_2(BigDecimal PROFITPAYABLE_FC_2) {
        this.PROFITPAYABLE_FC_2 = PROFITPAYABLE_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PROFITPAYABLE_CV_2
     *
     * @return the value of TRSDET.PROFITPAYABLE_CV_2
     */
    public BigDecimal getPROFITPAYABLE_CV_2() {
        return PROFITPAYABLE_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PROFITPAYABLE_CV_2
     *
     * @param PROFITPAYABLE_CV_2 the value for TRSDET.PROFITPAYABLE_CV_2
     */
    public void setPROFITPAYABLE_CV_2(BigDecimal PROFITPAYABLE_CV_2) {
        this.PROFITPAYABLE_CV_2 = PROFITPAYABLE_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTOFFBS_FC_2
     *
     * @return the value of TRSDET.INVESTMENTOFFBS_FC_2
     */
    public BigDecimal getINVESTMENTOFFBS_FC_2() {
        return INVESTMENTOFFBS_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTOFFBS_FC_2
     *
     * @param INVESTMENTOFFBS_FC_2 the value for TRSDET.INVESTMENTOFFBS_FC_2
     */
    public void setINVESTMENTOFFBS_FC_2(BigDecimal INVESTMENTOFFBS_FC_2) {
        this.INVESTMENTOFFBS_FC_2 = INVESTMENTOFFBS_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTOFFBS_CV_2
     *
     * @return the value of TRSDET.INVESTMENTOFFBS_CV_2
     */
    public BigDecimal getINVESTMENTOFFBS_CV_2() {
        return INVESTMENTOFFBS_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTOFFBS_CV_2
     *
     * @param INVESTMENTOFFBS_CV_2 the value for TRSDET.INVESTMENTOFFBS_CV_2
     */
    public void setINVESTMENTOFFBS_CV_2(BigDecimal INVESTMENTOFFBS_CV_2) {
        this.INVESTMENTOFFBS_CV_2 = INVESTMENTOFFBS_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TEMPLATE_CODE_INVESTMENT
     *
     * @return the value of TRSDET.TEMPLATE_CODE_INVESTMENT
     */
    public BigDecimal getTEMPLATE_CODE_INVESTMENT() {
        return TEMPLATE_CODE_INVESTMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TEMPLATE_CODE_INVESTMENT
     *
     * @param TEMPLATE_CODE_INVESTMENT the value for
     *            TRSDET.TEMPLATE_CODE_INVESTMENT
     */
    public void setTEMPLATE_CODE_INVESTMENT(BigDecimal TEMPLATE_CODE_INVESTMENT) {
        this.TEMPLATE_CODE_INVESTMENT = TEMPLATE_CODE_INVESTMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TEMPLATE_CODE_SETTLEMENT
     *
     * @return the value of TRSDET.TEMPLATE_CODE_SETTLEMENT
     */
    public BigDecimal getTEMPLATE_CODE_SETTLEMENT() {
        return TEMPLATE_CODE_SETTLEMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TEMPLATE_CODE_SETTLEMENT
     *
     * @param TEMPLATE_CODE_SETTLEMENT the value for
     *            TRSDET.TEMPLATE_CODE_SETTLEMENT
     */
    public void setTEMPLATE_CODE_SETTLEMENT(BigDecimal TEMPLATE_CODE_SETTLEMENT) {
        this.TEMPLATE_CODE_SETTLEMENT = TEMPLATE_CODE_SETTLEMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CHANGE_TEMPLATE_INVESTMENT
     *
     * @return the value of TRSDET.CHANGE_TEMPLATE_INVESTMENT
     */
    public String getCHANGE_TEMPLATE_INVESTMENT() {
        return CHANGE_TEMPLATE_INVESTMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CHANGE_TEMPLATE_INVESTMENT
     *
     * @param CHANGE_TEMPLATE_INVESTMENT the value for
     *            TRSDET.CHANGE_TEMPLATE_INVESTMENT
     */
    public void setCHANGE_TEMPLATE_INVESTMENT(String CHANGE_TEMPLATE_INVESTMENT) {
        this.CHANGE_TEMPLATE_INVESTMENT = CHANGE_TEMPLATE_INVESTMENT == null ? null : CHANGE_TEMPLATE_INVESTMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CHANGE_TEMPLATE_SETTLEMENT
     *
     * @return the value of TRSDET.CHANGE_TEMPLATE_SETTLEMENT
     */
    public String getCHANGE_TEMPLATE_SETTLEMENT() {
        return CHANGE_TEMPLATE_SETTLEMENT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CHANGE_TEMPLATE_SETTLEMENT
     *
     * @param CHANGE_TEMPLATE_SETTLEMENT the value for
     *            TRSDET.CHANGE_TEMPLATE_SETTLEMENT
     */
    public void setCHANGE_TEMPLATE_SETTLEMENT(String CHANGE_TEMPLATE_SETTLEMENT) {
        this.CHANGE_TEMPLATE_SETTLEMENT = CHANGE_TEMPLATE_SETTLEMENT == null ? null : CHANGE_TEMPLATE_SETTLEMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TEMPLATE_CODE_EOM
     *
     * @return the value of TRSDET.TEMPLATE_CODE_EOM
     */
    public BigDecimal getTEMPLATE_CODE_EOM()
    {
	return TEMPLATE_CODE_EOM;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TEMPLATE_CODE_EOM
     *
     * @param TEMPLATE_CODE_EOM the value for TRSDET.TEMPLATE_CODE_EOM
     */
    public void setTEMPLATE_CODE_EOM(BigDecimal TEMPLATE_CODE_EOM)
    {
	this.TEMPLATE_CODE_EOM = TEMPLATE_CODE_EOM;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TEMPLATE_CODE_EOY
     *
     * @return the value of TRSDET.TEMPLATE_CODE_EOY
     */
    public BigDecimal getTEMPLATE_CODE_EOY()
    {
	return TEMPLATE_CODE_EOY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TEMPLATE_CODE_EOY
     *
     * @param TEMPLATE_CODE_EOY the value for TRSDET.TEMPLATE_CODE_EOY
     */
    public void setTEMPLATE_CODE_EOY(BigDecimal TEMPLATE_CODE_EOY)
    {
	this.TEMPLATE_CODE_EOY = TEMPLATE_CODE_EOY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TEMPLATE_CODE_ACCRUAL
     *
     * @return the value of TRSDET.TEMPLATE_CODE_ACCRUAL
     */
    public BigDecimal getTEMPLATE_CODE_ACCRUAL()
    {
	return TEMPLATE_CODE_ACCRUAL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TEMPLATE_CODE_ACCRUAL
     *
     * @param TEMPLATE_CODE_ACCRUAL the value for TRSDET.TEMPLATE_CODE_ACCRUAL
     */
    public void setTEMPLATE_CODE_ACCRUAL(BigDecimal TEMPLATE_CODE_ACCRUAL)
    {
	this.TEMPLATE_CODE_ACCRUAL = TEMPLATE_CODE_ACCRUAL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWITCHED_AMOUNT
     *
     * @return the value of TRSDET.SWITCHED_AMOUNT
     */
    public BigDecimal getSWITCHED_AMOUNT() {
        return SWITCHED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWITCHED_AMOUNT
     *
     * @param SWITCHED_AMOUNT the value for TRSDET.SWITCHED_AMOUNT
     */
    public void setSWITCHED_AMOUNT(BigDecimal SWITCHED_AMOUNT) {
        this.SWITCHED_AMOUNT = SWITCHED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_METHOD
     *
     * @return the value of TRSDET.ROLLOVER_METHOD
     */
    public String getROLLOVER_METHOD() {
        return ROLLOVER_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_METHOD
     *
     * @param ROLLOVER_METHOD the value for TRSDET.ROLLOVER_METHOD
     */
    public void setROLLOVER_METHOD(String ROLLOVER_METHOD) {
        this.ROLLOVER_METHOD = ROLLOVER_METHOD == null ? null : ROLLOVER_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_AMT_TYPE
     *
     * @return the value of TRSDET.ROLLOVER_AMT_TYPE
     */
    public String getROLLOVER_AMT_TYPE() {
        return ROLLOVER_AMT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_AMT_TYPE
     *
     * @param ROLLOVER_AMT_TYPE the value for TRSDET.ROLLOVER_AMT_TYPE
     */
    public void setROLLOVER_AMT_TYPE(String ROLLOVER_AMT_TYPE) {
        this.ROLLOVER_AMT_TYPE = ROLLOVER_AMT_TYPE == null ? null : ROLLOVER_AMT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_POSITION
     *
     * @return the value of TRSDET.ROLLOVER_POSITION
     */
    public String getROLLOVER_POSITION() {
        return ROLLOVER_POSITION;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_POSITION
     *
     * @param ROLLOVER_POSITION the value for TRSDET.ROLLOVER_POSITION
     */
    public void setROLLOVER_POSITION(String ROLLOVER_POSITION) {
        this.ROLLOVER_POSITION = ROLLOVER_POSITION == null ? null : ROLLOVER_POSITION.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_DATE_TYPE
     *
     * @return the value of TRSDET.ROLLOVER_DATE_TYPE
     */
    public String getROLLOVER_DATE_TYPE() {
        return ROLLOVER_DATE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_DATE_TYPE
     *
     * @param ROLLOVER_DATE_TYPE the value for TRSDET.ROLLOVER_DATE_TYPE
     */
    public void setROLLOVER_DATE_TYPE(String ROLLOVER_DATE_TYPE) {
        this.ROLLOVER_DATE_TYPE = ROLLOVER_DATE_TYPE == null ? null : ROLLOVER_DATE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_CUMULATIVE
     *
     * @return the value of TRSDET.ROLLOVER_CUMULATIVE
     */
    public String getROLLOVER_CUMULATIVE() {
        return ROLLOVER_CUMULATIVE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_CUMULATIVE
     *
     * @param ROLLOVER_CUMULATIVE the value for TRSDET.ROLLOVER_CUMULATIVE
     */
    public void setROLLOVER_CUMULATIVE(String ROLLOVER_CUMULATIVE) {
        this.ROLLOVER_CUMULATIVE = ROLLOVER_CUMULATIVE == null ? null : ROLLOVER_CUMULATIVE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_STATUS
     *
     * @return the value of TRSDET.ROLLOVER_STATUS
     */
    public String getROLLOVER_STATUS() {
        return ROLLOVER_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_STATUS
     *
     * @param ROLLOVER_STATUS the value for TRSDET.ROLLOVER_STATUS
     */
    public void setROLLOVER_STATUS(String ROLLOVER_STATUS) {
        this.ROLLOVER_STATUS = ROLLOVER_STATUS == null ? null : ROLLOVER_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_NO
     *
     * @return the value of TRSDET.ROLLOVER_NO
     */
    public BigDecimal getROLLOVER_NO() {
        return ROLLOVER_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_NO
     *
     * @param ROLLOVER_NO the value for TRSDET.ROLLOVER_NO
     */
    public void setROLLOVER_NO(BigDecimal ROLLOVER_NO) {
        this.ROLLOVER_NO = ROLLOVER_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTONBS_FC_2
     *
     * @return the value of TRSDET.INVESTMENTONBS_FC_2
     */
    public BigDecimal getINVESTMENTONBS_FC_2() {
        return INVESTMENTONBS_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTONBS_FC_2
     *
     * @param INVESTMENTONBS_FC_2 the value for TRSDET.INVESTMENTONBS_FC_2
     */
    public void setINVESTMENTONBS_FC_2(BigDecimal INVESTMENTONBS_FC_2) {
        this.INVESTMENTONBS_FC_2 = INVESTMENTONBS_FC_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INVESTMENTONBS_CV_2
     *
     * @return the value of TRSDET.INVESTMENTONBS_CV_2
     */
    public BigDecimal getINVESTMENTONBS_CV_2() {
        return INVESTMENTONBS_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INVESTMENTONBS_CV_2
     *
     * @param INVESTMENTONBS_CV_2 the value for TRSDET.INVESTMENTONBS_CV_2
     */
    public void setINVESTMENTONBS_CV_2(BigDecimal INVESTMENTONBS_CV_2) {
        this.INVESTMENTONBS_CV_2 = INVESTMENTONBS_CV_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SUSPENSE_REVENUE_AMT
     *
     * @return the value of TRSDET.SUSPENSE_REVENUE_AMT
     */
    public BigDecimal getSUSPENSE_REVENUE_AMT() {
        return SUSPENSE_REVENUE_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SUSPENSE_REVENUE_AMT
     *
     * @param SUSPENSE_REVENUE_AMT the value for TRSDET.SUSPENSE_REVENUE_AMT
     */
    public void setSUSPENSE_REVENUE_AMT(BigDecimal SUSPENSE_REVENUE_AMT) {
        this.SUSPENSE_REVENUE_AMT = SUSPENSE_REVENUE_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SUSPENSE_MODARIB_REVENUE_AMT
     *
     * @return the value of TRSDET.SUSPENSE_MODARIB_REVENUE_AMT
     */
    public BigDecimal getSUSPENSE_MODARIB_REVENUE_AMT() {
        return SUSPENSE_MODARIB_REVENUE_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SUSPENSE_MODARIB_REVENUE_AMT
     *
     * @param SUSPENSE_MODARIB_REVENUE_AMT the value for
     *            TRSDET.SUSPENSE_MODARIB_REVENUE_AMT
     */
    public void setSUSPENSE_MODARIB_REVENUE_AMT(BigDecimal SUSPENSE_MODARIB_REVENUE_AMT) {
        this.SUSPENSE_MODARIB_REVENUE_AMT = SUSPENSE_MODARIB_REVENUE_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SUSPENSE_REVENUE_AMT_CV
     *
     * @return the value of TRSDET.SUSPENSE_REVENUE_AMT_CV
     */
    public BigDecimal getSUSPENSE_REVENUE_AMT_CV() {
        return SUSPENSE_REVENUE_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SUSPENSE_REVENUE_AMT_CV
     *
     * @param SUSPENSE_REVENUE_AMT_CV the value for
     *            TRSDET.SUSPENSE_REVENUE_AMT_CV
     */
    public void setSUSPENSE_REVENUE_AMT_CV(BigDecimal SUSPENSE_REVENUE_AMT_CV) {
        this.SUSPENSE_REVENUE_AMT_CV = SUSPENSE_REVENUE_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SUSPENSE_MODARIB_REVENUE_CV
     *
     * @return the value of TRSDET.SUSPENSE_MODARIB_REVENUE_CV
     */
    public BigDecimal getSUSPENSE_MODARIB_REVENUE_CV() {
        return SUSPENSE_MODARIB_REVENUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SUSPENSE_MODARIB_REVENUE_CV
     *
     * @param SUSPENSE_MODARIB_REVENUE_CV the value for
     *            TRSDET.SUSPENSE_MODARIB_REVENUE_CV
     */
    public void setSUSPENSE_MODARIB_REVENUE_CV(BigDecimal SUSPENSE_MODARIB_REVENUE_CV) {
        this.SUSPENSE_MODARIB_REVENUE_CV = SUSPENSE_MODARIB_REVENUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REQUEST_ID
     *
     * @return the value of TRSDET.REQUEST_ID
     */
    public String getREQUEST_ID()
    {
	return REQUEST_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REQUEST_ID
     *
     * @param REQUEST_ID the value for TRSDET.REQUEST_ID
     */
    public void setREQUEST_ID(String REQUEST_ID)
    {
	this.REQUEST_ID = REQUEST_ID == null ? null : REQUEST_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_LINE_NO
     *
     * @return the value of TRSDET.ROLLOVER_LINE_NO
     */
    public BigDecimal getROLLOVER_LINE_NO()
    {
	return ROLLOVER_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_LINE_NO
     *
     * @param ROLLOVER_LINE_NO the value for TRSDET.ROLLOVER_LINE_NO
     */
    public void setROLLOVER_LINE_NO(BigDecimal ROLLOVER_LINE_NO)
    {
	this.ROLLOVER_LINE_NO = ROLLOVER_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MATR_AC_BR
     *
     * @return the value of TRSDET.MATR_AC_BR
     */
    public BigDecimal getMATR_AC_BR()
    {
	return MATR_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MATR_AC_BR
     *
     * @param MATR_AC_BR the value for TRSDET.MATR_AC_BR
     */
    public void setMATR_AC_BR(BigDecimal MATR_AC_BR)
    {
	this.MATR_AC_BR = MATR_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DIFF_AC_BR
     *
     * @return the value of TRSDET.DIFF_AC_BR
     */
    public BigDecimal getDIFF_AC_BR() {
        return DIFF_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DIFF_AC_BR
     *
     * @param DIFF_AC_BR the value for TRSDET.DIFF_AC_BR
     */
    public void setDIFF_AC_BR(BigDecimal DIFF_AC_BR) {
        this.DIFF_AC_BR = DIFF_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TRF_AC_BR
     *
     * @return the value of TRSDET.TRF_AC_BR
     */
    public BigDecimal getTRF_AC_BR() {
        return TRF_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TRF_AC_BR
     *
     * @param TRF_AC_BR the value for TRSDET.TRF_AC_BR
     */
    public void setTRF_AC_BR(BigDecimal TRF_AC_BR) {
        this.TRF_AC_BR = TRF_AC_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REQ_NO
     *
     * @return the value of TRSDET.REQ_NO
     */
    public BigDecimal getREQ_NO() {
        return REQ_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REQ_NO
     *
     * @param REQ_NO the value for TRSDET.REQ_NO
     */
    public void setREQ_NO(BigDecimal REQ_NO) {
        this.REQ_NO = REQ_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REQ_BR
     *
     * @return the value of TRSDET.REQ_BR
     */
    public BigDecimal getREQ_BR() {
        return REQ_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REQ_BR
     *
     * @param REQ_BR the value for TRSDET.REQ_BR
     */
    public void setREQ_BR(BigDecimal REQ_BR) {
        this.REQ_BR = REQ_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MGMT_PCNT
     *
     * @return the value of TRSDET.MGMT_PCNT
     */
    public BigDecimal getMGMT_PCNT() {
        return MGMT_PCNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MGMT_PCNT
     *
     * @param MGMT_PCNT the value for TRSDET.MGMT_PCNT
     */
    public void setMGMT_PCNT(BigDecimal MGMT_PCNT) {
        this.MGMT_PCNT = MGMT_PCNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_AMT_TYPE_2
     *
     * @return the value of TRSDET.ROLLOVER_AMT_TYPE_2
     */
    public String getROLLOVER_AMT_TYPE_2()
    {
	return ROLLOVER_AMT_TYPE_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_AMT_TYPE_2
     *
     * @param ROLLOVER_AMT_TYPE_2 the value for TRSDET.ROLLOVER_AMT_TYPE_2
     */
    public void setROLLOVER_AMT_TYPE_2(String ROLLOVER_AMT_TYPE_2)
    {
	this.ROLLOVER_AMT_TYPE_2 = ROLLOVER_AMT_TYPE_2 == null ? null : ROLLOVER_AMT_TYPE_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ROLLOVER_AMOUNT_2
     *
     * @return the value of TRSDET.ROLLOVER_AMOUNT_2
     */
    public BigDecimal getROLLOVER_AMOUNT_2()
    {
	return ROLLOVER_AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ROLLOVER_AMOUNT_2
     *
     * @param ROLLOVER_AMOUNT_2 the value for TRSDET.ROLLOVER_AMOUNT_2
     */
    public void setROLLOVER_AMOUNT_2(BigDecimal ROLLOVER_AMOUNT_2)
    {
	this.ROLLOVER_AMOUNT_2 = ROLLOVER_AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.VALUE_DATE
     *
     * @return the value of TRSDET.VALUE_DATE
     */
    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.VALUE_DATE
     *
     * @param VALUE_DATE the value for TRSDET.VALUE_DATE
     */
    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.USER_AMENDED_VALUE_DATE_YN
     *
     * @return the value of TRSDET.USER_AMENDED_VALUE_DATE_YN
     */
    public String getUSER_AMENDED_VALUE_DATE_YN() {
        return USER_AMENDED_VALUE_DATE_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.USER_AMENDED_VALUE_DATE_YN
     *
     * @param USER_AMENDED_VALUE_DATE_YN the value for
     *            TRSDET.USER_AMENDED_VALUE_DATE_YN
     */
    public void setUSER_AMENDED_VALUE_DATE_YN(String USER_AMENDED_VALUE_DATE_YN) {
        this.USER_AMENDED_VALUE_DATE_YN = USER_AMENDED_VALUE_DATE_YN == null ? null : USER_AMENDED_VALUE_DATE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.BLOCK_CONTRIB_AMT_YN
     *
     * @return the value of TRSDET.BLOCK_CONTRIB_AMT_YN
     */
    public String getBLOCK_CONTRIB_AMT_YN() {
        return BLOCK_CONTRIB_AMT_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.BLOCK_CONTRIB_AMT_YN
     *
     * @param BLOCK_CONTRIB_AMT_YN the value for TRSDET.BLOCK_CONTRIB_AMT_YN
     */
    public void setBLOCK_CONTRIB_AMT_YN(String BLOCK_CONTRIB_AMT_YN) {
        this.BLOCK_CONTRIB_AMT_YN = BLOCK_CONTRIB_AMT_YN == null ? null : BLOCK_CONTRIB_AMT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ADDITNL_INCOME_IN_SUSPENSE
     *
     * @return the value of TRSDET.ADDITNL_INCOME_IN_SUSPENSE
     */
    public BigDecimal getADDITNL_INCOME_IN_SUSPENSE() {
        return ADDITNL_INCOME_IN_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ADDITNL_INCOME_IN_SUSPENSE
     *
     * @param ADDITNL_INCOME_IN_SUSPENSE the value for
     *            TRSDET.ADDITNL_INCOME_IN_SUSPENSE
     */
    public void setADDITNL_INCOME_IN_SUSPENSE(BigDecimal ADDITNL_INCOME_IN_SUSPENSE) {
        this.ADDITNL_INCOME_IN_SUSPENSE = ADDITNL_INCOME_IN_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.ADDITNL_INCOME_IN_SUSPENSE_CV
     *
     * @return the value of TRSDET.ADDITNL_INCOME_IN_SUSPENSE_CV
     */
    public BigDecimal getADDITNL_INCOME_IN_SUSPENSE_CV() {
        return ADDITNL_INCOME_IN_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.ADDITNL_INCOME_IN_SUSPENSE_CV
     *
     * @param ADDITNL_INCOME_IN_SUSPENSE_CV the value for
     *            TRSDET.ADDITNL_INCOME_IN_SUSPENSE_CV
     */
    public void setADDITNL_INCOME_IN_SUSPENSE_CV(BigDecimal ADDITNL_INCOME_IN_SUSPENSE_CV) {
        this.ADDITNL_INCOME_IN_SUSPENSE_CV = ADDITNL_INCOME_IN_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_BLOCKED_AMOUNT
     *
     * @return the value of TRSDET.CONTRIB_BLOCKED_AMOUNT
     */
    public BigDecimal getCONTRIB_BLOCKED_AMOUNT() {
        return CONTRIB_BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_BLOCKED_AMOUNT
     *
     * @param CONTRIB_BLOCKED_AMOUNT the value for TRSDET.CONTRIB_BLOCKED_AMOUNT
     */
    public void setCONTRIB_BLOCKED_AMOUNT(BigDecimal CONTRIB_BLOCKED_AMOUNT) {
        this.CONTRIB_BLOCKED_AMOUNT = CONTRIB_BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DISBURSEMENT_NO
     *
     * @return the value of TRSDET.DISBURSEMENT_NO
     */
    public BigDecimal getDISBURSEMENT_NO() {
        return DISBURSEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DISBURSEMENT_NO
     *
     * @param DISBURSEMENT_NO the value for TRSDET.DISBURSEMENT_NO
     */
    public void setDISBURSEMENT_NO(BigDecimal DISBURSEMENT_NO) {
        this.DISBURSEMENT_NO = DISBURSEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWITCHED_DATE
     *
     * @return the value of TRSDET.SWITCHED_DATE
     */
    public Date getSWITCHED_DATE() {
        return SWITCHED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWITCHED_DATE
     *
     * @param SWITCHED_DATE the value for TRSDET.SWITCHED_DATE
     */
    public void setSWITCHED_DATE(Date SWITCHED_DATE) {
        this.SWITCHED_DATE = SWITCHED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWITCHED_TYPE
     *
     * @return the value of TRSDET.SWITCHED_TYPE
     */
    public String getSWITCHED_TYPE() {
        return SWITCHED_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWITCHED_TYPE
     *
     * @param SWITCHED_TYPE the value for TRSDET.SWITCHED_TYPE
     */
    public void setSWITCHED_TYPE(String SWITCHED_TYPE) {
        this.SWITCHED_TYPE = SWITCHED_TYPE == null ? null : SWITCHED_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWITCHED_PARTY_TYPE
     *
     * @return the value of TRSDET.SWITCHED_PARTY_TYPE
     */
    public String getSWITCHED_PARTY_TYPE() {
        return SWITCHED_PARTY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWITCHED_PARTY_TYPE
     *
     * @param SWITCHED_PARTY_TYPE the value for TRSDET.SWITCHED_PARTY_TYPE
     */
    public void setSWITCHED_PARTY_TYPE(String SWITCHED_PARTY_TYPE) {
        this.SWITCHED_PARTY_TYPE = SWITCHED_PARTY_TYPE == null ? null : SWITCHED_PARTY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.OLD_LINE_NO
     *
     * @return the value of TRSDET.OLD_LINE_NO
     */
    public BigDecimal getOLD_LINE_NO() {
        return OLD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.OLD_LINE_NO
     *
     * @param OLD_LINE_NO the value for TRSDET.OLD_LINE_NO
     */
    public void setOLD_LINE_NO(BigDecimal OLD_LINE_NO) {
        this.OLD_LINE_NO = OLD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REASONFORCHANGING
     *
     * @return the value of TRSDET.REASONFORCHANGING
     */
    public BigDecimal getREASONFORCHANGING()
    {
	return REASONFORCHANGING;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REASONFORCHANGING
     *
     * @param REASONFORCHANGING the value for TRSDET.REASONFORCHANGING
     */
    public void setREASONFORCHANGING(BigDecimal REASONFORCHANGING)
    {
	this.REASONFORCHANGING = REASONFORCHANGING;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CROSS_EXCH_RATE
     *
     * @return the value of TRSDET.CROSS_EXCH_RATE
     */
    public BigDecimal getCROSS_EXCH_RATE()
    {
	return CROSS_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CROSS_EXCH_RATE
     *
     * @param CROSS_EXCH_RATE the value for TRSDET.CROSS_EXCH_RATE
     */
    public void setCROSS_EXCH_RATE(BigDecimal CROSS_EXCH_RATE)
    {
	this.CROSS_EXCH_RATE = CROSS_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.AMENDMENT_NO
     *
     * @return the value of TRSDET.AMENDMENT_NO
     */
    public BigDecimal getAMENDMENT_NO() {
        return AMENDMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.AMENDMENT_NO
     *
     * @param AMENDMENT_NO the value for TRSDET.AMENDMENT_NO
     */
    public void setAMENDMENT_NO(BigDecimal AMENDMENT_NO) {
        this.AMENDMENT_NO = AMENDMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_VIA_TRF_YN
     *
     * @return the value of TRSDET.CONTRIBBLOCK_VIA_TRF_YN
     */
    public String getCONTRIBBLOCK_VIA_TRF_YN() {
        return CONTRIBBLOCK_VIA_TRF_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_VIA_TRF_YN
     *
     * @param CONTRIBBLOCK_VIA_TRF_YN the value for
     *            TRSDET.CONTRIBBLOCK_VIA_TRF_YN
     */
    public void setCONTRIBBLOCK_VIA_TRF_YN(String CONTRIBBLOCK_VIA_TRF_YN) {
        this.CONTRIBBLOCK_VIA_TRF_YN = CONTRIBBLOCK_VIA_TRF_YN == null ? null : CONTRIBBLOCK_VIA_TRF_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_AMT
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_AMT
     */
    public BigDecimal getCONTRIBBLOCK_TRF_AMT() {
        return CONTRIBBLOCK_TRF_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_AMT
     *
     * @param CONTRIBBLOCK_TRF_AMT the value for TRSDET.CONTRIBBLOCK_TRF_AMT
     */
    public void setCONTRIBBLOCK_TRF_AMT(BigDecimal CONTRIBBLOCK_TRF_AMT) {
        this.CONTRIBBLOCK_TRF_AMT = CONTRIBBLOCK_TRF_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_BLOCK_AMT
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    public BigDecimal getCONTRIBBLOCK_TRF_BLOCK_AMT() {
        return CONTRIBBLOCK_TRF_BLOCK_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_BLOCK_AMT
     *
     * @param CONTRIBBLOCK_TRF_BLOCK_AMT the value for
     *            TRSDET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    public void setCONTRIBBLOCK_TRF_BLOCK_AMT(BigDecimal CONTRIBBLOCK_TRF_BLOCK_AMT) {
        this.CONTRIBBLOCK_TRF_BLOCK_AMT = CONTRIBBLOCK_TRF_BLOCK_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_REASON
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_REASON
     */
    public String getCONTRIBBLOCK_TRF_REASON() {
        return CONTRIBBLOCK_TRF_REASON;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_REASON
     *
     * @param CONTRIBBLOCK_TRF_REASON the value for
     *            TRSDET.CONTRIBBLOCK_TRF_REASON
     */
    public void setCONTRIBBLOCK_TRF_REASON(String CONTRIBBLOCK_TRF_REASON) {
        this.CONTRIBBLOCK_TRF_REASON = CONTRIBBLOCK_TRF_REASON == null ? null : CONTRIBBLOCK_TRF_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_BR
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_BR() {
        return CONTRIBBLOCK_TRF_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_BR
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_BR the value for
     *            TRSDET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_BR(BigDecimal CONTRIBBLOCK_TRF_MARGIN_BR) {
        this.CONTRIBBLOCK_TRF_MARGIN_BR = CONTRIBBLOCK_TRF_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_CY
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_CY() {
        return CONTRIBBLOCK_TRF_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_CY
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_CY the value for
     *            TRSDET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_CY(BigDecimal CONTRIBBLOCK_TRF_MARGIN_CY) {
        this.CONTRIBBLOCK_TRF_MARGIN_CY = CONTRIBBLOCK_TRF_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_GL
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_GL() {
        return CONTRIBBLOCK_TRF_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_GL
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_GL the value for
     *            TRSDET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_GL(BigDecimal CONTRIBBLOCK_TRF_MARGIN_GL) {
        this.CONTRIBBLOCK_TRF_MARGIN_GL = CONTRIBBLOCK_TRF_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_CIF
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_CIF() {
        return CONTRIBBLOCK_TRF_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_CIF
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_CIF the value for
     *            TRSDET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_CIF(BigDecimal CONTRIBBLOCK_TRF_MARGIN_CIF) {
        this.CONTRIBBLOCK_TRF_MARGIN_CIF = CONTRIBBLOCK_TRF_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_SL
     *
     * @return the value of TRSDET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_SL() {
        return CONTRIBBLOCK_TRF_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIBBLOCK_TRF_MARGIN_SL
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_SL the value for
     *            TRSDET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_SL(BigDecimal CONTRIBBLOCK_TRF_MARGIN_SL) {
        this.CONTRIBBLOCK_TRF_MARGIN_SL = CONTRIBBLOCK_TRF_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.TOTAL_DEPRECIATION_AMT
     *
     * @return the value of TRSDET.TOTAL_DEPRECIATION_AMT
     */
    public BigDecimal getTOTAL_DEPRECIATION_AMT() {
        return TOTAL_DEPRECIATION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.TOTAL_DEPRECIATION_AMT
     *
     * @param TOTAL_DEPRECIATION_AMT the value for TRSDET.TOTAL_DEPRECIATION_AMT
     */
    public void setTOTAL_DEPRECIATION_AMT(BigDecimal TOTAL_DEPRECIATION_AMT) {
        this.TOTAL_DEPRECIATION_AMT = TOTAL_DEPRECIATION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DAILY_DEPRECIATION_AMT
     *
     * @return the value of TRSDET.DAILY_DEPRECIATION_AMT
     */
    public BigDecimal getDAILY_DEPRECIATION_AMT() {
        return DAILY_DEPRECIATION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DAILY_DEPRECIATION_AMT
     *
     * @param DAILY_DEPRECIATION_AMT the value for TRSDET.DAILY_DEPRECIATION_AMT
     */
    public void setDAILY_DEPRECIATION_AMT(BigDecimal DAILY_DEPRECIATION_AMT) {
        this.DAILY_DEPRECIATION_AMT = DAILY_DEPRECIATION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.DAILY_ACCRUAL_AMT
     *
     * @return the value of TRSDET.DAILY_ACCRUAL_AMT
     */
    public BigDecimal getDAILY_ACCRUAL_AMT() {
        return DAILY_ACCRUAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.DAILY_ACCRUAL_AMT
     *
     * @param DAILY_ACCRUAL_AMT the value for TRSDET.DAILY_ACCRUAL_AMT
     */
    public void setDAILY_ACCRUAL_AMT(BigDecimal DAILY_ACCRUAL_AMT) {
        this.DAILY_ACCRUAL_AMT = DAILY_ACCRUAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_29
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_29
     */
    public String getMT579_CERTIFICATE_NO_29()
    {
	return MT579_CERTIFICATE_NO_29;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_29
     *
     * @param MT579_CERTIFICATE_NO_29 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_29
     */
    public void setMT579_CERTIFICATE_NO_29(String MT579_CERTIFICATE_NO_29)
    {
	this.MT579_CERTIFICATE_NO_29 = MT579_CERTIFICATE_NO_29 == null ? null : MT579_CERTIFICATE_NO_29.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_3
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_3
     */
    public String getMT579_CERTIFICATE_NO_3()
    {
	return MT579_CERTIFICATE_NO_3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_3
     *
     * @param MT579_CERTIFICATE_NO_3 the value for TRSDET.MT579_CERTIFICATE_NO_3
     */
    public void setMT579_CERTIFICATE_NO_3(String MT579_CERTIFICATE_NO_3)
    {
	this.MT579_CERTIFICATE_NO_3 = MT579_CERTIFICATE_NO_3 == null ? null : MT579_CERTIFICATE_NO_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_30
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_30
     */
    public String getMT579_CERTIFICATE_NO_30()
    {
	return MT579_CERTIFICATE_NO_30;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_30
     *
     * @param MT579_CERTIFICATE_NO_30 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_30
     */
    public void setMT579_CERTIFICATE_NO_30(String MT579_CERTIFICATE_NO_30)
    {
	this.MT579_CERTIFICATE_NO_30 = MT579_CERTIFICATE_NO_30 == null ? null : MT579_CERTIFICATE_NO_30.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_31
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_31
     */
    public String getMT579_CERTIFICATE_NO_31()
    {
	return MT579_CERTIFICATE_NO_31;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_31
     *
     * @param MT579_CERTIFICATE_NO_31 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_31
     */
    public void setMT579_CERTIFICATE_NO_31(String MT579_CERTIFICATE_NO_31)
    {
	this.MT579_CERTIFICATE_NO_31 = MT579_CERTIFICATE_NO_31 == null ? null : MT579_CERTIFICATE_NO_31.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_32
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_32
     */
    public String getMT579_CERTIFICATE_NO_32()
    {
	return MT579_CERTIFICATE_NO_32;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_32
     *
     * @param MT579_CERTIFICATE_NO_32 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_32
     */
    public void setMT579_CERTIFICATE_NO_32(String MT579_CERTIFICATE_NO_32)
    {
	this.MT579_CERTIFICATE_NO_32 = MT579_CERTIFICATE_NO_32 == null ? null : MT579_CERTIFICATE_NO_32.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_33
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_33
     */
    public String getMT579_CERTIFICATE_NO_33()
    {
	return MT579_CERTIFICATE_NO_33;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_33
     *
     * @param MT579_CERTIFICATE_NO_33 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_33
     */
    public void setMT579_CERTIFICATE_NO_33(String MT579_CERTIFICATE_NO_33)
    {
	this.MT579_CERTIFICATE_NO_33 = MT579_CERTIFICATE_NO_33 == null ? null : MT579_CERTIFICATE_NO_33.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_34
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_34
     */
    public String getMT579_CERTIFICATE_NO_34()
    {
	return MT579_CERTIFICATE_NO_34;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_34
     *
     * @param MT579_CERTIFICATE_NO_34 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_34
     */
    public void setMT579_CERTIFICATE_NO_34(String MT579_CERTIFICATE_NO_34)
    {
	this.MT579_CERTIFICATE_NO_34 = MT579_CERTIFICATE_NO_34 == null ? null : MT579_CERTIFICATE_NO_34.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_35
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_35
     */
    public String getMT579_CERTIFICATE_NO_35()
    {
	return MT579_CERTIFICATE_NO_35;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_35
     *
     * @param MT579_CERTIFICATE_NO_35 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_35
     */
    public void setMT579_CERTIFICATE_NO_35(String MT579_CERTIFICATE_NO_35)
    {
	this.MT579_CERTIFICATE_NO_35 = MT579_CERTIFICATE_NO_35 == null ? null : MT579_CERTIFICATE_NO_35.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_4
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_4
     */
    public String getMT579_CERTIFICATE_NO_4()
    {
	return MT579_CERTIFICATE_NO_4;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_4
     *
     * @param MT579_CERTIFICATE_NO_4 the value for TRSDET.MT579_CERTIFICATE_NO_4
     */
    public void setMT579_CERTIFICATE_NO_4(String MT579_CERTIFICATE_NO_4)
    {
	this.MT579_CERTIFICATE_NO_4 = MT579_CERTIFICATE_NO_4 == null ? null : MT579_CERTIFICATE_NO_4.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_5
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_5
     */
    public String getMT579_CERTIFICATE_NO_5()
    {
	return MT579_CERTIFICATE_NO_5;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_5
     *
     * @param MT579_CERTIFICATE_NO_5 the value for TRSDET.MT579_CERTIFICATE_NO_5
     */
    public void setMT579_CERTIFICATE_NO_5(String MT579_CERTIFICATE_NO_5)
    {
	this.MT579_CERTIFICATE_NO_5 = MT579_CERTIFICATE_NO_5 == null ? null : MT579_CERTIFICATE_NO_5.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_6
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_6
     */
    public String getMT579_CERTIFICATE_NO_6()
    {
	return MT579_CERTIFICATE_NO_6;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_6
     *
     * @param MT579_CERTIFICATE_NO_6 the value for TRSDET.MT579_CERTIFICATE_NO_6
     */
    public void setMT579_CERTIFICATE_NO_6(String MT579_CERTIFICATE_NO_6)
    {
	this.MT579_CERTIFICATE_NO_6 = MT579_CERTIFICATE_NO_6 == null ? null : MT579_CERTIFICATE_NO_6.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_7
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_7
     */
    public String getMT579_CERTIFICATE_NO_7()
    {
	return MT579_CERTIFICATE_NO_7;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_7
     *
     * @param MT579_CERTIFICATE_NO_7 the value for TRSDET.MT579_CERTIFICATE_NO_7
     */
    public void setMT579_CERTIFICATE_NO_7(String MT579_CERTIFICATE_NO_7)
    {
	this.MT579_CERTIFICATE_NO_7 = MT579_CERTIFICATE_NO_7 == null ? null : MT579_CERTIFICATE_NO_7.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_8
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_8
     */
    public String getMT579_CERTIFICATE_NO_8()
    {
	return MT579_CERTIFICATE_NO_8;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_8
     *
     * @param MT579_CERTIFICATE_NO_8 the value for TRSDET.MT579_CERTIFICATE_NO_8
     */
    public void setMT579_CERTIFICATE_NO_8(String MT579_CERTIFICATE_NO_8)
    {
	this.MT579_CERTIFICATE_NO_8 = MT579_CERTIFICATE_NO_8 == null ? null : MT579_CERTIFICATE_NO_8.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_9
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_9
     */
    public String getMT579_CERTIFICATE_NO_9()
    {
	return MT579_CERTIFICATE_NO_9;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_9
     *
     * @param MT579_CERTIFICATE_NO_9 the value for TRSDET.MT579_CERTIFICATE_NO_9
     */
    public void setMT579_CERTIFICATE_NO_9(String MT579_CERTIFICATE_NO_9)
    {
	this.MT579_CERTIFICATE_NO_9 = MT579_CERTIFICATE_NO_9 == null ? null : MT579_CERTIFICATE_NO_9.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CONTINUATION_CHAR
     *
     * @return the value of TRSDET.MT579_CONTINUATION_CHAR
     */
    public String getMT579_CONTINUATION_CHAR()
    {
	return MT579_CONTINUATION_CHAR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CONTINUATION_CHAR
     *
     * @param MT579_CONTINUATION_CHAR the value for
     *            TRSDET.MT579_CONTINUATION_CHAR
     */
    public void setMT579_CONTINUATION_CHAR(String MT579_CONTINUATION_CHAR)
    {
	this.MT579_CONTINUATION_CHAR = MT579_CONTINUATION_CHAR == null ? null : MT579_CONTINUATION_CHAR.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_ACCNO
     *
     * @return the value of TRSDET.PARTY_ACCNO
     */
    public String getPARTY_ACCNO()
    {
	return PARTY_ACCNO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_ACCNO
     *
     * @param PARTY_ACCNO the value for TRSDET.PARTY_ACCNO
     */
    public void setPARTY_ACCNO(String PARTY_ACCNO)
    {
	this.PARTY_ACCNO = PARTY_ACCNO == null ? null : PARTY_ACCNO.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_BANK
     *
     * @return the value of TRSDET.PARTY_BANK
     */
    public BigDecimal getPARTY_BANK()
    {
	return PARTY_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_BANK
     *
     * @param PARTY_BANK the value for TRSDET.PARTY_BANK
     */
    public void setPARTY_BANK(BigDecimal PARTY_BANK)
    {
	this.PARTY_BANK = PARTY_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_BANK_BIC_CODE
     *
     * @return the value of TRSDET.PARTY_BANK_BIC_CODE
     */
    public String getPARTY_BANK_BIC_CODE()
    {
	return PARTY_BANK_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_BANK_BIC_CODE
     *
     * @param PARTY_BANK_BIC_CODE the value for TRSDET.PARTY_BANK_BIC_CODE
     */
    public void setPARTY_BANK_BIC_CODE(String PARTY_BANK_BIC_CODE)
    {
	this.PARTY_BANK_BIC_CODE = PARTY_BANK_BIC_CODE == null ? null : PARTY_BANK_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PARTY_BANK_BR
     *
     * @return the value of TRSDET.PARTY_BANK_BR
     */
    public String getPARTY_BANK_BR()
    {
	return PARTY_BANK_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PARTY_BANK_BR
     *
     * @param PARTY_BANK_BR the value for TRSDET.PARTY_BANK_BR
     */
    public void setPARTY_BANK_BR(String PARTY_BANK_BR)
    {
	this.PARTY_BANK_BR = PARTY_BANK_BR == null ? null : PARTY_BANK_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.PAYMENT_VIA
     *
     * @return the value of TRSDET.PAYMENT_VIA
     */
    public String getPAYMENT_VIA()
    {
	return PAYMENT_VIA;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.PAYMENT_VIA
     *
     * @param PAYMENT_VIA the value for TRSDET.PAYMENT_VIA
     */
    public void setPAYMENT_VIA(String PAYMENT_VIA)
    {
	this.PAYMENT_VIA = PAYMENT_VIA == null ? null : PAYMENT_VIA.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_BANK
     *
     * @return the value of TRSDET.RECEIVER_BANK
     */
    public BigDecimal getRECEIVER_BANK()
    {
	return RECEIVER_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_BANK
     *
     * @param RECEIVER_BANK the value for TRSDET.RECEIVER_BANK
     */
    public void setRECEIVER_BANK(BigDecimal RECEIVER_BANK)
    {
	this.RECEIVER_BANK = RECEIVER_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_BANK_NAME
     *
     * @return the value of TRSDET.RECEIVER_BANK_NAME
     */
    public String getRECEIVER_BANK_NAME()
    {
	return RECEIVER_BANK_NAME;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_BANK_NAME
     *
     * @param RECEIVER_BANK_NAME the value for TRSDET.RECEIVER_BANK_NAME
     */
    public void setRECEIVER_BANK_NAME(String RECEIVER_BANK_NAME)
    {
	this.RECEIVER_BANK_NAME = RECEIVER_BANK_NAME == null ? null : RECEIVER_BANK_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CHARGES
     *
     * @return the value of TRSDET.RECEIVER_CHARGES
     */
    public BigDecimal getRECEIVER_CHARGES()
    {
	return RECEIVER_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CHARGES
     *
     * @param RECEIVER_CHARGES the value for TRSDET.RECEIVER_CHARGES
     */
    public void setRECEIVER_CHARGES(BigDecimal RECEIVER_CHARGES)
    {
	this.RECEIVER_CHARGES = RECEIVER_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ACC
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_ACC
     */
    public String getRECEIVER_CORR_BANK_ACC()
    {
	return RECEIVER_CORR_BANK_ACC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ACC
     *
     * @param RECEIVER_CORR_BANK_ACC the value for TRSDET.RECEIVER_CORR_BANK_ACC
     */
    public void setRECEIVER_CORR_BANK_ACC(String RECEIVER_CORR_BANK_ACC)
    {
	this.RECEIVER_CORR_BANK_ACC = RECEIVER_CORR_BANK_ACC == null ? null : RECEIVER_CORR_BANK_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_ADDRESS
     */
    public String getRECEIVER_CORR_BANK_ADDRESS()
    {
	return RECEIVER_CORR_BANK_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS
     *
     * @param RECEIVER_CORR_BANK_ADDRESS the value for
     *            TRSDET.RECEIVER_CORR_BANK_ADDRESS
     */
    public void setRECEIVER_CORR_BANK_ADDRESS(String RECEIVER_CORR_BANK_ADDRESS)
    {
	this.RECEIVER_CORR_BANK_ADDRESS = RECEIVER_CORR_BANK_ADDRESS == null ? null : RECEIVER_CORR_BANK_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS1
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_ADDRESS1
     */
    public String getRECEIVER_CORR_BANK_ADDRESS1()
    {
	return RECEIVER_CORR_BANK_ADDRESS1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS1
     *
     * @param RECEIVER_CORR_BANK_ADDRESS1 the value for
     *            TRSDET.RECEIVER_CORR_BANK_ADDRESS1
     */
    public void setRECEIVER_CORR_BANK_ADDRESS1(String RECEIVER_CORR_BANK_ADDRESS1)
    {
	this.RECEIVER_CORR_BANK_ADDRESS1 = RECEIVER_CORR_BANK_ADDRESS1 == null ? null
		: RECEIVER_CORR_BANK_ADDRESS1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS2
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_ADDRESS2
     */
    public String getRECEIVER_CORR_BANK_ADDRESS2()
    {
	return RECEIVER_CORR_BANK_ADDRESS2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_ADDRESS2
     *
     * @param RECEIVER_CORR_BANK_ADDRESS2 the value for
     *            TRSDET.RECEIVER_CORR_BANK_ADDRESS2
     */
    public void setRECEIVER_CORR_BANK_ADDRESS2(String RECEIVER_CORR_BANK_ADDRESS2)
    {
	this.RECEIVER_CORR_BANK_ADDRESS2 = RECEIVER_CORR_BANK_ADDRESS2 == null ? null
		: RECEIVER_CORR_BANK_ADDRESS2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_BIC_CODE
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_BIC_CODE
     */
    public String getRECEIVER_CORR_BANK_BIC_CODE()
    {
	return RECEIVER_CORR_BANK_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_BIC_CODE
     *
     * @param RECEIVER_CORR_BANK_BIC_CODE the value for
     *            TRSDET.RECEIVER_CORR_BANK_BIC_CODE
     */
    public void setRECEIVER_CORR_BANK_BIC_CODE(String RECEIVER_CORR_BANK_BIC_CODE)
    {
	this.RECEIVER_CORR_BANK_BIC_CODE = RECEIVER_CORR_BANK_BIC_CODE == null ? null
		: RECEIVER_CORR_BANK_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_BR
     *
     * @return the value of TRSDET.RECEIVER_CORR_BANK_BR
     */
    public String getRECEIVER_CORR_BANK_BR()
    {
	return RECEIVER_CORR_BANK_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.RECEIVER_CORR_BANK_BR
     *
     * @param RECEIVER_CORR_BANK_BR the value for TRSDET.RECEIVER_CORR_BANK_BR
     */
    public void setRECEIVER_CORR_BANK_BR(String RECEIVER_CORR_BANK_BR)
    {
	this.RECEIVER_CORR_BANK_BR = RECEIVER_CORR_BANK_BR == null ? null : RECEIVER_CORR_BANK_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REMARKS1
     *
     * @return the value of TRSDET.REMARKS1
     */
    public String getREMARKS1()
    {
	return REMARKS1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REMARKS1
     *
     * @param REMARKS1 the value for TRSDET.REMARKS1
     */
    public void setREMARKS1(String REMARKS1)
    {
	this.REMARKS1 = REMARKS1 == null ? null : REMARKS1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REMARKS2
     *
     * @return the value of TRSDET.REMARKS2
     */
    public String getREMARKS2()
    {
	return REMARKS2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REMARKS2
     *
     * @param REMARKS2 the value for TRSDET.REMARKS2
     */
    public void setREMARKS2(String REMARKS2)
    {
	this.REMARKS2 = REMARKS2 == null ? null : REMARKS2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.REMARKS3
     *
     * @return the value of TRSDET.REMARKS3
     */
    public String getREMARKS3()
    {
	return REMARKS3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.REMARKS3
     *
     * @param REMARKS3 the value for TRSDET.REMARKS3
     */
    public void setREMARKS3(String REMARKS3)
    {
	this.REMARKS3 = REMARKS3 == null ? null : REMARKS3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWIFT_CHARGE
     *
     * @return the value of TRSDET.SWIFT_CHARGE
     */
    public String getSWIFT_CHARGE()
    {
	return SWIFT_CHARGE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWIFT_CHARGE
     *
     * @param SWIFT_CHARGE the value for TRSDET.SWIFT_CHARGE
     */
    public void setSWIFT_CHARGE(String SWIFT_CHARGE)
    {
	this.SWIFT_CHARGE = SWIFT_CHARGE == null ? null : SWIFT_CHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.SWIFT_TYPE
     *
     * @return the value of TRSDET.SWIFT_TYPE
     */
    public String getSWIFT_TYPE()
    {
	return SWIFT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.SWIFT_TYPE
     *
     * @param SWIFT_TYPE the value for TRSDET.SWIFT_TYPE
     */
    public void setSWIFT_TYPE(String SWIFT_TYPE)
    {
	this.SWIFT_TYPE = SWIFT_TYPE == null ? null : SWIFT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK
     *
     * @return the value of TRSDET.INTERM_BANK
     */
    public BigDecimal getINTERM_BANK()
    {
	return INTERM_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK
     *
     * @param INTERM_BANK the value for TRSDET.INTERM_BANK
     */
    public void setINTERM_BANK(BigDecimal INTERM_BANK)
    {
	this.INTERM_BANK = INTERM_BANK;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_ACC
     *
     * @return the value of TRSDET.INTERM_BANK_ACC
     */
    public String getINTERM_BANK_ACC()
    {
	return INTERM_BANK_ACC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_ACC
     *
     * @param INTERM_BANK_ACC the value for TRSDET.INTERM_BANK_ACC
     */
    public void setINTERM_BANK_ACC(String INTERM_BANK_ACC)
    {
	this.INTERM_BANK_ACC = INTERM_BANK_ACC == null ? null : INTERM_BANK_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS
     *
     * @return the value of TRSDET.INTERM_BANK_ADDRESS
     */
    public String getINTERM_BANK_ADDRESS()
    {
	return INTERM_BANK_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS
     *
     * @param INTERM_BANK_ADDRESS the value for TRSDET.INTERM_BANK_ADDRESS
     */
    public void setINTERM_BANK_ADDRESS(String INTERM_BANK_ADDRESS)
    {
	this.INTERM_BANK_ADDRESS = INTERM_BANK_ADDRESS == null ? null : INTERM_BANK_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS_1
     *
     * @return the value of TRSDET.INTERM_BANK_ADDRESS_1
     */
    public String getINTERM_BANK_ADDRESS_1()
    {
	return INTERM_BANK_ADDRESS_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS_1
     *
     * @param INTERM_BANK_ADDRESS_1 the value for TRSDET.INTERM_BANK_ADDRESS_1
     */
    public void setINTERM_BANK_ADDRESS_1(String INTERM_BANK_ADDRESS_1)
    {
	this.INTERM_BANK_ADDRESS_1 = INTERM_BANK_ADDRESS_1 == null ? null : INTERM_BANK_ADDRESS_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS_2
     *
     * @return the value of TRSDET.INTERM_BANK_ADDRESS_2
     */
    public String getINTERM_BANK_ADDRESS_2()
    {
	return INTERM_BANK_ADDRESS_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_ADDRESS_2
     *
     * @param INTERM_BANK_ADDRESS_2 the value for TRSDET.INTERM_BANK_ADDRESS_2
     */
    public void setINTERM_BANK_ADDRESS_2(String INTERM_BANK_ADDRESS_2)
    {
	this.INTERM_BANK_ADDRESS_2 = INTERM_BANK_ADDRESS_2 == null ? null : INTERM_BANK_ADDRESS_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_BIC
     *
     * @return the value of TRSDET.INTERM_BANK_BIC
     */
    public String getINTERM_BANK_BIC()
    {
	return INTERM_BANK_BIC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_BIC
     *
     * @param INTERM_BANK_BIC the value for TRSDET.INTERM_BANK_BIC
     */
    public void setINTERM_BANK_BIC(String INTERM_BANK_BIC)
    {
	this.INTERM_BANK_BIC = INTERM_BANK_BIC == null ? null : INTERM_BANK_BIC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_BR
     *
     * @return the value of TRSDET.INTERM_BANK_BR
     */
    public String getINTERM_BANK_BR()
    {
	return INTERM_BANK_BR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_BR
     *
     * @param INTERM_BANK_BR the value for TRSDET.INTERM_BANK_BR
     */
    public void setINTERM_BANK_BR(String INTERM_BANK_BR)
    {
	this.INTERM_BANK_BR = INTERM_BANK_BR == null ? null : INTERM_BANK_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.INTERM_BANK_NAME
     *
     * @return the value of TRSDET.INTERM_BANK_NAME
     */
    public String getINTERM_BANK_NAME()
    {
	return INTERM_BANK_NAME;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.INTERM_BANK_NAME
     *
     * @param INTERM_BANK_NAME the value for TRSDET.INTERM_BANK_NAME
     */
    public void setINTERM_BANK_NAME(String INTERM_BANK_NAME)
    {
	this.INTERM_BANK_NAME = INTERM_BANK_NAME == null ? null : INTERM_BANK_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_BANK_OPERATION_CODE
     *
     * @return the value of TRSDET.MT103_BANK_OPERATION_CODE
     */
    public String getMT103_BANK_OPERATION_CODE()
    {
	return MT103_BANK_OPERATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_BANK_OPERATION_CODE
     *
     * @param MT103_BANK_OPERATION_CODE the value for
     *            TRSDET.MT103_BANK_OPERATION_CODE
     */
    public void setMT103_BANK_OPERATION_CODE(String MT103_BANK_OPERATION_CODE)
    {
	this.MT103_BANK_OPERATION_CODE = MT103_BANK_OPERATION_CODE == null ? null : MT103_BANK_OPERATION_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS1
     *
     * @return the value of TRSDET.MT103_BENEF_ADDRESS1
     */
    public String getMT103_BENEF_ADDRESS1()
    {
	return MT103_BENEF_ADDRESS1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS1
     *
     * @param MT103_BENEF_ADDRESS1 the value for TRSDET.MT103_BENEF_ADDRESS1
     */
    public void setMT103_BENEF_ADDRESS1(String MT103_BENEF_ADDRESS1)
    {
	this.MT103_BENEF_ADDRESS1 = MT103_BENEF_ADDRESS1 == null ? null : MT103_BENEF_ADDRESS1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS2
     *
     * @return the value of TRSDET.MT103_BENEF_ADDRESS2
     */
    public String getMT103_BENEF_ADDRESS2()
    {
	return MT103_BENEF_ADDRESS2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS2
     *
     * @param MT103_BENEF_ADDRESS2 the value for TRSDET.MT103_BENEF_ADDRESS2
     */
    public void setMT103_BENEF_ADDRESS2(String MT103_BENEF_ADDRESS2)
    {
	this.MT103_BENEF_ADDRESS2 = MT103_BENEF_ADDRESS2 == null ? null : MT103_BENEF_ADDRESS2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS3
     *
     * @return the value of TRSDET.MT103_BENEF_ADDRESS3
     */
    public String getMT103_BENEF_ADDRESS3()
    {
	return MT103_BENEF_ADDRESS3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_BENEF_ADDRESS3
     *
     * @param MT103_BENEF_ADDRESS3 the value for TRSDET.MT103_BENEF_ADDRESS3
     */
    public void setMT103_BENEF_ADDRESS3(String MT103_BENEF_ADDRESS3)
    {
	this.MT103_BENEF_ADDRESS3 = MT103_BENEF_ADDRESS3 == null ? null : MT103_BENEF_ADDRESS3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_BENEF_NAME
     *
     * @return the value of TRSDET.MT103_BENEF_NAME
     */
    public String getMT103_BENEF_NAME()
    {
	return MT103_BENEF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_BENEF_NAME
     *
     * @param MT103_BENEF_NAME the value for TRSDET.MT103_BENEF_NAME
     */
    public void setMT103_BENEF_NAME(String MT103_BENEF_NAME)
    {
	this.MT103_BENEF_NAME = MT103_BENEF_NAME == null ? null : MT103_BENEF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_CURRENCY
     *
     * @return the value of TRSDET.MT103_CURRENCY
     */
    public String getMT103_CURRENCY()
    {
	return MT103_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_CURRENCY
     *
     * @param MT103_CURRENCY the value for TRSDET.MT103_CURRENCY
     */
    public void setMT103_CURRENCY(String MT103_CURRENCY)
    {
	this.MT103_CURRENCY = MT103_CURRENCY == null ? null : MT103_CURRENCY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_EXCH_RATE
     *
     * @return the value of TRSDET.MT103_EXCH_RATE
     */
    public BigDecimal getMT103_EXCH_RATE()
    {
	return MT103_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_EXCH_RATE
     *
     * @param MT103_EXCH_RATE the value for TRSDET.MT103_EXCH_RATE
     */
    public void setMT103_EXCH_RATE(BigDecimal MT103_EXCH_RATE)
    {
	this.MT103_EXCH_RATE = MT103_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD70_1
     *
     * @return the value of TRSDET.MT103_FIELD70_1
     */
    public String getMT103_FIELD70_1()
    {
	return MT103_FIELD70_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD70_1
     *
     * @param MT103_FIELD70_1 the value for TRSDET.MT103_FIELD70_1
     */
    public void setMT103_FIELD70_1(String MT103_FIELD70_1)
    {
	this.MT103_FIELD70_1 = MT103_FIELD70_1 == null ? null : MT103_FIELD70_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD70_2
     *
     * @return the value of TRSDET.MT103_FIELD70_2
     */
    public String getMT103_FIELD70_2()
    {
	return MT103_FIELD70_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD70_2
     *
     * @param MT103_FIELD70_2 the value for TRSDET.MT103_FIELD70_2
     */
    public void setMT103_FIELD70_2(String MT103_FIELD70_2)
    {
	this.MT103_FIELD70_2 = MT103_FIELD70_2 == null ? null : MT103_FIELD70_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD70_3
     *
     * @return the value of TRSDET.MT103_FIELD70_3
     */
    public String getMT103_FIELD70_3()
    {
	return MT103_FIELD70_3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD70_3
     *
     * @param MT103_FIELD70_3 the value for TRSDET.MT103_FIELD70_3
     */
    public void setMT103_FIELD70_3(String MT103_FIELD70_3)
    {
	this.MT103_FIELD70_3 = MT103_FIELD70_3 == null ? null : MT103_FIELD70_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD70_4
     *
     * @return the value of TRSDET.MT103_FIELD70_4
     */
    public String getMT103_FIELD70_4()
    {
	return MT103_FIELD70_4;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD70_4
     *
     * @param MT103_FIELD70_4 the value for TRSDET.MT103_FIELD70_4
     */
    public void setMT103_FIELD70_4(String MT103_FIELD70_4)
    {
	this.MT103_FIELD70_4 = MT103_FIELD70_4 == null ? null : MT103_FIELD70_4.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD71F
     *
     * @return the value of TRSDET.MT103_FIELD71F
     */
    public BigDecimal getMT103_FIELD71F()
    {
	return MT103_FIELD71F;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD71F
     *
     * @param MT103_FIELD71F the value for TRSDET.MT103_FIELD71F
     */
    public void setMT103_FIELD71F(BigDecimal MT103_FIELD71F)
    {
	this.MT103_FIELD71F = MT103_FIELD71F;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_1
     *
     * @return the value of TRSDET.MT103_FIELD72_1
     */
    public String getMT103_FIELD72_1()
    {
	return MT103_FIELD72_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_1
     *
     * @param MT103_FIELD72_1 the value for TRSDET.MT103_FIELD72_1
     */
    public void setMT103_FIELD72_1(String MT103_FIELD72_1)
    {
	this.MT103_FIELD72_1 = MT103_FIELD72_1 == null ? null : MT103_FIELD72_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_2
     *
     * @return the value of TRSDET.MT103_FIELD72_2
     */
    public String getMT103_FIELD72_2()
    {
	return MT103_FIELD72_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_2
     *
     * @param MT103_FIELD72_2 the value for TRSDET.MT103_FIELD72_2
     */
    public void setMT103_FIELD72_2(String MT103_FIELD72_2)
    {
	this.MT103_FIELD72_2 = MT103_FIELD72_2 == null ? null : MT103_FIELD72_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_3
     *
     * @return the value of TRSDET.MT103_FIELD72_3
     */
    public String getMT103_FIELD72_3()
    {
	return MT103_FIELD72_3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_3
     *
     * @param MT103_FIELD72_3 the value for TRSDET.MT103_FIELD72_3
     */
    public void setMT103_FIELD72_3(String MT103_FIELD72_3)
    {
	this.MT103_FIELD72_3 = MT103_FIELD72_3 == null ? null : MT103_FIELD72_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_4
     *
     * @return the value of TRSDET.MT103_FIELD72_4
     */
    public String getMT103_FIELD72_4()
    {
	return MT103_FIELD72_4;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_4
     *
     * @param MT103_FIELD72_4 the value for TRSDET.MT103_FIELD72_4
     */
    public void setMT103_FIELD72_4(String MT103_FIELD72_4)
    {
	this.MT103_FIELD72_4 = MT103_FIELD72_4 == null ? null : MT103_FIELD72_4.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_5
     *
     * @return the value of TRSDET.MT103_FIELD72_5
     */
    public String getMT103_FIELD72_5()
    {
	return MT103_FIELD72_5;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_5
     *
     * @param MT103_FIELD72_5 the value for TRSDET.MT103_FIELD72_5
     */
    public void setMT103_FIELD72_5(String MT103_FIELD72_5)
    {
	this.MT103_FIELD72_5 = MT103_FIELD72_5 == null ? null : MT103_FIELD72_5.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_FIELD72_6
     *
     * @return the value of TRSDET.MT103_FIELD72_6
     */
    public String getMT103_FIELD72_6()
    {
	return MT103_FIELD72_6;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_FIELD72_6
     *
     * @param MT103_FIELD72_6 the value for TRSDET.MT103_FIELD72_6
     */
    public void setMT103_FIELD72_6(String MT103_FIELD72_6)
    {
	this.MT103_FIELD72_6 = MT103_FIELD72_6 == null ? null : MT103_FIELD72_6.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_INSTRUCTION_AMOUNT
     *
     * @return the value of TRSDET.MT103_INSTRUCTION_AMOUNT
     */
    public BigDecimal getMT103_INSTRUCTION_AMOUNT()
    {
	return MT103_INSTRUCTION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_INSTRUCTION_AMOUNT
     *
     * @param MT103_INSTRUCTION_AMOUNT the value for
     *            TRSDET.MT103_INSTRUCTION_AMOUNT
     */
    public void setMT103_INSTRUCTION_AMOUNT(BigDecimal MT103_INSTRUCTION_AMOUNT)
    {
	this.MT103_INSTRUCTION_AMOUNT = MT103_INSTRUCTION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_INSTRUCTION_CODE
     *
     * @return the value of TRSDET.MT103_INSTRUCTION_CODE
     */
    public String getMT103_INSTRUCTION_CODE()
    {
	return MT103_INSTRUCTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_INSTRUCTION_CODE
     *
     * @param MT103_INSTRUCTION_CODE the value for TRSDET.MT103_INSTRUCTION_CODE
     */
    public void setMT103_INSTRUCTION_CODE(String MT103_INSTRUCTION_CODE)
    {
	this.MT103_INSTRUCTION_CODE = MT103_INSTRUCTION_CODE == null ? null : MT103_INSTRUCTION_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT1
     *
     * @return the value of TRSDET.MT103_REGULATORY_REPORT1
     */
    public String getMT103_REGULATORY_REPORT1()
    {
	return MT103_REGULATORY_REPORT1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT1
     *
     * @param MT103_REGULATORY_REPORT1 the value for
     *            TRSDET.MT103_REGULATORY_REPORT1
     */
    public void setMT103_REGULATORY_REPORT1(String MT103_REGULATORY_REPORT1)
    {
	this.MT103_REGULATORY_REPORT1 = MT103_REGULATORY_REPORT1 == null ? null : MT103_REGULATORY_REPORT1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT2
     *
     * @return the value of TRSDET.MT103_REGULATORY_REPORT2
     */
    public String getMT103_REGULATORY_REPORT2()
    {
	return MT103_REGULATORY_REPORT2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT2
     *
     * @param MT103_REGULATORY_REPORT2 the value for
     *            TRSDET.MT103_REGULATORY_REPORT2
     */
    public void setMT103_REGULATORY_REPORT2(String MT103_REGULATORY_REPORT2)
    {
	this.MT103_REGULATORY_REPORT2 = MT103_REGULATORY_REPORT2 == null ? null : MT103_REGULATORY_REPORT2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT3
     *
     * @return the value of TRSDET.MT103_REGULATORY_REPORT3
     */
    public String getMT103_REGULATORY_REPORT3()
    {
	return MT103_REGULATORY_REPORT3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_REGULATORY_REPORT3
     *
     * @param MT103_REGULATORY_REPORT3 the value for
     *            TRSDET.MT103_REGULATORY_REPORT3
     */
    public void setMT103_REGULATORY_REPORT3(String MT103_REGULATORY_REPORT3)
    {
	this.MT103_REGULATORY_REPORT3 = MT103_REGULATORY_REPORT3 == null ? null : MT103_REGULATORY_REPORT3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT103_TRX_TYPE_CODE
     *
     * @return the value of TRSDET.MT103_TRX_TYPE_CODE
     */
    public String getMT103_TRX_TYPE_CODE()
    {
	return MT103_TRX_TYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT103_TRX_TYPE_CODE
     *
     * @param MT103_TRX_TYPE_CODE the value for TRSDET.MT103_TRX_TYPE_CODE
     */
    public void setMT103_TRX_TYPE_CODE(String MT103_TRX_TYPE_CODE)
    {
	this.MT103_TRX_TYPE_CODE = MT103_TRX_TYPE_CODE == null ? null : MT103_TRX_TYPE_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT200_SWIFT_MESSAGE1
     *
     * @return the value of TRSDET.MT200_SWIFT_MESSAGE1
     */
    public String getMT200_SWIFT_MESSAGE1()
    {
	return MT200_SWIFT_MESSAGE1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT200_SWIFT_MESSAGE1
     *
     * @param MT200_SWIFT_MESSAGE1 the value for TRSDET.MT200_SWIFT_MESSAGE1
     */
    public void setMT200_SWIFT_MESSAGE1(String MT200_SWIFT_MESSAGE1)
    {
	this.MT200_SWIFT_MESSAGE1 = MT200_SWIFT_MESSAGE1 == null ? null : MT200_SWIFT_MESSAGE1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT200_SWIFT_MESSAGE2
     *
     * @return the value of TRSDET.MT200_SWIFT_MESSAGE2
     */
    public String getMT200_SWIFT_MESSAGE2()
    {
	return MT200_SWIFT_MESSAGE2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT200_SWIFT_MESSAGE2
     *
     * @param MT200_SWIFT_MESSAGE2 the value for TRSDET.MT200_SWIFT_MESSAGE2
     */
    public void setMT200_SWIFT_MESSAGE2(String MT200_SWIFT_MESSAGE2)
    {
	this.MT200_SWIFT_MESSAGE2 = MT200_SWIFT_MESSAGE2 == null ? null : MT200_SWIFT_MESSAGE2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD21
     *
     * @return the value of TRSDET.MT202_FIELD21
     */
    public String getMT202_FIELD21()
    {
	return MT202_FIELD21;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD21
     *
     * @param MT202_FIELD21 the value for TRSDET.MT202_FIELD21
     */
    public void setMT202_FIELD21(String MT202_FIELD21)
    {
	this.MT202_FIELD21 = MT202_FIELD21 == null ? null : MT202_FIELD21.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_1
     *
     * @return the value of TRSDET.MT202_FIELD72_1
     */
    public String getMT202_FIELD72_1()
    {
	return MT202_FIELD72_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_1
     *
     * @param MT202_FIELD72_1 the value for TRSDET.MT202_FIELD72_1
     */
    public void setMT202_FIELD72_1(String MT202_FIELD72_1)
    {
	this.MT202_FIELD72_1 = MT202_FIELD72_1 == null ? null : MT202_FIELD72_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_2
     *
     * @return the value of TRSDET.MT202_FIELD72_2
     */
    public String getMT202_FIELD72_2()
    {
	return MT202_FIELD72_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_2
     *
     * @param MT202_FIELD72_2 the value for TRSDET.MT202_FIELD72_2
     */
    public void setMT202_FIELD72_2(String MT202_FIELD72_2)
    {
	this.MT202_FIELD72_2 = MT202_FIELD72_2 == null ? null : MT202_FIELD72_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_3
     *
     * @return the value of TRSDET.MT202_FIELD72_3
     */
    public String getMT202_FIELD72_3()
    {
	return MT202_FIELD72_3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_3
     *
     * @param MT202_FIELD72_3 the value for TRSDET.MT202_FIELD72_3
     */
    public void setMT202_FIELD72_3(String MT202_FIELD72_3)
    {
	this.MT202_FIELD72_3 = MT202_FIELD72_3 == null ? null : MT202_FIELD72_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_4
     *
     * @return the value of TRSDET.MT202_FIELD72_4
     */
    public String getMT202_FIELD72_4()
    {
	return MT202_FIELD72_4;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_4
     *
     * @param MT202_FIELD72_4 the value for TRSDET.MT202_FIELD72_4
     */
    public void setMT202_FIELD72_4(String MT202_FIELD72_4)
    {
	this.MT202_FIELD72_4 = MT202_FIELD72_4 == null ? null : MT202_FIELD72_4.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_5
     *
     * @return the value of TRSDET.MT202_FIELD72_5
     */
    public String getMT202_FIELD72_5()
    {
	return MT202_FIELD72_5;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_5
     *
     * @param MT202_FIELD72_5 the value for TRSDET.MT202_FIELD72_5
     */
    public void setMT202_FIELD72_5(String MT202_FIELD72_5)
    {
	this.MT202_FIELD72_5 = MT202_FIELD72_5 == null ? null : MT202_FIELD72_5.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT202_FIELD72_6
     *
     * @return the value of TRSDET.MT202_FIELD72_6
     */
    public String getMT202_FIELD72_6()
    {
	return MT202_FIELD72_6;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT202_FIELD72_6
     *
     * @param MT202_FIELD72_6 the value for TRSDET.MT202_FIELD72_6
     */
    public void setMT202_FIELD72_6(String MT202_FIELD72_6)
    {
	this.MT202_FIELD72_6 = MT202_FIELD72_6 == null ? null : MT202_FIELD72_6.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_1
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_1
     */
    public String getMT579_CERTIFICATE_NO_1()
    {
	return MT579_CERTIFICATE_NO_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_1
     *
     * @param MT579_CERTIFICATE_NO_1 the value for TRSDET.MT579_CERTIFICATE_NO_1
     */
    public void setMT579_CERTIFICATE_NO_1(String MT579_CERTIFICATE_NO_1)
    {
	this.MT579_CERTIFICATE_NO_1 = MT579_CERTIFICATE_NO_1 == null ? null : MT579_CERTIFICATE_NO_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_10
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_10
     */
    public String getMT579_CERTIFICATE_NO_10()
    {
	return MT579_CERTIFICATE_NO_10;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_10
     *
     * @param MT579_CERTIFICATE_NO_10 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_10
     */
    public void setMT579_CERTIFICATE_NO_10(String MT579_CERTIFICATE_NO_10)
    {
	this.MT579_CERTIFICATE_NO_10 = MT579_CERTIFICATE_NO_10 == null ? null : MT579_CERTIFICATE_NO_10.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_11
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_11
     */
    public String getMT579_CERTIFICATE_NO_11()
    {
	return MT579_CERTIFICATE_NO_11;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_11
     *
     * @param MT579_CERTIFICATE_NO_11 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_11
     */
    public void setMT579_CERTIFICATE_NO_11(String MT579_CERTIFICATE_NO_11)
    {
	this.MT579_CERTIFICATE_NO_11 = MT579_CERTIFICATE_NO_11 == null ? null : MT579_CERTIFICATE_NO_11.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_12
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_12
     */
    public String getMT579_CERTIFICATE_NO_12()
    {
	return MT579_CERTIFICATE_NO_12;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_12
     *
     * @param MT579_CERTIFICATE_NO_12 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_12
     */
    public void setMT579_CERTIFICATE_NO_12(String MT579_CERTIFICATE_NO_12)
    {
	this.MT579_CERTIFICATE_NO_12 = MT579_CERTIFICATE_NO_12 == null ? null : MT579_CERTIFICATE_NO_12.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_13
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_13
     */
    public String getMT579_CERTIFICATE_NO_13()
    {
	return MT579_CERTIFICATE_NO_13;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_13
     *
     * @param MT579_CERTIFICATE_NO_13 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_13
     */
    public void setMT579_CERTIFICATE_NO_13(String MT579_CERTIFICATE_NO_13)
    {
	this.MT579_CERTIFICATE_NO_13 = MT579_CERTIFICATE_NO_13 == null ? null : MT579_CERTIFICATE_NO_13.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_14
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_14
     */
    public String getMT579_CERTIFICATE_NO_14()
    {
	return MT579_CERTIFICATE_NO_14;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_14
     *
     * @param MT579_CERTIFICATE_NO_14 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_14
     */
    public void setMT579_CERTIFICATE_NO_14(String MT579_CERTIFICATE_NO_14)
    {
	this.MT579_CERTIFICATE_NO_14 = MT579_CERTIFICATE_NO_14 == null ? null : MT579_CERTIFICATE_NO_14.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_15
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_15
     */
    public String getMT579_CERTIFICATE_NO_15()
    {
	return MT579_CERTIFICATE_NO_15;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_15
     *
     * @param MT579_CERTIFICATE_NO_15 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_15
     */
    public void setMT579_CERTIFICATE_NO_15(String MT579_CERTIFICATE_NO_15)
    {
	this.MT579_CERTIFICATE_NO_15 = MT579_CERTIFICATE_NO_15 == null ? null : MT579_CERTIFICATE_NO_15.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_16
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_16
     */
    public String getMT579_CERTIFICATE_NO_16()
    {
	return MT579_CERTIFICATE_NO_16;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_16
     *
     * @param MT579_CERTIFICATE_NO_16 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_16
     */
    public void setMT579_CERTIFICATE_NO_16(String MT579_CERTIFICATE_NO_16)
    {
	this.MT579_CERTIFICATE_NO_16 = MT579_CERTIFICATE_NO_16 == null ? null : MT579_CERTIFICATE_NO_16.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_17
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_17
     */
    public String getMT579_CERTIFICATE_NO_17()
    {
	return MT579_CERTIFICATE_NO_17;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_17
     *
     * @param MT579_CERTIFICATE_NO_17 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_17
     */
    public void setMT579_CERTIFICATE_NO_17(String MT579_CERTIFICATE_NO_17)
    {
	this.MT579_CERTIFICATE_NO_17 = MT579_CERTIFICATE_NO_17 == null ? null : MT579_CERTIFICATE_NO_17.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_18
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_18
     */
    public String getMT579_CERTIFICATE_NO_18()
    {
	return MT579_CERTIFICATE_NO_18;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_18
     *
     * @param MT579_CERTIFICATE_NO_18 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_18
     */
    public void setMT579_CERTIFICATE_NO_18(String MT579_CERTIFICATE_NO_18)
    {
	this.MT579_CERTIFICATE_NO_18 = MT579_CERTIFICATE_NO_18 == null ? null : MT579_CERTIFICATE_NO_18.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_19
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_19
     */
    public String getMT579_CERTIFICATE_NO_19()
    {
	return MT579_CERTIFICATE_NO_19;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_19
     *
     * @param MT579_CERTIFICATE_NO_19 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_19
     */
    public void setMT579_CERTIFICATE_NO_19(String MT579_CERTIFICATE_NO_19)
    {
	this.MT579_CERTIFICATE_NO_19 = MT579_CERTIFICATE_NO_19 == null ? null : MT579_CERTIFICATE_NO_19.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_2
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_2
     */
    public String getMT579_CERTIFICATE_NO_2()
    {
	return MT579_CERTIFICATE_NO_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_2
     *
     * @param MT579_CERTIFICATE_NO_2 the value for TRSDET.MT579_CERTIFICATE_NO_2
     */
    public void setMT579_CERTIFICATE_NO_2(String MT579_CERTIFICATE_NO_2)
    {
	this.MT579_CERTIFICATE_NO_2 = MT579_CERTIFICATE_NO_2 == null ? null : MT579_CERTIFICATE_NO_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_20
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_20
     */
    public String getMT579_CERTIFICATE_NO_20()
    {
	return MT579_CERTIFICATE_NO_20;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_20
     *
     * @param MT579_CERTIFICATE_NO_20 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_20
     */
    public void setMT579_CERTIFICATE_NO_20(String MT579_CERTIFICATE_NO_20)
    {
	this.MT579_CERTIFICATE_NO_20 = MT579_CERTIFICATE_NO_20 == null ? null : MT579_CERTIFICATE_NO_20.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_21
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_21
     */
    public String getMT579_CERTIFICATE_NO_21()
    {
	return MT579_CERTIFICATE_NO_21;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_21
     *
     * @param MT579_CERTIFICATE_NO_21 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_21
     */
    public void setMT579_CERTIFICATE_NO_21(String MT579_CERTIFICATE_NO_21)
    {
	this.MT579_CERTIFICATE_NO_21 = MT579_CERTIFICATE_NO_21 == null ? null : MT579_CERTIFICATE_NO_21.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_22
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_22
     */
    public String getMT579_CERTIFICATE_NO_22()
    {
	return MT579_CERTIFICATE_NO_22;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_22
     *
     * @param MT579_CERTIFICATE_NO_22 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_22
     */
    public void setMT579_CERTIFICATE_NO_22(String MT579_CERTIFICATE_NO_22)
    {
	this.MT579_CERTIFICATE_NO_22 = MT579_CERTIFICATE_NO_22 == null ? null : MT579_CERTIFICATE_NO_22.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_23
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_23
     */
    public String getMT579_CERTIFICATE_NO_23()
    {
	return MT579_CERTIFICATE_NO_23;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_23
     *
     * @param MT579_CERTIFICATE_NO_23 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_23
     */
    public void setMT579_CERTIFICATE_NO_23(String MT579_CERTIFICATE_NO_23)
    {
	this.MT579_CERTIFICATE_NO_23 = MT579_CERTIFICATE_NO_23 == null ? null : MT579_CERTIFICATE_NO_23.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_24
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_24
     */
    public String getMT579_CERTIFICATE_NO_24()
    {
	return MT579_CERTIFICATE_NO_24;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_24
     *
     * @param MT579_CERTIFICATE_NO_24 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_24
     */
    public void setMT579_CERTIFICATE_NO_24(String MT579_CERTIFICATE_NO_24)
    {
	this.MT579_CERTIFICATE_NO_24 = MT579_CERTIFICATE_NO_24 == null ? null : MT579_CERTIFICATE_NO_24.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_25
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_25
     */
    public String getMT579_CERTIFICATE_NO_25()
    {
	return MT579_CERTIFICATE_NO_25;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_25
     *
     * @param MT579_CERTIFICATE_NO_25 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_25
     */
    public void setMT579_CERTIFICATE_NO_25(String MT579_CERTIFICATE_NO_25)
    {
	this.MT579_CERTIFICATE_NO_25 = MT579_CERTIFICATE_NO_25 == null ? null : MT579_CERTIFICATE_NO_25.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_26
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_26
     */
    public String getMT579_CERTIFICATE_NO_26()
    {
	return MT579_CERTIFICATE_NO_26;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_26
     *
     * @param MT579_CERTIFICATE_NO_26 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_26
     */
    public void setMT579_CERTIFICATE_NO_26(String MT579_CERTIFICATE_NO_26)
    {
	this.MT579_CERTIFICATE_NO_26 = MT579_CERTIFICATE_NO_26 == null ? null : MT579_CERTIFICATE_NO_26.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_27
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_27
     */
    public String getMT579_CERTIFICATE_NO_27()
    {
	return MT579_CERTIFICATE_NO_27;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_27
     *
     * @param MT579_CERTIFICATE_NO_27 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_27
     */
    public void setMT579_CERTIFICATE_NO_27(String MT579_CERTIFICATE_NO_27)
    {
	this.MT579_CERTIFICATE_NO_27 = MT579_CERTIFICATE_NO_27 == null ? null : MT579_CERTIFICATE_NO_27.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_28
     *
     * @return the value of TRSDET.MT579_CERTIFICATE_NO_28
     */
    public String getMT579_CERTIFICATE_NO_28()
    {
	return MT579_CERTIFICATE_NO_28;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MT579_CERTIFICATE_NO_28
     *
     * @param MT579_CERTIFICATE_NO_28 the value for
     *            TRSDET.MT579_CERTIFICATE_NO_28
     */
    public void setMT579_CERTIFICATE_NO_28(String MT579_CERTIFICATE_NO_28)
    {
	this.MT579_CERTIFICATE_NO_28 = MT579_CERTIFICATE_NO_28 == null ? null : MT579_CERTIFICATE_NO_28.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_PAYABLE_CIF
     *
     * @return the value of TRSDET.CONTRIB_PAYABLE_CIF
     */
    public BigDecimal getCONTRIB_PAYABLE_CIF()
    {
	return CONTRIB_PAYABLE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_PAYABLE_CIF
     *
     * @param CONTRIB_PAYABLE_CIF the value for TRSDET.CONTRIB_PAYABLE_CIF
     */
    public void setCONTRIB_PAYABLE_CIF(BigDecimal CONTRIB_PAYABLE_CIF)
    {
	this.CONTRIB_PAYABLE_CIF = CONTRIB_PAYABLE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_PAYABLE_GL
     *
     * @return the value of TRSDET.CONTRIB_PAYABLE_GL
     */
    public BigDecimal getCONTRIB_PAYABLE_GL()
    {
	return CONTRIB_PAYABLE_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_PAYABLE_GL
     *
     * @param CONTRIB_PAYABLE_GL the value for TRSDET.CONTRIB_PAYABLE_GL
     */
    public void setCONTRIB_PAYABLE_GL(BigDecimal CONTRIB_PAYABLE_GL)
    {
	this.CONTRIB_PAYABLE_GL = CONTRIB_PAYABLE_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_PAYABLE_SL
     *
     * @return the value of TRSDET.CONTRIB_PAYABLE_SL
     */
    public BigDecimal getCONTRIB_PAYABLE_SL()
    {
	return CONTRIB_PAYABLE_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_PAYABLE_SL
     *
     * @param CONTRIB_PAYABLE_SL the value for TRSDET.CONTRIB_PAYABLE_SL
     */
    public void setCONTRIB_PAYABLE_SL(BigDecimal CONTRIB_PAYABLE_SL)
    {
	this.CONTRIB_PAYABLE_SL = CONTRIB_PAYABLE_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_CIF
     *
     * @return the value of TRSDET.CONTRIB_RECEIVABLE_CIF
     */
    public BigDecimal getCONTRIB_RECEIVABLE_CIF()
    {
	return CONTRIB_RECEIVABLE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_CIF
     *
     * @param CONTRIB_RECEIVABLE_CIF the value for TRSDET.CONTRIB_RECEIVABLE_CIF
     */
    public void setCONTRIB_RECEIVABLE_CIF(BigDecimal CONTRIB_RECEIVABLE_CIF)
    {
	this.CONTRIB_RECEIVABLE_CIF = CONTRIB_RECEIVABLE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_GL
     *
     * @return the value of TRSDET.CONTRIB_RECEIVABLE_GL
     */
    public BigDecimal getCONTRIB_RECEIVABLE_GL()
    {
	return CONTRIB_RECEIVABLE_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_GL
     *
     * @param CONTRIB_RECEIVABLE_GL the value for TRSDET.CONTRIB_RECEIVABLE_GL
     */
    public void setCONTRIB_RECEIVABLE_GL(BigDecimal CONTRIB_RECEIVABLE_GL)
    {
	this.CONTRIB_RECEIVABLE_GL = CONTRIB_RECEIVABLE_GL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_SL
     *
     * @return the value of TRSDET.CONTRIB_RECEIVABLE_SL
     */
    public BigDecimal getCONTRIB_RECEIVABLE_SL()
    {
	return CONTRIB_RECEIVABLE_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.CONTRIB_RECEIVABLE_SL
     *
     * @param CONTRIB_RECEIVABLE_SL the value for TRSDET.CONTRIB_RECEIVABLE_SL
     */
    public void setCONTRIB_RECEIVABLE_SL(BigDecimal CONTRIB_RECEIVABLE_SL)
    {
	this.CONTRIB_RECEIVABLE_SL = CONTRIB_RECEIVABLE_SL;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRSDET.MUSHARAKA_PSR
     *
     * @return the value of TRSDET.MUSHARAKA_PSR
     */
    public BigDecimal getMUSHARAKA_PSR() {
        return MUSHARAKA_PSR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRSDET.MUSHARAKA_PSR
     *
     * @param MUSHARAKA_PSR the value for TRSDET.MUSHARAKA_PSR
     */
    public void setMUSHARAKA_PSR(BigDecimal MUSHARAKA_PSR) {
        this.MUSHARAKA_PSR = MUSHARAKA_PSR;
    }
}