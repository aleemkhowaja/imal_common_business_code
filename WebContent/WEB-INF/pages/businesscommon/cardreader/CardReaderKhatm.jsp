<%@include file="/WEB-INF/pages/common/Encoding.jsp"%> 
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
 	 
<script type="text/javascript">
var SEX_ENGLISH=  "<ps:property value='SEX_ENGLISH'  escapeHtml='true' escapeJavaScript='true' />" ;  
var DATE_OF_BIRTH=  "<ps:property value='DATE_OF_BIRTH'  escapeHtml='true' escapeJavaScript='true' />" ;  
var CSN=  "<ps:property value='CSN'  escapeHtml='true' escapeJavaScript='true' />" ; 
var ID_CIVIL_NUMBER=  "<ps:property value='ID_CIVIL_NUMBER'   escapeHtml='true' escapeJavaScript='true' />" ; 
var ID_DATE_OF_EXPIRY=   "<ps:property value='ID_DATE_OF_EXPIRY' escapeHtml='true' escapeJavaScript='true' />"  ;
var NATIONALITY_ENGLISH=   "<ps:property value='NATIONALITY_ENGLISH'  escapeHtml='true' escapeJavaScript='true' />" ;  
var TITLE_FULL_NAME_ARABIC=   "<ps:property value='TITLE_FULL_NAME_ARABIC'  escapeHtml='true' escapeJavaScript='true' />" ;
var TITLE_FULL_NAME_ENGLISH=  "<ps:property value='TITLE_FULL_NAME_ENGLISH'   escapeHtml='true' escapeJavaScript='true'/>" ;
var fromWhere =  "<ps:property value='fromWhere'  escapeHtml='true' escapeJavaScript='true' />" ;

//var error_code =  '${error_code}';

var error_type =   "<ps:property value='error_type' escapeHtml='false' escapeJavaScript='true' />" ;
//var error_desc  = "<ps:property value='error_desc' escapeHtml='false' escapeJavaScript='true' />" ;
var  fromMethod =   "<ps:property value='fromMethod'  escapeHtml='false' escapeJavaScript='true' />"  ;  
var valueParams = {};
valueParams["fromMethod"]             = fromMethod;

valueParams["error_type"]             = error_type;
//valueParams["error_desc"]             = error_desc;
var pageRef = parent._pageRef;

if (fromWhere == "FOM")
	{
	if(error_type == null || error_type == ''  || error_type == ' ' )
		{ 
		
		
		 valueParams["cifVO_BIRTH_DATE"] 	     = DATE_OF_BIRTH;
		 valueParams["cardReaderCardSerial"]     = CSN;
		 valueParams["cifVO_ID_NO"]      = ID_CIVIL_NUMBER;
		 valueParams["cardReaderCivilID"]         = ID_CIVIL_NUMBER;
		 valueParams["cifVO_ID_EXPIRY_DATE"] 		     = ID_DATE_OF_EXPIRY;	
		 valueParams["lookuptxt_cifVO_NATION_CODE"]           = NATIONALITY_ENGLISH ;
		 valueParams["cifVO_LONG_NAME_ARAB"]             = TITLE_FULL_NAME_ARABIC; 
		 valueParams["cifVO_LONG_NAME_ENG"]             = TITLE_FULL_NAME_ENGLISH; 
		 valueParams["SEX_ENGLISH"]             = SEX_ENGLISH;
		}

	 valueParams["pageRef"]             = pageRef; 
	 
	parent.changeTheValueFOM(fromWhere, valueParams); 
	}  
	if (fromWhere  ==  "CHQ")
	{ 
	
		if(error_type == null || error_type == ''  || error_type == ' ' )
		{
 		 valueParams["CSN"]     = CSN;
		 valueParams["ID_CIVIL_NUMBER"]     = ID_CIVIL_NUMBER;
		 //added by maria for BMO180267 
		 valueParams["TITLE_FULL_NAME_ENGLISH"]     = TITLE_FULL_NAME_ENGLISH;
		 valueParams["ID_EXPIRY_DATE"] = ID_DATE_OF_EXPIRY;
		 valueParams["NATION_CODE"]= NATIONALITY_ENGLISH;
		 valueParams["SEX_ENGLISH"] = SEX_ENGLISH;
		 //end maria 
		}
		 parent.changeTheValueCHQ(fromWhere ,valueParams );  
	}
	if (fromWhere  == "CRD")
	{
		if(error_type == null || error_type == ''  || error_type == ' ' )
		{
		 valueParams["CSN"]     = CSN;
		 valueParams["ID_CIVIL_NUMBER"]     = ID_CIVIL_NUMBER; 
	 	//added by maria for BMO180267 
		 valueParams["TITLE_FULL_NAME_ENGLISH"]     = TITLE_FULL_NAME_ENGLISH;
		 valueParams["ID_EXPIRY_DATE"] = ID_DATE_OF_EXPIRY;
		 valueParams["NATION_CODE"]= NATIONALITY_ENGLISH;
		 valueParams["SEX_ENGLISH"] = SEX_ENGLISH;
		 //end maria 
		}
		
 		 parent.changeTheValueCRD(fromWhere , valueParams); 
			
	}
	if (fromWhere == "TRX") 
	{
		if(error_type == null || error_type == ''  || error_type == ' ' )
		{
		 valueParams["CSN"]     = CSN;
		 valueParams["ID_CIVIL_NUMBER"]     = ID_CIVIL_NUMBER; 
		 valueParams["TITLE_FULL_NAME_ENGLISH"]     = TITLE_FULL_NAME_ENGLISH;
		 valueParams["ID_EXPIRY_DATE"] = ID_DATE_OF_EXPIRY;
		 valueParams["NATION_CODE"]= NATIONALITY_ENGLISH;
		 valueParams["SEX_ENGLISH"] = SEX_ENGLISH;
		}
		parent.changeTheValueTRX(fromWhere ,valueParams); 
	
	} 
	if (fromWhere == "DGR") 
	{ 
		parent.changeTheValueDGR(fromWhere ,"cardReaderCivilID_"  , ID_CIVIL_NUMBER);
	}	 
</script>
