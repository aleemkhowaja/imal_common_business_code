package com.path.bo.core.instructionsubinstr;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrConstant.java used to define Constant variables 
 */
public class InstructionSubInstrConstant
{
	public static BigDecimal LOV_TYPE = new BigDecimal(10);
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

	public static final List<String> instructionSubInstrStatusLst = new ArrayList<String>();
    	static{
    		instructionSubInstrStatusLst.add("CREATED_BY,"+STATUS_CREATED+",DATE_CREATED");
    		instructionSubInstrStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED");
    		instructionSubInstrStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",DATE_MODIFIED");
    		instructionSubInstrStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",DATE_APPROVED");
    		instructionSubInstrStatusLst.add("SUSPENDED_BY,"+STATUS_SUSPENDED+",DATE_SUSPENDED");
    		instructionSubInstrStatusLst.add("REACTIVATED_BY,"+STATUS_REACTIVATED+",DATE_REACTIVATED");
    		instructionSubInstrStatusLst.add("CANCELED_BY,"+STATUS_CANCELED+",DATE_CANCELED");
    		instructionSubInstrStatusLst.add("TO_REACTIVATE_BY,"+STATUS_TO_REACTIVATE+",TO_REACTIVATE_DATE");
    		instructionSubInstrStatusLst.add("TO_SUSPEND_BY,"+STATUS_TO_SUSPEND+",TO_SUSPEND_DATE");
    		instructionSubInstrStatusLst.add("TO_CANCEL_BY,"+STATUS_TO_CANCEL+",TO_CANCEL_DATE");
		}
}
