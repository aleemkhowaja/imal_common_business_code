package com.path.core.bo.transferentity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class TransferEntityConstant
{

	private TransferEntityConstant() {
	}
	
	public static final String APPROVE_METHOD_NAME = "approve";
	public static final String CANCEL_METHOD_NAME = "cancel";
	public static final String APPROVE_CANCEL_METHOD_NAME = "approveCancel";
	public static final String TRANSFER_METHOD_NAME = "transfer";
	public static final String STATUS_CANCELED = "C";
	public static final String STATUS_TRANSFERED = "T";

	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_APPROVED = "P";
	public static final String STATUS_TO_BE_CANCELLED = "Z";
	public static final String STATUS_APPROVED_CANCELLED = "C";
	public static final String STATUS_TRANSFERRED = "T";


	public static final String EMPTY_STRING = "";

	public static final String APPROVED = "P";
	public static final String IV_CRUD_U = "U";
	public static final String IV_CRUD_R = "R";
	public static final String IV_CRUD_P = "P";
	public static final String IV_CRUD_N = "N";

	public static final String BYCIF = "C";
	public static final String BYACCOUNT = "A";
	public static final String BYFINANCING = "F";

	public static final String RANGE = "R";
	public static final String TYPE = "T";


	  public static final String SUCCESS_STATUS = "SUCCESS_STATUS";
	  public static final BigDecimal LOV_TYPE = new BigDecimal(951);

	public static final String CANCELED = "C";
	public static final String APPROVE_CANCEL = "Z";
	public static final String TRANSFERED = "T";
	public static final String TO_BE_CANCELED = "C";
	public static final String CRUD_MAINTENANCE = "R";
	public static final String CRUD_APPROVE = "P";
	public static final String CRUD_TO_CANCEL = "C";
	public static final String CRUD_APPROVE_CANCEL = "Z";
	public static final String CRUD_TRANSFER = "T";
	public static final String PARENT_OPT 					= "TOE00";
	
	public static final String CREATE = "U";
	public static final String APPROVAL = "AP";
	public static final String CANCELLATION = "N";
	public static final String APPROVE_CANCELLATION = "CP";
	public static final String TRANSFER = "TE";

	public static final List<String> transferEntityStatusLst = new ArrayList<String>();
	    static
	    {
	    	transferEntityStatusLst.add("CREATED_BY," + STATUS_ACTIVE + ",CREATED_DATE");
		transferEntityStatusLst.add("APPROVED_BY," + STATUS_APPROVED + ",APPROVED_DATE");		
		transferEntityStatusLst.add("CANCELED_BY,"+STATUS_TO_BE_CANCELLED+",CANCELED_DATE");
		transferEntityStatusLst.add("APPROVED_CANCEL_BY," + STATUS_APPROVED_CANCELLED + ",APPROVED_CANCEL_DATE");
		transferEntityStatusLst.add("TRANSFERED_BY," + STATUS_TRANSFERRED + ",TRANSFERED_DATE");

	    }
}
