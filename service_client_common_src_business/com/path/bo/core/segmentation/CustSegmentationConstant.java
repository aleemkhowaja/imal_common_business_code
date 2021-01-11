package com.path.bo.core.segmentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * CustSegmentationConstant.java used to define Constant variables
 */
public class CustSegmentationConstant
{

	public static BigDecimal LOV_TYPE = new BigDecimal(972);
	public static final String STATUS_MODIFIED = "0_M";
	public static final String STATUS_APPROVED = "P";
	public static final String STATUS_APPROVE_REJECTED = "J";
	public static final String STATUS_CREATED = "0_C";
	public static final String STATUS_ACTIVE = "A";
	// Rania - 718813 - Dynamic Customer Scoring on latest
	public static final String STATUS_SUSPEND = "Q";
	public static final String STATUS_APPROVE_SUSPEND = "S";
	public static final String STATUS_REACTIVATE = "Y";
	public static final String STATUS_APPROVE_REACTIVATE = "P";
	public static final String STATUS_CANCEL = "N";
	public static final String STATUS_APPROVE_CANCEL = "C";
	public static final String STATUS_DELETE = "D";
	
	

	// End Rania
	
	// Added By Ali
	public static final String BUSINESS_RULES = "BR";
	public static final String SEGMENTATION = "S";
	public static final String SCORING = "SC";
	public static final String FIRST_ROW_LOGICAL_OPERATOR_VALUE = "X";
	public static final String CR_USAGE_BUSINESS_RULES = "B";
	//End Ali
	/*
	 * Iv_Crud
	 */
	public static final String MAINT_IVCRUD = "MT";
	public static final String UPDATE_AFTER_APPROVE_IVCRUD = "UP";
	// Rania - 718813 - Dynamic Customer Scoring on latest
	public static final String SUSPEND = "S";
	public static final String APPROVE_SUSPEND = "SP";
	public static final String REACTIVATE = "RE";
	public static final String APPROVE_REACTIVATE = "RP";
	public static final String CANCEL = "C";
	public static final String APPROVE_CANCEL = "CP";

	// End Rania
	// ADDED BY NOUR for #835004

	public static final String MAINT = "R";
	public static final String UPDATE_AFTER_APPROVE = "U";
	public static final BigDecimal periodicityList = new BigDecimal(1795);
	public static final BigDecimal dayList = new BigDecimal(1752);
	public static String WEEKLY="W";
	public static String ONE = "1"; //By Bilal For TP#750884
	public static String ZERO = "0"; //By Bilal For TP#750884
	public static String APPROVE_CRUD = "P";
	
	
	// end nour

	//Rania - ABSAI180073
	public static final String AML_APP = "AML";
	//
	public static final String CHECKED ="1"; // ADDDED by nour for bug955568
	public static final List<String> custSegmentationStatusLst = new ArrayList<String>();
	static
	{
		custSegmentationStatusLst.add("CREATED_BY," + STATUS_CREATED + ",DATE_CREATED");
		custSegmentationStatusLst.add("MODIFIED_BY," + STATUS_MODIFIED + ",DATE_MODIFIED");
		custSegmentationStatusLst.add("APPROVED_BY," + STATUS_APPROVED + ",DATE_APPROVED");
		custSegmentationStatusLst.add("REJECTED_BY," + STATUS_APPROVE_REJECTED + ",DATE_REJECTED");
		custSegmentationStatusLst.add("SUSPENDED_BY," + STATUS_APPROVE_SUSPEND + ",SUSPENDED_DATE");
		custSegmentationStatusLst.add("REACTIVATED_BY," + STATUS_APPROVE_REACTIVATE + ",REACTIVATED_DATE");
		custSegmentationStatusLst.add("CANCELED_BY," + STATUS_APPROVE_CANCEL + ",CANCELED_DATE");
		custSegmentationStatusLst.add("TO_SUSPEND_BY," + STATUS_SUSPEND + ",TO_SUSPEND_DATE");
		custSegmentationStatusLst.add("TO_REACTIVATE_BY," + STATUS_REACTIVATE + ",TO_REACTIVATE_DATE");
		custSegmentationStatusLst.add("TO_CANCEL_BY," + STATUS_CANCEL + ",TO_CANCEL_DATE");
		custSegmentationStatusLst.add("DELETED_BY," + STATUS_DELETE + ",DELETED_DATE");
	}
	
	public static final String PLEASE_RUN_SEG_PROCESS = "Please run segmentation process";
	public static final String SEG_PROCESS_UPDATED_PLEASE_TAKE_ACTION = "The segmentation process has been updated, please take an action";
}
