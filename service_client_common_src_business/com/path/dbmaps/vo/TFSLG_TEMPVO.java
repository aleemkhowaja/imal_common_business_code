package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class TFSLG_TEMPVO extends BaseVO {
	
	//Mark Ayoub - #452967
	/**
	 * This field corresponds to the database column TFSLG.SECTOR_CODE
	 */
	private BigDecimal SECTOR_CODE;
	
	/**
	 * This field corresponds to the database column TFSLG.SUB_SECTOR_CODE
	 */
	private BigDecimal SUB_SECTOR_CODE;
	//End Mark
	
    /**
     * This field corresponds to the database column TFSLG_TEMP.AMEND_OTHER_SL
     */
    private BigDecimal AMEND_OTHER_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REQUISITION_NBR
     */
    private BigDecimal REQUISITION_NBR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOC_TYPE
     */
    private BigDecimal DOC_TYPE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MANUAL_REFERENCE
     */
    private String MANUAL_REFERENCE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOC_DATE
     */
    private Date DOC_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CIF
     */
    private BigDecimal CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CY_RATE
     */
    private BigDecimal CY_RATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CY_RATE_MULT_DIV
     */
    private String CY_RATE_MULT_DIV;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CV_AMOUNT
     */
    private BigDecimal CV_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VALIDITY_FROM
     */
    private Date VALIDITY_FROM;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VALIDITY_TO
     */
    private Date VALIDITY_TO;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_NAME
     */
    private String BENEFICIARY_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_COUNTRY
     */
    private String BENEFICIARY_COUNTRY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE
     */
    private String BENEFICIARY_ULTIMATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_METHOD
     */
    private String FUNDING_METHOD;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_FACILITY
     */
    private BigDecimal FUNDING_FACILITY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_ACC_GL
     */
    private BigDecimal FUNDING_ACC_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_ACC_CIF
     */
    private BigDecimal FUNDING_ACC_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_ACC_SL
     */
    private BigDecimal FUNDING_ACC_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PURPOSE_1
     */
    private String PURPOSE_1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PURPOSE_2
     */
    private String PURPOSE_2;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PURPOSE_3
     */
    private String PURPOSE_3;

    /**
     * This field corresponds to the database column TFSLG_TEMP.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VALIDATED_BY
     */
    private String VALIDATED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_VALIDATED
     */
    private Date DATE_VALIDATED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_REJECTED
     */
    private Date DATE_REJECTED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REVERSED_BY
     */
    private String REVERSED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_REVERSED
     */
    private Date DATE_REVERSED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PRINTED_BY
     */
    private String PRINTED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_PRINTED
     */
    private Date DATE_PRINTED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.POSTED_TO_GLS_BY
     */
    private String POSTED_TO_GLS_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_POSTED_TO_GLS
     */
    private Date DATE_POSTED_TO_GLS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_NBR
     */
    private BigDecimal LG_NBR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_STATUS
     */
    private String LG_STATUS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CY_UNIT
     */
    private BigDecimal CY_UNIT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SETTLED_AMOUNT
     */
    private BigDecimal SETTLED_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_BY
     */
    private String CLOSED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_CLOSED
     */
    private Date DATE_CLOSED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COLLATERAL_PERCENTAGE
     */
    private BigDecimal COLLATERAL_PERCENTAGE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DRWDWN_REF
     */
    private BigDecimal DRWDWN_REF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUSPENSE_GL
     */
    private BigDecimal SUSPENSE_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUSPENSE_CIF
     */
    private BigDecimal SUSPENSE_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUSPENSE_SL
     */
    private BigDecimal SUSPENSE_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CHARGES_BORNE_BY
     */
    private String CHARGES_BORNE_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_GL
     */
    private BigDecimal BENEFICIARY_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_CIF
     */
    private BigDecimal BENEFICIARY_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_SL
     */
    private BigDecimal BENEFICIARY_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_CANCELED
     */
    private Date DATE_CANCELED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CANCELED_BY
     */
    private String CANCELED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_REVERSE_BY
     */
    private String CLOSED_REVERSE_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATE_CLOSED_REVERSE
     */
    private Date DATE_CLOSED_REVERSE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_CREATED
     */
    private Date LG_DATE_CREATED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_CREATED_BY
     */
    private String LG_CREATED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_DELETED
     */
    private Date LG_DATE_DELETED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DELETED_BY
     */
    private String LG_DELETED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_APPROVED
     */
    private Date LG_DATE_APPROVED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_APPROVED_BY
     */
    private String LG_APPROVED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_REVERSED
     */
    private Date LG_DATE_REVERSED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_REVERSED_BY
     */
    private String LG_REVERSED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AMENDED_FC_AMOUNT
     */
    private BigDecimal AMENDED_FC_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AMENDED_CV_AMOUNT
     */
    private BigDecimal AMENDED_CV_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AMENDED_VALID_FROM_DATE
     */
    private Date AMENDED_VALID_FROM_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AMENDED_VALID_TO_DATE
     */
    private Date AMENDED_VALID_TO_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_CIF
     */
    private BigDecimal BENEF_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_COUNTRY
     */
    private BigDecimal BENEF_COUNTRY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CGUAR_EXP_DATE
     */
    private Date CGUAR_EXP_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PAYMENT_AMOUNT
     */
    private BigDecimal PAYMENT_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CASH_FINANCE
     */
    private String CASH_FINANCE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CROSS_CURRENCY
     */
    private String CROSS_CURRENCY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SETTLE_IND
     */
    private BigDecimal SETTLE_IND;

    /**
     * This field corresponds to the database column TFSLG_TEMP.INSURANCE_COMP
     */
    private BigDecimal INSURANCE_COMP;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TEMPLATE_CODE
     */
    private BigDecimal TEMPLATE_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_TYPE_DESC
     */
    private String LG_TYPE_DESC;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APPLICANT_CIF
     */
    private BigDecimal APPLICANT_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APPLICANT_NAME
     */
    private String APPLICANT_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MARGIN_REQUIRED
     */
    private BigDecimal MARGIN_REQUIRED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MARGIN_AMOUNT
     */
    private BigDecimal MARGIN_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_ACC_GL
     */
    private BigDecimal AUTO_MARGIN_ACC_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CIF
     */
    private BigDecimal AUTO_MARGIN_ACC_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_ACC_SL
     */
    private BigDecimal AUTO_MARGIN_ACC_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_DATE
     */
    private Date BENEF_LETTER_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_DATE_AR
     */
    private Date BENEF_LETTER_DATE_AR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_DATE_EXP
     */
    private Date BENEF_LETTER_DATE_EXP;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_DETAILS
     */
    private String BENEF_LETTER_DETAILS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_CHK
     */
    private BigDecimal BENEF_LETTER_CHK;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COUNTER_GUARANTEE_CIF
     */
    private BigDecimal COUNTER_GUARANTEE_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COUNTER_GUARANTEE_NAME
     */
    private String COUNTER_GUARANTEE_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COUNTER_GUARANTEE_NUMBER
     */
    private String COUNTER_GUARANTEE_NUMBER;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_CY
     */
    private BigDecimal BENEFICIARY_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_ACC_CY
     */
    private BigDecimal FUNDING_ACC_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUSPENSE_CY
     */
    private BigDecimal SUSPENSE_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_CY
     */
    private BigDecimal NOSTRO_MARGIN_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_GL
     */
    private BigDecimal NOSTRO_MARGIN_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_CIF
     */
    private BigDecimal NOSTRO_MARGIN_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_SL
     */
    private BigDecimal NOSTRO_MARGIN_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CY
     */
    private BigDecimal AUTO_MARGIN_ACC_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.ENABLE_ARABIC
     */
    private String ENABLE_ARABIC;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER1
     */
    private String SENDER_TO_RECIEVER1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER2
     */
    private String SENDER_TO_RECIEVER2;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_BIC_CODE
     */
    private String BENEF_BIC_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APPLICANT_BIC_CODE
     */
    private String APPLICANT_BIC_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FACILITY_CLASS
     */
    private BigDecimal FACILITY_CLASS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_BR
     */
    private BigDecimal BENEFICIARY_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FUNDING_ACC_BR
     */
    private BigDecimal FUNDING_ACC_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUSPENSE_BR
     */
    private BigDecimal SUSPENSE_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TOTAL_MARGIN_AMOUNT
     */
    private BigDecimal TOTAL_MARGIN_AMOUNT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN
     */
    private String AUTO_MARGIN;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TEMP_ALI
     */
    private String TEMP_ALI;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REASON_OF_CLOSURE
     */
    private String REASON_OF_CLOSURE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_LETTER_NBR
     */
    private String BENEF_LETTER_NBR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_AUTO_MARGIN
     */
    private BigDecimal CLOSED_AUTO_MARGIN;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE_ADDRESS
     */
    private String BENEFICIARY_ULTIMATE_ADDRESS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.INFO
     */
    private String INFO;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FACILITY_BR
     */
    private BigDecimal FACILITY_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MARGIN_AMT_CY2
     */
    private BigDecimal MARGIN_AMT_CY2;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CROSS_RATE
     */
    private BigDecimal CROSS_RATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CROSS_MULT_DIV
     */
    private String CROSS_MULT_DIV;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_RATE
     */
    private BigDecimal NOSTRO_MARGIN_RATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_RATE
     */
    private BigDecimal AUTO_MARGIN_RATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_SUSPENSE
     */
    private BigDecimal CLOSED_SUSPENSE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_SUSPENSE_CV
     */
    private BigDecimal CLOSED_SUSPENSE_CV;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_MODIFIED_BY
     */
    private String LG_MODIFIED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_MODIFIED
     */
    private Date LG_DATE_MODIFIED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FMS_MARGIN_PERCENT
     */
    private BigDecimal FMS_MARGIN_PERCENT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOC_NUMBER
     */
    private BigDecimal DOC_NUMBER;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOC_YEAR
     */
    private BigDecimal DOC_YEAR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APPLICANT_BIC_CODE1
     */
    private String APPLICANT_BIC_CODE1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_BIC_CODE1
     */
    private String BENEF_BIC_CODE1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BENEF_NAME1
     */
    private String BENEF_NAME1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APP_NAME1
     */
    private String APP_NAME1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TYPE_OF_ISSUE
     */
    private String TYPE_OF_ISSUE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.FURTHER_ID
     */
    private String FURTHER_ID;

    /**
     * This field corresponds to the database column TFSLG_TEMP.APP_RULES
     */
    private String APP_RULES;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_RENEW
     */
    private String AUTO_RENEW;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DD_CROSS_RATE
     */
    private BigDecimal DD_CROSS_RATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DYNAMIC_REF
     */
    private String DYNAMIC_REF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SUBLIMIT_MARGIN
     */
    private BigDecimal SUBLIMIT_MARGIN;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXTNDD_EXPIRY_DTE
     */
    private Date EXTNDD_EXPIRY_DTE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXPIRY_DTE
     */
    private Date EXPIRY_DTE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CLOSED_MARGIN_BS
     */
    private BigDecimal CLOSED_MARGIN_BS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SHIPPING_GUARANTEE
     */
    private String SHIPPING_GUARANTEE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SG_TYPE
     */
    private String SG_TYPE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SG_LINK_YEAR
     */
    private BigDecimal SG_LINK_YEAR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SG_LINK_NUMBER
     */
    private BigDecimal SG_LINK_NUMBER;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BILL_OF_LADING
     */
    private String BILL_OF_LADING;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BILL_OF_LADING_PLACE
     */
    private String BILL_OF_LADING_PLACE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.BILL_OF_LADING_DATE
     */
    private Date BILL_OF_LADING_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.INVOICE_NUMBER
     */
    private String INVOICE_NUMBER;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VESSEL_NAME
     */
    private String VESSEL_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VOYAGE_NBR
     */
    private String VOYAGE_NBR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.VESSEL_OWNER
     */
    private String VESSEL_OWNER;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SHIPPER_NAME
     */
    private String SHIPPER_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SHIPPER_ADDRESS
     */
    private String SHIPPER_ADDRESS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CONSIGNEE_NAME
     */
    private String CONSIGNEE_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CONSIGNEE_ADDRESS
     */
    private String CONSIGNEE_ADDRESS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOTIFY_PARTY_NAME
     */
    private String NOTIFY_PARTY_NAME;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOTIFY_PARTY_ADDRESS
     */
    private String NOTIFY_PARTY_ADDRESS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MARKS_NOS
     */
    private String MARKS_NOS;

    /**
     * This field corresponds to the database column TFSLG_TEMP.GROSS_WEIGHT
     */
    private String GROSS_WEIGHT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.MEASURMENT
     */
    private String MEASURMENT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PLACE_OF_RECEIPT
     */
    private String PLACE_OF_RECEIPT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PORT_OF_LOADING
     */
    private String PORT_OF_LOADING;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PORT_OF_DISCHARGE
     */
    private String PORT_OF_DISCHARGE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.PLACE_OF_DELIVERY
     */
    private String PLACE_OF_DELIVERY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REMINDER_DATE
     */
    private Date REMINDER_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REJECT_REASON
     */
    private String REJECT_REASON;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER3
     */
    private String SENDER_TO_RECIEVER3;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER4
     */
    private String SENDER_TO_RECIEVER4;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER5
     */
    private String SENDER_TO_RECIEVER5;

    /**
     * This field corresponds to the database column TFSLG_TEMP.SENDER_TO_RECIEVER6
     */
    private String SENDER_TO_RECIEVER6;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TYPE_OF_MSG
     */
    private String TYPE_OF_MSG;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA
     */
    private String EXISTING_GIA;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA_BR
     */
    private BigDecimal EXISTING_GIA_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA_CY
     */
    private BigDecimal EXISTING_GIA_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA_GL
     */
    private BigDecimal EXISTING_GIA_GL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA_CIF
     */
    private BigDecimal EXISTING_GIA_CIF;

    /**
     * This field corresponds to the database column TFSLG_TEMP.EXISTING_GIA_SL
     */
    private BigDecimal EXISTING_GIA_SL;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COUNTRY_LIMIT_CODE
     */
    private BigDecimal COUNTRY_LIMIT_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.ISSUED_ON
     */
    private Date ISSUED_ON;

    /**
     * This field corresponds to the database column TFSLG_TEMP.REQ_ISSUED_ON
     */
    private Date REQ_ISSUED_ON;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOM_REQUEST_NBR
     */
    private BigDecimal DOM_REQUEST_NBR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COMMISSION_CY
     */
    private BigDecimal COMMISSION_CY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COMMISSION_AMT
     */
    private BigDecimal COMMISSION_AMT;

    /**
     * This field corresponds to the database column TFSLG_TEMP.COMMISSION_PAID
     */
    private String COMMISSION_PAID;

    /**
     * This field corresponds to the database column TFSLG_TEMP.AUTO_MARGIN_ACC_BR
     */
    private BigDecimal AUTO_MARGIN_ACC_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.NOSTRO_MARGIN_BR
     */
    private BigDecimal NOSTRO_MARGIN_BR;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DATETIME_MODIFIED
     */
    private Date DATETIME_MODIFIED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REV_DATE
     */
    private Date TB_REV_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REV_BY
     */
    private String TB_REV_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REJREV_DATE
     */
    private Date TB_REJREV_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REJREV_BY
     */
    private String TB_REJREV_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.INS_HYPERLINK
     */
    private String INS_HYPERLINK;

    /**
     * This field corresponds to the database column TFSLG_TEMP.CONV_VALUE_DATE
     */
    private Date CONV_VALUE_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_CANCEL_BY
     */
    private String TB_CANCEL_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_CANCEL_DATE
     */
    private Date TB_CANCEL_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REJCANCEL_BY
     */
    private String TB_REJCANCEL_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TB_REJCANCEL_DATE
     */
    private Date TB_REJCANCEL_DATE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_DATE_VALIDATED
     */
    private Date LG_DATE_VALIDATED;

    /**
     * This field corresponds to the database column TFSLG_TEMP.LG_VALIDATED_BY
     */
    private String LG_VALIDATED_BY;

    /**
     * This field corresponds to the database column TFSLG_TEMP.ONLINE_LIMIT_CHECK
     */
    private String ONLINE_LIMIT_CHECK;

    /**
     * This field corresponds to the database column TFSLG_TEMP.TEXT_TYPE_CODE
     */
    private BigDecimal TEXT_TYPE_CODE;

    /**
     * This field corresponds to the database column TFSLG_TEMP.GUARANT_DET
     */
    private String GUARANT_DET;

    /**
     * This field corresponds to the database column TFSLG_TEMP.GUARANT_DET1
     */
    private String GUARANT_DET1;

    /**
     * This field corresponds to the database column TFSLG_TEMP.GUARANT_DET2
     */
    private String GUARANT_DET2;

    /**
     * This field corresponds to the database column TFSLG_TEMP.GOODS_DESCRIPTION
     */
    private String GOODS_DESCRIPTION;

    /**
     * This field corresponds to the database column TFSLG_TEMP.DOM_REQUEST_BRANCH_CODE
     */
    private BigDecimal DOM_REQUEST_BRANCH_CODE;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMEND_OTHER_SL
     *
     * @return the value of TFSLG_TEMP.AMEND_OTHER_SL
     */
    public BigDecimal getAMEND_OTHER_SL() {
        return AMEND_OTHER_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMEND_OTHER_SL
     *
     * @param AMEND_OTHER_SL the value for TFSLG_TEMP.AMEND_OTHER_SL
     */
    public void setAMEND_OTHER_SL(BigDecimal AMEND_OTHER_SL) {
        this.AMEND_OTHER_SL = AMEND_OTHER_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BRANCH
     *
     * @return the value of TFSLG_TEMP.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BRANCH
     *
     * @param BRANCH the value for TFSLG_TEMP.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COMP_CODE
     *
     * @return the value of TFSLG_TEMP.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COMP_CODE
     *
     * @param COMP_CODE the value for TFSLG_TEMP.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REQUISITION_NBR
     *
     * @return the value of TFSLG_TEMP.REQUISITION_NBR
     */
    public BigDecimal getREQUISITION_NBR() {
        return REQUISITION_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REQUISITION_NBR
     *
     * @param REQUISITION_NBR the value for TFSLG_TEMP.REQUISITION_NBR
     */
    public void setREQUISITION_NBR(BigDecimal REQUISITION_NBR) {
        this.REQUISITION_NBR = REQUISITION_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DOC_TYPE
     *
     * @return the value of TFSLG_TEMP.DOC_TYPE
     */
    public BigDecimal getDOC_TYPE() {
        return DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DOC_TYPE
     *
     * @param DOC_TYPE the value for TFSLG_TEMP.DOC_TYPE
     */
    public void setDOC_TYPE(BigDecimal DOC_TYPE) {
        this.DOC_TYPE = DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MANUAL_REFERENCE
     *
     * @return the value of TFSLG_TEMP.MANUAL_REFERENCE
     */
    public String getMANUAL_REFERENCE() {
        return MANUAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MANUAL_REFERENCE
     *
     * @param MANUAL_REFERENCE the value for TFSLG_TEMP.MANUAL_REFERENCE
     */
    public void setMANUAL_REFERENCE(String MANUAL_REFERENCE) {
        this.MANUAL_REFERENCE = MANUAL_REFERENCE == null ? null : MANUAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DOC_DATE
     *
     * @return the value of TFSLG_TEMP.DOC_DATE
     */
    public Date getDOC_DATE() {
        return DOC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DOC_DATE
     *
     * @param DOC_DATE the value for TFSLG_TEMP.DOC_DATE
     */
    public void setDOC_DATE(Date DOC_DATE) {
        this.DOC_DATE = DOC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CIF
     *
     * @return the value of TFSLG_TEMP.CIF
     */
    public BigDecimal getCIF() {
        return CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CIF
     *
     * @param CIF the value for TFSLG_TEMP.CIF
     */
    public void setCIF(BigDecimal CIF) {
        this.CIF = CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CURRENCY
     *
     * @return the value of TFSLG_TEMP.CURRENCY
     */
    public BigDecimal getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CURRENCY
     *
     * @param CURRENCY the value for TFSLG_TEMP.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMOUNT
     *
     * @return the value of TFSLG_TEMP.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMOUNT
     *
     * @param AMOUNT the value for TFSLG_TEMP.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CY_RATE
     *
     * @return the value of TFSLG_TEMP.CY_RATE
     */
    public BigDecimal getCY_RATE() {
        return CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CY_RATE
     *
     * @param CY_RATE the value for TFSLG_TEMP.CY_RATE
     */
    public void setCY_RATE(BigDecimal CY_RATE) {
        this.CY_RATE = CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CY_RATE_MULT_DIV
     *
     * @return the value of TFSLG_TEMP.CY_RATE_MULT_DIV
     */
    public String getCY_RATE_MULT_DIV() {
        return CY_RATE_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CY_RATE_MULT_DIV
     *
     * @param CY_RATE_MULT_DIV the value for TFSLG_TEMP.CY_RATE_MULT_DIV
     */
    public void setCY_RATE_MULT_DIV(String CY_RATE_MULT_DIV) {
        this.CY_RATE_MULT_DIV = CY_RATE_MULT_DIV == null ? null : CY_RATE_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CV_AMOUNT
     *
     * @return the value of TFSLG_TEMP.CV_AMOUNT
     */
    public BigDecimal getCV_AMOUNT() {
        return CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CV_AMOUNT
     *
     * @param CV_AMOUNT the value for TFSLG_TEMP.CV_AMOUNT
     */
    public void setCV_AMOUNT(BigDecimal CV_AMOUNT) {
        this.CV_AMOUNT = CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VALIDITY_FROM
     *
     * @return the value of TFSLG_TEMP.VALIDITY_FROM
     */
    public Date getVALIDITY_FROM() {
        return VALIDITY_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VALIDITY_FROM
     *
     * @param VALIDITY_FROM the value for TFSLG_TEMP.VALIDITY_FROM
     */
    public void setVALIDITY_FROM(Date VALIDITY_FROM) {
        this.VALIDITY_FROM = VALIDITY_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VALIDITY_TO
     *
     * @return the value of TFSLG_TEMP.VALIDITY_TO
     */
    public Date getVALIDITY_TO() {
        return VALIDITY_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VALIDITY_TO
     *
     * @param VALIDITY_TO the value for TFSLG_TEMP.VALIDITY_TO
     */
    public void setVALIDITY_TO(Date VALIDITY_TO) {
        this.VALIDITY_TO = VALIDITY_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_NAME
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_NAME
     */
    public String getBENEFICIARY_NAME() {
        return BENEFICIARY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_NAME
     *
     * @param BENEFICIARY_NAME the value for TFSLG_TEMP.BENEFICIARY_NAME
     */
    public void setBENEFICIARY_NAME(String BENEFICIARY_NAME) {
        this.BENEFICIARY_NAME = BENEFICIARY_NAME == null ? null : BENEFICIARY_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_COUNTRY
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_COUNTRY
     */
    public String getBENEFICIARY_COUNTRY() {
        return BENEFICIARY_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_COUNTRY
     *
     * @param BENEFICIARY_COUNTRY the value for TFSLG_TEMP.BENEFICIARY_COUNTRY
     */
    public void setBENEFICIARY_COUNTRY(String BENEFICIARY_COUNTRY) {
        this.BENEFICIARY_COUNTRY = BENEFICIARY_COUNTRY == null ? null : BENEFICIARY_COUNTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_ULTIMATE
     */
    public String getBENEFICIARY_ULTIMATE() {
        return BENEFICIARY_ULTIMATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE
     *
     * @param BENEFICIARY_ULTIMATE the value for TFSLG_TEMP.BENEFICIARY_ULTIMATE
     */
    public void setBENEFICIARY_ULTIMATE(String BENEFICIARY_ULTIMATE) {
        this.BENEFICIARY_ULTIMATE = BENEFICIARY_ULTIMATE == null ? null : BENEFICIARY_ULTIMATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_METHOD
     *
     * @return the value of TFSLG_TEMP.FUNDING_METHOD
     */
    public String getFUNDING_METHOD() {
        return FUNDING_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_METHOD
     *
     * @param FUNDING_METHOD the value for TFSLG_TEMP.FUNDING_METHOD
     */
    public void setFUNDING_METHOD(String FUNDING_METHOD) {
        this.FUNDING_METHOD = FUNDING_METHOD == null ? null : FUNDING_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_FACILITY
     *
     * @return the value of TFSLG_TEMP.FUNDING_FACILITY
     */
    public BigDecimal getFUNDING_FACILITY() {
        return FUNDING_FACILITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_FACILITY
     *
     * @param FUNDING_FACILITY the value for TFSLG_TEMP.FUNDING_FACILITY
     */
    public void setFUNDING_FACILITY(BigDecimal FUNDING_FACILITY) {
        this.FUNDING_FACILITY = FUNDING_FACILITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_ACC_GL
     *
     * @return the value of TFSLG_TEMP.FUNDING_ACC_GL
     */
    public BigDecimal getFUNDING_ACC_GL() {
        return FUNDING_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_ACC_GL
     *
     * @param FUNDING_ACC_GL the value for TFSLG_TEMP.FUNDING_ACC_GL
     */
    public void setFUNDING_ACC_GL(BigDecimal FUNDING_ACC_GL) {
        this.FUNDING_ACC_GL = FUNDING_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_ACC_CIF
     *
     * @return the value of TFSLG_TEMP.FUNDING_ACC_CIF
     */
    public BigDecimal getFUNDING_ACC_CIF() {
        return FUNDING_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_ACC_CIF
     *
     * @param FUNDING_ACC_CIF the value for TFSLG_TEMP.FUNDING_ACC_CIF
     */
    public void setFUNDING_ACC_CIF(BigDecimal FUNDING_ACC_CIF) {
        this.FUNDING_ACC_CIF = FUNDING_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_ACC_SL
     *
     * @return the value of TFSLG_TEMP.FUNDING_ACC_SL
     */
    public BigDecimal getFUNDING_ACC_SL() {
        return FUNDING_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_ACC_SL
     *
     * @param FUNDING_ACC_SL the value for TFSLG_TEMP.FUNDING_ACC_SL
     */
    public void setFUNDING_ACC_SL(BigDecimal FUNDING_ACC_SL) {
        this.FUNDING_ACC_SL = FUNDING_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PURPOSE_1
     *
     * @return the value of TFSLG_TEMP.PURPOSE_1
     */
    public String getPURPOSE_1() {
        return PURPOSE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PURPOSE_1
     *
     * @param PURPOSE_1 the value for TFSLG_TEMP.PURPOSE_1
     */
    public void setPURPOSE_1(String PURPOSE_1) {
        this.PURPOSE_1 = PURPOSE_1 == null ? null : PURPOSE_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PURPOSE_2
     *
     * @return the value of TFSLG_TEMP.PURPOSE_2
     */
    public String getPURPOSE_2() {
        return PURPOSE_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PURPOSE_2
     *
     * @param PURPOSE_2 the value for TFSLG_TEMP.PURPOSE_2
     */
    public void setPURPOSE_2(String PURPOSE_2) {
        this.PURPOSE_2 = PURPOSE_2 == null ? null : PURPOSE_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PURPOSE_3
     *
     * @return the value of TFSLG_TEMP.PURPOSE_3
     */
    public String getPURPOSE_3() {
        return PURPOSE_3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PURPOSE_3
     *
     * @param PURPOSE_3 the value for TFSLG_TEMP.PURPOSE_3
     */
    public void setPURPOSE_3(String PURPOSE_3) {
        this.PURPOSE_3 = PURPOSE_3 == null ? null : PURPOSE_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.STATUS
     *
     * @return the value of TFSLG_TEMP.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.STATUS
     *
     * @param STATUS the value for TFSLG_TEMP.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CREATED_BY
     *
     * @return the value of TFSLG_TEMP.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CREATED_BY
     *
     * @param CREATED_BY the value for TFSLG_TEMP.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_CREATED
     *
     * @return the value of TFSLG_TEMP.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_CREATED
     *
     * @param DATE_CREATED the value for TFSLG_TEMP.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DELETED_BY
     *
     * @return the value of TFSLG_TEMP.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DELETED_BY
     *
     * @param DELETED_BY the value for TFSLG_TEMP.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_DELETED
     *
     * @return the value of TFSLG_TEMP.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_DELETED
     *
     * @param DATE_DELETED the value for TFSLG_TEMP.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VALIDATED_BY
     *
     * @return the value of TFSLG_TEMP.VALIDATED_BY
     */
    public String getVALIDATED_BY() {
        return VALIDATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VALIDATED_BY
     *
     * @param VALIDATED_BY the value for TFSLG_TEMP.VALIDATED_BY
     */
    public void setVALIDATED_BY(String VALIDATED_BY) {
        this.VALIDATED_BY = VALIDATED_BY == null ? null : VALIDATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_VALIDATED
     *
     * @return the value of TFSLG_TEMP.DATE_VALIDATED
     */
    public Date getDATE_VALIDATED() {
        return DATE_VALIDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_VALIDATED
     *
     * @param DATE_VALIDATED the value for TFSLG_TEMP.DATE_VALIDATED
     */
    public void setDATE_VALIDATED(Date DATE_VALIDATED) {
        this.DATE_VALIDATED = DATE_VALIDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APPROVED_BY
     *
     * @return the value of TFSLG_TEMP.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APPROVED_BY
     *
     * @param APPROVED_BY the value for TFSLG_TEMP.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_APPROVED
     *
     * @return the value of TFSLG_TEMP.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for TFSLG_TEMP.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REJECTED_BY
     *
     * @return the value of TFSLG_TEMP.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REJECTED_BY
     *
     * @param REJECTED_BY the value for TFSLG_TEMP.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_REJECTED
     *
     * @return the value of TFSLG_TEMP.DATE_REJECTED
     */
    public Date getDATE_REJECTED() {
        return DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_REJECTED
     *
     * @param DATE_REJECTED the value for TFSLG_TEMP.DATE_REJECTED
     */
    public void setDATE_REJECTED(Date DATE_REJECTED) {
        this.DATE_REJECTED = DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REVERSED_BY
     *
     * @return the value of TFSLG_TEMP.REVERSED_BY
     */
    public String getREVERSED_BY() {
        return REVERSED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REVERSED_BY
     *
     * @param REVERSED_BY the value for TFSLG_TEMP.REVERSED_BY
     */
    public void setREVERSED_BY(String REVERSED_BY) {
        this.REVERSED_BY = REVERSED_BY == null ? null : REVERSED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_REVERSED
     *
     * @return the value of TFSLG_TEMP.DATE_REVERSED
     */
    public Date getDATE_REVERSED() {
        return DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_REVERSED
     *
     * @param DATE_REVERSED the value for TFSLG_TEMP.DATE_REVERSED
     */
    public void setDATE_REVERSED(Date DATE_REVERSED) {
        this.DATE_REVERSED = DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PRINTED_BY
     *
     * @return the value of TFSLG_TEMP.PRINTED_BY
     */
    public String getPRINTED_BY() {
        return PRINTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PRINTED_BY
     *
     * @param PRINTED_BY the value for TFSLG_TEMP.PRINTED_BY
     */
    public void setPRINTED_BY(String PRINTED_BY) {
        this.PRINTED_BY = PRINTED_BY == null ? null : PRINTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_PRINTED
     *
     * @return the value of TFSLG_TEMP.DATE_PRINTED
     */
    public Date getDATE_PRINTED() {
        return DATE_PRINTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_PRINTED
     *
     * @param DATE_PRINTED the value for TFSLG_TEMP.DATE_PRINTED
     */
    public void setDATE_PRINTED(Date DATE_PRINTED) {
        this.DATE_PRINTED = DATE_PRINTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.POSTED_TO_GLS_BY
     *
     * @return the value of TFSLG_TEMP.POSTED_TO_GLS_BY
     */
    public String getPOSTED_TO_GLS_BY() {
        return POSTED_TO_GLS_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.POSTED_TO_GLS_BY
     *
     * @param POSTED_TO_GLS_BY the value for TFSLG_TEMP.POSTED_TO_GLS_BY
     */
    public void setPOSTED_TO_GLS_BY(String POSTED_TO_GLS_BY) {
        this.POSTED_TO_GLS_BY = POSTED_TO_GLS_BY == null ? null : POSTED_TO_GLS_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_POSTED_TO_GLS
     *
     * @return the value of TFSLG_TEMP.DATE_POSTED_TO_GLS
     */
    public Date getDATE_POSTED_TO_GLS() {
        return DATE_POSTED_TO_GLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_POSTED_TO_GLS
     *
     * @param DATE_POSTED_TO_GLS the value for TFSLG_TEMP.DATE_POSTED_TO_GLS
     */
    public void setDATE_POSTED_TO_GLS(Date DATE_POSTED_TO_GLS) {
        this.DATE_POSTED_TO_GLS = DATE_POSTED_TO_GLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_NBR
     *
     * @return the value of TFSLG_TEMP.LG_NBR
     */
    public BigDecimal getLG_NBR() {
        return LG_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_NBR
     *
     * @param LG_NBR the value for TFSLG_TEMP.LG_NBR
     */
    public void setLG_NBR(BigDecimal LG_NBR) {
        this.LG_NBR = LG_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_STATUS
     *
     * @return the value of TFSLG_TEMP.LG_STATUS
     */
    public String getLG_STATUS() {
        return LG_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_STATUS
     *
     * @param LG_STATUS the value for TFSLG_TEMP.LG_STATUS
     */
    public void setLG_STATUS(String LG_STATUS) {
        this.LG_STATUS = LG_STATUS == null ? null : LG_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CY_UNIT
     *
     * @return the value of TFSLG_TEMP.CY_UNIT
     */
    public BigDecimal getCY_UNIT() {
        return CY_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CY_UNIT
     *
     * @param CY_UNIT the value for TFSLG_TEMP.CY_UNIT
     */
    public void setCY_UNIT(BigDecimal CY_UNIT) {
        this.CY_UNIT = CY_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SETTLED_AMOUNT
     *
     * @return the value of TFSLG_TEMP.SETTLED_AMOUNT
     */
    public BigDecimal getSETTLED_AMOUNT() {
        return SETTLED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SETTLED_AMOUNT
     *
     * @param SETTLED_AMOUNT the value for TFSLG_TEMP.SETTLED_AMOUNT
     */
    public void setSETTLED_AMOUNT(BigDecimal SETTLED_AMOUNT) {
        this.SETTLED_AMOUNT = SETTLED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_BY
     *
     * @return the value of TFSLG_TEMP.CLOSED_BY
     */
    public String getCLOSED_BY() {
        return CLOSED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_BY
     *
     * @param CLOSED_BY the value for TFSLG_TEMP.CLOSED_BY
     */
    public void setCLOSED_BY(String CLOSED_BY) {
        this.CLOSED_BY = CLOSED_BY == null ? null : CLOSED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_CLOSED
     *
     * @return the value of TFSLG_TEMP.DATE_CLOSED
     */
    public Date getDATE_CLOSED() {
        return DATE_CLOSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_CLOSED
     *
     * @param DATE_CLOSED the value for TFSLG_TEMP.DATE_CLOSED
     */
    public void setDATE_CLOSED(Date DATE_CLOSED) {
        this.DATE_CLOSED = DATE_CLOSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COLLATERAL_PERCENTAGE
     *
     * @return the value of TFSLG_TEMP.COLLATERAL_PERCENTAGE
     */
    public BigDecimal getCOLLATERAL_PERCENTAGE() {
        return COLLATERAL_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COLLATERAL_PERCENTAGE
     *
     * @param COLLATERAL_PERCENTAGE the value for TFSLG_TEMP.COLLATERAL_PERCENTAGE
     */
    public void setCOLLATERAL_PERCENTAGE(BigDecimal COLLATERAL_PERCENTAGE) {
        this.COLLATERAL_PERCENTAGE = COLLATERAL_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DRWDWN_REF
     *
     * @return the value of TFSLG_TEMP.DRWDWN_REF
     */
    public BigDecimal getDRWDWN_REF() {
        return DRWDWN_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DRWDWN_REF
     *
     * @param DRWDWN_REF the value for TFSLG_TEMP.DRWDWN_REF
     */
    public void setDRWDWN_REF(BigDecimal DRWDWN_REF) {
        this.DRWDWN_REF = DRWDWN_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUSPENSE_GL
     *
     * @return the value of TFSLG_TEMP.SUSPENSE_GL
     */
    public BigDecimal getSUSPENSE_GL() {
        return SUSPENSE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUSPENSE_GL
     *
     * @param SUSPENSE_GL the value for TFSLG_TEMP.SUSPENSE_GL
     */
    public void setSUSPENSE_GL(BigDecimal SUSPENSE_GL) {
        this.SUSPENSE_GL = SUSPENSE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUSPENSE_CIF
     *
     * @return the value of TFSLG_TEMP.SUSPENSE_CIF
     */
    public BigDecimal getSUSPENSE_CIF() {
        return SUSPENSE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUSPENSE_CIF
     *
     * @param SUSPENSE_CIF the value for TFSLG_TEMP.SUSPENSE_CIF
     */
    public void setSUSPENSE_CIF(BigDecimal SUSPENSE_CIF) {
        this.SUSPENSE_CIF = SUSPENSE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUSPENSE_SL
     *
     * @return the value of TFSLG_TEMP.SUSPENSE_SL
     */
    public BigDecimal getSUSPENSE_SL() {
        return SUSPENSE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUSPENSE_SL
     *
     * @param SUSPENSE_SL the value for TFSLG_TEMP.SUSPENSE_SL
     */
    public void setSUSPENSE_SL(BigDecimal SUSPENSE_SL) {
        this.SUSPENSE_SL = SUSPENSE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CHARGES_BORNE_BY
     *
     * @return the value of TFSLG_TEMP.CHARGES_BORNE_BY
     */
    public String getCHARGES_BORNE_BY() {
        return CHARGES_BORNE_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CHARGES_BORNE_BY
     *
     * @param CHARGES_BORNE_BY the value for TFSLG_TEMP.CHARGES_BORNE_BY
     */
    public void setCHARGES_BORNE_BY(String CHARGES_BORNE_BY) {
        this.CHARGES_BORNE_BY = CHARGES_BORNE_BY == null ? null : CHARGES_BORNE_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_GL
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_GL
     */
    public BigDecimal getBENEFICIARY_GL() {
        return BENEFICIARY_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_GL
     *
     * @param BENEFICIARY_GL the value for TFSLG_TEMP.BENEFICIARY_GL
     */
    public void setBENEFICIARY_GL(BigDecimal BENEFICIARY_GL) {
        this.BENEFICIARY_GL = BENEFICIARY_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_CIF
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_CIF
     */
    public BigDecimal getBENEFICIARY_CIF() {
        return BENEFICIARY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_CIF
     *
     * @param BENEFICIARY_CIF the value for TFSLG_TEMP.BENEFICIARY_CIF
     */
    public void setBENEFICIARY_CIF(BigDecimal BENEFICIARY_CIF) {
        this.BENEFICIARY_CIF = BENEFICIARY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_SL
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_SL
     */
    public BigDecimal getBENEFICIARY_SL() {
        return BENEFICIARY_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_SL
     *
     * @param BENEFICIARY_SL the value for TFSLG_TEMP.BENEFICIARY_SL
     */
    public void setBENEFICIARY_SL(BigDecimal BENEFICIARY_SL) {
        this.BENEFICIARY_SL = BENEFICIARY_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_CANCELED
     *
     * @return the value of TFSLG_TEMP.DATE_CANCELED
     */
    public Date getDATE_CANCELED() {
        return DATE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_CANCELED
     *
     * @param DATE_CANCELED the value for TFSLG_TEMP.DATE_CANCELED
     */
    public void setDATE_CANCELED(Date DATE_CANCELED) {
        this.DATE_CANCELED = DATE_CANCELED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CANCELED_BY
     *
     * @return the value of TFSLG_TEMP.CANCELED_BY
     */
    public String getCANCELED_BY() {
        return CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CANCELED_BY
     *
     * @param CANCELED_BY the value for TFSLG_TEMP.CANCELED_BY
     */
    public void setCANCELED_BY(String CANCELED_BY) {
        this.CANCELED_BY = CANCELED_BY == null ? null : CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_REVERSE_BY
     *
     * @return the value of TFSLG_TEMP.CLOSED_REVERSE_BY
     */
    public String getCLOSED_REVERSE_BY() {
        return CLOSED_REVERSE_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_REVERSE_BY
     *
     * @param CLOSED_REVERSE_BY the value for TFSLG_TEMP.CLOSED_REVERSE_BY
     */
    public void setCLOSED_REVERSE_BY(String CLOSED_REVERSE_BY) {
        this.CLOSED_REVERSE_BY = CLOSED_REVERSE_BY == null ? null : CLOSED_REVERSE_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATE_CLOSED_REVERSE
     *
     * @return the value of TFSLG_TEMP.DATE_CLOSED_REVERSE
     */
    public Date getDATE_CLOSED_REVERSE() {
        return DATE_CLOSED_REVERSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATE_CLOSED_REVERSE
     *
     * @param DATE_CLOSED_REVERSE the value for TFSLG_TEMP.DATE_CLOSED_REVERSE
     */
    public void setDATE_CLOSED_REVERSE(Date DATE_CLOSED_REVERSE) {
        this.DATE_CLOSED_REVERSE = DATE_CLOSED_REVERSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_CREATED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_CREATED
     */
    public Date getLG_DATE_CREATED() {
        return LG_DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_CREATED
     *
     * @param LG_DATE_CREATED the value for TFSLG_TEMP.LG_DATE_CREATED
     */
    public void setLG_DATE_CREATED(Date LG_DATE_CREATED) {
        this.LG_DATE_CREATED = LG_DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_CREATED_BY
     *
     * @return the value of TFSLG_TEMP.LG_CREATED_BY
     */
    public String getLG_CREATED_BY() {
        return LG_CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_CREATED_BY
     *
     * @param LG_CREATED_BY the value for TFSLG_TEMP.LG_CREATED_BY
     */
    public void setLG_CREATED_BY(String LG_CREATED_BY) {
        this.LG_CREATED_BY = LG_CREATED_BY == null ? null : LG_CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_DELETED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_DELETED
     */
    public Date getLG_DATE_DELETED() {
        return LG_DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_DELETED
     *
     * @param LG_DATE_DELETED the value for TFSLG_TEMP.LG_DATE_DELETED
     */
    public void setLG_DATE_DELETED(Date LG_DATE_DELETED) {
        this.LG_DATE_DELETED = LG_DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DELETED_BY
     *
     * @return the value of TFSLG_TEMP.LG_DELETED_BY
     */
    public String getLG_DELETED_BY() {
        return LG_DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DELETED_BY
     *
     * @param LG_DELETED_BY the value for TFSLG_TEMP.LG_DELETED_BY
     */
    public void setLG_DELETED_BY(String LG_DELETED_BY) {
        this.LG_DELETED_BY = LG_DELETED_BY == null ? null : LG_DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_APPROVED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_APPROVED
     */
    public Date getLG_DATE_APPROVED() {
        return LG_DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_APPROVED
     *
     * @param LG_DATE_APPROVED the value for TFSLG_TEMP.LG_DATE_APPROVED
     */
    public void setLG_DATE_APPROVED(Date LG_DATE_APPROVED) {
        this.LG_DATE_APPROVED = LG_DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_APPROVED_BY
     *
     * @return the value of TFSLG_TEMP.LG_APPROVED_BY
     */
    public String getLG_APPROVED_BY() {
        return LG_APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_APPROVED_BY
     *
     * @param LG_APPROVED_BY the value for TFSLG_TEMP.LG_APPROVED_BY
     */
    public void setLG_APPROVED_BY(String LG_APPROVED_BY) {
        this.LG_APPROVED_BY = LG_APPROVED_BY == null ? null : LG_APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_REVERSED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_REVERSED
     */
    public Date getLG_DATE_REVERSED() {
        return LG_DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_REVERSED
     *
     * @param LG_DATE_REVERSED the value for TFSLG_TEMP.LG_DATE_REVERSED
     */
    public void setLG_DATE_REVERSED(Date LG_DATE_REVERSED) {
        this.LG_DATE_REVERSED = LG_DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_REVERSED_BY
     *
     * @return the value of TFSLG_TEMP.LG_REVERSED_BY
     */
    public String getLG_REVERSED_BY() {
        return LG_REVERSED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_REVERSED_BY
     *
     * @param LG_REVERSED_BY the value for TFSLG_TEMP.LG_REVERSED_BY
     */
    public void setLG_REVERSED_BY(String LG_REVERSED_BY) {
        this.LG_REVERSED_BY = LG_REVERSED_BY == null ? null : LG_REVERSED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMENDED_FC_AMOUNT
     *
     * @return the value of TFSLG_TEMP.AMENDED_FC_AMOUNT
     */
    public BigDecimal getAMENDED_FC_AMOUNT() {
        return AMENDED_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMENDED_FC_AMOUNT
     *
     * @param AMENDED_FC_AMOUNT the value for TFSLG_TEMP.AMENDED_FC_AMOUNT
     */
    public void setAMENDED_FC_AMOUNT(BigDecimal AMENDED_FC_AMOUNT) {
        this.AMENDED_FC_AMOUNT = AMENDED_FC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMENDED_CV_AMOUNT
     *
     * @return the value of TFSLG_TEMP.AMENDED_CV_AMOUNT
     */
    public BigDecimal getAMENDED_CV_AMOUNT() {
        return AMENDED_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMENDED_CV_AMOUNT
     *
     * @param AMENDED_CV_AMOUNT the value for TFSLG_TEMP.AMENDED_CV_AMOUNT
     */
    public void setAMENDED_CV_AMOUNT(BigDecimal AMENDED_CV_AMOUNT) {
        this.AMENDED_CV_AMOUNT = AMENDED_CV_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMENDED_VALID_FROM_DATE
     *
     * @return the value of TFSLG_TEMP.AMENDED_VALID_FROM_DATE
     */
    public Date getAMENDED_VALID_FROM_DATE() {
        return AMENDED_VALID_FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMENDED_VALID_FROM_DATE
     *
     * @param AMENDED_VALID_FROM_DATE the value for TFSLG_TEMP.AMENDED_VALID_FROM_DATE
     */
    public void setAMENDED_VALID_FROM_DATE(Date AMENDED_VALID_FROM_DATE) {
        this.AMENDED_VALID_FROM_DATE = AMENDED_VALID_FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AMENDED_VALID_TO_DATE
     *
     * @return the value of TFSLG_TEMP.AMENDED_VALID_TO_DATE
     */
    public Date getAMENDED_VALID_TO_DATE() {
        return AMENDED_VALID_TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AMENDED_VALID_TO_DATE
     *
     * @param AMENDED_VALID_TO_DATE the value for TFSLG_TEMP.AMENDED_VALID_TO_DATE
     */
    public void setAMENDED_VALID_TO_DATE(Date AMENDED_VALID_TO_DATE) {
        this.AMENDED_VALID_TO_DATE = AMENDED_VALID_TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_CIF
     *
     * @return the value of TFSLG_TEMP.BENEF_CIF
     */
    public BigDecimal getBENEF_CIF() {
        return BENEF_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_CIF
     *
     * @param BENEF_CIF the value for TFSLG_TEMP.BENEF_CIF
     */
    public void setBENEF_CIF(BigDecimal BENEF_CIF) {
        this.BENEF_CIF = BENEF_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_COUNTRY
     *
     * @return the value of TFSLG_TEMP.BENEF_COUNTRY
     */
    public BigDecimal getBENEF_COUNTRY() {
        return BENEF_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_COUNTRY
     *
     * @param BENEF_COUNTRY the value for TFSLG_TEMP.BENEF_COUNTRY
     */
    public void setBENEF_COUNTRY(BigDecimal BENEF_COUNTRY) {
        this.BENEF_COUNTRY = BENEF_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CGUAR_EXP_DATE
     *
     * @return the value of TFSLG_TEMP.CGUAR_EXP_DATE
     */
    public Date getCGUAR_EXP_DATE() {
        return CGUAR_EXP_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CGUAR_EXP_DATE
     *
     * @param CGUAR_EXP_DATE the value for TFSLG_TEMP.CGUAR_EXP_DATE
     */
    public void setCGUAR_EXP_DATE(Date CGUAR_EXP_DATE) {
        this.CGUAR_EXP_DATE = CGUAR_EXP_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PAYMENT_AMOUNT
     *
     * @return the value of TFSLG_TEMP.PAYMENT_AMOUNT
     */
    public BigDecimal getPAYMENT_AMOUNT() {
        return PAYMENT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PAYMENT_AMOUNT
     *
     * @param PAYMENT_AMOUNT the value for TFSLG_TEMP.PAYMENT_AMOUNT
     */
    public void setPAYMENT_AMOUNT(BigDecimal PAYMENT_AMOUNT) {
        this.PAYMENT_AMOUNT = PAYMENT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CASH_FINANCE
     *
     * @return the value of TFSLG_TEMP.CASH_FINANCE
     */
    public String getCASH_FINANCE() {
        return CASH_FINANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CASH_FINANCE
     *
     * @param CASH_FINANCE the value for TFSLG_TEMP.CASH_FINANCE
     */
    public void setCASH_FINANCE(String CASH_FINANCE) {
        this.CASH_FINANCE = CASH_FINANCE == null ? null : CASH_FINANCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CROSS_CURRENCY
     *
     * @return the value of TFSLG_TEMP.CROSS_CURRENCY
     */
    public String getCROSS_CURRENCY() {
        return CROSS_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CROSS_CURRENCY
     *
     * @param CROSS_CURRENCY the value for TFSLG_TEMP.CROSS_CURRENCY
     */
    public void setCROSS_CURRENCY(String CROSS_CURRENCY) {
        this.CROSS_CURRENCY = CROSS_CURRENCY == null ? null : CROSS_CURRENCY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SETTLE_IND
     *
     * @return the value of TFSLG_TEMP.SETTLE_IND
     */
    public BigDecimal getSETTLE_IND() {
        return SETTLE_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SETTLE_IND
     *
     * @param SETTLE_IND the value for TFSLG_TEMP.SETTLE_IND
     */
    public void setSETTLE_IND(BigDecimal SETTLE_IND) {
        this.SETTLE_IND = SETTLE_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.INSURANCE_COMP
     *
     * @return the value of TFSLG_TEMP.INSURANCE_COMP
     */
    public BigDecimal getINSURANCE_COMP() {
        return INSURANCE_COMP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.INSURANCE_COMP
     *
     * @param INSURANCE_COMP the value for TFSLG_TEMP.INSURANCE_COMP
     */
    public void setINSURANCE_COMP(BigDecimal INSURANCE_COMP) {
        this.INSURANCE_COMP = INSURANCE_COMP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TEMPLATE_CODE
     *
     * @return the value of TFSLG_TEMP.TEMPLATE_CODE
     */
    public BigDecimal getTEMPLATE_CODE() {
        return TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TEMPLATE_CODE
     *
     * @param TEMPLATE_CODE the value for TFSLG_TEMP.TEMPLATE_CODE
     */
    public void setTEMPLATE_CODE(BigDecimal TEMPLATE_CODE) {
        this.TEMPLATE_CODE = TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_TYPE_DESC
     *
     * @return the value of TFSLG_TEMP.LG_TYPE_DESC
     */
    public String getLG_TYPE_DESC() {
        return LG_TYPE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_TYPE_DESC
     *
     * @param LG_TYPE_DESC the value for TFSLG_TEMP.LG_TYPE_DESC
     */
    public void setLG_TYPE_DESC(String LG_TYPE_DESC) {
        this.LG_TYPE_DESC = LG_TYPE_DESC == null ? null : LG_TYPE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APPLICANT_CIF
     *
     * @return the value of TFSLG_TEMP.APPLICANT_CIF
     */
    public BigDecimal getAPPLICANT_CIF() {
        return APPLICANT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APPLICANT_CIF
     *
     * @param APPLICANT_CIF the value for TFSLG_TEMP.APPLICANT_CIF
     */
    public void setAPPLICANT_CIF(BigDecimal APPLICANT_CIF) {
        this.APPLICANT_CIF = APPLICANT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APPLICANT_NAME
     *
     * @return the value of TFSLG_TEMP.APPLICANT_NAME
     */
    public String getAPPLICANT_NAME() {
        return APPLICANT_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APPLICANT_NAME
     *
     * @param APPLICANT_NAME the value for TFSLG_TEMP.APPLICANT_NAME
     */
    public void setAPPLICANT_NAME(String APPLICANT_NAME) {
        this.APPLICANT_NAME = APPLICANT_NAME == null ? null : APPLICANT_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MARGIN_REQUIRED
     *
     * @return the value of TFSLG_TEMP.MARGIN_REQUIRED
     */
    public BigDecimal getMARGIN_REQUIRED() {
        return MARGIN_REQUIRED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MARGIN_REQUIRED
     *
     * @param MARGIN_REQUIRED the value for TFSLG_TEMP.MARGIN_REQUIRED
     */
    public void setMARGIN_REQUIRED(BigDecimal MARGIN_REQUIRED) {
        this.MARGIN_REQUIRED = MARGIN_REQUIRED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MARGIN_AMOUNT
     *
     * @return the value of TFSLG_TEMP.MARGIN_AMOUNT
     */
    public BigDecimal getMARGIN_AMOUNT() {
        return MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MARGIN_AMOUNT
     *
     * @param MARGIN_AMOUNT the value for TFSLG_TEMP.MARGIN_AMOUNT
     */
    public void setMARGIN_AMOUNT(BigDecimal MARGIN_AMOUNT) {
        this.MARGIN_AMOUNT = MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_GL
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_ACC_GL
     */
    public BigDecimal getAUTO_MARGIN_ACC_GL() {
        return AUTO_MARGIN_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_GL
     *
     * @param AUTO_MARGIN_ACC_GL the value for TFSLG_TEMP.AUTO_MARGIN_ACC_GL
     */
    public void setAUTO_MARGIN_ACC_GL(BigDecimal AUTO_MARGIN_ACC_GL) {
        this.AUTO_MARGIN_ACC_GL = AUTO_MARGIN_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CIF
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_ACC_CIF
     */
    public BigDecimal getAUTO_MARGIN_ACC_CIF() {
        return AUTO_MARGIN_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CIF
     *
     * @param AUTO_MARGIN_ACC_CIF the value for TFSLG_TEMP.AUTO_MARGIN_ACC_CIF
     */
    public void setAUTO_MARGIN_ACC_CIF(BigDecimal AUTO_MARGIN_ACC_CIF) {
        this.AUTO_MARGIN_ACC_CIF = AUTO_MARGIN_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_SL
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_ACC_SL
     */
    public BigDecimal getAUTO_MARGIN_ACC_SL() {
        return AUTO_MARGIN_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_SL
     *
     * @param AUTO_MARGIN_ACC_SL the value for TFSLG_TEMP.AUTO_MARGIN_ACC_SL
     */
    public void setAUTO_MARGIN_ACC_SL(BigDecimal AUTO_MARGIN_ACC_SL) {
        this.AUTO_MARGIN_ACC_SL = AUTO_MARGIN_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_DATE
     */
    public Date getBENEF_LETTER_DATE() {
        return BENEF_LETTER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE
     *
     * @param BENEF_LETTER_DATE the value for TFSLG_TEMP.BENEF_LETTER_DATE
     */
    public void setBENEF_LETTER_DATE(Date BENEF_LETTER_DATE) {
        this.BENEF_LETTER_DATE = BENEF_LETTER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE_AR
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_DATE_AR
     */
    public Date getBENEF_LETTER_DATE_AR() {
        return BENEF_LETTER_DATE_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE_AR
     *
     * @param BENEF_LETTER_DATE_AR the value for TFSLG_TEMP.BENEF_LETTER_DATE_AR
     */
    public void setBENEF_LETTER_DATE_AR(Date BENEF_LETTER_DATE_AR) {
        this.BENEF_LETTER_DATE_AR = BENEF_LETTER_DATE_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE_EXP
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_DATE_EXP
     */
    public Date getBENEF_LETTER_DATE_EXP() {
        return BENEF_LETTER_DATE_EXP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_DATE_EXP
     *
     * @param BENEF_LETTER_DATE_EXP the value for TFSLG_TEMP.BENEF_LETTER_DATE_EXP
     */
    public void setBENEF_LETTER_DATE_EXP(Date BENEF_LETTER_DATE_EXP) {
        this.BENEF_LETTER_DATE_EXP = BENEF_LETTER_DATE_EXP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_DETAILS
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_DETAILS
     */
    public String getBENEF_LETTER_DETAILS() {
        return BENEF_LETTER_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_DETAILS
     *
     * @param BENEF_LETTER_DETAILS the value for TFSLG_TEMP.BENEF_LETTER_DETAILS
     */
    public void setBENEF_LETTER_DETAILS(String BENEF_LETTER_DETAILS) {
        this.BENEF_LETTER_DETAILS = BENEF_LETTER_DETAILS == null ? null : BENEF_LETTER_DETAILS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_CHK
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_CHK
     */
    public BigDecimal getBENEF_LETTER_CHK() {
        return BENEF_LETTER_CHK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_CHK
     *
     * @param BENEF_LETTER_CHK the value for TFSLG_TEMP.BENEF_LETTER_CHK
     */
    public void setBENEF_LETTER_CHK(BigDecimal BENEF_LETTER_CHK) {
        this.BENEF_LETTER_CHK = BENEF_LETTER_CHK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_CIF
     *
     * @return the value of TFSLG_TEMP.COUNTER_GUARANTEE_CIF
     */
    public BigDecimal getCOUNTER_GUARANTEE_CIF() {
        return COUNTER_GUARANTEE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_CIF
     *
     * @param COUNTER_GUARANTEE_CIF the value for TFSLG_TEMP.COUNTER_GUARANTEE_CIF
     */
    public void setCOUNTER_GUARANTEE_CIF(BigDecimal COUNTER_GUARANTEE_CIF) {
        this.COUNTER_GUARANTEE_CIF = COUNTER_GUARANTEE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_NAME
     *
     * @return the value of TFSLG_TEMP.COUNTER_GUARANTEE_NAME
     */
    public String getCOUNTER_GUARANTEE_NAME() {
        return COUNTER_GUARANTEE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_NAME
     *
     * @param COUNTER_GUARANTEE_NAME the value for TFSLG_TEMP.COUNTER_GUARANTEE_NAME
     */
    public void setCOUNTER_GUARANTEE_NAME(String COUNTER_GUARANTEE_NAME) {
        this.COUNTER_GUARANTEE_NAME = COUNTER_GUARANTEE_NAME == null ? null : COUNTER_GUARANTEE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_NUMBER
     *
     * @return the value of TFSLG_TEMP.COUNTER_GUARANTEE_NUMBER
     */
    public String getCOUNTER_GUARANTEE_NUMBER() {
        return COUNTER_GUARANTEE_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COUNTER_GUARANTEE_NUMBER
     *
     * @param COUNTER_GUARANTEE_NUMBER the value for TFSLG_TEMP.COUNTER_GUARANTEE_NUMBER
     */
    public void setCOUNTER_GUARANTEE_NUMBER(String COUNTER_GUARANTEE_NUMBER) {
        this.COUNTER_GUARANTEE_NUMBER = COUNTER_GUARANTEE_NUMBER == null ? null : COUNTER_GUARANTEE_NUMBER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_CY
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_CY
     */
    public BigDecimal getBENEFICIARY_CY() {
        return BENEFICIARY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_CY
     *
     * @param BENEFICIARY_CY the value for TFSLG_TEMP.BENEFICIARY_CY
     */
    public void setBENEFICIARY_CY(BigDecimal BENEFICIARY_CY) {
        this.BENEFICIARY_CY = BENEFICIARY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_ACC_CY
     *
     * @return the value of TFSLG_TEMP.FUNDING_ACC_CY
     */
    public BigDecimal getFUNDING_ACC_CY() {
        return FUNDING_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_ACC_CY
     *
     * @param FUNDING_ACC_CY the value for TFSLG_TEMP.FUNDING_ACC_CY
     */
    public void setFUNDING_ACC_CY(BigDecimal FUNDING_ACC_CY) {
        this.FUNDING_ACC_CY = FUNDING_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUSPENSE_CY
     *
     * @return the value of TFSLG_TEMP.SUSPENSE_CY
     */
    public BigDecimal getSUSPENSE_CY() {
        return SUSPENSE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUSPENSE_CY
     *
     * @param SUSPENSE_CY the value for TFSLG_TEMP.SUSPENSE_CY
     */
    public void setSUSPENSE_CY(BigDecimal SUSPENSE_CY) {
        this.SUSPENSE_CY = SUSPENSE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_CY
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_CY
     */
    public BigDecimal getNOSTRO_MARGIN_CY() {
        return NOSTRO_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_CY
     *
     * @param NOSTRO_MARGIN_CY the value for TFSLG_TEMP.NOSTRO_MARGIN_CY
     */
    public void setNOSTRO_MARGIN_CY(BigDecimal NOSTRO_MARGIN_CY) {
        this.NOSTRO_MARGIN_CY = NOSTRO_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_GL
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_GL
     */
    public BigDecimal getNOSTRO_MARGIN_GL() {
        return NOSTRO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_GL
     *
     * @param NOSTRO_MARGIN_GL the value for TFSLG_TEMP.NOSTRO_MARGIN_GL
     */
    public void setNOSTRO_MARGIN_GL(BigDecimal NOSTRO_MARGIN_GL) {
        this.NOSTRO_MARGIN_GL = NOSTRO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_CIF
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_CIF
     */
    public BigDecimal getNOSTRO_MARGIN_CIF() {
        return NOSTRO_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_CIF
     *
     * @param NOSTRO_MARGIN_CIF the value for TFSLG_TEMP.NOSTRO_MARGIN_CIF
     */
    public void setNOSTRO_MARGIN_CIF(BigDecimal NOSTRO_MARGIN_CIF) {
        this.NOSTRO_MARGIN_CIF = NOSTRO_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_SL
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_SL
     */
    public BigDecimal getNOSTRO_MARGIN_SL() {
        return NOSTRO_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_SL
     *
     * @param NOSTRO_MARGIN_SL the value for TFSLG_TEMP.NOSTRO_MARGIN_SL
     */
    public void setNOSTRO_MARGIN_SL(BigDecimal NOSTRO_MARGIN_SL) {
        this.NOSTRO_MARGIN_SL = NOSTRO_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CY
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_ACC_CY
     */
    public BigDecimal getAUTO_MARGIN_ACC_CY() {
        return AUTO_MARGIN_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_CY
     *
     * @param AUTO_MARGIN_ACC_CY the value for TFSLG_TEMP.AUTO_MARGIN_ACC_CY
     */
    public void setAUTO_MARGIN_ACC_CY(BigDecimal AUTO_MARGIN_ACC_CY) {
        this.AUTO_MARGIN_ACC_CY = AUTO_MARGIN_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.ENABLE_ARABIC
     *
     * @return the value of TFSLG_TEMP.ENABLE_ARABIC
     */
    public String getENABLE_ARABIC() {
        return ENABLE_ARABIC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.ENABLE_ARABIC
     *
     * @param ENABLE_ARABIC the value for TFSLG_TEMP.ENABLE_ARABIC
     */
    public void setENABLE_ARABIC(String ENABLE_ARABIC) {
        this.ENABLE_ARABIC = ENABLE_ARABIC == null ? null : ENABLE_ARABIC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER1
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER1
     */
    public String getSENDER_TO_RECIEVER1() {
        return SENDER_TO_RECIEVER1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER1
     *
     * @param SENDER_TO_RECIEVER1 the value for TFSLG_TEMP.SENDER_TO_RECIEVER1
     */
    public void setSENDER_TO_RECIEVER1(String SENDER_TO_RECIEVER1) {
        this.SENDER_TO_RECIEVER1 = SENDER_TO_RECIEVER1 == null ? null : SENDER_TO_RECIEVER1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER2
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER2
     */
    public String getSENDER_TO_RECIEVER2() {
        return SENDER_TO_RECIEVER2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER2
     *
     * @param SENDER_TO_RECIEVER2 the value for TFSLG_TEMP.SENDER_TO_RECIEVER2
     */
    public void setSENDER_TO_RECIEVER2(String SENDER_TO_RECIEVER2) {
        this.SENDER_TO_RECIEVER2 = SENDER_TO_RECIEVER2 == null ? null : SENDER_TO_RECIEVER2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_BIC_CODE
     *
     * @return the value of TFSLG_TEMP.BENEF_BIC_CODE
     */
    public String getBENEF_BIC_CODE() {
        return BENEF_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_BIC_CODE
     *
     * @param BENEF_BIC_CODE the value for TFSLG_TEMP.BENEF_BIC_CODE
     */
    public void setBENEF_BIC_CODE(String BENEF_BIC_CODE) {
        this.BENEF_BIC_CODE = BENEF_BIC_CODE == null ? null : BENEF_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APPLICANT_BIC_CODE
     *
     * @return the value of TFSLG_TEMP.APPLICANT_BIC_CODE
     */
    public String getAPPLICANT_BIC_CODE() {
        return APPLICANT_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APPLICANT_BIC_CODE
     *
     * @param APPLICANT_BIC_CODE the value for TFSLG_TEMP.APPLICANT_BIC_CODE
     */
    public void setAPPLICANT_BIC_CODE(String APPLICANT_BIC_CODE) {
        this.APPLICANT_BIC_CODE = APPLICANT_BIC_CODE == null ? null : APPLICANT_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FACILITY_CLASS
     *
     * @return the value of TFSLG_TEMP.FACILITY_CLASS
     */
    public BigDecimal getFACILITY_CLASS() {
        return FACILITY_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FACILITY_CLASS
     *
     * @param FACILITY_CLASS the value for TFSLG_TEMP.FACILITY_CLASS
     */
    public void setFACILITY_CLASS(BigDecimal FACILITY_CLASS) {
        this.FACILITY_CLASS = FACILITY_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_BR
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_BR
     */
    public BigDecimal getBENEFICIARY_BR() {
        return BENEFICIARY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_BR
     *
     * @param BENEFICIARY_BR the value for TFSLG_TEMP.BENEFICIARY_BR
     */
    public void setBENEFICIARY_BR(BigDecimal BENEFICIARY_BR) {
        this.BENEFICIARY_BR = BENEFICIARY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FUNDING_ACC_BR
     *
     * @return the value of TFSLG_TEMP.FUNDING_ACC_BR
     */
    public BigDecimal getFUNDING_ACC_BR() {
        return FUNDING_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FUNDING_ACC_BR
     *
     * @param FUNDING_ACC_BR the value for TFSLG_TEMP.FUNDING_ACC_BR
     */
    public void setFUNDING_ACC_BR(BigDecimal FUNDING_ACC_BR) {
        this.FUNDING_ACC_BR = FUNDING_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUSPENSE_BR
     *
     * @return the value of TFSLG_TEMP.SUSPENSE_BR
     */
    public BigDecimal getSUSPENSE_BR() {
        return SUSPENSE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUSPENSE_BR
     *
     * @param SUSPENSE_BR the value for TFSLG_TEMP.SUSPENSE_BR
     */
    public void setSUSPENSE_BR(BigDecimal SUSPENSE_BR) {
        this.SUSPENSE_BR = SUSPENSE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TOTAL_MARGIN_AMOUNT
     *
     * @return the value of TFSLG_TEMP.TOTAL_MARGIN_AMOUNT
     */
    public BigDecimal getTOTAL_MARGIN_AMOUNT() {
        return TOTAL_MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TOTAL_MARGIN_AMOUNT
     *
     * @param TOTAL_MARGIN_AMOUNT the value for TFSLG_TEMP.TOTAL_MARGIN_AMOUNT
     */
    public void setTOTAL_MARGIN_AMOUNT(BigDecimal TOTAL_MARGIN_AMOUNT) {
        this.TOTAL_MARGIN_AMOUNT = TOTAL_MARGIN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN
     */
    public String getAUTO_MARGIN() {
        return AUTO_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN
     *
     * @param AUTO_MARGIN the value for TFSLG_TEMP.AUTO_MARGIN
     */
    public void setAUTO_MARGIN(String AUTO_MARGIN) {
        this.AUTO_MARGIN = AUTO_MARGIN == null ? null : AUTO_MARGIN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TEMP_ALI
     *
     * @return the value of TFSLG_TEMP.TEMP_ALI
     */
    public String getTEMP_ALI() {
        return TEMP_ALI;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TEMP_ALI
     *
     * @param TEMP_ALI the value for TFSLG_TEMP.TEMP_ALI
     */
    public void setTEMP_ALI(String TEMP_ALI) {
        this.TEMP_ALI = TEMP_ALI == null ? null : TEMP_ALI.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REASON_OF_CLOSURE
     *
     * @return the value of TFSLG_TEMP.REASON_OF_CLOSURE
     */
    public String getREASON_OF_CLOSURE() {
        return REASON_OF_CLOSURE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REASON_OF_CLOSURE
     *
     * @param REASON_OF_CLOSURE the value for TFSLG_TEMP.REASON_OF_CLOSURE
     */
    public void setREASON_OF_CLOSURE(String REASON_OF_CLOSURE) {
        this.REASON_OF_CLOSURE = REASON_OF_CLOSURE == null ? null : REASON_OF_CLOSURE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_LETTER_NBR
     *
     * @return the value of TFSLG_TEMP.BENEF_LETTER_NBR
     */
    public String getBENEF_LETTER_NBR() {
        return BENEF_LETTER_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_LETTER_NBR
     *
     * @param BENEF_LETTER_NBR the value for TFSLG_TEMP.BENEF_LETTER_NBR
     */
    public void setBENEF_LETTER_NBR(String BENEF_LETTER_NBR) {
        this.BENEF_LETTER_NBR = BENEF_LETTER_NBR == null ? null : BENEF_LETTER_NBR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_AUTO_MARGIN
     *
     * @return the value of TFSLG_TEMP.CLOSED_AUTO_MARGIN
     */
    public BigDecimal getCLOSED_AUTO_MARGIN() {
        return CLOSED_AUTO_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_AUTO_MARGIN
     *
     * @param CLOSED_AUTO_MARGIN the value for TFSLG_TEMP.CLOSED_AUTO_MARGIN
     */
    public void setCLOSED_AUTO_MARGIN(BigDecimal CLOSED_AUTO_MARGIN) {
        this.CLOSED_AUTO_MARGIN = CLOSED_AUTO_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE_ADDRESS
     *
     * @return the value of TFSLG_TEMP.BENEFICIARY_ULTIMATE_ADDRESS
     */
    public String getBENEFICIARY_ULTIMATE_ADDRESS() {
        return BENEFICIARY_ULTIMATE_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEFICIARY_ULTIMATE_ADDRESS
     *
     * @param BENEFICIARY_ULTIMATE_ADDRESS the value for TFSLG_TEMP.BENEFICIARY_ULTIMATE_ADDRESS
     */
    public void setBENEFICIARY_ULTIMATE_ADDRESS(String BENEFICIARY_ULTIMATE_ADDRESS) {
        this.BENEFICIARY_ULTIMATE_ADDRESS = BENEFICIARY_ULTIMATE_ADDRESS == null ? null : BENEFICIARY_ULTIMATE_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.INFO
     *
     * @return the value of TFSLG_TEMP.INFO
     */
    public String getINFO() {
        return INFO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.INFO
     *
     * @param INFO the value for TFSLG_TEMP.INFO
     */
    public void setINFO(String INFO) {
        this.INFO = INFO == null ? null : INFO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FACILITY_BR
     *
     * @return the value of TFSLG_TEMP.FACILITY_BR
     */
    public BigDecimal getFACILITY_BR() {
        return FACILITY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FACILITY_BR
     *
     * @param FACILITY_BR the value for TFSLG_TEMP.FACILITY_BR
     */
    public void setFACILITY_BR(BigDecimal FACILITY_BR) {
        this.FACILITY_BR = FACILITY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MARGIN_AMT_CY2
     *
     * @return the value of TFSLG_TEMP.MARGIN_AMT_CY2
     */
    public BigDecimal getMARGIN_AMT_CY2() {
        return MARGIN_AMT_CY2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MARGIN_AMT_CY2
     *
     * @param MARGIN_AMT_CY2 the value for TFSLG_TEMP.MARGIN_AMT_CY2
     */
    public void setMARGIN_AMT_CY2(BigDecimal MARGIN_AMT_CY2) {
        this.MARGIN_AMT_CY2 = MARGIN_AMT_CY2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CROSS_RATE
     *
     * @return the value of TFSLG_TEMP.CROSS_RATE
     */
    public BigDecimal getCROSS_RATE() {
        return CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CROSS_RATE
     *
     * @param CROSS_RATE the value for TFSLG_TEMP.CROSS_RATE
     */
    public void setCROSS_RATE(BigDecimal CROSS_RATE) {
        this.CROSS_RATE = CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CROSS_MULT_DIV
     *
     * @return the value of TFSLG_TEMP.CROSS_MULT_DIV
     */
    public String getCROSS_MULT_DIV() {
        return CROSS_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CROSS_MULT_DIV
     *
     * @param CROSS_MULT_DIV the value for TFSLG_TEMP.CROSS_MULT_DIV
     */
    public void setCROSS_MULT_DIV(String CROSS_MULT_DIV) {
        this.CROSS_MULT_DIV = CROSS_MULT_DIV == null ? null : CROSS_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_RATE
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_RATE
     */
    public BigDecimal getNOSTRO_MARGIN_RATE() {
        return NOSTRO_MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_RATE
     *
     * @param NOSTRO_MARGIN_RATE the value for TFSLG_TEMP.NOSTRO_MARGIN_RATE
     */
    public void setNOSTRO_MARGIN_RATE(BigDecimal NOSTRO_MARGIN_RATE) {
        this.NOSTRO_MARGIN_RATE = NOSTRO_MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_RATE
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_RATE
     */
    public BigDecimal getAUTO_MARGIN_RATE() {
        return AUTO_MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_RATE
     *
     * @param AUTO_MARGIN_RATE the value for TFSLG_TEMP.AUTO_MARGIN_RATE
     */
    public void setAUTO_MARGIN_RATE(BigDecimal AUTO_MARGIN_RATE) {
        this.AUTO_MARGIN_RATE = AUTO_MARGIN_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_SUSPENSE
     *
     * @return the value of TFSLG_TEMP.CLOSED_SUSPENSE
     */
    public BigDecimal getCLOSED_SUSPENSE() {
        return CLOSED_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_SUSPENSE
     *
     * @param CLOSED_SUSPENSE the value for TFSLG_TEMP.CLOSED_SUSPENSE
     */
    public void setCLOSED_SUSPENSE(BigDecimal CLOSED_SUSPENSE) {
        this.CLOSED_SUSPENSE = CLOSED_SUSPENSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_SUSPENSE_CV
     *
     * @return the value of TFSLG_TEMP.CLOSED_SUSPENSE_CV
     */
    public BigDecimal getCLOSED_SUSPENSE_CV() {
        return CLOSED_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_SUSPENSE_CV
     *
     * @param CLOSED_SUSPENSE_CV the value for TFSLG_TEMP.CLOSED_SUSPENSE_CV
     */
    public void setCLOSED_SUSPENSE_CV(BigDecimal CLOSED_SUSPENSE_CV) {
        this.CLOSED_SUSPENSE_CV = CLOSED_SUSPENSE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_MODIFIED_BY
     *
     * @return the value of TFSLG_TEMP.LG_MODIFIED_BY
     */
    public String getLG_MODIFIED_BY() {
        return LG_MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_MODIFIED_BY
     *
     * @param LG_MODIFIED_BY the value for TFSLG_TEMP.LG_MODIFIED_BY
     */
    public void setLG_MODIFIED_BY(String LG_MODIFIED_BY) {
        this.LG_MODIFIED_BY = LG_MODIFIED_BY == null ? null : LG_MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_MODIFIED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_MODIFIED
     */
    public Date getLG_DATE_MODIFIED() {
        return LG_DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_MODIFIED
     *
     * @param LG_DATE_MODIFIED the value for TFSLG_TEMP.LG_DATE_MODIFIED
     */
    public void setLG_DATE_MODIFIED(Date LG_DATE_MODIFIED) {
        this.LG_DATE_MODIFIED = LG_DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FMS_MARGIN_PERCENT
     *
     * @return the value of TFSLG_TEMP.FMS_MARGIN_PERCENT
     */
    public BigDecimal getFMS_MARGIN_PERCENT() {
        return FMS_MARGIN_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FMS_MARGIN_PERCENT
     *
     * @param FMS_MARGIN_PERCENT the value for TFSLG_TEMP.FMS_MARGIN_PERCENT
     */
    public void setFMS_MARGIN_PERCENT(BigDecimal FMS_MARGIN_PERCENT) {
        this.FMS_MARGIN_PERCENT = FMS_MARGIN_PERCENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DOC_NUMBER
     *
     * @return the value of TFSLG_TEMP.DOC_NUMBER
     */
    public BigDecimal getDOC_NUMBER() {
        return DOC_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DOC_NUMBER
     *
     * @param DOC_NUMBER the value for TFSLG_TEMP.DOC_NUMBER
     */
    public void setDOC_NUMBER(BigDecimal DOC_NUMBER) {
        this.DOC_NUMBER = DOC_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DOC_YEAR
     *
     * @return the value of TFSLG_TEMP.DOC_YEAR
     */
    public BigDecimal getDOC_YEAR() {
        return DOC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DOC_YEAR
     *
     * @param DOC_YEAR the value for TFSLG_TEMP.DOC_YEAR
     */
    public void setDOC_YEAR(BigDecimal DOC_YEAR) {
        this.DOC_YEAR = DOC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APPLICANT_BIC_CODE1
     *
     * @return the value of TFSLG_TEMP.APPLICANT_BIC_CODE1
     */
    public String getAPPLICANT_BIC_CODE1() {
        return APPLICANT_BIC_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APPLICANT_BIC_CODE1
     *
     * @param APPLICANT_BIC_CODE1 the value for TFSLG_TEMP.APPLICANT_BIC_CODE1
     */
    public void setAPPLICANT_BIC_CODE1(String APPLICANT_BIC_CODE1) {
        this.APPLICANT_BIC_CODE1 = APPLICANT_BIC_CODE1 == null ? null : APPLICANT_BIC_CODE1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_BIC_CODE1
     *
     * @return the value of TFSLG_TEMP.BENEF_BIC_CODE1
     */
    public String getBENEF_BIC_CODE1() {
        return BENEF_BIC_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_BIC_CODE1
     *
     * @param BENEF_BIC_CODE1 the value for TFSLG_TEMP.BENEF_BIC_CODE1
     */
    public void setBENEF_BIC_CODE1(String BENEF_BIC_CODE1) {
        this.BENEF_BIC_CODE1 = BENEF_BIC_CODE1 == null ? null : BENEF_BIC_CODE1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BENEF_NAME1
     *
     * @return the value of TFSLG_TEMP.BENEF_NAME1
     */
    public String getBENEF_NAME1() {
        return BENEF_NAME1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BENEF_NAME1
     *
     * @param BENEF_NAME1 the value for TFSLG_TEMP.BENEF_NAME1
     */
    public void setBENEF_NAME1(String BENEF_NAME1) {
        this.BENEF_NAME1 = BENEF_NAME1 == null ? null : BENEF_NAME1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APP_NAME1
     *
     * @return the value of TFSLG_TEMP.APP_NAME1
     */
    public String getAPP_NAME1() {
        return APP_NAME1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APP_NAME1
     *
     * @param APP_NAME1 the value for TFSLG_TEMP.APP_NAME1
     */
    public void setAPP_NAME1(String APP_NAME1) {
        this.APP_NAME1 = APP_NAME1 == null ? null : APP_NAME1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TYPE_OF_ISSUE
     *
     * @return the value of TFSLG_TEMP.TYPE_OF_ISSUE
     */
    public String getTYPE_OF_ISSUE() {
        return TYPE_OF_ISSUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TYPE_OF_ISSUE
     *
     * @param TYPE_OF_ISSUE the value for TFSLG_TEMP.TYPE_OF_ISSUE
     */
    public void setTYPE_OF_ISSUE(String TYPE_OF_ISSUE) {
        this.TYPE_OF_ISSUE = TYPE_OF_ISSUE == null ? null : TYPE_OF_ISSUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.FURTHER_ID
     *
     * @return the value of TFSLG_TEMP.FURTHER_ID
     */
    public String getFURTHER_ID() {
        return FURTHER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.FURTHER_ID
     *
     * @param FURTHER_ID the value for TFSLG_TEMP.FURTHER_ID
     */
    public void setFURTHER_ID(String FURTHER_ID) {
        this.FURTHER_ID = FURTHER_ID == null ? null : FURTHER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.APP_RULES
     *
     * @return the value of TFSLG_TEMP.APP_RULES
     */
    public String getAPP_RULES() {
        return APP_RULES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.APP_RULES
     *
     * @param APP_RULES the value for TFSLG_TEMP.APP_RULES
     */
    public void setAPP_RULES(String APP_RULES) {
        this.APP_RULES = APP_RULES == null ? null : APP_RULES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_RENEW
     *
     * @return the value of TFSLG_TEMP.AUTO_RENEW
     */
    public String getAUTO_RENEW() {
        return AUTO_RENEW;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_RENEW
     *
     * @param AUTO_RENEW the value for TFSLG_TEMP.AUTO_RENEW
     */
    public void setAUTO_RENEW(String AUTO_RENEW) {
        this.AUTO_RENEW = AUTO_RENEW == null ? null : AUTO_RENEW.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DD_CROSS_RATE
     *
     * @return the value of TFSLG_TEMP.DD_CROSS_RATE
     */
    public BigDecimal getDD_CROSS_RATE() {
        return DD_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DD_CROSS_RATE
     *
     * @param DD_CROSS_RATE the value for TFSLG_TEMP.DD_CROSS_RATE
     */
    public void setDD_CROSS_RATE(BigDecimal DD_CROSS_RATE) {
        this.DD_CROSS_RATE = DD_CROSS_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DYNAMIC_REF
     *
     * @return the value of TFSLG_TEMP.DYNAMIC_REF
     */
    public String getDYNAMIC_REF() {
        return DYNAMIC_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DYNAMIC_REF
     *
     * @param DYNAMIC_REF the value for TFSLG_TEMP.DYNAMIC_REF
     */
    public void setDYNAMIC_REF(String DYNAMIC_REF) {
        this.DYNAMIC_REF = DYNAMIC_REF == null ? null : DYNAMIC_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SUBLIMIT_MARGIN
     *
     * @return the value of TFSLG_TEMP.SUBLIMIT_MARGIN
     */
    public BigDecimal getSUBLIMIT_MARGIN() {
        return SUBLIMIT_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SUBLIMIT_MARGIN
     *
     * @param SUBLIMIT_MARGIN the value for TFSLG_TEMP.SUBLIMIT_MARGIN
     */
    public void setSUBLIMIT_MARGIN(BigDecimal SUBLIMIT_MARGIN) {
        this.SUBLIMIT_MARGIN = SUBLIMIT_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXTNDD_EXPIRY_DTE
     *
     * @return the value of TFSLG_TEMP.EXTNDD_EXPIRY_DTE
     */
    public Date getEXTNDD_EXPIRY_DTE() {
        return EXTNDD_EXPIRY_DTE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXTNDD_EXPIRY_DTE
     *
     * @param EXTNDD_EXPIRY_DTE the value for TFSLG_TEMP.EXTNDD_EXPIRY_DTE
     */
    public void setEXTNDD_EXPIRY_DTE(Date EXTNDD_EXPIRY_DTE) {
        this.EXTNDD_EXPIRY_DTE = EXTNDD_EXPIRY_DTE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXPIRY_DTE
     *
     * @return the value of TFSLG_TEMP.EXPIRY_DTE
     */
    public Date getEXPIRY_DTE() {
        return EXPIRY_DTE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXPIRY_DTE
     *
     * @param EXPIRY_DTE the value for TFSLG_TEMP.EXPIRY_DTE
     */
    public void setEXPIRY_DTE(Date EXPIRY_DTE) {
        this.EXPIRY_DTE = EXPIRY_DTE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CLOSED_MARGIN_BS
     *
     * @return the value of TFSLG_TEMP.CLOSED_MARGIN_BS
     */
    public BigDecimal getCLOSED_MARGIN_BS() {
        return CLOSED_MARGIN_BS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CLOSED_MARGIN_BS
     *
     * @param CLOSED_MARGIN_BS the value for TFSLG_TEMP.CLOSED_MARGIN_BS
     */
    public void setCLOSED_MARGIN_BS(BigDecimal CLOSED_MARGIN_BS) {
        this.CLOSED_MARGIN_BS = CLOSED_MARGIN_BS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SHIPPING_GUARANTEE
     *
     * @return the value of TFSLG_TEMP.SHIPPING_GUARANTEE
     */
    public String getSHIPPING_GUARANTEE() {
        return SHIPPING_GUARANTEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SHIPPING_GUARANTEE
     *
     * @param SHIPPING_GUARANTEE the value for TFSLG_TEMP.SHIPPING_GUARANTEE
     */
    public void setSHIPPING_GUARANTEE(String SHIPPING_GUARANTEE) {
        this.SHIPPING_GUARANTEE = SHIPPING_GUARANTEE == null ? null : SHIPPING_GUARANTEE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SG_TYPE
     *
     * @return the value of TFSLG_TEMP.SG_TYPE
     */
    public String getSG_TYPE() {
        return SG_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SG_TYPE
     *
     * @param SG_TYPE the value for TFSLG_TEMP.SG_TYPE
     */
    public void setSG_TYPE(String SG_TYPE) {
        this.SG_TYPE = SG_TYPE == null ? null : SG_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SG_LINK_YEAR
     *
     * @return the value of TFSLG_TEMP.SG_LINK_YEAR
     */
    public BigDecimal getSG_LINK_YEAR() {
        return SG_LINK_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SG_LINK_YEAR
     *
     * @param SG_LINK_YEAR the value for TFSLG_TEMP.SG_LINK_YEAR
     */
    public void setSG_LINK_YEAR(BigDecimal SG_LINK_YEAR) {
        this.SG_LINK_YEAR = SG_LINK_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SG_LINK_NUMBER
     *
     * @return the value of TFSLG_TEMP.SG_LINK_NUMBER
     */
    public BigDecimal getSG_LINK_NUMBER() {
        return SG_LINK_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SG_LINK_NUMBER
     *
     * @param SG_LINK_NUMBER the value for TFSLG_TEMP.SG_LINK_NUMBER
     */
    public void setSG_LINK_NUMBER(BigDecimal SG_LINK_NUMBER) {
        this.SG_LINK_NUMBER = SG_LINK_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BILL_OF_LADING
     *
     * @return the value of TFSLG_TEMP.BILL_OF_LADING
     */
    public String getBILL_OF_LADING() {
        return BILL_OF_LADING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BILL_OF_LADING
     *
     * @param BILL_OF_LADING the value for TFSLG_TEMP.BILL_OF_LADING
     */
    public void setBILL_OF_LADING(String BILL_OF_LADING) {
        this.BILL_OF_LADING = BILL_OF_LADING == null ? null : BILL_OF_LADING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BILL_OF_LADING_PLACE
     *
     * @return the value of TFSLG_TEMP.BILL_OF_LADING_PLACE
     */
    public String getBILL_OF_LADING_PLACE() {
        return BILL_OF_LADING_PLACE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BILL_OF_LADING_PLACE
     *
     * @param BILL_OF_LADING_PLACE the value for TFSLG_TEMP.BILL_OF_LADING_PLACE
     */
    public void setBILL_OF_LADING_PLACE(String BILL_OF_LADING_PLACE) {
        this.BILL_OF_LADING_PLACE = BILL_OF_LADING_PLACE == null ? null : BILL_OF_LADING_PLACE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.BILL_OF_LADING_DATE
     *
     * @return the value of TFSLG_TEMP.BILL_OF_LADING_DATE
     */
    public Date getBILL_OF_LADING_DATE() {
        return BILL_OF_LADING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.BILL_OF_LADING_DATE
     *
     * @param BILL_OF_LADING_DATE the value for TFSLG_TEMP.BILL_OF_LADING_DATE
     */
    public void setBILL_OF_LADING_DATE(Date BILL_OF_LADING_DATE) {
        this.BILL_OF_LADING_DATE = BILL_OF_LADING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.INVOICE_NUMBER
     *
     * @return the value of TFSLG_TEMP.INVOICE_NUMBER
     */
    public String getINVOICE_NUMBER() {
        return INVOICE_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.INVOICE_NUMBER
     *
     * @param INVOICE_NUMBER the value for TFSLG_TEMP.INVOICE_NUMBER
     */
    public void setINVOICE_NUMBER(String INVOICE_NUMBER) {
        this.INVOICE_NUMBER = INVOICE_NUMBER == null ? null : INVOICE_NUMBER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VESSEL_NAME
     *
     * @return the value of TFSLG_TEMP.VESSEL_NAME
     */
    public String getVESSEL_NAME() {
        return VESSEL_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VESSEL_NAME
     *
     * @param VESSEL_NAME the value for TFSLG_TEMP.VESSEL_NAME
     */
    public void setVESSEL_NAME(String VESSEL_NAME) {
        this.VESSEL_NAME = VESSEL_NAME == null ? null : VESSEL_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VOYAGE_NBR
     *
     * @return the value of TFSLG_TEMP.VOYAGE_NBR
     */
    public String getVOYAGE_NBR() {
        return VOYAGE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VOYAGE_NBR
     *
     * @param VOYAGE_NBR the value for TFSLG_TEMP.VOYAGE_NBR
     */
    public void setVOYAGE_NBR(String VOYAGE_NBR) {
        this.VOYAGE_NBR = VOYAGE_NBR == null ? null : VOYAGE_NBR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.VESSEL_OWNER
     *
     * @return the value of TFSLG_TEMP.VESSEL_OWNER
     */
    public String getVESSEL_OWNER() {
        return VESSEL_OWNER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.VESSEL_OWNER
     *
     * @param VESSEL_OWNER the value for TFSLG_TEMP.VESSEL_OWNER
     */
    public void setVESSEL_OWNER(String VESSEL_OWNER) {
        this.VESSEL_OWNER = VESSEL_OWNER == null ? null : VESSEL_OWNER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SHIPPER_NAME
     *
     * @return the value of TFSLG_TEMP.SHIPPER_NAME
     */
    public String getSHIPPER_NAME() {
        return SHIPPER_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SHIPPER_NAME
     *
     * @param SHIPPER_NAME the value for TFSLG_TEMP.SHIPPER_NAME
     */
    public void setSHIPPER_NAME(String SHIPPER_NAME) {
        this.SHIPPER_NAME = SHIPPER_NAME == null ? null : SHIPPER_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SHIPPER_ADDRESS
     *
     * @return the value of TFSLG_TEMP.SHIPPER_ADDRESS
     */
    public String getSHIPPER_ADDRESS() {
        return SHIPPER_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SHIPPER_ADDRESS
     *
     * @param SHIPPER_ADDRESS the value for TFSLG_TEMP.SHIPPER_ADDRESS
     */
    public void setSHIPPER_ADDRESS(String SHIPPER_ADDRESS) {
        this.SHIPPER_ADDRESS = SHIPPER_ADDRESS == null ? null : SHIPPER_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CONSIGNEE_NAME
     *
     * @return the value of TFSLG_TEMP.CONSIGNEE_NAME
     */
    public String getCONSIGNEE_NAME() {
        return CONSIGNEE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CONSIGNEE_NAME
     *
     * @param CONSIGNEE_NAME the value for TFSLG_TEMP.CONSIGNEE_NAME
     */
    public void setCONSIGNEE_NAME(String CONSIGNEE_NAME) {
        this.CONSIGNEE_NAME = CONSIGNEE_NAME == null ? null : CONSIGNEE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CONSIGNEE_ADDRESS
     *
     * @return the value of TFSLG_TEMP.CONSIGNEE_ADDRESS
     */
    public String getCONSIGNEE_ADDRESS() {
        return CONSIGNEE_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CONSIGNEE_ADDRESS
     *
     * @param CONSIGNEE_ADDRESS the value for TFSLG_TEMP.CONSIGNEE_ADDRESS
     */
    public void setCONSIGNEE_ADDRESS(String CONSIGNEE_ADDRESS) {
        this.CONSIGNEE_ADDRESS = CONSIGNEE_ADDRESS == null ? null : CONSIGNEE_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOTIFY_PARTY_NAME
     *
     * @return the value of TFSLG_TEMP.NOTIFY_PARTY_NAME
     */
    public String getNOTIFY_PARTY_NAME() {
        return NOTIFY_PARTY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOTIFY_PARTY_NAME
     *
     * @param NOTIFY_PARTY_NAME the value for TFSLG_TEMP.NOTIFY_PARTY_NAME
     */
    public void setNOTIFY_PARTY_NAME(String NOTIFY_PARTY_NAME) {
        this.NOTIFY_PARTY_NAME = NOTIFY_PARTY_NAME == null ? null : NOTIFY_PARTY_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOTIFY_PARTY_ADDRESS
     *
     * @return the value of TFSLG_TEMP.NOTIFY_PARTY_ADDRESS
     */
    public String getNOTIFY_PARTY_ADDRESS() {
        return NOTIFY_PARTY_ADDRESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOTIFY_PARTY_ADDRESS
     *
     * @param NOTIFY_PARTY_ADDRESS the value for TFSLG_TEMP.NOTIFY_PARTY_ADDRESS
     */
    public void setNOTIFY_PARTY_ADDRESS(String NOTIFY_PARTY_ADDRESS) {
        this.NOTIFY_PARTY_ADDRESS = NOTIFY_PARTY_ADDRESS == null ? null : NOTIFY_PARTY_ADDRESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MARKS_NOS
     *
     * @return the value of TFSLG_TEMP.MARKS_NOS
     */
    public String getMARKS_NOS() {
        return MARKS_NOS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MARKS_NOS
     *
     * @param MARKS_NOS the value for TFSLG_TEMP.MARKS_NOS
     */
    public void setMARKS_NOS(String MARKS_NOS) {
        this.MARKS_NOS = MARKS_NOS == null ? null : MARKS_NOS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.GROSS_WEIGHT
     *
     * @return the value of TFSLG_TEMP.GROSS_WEIGHT
     */
    public String getGROSS_WEIGHT() {
        return GROSS_WEIGHT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.GROSS_WEIGHT
     *
     * @param GROSS_WEIGHT the value for TFSLG_TEMP.GROSS_WEIGHT
     */
    public void setGROSS_WEIGHT(String GROSS_WEIGHT) {
        this.GROSS_WEIGHT = GROSS_WEIGHT == null ? null : GROSS_WEIGHT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.MEASURMENT
     *
     * @return the value of TFSLG_TEMP.MEASURMENT
     */
    public String getMEASURMENT() {
        return MEASURMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.MEASURMENT
     *
     * @param MEASURMENT the value for TFSLG_TEMP.MEASURMENT
     */
    public void setMEASURMENT(String MEASURMENT) {
        this.MEASURMENT = MEASURMENT == null ? null : MEASURMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PLACE_OF_RECEIPT
     *
     * @return the value of TFSLG_TEMP.PLACE_OF_RECEIPT
     */
    public String getPLACE_OF_RECEIPT() {
        return PLACE_OF_RECEIPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PLACE_OF_RECEIPT
     *
     * @param PLACE_OF_RECEIPT the value for TFSLG_TEMP.PLACE_OF_RECEIPT
     */
    public void setPLACE_OF_RECEIPT(String PLACE_OF_RECEIPT) {
        this.PLACE_OF_RECEIPT = PLACE_OF_RECEIPT == null ? null : PLACE_OF_RECEIPT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PORT_OF_LOADING
     *
     * @return the value of TFSLG_TEMP.PORT_OF_LOADING
     */
    public String getPORT_OF_LOADING() {
        return PORT_OF_LOADING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PORT_OF_LOADING
     *
     * @param PORT_OF_LOADING the value for TFSLG_TEMP.PORT_OF_LOADING
     */
    public void setPORT_OF_LOADING(String PORT_OF_LOADING) {
        this.PORT_OF_LOADING = PORT_OF_LOADING == null ? null : PORT_OF_LOADING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PORT_OF_DISCHARGE
     *
     * @return the value of TFSLG_TEMP.PORT_OF_DISCHARGE
     */
    public String getPORT_OF_DISCHARGE() {
        return PORT_OF_DISCHARGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PORT_OF_DISCHARGE
     *
     * @param PORT_OF_DISCHARGE the value for TFSLG_TEMP.PORT_OF_DISCHARGE
     */
    public void setPORT_OF_DISCHARGE(String PORT_OF_DISCHARGE) {
        this.PORT_OF_DISCHARGE = PORT_OF_DISCHARGE == null ? null : PORT_OF_DISCHARGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.PLACE_OF_DELIVERY
     *
     * @return the value of TFSLG_TEMP.PLACE_OF_DELIVERY
     */
    public String getPLACE_OF_DELIVERY() {
        return PLACE_OF_DELIVERY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.PLACE_OF_DELIVERY
     *
     * @param PLACE_OF_DELIVERY the value for TFSLG_TEMP.PLACE_OF_DELIVERY
     */
    public void setPLACE_OF_DELIVERY(String PLACE_OF_DELIVERY) {
        this.PLACE_OF_DELIVERY = PLACE_OF_DELIVERY == null ? null : PLACE_OF_DELIVERY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REMINDER_DATE
     *
     * @return the value of TFSLG_TEMP.REMINDER_DATE
     */
    public Date getREMINDER_DATE() {
        return REMINDER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REMINDER_DATE
     *
     * @param REMINDER_DATE the value for TFSLG_TEMP.REMINDER_DATE
     */
    public void setREMINDER_DATE(Date REMINDER_DATE) {
        this.REMINDER_DATE = REMINDER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REJECT_REASON
     *
     * @return the value of TFSLG_TEMP.REJECT_REASON
     */
    public String getREJECT_REASON() {
        return REJECT_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REJECT_REASON
     *
     * @param REJECT_REASON the value for TFSLG_TEMP.REJECT_REASON
     */
    public void setREJECT_REASON(String REJECT_REASON) {
        this.REJECT_REASON = REJECT_REASON == null ? null : REJECT_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER3
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER3
     */
    public String getSENDER_TO_RECIEVER3() {
        return SENDER_TO_RECIEVER3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER3
     *
     * @param SENDER_TO_RECIEVER3 the value for TFSLG_TEMP.SENDER_TO_RECIEVER3
     */
    public void setSENDER_TO_RECIEVER3(String SENDER_TO_RECIEVER3) {
        this.SENDER_TO_RECIEVER3 = SENDER_TO_RECIEVER3 == null ? null : SENDER_TO_RECIEVER3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER4
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER4
     */
    public String getSENDER_TO_RECIEVER4() {
        return SENDER_TO_RECIEVER4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER4
     *
     * @param SENDER_TO_RECIEVER4 the value for TFSLG_TEMP.SENDER_TO_RECIEVER4
     */
    public void setSENDER_TO_RECIEVER4(String SENDER_TO_RECIEVER4) {
        this.SENDER_TO_RECIEVER4 = SENDER_TO_RECIEVER4 == null ? null : SENDER_TO_RECIEVER4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER5
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER5
     */
    public String getSENDER_TO_RECIEVER5() {
        return SENDER_TO_RECIEVER5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER5
     *
     * @param SENDER_TO_RECIEVER5 the value for TFSLG_TEMP.SENDER_TO_RECIEVER5
     */
    public void setSENDER_TO_RECIEVER5(String SENDER_TO_RECIEVER5) {
        this.SENDER_TO_RECIEVER5 = SENDER_TO_RECIEVER5 == null ? null : SENDER_TO_RECIEVER5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER6
     *
     * @return the value of TFSLG_TEMP.SENDER_TO_RECIEVER6
     */
    public String getSENDER_TO_RECIEVER6() {
        return SENDER_TO_RECIEVER6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.SENDER_TO_RECIEVER6
     *
     * @param SENDER_TO_RECIEVER6 the value for TFSLG_TEMP.SENDER_TO_RECIEVER6
     */
    public void setSENDER_TO_RECIEVER6(String SENDER_TO_RECIEVER6) {
        this.SENDER_TO_RECIEVER6 = SENDER_TO_RECIEVER6 == null ? null : SENDER_TO_RECIEVER6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TYPE_OF_MSG
     *
     * @return the value of TFSLG_TEMP.TYPE_OF_MSG
     */
    public String getTYPE_OF_MSG() {
        return TYPE_OF_MSG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TYPE_OF_MSG
     *
     * @param TYPE_OF_MSG the value for TFSLG_TEMP.TYPE_OF_MSG
     */
    public void setTYPE_OF_MSG(String TYPE_OF_MSG) {
        this.TYPE_OF_MSG = TYPE_OF_MSG == null ? null : TYPE_OF_MSG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA
     */
    public String getEXISTING_GIA() {
        return EXISTING_GIA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA
     *
     * @param EXISTING_GIA the value for TFSLG_TEMP.EXISTING_GIA
     */
    public void setEXISTING_GIA(String EXISTING_GIA) {
        this.EXISTING_GIA = EXISTING_GIA == null ? null : EXISTING_GIA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA_BR
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA_BR
     */
    public BigDecimal getEXISTING_GIA_BR() {
        return EXISTING_GIA_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA_BR
     *
     * @param EXISTING_GIA_BR the value for TFSLG_TEMP.EXISTING_GIA_BR
     */
    public void setEXISTING_GIA_BR(BigDecimal EXISTING_GIA_BR) {
        this.EXISTING_GIA_BR = EXISTING_GIA_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA_CY
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA_CY
     */
    public BigDecimal getEXISTING_GIA_CY() {
        return EXISTING_GIA_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA_CY
     *
     * @param EXISTING_GIA_CY the value for TFSLG_TEMP.EXISTING_GIA_CY
     */
    public void setEXISTING_GIA_CY(BigDecimal EXISTING_GIA_CY) {
        this.EXISTING_GIA_CY = EXISTING_GIA_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA_GL
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA_GL
     */
    public BigDecimal getEXISTING_GIA_GL() {
        return EXISTING_GIA_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA_GL
     *
     * @param EXISTING_GIA_GL the value for TFSLG_TEMP.EXISTING_GIA_GL
     */
    public void setEXISTING_GIA_GL(BigDecimal EXISTING_GIA_GL) {
        this.EXISTING_GIA_GL = EXISTING_GIA_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA_CIF
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA_CIF
     */
    public BigDecimal getEXISTING_GIA_CIF() {
        return EXISTING_GIA_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA_CIF
     *
     * @param EXISTING_GIA_CIF the value for TFSLG_TEMP.EXISTING_GIA_CIF
     */
    public void setEXISTING_GIA_CIF(BigDecimal EXISTING_GIA_CIF) {
        this.EXISTING_GIA_CIF = EXISTING_GIA_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.EXISTING_GIA_SL
     *
     * @return the value of TFSLG_TEMP.EXISTING_GIA_SL
     */
    public BigDecimal getEXISTING_GIA_SL() {
        return EXISTING_GIA_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.EXISTING_GIA_SL
     *
     * @param EXISTING_GIA_SL the value for TFSLG_TEMP.EXISTING_GIA_SL
     */
    public void setEXISTING_GIA_SL(BigDecimal EXISTING_GIA_SL) {
        this.EXISTING_GIA_SL = EXISTING_GIA_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COUNTRY_LIMIT_CODE
     *
     * @return the value of TFSLG_TEMP.COUNTRY_LIMIT_CODE
     */
    public BigDecimal getCOUNTRY_LIMIT_CODE() {
        return COUNTRY_LIMIT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COUNTRY_LIMIT_CODE
     *
     * @param COUNTRY_LIMIT_CODE the value for TFSLG_TEMP.COUNTRY_LIMIT_CODE
     */
    public void setCOUNTRY_LIMIT_CODE(BigDecimal COUNTRY_LIMIT_CODE) {
        this.COUNTRY_LIMIT_CODE = COUNTRY_LIMIT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.ISSUED_ON
     *
     * @return the value of TFSLG_TEMP.ISSUED_ON
     */
    public Date getISSUED_ON() {
        return ISSUED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.ISSUED_ON
     *
     * @param ISSUED_ON the value for TFSLG_TEMP.ISSUED_ON
     */
    public void setISSUED_ON(Date ISSUED_ON) {
        this.ISSUED_ON = ISSUED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.REQ_ISSUED_ON
     *
     * @return the value of TFSLG_TEMP.REQ_ISSUED_ON
     */
    public Date getREQ_ISSUED_ON() {
        return REQ_ISSUED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.REQ_ISSUED_ON
     *
     * @param REQ_ISSUED_ON the value for TFSLG_TEMP.REQ_ISSUED_ON
     */
    public void setREQ_ISSUED_ON(Date REQ_ISSUED_ON) {
        this.REQ_ISSUED_ON = REQ_ISSUED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DOM_REQUEST_NBR
     *
     * @return the value of TFSLG_TEMP.DOM_REQUEST_NBR
     */
    public BigDecimal getDOM_REQUEST_NBR() {
        return DOM_REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DOM_REQUEST_NBR
     *
     * @param DOM_REQUEST_NBR the value for TFSLG_TEMP.DOM_REQUEST_NBR
     */
    public void setDOM_REQUEST_NBR(BigDecimal DOM_REQUEST_NBR) {
        this.DOM_REQUEST_NBR = DOM_REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COMMISSION_CY
     *
     * @return the value of TFSLG_TEMP.COMMISSION_CY
     */
    public BigDecimal getCOMMISSION_CY() {
        return COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COMMISSION_CY
     *
     * @param COMMISSION_CY the value for TFSLG_TEMP.COMMISSION_CY
     */
    public void setCOMMISSION_CY(BigDecimal COMMISSION_CY) {
        this.COMMISSION_CY = COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COMMISSION_AMT
     *
     * @return the value of TFSLG_TEMP.COMMISSION_AMT
     */
    public BigDecimal getCOMMISSION_AMT() {
        return COMMISSION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COMMISSION_AMT
     *
     * @param COMMISSION_AMT the value for TFSLG_TEMP.COMMISSION_AMT
     */
    public void setCOMMISSION_AMT(BigDecimal COMMISSION_AMT) {
        this.COMMISSION_AMT = COMMISSION_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.COMMISSION_PAID
     *
     * @return the value of TFSLG_TEMP.COMMISSION_PAID
     */
    public String getCOMMISSION_PAID() {
        return COMMISSION_PAID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.COMMISSION_PAID
     *
     * @param COMMISSION_PAID the value for TFSLG_TEMP.COMMISSION_PAID
     */
    public void setCOMMISSION_PAID(String COMMISSION_PAID) {
        this.COMMISSION_PAID = COMMISSION_PAID == null ? null : COMMISSION_PAID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_BR
     *
     * @return the value of TFSLG_TEMP.AUTO_MARGIN_ACC_BR
     */
    public BigDecimal getAUTO_MARGIN_ACC_BR() {
        return AUTO_MARGIN_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.AUTO_MARGIN_ACC_BR
     *
     * @param AUTO_MARGIN_ACC_BR the value for TFSLG_TEMP.AUTO_MARGIN_ACC_BR
     */
    public void setAUTO_MARGIN_ACC_BR(BigDecimal AUTO_MARGIN_ACC_BR) {
        this.AUTO_MARGIN_ACC_BR = AUTO_MARGIN_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_BR
     *
     * @return the value of TFSLG_TEMP.NOSTRO_MARGIN_BR
     */
    public BigDecimal getNOSTRO_MARGIN_BR() {
        return NOSTRO_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.NOSTRO_MARGIN_BR
     *
     * @param NOSTRO_MARGIN_BR the value for TFSLG_TEMP.NOSTRO_MARGIN_BR
     */
    public void setNOSTRO_MARGIN_BR(BigDecimal NOSTRO_MARGIN_BR) {
        this.NOSTRO_MARGIN_BR = NOSTRO_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.DATETIME_MODIFIED
     *
     * @return the value of TFSLG_TEMP.DATETIME_MODIFIED
     */
    public Date getDATETIME_MODIFIED() {
        return DATETIME_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.DATETIME_MODIFIED
     *
     * @param DATETIME_MODIFIED the value for TFSLG_TEMP.DATETIME_MODIFIED
     */
    public void setDATETIME_MODIFIED(Date DATETIME_MODIFIED) {
        this.DATETIME_MODIFIED = DATETIME_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REV_DATE
     *
     * @return the value of TFSLG_TEMP.TB_REV_DATE
     */
    public Date getTB_REV_DATE() {
        return TB_REV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REV_DATE
     *
     * @param TB_REV_DATE the value for TFSLG_TEMP.TB_REV_DATE
     */
    public void setTB_REV_DATE(Date TB_REV_DATE) {
        this.TB_REV_DATE = TB_REV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REV_BY
     *
     * @return the value of TFSLG_TEMP.TB_REV_BY
     */
    public String getTB_REV_BY() {
        return TB_REV_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REV_BY
     *
     * @param TB_REV_BY the value for TFSLG_TEMP.TB_REV_BY
     */
    public void setTB_REV_BY(String TB_REV_BY) {
        this.TB_REV_BY = TB_REV_BY == null ? null : TB_REV_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REJREV_DATE
     *
     * @return the value of TFSLG_TEMP.TB_REJREV_DATE
     */
    public Date getTB_REJREV_DATE() {
        return TB_REJREV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REJREV_DATE
     *
     * @param TB_REJREV_DATE the value for TFSLG_TEMP.TB_REJREV_DATE
     */
    public void setTB_REJREV_DATE(Date TB_REJREV_DATE) {
        this.TB_REJREV_DATE = TB_REJREV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REJREV_BY
     *
     * @return the value of TFSLG_TEMP.TB_REJREV_BY
     */
    public String getTB_REJREV_BY() {
        return TB_REJREV_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REJREV_BY
     *
     * @param TB_REJREV_BY the value for TFSLG_TEMP.TB_REJREV_BY
     */
    public void setTB_REJREV_BY(String TB_REJREV_BY) {
        this.TB_REJREV_BY = TB_REJREV_BY == null ? null : TB_REJREV_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.INS_HYPERLINK
     *
     * @return the value of TFSLG_TEMP.INS_HYPERLINK
     */
    public String getINS_HYPERLINK() {
        return INS_HYPERLINK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.INS_HYPERLINK
     *
     * @param INS_HYPERLINK the value for TFSLG_TEMP.INS_HYPERLINK
     */
    public void setINS_HYPERLINK(String INS_HYPERLINK) {
        this.INS_HYPERLINK = INS_HYPERLINK == null ? null : INS_HYPERLINK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.CONV_VALUE_DATE
     *
     * @return the value of TFSLG_TEMP.CONV_VALUE_DATE
     */
    public Date getCONV_VALUE_DATE() {
        return CONV_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.CONV_VALUE_DATE
     *
     * @param CONV_VALUE_DATE the value for TFSLG_TEMP.CONV_VALUE_DATE
     */
    public void setCONV_VALUE_DATE(Date CONV_VALUE_DATE) {
        this.CONV_VALUE_DATE = CONV_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_CANCEL_BY
     *
     * @return the value of TFSLG_TEMP.TB_CANCEL_BY
     */
    public String getTB_CANCEL_BY() {
        return TB_CANCEL_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_CANCEL_BY
     *
     * @param TB_CANCEL_BY the value for TFSLG_TEMP.TB_CANCEL_BY
     */
    public void setTB_CANCEL_BY(String TB_CANCEL_BY) {
        this.TB_CANCEL_BY = TB_CANCEL_BY == null ? null : TB_CANCEL_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_CANCEL_DATE
     *
     * @return the value of TFSLG_TEMP.TB_CANCEL_DATE
     */
    public Date getTB_CANCEL_DATE() {
        return TB_CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_CANCEL_DATE
     *
     * @param TB_CANCEL_DATE the value for TFSLG_TEMP.TB_CANCEL_DATE
     */
    public void setTB_CANCEL_DATE(Date TB_CANCEL_DATE) {
        this.TB_CANCEL_DATE = TB_CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REJCANCEL_BY
     *
     * @return the value of TFSLG_TEMP.TB_REJCANCEL_BY
     */
    public String getTB_REJCANCEL_BY() {
        return TB_REJCANCEL_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REJCANCEL_BY
     *
     * @param TB_REJCANCEL_BY the value for TFSLG_TEMP.TB_REJCANCEL_BY
     */
    public void setTB_REJCANCEL_BY(String TB_REJCANCEL_BY) {
        this.TB_REJCANCEL_BY = TB_REJCANCEL_BY == null ? null : TB_REJCANCEL_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TB_REJCANCEL_DATE
     *
     * @return the value of TFSLG_TEMP.TB_REJCANCEL_DATE
     */
    public Date getTB_REJCANCEL_DATE() {
        return TB_REJCANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TB_REJCANCEL_DATE
     *
     * @param TB_REJCANCEL_DATE the value for TFSLG_TEMP.TB_REJCANCEL_DATE
     */
    public void setTB_REJCANCEL_DATE(Date TB_REJCANCEL_DATE) {
        this.TB_REJCANCEL_DATE = TB_REJCANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_DATE_VALIDATED
     *
     * @return the value of TFSLG_TEMP.LG_DATE_VALIDATED
     */
    public Date getLG_DATE_VALIDATED() {
        return LG_DATE_VALIDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_DATE_VALIDATED
     *
     * @param LG_DATE_VALIDATED the value for TFSLG_TEMP.LG_DATE_VALIDATED
     */
    public void setLG_DATE_VALIDATED(Date LG_DATE_VALIDATED) {
        this.LG_DATE_VALIDATED = LG_DATE_VALIDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.LG_VALIDATED_BY
     *
     * @return the value of TFSLG_TEMP.LG_VALIDATED_BY
     */
    public String getLG_VALIDATED_BY() {
        return LG_VALIDATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.LG_VALIDATED_BY
     *
     * @param LG_VALIDATED_BY the value for TFSLG_TEMP.LG_VALIDATED_BY
     */
    public void setLG_VALIDATED_BY(String LG_VALIDATED_BY) {
        this.LG_VALIDATED_BY = LG_VALIDATED_BY == null ? null : LG_VALIDATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.ONLINE_LIMIT_CHECK
     *
     * @return the value of TFSLG_TEMP.ONLINE_LIMIT_CHECK
     */
    public String getONLINE_LIMIT_CHECK() {
        return ONLINE_LIMIT_CHECK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.ONLINE_LIMIT_CHECK
     *
     * @param ONLINE_LIMIT_CHECK the value for TFSLG_TEMP.ONLINE_LIMIT_CHECK
     */
    public void setONLINE_LIMIT_CHECK(String ONLINE_LIMIT_CHECK) {
        this.ONLINE_LIMIT_CHECK = ONLINE_LIMIT_CHECK == null ? null : ONLINE_LIMIT_CHECK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.TEXT_TYPE_CODE
     *
     * @return the value of TFSLG_TEMP.TEXT_TYPE_CODE
     */
    public BigDecimal getTEXT_TYPE_CODE() {
        return TEXT_TYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.TEXT_TYPE_CODE
     *
     * @param TEXT_TYPE_CODE the value for TFSLG_TEMP.TEXT_TYPE_CODE
     */
    public void setTEXT_TYPE_CODE(BigDecimal TEXT_TYPE_CODE) {
        this.TEXT_TYPE_CODE = TEXT_TYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.GUARANT_DET
     *
     * @return the value of TFSLG_TEMP.GUARANT_DET
     */
    public String getGUARANT_DET() {
        return GUARANT_DET;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.GUARANT_DET
     *
     * @param GUARANT_DET the value for TFSLG_TEMP.GUARANT_DET
     */
    public void setGUARANT_DET(String GUARANT_DET) {
        this.GUARANT_DET = GUARANT_DET == null ? null : GUARANT_DET.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.GUARANT_DET1
     *
     * @return the value of TFSLG_TEMP.GUARANT_DET1
     */
    public String getGUARANT_DET1() {
        return GUARANT_DET1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.GUARANT_DET1
     *
     * @param GUARANT_DET1 the value for TFSLG_TEMP.GUARANT_DET1
     */
    public void setGUARANT_DET1(String GUARANT_DET1) {
        this.GUARANT_DET1 = GUARANT_DET1 == null ? null : GUARANT_DET1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.GUARANT_DET2
     *
     * @return the value of TFSLG_TEMP.GUARANT_DET2
     */
    public String getGUARANT_DET2() {
        return GUARANT_DET2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.GUARANT_DET2
     *
     * @param GUARANT_DET2 the value for TFSLG_TEMP.GUARANT_DET2
     */
    public void setGUARANT_DET2(String GUARANT_DET2) {
        this.GUARANT_DET2 = GUARANT_DET2 == null ? null : GUARANT_DET2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLG_TEMP.GOODS_DESCRIPTION
     *
     * @return the value of TFSLG_TEMP.GOODS_DESCRIPTION
     */
    public String getGOODS_DESCRIPTION() {
        return GOODS_DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLG_TEMP.GOODS_DESCRIPTION
     *
     * @param GOODS_DESCRIPTION the value for TFSLG_TEMP.GOODS_DESCRIPTION
     */
    public void setGOODS_DESCRIPTION(String GOODS_DESCRIPTION) {
        this.GOODS_DESCRIPTION = GOODS_DESCRIPTION == null ? null : GOODS_DESCRIPTION.trim();
    }

    public BigDecimal getDOM_REQUEST_BRANCH_CODE()
    {
        return DOM_REQUEST_BRANCH_CODE;
    }

    public void setDOM_REQUEST_BRANCH_CODE(BigDecimal DOM_REQUEST_BRANCH_CODE)
    {
        this.DOM_REQUEST_BRANCH_CODE = DOM_REQUEST_BRANCH_CODE;
    }
    
    //Mark Ayoub - #452967
	public BigDecimal getSECTOR_CODE() {
		return SECTOR_CODE;
	}

	public void setSECTOR_CODE(BigDecimal sECTOR_CODE) {
		SECTOR_CODE = sECTOR_CODE;
	}

	public BigDecimal getSUB_SECTOR_CODE() {
		return SUB_SECTOR_CODE;
	}

	public void setSUB_SECTOR_CODE(BigDecimal sUB_SECTOR_CODE) {
		SUB_SECTOR_CODE = sUB_SECTOR_CODE;
	}
    //End Mark
    
}