/**
 * 
 */
package com.path.bo.common.requests.csm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.log.Log;

/**
 * @author raees
 * 
 */
public final class CtsRequestConstant
{
    private static final Log log = Log.getInstance();

    /**
     * Private constructor only to prevent instantiation in the class
     */
    private CtsRequestConstant()
    {
	log.error("This Class Should not be Instantiated");
    }

    public static final BigDecimal LOV_TYPE = BigDecimal.valueOf(515);
    public static final String STATUS_CREATE = "A";
    public static final String STATUS_DELETE = "D";
    public static final String STATUS_APPROVE = "P";
    public static final String STATUS_REVERSE = "V";
    public static final String STATUS_CANCELLED = "N";
    public static final String STATUS_PROCESSED = "O";
    public static final String STATUS_EXPIRED = "E";
    public static final String STATUS_REJECT = "R";
    public static final String STATUS_VERIFIED = "G";// added for assets trade
						     // process
    public static final String STATUS_TO_BE_RESVERSED = "T";

    public static final String REQUEST_ENTITY_TYPE = "REQ";

    // Payment Type
    public static final String PAYMENT_TYPE_CASH = "C";
    public static final String PAYMENT_TYPE_IND_ACCOUNT = "D";

    // added by rany for assests process
    public static final String PURCHASE = "P";
    public static final String SALE = "S";
    public static final String APPROVE_TRX = "P";
    public static final String PRINT_WITHOUT_CONF = "P";
    public static final String PRINT_WITH_CONF = "W";
    public static final Integer INT_ONE = 1;
    public static final BigDecimal MINUS_ONE = new BigDecimal(-1);
    public static final String RENEWAL = "T";
    public static final String IPO = "I";
    // end assets

    public static final BigDecimal PAYMENT_TYPE_LOV_TYPE = new BigDecimal(553);
    
    public static List<String> getRequestStatusFields()
    {
	ArrayList<String> statusFields = new ArrayList<String>();
	statusFields.add("CREATED_BY," + STATUS_CREATE + ",DATE_CREATED");
	statusFields.add("APPROVED_BY," + STATUS_APPROVE + ",DATE_APPROVED");
	statusFields.add("CANCELLED_BY," + STATUS_CANCELLED + ",DATE_CANCELLED");
	statusFields.add("PROCESSED_BY," + STATUS_PROCESSED + ",DATE_PROCESSED");
	statusFields.add("REJECTED_BY," + STATUS_REJECT + ",DATE_REJECTED");
	statusFields.add("EXPIRED_BY," + STATUS_EXPIRED + ",DATE_EXPIRED");
	statusFields.add("DELETED_BY," + STATUS_DELETE + ",DATE_DELETED");
	statusFields.add("TB_REV_BY," + "T" + ",TB_REV_DATE");	
	statusFields.add("TB_REJREV_BY," +  "R_R" + ",TB_REJREV_DATE"); 	
	statusFields.add("REVERSE_BY," + STATUS_REVERSE + ",REVERSE_DATE");        
	statusFields.add("VALIDATED_BY," + "L" + ",DATE_VALIDATED");
	return statusFields;

    }
}
