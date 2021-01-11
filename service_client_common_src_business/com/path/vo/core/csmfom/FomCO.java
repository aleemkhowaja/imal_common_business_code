package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIF1VO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_CONTACTVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CIF_FATCA_DETAILSVO;
import com.path.dbmaps.vo.CIF_ID_DETAILSVO;
import com.path.dbmaps.vo.CIF_IRISVO;
import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.dbmaps.vo.CIF_KYCVO;
import com.path.dbmaps.vo.CIF_KYC_PARAM_LINKVO;
import com.path.dbmaps.vo.CIF_SCORE_RESULTVO;
import com.path.dbmaps.vo.CIF_KYC_FINANCIAL_INFOVO;
import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTS_BLCKLIST_NAME_MATCHVO;
import com.path.dbmaps.vo.CTS_CIF_KYC_DETAILSVO;
import com.path.dbmaps.vo.CTS_CIF_SEGMENT_HISTORYVO;
import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.dbmaps.vo.ID_TYPESVO;
//import com.path.dbmaps.vo.ITR_CIF_DETAILSVO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.WS_RESULT_MAPPINGVO;
//import com.path.dbmaps.vo.WS_RESULT_MAPPINGVO;
import com.path.dbmaps.vo.CIF_SCORE_RESULTVO;
//import com.path.fatca.vo.CifTaxInfoCO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.common.address.AddFieldsFomCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.cifproduct.CifProductsCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.signature.SignatureCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.cardreader.CardReaderCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.dbmaps.vo.CIF_SHOW_PICTUREVO;
import com.path.vo.core.cardsmanagement.CardsManagementCO;


public class FomCO extends RetailBaseVO
{
    private CIFVO cifVO = new CIFVO();
    private COUNTRIESVO countriesVO = new COUNTRIESVO();
    private CIF_CONTACTVO cifContactVO = new CIF_CONTACTVO();
/*    private CifTaxInfoCO  cifTaxInfoCO = new CifTaxInfoCO();*/
    private ECO_SECTORSVO ecoSectorsVO = new ECO_SECTORSVO();
    private RIFPCTVO rifpctVO = new RIFPCTVO();
    private CIFOBJECTVO cifObjectVO = new CIFOBJECTVO(); 
    //private ITR_CIF_DETAILSVO cifItrDetailsVO = new ITR_CIF_DETAILSVO();
    private BigDecimal tellerCode;
    private String ADDRESS1;
    private String ADDRESS2;
    private String ADDRESS3;
    private String enableMcr;
    private String statusDesc;
    private String branchDesc;
    private String divisionDesc;
    private String deptDesc;
    private String roleDesc;
    private String groupDesc;
    private String teamDesc;
    private String isEmptyScreen;
    private String entity;
    private String cifStatus;
    private String hyperlinkId;
    private String isoCountry;
    private BigDecimal countryOfIssuance;
    private String issueCountry;
    private BigDecimal event;
    private BigDecimal selectedCifCode;
    private BigDecimal accessFundTransfer;
    private BigDecimal accessCifSwiftDetails;
    private BigDecimal countryId;
    private BigDecimal branchId;
    private BigDecimal oldCountryId;
    private BigDecimal maxCifNo;
//    private String passportInfoOpened;
    private String additionFieldOpened;
    private String mktPositionByDesc;
    private String reference;
    private String openFatca;
    private String regionBirthDesc;
    private boolean allowAccess;
    private String cityDesc;
    private String showMessage;
    
    //Hasan ghrayeb-BIPL170023 added to check on validate button if ID's grid contains records or not
    private String Idscontainsrecords;
    
    //added by nancy - 16/09/2017-561471-SBI170005 - Limit Cap on Account type
    private String baseCurrencyDesc;
    //

    private Boolean cifSuspiciousFlag;
    private Boolean cifIdNumDupFlag;
    private Boolean cifControlRecordFlag;
    private Boolean reloadDeletedCif;
    // this flag is used to susapend all accounts while populating the CIF
    private int suspendAllAccounts;
    private HashMap userAxsMap = new HashMap<String, Boolean>();

    private SignatureCO signatureCO = new SignatureCO();

    // SMART list
    private ArrayList<SmartCO> smartCOList;

    private String mktDeptByDesc;
    private String mktDivisionByDesc;
    private String mktDeptForDesc;
    private String mktDivisionForDesc;
    private String cifTypeDesc;
    private String idTypeDesc;
    private String idTypes;
    private String joinIdTypeDesc;
    private String idType2Desc;
    private String nationalityDesc;
    private String nationBriefDesc;
    private String countryDesc;
    private String raceDesc;
    private String religionDesc;
    private String salutationDesc;
    private String actionStr;
    private String limitcy;
    private String limitcy1;

    private String countryOfBirthDesc;
    private String positionDesc;
    private String occupationDesc;
    private String priorityDesc;
    private String educationLevelDesc;
    private String addnDivisionDesc;
    private String addnDeptDesc;
    private String signatoryIdTypeDesc;
    private String residenceTypeDesc;
    private String creditRatingDesc;
    private String ecoSectorsDesc;
    private String subEcoSectorDesc;
    private String legalStatusDesc;
    private String inactiveStatusDesc;
    private String relationCodeDesc;
    private String oneObligorDesc;
    private String oneObligorLongDesc;
    private String cifProfileDesc;
    // private String language;
    // private String ivcrud;
    private String preferredLanguage;
    private Date runningDate;
    private Date dateUpdated;
    private Date fromDate;
    private Date toDate;
    private String cifDateUpdated;
    // private String opt;
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private RIFCTTVO rifCttVO = new RIFCTTVO();
    private ID_TYPESVO idTypesVO = new ID_TYPESVO();
    private LEGAL_STATUSVO legalStatusVO = new LEGAL_STATUSVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTSCONTROLVO ctsControl = new CTSCONTROLVO();
    private COMPANIESVO companiesVO = new COMPANIESVO();
    private PTH_CTRLVO pthCtrlVO = new PTH_CTRLVO();
    private CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
    private RIFCTT_GLVO rifcttGlVO = new RIFCTT_GLVO();
    private CTSCHEQUESVO chequesVO = new CTSCHEQUESVO();
    private CTSCARDSVO cardsVO = new CTSCARDSVO();
    private CTSPASSBOOK_TYPEVO passBookVO = new CTSPASSBOOK_TYPEVO();
    private CifProductsCO fomCifProductsCO = new CifProductsCO();
    private CIF_ID_DETAILSVO cifIdDetailsVO = new CIF_ID_DETAILSVO();
    private CIF_TRXTYPE_LIMITSVO cifTrxTypeVO = new CIF_TRXTYPE_LIMITSVO();
    private CifMembersCO cifMembersCO = new CifMembersCO();
    private List<FOMIdsCO> cifIdDetailsVOList = new ArrayList<FOMIdsCO>();
    private List<FOMJointIdsCO> cifJointIdDetailsVOList = new ArrayList<FOMJointIdsCO>();
    private List<FomBusinessNatureCO> fomBusinessNatureCOList = new ArrayList<FomBusinessNatureCO>();
    private List<FOMTransactionTrendsCO> transactionTrendsList= new ArrayList<FOMTransactionTrendsCO>();
    // Alerts params
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private MosBlackListCO mosBlackListCO = new MosBlackListCO();
    private FOMRequiredDocCO requiredDocCO = new FOMRequiredDocCO();
    private CIF_IRISVO cifIrisVO = new CIF_IRISVO();
    private CIF_FATCA_DETAILSVO cifFatcaDetailsVO = new CIF_FATCA_DETAILSVO();
    private String fatcaReasonDesc;
    private String fatcaAuditTrxNbr;
    private String fatcaAuditJsonStr;
    private String isFromAlert;
    private String alertTodoReason;
    private String showAlertModifyButton;
    private String userIsBranchManager;
    private String countryKYCDesc;
    private CIF_KYCVO cifKYCVO = new CIF_KYCVO();
    private String tinMinLengthMessage;
    private String corporateType;//Abdo CIHAN160037 12/01/2018
    private BigDecimal fromCifJoint;//Abdo CIHAN160037 12/01/2018
    
    
    /**
     * 
     * added by jihad
     * 
     */

    public BigDecimal compCodeCif;//EWBI160091 (403157)- Modification of CIF
    private boolean idTypeMandatory;
    private String bank;
    private String rifCttBank;
    private String vtInd;
    private String client;
    private String jointAccounts;
    private String statusDeleted;
    private boolean isCivilId;
    private String saveType;
    private String passportSaveType;
    private int countField;
    private HashMap<String, ID_TYPESVO> idTypessVO = new HashMap<String, ID_TYPESVO>();
    private HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap = new HashMap<BigDecimal, CTSTELLER_AXSVO>();
    private String allowToModifyCif;
    private String civilCodeField;
    private String civilCodeValue;
    private BigDecimal idTypeValue;

    private Boolean accesByTeller = true;
    private boolean applyUniquenessOnIds = true;
    private boolean applyBalckListOnIds;
    private String cifProductOpened;
    private AccountSC account = new AccountSC();
    private String memoOptRef;
    private String fromDependency;
    private String fromValidationOfIdType2="0";
    private String fromFomSignatory;
    private String fromFomOwnerShip;
    private String fromIdsButton;
    
    //NABIL FEGHALI BB140155 KYC new changes
    private String kycResidentBankName;
    private String kycOpeningAccPurposeDesc;
    private String kycBusinessEcoSectorDesc;
    private String kycSourceOfWealth;
    private String kycGreenCardCountryDesc;
    private String kycLongStayCountryDesc;
    private String kycTaxPayerCountryDesc;
    private String kycStandInstrCountryDesc;
    private String kycRemitterBenefNationalityDesc;
    private BigDecimal kycAddressCountryCode;
    private String kycAddressCountryDesc;
    private String kycAddressState;
    private String kycAddressGovernate;
    private String kycAddressPoboxCode;
    private String kycAddressPoboxDesc;
    private String kycAddressEmail;
    private String kycAttorneyCountryDesc;
    private BigDecimal kycAddressPostalCode;
    private String kycAddressPostalCodeDesc;
    private String kycLoadPassPortInfo;
    private String IDTypeAlreadyinUse; //TP260314
    
  //John Massaaad PATH130241 
    private String occupationCountryDesc;
    private String regionDesc;
    private String occupationPostalCodeDesc;
    private String introducerCIFDesc;
  //John Massaaad PATH130241 
    
    public String cardReaderEnabled;
    
    // TP 324728 -- Hala Al Sheikh Enhance the checking on the US
    private CIF_EXTENDEDVO cifExtendedVO = new CIF_EXTENDEDVO();
    private String countryOfIssuanceDesc;
    private String jointCountryOfIssuanceDesc;
    private String signCountryOfIssuanceDesc;
    private String cif1VOCountryOfIssuanceDesc;
    private String cif1VOCountryOfIssuance2Desc;
    private String cif1VOCountryOfIssuance3Desc;
    private BigDecimal countryOfIssuanceVal;
    private String fromGrid;
   //End Hala
    
    private String ymcOtherCntryDesc;
    private String ymcTypeOfAccountDesc;
    private CIF_KYC_PARAM_LINKVO cifKycParamLinkVO = new CIF_KYC_PARAM_LINKVO();
    
    private String exemptFullChargesWaiver;
    private String kycStreet;
    private String kycAvenue;
    private String kycBlock;
    private String kycHouseBuildling;
    private String kycTel;
    private String kycFax;
    private BigDecimal kycRegion;
    private String kycRegionDesc; 
    private String kycPoBox;
    private String applyCorporateKycId;
    
    //Abdo CIHAN160037 KYC and FATCA details 04/01/2018
    private String additionnalFatcaProps;
    private String boardMemberGrid;
    private String actualBenefGrid ;
    private String authorizedDetGrid ;
    private String attorneysDetGrid ;
    private String shareHolderDetGrid ;
    private ArrayList<CIF_KYC_FINANCIAL_INFOCO> boardMemberList;
    private ArrayList<CIF_KYC_FINANCIAL_INFOCO> actualBenefList;
    private ArrayList<CIF_KYC_FINANCIAL_INFOCO> authorizedDetList;
    private ArrayList<CIF_KYC_FINANCIAL_INFOCO> attorneysDetList;
    private ArrayList<CIF_KYC_FINANCIAL_INFOCO> shareHolderDetList;
    
    private BigDecimal returnCode;
    private BigDecimal limit;
    private BigDecimal value;
    private BigDecimal confirmationCode;
    private String source;
    private BigDecimal parentObligor;
    private String productsIssuedDesc;
    
    private boolean applyCheckingOnJoinIdno;
    private String bothIdType;
    
    // BIC
    private PMSCIFSWIFTVO cifSwiftVO = new PMSCIFSWIFTVO();
    private String bic_11;
    private String bic_Code_limit;
    private AddressCommonCO addressCommonCO = new AddressCommonCO();
    private FomCifAddressCO cifAddressCO = new FomCifAddressCO();
    private FomCifSwiftCO cifSwiftCO = new FomCifSwiftCO();

    private Boolean cifFieldModeFlag = true;
    // ADDED BY jihad -->
    private CIF1VO cif1VO = new CIF1VO();
    private Date runningDateWithTime;

    // For check Box on screen
    private Boolean chatFlag;
    private Boolean maintainSalFlag;
    private Boolean mailDocFlag;
    
  //maureena
    private Boolean registered = false;
    private String registrationNumber;
    private String walletAccount;
    private String nickname;
    private String mobileNumber;
    private String oldMobileNumber;
    private String callWebService;
    
    private Boolean cifReservedConfirmFlag = false;
    /* added by jihad for edit events */// //
    private Boolean isTabsBicCodeVisible = false;
    private Boolean isTabsFundTransferVisible = false;
    private String scallingMod;
//    private String showMemoOnLoad; // IIAB120195 - Sarah Elhusseini

    // end
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> trxTypeLimitElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> cifProductElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private UsrCO usrCO = new UsrCO();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buttonMap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    ResultCO warningMessages = new ResultCO();
    // this is used in order to cath the buisnes error location(in mainm in
    // popup,in tab......)
    String sectionName = "";
    private String warngMessages;
    private Boolean cifGlobalConfirmFlag = false;
    private Boolean populateConfirmation;
    private BigDecimal previousValue;
    //Bug-- 336077 [John Massaad]
    private BigDecimal idTypePreviousVal;
  //Bug-- 336077 [John Massaad]
    private String sVipAlert;
    private String cifAllowedModification;
    private String cifBlacklisted;
    private ArrayList<BaseException> warningMessagesList = new ArrayList<BaseException>();
    private String compareTwoIdsno;

    private String addressPageRef;

    private Boolean nameAddressTabReadOnlyMode = false;
    private Boolean nameAddressTabNameDetailsReadOnlyMode = false;
    private Boolean nameAddressTabPassportDetailsReadOnlyMode = false;
    private Boolean additionalDetailsTabReadOnlyMode = false;
    private Boolean referenceTabReadOnlyMode = false;
    private Boolean referenceTab = false;
    private Boolean marketDetailsTabReadOnlyMode = false;

