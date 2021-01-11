

function trxTypeChargesGrid_Id_ChargeBtnFormatter(cellValue, options, rowObject) {	
		return '<a href ="#" onclick= "javascript:trxChargesSchemaGrid_Id_ChargesDetailBtn_Clicked(' + options.rowId
				+ ');">' + charges_Details_key + '</a>';		
}
// Function called upon Charges hyperlink clicked 
function trxChargesSchemaGrid_Id_ChargesDetailBtn_Clicked(rowindex)
{
	$("#trxChargesSchemaGrid_Id_" + _pageRef).jqGrid('setSelection',
			rowindex);		
	var chargesSchemaGrid = $("#trxChargesSchemaGrid_Id_" + _pageRef);//Trx Type Grid
	var schemaNo = chargesSchemaGrid.jqGrid('getCell', rowindex,'ctsChargesSchemaVO.CHARGE_CODE');	
	var schemaUrl = jQuery.contextPath + '/path/fom/ChargesSchemaCommon_loadChargesDetail?schemaCode='+schemaNo+'&_pageRef='+_pageRef;
	$("#maintenenceChargesSchemaDetailMainDiv_" + _pageRef).html('');		
	$("#maintenenceChargesSchemaDetailMainDiv_" + _pageRef).show();		
	$("#maintenenceChargesSchemaDetailMainDiv_" + _pageRef).load(schemaUrl);// Load Sub Section
	if ($("#trxTypeChargesGridDiv_Id_" + _pageRef).length)
		$("#trxTypeChargesGridDiv_Id_" + _pageRef).hide();
	if ($("#reasonChargesGridDiv_Id_" + _pageRef).length)
		$("#reasonChargesGridDiv_Id_" + _pageRef).hide();
	$("#chargesSchemaDetailDiv_content_id_" + _pageRef).hide();	
	$("#trxChargesSchemaDetailsGrid_main_" + _pageRef).hide();	
	$("#btn_back_fomPackageChargesGrid_"+_pageRef).css("display","none");
	$("#trxType_" + _pageRef).hide();		
//	$("#fomTrxTypeChargesDialog_" + _pageRef).hide();		
}
function trxChargesBackButtonClick()
{	
	if ($("#trxTypeChargesGridDiv_Id_" + _pageRef).length)
		$("#trxTypeChargesGridDiv_Id_" + _pageRef).show();
	if ($("#reasonChargesGridDiv_Id_" + _pageRef).length)
		$("#reasonChargesGridDiv_Id_" + _pageRef).show();
	$("#chargesSchemaDetailDiv_content_id_" + _pageRef).show();	
	$("#trxChargesSchemaDetailsGrid_main_" + _pageRef).show();	
	$("#trxType_" + _pageRef).show();	
	$("#maintenenceChargesSchemaDetailMainDiv_" + _pageRef).hide();	
	$("#btn_back_fomPackageChargesGrid_"+_pageRef).css("display","");
//	$("#excemptedInBranchesGridMain_Id_" + _pageRef).hide();	
//	$("#trxChargesSchemaBackBtnDiv_id_" + _pageRef).hide();	
	}

// Show Hide mechanism for Foreign CY Charge Grid
function fOMTrx_showHideForeignCYChargeGrid()
{
	if($("#fom_foreignCYChargeGridTr_"+_pageRef).attr("style") == "visibility: collapse;")
	{
		$("#fom_foreignCYChargeGridTr_"+_pageRef).attr("style","visibility: visible;");
		$("#fom_foreignCYChargeTiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: visible;");
		$("#fom_tiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: collapse;");
	}
	else
	{
		$("#fom_foreignCYChargeGridTr_"+_pageRef).attr("style","visibility: collapse;");
		$("#fom_foreignCYChargeTiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: collapse;");
	}
	
	//[EAOUN] IE9 grid resize issue
	resizeSingleGrid("foreignCYChargeGrid_Id_" + _pageRef);
}

