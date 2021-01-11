package com.path.bo.core.common;

import java.math.BigDecimal;

public class CoreCommonConstants
{

    public static final String SERIAL_BY_COMPANY = "C";
    public static final String ON_BALANCE_SHEET = "B";
    public static final Integer TRANSACTION_TYPE_CHARGES = 54;
    public static final String CHEQUEBOOK_ENTITY_TYPE = "CHQ";
    public static final String CHEQUEBOOK_CRUD_APPROVE_DESTROY = "AD";
    public static final String CHEQUEBOOK_CRUD_TO_DESTROY = "TD";
    public static final String CHEQUEBOOK_CRUD_APPROVE_CANCEL = "AC";
    public static final String CHEQUEBOOK_CRUD_TO_CANCEL = "TC";
    public static final String CHEQUEBOOK_CRUD_APPLY_TO_SUBMIT = "T";
    public static final String CHEQUEBOOK_CRUD_SUBMIT = "B";
    public static final String CARDS_MANAGEMENT_ENTITY_TYPE = "CAR";
    public static final String LOSTFOUND_ENTITY_TYPE = "LOS";
    public static final BigDecimal CHEQUE_BOOK_SYS_PARAM_LOV_TYPE = new BigDecimal(38);
    
    public static final String ACCOUNT = "A";
    public static final String CIF = "C";
    public static final String FORBID_TRX_NOT_APPLICABLE = "0";
    public static final String FORBID_TRX_FORBID_CREDIT = "1";
    public static final String FORBID_TRX_FORBID_DEBIT = "2";
    public static final String FORBID_TRX_FORBID_BOTH = "3";
    public static final String FORBID_TRX_RESTRICT_CREDIT = "4";
    public static final String FORBID_TRX_RESTRICT_DEBIT = "5";
    public static final String FORBID_TRX_RESTRICT_BOTH = "6";
    //Hasan BB140052
    public static final BigDecimal CARDS_MANAGEMENT_STATUS_LOV_TYPE	= new BigDecimal(92);
    public static final BigDecimal CARDS_MANAGEMENT_CIF_STATUS_LOV_TYPE	= new BigDecimal(93);
    public static final BigDecimal CARDS_MANAGEMENT_PRIMSUPP_LOV_TYPE	= new BigDecimal(14);
    //end Hasan
    public static final String AML ="AML";// ADD BY NOUR FOR 777000
    public static final Integer INT_MINUS_ONE = -1; // added by nour for 777000
    public static final BigDecimal Max = BigDecimal.valueOf(9999999.999);// added by nour for 777000
    public static final BigDecimal MAX_ALERT = new BigDecimal("99999999999999999");
    public static final BigDecimal MAX_TRANSAMOUNT = new BigDecimal("99999999999999999.999");
    public static final Integer INT_ONE = 1;// added by nour for 777000
    public static final String CRUD_CANCEL = "N";// added by nour for 777000
    public static final BigDecimal MINUS_ONE = new BigDecimal(-1);// added by nour for 777000
    public static final BigDecimal TWO = new BigDecimal(2);// added by nour for 777000
    public static final String CRUD_MAINTENANCE = "R";// added by nour for 777000
    public static final String CRUD_UPDATE_AFTER_APPROVE = "U";// added by nour for 777000
    public static final String CRUD_APPROVE = "P";// added by nour for 777000
    public static final String STATUS_DELETED = "D";// added by nour for 777000
    public static final String STATUS_APPROVED = "P";// added by nour for 777000

    
    public static final BigDecimal CHEQUE_DIGITS_NUMBER	= new BigDecimal(20);
}