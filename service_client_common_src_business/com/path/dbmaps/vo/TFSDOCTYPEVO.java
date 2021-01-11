package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class TFSDOCTYPEVO extends BaseVO {
    /**
     * This field corresponds to the database column TFSDOCTYPE.CONTRACT_REGISTRATION
     */
	private String CONTRACT_REGISTRATION; //Mark Ayoub - TP#450290 - SBI160238 - TP#450290
	
    /**
     * This field corresponds to the database column TFSDOCTYPE.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DOC_TYPE
     */
    private String DOC_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BRIEF_NAME_ARAB
     */
    private String BRIEF_NAME_ARAB;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LONG_NAME_ARAB
     */
    private String LONG_NAME_ARAB;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SIGHT_TIME_LC
     */
    private String SIGHT_TIME_LC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MODIF_SIGHT_TIME_LC
     */
    private String MODIF_SIGHT_TIME_LC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TIMELC_AUTO_DRDWN
     */
    private String TIMELC_AUTO_DRDWN;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_GL
     */
    private BigDecimal SUSPENSE_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_CIF
     */
    private BigDecimal SUSPENSE_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_SL
     */
    private BigDecimal SUSPENSE_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ISSUE_DATE_FROM_SYSDATE
     */
    private String ISSUE_DATE_FROM_SYSDATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MODIF_ISSUE_DATE
     */
    private String MODIF_ISSUE_DATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.FILL_SHIP_DETAILS
     */
    private String FILL_SHIP_DETAILS;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_DAYS_TOEXPIRY
     */
    private BigDecimal SHIP_DAYS_TOEXPIRY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_MAIN
     */
    private BigDecimal TEMP_CODE_MAIN;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_MAIN
     */
    private String TEMP_MODIF_MAIN;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_MAIN
     */
    private String TEMP_SHOW_MAIN;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_MAIN
     */
    private BigDecimal TEMP_TYPE_MAIN;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CHECK_CLOSING
     */
    private String CHECK_CLOSING;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_CHARGES
     */
    private BigDecimal TEMP_CODE_CHARGES;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_GL
     */
    private BigDecimal LC_OUT_SIGHT_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DIV
     */
    private BigDecimal LC_OUT_SIGHT_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DEPT
     */
    private BigDecimal LC_OUT_SIGHT_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_GL
     */
    private BigDecimal LC_OUT_SIGHT_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DIV
     */
    private BigDecimal LC_OUT_SIGHT_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DEPT
     */
    private BigDecimal LC_OUT_SIGHT_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_GL
     */
    private BigDecimal LC_OUT_SIGHT_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DIV
     */
    private BigDecimal LC_OUT_SIGHT_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DEPT
     */
    private BigDecimal LC_OUT_SIGHT_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_GL
     */
    private BigDecimal LC_OUT_SIGHT_FIN_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DIV
     */
    private BigDecimal LC_OUT_SIGHT_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DEPT
     */
    private BigDecimal LC_OUT_SIGHT_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_GL
     */
    private BigDecimal LC_OUT_TIME_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DIV
     */
    private BigDecimal LC_OUT_TIME_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DEPT
     */
    private BigDecimal LC_OUT_TIME_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_GL
     */
    private BigDecimal LC_OUT_TIME_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DIV
     */
    private BigDecimal LC_OUT_TIME_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DEPT
     */
    private BigDecimal LC_OUT_TIME_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_GL
     */
    private BigDecimal LC_OUT_TIME_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DIV
     */
    private BigDecimal LC_OUT_TIME_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DEPT
     */
    private BigDecimal LC_OUT_TIME_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_GL
     */
    private BigDecimal LC_OUT_TIME_FIN_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DIV
     */
    private BigDecimal LC_OUT_TIME_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DEPT
     */
    private BigDecimal LC_OUT_TIME_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_GL
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DIV
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DEPT
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_GL
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DIV
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DEPT
     */
    private BigDecimal LC_OUT_ACCEPT_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_GL
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DIV
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DEPT
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_GL
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DIV
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DEPT
     */
    private BigDecimal LC_OUT_ACCEPT_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_GL
     */
    private BigDecimal SHIP_GUR_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_DIV
     */
    private BigDecimal SHIP_GUR_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_DEPT
     */
    private BigDecimal SHIP_GUR_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_GL
     */
    private BigDecimal SHIP_GUR_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_DIV
     */
    private BigDecimal SHIP_GUR_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_DEPT
     */
    private BigDecimal SHIP_GUR_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_GL
     */
    private BigDecimal SHIP_GUR_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DIV
     */
    private BigDecimal SHIP_GUR_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DEPT
     */
    private BigDecimal SHIP_GUR_ASSET_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_GL
     */
    private BigDecimal SHIP_GUR_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DIV
     */
    private BigDecimal SHIP_GUR_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DEPT
     */
    private BigDecimal SHIP_GUR_LIAB_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_GL
     */
    private BigDecimal LC_INW_SIGHT_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DIV
     */
    private BigDecimal LC_INW_SIGHT_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DEPT
     */
    private BigDecimal LC_INW_SIGHT_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_GL
     */
    private BigDecimal LC_INW_SIGHT_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DIV
     */
    private BigDecimal LC_INW_SIGHT_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DEPT
     */
    private BigDecimal LC_INW_SIGHT_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_GL
     */
    private BigDecimal LC_INW_SIGHT_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DIV
     */
    private BigDecimal LC_INW_SIGHT_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DEPT
     */
    private BigDecimal LC_INW_SIGHT_ASSET_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_GL
     */
    private BigDecimal LC_INW_SIGHT_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DIV
     */
    private BigDecimal LC_INW_SIGHT_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DEPT
     */
    private BigDecimal LC_INW_SIGHT_LIAB_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_GL
     */
    private BigDecimal LC_INW_TIME_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DIV
     */
    private BigDecimal LC_INW_TIME_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DEPT
     */
    private BigDecimal LC_INW_TIME_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_GL
     */
    private BigDecimal LC_INW_TIME_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DIV
     */
    private BigDecimal LC_INW_TIME_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DEPT
     */
    private BigDecimal LC_INW_TIME_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_GL
     */
    private BigDecimal LC_INW_TIME_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DIV
     */
    private BigDecimal LC_INW_TIME_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DEPT
     */
    private BigDecimal LC_INW_TIME_ASSET_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_GL
     */
    private BigDecimal LC_INW_TIME_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DIV
     */
    private BigDecimal LC_INW_TIME_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DEPT
     */
    private BigDecimal LC_INW_TIME_LIAB_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_GL
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DIV
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DEPT
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_GL
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DIV
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DEPT
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_GL
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DIV
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DEPT
     */
    private BigDecimal LC_INW_ACCEPT_ASSET_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_GL
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DIV
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DEPT
     */
    private BigDecimal LC_INW_ACCEPT_LIAB_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_ASSET_GL
     */
    private BigDecimal LG_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_ASSET_DIV
     */
    private BigDecimal LG_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_ASSET_DEPT
     */
    private BigDecimal LG_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_LIAB_GL
     */
    private BigDecimal LG_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_LIAB_DIV
     */
    private BigDecimal LG_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_LIAB_DEPT
     */
    private BigDecimal LG_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_ASSET_GL
     */
    private BigDecimal LG_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_ASSET_DIV
     */
    private BigDecimal LG_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_ASSET_DEPT
     */
    private BigDecimal LG_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_LIAB_GL
     */
    private BigDecimal LG_FIN_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_LIAB_DIV
     */
    private BigDecimal LG_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_LIAB_DEPT
     */
    private BigDecimal LG_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_FIN_GL
     */
    private BigDecimal BILLS_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_FIN_DIV
     */
    private BigDecimal BILLS_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_FIN_DEP
     */
    private BigDecimal BILLS_LIAB_FIN_DEP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_FIN_GL
     */
    private BigDecimal BILLS_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_FIN_DIV
     */
    private BigDecimal BILLS_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_FIN_DEP
     */
    private BigDecimal BILLS_ASSET_FIN_DEP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ABOUT_APPLY
     */
    private String ABOUT_APPLY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ABOUT_PCT
     */
    private BigDecimal ABOUT_PCT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MARGIN_APPLY
     */
    private String MARGIN_APPLY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MARGIN_PCT
     */
    private BigDecimal MARGIN_PCT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ABOUT_MODIFY
     */
    private String ABOUT_MODIFY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MARGIN_MODIFY
     */
    private String MARGIN_MODIFY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_SHIP
     */
    private BigDecimal TEMP_TYPE_SHIP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_SHIP
     */
    private BigDecimal TEMP_CODE_SHIP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_SHIP
     */
    private String TEMP_MODIF_SHIP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_SHIP
     */
    private String TEMP_SHOW_SHIP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_AMEND
     */
    private BigDecimal TEMP_TYPE_AMEND;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_SIGHTTIME
     */
    private BigDecimal TEMP_CODE_SIGHTTIME;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_TIMESIGHT
     */
    private BigDecimal TEMP_CODE_TIMESIGHT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_AMEND
     */
    private String TEMP_MODIF_AMEND;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_AMEND
     */
    private String TEMP_SHOW_AMEND;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_CSHIP
     */
    private BigDecimal TEMP_CODE_CSHIP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_AMOUNT
     */
    private BigDecimal TEMP_CODE_AMOUNT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_ACCEPT
     */
    private BigDecimal TEMP_TYPE_ACCEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_ACCEPT
     */
    private BigDecimal TEMP_CODE_ACCEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_ACCEPT
     */
    private String TEMP_MODIF_ACCEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_ACCEPT
     */
    private String TEMP_SHOW_ACCEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_SETTL
     */
    private BigDecimal TEMP_TYPE_SETTL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_SETTL
     */
    private BigDecimal TEMP_CODE_SETTL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_SETTL
     */
    private String TEMP_MODIF_SETTL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_SETTL
     */
    private String TEMP_SHOW_SETTL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_GL
     */
    private BigDecimal BILLS_ACCEPT_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DIV
     */
    private BigDecimal BILLS_ACCEPT_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DEPT
     */
    private BigDecimal BILLS_ACCEPT_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_GL
     */
    private BigDecimal BILLS_ACCEPT_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DIV
     */
    private BigDecimal BILLS_ACCEPT_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DEPT
     */
    private BigDecimal BILLS_ACCEPT_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_GL
     */
    private BigDecimal BILLS_ACCEPT_FIN_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DIV
     */
    private BigDecimal BILLS_ACCEPT_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DEPT
     */
    private BigDecimal BILLS_ACCEPT_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_GL
     */
    private BigDecimal BILLS_ACCEPT_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DIV
     */
    private BigDecimal BILLS_ACCEPT_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DEPT
     */
    private BigDecimal BILLS_ACCEPT_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_CLOSE
     */
    private BigDecimal TEMP_TYPE_CLOSE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_CLOSE
     */
    private BigDecimal TEMP_CODE_CLOSE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_CLOSE
     */
    private String TEMP_MODIF_CLOSE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_CLOSE
     */
    private String TEMP_SHOW_CLOSE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_TYPE_NOSTRO
     */
    private BigDecimal TEMP_TYPE_NOSTRO;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_CODE_NOSTRO
     */
    private BigDecimal TEMP_CODE_NOSTRO;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_MODIF_NOSTRO
     */
    private String TEMP_MODIF_NOSTRO;

    /**
     * This field corresponds to the database column TFSDOCTYPE.TEMP_SHOW_NOSTRO
     */
    private String TEMP_SHOW_NOSTRO;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ABOUT_AMOUNT_PCT
     */
    private String ABOUT_AMOUNT_PCT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DUE_DATE_AFTER
     */
    private BigDecimal DUE_DATE_AFTER;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_GL
     */
    private BigDecimal BILLS_ASSET_TIME_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DIV
     */
    private BigDecimal BILLS_ASSET_TIME_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DEP
     */
    private BigDecimal BILLS_ASSET_TIME_FIN_DEP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_GL
     */
    private BigDecimal BILLS_LIAB_TIME_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DIV
     */
    private BigDecimal BILLS_LIAB_TIME_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DEP
     */
    private BigDecimal BILLS_LIAB_TIME_FIN_DEP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CHECK_INCREMENT_SL
     */
    private BigDecimal CHECK_INCREMENT_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_TYPE_DESC
     */
    private String LG_TYPE_DESC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_COMMISSION_GL
     */
    private BigDecimal CR_ACC_COMMISSION_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_COMMISSION_CIF
     */
    private BigDecimal CR_ACC_COMMISSION_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_COMMISSION_SL
     */
    private BigDecimal CR_ACC_COMMISSION_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_SWIFT_GL
     */
    private BigDecimal CR_ACC_SWIFT_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_SWIFT_CIF
     */
    private BigDecimal CR_ACC_SWIFT_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_SWIFT_SL
     */
    private BigDecimal CR_ACC_SWIFT_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_MAIL_GL
     */
    private BigDecimal CR_ACC_MAIL_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_MAIL_CIF
     */
    private BigDecimal CR_ACC_MAIL_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_MAIL_SL
     */
    private BigDecimal CR_ACC_MAIL_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_STAMPS_GL
     */
    private BigDecimal CR_ACC_STAMPS_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_STAMPS_CIF
     */
    private BigDecimal CR_ACC_STAMPS_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_STAMPS_SL
     */
    private BigDecimal CR_ACC_STAMPS_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_GL
     */
    private BigDecimal BILLS_TRANSFER_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DIV
     */
    private BigDecimal BILLS_TRANSFER_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DEPT
     */
    private BigDecimal BILLS_TRANSFER_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_GL
     */
    private BigDecimal BILLS_TRANSFER_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DIV
     */
    private BigDecimal BILLS_TRANSFER_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DEPT
     */
    private BigDecimal BILLS_TRANSFER_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_CY
     */
    private BigDecimal SUSPENSE_CY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DEFAULT_APPLICANT_CIF
     */
    private String DEFAULT_APPLICANT_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DEFAULT_CIF
     */
    private BigDecimal DEFAULT_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_BR
     */
    private BigDecimal SUSPENSE_BR;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SETTLEMENT_TYPE
     */
    private String SETTLEMENT_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CASH_FINANCE
     */
    private String CASH_FINANCE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.PRODUCT_CLASS
     */
    private BigDecimal PRODUCT_CLASS;

    /**
     * This field corresponds to the database column TFSDOCTYPE.PRE_SETT_ENABLED
     */
    private String PRE_SETT_ENABLED;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GENERATE_ENTRIES
     */
    private String GENERATE_ENTRIES;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_COMMISSION_BR
     */
    private BigDecimal CR_ACC_COMMISSION_BR;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_COMMISSION_CY
     */
    private BigDecimal CR_ACC_COMMISSION_CY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CLOSED_AFTER
     */
    private String CLOSED_AFTER;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CLOSED_AFTER_DAYS
     */
    private BigDecimal CLOSED_AFTER_DAYS;

    /**
     * This field corresponds to the database column TFSDOCTYPE.REVOLVING
     */
    private String REVOLVING;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIPPING_GUARANTEE
     */
    private String SHIPPING_GUARANTEE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_GL
     */
    private BigDecimal LG_CASH_REDEMP_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DIV
     */
    private BigDecimal LG_CASH_REDEMP_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DEPT
     */
    private BigDecimal LG_CASH_REDEMP_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_GL
     */
    private BigDecimal LG_CASH_REDEMP_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DIV
     */
    private BigDecimal LG_CASH_REDEMP_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DEPT
     */
    private BigDecimal LG_CASH_REDEMP_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_GL
     */
    private BigDecimal LG_FIN_REDEMP_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DIV
     */
    private BigDecimal LG_FIN_REDEMP_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DEPT
     */
    private BigDecimal LG_FIN_REDEMP_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_GL
     */
    private BigDecimal LG_FIN_REDEMP_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DIV
     */
    private BigDecimal LG_FIN_REDEMP_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DEPT
     */
    private BigDecimal LG_FIN_REDEMP_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DD_TRX_TYPE
     */
    private String DD_TRX_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.FORM_OFDOC_CREDIT_PARAM
     */
    private String FORM_OFDOC_CREDIT_PARAM;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GENERATE_ENTRIES_ACCEPTANCE
     */
    private String GENERATE_ENTRIES_ACCEPTANCE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_MAIL_BR
     */
    private BigDecimal CR_ACC_MAIL_BR;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CR_ACC_MAIL_CY
     */
    private BigDecimal CR_ACC_MAIL_CY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.REVERSE_MARGIN_SEP
     */
    private String REVERSE_MARGIN_SEP;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ENABLE_GUARANTEE_ADV
     */
    private String ENABLE_GUARANTEE_ADV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ENABLE_GUARANTEE_EXC
     */
    private String ENABLE_GUARANTEE_EXC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_GL
     */
    private BigDecimal BILLS_DCLR_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DIV
     */
    private BigDecimal BILLS_DCLR_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DEPT
     */
    private BigDecimal BILLS_DCLR_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_GL
     */
    private BigDecimal BILLS_DCLR_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DIV
     */
    private BigDecimal BILLS_DCLR_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DEPT
     */
    private BigDecimal BILLS_DCLR_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTO_MARGIN_GL
     */
    private BigDecimal AUTO_MARGIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTO_MARGIN_DIV
     */
    private BigDecimal AUTO_MARGIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTO_MARGIN_DEPT
     */
    private BigDecimal AUTO_MARGIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTO_MARGIN_ACC
     */
    private String AUTO_MARGIN_ACC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MARGIN_INCR_SL
     */
    private String MARGIN_INCR_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DIV
     */
    private BigDecimal AUTOMATIC_SUSPENSE_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DEPT
     */
    private BigDecimal AUTOMATIC_SUSPENSE_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.AUTO_SUSPENSE_ACC
     */
    private String AUTO_SUSPENSE_ACC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SUSPENSE_ACC_TYPE
     */
    private String SUSPENSE_ACC_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.INCREMENT_SL
     */
    private String INCREMENT_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.FREE_TRANSFER
     */
    private String FREE_TRANSFER;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MARGIN_ACC_TYPE
     */
    private String MARGIN_ACC_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.RELEASE_DD_ON_ACCEPTANCE
     */
    private String RELEASE_DD_ON_ACCEPTANCE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DEFAULT_SETTLEMENT_TYPE
     */
    private String DEFAULT_SETTLEMENT_TYPE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GENERATE_ENTRIES_ON_DEC
     */
    private String GENERATE_ENTRIES_ON_DEC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CHECK_DOM_ILC_DOC
     */
    private String CHECK_DOM_ILC_DOC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.ADDITIONAL_REF
     */
    private String ADDITIONAL_REF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GOODS_TRANS_CIF
     */
    private BigDecimal GOODS_TRANS_CIF;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GOODS_TRANS_CY
     */
    private BigDecimal GOODS_TRANS_CY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GOODS_TRANS_GL
     */
    private BigDecimal GOODS_TRANS_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.GOODS_TRANS_SL
     */
    private BigDecimal GOODS_TRANS_SL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.USE_GOODS_IN_TRANS
     */
    private String USE_GOODS_IN_TRANS;

    /**
     * This field corresponds to the database column TFSDOCTYPE.DOM_MAND_FOR_FC_YN
     */
    private String DOM_MAND_FOR_FC_YN;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.DOM_MAND_FOR_FC_OPTION
     */
    private String DOM_MAND_FOR_FC_OPTION;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.OFF_BS_DOC_ENTRIES_TYPE
     */
    private String OFF_BS_DOC_ENTRIES_TYPE;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.DOM_MAND_FOR_FC_IN
     */
    private String DOM_MAND_FOR_FC_IN;
    
    private String DEFAULT_SUSPENSE_ACC_YN;
    
    private String ALLOW_EXCESS_OVER_LIMIT_YN;
    
    private BigDecimal DRAWDOWN_TYPE;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.DOC_GRP_CODE
     */
    private BigDecimal DOC_GRP_CODE;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.DOC_GRP_DESC
     */
    private String DOC_GRP_DESC;

    /**
     * This field corresponds to the database column TFSDOCTYPE.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column TFSDOCTYPE.REJECTED_DATE
     */
    private Date REJECTED_DATE;

    /**
     * This field corresponds to the database column TFSDOCTYPE.SHIP_GUAR_AVAIL_LC_DOC
     */
    private String SHIP_GUAR_AVAIL_LC_DOC;
    
    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DEPT
     */
    private BigDecimal LC_INW_DOC_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DIV
     */
    private BigDecimal LC_INW_DOC_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DEPT
     */
    private BigDecimal LC_INW_DOC_ASSET_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DIV
     */
    private BigDecimal LC_INW_DOC_ASSET_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_GL
     */
    private BigDecimal LC_INW_DOC_ASSET_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_ASSET_GL
     */
    private BigDecimal LC_INW_DOC_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DEPT
     */
    private BigDecimal LC_INW_DOC_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DIV
     */
    private BigDecimal LC_INW_DOC_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DEPT
     */
    private BigDecimal LC_INW_DOC_LIAB_FIN_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DIV
     */
    private BigDecimal LC_INW_DOC_LIAB_FIN_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_GL
     */
    private BigDecimal LC_INW_DOC_LIAB_FIN_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_INW_DOC_LIAB_GL
     */
    private BigDecimal LC_INW_DOC_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DEPT
     */
    private BigDecimal LC_OUT_DOC_CASH_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DIV
     */
    private BigDecimal LC_OUT_DOC_CASH_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_GL
     */
    private BigDecimal LC_OUT_DOC_CASH_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DEPT
     */
    private BigDecimal LC_OUT_DOC_CASH_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DIV
     */
    private BigDecimal LC_OUT_DOC_CASH_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_GL
     */
    private BigDecimal LC_OUT_DOC_CASH_LIAB_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DEPT
     */
    private BigDecimal LC_OUT_DOC_FIN_ASSET_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DIV
     */
    private BigDecimal LC_OUT_DOC_FIN_ASSET_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_GL
     */
    private BigDecimal LC_OUT_DOC_FIN_ASSET_GL;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DEPT
     */
    private BigDecimal LC_OUT_DOC_FIN_LIAB_DEPT;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DIV
     */
    private BigDecimal LC_OUT_DOC_FIN_LIAB_DIV;

    /**
     * This field corresponds to the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_GL
     */
    private BigDecimal LC_OUT_DOC_FIN_LIAB_GL;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CODE
     *
     * @return the value of TFSDOCTYPE.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CODE
     *
     * @param CODE the value for TFSDOCTYPE.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.COMP_CODE
     *
     * @return the value of TFSDOCTYPE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.COMP_CODE
     *
     * @param COMP_CODE the value for TFSDOCTYPE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DOC_TYPE
     *
     * @return the value of TFSDOCTYPE.DOC_TYPE
     */
    public String getDOC_TYPE() {
        return DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DOC_TYPE
     *
     * @param DOC_TYPE the value for TFSDOCTYPE.DOC_TYPE
     */
    public void setDOC_TYPE(String DOC_TYPE) {
        this.DOC_TYPE = DOC_TYPE == null ? null : DOC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BRIEF_NAME_ENG
     *
     * @return the value of TFSDOCTYPE.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for TFSDOCTYPE.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LONG_NAME_ENG
     *
     * @return the value of TFSDOCTYPE.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for TFSDOCTYPE.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BRIEF_NAME_ARAB
     *
     * @return the value of TFSDOCTYPE.BRIEF_NAME_ARAB
     */
    public String getBRIEF_NAME_ARAB() {
        return BRIEF_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BRIEF_NAME_ARAB
     *
     * @param BRIEF_NAME_ARAB the value for TFSDOCTYPE.BRIEF_NAME_ARAB
     */
    public void setBRIEF_NAME_ARAB(String BRIEF_NAME_ARAB) {
        this.BRIEF_NAME_ARAB = BRIEF_NAME_ARAB == null ? null : BRIEF_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LONG_NAME_ARAB
     *
     * @return the value of TFSDOCTYPE.LONG_NAME_ARAB
     */
    public String getLONG_NAME_ARAB() {
        return LONG_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LONG_NAME_ARAB
     *
     * @param LONG_NAME_ARAB the value for TFSDOCTYPE.LONG_NAME_ARAB
     */
    public void setLONG_NAME_ARAB(String LONG_NAME_ARAB) {
        this.LONG_NAME_ARAB = LONG_NAME_ARAB == null ? null : LONG_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SIGHT_TIME_LC
     *
     * @return the value of TFSDOCTYPE.SIGHT_TIME_LC
     */
    public String getSIGHT_TIME_LC() {
        return SIGHT_TIME_LC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SIGHT_TIME_LC
     *
     * @param SIGHT_TIME_LC the value for TFSDOCTYPE.SIGHT_TIME_LC
     */
    public void setSIGHT_TIME_LC(String SIGHT_TIME_LC) {
        this.SIGHT_TIME_LC = SIGHT_TIME_LC == null ? null : SIGHT_TIME_LC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MODIF_SIGHT_TIME_LC
     *
     * @return the value of TFSDOCTYPE.MODIF_SIGHT_TIME_LC
     */
    public String getMODIF_SIGHT_TIME_LC() {
        return MODIF_SIGHT_TIME_LC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MODIF_SIGHT_TIME_LC
     *
     * @param MODIF_SIGHT_TIME_LC the value for TFSDOCTYPE.MODIF_SIGHT_TIME_LC
     */
    public void setMODIF_SIGHT_TIME_LC(String MODIF_SIGHT_TIME_LC) {
        this.MODIF_SIGHT_TIME_LC = MODIF_SIGHT_TIME_LC == null ? null : MODIF_SIGHT_TIME_LC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TIMELC_AUTO_DRDWN
     *
     * @return the value of TFSDOCTYPE.TIMELC_AUTO_DRDWN
     */
    public String getTIMELC_AUTO_DRDWN() {
        return TIMELC_AUTO_DRDWN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TIMELC_AUTO_DRDWN
     *
     * @param TIMELC_AUTO_DRDWN the value for TFSDOCTYPE.TIMELC_AUTO_DRDWN
     */
    public void setTIMELC_AUTO_DRDWN(String TIMELC_AUTO_DRDWN) {
        this.TIMELC_AUTO_DRDWN = TIMELC_AUTO_DRDWN == null ? null : TIMELC_AUTO_DRDWN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_GL
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_GL
     */
    public BigDecimal getSUSPENSE_GL() {
        return SUSPENSE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_GL
     *
     * @param SUSPENSE_GL the value for TFSDOCTYPE.SUSPENSE_GL
     */
    public void setSUSPENSE_GL(BigDecimal SUSPENSE_GL) {
        this.SUSPENSE_GL = SUSPENSE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_CIF
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_CIF
     */
    public BigDecimal getSUSPENSE_CIF() {
        return SUSPENSE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_CIF
     *
     * @param SUSPENSE_CIF the value for TFSDOCTYPE.SUSPENSE_CIF
     */
    public void setSUSPENSE_CIF(BigDecimal SUSPENSE_CIF) {
        this.SUSPENSE_CIF = SUSPENSE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_SL
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_SL
     */
    public BigDecimal getSUSPENSE_SL() {
        return SUSPENSE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_SL
     *
     * @param SUSPENSE_SL the value for TFSDOCTYPE.SUSPENSE_SL
     */
    public void setSUSPENSE_SL(BigDecimal SUSPENSE_SL) {
        this.SUSPENSE_SL = SUSPENSE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ISSUE_DATE_FROM_SYSDATE
     *
     * @return the value of TFSDOCTYPE.ISSUE_DATE_FROM_SYSDATE
     */
    public String getISSUE_DATE_FROM_SYSDATE() {
        return ISSUE_DATE_FROM_SYSDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ISSUE_DATE_FROM_SYSDATE
     *
     * @param ISSUE_DATE_FROM_SYSDATE the value for TFSDOCTYPE.ISSUE_DATE_FROM_SYSDATE
     */
    public void setISSUE_DATE_FROM_SYSDATE(String ISSUE_DATE_FROM_SYSDATE) {
        this.ISSUE_DATE_FROM_SYSDATE = ISSUE_DATE_FROM_SYSDATE == null ? null : ISSUE_DATE_FROM_SYSDATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MODIF_ISSUE_DATE
     *
     * @return the value of TFSDOCTYPE.MODIF_ISSUE_DATE
     */
    public String getMODIF_ISSUE_DATE() {
        return MODIF_ISSUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MODIF_ISSUE_DATE
     *
     * @param MODIF_ISSUE_DATE the value for TFSDOCTYPE.MODIF_ISSUE_DATE
     */
    public void setMODIF_ISSUE_DATE(String MODIF_ISSUE_DATE) {
        this.MODIF_ISSUE_DATE = MODIF_ISSUE_DATE == null ? null : MODIF_ISSUE_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.FILL_SHIP_DETAILS
     *
     * @return the value of TFSDOCTYPE.FILL_SHIP_DETAILS
     */
    public String getFILL_SHIP_DETAILS() {
        return FILL_SHIP_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.FILL_SHIP_DETAILS
     *
     * @param FILL_SHIP_DETAILS the value for TFSDOCTYPE.FILL_SHIP_DETAILS
     */
    public void setFILL_SHIP_DETAILS(String FILL_SHIP_DETAILS) {
        this.FILL_SHIP_DETAILS = FILL_SHIP_DETAILS == null ? null : FILL_SHIP_DETAILS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_DAYS_TOEXPIRY
     *
     * @return the value of TFSDOCTYPE.SHIP_DAYS_TOEXPIRY
     */
    public BigDecimal getSHIP_DAYS_TOEXPIRY() {
        return SHIP_DAYS_TOEXPIRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_DAYS_TOEXPIRY
     *
     * @param SHIP_DAYS_TOEXPIRY the value for TFSDOCTYPE.SHIP_DAYS_TOEXPIRY
     */
    public void setSHIP_DAYS_TOEXPIRY(BigDecimal SHIP_DAYS_TOEXPIRY) {
        this.SHIP_DAYS_TOEXPIRY = SHIP_DAYS_TOEXPIRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_MAIN
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_MAIN
     */
    public BigDecimal getTEMP_CODE_MAIN() {
        return TEMP_CODE_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_MAIN
     *
     * @param TEMP_CODE_MAIN the value for TFSDOCTYPE.TEMP_CODE_MAIN
     */
    public void setTEMP_CODE_MAIN(BigDecimal TEMP_CODE_MAIN) {
        this.TEMP_CODE_MAIN = TEMP_CODE_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_MAIN
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_MAIN
     */
    public String getTEMP_MODIF_MAIN() {
        return TEMP_MODIF_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_MAIN
     *
     * @param TEMP_MODIF_MAIN the value for TFSDOCTYPE.TEMP_MODIF_MAIN
     */
    public void setTEMP_MODIF_MAIN(String TEMP_MODIF_MAIN) {
        this.TEMP_MODIF_MAIN = TEMP_MODIF_MAIN == null ? null : TEMP_MODIF_MAIN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_MAIN
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_MAIN
     */
    public String getTEMP_SHOW_MAIN() {
        return TEMP_SHOW_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_MAIN
     *
     * @param TEMP_SHOW_MAIN the value for TFSDOCTYPE.TEMP_SHOW_MAIN
     */
    public void setTEMP_SHOW_MAIN(String TEMP_SHOW_MAIN) {
        this.TEMP_SHOW_MAIN = TEMP_SHOW_MAIN == null ? null : TEMP_SHOW_MAIN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_MAIN
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_MAIN
     */
    public BigDecimal getTEMP_TYPE_MAIN() {
        return TEMP_TYPE_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_MAIN
     *
     * @param TEMP_TYPE_MAIN the value for TFSDOCTYPE.TEMP_TYPE_MAIN
     */
    public void setTEMP_TYPE_MAIN(BigDecimal TEMP_TYPE_MAIN) {
        this.TEMP_TYPE_MAIN = TEMP_TYPE_MAIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CHECK_CLOSING
     *
     * @return the value of TFSDOCTYPE.CHECK_CLOSING
     */
    public String getCHECK_CLOSING() {
        return CHECK_CLOSING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CHECK_CLOSING
     *
     * @param CHECK_CLOSING the value for TFSDOCTYPE.CHECK_CLOSING
     */
    public void setCHECK_CLOSING(String CHECK_CLOSING) {
        this.CHECK_CLOSING = CHECK_CLOSING == null ? null : CHECK_CLOSING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_CHARGES
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_CHARGES
     */
    public BigDecimal getTEMP_CODE_CHARGES() {
        return TEMP_CODE_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_CHARGES
     *
     * @param TEMP_CODE_CHARGES the value for TFSDOCTYPE.TEMP_CODE_CHARGES
     */
    public void setTEMP_CODE_CHARGES(BigDecimal TEMP_CODE_CHARGES) {
        this.TEMP_CODE_CHARGES = TEMP_CODE_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_GL
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_ASSET_GL() {
        return LC_OUT_SIGHT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_GL
     *
     * @param LC_OUT_SIGHT_CASH_ASSET_GL the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_GL
     */
    public void setLC_OUT_SIGHT_CASH_ASSET_GL(BigDecimal LC_OUT_SIGHT_CASH_ASSET_GL) {
        this.LC_OUT_SIGHT_CASH_ASSET_GL = LC_OUT_SIGHT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DIV
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_ASSET_DIV() {
        return LC_OUT_SIGHT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DIV
     *
     * @param LC_OUT_SIGHT_CASH_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DIV
     */
    public void setLC_OUT_SIGHT_CASH_ASSET_DIV(BigDecimal LC_OUT_SIGHT_CASH_ASSET_DIV) {
        this.LC_OUT_SIGHT_CASH_ASSET_DIV = LC_OUT_SIGHT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_ASSET_DEPT() {
        return LC_OUT_SIGHT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DEPT
     *
     * @param LC_OUT_SIGHT_CASH_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_ASSET_DEPT
     */
    public void setLC_OUT_SIGHT_CASH_ASSET_DEPT(BigDecimal LC_OUT_SIGHT_CASH_ASSET_DEPT) {
        this.LC_OUT_SIGHT_CASH_ASSET_DEPT = LC_OUT_SIGHT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_GL
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_LIAB_GL() {
        return LC_OUT_SIGHT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_GL
     *
     * @param LC_OUT_SIGHT_CASH_LIAB_GL the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_GL
     */
    public void setLC_OUT_SIGHT_CASH_LIAB_GL(BigDecimal LC_OUT_SIGHT_CASH_LIAB_GL) {
        this.LC_OUT_SIGHT_CASH_LIAB_GL = LC_OUT_SIGHT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DIV
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_LIAB_DIV() {
        return LC_OUT_SIGHT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DIV
     *
     * @param LC_OUT_SIGHT_CASH_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DIV
     */
    public void setLC_OUT_SIGHT_CASH_LIAB_DIV(BigDecimal LC_OUT_SIGHT_CASH_LIAB_DIV) {
        this.LC_OUT_SIGHT_CASH_LIAB_DIV = LC_OUT_SIGHT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_SIGHT_CASH_LIAB_DEPT() {
        return LC_OUT_SIGHT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DEPT
     *
     * @param LC_OUT_SIGHT_CASH_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_SIGHT_CASH_LIAB_DEPT
     */
    public void setLC_OUT_SIGHT_CASH_LIAB_DEPT(BigDecimal LC_OUT_SIGHT_CASH_LIAB_DEPT) {
        this.LC_OUT_SIGHT_CASH_LIAB_DEPT = LC_OUT_SIGHT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_GL
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_ASSET_GL() {
        return LC_OUT_SIGHT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_GL
     *
     * @param LC_OUT_SIGHT_FIN_ASSET_GL the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_GL
     */
    public void setLC_OUT_SIGHT_FIN_ASSET_GL(BigDecimal LC_OUT_SIGHT_FIN_ASSET_GL) {
        this.LC_OUT_SIGHT_FIN_ASSET_GL = LC_OUT_SIGHT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DIV
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_ASSET_DIV() {
        return LC_OUT_SIGHT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DIV
     *
     * @param LC_OUT_SIGHT_FIN_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DIV
     */
    public void setLC_OUT_SIGHT_FIN_ASSET_DIV(BigDecimal LC_OUT_SIGHT_FIN_ASSET_DIV) {
        this.LC_OUT_SIGHT_FIN_ASSET_DIV = LC_OUT_SIGHT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_ASSET_DEPT() {
        return LC_OUT_SIGHT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DEPT
     *
     * @param LC_OUT_SIGHT_FIN_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_ASSET_DEPT
     */
    public void setLC_OUT_SIGHT_FIN_ASSET_DEPT(BigDecimal LC_OUT_SIGHT_FIN_ASSET_DEPT) {
        this.LC_OUT_SIGHT_FIN_ASSET_DEPT = LC_OUT_SIGHT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_GL
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_LIAB_GL() {
        return LC_OUT_SIGHT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_GL
     *
     * @param LC_OUT_SIGHT_FIN_LIAB_GL the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_GL
     */
    public void setLC_OUT_SIGHT_FIN_LIAB_GL(BigDecimal LC_OUT_SIGHT_FIN_LIAB_GL) {
        this.LC_OUT_SIGHT_FIN_LIAB_GL = LC_OUT_SIGHT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DIV
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_LIAB_DIV() {
        return LC_OUT_SIGHT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DIV
     *
     * @param LC_OUT_SIGHT_FIN_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DIV
     */
    public void setLC_OUT_SIGHT_FIN_LIAB_DIV(BigDecimal LC_OUT_SIGHT_FIN_LIAB_DIV) {
        this.LC_OUT_SIGHT_FIN_LIAB_DIV = LC_OUT_SIGHT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_SIGHT_FIN_LIAB_DEPT() {
        return LC_OUT_SIGHT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DEPT
     *
     * @param LC_OUT_SIGHT_FIN_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_SIGHT_FIN_LIAB_DEPT
     */
    public void setLC_OUT_SIGHT_FIN_LIAB_DEPT(BigDecimal LC_OUT_SIGHT_FIN_LIAB_DEPT) {
        this.LC_OUT_SIGHT_FIN_LIAB_DEPT = LC_OUT_SIGHT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_GL
     */
    public BigDecimal getLC_OUT_TIME_CASH_ASSET_GL() {
        return LC_OUT_TIME_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_GL
     *
     * @param LC_OUT_TIME_CASH_ASSET_GL the value for TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_GL
     */
    public void setLC_OUT_TIME_CASH_ASSET_GL(BigDecimal LC_OUT_TIME_CASH_ASSET_GL) {
        this.LC_OUT_TIME_CASH_ASSET_GL = LC_OUT_TIME_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DIV
     */
    public BigDecimal getLC_OUT_TIME_CASH_ASSET_DIV() {
        return LC_OUT_TIME_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DIV
     *
     * @param LC_OUT_TIME_CASH_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DIV
     */
    public void setLC_OUT_TIME_CASH_ASSET_DIV(BigDecimal LC_OUT_TIME_CASH_ASSET_DIV) {
        this.LC_OUT_TIME_CASH_ASSET_DIV = LC_OUT_TIME_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_TIME_CASH_ASSET_DEPT() {
        return LC_OUT_TIME_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DEPT
     *
     * @param LC_OUT_TIME_CASH_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_TIME_CASH_ASSET_DEPT
     */
    public void setLC_OUT_TIME_CASH_ASSET_DEPT(BigDecimal LC_OUT_TIME_CASH_ASSET_DEPT) {
        this.LC_OUT_TIME_CASH_ASSET_DEPT = LC_OUT_TIME_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_GL
     */
    public BigDecimal getLC_OUT_TIME_CASH_LIAB_GL() {
        return LC_OUT_TIME_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_GL
     *
     * @param LC_OUT_TIME_CASH_LIAB_GL the value for TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_GL
     */
    public void setLC_OUT_TIME_CASH_LIAB_GL(BigDecimal LC_OUT_TIME_CASH_LIAB_GL) {
        this.LC_OUT_TIME_CASH_LIAB_GL = LC_OUT_TIME_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DIV
     */
    public BigDecimal getLC_OUT_TIME_CASH_LIAB_DIV() {
        return LC_OUT_TIME_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DIV
     *
     * @param LC_OUT_TIME_CASH_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DIV
     */
    public void setLC_OUT_TIME_CASH_LIAB_DIV(BigDecimal LC_OUT_TIME_CASH_LIAB_DIV) {
        this.LC_OUT_TIME_CASH_LIAB_DIV = LC_OUT_TIME_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_TIME_CASH_LIAB_DEPT() {
        return LC_OUT_TIME_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DEPT
     *
     * @param LC_OUT_TIME_CASH_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_TIME_CASH_LIAB_DEPT
     */
    public void setLC_OUT_TIME_CASH_LIAB_DEPT(BigDecimal LC_OUT_TIME_CASH_LIAB_DEPT) {
        this.LC_OUT_TIME_CASH_LIAB_DEPT = LC_OUT_TIME_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_GL
     */
    public BigDecimal getLC_OUT_TIME_FIN_ASSET_GL() {
        return LC_OUT_TIME_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_GL
     *
     * @param LC_OUT_TIME_FIN_ASSET_GL the value for TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_GL
     */
    public void setLC_OUT_TIME_FIN_ASSET_GL(BigDecimal LC_OUT_TIME_FIN_ASSET_GL) {
        this.LC_OUT_TIME_FIN_ASSET_GL = LC_OUT_TIME_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DIV
     */
    public BigDecimal getLC_OUT_TIME_FIN_ASSET_DIV() {
        return LC_OUT_TIME_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DIV
     *
     * @param LC_OUT_TIME_FIN_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DIV
     */
    public void setLC_OUT_TIME_FIN_ASSET_DIV(BigDecimal LC_OUT_TIME_FIN_ASSET_DIV) {
        this.LC_OUT_TIME_FIN_ASSET_DIV = LC_OUT_TIME_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_TIME_FIN_ASSET_DEPT() {
        return LC_OUT_TIME_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DEPT
     *
     * @param LC_OUT_TIME_FIN_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_TIME_FIN_ASSET_DEPT
     */
    public void setLC_OUT_TIME_FIN_ASSET_DEPT(BigDecimal LC_OUT_TIME_FIN_ASSET_DEPT) {
        this.LC_OUT_TIME_FIN_ASSET_DEPT = LC_OUT_TIME_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_GL
     */
    public BigDecimal getLC_OUT_TIME_FIN_LIAB_GL() {
        return LC_OUT_TIME_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_GL
     *
     * @param LC_OUT_TIME_FIN_LIAB_GL the value for TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_GL
     */
    public void setLC_OUT_TIME_FIN_LIAB_GL(BigDecimal LC_OUT_TIME_FIN_LIAB_GL) {
        this.LC_OUT_TIME_FIN_LIAB_GL = LC_OUT_TIME_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DIV
     */
    public BigDecimal getLC_OUT_TIME_FIN_LIAB_DIV() {
        return LC_OUT_TIME_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DIV
     *
     * @param LC_OUT_TIME_FIN_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DIV
     */
    public void setLC_OUT_TIME_FIN_LIAB_DIV(BigDecimal LC_OUT_TIME_FIN_LIAB_DIV) {
        this.LC_OUT_TIME_FIN_LIAB_DIV = LC_OUT_TIME_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_TIME_FIN_LIAB_DEPT() {
        return LC_OUT_TIME_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DEPT
     *
     * @param LC_OUT_TIME_FIN_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_TIME_FIN_LIAB_DEPT
     */
    public void setLC_OUT_TIME_FIN_LIAB_DEPT(BigDecimal LC_OUT_TIME_FIN_LIAB_DEPT) {
        this.LC_OUT_TIME_FIN_LIAB_DEPT = LC_OUT_TIME_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_GL
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_ASSET_GL() {
        return LC_OUT_ACCEPT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_GL
     *
     * @param LC_OUT_ACCEPT_CASH_ASSET_GL the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_GL
     */
    public void setLC_OUT_ACCEPT_CASH_ASSET_GL(BigDecimal LC_OUT_ACCEPT_CASH_ASSET_GL) {
        this.LC_OUT_ACCEPT_CASH_ASSET_GL = LC_OUT_ACCEPT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DIV
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_ASSET_DIV() {
        return LC_OUT_ACCEPT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DIV
     *
     * @param LC_OUT_ACCEPT_CASH_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DIV
     */
    public void setLC_OUT_ACCEPT_CASH_ASSET_DIV(BigDecimal LC_OUT_ACCEPT_CASH_ASSET_DIV) {
        this.LC_OUT_ACCEPT_CASH_ASSET_DIV = LC_OUT_ACCEPT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_ASSET_DEPT() {
        return LC_OUT_ACCEPT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DEPT
     *
     * @param LC_OUT_ACCEPT_CASH_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_ASSET_DEPT
     */
    public void setLC_OUT_ACCEPT_CASH_ASSET_DEPT(BigDecimal LC_OUT_ACCEPT_CASH_ASSET_DEPT) {
        this.LC_OUT_ACCEPT_CASH_ASSET_DEPT = LC_OUT_ACCEPT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_GL
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_LIAB_GL() {
        return LC_OUT_ACCEPT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_GL
     *
     * @param LC_OUT_ACCEPT_CASH_LIAB_GL the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_GL
     */
    public void setLC_OUT_ACCEPT_CASH_LIAB_GL(BigDecimal LC_OUT_ACCEPT_CASH_LIAB_GL) {
        this.LC_OUT_ACCEPT_CASH_LIAB_GL = LC_OUT_ACCEPT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DIV
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_LIAB_DIV() {
        return LC_OUT_ACCEPT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DIV
     *
     * @param LC_OUT_ACCEPT_CASH_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DIV
     */
    public void setLC_OUT_ACCEPT_CASH_LIAB_DIV(BigDecimal LC_OUT_ACCEPT_CASH_LIAB_DIV) {
        this.LC_OUT_ACCEPT_CASH_LIAB_DIV = LC_OUT_ACCEPT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_ACCEPT_CASH_LIAB_DEPT() {
        return LC_OUT_ACCEPT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DEPT
     *
     * @param LC_OUT_ACCEPT_CASH_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_ACCEPT_CASH_LIAB_DEPT
     */
    public void setLC_OUT_ACCEPT_CASH_LIAB_DEPT(BigDecimal LC_OUT_ACCEPT_CASH_LIAB_DEPT) {
        this.LC_OUT_ACCEPT_CASH_LIAB_DEPT = LC_OUT_ACCEPT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_GL
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_ASSET_GL() {
        return LC_OUT_ACCEPT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_GL
     *
     * @param LC_OUT_ACCEPT_FIN_ASSET_GL the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_GL
     */
    public void setLC_OUT_ACCEPT_FIN_ASSET_GL(BigDecimal LC_OUT_ACCEPT_FIN_ASSET_GL) {
        this.LC_OUT_ACCEPT_FIN_ASSET_GL = LC_OUT_ACCEPT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DIV
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_ASSET_DIV() {
        return LC_OUT_ACCEPT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DIV
     *
     * @param LC_OUT_ACCEPT_FIN_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DIV
     */
    public void setLC_OUT_ACCEPT_FIN_ASSET_DIV(BigDecimal LC_OUT_ACCEPT_FIN_ASSET_DIV) {
        this.LC_OUT_ACCEPT_FIN_ASSET_DIV = LC_OUT_ACCEPT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_ASSET_DEPT() {
        return LC_OUT_ACCEPT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DEPT
     *
     * @param LC_OUT_ACCEPT_FIN_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_ASSET_DEPT
     */
    public void setLC_OUT_ACCEPT_FIN_ASSET_DEPT(BigDecimal LC_OUT_ACCEPT_FIN_ASSET_DEPT) {
        this.LC_OUT_ACCEPT_FIN_ASSET_DEPT = LC_OUT_ACCEPT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_GL
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_LIAB_GL() {
        return LC_OUT_ACCEPT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_GL
     *
     * @param LC_OUT_ACCEPT_FIN_LIAB_GL the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_GL
     */
    public void setLC_OUT_ACCEPT_FIN_LIAB_GL(BigDecimal LC_OUT_ACCEPT_FIN_LIAB_GL) {
        this.LC_OUT_ACCEPT_FIN_LIAB_GL = LC_OUT_ACCEPT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DIV
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_LIAB_DIV() {
        return LC_OUT_ACCEPT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DIV
     *
     * @param LC_OUT_ACCEPT_FIN_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DIV
     */
    public void setLC_OUT_ACCEPT_FIN_LIAB_DIV(BigDecimal LC_OUT_ACCEPT_FIN_LIAB_DIV) {
        this.LC_OUT_ACCEPT_FIN_LIAB_DIV = LC_OUT_ACCEPT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_ACCEPT_FIN_LIAB_DEPT() {
        return LC_OUT_ACCEPT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DEPT
     *
     * @param LC_OUT_ACCEPT_FIN_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_ACCEPT_FIN_LIAB_DEPT
     */
    public void setLC_OUT_ACCEPT_FIN_LIAB_DEPT(BigDecimal LC_OUT_ACCEPT_FIN_LIAB_DEPT) {
        this.LC_OUT_ACCEPT_FIN_LIAB_DEPT = LC_OUT_ACCEPT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_GL
     */
    public BigDecimal getSHIP_GUR_ASSET_GL() {
        return SHIP_GUR_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_GL
     *
     * @param SHIP_GUR_ASSET_GL the value for TFSDOCTYPE.SHIP_GUR_ASSET_GL
     */
    public void setSHIP_GUR_ASSET_GL(BigDecimal SHIP_GUR_ASSET_GL) {
        this.SHIP_GUR_ASSET_GL = SHIP_GUR_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_DIV
     */
    public BigDecimal getSHIP_GUR_ASSET_DIV() {
        return SHIP_GUR_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_DIV
     *
     * @param SHIP_GUR_ASSET_DIV the value for TFSDOCTYPE.SHIP_GUR_ASSET_DIV
     */
    public void setSHIP_GUR_ASSET_DIV(BigDecimal SHIP_GUR_ASSET_DIV) {
        this.SHIP_GUR_ASSET_DIV = SHIP_GUR_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_DEPT
     */
    public BigDecimal getSHIP_GUR_ASSET_DEPT() {
        return SHIP_GUR_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_DEPT
     *
     * @param SHIP_GUR_ASSET_DEPT the value for TFSDOCTYPE.SHIP_GUR_ASSET_DEPT
     */
    public void setSHIP_GUR_ASSET_DEPT(BigDecimal SHIP_GUR_ASSET_DEPT) {
        this.SHIP_GUR_ASSET_DEPT = SHIP_GUR_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_GL
     */
    public BigDecimal getSHIP_GUR_LIAB_GL() {
        return SHIP_GUR_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_GL
     *
     * @param SHIP_GUR_LIAB_GL the value for TFSDOCTYPE.SHIP_GUR_LIAB_GL
     */
    public void setSHIP_GUR_LIAB_GL(BigDecimal SHIP_GUR_LIAB_GL) {
        this.SHIP_GUR_LIAB_GL = SHIP_GUR_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_DIV
     */
    public BigDecimal getSHIP_GUR_LIAB_DIV() {
        return SHIP_GUR_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_DIV
     *
     * @param SHIP_GUR_LIAB_DIV the value for TFSDOCTYPE.SHIP_GUR_LIAB_DIV
     */
    public void setSHIP_GUR_LIAB_DIV(BigDecimal SHIP_GUR_LIAB_DIV) {
        this.SHIP_GUR_LIAB_DIV = SHIP_GUR_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_DEPT
     */
    public BigDecimal getSHIP_GUR_LIAB_DEPT() {
        return SHIP_GUR_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_DEPT
     *
     * @param SHIP_GUR_LIAB_DEPT the value for TFSDOCTYPE.SHIP_GUR_LIAB_DEPT
     */
    public void setSHIP_GUR_LIAB_DEPT(BigDecimal SHIP_GUR_LIAB_DEPT) {
        this.SHIP_GUR_LIAB_DEPT = SHIP_GUR_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_FIN_GL
     */
    public BigDecimal getSHIP_GUR_ASSET_FIN_GL() {
        return SHIP_GUR_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_GL
     *
     * @param SHIP_GUR_ASSET_FIN_GL the value for TFSDOCTYPE.SHIP_GUR_ASSET_FIN_GL
     */
    public void setSHIP_GUR_ASSET_FIN_GL(BigDecimal SHIP_GUR_ASSET_FIN_GL) {
        this.SHIP_GUR_ASSET_FIN_GL = SHIP_GUR_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DIV
     */
    public BigDecimal getSHIP_GUR_ASSET_FIN_DIV() {
        return SHIP_GUR_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DIV
     *
     * @param SHIP_GUR_ASSET_FIN_DIV the value for TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DIV
     */
    public void setSHIP_GUR_ASSET_FIN_DIV(BigDecimal SHIP_GUR_ASSET_FIN_DIV) {
        this.SHIP_GUR_ASSET_FIN_DIV = SHIP_GUR_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DEPT
     */
    public BigDecimal getSHIP_GUR_ASSET_FIN_DEPT() {
        return SHIP_GUR_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DEPT
     *
     * @param SHIP_GUR_ASSET_FIN_DEPT the value for TFSDOCTYPE.SHIP_GUR_ASSET_FIN_DEPT
     */
    public void setSHIP_GUR_ASSET_FIN_DEPT(BigDecimal SHIP_GUR_ASSET_FIN_DEPT) {
        this.SHIP_GUR_ASSET_FIN_DEPT = SHIP_GUR_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_FIN_GL
     */
    public BigDecimal getSHIP_GUR_LIAB_FIN_GL() {
        return SHIP_GUR_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_GL
     *
     * @param SHIP_GUR_LIAB_FIN_GL the value for TFSDOCTYPE.SHIP_GUR_LIAB_FIN_GL
     */
    public void setSHIP_GUR_LIAB_FIN_GL(BigDecimal SHIP_GUR_LIAB_FIN_GL) {
        this.SHIP_GUR_LIAB_FIN_GL = SHIP_GUR_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DIV
     */
    public BigDecimal getSHIP_GUR_LIAB_FIN_DIV() {
        return SHIP_GUR_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DIV
     *
     * @param SHIP_GUR_LIAB_FIN_DIV the value for TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DIV
     */
    public void setSHIP_GUR_LIAB_FIN_DIV(BigDecimal SHIP_GUR_LIAB_FIN_DIV) {
        this.SHIP_GUR_LIAB_FIN_DIV = SHIP_GUR_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DEPT
     */
    public BigDecimal getSHIP_GUR_LIAB_FIN_DEPT() {
        return SHIP_GUR_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DEPT
     *
     * @param SHIP_GUR_LIAB_FIN_DEPT the value for TFSDOCTYPE.SHIP_GUR_LIAB_FIN_DEPT
     */
    public void setSHIP_GUR_LIAB_FIN_DEPT(BigDecimal SHIP_GUR_LIAB_FIN_DEPT) {
        this.SHIP_GUR_LIAB_FIN_DEPT = SHIP_GUR_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_GL
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_GL() {
        return LC_INW_SIGHT_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_GL
     *
     * @param LC_INW_SIGHT_ASSET_GL the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_GL
     */
    public void setLC_INW_SIGHT_ASSET_GL(BigDecimal LC_INW_SIGHT_ASSET_GL) {
        this.LC_INW_SIGHT_ASSET_GL = LC_INW_SIGHT_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_DIV
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_DIV() {
        return LC_INW_SIGHT_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DIV
     *
     * @param LC_INW_SIGHT_ASSET_DIV the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_DIV
     */
    public void setLC_INW_SIGHT_ASSET_DIV(BigDecimal LC_INW_SIGHT_ASSET_DIV) {
        this.LC_INW_SIGHT_ASSET_DIV = LC_INW_SIGHT_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_DEPT
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_DEPT() {
        return LC_INW_SIGHT_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_DEPT
     *
     * @param LC_INW_SIGHT_ASSET_DEPT the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_DEPT
     */
    public void setLC_INW_SIGHT_ASSET_DEPT(BigDecimal LC_INW_SIGHT_ASSET_DEPT) {
        this.LC_INW_SIGHT_ASSET_DEPT = LC_INW_SIGHT_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_GL
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_GL() {
        return LC_INW_SIGHT_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_GL
     *
     * @param LC_INW_SIGHT_LIAB_GL the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_GL
     */
    public void setLC_INW_SIGHT_LIAB_GL(BigDecimal LC_INW_SIGHT_LIAB_GL) {
        this.LC_INW_SIGHT_LIAB_GL = LC_INW_SIGHT_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_DIV
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_DIV() {
        return LC_INW_SIGHT_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DIV
     *
     * @param LC_INW_SIGHT_LIAB_DIV the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_DIV
     */
    public void setLC_INW_SIGHT_LIAB_DIV(BigDecimal LC_INW_SIGHT_LIAB_DIV) {
        this.LC_INW_SIGHT_LIAB_DIV = LC_INW_SIGHT_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_DEPT
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_DEPT() {
        return LC_INW_SIGHT_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_DEPT
     *
     * @param LC_INW_SIGHT_LIAB_DEPT the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_DEPT
     */
    public void setLC_INW_SIGHT_LIAB_DEPT(BigDecimal LC_INW_SIGHT_LIAB_DEPT) {
        this.LC_INW_SIGHT_LIAB_DEPT = LC_INW_SIGHT_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_GL
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_FIN_GL() {
        return LC_INW_SIGHT_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_GL
     *
     * @param LC_INW_SIGHT_ASSET_FIN_GL the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_GL
     */
    public void setLC_INW_SIGHT_ASSET_FIN_GL(BigDecimal LC_INW_SIGHT_ASSET_FIN_GL) {
        this.LC_INW_SIGHT_ASSET_FIN_GL = LC_INW_SIGHT_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DIV
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_FIN_DIV() {
        return LC_INW_SIGHT_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DIV
     *
     * @param LC_INW_SIGHT_ASSET_FIN_DIV the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DIV
     */
    public void setLC_INW_SIGHT_ASSET_FIN_DIV(BigDecimal LC_INW_SIGHT_ASSET_FIN_DIV) {
        this.LC_INW_SIGHT_ASSET_FIN_DIV = LC_INW_SIGHT_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DEPT
     */
    public BigDecimal getLC_INW_SIGHT_ASSET_FIN_DEPT() {
        return LC_INW_SIGHT_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DEPT
     *
     * @param LC_INW_SIGHT_ASSET_FIN_DEPT the value for TFSDOCTYPE.LC_INW_SIGHT_ASSET_FIN_DEPT
     */
    public void setLC_INW_SIGHT_ASSET_FIN_DEPT(BigDecimal LC_INW_SIGHT_ASSET_FIN_DEPT) {
        this.LC_INW_SIGHT_ASSET_FIN_DEPT = LC_INW_SIGHT_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_GL
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_FIN_GL() {
        return LC_INW_SIGHT_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_GL
     *
     * @param LC_INW_SIGHT_LIAB_FIN_GL the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_GL
     */
    public void setLC_INW_SIGHT_LIAB_FIN_GL(BigDecimal LC_INW_SIGHT_LIAB_FIN_GL) {
        this.LC_INW_SIGHT_LIAB_FIN_GL = LC_INW_SIGHT_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DIV
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_FIN_DIV() {
        return LC_INW_SIGHT_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DIV
     *
     * @param LC_INW_SIGHT_LIAB_FIN_DIV the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DIV
     */
    public void setLC_INW_SIGHT_LIAB_FIN_DIV(BigDecimal LC_INW_SIGHT_LIAB_FIN_DIV) {
        this.LC_INW_SIGHT_LIAB_FIN_DIV = LC_INW_SIGHT_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DEPT
     */
    public BigDecimal getLC_INW_SIGHT_LIAB_FIN_DEPT() {
        return LC_INW_SIGHT_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DEPT
     *
     * @param LC_INW_SIGHT_LIAB_FIN_DEPT the value for TFSDOCTYPE.LC_INW_SIGHT_LIAB_FIN_DEPT
     */
    public void setLC_INW_SIGHT_LIAB_FIN_DEPT(BigDecimal LC_INW_SIGHT_LIAB_FIN_DEPT) {
        this.LC_INW_SIGHT_LIAB_FIN_DEPT = LC_INW_SIGHT_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_GL
     */
    public BigDecimal getLC_INW_TIME_ASSET_GL() {
        return LC_INW_TIME_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_GL
     *
     * @param LC_INW_TIME_ASSET_GL the value for TFSDOCTYPE.LC_INW_TIME_ASSET_GL
     */
    public void setLC_INW_TIME_ASSET_GL(BigDecimal LC_INW_TIME_ASSET_GL) {
        this.LC_INW_TIME_ASSET_GL = LC_INW_TIME_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_DIV
     */
    public BigDecimal getLC_INW_TIME_ASSET_DIV() {
        return LC_INW_TIME_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DIV
     *
     * @param LC_INW_TIME_ASSET_DIV the value for TFSDOCTYPE.LC_INW_TIME_ASSET_DIV
     */
    public void setLC_INW_TIME_ASSET_DIV(BigDecimal LC_INW_TIME_ASSET_DIV) {
        this.LC_INW_TIME_ASSET_DIV = LC_INW_TIME_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_DEPT
     */
    public BigDecimal getLC_INW_TIME_ASSET_DEPT() {
        return LC_INW_TIME_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_DEPT
     *
     * @param LC_INW_TIME_ASSET_DEPT the value for TFSDOCTYPE.LC_INW_TIME_ASSET_DEPT
     */
    public void setLC_INW_TIME_ASSET_DEPT(BigDecimal LC_INW_TIME_ASSET_DEPT) {
        this.LC_INW_TIME_ASSET_DEPT = LC_INW_TIME_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_GL
     */
    public BigDecimal getLC_INW_TIME_LIAB_GL() {
        return LC_INW_TIME_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_GL
     *
     * @param LC_INW_TIME_LIAB_GL the value for TFSDOCTYPE.LC_INW_TIME_LIAB_GL
     */
    public void setLC_INW_TIME_LIAB_GL(BigDecimal LC_INW_TIME_LIAB_GL) {
        this.LC_INW_TIME_LIAB_GL = LC_INW_TIME_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_DIV
     */
    public BigDecimal getLC_INW_TIME_LIAB_DIV() {
        return LC_INW_TIME_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DIV
     *
     * @param LC_INW_TIME_LIAB_DIV the value for TFSDOCTYPE.LC_INW_TIME_LIAB_DIV
     */
    public void setLC_INW_TIME_LIAB_DIV(BigDecimal LC_INW_TIME_LIAB_DIV) {
        this.LC_INW_TIME_LIAB_DIV = LC_INW_TIME_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_DEPT
     */
    public BigDecimal getLC_INW_TIME_LIAB_DEPT() {
        return LC_INW_TIME_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_DEPT
     *
     * @param LC_INW_TIME_LIAB_DEPT the value for TFSDOCTYPE.LC_INW_TIME_LIAB_DEPT
     */
    public void setLC_INW_TIME_LIAB_DEPT(BigDecimal LC_INW_TIME_LIAB_DEPT) {
        this.LC_INW_TIME_LIAB_DEPT = LC_INW_TIME_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_GL
     */
    public BigDecimal getLC_INW_TIME_ASSET_FIN_GL() {
        return LC_INW_TIME_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_GL
     *
     * @param LC_INW_TIME_ASSET_FIN_GL the value for TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_GL
     */
    public void setLC_INW_TIME_ASSET_FIN_GL(BigDecimal LC_INW_TIME_ASSET_FIN_GL) {
        this.LC_INW_TIME_ASSET_FIN_GL = LC_INW_TIME_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DIV
     */
    public BigDecimal getLC_INW_TIME_ASSET_FIN_DIV() {
        return LC_INW_TIME_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DIV
     *
     * @param LC_INW_TIME_ASSET_FIN_DIV the value for TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DIV
     */
    public void setLC_INW_TIME_ASSET_FIN_DIV(BigDecimal LC_INW_TIME_ASSET_FIN_DIV) {
        this.LC_INW_TIME_ASSET_FIN_DIV = LC_INW_TIME_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DEPT
     */
    public BigDecimal getLC_INW_TIME_ASSET_FIN_DEPT() {
        return LC_INW_TIME_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DEPT
     *
     * @param LC_INW_TIME_ASSET_FIN_DEPT the value for TFSDOCTYPE.LC_INW_TIME_ASSET_FIN_DEPT
     */
    public void setLC_INW_TIME_ASSET_FIN_DEPT(BigDecimal LC_INW_TIME_ASSET_FIN_DEPT) {
        this.LC_INW_TIME_ASSET_FIN_DEPT = LC_INW_TIME_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_GL
     */
    public BigDecimal getLC_INW_TIME_LIAB_FIN_GL() {
        return LC_INW_TIME_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_GL
     *
     * @param LC_INW_TIME_LIAB_FIN_GL the value for TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_GL
     */
    public void setLC_INW_TIME_LIAB_FIN_GL(BigDecimal LC_INW_TIME_LIAB_FIN_GL) {
        this.LC_INW_TIME_LIAB_FIN_GL = LC_INW_TIME_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DIV
     */
    public BigDecimal getLC_INW_TIME_LIAB_FIN_DIV() {
        return LC_INW_TIME_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DIV
     *
     * @param LC_INW_TIME_LIAB_FIN_DIV the value for TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DIV
     */
    public void setLC_INW_TIME_LIAB_FIN_DIV(BigDecimal LC_INW_TIME_LIAB_FIN_DIV) {
        this.LC_INW_TIME_LIAB_FIN_DIV = LC_INW_TIME_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DEPT
     */
    public BigDecimal getLC_INW_TIME_LIAB_FIN_DEPT() {
        return LC_INW_TIME_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DEPT
     *
     * @param LC_INW_TIME_LIAB_FIN_DEPT the value for TFSDOCTYPE.LC_INW_TIME_LIAB_FIN_DEPT
     */
    public void setLC_INW_TIME_LIAB_FIN_DEPT(BigDecimal LC_INW_TIME_LIAB_FIN_DEPT) {
        this.LC_INW_TIME_LIAB_FIN_DEPT = LC_INW_TIME_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_GL
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_GL() {
        return LC_INW_ACCEPT_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_GL
     *
     * @param LC_INW_ACCEPT_ASSET_GL the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_GL
     */
    public void setLC_INW_ACCEPT_ASSET_GL(BigDecimal LC_INW_ACCEPT_ASSET_GL) {
        this.LC_INW_ACCEPT_ASSET_GL = LC_INW_ACCEPT_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DIV
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_DIV() {
        return LC_INW_ACCEPT_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DIV
     *
     * @param LC_INW_ACCEPT_ASSET_DIV the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DIV
     */
    public void setLC_INW_ACCEPT_ASSET_DIV(BigDecimal LC_INW_ACCEPT_ASSET_DIV) {
        this.LC_INW_ACCEPT_ASSET_DIV = LC_INW_ACCEPT_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DEPT
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_DEPT() {
        return LC_INW_ACCEPT_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DEPT
     *
     * @param LC_INW_ACCEPT_ASSET_DEPT the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_DEPT
     */
    public void setLC_INW_ACCEPT_ASSET_DEPT(BigDecimal LC_INW_ACCEPT_ASSET_DEPT) {
        this.LC_INW_ACCEPT_ASSET_DEPT = LC_INW_ACCEPT_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_GL
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_GL() {
        return LC_INW_ACCEPT_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_GL
     *
     * @param LC_INW_ACCEPT_LIAB_GL the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_GL
     */
    public void setLC_INW_ACCEPT_LIAB_GL(BigDecimal LC_INW_ACCEPT_LIAB_GL) {
        this.LC_INW_ACCEPT_LIAB_GL = LC_INW_ACCEPT_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DIV
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_DIV() {
        return LC_INW_ACCEPT_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DIV
     *
     * @param LC_INW_ACCEPT_LIAB_DIV the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DIV
     */
    public void setLC_INW_ACCEPT_LIAB_DIV(BigDecimal LC_INW_ACCEPT_LIAB_DIV) {
        this.LC_INW_ACCEPT_LIAB_DIV = LC_INW_ACCEPT_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DEPT
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_DEPT() {
        return LC_INW_ACCEPT_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DEPT
     *
     * @param LC_INW_ACCEPT_LIAB_DEPT the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_DEPT
     */
    public void setLC_INW_ACCEPT_LIAB_DEPT(BigDecimal LC_INW_ACCEPT_LIAB_DEPT) {
        this.LC_INW_ACCEPT_LIAB_DEPT = LC_INW_ACCEPT_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_GL
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_FIN_GL() {
        return LC_INW_ACCEPT_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_GL
     *
     * @param LC_INW_ACCEPT_ASSET_FIN_GL the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_GL
     */
    public void setLC_INW_ACCEPT_ASSET_FIN_GL(BigDecimal LC_INW_ACCEPT_ASSET_FIN_GL) {
        this.LC_INW_ACCEPT_ASSET_FIN_GL = LC_INW_ACCEPT_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DIV
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_FIN_DIV() {
        return LC_INW_ACCEPT_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DIV
     *
     * @param LC_INW_ACCEPT_ASSET_FIN_DIV the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DIV
     */
    public void setLC_INW_ACCEPT_ASSET_FIN_DIV(BigDecimal LC_INW_ACCEPT_ASSET_FIN_DIV) {
        this.LC_INW_ACCEPT_ASSET_FIN_DIV = LC_INW_ACCEPT_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DEPT
     */
    public BigDecimal getLC_INW_ACCEPT_ASSET_FIN_DEPT() {
        return LC_INW_ACCEPT_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DEPT
     *
     * @param LC_INW_ACCEPT_ASSET_FIN_DEPT the value for TFSDOCTYPE.LC_INW_ACCEPT_ASSET_FIN_DEPT
     */
    public void setLC_INW_ACCEPT_ASSET_FIN_DEPT(BigDecimal LC_INW_ACCEPT_ASSET_FIN_DEPT) {
        this.LC_INW_ACCEPT_ASSET_FIN_DEPT = LC_INW_ACCEPT_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_GL
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_FIN_GL() {
        return LC_INW_ACCEPT_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_GL
     *
     * @param LC_INW_ACCEPT_LIAB_FIN_GL the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_GL
     */
    public void setLC_INW_ACCEPT_LIAB_FIN_GL(BigDecimal LC_INW_ACCEPT_LIAB_FIN_GL) {
        this.LC_INW_ACCEPT_LIAB_FIN_GL = LC_INW_ACCEPT_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DIV
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_FIN_DIV() {
        return LC_INW_ACCEPT_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DIV
     *
     * @param LC_INW_ACCEPT_LIAB_FIN_DIV the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DIV
     */
    public void setLC_INW_ACCEPT_LIAB_FIN_DIV(BigDecimal LC_INW_ACCEPT_LIAB_FIN_DIV) {
        this.LC_INW_ACCEPT_LIAB_FIN_DIV = LC_INW_ACCEPT_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DEPT
     */
    public BigDecimal getLC_INW_ACCEPT_LIAB_FIN_DEPT() {
        return LC_INW_ACCEPT_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DEPT
     *
     * @param LC_INW_ACCEPT_LIAB_FIN_DEPT the value for TFSDOCTYPE.LC_INW_ACCEPT_LIAB_FIN_DEPT
     */
    public void setLC_INW_ACCEPT_LIAB_FIN_DEPT(BigDecimal LC_INW_ACCEPT_LIAB_FIN_DEPT) {
        this.LC_INW_ACCEPT_LIAB_FIN_DEPT = LC_INW_ACCEPT_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LG_CASH_ASSET_GL
     */
    public BigDecimal getLG_CASH_ASSET_GL() {
        return LG_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_ASSET_GL
     *
     * @param LG_CASH_ASSET_GL the value for TFSDOCTYPE.LG_CASH_ASSET_GL
     */
    public void setLG_CASH_ASSET_GL(BigDecimal LG_CASH_ASSET_GL) {
        this.LG_CASH_ASSET_GL = LG_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LG_CASH_ASSET_DIV
     */
    public BigDecimal getLG_CASH_ASSET_DIV() {
        return LG_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_ASSET_DIV
     *
     * @param LG_CASH_ASSET_DIV the value for TFSDOCTYPE.LG_CASH_ASSET_DIV
     */
    public void setLG_CASH_ASSET_DIV(BigDecimal LG_CASH_ASSET_DIV) {
        this.LG_CASH_ASSET_DIV = LG_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_CASH_ASSET_DEPT
     */
    public BigDecimal getLG_CASH_ASSET_DEPT() {
        return LG_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_ASSET_DEPT
     *
     * @param LG_CASH_ASSET_DEPT the value for TFSDOCTYPE.LG_CASH_ASSET_DEPT
     */
    public void setLG_CASH_ASSET_DEPT(BigDecimal LG_CASH_ASSET_DEPT) {
        this.LG_CASH_ASSET_DEPT = LG_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LG_CASH_LIAB_GL
     */
    public BigDecimal getLG_CASH_LIAB_GL() {
        return LG_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_LIAB_GL
     *
     * @param LG_CASH_LIAB_GL the value for TFSDOCTYPE.LG_CASH_LIAB_GL
     */
    public void setLG_CASH_LIAB_GL(BigDecimal LG_CASH_LIAB_GL) {
        this.LG_CASH_LIAB_GL = LG_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LG_CASH_LIAB_DIV
     */
    public BigDecimal getLG_CASH_LIAB_DIV() {
        return LG_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_LIAB_DIV
     *
     * @param LG_CASH_LIAB_DIV the value for TFSDOCTYPE.LG_CASH_LIAB_DIV
     */
    public void setLG_CASH_LIAB_DIV(BigDecimal LG_CASH_LIAB_DIV) {
        this.LG_CASH_LIAB_DIV = LG_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_CASH_LIAB_DEPT
     */
    public BigDecimal getLG_CASH_LIAB_DEPT() {
        return LG_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_LIAB_DEPT
     *
     * @param LG_CASH_LIAB_DEPT the value for TFSDOCTYPE.LG_CASH_LIAB_DEPT
     */
    public void setLG_CASH_LIAB_DEPT(BigDecimal LG_CASH_LIAB_DEPT) {
        this.LG_CASH_LIAB_DEPT = LG_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LG_FIN_ASSET_GL
     */
    public BigDecimal getLG_FIN_ASSET_GL() {
        return LG_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_ASSET_GL
     *
     * @param LG_FIN_ASSET_GL the value for TFSDOCTYPE.LG_FIN_ASSET_GL
     */
    public void setLG_FIN_ASSET_GL(BigDecimal LG_FIN_ASSET_GL) {
        this.LG_FIN_ASSET_GL = LG_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LG_FIN_ASSET_DIV
     */
    public BigDecimal getLG_FIN_ASSET_DIV() {
        return LG_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_ASSET_DIV
     *
     * @param LG_FIN_ASSET_DIV the value for TFSDOCTYPE.LG_FIN_ASSET_DIV
     */
    public void setLG_FIN_ASSET_DIV(BigDecimal LG_FIN_ASSET_DIV) {
        this.LG_FIN_ASSET_DIV = LG_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_FIN_ASSET_DEPT
     */
    public BigDecimal getLG_FIN_ASSET_DEPT() {
        return LG_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_ASSET_DEPT
     *
     * @param LG_FIN_ASSET_DEPT the value for TFSDOCTYPE.LG_FIN_ASSET_DEPT
     */
    public void setLG_FIN_ASSET_DEPT(BigDecimal LG_FIN_ASSET_DEPT) {
        this.LG_FIN_ASSET_DEPT = LG_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LG_FIN_LIAB_GL
     */
    public BigDecimal getLG_FIN_LIAB_GL() {
        return LG_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_LIAB_GL
     *
     * @param LG_FIN_LIAB_GL the value for TFSDOCTYPE.LG_FIN_LIAB_GL
     */
    public void setLG_FIN_LIAB_GL(BigDecimal LG_FIN_LIAB_GL) {
        this.LG_FIN_LIAB_GL = LG_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LG_FIN_LIAB_DIV
     */
    public BigDecimal getLG_FIN_LIAB_DIV() {
        return LG_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_LIAB_DIV
     *
     * @param LG_FIN_LIAB_DIV the value for TFSDOCTYPE.LG_FIN_LIAB_DIV
     */
    public void setLG_FIN_LIAB_DIV(BigDecimal LG_FIN_LIAB_DIV) {
        this.LG_FIN_LIAB_DIV = LG_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_FIN_LIAB_DEPT
     */
    public BigDecimal getLG_FIN_LIAB_DEPT() {
        return LG_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_LIAB_DEPT
     *
     * @param LG_FIN_LIAB_DEPT the value for TFSDOCTYPE.LG_FIN_LIAB_DEPT
     */
    public void setLG_FIN_LIAB_DEPT(BigDecimal LG_FIN_LIAB_DEPT) {
        this.LG_FIN_LIAB_DEPT = LG_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_FIN_GL
     */
    public BigDecimal getBILLS_LIAB_FIN_GL() {
        return BILLS_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_GL
     *
     * @param BILLS_LIAB_FIN_GL the value for TFSDOCTYPE.BILLS_LIAB_FIN_GL
     */
    public void setBILLS_LIAB_FIN_GL(BigDecimal BILLS_LIAB_FIN_GL) {
        this.BILLS_LIAB_FIN_GL = BILLS_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_FIN_DIV
     */
    public BigDecimal getBILLS_LIAB_FIN_DIV() {
        return BILLS_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_DIV
     *
     * @param BILLS_LIAB_FIN_DIV the value for TFSDOCTYPE.BILLS_LIAB_FIN_DIV
     */
    public void setBILLS_LIAB_FIN_DIV(BigDecimal BILLS_LIAB_FIN_DIV) {
        this.BILLS_LIAB_FIN_DIV = BILLS_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_DEP
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_FIN_DEP
     */
    public BigDecimal getBILLS_LIAB_FIN_DEP() {
        return BILLS_LIAB_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_FIN_DEP
     *
     * @param BILLS_LIAB_FIN_DEP the value for TFSDOCTYPE.BILLS_LIAB_FIN_DEP
     */
    public void setBILLS_LIAB_FIN_DEP(BigDecimal BILLS_LIAB_FIN_DEP) {
        this.BILLS_LIAB_FIN_DEP = BILLS_LIAB_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_FIN_GL
     */
    public BigDecimal getBILLS_ASSET_FIN_GL() {
        return BILLS_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_GL
     *
     * @param BILLS_ASSET_FIN_GL the value for TFSDOCTYPE.BILLS_ASSET_FIN_GL
     */
    public void setBILLS_ASSET_FIN_GL(BigDecimal BILLS_ASSET_FIN_GL) {
        this.BILLS_ASSET_FIN_GL = BILLS_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_FIN_DIV
     */
    public BigDecimal getBILLS_ASSET_FIN_DIV() {
        return BILLS_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_DIV
     *
     * @param BILLS_ASSET_FIN_DIV the value for TFSDOCTYPE.BILLS_ASSET_FIN_DIV
     */
    public void setBILLS_ASSET_FIN_DIV(BigDecimal BILLS_ASSET_FIN_DIV) {
        this.BILLS_ASSET_FIN_DIV = BILLS_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_DEP
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_FIN_DEP
     */
    public BigDecimal getBILLS_ASSET_FIN_DEP() {
        return BILLS_ASSET_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_FIN_DEP
     *
     * @param BILLS_ASSET_FIN_DEP the value for TFSDOCTYPE.BILLS_ASSET_FIN_DEP
     */
    public void setBILLS_ASSET_FIN_DEP(BigDecimal BILLS_ASSET_FIN_DEP) {
        this.BILLS_ASSET_FIN_DEP = BILLS_ASSET_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ABOUT_APPLY
     *
     * @return the value of TFSDOCTYPE.ABOUT_APPLY
     */
    public String getABOUT_APPLY() {
        return ABOUT_APPLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ABOUT_APPLY
     *
     * @param ABOUT_APPLY the value for TFSDOCTYPE.ABOUT_APPLY
     */
    public void setABOUT_APPLY(String ABOUT_APPLY) {
        this.ABOUT_APPLY = ABOUT_APPLY == null ? null : ABOUT_APPLY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ABOUT_PCT
     *
     * @return the value of TFSDOCTYPE.ABOUT_PCT
     */
    public BigDecimal getABOUT_PCT() {
        return ABOUT_PCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ABOUT_PCT
     *
     * @param ABOUT_PCT the value for TFSDOCTYPE.ABOUT_PCT
     */
    public void setABOUT_PCT(BigDecimal ABOUT_PCT) {
        this.ABOUT_PCT = ABOUT_PCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MARGIN_APPLY
     *
     * @return the value of TFSDOCTYPE.MARGIN_APPLY
     */
    public String getMARGIN_APPLY() {
        return MARGIN_APPLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MARGIN_APPLY
     *
     * @param MARGIN_APPLY the value for TFSDOCTYPE.MARGIN_APPLY
     */
    public void setMARGIN_APPLY(String MARGIN_APPLY) {
        this.MARGIN_APPLY = MARGIN_APPLY == null ? null : MARGIN_APPLY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MARGIN_PCT
     *
     * @return the value of TFSDOCTYPE.MARGIN_PCT
     */
    public BigDecimal getMARGIN_PCT() {
        return MARGIN_PCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MARGIN_PCT
     *
     * @param MARGIN_PCT the value for TFSDOCTYPE.MARGIN_PCT
     */
    public void setMARGIN_PCT(BigDecimal MARGIN_PCT) {
        this.MARGIN_PCT = MARGIN_PCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ABOUT_MODIFY
     *
     * @return the value of TFSDOCTYPE.ABOUT_MODIFY
     */
    public String getABOUT_MODIFY() {
        return ABOUT_MODIFY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ABOUT_MODIFY
     *
     * @param ABOUT_MODIFY the value for TFSDOCTYPE.ABOUT_MODIFY
     */
    public void setABOUT_MODIFY(String ABOUT_MODIFY) {
        this.ABOUT_MODIFY = ABOUT_MODIFY == null ? null : ABOUT_MODIFY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MARGIN_MODIFY
     *
     * @return the value of TFSDOCTYPE.MARGIN_MODIFY
     */
    public String getMARGIN_MODIFY() {
        return MARGIN_MODIFY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MARGIN_MODIFY
     *
     * @param MARGIN_MODIFY the value for TFSDOCTYPE.MARGIN_MODIFY
     */
    public void setMARGIN_MODIFY(String MARGIN_MODIFY) {
        this.MARGIN_MODIFY = MARGIN_MODIFY == null ? null : MARGIN_MODIFY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_SHIP
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_SHIP
     */
    public BigDecimal getTEMP_TYPE_SHIP() {
        return TEMP_TYPE_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_SHIP
     *
     * @param TEMP_TYPE_SHIP the value for TFSDOCTYPE.TEMP_TYPE_SHIP
     */
    public void setTEMP_TYPE_SHIP(BigDecimal TEMP_TYPE_SHIP) {
        this.TEMP_TYPE_SHIP = TEMP_TYPE_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_SHIP
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_SHIP
     */
    public BigDecimal getTEMP_CODE_SHIP() {
        return TEMP_CODE_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_SHIP
     *
     * @param TEMP_CODE_SHIP the value for TFSDOCTYPE.TEMP_CODE_SHIP
     */
    public void setTEMP_CODE_SHIP(BigDecimal TEMP_CODE_SHIP) {
        this.TEMP_CODE_SHIP = TEMP_CODE_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_SHIP
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_SHIP
     */
    public String getTEMP_MODIF_SHIP() {
        return TEMP_MODIF_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_SHIP
     *
     * @param TEMP_MODIF_SHIP the value for TFSDOCTYPE.TEMP_MODIF_SHIP
     */
    public void setTEMP_MODIF_SHIP(String TEMP_MODIF_SHIP) {
        this.TEMP_MODIF_SHIP = TEMP_MODIF_SHIP == null ? null : TEMP_MODIF_SHIP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_SHIP
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_SHIP
     */
    public String getTEMP_SHOW_SHIP() {
        return TEMP_SHOW_SHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_SHIP
     *
     * @param TEMP_SHOW_SHIP the value for TFSDOCTYPE.TEMP_SHOW_SHIP
     */
    public void setTEMP_SHOW_SHIP(String TEMP_SHOW_SHIP) {
        this.TEMP_SHOW_SHIP = TEMP_SHOW_SHIP == null ? null : TEMP_SHOW_SHIP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_AMEND
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_AMEND
     */
    public BigDecimal getTEMP_TYPE_AMEND() {
        return TEMP_TYPE_AMEND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_AMEND
     *
     * @param TEMP_TYPE_AMEND the value for TFSDOCTYPE.TEMP_TYPE_AMEND
     */
    public void setTEMP_TYPE_AMEND(BigDecimal TEMP_TYPE_AMEND) {
        this.TEMP_TYPE_AMEND = TEMP_TYPE_AMEND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_SIGHTTIME
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_SIGHTTIME
     */
    public BigDecimal getTEMP_CODE_SIGHTTIME() {
        return TEMP_CODE_SIGHTTIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_SIGHTTIME
     *
     * @param TEMP_CODE_SIGHTTIME the value for TFSDOCTYPE.TEMP_CODE_SIGHTTIME
     */
    public void setTEMP_CODE_SIGHTTIME(BigDecimal TEMP_CODE_SIGHTTIME) {
        this.TEMP_CODE_SIGHTTIME = TEMP_CODE_SIGHTTIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_TIMESIGHT
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_TIMESIGHT
     */
    public BigDecimal getTEMP_CODE_TIMESIGHT() {
        return TEMP_CODE_TIMESIGHT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_TIMESIGHT
     *
     * @param TEMP_CODE_TIMESIGHT the value for TFSDOCTYPE.TEMP_CODE_TIMESIGHT
     */
    public void setTEMP_CODE_TIMESIGHT(BigDecimal TEMP_CODE_TIMESIGHT) {
        this.TEMP_CODE_TIMESIGHT = TEMP_CODE_TIMESIGHT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_AMEND
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_AMEND
     */
    public String getTEMP_MODIF_AMEND() {
        return TEMP_MODIF_AMEND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_AMEND
     *
     * @param TEMP_MODIF_AMEND the value for TFSDOCTYPE.TEMP_MODIF_AMEND
     */
    public void setTEMP_MODIF_AMEND(String TEMP_MODIF_AMEND) {
        this.TEMP_MODIF_AMEND = TEMP_MODIF_AMEND == null ? null : TEMP_MODIF_AMEND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_AMEND
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_AMEND
     */
    public String getTEMP_SHOW_AMEND() {
        return TEMP_SHOW_AMEND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_AMEND
     *
     * @param TEMP_SHOW_AMEND the value for TFSDOCTYPE.TEMP_SHOW_AMEND
     */
    public void setTEMP_SHOW_AMEND(String TEMP_SHOW_AMEND) {
        this.TEMP_SHOW_AMEND = TEMP_SHOW_AMEND == null ? null : TEMP_SHOW_AMEND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_CSHIP
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_CSHIP
     */
    public BigDecimal getTEMP_CODE_CSHIP() {
        return TEMP_CODE_CSHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_CSHIP
     *
     * @param TEMP_CODE_CSHIP the value for TFSDOCTYPE.TEMP_CODE_CSHIP
     */
    public void setTEMP_CODE_CSHIP(BigDecimal TEMP_CODE_CSHIP) {
        this.TEMP_CODE_CSHIP = TEMP_CODE_CSHIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_AMOUNT
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_AMOUNT
     */
    public BigDecimal getTEMP_CODE_AMOUNT() {
        return TEMP_CODE_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_AMOUNT
     *
     * @param TEMP_CODE_AMOUNT the value for TFSDOCTYPE.TEMP_CODE_AMOUNT
     */
    public void setTEMP_CODE_AMOUNT(BigDecimal TEMP_CODE_AMOUNT) {
        this.TEMP_CODE_AMOUNT = TEMP_CODE_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_ACCEPT
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_ACCEPT
     */
    public BigDecimal getTEMP_TYPE_ACCEPT() {
        return TEMP_TYPE_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_ACCEPT
     *
     * @param TEMP_TYPE_ACCEPT the value for TFSDOCTYPE.TEMP_TYPE_ACCEPT
     */
    public void setTEMP_TYPE_ACCEPT(BigDecimal TEMP_TYPE_ACCEPT) {
        this.TEMP_TYPE_ACCEPT = TEMP_TYPE_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_ACCEPT
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_ACCEPT
     */
    public BigDecimal getTEMP_CODE_ACCEPT() {
        return TEMP_CODE_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_ACCEPT
     *
     * @param TEMP_CODE_ACCEPT the value for TFSDOCTYPE.TEMP_CODE_ACCEPT
     */
    public void setTEMP_CODE_ACCEPT(BigDecimal TEMP_CODE_ACCEPT) {
        this.TEMP_CODE_ACCEPT = TEMP_CODE_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_ACCEPT
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_ACCEPT
     */
    public String getTEMP_MODIF_ACCEPT() {
        return TEMP_MODIF_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_ACCEPT
     *
     * @param TEMP_MODIF_ACCEPT the value for TFSDOCTYPE.TEMP_MODIF_ACCEPT
     */
    public void setTEMP_MODIF_ACCEPT(String TEMP_MODIF_ACCEPT) {
        this.TEMP_MODIF_ACCEPT = TEMP_MODIF_ACCEPT == null ? null : TEMP_MODIF_ACCEPT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_ACCEPT
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_ACCEPT
     */
    public String getTEMP_SHOW_ACCEPT() {
        return TEMP_SHOW_ACCEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_ACCEPT
     *
     * @param TEMP_SHOW_ACCEPT the value for TFSDOCTYPE.TEMP_SHOW_ACCEPT
     */
    public void setTEMP_SHOW_ACCEPT(String TEMP_SHOW_ACCEPT) {
        this.TEMP_SHOW_ACCEPT = TEMP_SHOW_ACCEPT == null ? null : TEMP_SHOW_ACCEPT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_SETTL
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_SETTL
     */
    public BigDecimal getTEMP_TYPE_SETTL() {
        return TEMP_TYPE_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_SETTL
     *
     * @param TEMP_TYPE_SETTL the value for TFSDOCTYPE.TEMP_TYPE_SETTL
     */
    public void setTEMP_TYPE_SETTL(BigDecimal TEMP_TYPE_SETTL) {
        this.TEMP_TYPE_SETTL = TEMP_TYPE_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_SETTL
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_SETTL
     */
    public BigDecimal getTEMP_CODE_SETTL() {
        return TEMP_CODE_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_SETTL
     *
     * @param TEMP_CODE_SETTL the value for TFSDOCTYPE.TEMP_CODE_SETTL
     */
    public void setTEMP_CODE_SETTL(BigDecimal TEMP_CODE_SETTL) {
        this.TEMP_CODE_SETTL = TEMP_CODE_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_SETTL
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_SETTL
     */
    public String getTEMP_MODIF_SETTL() {
        return TEMP_MODIF_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_SETTL
     *
     * @param TEMP_MODIF_SETTL the value for TFSDOCTYPE.TEMP_MODIF_SETTL
     */
    public void setTEMP_MODIF_SETTL(String TEMP_MODIF_SETTL) {
        this.TEMP_MODIF_SETTL = TEMP_MODIF_SETTL == null ? null : TEMP_MODIF_SETTL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_SETTL
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_SETTL
     */
    public String getTEMP_SHOW_SETTL() {
        return TEMP_SHOW_SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_SETTL
     *
     * @param TEMP_SHOW_SETTL the value for TFSDOCTYPE.TEMP_SHOW_SETTL
     */
    public void setTEMP_SHOW_SETTL(String TEMP_SHOW_SETTL) {
        this.TEMP_SHOW_SETTL = TEMP_SHOW_SETTL == null ? null : TEMP_SHOW_SETTL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_GL
     */
    public BigDecimal getBILLS_ACCEPT_FIN_ASSET_GL() {
        return BILLS_ACCEPT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_GL
     *
     * @param BILLS_ACCEPT_FIN_ASSET_GL the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_GL
     */
    public void setBILLS_ACCEPT_FIN_ASSET_GL(BigDecimal BILLS_ACCEPT_FIN_ASSET_GL) {
        this.BILLS_ACCEPT_FIN_ASSET_GL = BILLS_ACCEPT_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DIV
     */
    public BigDecimal getBILLS_ACCEPT_FIN_ASSET_DIV() {
        return BILLS_ACCEPT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DIV
     *
     * @param BILLS_ACCEPT_FIN_ASSET_DIV the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DIV
     */
    public void setBILLS_ACCEPT_FIN_ASSET_DIV(BigDecimal BILLS_ACCEPT_FIN_ASSET_DIV) {
        this.BILLS_ACCEPT_FIN_ASSET_DIV = BILLS_ACCEPT_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DEPT
     */
    public BigDecimal getBILLS_ACCEPT_FIN_ASSET_DEPT() {
        return BILLS_ACCEPT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DEPT
     *
     * @param BILLS_ACCEPT_FIN_ASSET_DEPT the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_ASSET_DEPT
     */
    public void setBILLS_ACCEPT_FIN_ASSET_DEPT(BigDecimal BILLS_ACCEPT_FIN_ASSET_DEPT) {
        this.BILLS_ACCEPT_FIN_ASSET_DEPT = BILLS_ACCEPT_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_GL
     */
    public BigDecimal getBILLS_ACCEPT_CASH_ASSET_GL() {
        return BILLS_ACCEPT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_GL
     *
     * @param BILLS_ACCEPT_CASH_ASSET_GL the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_GL
     */
    public void setBILLS_ACCEPT_CASH_ASSET_GL(BigDecimal BILLS_ACCEPT_CASH_ASSET_GL) {
        this.BILLS_ACCEPT_CASH_ASSET_GL = BILLS_ACCEPT_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DIV
     */
    public BigDecimal getBILLS_ACCEPT_CASH_ASSET_DIV() {
        return BILLS_ACCEPT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DIV
     *
     * @param BILLS_ACCEPT_CASH_ASSET_DIV the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DIV
     */
    public void setBILLS_ACCEPT_CASH_ASSET_DIV(BigDecimal BILLS_ACCEPT_CASH_ASSET_DIV) {
        this.BILLS_ACCEPT_CASH_ASSET_DIV = BILLS_ACCEPT_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DEPT
     */
    public BigDecimal getBILLS_ACCEPT_CASH_ASSET_DEPT() {
        return BILLS_ACCEPT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DEPT
     *
     * @param BILLS_ACCEPT_CASH_ASSET_DEPT the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_ASSET_DEPT
     */
    public void setBILLS_ACCEPT_CASH_ASSET_DEPT(BigDecimal BILLS_ACCEPT_CASH_ASSET_DEPT) {
        this.BILLS_ACCEPT_CASH_ASSET_DEPT = BILLS_ACCEPT_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_GL
     */
    public BigDecimal getBILLS_ACCEPT_FIN_LIAB_GL() {
        return BILLS_ACCEPT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_GL
     *
     * @param BILLS_ACCEPT_FIN_LIAB_GL the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_GL
     */
    public void setBILLS_ACCEPT_FIN_LIAB_GL(BigDecimal BILLS_ACCEPT_FIN_LIAB_GL) {
        this.BILLS_ACCEPT_FIN_LIAB_GL = BILLS_ACCEPT_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DIV
     */
    public BigDecimal getBILLS_ACCEPT_FIN_LIAB_DIV() {
        return BILLS_ACCEPT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DIV
     *
     * @param BILLS_ACCEPT_FIN_LIAB_DIV the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DIV
     */
    public void setBILLS_ACCEPT_FIN_LIAB_DIV(BigDecimal BILLS_ACCEPT_FIN_LIAB_DIV) {
        this.BILLS_ACCEPT_FIN_LIAB_DIV = BILLS_ACCEPT_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DEPT
     */
    public BigDecimal getBILLS_ACCEPT_FIN_LIAB_DEPT() {
        return BILLS_ACCEPT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DEPT
     *
     * @param BILLS_ACCEPT_FIN_LIAB_DEPT the value for TFSDOCTYPE.BILLS_ACCEPT_FIN_LIAB_DEPT
     */
    public void setBILLS_ACCEPT_FIN_LIAB_DEPT(BigDecimal BILLS_ACCEPT_FIN_LIAB_DEPT) {
        this.BILLS_ACCEPT_FIN_LIAB_DEPT = BILLS_ACCEPT_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_GL
     */
    public BigDecimal getBILLS_ACCEPT_CASH_LIAB_GL() {
        return BILLS_ACCEPT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_GL
     *
     * @param BILLS_ACCEPT_CASH_LIAB_GL the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_GL
     */
    public void setBILLS_ACCEPT_CASH_LIAB_GL(BigDecimal BILLS_ACCEPT_CASH_LIAB_GL) {
        this.BILLS_ACCEPT_CASH_LIAB_GL = BILLS_ACCEPT_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DIV
     */
    public BigDecimal getBILLS_ACCEPT_CASH_LIAB_DIV() {
        return BILLS_ACCEPT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DIV
     *
     * @param BILLS_ACCEPT_CASH_LIAB_DIV the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DIV
     */
    public void setBILLS_ACCEPT_CASH_LIAB_DIV(BigDecimal BILLS_ACCEPT_CASH_LIAB_DIV) {
        this.BILLS_ACCEPT_CASH_LIAB_DIV = BILLS_ACCEPT_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DEPT
     */
    public BigDecimal getBILLS_ACCEPT_CASH_LIAB_DEPT() {
        return BILLS_ACCEPT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DEPT
     *
     * @param BILLS_ACCEPT_CASH_LIAB_DEPT the value for TFSDOCTYPE.BILLS_ACCEPT_CASH_LIAB_DEPT
     */
    public void setBILLS_ACCEPT_CASH_LIAB_DEPT(BigDecimal BILLS_ACCEPT_CASH_LIAB_DEPT) {
        this.BILLS_ACCEPT_CASH_LIAB_DEPT = BILLS_ACCEPT_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_CLOSE
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_CLOSE
     */
    public BigDecimal getTEMP_TYPE_CLOSE() {
        return TEMP_TYPE_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_CLOSE
     *
     * @param TEMP_TYPE_CLOSE the value for TFSDOCTYPE.TEMP_TYPE_CLOSE
     */
    public void setTEMP_TYPE_CLOSE(BigDecimal TEMP_TYPE_CLOSE) {
        this.TEMP_TYPE_CLOSE = TEMP_TYPE_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_CLOSE
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_CLOSE
     */
    public BigDecimal getTEMP_CODE_CLOSE() {
        return TEMP_CODE_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_CLOSE
     *
     * @param TEMP_CODE_CLOSE the value for TFSDOCTYPE.TEMP_CODE_CLOSE
     */
    public void setTEMP_CODE_CLOSE(BigDecimal TEMP_CODE_CLOSE) {
        this.TEMP_CODE_CLOSE = TEMP_CODE_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_CLOSE
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_CLOSE
     */
    public String getTEMP_MODIF_CLOSE() {
        return TEMP_MODIF_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_CLOSE
     *
     * @param TEMP_MODIF_CLOSE the value for TFSDOCTYPE.TEMP_MODIF_CLOSE
     */
    public void setTEMP_MODIF_CLOSE(String TEMP_MODIF_CLOSE) {
        this.TEMP_MODIF_CLOSE = TEMP_MODIF_CLOSE == null ? null : TEMP_MODIF_CLOSE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_CLOSE
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_CLOSE
     */
    public String getTEMP_SHOW_CLOSE() {
        return TEMP_SHOW_CLOSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_CLOSE
     *
     * @param TEMP_SHOW_CLOSE the value for TFSDOCTYPE.TEMP_SHOW_CLOSE
     */
    public void setTEMP_SHOW_CLOSE(String TEMP_SHOW_CLOSE) {
        this.TEMP_SHOW_CLOSE = TEMP_SHOW_CLOSE == null ? null : TEMP_SHOW_CLOSE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_TYPE_NOSTRO
     *
     * @return the value of TFSDOCTYPE.TEMP_TYPE_NOSTRO
     */
    public BigDecimal getTEMP_TYPE_NOSTRO() {
        return TEMP_TYPE_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_TYPE_NOSTRO
     *
     * @param TEMP_TYPE_NOSTRO the value for TFSDOCTYPE.TEMP_TYPE_NOSTRO
     */
    public void setTEMP_TYPE_NOSTRO(BigDecimal TEMP_TYPE_NOSTRO) {
        this.TEMP_TYPE_NOSTRO = TEMP_TYPE_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_CODE_NOSTRO
     *
     * @return the value of TFSDOCTYPE.TEMP_CODE_NOSTRO
     */
    public BigDecimal getTEMP_CODE_NOSTRO() {
        return TEMP_CODE_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_CODE_NOSTRO
     *
     * @param TEMP_CODE_NOSTRO the value for TFSDOCTYPE.TEMP_CODE_NOSTRO
     */
    public void setTEMP_CODE_NOSTRO(BigDecimal TEMP_CODE_NOSTRO) {
        this.TEMP_CODE_NOSTRO = TEMP_CODE_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_MODIF_NOSTRO
     *
     * @return the value of TFSDOCTYPE.TEMP_MODIF_NOSTRO
     */
    public String getTEMP_MODIF_NOSTRO() {
        return TEMP_MODIF_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_MODIF_NOSTRO
     *
     * @param TEMP_MODIF_NOSTRO the value for TFSDOCTYPE.TEMP_MODIF_NOSTRO
     */
    public void setTEMP_MODIF_NOSTRO(String TEMP_MODIF_NOSTRO) {
        this.TEMP_MODIF_NOSTRO = TEMP_MODIF_NOSTRO == null ? null : TEMP_MODIF_NOSTRO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.TEMP_SHOW_NOSTRO
     *
     * @return the value of TFSDOCTYPE.TEMP_SHOW_NOSTRO
     */
    public String getTEMP_SHOW_NOSTRO() {
        return TEMP_SHOW_NOSTRO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.TEMP_SHOW_NOSTRO
     *
     * @param TEMP_SHOW_NOSTRO the value for TFSDOCTYPE.TEMP_SHOW_NOSTRO
     */
    public void setTEMP_SHOW_NOSTRO(String TEMP_SHOW_NOSTRO) {
        this.TEMP_SHOW_NOSTRO = TEMP_SHOW_NOSTRO == null ? null : TEMP_SHOW_NOSTRO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ABOUT_AMOUNT_PCT
     *
     * @return the value of TFSDOCTYPE.ABOUT_AMOUNT_PCT
     */
    public String getABOUT_AMOUNT_PCT() {
        return ABOUT_AMOUNT_PCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ABOUT_AMOUNT_PCT
     *
     * @param ABOUT_AMOUNT_PCT the value for TFSDOCTYPE.ABOUT_AMOUNT_PCT
     */
    public void setABOUT_AMOUNT_PCT(String ABOUT_AMOUNT_PCT) {
        this.ABOUT_AMOUNT_PCT = ABOUT_AMOUNT_PCT == null ? null : ABOUT_AMOUNT_PCT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DUE_DATE_AFTER
     *
     * @return the value of TFSDOCTYPE.DUE_DATE_AFTER
     */
    public BigDecimal getDUE_DATE_AFTER() {
        return DUE_DATE_AFTER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DUE_DATE_AFTER
     *
     * @param DUE_DATE_AFTER the value for TFSDOCTYPE.DUE_DATE_AFTER
     */
    public void setDUE_DATE_AFTER(BigDecimal DUE_DATE_AFTER) {
        this.DUE_DATE_AFTER = DUE_DATE_AFTER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_TIME_FIN_GL
     */
    public BigDecimal getBILLS_ASSET_TIME_FIN_GL() {
        return BILLS_ASSET_TIME_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_GL
     *
     * @param BILLS_ASSET_TIME_FIN_GL the value for TFSDOCTYPE.BILLS_ASSET_TIME_FIN_GL
     */
    public void setBILLS_ASSET_TIME_FIN_GL(BigDecimal BILLS_ASSET_TIME_FIN_GL) {
        this.BILLS_ASSET_TIME_FIN_GL = BILLS_ASSET_TIME_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DIV
     */
    public BigDecimal getBILLS_ASSET_TIME_FIN_DIV() {
        return BILLS_ASSET_TIME_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DIV
     *
     * @param BILLS_ASSET_TIME_FIN_DIV the value for TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DIV
     */
    public void setBILLS_ASSET_TIME_FIN_DIV(BigDecimal BILLS_ASSET_TIME_FIN_DIV) {
        this.BILLS_ASSET_TIME_FIN_DIV = BILLS_ASSET_TIME_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DEP
     *
     * @return the value of TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DEP
     */
    public BigDecimal getBILLS_ASSET_TIME_FIN_DEP() {
        return BILLS_ASSET_TIME_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DEP
     *
     * @param BILLS_ASSET_TIME_FIN_DEP the value for TFSDOCTYPE.BILLS_ASSET_TIME_FIN_DEP
     */
    public void setBILLS_ASSET_TIME_FIN_DEP(BigDecimal BILLS_ASSET_TIME_FIN_DEP) {
        this.BILLS_ASSET_TIME_FIN_DEP = BILLS_ASSET_TIME_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_TIME_FIN_GL
     */
    public BigDecimal getBILLS_LIAB_TIME_FIN_GL() {
        return BILLS_LIAB_TIME_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_GL
     *
     * @param BILLS_LIAB_TIME_FIN_GL the value for TFSDOCTYPE.BILLS_LIAB_TIME_FIN_GL
     */
    public void setBILLS_LIAB_TIME_FIN_GL(BigDecimal BILLS_LIAB_TIME_FIN_GL) {
        this.BILLS_LIAB_TIME_FIN_GL = BILLS_LIAB_TIME_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DIV
     */
    public BigDecimal getBILLS_LIAB_TIME_FIN_DIV() {
        return BILLS_LIAB_TIME_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DIV
     *
     * @param BILLS_LIAB_TIME_FIN_DIV the value for TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DIV
     */
    public void setBILLS_LIAB_TIME_FIN_DIV(BigDecimal BILLS_LIAB_TIME_FIN_DIV) {
        this.BILLS_LIAB_TIME_FIN_DIV = BILLS_LIAB_TIME_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DEP
     *
     * @return the value of TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DEP
     */
    public BigDecimal getBILLS_LIAB_TIME_FIN_DEP() {
        return BILLS_LIAB_TIME_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DEP
     *
     * @param BILLS_LIAB_TIME_FIN_DEP the value for TFSDOCTYPE.BILLS_LIAB_TIME_FIN_DEP
     */
    public void setBILLS_LIAB_TIME_FIN_DEP(BigDecimal BILLS_LIAB_TIME_FIN_DEP) {
        this.BILLS_LIAB_TIME_FIN_DEP = BILLS_LIAB_TIME_FIN_DEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CHECK_INCREMENT_SL
     *
     * @return the value of TFSDOCTYPE.CHECK_INCREMENT_SL
     */
    public BigDecimal getCHECK_INCREMENT_SL() {
        return CHECK_INCREMENT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CHECK_INCREMENT_SL
     *
     * @param CHECK_INCREMENT_SL the value for TFSDOCTYPE.CHECK_INCREMENT_SL
     */
    public void setCHECK_INCREMENT_SL(BigDecimal CHECK_INCREMENT_SL) {
        this.CHECK_INCREMENT_SL = CHECK_INCREMENT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_TYPE_DESC
     *
     * @return the value of TFSDOCTYPE.LG_TYPE_DESC
     */
    public String getLG_TYPE_DESC() {
        return LG_TYPE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_TYPE_DESC
     *
     * @param LG_TYPE_DESC the value for TFSDOCTYPE.LG_TYPE_DESC
     */
    public void setLG_TYPE_DESC(String LG_TYPE_DESC) {
        this.LG_TYPE_DESC = LG_TYPE_DESC == null ? null : LG_TYPE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_GL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_COMMISSION_GL
     */
    public BigDecimal getCR_ACC_COMMISSION_GL() {
        return CR_ACC_COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_GL
     *
     * @param CR_ACC_COMMISSION_GL the value for TFSDOCTYPE.CR_ACC_COMMISSION_GL
     */
    public void setCR_ACC_COMMISSION_GL(BigDecimal CR_ACC_COMMISSION_GL) {
        this.CR_ACC_COMMISSION_GL = CR_ACC_COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_CIF
     *
     * @return the value of TFSDOCTYPE.CR_ACC_COMMISSION_CIF
     */
    public BigDecimal getCR_ACC_COMMISSION_CIF() {
        return CR_ACC_COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_CIF
     *
     * @param CR_ACC_COMMISSION_CIF the value for TFSDOCTYPE.CR_ACC_COMMISSION_CIF
     */
    public void setCR_ACC_COMMISSION_CIF(BigDecimal CR_ACC_COMMISSION_CIF) {
        this.CR_ACC_COMMISSION_CIF = CR_ACC_COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_SL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_COMMISSION_SL
     */
    public BigDecimal getCR_ACC_COMMISSION_SL() {
        return CR_ACC_COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_SL
     *
     * @param CR_ACC_COMMISSION_SL the value for TFSDOCTYPE.CR_ACC_COMMISSION_SL
     */
    public void setCR_ACC_COMMISSION_SL(BigDecimal CR_ACC_COMMISSION_SL) {
        this.CR_ACC_COMMISSION_SL = CR_ACC_COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_GL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_SWIFT_GL
     */
    public BigDecimal getCR_ACC_SWIFT_GL() {
        return CR_ACC_SWIFT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_GL
     *
     * @param CR_ACC_SWIFT_GL the value for TFSDOCTYPE.CR_ACC_SWIFT_GL
     */
    public void setCR_ACC_SWIFT_GL(BigDecimal CR_ACC_SWIFT_GL) {
        this.CR_ACC_SWIFT_GL = CR_ACC_SWIFT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_CIF
     *
     * @return the value of TFSDOCTYPE.CR_ACC_SWIFT_CIF
     */
    public BigDecimal getCR_ACC_SWIFT_CIF() {
        return CR_ACC_SWIFT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_CIF
     *
     * @param CR_ACC_SWIFT_CIF the value for TFSDOCTYPE.CR_ACC_SWIFT_CIF
     */
    public void setCR_ACC_SWIFT_CIF(BigDecimal CR_ACC_SWIFT_CIF) {
        this.CR_ACC_SWIFT_CIF = CR_ACC_SWIFT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_SL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_SWIFT_SL
     */
    public BigDecimal getCR_ACC_SWIFT_SL() {
        return CR_ACC_SWIFT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_SWIFT_SL
     *
     * @param CR_ACC_SWIFT_SL the value for TFSDOCTYPE.CR_ACC_SWIFT_SL
     */
    public void setCR_ACC_SWIFT_SL(BigDecimal CR_ACC_SWIFT_SL) {
        this.CR_ACC_SWIFT_SL = CR_ACC_SWIFT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_MAIL_GL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_MAIL_GL
     */
    public BigDecimal getCR_ACC_MAIL_GL() {
        return CR_ACC_MAIL_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_MAIL_GL
     *
     * @param CR_ACC_MAIL_GL the value for TFSDOCTYPE.CR_ACC_MAIL_GL
     */
    public void setCR_ACC_MAIL_GL(BigDecimal CR_ACC_MAIL_GL) {
        this.CR_ACC_MAIL_GL = CR_ACC_MAIL_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_MAIL_CIF
     *
     * @return the value of TFSDOCTYPE.CR_ACC_MAIL_CIF
     */
    public BigDecimal getCR_ACC_MAIL_CIF() {
        return CR_ACC_MAIL_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_MAIL_CIF
     *
     * @param CR_ACC_MAIL_CIF the value for TFSDOCTYPE.CR_ACC_MAIL_CIF
     */
    public void setCR_ACC_MAIL_CIF(BigDecimal CR_ACC_MAIL_CIF) {
        this.CR_ACC_MAIL_CIF = CR_ACC_MAIL_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_MAIL_SL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_MAIL_SL
     */
    public BigDecimal getCR_ACC_MAIL_SL() {
        return CR_ACC_MAIL_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_MAIL_SL
     *
     * @param CR_ACC_MAIL_SL the value for TFSDOCTYPE.CR_ACC_MAIL_SL
     */
    public void setCR_ACC_MAIL_SL(BigDecimal CR_ACC_MAIL_SL) {
        this.CR_ACC_MAIL_SL = CR_ACC_MAIL_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_GL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_STAMPS_GL
     */
    public BigDecimal getCR_ACC_STAMPS_GL() {
        return CR_ACC_STAMPS_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_GL
     *
     * @param CR_ACC_STAMPS_GL the value for TFSDOCTYPE.CR_ACC_STAMPS_GL
     */
    public void setCR_ACC_STAMPS_GL(BigDecimal CR_ACC_STAMPS_GL) {
        this.CR_ACC_STAMPS_GL = CR_ACC_STAMPS_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_CIF
     *
     * @return the value of TFSDOCTYPE.CR_ACC_STAMPS_CIF
     */
    public BigDecimal getCR_ACC_STAMPS_CIF() {
        return CR_ACC_STAMPS_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_CIF
     *
     * @param CR_ACC_STAMPS_CIF the value for TFSDOCTYPE.CR_ACC_STAMPS_CIF
     */
    public void setCR_ACC_STAMPS_CIF(BigDecimal CR_ACC_STAMPS_CIF) {
        this.CR_ACC_STAMPS_CIF = CR_ACC_STAMPS_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_SL
     *
     * @return the value of TFSDOCTYPE.CR_ACC_STAMPS_SL
     */
    public BigDecimal getCR_ACC_STAMPS_SL() {
        return CR_ACC_STAMPS_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_STAMPS_SL
     *
     * @param CR_ACC_STAMPS_SL the value for TFSDOCTYPE.CR_ACC_STAMPS_SL
     */
    public void setCR_ACC_STAMPS_SL(BigDecimal CR_ACC_STAMPS_SL) {
        this.CR_ACC_STAMPS_SL = CR_ACC_STAMPS_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_GL
     */
    public BigDecimal getBILLS_TRANSFER_CASH_ASSET_GL() {
        return BILLS_TRANSFER_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_GL
     *
     * @param BILLS_TRANSFER_CASH_ASSET_GL the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_GL
     */
    public void setBILLS_TRANSFER_CASH_ASSET_GL(BigDecimal BILLS_TRANSFER_CASH_ASSET_GL) {
        this.BILLS_TRANSFER_CASH_ASSET_GL = BILLS_TRANSFER_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DIV
     */
    public BigDecimal getBILLS_TRANSFER_CASH_ASSET_DIV() {
        return BILLS_TRANSFER_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DIV
     *
     * @param BILLS_TRANSFER_CASH_ASSET_DIV the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DIV
     */
    public void setBILLS_TRANSFER_CASH_ASSET_DIV(BigDecimal BILLS_TRANSFER_CASH_ASSET_DIV) {
        this.BILLS_TRANSFER_CASH_ASSET_DIV = BILLS_TRANSFER_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DEPT
     */
    public BigDecimal getBILLS_TRANSFER_CASH_ASSET_DEPT() {
        return BILLS_TRANSFER_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DEPT
     *
     * @param BILLS_TRANSFER_CASH_ASSET_DEPT the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_ASSET_DEPT
     */
    public void setBILLS_TRANSFER_CASH_ASSET_DEPT(BigDecimal BILLS_TRANSFER_CASH_ASSET_DEPT) {
        this.BILLS_TRANSFER_CASH_ASSET_DEPT = BILLS_TRANSFER_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_GL
     */
    public BigDecimal getBILLS_TRANSFER_CASH_LIAB_GL() {
        return BILLS_TRANSFER_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_GL
     *
     * @param BILLS_TRANSFER_CASH_LIAB_GL the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_GL
     */
    public void setBILLS_TRANSFER_CASH_LIAB_GL(BigDecimal BILLS_TRANSFER_CASH_LIAB_GL) {
        this.BILLS_TRANSFER_CASH_LIAB_GL = BILLS_TRANSFER_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DIV
     */
    public BigDecimal getBILLS_TRANSFER_CASH_LIAB_DIV() {
        return BILLS_TRANSFER_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DIV
     *
     * @param BILLS_TRANSFER_CASH_LIAB_DIV the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DIV
     */
    public void setBILLS_TRANSFER_CASH_LIAB_DIV(BigDecimal BILLS_TRANSFER_CASH_LIAB_DIV) {
        this.BILLS_TRANSFER_CASH_LIAB_DIV = BILLS_TRANSFER_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DEPT
     */
    public BigDecimal getBILLS_TRANSFER_CASH_LIAB_DEPT() {
        return BILLS_TRANSFER_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DEPT
     *
     * @param BILLS_TRANSFER_CASH_LIAB_DEPT the value for TFSDOCTYPE.BILLS_TRANSFER_CASH_LIAB_DEPT
     */
    public void setBILLS_TRANSFER_CASH_LIAB_DEPT(BigDecimal BILLS_TRANSFER_CASH_LIAB_DEPT) {
        this.BILLS_TRANSFER_CASH_LIAB_DEPT = BILLS_TRANSFER_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_CY
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_CY
     */
    public BigDecimal getSUSPENSE_CY() {
        return SUSPENSE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_CY
     *
     * @param SUSPENSE_CY the value for TFSDOCTYPE.SUSPENSE_CY
     */
    public void setSUSPENSE_CY(BigDecimal SUSPENSE_CY) {
        this.SUSPENSE_CY = SUSPENSE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DEFAULT_APPLICANT_CIF
     *
     * @return the value of TFSDOCTYPE.DEFAULT_APPLICANT_CIF
     */
    public String getDEFAULT_APPLICANT_CIF() {
        return DEFAULT_APPLICANT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DEFAULT_APPLICANT_CIF
     *
     * @param DEFAULT_APPLICANT_CIF the value for TFSDOCTYPE.DEFAULT_APPLICANT_CIF
     */
    public void setDEFAULT_APPLICANT_CIF(String DEFAULT_APPLICANT_CIF) {
        this.DEFAULT_APPLICANT_CIF = DEFAULT_APPLICANT_CIF == null ? null : DEFAULT_APPLICANT_CIF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DEFAULT_CIF
     *
     * @return the value of TFSDOCTYPE.DEFAULT_CIF
     */
    public BigDecimal getDEFAULT_CIF() {
        return DEFAULT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DEFAULT_CIF
     *
     * @param DEFAULT_CIF the value for TFSDOCTYPE.DEFAULT_CIF
     */
    public void setDEFAULT_CIF(BigDecimal DEFAULT_CIF) {
        this.DEFAULT_CIF = DEFAULT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_BR
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_BR
     */
    public BigDecimal getSUSPENSE_BR() {
        return SUSPENSE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_BR
     *
     * @param SUSPENSE_BR the value for TFSDOCTYPE.SUSPENSE_BR
     */
    public void setSUSPENSE_BR(BigDecimal SUSPENSE_BR) {
        this.SUSPENSE_BR = SUSPENSE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SETTLEMENT_TYPE
     *
     * @return the value of TFSDOCTYPE.SETTLEMENT_TYPE
     */
    public String getSETTLEMENT_TYPE() {
        return SETTLEMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SETTLEMENT_TYPE
     *
     * @param SETTLEMENT_TYPE the value for TFSDOCTYPE.SETTLEMENT_TYPE
     */
    public void setSETTLEMENT_TYPE(String SETTLEMENT_TYPE) {
        this.SETTLEMENT_TYPE = SETTLEMENT_TYPE == null ? null : SETTLEMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CASH_FINANCE
     *
     * @return the value of TFSDOCTYPE.CASH_FINANCE
     */
    public String getCASH_FINANCE() {
        return CASH_FINANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CASH_FINANCE
     *
     * @param CASH_FINANCE the value for TFSDOCTYPE.CASH_FINANCE
     */
    public void setCASH_FINANCE(String CASH_FINANCE) {
        this.CASH_FINANCE = CASH_FINANCE == null ? null : CASH_FINANCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.PRODUCT_CLASS
     *
     * @return the value of TFSDOCTYPE.PRODUCT_CLASS
     */
    public BigDecimal getPRODUCT_CLASS() {
        return PRODUCT_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.PRODUCT_CLASS
     *
     * @param PRODUCT_CLASS the value for TFSDOCTYPE.PRODUCT_CLASS
     */
    public void setPRODUCT_CLASS(BigDecimal PRODUCT_CLASS) {
        this.PRODUCT_CLASS = PRODUCT_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.PRE_SETT_ENABLED
     *
     * @return the value of TFSDOCTYPE.PRE_SETT_ENABLED
     */
    public String getPRE_SETT_ENABLED() {
        return PRE_SETT_ENABLED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.PRE_SETT_ENABLED
     *
     * @param PRE_SETT_ENABLED the value for TFSDOCTYPE.PRE_SETT_ENABLED
     */
    public void setPRE_SETT_ENABLED(String PRE_SETT_ENABLED) {
        this.PRE_SETT_ENABLED = PRE_SETT_ENABLED == null ? null : PRE_SETT_ENABLED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GENERATE_ENTRIES
     *
     * @return the value of TFSDOCTYPE.GENERATE_ENTRIES
     */
    public String getGENERATE_ENTRIES() {
        return GENERATE_ENTRIES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GENERATE_ENTRIES
     *
     * @param GENERATE_ENTRIES the value for TFSDOCTYPE.GENERATE_ENTRIES
     */
    public void setGENERATE_ENTRIES(String GENERATE_ENTRIES) {
        this.GENERATE_ENTRIES = GENERATE_ENTRIES == null ? null : GENERATE_ENTRIES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_BR
     *
     * @return the value of TFSDOCTYPE.CR_ACC_COMMISSION_BR
     */
    public BigDecimal getCR_ACC_COMMISSION_BR() {
        return CR_ACC_COMMISSION_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_BR
     *
     * @param CR_ACC_COMMISSION_BR the value for TFSDOCTYPE.CR_ACC_COMMISSION_BR
     */
    public void setCR_ACC_COMMISSION_BR(BigDecimal CR_ACC_COMMISSION_BR) {
        this.CR_ACC_COMMISSION_BR = CR_ACC_COMMISSION_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_CY
     *
     * @return the value of TFSDOCTYPE.CR_ACC_COMMISSION_CY
     */
    public BigDecimal getCR_ACC_COMMISSION_CY() {
        return CR_ACC_COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_COMMISSION_CY
     *
     * @param CR_ACC_COMMISSION_CY the value for TFSDOCTYPE.CR_ACC_COMMISSION_CY
     */
    public void setCR_ACC_COMMISSION_CY(BigDecimal CR_ACC_COMMISSION_CY) {
        this.CR_ACC_COMMISSION_CY = CR_ACC_COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CLOSED_AFTER
     *
     * @return the value of TFSDOCTYPE.CLOSED_AFTER
     */
    public String getCLOSED_AFTER() {
        return CLOSED_AFTER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CLOSED_AFTER
     *
     * @param CLOSED_AFTER the value for TFSDOCTYPE.CLOSED_AFTER
     */
    public void setCLOSED_AFTER(String CLOSED_AFTER) {
        this.CLOSED_AFTER = CLOSED_AFTER == null ? null : CLOSED_AFTER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CLOSED_AFTER_DAYS
     *
     * @return the value of TFSDOCTYPE.CLOSED_AFTER_DAYS
     */
    public BigDecimal getCLOSED_AFTER_DAYS() {
        return CLOSED_AFTER_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CLOSED_AFTER_DAYS
     *
     * @param CLOSED_AFTER_DAYS the value for TFSDOCTYPE.CLOSED_AFTER_DAYS
     */
    public void setCLOSED_AFTER_DAYS(BigDecimal CLOSED_AFTER_DAYS) {
        this.CLOSED_AFTER_DAYS = CLOSED_AFTER_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.REVOLVING
     *
     * @return the value of TFSDOCTYPE.REVOLVING
     */
    public String getREVOLVING() {
        return REVOLVING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.REVOLVING
     *
     * @param REVOLVING the value for TFSDOCTYPE.REVOLVING
     */
    public void setREVOLVING(String REVOLVING) {
        this.REVOLVING = REVOLVING == null ? null : REVOLVING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIPPING_GUARANTEE
     *
     * @return the value of TFSDOCTYPE.SHIPPING_GUARANTEE
     */
    public String getSHIPPING_GUARANTEE() {
        return SHIPPING_GUARANTEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIPPING_GUARANTEE
     *
     * @param SHIPPING_GUARANTEE the value for TFSDOCTYPE.SHIPPING_GUARANTEE
     */
    public void setSHIPPING_GUARANTEE(String SHIPPING_GUARANTEE) {
        this.SHIPPING_GUARANTEE = SHIPPING_GUARANTEE == null ? null : SHIPPING_GUARANTEE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_ASSET_GL
     */
    public BigDecimal getLG_CASH_REDEMP_ASSET_GL() {
        return LG_CASH_REDEMP_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_GL
     *
     * @param LG_CASH_REDEMP_ASSET_GL the value for TFSDOCTYPE.LG_CASH_REDEMP_ASSET_GL
     */
    public void setLG_CASH_REDEMP_ASSET_GL(BigDecimal LG_CASH_REDEMP_ASSET_GL) {
        this.LG_CASH_REDEMP_ASSET_GL = LG_CASH_REDEMP_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DIV
     */
    public BigDecimal getLG_CASH_REDEMP_ASSET_DIV() {
        return LG_CASH_REDEMP_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DIV
     *
     * @param LG_CASH_REDEMP_ASSET_DIV the value for TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DIV
     */
    public void setLG_CASH_REDEMP_ASSET_DIV(BigDecimal LG_CASH_REDEMP_ASSET_DIV) {
        this.LG_CASH_REDEMP_ASSET_DIV = LG_CASH_REDEMP_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DEPT
     */
    public BigDecimal getLG_CASH_REDEMP_ASSET_DEPT() {
        return LG_CASH_REDEMP_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DEPT
     *
     * @param LG_CASH_REDEMP_ASSET_DEPT the value for TFSDOCTYPE.LG_CASH_REDEMP_ASSET_DEPT
     */
    public void setLG_CASH_REDEMP_ASSET_DEPT(BigDecimal LG_CASH_REDEMP_ASSET_DEPT) {
        this.LG_CASH_REDEMP_ASSET_DEPT = LG_CASH_REDEMP_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_LIAB_GL
     */
    public BigDecimal getLG_CASH_REDEMP_LIAB_GL() {
        return LG_CASH_REDEMP_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_GL
     *
     * @param LG_CASH_REDEMP_LIAB_GL the value for TFSDOCTYPE.LG_CASH_REDEMP_LIAB_GL
     */
    public void setLG_CASH_REDEMP_LIAB_GL(BigDecimal LG_CASH_REDEMP_LIAB_GL) {
        this.LG_CASH_REDEMP_LIAB_GL = LG_CASH_REDEMP_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DIV
     */
    public BigDecimal getLG_CASH_REDEMP_LIAB_DIV() {
        return LG_CASH_REDEMP_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DIV
     *
     * @param LG_CASH_REDEMP_LIAB_DIV the value for TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DIV
     */
    public void setLG_CASH_REDEMP_LIAB_DIV(BigDecimal LG_CASH_REDEMP_LIAB_DIV) {
        this.LG_CASH_REDEMP_LIAB_DIV = LG_CASH_REDEMP_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DEPT
     */
    public BigDecimal getLG_CASH_REDEMP_LIAB_DEPT() {
        return LG_CASH_REDEMP_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DEPT
     *
     * @param LG_CASH_REDEMP_LIAB_DEPT the value for TFSDOCTYPE.LG_CASH_REDEMP_LIAB_DEPT
     */
    public void setLG_CASH_REDEMP_LIAB_DEPT(BigDecimal LG_CASH_REDEMP_LIAB_DEPT) {
        this.LG_CASH_REDEMP_LIAB_DEPT = LG_CASH_REDEMP_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_ASSET_GL
     */
    public BigDecimal getLG_FIN_REDEMP_ASSET_GL() {
        return LG_FIN_REDEMP_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_GL
     *
     * @param LG_FIN_REDEMP_ASSET_GL the value for TFSDOCTYPE.LG_FIN_REDEMP_ASSET_GL
     */
    public void setLG_FIN_REDEMP_ASSET_GL(BigDecimal LG_FIN_REDEMP_ASSET_GL) {
        this.LG_FIN_REDEMP_ASSET_GL = LG_FIN_REDEMP_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DIV
     */
    public BigDecimal getLG_FIN_REDEMP_ASSET_DIV() {
        return LG_FIN_REDEMP_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DIV
     *
     * @param LG_FIN_REDEMP_ASSET_DIV the value for TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DIV
     */
    public void setLG_FIN_REDEMP_ASSET_DIV(BigDecimal LG_FIN_REDEMP_ASSET_DIV) {
        this.LG_FIN_REDEMP_ASSET_DIV = LG_FIN_REDEMP_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DEPT
     */
    public BigDecimal getLG_FIN_REDEMP_ASSET_DEPT() {
        return LG_FIN_REDEMP_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DEPT
     *
     * @param LG_FIN_REDEMP_ASSET_DEPT the value for TFSDOCTYPE.LG_FIN_REDEMP_ASSET_DEPT
     */
    public void setLG_FIN_REDEMP_ASSET_DEPT(BigDecimal LG_FIN_REDEMP_ASSET_DEPT) {
        this.LG_FIN_REDEMP_ASSET_DEPT = LG_FIN_REDEMP_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_LIAB_GL
     */
    public BigDecimal getLG_FIN_REDEMP_LIAB_GL() {
        return LG_FIN_REDEMP_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_GL
     *
     * @param LG_FIN_REDEMP_LIAB_GL the value for TFSDOCTYPE.LG_FIN_REDEMP_LIAB_GL
     */
    public void setLG_FIN_REDEMP_LIAB_GL(BigDecimal LG_FIN_REDEMP_LIAB_GL) {
        this.LG_FIN_REDEMP_LIAB_GL = LG_FIN_REDEMP_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DIV
     */
    public BigDecimal getLG_FIN_REDEMP_LIAB_DIV() {
        return LG_FIN_REDEMP_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DIV
     *
     * @param LG_FIN_REDEMP_LIAB_DIV the value for TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DIV
     */
    public void setLG_FIN_REDEMP_LIAB_DIV(BigDecimal LG_FIN_REDEMP_LIAB_DIV) {
        this.LG_FIN_REDEMP_LIAB_DIV = LG_FIN_REDEMP_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DEPT
     */
    public BigDecimal getLG_FIN_REDEMP_LIAB_DEPT() {
        return LG_FIN_REDEMP_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DEPT
     *
     * @param LG_FIN_REDEMP_LIAB_DEPT the value for TFSDOCTYPE.LG_FIN_REDEMP_LIAB_DEPT
     */
    public void setLG_FIN_REDEMP_LIAB_DEPT(BigDecimal LG_FIN_REDEMP_LIAB_DEPT) {
        this.LG_FIN_REDEMP_LIAB_DEPT = LG_FIN_REDEMP_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DD_TRX_TYPE
     *
     * @return the value of TFSDOCTYPE.DD_TRX_TYPE
     */
    public String getDD_TRX_TYPE() {
        return DD_TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DD_TRX_TYPE
     *
     * @param DD_TRX_TYPE the value for TFSDOCTYPE.DD_TRX_TYPE
     */
    public void setDD_TRX_TYPE(String DD_TRX_TYPE) {
        this.DD_TRX_TYPE = DD_TRX_TYPE == null ? null : DD_TRX_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.FORM_OFDOC_CREDIT_PARAM
     *
     * @return the value of TFSDOCTYPE.FORM_OFDOC_CREDIT_PARAM
     */
    public String getFORM_OFDOC_CREDIT_PARAM() {
        return FORM_OFDOC_CREDIT_PARAM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.FORM_OFDOC_CREDIT_PARAM
     *
     * @param FORM_OFDOC_CREDIT_PARAM the value for TFSDOCTYPE.FORM_OFDOC_CREDIT_PARAM
     */
    public void setFORM_OFDOC_CREDIT_PARAM(String FORM_OFDOC_CREDIT_PARAM) {
        this.FORM_OFDOC_CREDIT_PARAM = FORM_OFDOC_CREDIT_PARAM == null ? null : FORM_OFDOC_CREDIT_PARAM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GENERATE_ENTRIES_ACCEPTANCE
     *
     * @return the value of TFSDOCTYPE.GENERATE_ENTRIES_ACCEPTANCE
     */
    public String getGENERATE_ENTRIES_ACCEPTANCE() {
        return GENERATE_ENTRIES_ACCEPTANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GENERATE_ENTRIES_ACCEPTANCE
     *
     * @param GENERATE_ENTRIES_ACCEPTANCE the value for TFSDOCTYPE.GENERATE_ENTRIES_ACCEPTANCE
     */
    public void setGENERATE_ENTRIES_ACCEPTANCE(String GENERATE_ENTRIES_ACCEPTANCE) {
        this.GENERATE_ENTRIES_ACCEPTANCE = GENERATE_ENTRIES_ACCEPTANCE == null ? null : GENERATE_ENTRIES_ACCEPTANCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_MAIL_BR
     *
     * @return the value of TFSDOCTYPE.CR_ACC_MAIL_BR
     */
    public BigDecimal getCR_ACC_MAIL_BR() {
        return CR_ACC_MAIL_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_MAIL_BR
     *
     * @param CR_ACC_MAIL_BR the value for TFSDOCTYPE.CR_ACC_MAIL_BR
     */
    public void setCR_ACC_MAIL_BR(BigDecimal CR_ACC_MAIL_BR) {
        this.CR_ACC_MAIL_BR = CR_ACC_MAIL_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CR_ACC_MAIL_CY
     *
     * @return the value of TFSDOCTYPE.CR_ACC_MAIL_CY
     */
    public BigDecimal getCR_ACC_MAIL_CY() {
        return CR_ACC_MAIL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CR_ACC_MAIL_CY
     *
     * @param CR_ACC_MAIL_CY the value for TFSDOCTYPE.CR_ACC_MAIL_CY
     */
    public void setCR_ACC_MAIL_CY(BigDecimal CR_ACC_MAIL_CY) {
        this.CR_ACC_MAIL_CY = CR_ACC_MAIL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.REVERSE_MARGIN_SEP
     *
     * @return the value of TFSDOCTYPE.REVERSE_MARGIN_SEP
     */
    public String getREVERSE_MARGIN_SEP() {
        return REVERSE_MARGIN_SEP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.REVERSE_MARGIN_SEP
     *
     * @param REVERSE_MARGIN_SEP the value for TFSDOCTYPE.REVERSE_MARGIN_SEP
     */
    public void setREVERSE_MARGIN_SEP(String REVERSE_MARGIN_SEP) {
        this.REVERSE_MARGIN_SEP = REVERSE_MARGIN_SEP == null ? null : REVERSE_MARGIN_SEP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ENABLE_GUARANTEE_ADV
     *
     * @return the value of TFSDOCTYPE.ENABLE_GUARANTEE_ADV
     */
    public String getENABLE_GUARANTEE_ADV() {
        return ENABLE_GUARANTEE_ADV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ENABLE_GUARANTEE_ADV
     *
     * @param ENABLE_GUARANTEE_ADV the value for TFSDOCTYPE.ENABLE_GUARANTEE_ADV
     */
    public void setENABLE_GUARANTEE_ADV(String ENABLE_GUARANTEE_ADV) {
        this.ENABLE_GUARANTEE_ADV = ENABLE_GUARANTEE_ADV == null ? null : ENABLE_GUARANTEE_ADV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ENABLE_GUARANTEE_EXC
     *
     * @return the value of TFSDOCTYPE.ENABLE_GUARANTEE_EXC
     */
    public String getENABLE_GUARANTEE_EXC() {
        return ENABLE_GUARANTEE_EXC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ENABLE_GUARANTEE_EXC
     *
     * @param ENABLE_GUARANTEE_EXC the value for TFSDOCTYPE.ENABLE_GUARANTEE_EXC
     */
    public void setENABLE_GUARANTEE_EXC(String ENABLE_GUARANTEE_EXC) {
        this.ENABLE_GUARANTEE_EXC = ENABLE_GUARANTEE_EXC == null ? null : ENABLE_GUARANTEE_EXC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_GL
     */
    public BigDecimal getBILLS_DCLR_CASH_ASSET_GL() {
        return BILLS_DCLR_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_GL
     *
     * @param BILLS_DCLR_CASH_ASSET_GL the value for TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_GL
     */
    public void setBILLS_DCLR_CASH_ASSET_GL(BigDecimal BILLS_DCLR_CASH_ASSET_GL) {
        this.BILLS_DCLR_CASH_ASSET_GL = BILLS_DCLR_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DIV
     */
    public BigDecimal getBILLS_DCLR_CASH_ASSET_DIV() {
        return BILLS_DCLR_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DIV
     *
     * @param BILLS_DCLR_CASH_ASSET_DIV the value for TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DIV
     */
    public void setBILLS_DCLR_CASH_ASSET_DIV(BigDecimal BILLS_DCLR_CASH_ASSET_DIV) {
        this.BILLS_DCLR_CASH_ASSET_DIV = BILLS_DCLR_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DEPT
     */
    public BigDecimal getBILLS_DCLR_CASH_ASSET_DEPT() {
        return BILLS_DCLR_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DEPT
     *
     * @param BILLS_DCLR_CASH_ASSET_DEPT the value for TFSDOCTYPE.BILLS_DCLR_CASH_ASSET_DEPT
     */
    public void setBILLS_DCLR_CASH_ASSET_DEPT(BigDecimal BILLS_DCLR_CASH_ASSET_DEPT) {
        this.BILLS_DCLR_CASH_ASSET_DEPT = BILLS_DCLR_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_GL
     */
    public BigDecimal getBILLS_DCLR_CASH_LIAB_GL() {
        return BILLS_DCLR_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_GL
     *
     * @param BILLS_DCLR_CASH_LIAB_GL the value for TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_GL
     */
    public void setBILLS_DCLR_CASH_LIAB_GL(BigDecimal BILLS_DCLR_CASH_LIAB_GL) {
        this.BILLS_DCLR_CASH_LIAB_GL = BILLS_DCLR_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DIV
     */
    public BigDecimal getBILLS_DCLR_CASH_LIAB_DIV() {
        return BILLS_DCLR_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DIV
     *
     * @param BILLS_DCLR_CASH_LIAB_DIV the value for TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DIV
     */
    public void setBILLS_DCLR_CASH_LIAB_DIV(BigDecimal BILLS_DCLR_CASH_LIAB_DIV) {
        this.BILLS_DCLR_CASH_LIAB_DIV = BILLS_DCLR_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DEPT
     */
    public BigDecimal getBILLS_DCLR_CASH_LIAB_DEPT() {
        return BILLS_DCLR_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DEPT
     *
     * @param BILLS_DCLR_CASH_LIAB_DEPT the value for TFSDOCTYPE.BILLS_DCLR_CASH_LIAB_DEPT
     */
    public void setBILLS_DCLR_CASH_LIAB_DEPT(BigDecimal BILLS_DCLR_CASH_LIAB_DEPT) {
        this.BILLS_DCLR_CASH_LIAB_DEPT = BILLS_DCLR_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTO_MARGIN_GL
     *
     * @return the value of TFSDOCTYPE.AUTO_MARGIN_GL
     */
    public BigDecimal getAUTO_MARGIN_GL() {
        return AUTO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTO_MARGIN_GL
     *
     * @param AUTO_MARGIN_GL the value for TFSDOCTYPE.AUTO_MARGIN_GL
     */
    public void setAUTO_MARGIN_GL(BigDecimal AUTO_MARGIN_GL) {
        this.AUTO_MARGIN_GL = AUTO_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTO_MARGIN_DIV
     *
     * @return the value of TFSDOCTYPE.AUTO_MARGIN_DIV
     */
    public BigDecimal getAUTO_MARGIN_DIV() {
        return AUTO_MARGIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTO_MARGIN_DIV
     *
     * @param AUTO_MARGIN_DIV the value for TFSDOCTYPE.AUTO_MARGIN_DIV
     */
    public void setAUTO_MARGIN_DIV(BigDecimal AUTO_MARGIN_DIV) {
        this.AUTO_MARGIN_DIV = AUTO_MARGIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTO_MARGIN_DEPT
     *
     * @return the value of TFSDOCTYPE.AUTO_MARGIN_DEPT
     */
    public BigDecimal getAUTO_MARGIN_DEPT() {
        return AUTO_MARGIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTO_MARGIN_DEPT
     *
     * @param AUTO_MARGIN_DEPT the value for TFSDOCTYPE.AUTO_MARGIN_DEPT
     */
    public void setAUTO_MARGIN_DEPT(BigDecimal AUTO_MARGIN_DEPT) {
        this.AUTO_MARGIN_DEPT = AUTO_MARGIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTO_MARGIN_ACC
     *
     * @return the value of TFSDOCTYPE.AUTO_MARGIN_ACC
     */
    public String getAUTO_MARGIN_ACC() {
        return AUTO_MARGIN_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTO_MARGIN_ACC
     *
     * @param AUTO_MARGIN_ACC the value for TFSDOCTYPE.AUTO_MARGIN_ACC
     */
    public void setAUTO_MARGIN_ACC(String AUTO_MARGIN_ACC) {
        this.AUTO_MARGIN_ACC = AUTO_MARGIN_ACC == null ? null : AUTO_MARGIN_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MARGIN_INCR_SL
     *
     * @return the value of TFSDOCTYPE.MARGIN_INCR_SL
     */
    public String getMARGIN_INCR_SL() {
        return MARGIN_INCR_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MARGIN_INCR_SL
     *
     * @param MARGIN_INCR_SL the value for TFSDOCTYPE.MARGIN_INCR_SL
     */
    public void setMARGIN_INCR_SL(String MARGIN_INCR_SL) {
        this.MARGIN_INCR_SL = MARGIN_INCR_SL == null ? null : MARGIN_INCR_SL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DIV
     *
     * @return the value of TFSDOCTYPE.AUTOMATIC_SUSPENSE_DIV
     */
    public BigDecimal getAUTOMATIC_SUSPENSE_DIV() {
        return AUTOMATIC_SUSPENSE_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DIV
     *
     * @param AUTOMATIC_SUSPENSE_DIV the value for TFSDOCTYPE.AUTOMATIC_SUSPENSE_DIV
     */
    public void setAUTOMATIC_SUSPENSE_DIV(BigDecimal AUTOMATIC_SUSPENSE_DIV) {
        this.AUTOMATIC_SUSPENSE_DIV = AUTOMATIC_SUSPENSE_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DEPT
     *
     * @return the value of TFSDOCTYPE.AUTOMATIC_SUSPENSE_DEPT
     */
    public BigDecimal getAUTOMATIC_SUSPENSE_DEPT() {
        return AUTOMATIC_SUSPENSE_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTOMATIC_SUSPENSE_DEPT
     *
     * @param AUTOMATIC_SUSPENSE_DEPT the value for TFSDOCTYPE.AUTOMATIC_SUSPENSE_DEPT
     */
    public void setAUTOMATIC_SUSPENSE_DEPT(BigDecimal AUTOMATIC_SUSPENSE_DEPT) {
        this.AUTOMATIC_SUSPENSE_DEPT = AUTOMATIC_SUSPENSE_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.AUTO_SUSPENSE_ACC
     *
     * @return the value of TFSDOCTYPE.AUTO_SUSPENSE_ACC
     */
    public String getAUTO_SUSPENSE_ACC() {
        return AUTO_SUSPENSE_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.AUTO_SUSPENSE_ACC
     *
     * @param AUTO_SUSPENSE_ACC the value for TFSDOCTYPE.AUTO_SUSPENSE_ACC
     */
    public void setAUTO_SUSPENSE_ACC(String AUTO_SUSPENSE_ACC) {
        this.AUTO_SUSPENSE_ACC = AUTO_SUSPENSE_ACC == null ? null : AUTO_SUSPENSE_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SUSPENSE_ACC_TYPE
     *
     * @return the value of TFSDOCTYPE.SUSPENSE_ACC_TYPE
     */
    public String getSUSPENSE_ACC_TYPE() {
        return SUSPENSE_ACC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SUSPENSE_ACC_TYPE
     *
     * @param SUSPENSE_ACC_TYPE the value for TFSDOCTYPE.SUSPENSE_ACC_TYPE
     */
    public void setSUSPENSE_ACC_TYPE(String SUSPENSE_ACC_TYPE) {
        this.SUSPENSE_ACC_TYPE = SUSPENSE_ACC_TYPE == null ? null : SUSPENSE_ACC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.INCREMENT_SL
     *
     * @return the value of TFSDOCTYPE.INCREMENT_SL
     */
    public String getINCREMENT_SL() {
        return INCREMENT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.INCREMENT_SL
     *
     * @param INCREMENT_SL the value for TFSDOCTYPE.INCREMENT_SL
     */
    public void setINCREMENT_SL(String INCREMENT_SL) {
        this.INCREMENT_SL = INCREMENT_SL == null ? null : INCREMENT_SL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.FREE_TRANSFER
     *
     * @return the value of TFSDOCTYPE.FREE_TRANSFER
     */
    public String getFREE_TRANSFER() {
        return FREE_TRANSFER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.FREE_TRANSFER
     *
     * @param FREE_TRANSFER the value for TFSDOCTYPE.FREE_TRANSFER
     */
    public void setFREE_TRANSFER(String FREE_TRANSFER) {
        this.FREE_TRANSFER = FREE_TRANSFER == null ? null : FREE_TRANSFER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MARGIN_ACC_TYPE
     *
     * @return the value of TFSDOCTYPE.MARGIN_ACC_TYPE
     */
    public String getMARGIN_ACC_TYPE() {
        return MARGIN_ACC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MARGIN_ACC_TYPE
     *
     * @param MARGIN_ACC_TYPE the value for TFSDOCTYPE.MARGIN_ACC_TYPE
     */
    public void setMARGIN_ACC_TYPE(String MARGIN_ACC_TYPE) {
        this.MARGIN_ACC_TYPE = MARGIN_ACC_TYPE == null ? null : MARGIN_ACC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.RELEASE_DD_ON_ACCEPTANCE
     *
     * @return the value of TFSDOCTYPE.RELEASE_DD_ON_ACCEPTANCE
     */
    public String getRELEASE_DD_ON_ACCEPTANCE() {
        return RELEASE_DD_ON_ACCEPTANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.RELEASE_DD_ON_ACCEPTANCE
     *
     * @param RELEASE_DD_ON_ACCEPTANCE the value for TFSDOCTYPE.RELEASE_DD_ON_ACCEPTANCE
     */
    public void setRELEASE_DD_ON_ACCEPTANCE(String RELEASE_DD_ON_ACCEPTANCE) {
        this.RELEASE_DD_ON_ACCEPTANCE = RELEASE_DD_ON_ACCEPTANCE == null ? null : RELEASE_DD_ON_ACCEPTANCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DEFAULT_SETTLEMENT_TYPE
     *
     * @return the value of TFSDOCTYPE.DEFAULT_SETTLEMENT_TYPE
     */
    public String getDEFAULT_SETTLEMENT_TYPE() {
        return DEFAULT_SETTLEMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DEFAULT_SETTLEMENT_TYPE
     *
     * @param DEFAULT_SETTLEMENT_TYPE the value for TFSDOCTYPE.DEFAULT_SETTLEMENT_TYPE
     */
    public void setDEFAULT_SETTLEMENT_TYPE(String DEFAULT_SETTLEMENT_TYPE) {
        this.DEFAULT_SETTLEMENT_TYPE = DEFAULT_SETTLEMENT_TYPE == null ? null : DEFAULT_SETTLEMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GENERATE_ENTRIES_ON_DEC
     *
     * @return the value of TFSDOCTYPE.GENERATE_ENTRIES_ON_DEC
     */
    public String getGENERATE_ENTRIES_ON_DEC() {
        return GENERATE_ENTRIES_ON_DEC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GENERATE_ENTRIES_ON_DEC
     *
     * @param GENERATE_ENTRIES_ON_DEC the value for TFSDOCTYPE.GENERATE_ENTRIES_ON_DEC
     */
    public void setGENERATE_ENTRIES_ON_DEC(String GENERATE_ENTRIES_ON_DEC) {
        this.GENERATE_ENTRIES_ON_DEC = GENERATE_ENTRIES_ON_DEC == null ? null : GENERATE_ENTRIES_ON_DEC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CHECK_DOM_ILC_DOC
     *
     * @return the value of TFSDOCTYPE.CHECK_DOM_ILC_DOC
     */
    public String getCHECK_DOM_ILC_DOC() {
        return CHECK_DOM_ILC_DOC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CHECK_DOM_ILC_DOC
     *
     * @param CHECK_DOM_ILC_DOC the value for TFSDOCTYPE.CHECK_DOM_ILC_DOC
     */
    public void setCHECK_DOM_ILC_DOC(String CHECK_DOM_ILC_DOC) {
        this.CHECK_DOM_ILC_DOC = CHECK_DOM_ILC_DOC == null ? null : CHECK_DOM_ILC_DOC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.ADDITIONAL_REF
     *
     * @return the value of TFSDOCTYPE.ADDITIONAL_REF
     */
    public String getADDITIONAL_REF() {
        return ADDITIONAL_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.ADDITIONAL_REF
     *
     * @param ADDITIONAL_REF the value for TFSDOCTYPE.ADDITIONAL_REF
     */
    public void setADDITIONAL_REF(String ADDITIONAL_REF) {
        this.ADDITIONAL_REF = ADDITIONAL_REF == null ? null : ADDITIONAL_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GOODS_TRANS_CIF
     *
     * @return the value of TFSDOCTYPE.GOODS_TRANS_CIF
     */
    public BigDecimal getGOODS_TRANS_CIF() {
        return GOODS_TRANS_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GOODS_TRANS_CIF
     *
     * @param GOODS_TRANS_CIF the value for TFSDOCTYPE.GOODS_TRANS_CIF
     */
    public void setGOODS_TRANS_CIF(BigDecimal GOODS_TRANS_CIF) {
        this.GOODS_TRANS_CIF = GOODS_TRANS_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GOODS_TRANS_CY
     *
     * @return the value of TFSDOCTYPE.GOODS_TRANS_CY
     */
    public BigDecimal getGOODS_TRANS_CY() {
        return GOODS_TRANS_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GOODS_TRANS_CY
     *
     * @param GOODS_TRANS_CY the value for TFSDOCTYPE.GOODS_TRANS_CY
     */
    public void setGOODS_TRANS_CY(BigDecimal GOODS_TRANS_CY) {
        this.GOODS_TRANS_CY = GOODS_TRANS_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GOODS_TRANS_GL
     *
     * @return the value of TFSDOCTYPE.GOODS_TRANS_GL
     */
    public BigDecimal getGOODS_TRANS_GL() {
        return GOODS_TRANS_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GOODS_TRANS_GL
     *
     * @param GOODS_TRANS_GL the value for TFSDOCTYPE.GOODS_TRANS_GL
     */
    public void setGOODS_TRANS_GL(BigDecimal GOODS_TRANS_GL) {
        this.GOODS_TRANS_GL = GOODS_TRANS_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.GOODS_TRANS_SL
     *
     * @return the value of TFSDOCTYPE.GOODS_TRANS_SL
     */
    public BigDecimal getGOODS_TRANS_SL() {
        return GOODS_TRANS_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.GOODS_TRANS_SL
     *
     * @param GOODS_TRANS_SL the value for TFSDOCTYPE.GOODS_TRANS_SL
     */
    public void setGOODS_TRANS_SL(BigDecimal GOODS_TRANS_SL) {
        this.GOODS_TRANS_SL = GOODS_TRANS_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.USE_GOODS_IN_TRANS
     *
     * @return the value of TFSDOCTYPE.USE_GOODS_IN_TRANS
     */
    public String getUSE_GOODS_IN_TRANS() {
        return USE_GOODS_IN_TRANS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.USE_GOODS_IN_TRANS
     *
     * @param USE_GOODS_IN_TRANS the value for TFSDOCTYPE.USE_GOODS_IN_TRANS
     */
    public void setUSE_GOODS_IN_TRANS(String USE_GOODS_IN_TRANS) {
        this.USE_GOODS_IN_TRANS = USE_GOODS_IN_TRANS == null ? null : USE_GOODS_IN_TRANS.trim();
    }

    public String getDOM_MAND_FOR_FC_YN()
    {
        return DOM_MAND_FOR_FC_YN;
    }

    public void setDOM_MAND_FOR_FC_YN(String dOMMANDFORFCYN)
    {
        DOM_MAND_FOR_FC_YN = dOMMANDFORFCYN;
    }

    public String getDOM_MAND_FOR_FC_OPTION()
    {
        return DOM_MAND_FOR_FC_OPTION;
    }

    public void setDOM_MAND_FOR_FC_OPTION(String dOMMANDFORFCOPTION)
    {
        DOM_MAND_FOR_FC_OPTION = dOMMANDFORFCOPTION;
    }

    public String getDOM_MAND_FOR_FC_IN()
    {
        return DOM_MAND_FOR_FC_IN;
    }

    public void setDOM_MAND_FOR_FC_IN(String dOMMANDFORFCIN)
    {
        DOM_MAND_FOR_FC_IN = dOMMANDFORFCIN;
    }

	public String getDEFAULT_SUSPENSE_ACC_YN() {
		return DEFAULT_SUSPENSE_ACC_YN;
	}

	public void setDEFAULT_SUSPENSE_ACC_YN(String dEFAULT_SUSPENSE_ACC_YN) {
		DEFAULT_SUSPENSE_ACC_YN = dEFAULT_SUSPENSE_ACC_YN;
	}

	public String getCONTRACT_REGISTRATION() {
		return CONTRACT_REGISTRATION;
	}

	public void setCONTRACT_REGISTRATION(String cONTRACT_REGISTRATION) {
		CONTRACT_REGISTRATION = cONTRACT_REGISTRATION;
	}

	public String getALLOW_EXCESS_OVER_LIMIT_YN()
	{
	    return ALLOW_EXCESS_OVER_LIMIT_YN;
	}

	public void setALLOW_EXCESS_OVER_LIMIT_YN(String aLLOW_EXCESS_OVER_LIMIT_YN)
	{
	    ALLOW_EXCESS_OVER_LIMIT_YN = aLLOW_EXCESS_OVER_LIMIT_YN;
	}

	public BigDecimal getDRAWDOWN_TYPE()
	{
	    return DRAWDOWN_TYPE;
	}

	public void setDRAWDOWN_TYPE(BigDecimal dRAWDOWN_TYPE)
	{
	    DRAWDOWN_TYPE = dRAWDOWN_TYPE;
	}
	
	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DOC_GRP_DESC
     *
     * @return the value of TFSDOCTYPE.DOC_GRP_DESC
     */
    public String getDOC_GRP_DESC() {
        return DOC_GRP_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DOC_GRP_DESC
     *
     * @param DOC_GRP_DESC the value for TFSDOCTYPE.DOC_GRP_DESC
     */
    public void setDOC_GRP_DESC(String DOC_GRP_DESC) {
        this.DOC_GRP_DESC = DOC_GRP_DESC == null ? null : DOC_GRP_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.STATUS
     *
     * @return the value of TFSDOCTYPE.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.STATUS
     *
     * @param STATUS the value for TFSDOCTYPE.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CREATED_BY
     *
     * @return the value of TFSDOCTYPE.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CREATED_BY
     *
     * @param CREATED_BY the value for TFSDOCTYPE.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.CREATED_DATE
     *
     * @return the value of TFSDOCTYPE.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.CREATED_DATE
     *
     * @param CREATED_DATE the value for TFSDOCTYPE.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.APPROVED_BY
     *
     * @return the value of TFSDOCTYPE.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.APPROVED_BY
     *
     * @param APPROVED_BY the value for TFSDOCTYPE.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.APPROVED_DATE
     *
     * @return the value of TFSDOCTYPE.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for TFSDOCTYPE.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MODIFIED_BY
     *
     * @return the value of TFSDOCTYPE.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TFSDOCTYPE.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.MODIFIED_DATE
     *
     * @return the value of TFSDOCTYPE.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for TFSDOCTYPE.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.REJECTED_BY
     *
     * @return the value of TFSDOCTYPE.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.REJECTED_BY
     *
     * @param REJECTED_BY the value for TFSDOCTYPE.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.REJECTED_DATE
     *
     * @return the value of TFSDOCTYPE.REJECTED_DATE
     */
    public Date getREJECTED_DATE() {
        return REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.REJECTED_DATE
     *
     * @param REJECTED_DATE the value for TFSDOCTYPE.REJECTED_DATE
     */
    public void setREJECTED_DATE(Date REJECTED_DATE) {
        this.REJECTED_DATE = REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.SHIP_GUAR_AVAIL_LC_DOC
     *
     * @return the value of TFSDOCTYPE.SHIP_GUAR_AVAIL_LC_DOC
     */
    public String getSHIP_GUAR_AVAIL_LC_DOC() {
        return SHIP_GUAR_AVAIL_LC_DOC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.SHIP_GUAR_AVAIL_LC_DOC
     *
     * @param SHIP_GUAR_AVAIL_LC_DOC the value for TFSDOCTYPE.SHIP_GUAR_AVAIL_LC_DOC
     */
    public void setSHIP_GUAR_AVAIL_LC_DOC(String SHIP_GUAR_AVAIL_LC_DOC) {
        this.SHIP_GUAR_AVAIL_LC_DOC = SHIP_GUAR_AVAIL_LC_DOC == null ? null : SHIP_GUAR_AVAIL_LC_DOC.trim();
    }
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.OFF_BS_DOC_ENTRIES_TYPE
     *
     * @return the value of TFSDOCTYPE.OFF_BS_DOC_ENTRIES_TYPE
     */
    public String getOFF_BS_DOC_ENTRIES_TYPE() {
        return OFF_BS_DOC_ENTRIES_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.OFF_BS_DOC_ENTRIES_TYPE
     *
     * @param OFF_BS_DOC_ENTRIES_TYPE the value for TFSDOCTYPE.OFF_BS_DOC_ENTRIES_TYPE
     */
    public void setOFF_BS_DOC_ENTRIES_TYPE(String OFF_BS_DOC_ENTRIES_TYPE) {
        this.OFF_BS_DOC_ENTRIES_TYPE = OFF_BS_DOC_ENTRIES_TYPE == null ? null : OFF_BS_DOC_ENTRIES_TYPE.trim();
    }
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.DOC_GRP_CODE
     *
     * @return the value of TFSDOCTYPE.DOC_GRP_CODE
     */
    public BigDecimal getDOC_GRP_CODE() {
        return DOC_GRP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.DOC_GRP_CODE
     *
     * @param DOC_GRP_CODE the value for TFSDOCTYPE.DOC_GRP_CODE
     */
    public void setDOC_GRP_CODE(BigDecimal DOC_GRP_CODE) {
        this.DOC_GRP_CODE = DOC_GRP_CODE;
    }
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_DEPT
     */
    public BigDecimal getLC_INW_DOC_ASSET_DEPT() {
        return LC_INW_DOC_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DEPT
     *
     * @param LC_INW_DOC_ASSET_DEPT the value for TFSDOCTYPE.LC_INW_DOC_ASSET_DEPT
     */
    public void setLC_INW_DOC_ASSET_DEPT(BigDecimal LC_INW_DOC_ASSET_DEPT) {
        this.LC_INW_DOC_ASSET_DEPT = LC_INW_DOC_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_DIV
     */
    public BigDecimal getLC_INW_DOC_ASSET_DIV() {
        return LC_INW_DOC_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_DIV
     *
     * @param LC_INW_DOC_ASSET_DIV the value for TFSDOCTYPE.LC_INW_DOC_ASSET_DIV
     */
    public void setLC_INW_DOC_ASSET_DIV(BigDecimal LC_INW_DOC_ASSET_DIV) {
        this.LC_INW_DOC_ASSET_DIV = LC_INW_DOC_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DEPT
     */
    public BigDecimal getLC_INW_DOC_ASSET_FIN_DEPT() {
        return LC_INW_DOC_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DEPT
     *
     * @param LC_INW_DOC_ASSET_FIN_DEPT the value for TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DEPT
     */
    public void setLC_INW_DOC_ASSET_FIN_DEPT(BigDecimal LC_INW_DOC_ASSET_FIN_DEPT) {
        this.LC_INW_DOC_ASSET_FIN_DEPT = LC_INW_DOC_ASSET_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DIV
     */
    public BigDecimal getLC_INW_DOC_ASSET_FIN_DIV() {
        return LC_INW_DOC_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DIV
     *
     * @param LC_INW_DOC_ASSET_FIN_DIV the value for TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_DIV
     */
    public void setLC_INW_DOC_ASSET_FIN_DIV(BigDecimal LC_INW_DOC_ASSET_FIN_DIV) {
        this.LC_INW_DOC_ASSET_FIN_DIV = LC_INW_DOC_ASSET_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_GL
     */
    public BigDecimal getLC_INW_DOC_ASSET_FIN_GL() {
        return LC_INW_DOC_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_GL
     *
     * @param LC_INW_DOC_ASSET_FIN_GL the value for TFSDOCTYPE.LC_INW_DOC_ASSET_FIN_GL
     */
    public void setLC_INW_DOC_ASSET_FIN_GL(BigDecimal LC_INW_DOC_ASSET_FIN_GL) {
        this.LC_INW_DOC_ASSET_FIN_GL = LC_INW_DOC_ASSET_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_ASSET_GL
     */
    public BigDecimal getLC_INW_DOC_ASSET_GL() {
        return LC_INW_DOC_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_ASSET_GL
     *
     * @param LC_INW_DOC_ASSET_GL the value for TFSDOCTYPE.LC_INW_DOC_ASSET_GL
     */
    public void setLC_INW_DOC_ASSET_GL(BigDecimal LC_INW_DOC_ASSET_GL) {
        this.LC_INW_DOC_ASSET_GL = LC_INW_DOC_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_DEPT
     */
    public BigDecimal getLC_INW_DOC_LIAB_DEPT() {
        return LC_INW_DOC_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DEPT
     *
     * @param LC_INW_DOC_LIAB_DEPT the value for TFSDOCTYPE.LC_INW_DOC_LIAB_DEPT
     */
    public void setLC_INW_DOC_LIAB_DEPT(BigDecimal LC_INW_DOC_LIAB_DEPT) {
        this.LC_INW_DOC_LIAB_DEPT = LC_INW_DOC_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_DIV
     */
    public BigDecimal getLC_INW_DOC_LIAB_DIV() {
        return LC_INW_DOC_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_DIV
     *
     * @param LC_INW_DOC_LIAB_DIV the value for TFSDOCTYPE.LC_INW_DOC_LIAB_DIV
     */
    public void setLC_INW_DOC_LIAB_DIV(BigDecimal LC_INW_DOC_LIAB_DIV) {
        this.LC_INW_DOC_LIAB_DIV = LC_INW_DOC_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DEPT
     */
    public BigDecimal getLC_INW_DOC_LIAB_FIN_DEPT() {
        return LC_INW_DOC_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DEPT
     *
     * @param LC_INW_DOC_LIAB_FIN_DEPT the value for TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DEPT
     */
    public void setLC_INW_DOC_LIAB_FIN_DEPT(BigDecimal LC_INW_DOC_LIAB_FIN_DEPT) {
        this.LC_INW_DOC_LIAB_FIN_DEPT = LC_INW_DOC_LIAB_FIN_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DIV
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DIV
     */
    public BigDecimal getLC_INW_DOC_LIAB_FIN_DIV() {
        return LC_INW_DOC_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DIV
     *
     * @param LC_INW_DOC_LIAB_FIN_DIV the value for TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_DIV
     */
    public void setLC_INW_DOC_LIAB_FIN_DIV(BigDecimal LC_INW_DOC_LIAB_FIN_DIV) {
        this.LC_INW_DOC_LIAB_FIN_DIV = LC_INW_DOC_LIAB_FIN_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_GL
     */
    public BigDecimal getLC_INW_DOC_LIAB_FIN_GL() {
        return LC_INW_DOC_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_GL
     *
     * @param LC_INW_DOC_LIAB_FIN_GL the value for TFSDOCTYPE.LC_INW_DOC_LIAB_FIN_GL
     */
    public void setLC_INW_DOC_LIAB_FIN_GL(BigDecimal LC_INW_DOC_LIAB_FIN_GL) {
        this.LC_INW_DOC_LIAB_FIN_GL = LC_INW_DOC_LIAB_FIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_INW_DOC_LIAB_GL
     */
    public BigDecimal getLC_INW_DOC_LIAB_GL() {
        return LC_INW_DOC_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_INW_DOC_LIAB_GL
     *
     * @param LC_INW_DOC_LIAB_GL the value for TFSDOCTYPE.LC_INW_DOC_LIAB_GL
     */
    public void setLC_INW_DOC_LIAB_GL(BigDecimal LC_INW_DOC_LIAB_GL) {
        this.LC_INW_DOC_LIAB_GL = LC_INW_DOC_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_DOC_CASH_ASSET_DEPT() {
        return LC_OUT_DOC_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DEPT
     *
     * @param LC_OUT_DOC_CASH_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DEPT
     */
    public void setLC_OUT_DOC_CASH_ASSET_DEPT(BigDecimal LC_OUT_DOC_CASH_ASSET_DEPT) {
        this.LC_OUT_DOC_CASH_ASSET_DEPT = LC_OUT_DOC_CASH_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DIV
     */
    public BigDecimal getLC_OUT_DOC_CASH_ASSET_DIV() {
        return LC_OUT_DOC_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DIV
     *
     * @param LC_OUT_DOC_CASH_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_DIV
     */
    public void setLC_OUT_DOC_CASH_ASSET_DIV(BigDecimal LC_OUT_DOC_CASH_ASSET_DIV) {
        this.LC_OUT_DOC_CASH_ASSET_DIV = LC_OUT_DOC_CASH_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_GL
     */
    public BigDecimal getLC_OUT_DOC_CASH_ASSET_GL() {
        return LC_OUT_DOC_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_GL
     *
     * @param LC_OUT_DOC_CASH_ASSET_GL the value for TFSDOCTYPE.LC_OUT_DOC_CASH_ASSET_GL
     */
    public void setLC_OUT_DOC_CASH_ASSET_GL(BigDecimal LC_OUT_DOC_CASH_ASSET_GL) {
        this.LC_OUT_DOC_CASH_ASSET_GL = LC_OUT_DOC_CASH_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_DOC_CASH_LIAB_DEPT() {
        return LC_OUT_DOC_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DEPT
     *
     * @param LC_OUT_DOC_CASH_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DEPT
     */
    public void setLC_OUT_DOC_CASH_LIAB_DEPT(BigDecimal LC_OUT_DOC_CASH_LIAB_DEPT) {
        this.LC_OUT_DOC_CASH_LIAB_DEPT = LC_OUT_DOC_CASH_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DIV
     */
    public BigDecimal getLC_OUT_DOC_CASH_LIAB_DIV() {
        return LC_OUT_DOC_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DIV
     *
     * @param LC_OUT_DOC_CASH_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_DIV
     */
    public void setLC_OUT_DOC_CASH_LIAB_DIV(BigDecimal LC_OUT_DOC_CASH_LIAB_DIV) {
        this.LC_OUT_DOC_CASH_LIAB_DIV = LC_OUT_DOC_CASH_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_GL
     */
    public BigDecimal getLC_OUT_DOC_CASH_LIAB_GL() {
        return LC_OUT_DOC_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_GL
     *
     * @param LC_OUT_DOC_CASH_LIAB_GL the value for TFSDOCTYPE.LC_OUT_DOC_CASH_LIAB_GL
     */
    public void setLC_OUT_DOC_CASH_LIAB_GL(BigDecimal LC_OUT_DOC_CASH_LIAB_GL) {
        this.LC_OUT_DOC_CASH_LIAB_GL = LC_OUT_DOC_CASH_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DEPT
     */
    public BigDecimal getLC_OUT_DOC_FIN_ASSET_DEPT() {
        return LC_OUT_DOC_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DEPT
     *
     * @param LC_OUT_DOC_FIN_ASSET_DEPT the value for TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DEPT
     */
    public void setLC_OUT_DOC_FIN_ASSET_DEPT(BigDecimal LC_OUT_DOC_FIN_ASSET_DEPT) {
        this.LC_OUT_DOC_FIN_ASSET_DEPT = LC_OUT_DOC_FIN_ASSET_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DIV
     */
    public BigDecimal getLC_OUT_DOC_FIN_ASSET_DIV() {
        return LC_OUT_DOC_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DIV
     *
     * @param LC_OUT_DOC_FIN_ASSET_DIV the value for TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_DIV
     */
    public void setLC_OUT_DOC_FIN_ASSET_DIV(BigDecimal LC_OUT_DOC_FIN_ASSET_DIV) {
        this.LC_OUT_DOC_FIN_ASSET_DIV = LC_OUT_DOC_FIN_ASSET_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_GL
     */
    public BigDecimal getLC_OUT_DOC_FIN_ASSET_GL() {
        return LC_OUT_DOC_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_GL
     *
     * @param LC_OUT_DOC_FIN_ASSET_GL the value for TFSDOCTYPE.LC_OUT_DOC_FIN_ASSET_GL
     */
    public void setLC_OUT_DOC_FIN_ASSET_GL(BigDecimal LC_OUT_DOC_FIN_ASSET_GL) {
        this.LC_OUT_DOC_FIN_ASSET_GL = LC_OUT_DOC_FIN_ASSET_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DEPT
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DEPT
     */
    public BigDecimal getLC_OUT_DOC_FIN_LIAB_DEPT() {
        return LC_OUT_DOC_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DEPT
     *
     * @param LC_OUT_DOC_FIN_LIAB_DEPT the value for TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DEPT
     */
    public void setLC_OUT_DOC_FIN_LIAB_DEPT(BigDecimal LC_OUT_DOC_FIN_LIAB_DEPT) {
        this.LC_OUT_DOC_FIN_LIAB_DEPT = LC_OUT_DOC_FIN_LIAB_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DIV
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DIV
     */
    public BigDecimal getLC_OUT_DOC_FIN_LIAB_DIV() {
        return LC_OUT_DOC_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DIV
     *
     * @param LC_OUT_DOC_FIN_LIAB_DIV the value for TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_DIV
     */
    public void setLC_OUT_DOC_FIN_LIAB_DIV(BigDecimal LC_OUT_DOC_FIN_LIAB_DIV) {
        this.LC_OUT_DOC_FIN_LIAB_DIV = LC_OUT_DOC_FIN_LIAB_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_GL
     *
     * @return the value of TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_GL
     */
    public BigDecimal getLC_OUT_DOC_FIN_LIAB_GL() {
        return LC_OUT_DOC_FIN_LIAB_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_GL
     *
     * @param LC_OUT_DOC_FIN_LIAB_GL the value for TFSDOCTYPE.LC_OUT_DOC_FIN_LIAB_GL
     */
    public void setLC_OUT_DOC_FIN_LIAB_GL(BigDecimal LC_OUT_DOC_FIN_LIAB_GL) {
        this.LC_OUT_DOC_FIN_LIAB_GL = LC_OUT_DOC_FIN_LIAB_GL;
    }
	
}