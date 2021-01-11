/**
 * remove hyperlink formatting to properly read the value 
 * of the column with hyperlink
 * @param {Object} cellValue
 */
function dashboard_unformatHyperlink(cellValue)
{
	return cellValue;
}

/**
 * for inward LC drilldown
 * @param {Object} cellValue
 * @param {Object} options
 */
function dashboard_inwardLCBtn(cellValue, options)
{
	return '<a href = "#" onclick="javascript:onInwardLCShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

function onInwardLCShowlink(selectedRowId)
{
  	var $t = $("#inLCListGridTbl_Id_"+_pageRef);
  	var myObject = $t.jqGrid('getRowData',selectedRowId); 
	var lcType = myObject["tfslc1VO.LC_TYPE"];
	var lcYear = myObject["tfslc1VO.LC_YEAR"];
	var lcNbr = myObject["tfslc1VO.LC_NBR"];
	var trxType = myObject["tfstrxVO.TRX_TYPE"];
	var trxNbr = myObject["tfstrxVO.TRX_NBR"];
	var branchCode = myObject["tfslc1VO.BRANCH"];
	var ivCrud = "R";	
	
	var inwardLCDiv = $("<div id='inwardLCDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	var dashInwardLCDiv = $(inwardLCDiv);
	theForm.append(dashInwardLCDiv);
	dashInwardLCDiv.insertAfter(theForm);
	
	var params = {'lcMgntCO.tfslc1VO.LC_TYPE':lcType,
				'lcMgntCO.tfsLc1VO.LC_YEAR':lcYear,
				'lcMgntCO.tfsLc1VO.LC_NBR':lcNbr,
				'lcMgntCO.tfsTrxVO.TRX_TYPE':trxType,
				'lcMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
				'lcMgntCO.tfsLc1VO.BRANCH':branchCode,
			   	'_pageRef':'ILC01MT',
			  	'iv_crud':ivCrud,
			    'isLookUp':1
			   	};
	
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = "ILC01MT";
	iFrameParams["appName"] = 'TFA';
	iFrameParams["destinationUrl"] = "/path/lc/lcmgnt/LcMgntMaint_edit";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashInwardLCDiv.dialog( {
		modal : true,
		title : exportLCKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#inwardLCDiv_id_"+_pageRef ).dialog("destroy");
			$("#inwardLCDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashInwardLCDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#inwardLCDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * for outward LC drilldown
 * @param {Object} cellValue
 * @param {Object} options
 */
function dashboard_outwardLCBtn(cellValue, options)
{
	return '<a href = "#" onclick="javascript:onOutwardLCShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

function onOutwardLCShowlink(selectedRowId)
{
  	var $t = $("#outLCListGridTbl_Id_"+_pageRef);
  	var myObject = $t.jqGrid('getRowData',selectedRowId); 
	var lcType = myObject["tfslc1VO.LC_TYPE"];
	var lcYear = myObject["tfslc1VO.LC_YEAR"];
	var lcNbr = myObject["tfslc1VO.LC_NBR"];
	var trxType = myObject["tfstrxVO.TRX_TYPE"];
	var trxNbr = myObject["tfstrxVO.TRX_NBR"];
	var branchCode = myObject["tfslc1VO.BRANCH"];
	var ivCrud = "R";
	
	var outwardLCDiv = $("<div id='outwardLCDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	var dashOutwardLCDiv = $(outwardLCDiv);
	theForm.append(dashOutwardLCDiv);
	dashOutwardLCDiv.insertAfter(theForm);
	
	var params = {'lcMgntCO.tfslc1VO.LC_TYPE':lcType,
				'lcMgntCO.tfsLc1VO.LC_YEAR':lcYear,
				'lcMgntCO.tfsLc1VO.LC_NBR':lcNbr,
				'lcMgntCO.tfsTrxVO.TRX_TYPE':trxType,
				'lcMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
				'lcMgntCO.tfsLc1VO.BRANCH':branchCode,
			   	'_pageRef':'OLC02MT',
			  	'iv_crud':ivCrud,
			    'isLookUp':1
			   	};
	
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = "OLC02MT";
	iFrameParams["appName"] = 'TFA';
	iFrameParams["destinationUrl"] = "/path/lc/lcmgnt/LcMgntMaint_edit";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashOutwardLCDiv.dialog( {
		modal : true,
		title : importLCKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#outwardLCDiv_id_"+_pageRef ).dialog("destroy");
			$("#outwardLCDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashOutwardLCDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#outwardLCDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * for acceptance drilldown
 * @param {Object} cellValue
 * @param {Object} options
 */
function dashboard_acceptanceBtn(cellValue, options)
{
	return '<a href = "#" onclick="javascript:acceptanceShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

function acceptanceShowlink(selectedRowId)
{
  	var $t = $("#acceptanceListGridTbl_Id_"+_pageRef);
  	var myObject = $t.jqGrid('getRowData',selectedRowId); 
	var lcType = myObject["tfslc1VO.LC_TYPE"];
	var lcYear = myObject["tfslc1VO.LC_YEAR"];
	var lcNbr = myObject["tfslc1VO.LC_NBR"];
	var trxType = myObject["tfstrxVO.TRX_TYPE"];
	var trxNbr = myObject["tfstrxVO.TRX_NBR"];
	var branchCode = myObject["tfstrxVO.BRANCH"];
	var ivCrud = "R";
	
	var acceptanceDiv = $("<div id='acceptanceDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	var dashAcceptanceDiv = $(acceptanceDiv);
	theForm.append(dashAcceptanceDiv);
	dashAcceptanceDiv.insertAfter(theForm);
	
	var pageRef, divTitle;
	
	if (lcType == 'O')
	{
		pageRef = "OLC06MT";
		divTitle = importLCKey;
	}
	else if (lcType == 'I')
	{
		pageRef = "ILC04MT";
		divTitle = exportLCKey;
	}
	else if (lcType == 'N')
	{
		pageRef = "IB04MT";
		divTitle = importBillKey;
	}
	else if (lcType == 'U')
	{
		pageRef = "OB04MT";
		divTitle = exportBillKey;
	}
	
	var destinationUrl;
	
	if (lcType == 'O' || lcType == 'I')
	{
		destinationUrl = "/path/lc/lcmgnt/LcMgntMaint_edit";
		
		var params = {'lcMgntCO.tfslc1VO.LC_TYPE':lcType,
				'lcMgntCO.tfsLc1VO.LC_YEAR':lcYear,
				'lcMgntCO.tfsLc1VO.LC_NBR':lcNbr,
				'lcMgntCO.tfsTrxVO.TRX_TYPE':trxType,
				'lcMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
				'lcMgntCO.tfsLc1VO.BRANCH':branchCode,
			   	'_pageRef':pageRef,
			  	'iv_crud':ivCrud,
			    'isLookUp':1
			   	};
	}
	else if (lcType == 'N' || lcType == 'U')
	{
		destinationUrl = "/path/bill/bcmgnt/BcMgntMaint_edit"
		
		var params = {'bcMgntCO.tfsBillVO.BILL_TYPE':lcType,
				'bcMgntCO.tfsBillVO.BILL_NBR':lcNbr,
				'bcMgntCO.tfsTrxVO.TRX_TYPE':trxType,
				'bcMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
				'bcMgntCO.tfsBillVO.BRANCH':branchCode,
			   	'_pageRef':pageRef,
			  	'iv_crud':ivCrud,
			    'isLookUp':1
			   	};
	}
	
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = pageRef;
	iFrameParams["appName"] = 'TFA';
	iFrameParams["destinationUrl"] = destinationUrl;
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashAcceptanceDiv.dialog( {
		modal : true,
		title : divTitle,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#acceptanceDiv_id_"+_pageRef ).dialog("destroy");
			$("#acceptanceDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashAcceptanceDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#acceptanceDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * for bills drilldown
 * @param {Object} cellValue
 * @param {Object} options
 */
function dashboard_inOutBillsBtn(cellValue, options)
{
	return '<a href = "#" onclick="javascript:inOutBillsShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

function inOutBillsShowlink(selectedRowId)
{
  	var $t = $("#inOutBillsListGridTbl_Id_"+_pageRef);
  	var myObject = $t.jqGrid('getRowData',selectedRowId); 
	var billType = myObject["tfstrxVO.LC_TYPE"];
	var billNbr = myObject["tfsbillVO.BILL_NBR"];
	var trxType = myObject["tfstrxVO.TRX_TYPE"];
	var trxNbr = myObject["tfstrxVO.TRX_NBR"];
	var branchCode = myObject["tfstrxVO.BRANCH"];
	var ivCrud = "R";
	
	var inOutBillsDiv = $("<div id='inOutBillsDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	var dashInOutBillsDiv = $(inOutBillsDiv);
	theForm.append(dashInOutBillsDiv);
	dashInOutBillsDiv.insertAfter(theForm);
	
	var pageRef, divTitle;
	
	if (billType == 'N')
	{
		pageRef = "IB01MT";
		divTitle = importBillKey;
	}
	else if (billType == 'U')
	{
		pageRef = "OB01MT";
		divTitle = exportBillKey;
	}
	
	var params = {'bcMgntCO.tfsBillVO.BILL_TYPE':billType,
			'bcMgntCO.tfsBillVO.BILL_NBR':billNbr,
			'bcMgntCO.tfsTrxVO.TRX_TYPE':trxType,
			'bcMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
			'bcMgntCO.tfsBillVO.BRANCH':branchCode,
		   	'_pageRef':pageRef,
		  	'iv_crud':ivCrud,
		    'isLookUp':1
		   	};
	
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = pageRef;
	iFrameParams["appName"] = 'TFA';
	iFrameParams["destinationUrl"] = "/path/bill/bcmgnt/BcMgntMaint_edit";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashInOutBillsDiv.dialog( {
		modal : true,
		title : divTitle,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#inOutBillsDiv_id_"+_pageRef ).dialog("destroy");
			$("#inOutBillsDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashInOutBillsDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#inOutBillsDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * 
 * @param {Object} cellValue
 * @param {Object} options
 */
function dashboard_lgBtn(cellValue, options)
{
	return '<a href = "#" onclick="javascript:lgShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

function lgShowlink(selectedRowId)
{
  	var $t = $("#lgGridTbl_Id_"+_pageRef);
  	var myObject = $t.jqGrid('getRowData',selectedRowId); 
  	
	var lgNbr = myObject["tfslgVO.LG_NBR"];
	var trxType = myObject["tfstrxVO.TRX_TYPE"];
	var trxNbr = myObject["tfstrxVO.TRX_NBR"];
	var branchCode = myObject["tfslgVO.BRANCH"];
	var ivCrud = "R";
	
	var lgDiv = $("<div id='lgDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	
	var dashLGDiv = $(lgDiv);
	theForm.append(dashLGDiv);
	dashLGDiv.insertAfter(theForm);
	
	var pageRef = "LG02MT";
	var params = {'lgMgntCO.tfsLgVO.LG_NBR':lgNbr,
			'lgMgntCO.tfsTrxVO.TRX_TYPE':trxType,
			'lgMgntCO.tfsTrxVO.TRX_NBR':trxNbr,
			'lgMgntCO.tfsLgVO.BRANCH':branchCode,
		   	'_pageRef':pageRef,
		  	'iv_crud':ivCrud,
		    'isLookUp':1
		   	};
	
	var currentAppName = 'TFA';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = pageRef;
	iFrameParams["appName"] = 'TFA';
	iFrameParams["destinationUrl"] = "/path/lg/lgmgnt/LgMgntMaint_edit";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashLGDiv.dialog( {
		modal : true,
		title : lgKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#lgDiv_id_"+_pageRef ).dialog("destroy");
			$("#lgDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashLGDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#lgDiv_id_"+_pageRef ).dialog("open");
			});
}

function openParams(cellvalue, options, rowObject)
{
  return '<a href="#" onclick="dash_assetsLiablLink(\''+options.rowId+'\')">'+cellvalue+'</a>';
}

function dash_assetsLiablLink(_rowid,assetOrLiabl)
{debugger;
	
	var cifNo         = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	myObject     =  $("#assetsLiabAccGridTbl_Id_"+_pageRef).jqGrid("getRowData",_rowid);
	var category = myObject["categoryId"];
    var assestsOrLiab = "";
	if (assetOrLiabl != null) /*From chart Link*/
		{
		category = assetOrLiabl;
		}
	switch(category)
	{
	   case "1":
		  assestsOrLiab = "A";
		  break;
	   default:
		  assestsOrLiab = "L";
		  
		  break;
	}
	var mySrc = jQuery.contextPath+"/path/globalview/dashAccDetailsLoadAction?";
	var params = {cif_no:cifNo,assestsOrLiab:assestsOrLiab,_pageRef:_pageRef,loginTypeByBr:loginTypeByBr};
	$("#detailDiv_"+_pageRef).html("");
	$("#mainDivId_"+_pageRef).css("display","none");
	$("#detailDiv_"+_pageRef).load(mySrc,params);
	$("#detailDiv_"+_pageRef).show('slide');
}
function dash_ShowSignature()
{
	var signatureParams = {};
	var cifNo  = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginBrType = $("#loginType_"+_pageRef).val();
	//all branches
//	if(loginBrType == "2")
//	{
		var cifBr  = $("#cifBranch_"+_pageRef).val();
		signatureParams["signatureSC.branchCode"]  = cifBr;
//	}
	
	signatureParams["signatureSC.signatureTp"]      = 'C';
	signatureParams["signatureSC.readOnly"]         = "true";
	signatureParams["signatureSC.cifNo"] 		    = cifNo;	
	signatureParams["signatureSC.parentPageStatus"] = "P"
	signatureParams["_pageRef"] 					= _pageRef;
	populateSignaturePopup("dashboardFormId",signatureParams);
}

//falha 853215 DBU190869 - 360 degree Report Enhancement
function dashShowAccDtlTrxJv()
{
	var $table        = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	if(selectedRowId!=null && typeof selectedRowId != "undefined" && selectedRowId !="")
	{	        		
        var myObject = $table.jqGrid('getRowData', selectedRowId);
        var cifNo   = $("#lookuptxt_cif_no_"+_pageRef).val();
        var acc_bra = myObject["branchCode"];
        var acc_cy = myObject["currencyCode"];
        var acc_gl = myObject["glCode"];
        var acc_sl = myObject["slNo"];
        var loginTypeByBr = $("#loginType_"+_pageRef).val();
        var params        = {cif_no:cifNo,accBr:acc_bra,currencyCode:acc_cy,glCode:acc_gl,slNo:acc_sl,accNum:myObject["acc_num"],addRef:myObject["acc_add_ref"],_pageRef:_pageRef,loginTypeByBr:loginTypeByBr};
        var mySrc         = jQuery.contextPath+"/path/globalview/dashAccDtlTrxLoadAction?";
        
        var mySrc2         = jQuery.contextPath+"/path/globalview/dashAccDtlJvsLoadAction?";
	 

        $("#mainDivId_"+_pageRef).css("display","none");
        $("#detailDiv_"+_pageRef).css("display","none");
        $("#subDetailDiv_"+_pageRef).html("");
        $("#subDetailDiv_"+_pageRef).load(mySrc,params);
        $("#subDetailDiv_"+_pageRef).show('slide');
        
   	    $("#subDetailDiv2_"+_pageRef).html("");
	    $("#subDetailDiv2_"+_pageRef).load(mySrc2,params);
	    $("#subDetailDiv2_"+_pageRef).show('slide');
	}
	else
	{
	    _showErrorMsg(msg_noRecordSelectedLabel,error_msg_title)
	}
}
//falha 853215 DBU190869 - 360 degree Report Enhancement

/**
 * 
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashShowAccDtlTrx()
{
	var $table        = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	if(selectedRowId!=null && typeof selectedRowId != "undefined" && selectedRowId !="")
	{	        		
        var myObject = $table.jqGrid('getRowData', selectedRowId);
        var cifNo   = $("#lookuptxt_cif_no_"+_pageRef).val();
        var acc_bra = myObject["branchCode"];
        var acc_cy = myObject["currencyCode"];
        var acc_gl = myObject["glCode"];
        var acc_sl = myObject["slNo"];
        var loginTypeByBr = $("#loginType_"+_pageRef).val();
        var params        = {cif_no:cifNo,accBr:acc_bra,currencyCode:acc_cy,glCode:acc_gl,slNo:acc_sl,accNum:myObject["acc_num"],addRef:myObject["acc_add_ref"],_pageRef:_pageRef,loginTypeByBr:loginTypeByBr};
        var mySrc         = jQuery.contextPath+"/path/globalview/dashAccDtlTrxLoadAction?";
        
        $("#mainDivId_"+_pageRef).css("display","none");
        $("#detailDiv_"+_pageRef).css("display","none");
        $("#subDetailDiv_"+_pageRef).html("");
        $("#subDetailDiv_"+_pageRef).load(mySrc,params);
        $("#subDetailDiv_"+_pageRef).show('slide');
	}
	else
	{
	    _showErrorMsg(msg_noRecordSelectedLabel,error_msg_title)
	}
	
}
/**
 * 
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashShowAccDtlJvs()
{
	 var $table        = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	 var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	 if(selectedRowId!=null && typeof selectedRowId != "undefined" && selectedRowId !="")
	 {	        		
		 var myObject = $table.jqGrid('getRowData', selectedRowId);
		 var cifNo         = $("#lookuptxt_cif_no_"+_pageRef).val();
		 var loginTypeByBr = $("#loginType_"+_pageRef).val();
		 var params        = {cif_no:cifNo,accNum:myObject["acc_num"],addRef:myObject["acc_add_ref"],_pageRef:_pageRef,loginTypeByBr:loginTypeByBr};
		 var mySrc         = jQuery.contextPath+"/path/globalview/dashAccDtlJvsLoadAction?";
		 
		 $("#mainDivId_"+_pageRef).css("display","none");
		 $("#detailDiv_"+_pageRef).css("display","none");
		 $("#subDetailDiv_"+_pageRef).html("");
		 $("#subDetailDiv_"+_pageRef).load(mySrc,params);
		 $("#subDetailDiv_"+_pageRef).show('slide');
	 }
	 else
	 {
	    _showErrorMsg(msg_noRecordSelectedLabel,error_msg_title)	 
	 }


}
/**
 * 
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 * /path/reports/StatementOfAccountMaint_initialize.action?_type=GLBV&iv_crud=R
 * ( _type should be filled as it is initialized in StatementOfAccountConstant )
 */
/*function dashShowAccDtlStat_old()
{
	 var $table        = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	 var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	 if(selectedRowId!=null && typeof selectedRowId != "undefined" && selectedRowId !="")
	 {	        		
		 var myObject = $table.jqGrid('getRowData', selectedRowId);
		 var cifNo    = $("#lookuptxt_cif_no_"+_pageRef).val();
		 //Bug # --[John Massaad] sending reportsCO.amfVOFrom.BRANCH_CODE and reportsCO.amfVOFrom.BRANCH_CODE as parameters to default the selected account branch not the log in bracnch 
		 var params   = {"reportsCO.branchesVO.BRANCH_CODE":myObject["branchCode"],"reportsCO.amfVOFrom.BRANCH_CODE":myObject["branchCode"],"reportsCO.amfVOTo.BRANCH_CODE":myObject["branchCode"],"reportsCO.amfVOFrom.CURRENCY_CODE":myObject["currencyCode"],"reportsCO.amfVOTo.CURRENCY_CODE":myObject["currencyCode"],
						 "reportsCO.amfVOFrom.GL_CODE":myObject["glCode"],"reportsCO.amfVOTo.GL_CODE":myObject["glCode"],
						 "reportsCO.amfVOFrom.CIF_SUB_NO":cifNo,"reportsCO.amfVOTo.CIF_SUB_NO":cifNo,
						 "reportsCO.amfVOFrom.SL_NO":myObject["slNo"],"reportsCO.amfVOTo.SL_NO":myObject["slNo"],
						 _pageRef:_pageRef,_type:'GLBV',iv_crud:'R'};
		 var mySrc    = jQuery.contextPath+"/path/reports/StatementOfAccountMaint_initialize.action?";
		 
		 $("#mainDivId_"+_pageRef).css("display","none");
		 $("#detailDiv_"+_pageRef).css("display","none");
		 $("#subDetailDiv_"+_pageRef).html("");
		 $("#subDetailDiv_"+_pageRef).load(mySrc,params);
		 $("#subDetailDiv_"+_pageRef).show('slide');
		 
	  var myObject = $table.jqGrid('getRowData', selectedRowId);
	  var cifNo    = $("#lookuptxt_cif_no_"+_pageRef).val();
	  var statementOfAccDiv = $("<div id='statementOfAccDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
      var theForm = $("#dashboardFormId");
      var dashStatementAccDiv = $(statementOfAccDiv);
      theForm.append(dashStatementAccDiv);
      dashStatementAccDiv.insertAfter(theForm);
  
 	var mySrc ="/path/reports/StatementOfAccountMaint_initialize";
  
   var params   = {"reportsCO.branchesVO.BRANCH_CODE":myObject["branchCode"],"reportsCO.amfVOFrom.BRANCH_CODE":myObject["branchCode"],
				   "reportsCO.amfVOTo.BRANCH_CODE":myObject["branchCode"],"reportsCO.amfVOFrom.CURRENCY_CODE":myObject["currencyCode"],
				   "reportsCO.amfVOTo.CURRENCY_CODE":myObject["currencyCode"],"reportsCO.amfVOFrom.GL_CODE":myObject["glCode"],
				   "reportsCO.amfVOFrom.CIF_SUB_NO":cifNo,"reportsCO.amfVOTo.CIF_SUB_NO":cifNo,
				   "reportsCO.amfVOTo.GL_CODE":myObject["glCode"],"reportsCO.amfVOFrom.SL_NO":myObject["slNo"],
				   "reportsCO.amfVOTo.SL_NO":myObject["slNo"],_pageRef:_pageRef,_type:'GLBV',iv_crud:'R'};
             
  var currentAppName = 'RET';
  var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
  var iFrameParam = {};
  iFrameParam["destinationProgRef"] = "R108T";
  iFrameParam["appName"] = currentAppName;
  iFrameParam["destinationUrl"] = mySrc;
  iFrameParam["additionalParams"] = JSON.stringify(params); 
  
  dashStatementAccDiv.dialog( {
		    modal : true,
		    title:"Statement of Account",
		    autoOpen : false,
		    position : 'center',
		    height : returnMaxHeight(501),
		    width : returnMaxWidth(1023),
		    close : function() {
		      $("#statementOfAccDiv_id_"+_pageRef ).dialog("destroy");
		      $("#statementOfAccDiv_id_"+_pageRef ).remove();
		    },
		    open : function() {
		    }
		  });

  $(dashStatementAccDiv).load(iFrameUrl,iFrameParam,
      function() 
      {
        $("#statementOfAccDiv_id_"+_pageRef ).dialog("open");
      });      
		 
		 
		 
	 }
	 else
	 {
		_showErrorMsg(msg_noRecordSelectedLabel,error_msg_title)	 
	 }
	

}*/



function dashShowAccDtlStat()
{
	var $table = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	if (selectedRowId != null && typeof selectedRowId != "undefined" && selectedRowId != "")
	{
		var myObject = $table.jqGrid('getRowData', selectedRowId);
		var cifNo = $("#lookuptxt_cif_no_" + _pageRef).val();
		var statementOfAccDiv = $("<div id='statementOfAccDiv_id_" + _pageRef + "' style='width:" + returnMaxWidth(1023) + ";height:" + returnMaxHeight(501) + ";border:0px;overflow:auto;'/>");
		var theForm = $("#dashboardFormId");
		var dashStatementAccDiv = $(statementOfAccDiv);
		theForm.append(dashStatementAccDiv);
		dashStatementAccDiv.insertAfter(theForm);

		var srcURL = jQuery.contextPath +"/path/reports/StatementOfAccountMaint_initialize";

		var srcParam = {
			"reportsCO.branchesVO.BRANCH_CODE" : myObject["branchCode"],
			"reportsCO.amfVOFrom.BRANCH_CODE" : myObject["branchCode"],
			"reportsCO.amfVOTo.BRANCH_CODE" : myObject["branchCode"],
			"reportsCO.amfVOFrom.CURRENCY_CODE" : myObject["currencyCode"],
			"reportsCO.amfVOTo.CURRENCY_CODE" : myObject["currencyCode"],
			"reportsCO.amfVOFrom.GL_CODE" : myObject["glCode"],
			"reportsCO.amfVOFrom.CIF_SUB_NO" : cifNo,
			"reportsCO.amfVOTo.CIF_SUB_NO" : cifNo,
			"reportsCO.amfVOTo.GL_CODE" : myObject["glCode"],
			"reportsCO.amfVOFrom.SL_NO" : myObject["slNo"],
			"reportsCO.amfVOTo.SL_NO" : myObject["slNo"],
			_pageRef : _pageRef,
			_type : 'GLBV',
			iv_crud : 'R'
		};
		
		$("#statementOfAccDiv_id_"+_pageRef).load(srcURL, srcParam, function() {
			$("#statementOfAccDiv_id_"+_pageRef).dialog({modal:true, 
			                                title: "Statement of Account",
			                                autoOpen:false,
			                                resizable: true,
			                                position:'center', 
			                     			height : returnMaxHeight(600),
			                    			width : returnMaxWidth(900),
			                    			close : function()
			                    			{
			                    				$("#statementOfAccDiv_id_" + _pageRef).dialog("destroy");
			                    				$("#statementOfAccDiv_id_" + _pageRef).remove();
			                    			},
			                    			open : function()
			                    			{
			                    			}
		                          });
			$("#statementOfAccDiv_id_"+_pageRef).dialog("open");
			_showProgressBar(false);
		});
	}
	else
	{
		_showErrorMsg(msg_noRecordSelectedLabel, error_msg_title)
	}
}


/**
 * 
 * @param {Object}
 *            cellValue
 * @param {Object}
 *            options
 * @param {Object}
 *            rowObject
 * @return {TypeName}
 */

function dashShowAccDtlSign()
{
	 var $table        = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	 var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	 if(selectedRowId != null && typeof selectedRowId != "undefined" && selectedRowId !="")
	 {	        		
		 var myObject = $table.jqGrid('getRowData', selectedRowId);
		 var signatureParams = {};
		 var cifNo  = $("#lookuptxt_cif_no_"+_pageRef).val();
		 
		 signatureParams["signatureSC.branchCode"] 	     = myObject["branchCode"];
		 signatureParams["signatureSC.currencyCode"]     = myObject["currencyCode"];
		 signatureParams["signatureSC.signatureTp"]      = 'A';
		 signatureParams["signatureSC.readOnly"]         = "true";
		 signatureParams["signatureSC.cifNo"] 		     = cifNo;	
		 signatureParams["signatureSC.glCode"]           = myObject["glCode"];
		 signatureParams["signatureSC.slNo"]             = myObject["slNo"];
		 signatureParams["signatureSC.parentPageStatus"] = "P";
		 signatureParams["signatureSC.screenName"]        = "DASHBOARDSCRN";
//         signatureParams["signatureSC.signatureTp"] 	 = 'C';
		 signatureParams["_pageRef"] 					 = _pageRef;
		 populateSignaturePopup("dashboardFormId",signatureParams);
	 }
	 else
	 {
		 _showErrorMsg(msg_noRecordSelectedLabel,error_msg_title)	 
	 }
}


//917789 - DBU191081  
function dashboard_afterCifDependencyAfterConfirm(confirm,args)
{
  var fromGridView = args.fromGridView;
  if(confirm)
  {
      dashboard_afterCifDependency(fromGridView, true);
  }
  else
  {
      dashboard_afterCifDependency(fromGridView, false);
  }
}




/**
 * after CIF Selection 
 */
function dashboard_afterCifDependency(fromGridView, parentCif)
{
	$("#subDetailDiv_"+_pageRef).html("");
	$("#subDetailDiv2_"+_pageRef).html("");

	$("#detailDiv_"+_pageRef).html("");
	var ivCrud = $("#iv_crud_"+_pageRef).val();
	var cifNo  = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	$("#cardReaderCivilID_"+_pageRef).val(""); //BMOI130009
    var params = {_pageRef:_pageRef,cif_no:cifNo,loginTypeByBr:loginTypeByBr,parentCif:parentCif}
	var actionSrc = jQuery.contextPath+"/path/globalview/dashboardMainData?iv_crud=R";
	if(cifNo != null && cifNo != undefined && cifNo != "")
    {
		_showProgressBar(true, null, null, "DASH_CIF_PROGRESSBAR");
		$.post(actionSrc
			   ,params
		       ,function( param )
	 	        {
					  //TP 238142;George Eapen;07/11/2014 Fix for hanging issue if permission not there 
					 _showProgressBar(false, null, null, "DASH_CIF_PROGRESSBAR");
			    	 if(typeof param == "object")
			    	 {
			    		 //added by abbas for Bug#682992
			    		 $("#loginType_" + _pageRef).attr("disabled", false);
				 			if(typeof param["_error"] != "undefined" && param["_error"] != null)
							{
			    			 _showErrorMsg(param._error,error_msg_title)
							}
				 			
				    		//917789 - DBU191081  	 
				    		 if (typeof param["_confirm"] != "undefined" && param["_confirm"] != null)
				    		 {
	                        
	                            
	                            _showConfirmMsg(param["_confirm"],confirm_msg_title,"dashboard_afterCifDependencyAfterConfirm",{fromGridView:fromGridView });
	                            return;
				    		 }
			    	 }
			    	 else
			    	 {
			    		 $("#mainDivId_"+_pageRef).css("display","inline");
					     $("#detailDiv_"+_pageRef).css("display","none");
					     $("#detailDiv_"+_pageRef).html("");
			        	 $("#mainDivId_"+_pageRef).html(param);
			        	 
			        	 var assetsLiabList        = $("#assetsLiabList_"+_pageRef).val();
			        	 var finAppAndAppList      = $("#finAppAndAppList_"+_pageRef).val();
			        	 var financeDealsList      = $("#financeDealsList_"+_pageRef).val();
			        	 var investAndTreasuryList = $("#investAndTreasuryList_"+_pageRef).val();
			        	 
			        	  /**
			        	  * Elie Achkar TFA
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 var tradeFinanceList	   = $("#tradeFinanceList_"+_pageRef).val();
			        	 var tradeFinanceJson	   = $.parseJSON(tradeFinanceList);
			        	 
			        	 var assetsLiabJson        = $.parseJSON(assetsLiabList);
			        	 var finAppAndAppJson      = $.parseJSON(finAppAndAppList);
			        	 var financeDealsJson      = $.parseJSON(financeDealsList);
			        	 
			        	 /**
			        	  * for access right
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 var investAndTreasuryJson = $.parseJSON(investAndTreasuryList);
						 var totalAssLiabOpt    = $("#totalAssLiabOpt_"+_pageRef).val();
						 var finAppAprLineOpt   = $("#finAppAprLineOpt_"+_pageRef).val();
						 var financingDealsOpt  = $("#financingDealsOpt_"+_pageRef).val();
						 var investmentsOpt     = $("#investmentsOpt_"+_pageRef).val();

			        	 /**
			        	  * fill assets and Liability grid data
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 
			        	 if(totalAssLiabOpt == "true")
			        		 {			        		 
			        	       dash_fillGridData("assetsLiabAccGridTbl_Id_",assetsLiabJson);
			        		 }
			        	
			        	 /**
			        	  * fill financing application, approved lines and trade finance operations
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 if(finAppAprLineOpt == "true")
			        		 {			        		 
			        	       dash_fillGridData("finAppAndAprvdLinesGridTbl_Id_",finAppAndAppJson);
			        	       // Elie Achkar added TFA grid
			        	       dash_fillGridData("tradeFinanceOperationsGridTbl_Id_",tradeFinanceJson);

			        		 }
			        	 
			        	 /**
			        	  * fill financing Deals Grid Data 
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 if(financingDealsOpt == "true")
			        		 {			        		 
			        	       dash_fillGridData("financingDealsGridTbl_Id_",financeDealsJson);
			        		 }
			        	 
			        	 /**
			        	  * fill investments & treasury Grid Data ...
			        	  * @param {Object} gridId
			        	  * @param {Object} jsonStr
			        	  */
			        	 if(investmentsOpt == "true")
			        		 {
			        	       dash_fillGridData("investTreasuryGridTbl_Id_",investAndTreasuryJson);			        		 
			        		 }
			       	 }
			    	 if(fromGridView != "1")
			    	 {
			    		 $("#assetsLiabAccDivId_"+_pageRef).html("");
			    		 plotBarChart();
			    		 plotFinancingApplicationsBarChart();
                     	 // Elie Achkar added grid plotting call
	                     plotTFABarChart();
	                     plotFinancingDealsChart();
	                     plotInvestmentAndTreasuryChart();
				    	 // hide print button if not from grid view
						 $("#print_grid_btn_" + _pageRef).hide();
                     }
			    	 else
			    	 {
			    		 // show print button if from grid view
			    		 $("#print_grid_btn_" + _pageRef).show();
			    	 }
			    	 //added by abbas for Bug#682992
		    		 $("#loginType_" + _pageRef).attr("disabled", false);

			          
		    	 }
		       );  
		 var width = $(window).width();
		
		  $("#assetsLiabAccDivId_"+_pageRef).width(width);
		    $("#finAppAppLinesDivId_"+_pageRef).width(width);
		    $("#tradeFinanceOperationsDivId_"+_pageRef).width(width);
		    $("#financingDealsDivId_"+_pageRef).width(width);
		    $("#invstTreasuryDivId_"+_pageRef).width(width);
		    
    }
    else
    {
       $("#mainDivId_"+_pageRef).html("");
       $("#detailDiv_"+_pageRef).html("");
    }
	
}

/**
 * fill the grid data from a json string returned from the action 
 * @param {Object} gridId
 * @param {Object} jsonStr
 */
function dash_fillGridData(gridId,jsonStr)
{	
	
	 for(var i=0;i<jsonStr.length;i++)
	 {		 
		 // To empty the dues and overdrawn amounts in assets row 
		 if(jsonStr[i].duesAssetLiablAmt == 0 && jsonStr[i].category == "Assets")
			 {
  			   jsonStr[i].duesAssetLiablAmt=null;
			 }
		 if(jsonStr[i].overdrawLimit == 0 && jsonStr[i].category == "Assets" )
			 {
  			   jsonStr[i].overdrawLimit=null;
			 }
		jQuery("#"+gridId+_pageRef).jqGrid('addRowData',i+1,jsonStr[i]);
	 }
}
/**
 * on hyperlink click
 */
function dashboard_onBackClicked()
{
   if ($("#subDetailDiv_"+_pageRef).text().length > 0) 
   {
     	$("#detailDiv_"+_pageRef).show('slide');
     	$("#subDetailDiv_"+_pageRef).html("");
    	$("#subDetailDiv2_"+_pageRef).html("");

     	$("#subDetailDiv_"+_pageRef).css("display","none");
     	 setTimeout(resizeGrids, 210);
     	return;
   }
  $("#detailDiv_"+_pageRef).html("");
  $("#detailDiv_"+_pageRef).css("display","none");
  $("#mainDivId_"+_pageRef).show('slide');
   setTimeout(resizeGrids, 210);
 

}	
/**
 * to load profile detail in save new mode
 */
function dashboard_onLinkClicked(screenName)
{
  var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
  var loginTypeByBr = $("#loginType_"+_pageRef).val();
  var mySrc = "";
  var params = {cif_no:cifNo, _pageRef:_pageRef,loginTypeByBr:loginTypeByBr};
  _showProgressBar(true);
  switch(screenName)
  {
    case "safeboxes":
	     mySrc = jQuery.contextPath+"/path/globalview/safeboxesLoadAction";
	     break;
    case "cards":
		 mySrc = jQuery.contextPath+"/path/globalview/cardsLoadAction";
		 break;
    case "chequebooks":
		 mySrc = jQuery.contextPath+"/path/globalview/chequebooksLoadAction";
		 break;
    case "passbooks":
		 mySrc = jQuery.contextPath+"/path/globalview/passbooksLoadAction";
		 break;
    case "lostDocuments":
		 mySrc = jQuery.contextPath+"/path/globalview/dashLostDocsLoadAction";
		 break;
	case "smsSubscriptions": //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen
		 mySrc = jQuery.contextPath+"/path/globalview/dashboardSmsSubscriptionLoadAction";
		 break;	 
    case "bankersCheques":
		 mySrc = jQuery.contextPath+"/path/globalview/dashBankersChequesLoadAction";
		 break;
    case "voidedCheques":
		 mySrc = jQuery.contextPath+"/path/globalview/dashVoidedChequesLoadAction";
		 break;
    case "chequesForCol":
		 mySrc = jQuery.contextPath+"/path/globalview/dashChequesForColLoadAction";
		 break;
    case "postDatedChqWDrawal":
		 mySrc = jQuery.contextPath+"/path/globalview/dashPostDatedChqWDrawalLoadAction";
		 break;
    case "postDatedChqDep":
		 mySrc = jQuery.contextPath+"/path/globalview/dashPostDatedChqDepLoadAction";
		 break;
	
	case "remittances":
		 mySrc = jQuery.contextPath+"/path/globalview/dashRemittancesLoadAction";
		 break;
	case "specialConditions":
		 mySrc = jQuery.contextPath+"/path/globalview/dashSpecialCondLoadAction";
		 break;
	case "authorizedSig":
		 mySrc = jQuery.contextPath+"/path/globalview/dashAuthorizedSigLoadAction";
		 break;
	case "links":
		 mySrc = jQuery.contextPath+"/path/globalview/dashLinksLoadAction";
		 break;
	case "standingOrder":
		 mySrc = jQuery.contextPath+"/path/globalview/dashSOLoadAction";
		 break;
	case "memos":
		 mySrc = jQuery.contextPath+"/path/globalview/dashMemosLoadAction";
		 break;
		 
	case "inOutLC":
		 mySrc = jQuery.contextPath+"/path/globalview/dashInOutLCLoadAction";
		 break;
	case "lg":
		 mySrc = jQuery.contextPath+"/path/globalview/dashLGLoadAction";
		 break;
	case "inOutBills":
		 mySrc = jQuery.contextPath+"/path/globalview/dashInOutBillsLoadAction";
		 break;
	case "acceptance":
		 mySrc = jQuery.contextPath+"/path/globalview/dashAcceptanceLoadAction";
		 break;
	
	case "fmsApprovedLines":
		 mySrc = jQuery.contextPath+"/path/globalview/fmsApprovedLineDetailsListAction_showFMSApprovedLinesData";
		 break;
		 
	case "fmsCollaterals":
		 mySrc = jQuery.contextPath+"/path/globalview/fmsCollateralDetailsListAction_showFMSCollateralsGrid";
		 break;
	
	case "fmsGuarantees":
		 mySrc = jQuery.contextPath+"/path/globalview/fmsGuarantorDetailsListAction_showFMSGuarantorGrid";
		 break;
		 
	case "fmsNewApp":
		 mySrc = jQuery.contextPath+"/path/globalview/fmsNewAppDetailsListAction_showFMSNewAppGrid";
		 break;
		 
	case "fmsSuspendedFacility":
		 mySrc = jQuery.contextPath+"/path/globalview/fmsSuspendedFacilityDetailsListAction_showFMSSuspendedFacilityGrid";
		 break;
		 
	case "investments":
		 mySrc = jQuery.contextPath+"/path/globalview/dashInvestmentsLoadAction";
		 break;
		 
	default:
		 break;
  }
  $("#subDetailDiv_"+_pageRef).html("");
	$("#subDetailDiv2_"+_pageRef).html("");

  $("#subDetailDiv_"+_pageRef).css("display","none");
  $("#mainDivId_"+_pageRef).css("display","none");
  $("#detailDiv_"+_pageRef).html('');
  $("#detailDiv_"+_pageRef).load(mySrc,params,function(){_showProgressBar(false);});
  $("#detailDiv_"+_pageRef).show('slide');
}
// Temp Method for handling Phase 2 screen click Event
function dashboard_Phase2onLinkClicked(screenName)
{
	switch(screenName)
    {
    	case "fmsDrawDowns":
    		alert('Phase 2 Task');
		default:
		 	break;
	}
}
function formatAprvdLinesLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'fmsApprovedLines'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}
function formatCollateralsLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'fmsCollaterals'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}
function formatGuaranteesLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'fmsGuarantees'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}

function formatDrawDownsLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_Phase2onLinkClicked(' + "'fmsDrawDowns'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}
function formatSuspendedFacilityLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'fmsSuspendedFacility'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}
function formatNewAppLink(cellValue, options, rowObject) {
	
		return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'fmsNewApp'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
}

function fmsFacilityVO_CODE_Formatter(cellValue, options, rowObject) 
{
	var curName  = "'"+rowObject.currencyDesc+"'";
	return '<a href ="#" onclick= "javascript:loadApprovedLinesFacilityDetailList(' + rowObject.fmsFacilityVO.BRANCH+','+ rowObject.fmsFacilityVO.CODE+','+ rowObject.fmsFacilityVO.CIF+','+ rowObject.fmsFacilityVO.CURRENCY+','+ rowObject.curDecimalPoints+','+ curName
				+ ');">' + cellValue + '</a>';
}	

function loadApprovedLinesFacilityDetailList(branch,facilityCode,cifNo,cyCode,decimalPoint,curName)
{
  var mySrc = jQuery.contextPath+"/path/globalview/fmsApprovedLineDetailsListAction_showFMSApprovedLinesDetailData?dashboardSC.cif_no="+cifNo+"&dashboardSC.branchCode="+branch+"&dashboardSC.facilityCode="+facilityCode+"&fmsCO.curDecimalPoints="+decimalPoint+"&_pageRef="+_pageRef+"&dashboardSC.curName="+curName;
  
  $("#mainDivId_"+_pageRef).css("display","none");
  $("#detailDiv_"+_pageRef).css("display","none");
  $("#subDetailDiv_"+_pageRef).html("");
	$("#subDetailDiv2_"+_pageRef).html("");

  $("#subDetailDiv_"+_pageRef).load(mySrc);
  $("#subDetailDiv_"+_pageRef).show('slide');
	
}

function formatInOutLCLink(cellValue, options, rowObject) {
	return constructGlobalViewLink(cellValue, options, rowObject, 'inOutLC');
}
function formatLGLink(cellValue, options, rowObject) {
	return constructGlobalViewLink(cellValue, options, rowObject, 'lg');
}
function formatInOutBillsLink(cellValue, options, rowObject) {
	return constructGlobalViewLink(cellValue, options, rowObject, 'inOutBills');
}
function formatAcceptanceLink(cellValue, options, rowObject) {
	return constructGlobalViewLink(cellValue, options, rowObject, 'acceptance');
}

function constructGlobalViewLink(cellValue, options, rowObject, refID) {
	return '<a href ="#" onclick= "javascript:dashboard_onLinkClicked(' + "'" + refID + "'"
				+ ');">' + currencyFmatter(cellValue,options,rowObject) + '</a>';
	
}

function formatLinksGrids(from_cif_Key, to_cif_Key, from_acc_Key, to_acc_Key)
{
	$("#linksListCifCifGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'sLinkCifAmfVO.FROM_CIF', numberOfColumns: 2, titleText: from_cif_Key},{startColumnName: 'sLinkCifAmfVO.TO_CIF', numberOfColumns: 2, titleText: to_cif_Key}
	  	]
	});
 	$("#linksListAccAccGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'sLinkCifAmfVO.FROM_BR', numberOfColumns: 6, titleText: from_acc_Key},{startColumnName: 'sLinkCifAmfVO.TO_BR', numberOfColumns: 6, titleText: to_acc_Key}
	  	]
	});
 	$("#linksListAccCifGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'sLinkCifAmfVO.FROM_BR', numberOfColumns: 6, titleText: from_acc_Key},{startColumnName: 'sLinkCifAmfVO.TO_CIF', numberOfColumns: 2, titleText: to_cif_Key}
	  	]
	});
 	$("#linksListCifAccGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'sLinkCifAmfVO.FROM_CIF', numberOfColumns: 2, titleText: from_cif_Key},{startColumnName: 'sLinkCifAmfVO.TO_BR', numberOfColumns: 6, titleText: to_acc_Key}
	  	]
	});
 }

function formatSOGrid(from_acc_Key, to_acc_Key)
{
	$("#soListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'ctstrsVO.TRS_AC_BR', numberOfColumns: 7, titleText: from_acc_Key},{startColumnName: 'ctstrsVO.TO_TRS_AC_BR', numberOfColumns: 7, titleText: to_acc_Key}
	  	]
	});
 }

function formatRemittancesGrid(from_acc_Key, to_acc_Key)
{
	$("#remittancesListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
		useColSpanStyle: true, 
	  	groupHeaders:[
		{startColumnName: 'ctstrsVO.TRS_AC_BR', numberOfColumns: 7, titleText: from_acc_Key},{startColumnName: 'ctstrsVO.TO_TRS_AC_BR', numberOfColumns: 7, titleText: to_acc_Key}
	  	]
	});
 }


function openPage(src){
  $("#detailDiv_"+_pageRef).html("");
  $("#mainDivId_"+_pageRef).css("display","none");
  $("#detailDiv_"+_pageRef).html('');
  $("#detailDiv_"+_pageRef).load(src);
  $("#detailDiv_"+_pageRef).show('slide');
}

function openSubDivPage(src){
   $("#detailDiv_"+_pageRef).css("display","none");
  $("#subDetailDiv_"+_pageRef).html("");
	$("#subDetailDiv2_"+_pageRef).html("");

  $("#subDetailDiv_"+_pageRef).load(src);
  $("#subDetailDiv_"+_pageRef).show('slide');
}

function financingDealsLink(cellValue, options, rowObject){
	return '<a href ="#" onclick= "javascript:dashboard_financialDealClicked('+"'"+ rowObject.categoryId+"'"+');">' + currencyFmatter(cellValue, options, rowObject) + '</a>';
}

function financingDealsLimitUtilizationLimitAmt(cellValue, options, rowObject){
	return '<a href ="#" onclick= "javascript:dashboard_financingDealFromLimit('+"'L'"+');">' + currencyFmatter(cellValue, options, rowObject) + '</a>';
}

function financingDealsPromissoryNotesLink(cellValue, options, rowObject){
	return '<a href ="#" onclick= "javascript:dashboard_financialDealPromissoryNotesClicked('+"'"+ rowObject.categoryId+"'"+');">' + currencyFmatter(cellValue, options, rowObject) + '</a>';
}

function investmentsDetails(cellValue, options, rowObject){
    return '<a href = "#" onclick="javascript:onCashHoldingShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';//tp id 610138
    //return constructGlobalViewLink(cellValue, options, rowObject, 'investments');
}

//tp id 610138
function onCashHoldingShowlink(selectedRowId)
{
    var cifNo = $("#lookuptxt_cif_no_" + _pageRef).val();
    var cifName = $("#long_name_eng_" + _pageRef).val();   
    var ivCrud = "R";
    
    //added by abbas for Bug#679881
    var loginTypeByBr = $("#loginType_"+_pageRef).val();
    //end abbas
    
    var CashHoldingDiv = $("<div id='cashHoldingDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
    var theForm = $("#dashboardFormId");
    var dashCashHoldingDiv = $(CashHoldingDiv);
    theForm.append(dashCashHoldingDiv);
    dashCashHoldingDiv.insertAfter(theForm);
    
    var params = {'queryPositionCO.cifCode':cifNo,
                          'queryPositionCO.cifName':cifName,     
                          'queryPositionCO.from360':"1", 
                          'queryPositionCO.loginTypeByBr':loginTypeByBr,//added by abbas for Bug#679881
                           '_pageRef':'R001Q',
                           'iv_crud':ivCrud,
                           "isLookUp":"1"
                         };
    
    var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
    var iFrameParams = {};
    iFrameParams["destinationProgRef"] = "R001Q";
    iFrameParams["appName"] = 'PMS';
    iFrameParams["destinationUrl"] = "/path/assets/queryPosition/QueryPosition_loadqueryPositionPage.action";
    iFrameParams["additionalParams"] = JSON.stringify(params);
    
    
    
    dashCashHoldingDiv.dialog( {
           modal : true,
           title : query_position_key,
           autoOpen : false,
           position : 'center',
           height : returnMaxHeight(501),
           width : returnMaxWidth(1023),
           close : function() {
                  $("#cashHoldingDiv_id_"+_pageRef ).dialog("destroy");
                  $("#cashHoldingDiv_id_"+_pageRef ).remove();
           },
           open : function() {
           }
    });

    $(dashCashHoldingDiv).load(iFrameUrl,iFrameParams,
                  function() 
                  {
                        $("#cashHoldingDiv_id_"+_pageRef ).dialog("open");
                  });
}
//tp id 610138


// to be adjusted
function investments_onDbClickedEvent()
{
	var cifNo  = $("#lookuptxt_cif_no_"+_pageRef).val();
	var $table = $("#investmentsListGridTbl_Id_" +_pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var myObject = $table.jqGrid('getRowData', selectedRowId);
	/**
	 * get the selected rowId
	 */
    var params = {cif_no:cifNo,portfolioSeq:myObject["pmsPortfolioTmpVO.PORTFOLIO_SEQ"],branchCode:myObject["pmsPortfolioTmpVO.BRANCH"],_pageRef:_pageRef};
	var mySrc  = jQuery.contextPath+"/path/globalview/dashPrtfCashPosHoldPosLoadAction?";
	
	$("#mainDivId_"+_pageRef).css("display","none");
    $("#detailDiv_"+_pageRef).css("display","none");
    $("#subDetailDiv_"+_pageRef).html("");
	$("#subDetailDiv2_"+_pageRef).html("");

    $("#subDetailDiv_"+_pageRef).load(mySrc,params);
    $("#subDetailDiv_"+_pageRef).show('slide');

}

function treasuryDerivativesDetails(cellValue, options, rowObject){
	return '<a href ="#" onclick= "javascript:dashboard_treasuryDerivativesDetails();">' + currencyFmatter(cellValue,options, rowObject) + '</a>';
}


function dashboard_treasuryDerivativesDetails(){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/treasuryListAction_loadTreasuryDerivativesGrid?treasurySC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&treasurySC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);
	openPage(src);
	
}
function dashboard_financialDealClicked(category){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	if(category=="LU"){
		src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsLimitUtilizationGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category="+category+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);
		}	
	else{
	 	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsByProductGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category="+category+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);
	 	}
	openPage(src);
}

function treasuryMoneyMarketDetails(cellValue, options, rowObject){
	return '<a href ="#" onclick= "javascript:dashboard_treasuryMoneyMarketClicked();">' + currencyFmatter(cellValue,options, rowObject) + '</a>';
}

function dashboard_treasuryMoneyMarketClicked(){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsByProductGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category=L&financingDealsSC.appName=ITRS&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);	 	
	openPage(src);

}
function dashboard_financingDealFromLimit(category){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsByProductGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category="+category+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);
	openSubDivPage(src);
}

function dashboard_financialDealRepaymentPlanClicked(dealNo,prodClassCode,dealType,branchCode){
	if(dealType==1||dealType==2||dealType==13||dealType==17){
		_showErrorMsg(Repayment_Plan_details_not_available_key);
		return;
	}
	 
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsRepaymentPlanHeaderDtls?financingDealsSC.cifNo="+cifNo+"&financingDealsSC.dealNo="+dealNo+"&financingDealsSC.prodClassCode="+prodClassCode+"&_pageRef="+_pageRef+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr)+"&financingDealsSC.branchCode="+branchCode;
	openSubDivPage(src);
}

function dashboard_financialDealGuarantorClicked(dealNo,branchCode){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsGuarantorGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.dealNo="+dealNo+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr)+"&financingDealsSC.branchCode="+branchCode;
	openSubDivPage(src);
}

function dashboard_financialDealCollateralClicked(dealNo,branchCode){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsCollateralGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.dealNo="+dealNo+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr)+"&financingDealsSC.branchCode="+branchCode;
	openSubDivPage(src);
}

function dashboard_financialDealDetailsClicked(dealNo,branchCode,appName) {

	var iv_crud = "Q";
	var financialDealDetailsDiv = $("<div id='financialDealDetailsDiv_id_"
			+ _pageRef + "' style='width:" + returnMaxWidth(1023) + ";height:"
			+ returnMaxHeight(501) + ";border:0px;overflow:hidden;'/>");

	var theForm = $("#dashboardFormId");
	var dashfinancialDealDetailsDiv = $(financialDealDetailsDiv);
	theForm.append(dashfinancialDealDetailsDiv);
	dashfinancialDealDetailsDiv.insertAfter(theForm);

	var mySrc = "/path/iis/investmentDeals/InvestmentDealsMaint_edit";

	var params = {
		"serialNo" : dealNo,
		"iv_crud" : iv_crud,
		"selectedBranchCode" : branchCode,
		"_pageRef" : "T02Q",
		"screenOption" : "1",
		"calledFrom360":"Y"
	};

	var currentAppName = 'IIS';
	if(appName!=null && appName != undefined && appName != "undefined" && appName !="")
	{
		currentAppName = appName;
	}

	var iFrameUrl = jQuery.contextPath + '/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "T02Q";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);

	dashfinancialDealDetailsDiv.dialog( {
		modal : true,
		title : Deal_Details_key,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#financialDealDetailsDiv_id_" + _pageRef).dialog("destroy");
			$("#financialDealDetailsDiv_id_" + _pageRef).remove();
		},
		open : function() {
		}
	});

	$(dashfinancialDealDetailsDiv).load(iFrameUrl, iFrameParam, function() {
		$("#financialDealDetailsDiv_id_" + _pageRef).dialog("open");
	});

}

function dashboard_financialDealPromissoryNotesClicked(category){
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var loginTypeByBr = $("#loginType_"+_pageRef).val();
	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadFinancingDealsPromissoryNotesGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category="+category+"&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);	 	
	openPage(src);
	
}


function calcFinancingDealsRepaymentPlanTotal(response,html){	
		var gridModel = response.originalEvent.request.gridModel;
		if(gridModel!=undefined&&gridModel.length>0){			
			nbFormat = returnNbFormat(gridModel[0].currDecimalPoints)			 
			var grid = $("#financingDealsRepaymentDtlsGridTbl_Id_" + _pageRef);
			grid.jqGrid('footerData', 'set', {"paymentType" : Total_Amount_key,}, false);
			grid.jqGrid('footerData', 'set', {"amount" :	$.formatNumberNumeric(grid.jqGrid('getCol', 'amount', false, 'sum'), {format: nbFormat,applyRounding:true}) }, false);		
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.CAPITAL_AMT" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.CAPITAL_AMT', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.TRSPAYPLANDET_PROFIT_AMT_BEFORE_XIRR" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.TRSPAYPLANDET_PROFIT_AMT_BEFORE_XIRR', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"settlementAmount" : $.formatNumberNumeric(grid.jqGrid('getCol', 'settlementAmount', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedActiveSettlementAmt" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedActiveSettlementAmt', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedRemainingAmt" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedRemainingAmt', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.REIMBURSED_PROFIT" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.REIMBURSED_PROFIT', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"trsPayPlanDetVO.RESERVE_AMOUNT" : $.formatNumberNumeric(grid.jqGrid('getCol', 'trsPayPlanDetVO.RESERVE_AMOUNT', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedAmtReceived" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedAmtReceived', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedIncidentalCost" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedIncidentalCost', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedAdvInsurance" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedAdvInsurance', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
			grid.jqGrid('footerData', 'set', {"computedTotalInstallment" : $.formatNumberNumeric(grid.jqGrid('getCol', 'computedTotalInstallment', false, 'sum'), {format: nbFormat,applyRounding:true})}, false);
		}
}

var allSecuritiesCharts;
var prtflPosSummaryCharts;

function onLoadInvestmentCharts()
{
	drawInvestmentsGrids("bookValueChart", $("#bookValueList_"+_pageRef).val());
	drawInvestmentsGrids("marketValueChart", $("#marketValueList_"+_pageRef).val());
}

function onLoadPortfolioPositionCharts()
{
	$("#lookuptxt_securities_"+_pageRef).attr('readonly', true);
	allSecuritiesCharts = drawDashAllSecuritiesGrid("allSecuritiesChart", $("#allSecuritiesList_"+_pageRef).val());
	prtflPosSummaryCharts = drawInvestmentsGrids("prtflPosSummaryChart", $("#prtflPosSummaryList_"+_pageRef).val());
}

function readJsonDataForPieCharts(valueAmountJson)
{
	var arr = [];
	var theName, theAmount;
	var valid = false;
	
	for (i=0; i<valueAmountJson.length;i++)
  	{
  		theName = valueAmountJson[i].name;
  		theAmount = valueAmountJson[i].value;
		arr.push([theName, theAmount]);
		if (theAmount > 0 )
			valid = true;
	}
	if(valid)
	return arr;
	return null;
}

function plotPieChart(gridName, arr,decPoint,colors)
{
	/*jQuery.jqplot (gridName, [arr],
    {
      	seriesDefaults: {
        	// Make this a pie chart.
			renderer: jQuery.jqplot.PieRenderer,
			rendererOptions: {
  			// Put data labels on the pie slices.
  			// By default, labels show the percentage of the slice.
      		showDataLabels: true,
      		dataLabelFormatString: '%.4g%'
    		}
  		},
  		legend: { show:true, location: 's' }
    });*/
	
	
	 
	if(arr == null)
	{
		$("#"+gridName).append(No_Data_Found_key);
	}
	else
	{
		 
			if(colors==undefined){
				colors =  ['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1']
				
			}
			Highcharts.getOptions().plotOptions.pie.colors = colors
			var pieName = $("#"+gridName).attr("chartName");
		     var thisChart = new Highcharts.Chart({
		    chart: {
		        renderTo: gridName,
		        type: 'pie',
		        reflow: true,		        
		
		    },
		    title: {
		        text: pieName
		    },
		
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            size: 150,
		            shadow: true,
		       
		            
		            
		        dataLabels: {
		    		
		            //color: 'red',
		            //borderColor: 'black',
		            //borderWidth: 2,
		            //distance: 30,
		            //useHTML: true,
		    		enabled: true,
		                        style: {
		                            width: '30%'
		                        },
		    		//color: '#000000',
		    		//connectorColor: '#000000',
		                   //format: '<b>{point.name}</b>: <br/> {point.percentage:.1f} %'
		           formatter: function () {
		    							var result;
		    						if(this.y > 5)
		                   				{
		    							result ='<span style="color:' + this.point.color + '">' + 
		    							this.point.name +'-'+this.point.percentage.toFixed(2) + '%'+ '<br/>' + 
		    							'<span style="color:' + this.point.color + ' + ">' + 
		    							$.formatNumberNumeric(this.point.y, {format: returnNbFormat(decPoint)} )+ '</span>'
		    							}
		                   			else
		                   				result = null
		                   			return result
		    						}
		                            
		        },
		                    showInLegend: false
		        }
		    },
		     credits: 
              {
                 enabled: false
              },
		    tooltip: {
		        valueSuffix: '',
		        formatter: function () {		         
		            return  '<span style="color:' + this.point.color + '">' + 
		    							this.point.name +':'+this.point.percentage.toFixed(2) + '%'+ '<br/>' + 
		    							'<span style="color:' + this.point.color + ' + ">' + 
		    							$.formatNumberNumeric(this.point.y, {format: returnNbFormat(decPoint)} )+ '</span>'
		        }
		    },
		    series: [{
		            type: 'pie',
		        //name: 'Profit/Principal',
		        data: arr,
		        //size: '50%',
		        //dataLabels: {
		          //  color: 'red',
		            //distance: 40,
		            //connectorColor: 'red',
		            //formatter: function () {
		           //     return this.y > 5 ? this.point.name + '<br/>' + this.point.y : null;
		         //   }
		       // }
		    }]
		});
	}
}

function checkAndDrawChart(gridName, valueAmount)
{
	arr = readJsonDataForPieCharts(valueAmount);
	return plotPieChart(gridName, arr,$("#queryPositionCO_baseCYDecPoints_"+_pageRef).val())//BUG 468114	
}

function drawInvestmentsGrids(gridName, valueAmount)
{
  	var arr = [];
  	var valueAmountJson = $.parseJSON(valueAmount);
    
  	if (!$.isEmptyObject(valueAmountJson) && valueAmountJson.length > 0)
  	{
  		arr = readJsonDataForPieCharts(valueAmountJson);

  		if (gridName == "bookValueChart" || gridName == "marketValueChart")
  		{
  			checkAndDrawChart(gridName, valueAmountJson);
  		}
  		else if (gridName == "prtflPosSummaryChart")
  		{
  			if (prtflPosSummaryCharts != undefined)
  			{
  				prtflPosSummaryCharts.replot({data: [arr]});
  			}
  			else
  			{
  				prtflPosSummaryCharts = checkAndDrawChart(gridName, valueAmountJson);
  			}
  		}
  	}
  	else
  	{
  		$("#"+gridName).text(No_Data_Found_key);
  	}
}

function readAmountDataForBarCharts(valueAmountJson)
{
	var arr1 = [];
	var theDate, theAmount;
	
	for (i=0; i<valueAmountJson.length;i++)
  	{
		theDate = valueAmountJson[i].trsDate;
		
		var now = new Date(theDate.substr(0,10));
		var now_utc = new Date(now.getUTCFullYear(), now.getUTCMonth(), now.getUTCDate(),  now.getUTCHours(), now.getUTCMinutes(), now.getUTCSeconds());

  		theAmount = valueAmountJson[i].value;
		arr1.push([now_utc, theAmount]);
	}
	
	return arr1;
}

function readMarketDataForBarCharts(valueAmountJson)
{
	var arr2 = [];
	var theDate,  theMarket;
	
	for (i=0; i<valueAmountJson.length;i++)
  	{
		theDate = valueAmountJson[i].trsDate;
		
		var now = new Date(theDate.substr(0,10));
		var now_utc = new Date(now.getUTCFullYear(), now.getUTCMonth(), now.getUTCDate(),  now.getUTCHours(), now.getUTCMinutes(), now.getUTCSeconds());

  		theMarket = valueAmountJson[i].market;
		arr2.push([now_utc, theMarket]);
	}
	return arr2;
}
function readJsonDataForBarCharts(valueAmountJson)
{
	var arr1 = [];
	var arr2 = [];
	var theDate, theAmount, theMarket;
	
	for (i=0; i<valueAmountJson.length;i++)
  	{
		theDate = valueAmountJson[i].trsDate;
  		theAmount = valueAmountJson[i].value;
  		theMarket = valueAmountJson[i].market;
		arr1.push([theDate, theAmount]);
		arr2.push([theDate, theMarket]);
	}
	return [arr1, arr2];
}
function drawDashAllSecuritiesGrid(gridName, valueAmount)
{
	var arr = [,];
  	var valueAmountJson = $.parseJSON(valueAmount);
  	
  	
 	//added by rany for bugid:468118
    var runningDate = $("#queryPositionCO_positionAsOfDate_" + _pageRef).val();
  	var monthNames = [January_key, February_key, March_key,April_key, May_key, June_key, July_key, August_key, September_key, October_key, November_key, December_key];
  	var monthIndex  = runningDate.substring(3,5);
	var month = monthNames[monthIndex - 1];//-1 bcz the index is [0-11]
	//end rany
  	
  	
  	if (!$.isEmptyObject(valueAmountJson) && valueAmountJson.length > 0)
  	{
  		if (gridName == "allSecuritiesChart")
  		{

  		/*		allSecuritiesCharts = $.jqplot(gridName, readJsonDataForBarCharts(valueAmountJson), {
  					axes:{
  						xaxis:{
  						renderer:$.jqplot.DateAxisRenderer, 
  						tickRenderer: $.jqplot.CanvasAxisTickRenderer,
			        	tickOptions: {  angle: -90, formatString:'%Y-%m-%d'},
  						tickInterval:'1 week'
  					}
  					},
      highlighter: {
        show: true,
        sizeAdjust: 7.5
      },
      cursor: {
        show: false
      },
  					series:[{lineWidth:4, markerOptions:{style:'square'}}]
  				});*/

  			allSecuritiesCharts = new Highcharts.Chart(
  				{
  				chart:
  				{
	  				type: 'spline',
	  				renderTo: gridName
  				},
  				plotOptiopns:{
  					spline:{
            			size: '100%',  					
  					}
  				},
  				title:
  				{
  					text: ''
  				},
  				xAxis:
  				{
                	type: 'datetime',
                	dateTimeLabelFormats:
                	{
                		day:'%e of '+ month //modified by rany for bugid:468118,it was: (day: '%e of %b') since %b return the current month and not the running date of the app.
                    	//month: '%e. %b',
                    	//year: '%b'
                	}
            	},
            	yAxis:
            	{
                	title:
                	{
                    	text: ''
                	},
                	min: 0
            	},
           		tooltip:
           		{
                	formatter: function() 
                	{
                		 return Highcharts.dateFormat('%e of ' + month, this.x) +': '+ this.y; //modified by rany for bugid:468118,it was:('%e of %b')
                	}
            	},
            
            	series:
            		[
            			{
			            	id: 'Amount',
			            	//added the key by bahaa for #BUG 718390            		
			                name: amount_key,
			                //data: readAmountDataForBarCharts(valueAmountJson),
			                pointInterval: 24 * 3600 * 1000
                          
            			},
            			{
			            	id: 'Market',
			                name: market_key,//bug 718390
			                //data: readMarketDataForBarCharts(valueAmountJson),
			                pointInterval: 24 * 3600 * 1000
            			}
            		],
        		credits: {
			      enabled: false
			  			}
  				});
  				
  		}
		if (allSecuritiesCharts != null && allSecuritiesCharts != undefined)
  			{
			allSecuritiesCharts.series[0].setData(readAmountDataForBarCharts(valueAmountJson), true);
			allSecuritiesCharts.series[1].setData(readMarketDataForBarCharts(valueAmountJson), true);
  			}
  	}
  	else
  	{
  		$("#"+gridName).text(No_Data_Found_key);
  	}
  	return allSecuritiesCharts;
}

// Libin added to apply dynamic height to FMS Grids based on no. of records
function giveDynamicHeightToFMSGrids()
{
	var origGridHeight = $(this).height();
	var gridId = $(this).attr('id');
	var gridDivSelector = "gview_" + gridId;
	var recCount = $(this).jqGrid('getGridParam', 'records');
	var screenGridHeight = $("#"+gridDivSelector+" > .ui-jqgrid-bdiv").height();
	if(origGridHeight<screenGridHeight)
	{
		$("#"+gridDivSelector+" > .ui-jqgrid-bdiv").height(origGridHeight+15);// Libin added 10 to accomodate Scroll size(if scroll comes)
	}
}

function dashboard_drawGridOnHoldingBySecurityChange()
{
	var selectedHolding = $("#holdingBySecurity_"+_pageRef).val();
	var cifNo           = $("#cifNo_"+_pageRef).val();//$("#lookuptxt_cif_no_"+_pageRef).val(); changed by bahaa for TP# 1042048
	var portfolioSeq    = $("#portfolioSeq_"+_pageRef).val();
	var branchCode      = $("#branchCode_"+_pageRef).val();
	//added by rany for bugid:496097    
	 var asOfDate         = $("#queryPositionCO_positionAsOfDate_"+_pageRef).val();

    var params = {_pageRef:_pageRef,cif_no:cifNo,prtflPosSummaryOption:selectedHolding,portfolioSeq:portfolioSeq,branchCode:branchCode,asOfDate:asOfDate}
	var actionSrc = jQuery.contextPath+"/path/globalview/dashPrtfCashPosHoldPosListAction_loadDashPrtfPosGraph";
	$.ajax({
		  url: actionSrc,
		  data: params,
		  type:"get",
		  dataType:"json",
		  success: function(data){
		    $("#prtflPosSummaryChart").html("");
		    drawInvestmentsGrids("prtflPosSummaryChart", data.prtflPosSummaryList)
		  }
	});
}

function dashboard_drawGridOnSecuritiesChange()
{
	
	var securityCode1 = $("#securityCode1_"+_pageRef).val();
	var securityCode2 = $("#securityCode2_"+_pageRef).val();
	var cifNo         = $("#cifNo_"+_pageRef).val();//$("#lookuptxt_cif_no_"+_pageRef).val(); changed by bahaa for TP# 1042048
	var portfolioSeq  = $("#portfolioSeq_"+_pageRef).val();
	var branchCode    = $("#branchCode_"+_pageRef).val();
	var params = {_pageRef:_pageRef,cif_no:cifNo,portfolioSeq:portfolioSeq,securityCode1:securityCode1,securityCode2:securityCode2,branchCode:branchCode}
	var actionSrc = jQuery.contextPath+"/path/globalview/dashPrtfCashPosHoldPosListAction_loadDashSummaryPositionGraph";
	$.post(actionSrc
		   ,params
	       ,function()
 	        {
				$("#allSecuritiesChart").html("");
		    	drawDashAllSecuritiesGrid("allSecuritiesChart", $("#allSecuritiesList_"+_pageRef).val())
	    	 }
	       );
}
// converting the branch filter to financing deals specific branch filter
//1(Login Branch)->'S' 2(All Branches) ->'A'
function dashboard_getFinancingDealsBranchFilter(branchFilter){
	return branchFilter=="1"?"S":"A";
}

// Collapse/Open FMS 360 grids upon single click - Libin Added
function showHideFMSGrids(divID,screen) 
{
	var state;
	var selector;
	if(screen=='APPROVEDLINES')
		{
			state = $("#fmsApprovedLines_collapse_Grid_identifier_"+_pageRef).val();// getting grid state
			selector = "#"+divID+" div[id^='gbox_fmsApprovedLinesGridTbl_Id_"+_pageRef+"']";
			if(state=='visible')
				$("#fmsApprovedLines_collapse_Grid_identifier_"+_pageRef).val('hidden');
			else if(state=='hidden')
				$("#fmsApprovedLines_collapse_Grid_identifier_"+_pageRef).val('visible');
		}
	else if(screen=='GUARANTOR')
		{
			state = $("#fmsGuarantor_collapse_Grid_identifier_"+_pageRef).val();// getting grid state
			selector = "#"+divID+" div[id^='gbox_fmsGuarantorGridTbl_Id_"+_pageRef+"']";
			if(state=='visible')
				$("#fmsGuarantor_collapse_Grid_identifier_"+_pageRef).val('hidden');
			else if(state=='hidden')
				$("#fmsGuarantor_collapse_Grid_identifier_"+_pageRef).val('visible');
		}
	else if(screen=='COLLATERALS')
		{
			state = $("#fmsCollaterals_collapse_Grid_identifier_"+_pageRef).val();// getting grid state
			selector = "#"+divID+" div[id^='gbox_fmsCollateralsGridTbl_Id_"+_pageRef+"']";
			if(state=='visible')
				$("#fmsCollaterals_collapse_Grid_identifier_"+_pageRef).val('hidden');
			else if(state=='hidden')
				$("#fmsCollaterals_collapse_Grid_identifier_"+_pageRef).val('visible');
		}
	else if(screen=='NEWAPP')
		{
			state = $("#fmsNewApp_collapse_Grid_identifier_"+_pageRef).val();// getting grid state
			selector = "#"+divID+" div[id^='gbox_fmsNewAppGridTbl_Id_"+_pageRef+"']";
			if(state=='visible')
				$("#fmsNewApp_collapse_Grid_identifier_"+_pageRef).val('hidden');
			else if(state=='hidden')
				$("#fmsNewApp_collapse_Grid_identifier_"+_pageRef).val('visible');
		}
	else if(screen=='BLOCKSUSPEND')
		{
			state = $("#fmsSuspendedFacility_collapse_Grid_identifier_"+_pageRef).val();// getting grid state
			selector = "#"+divID+" div[id^='gbox_fmsSuspendedFacilityGridTbl_Id_"+_pageRef+"']";
			if(state=='visible')
				$("#fmsSuspendedFacility_collapse_Grid_identifier_"+_pageRef).val('hidden');
			else if(state=='hidden')
				$("#fmsSuspendedFacility_collapse_Grid_identifier_"+_pageRef).val('visible');
		}
	
	if($(selector).length>0)
	{
		$(selector).each( 
		   	function ()
		   	{	
		   		var id = $(this).attr('id');
		   		var gridId = id.replace('gbox_','');
		   		var theGrid =  $("#" + gridId);
		   		if(theGrid.size() > 0 )
				{
					var gridBody = "#gview_"+gridId;
					var style = $(gridBody).find('.ui-jqgrid-bdiv').css('display');
					if(style=='none'&& state=='hidden')
					{
						var captionDiv = theGrid[0].grid.cDiv;
						$("a.ui-jqgrid-titlebar-close", captionDiv).click();
					}
					else if(style=='block'&& state=='visible')
					{
						var captionDiv = theGrid[0].grid.cDiv;
						$("a.ui-jqgrid-titlebar-close", captionDiv).click();
					}
				}
			});
	}
}

// Print method for FMS 360 grids - Libin Added
function onPrintFMSGrids(divID,screen) 
{
	var state;
	var selector;
	var flag;
	if(screen=='APPROVEDLINES')
	{
		selector = "#"+divID+" div[id^='gbox_fmsApprovedLinesGridTbl_Id_"+_pageRef+"']";
	}
	else if(screen=='GUARANTOR')
	{
		selector = "#"+divID+" div[id^='gbox_fmsGuarantorGridTbl_Id_"+_pageRef+"']";
	}
	else if(screen=='COLLATERALS')
	{
		selector = "#"+divID+" div[id^='gbox_fmsCollateralsGridTbl_Id_"+_pageRef+"']";
	}
	else if(screen=='NEWAPP')
	{
		selector = "#"+divID+" div[id^='gbox_fmsNewAppGridTbl_Id_"+_pageRef+"']";
	}
	else if(screen=='BLOCKSUSPEND')
	{
		selector = "#"+divID+" div[id^='gbox_fmsSuspendedFacilityGridTbl_Id_"+_pageRef+"']";
	}
	else if(screen=='APPROVEDLINESDETAIL')
	{
		selector = "#"+divID+" div[id^='gbox_fmsApprovedLinesDetailGridTbl_Id_"+_pageRef+"']";
	}	

	if($(selector).length>0)
	{
		$(selector).each( 
		   	function ()
		   	{	
		   		var id = $(this).attr('id');
		   		var gridId = id.replace('gbox_','');
				var theGrid =  $("#" + gridId);
		   		if(theGrid.size() > 0)
				{
					var gridBody = "#gview_"+gridId;
					var style = $(gridBody).find('.ui-jqgrid-bdiv').css('display');
					if(style=='none')
					{
						flag = true;
					}
				}
			});
	if(flag)
		_showErrorMsg('Please Expand all Grids for Printing to continue....',warning_msg_title);
	else
		{
			$("#"+divID).printElement(
        		{
        		printBodyOptions:
	            {
	            	styleToAdd:''
	            },
	            leaveOpen:true,
	            printMode:'popup'
	       });
		}
	}

}

/**
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_chequebookCodeBtn(cellValue, options, rowObject) 
{		return '<a href = "#" onclick="onchequeBookCodeShowlink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}


function onchequeBookCodeShowlink(selectedRowId, chequeBookCode)
{
  	var $t = $("#DashChqBookListGridTbl_Id_"+_pageRef);
  	
  	var myObject      = $t.jqGrid('getRowData',selectedRowId); 
		   
	var branchCode = myObject["ctschqbookVO.BRANCH_CODE"];
	var accBranch = myObject["ctschqbookVO.ACC_BR"];
	var accCurrency = myObject["ctschqbookVO.ACC_CY"];
	var accGL = myObject["ctschqbookVO.ACC_GL"];
	var accCIF = myObject["ctschqbookVO.ACC_CIF"];
	var accSL = myObject["ctschqbookVO.ACC_SL"];
	var accAddRef = myObject["ctschqbookVO.ACC_ADD_REF"];
	var ivCrud = "R";	
	
	var chequeBookDiv = $("<div id='chequeBookQueryDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	
	 var dashChequeBookDiv = $(chequeBookDiv);
	  theForm.append(dashChequeBookDiv);
	
	dashChequeBookDiv.insertAfter(theForm);
	
	var mySrc = jQuery.contextPath+"/path/chequeBook/ChequeBookStatusMaint_initialise.action?";
	var params = {'ctschqbookVO.ACC_BR':accBranch,
			   'ctschqbookVO.ACC_CY':accCurrency,
			   'ctschqbookVO.ACC_GL':accGL,
			   'ctschqbookVO.ACC_CIF':accCIF,
			   'ctschqbookVO.ACC_SL':accSL,
			   'ctschqbookVO.ACC_ADD_REF':accAddRef,
			   '_pageRef':'Q000QR',
			  	"iv_crud" :ivCrud,
			   'isLookUp':1
			   };
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = "Q000QR";
	iFrameParams["appName"] = currentAppName;
	iFrameParams["destinationUrl"] = "/path/chequeBook/ChequeBookStatusMaint_initialise";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	dashChequeBookDiv.dialog( {
		modal : true,
		title : chequeBookKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#chequeBookQueryDiv_id_"+_pageRef ).dialog("destroy");
			$("#chequeBookQueryDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashChequeBookDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#chequeBookQueryDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * Drildowns -- [John Massaad]
 * This method to show SafeBox trx Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_safeBoxTrxBtn(cellValue, options, rowObject) 
{		return '<a href = "#" onclick="onSafeBoxesTrxNOShowlink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
		
}

/**
 * Drildowns -- [John Massaad]
 * @param {Object} sel_row_index
 * @memberOf {TypeName} 
 * This method is called when clicking on TrxNO in the Grid
 * It is used to show additional details related to a cetain link
 * It opends the safeboxmanagement Screen(SafeBoxManagementMaint.jsp)
 * It is called from SafeboxesList.jsp
 */
function onSafeBoxesTrxNOShowlink(selectedRowId, trx_no)
{
	var $t = $("#safeBoxexListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	var safeBoxNo=  myObject["safebox_no"];
	var branchCode = myObject["branch_code"];
	var safeBoxStatus = myObject["ctsSafeBoxVO.STATUS"];
	var fromGraphicView = true;
	var paramType = myObject["ctsParamVO.PARAM_TYPE"];//'S' ;
	var safeBoxTrxStatus = myObject["statusTrx"];
	
	var ivCrud = "M";	
//	var safeBoxMgntDiv = $("<div id='safeBoxMgntDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var safeBoxMgntDiv = $("<div id='safeBoxMgntDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;'/>"); // Hussein El Hajj #684661 User is not able to view the full details of the safe box under 360
	var theForm = $("#dashboardFormId");
	var dashSafeBoxMgntDiv = $(safeBoxMgntDiv);
	theForm.append(dashSafeBoxMgntDiv);
	dashSafeBoxMgntDiv.insertAfter(theForm);
	var mySrc =jQuery.contextPath+"/path/safeBox/SafeBoxMgmtMaint_safeBoxMgmtEditPage.action";
	var params = {"safeBoxNo" : safeBoxNo,
				   "safeBoxDefCO.safeBoxVO.STATUS" : safeBoxStatus,
				   "safeBoxDefCO.fromGraphicView" : fromGraphicView
				   ,"safeBoxDefCO.ctsSafeBoxTrxVO.STATUS" : safeBoxTrxStatus,
				   "safeBoxDefCO.paramTypeVO.PARAM_TYPE" : paramType
					,"safeBoxDefCO.ctsSafeBoxTrxVO.TRX_NO" : trx_no,
					"iv_crud" :ivCrud,
					"_pageRef" : "E003MT", //"E003MT",
					"isLookUp":"1",
					"safeBoxDefCO.ctsSafeBoxTrxVO.BRANCH_CODE" : branchCode};
	
	_showProgressBar(true);
	$("#safeBoxMgntDiv_id_"+_pageRef).load(mySrc, params, function() {
		$("#safeBoxMgntDiv_id_"+_pageRef).dialog({modal:true, 
		                                 title: safeBoxKey,
		                                 autoOpen:false,
		                                 show:'slide',
		                                 position:'center', 
		                                 width:800,
		                                 height:550,
		                                 buttons :{"ok":function(){
						                                	 var theDialog = $(this);
							 								  theDialog.remove();
	    	                                                      }
	                                              },
		                                 close: function (){
							 								  var theDialog = $(this);
							 								  theDialog.remove();
														    }});
		$("#automaticRenewalChkBox_E003MT").attr("disabled", true);
		$("#safeBoxMgntDiv_id_"+_pageRef).dialog("open");
		_showProgressBar(false);
	});
//	var currentAppName = 'RET';
//	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
//	var iFrameParam = {};
//	iFrameParam["destinationProgRef"] = "E003MT";
//	iFrameParam["appName"] = currentAppName;
//	iFrameParam["destinationUrl"] = mySrc;
//	iFrameParam["additionalParams"] = JSON.stringify(params);
//	
//	dashSafeBoxMgntDiv.dialog( {
//		modal : true,
//		title : safeBoxesKey,
//		autoOpen : false,
//		position : 'center',
//		height : returnMaxHeight(501),
//		width : returnMaxWidth(1023),
//		close : function() {
//			$("#safeBoxMgntDiv_id_"+_pageRef ).dialog("destroy");
//			$("#safeBoxMgntDiv_id_"+_pageRef ).remove();
//		},
//		open : function() {
//		}
//	});
//
//	$(dashSafeBoxMgntDiv).load(iFrameUrl,iFrameParam,
//			function() 
//			{
//				$("#safeBoxMgntDiv_id_"+_pageRef ).dialog("open");
//			});
}


/**
 * Drildowns -- [John Massaad]
 * This method to show Card Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_cardsBtn(cellValue, options, rowObject) 
{	
	return '<a href = "#" onclick="onCardsNumberShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}

/**
 * Drildowns -- [John Massaad]
 * @param {Object} sel_row_index
 * @memberOf {TypeName} 
 * This method is called when clicking on CardsNumber in the Grid
 * It is used to show additional details related to a cetain link
 * It opends the CardsMgnt Screen(CardsManagementMaint.jsp)
 * It is called from CardsList.jsp
 */
function onCardsNumberShowlink(selectedRowId)
{
	
	var $t = $("#cardsListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	//Here we retrieve the CARD_NO column(which is hidden) not the masked one (if we have a maked number) always
	//and sends it as a parameter tot the Cards screen
	var card_no = myObject["ctsCardsMGTVO.CARD_NO"];
		
	var app_id 	   = myObject["ctsCardsMGTVO.APPLICATION_ID"];
	var branchCode = myObject["banch_code"];
	var iv_crud = "R";
	$.struts2_jquery.require("CardsManagementList.js,CardsManagementMaint.js,CardsManagementPrintAdvice.js" ,null,jQuery.contextPath+"/path/js/cardsmanagement/");
	
	var cardsManagementDiv = $("<div id='cardsManagementDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	
	var theForm = $("#dashboardFormId");
	var dashCardsManagementDiv = $(cardsManagementDiv);
	theForm.append(dashCardsManagementDiv);
	dashCardsManagementDiv.insertAfter(theForm);
	
	var mySrc ="/path/cardsManagement/CardsManagementMaint_showCardsMaintMainDetails";
	
	var params = {"application_id" : app_id,
				   "card_no" : card_no,
				   "iv_crud" : iv_crud,
				   "_pageRef" : "G001MT",
				   "criteria.branchCode" : branchCode
					,"_recReadOnly" : "true",
					"isLookUp":"1"};
	
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "G001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashCardsManagementDiv.dialog( {
		modal : true,
		title:cardsManagementKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$(this).dialog("destroy");
						$("#cardsManagementDiv_id_"+_pageRef).dialog("close").remove();
		},
		open : function() {
		}
	});

	$(dashCardsManagementDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#cardsManagementDiv_id_"+_pageRef ).dialog("open");
			});

	
}
//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen
function dashboard_smsBtn(cellValue, options, rowObject) 
{	
	return '<a href = "#" onclick="onSmsNumberShowlink(' + options.rowId + ')";>' +  cellValue + '</a>';
}


function onSmsNumberShowlink(selectedRowId)
{
	var $t = $("#smsSubscriptionListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	var code= myObject["CODE"];
		
	
	var branchCode = myObject["BRANCH_CODE"];
	var iv_crud = "R";
    $.struts2_jquery.require("SmsSubscriptionMaint.js" ,null,jQuery.contextPath+"/path/js/smssubscription/");

	var smsSubscriptionDiv = $("<div id='smsSubscriptionDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	
	var theForm = $("#dashboardFormId");
	var dashSmsSubscriptionDiv = $(smsSubscriptionDiv);
	theForm.append(dashSmsSubscriptionDiv);
	dashSmsSubscriptionDiv.insertAfter(theForm);
	
	var mySrc ="/path/smsSubscription/SmsSubscriptionMaintAction_loadSmsSubscriptionDetails";
				
	var params = { "smsSubscriptionCO.smsSubscriptionVO.CODE" : code,
				   "iv_crud" : iv_crud,
				   "_pageRef" : "SMS00MT",
				   "smsSubscriptionCO.smsSubscriptionVO.BRANCH_CODE" : branchCode
					,"_recReadOnly" : "true",
					"isLookUp":"1",
					"openedFromDashboard":"true"};
	
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "SMS00MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashSmsSubscriptionDiv.dialog( {
		modal : true,
		title:'Sms Subscription',
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$(this).dialog("destroy");
						$("#smsSubscriptionDiv_id_"+_pageRef).dialog("close").remove();
		},
		open : function() {
		}
	});

	$(dashSmsSubscriptionDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#smsSubscriptionDiv_id_"+_pageRef ).dialog("open");
			});

	
}
//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen


/**
 * Drildowns -- [John Massaad]
 * This method to show Links Mgnt  CIF CIF Serial Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_linksCIFCIFBtn(cellValue, options, rowObject) 
{	
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSerialNbShowlink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";	
}
/**
 * Drildowns -- [John Massaad]
 *  This method to show Links Mgnt  CIF Acc Serial Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_linksCIFAccBtn(cellValue, options, rowObject) 
{	
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSerialNbShowlink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";	
	
}
/**
 * Drildowns -- [John Massaad]
 *  This method to show Links Mgnt  Acc Acc Serial Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_linksAccAccBtn(cellValue, options, rowObject) 
{	
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSerialNbShowlink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";	
	
}

/**
 * Drildowns -- [John Massaad]
 *  This method to show Links Mgnt  Acc CIF Serial Nb hyperlink button
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_linksAccCIFBtn(cellValue, options, rowObject) 
{	
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSerialNbShowlink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";	
}


/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Serial Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens the LinksManagement Screen(LinksManagementMaint.jsp)
 * called From DashLinksList.jsp
 */
function onSerialNbShowlink(selectedRowId,linkSerial,gridId)
{	
	
	var $t ="";
	
	$t = $("#"+gridId);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	var linkCode = myObject["sLinkCifAmfVO.LINK_CODE"]; 
	
	var iv_crud = "R";	
	var linksManagementDiv = $("<div id='linksManagementDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashLinksManagementDiv = $(linksManagementDiv);
	theForm.append(dashLinksManagementDiv);
	dashLinksManagementDiv.insertAfter(theForm);
	
	var mySrc ="/path/linksManagement/LinksManagementMaint_edit";
	
	var params = {"linkSerial" : linkSerial,
				   "linkCode" : linkCode,
				   "iv_crud" : iv_crud,
					"_pageRef" : "LM01MT",
					"isLookUp":"1"};
	
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "LM01MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashLinksManagementDiv.dialog( {
		modal : true,
		title : linksMgmtKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#linksManagementDiv_id_"+_pageRef ).dialog("destroy");
			$("#linksManagementDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashLinksManagementDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#linksManagementDiv_id_"+_pageRef ).dialog("open");
			});
	
}
/**
 * This method is to create the LostDocs TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_dahsLostDocsTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onDahsLostDocsTrxNbShowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}
/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens LostAndFound/Maintenance Screen(LostFoundManagementMaint.jsp)
 * It is called From DashLostDocsList.jsp
 */
function onDahsLostDocsTrxNbShowLink(selectedRowId,lostFoundtrxNb)
{
	var $t = $("#DashLostDocsListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	var iv_crud = "R";	
	var lostFoundDiv = $("<div id='lostFoundDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashLostFoundDiv = $(lostFoundDiv);
	theForm.append(dashLostFoundDiv);
	dashLostFoundDiv.insertAfter(theForm);
	
	var mySrc ="/path/lostFoundManagement/LostFoundManagementMaint_edit";
	
	var params = {"lostFoundManagementCO.lostFoundVO.TRX_NO" : lostFoundtrxNb,
					"iv_crud" :iv_crud,
					"_pageRef" : "N001MT",
					"isLookUp":"1"};
	
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "N001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashLostFoundDiv.dialog( {
		modal : true,
		title:lostDocsKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#lostFoundDiv_id_"+_pageRef ).dialog("destroy");
			$("#lostFoundDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashLostFoundDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#lostFoundDiv_id_"+_pageRef ).dialog("open");
			});
		
	
}
/**
 * This method is to create the SO TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_SOTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onSOTrxNbShowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashSOList.jsp
 * @param {Object} sel_row_index
 */
function onSOTrxNbShowLink(selectedRowId, trs_no)
{
	$t=$("#soListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["ctstrsVO.BRANCH_CODE"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	
	
	var iv_crud = "R";	
	var soDiv = $("<div id='soDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashSODiv = $(soDiv);
	theForm.append(dashSODiv);
	dashSODiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashSODiv.dialog( {
		modal : true,
		title : standingOrdersKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#soDiv_id_"+_pageRef ).dialog("destroy");
			$("#soDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashSODiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#soDiv_id_"+_pageRef ).dialog("open");
			});
}
/**
 * This method is to create the Cheques for collection TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_chequesForColTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onChequesForCollTrxNbShowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashChequesForColList.jsp
 * @param {Object} selectedRowId	
 */
function onChequesForCollTrxNbShowLink(selectedRowId, trs_no)
{
	$t=$("#chequesForColListGridTbl_Id_"+_pageRef);
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["branch_code"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	var ivCrud     = "R";
	
	var iv_crud = "R";	
	var chequesForCollDiv = $("<div id='chequesForCollDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashChequesForCollDiv = $(chequesForCollDiv);
	theForm.append(dashChequesForCollDiv);
	dashChequesForCollDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);

	
	dashChequesForCollDiv.dialog( {
		modal : true,
		title:chequesForCollKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#chequesForCollDiv_id_"+_pageRef ).dialog("destroy");
			$("#chequesForCollDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashChequesForCollDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#chequesForCollDiv_id_"+_pageRef ).dialog("open");
			});
}
/**
 * This method is to create the VoidedCheques TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_voidedChequesTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onVoidedChequesTrxNbShowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashVoidedChequesList.jsp 
 * @param {Object} sel_row_index
 */
function onVoidedChequesTrxNbShowLink(selectedRowId, trs_no)
{
		$t=$("#voidedChequesListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["branch_code"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	
	
	var iv_crud = "R";	
	var voidedChequesDiv = $("<div id='voidedCheques_Div_Id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashVoidedChequesDiv = $(voidedChequesDiv);
	theForm.append(dashVoidedChequesDiv);
	dashVoidedChequesDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashVoidedChequesDiv.dialog( {
		modal : true,
		title:voidedChequesKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#voidedCheques_Div_Id_"+_pageRef ).dialog("destroy");
			$("#voidedCheques_Div_Id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashVoidedChequesDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#voidedCheques_Div_Id_"+_pageRef ).dialog("open");
			});
	
	
}
/**
 * This method is to create the VoidedCheques TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_passBookNbBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onPassBookNbshowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens PassBook/Maintenance Screen(PassBookMaint.jsp)
 * It is called From DashPassbooksList.jsp 
 * @param {Object} sel_row_index
 * @param {Object} param
 */
function onPassBookNbshowLink(selectedRowId,passbkNumber)
{
	$t=$("#dashPassbookListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	var iv_crud = "R";	
	var passBookMaintDiv = $("<div id='passBookMaintDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashPassBookMaintDiv = $(passBookMaintDiv);
	theForm.append(dashPassBookMaintDiv);
	dashPassBookMaintDiv.insertAfter(theForm);
	debugger;
	var mySrc ="/path/passBook/PassBookMaintAction_loadPassBookMaint";
		
	var params = {"passBookCO.passBookVO.CODE" : passbkNumber,
					"iv_crud" :iv_crud,
					"_pageRef" : "S000MT",
					"isLookUp":"1"};
	

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "S000MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashPassBookMaintDiv.dialog( {
		modal : true,
		title:passbookKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#passBookMaintDiv_id_"+_pageRef ).dialog("destroy");
			$("#passBookMaintDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashPassBookMaintDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#passBookMaintDiv_id_"+_pageRef ).dialog("open");
			});
	
}

/**
 * This method is to create the Special Condition Line Nb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */

function dashboard_specialCondCIFLineBtn(cellValue, options, rowObject) 
{
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSpecialCondLineNbshowLink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";
	
//	return '<a href = "#" onclick="onSpecialCondLineNbshowLink(' + options.rowId + ',' +cellValue+ ','+ bb.toString()+')";>' +  cellValue + '</a>';
}

/**
 * This method is to create the Special Condition Line Nb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_specialCondAccLineBtn(cellValue, options, rowObject) 
{
	var gridId = ""+options.gid;
	
		return "<a href = '#' onclick=onSpecialCondLineNbshowLink('" + options.rowId + "','" +cellValue+ "','" + gridId+"');>" +  cellValue + "</a>";
}


/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens SpecialConditions/Maintenance Screen(SpecialConditionsMaint.jsp)
 * It is called From DashSpecialCondList.jsp 
 * @param {Object} sel_row_index
 * @param {Object} param
 */	

function onSpecialCondLineNbshowLink(selectedRowId,lineNo,gridId)
{
	
	var myObject=null;
	var selectedRowId = null;
	
	gridId = $("#"+gridId);
	 
	myObject = gridId.jqGrid('getRowData',selectedRowId);

	var iv_crud = "R";	
	var specialConditionsMaintDiv = $("<div id='specialConditionsMaintDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashSpecialConditionsMaintDiv = $(specialConditionsMaintDiv);
	theForm.append(dashSpecialConditionsMaintDiv);
	dashSpecialConditionsMaintDiv.insertAfter(theForm);
	
	var mySrc ="/path/specialconditions/SpecialConditionsMaintLoader_loadSpecialConditionsMaint";
		
	var params = {"lineNo" : lineNo,
					"_pageRef":"SPC00MT",
					"iv_crud":iv_crud,
					"isLookUp":"1"};
	

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "SPC00MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	var mySrc  = jQuery.contextPath+"/path/specialconditions/SpecialConditionsMaintLoader_loadSpecialConditionsMaint";
	

	dashSpecialConditionsMaintDiv.dialog( {
		modal : true,
		title:specialCondKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#specialConditionsMaintDiv_id_"+_pageRef ).dialog("destroy");
			$("#specialConditionsMaintDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashSpecialConditionsMaintDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#specialConditionsMaintDiv_id_"+_pageRef ).dialog("open");
			});
	
}


/**
 * This method is to create the  TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_remittancesTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onRemittancesTrxNbshowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashRemittancesList.jsp 
 * @param {Object} sel_row_index
 */
function onRemittancesTrxNbshowLink(selectedRowId,trs_no)
{
	_showProgressBar(true);
	
	$t=$("#remittancesListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["ctstrsVO.BRANCH_CODE"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["trsType"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	

		
	var iv_crud = "R";	
	var remittancesDiv = $("<div id='remittancesDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashRemittancesDiv = $(remittancesDiv);
	theForm.append(dashRemittancesDiv);
	dashRemittancesDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	
	dashRemittancesDiv.dialog( {
		modal : true,
		title:remittancesKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#remittancesDiv_id_"+_pageRef ).dialog("destroy");
			$("#remittancesDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashRemittancesDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#remittancesDiv_id_"+_pageRef ).dialog("open");
			});
}
/**
 * This method is to create the  TrxNb hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_postDatedChqDepTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onPostDatedChqDepTrxNbshowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashPostDatedChqDepList.jsp 
 * @param {Object} sel_row_index
 */
function onPostDatedChqDepTrxNbshowLink(selectedRowId,trs_no)
{
	$t=$("#postDatedChqDepListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["branch_code"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	
	var iv_crud = "R";	
	var postDatedChqDepDiv = $("<div id='postDatedChqDepDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashPostDatedChqDepDiv = $(postDatedChqDepDiv);
	theForm.append(dashPostDatedChqDepDiv);
	dashPostDatedChqDepDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashPostDatedChqDepDiv.dialog( {
		modal : true,
		title:postDatedChqDepositKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#postDatedChqDepDiv_id_"+_pageRef ).dialog("destroy");
			$("#postDatedChqDepDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashPostDatedChqDepDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#postDatedChqDepDiv_id_"+_pageRef ).dialog("open");
			});
	
}
/**
 * This method is to create the  CIF Name hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_authSignatureCIFBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onAuthSignatureCIFNameShowLink(' + options.rowId +')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on CIF Name in the Grid
 * It is used to show additional details related to a cetain link
 * It opens FOM/Maintenance Screen(FomMaint.jsp)
 * It is called From DashAuthorizedSigList 
 * @param {Object} sel_row_index
 */
function onAuthSignatureCIFNameShowLink(selectedRowId)
{
	$t=$("#authorizedSigListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	var cifNo  = $("#lookuptxt_cif_no_"+_pageRef).val();
	var branchId = myObject["cifVO.BRANCH_CODE"];
	var iv_crud = "R";	
	
	var fomMaintDiv = $("<div id='fomMaintDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashFomMaintDiv = $(fomMaintDiv);
	theForm.append(dashFomMaintDiv);
	dashFomMaintDiv.insertAfter(theForm);
	
	var mySrc ="/path/fom/FrontOfficeMgntMaint_showFOMCifDetails";
		
	var params = {"cifNo" : cifNo,
				   "branchId" : branchId,
					"iv_crud" :iv_crud,
					"_pageRef" : "F00I1MT",
					"isLookUp":"1"};
	

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "F00I1MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashFomMaintDiv.dialog( {
		modal : true,
		title:Fom_key,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#fomMaintDiv_id_"+_pageRef ).dialog("destroy");
			$("#fomMaintDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashFomMaintDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#fomMaintDiv_id_"+_pageRef ).dialog("open");
			});
	
}
/**
 * This method is to create the bankersChq Trx Number hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_bankersChqTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onBankersChqTrxNbshowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashBankersChequesList.jsp 
 * @param {Object} sel_row_index
 */
function onBankersChqTrxNbshowLink(selectedRowId,trs_no)
{
	$t=$("#bankersChqListGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["branch_code"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["trx_type"];
	
	
	var iv_crud = "R";	
	var bankersChqDiv = $("<div id='bankersChqDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashBankersChqDiv = $(bankersChqDiv);
	theForm.append(dashBankersChqDiv);
	dashBankersChqDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashBankersChqDiv.dialog( {
		modal : true,
		title:bankersChqKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#bankersChqDiv_id_"+_pageRef ).dialog("destroy");
			$("#bankersChqDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashBankersChqDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#bankersChqDiv_id_"+_pageRef ).dialog("open");
			});
	
}
/**
 * This method is to create the PostDatedChq Trx Number hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_postDatedChqWDrawalTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onPostDatedChqWDrawalTrxNbshowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashPostDatedChqWDrawalList.jsp 
 * @param {Object} sel_row_index
 */
function onPostDatedChqWDrawalTrxNbshowLink(selectedRowId,trs_no)
{
	$t=$("#postDatedChqWDrawalGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["branch_code"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
	var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	
	var iv_crud = "R";	
	var postDatedChqWDrawalDiv = $("<div id='postDatedChqWDrawalDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashPostDatedChqWDrawalDiv = $(postDatedChqWDrawalDiv);
	theForm.append(dashPostDatedChqWDrawalDiv);
	dashPostDatedChqWDrawalDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	

	
	dashPostDatedChqWDrawalDiv.dialog( {
		modal : true,
		title:postDatedChqWdrawalKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#postDatedChqWDrawalDiv_id_"+_pageRef ).dialog("destroy");
			$("#postDatedChqWDrawalDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashPostDatedChqWDrawalDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#postDatedChqWDrawalDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * This method is to create the DashAccDtls Trx Number hyperlink button
 * Drildowns -- [John Massaad]
 * @param {Object} cellValue
 * @param {Object} options
 * @param {Object} rowObject
 * @return {TypeName} 
 */
function dashboard_accDelailsTrxBtn(cellValue, options, rowObject) 
{
		return '<a href = "#" onclick="onDashAccDtlsTrxNbShowLink(' + options.rowId + ',' +cellValue+')";>' +  cellValue + '</a>';	
}

/**
 * Drildowns -- [John Massaad]
 * This method is called when clicking on Transaction Number in the Grid ( this grid appears when clicking on Assets or Liabilities-> click on button Transaction Information-> click on a link in the grid
 * It is used to show additional details related to a cetain link
 * It opens Transaction/Maintenance Screen(TrxMgntMaint.jsp)
 * It is called From DashAccDtlTrxList.jsp 
 * @param {Object} sel_row_index
 * This method is called form DashAccDtlTrxList.jsp when clicking on TrsNo and opens the Transaction Maintenance screen.
 */
function onDashAccDtlsTrxNbShowLink(selectedRowId,trs_no)
{
	$t=$("#dashAccDtlTrxGridTbl_Id_"+_pageRef);
	
	var myObject = $t.jqGrid('getRowData',selectedRowId);
	
	
	
	var compCode   = myObject["ctstrsVO.COMP_CODE"];
	var branchCode = myObject["trx_branch"];
	var cbInd      = myObject["ctstrsVO.CB_IND"];
    var trsType    = myObject["ctstrsVO.TRS_TYPE"];
	var trxType    = myObject["ctstrsVO.TRX_TYPE"];
	
	var iv_crud = "R";	
	var accDtlTrxDiv = $("<div id='accDtlTrxDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashAccDtlTrxDiv = $(accDtlTrxDiv);
	theForm.append(dashAccDtlTrxDiv);
	dashAccDtlTrxDiv.insertAfter(theForm);
	
	var mySrc ="/path/trxMgnt/TrxMgntMaint_edit";
		
	var params = {"compCode" : compCode,
				   "branchCode" : branchCode,
				   "cbInd" : cbInd
				   ,"trs_no" : trs_no,
				   "trsType" : trsType
					,"trxMgntCO.trxType" : trxType,
					"iv_crud" :iv_crud,
					"_pageRef" : "D001MT",
					"isLookUp":"1"};

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "D001MT";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	dashAccDtlTrxDiv.dialog( {
		modal : true,
		title:trxDetlsKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#accDtlTrxDiv_id_"+_pageRef ).dialog("destroy");
			$("#accDtlTrxDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashAccDtlTrxDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#accDtlTrxDiv_id_"+_pageRef ).dialog("open");
			});
}

/**
 * Drildowns -- [John Massaad]
 * JVListDetls 
 * This method is used to open JVDetails(StatementOfAccountsJVDetails.jsp) on dblClick event of dashAccDtlJvsGridTbl_Id Grid located in (DashAccDtlJVsList)
 * This screen is already opened in Queries->StatementOfAccounts->By Trade Date when double click on statementOfAccountsDetGridTbl_Id Grid located in StatementOfAccountsBal.jsp
 * 
 * 
 */
function dashAccDtlJVs_onDbClickedEvent()
{
	
	var jvListGrid = $("#dashAccDtlJvsGridTbl_Id_" + _pageRef);
	var selectedRowId = jvListGrid.jqGrid('getGridParam', 'selrow');
	if (selectedRowId == null) {
		return;
	}
	var myObject = jvListGrid.jqGrid('getRowData', selectedRowId);
	
	var compCode = myObject["compCode"];
	var branchCode = myObject["branchCode"];
	var opNo = myObject["op_no"];
    var srlNo = myObject["srlNo"];
	
	
	
	var iv_crud = "R";	
	var jvListDtlsDiv = $("<div id='jvListDtlsDiv_id_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	
	var theForm = $("#dashboardFormId");
	var dashJVListDtlsDiv = $(jvListDtlsDiv);
	theForm.append(dashJVListDtlsDiv);
	dashJVListDtlsDiv.insertAfter(theForm);
	
	var mySrc ="/path/queries/StatementOfAccounts_returnJVDetails.action";
		
	var params = {"statementOfAccountsCO.amfvo.COMP_CODE" : compCode,
				   "statementOfAccountsCO.amfvo.BRANCH_CODE" : branchCode,
				   "statementOfAccountsCO.hstvo.OP_NO" : opNo
				   ,"statementOfAccountsCO.srlNo" : srlNo,
					"iv_crud" :iv_crud,
					"_pageRef" : "QUER001T",
					"isLookUp":"1"};
	

	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParam = {};
	iFrameParam["destinationProgRef"] = "QUER001T";
	iFrameParam["appName"] = currentAppName;
	iFrameParam["destinationUrl"] = mySrc;
	iFrameParam["additionalParams"] = JSON.stringify(params);
	
	
	dashJVListDtlsDiv.dialog( {
		modal : true,
		title : jvDetslKey,
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#jvListDtlsDiv_id_"+_pageRef ).dialog("destroy");
			$("#jvListDtlsDiv_id_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(dashJVListDtlsDiv).load(iFrameUrl,iFrameParam,
			function() 
			{
				$("#jvListDtlsDiv_id_"+_pageRef ).dialog("open");
			});
}
/**
 * This method is used to open OneObligorMaint.jsp from the imal_core_admin_portal 
 */
function dash_ShowOneObligor()
{
	_showProgressBar(true);
//	var mySrc  = jQuery.contextPath+"/path/oneObligor/OneObligorMaintAction_loadOneObligorMaintPage";
	
	//Temp
	var mySrc  = jQuery.contextPath+"/path/globalview/dashOneObligorMaintAction_loadOneObligorMaintPage";
	//Temp
	
	
	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
	var params={"dashOneObligorSC.cifNo":cifNo,"_pageRef":_pageRef,"iv_crud":"R","isLookUp":"1"};
	 

	var dialogOptions={modal:true,
			title:oneObligorKey,
		//		height : returnMaxHeight(500),
		//		width : returnMaxWidth(855),
			height :500,
			width:750,
			resizable: false,
			autoOpen : false,
			show : 'slide',
			close : function(event, ui) {
				$("#oneObligorMaintDiv_id_"+_pageRef).remove();
			},
			buttons : {
				"OK" : function() {
						$("#oneObligorMaintDiv_id_"+_pageRef).remove();
				}
			}
		};
		
	if($("#oneObligorMaintDiv_id_" + _pageRef) && $("#oneObligorMaintDiv_id_" + _pageRef).attr('id') != undefined)
	{
		$("#oneObligorMaintDiv_id_" + _pageRef).dialog("destroy");
		$("#oneObligorMaintDiv_id_" + _pageRef).remove();
	}
	
	var alertDivElement = $('<div>',{id:"oneObligorMaintDiv_id_"+_pageRef});
	alertDivElement.css("padding","0");
	$('body').append(alertDivElement);
	
		 
	
	   $("#oneObligorMaintDiv_id_"+_pageRef).load(mySrc,params,function(){
				_showProgressBar(false);
				$("#oneObligorMaintDiv_id_"+_pageRef).dialog(dialogOptions);
				$("#oneObligorMaintDiv_id_"+_pageRef).dialog("open");
					});
	
}

/**
 * common func that returns a row as Json object based on selectedRowId
 * @param {Object} selectedRowId : if equal undefined then we return the selected, if it is defined we return its correspondant row
 */
function returnDashAccDetRow(selectedRowId){
	var $table = $("#dashAccDetailsGridTbl_Id_" + _pageRef);
	var selectedRowId = typeof selectedRowId != undefined ? selectedRowId : $table.jqGrid('getGridParam', 'selrow');
	return $table.jqGrid('getRowData', selectedRowId);
}


/**
 * Description : this function will open a grid in modal dialog to populate the dues related for the selected account
 */
function openDuesForAccounts(selectedRowId){
    _showProgressBar(true);
	var	duesForAccDiv = $("<div id='duesForAccounts_div_"+_pageRef+"'/>");
	duesForAccDiv.css("padding","0");
    duesForAccDiv.insertAfter('body');
    
    var selectedRowObj = returnDashAccDetRow(selectedRowId);
    var accBr = selectedRowObj["branchCode"];
    var currencyCode = selectedRowObj["currencyCode"];
    var glCode = selectedRowObj["glCode"];
    var cif_no = unformatNumber( $("#lookuptxt_cif_no_"+_pageRef).val());
    var slNo = selectedRowObj["slNo"];
    
    var actionSrc = jQuery.contextPath+"/path/globalview/DashAccDtlDuesListAction_loadDuesForAccPage";
	var curParams = {"accBr" : accBr, "currencyCode" : currencyCode,"glCode" : glCode,"cif_no" : cif_no, "slNo":slNo,"_pageRef" : _pageRef};
	duesForAccDiv.load(actionSrc, curParams, function() {
	_showProgressBar(false);
    duesForAccDiv.dialog({modal:true, 
                          title:due_details_key,
                       autoOpen:false,
                           show:'slide',
                       position:'center', 
                         width:returnMaxWidth(1000),
                         height:returnMaxHeight(250),
                     	  close:function (){
 								  var theDialog = $(this);
 								  theDialog.remove();
								}});
	duesForAccDiv.dialog("open");
	});
}

/**
 * @author EliasAoun
 * this formatter is binded to open the dues frid as a link from DashAccountsDetailsList.jsp
 */
function duesLinkFormatter(cellValue, options, rowObject){
	//apply format on the value
	var cellValueFormatted = $.formatNumberNumeric(cellValue,{format :"0.##", locale:"us"})
	return '<a href = "#" onclick="openDuesForAccounts(' + options.rowId + ');" >'+cellValueFormatted+'</a>';
}

/**
 * Modif IIAB080110 ; EliasAoun
 */
function openTrxScreenFromDuesDash(){ 
	var $table = $("#dashAccountsDuesGrid_Id_" + _pageRef);
	var selectedRowId = $table.jqGrid('getGridParam', 'selrow');
	var rowObj = $table.jqGrid('getRowData', selectedRowId);
	var trsNo = unformatNumber( rowObj["ctsDuesVO.TRS_NO"]);
	if(trsNo != null && typeof trsNo != undefined && trsNo != ''){
		
      //Required JS
      $.struts2_jquery.require("AlertsOpenItem.js,ApproveAlertsMaint.js" ,null,jQuery.contextPath+"/common/js/alerts/");
      //Prepare Params
      var openItemParam = {};
      openItemParam["alertsParamCO.isLocalApprove"] = 'true';
      openItemParam["alertsParamCO.alertType"]   = 'TRANS';
      openItemParam["alertsParamCO.isLocalApprove"]    = 'true';
      openItemParam["alertsParamCO.compCode"]          = unformatNumber( rowObj["ctsDuesVO.COMP_CODE"]);
      openItemParam["alertsParamCO.branchCode"]        = unformatNumber( rowObj["ctsDuesVO.BRANCH_CODE"]);
      openItemParam["alertsParamCO.trsNo"]             = trsNo;
      openItemParam["alertsParamCO.todoParam"]         = trsNo;
      openItemParam["showToolbar"]                     = false;
      openItemParam["alertsParamCO.progRef"]           = 'D001MT';
      openItemParam["alertsParamCO.todoAlert"]         = 'X';
      //Open item
      ApproveAlertsMaint_loadOpenitemScreen(openItemParam);
	}
}




function dashboard_onViewChartClicked()
{
	// hide print button if not from grid view
	$("#print_grid_btn_" + _pageRef).hide();
	$("#assetsLiabAccDivId_"+_pageRef).html("");
    plotBarChart();	
    plotFinancingApplicationsBarChart();
    plotTFABarChart();
    plotFinancingDealsChart();    
    plotInvestmentAndTreasuryChart();
    
}

function dashboard_onViewGridClicked()
{
dashboard_afterCifDependency("1");
}

/**
 * NABIL FEGHALI USER STORY#205367 Resize the 360 degree screen to fit into any display
 */
function dashboard_printView()
{
	_showProgressBar(true);
	var prtDiv =$('#prt-container');// empty the print div container.
	var pgTitle = "";
    if(prtDiv.length)
    {        
    	prtDiv.empty();
    }
    else
    {    	
	    prtDiv = $('<div id="prt-container"></div>');
	    prtDiv.appendTo('body');
    }	     
 	
   $('#dashboardScreen').clone().appendTo(prtDiv);   
   $(prtDiv).find('tr').removeClass('ui-priority-secondary');
   $(prtDiv).printElement({ printContainer:"prt-container",pageTitle:'',leaveOpen:false,printMode:'iframe'});
   _showProgressBar(false);
}

/**
 * Elie Achkar TFA Grid
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
function plotTFABarChart()
{
	var tradeFinanceJson = $.parseJSON($("#tradeFinanceList_"+_pageRef).val());

	var impLCTotal = tradeFinanceJson[0].impLcOuts + tradeFinanceJson[0].impLcAccept + tradeFinanceJson[0].impLcSettled;
	var expLcTotal = tradeFinanceJson[0].expLcOuts + tradeFinanceJson[0].expLcAccept + tradeFinanceJson[0].expLcSettled;
	var impBillsTotal = tradeFinanceJson[0].impBillsOuts + tradeFinanceJson[0].impBillsAccept + tradeFinanceJson[0].impBillsSettled;
	var expBillsTotal = tradeFinanceJson[0].expBillsOuts + tradeFinanceJson[0].expBillsAccept + tradeFinanceJson[0].expBillsSettled;
	var lgTotal = tradeFinanceJson[0].lgOuts + tradeFinanceJson[0].lgSettled;
	// define correct number format
	var glblDecSep = returnDecSep();
	var glblGrpSep = returnGrpSep();
	impLCTotal = Highcharts.numberFormat(impLCTotal, 2, glblDecSep, glblGrpSep);
	expLcTotal = Highcharts.numberFormat(expLcTotal, 2, glblDecSep, glblGrpSep);
	impBillsTotal = Highcharts.numberFormat(impBillsTotal, 2, glblDecSep, glblGrpSep);
	expBillsTotal = Highcharts.numberFormat(expBillsTotal, 2, glblDecSep, glblGrpSep);
	lgTotal = Highcharts.numberFormat(lgTotal, 2, glblDecSep, glblGrpSep);
	
	$("#tradeFinanceOperationsDivId_"+_pageRef).highcharts
	({
        chart: {
            type: 'column'
           
        },

        title: {
            text: Trade_Finance_Operations_key
        },

        xAxis: {
            categories: [Import_LC_key + '<br/>Total: ' + impLCTotal, 
            	Export_LC_key+ '<br/>Total: ' + expLcTotal, 
            	Import_Bills_key+ '<br/>Total: ' + impBillsTotal, 
            	Export_Bills_key+ '<br/>Total: ' + expBillsTotal, 
            	LG_key + '<br/>Total: ' + lgTotal]
            
        },

        yAxis: {
            allowDecimals: false,
            min: 0,
            title: {
            	//Hasan Ghrayeb 955121
                text: values_key,
                align: 'low'
            }
        },

        tooltip: {
            formatter: function() {
                return this.series.name +': '+ Highcharts.numberFormat(this.y, 2, glblDecSep, glblGrpSep);
            }
        },

        plotOptions: {
        	  
       		series: 
                           {
                            minPointLength: 3
                           }
        },
        
             

        series: [{
            name: Outstanding_key,
            data: [tradeFinanceJson[0].impLcOuts, tradeFinanceJson[0].expLcOuts, 
            	tradeFinanceJson[0].impBillsOuts, tradeFinanceJson[0].expBillsOuts, 
            	tradeFinanceJson[0].lgOuts],
            stack: 'data'
        }, {
            name: Acceptance_key,
            data: [tradeFinanceJson[0].impLcAccept, tradeFinanceJson[0].expLcAccept, 
            	tradeFinanceJson[0].impBillsAccept, tradeFinanceJson[0].expBillsAccept, 
            	null],
            stack: 'data'
        }, {
            name: Settled_key,
            data: [tradeFinanceJson[0].impLcSettled, tradeFinanceJson[0].expLcSettled, 
            	tradeFinanceJson[0].impBillsSettled, tradeFinanceJson[0].expBillsSettled, 
            	tradeFinanceJson[0].lgSettled],
            stack: 'data'
        }],
        credits: {
			      enabled: false
				  }
    });
}
$(window).on('resize',function(){
    var width = $(window).width();
    
    $("#assetsLiabAccDivId_"+_pageRef).width(width);
    $("#finAppAppLinesDivId_"+_pageRef).width(width);
    $("#tradeFinanceOperationsDivId_"+_pageRef).width(width);
    $("#financingDealsDivId_"+_pageRef).width(width);
    $("#invstTreasuryDivId_"+_pageRef).width(width);
    
});
function plotBarChart()
{
   
	var valueAmountLiabJson = $.parseJSON($("#liability_"+_pageRef).val());
	var valueAmountAssetJson = $.parseJSON($("#assets_"+_pageRef).val());	
	var categories = $.parseJSON($("#categ_"+_pageRef).val());
	
	var nameLiability= Liability_Account+' '+$("#nbAccountLiabl_"+_pageRef).val();
	var nameAssets=Asset_Account+' '+$("#nbAccountAssets_"+_pageRef).val();

  	if (!$.isEmptyObject(valueAmountLiabJson) )
  	{
    
  	// define correct number format
  		var glblDecSep = returnDecSep();
  		var glblGrpSep = returnGrpSep();
  		
  	// define correct number format
  		var glblDecSep = returnDecSep();
  		var glblGrpSep = returnGrpSep();
  		
       //  var thisChart = new Highcharts.Chart
  	var chart=	$("#assetsLiabAccDivId_"+_pageRef).highcharts
         ({
        	 
        chart: 
              {
	             renderTo: "assetsLiabAccDivId_"+_pageRef,
	             reflow: true,
	            
	             height:250,
	             type: 'column'
	            
              },
         title: 
              {
                 text: Assets_And_Liabilities_key
              },
         credits: 
              {
                 enabled: false
              },
         xAxis: 
              {
                 categories: categories
              },
         yAxis: 
              {
	            gridLineColor: '#197F07',
	            gridLineWidth: 0.2,
	            labels: 
	                  {
	                    formatter: function() 
	                              {
   	                                return this.value;
	                              }
	                  },
	                  //955121-Hasan ghrayeb 
              title: {
                text: values_key,
                align: 'low'
            }
            },
         tooltip: 
                {
                  formatter: function() 
                             {
                                  if(this.series.name ==nameLiability)
				                    {	  	  
				                      return '<b>'+ this.series.name.substring(0, 17) +'</b><br/>'+
				                      this.x +': '+  Highcharts.numberFormat(Math.abs(this.y), 2, glblDecSep, glblGrpSep);
				                    }
				        	      else
				        	    	{
				        	          return '<b>'+ this.series.name.substring(0,13) +'</b><br/>'+
				                      this.x +': '+ Highcharts.numberFormat(Math.abs(this.y), 2, glblDecSep, glblGrpSep);
				        	        }
                             }
                },
          
                
          legend: 
                {
	        	 layout: 'vertical',
	             align: 'left',
	             verticalAlign: 'top',
	             useHTML:true,
	             symbolWidth: 0,
	             borderWidth:0,
	             labelFormatter: function() 
	                             { 
	                               return '<u>'+this.name+'</u>' ;
	                             }
                },
          plotOptions: 
                     {
                     column: 
                           {
		                  /*  stacking: 'normal',*/
		                    dataLabels: 
		                              {
					        			color:'black',
					        	        enabled: true,
					        	        inside: false,
					        	        align: 'left',
					        	        overflow: 'none',
					                    crop: false,
					        	        formatter: function() 
					        	                   {
                
			        	                        	if(this.y!=0 && this.y!=null )
										        		  {
											        	// return  this.y;
											        	   return Highcharts.numberFormat(Math.abs(this.y), 2, glblDecSep, glblGrpSep);
										        		  }
			                                        },
                                       },
		     
                            },
                     series: 
                           {
                            minPointLength: 3
                           }
                      },
          series: 
        	    [                {
        	        name: nameLiability ,
                    events: 
                          {
					       legendItemClick: function()
					        	            {
										      dash_assetsLiablLink(2,"2");
										      return false;
					        	            }
                          },
                    data:valueAmountLiabJson,
                    pointWidth: 60,
                    colorByPoint: true,
                    colors: ['green','green','red','red','red'],
                    negativeColor: 'red'
            
               },
        	   {
		           name: nameAssets,
		           events: 
		                 {
			        	  legendItemClick: function()
			        	                   {
								        	 dash_assetsLiablLink(1,"1");
								        	 return false;
			        	                   }
		                 },
		            data:valueAmountAssetJson,
		           // colorByPoint: true,
		            pointWidth: 40,
		            color: '#8B0000'
		          // 	colors: ['green','green','red','red','red'],		           	 	
		           // negativeColor: 'red'
                 }]
        
      
         });

    }
  	else
  	{
  		$("#"+"assetsLiabAccDivId_"+_pageRef).text(No_Data_Found_key);
  	}
}

function accountBalanceClicked()
{
	
	var cifNo         = $("#lookuptxt_cif_no_"+_pageRef).val();
    var branchCode    = $("#branchCode_"+_pageRef).val();
    var loginTypeByBr = $("#loginType_"+_pageRef).val();
	var params = {_pageRef:_pageRef,cif_no:cifNo,branchCode:branchCode,loginTypeByBr:loginTypeByBr};


if(cifNo!=null && typeof cifNo != "undefined" && cifNo !="")
	{
	var actionSrc = jQuery.contextPath+"/path/globalview/dashboardMain_loadLineChart";
	$.ajax({
		  url: actionSrc,
		  type:"post",
		  dataType:"json",
		  data : params,
		  success: function(jsonObject){
       
			  var balAccLineChart = plotLineChart("accBalViewLineChartDialog_"+_pageRef,jsonObject.accBalanceChartLiableList,jsonObject.accBalanceChartAssetList,jsonObject.dashboardSC.language);

			 $("#accBalViewLineChartDialog_"+_pageRef).dialog({modal   :true, 
				                                     title    :Available_Balance_History_key,
				                                     autoOpen:false,
				                                     show    :'slide',
				                                     position:'center', 
				                                     width   :'650',
				                                     height  :'460',
				                                  
                                                     });
 
 
 
	 			$("#accBalViewLineChartDialog_"+_pageRef).dialog("open");

		  },
		  error:function(){
			  
   			alert("error");
		  }
	})
	;
	}
else
	{
	return;
	}


}

//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen


function powerOfAttroneyClicked()
{
	
	var cifNo         = $("#lookuptxt_cif_no_"+_pageRef).val();
    var branchCode    = $("#branchCode_"+_pageRef).val();
    var loginTypeByBr = $("#loginType_"+_pageRef).val();
    
	var params = {_pageRef:_pageRef,cif_no:cifNo,branchCode:branchCode,loginTypeByBr:loginTypeByBr,update:cifNo, updates:'1',_recReadOnly:"true",openedFromDashboard:"true"};


if(cifNo!=null && typeof cifNo != "undefined" && cifNo !="")
	{
	var actionSrc = jQuery.contextPath+"/path/fom/FrontOfficeMgntMaint_openShareHolderPopup";
	_showProgressBar(true);

	$("#powerOfAttroneyDialog_" + _pageRef).load(actionSrc ,params, function() {
			_showProgressBar(false);
			$("#powerOfAttroneyDialog_"+_pageRef).dialog({modal   :true, 
                title    :'Power of Attroney',
                autoOpen:false,
                position:'center', 
                width   :returnMaxWidth(900),
                height  :returnMaxHeight(770),
               
                });
			$("#powerOfAttroneyDialog_"+_pageRef).dialog("open");
			$("#saveRecord_"+_pageRef).hide();

		});
	}
	else
		{
		return;
		}
	}

//806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen


//917789 - DBU191081  
function childCifClicked()
{
	
	var cifNo         = $("#lookuptxt_cif_no_"+_pageRef).val();

if(cifNo!=null && typeof cifNo != "undefined" && cifNo !="")
	{

	
	_showProgressBar(true);
	
	var mySrc  = jQuery.contextPath+"/path/globalview/dashChildCifMaintAction_loadChildCifMaintPage";
	
	var params={"cif_no":cifNo,"_pageRef":_pageRef,"iv_crud":"R","isLookUp":"1"};
	 

	var dialogOptions={modal:true,
			title:'',
		//		height : returnMaxHeight(500),
		//		width : returnMaxWidth(855),
			height :300,
			width:450,
			resizable: false,
			autoOpen : false,
			close : function(event, ui) {
				$("#childCifMaintDiv_id_"+_pageRef).remove();
			},
			buttons : {
				"OK" : function() {
						$("#childCifMaintDiv_id_"+_pageRef).remove();
				}
			}
		};
		
	if($("#childCifMaintDiv_id_" + _pageRef) && $("#childCifMaintDiv_id_" + _pageRef).attr('id') != undefined)
	{
		$("#childCifMaintDiv_id_" + _pageRef).dialog("destroy");
		$("#childCifMaintDiv_id_" + _pageRef).remove();
	}
	
	var alertDivElement = $('<div>',{id:"childCifMaintDiv_id_"+_pageRef});
	alertDivElement.css("padding","0");
	$('body').append(alertDivElement);
	
		 
	
	   $("#childCifMaintDiv_id_"+_pageRef).load(mySrc,params,function(){
				_showProgressBar(false);
				$("#childCifMaintDiv_id_"+_pageRef).dialog(dialogOptions);
				$("#childCifMaintDiv_id_"+_pageRef).dialog("open");
					});
	
	}


}



function plotLineChart(gridName, valueAmount1,valueAmount2, lang)
{
	
    var valueAmountJsonLiabl = $.parseJSON(valueAmount1);
  	var valueAmountJsonAssets = $.parseJSON(valueAmount2);
  
  	      
  	if (!$.isEmptyObject(valueAmountJsonLiabl) || !$.isEmptyObject(valueAmountJsonAssets) )
        	{
  	
	  		if(lang != undefined && lang != 'undefined' && lang == 'FR')
			{
		  		Highcharts.setOptions({
		  		    lang: {
		  		        months: [
		  		            'Janvier', 'Février', 'Mars', 'Avril',
		  		            'Mai', 'Juin', 'Juillet', 'Août',
		  		            'Septembre', 'Octobre', 'Novembre', 'Décembre'
		  		        ],
		  		        shortMonths: [
		  		            'Janv',	'Févr',	'Mars',	'Avril', 'Mai', 'Juin',	
		  		            'Juil',	'Août',	'Sept',	'Oct', 'Nov', 'Déc'
		  		        ]
		  		    }
		  		});
			}
  			var accountBalCharts = new Highcharts.Chart(
  				{
  				chart:
  				{
	  				type: 'spline',
	  				renderTo: gridName,
	  				 width: 630
  				},
  				plotOptiopns:{
  					spline:{
            			size: '100%',  					
  					},
  					series: 
                           {
                            minPointLength: 3
                           }
  				},
  				title:
  				{
  					text: ''
  				},
  				xAxis:
  				{
                	type: 'datetime'
                //	dateTimeLabelFormats:
                //	{
            			//month: '%b \'%y'
                    	//month: '%e. %b',
                //    	year: '%b'
                //	}
  					
            	},
            	yAxis:
            	{
                	title:
                	{
                    	text: ''
                	}
                	
            	},
            		series:
            		[
            			{
			            	id: 'Assets',  
			            	//955121-Hasan ghrayeb
			                name: Assets_Available ,
			         //       data: [],
                          
            			},
			         
            			{
			            	id: 'Liability',
			            	//955121-Hasan ghrayeb
			                name: Liabilities_Available,
			           //     data:[],
            			}
            		],
		        	credits: {
							      enabled: false
							  }
  				});
  			
  		
		if (accountBalCharts != null && accountBalCharts != undefined)
  			{
			accountBalCharts.series[0].setData(readLiablDataForBarCharts(valueAmountJsonAssets), true);
			accountBalCharts.series[1].setData(readLiablDataForBarCharts(valueAmountJsonLiabl), true);
	
  			}
  	}
  	else
     	{
    		$("#"+gridName).text(No_Data_Found_key);
    	}
  			
  	return accountBalCharts;
}


function readLiablDataForBarCharts(valueAmountJson)
{
	var arrayData = [];
	var theMonth,theYear,theAmount,now;
	
	for (i=0; i<valueAmountJson.length;i++)
  	{
		theMonth  = valueAmountJson[i].MONTH;
		theYear   = valueAmountJson[i].YEAR;
		theAmount = valueAmountJson[i].CYB_CV_VALUE * -1;
        now       =	Date.UTC(theYear, theMonth-1, 1)
		arrayData.push([now, theAmount]);
		
	}

	return arrayData;
}


/**
 * Filling the investments pie chart, with cash and holding value
 */
function plotInvestmentsPieChart(){
	var investAndTreasuryList = $("#investAndTreasuryList_"+_pageRef).val();
	var investAndTreasuryJson = $.parseJSON(investAndTreasuryList);
	var colors = ["#476B6B","#669999" ];
	
 
	
	if(investAndTreasuryJson[0] != null){
		var data =  [[$("#investTreasuryCash_"+_pageRef).val(),investAndTreasuryJson[0].investTreasury_cash],
		   		     [$("#investTreasuryHolding_"+_pageRef).val(), investAndTreasuryJson[0].investTreasury_holding]];
		
	    plotPieChart("investmentPieChart_"+_pageRef, data,investAndTreasuryJson[0].decimal_points,colors);
	}
}

function plotTreasuryPieChart(){
	var investAndTreasuryList = $("#investAndTreasuryList_"+_pageRef).val();
	var investAndTreasuryJson = $.parseJSON(investAndTreasuryList);
	
	var colors = ["#29527A","#5C85AD","	#85A3C2"];
	 
	if(investAndTreasuryJson[0] != null){
		var data =  [["Forex",investAndTreasuryJson[0].investTreasury_forex],
		   		     ["Money Market", investAndTreasuryJson[0].investTreasury_moneyMarket],
		   		     ["Islamic Derivative", investAndTreasuryJson[0].investTreasury_islamicDerivatives]
		   		    	 
		   		    	 ];
		
	    plotPieChart("treasuryPieChart_"+_pageRef, data,investAndTreasuryJson[0].decimal_points,colors);
	}
}


function plotFinancingDealsChart(){
	var financingDealsList = $("#financeDealsList_"+_pageRef).val();
	var financingDealsJSON = $.parseJSON(financingDealsList);	
	var assetObj = null;
	var liabObj = null;
	var indirectLiabObj =null;
	
	$( financingDealsJSON ).each(function( index,obj ) {
  		if( obj.categoryId=="A" ){  //asset			
  			assetsData=  [	
				["Settled",obj.settledAmt],
		   		["Outstanding", obj.outstandingAmt],
		   		["Overdue", obj.overdueAmt]
		   		     ]; 	
  			assetObj = obj;
  		}
  		else if(obj.categoryId=="L"){//liability
  			liabilityData=  [	
				["Settled",obj.settledAmt],
		   		["Outstanding", obj.outstandingAmt],
		   		["Overdue", obj.overdueAmt]
		   		     ];
  			liabObj = obj;
  		}
  		else if(obj.categoryId=="I"){//indirect liability
  			indirectLiabilityData=  [	
				["Settled",obj.settledAmt],
		   		["Outstanding", obj.outstandingAmt],
		   		["Overdue", obj.overdueAmt]
		   		     ];
  			indirectLiabObj = obj;
  			}  		
		});
 
	$("#financingDealsDivId_"+_pageRef).html("<table  id='financingDealsTable_"+_pageRef+"' width='100%'><tr ></tr><tr></tr></table>");
	var financingDealsPieChartTblRow = $("#financingDealsTable_"+_pageRef+" > tbody tr:first")
	//DBU190980 START
	financingDealsPieChartTblRow.append("<td width='33%'><div id='financingDealsAssets_"+_pageRef+"' chartName='"+Financing_Deals_key+" : "+Liabilities_key+"'></div></td>");
	financingDealsPieChartTblRow.append("<td width='33%'><div id='financingDealsLiability_"+_pageRef+"'  chartName='"+Financing_Deals_key+" : "+Assets_key+"'></div></td>");
	financingDealsPieChartTblRow.append("<td width='33%'><div id='financingDealsIndirectLiability_"+_pageRef+"' chartName='"+Financing_Deals_key+" : "+indirect_assets_key+"'></div></td>");
	var  colors  = [ '#336600', '#660033', '#FF0000'];	
	plotPieChart("financingDealsAssets_"+_pageRef,assetsData,assetObj.decimalPoints,colors);
	plotPieChart("financingDealsLiability_"+_pageRef,liabilityData,liabObj.decimalPoints,colors);
	plotPieChart("financingDealsIndirectLiability_"+_pageRef,indirectLiabilityData,indirectLiabObj.decimalPoints,colors);
	
	var financingDealsBarChartTblRow = $("#financingDealsTable_"+_pageRef+" > tbody tr:last")
	financingDealsBarChartTblRow.append("<td width='33%'><div id='financingDealsAssetsBarChart_"+_pageRef+"' chartName='"+Liabilities_key+"'></div></td>");
	financingDealsBarChartTblRow.append("<td width='33%'><div id='financingDealsLiabilityBarChart_"+_pageRef+"'  chartName='"+Assets_key+"'></div></td>");
	financingDealsBarChartTblRow.append("<td width='33%'><div id='financingDealsIndirectLiabilityBarChart_"+_pageRef+"' chartName='"+indirect_assets_key+"'></div></td>");	
	plotFinancingDealsBarChart("financingDealsAssetsBarChart_"+_pageRef,assetObj);
	plotFinancingDealsBarChart("financingDealsLiabilityBarChart_"+_pageRef,liabObj);
	plotFinancingDealsBarChart("financingDealsIndirectLiabilityBarChart_"+_pageRef,indirectLiabObj);
	//DBU190980 END
	
}

function plotInvestmentAndTreasuryChart(){
	$("#invstTreasuryDivId_"+_pageRef).html("<table  id='investmentAndTreasuryTable_"+_pageRef+"' width='100%'><tr></tr></table>");
	var investmentAndTreasuryPieChartTblRow = $("#investmentAndTreasuryTable_"+_pageRef+" > tbody tr:first")
	investmentAndTreasuryPieChartTblRow.append("<td width='50%'><div id='investmentPieChart_"+_pageRef+"' chartName='"+Investments_key+"'></div></td>");
	investmentAndTreasuryPieChartTblRow.append("<td width='50%'><div id='treasuryPieChart_"+_pageRef+"'  chartName='"+Treasury_key+"'></div></td>");	
	plotInvestmentsPieChart();	
	plotTreasuryPieChart();
	
}


function plotFinancingDealsBarChart(gridName,obj){	 

   if (!$.isEmptyObject(obj) )
  	{
	   
	  
	   
    
         var thisChart = new Highcharts.Chart        
        ({
            chart: {
                type: 'column',
                renderTo: gridName,                
	            height:200
	            
            },
            title: {
                text: ''
            } ,
            xAxis: {
                type: 'category',                             
   				labels: {
       			enabled: true
   				},
   				
   				
            },
            yAxis: {
                min: 0,
                title: {
                    text: ' '
                },            	
   				labels: {
      			 enabled: true
   				},
   				minorGridLineWidth :0
  				
            },
            legend: {
                enabled: false
            },
            credits: 
              {
                 enabled: false
              },
            series: [{
                name: '',
                data: [
                    ['Guarantees', obj.guarantees],
                    ['Collaterals', obj.collaterals],
                    ['Promissory Notes', obj.promissoryNotes]
                 
                   
                   
                ],
                dataLabels: {
                    enabled: true,
                      formatter: function () {             						
		    						return	$.formatNumberNumeric(this.point.y, {format: returnNbFormat(obj.decimalPoints)} );
		    					
		                   		}
                   
                }
            }]
        });
   
	}

}

function plotFinancingApplicationsBarChart(){	 
	var obj = $.parseJSON($("#finAppAndAppList_"+_pageRef).val());
	
   if (!$.isEmptyObject(obj) )
  	{	 
	   
	   
    	var gridName = "finAppAppLinesDivId_"+_pageRef;
    	var chartName =  $("#"+gridName).attr("chartName");
    	var finAppList = $("#finAppList_"+_pageRef).val();
    	var decPoint = obj[0].decimal_points;
    	finAppList = $.parseJSON(finAppList);
    	// define correct number format
  		var glblDecSep = returnDecSep();
  		var glblGrpSep = returnGrpSep();
  		
    	// define correct number format
  		var glblDecSep = returnDecSep();
  		var glblGrpSep = returnGrpSep();
  		
         var thisChart = new Highcharts.Chart        
        ({
            chart: {
                type: 'column',
                renderTo: gridName,                
	            reflow: true,
	            
	            height:250
            },
            title: {
               text: chartName
            } ,
            credits: {
                 enabled: false
			},
            xAxis: {
                 categories: finAppList
            },
            yAxis: {
            	gridLineColor: '#197F07',
	            gridLineWidth: 0.2,
                min: 0,
                minorGridLineWidth :0,
                //955121-Hasan Ghrayeb
          	  	title: {
                  text: values_key,
                  align: 'low'
          	  	},
                labels: {
					formatter: function() {
						return this.value;
						}
					}
            },
            tooltip: {
				formatter: function() {
					return '<b>'+ chartName +'</b><br/>'+
				    this.x +': '+ Highcharts.numberFormat(this.y, decPoint, glblDecSep, glblGrpSep);
				}
			},
            legend: {
                enabled: false
            },
            
            
            series: [{
                name: 'Financing Applications And Approved Lines',
                data: [
                    ['Approved Lines',obj[0].approvedLines], 
					['New Applications',obj[0].newApplications], 
					['Blocked Or Suspended Facility',obj[0].blockedOrSuspFac], 
					['Collaterals',obj[0].collaterals], 
					['Guarantees',obj[0].guarantees],
					['Drawdown',obj[0].drawdowns] // TP#674453;BMOUPI180297;Clint.Joy;16/07/2018
                ],
                colorByPoint: true,
                negativeColor: 'blue',
                dataLabels: {
                    enabled: true,
                      formatter: function () { 	
		    						return	$.formatNumberNumeric(this.point.y, {format: returnNbFormat(decPoint)} );
		                   		}
                }
            }]
        });
   
	}
}
/**
 * antonella BMOI130009
 * added to open the Account lookup with the cifs related to the id no retrieved from the card reader
 * @returns
 */
function dashboard_onCardReaderClicked()
{
 //	 var src  = jQuery.contextPath+'/path/cardreader/cardReaderMaint_returnKhatmURL'; 

	 var src  = jQuery.contextPath+'/path/cardreader/cardReaderMaint_loadIframeJSP'; 
			var params = {  'fromWhere' : "DGR" ,
					        'fromMethod' : "retrieve"}; 
			
		$.ajax({
			url : src,
			type : 'post',
			data: params,
			beforeSend : function() {
				
				_showProgressBar(true);
			},
			success : function(HTML) {
				_showProgressBar(false);
				  
				$("#khatmCardReaderURLDiv_id_"+_pageRef).html(HTML);
				
				$("#khatmCardReaderURLDiv_id_"+_pageRef).dialog({modal:true, 
	                title: 'Khatm Card Reader',
	                autoOpen:false,
	                show:'slide',
	                width:returnMaxWidth(1000),
	                height:returnMaxHeight(500),
	                position:'center' });
					$("#khatmCardReaderURLDiv_id_"+_pageRef).dialog("open"); 
		        
			 
			}
		}); 
 
	_showProgressBar(false);
}

function dashboard_FMSApprovedDrawdownDetailsClicked(ddCode, branchCode,  cif, facilityCategory){ 
	 var iv_crud = "Q";
	 var financialDealDetailsDiv = $("<div id='financialDealDetailsDiv_id_"
	   + _pageRef + "' style='width:" + returnMaxWidth(1023) + ";height:"
	   + returnMaxHeight(501) + ";border:0px;overflow:hidden;'/>");

	 var theForm = $("#dashboardFormId");
	 var dashfinancialDealDetailsDiv = $(financialDealDetailsDiv);
	 theForm.append(dashfinancialDealDetailsDiv);
	 dashfinancialDealDetailsDiv.insertAfter(theForm);

	 var mySrc = "/path/drawdownrequest/DrawdownRequestMaint_drawDownrequestEditPage";
	 
	 var params = {
	  "drawdownRequestCO.drawDownCode" : ddCode,
	  "drawdownRequestCO.cifNo" : cif,
	  "drawdownRequestCO.facilityCategory" : facilityCategory,
	  "iv_crud" : iv_crud,
	  "_pageRef" : "T009Q",
	  "drawdownRequestCO.branchCode" : branchCode
	 };
	 
	 
	 var currentAppName = 'FMS';
	 var iFrameUrl = jQuery.contextPath + '/path-default/loadIframeScreenAction';
	 var iFrameParam = {};
	 iFrameParam["destinationProgRef"] = "T009Q";
	 iFrameParam["appName"] = currentAppName;
	 iFrameParam["destinationUrl"] = mySrc;
	 iFrameParam["additionalParams"] = JSON.stringify(params);
	 
	 dashfinancialDealDetailsDiv.dialog( {
	  modal : true,
	  title : Drawdown_Details_key,
	  autoOpen : false,
	  position : 'center',
	  height : returnMaxHeight(501),
	  width : returnMaxWidth(1023),
	  close : function() {
	   $("#financialDealDetailsDiv_id_" + _pageRef).dialog("destroy");
	   $("#financialDealDetailsDiv_id_" + _pageRef).remove();
	  },
	  open : function() {
	  }
	 });

	 
	 $(dashfinancialDealDetailsDiv).load(iFrameUrl, iFrameParam, function() {
	  $("#financialDealDetailsDiv_id_" + _pageRef).dialog("open");
	 });
	}

function fmsFacilityDetVO_LINE_NBR_Formatter(cellValue, options, rowObject) 
{
	return '<a href ="#" onclick= "javascript:loadApprovedLinesDrawDownDetailList(' + rowObject.fmsFacilityDetVO.BRANCH+','+ rowObject.fmsFacilityDetVO.CODE+','+ rowObject.fmsFacilityDetVO.LINE_NBR
				+ ');">' + cellValue + '</a>';
}


//Rania - ABSAI180073 - FICA Risk Matrix calculation
function dashboard_onClickMoreScoresBtn()
 {
	var mySrc = ctxPath
			+ "/path/fom/FrontOfficeMgntMaint_loadDashScoreDescriptionListPopup.action";

	var params = {};
	params["cifNo"] = $('#lookuptxt_cif_no_' + _pageRef).val();

	$("#dashboardScoreDescriptionList_" + _pageRef).load(mySrc, params,
			function() {
				_showProgressBar(false);
			});

	$("#dashboardScoreDescriptionList_" + _pageRef).dialog(
			{
				modal : true,
				title : 'More Scores',
				autoOpen : false,
				show : 'slide',
				position : 'center',
				width : '1100',
				height : '500',
				buttons : {
					"ok" : function() {
						$("#dashboardScoreDescriptionList_" + _pageRef).dialog(
								'close');
					}
				},
				"close" : function() {
					$("#dashboardScoreDescriptionList_" + _pageRef).dialog(
							'close');
				}
			});

	$("#dashboardScoreDescriptionList_" + _pageRef).dialog("open");
}
//

function changeTheValueDGR(fromWhere,id, value)
{	
	
  $("#" + id  + _pageRef).val(value);
  $("#spanLookup_cif_no_"+ _pageRef).click();
  $("#khatmCardReaderURLDiv_id_"+_pageRef).dialog("close"); 
}

//Bassam - 926127 - Copied from Rania - ABSAI180073 - FICA Risk Matrix calculation
function dashboard_onClickMoreScoresBtn()
 {
	var queryDiv = $("<div id='dashboardScoreDescriptionDiv_"+_pageRef + "' style='width:"+ returnMaxWidth(1023)+";height:"+returnMaxHeight(501)+";border:0px;overflow:hidden;'/>");
	var theForm = $("#dashboardFormId");
	
	var newQueryDiv = $(queryDiv);
	theForm.append(newQueryDiv);
	
	newQueryDiv.insertAfter(theForm);
	
	var params = {};
	params["cifNo"] = $('#lookuptxt_cif_no_' + _pageRef).val();
	
	var currentAppName = 'RET';
	var iFrameUrl = jQuery.contextPath+'/path-default/loadIframeScreenAction';
	var iFrameParams = {};
	iFrameParams["destinationProgRef"] = "F00I1";
	iFrameParams["appName"] = currentAppName;
	iFrameParams["destinationUrl"] = "/path/fom/FrontOfficeMgntMaint_loadDashScoreDescriptionListPopup.action";
	iFrameParams["additionalParams"] = JSON.stringify(params);
	
	newQueryDiv.dialog( {
		modal : true,
		title : 'More Scores',
		autoOpen : false,
		position : 'center',
		height : returnMaxHeight(501),
		width : returnMaxWidth(1023),
		close : function() {
			$("#dashboardScoreDescriptionDiv_"+_pageRef ).dialog("destroy");
			$("#dashboardScoreDescriptionDiv_"+_pageRef ).remove();
		},
		open : function() {
		}
	});

	$(newQueryDiv).load(iFrameUrl,iFrameParams,
			function() 
			{
				$("#dashboardScoreDescriptionDiv_"+_pageRef ).dialog("open");
			});
}
//


// DBU191081 Muhammed Anas Start
 function treasuryForexDetails(cellValue, options, rowObject){
 	return '<a href ="#" onclick= "javascript:dashboard_treasuryForexDetailsClicked();">' + currencyFmatter(cellValue,options, rowObject) + '</a>';
 }

 function dashboard_treasuryForexDetailsClicked(){
 	var cifNo = $("#lookuptxt_cif_no_"+_pageRef).val();
 	var loginTypeByBr = $("#loginType_"+_pageRef).val();
 	src = jQuery.contextPath+"/path/globalview/financingDealsListAction_loadTreasuryForexDealsGrid?financingDealsSC.cifNo="+cifNo+"&_pageRef="+_pageRef+"&financingDealsSC.category=L&financingDealsSC.appName=ITRS&financingDealsSC.branchFilter="+dashboard_getFinancingDealsBranchFilter(loginTypeByBr);	 	
 	openPage(src);

 }
 // DBU191081 Muhammed Anas End


// added by nancy- 01/02/2017-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
function postDatedBalancesLinkFormatter(cellValue, options, rowObject){
	//apply format on the value
	return '<a href = "#" onclick="openpostDatedBalForAccount(' + options.rowId + ',\''+options.colModel.name+'\');" >'+ currencyFmatter(cellValue, options, rowObject) +'</a>';
}

/**
 * Description : this function will open a grid in modal dialog to populate the postdated cheques balances related for the selected account
 */
function openpostDatedBalForAccount(selectedRowId,colname){
    _showProgressBar(true);
	var	postDatedBalAccDiv = $("<div id='postDatedBalForAccounts_div_"+_pageRef+"'/>");
	postDatedBalAccDiv.css("padding","0");
	postDatedBalAccDiv.insertAfter('body');
    
    var selectedRowObj = returnDashAccDetRow(selectedRowId);
    var accBr = selectedRowObj["branchCode"];
    var currencyCode = selectedRowObj["currencyCode"];
    var glCode = selectedRowObj["glCode"];
    var cif_no = unformatNumber( $("#lookuptxt_cif_no_"+_pageRef).val());
    var slNo = selectedRowObj["slNo"];
    
    var actionSrc = jQuery.contextPath+"/path/globalview/DashAccDetailsLoadAction_loadpostDatedBalForAccPage";
	var curParams = {"accBr" : accBr, "currencyCode" : currencyCode,"glCode" : glCode,"cif_no" : cif_no, "slNo":slNo,"_pageRef" : _pageRef, "colname":colname};
	postDatedBalAccDiv.load(actionSrc, curParams, function() {
	_showProgressBar(false);
	postDatedBalAccDiv.dialog({modal:true, 
                           show:'slide',
                       position:'center', 
                         width:returnMaxWidth(1000),
                         height:returnMaxHeight(250),
                     	  close:function (){
 								  var theDialog = $(this);
 								  theDialog.remove();
								}});
    postDatedBalAccDiv.dialog("open");
	});
}
// end nancy
