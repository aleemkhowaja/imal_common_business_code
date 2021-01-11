package com.path.bo.core.instructiondefinition;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionConstant.java used to define Constant variables 
 */
public class InstructionDefinitionConstant
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

	public static final List<String> instructionDefinitionStatusLst = new ArrayList<String>();
    	static{
    		instructionDefinitionStatusLst.add("CREATED_BY,"+STATUS_CREATED+",DATE_CREATED");
    		instructionDefinitionStatusLst.add("DELETED_BY,"+STATUS_DELETED+",DATE_DELETED");
    		instructionDefinitionStatusLst.add("MODIFIED_BY,"+STATUS_MODIFIED+",DATE_MODIFIED");
    		instructionDefinitionStatusLst.add("APPROVED_BY,"+STATUS_APPROVED+",DATE_APPROVED");
    		instructionDefinitionStatusLst.add("SUSPENDED_BY,"+STATUS_SUSPENDED+",DATE_SUSPENDED");
    		instructionDefinitionStatusLst.add("REACTIVATED_BY,"+STATUS_REACTIVATED+",DATE_REACTIVATED");
    		instructionDefinitionStatusLst.add("CANCELED_BY,"+STATUS_CANCELED+",DATE_CANCELED");
    		instructionDefinitionStatusLst.add("TO_REACTIVATE_BY,"+STATUS_TO_REACTIVATE+",TO_REACTIVATE_DATE");
    		instructionDefinitionStatusLst.add("TO_SUSPEND_BY,"+STATUS_TO_SUSPEND+",TO_SUSPEND_DATE");
    		instructionDefinitionStatusLst.add("TO_CANCEL_BY,"+STATUS_TO_CANCEL+",TO_CANCEL_DATE");
		}
}