    // Print Advice
    private List<ReportResponseCO> amfReportResponseCOList = new ArrayList<ReportResponseCO>();
    private List<ReportResponseCO> cardReportResponseCOList = new ArrayList<ReportResponseCO>();
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private String printConfirmationMessage;
    //NABIL FEGHALI - BB120129 - YMC FORMS
    private List<ReportResponseCO> additionalAdvicesReportList = new ArrayList<ReportResponseCO>();
    
    // this is used to add the warning msg lists from database
    private ArrayList<Integer> warningListCode = new ArrayList<Integer>();
    private HashMap<Integer, String[]> ctsMsgParam = new HashMap<Integer, String[]>();
    //
    // this is used to add the warning msg lists
    private ArrayList<String> warningList = new ArrayList<String>();
    //
    private boolean validateIDsFromMainScreen;
    private String fomCIFIrisSave;

    
    private String fomKYCIsloaded;
    private String initBicCode;    
    private String oldKYCVal;
    private BigDecimal checkMandatory;
    private BigDecimal idType;
    private BigDecimal idType2;
    private String countryOfIssuanceIDName;
    private String countryOfIssuanceDescIDName;
    private BigDecimal consolidatedView;
    private String currIsoCode;
    private String currBriefDescEng;
    private int nbrCif;
    
    //Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    private String reasonDesc;
    private String reasonType;
    //END Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    private boolean fromMoreAddressButton;
    ////Abdo US 382751 - BB KYC with Dynamic Screen 
    private String additionnalKycProps;
    private BigDecimal screenId;
    private BigDecimal sironGrade;
    private String sironReasonDesc;
    private String sironCompliance;
    private String sironVisibility;
    //418494
    private CIFVO employerCifVO;
    private BigDecimal occupOtherIncome;
    //added by rany for bugid:679050
    private String isFromPrintConf;
    //418495
    private String billFlag;
    private List<FomCO> fomCOLst = new ArrayList<FomCO>();
    private Date finalDate;
    
    private String fomNameDetailsLoaded;
    private String fomPassportInfoLoaded;
    private String fomReferencesDetailsLoaded;
    private String fomMarketDetailsLoaded;
    
    private String fomCifBicCodeDetailsLoaded;
    private String fomFundTransferDetailsLoaded;    
    private String recvIncomeCntryDesc;
    private String compCountryDesc;
    private String incomeThroughDesc;
    private String depositThroughDesc;
    private String ymcStatusDesc;
    private ArrayList<CTS_BLCKLIST_NAME_MATCHVO> ctsBlckListNameMatchVO = new ArrayList<CTS_BLCKLIST_NAME_MATCHVO>();
    private String NameMatchedOR;
    BigDecimal criteriaPerc;
    int countBlckListLog;
    private boolean complianceDecision = false;
    private String todoAlert;
    private int countCif;
    private BigDecimal cifNoforJoint;
    private CIF_JOINT_DETVO cifJointAccVO = new CIF_JOINT_DETVO();
    private BigDecimal jointCifNo;
    private int countCifsJoint;
    private boolean complianceUserApprove;
    
    
    private String vtIndicator;
    private String crsSignYN;
    private List<ReportResponseCO> resultList = new ArrayList<ReportResponseCO>();
    private String fatcaCompliant;
    private CTS_CIF_KYC_DETAILSVO ctsCifKycDetailsVO;
    private int mosBlackListCode;

    // Habib Baalbaki accocunt restriction 372747 bug 718260
    private String cifRestricted;
    private String restrictionMessage;
    private String kycDhfLoaded;
    private CardReaderCO cardReaderCO = new CardReaderCO();
    private String fatcaControlCntry;
    
    private String fromButton;
    
    private String nickName;  //Raed Saad - [BB160150]
    private String screenName;    
    private String allowCifCreationMaskYN;
  
    private String flag;
    private String pageRef;
    private BigDecimal tryMatch;
    //Hala Al Sheikh - AMANA130215
    private String fnIdentifier;
    private String checkOnjoin;
    private String checkIdDigitsParam;
	    
    
    
    //For Omni webService
    private String statusCode;
    private String cifTypeBank;
    private String branchDescriptionArabic;
    private String idTypeDescriptionArabic;
    private String idTypeAdditionalReference;
    private String nationalityLongDescription;
    private String countryDescriptionArabic;
    private String countryBriefDescription;   
    
    //Hussein Elhajj-AUBBH150040-SWIFT 2015 CHANGES
    private String idTypeSwiftCode;
    
    private String keepStatus;

    private AdditionalFieldsByTypeCO additionalFieldsByTypeCO = new AdditionalFieldsByTypeCO();
    private String ebankingChannel;
    
    //DASI170068
    private CTS_ECONOMIC_AGENTVO economicAgentVO = new CTS_ECONOMIC_AGENTVO();
    private String economicAgentDesc;
    private CTS_PROFESSION_CATEGORYVO professionCategory = new CTS_PROFESSION_CATEGORYVO();
    private String professionCategoryDesc;    
    private CTS_PROFESSION_SEGMENTVO professionSegment = new CTS_PROFESSION_SEGMENTVO();
    private String professionSegmentDesc;  
    private CTS_PROFESSIONVO profession = new CTS_PROFESSIONVO();
    private String professionDesc;      
    //
    
    // FIBSI170006 Integration with Seville Registration System
    public BigDecimal sevilleRegistration;/// TO CHECK IF THE VALIDATION REQUEST_ID from WS_RESULT_MAPPING
    private byte[] showPicture;
  //  private  WS_RESULT_MAPPINGVO wsResultMappingVO = new WS_RESULT_MAPPINGVO(); 
    //
    private boolean duplicateCifName;//IDB170046
    private String addAccByProviderByBill;
    private BigDecimal productType;
    private Boolean fromPackageProduct = false;

    //maria BMO180074
    private String additionnalPepProps;
    private String errorMsg;
    private String errorType;
    private String userId;
    private boolean sendRestrictAlert;
    private boolean restrictConfirmationFlag;
    
    //maria BMO180067
    private String vatZoneDesc;
	
	//maria BMO180181
    private String proofOccupationDesc;
    private String sourceFundsDesc;
    private String employmentStatusDesc;
    private String addressField;
    private Boolean sourceOfFundsDescReadOnlyMode; //Rania - BMO180181
    private String sourceFundsDummyDesc; //Rania - BMO180181
    
    private String exemptReasonType;
    private String exemptReasonDesc;
    
    //Added by Maria Chamieh for SBI170183
    private String fromSignature;
    
    private String reasonCodeDesc; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>(); //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    
    
    private String isFromPrintAccConf;
   
    

    private String fromAddNationalities;
    private String autoApproveFlag;//used from webservices
    
    private CTS_CIF_SEGMENT_HISTORYVO ctsCifSegmentHistoryVO = new CTS_CIF_SEGMENT_HISTORYVO(); //Rania - Customers Segmentation 
    private BigDecimal groupCode; //Rania - Customers Segmentation
    private String groupCodeDesc; //Rania - Customers Segmentation
    private Date segmentCreatedDate; //Rania - Customers Segmentation
    private String fomIntroducerDetailsLoaded;
    private AddFieldsFomCO additionalFieldCO;
    private String fomCifBicCodeLoaded;
    private CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO = new CIF_KYC_FINANCIAL_INFOCO();
    
    
    private String sironResetKycScore;   //#794231 Reset SIRON score and encrypt SIRON Password in iMAL DB [mfalha]
    private boolean sironFailed;
    
    private String noMessageToDisplay; /*DBU190684*/
    
    private Boolean additionalFieldsTabReadOnlyMode = false;
    private Boolean cifBicCodeTabReadOnlyMode = false;
    private Boolean fundTransferTabReadOnlyMode = false; 
    
    private boolean checkUserCifTypeAccounts;
    
    //Rania - ABSAI180073
    private String scoreAmended;
    private CIF_SCORE_RESULTVO cifScoreResultVO = new CIF_SCORE_RESULTVO();
    private String scoreRiskDescription; 
    private String errorDesc;
    private BigDecimal scoreCode;
    private String runType;
    private String segmentCodeDescription;
    private BigDecimal scoreRiskValue;
    private BigDecimal errorCode;
    //
    //Hala Al Sheikh - ABSAI190239
    private String statusReason; 
    private String modifyMessage;
    
    private String   cif1VOCountryOfIssuanceIso;
    private String   cif1VOCountryOfIssuance2Iso;
    private String   cif1VOCountryOfIssuance3Iso;
    
    private String agentDescription;
    
    // added by nour
    private String incomeBusinessCntryDesc;
    
    //Hala Al Sheikh - BIPL180103
    private String blackListInCifName;
    private String blackListAction;
    private BigDecimal blkListRegion;    
    private String blkListWarnMessage;
    
  //Rania - Customers Segmentation
    private String allowModifySegment;
    private List<FomCO> fomCOGridList= new ArrayList<FomCO>();
    private String segmentManuallyChanged;
    //419497
    private List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList = new ArrayList<AdditionalFieldsByTypeCO>();
    
    //Rania - SBI190008 
    List<FOMIdsCO> cifProxyBenefIDDetailsVOList;
    //
    private  WS_RESULT_MAPPINGVO wsResultMappingVO = new WS_RESULT_MAPPINGVO();
    
    
    private CardsManagementCO cardsManagementCO = new CardsManagementCO();//BB200555

    
    
    public String getFatcaControlCntry()
    {
        return fatcaControlCntry;
    }


    public void setFatcaControlCntry(String fatcaControlCntry)
    {
        this.fatcaControlCntry = fatcaControlCntry;
    }


    public List<FOMIdsCO> getCifIdDetailsVOList()
    {
	return cifIdDetailsVOList;
    }

    public void setCifIdDetailsVOList(List<FOMIdsCO> cifIdDetailsVOList)
    {
	this.cifIdDetailsVOList = cifIdDetailsVOList;
    }

    public int getSupendAllAccounts()
    {
	return suspendAllAccounts;
    }

    public void setSupendAllAccounts(int supendAllAccounts)
    {
	this.suspendAllAccounts = supendAllAccounts;
    }
    public int getSuspendAllAccounts()
    {
	return suspendAllAccounts;
    }

    public void setSuspendAllAccounts(int suspendAllAccounts)
    {
	this.suspendAllAccounts = suspendAllAccounts;
    }

    public boolean isApplyCheckingOnJoinIdno()
    {
	return applyCheckingOnJoinIdno;
    }

    public void setApplyCheckingOnJoinIdno(boolean applyCheckingOnJoinIdno)
    {
	this.applyCheckingOnJoinIdno = applyCheckingOnJoinIdno;
    }

    public String getBothIdType()
    {
	return bothIdType;
    }

    public void setBothIdType(String bothIdType)
    {
	this.bothIdType = bothIdType;
    }

    public boolean isApplyUniquenessOnIds()
    {
	return applyUniquenessOnIds;
    }

    public void setApplyUniquenessOnIds(boolean applyUniquenessOnIds)
    {
	this.applyUniquenessOnIds = applyUniquenessOnIds;
    }

    public boolean isApplyBalckListOnIds()
    {
	return applyBalckListOnIds;
    }

    public void setApplyBalckListOnIds(boolean applyBalckListOnIds)
    {
	this.applyBalckListOnIds = applyBalckListOnIds;
    }

    public String getRegionDesc()
    {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc)
    {
        this.regionDesc = regionDesc;
    }

    public Boolean getNameAddressTabReadOnlyMode()
    {
	return nameAddressTabReadOnlyMode;
    }

    public void setNameAddressTabReadOnlyMode(Boolean nameAddressTabReadOnlyMode)
    {
	this.nameAddressTabReadOnlyMode = nameAddressTabReadOnlyMode;
    }

    public Boolean getNameAddressTabNameDetailsReadOnlyMode()
    {
	return nameAddressTabNameDetailsReadOnlyMode;
    }

    public void setNameAddressTabNameDetailsReadOnlyMode(Boolean nameAddressTabNameDetailsReadOnlyMode)
    {
	this.nameAddressTabNameDetailsReadOnlyMode = nameAddressTabNameDetailsReadOnlyMode;
    }

    public Boolean getNameAddressTabPassportDetailsReadOnlyMode()
    {
	return nameAddressTabPassportDetailsReadOnlyMode;
    }

    public void setNameAddressTabPassportDetailsReadOnlyMode(Boolean nameAddressTabPassportDetailsReadOnlyMode)
    {
	this.nameAddressTabPassportDetailsReadOnlyMode = nameAddressTabPassportDetailsReadOnlyMode;
    }

    public Boolean getAdditionalDetailsTabReadOnlyMode()
    {
	return additionalDetailsTabReadOnlyMode;
    }

    public void setAdditionalDetailsTabReadOnlyMode(Boolean additionalDetailsTabReadOnlyMode)
    {
	this.additionalDetailsTabReadOnlyMode = additionalDetailsTabReadOnlyMode;
    }

    public Boolean getReferenceTabReadOnlyMode()
    {
	return referenceTabReadOnlyMode;
    }

    public void setReferenceTabReadOnlyMode(Boolean referenceTabReadOnlyMode)
    {
	this.referenceTabReadOnlyMode = referenceTabReadOnlyMode;
    }

    public Boolean getMarketDetailsTabReadOnlyMode()
    {
	return marketDetailsTabReadOnlyMode;
    }

    public void setMarketDetailsTabReadOnlyMode(Boolean marketDetailsTabReadOnlyMode)
    {
	this.marketDetailsTabReadOnlyMode = marketDetailsTabReadOnlyMode;
    }

    public String getCompareTwoIdsno()
    {
	return compareTwoIdsno;
    }

    public void setCompareTwoIdsno(String compareTwoIdsno)
    {
	this.compareTwoIdsno = compareTwoIdsno;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getCifProductElement()
    {
	return cifProductElement;
    }

    public void setCifProductElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> cifProductElement)
    {
	this.cifProductElement = cifProductElement;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getTrxTypeLimitElement()
    {
	return trxTypeLimitElement;
    }

    public void setTrxTypeLimitElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> trxTypeLimitElement)
    {
	this.trxTypeLimitElement = trxTypeLimitElement;
    }

    public ArrayList<BaseException> getWarningMessagesList()
    {
	return warningMessagesList;
    }

    public void setWarningMessagesList(ArrayList<BaseException> warningMessagesList)
    {
	this.warningMessagesList = warningMessagesList;
    }

    public String getCifAllowedModification()
    {
	return cifAllowedModification;
    }

    public void setCifAllowedModification(String cifAllowedModification)
    {
	this.cifAllowedModification = cifAllowedModification;
    }

    public String getCifBlacklisted()
    {
	return cifBlacklisted;
    }

    public void setCifBlacklisted(String cifBlacklisted)
    {
	this.cifBlacklisted = cifBlacklisted;
    }

    public String getSVipAlert()
    {
	return sVipAlert;
    }

    public void setSVipAlert(String sVipAlert)
    {
	this.sVipAlert = sVipAlert;
    }

    public BigDecimal getPreviousValue()
    {
	return previousValue;
    }

    public void setPreviousValue(BigDecimal previousValue)
    {
	this.previousValue = previousValue;
    }

    public Boolean getCifGlobalConfirmFlag()
    {
	return cifGlobalConfirmFlag;
    }

    public void setCifGlobalConfirmFlag(Boolean cifGlobalConfirmFlag)
    {
	this.cifGlobalConfirmFlag = cifGlobalConfirmFlag;
    }

