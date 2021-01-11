package com.path.bo.core.grouping;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SegmentGroupingConstant.java used to define Constant variables 
 */
public class SegmentGroupingConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(63);
	public static final String MAINT_IVCRUD = "MT";
    public static final String UPDATE_AFTER_APPROVE_IVCRUD = "UP";
    public static final String STATUS_APPROVE_REJECTED = "J";
    public static final String STATUS_ACTIVE = "A";
    
	public static final String STATUS_CREATED = "0_C";
	public static final String STATUS_DELETED = "D";
	public static final String STATUS_MODIFIED = "0_M";
	public static final String STATUS_APPROVED = "P";
	public static final String STATUS_SUSPENDED = "S";
	public static final String STATUS_REACTIVATED = "0_R";
	public static final String STATUS_CANCELED = "C";
	public static final String STATUS_TO_REACTIVATE = "R";
	public static final String STATUS_TO_SUSPEND = "T";
	public static final String STATUS_TO_CANCEL = "N";

	public static final List<String> segmentGroupingStatusLst = new ArrayList<String>();
    	static{
    		segmentGroupingStatusLst.add("CREATED_BY,"+STATUS_CREATED+",DATE_CREATED");
    		segmentGroupingStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED");
    		segmentGroupingStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",DATE_MODIFIED");
    		segmentGroupingStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",DATE_APPROVED");
		}
}
