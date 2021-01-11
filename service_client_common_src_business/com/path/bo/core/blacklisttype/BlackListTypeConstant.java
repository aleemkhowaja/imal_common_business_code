package com.path.bo.core.blacklisttype;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * author : nour
 * tp:777000
 * BlackListTypeConstant.java used to define Constant variables 
 */
public class BlackListTypeConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(153);
	public static final String STATUS_CREATED = "C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "M";
	public static final String STATUS_APPROVED = "P";
    public static final String CRUD_UPDATE_AFTER_AUTHORIZE = "U";
	public static final String STATUS_ACTIVE="A";

	public static final BigDecimal revisionBasisList = new BigDecimal(1798);
	
	public static final String NOT_APPLICABLE = "N";
    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final Integer INT_ONE = 1;


	public static final List<String> blackListTypeStatusLst = new ArrayList<String>();
    	static{
    		blackListTypeStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
    		blackListTypeStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    		blackListTypeStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		blackListTypeStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
