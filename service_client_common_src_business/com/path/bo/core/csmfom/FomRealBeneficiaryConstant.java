package com.path.bo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FomRealBeneficiaryConstant
{

    public static final BigDecimal REAL_BENEF_STATUS_LOV_TYPE        		= BigDecimal.valueOf(1459);
    
    public static final String STATUS_CREATED       	= "0_C";
    public static final String STATUS_MODIFIED      	= "0_M";
    public static final String STATUS_TO_BE_DELETED	= "TD";
    public static final String STATUS_DELETED 		= "D";
    public static final String STATUS_ACTIVE		= "A";
    public static final String STATUS_INACTIVE		= "I";
    public static final String STATUS_TO_CANCEL		= "TC";
    public static final String STATUS_CANCEL		= "CA";    
//    public static final String STATUS_APPROVED 		= "P";
    public static final String STATUS_DEACTIVATED	= "T";
    
    public static final String PARENT_CHILD_IND_P	= "P";
    public static final String PARENT_CHILD_IND_C	= "C";
    public static final String PARENT_BENEF_PARAM = "Parent Beneficiary ";
    public static final String DELETED = " Deleted";
    public static final String CANCELLED = " Cancelled";
    
    public static final String NOT_APPLICABLE = "NA";
    
    public static List<String> getStatusFields(){
    	ArrayList<String> statusFields = new ArrayList<String>();

    	statusFields.add("CREATED_BY,"+STATUS_INACTIVE+",CREATED_DATE");
    	statusFields.add("MODIFIED_BY,"+STATUS_MODIFIED+",MODIFIED_DATE");
    	statusFields.add("DEACTIVATED_BY,"+STATUS_DEACTIVATED+",DEACTIVATED_DATE");
    	statusFields.add("TO_DELETE_BY,"+STATUS_TO_BE_DELETED+",TO_DELETE_DATE");    	
    	statusFields.add("DELETED_BY,"+STATUS_DELETED+",DELETED_DATE");
    	statusFields.add("TO_CANCEL_BY,"+STATUS_TO_CANCEL+",TO_CANCEL_DATE");
    	statusFields.add("CANCEL_BY,"+STATUS_CANCEL+",CANCEL_DATE");
    	statusFields.add("ACTIVATED_BY,"+STATUS_ACTIVE+",ACTIVATED_DATE");
    	return statusFields;
    }
}
