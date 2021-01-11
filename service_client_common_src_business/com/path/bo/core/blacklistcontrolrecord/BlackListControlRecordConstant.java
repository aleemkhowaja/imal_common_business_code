package com.path.bo.core.blacklistcontrolrecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ControlRecordConstant.java used to define Constant variables 
 */
public class BlackListControlRecordConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(972); //by bilal for BUG#945746, use 972 instead 153 because not exist in SBYB DB
	public static final String STATUS_CREATED = "C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "M";
	public static final String STATUS_APPROVED = "P";
    public static final String STATUS_ACTIVE = "A";
    public static final String CRUD_UPDATE_AFTER_AUTHORIZE = "U";

	public static final BigDecimal andOnList = new BigDecimal(1754);
    public static final Integer INT_ONE = 1;

    public static final String CHECKED = "true";
    public static final String UNCHECKED = "false";

    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final String Y = "Y";
    public static final String N = "N";
    public static final String CHECKED_YN = "Y";
    public static final String UNCHECKED_YN = "N";
    public static final  BigDecimal MAX_PERC= new BigDecimal(100);
    public static final String OR = "O";
    public static final String AND = "A";




    


	  // OPT


	public static final List<String> controlRecordStatusLst = new ArrayList<String>();
    	static{
    		controlRecordStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
    		controlRecordStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    		controlRecordStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		controlRecordStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