// Show Hide mechanism for Tiers Grid
function fOMTrx_showHideTiersGrid()
{
	if($("#fom_tiresdetailsGridGridTr_"+_pageRef).attr("style") == "visibility: collapse;")
	{
		$("#fom_tiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: visible;");
		$("#fom_foreignCYChargeGridTr_"+_pageRef).attr("style","visibility: collapse;");
		$("#fom_foreignCYChargeTiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: collapse;");
	}
	else
	{
		$("#fom_tiresdetailsGridGridTr_"+_pageRef).attr("style","visibility: collapse;");
	}
	
	//[EAOUN] IE9 grid resize issue
	resizeSingleGrid("tiresdetailsGrid_Id_" + _pageRef);
}

// Show Hide mechanism for Excempted In Branches Grid
function fOMTrx_showHideExcemptedInBranchesGrid()
{
	if($("#fom_excemptedInBranchesGridTr_"+_pageRef).attr("style") == "visibility: collapse;")
	{
		$("#fom_excemptedInBranchesGridTr_"+_pageRef).attr("style","visibility: visible;");
	}
	else
	{
		$("#fom_excemptedInBranchesGridTr_"+_pageRef).attr("style","visibility: collapse;");
	}
	
	//[EAOUN] IE9 grid resize issue
	resizeSingleGrid("excemptedInBranchesGrid_Id_" + _pageRef);
}

function foreignCYChargeGrid_Id_TiersBtnFormatter(cellValue, options, rowObject) {	
		return '<a href ="#" onclick= "javascript:foreignCYChargeGrid_Id_TiersBtn_Clicked(' + options.rowId
				+ ');">' + tiers_key + '</a>';		
}

function foreignCYChargeGrid_Id_TiersBtn_Clicked(rowindex) {
	
	var foreignGrid = $("#foreignCYChargeGrid_Id_" + _pageRef);
	foreignGrid.jqGrid('resetSelection').jqGrid('setSelection',rowindex);// Select the clicked row of hyperlink.
	var cyCode 		= foreignGrid.jqGrid('getCell', rowindex,'ctsChargesCurrencyVO.CY_CODE');
	var chargeCode  = foreignGrid.jqGrid('getCell', rowindex,'ctsChargesCurrencyVO.CHARGE_CODE');

	//var lookupUrl = jQuery.contextPath	+ '/path/fom/MaintenenceChargesGridAction_loadTireDetailsGrid';
	var arr={};
	arr["criteria.currencyCode"] =	cyCode;
	arr["criteria.code"] 		=	chargeCode;
	arr["_pageRef"] 			= 	_pageRef;
	var mySrc = ctxPath
			+ "/path/fom/MaintenenceChargesGridAction_populateForeignChargesTierPopup.action";

	var popupDiv = $("<div id='foreignCYChargeTiresdetailsGridDiv_"+_pageRef+"'/>");
	popupDiv.dialog( {
							autoOpen : false,
							modal : true,
							title : foreign_CY_Charge_key+" - "+tiers_key,
							hide : 'clip',
							height	:returnMaxHeight(300),
							width : returnMaxWidth(750),
							close : function(ev, ui) {
								$(this).dialog("destroy");
								$(this).remove();
								}
						});
	var popupButtons = {};
	popupButtons["Cancel"] 	= {text:ok_label_trans,	id:"foreignCYChargeTiresdetailsDiv_ok_btn_"+ _pageRef,	click: function(){$(this).dialog("destroy");$(this).remove();}}
	popupDiv.dialog('option', 'buttons', popupButtons);
	$("#foreignCYChargeTiresdetailsGridDiv_" + _pageRef).load(
							mySrc,arr,
							function() {
								popupDiv.dialog("open");
								var gridParentWidth = $('#gbox_foreignCYChargeTiresdetailsGrid_Id_'+_pageRef ).parent().width(); 
								$('#foreignCYChargeTiresdetailsGrid_Id_'+_pageRef ).jqGrid("setGridWidth",gridParentWidth);
						});
//	jQuery("#foreignCYChargeTiresdetailsGrid_Id_" + _pageRef).jqGrid('setGridParam', {
//		url : lookupUrl,
//		datatype : 'json',
//		postData: arr
//	}).trigger("reloadGrid");
}
    