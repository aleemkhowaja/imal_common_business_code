package com.path.bo.common.memo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.log.Log;

public final class MemoConstants
{
    /**
     * private constructor to prevent the class being instantiated since all
     * methods are static
     */
    private MemoConstants()
    {
	Log.getInstance().error("This Class is utility class cannot be instantiated");
    }
    public static final BigDecimal LOV_TYPE = new BigDecimal(39);
    public static final BigDecimal STATUS_LOV_TYPE = new BigDecimal(29);
    public static final BigDecimal FOR_ACC_CIF_LOV_TYPE = new BigDecimal(381);
    
    public static final String ACCOUNTS = "A";
    public static final String CIF = "C";
    public static final String CSM_APP_TYPE = "R";
    public static final String ACC_TYPE = "ACC";
    public static final String CIF_TYPE = "CIF";
    public static final String SEGMENT = "S";

    
    // STATUSES
    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_APPROVE = "P";
    public static final String STATUS_TO_CANCEL = "N";
    public static final String STATUS_CANCEL = "C";
    public static final String STATUS_SUSPEND = "S";
    public static final String STATUS_TO_SUSPEND = "T";
    public static final String STATUS_TO_REACTIVATE = "R";
    public static final String STATUS_DELETE = "D";
    private static final String STATUS_CREATED = "0_C";
    private static final String STATUS_MODIFIED = "0_M";
    private static final String STATUS_REACTIVATED = "0_R";

    // Messages
    public static final Integer DATE_INT_MANDATORY = 704;
    public static final Integer ACC_NB_MANDATORY = 713;
    public static final Integer TOCIF_LESS_THEN_FROMCIF = 714;
    public static final Integer CIF_MANDATORY = 717;

    public static final String MEMO_TYPE_NR = "NR"; // NR refere to all memo
						    // with request memos
    //CRUD
    public static final String CRUD_MAINTENANCE = "R";
    public static final String CRUD_UPDATE_AFTER_APPROVE ="UP";						
    //STATUSES
    public static final String REFERENCE_CREATE      = "C";
    public static final String REFERENCE_UPDATE      = "U";
    public static final String REFERENCE_UPDATE_AFTER_APPROVE ="UP";	
    // OPT
    public static final String PARENT_OPT 	     = "M001";
    public static final String UPDATE_OPT 	     = "M001UP";
    public static final String CREATE_OPT 	     = "M001MT";
    public static final String APPROVE_OPT 	     = "M001P";//Hala Al Sheikh - TP813252
    public static List<String> getStatusFields()
    {
	ArrayList<String> statusFields = new ArrayList<String>();

	statusFields.add("CREATED_BY," + STATUS_CREATED + ",DATE_CREATED");
	statusFields.add("MODIFIED_BY," + STATUS_MODIFIED + ",DATE_MODIFIED");
	statusFields.add("APPROVED_BY," + STATUS_APPROVE + ",DATE_APPROVED");
	statusFields.add("DELETED_BY," + STATUS_DELETE + ",DATE_DELETED");
	statusFields.add("CANCELLED_BY," + STATUS_CANCEL + ",DATE_CANCELLED");
	statusFields.add("SUSPENDED_BY," + STATUS_SUSPEND + ",DATE_SUSPENDED");
	statusFields.add("TOBE_SUSPENDED_BY," + STATUS_TO_SUSPEND + ",TOBE_SUSPENDED_DATE");
	statusFields.add("REACTIVATED_BY," + STATUS_REACTIVATED + ",DATE_REACTIVATED");
	statusFields.add("TOBE_REACTIVATED_BY," + STATUS_TO_REACTIVATE + ",TOBE_REACTIVATED_DATE");
	statusFields.add("TOBE_CANCELLED_BY," + STATUS_TO_CANCEL + ",TOBE_CANCELLED_DATE");
	return statusFields;

    }

    // iv_crud
    public static final String IV_CRUD_P = "P";
    public static final String IV_CRUD_S = "S";
    public static final String IV_CRUD_N = "N";
    public static final String IV_CRUD_A = "A";
    
