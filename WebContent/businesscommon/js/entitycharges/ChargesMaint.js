function onLoadChargesMaint()
{
    $("div#requestInfoChargesDiv_"+_pageRef+".collapsibleContainer").collapsiblePanel();
    $("#requestInfoChargesDiv_"+_pageRef +" .collapsibleContainerTitle").click(requestDetRrequest_ChargesDetailsClk);
}

function requestDetRrequest_paymentTypeChange()
{
	$("#chr_ac_br_"+_pageRef+",#chr_ac_cy_"+_pageRef+",#chr_ac_gl_"+_pageRef+",#chr_ac_cif_"+_pageRef
		+",#lookuptxt_chr_ac_sl_"+_pageRef
		+",#lookuptxt_chr_ac_add_ref_"+_pageRef
		+",#chr_ac_desc_"+_pageRef).val("");
	
	requestDetRrequest_emptyOfChargeGrid();
}

function requestDetRrequest_emptyOfChargeGrid()
{
	$("#chargesGridEmptied_"+_pageRef).val("true");
	$("#requestInfoChargesDiv_"+_pageRef).addClass("collapsed");
	$("#requestInfoChargesDiv_"+_pageRef+" .collapsibleContainerContent").attr("style","display: none;");
	$("#requestInfoCharges_"+_pageRef).empty();
}

function requestDetRrequest_setAccountData(src)
{
	var selectedRowId = $("#gridtab_"+src+"_"+_pageRef).jqGrid('getGridParam','selrow');
	var myObject = $("#gridtab_"+src+"_"+_pageRef).jqGrid('getRowData',selectedRowId);

	$("#chr_ac_desc_"+_pageRef).val(myObject["amfVO.BRIEF_NAME_ENG"]);
  	$("#lookuptxt_chr_ac_add_ref_"+_pageRef).val(myObject["amfVO.SL_NO"]);
	$("#chr_ac_br_"+_pageRef).val(myObject["amfVO.BRANCH_CODE"]);
	$("#chr_ac_cy_"+_pageRef).val(myObject["amfVO.CURRENCY_CODE"]);
	$("#chr_ac_gl_"+_pageRef).val(myObject["amfVO.GL_CODE"]);
	$("#chr_ac_cif_"+_pageRef).val(myObject["amfVO.CIF_SUB_NO"]);
	$("#lookuptxt_chr_ac_add_ref_"+_pageRef).val(myObject["amfVO.ADDITIONAL_REFERENCE"]);
	$("#lookuptxt_chr_ac_sl_"+_pageRef).val(myObject["amfVO.SL_NO"]);
	requestDetRrequest_emptyOfChargeGrid();
}

function requestDetRrequest_ChargesDetailsClk()
{
	var alertApprove = "";
	if($("#isFromAlert_"+_pageRef).val() == "true" && $("#isLocalApprove_"+_pageRef).val() == "true")
	{
		alertApprove = "1";
	}
	_showProgressBar(true);

	var chargesParam  = {"entityChargesCO.entityCode" 			: $("#requestDetRequestNo_" + _pageRef).val(),
						 "entityChargesCO.accBranch" 			: $("#chr_ac_br_"+_pageRef).val(),
						 "entityChargesCO.accCurrency" 			: $("#chr_ac_cy_"+_pageRef).val(),
						 "entityChargesCO.accGL" 				: $("#chr_ac_gl_"+_pageRef).val()-0,
						 "entityChargesCO.accCIF" 				: $("#chr_ac_cif_"+_pageRef).val()-0,
						 "entityChargesCO.accSL" 				: $("#lookuptxt_chr_ac_sl_"+_pageRef).val(),
						 "entityChargesCO.deductCharges"		: $("#paymentType_"+_pageRef).val(), // $("#paymentType_"+_pageRef).find(":selected").text(),
						 "entityChargesCO.chargeAccBranch"   	: $("#chr_ac_br_"+_pageRef).val(),
						 "entityChargesCO.chargeAccCurrency" 	: $("#chr_ac_cy_"+_pageRef).val(),
						 "entityChargesCO.chargeAccGL" 			: $("#chr_ac_gl_"+_pageRef).val(),
						 "entityChargesCO.chargeAccCIF" 		: $("#requestCif_"+_pageRef).val(),//$("#chr_ac_cif_"+_pageRef).val(),
						 "entityChargesCO.chargeAccSL" 			: $("#lookuptxt_chr_ac_sl_"+_pageRef).val(),
						 "entityChargesCO.isEmptied" 			: $("#chargesGridEmptied_"+_pageRef).val(),
						  "entityChargesCO.crud" 				: $("#requestInfoIvcrud_"+_pageRef).val(),
						 "entityChargesCO.entityType" 			: "REQ",
						 "entityChargesCO.tradeSerialNbr"		: $("#trade_serial_nbr_"+_pageRef).val(),
						 "entityChargesCO.entityTypeCode" 		: $("#lookuptxt_requestDetRrequestType_"+_pageRef).val(),
						 "_recReadOnly" 						: $("#_recReadOnly_"+_pageRef).val(),
						 "entityChargesCO.numOfEntities" 		: $("#number_of_bills_"+_pageRef).val(),
						 "iv_crud" 								: $("#requestInfoIvcrud_"+_pageRef).val(),
						 "_pageRef" : _pageRef};

	if($("#chargesGridEmptied_"+_pageRef).val()=="true") //recalculate the charges section
	{	 
		$("#requestInfoCharges_" + _pageRef).load(jQuery.contextPath+"/path/requests/CtsRequestMaintAction_loadChargesSection",chargesParam,
			function() {
				$("#chargesGridEmptied_"+_pageRef).val('false');
				_showProgressBar(false);
			});
	}
	else
	{
		if($("#requestInfoCharges_" + _pageRef).is(":empty"))
		{
			$("#requestInfoCharges_" + _pageRef).load(jQuery.contextPath+"/path/requests/CtsRequestMaintAction_loadChargesSection",chargesParam,
			function() {
				_showProgressBar(false);
			});
		}
		else
		{
			_showProgressBar(false);
		}
	}
}

function requestDetRrequest_AccAfterDep(src)
{
	var self = $("#srcformId_"+_pageRef).val();
	var theform = document.getElementById(self);
 //	$.data(theform , 'changeTrack',true);
	requestDetRrequest_emptyOfChargeGrid()
}