package com.path.bo.core.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScoringControlRecordConstant.java used to define Constant variables 
 */
public class ScoringControlRecordConstant
{
	//public static BigDecimal LOV_TYPE = new BigDecimal(153);
	public static BigDecimal LOV_TYPE = new BigDecimal(972);

	public static final String STATUS_CREATED = "0_C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "0_M";
	public static final String STATUS_APPROVED = "P";
	public static final String New = "";
    public static final String STATUS_ACTIVE = "A";
    public static final String CRUD_MAINTENANCE = "R";
    public static final String CRUD_AUTHORIZE = "P";
    public static final String CRUD_UPDATE_AFTER_AUTHORIZE = "U";
    public static final BigDecimal Zero = BigDecimal.ZERO;
    public static final BigDecimal One = BigDecimal.ONE;
    public static final BigDecimal CASE_SEVERITY_LOV_TYPE = BigDecimal.valueOf(1831);
    public static final BigDecimal PROFILING_BASED_ON_LOV_TYPE = BigDecimal.valueOf(1845); //by bilal for TP#987360


	public static final List<String> scoringControlRecordStatusLst = new ArrayList<String>();
    	static{
    		scoringControlRecordStatusLst.add("CREATED_BY,"+STATUS_CREATED+",CREATED_DATE");
    		scoringControlRecordStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    		scoringControlRecordStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    		scoringControlRecordStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",APPROVED_DATE");
		}
}
