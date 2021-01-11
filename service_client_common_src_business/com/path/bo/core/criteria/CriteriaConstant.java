package com.path.bo.core.criteria;

import java.math.BigDecimal;

public class CriteriaConstant
{

    public static final String CRUD_MAINTENANCE = "R";

    // references
    public static final String REFERENCE_CREATE = "C";
    public static final String REFERENCE_UPDATE = "U";
    // OPT
    public static final String PARENT_OPT = "CSG00";

    // crud
    public static final String CRUD_TO_CANCEL = "K";
    public static final String CRUD_CANCEL = "N";

    // Print Advice
    public static final String CANCEL_PRINT = "CAN";
    public static final String APPROVE_PRINT = "APP";

    public static final BigDecimal CRITERIA_USAGE_LOV_TYPE = new BigDecimal(980);
    public static final BigDecimal CRITERIA_PARAM_CLASS_LOV_TYPE = new BigDecimal(1727);
    
    public static final String CRITERIA_CODE[] = { "Criteria_Id", "criteriaCO.ctsCriteriaVO.CRITERIA_CODE" };
    public static final String SCORE[] = { "scoreValue", "criteriaCO.ctsCriteriaVO.SCORE" }; //Rania - 718813 - Dynamic Customer Scoring on latest
    
    public static final String PARAM_CLASS_Q = "Q";
    public static final String PARAM_CLASS_F = "F";
    public static final String PARAM_CLASS_D = "D";
    public static final String PARAM_CLASS_S = "S";
    
    //added by bilal for TP#750884
    public static final String PAGE_REF_CRITERIA_BUS_RULE = "BR001MT";
    public static final String PAGE_REF_CRITERIA_SCORING = "CSG00CR";
    
    public static final String SELECT_CODE_BUS_RULE = "B";
    public static final String SELECT_CODE_SCORING = "O";
    
    public static final String APP_NAME_AML = "AML";
    
}