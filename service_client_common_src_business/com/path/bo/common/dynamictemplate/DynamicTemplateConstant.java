package com.path.bo.common.dynamictemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateConstant.java used to define Constant variables 
 */
public class DynamicTemplateConstant
{
	public static BigDecimal nodeTypelistDropDown = new BigDecimal(954);
	public static BigDecimal LOV_TYPE = new BigDecimal(971);
	public static BigDecimal LOV_LK_OPT_TYPE = new BigDecimal(966);
	public static BigDecimal LOV_TYPE_ENTITY = new BigDecimal(967);
	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_CREATED = "0_C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "0_M";
	public static final String STATUS_APPROVED = "P";
	public static final String STATUS_APPROVE_REJECTED = "J";
	public static final String STATUS_SUSPEND = "S";
	public static final String STATUS_REACTIVATED = "RA";
	public static final String CRUD_UP = "UP";
	public static final String CRUD_P = "P";
	public static final String CRUD_R = "R";
	public static final String CRUD_J = "J";

	public static final List<String> dynamicTemplateStatusLst = new ArrayList<String>();
    	static{
    		dynamicTemplateStatusLst.add("CREATED_BY,"+DynamicTemplateConstant.STATUS_CREATED+",CREATED_DATE,SERVER_CREATED_DATE");
    		dynamicTemplateStatusLst.add("MODIFIED_BY,"+DynamicTemplateConstant.STATUS_MODIFIED+",MODIFIED_DATE,SERVER_MODIFIED_DATE");
    		dynamicTemplateStatusLst.add("DELETED_BY,"+DynamicTemplateConstant.STATUS_DELETED+",DELETED_DATE,SERVER_DELETED_DATE");
    		dynamicTemplateStatusLst.add("APPROVED_BY,"+DynamicTemplateConstant.STATUS_APPROVED+",APPROVED_DATE,SERVER_APPROVED_DATE");
    		dynamicTemplateStatusLst.add("APPROVE_REJECTED_BY,"+DynamicTemplateConstant.STATUS_APPROVE_REJECTED+",APPROVE_REJECTED_DATE,SERVER_APPROVE_REJECTED_DATE");
    		dynamicTemplateStatusLst.add("SUSPENDED_BY,"+DynamicTemplateConstant.STATUS_SUSPEND+",SUSPENDED_DATE,SERVER_SUSPENDED_DATE");
    		dynamicTemplateStatusLst.add("REACTIVATE_BY,"+DynamicTemplateConstant.STATUS_REACTIVATED+",REACTIVATE_DATE,SERVER_REACTIVATE_DATE");
		}
}
