package com.path.bo.common.signature;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SignatureConstant
{
 
    
    public static final Map<String, String> SIGNATURE_FILE_TYPES =  new HashMap<String, String>();

    
    public static final String PHOTO = "P";
    public static final String DOCUMENT = "D";
    public static final String SIGNATURE = "S";
    
    public static final String IS_CIF = "C";
    
    public static final String INSERT = "I";
    public static final String UPDATE = "U";
    public static final String DELETE = "D";
    public static final String APPROVE = "A";
    public static final String REJECT = "R";
    public static final String SELECT = "S";
    
    public static final String COPY = "C";
    public static final String NO_ACCESS = "N";
    public static final String AMOUNT = "M";
    
    public static final String SIGN001  = "SIGN001";  //VIEW ALL SIGNATURES
    public static final String SIGN002  = "SIGN002";  //MANAGE SIGNATURES
    public static final String SIGN002A = "SIGN002A"; //ADD SIGNATURES
    public static final String SIGN002D = "SIGN002D";	//DELETE SIGNATURE
    public static final String SIGN002R = "SIGN002R";	//EDIT SIGNATURE
    public static final String SIGN002C = "SIGN002C";	//CHANGE AMOUNT
    public static final String SIGN002P = "SIGN002P";	//APPROVE SIGNATURE    
    public static final String SIGN002CP = "SIGN002CP";  //COPY SIGNATURES
    public static final String SIGN002PA = "SIGN002PA";  //PRINT ADVISE
    public static final String SIGNAUD = "SIGNAUD"; // SIGNATURE AUDIT

    public static final String SIGN001L = "SIGN001L";   //LIMIT SCHEMA
    public static final String SIGN002L = "SIGN002L";   //MODIFY SCHEMA
    public static final String SIGN002SP = "SIGN002SP"; //APPROVE SCHEMA
    
    
    
    
    public static final String DOC001 = "DOC001";	//VIEW DOCUMENT
    public static final String DOC002 = "DOC002";  //MANAGE DOCUMENT
    public static final String DOC002A = "DOC002A";  //ADD DOCUMENT    
    public static final String DOC002D = "DOC002D";   //DELETE DOCUMENT
    public static final String DOC002R = "DOC002R";   //RENAME DOCUMENT
    public static final String DOC002P = "DOC002P"; //APPROVE DOCUMENT
    
    public static final String PHO001 = "PHO001";	//VIEW PHOTO
    public static final String PHO002 = "PHO002";  //MANAGE PHOTO
    public static final String PHO002R = "PHO002R"; //RENAME PHOTO
    
    public static final String SIGNATURE_EDIT_ALL 		= "Edit";
    public static final String SIGNATURE_CHANGE_AMOUNT 	= "ChangeAmount";
    public static final BigDecimal KEY_SIGN_INSTRUCTIONS_LOV_TYPE = BigDecimal.valueOf(988);
        
    public static final String VIEW_MODE="V";
    public static final String EDIT_ALL_MODE="E";
    public static final String EDIT_CHANGE_AMOUNT_MODE="EC";
    public static final String ADD_MODE="A";
    public static final BigDecimal SIGN_GRP_LOV_ID = BigDecimal.valueOf(110);
    
    
    public static final BigDecimal TRX_TYPE_900 = BigDecimal.valueOf(900);
    public static final BigDecimal TRX_TYPE_901 = BigDecimal.valueOf(901);
    
    public static final String SIGN_MODIF_ORIGIN= "1";
    
    public static final BigDecimal SIGN_STATUS_CODE = BigDecimal.valueOf(122);
    
    public static final String SECONDARY_ID_COPY = "_copy";
    
    public static final String TRS_PROGRAM="TRS";
    
     
    static{
	SIGNATURE_FILE_TYPES.put("image/jpeg", "S");
	SIGNATURE_FILE_TYPES.put("image/bmp", "P");
	SIGNATURE_FILE_TYPES.put("image/gif", "S");
	SIGNATURE_FILE_TYPES.put("image/jpg", "S");
	 
    }
    
    //NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
    public static final String SIGN_EXPIRY_DATE_NAME = "signatureCO.scanVO.EXP_DATE";
    public static final String SIGN_UNLIMITED_NAME = "signatureCO.unlimitedFlag";
    public static final String COUNT_SCAN = "COUNT_SCAN";
    public static final String COUNT_SIGN_MODIF = "COUNT_SIGN_MODIF";
    
    
    
    // signature fields
    public static final String ID_SIGN_DESC = "signDesc";
    public static final String NAME_SIGN_DESC = "signatureCO.scanVO.DESCRIPTION";
    public static final String ID_SIGN_INST = "signatureInstructions";
    public static final String NAME_SIGN_INST = "signatureCO.scanVO.SIGN_INSTRUCTIONS";

    public static final String ID_OTHER_VALUE = "instructionsOtherValue";
    public static final String NAME_OTHER_VALUE = "signatureCO.scanVO.INST_OTHER_VALUE";
    public static final String ID_LIMIT_AMT = "limitAmt";
    public static final String NAME_AMOUNT = "signatureCO.cifObjectVO.AMOUNT";
    public static final String ID_SIGN_GRP = "signGroup";
    public static final String NAME_EXP_DATE = "signatureCO.scanVO.EXP_DATE";
    public static final String ID_EXP_DATE = "expirySignDate";
    // SigCap
    public static final String CIF_SIGNATURE = "C";
    public static final String SIG_SCREEN = "screen";
    public static final String SIGCAP_SIG_SCREEN = "sigCapSignature";
    public static final String SIG_SIG_SCREEN = "signature";
    public static final String SIG_URL = "url";
    public static final String SIGCAP_ADD_SCREEN_PARAMS = "additionnalScreenParams";
    public static final String SIGCAP_EXTERNAL_SIGNATURE_URL = "EXTERNAL_SIGNATURE_URL";
    public static final String SIGCAP_EXTERNAL_SIGNATURE_MGT_YN = "EXTERNAL_SIGNATURE_MGT_YN";
    public static final String SIGCAP_MODIFY = "M";
    public static final String ACC_NO = "accNo";
    public static final String SIG_AMT = "sigAmt";
    public static final String AMT_SIG_CAP_LBL = "amtSigCapLbl";
    public static final String ACCEPT_SIG_CAP_BTN = "acceptSigCapBtn";
    public static final String REJECT_SIG_CAP_BTN = "rejectSigCapBtn";
    public static final String CANCEL_SIG_CAP_BTN = "cancelSigCapBtn";
    public static final String SIG_AMOUNT = "amount";
    // added by abbas for tp#459218
    public static final String PMS_APP = "PMS";

    public static final String ID_EXP_DATE_LIMIT = "expiryUnlimited";
    public static final String NAME_ANNOTATION = "signatureCO.scanVO.ANNOTATION";
    public static final String ID_ANNOTATION = "signAnnotation";
    public static final String NAME_GENERALE_ANNOTATION = "signatureCO.signatureAnnotationVO.ANNOTATION";
    public static final String ID_GENERALE_ANNOTATION = "generalNote";

    
}
