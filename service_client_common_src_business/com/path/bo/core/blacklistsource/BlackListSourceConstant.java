package com.path.bo.core.blacklistsource;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * BlackListSourceConstant.java used to define Constant variables 
 */
public class BlackListSourceConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(153);
	//public static BigDecimal LOV_TYPE = new BigDecimal(972);

	public static final String STATUS_CREATED = "C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "M";
	public static final String STATUS_APPROVED = "P";
    public static final String STATUS_ACTIVE = "A";
    public static final String CRUD_UPDATE_AFTER_AUTHORIZE = "U";


    public static final String ONE = "1";

    public static final Integer INT_ONE = 1;
    public static final String CHECKED = "true";
    public static final String UNCHECKED = "false";

    public static final String ZERO = "0";
    public static final String YES="Y";
    public static final String NO ="N";




	public static final List<String> blackListSourceStatusLst = new ArrayList<String>();
    	static{
    		blackListSourceStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
    		blackListSourceStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    		blackListSourceStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		blackListSourceStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