    public static final BigDecimal EVENT_TYPE_RECALCITRANT = new BigDecimal(7);
    public static final BigDecimal EVENT_TYPE_INCOMPLETE = new BigDecimal(8);
    
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public static final String MEMO_FOM_OPT = "F00I1MEM";
    public static final String MEMO_TRX_OPT = "D001MEM";
    public static final String MEMO_SAFBOX_OPT = "E003MEM";
    public static final String MEMO_CHEQUEBOOK_OPT = "Q000MEM";
    public static final String MEMO_LINKSMANAGMENET_OPT = "LM01MTMEM";
    public static final String MEMO_BILLREG_OPT = "REGCLTMEM";
    public static final String MEMO_PASSBOOK_OPT = "S000MEM";
    public static final String MEMO_LOSTFOUND_OPT = "N001MEM";
    public static final String MEMO_CARDSMGNT_OPT = "G001MEM";
    public static final String MEMO_GEN_ACC_OPT = "A002MEM";
    public static final String MEMO_FIX_ACC_OPT = "A001MEM";
    public static final String MEMO_CERTIFICATE_OPT = "P0049MEM";
    public static final String MEMO_SMS_SUBSCRIPTION_OPT = "SMS00MEM";
    public static final String MEMO_MERCHANT_OPT = "MER00MEM";
    public static final String MEMO_BLACKLIST_OPT = "BL001MEM";
    public static final String MEMO_SPECIAL_CONDITIONS_OPT = "SPC00MEM";
    public static final String MEMO_QUERIES_SOA_T_OPT = "QUER001TMEM";
    public static final String MEMO_QUERIES_SOA_V_OPT = "QUER001VMEM";
    public static final String MEMO_DUES_MANAGEMENT_OPT = "DUES01MEM";
    public static final String MEMO_ACC_QUERY_OPT = "A003MEM";
    public static final String SHOW_MEMO_ALL_OPT_RETRIEVE_TRUE = "1";
    public static final String MEMO_VISITS_OPT = "V001MEM";
    
    
    public static final String MEMO_CODE = "memoDtlCO.ctsMemoDetVO.MEMO_CODE";
    public static final String ID_MEMO_CODE = "memoCode";
    public static final String ENG_COMENT = "memoDtlCO.ctsMemoDetVO.ENG_COMENT";
    public static final String ARAB_COMENT = "memoDtlCO.ctsMemoDetVO.ARAB_COMENT";
    public static final String CIF_NO = "memoDtlCO.ctsMemoDetVO.CIF_NO";
    public static final String ID_CIF_NO = "cifNo";
    public static final String ACC_BR = "memoDtlCO.ctsMemoDetVO.ACC_BR";
    public static final String ID_ACC_BR = "accBr";
    public static final String ACC_CY = "memoDtlCO.ctsMemoDetVO.ACC_CY";
    public static final String ID_ACC_CY = "accCy";
    public static final String ACC_GL = "memoDtlCO.ctsMemoDetVO.ACC_GL";
    public static final String ID_ACC_GL = "accGl";
    public static final String ACC_CIF = "memoDtlCO.ctsMemoDetVO.ACC_CIF";
    public static final String ID_ACC_CIF = "accCif";
    public static final String ACC_SL = "memoDtlCO.ctsMemoDetVO.ACC_SL";
    public static final String ID_ACC_SL = "accSl";
    public static final String ACC_ADD_REF = "memoDtlCO.ctsMemoDetVO.ACC_ADD_REF";
    public static final String ID_ACC_ADD_REF = "accAddRef";
    public static final String FROM_DATE = " memoDtlCO.ctsMemoDetVO.FROM_DATE";
    public static final String DATE_TO = "memoDtlCO.ctsMemoDetVO.DATE_TO";
    public static final String ID_FROM_DATE = "fromDate";
    public static final String ID_DATE_TO = "toDate";
    
    public static final String MEMO_FROM_CRM = "CRM";//Hala Al Sheikh - TP813252
}