    public String getBic_Code_limit()
    {
	return bic_Code_limit;
    }

    public void setBic_Code_limit(String bicCodeLimit)
    {
	bic_Code_limit = bicCodeLimit;
    }

    public String getSectionName()
    {
	return sectionName;
    }

    public void setSectionName(String sectionName)
    {
	this.sectionName = sectionName;
    }

    public ResultCO getWarningMessages()
    {
	return warningMessages;
    }

    public void setWarningMessages(ResultCO warningMessages)
    {
	this.warningMessages = warningMessages;
    }

    public FomCifAddressCO getCifAddressCO()
    {
	return cifAddressCO;
    }

    public void setCifAddressCO(FomCifAddressCO cifAddressCO)
    {
	this.cifAddressCO = cifAddressCO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public String getBranchDesc()
    {
	return branchDesc;
    }

    public void setBranchDesc(String branchDesc)
    {
	this.branchDesc = branchDesc;
    }

    public String getDivisionDesc()
    {
	return divisionDesc;
    }

    public void setDivisionDesc(String divisionDesc)
    {
	this.divisionDesc = divisionDesc;
    }

    public String getDeptDesc()
    {
	return deptDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
	this.deptDesc = deptDesc;
    }

    public String getRoleDesc()
    {
	return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
	this.roleDesc = roleDesc;
    }

    public String getGroupDesc()
    {
	return groupDesc;
    }

    public void setGroupDesc(String groupDesc)
    {
	this.groupDesc = groupDesc;
    }

    public String getTeamDesc()
    {
	return teamDesc;
    }

    public void setTeamDesc(String teamDesc)
    {
	this.teamDesc = teamDesc;
    }

    public String getMktPositionByDesc()
    {
	return mktPositionByDesc;
    }

    public void setMktPositionByDesc(String mktPositionByDesc)
    {
	this.mktPositionByDesc = mktPositionByDesc;
    }

    public String getMktDeptByDesc()
    {
	return mktDeptByDesc;
    }

    public void setMktDeptByDesc(String mktDeptByDesc)
    {
	this.mktDeptByDesc = mktDeptByDesc;
    }

    public String getMktDivisionByDesc()
    {
	return mktDivisionByDesc;
    }

    public void setMktDivisionByDesc(String mktDivisionByDesc)
    {
	this.mktDivisionByDesc = mktDivisionByDesc;
    }

    public String getMktDeptForDesc()
    {
	return mktDeptForDesc;
    }

    public void setMktDeptForDesc(String mktDeptForDesc)
    {
	this.mktDeptForDesc = mktDeptForDesc;
    }

    public String getMktDivisionForDesc()
    {
	return mktDivisionForDesc;
    }

    public void setMktDivisionForDesc(String mktDivisionForDesc)
    {
	this.mktDivisionForDesc = mktDivisionForDesc;
    }

    public String getCifTypeDesc()
    {
	return cifTypeDesc;
    }

    public void setCifTypeDesc(String cifTypeDesc)
    {
	this.cifTypeDesc = cifTypeDesc;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public String getNationalityDesc()
    {
	return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc)
    {
	this.nationalityDesc = nationalityDesc;
    }

    public String getCountryDesc()
    {
	return countryDesc;
    }

    public void setCountryDesc(String countryDesc)
    {
	this.countryDesc = countryDesc;
    }

    public String getRaceDesc()
    {
	return raceDesc;
    }

    public void setRaceDesc(String raceDesc)
    {
	this.raceDesc = raceDesc;
    }

    public String getReligionDesc()
    {
	return religionDesc;
    }

    public void setReligionDesc(String religionDesc)
    {
	this.religionDesc = religionDesc;
    }

    public String getSalutationDesc()
    {
	return salutationDesc;
    }

    public void setSalutationDesc(String salutationDesc)
    {
	this.salutationDesc = salutationDesc;
    }

    public String getIdType2Desc()
    {
	return idType2Desc;
    }

    public void setIdType2Desc(String idType2Desc)
    {
	this.idType2Desc = idType2Desc;
    }

    public String getJoinIdTypeDesc()
    {
	return joinIdTypeDesc;
    }

    public void setJoinIdTypeDesc(String joinIdTypeDesc)
    {
	this.joinIdTypeDesc = joinIdTypeDesc;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public CIFCONTROLVO getCifControlVO()
    {
	return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
	this.cifControlVO = cifControlVO;
    }

    public ID_TYPESVO getIdTypesVO()
    {
	return idTypesVO;
    }

    public RIFCTTVO getRifCttVO()
    {
	return rifCttVO;
    }

    public void setRifCttVO(RIFCTTVO rifCttVO)
    {
	this.rifCttVO = rifCttVO;
    }

    public HashMap<BigDecimal, CTSTELLER_AXSVO> getCifUserAccessMap()
    {
	return cifUserAccessMap;
    }

    public void setCifUserAccessMap(HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap)
    {
	this.cifUserAccessMap = cifUserAccessMap;
    }

    public void setIdTypesVO(ID_TYPESVO idTypesVO)
    {
	this.idTypesVO = idTypesVO;
    }

    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public CTSCONTROLVO getCtsControl()
    {
	return ctsControl;
    }

    public void setCtsControl(CTSCONTROLVO ctsControl)
    {
	this.ctsControl = ctsControl;
    }

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public PTH_CTRLVO getPthCtrlVO()
    {
	return pthCtrlVO;
    }

    public void setPthCtrlVO(PTH_CTRLVO pthCtrlVO)
    {
	this.pthCtrlVO = pthCtrlVO;
    }

    public String getBank()
    {
	return bank;
    }

    public void setBank(String bank)
    {
	this.bank = bank;
    }

    public String getVtInd()
    {
	return vtInd;
    }

    public void setVtInd(String vtInd)
    {
	this.vtInd = vtInd;
    }

    public String getClient()
    {
	return client;
    }

    public void setClient(String client)
    {
	this.client = client;
    }

    public String getJointAccounts()
    {
	return jointAccounts;
    }

    public void setJointAccounts(String jointAccounts)
    {
	this.jointAccounts = jointAccounts;
    }

    public boolean isIdTypeMandatory()
    {
	return idTypeMandatory;
    }

    public void setIdTypeMandatory(boolean idTypeMandatory)
    {
	this.idTypeMandatory = idTypeMandatory;
    }

    public boolean isCivilId()
    {
	return isCivilId;
    }

    public void setCivilId(boolean isCivilId)
    {
	this.isCivilId = isCivilId;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public HashMap<String, ID_TYPESVO> getIdTypessVO()
    {
	return idTypessVO;
    }

    public void setIdTypessVO(HashMap<String, ID_TYPESVO> idTypessVO)
    {
	this.idTypessVO = idTypessVO;
    }

    public int getCountField()
    {
	return countField;
    }

    public void setCountField(int countField)
    {
	this.countField = countField;
    }

    public String getCivilCodeField()
    {
	return civilCodeField;
    }

    public void setCivilCodeField(String civilCodeField)
    {
	this.civilCodeField = civilCodeField;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getCountryOfBirthDesc()
    {
	return countryOfBirthDesc;
    }

    public void setCountryOfBirthDesc(String countryOfBirthDesc)
    {
	this.countryOfBirthDesc = countryOfBirthDesc;
    }

    public String getPositionDesc()
    {
	return positionDesc;
    }

    public void setPositionDesc(String positionDesc)
    {
	this.positionDesc = positionDesc;
    }

    public String getOccupationDesc()
    {
	return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc)
    {
	this.occupationDesc = occupationDesc;
    }

    public String getPriorityDesc()
    {
	return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc)
    {
	this.priorityDesc = priorityDesc;
    }

    public String getEducationLevelDesc()
    {
	return educationLevelDesc;
    }

    public void setEducationLevelDesc(String educationLevelDesc)
    {
	this.educationLevelDesc = educationLevelDesc;
    }

    public String getAddnDivisionDesc()
    {
	return addnDivisionDesc;
    }

    public void setAddnDivisionDesc(String addnDivisionDesc)
    {
	this.addnDivisionDesc = addnDivisionDesc;
    }

    public String getAddnDeptDesc()
    {
	return addnDeptDesc;
    }

    public void setAddnDeptDesc(String addnDeptDesc)
    {
	this.addnDeptDesc = addnDeptDesc;
    }

    public String getSignatoryIdTypeDesc()
    {
	return signatoryIdTypeDesc;
    }

    public void setSignatoryIdTypeDesc(String signatoryIdTypeDesc)
    {
	this.signatoryIdTypeDesc = signatoryIdTypeDesc;
    }

    public String getResidenceTypeDesc()
    {
	return residenceTypeDesc;
    }

    public void setResidenceTypeDesc(String residenceTypeDesc)
    {
	this.residenceTypeDesc = residenceTypeDesc;
    }

    public String getCreditRatingDesc()
    {
	return creditRatingDesc;
    }

    public void setCreditRatingDesc(String creditRatingDesc)
    {
	this.creditRatingDesc = creditRatingDesc;
    }

    public String getEcoSectorsDesc()
    {
	return ecoSectorsDesc;
    }

    public void setEcoSectorsDesc(String ecoSectorsDesc)
    {
	this.ecoSectorsDesc = ecoSectorsDesc;
    }

    public String getSubEcoSectorDesc()
    {
	return subEcoSectorDesc;
    }

    public void setSubEcoSectorDesc(String subEcoSectorDesc)
    {
	this.subEcoSectorDesc = subEcoSectorDesc;
    }

    public String getLegalStatusDesc()
    {
	return legalStatusDesc;
    }

    public void setLegalStatusDesc(String legalStatusDesc)
    {
	this.legalStatusDesc = legalStatusDesc;
    }

    public String getRelationCodeDesc()
    {
	return relationCodeDesc;
    }

    public void setRelationCodeDesc(String relationCodeDesc)
    {
	this.relationCodeDesc = relationCodeDesc;
    }

    public String getOneObligorDesc()
    {
	return oneObligorDesc;
    }

    public void setOneObligorDesc(String oneObligorDesc)
    {
	this.oneObligorDesc = oneObligorDesc;
    }

    public String getCifProfileDesc()
    {
	return cifProfileDesc;
    }

    public void setCifProfileDesc(String cifProfileDesc)
    {
	this.cifProfileDesc = cifProfileDesc;
    }

    public PMSCIFSWIFTVO getCifSwiftVO()
    {
	return cifSwiftVO;
    }

    public void setCifSwiftVO(PMSCIFSWIFTVO cifSwiftVO)
    {
	this.cifSwiftVO = cifSwiftVO;
    }

    public String getBic_11()
    {
	return bic_11;
    }

    public void setBic_11(String bic_11)
    {
	this.bic_11 = bic_11;
    }

    public AddressCommonCO getAddressCommonCO()
    {
	return addressCommonCO;
    }

    public void setAddressCommonCO(AddressCommonCO addressCommonCO)
    {
	this.addressCommonCO = addressCommonCO;
    }

    public Boolean getCifFieldModeFlag()
    {
	return cifFieldModeFlag;
    }

    public void setCifFieldModeFlag(Boolean cifFieldModeFlag)
    {
	this.cifFieldModeFlag = cifFieldModeFlag;
    }

    public FomCifSwiftCO getCifSwiftCO()
    {
	return cifSwiftCO;
    }

    public void setCifSwiftCO(FomCifSwiftCO cifSwiftCO)
    {
	this.cifSwiftCO = cifSwiftCO;
    }

    public String getCivilCodeValue()
    {
	return civilCodeValue;
    }

    public void setCivilCodeValue(String civilCodeValue)
    {
	this.civilCodeValue = civilCodeValue;
    }

    public BigDecimal getIdTypeValue()
    {
	return idTypeValue;
    }

    public void setIdTypeValue(BigDecimal idTypeValue)
    {
	this.idTypeValue = idTypeValue;
    }

    public CIF1VO getCif1VO()
    {
	return cif1VO;
    }

    public void setCif1VO(CIF1VO cif1vo)
    {
	cif1VO = cif1vo;
    }

    public Boolean getChatFlag()
    {
	return chatFlag;
    }

    public void setChatFlag(Boolean chatFlag)
    {
	this.chatFlag = chatFlag;
    }

    public Boolean getMaintainSalFlag()
    {
	return maintainSalFlag;
    }

    public void setMaintainSalFlag(Boolean maintainSalFlag)
    {
	this.maintainSalFlag = maintainSalFlag;
    }

    public Boolean getMailDocFlag()
    {
	return mailDocFlag;
    }

    public void setMailDocFlag(Boolean mailDocFlag)
    {
	this.mailDocFlag = mailDocFlag;
    }

    public Date getRunningDateWithTime()
    {
	return runningDateWithTime;
    }

    public void setRunningDateWithTime(Date runningDateWithTime)
    {
	this.runningDateWithTime = runningDateWithTime;
    }

    public String getPassportSaveType()
    {
	return passportSaveType;
    }

    public void setPassportSaveType(String passportSaveType)
    {
	this.passportSaveType = passportSaveType;
    }

    public Boolean getCifReservedConfirmFlag()
    {
	return cifReservedConfirmFlag;
    }

    public void setCifReservedConfirmFlag(Boolean cifReservedConfirmFlag)
    {
	this.cifReservedConfirmFlag = cifReservedConfirmFlag;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
	return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
	this.buisnessElement = buisnessElement;
    }

    public UsrCO getUsrCO()
    {
	return usrCO;
    }

    public void setUsrCO(UsrCO usrCO)
    {
	this.usrCO = usrCO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getButtonMap()
    {
	return buttonMap;
    }

    public void setButtonMap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buttonMap)
    {
	this.buttonMap = buttonMap;
    }

    public String getAllowToModifyCif()
    {
	return allowToModifyCif;
    }

    public void setAllowToModifyCif(String allowToModifyCif)
    {
	this.allowToModifyCif = allowToModifyCif;
    }

    public Boolean getIsTabsBicCodeVisible()
    {
	return isTabsBicCodeVisible;
    }

    public void setIsTabsBicCodeVisible(Boolean isTabsBicCodeVisible)
    {
	this.isTabsBicCodeVisible = isTabsBicCodeVisible;
    }

    public Boolean getIsTabsFundTransferVisible()
    {
	return isTabsFundTransferVisible;
    }

    public void setIsTabsFundTransferVisible(Boolean isTabsFundTransferVisible)
    {
	this.isTabsFundTransferVisible = isTabsFundTransferVisible;
    }

    public String getScallingMod()
    {
	return scallingMod;
    }

    public void setScallingMod(String scallingMod)
    {
	this.scallingMod = scallingMod;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
	return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
	this.ctsTrxTypeVO = ctsTrxTypeVO;
    }

    public CTSCHEQUESVO getChequesVO()
    {
	return chequesVO;
    }

    public void setChequesVO(CTSCHEQUESVO chequesVO)
    {
	this.chequesVO = chequesVO;
    }

    public CTSCARDSVO getCardsVO()
    {
	return cardsVO;
    }

    public void setCardsVO(CTSCARDSVO cardsVO)
    {
	this.cardsVO = cardsVO;
    }

    public CTSPASSBOOK_TYPEVO getPassBookVO()
    {
	return passBookVO;
    }

    public void setPassBookVO(CTSPASSBOOK_TYPEVO passBookVO)
    {
	this.passBookVO = passBookVO;
    }

    public RIFCTT_GLVO getRifcttGlVO()
    {
	return rifcttGlVO;
    }

    public void setRifcttGlVO(RIFCTT_GLVO rifcttGlVO)
    {
	this.rifcttGlVO = rifcttGlVO;
    }

    /**
     * @return the cifSuspiciousFlag
     */
    public Boolean getCifSuspiciousFlag()
    {
	return cifSuspiciousFlag;
    }

    /**
     * @param cifSuspiciousFlag the cifSuspiciousFlag to set
     */
    public void setCifSuspiciousFlag(Boolean cifSuspiciousFlag)
    {
	this.cifSuspiciousFlag = cifSuspiciousFlag;
    }

    /**
     * @return the cifControlRecordFlag
     */
    public Boolean getCifControlRecordFlag()
    {
	return cifControlRecordFlag;
    }

    /**
     * @param cifControlRecordFlag the cifControlRecordFlag to set
     */
    public void setCifControlRecordFlag(Boolean cifControlRecordFlag)
    {
	this.cifControlRecordFlag = cifControlRecordFlag;
    }

    public CifProductsCO getFomCifProductsCO()
    {
	return fomCifProductsCO;
    }

    public void setFomCifProductsCO(CifProductsCO fomCifProductsCO)
    {
	this.fomCifProductsCO = fomCifProductsCO;
    }

    /**
     * @return the reloadDeletedCif
     */
    public Boolean getReloadDeletedCif()
    {
	return reloadDeletedCif;
    }

    /**
     * @param reloadDeletedCif the reloadDeletedCif to set
     */
    public void setReloadDeletedCif(Boolean reloadDeletedCif)
    {
	this.reloadDeletedCif = reloadDeletedCif;
    }

    /**
     * @return the cifIdDetailsVO
     */
    public CIF_ID_DETAILSVO getCifIdDetailsVO()
    {
	return cifIdDetailsVO;
    }

    /**
     * @param cifIdDetailsVO the cifIdDetailsVO to set
     */
    public void setCifIdDetailsVO(CIF_ID_DETAILSVO cifIdDetailsVO)
    {
	this.cifIdDetailsVO = cifIdDetailsVO;
    }

    /*
     * IIAB120195 - this modification substitute the of this attribute : showMemoOnLoad
    public String getShowMemoOnLoad()
    {
	return showMemoOnLoad;
    }

    public void setShowMemoOnLoad(String showMemoOnLoad)
    {
	this.showMemoOnLoad = showMemoOnLoad;
    }
    */

    public String getAddressPageRef()
    {
	return addressPageRef;
    }

    public void setAddressPageRef(String addressPageRef)
    {
	this.addressPageRef = addressPageRef;
    }

    public String getADDRESS1()
    {
	return ADDRESS1;
    }

    public void setADDRESS1(String aDDRESS1)
    {
	ADDRESS1 = aDDRESS1;
    }

    public String getADDRESS2()
    {
	return ADDRESS2;
    }

    public void setADDRESS2(String aDDRESS2)
    {
	ADDRESS2 = aDDRESS2;
    }

    public String getADDRESS3()
    {
	return ADDRESS3;
    }

    public void setADDRESS3(String aDDRESS3)
    {
	ADDRESS3 = aDDRESS3;
    }

    public String getsVipAlert()
    {
	return sVipAlert;
    }

    public void setsVipAlert(String sVipAlert)
    {
	this.sVipAlert = sVipAlert;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public AlertsParamCO getAlertsParamCO()
    {
	return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
	this.alertsParamCO = alertsParamCO;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public String getAlertTodoReason()
    {
	return alertTodoReason;
    }

    public void setAlertTodoReason(String alertTodoReason)
    {
	this.alertTodoReason = alertTodoReason;
    }

    public String getShowAlertModifyButton()
    {
	return showAlertModifyButton;
    }

    public void setShowAlertModifyButton(String showAlertModifyButton)
    {
	this.showAlertModifyButton = showAlertModifyButton;
    }

    public MosBlackListCO getMosBlackListCO()
    {
	return mosBlackListCO;
    }

    public void setMosBlackListCO(MosBlackListCO mosBlackListCO)
    {
	this.mosBlackListCO = mosBlackListCO;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    public SignatureCO getSignatureCO()
    {
	return signatureCO;
    }

    public void setSignatureCO(SignatureCO signatureCO)
    {
	this.signatureCO = signatureCO;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    public List<ReportResponseCO> getAmfReportResponseCOList()
    {
	return amfReportResponseCOList;
    }

    public void setAmfReportResponseCOList(List<ReportResponseCO> amfReportResponseCOList)
    {
	this.amfReportResponseCOList = amfReportResponseCOList;
    }

    public List<ReportResponseCO> getCardReportResponseCOList()
    {
	return cardReportResponseCOList;
    }

    public void setCardReportResponseCOList(List<ReportResponseCO> cardReportResponseCOList)
    {
	this.cardReportResponseCOList = cardReportResponseCOList;
    }

    public ReportResponseCO getReportResponseCO()
    {
	return reportResponseCO;
    }

    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
	this.reportResponseCO = reportResponseCO;
    }

    public String getPrintConfirmationMessage()
    {
	return printConfirmationMessage;
    }

    public void setPrintConfirmationMessage(String printConfirmationMessage)
    {
	this.printConfirmationMessage = printConfirmationMessage;
    }

    public boolean isValidateIDsFromMainScreen()
    {
	return validateIDsFromMainScreen;
    }

    public void setValidateIDsFromMainScreen(boolean validateIDsFromMainScreen)
    {
	this.validateIDsFromMainScreen = validateIDsFromMainScreen;
    }

    public ArrayList<Integer> getWarningListCode()
    {
	return warningListCode;
    }

    public void setWarningListCode(ArrayList<Integer> warningListCode)
    {
	this.warningListCode = warningListCode;
    }

    public HashMap<Integer, String[]> getCtsMsgParam()
    {
	return ctsMsgParam;
    }

    public void setCtsMsgParam(HashMap<Integer, String[]> ctsMsgParam)
    {
	this.ctsMsgParam = ctsMsgParam;
    }

    public Boolean getPopulateConfirmation()
    {
	return populateConfirmation;
    }

    public void setPopulateConfirmation(Boolean populateConfirmation)
    {
	this.populateConfirmation = populateConfirmation;
    }

    public ArrayList<String> getWarningList()
    {
	return warningList;
    }

    public void setWarningList(ArrayList<String> warningList)
    {
	this.warningList = warningList;
    }

    public String getCifProductOpened()
    {
	return cifProductOpened;
    }

    public void setCifProductOpened(String cifProductOpened)
    {
	this.cifProductOpened = cifProductOpened;
    }

    public CIF_TRXTYPE_LIMITSVO getCifTrxTypeVO()
    {
	return cifTrxTypeVO;
    }

    public void setCifTrxTypeVO(CIF_TRXTYPE_LIMITSVO cifTrxTypeVO)
    {
	this.cifTrxTypeVO = cifTrxTypeVO;
    }

    public AccountSC getAccount()
    {
	return account;
    }

    public void setAccount(AccountSC account)
    {
	this.account = account;
    }

    public String getFomCIFIrisSave()
    {
	return fomCIFIrisSave;
    }

    public void setFomCIFIrisSave(String fomCIFIrisSave)
    {
	this.fomCIFIrisSave = fomCIFIrisSave;
    }

    public String getCountryKYCDesc()
    {
        return countryKYCDesc;
    }

    public void setCountryKYCDesc(String countryKYCDesc)
    {
        this.countryKYCDesc = countryKYCDesc;
    }

    public CIF_KYCVO getCifKYCVO()
    {
        return cifKYCVO;
    }

    public void setCifKYCVO(CIF_KYCVO cifKYCVO)
    {
        this.cifKYCVO = cifKYCVO;
    }

    public String getActionStr()
    {
        return actionStr;
    }

    public void setActionStr(String actionStr)
    {
        this.actionStr = actionStr;
    }

    public String getEntity()
    {
        return entity;
    }

    public void setEntity(String entity)
    {
        this.entity = entity;
    }

    public BigDecimal getEvent()
    {
        return event;
    }

    public void setEvent(BigDecimal event)
    {
        this.event = event;
    }

    public CIF_IRISVO getCifIrisVO()
    {
        return cifIrisVO;
    }

    public void setCifIrisVO(CIF_IRISVO cifIrisVO)
    {
        this.cifIrisVO = cifIrisVO;
    }

    public CIF_FATCA_DETAILSVO getCifFatcaDetailsVO()
    {
        return cifFatcaDetailsVO;
    }

    public void setCifFatcaDetailsVO(CIF_FATCA_DETAILSVO cifFatcaDetailsVO)
    {
        this.cifFatcaDetailsVO = cifFatcaDetailsVO;
    }

    public String getFatcaReasonDesc()
    {
        return fatcaReasonDesc;
    }

    public void setFatcaReasonDesc(String fatcaReasonDesc)
    {
        this.fatcaReasonDesc = fatcaReasonDesc;
    }

    public String getFatcaAuditTrxNbr()
    {
        return fatcaAuditTrxNbr;
    }

    public void setFatcaAuditTrxNbr(String fatcaAuditTrxNbr)
    {
        this.fatcaAuditTrxNbr = fatcaAuditTrxNbr;
    }

    public String getFatcaAuditJsonStr()
    {
        return fatcaAuditJsonStr;
    }

    public void setFatcaAuditJsonStr(String fatcaAuditJsonStr)
    {
        this.fatcaAuditJsonStr = fatcaAuditJsonStr;
    }

    public String getIsEmptyScreen()
    {
        return isEmptyScreen;
    }

    public void setIsEmptyScreen(String isEmptyScreen)
    {
        this.isEmptyScreen = isEmptyScreen;
    }

    public Date getDateUpdated()
    {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated)
    {
        this.dateUpdated = dateUpdated;
    }

    public String getCifDateUpdated()
    {
        return cifDateUpdated;
    }

    public void setCifDateUpdated(String cifDateUpdated)
    {
        this.cifDateUpdated = cifDateUpdated;
    }

    public BigDecimal getSelectedCifCode()
    {
        return selectedCifCode;
    }

    public void setSelectedCifCode(BigDecimal selectedCifCode)
    {
        this.selectedCifCode = selectedCifCode;
    }

    public List<ReportResponseCO> getAdditionalAdvicesReportList()
    {
        return additionalAdvicesReportList;
    }

    public void setAdditionalAdvicesReportList(List<ReportResponseCO> additionalAdvicesReportList)
    {
        this.additionalAdvicesReportList = additionalAdvicesReportList;
    }

    public String getRifCttBank()
    {
        return rifCttBank;
    }

    public void setRifCttBank(String rifCttBank)
    {
        this.rifCttBank = rifCttBank;
    }

    public String getStatusDeleted()
    {
        return statusDeleted;
    }

    public void setStatusDeleted(String statusDeleted)
    {
        this.statusDeleted = statusDeleted;
    }

    public FOMRequiredDocCO getRequiredDocCO()
    {
        return requiredDocCO;
    }

    public void setRequiredDocCO(FOMRequiredDocCO requiredDocCO)
    {
        this.requiredDocCO = requiredDocCO;
    }

    public LEGAL_STATUSVO getLegalStatusVO()
    {
        return legalStatusVO;
    }

    public void setLegalStatusVO(LEGAL_STATUSVO legalStatusVO)
    {
        this.legalStatusVO = legalStatusVO;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Boolean getCifIdNumDupFlag()
    {
        return cifIdNumDupFlag;
    }

    public void setCifIdNumDupFlag(Boolean cifIdNumDupFlag)
    {
        this.cifIdNumDupFlag = cifIdNumDupFlag;
    }

    public String getMemoOptRef()
    {
        return memoOptRef;
    }

    public void setMemoOptRef(String memoOptRef)
    {
        this.memoOptRef = memoOptRef;
    }

    public COUNTRIESVO getCountriesVO()
    {
        return countriesVO;
    }

    public void setCountriesVO(COUNTRIESVO countriesVO)
    {
        this.countriesVO = countriesVO;
    }

    public List<FomBusinessNatureCO> getFomBusinessNatureCOList()
    {
        return fomBusinessNatureCOList;
    }

    public void setFomBusinessNatureCOList(List<FomBusinessNatureCO> fomBusinessNatureCOList)
    {
        this.fomBusinessNatureCOList = fomBusinessNatureCOList;
    }

    public String getWarngMessages()
    {
        return warngMessages;
    }

    public void setWarngMessages(String warngMessages)
    {
        this.warngMessages = warngMessages;
    }

    public Boolean getReferenceTab()
    {
        return referenceTab;
    }

    public void setReferenceTab(Boolean referenceTab)
    {
        this.referenceTab = referenceTab;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public BigDecimal getCountryId()
    {
        return countryId;
    }

    public void setCountryId(BigDecimal countryId)
    {
        this.countryId = countryId;
    }

    public BigDecimal getOldCountryId()
    {
        return oldCountryId;
    }

    public void setOldCountryId(BigDecimal oldCountryId)
    {
        this.oldCountryId = oldCountryId;
    }

    public Boolean getAccesByTeller()
    {
        return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
        this.accesByTeller = accesByTeller;
    }

    public CIF_CONTACTVO getCifContactVO()
    {
        return cifContactVO;
    }

    public void setCifContactVO(CIF_CONTACTVO cifContactVO)
    {
        this.cifContactVO = cifContactVO;
    }

    public String getFromDependency()
    {
        return fromDependency;
    }

    public void setFromDependency(String fromDependency)
    {
        this.fromDependency = fromDependency;
    }

    public BigDecimal getBranchId()
    {
        return branchId;
    }

    public void setBranchId(BigDecimal branchId)
    {
        this.branchId = branchId;
    }

    public String getFromValidationOfIdType2()
    {
        return fromValidationOfIdType2;
    }

    public void setFromValidationOfIdType2(String fromValidationOfIdType2)
    {
        this.fromValidationOfIdType2 = fromValidationOfIdType2;
    }

    public String getFromFomSignatory()
    {
        return fromFomSignatory;
    }

    public void setFromFomSignatory(String fromFomSignatory)
    {
        this.fromFomSignatory = fromFomSignatory;
    }

    public String getFromIdsButton()
    {
        return fromIdsButton;
    }

    public void setFromIdsButton(String fromIdsButton)
    {
        this.fromIdsButton = fromIdsButton;
    }

//    public String getPassportInfoOpened()
//    {
//        return passportInfoOpened;
//    }
//
//    public void setPassportInfoOpened(String passportInfoOpened)
//    {
//        this.passportInfoOpened = passportInfoOpened;
//    }

    public String getFomKYCIsloaded()
    {
        return fomKYCIsloaded;
    }

    public void setFomKYCIsloaded(String fomKYCIsloaded)
    {
        this.fomKYCIsloaded = fomKYCIsloaded;
    }

    public CifMembersCO getCifMembersCO()
    {
        return cifMembersCO;
    }

    public void setCifMembersCO(CifMembersCO cifMembersCO)
    {
        this.cifMembersCO = cifMembersCO;
    }

    /**
     * @return the rifpctVO
     */
    public RIFPCTVO getRifpctVO()
    {
        return rifpctVO;
    }

    /**
     * @param rifpctVO the rifpctVO to set
     */
    public void setRifpctVO(RIFPCTVO rifpctVO)
    {
        this.rifpctVO = rifpctVO;
    }

    public String getFromFomOwnerShip()
    {
        return fromFomOwnerShip;
    }

    public void setFromFomOwnerShip(String fromFomOwnerShip)
    {
        this.fromFomOwnerShip = fromFomOwnerShip;
    }

    /**
     * @return the allowAccess
     */
    public boolean isAllowAccess()
    {
        return allowAccess;
    }

    /**
     * @param allowAccess the allowAccess to set
     */
    public void setAllowAccess(boolean allowAccess)
    {
        this.allowAccess = allowAccess;
    }

    /**
     * @return the userAxsMap
     */
    public HashMap getUserAxsMap()
    {
        return userAxsMap;
    }

    /**
     * @param userAxsMap the userAxsMap to set
     */
    public void setUserAxsMap(HashMap userAxsMap)
    {
        this.userAxsMap = userAxsMap;
    }

    /**
     * @return the accessFundTransfer
     */
    public BigDecimal getAccessFundTransfer()
    {
        return accessFundTransfer;
    }

    /**
     * @param accessFundTransfer the accessFundTransfer to set
     */
    public void setAccessFundTransfer(BigDecimal accessFundTransfer)
    {
        this.accessFundTransfer = accessFundTransfer;
    }

    /**
     * @return the transactionTrendsList
     */
    public List<FOMTransactionTrendsCO> getTransactionTrendsList()
    {
        return transactionTrendsList;
    }

    /**
     * @param transactionTrendsList the transactionTrendsList to set
     */
    public void setTransactionTrendsList(List<FOMTransactionTrendsCO> transactionTrendsList)
    {
        this.transactionTrendsList = transactionTrendsList;
    }

    /**
     * @return the inactiveStatusDesc
     */
    public String getInactiveStatusDesc()
    {
        return inactiveStatusDesc;
    }

    /**
     * @param inactiveStatusDesc the inactiveStatusDesc to set
     */
    public void setInactiveStatusDesc(String inactiveStatusDesc)
    {
        this.inactiveStatusDesc = inactiveStatusDesc;
    }

    /**
     * @return the enableMcr
     */
    public String getEnableMcr()
    {
        return enableMcr;
    }

    /**
     * @param enableMcr the enableMcr to set
     */
    public void setEnableMcr(String enableMcr)
    {
        this.enableMcr = enableMcr;
    }

    /**
     * @return the hyperlinkId
     */
    public String getHyperlinkId()
    {
        return hyperlinkId;
    }

    /**
     * @param hyperlinkId the hyperlinkId to set
     */
    public void setHyperlinkId(String hyperlinkId)
    {
        this.hyperlinkId = hyperlinkId;
    }

    /**
     * @return the nationBriefDesc
     */
    public String getNationBriefDesc()
    {
        return nationBriefDesc;
    }

    /**
     * @param nationBriefDesc the nationBriefDesc to set
     */
    public void setNationBriefDesc(String nationBriefDesc)
    {
        this.nationBriefDesc = nationBriefDesc;
    }

    public String getKycResidentBankName()
    {
        return kycResidentBankName;
    }

    public void setKycResidentBankName(String kycResidentBankName)
    {
        this.kycResidentBankName = kycResidentBankName;
    }

    public String getKycOpeningAccPurposeDesc()
    {
        return kycOpeningAccPurposeDesc;
    }

    public void setKycOpeningAccPurposeDesc(String kycOpeningAccPurposeDesc)
    {
        this.kycOpeningAccPurposeDesc = kycOpeningAccPurposeDesc;
    }

    public String getKycBusinessEcoSectorDesc()
    {
        return kycBusinessEcoSectorDesc;
    }

    public void setKycBusinessEcoSectorDesc(String kycBusinessEcoSectorDesc)
    {
        this.kycBusinessEcoSectorDesc = kycBusinessEcoSectorDesc;
    }

    public String getKycSourceOfWealth()
    {
        return kycSourceOfWealth;
    }

    public void setKycSourceOfWealth(String kycSourceOfWealth)
    {
        this.kycSourceOfWealth = kycSourceOfWealth;
    }

    public String getKycGreenCardCountryDesc()
    {
        return kycGreenCardCountryDesc;
    }

    public void setKycGreenCardCountryDesc(String kycGreenCardCountryDesc)
    {
        this.kycGreenCardCountryDesc = kycGreenCardCountryDesc;
    }

    public String getKycLongStayCountryDesc()
    {
        return kycLongStayCountryDesc;
    }

    public void setKycLongStayCountryDesc(String kycLongStayCountryDesc)
    {
        this.kycLongStayCountryDesc = kycLongStayCountryDesc;
    }

    public String getKycTaxPayerCountryDesc()
    {
        return kycTaxPayerCountryDesc;
    }

    public void setKycTaxPayerCountryDesc(String kycTaxPayerCountryDesc)
    {
        this.kycTaxPayerCountryDesc = kycTaxPayerCountryDesc;
    }

    public String getKycStandInstrCountryDesc()
    {
        return kycStandInstrCountryDesc;
    }

    public void setKycStandInstrCountryDesc(String kycStandInstrCountryDesc)
    {
        this.kycStandInstrCountryDesc = kycStandInstrCountryDesc;
    }

    public String getKycRemitterBenefNationalityDesc()
    {
        return kycRemitterBenefNationalityDesc;
    }

    public void setKycRemitterBenefNationalityDesc(String kycRemitterBenefNationalityDesc)
    {
        this.kycRemitterBenefNationalityDesc = kycRemitterBenefNationalityDesc;
    }

    public BigDecimal getKycAddressCountryCode()
    {
        return kycAddressCountryCode;
    }

    public void setKycAddressCountryCode(BigDecimal kycAddressCountryCode)
    {
        this.kycAddressCountryCode = kycAddressCountryCode;
    }

    public String getKycAddressCountryDesc()
    {
        return kycAddressCountryDesc;
    }

    public void setKycAddressCountryDesc(String kycAddressCountryDesc)
    {
        this.kycAddressCountryDesc = kycAddressCountryDesc;
    }

    public String getKycAddressState()
    {
        return kycAddressState;
    }

    public void setKycAddressState(String kycAddressState)
    {
        this.kycAddressState = kycAddressState;
    }

    public String getKycAddressGovernate()
    {
        return kycAddressGovernate;
    }

    public void setKycAddressGovernate(String kycAddressGovernate)
    {
        this.kycAddressGovernate = kycAddressGovernate;
    }
 
    public String getKycAddressPoboxCode()
    {
        return kycAddressPoboxCode;
    }

    public void setKycAddressPoboxCode(String kycAddressPoboxCode)
    {
        this.kycAddressPoboxCode = kycAddressPoboxCode;
    }

    public String getKycAddressPoboxDesc()
    {
        return kycAddressPoboxDesc;
    }

    public void setKycAddressPoboxDesc(String kycAddressPoboxDesc)
    {
        this.kycAddressPoboxDesc = kycAddressPoboxDesc;
    }

    public String getKycAddressEmail()
    {
        return kycAddressEmail;
    }

    public void setKycAddressEmail(String kycAddressEmail)
    {
        this.kycAddressEmail = kycAddressEmail;
    }

    public String getKycAttorneyCountryDesc()
    {
        return kycAttorneyCountryDesc;
    }

    public void setKycAttorneyCountryDesc(String kycAttorneyCountryDesc)
    {
        this.kycAttorneyCountryDesc = kycAttorneyCountryDesc;
    }

    public BigDecimal getKycAddressPostalCode()
    {
        return kycAddressPostalCode;
    }

    public void setKycAddressPostalCode(BigDecimal kycAddressPostalCode)
    {
        this.kycAddressPostalCode = kycAddressPostalCode;
    }

    public String getKycAddressPostalCodeDesc()
    {
        return kycAddressPostalCodeDesc;
    }

    public void setKycAddressPostalCodeDesc(String kycAddressPostalCodeDesc)
    {
        this.kycAddressPostalCodeDesc = kycAddressPostalCodeDesc;
    }

    /**
     * @return the additionFieldOpened
     */
    public String getAdditionFieldOpened()
    {
        return additionFieldOpened;
    }

    /**
     * @param additionFieldOpened the additionFieldOpened to set
     */
    public void setAdditionFieldOpened(String additionFieldOpened)
    {
        this.additionFieldOpened = additionFieldOpened;
    }

    public String getKycLoadPassPortInfo()
    {
        return kycLoadPassPortInfo;
    }

    public void setKycLoadPassPortInfo(String kycLoadPassPortInfo)
    {
        this.kycLoadPassPortInfo = kycLoadPassPortInfo;
    }

    /**
     * @return the maxCifNo
     */
    public BigDecimal getMaxCifNo()
    {
        return maxCifNo;
    }

    /**
     * @param maxCifNo the maxCifNo to set
     */
    public void setMaxCifNo(BigDecimal maxCifNo)
    {
        this.maxCifNo = maxCifNo;
    }

    public String getTinMinLengthMessage()
    {
        return tinMinLengthMessage;
    }

    public void setTinMinLengthMessage(String tinMinLengthMessage)
    {
        this.tinMinLengthMessage = tinMinLengthMessage;
    }

    /**
     * @return the openFatca
     */
    public String getOpenFatca()
    {
        return openFatca;
    }

    /**
     * @param openFatca the openFatca to set
     */
    public void setOpenFatca(String openFatca)
    {
        this.openFatca = openFatca;
    }

    /**
     * @return the fromDate
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public Date getToDate()
    {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    /**
     * @return the limitcy
     */
    public String getLimitcy()
    {
        return limitcy;
    }

    /**
     * @param limitcy the limitcy to set
     */
    public void setLimitcy(String limitcy)
    {
        this.limitcy = limitcy;
    }

    /**
     * @return the limitcy1
     */
    public String getLimitcy1()
    {
        return limitcy1;
    }

    /**
     * @param limitcy1 the limitcy1 to set
     */
    public void setLimitcy1(String limitcy1)
    {
        this.limitcy1 = limitcy1;
    }

    /**
     * @return the oldKYCVal
     */
    public String getOldKYCVal()
    {
        return oldKYCVal;
    }

    /**
     * @param oldKYCVal the oldKYCVal to set
     */
    public void setOldKYCVal(String oldKYCVal)
    {
        this.oldKYCVal = oldKYCVal;
    }

//    public CifTaxInfoCO getCifTaxInfoCO()
//    {
//        return cifTaxInfoCO;
//    }
//
//    public void setCifTaxInfoCO(CifTaxInfoCO cifTaxInfoCO)
//    {
//        this.cifTaxInfoCO = cifTaxInfoCO;
//    }
//
//    public ITR_CIF_DETAILSVO getCifItrDetailsVO()
//    {
//	return cifItrDetailsVO;
//    }
//
//    public void setCifItrDetailsVO(ITR_CIF_DETAILSVO cifItrDetailsVO)
//    {
//	this.cifItrDetailsVO = cifItrDetailsVO;
//    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

	public BigDecimal getCheckMandatory() {
		return checkMandatory;
	}

	public void setCheckMandatory(BigDecimal checkMandatory) {
		this.checkMandatory = checkMandatory;
	}
	public ECO_SECTORSVO getEcoSectorsVO() {
		return ecoSectorsVO;
	}

	public void setEcoSectorsVO(ECO_SECTORSVO ecoSectorsVO) {
		this.ecoSectorsVO = ecoSectorsVO;
	}

    public String getFomCifBicCodeDetailsLoaded()
    {
        return fomCifBicCodeDetailsLoaded;
    }

    public void setFomCifBicCodeDetailsLoaded(String fomCifBicCodeDetailsLoaded)
    {
        this.fomCifBicCodeDetailsLoaded = fomCifBicCodeDetailsLoaded;
    }

    public String getFomFundTransferDetailsLoaded()
    {
        return fomFundTransferDetailsLoaded;
    }

    public void setFomFundTransferDetailsLoaded(String fomFundTransferDetailsLoaded)
    {
        this.fomFundTransferDetailsLoaded = fomFundTransferDetailsLoaded;
    }
//    public String getSironAlert()
//    {
//	return sironAlert;
//    }


//	public String getSironAlert() {
//		return sironAlert;
//	}
//
//	public void setSironAlert(String sironAlert) {
//		this.sironAlert = sironAlert;
//	}

//    public void setSironAlert(String sironAlert)
//    {
//	this.sironAlert = sironAlert;
//    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public String getScreenName()
    {
	return screenName;
    }

    public void setScreenName(String screenName)
    {
	this.screenName = screenName;
    }

    public String getAllowCifCreationMaskYN()
    {
	return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
	this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getNickName()
    {
	return nickName;
    }

    public void setNickName(String nickName)
    {
	this.nickName = nickName;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public BigDecimal getAccessCifSwiftDetails()
    {
        return accessCifSwiftDetails;
    }

    public void setAccessCifSwiftDetails(BigDecimal accessCifSwiftDetails)
    {
        this.accessCifSwiftDetails = accessCifSwiftDetails;
    }
    
    public String getFnIdentifier()
    {
        return fnIdentifier;
    }

    public void setFnIdentifier(String fnIdentifier)
    {
        this.fnIdentifier = fnIdentifier;
    }

    public String getCheckOnjoin()
    {
        return checkOnjoin;
    }

    public void setCheckOnjoin(String checkOnjoin)
    {
        this.checkOnjoin = checkOnjoin;
    }

    public String getCheckIdDigitsParam()
    {
        return checkIdDigitsParam;
    }

    public void setCheckIdDigitsParam(String checkIdDigitsParam)
    {
        this.checkIdDigitsParam = checkIdDigitsParam;
    }
  
    public String getEbankingChannel()
    {
        return ebankingChannel;
    }

    public void setEbankingChannel(String ebankingChannel)
    {
        this.ebankingChannel = ebankingChannel;
    }

    public CTS_ECONOMIC_AGENTVO getEconomicAgentVO()
    {
        return economicAgentVO;
    }

    public void setEconomicAgentVO(CTS_ECONOMIC_AGENTVO economicAgentVO)
    {
        this.economicAgentVO = economicAgentVO;
    }

    public String getEconomicAgentDesc()
    {
        return economicAgentDesc;
    }

    public void setEconomicAgentDesc(String economicAgentDesc)
    {
        this.economicAgentDesc = economicAgentDesc;
    }

    public CTS_PROFESSION_CATEGORYVO getProfessionCategory()
    {
        return professionCategory;
    }

    public void setProfessionCategory(CTS_PROFESSION_CATEGORYVO professionCategory)
    {
        this.professionCategory = professionCategory;
    }

    public String getProfessionCategoryDesc()
    {
        return professionCategoryDesc;
    }

    public void setProfessionCategoryDesc(String professionCategoryDesc)
    {
        this.professionCategoryDesc = professionCategoryDesc;
    }

    public CTS_PROFESSION_SEGMENTVO getProfessionSegment()
    {
        return professionSegment;
    }

    public void setProfessionSegment(CTS_PROFESSION_SEGMENTVO professionSegment)
    {
        this.professionSegment = professionSegment;
    }

    public String getProfessionSegmentDesc()
    {
        return professionSegmentDesc;
    }

    public void setProfessionSegmentDesc(String professionSegmentDesc)
    {
        this.professionSegmentDesc = professionSegmentDesc;
    }

    public CTS_PROFESSIONVO getProfession()
    {
        return profession;
    }

    public void setProfession(CTS_PROFESSIONVO profession)
    {
        this.profession = profession;
    }

    public String getProfessionDesc()
    {
        return professionDesc;
    }

    public void setProfessionDesc(String professionDesc)
    {
        this.professionDesc = professionDesc;
    }

    public byte[] getShowPicture()
    {
        return showPicture;
    }

    public void setShowPicture(byte[] showPicture)
    {
        this.showPicture = showPicture;
    }

    public BigDecimal getSevilleRegistration()
    {
        return sevilleRegistration;
    }

    public void setSevilleRegistration(BigDecimal sevilleRegistration)
    {
        this.sevilleRegistration = sevilleRegistration;
    }

//    public WS_RESULT_MAPPINGVO getWsResultMappingVO()
//    {
//        return wsResultMappingVO;
//    }
//
//    public void setWsResultMappingVO(WS_RESULT_MAPPINGVO wsResultMappingVO)
//    {
//        this.wsResultMappingVO = wsResultMappingVO;
//    }

    public boolean isDuplicateCifName()
    {
        return duplicateCifName;
    }

    public void setDuplicateCifName(boolean duplicateCifName)
    {
        this.duplicateCifName = duplicateCifName;
    }

    public String getAddAccByProviderByBill()
    {
        return addAccByProviderByBill;
    }

    public void setAddAccByProviderByBill(String addAccByProviderByBill)
    {
        this.addAccByProviderByBill = addAccByProviderByBill;
    }

    public String getInitBicCode()
    {
        return initBicCode;
    }

    public void setInitBicCode(String initBicCode)
    {
        this.initBicCode = initBicCode;
    }

    public String getFromButton()
    {
        return fromButton;
    }

    public void setFromButton(String fromButton)
    {
        this.fromButton = fromButton;
    }
    
    public String getIDTypeAlreadyinUse()
    {
        return IDTypeAlreadyinUse;
    }

    public void setIDTypeAlreadyinUse(String iDTypeAlreadyinUse)
    {
        IDTypeAlreadyinUse = iDTypeAlreadyinUse;
    }

    public String getOccupationCountryDesc()
    {
        return occupationCountryDesc;
    }

    public void setOccupationCountryDesc(String occupationCountryDesc)
    {
        this.occupationCountryDesc = occupationCountryDesc;
    }


    public String getOccupationPostalCodeDesc()
    {
        return occupationPostalCodeDesc;
    }

    public void setOccupationPostalCodeDesc(String occupationPostalCodeDesc)
    {
        this.occupationPostalCodeDesc = occupationPostalCodeDesc;
    }

    public CIFOBJECTVO getCifObjectVO()
    {
        return cifObjectVO;
    }

    public void setCifObjectVO(CIFOBJECTVO cifObjectVO)
    {
        this.cifObjectVO = cifObjectVO;
    }

    public String getIntroducerCIFDesc()
    {
        return introducerCIFDesc;
    }

    public void setIntroducerCIFDesc(String introducerCIFDesc)
    {
        this.introducerCIFDesc = introducerCIFDesc;
    }

    public String getCardReaderEnabled()
    {
        return cardReaderEnabled;
    }

    public void setCardReaderEnabled(String cardReaderEnabled)
    {
        this.cardReaderEnabled = cardReaderEnabled;
    }

    public BigDecimal getIdTypePreviousVal()
    {
        return idTypePreviousVal;
    }

    public void setIdTypePreviousVal(BigDecimal idTypePreviousVal)
    {
        this.idTypePreviousVal = idTypePreviousVal;
    }

    public BigDecimal getIdType()
    {
        return idType;
    }

    public void setIdType(BigDecimal idType)
    {
        this.idType = idType;
    }

    public BigDecimal getIdType2()
    {
        return idType2;
    }

    public void setIdType2(BigDecimal idType2)
    {
        this.idType2 = idType2;
    }

    public String getCountryOfIssuanceIDName()
    {
        return countryOfIssuanceIDName;
    }

    public void setCountryOfIssuanceIDName(String countryOfIssuanceIDName)
    {
        this.countryOfIssuanceIDName = countryOfIssuanceIDName;
    }

    public String getCountryOfIssuanceDescIDName()
    {
        return countryOfIssuanceDescIDName;
    }

    public void setCountryOfIssuanceDescIDName(String countryOfIssuanceDescIDName)
    {
        this.countryOfIssuanceDescIDName = countryOfIssuanceDescIDName;
    }

    public String getReasonDesc()
    {
	return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc)
    {
	this.reasonDesc = reasonDesc;
    }

    public String getReasonType()
    {
	return reasonType;
    }

    public void setReasonType(String reasonType)
    {
	this.reasonType = reasonType;
    }

    public CIF_EXTENDEDVO getCifExtendedVO()
    {
	return cifExtendedVO;
    }

    public void setCifExtendedVO(CIF_EXTENDEDVO cifExtendedVO)
    {
	this.cifExtendedVO = cifExtendedVO;
    }

    public String getCountryOfIssuanceDesc()
    {
	return countryOfIssuanceDesc;
    }

    public void setCountryOfIssuanceDesc(String countryOfIssuanceDesc)
    {
	this.countryOfIssuanceDesc = countryOfIssuanceDesc;
    }

    public String getJointCountryOfIssuanceDesc()
    {
	return jointCountryOfIssuanceDesc;
    }

    public void setJointCountryOfIssuanceDesc(String jointCountryOfIssuanceDesc)
    {
	this.jointCountryOfIssuanceDesc = jointCountryOfIssuanceDesc;
    }

    public String getSignCountryOfIssuanceDesc()
    {
	return signCountryOfIssuanceDesc;
    }

    public void setSignCountryOfIssuanceDesc(String signCountryOfIssuanceDesc)
    {
	this.signCountryOfIssuanceDesc = signCountryOfIssuanceDesc;
    }

    public String getCif1VOCountryOfIssuanceDesc()
    {
	return cif1VOCountryOfIssuanceDesc;
    }

    public void setCif1VOCountryOfIssuanceDesc(String cif1voCountryOfIssuanceDesc)
    {
	cif1VOCountryOfIssuanceDesc = cif1voCountryOfIssuanceDesc;
    }

    public String getCif1VOCountryOfIssuance2Desc()
    {
	return cif1VOCountryOfIssuance2Desc;
    }

    public void setCif1VOCountryOfIssuance2Desc(String cif1voCountryOfIssuance2Desc)
    {
	cif1VOCountryOfIssuance2Desc = cif1voCountryOfIssuance2Desc;
    }

    public String getCif1VOCountryOfIssuance3Desc()
    {
	return cif1VOCountryOfIssuance3Desc;
    }

    public void setCif1VOCountryOfIssuance3Desc(String cif1voCountryOfIssuance3Desc)
    {
	cif1VOCountryOfIssuance3Desc = cif1voCountryOfIssuance3Desc;
    }

    public BigDecimal getCountryOfIssuanceVal()
    {
	return countryOfIssuanceVal;
    }

    public void setCountryOfIssuanceVal(BigDecimal countryOfIssuanceVal)
    {
	this.countryOfIssuanceVal = countryOfIssuanceVal;
    }

    public String getFromGrid()
    {
	return fromGrid;
    }

    public void setFromGrid(String fromGrid)
    {
	this.fromGrid = fromGrid;
    }

    public String getBaseCurrencyDesc()
    {
	return baseCurrencyDesc;
    }

    public void setBaseCurrencyDesc(String baseCurrencyDesc)
    {
	this.baseCurrencyDesc = baseCurrencyDesc;
    }

    public String getExemptFullChargesWaiver()
    {
	return exemptFullChargesWaiver;
    }

    public void setExemptFullChargesWaiver(String exemptFullChargesWaiver)
    {
	this.exemptFullChargesWaiver = exemptFullChargesWaiver;
    }

    public String getYmcOtherCntryDesc()
    {
	return ymcOtherCntryDesc;
    }

    public void setYmcOtherCntryDesc(String ymcOtherCntryDesc)
    {
	this.ymcOtherCntryDesc = ymcOtherCntryDesc;
    }

    public String getYmcTypeOfAccountDesc()
    {
	return ymcTypeOfAccountDesc;
    }

    public void setYmcTypeOfAccountDesc(String ymcTypeOfAccountDesc)
    {
	this.ymcTypeOfAccountDesc = ymcTypeOfAccountDesc;
    }

    public CIF_KYC_PARAM_LINKVO getCifKycParamLinkVO()
    {
	return cifKycParamLinkVO;
    }

    public void setCifKycParamLinkVO(CIF_KYC_PARAM_LINKVO cifKycParamLinkVO)
    {
	this.cifKycParamLinkVO = cifKycParamLinkVO;
    }

    public String getAdditionnalKycProps()
    {
	return additionnalKycProps;
    }

    public void setAdditionnalKycProps(String additionnalKycProps)
    {
	this.additionnalKycProps = additionnalKycProps;
    }

    public BigDecimal getScreenId()
    {
	return screenId;
    }

    public void setScreenId(BigDecimal screenId)
    {
	this.screenId = screenId;
    }

    public String getKycStreet()
    {
	return kycStreet;
    }

    public void setKycStreet(String kycStreet)
    {
	this.kycStreet = kycStreet;
    }

    public String getKycAvenue()
    {
	return kycAvenue;
    }

    public void setKycAvenue(String kycAvenue)
    {
	this.kycAvenue = kycAvenue;
    }

    public String getKycBlock()
    {
	return kycBlock;
    }

    public void setKycBlock(String kycBlock)
    {
	this.kycBlock = kycBlock;
    }

    public String getKycHouseBuildling()
    {
	return kycHouseBuildling;
    }

    public void setKycHouseBuildling(String kycHouseBuildling)
    {
	this.kycHouseBuildling = kycHouseBuildling;
    }

    public String getKycTel()
    {
	return kycTel;
    }

    public void setKycTel(String kycTel)
    {
	this.kycTel = kycTel;
    }

    public String getKycFax()
    {
	return kycFax;
    }

    public void setKycFax(String kycFax)
    {
	this.kycFax = kycFax;
    }

    public BigDecimal getKycRegion()
    {
	return kycRegion;
    }

    public void setKycRegion(BigDecimal kycRegion)
    {
	this.kycRegion = kycRegion;
    }

    public String getKycRegionDesc()
    {
	return kycRegionDesc;
    }

    public void setKycRegionDesc(String kycRegionDesc)
    {
	this.kycRegionDesc = kycRegionDesc;
    }

    public String getKycPoBox()
    {
	return kycPoBox;
    }

    public void setKycPoBox(String kycPoBox)
    {
	this.kycPoBox = kycPoBox;
    }

    public boolean isFromMoreAddressButton()
    {
	return fromMoreAddressButton;
    }

    public void setFromMoreAddressButton(boolean fromMoreAddressButton)
    {
	this.fromMoreAddressButton = fromMoreAddressButton;
    }

    public String getApplyCorporateKycId()
    {
	return applyCorporateKycId;
    }

    public void setApplyCorporateKycId(String applyCorporateKycId)
    {
	this.applyCorporateKycId = applyCorporateKycId;
    }

    public BigDecimal getReturnCode()
    {
	return returnCode;
    }

    public void setReturnCode(BigDecimal returnCode)
    {
	this.returnCode = returnCode;
    }

    public BigDecimal getLimit()
    {
	return limit;
    }

    public void setLimit(BigDecimal limit)
    {
	this.limit = limit;
    }

    public BigDecimal getValue()
    {
	return value;
    }

    public void setValue(BigDecimal value)
    {
	this.value = value;
    }

    public BigDecimal getConfirmationCode()
    {
	return confirmationCode;
    }

    public void setConfirmationCode(BigDecimal confirmationCode)
    {
	this.confirmationCode = confirmationCode;
    }

    public String getOneObligorLongDesc()
    {
	return oneObligorLongDesc;
    }

    public void setOneObligorLongDesc(String oneObligorLongDesc)
    {
	this.oneObligorLongDesc = oneObligorLongDesc;
    }

    public String getSource()
    {
	return source;
    }

    public void setSource(String source)
    {
	this.source = source;
    }

    public BigDecimal getParentObligor()
    {
	return parentObligor;
    }

    public void setParentObligor(BigDecimal parentObligor)
    {
	this.parentObligor = parentObligor;
    }

    public BigDecimal getSironGrade()
    {
        return sironGrade;
    }

    public void setSironGrade(BigDecimal sironGrade)
    {
        this.sironGrade = sironGrade;
    }

    public String getSironReasonDesc()
    {
        return sironReasonDesc;
    }

    public void setSironReasonDesc(String sironReasonDesc)
    {
        this.sironReasonDesc = sironReasonDesc;
    }

    public String getSironCompliance()
    {
        return sironCompliance;
    }

    public void setSironCompliance(String sironCompliance)
    {
        this.sironCompliance = sironCompliance;
    }

    public String getSironVisibility()
    {
        return sironVisibility;
    }

    public void setSironVisibility(String sironVisibility)
    {
        this.sironVisibility = sironVisibility;
    }

    public String getRegionBirthDesc()
    {
        return regionBirthDesc;
    }

    public void setRegionBirthDesc(String regionBirthDesc)
    {
        this.regionBirthDesc = regionBirthDesc;
    }

    public String getCityDesc()
    {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc)
    {
        this.cityDesc = cityDesc;
    }

    public String getProductsIssuedDesc()
    {
        return productsIssuedDesc;
    }

    public void setProductsIssuedDesc(String productsIssuedDesc)
    {
        this.productsIssuedDesc = productsIssuedDesc;
    }

    public String getIsFromPrintConf()
    {
        return isFromPrintConf;
    }

    public void setIsFromPrintConf(String isFromPrintConf)
    {
        this.isFromPrintConf = isFromPrintConf;
    }
    

    public String getShowMessage()
    {
        return showMessage;
    }

    public void setShowMessage(String showMessage)
    {
        this.showMessage = showMessage;
    }
    
    public Date getFinalDate()
    {
	return finalDate;
    }

    
    public void setFinalDate(Date finalDate)
    {
	this.finalDate = finalDate;
    }

    public String getFomNameDetailsLoaded()
    {
        return fomNameDetailsLoaded;
    }

    public void setFomNameDetailsLoaded(String fomNameDetailsLoaded)
    {
        this.fomNameDetailsLoaded = fomNameDetailsLoaded;
    }

    public String getFomPassportInfoLoaded()
    {
        return fomPassportInfoLoaded;
    }

    public void setFomPassportInfoLoaded(String fomPassportInfoLoaded)
    {
        this.fomPassportInfoLoaded = fomPassportInfoLoaded;
    }

    public String getFomReferencesDetailsLoaded()
    {
        return fomReferencesDetailsLoaded;
    }

    public void setFomReferencesDetailsLoaded(String fomReferencesDetailsLoaded)
    {
        this.fomReferencesDetailsLoaded = fomReferencesDetailsLoaded;
    }

    public String getFomMarketDetailsLoaded()
    {
        return fomMarketDetailsLoaded;
    }

    public void setFomMarketDetailsLoaded(String fomMarketDetailsLoaded)
    {
        this.fomMarketDetailsLoaded = fomMarketDetailsLoaded;
    }

    public String getRecvIncomeCntryDesc()
    {
        return recvIncomeCntryDesc;
    }

    public void setRecvIncomeCntryDesc(String recvIncomeCntryDesc)
    {
        this.recvIncomeCntryDesc = recvIncomeCntryDesc;
    }

    public String getCompCountryDesc()
    {
        return compCountryDesc;
    }

    public void setCompCountryDesc(String compCountryDesc)
    {
        this.compCountryDesc = compCountryDesc;
    }

    public String getIncomeThroughDesc()
    {
        return incomeThroughDesc;
    }

    public void setIncomeThroughDesc(String incomeThroughDesc)
    {
        this.incomeThroughDesc = incomeThroughDesc;
    }

    public String getDepositThroughDesc()
    {
        return depositThroughDesc;
    }

    public void setDepositThroughDesc(String depositThroughDesc)
    {
        this.depositThroughDesc = depositThroughDesc;
    }

    public String getYmcStatusDesc()
    {
        return ymcStatusDesc;
    }

    public void setYmcStatusDesc(String ymcStatusDesc)
    {
        this.ymcStatusDesc = ymcStatusDesc;
    }

    public boolean isComplianceUserApprove()
    {
        return complianceUserApprove;
    }

    public void setComplianceUserApprove(boolean complianceUserApprove)
    {
        this.complianceUserApprove = complianceUserApprove;
    }

    public String getVtIndicator() {
	return vtIndicator;
    }

    public void setVtIndicator(String vtIndicator) {
	this.vtIndicator = vtIndicator;
    }

    public String getCrsSignYN()
    {
        return crsSignYN;
    }

    public void setCrsSignYN(String crsSignYN)
    {
        this.crsSignYN = crsSignYN;
    }

    public List<ReportResponseCO> getResultList()
    {
        return resultList;
    }

    public void setResultList(List<ReportResponseCO> resultList)
    {
        this.resultList = resultList;
    }

    public String getFatcaCompliant()
    {
        return fatcaCompliant;
    }

    public void setFatcaCompliant(String fatcaCompliant)
    {
        this.fatcaCompliant = fatcaCompliant;
    }

    public CTS_CIF_KYC_DETAILSVO getCtsCifKycDetailsVO()
    {
        return ctsCifKycDetailsVO;
    }

    public void setCtsCifKycDetailsVO(CTS_CIF_KYC_DETAILSVO ctsCifKycDetailsVO)
    {
        this.ctsCifKycDetailsVO = ctsCifKycDetailsVO;
    }
    

    public String getNameMatchedOR()
    {
        return NameMatchedOR;
    }

    public void setNameMatchedOR(String nameMatchedOR)
    {
        NameMatchedOR = nameMatchedOR;
    }

    public BigDecimal getCriteriaPerc()
    {
        return criteriaPerc;
    }

    public void setCriteriaPerc(BigDecimal criteriaPerc)
    {
        this.criteriaPerc = criteriaPerc;
    }

    public int getCountBlckListLog()
    {
        return countBlckListLog;
    }

    public void setCountBlckListLog(int countBlckListLog)
    {
        this.countBlckListLog = countBlckListLog;
    }

    public ArrayList<CTS_BLCKLIST_NAME_MATCHVO> getCtsBlckListNameMatchVO()
    {
        return ctsBlckListNameMatchVO;
    }

    public void setCtsBlckListNameMatchVO(ArrayList<CTS_BLCKLIST_NAME_MATCHVO> ctsBlckListNameMatchVO)
    {
        this.ctsBlckListNameMatchVO = ctsBlckListNameMatchVO;
    }

    public boolean isComplianceDecision()
    {
        return complianceDecision;
    }

    public void setComplianceDecision(boolean complianceDecision)
    {
        this.complianceDecision = complianceDecision;
    }

    public String getTodoAlert()
    {
        return todoAlert;
    }

    public void setTodoAlert(String todoAlert)
    {
        this.todoAlert = todoAlert;
    }

    public int getCountCif()
    {
        return countCif;
    }

    public void setCountCif(int countCif)
    {
        this.countCif = countCif;
    }

    public BigDecimal getCifNoforJoint()
    {
        return cifNoforJoint;
    }

    public void setCifNoforJoint(BigDecimal cifNoforJoint)
    {
        this.cifNoforJoint = cifNoforJoint;
    }

    public CIF_JOINT_DETVO getCifJointAccVO()
    {
        return cifJointAccVO;
    }

    public void setCifJointAccVO(CIF_JOINT_DETVO cifJointAccVO)
    {
        this.cifJointAccVO = cifJointAccVO;
    }

    public BigDecimal getJointCifNo()
    {
        return jointCifNo;
    }

    public void setJointCifNo(BigDecimal jointCifNo)
    {
        this.jointCifNo = jointCifNo;
    }

    public int getCountCifsJoint()
    {
        return countCifsJoint;
    }

    public void setCountCifsJoint(int countCifsJoint)
    {
        this.countCifsJoint = countCifsJoint;
    }

    public int getMosBlackListCode()
    {
        return mosBlackListCode;
    }

    public void setMosBlackListCode(int mosBlackListCode)
    {
        this.mosBlackListCode = mosBlackListCode;
    }

    public String getCifRestricted()
    {
        return cifRestricted;
    }

    public void setCifRestricted(String cifRestricted)
    {
        this.cifRestricted = cifRestricted;
    }

    public String getRestrictionMessage()
    {
        return restrictionMessage;
    }

    public void setRestrictionMessage(String restrictionMessage)
    {
        this.restrictionMessage = restrictionMessage;
    }

    public Boolean getRegistered()
    {
        return registered;
    }

    public void setRegistered(Boolean registered)
    {
        this.registered = registered;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public String getWalletAccount()
    {
        return walletAccount;
    }

    public void setWalletAccount(String walletAccount)
    {
        this.walletAccount = walletAccount;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getOldMobileNumber()
    {
        return oldMobileNumber;
    }

    public void setOldMobileNumber(String oldMobileNumber)
    {
        this.oldMobileNumber = oldMobileNumber;
    }

    public String getIdTypes()
    {
        return idTypes;
    }

    public void setIdTypes(String idTypes)
    {
        this.idTypes = idTypes;
    }

    public String getIsoCountry()
    {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry)
    {
        this.isoCountry = isoCountry;
    }

    public BigDecimal getCountryOfIssuance()
    {
        return countryOfIssuance;
    }

    public void setCountryOfIssuance(BigDecimal countryOfIssuance)
    {
        this.countryOfIssuance = countryOfIssuance;
    }

    public String getIssueCountry()
    {
        return issueCountry;
    }

    public void setIssueCountry(String issueCountry)
    {
        this.issueCountry = issueCountry;
    }

    public String getCallWebService()
    {
        return callWebService;
    }

    public void setCallWebService(String callWebService)
    {
        this.callWebService = callWebService;
    }
    
    public CardReaderCO getCardReaderCO()
    {
	return cardReaderCO;
    }

    public void setCardReaderCO(CardReaderCO cardReaderCO)
    {
	this.cardReaderCO = cardReaderCO;
    }
    
    public BigDecimal getTryMatch()
    {
        return tryMatch;
    }

    public void setTryMatch(BigDecimal tryMatch)
    {
        this.tryMatch = tryMatch;
    }


    public String getKycDhfLoaded()
    {
        return kycDhfLoaded;
    }

    public void setKycDhfLoaded(String kycDhfLoaded)
    {
        this.kycDhfLoaded = kycDhfLoaded;
    }

    public String getStatusCode()
    {
	return statusCode;
    }

    public void setStatusCode(String statusCode)
    {
	this.statusCode = statusCode;
    }

    public String getCifTypeBank()
    {
	return cifTypeBank;
    }

    public void setCifTypeBank(String cifTypeBank)
    {
	this.cifTypeBank = cifTypeBank;
    }

    public String getBranchDescriptionArabic()
    {
	return branchDescriptionArabic;
    }

    public void setBranchDescriptionArabic(String branchDescriptionArabic)
    {
	this.branchDescriptionArabic = branchDescriptionArabic;
    }

    public String getIdTypeDescriptionArabic()
    {
	return idTypeDescriptionArabic;
    }

    public void setIdTypeDescriptionArabic(String idTypeDescriptionArabic)
    {
	this.idTypeDescriptionArabic = idTypeDescriptionArabic;
    }

    public String getIdTypeAdditionalReference()
    {
	return idTypeAdditionalReference;
    }

    public void setIdTypeAdditionalReference(String idTypeAdditionalReference)
    {
	this.idTypeAdditionalReference = idTypeAdditionalReference;
    }

    public String getNationalityLongDescription()
    {
	return nationalityLongDescription;
    }

    public void setNationalityLongDescription(String nationalityLongDescription)
    {
	this.nationalityLongDescription = nationalityLongDescription;
    }

    public String getCountryDescriptionArabic()
    {
	return countryDescriptionArabic;
    }

    public void setCountryDescriptionArabic(String countryDescriptionArabic)
    {
	this.countryDescriptionArabic = countryDescriptionArabic;
    }

    public String getCountryBriefDescription()
    {
	return countryBriefDescription;
    }

    public void setCountryBriefDescription(String countryBriefDescription)
    {
	this.countryBriefDescription = countryBriefDescription;
    }


    public BigDecimal getProductType()
    {
	return productType;
    }

    public void setProductType(BigDecimal productType)
    {
	this.productType = productType;
    }

    public Boolean getFromPackageProduct()
    {
	return fromPackageProduct;
    }

    public String getIdTypeSwiftCode()
    {
	return idTypeSwiftCode;
    }

    public void setIdTypeSwiftCode(String idTypeSwiftCode)
    {
	this.idTypeSwiftCode = idTypeSwiftCode;
    }

    public String getKeepStatus()
    {
	return keepStatus;
    }


    public void setKeepStatus(String keepStatus)
    {
	this.keepStatus = keepStatus;
    }
    
    /**
     * @param additionalFieldsByTypeCO the additionalFieldsByTypeCO to set
     */
    public void setAdditionalFieldsByTypeCO(AdditionalFieldsByTypeCO additionalFieldsByTypeCO)
    {
	this.additionalFieldsByTypeCO = additionalFieldsByTypeCO;
    }
    
    /**
     * @return the additionalFieldsByTypeCO
     */
    public AdditionalFieldsByTypeCO getAdditionalFieldsByTypeCO()
    {
	return additionalFieldsByTypeCO;
    }

    public String getFromAddNationalities()
    {
	return fromAddNationalities;
    }


    public void setFromAddNationalities(String fromAddNationalities)
    {
	this.fromAddNationalities = fromAddNationalities;
    }

    public AddFieldsFomCO getAdditionalFieldCO()
    {
	return additionalFieldCO;
    }

    public void setAdditionalFieldCO(AddFieldsFomCO additionalFieldCO)
    {
	this.additionalFieldCO = additionalFieldCO;
    }

    public void setFromPackageProduct(Boolean fromPackageProduct)
    {
	this.fromPackageProduct = fromPackageProduct;
    }

    public String getAutoApproveFlag()
    {
	return autoApproveFlag;
    }

    public void setAutoApproveFlag(String autoApproveFlag)
    {
	this.autoApproveFlag = autoApproveFlag;
    }

    public String getExemptReasonType()
    {
	return exemptReasonType;
    }

    public void setExemptReasonType(String exemptReasonType)
    {
	this.exemptReasonType = exemptReasonType;
    }

    public String getExemptReasonDesc()
    {
	return exemptReasonDesc;
    }

    public void setExemptReasonDesc(String exemptReasonDesc)
    {
	this.exemptReasonDesc = exemptReasonDesc;
    }

    public String getReasonCodeDesc()
    {
	return reasonCodeDesc;
    }

    public void setReasonCodeDesc(String reasonCodeDesc)
    {
	this.reasonCodeDesc = reasonCodeDesc;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementHashmap()
    {
	return elementHashmap;
    }

    public void setElementHashmap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	this.elementHashmap = elementHashmap;
    }

    public String getFromSignature()
    {
	return fromSignature;
    }

    public void setFromSignature(String fromSignature)
    {
	this.fromSignature = fromSignature;
    }
    
    public String getIsFromPrintAccConf()
    {
        return isFromPrintAccConf;
    }

    public void setIsFromPrintAccConf(String isFromPrintAccConf)
    {
        this.isFromPrintAccConf = isFromPrintAccConf;
    }

    public String getCif1VOCountryOfIssuanceIso()
    {
        return cif1VOCountryOfIssuanceIso;
    }

    public void setCif1VOCountryOfIssuanceIso(String cif1voCountryOfIssuanceIso)
    {
        cif1VOCountryOfIssuanceIso = cif1voCountryOfIssuanceIso;
    }

    public String getCif1VOCountryOfIssuance2Iso()
    {
        return cif1VOCountryOfIssuance2Iso;
    }

    public void setCif1VOCountryOfIssuance2Iso(String cif1voCountryOfIssuance2Iso)
    {
        cif1VOCountryOfIssuance2Iso = cif1voCountryOfIssuance2Iso;
    }

    public String getCif1VOCountryOfIssuance3Iso()
    {
        return cif1VOCountryOfIssuance3Iso;
    }

    public void setCif1VOCountryOfIssuance3Iso(String cif1voCountryOfIssuance3Iso)
    {
        cif1VOCountryOfIssuance3Iso = cif1voCountryOfIssuance3Iso;
    }

    public Boolean getAdditionalFieldsTabReadOnlyMode()
    {
	return additionalFieldsTabReadOnlyMode;
    }

    public void setAdditionalFieldsTabReadOnlyMode(Boolean additionalFieldsTabReadOnlyMode)
    {
	this.additionalFieldsTabReadOnlyMode = additionalFieldsTabReadOnlyMode;
    }

    public Boolean getCifBicCodeTabReadOnlyMode()
    {
	return cifBicCodeTabReadOnlyMode;
    }

    public void setCifBicCodeTabReadOnlyMode(Boolean cifBicCodeTabReadOnlyMode)
    {
	this.cifBicCodeTabReadOnlyMode = cifBicCodeTabReadOnlyMode;
    }

    public Boolean getFundTransferTabReadOnlyMode()
    {
	return fundTransferTabReadOnlyMode;
    }

    public void setFundTransferTabReadOnlyMode(Boolean fundTransferTabReadOnlyMode)
    {
	this.fundTransferTabReadOnlyMode = fundTransferTabReadOnlyMode;
    }

    public String getScoreAmended()
    {
	return scoreAmended;
    }

    public void setScoreAmended(String scoreAmended)
    {
	this.scoreAmended = scoreAmended;
    }

    public CIF_SCORE_RESULTVO getCifScoreResultVO()
    {
	return cifScoreResultVO;
    }

    public void setCifScoreResultVO(CIF_SCORE_RESULTVO cifScoreResultVO)
    {
	this.cifScoreResultVO = cifScoreResultVO;
    }

    public String getScoreRiskDescription()
    {
	return scoreRiskDescription;
    }

    public void setScoreRiskDescription(String scoreRiskDescription)
    {
	this.scoreRiskDescription = scoreRiskDescription;
    }

    public String getErrorDesc()
    {
	return errorDesc;
    }

    public void setErrorDesc(String errorDesc)
    {
	this.errorDesc = errorDesc;
    }

    public BigDecimal getScoreCode()
    {
	return scoreCode;
    }

    public void setScoreCode(BigDecimal scoreCode)
    {
	this.scoreCode = scoreCode;
    }
    
    public boolean isCheckUserCifTypeAccounts()
    {
        return checkUserCifTypeAccounts;
    }

    public void setCheckUserCifTypeAccounts(boolean checkUserCifTypeAccounts)
    {
        this.checkUserCifTypeAccounts = checkUserCifTypeAccounts;
    }


    public void setCifKycFinancialInfoCO(CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO)
    {
	this.cifKycFinancialInfoCO = cifKycFinancialInfoCO;
    }

    public CTS_CIF_SEGMENT_HISTORYVO getCtsCifSegmentHistoryVO()
    {
	return ctsCifSegmentHistoryVO;
    }

    public void setCtsCifSegmentHistoryVO(CTS_CIF_SEGMENT_HISTORYVO ctsCifSegmentHistoryVO)
    {
	this.ctsCifSegmentHistoryVO = ctsCifSegmentHistoryVO;
    }

    public BigDecimal getGroupCode()
    {
	return groupCode;
    }

    public void setGroupCode(BigDecimal groupCode)
    {
	this.groupCode = groupCode;
    }

    public String getGroupCodeDesc()
    {
	return groupCodeDesc;
    }

    public void setGroupCodeDesc(String groupCodeDesc)
    {
	this.groupCodeDesc = groupCodeDesc;
    }

    public Date getSegmentCreatedDate()
    {
	return segmentCreatedDate;
    }

    public void setSegmentCreatedDate(Date segmentCreatedDate)
    {
	this.segmentCreatedDate = segmentCreatedDate;
    }

    public String getFomIntroducerDetailsLoaded()
    {
	return fomIntroducerDetailsLoaded;
    }

    public void setFomIntroducerDetailsLoaded(String fomIntroducerDetailsLoaded)
    {
	this.fomIntroducerDetailsLoaded = fomIntroducerDetailsLoaded;
    }

    public String getFomCifBicCodeLoaded()
    {
	return fomCifBicCodeLoaded;
    }

    public void setFomCifBicCodeLoaded(String fomCifBicCodeLoaded)
    {
	this.fomCifBicCodeLoaded = fomCifBicCodeLoaded;
    }

    public String getSironResetKycScore()
    {
	return sironResetKycScore;
    }

    public void setSironResetKycScore(String sironResetKycScore)
    {
	this.sironResetKycScore = sironResetKycScore;
    }

    public boolean isSironFailed()
    {
	return sironFailed;
    }

    public void setSironFailed(boolean sironFailed)
    {
	this.sironFailed = sironFailed;
    }

    public String getNoMessageToDisplay()
    {
	return noMessageToDisplay;
    }

    public void setNoMessageToDisplay(String noMessageToDisplay)
    {
	this.noMessageToDisplay = noMessageToDisplay;
    }

    public CIF_KYC_FINANCIAL_INFOCO getCifKycFinancialInfoCO()
    {
	return cifKycFinancialInfoCO;
    }

    public String getRunType()
    {
	return runType;
    }

    public void setRunType(String runType)
    {
	this.runType = runType;
    }

    public String getSegmentCodeDescription()
    {
	return segmentCodeDescription;
    }

    public void setSegmentCodeDescription(String segmentCodeDescription)
    {
	this.segmentCodeDescription = segmentCodeDescription;
    }

    public BigDecimal getScoreRiskValue()
    {
	return scoreRiskValue;
    }

    public void setScoreRiskValue(BigDecimal scoreRiskValue)
    {
	this.scoreRiskValue = scoreRiskValue;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getStatusReason()
    {
	return statusReason;
    }

    public void setStatusReason(String statusReason)
    {
	this.statusReason = statusReason;
    }

    public String getModifyMessage()
    {
	return modifyMessage;
    }

    public void setModifyMessage(String modifyMessage)
    {
	this.modifyMessage = modifyMessage;
    }

    public String getAgentDescription()
    {
	return agentDescription;
    }

    public void setAgentDescription(String agentDescription)
    {
	this.agentDescription = agentDescription;
    }

    public String getIncomeBusinessCntryDesc()
    {
	return incomeBusinessCntryDesc;
    }

    public void setIncomeBusinessCntryDesc(String incomeBusinessCntryDesc)
    {
	this.incomeBusinessCntryDesc = incomeBusinessCntryDesc;
    }
    
    public String getBlackListInCifName()
    {
	return blackListInCifName;
    }

    public void setBlackListInCifName(String blackListInCifName)
    {
	this.blackListInCifName = blackListInCifName;
    }

    public String getBlackListAction()
    {
	return blackListAction;
    }

    public void setBlackListAction(String blackListAction)
    {
	this.blackListAction = blackListAction;
    }

    public BigDecimal getBlkListRegion()
    {
	return blkListRegion;
    }

    public void setBlkListRegion(BigDecimal blkListRegion)
    {
	this.blkListRegion = blkListRegion;
    }

    public String getBlkListWarnMessage()
    {
	return blkListWarnMessage;
    }

    public void setBlkListWarnMessage(String blkListWarnMessage)
    {
	this.blkListWarnMessage = blkListWarnMessage;
    }

    public String getIdscontainsrecords()
    {
	return Idscontainsrecords;
    }

    public void setIdscontainsrecords(String idscontainsrecords)
    {
	Idscontainsrecords = idscontainsrecords;
    }

    public String getAllowModifySegment()
    {
        return allowModifySegment;
    }

    public void setAllowModifySegment(String allowModifySegment)
    {
        this.allowModifySegment = allowModifySegment;
    }

    public List<FomCO> getFomCOGridList()
    {
        return fomCOGridList;
    }

    public void setFomCOGridList(List<FomCO> fomCOGridList)
    {
        this.fomCOGridList = fomCOGridList;
    }

    public String getSegmentManuallyChanged()
    {
        return segmentManuallyChanged;
    }

    public void setSegmentManuallyChanged(String segmentManuallyChanged)
    {
        this.segmentManuallyChanged = segmentManuallyChanged;
    }

    public BigDecimal getConsolidatedView()
    {
        return consolidatedView;
    }

    public void setConsolidatedView(BigDecimal consolidatedView)
    {
        this.consolidatedView = consolidatedView;
    }

    public CIFVO getEmployerCifVO()
    {
        return employerCifVO;
    }

    public void setEmployerCifVO(CIFVO employerCifVO)
    {
        this.employerCifVO = employerCifVO;
    }

    public BigDecimal getOccupOtherIncome()
    {
        return occupOtherIncome;
    }

    public void setOccupOtherIncome(BigDecimal occupOtherIncome)
    {
        this.occupOtherIncome = occupOtherIncome;
    }

    public String getCurrIsoCode()
    {
        return currIsoCode;
    }

    public void setCurrIsoCode(String currIsoCode)
    {
        this.currIsoCode = currIsoCode;
    }

    public String getCurrBriefDescEng()
    {
        return currBriefDescEng;
    }

    public void setCurrBriefDescEng(String currBriefDescEng)
    {
        this.currBriefDescEng = currBriefDescEng;
    }

    public int getNbrCif()
    {
        return nbrCif;
    }

    public void setNbrCif(int nbrCif)
    {
        this.nbrCif = nbrCif;
    }

    public String getBillFlag()
    {
        return billFlag;
    }

    public void setBillFlag(String billFlag)
    {
        this.billFlag = billFlag;
    }

    public List<AdditionalFieldsByTypeCO> getAdditionalFieldsByTypeCOList()
    {
        return additionalFieldsByTypeCOList;
    }

    public void setAdditionalFieldsByTypeCOList(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList)
    {
        this.additionalFieldsByTypeCOList = additionalFieldsByTypeCOList;
    }

    public List<FomCO> getFomCOLst()
    {
        return fomCOLst;
    }

    public void setFomCOLst(List<FomCO> fomCOLst)
    {
        this.fomCOLst = fomCOLst;
    }

    public ArrayList<CIF_KYC_FINANCIAL_INFOCO> getBoardMemberList()
    {
        return boardMemberList;
    }

    public void setBoardMemberList(ArrayList<CIF_KYC_FINANCIAL_INFOCO> boardMemberList)
    {
        this.boardMemberList = boardMemberList;
    }

    public String getBoardMemberGrid()
    {
        return boardMemberGrid;
    }

    public void setBoardMemberGrid(String boardMemberGrid)
    {
        this.boardMemberGrid = boardMemberGrid;
    }

    public List<FOMJointIdsCO> getCifJointIdDetailsVOList()
    {
        return cifJointIdDetailsVOList;
    }

    public void setCifJointIdDetailsVOList(List<FOMJointIdsCO> cifJointIdDetailsVOList)
    {
        this.cifJointIdDetailsVOList = cifJointIdDetailsVOList;
    }

    public String getCorporateType()
    {
        return corporateType;
    }

    public void setCorporateType(String corporateType)
    {
        this.corporateType = corporateType;
    }

    public BigDecimal getFromCifJoint()
    {
        return fromCifJoint;
    }

    public void setFromCifJoint(BigDecimal fromCifJoint)
    {
        this.fromCifJoint = fromCifJoint;
    }

    public String getAdditionnalFatcaProps()
    {
        return additionnalFatcaProps;
    }

    public void setAdditionnalFatcaProps(String additionnalFatcaProps)
    {
        this.additionnalFatcaProps = additionnalFatcaProps;
    }

   
    public String getActualBenefGrid()
    {
        return actualBenefGrid;
    }

    public void setActualBenefGrid(String actualBenefGrid)
    {
        this.actualBenefGrid = actualBenefGrid;
    }

    public ArrayList<CIF_KYC_FINANCIAL_INFOCO> getActualBenefList()
    {
        return actualBenefList;
    }

    public void setActualBenefList(ArrayList<CIF_KYC_FINANCIAL_INFOCO> actualBenefList)
    {
        this.actualBenefList = actualBenefList;
    }

    public String getAuthorizedDetGrid()
    {
        return authorizedDetGrid;
    }

    public void setAuthorizedDetGrid(String authorizedDetGrid)
    {
        this.authorizedDetGrid = authorizedDetGrid;
    }

    public ArrayList<CIF_KYC_FINANCIAL_INFOCO> getAuthorizedDetList()
    {
        return authorizedDetList;
    }

    public void setAuthorizedDetList(ArrayList<CIF_KYC_FINANCIAL_INFOCO> authorizedDetList)
    {
        this.authorizedDetList = authorizedDetList;
    }

    public String getAttorneysDetGrid()
    {
        return attorneysDetGrid;
    }

    public void setAttorneysDetGrid(String attorneysDetGrid)
    {
        this.attorneysDetGrid = attorneysDetGrid;
    }

    public ArrayList<CIF_KYC_FINANCIAL_INFOCO> getAttorneysDetList()
    {
        return attorneysDetList;
    }

    public void setAttorneysDetList(ArrayList<CIF_KYC_FINANCIAL_INFOCO> attorneysDetList)
    {
        this.attorneysDetList = attorneysDetList;
    }

   
    public ArrayList<CIF_KYC_FINANCIAL_INFOCO> getShareHolderDetList()
    {
        return shareHolderDetList;
    }

    public void setShareHolderDetList(ArrayList<CIF_KYC_FINANCIAL_INFOCO> shareHolderDetList)
    {
        this.shareHolderDetList = shareHolderDetList;
    }

    public String getShareHolderDetGrid()
    {
        return shareHolderDetGrid;
    }

    public void setShareHolderDetGrid(String shareHolderDetGrid)
    {
        this.shareHolderDetGrid = shareHolderDetGrid;
    }   

    public List<FOMIdsCO> getCifProxyBenefIDDetailsVOList()
    {
	return cifProxyBenefIDDetailsVOList;
    }

    public void setCifProxyBenefIDDetailsVOList(List<FOMIdsCO> cifProxyBenefIDDetailsVOList)
    {
	this.cifProxyBenefIDDetailsVOList = cifProxyBenefIDDetailsVOList;
    }

    public WS_RESULT_MAPPINGVO getWsResultMappingVO()
    {
        return wsResultMappingVO;
    }

    public void setWsResultMappingVO(WS_RESULT_MAPPINGVO wsResultMappingVO)
    {
        this.wsResultMappingVO = wsResultMappingVO;
    }

    

	public String getAdditionnalPepProps() {
		return additionnalPepProps;
	}

	public void setAdditionnalPepProps(String additionnalPepProps) {
		this.additionnalPepProps = additionnalPepProps;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSendRestrictAlert() {
		return sendRestrictAlert;
	}

	public void setSendRestrictAlert(boolean sendRestrictAlert) {
		this.sendRestrictAlert = sendRestrictAlert;
	}

	public boolean isRestrictConfirmationFlag() {
		return restrictConfirmationFlag;
	}

	public void setRestrictConfirmationFlag(boolean restrictConfirmationFlag) {
		this.restrictConfirmationFlag = restrictConfirmationFlag;
	}
	
    public String getVatZoneDesc()
    {
        return vatZoneDesc;
    }

    public void setVatZoneDesc(String vatZoneDesc)
    {
        this.vatZoneDesc = vatZoneDesc;
    }

		public String getProofOccupationDesc() {
		return proofOccupationDesc;
	}

	public void setProofOccupationDesc(String proofOccupationDesc) {
		this.proofOccupationDesc = proofOccupationDesc;
	}

	public String getSourceFundsDesc() {
		return sourceFundsDesc;
	}

	public void setSourceFundsDesc(String sourceFundsDesc) {
		this.sourceFundsDesc = sourceFundsDesc;
	}

	public String getEmploymentStatusDesc() {
		return employmentStatusDesc;
	}

	public void setEmploymentStatusDesc(String employmentStatusDesc) {
		this.employmentStatusDesc = employmentStatusDesc;
	}

	public String getAddressField() {
		return addressField;
	}

	public void setAddressField(String addressField) {
		this.addressField = addressField;
	}

	
	public Boolean getSourceOfFundsDescReadOnlyMode()
	{
		return sourceOfFundsDescReadOnlyMode;
	}

	
	public void setSourceOfFundsDescReadOnlyMode(Boolean sourceOfFundsDescReadOnlyMode)
	{
		this.sourceOfFundsDescReadOnlyMode = sourceOfFundsDescReadOnlyMode;
	}

	
	public String getSourceFundsDummyDesc()
	{
		return sourceFundsDummyDesc;
	}

	
	public void setSourceFundsDummyDesc(String sourceFundsDummyDesc)
	{
		this.sourceFundsDummyDesc = sourceFundsDummyDesc;
	}
	
	public CardsManagementCO getCardsManagementCO()
	{
	    return cardsManagementCO;
	}

    	public void setCardsManagementCO(CardsManagementCO cardsManagementCO)
    	{
    	    this.cardsManagementCO = cardsManagementCO;
    	}	
	
}