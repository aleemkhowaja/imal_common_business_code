package com.path.core.bo.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.log.Log;

public final class BlackListConstant
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    @Deprecated
    private BlackListConstant()
    {
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    }

    public static final BigDecimal BLACK_LIST_STATUS_LOV_TYPE = BigDecimal.valueOf(107);

    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_DELETED = "D";
    public static final String STATUS_APPROVED = "P";
    public static final String STATUS_REVERSED = "R";
    public static final String STATUS_TO_BE_REVERSED = "V";
    public static final String STATUS_FROM_CENTRAL_FILE = "G";
    public static final String STATUS_CREATED = "0_C";
    public static final String STATUS_MODIFIED = "0_M";
    public static final String STATUS_REJECTED = "P";

    public static final String CRUD_MAINTENANCE = "R";
    public static final String CRUD_APPROVE = "P";
    public static final String CRUD_REVERSE = "V";
    public static final String CRUD_TE_BE_REVERSED = "TV";
    public static final String CRUD_UPDATE_AFTER_APPROVE = "UP";

    public static final String BLACK_LIST_TYPE_REVISION_BASIS_SOURCE_DATE_FLAG = "S";
    public static final String BLACK_LIST_TYPE_REVISION_BASIS_CREATE_DATE_FLAG = "C";
    public static final String BLACK_LIST_TYPE_REVISION_BASIS_APPROVE_DATE_FLAG = "P";
//    public static final String UPDATE_AFTER_APPROVE_PROG_REF = "BL001UP";

    public static List<String> getStatusFields()
    {
	ArrayList<String> statusFields = new ArrayList<String>();
	statusFields.add("CREATED_BY," + STATUS_CREATED + ",DATE_CREATED");
	statusFields.add("UPDATED_BY," + STATUS_MODIFIED + ",DATE_UPDATED");
	statusFields.add("APPROVED_BY," + STATUS_APPROVED + ",DATE_APPROVED");
	statusFields.add("REVERSED_BY," + STATUS_REVERSED + ",DATE_REVERSED");
	statusFields.add("TO_BE_REVERSED_BY," + STATUS_TO_BE_REVERSED + ",TO_BE_REVERSED_DATE");
	return statusFields;
    }

    // Access privileges on create,update buttons on maintenance screen
    public static final String ACCESS_CREATE = "BL001C";
    public static final String ACCESS_UPDATE = "BL001U";

    //this constant is used when we approve a blacklist record having a CIF
    public static final String SUSPEND_USER_FROM_EOD = "BLACKMGT";

    public static final BigDecimal BLACKLIST_LOG_ACTION_LOV = BigDecimal.valueOf(1428);
    
    public static final String APP_AML = "AML";
    
}
