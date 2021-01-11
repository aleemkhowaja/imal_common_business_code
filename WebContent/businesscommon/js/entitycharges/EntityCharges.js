function safebox_waiveCharges( chargeGridId){
	waiveCharges( chargeGridId)
}

function waiveCharges( chargeGridId)
{
	var local_pageRef = typeof chargeGridId == 'undefined'? _pageRef : _pageRef + "" + chargeGridId
	var grid = $("#chargesGridId_hid_"+local_pageRef).val();
	$(grid).jqGrid("resetSelection");

	var dataObj = { "gridJsonStr": returnChargesGridUpdates(chargeGridId),
					"crud" 	: $("#chargesGridCrud_"+local_pageRef).val() }
	$.ajax({
		  url: jQuery.contextPath+"/path/entitycharges/EntityCharges_waiveCharges",
		  type:"post",
		  dataType:"json",
		  data: dataObj,
		  success: function(data)
		  {
				if(data["_error"] == null)
				{
					var rows = $(grid).jqGrid('getDataIDs');
					var rowsLen = rows.length;
				
					for(i=rowsLen-1; i>=0; i--)
					{
						$(grid).jqGrid('delRowData',rows[i]);
					}
					$("#isWaived_"+local_pageRef).val("true");
					$("#chargesGridEmptied_"+local_pageRef).val("false");
					$("#schemaCharges_"+local_pageRef).val("");
				}
          }
	});
}


function onChangeAmount(gridId,baseForeign,columnName,local_pageRef) {		 
		var selRow  = $(gridId).jqGrid('getGridParam','selrow');
  		var ctsChargesEntityVO = $(gridId).jqGrid('getRowData',$(gridId).jqGrid('getGridParam','selrow'));
  		
  		var entityType=$("#chargesGridEntityType_"+local_pageRef).val();
  		var entityCode=$("#chargesGridEntityCode_"+local_pageRef).val();
	  	var accBranch = $("#chargesGridAccBranch_"+local_pageRef).val();
		var accountCY = $("#chargesGridAccCurrency_"+local_pageRef).val();
		var deductCharges = $("#chargesGridDeductCharges_"+local_pageRef).val();
		var chargeAccBranch = $("#chargesGridChargeAccBranch_"+local_pageRef).val();
		var chargeAccCurrency = $("#chargesGridChargeAccCurrency_"+local_pageRef).val();
  		var originalCode = $("#chargesGridOriginalCode_"+local_pageRef).length!=0?$("#chargesGridOriginalCode_"+local_pageRef).val():"";	
		var isEmptied = $("#chargesGridIsEmptied_"+local_pageRef).length!=0?$("#chargesGridIsEmptied_"+local_pageRef).val():"";
		var cardType = $("#chargesGridCardType_"+local_pageRef).val();
		var briefDescEngBase = $("#chargesGridBriefDescEngBase_"+local_pageRef).val();
		var entityCommand = $("#chargesGridEntityCommand_"+local_pageRef).val();
		var crud = $("#chargesGridCrud_"+local_pageRef).val();
		var schemaDestroy = $("#chargesGridSchemaDestroy_"+local_pageRef).val();
		var schemaCancel = $("#chargesGridSchemaCancel_"+local_pageRef).val();
		var isRepeat = $("#chargesGridIsRepeat_"+local_pageRef).val();
		var proceed = $("#chargesGridProceed_"+local_pageRef).length!=0?$("#chargesGridProceed_"+local_pageRef).val():"";
		var numOfEntities = $("#chargesGridNumOfEntities_"+local_pageRef).length!=0?$("#chargesGridNumOfEntities_"+local_pageRef).val():"";
		var prevValue = $(gridId).jqGrid("getCellInputElt",$(gridId).jqGrid('getGridParam','selrow'), columnName).attr("prevValue")
		var acc_gl 	= $("#chargesGridaccGL_"+local_pageRef).val();
		var acc_cif = $("#chargesGridaccCIF_"+local_pageRef).val();
		var acc_sl 	= $("#chargesGridAccSL_"+local_pageRef).val();
		//#553923 -DASI170045 - Commission on Cheque Deposit
		var certificateCode = $("#certificateCode_"+local_pageRef).val();
		/*TO BE REMOVED
		if(entityType == "CHQ")
  		{
  			accBranch 			= $("#acc_br_"+_pageRef).val();
  			accountCY 			= $("#acc_cy_"+_pageRef).val();
  			deductCharges 		= $("#deductCharges_"+_pageRef).val();
  			chargeAccBranch 	= $("#chr_ac_br_"+_pageRef).val();
  			chargeAccCurrency 	= $("#chr_ac_cy_"+_pageRef).val();
  		}
  		else
  		{
  			accBranch = $("#safeBoxMgmtAccBr_"+_pageRef).val();
  			accountCY = $("#safeBoxMgmtAccCy_"+_pageRef).val();
  			entityType= "SAF";
  		}
  		*/
  		
  		_showProgressBar(true);
		$.ajax({
		 url: $.contextPath+"/path/entitycharges/EntityCharges_dependencyByAMT"
		 				   +"?baseForeign="+baseForeign
		 				   +"&entityType="+entityType
		 				   +"&accBranch="+accBranch
		 				   +"&accCurrency="+accountCY
		 				   +"&deductCharges="+deductCharges
		 				   +"&chargeAccBranch="+chargeAccBranch
		 				   +"&chargeAccCurrency="+chargeAccCurrency
		 				   +"&certificateCode="+certificateCode
		 				   +"&originalCode="+originalCode
		 				   +"&isEmptied="+isEmptied
		 				   +"&cardType="+cardType
		 				   +"&briefDescEngBase="+briefDescEngBase
		 				   +"&entityCommand="+entityCommand
		 				   +"&crud="+crud
		 				   +"&schemaDestroy="+schemaDestroy
		 				   +"&schemaCancel="+schemaCancel
		 				   +"&isRepeat="+isRepeat
		 				   +"&proceed="+proceed
		 				   +"&numOfEntities="+numOfEntities
		 				   +"&accGL="+acc_gl
		 				   +"&accCIF="+acc_cif
		 				   +"&accSL="+acc_sl,
		 				   
		 type:"post",
		 data:ctsChargesEntityVO,
		 success: function(data){			
			 if(typeof data["_error"] != "undefined" && data["_error"] != null){
				 $(gridId).jqGrid('setCellValue', $(gridId).jqGrid('getGridParam','selrow'), columnName, prevValue, "false");				 
				if(typeof data["_msgTitle"] != "undefined" && data["_msgTitle"] != null)
					_showErrorMsg(data["_error"],data["_msgTitle"] )
				else
					_showErrorMsg(data["_error"],error_msg_title)
			 }			 
			 else{
				  $(gridId).jqGrid('setCellValue', selRow, 'ctsChargesEntityVO.AMOUNT',   data.ctsChargesEntityCOs[0].ctsChargesEntityVO.AMOUNT);
				  $(gridId).jqGrid('setCellValue', selRow, 'ctsChargesEntityVO.AMOUNT_FC',    data.ctsChargesEntityCOs[0].ctsChargesEntityVO.AMOUNT_FC);
				  $(gridId).jqGrid('setCellValue', selRow, 'vatCtsChargesEntityVO.AMOUNT', data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT);
				  $(gridId).jqGrid('setCellValue', selRow, 'vatCtsChargesEntityVO.AMOUNT_FC',  data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT_FC);
				  
				 
				 
				 
				 
			// $(gridId).jqGrid('setCellValue', selRow, 'ctsChargesEntityVO.AMOUNT', data.ctsChargesEntityCOs[0].ctsChargesEntityVO.AMOUNT);
			// $(gridId).jqGrid('setCellValue', selRow, 'ctsChargesEntityVO.AMOUNT_FC', data.ctsChargesEntityCOs[0].ctsChargesEntityVO.AMOUNT_FC); 
			// $(gridId).jqGrid('setCellValue', selRow, 'vatCtsChargesEntityVO.AMOUNT', data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT);
			 //$(gridId).jqGrid('setCellValue', selRow, 'vatCtsChargesEntityVO.AMOUNT_FC', data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT_FC);
			// $(gridId).jqGrid('setCellValue', selRow,"vatCtsChargesEntityVO.AMOUNT",data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT);
			// $(gridId).jqGrid('setCellValue', selRow,"vatCtsChargesEntityVO.AMOUNT_FC",data.ctsChargesEntityCOs[0].vatCtsChargesEntityVO.AMOUNT_FC);
			 calculateChargesTotal(gridId,local_pageRef);
			 }
			
			 _showProgressBar(false);
			
		 }}); 
		}		
 
function calculateChargesTotal(gridId,local_pageRef)
{
           if(gridId != null && gridId != undefined && gridId != '' && gridId.indexOf("#") == 0)
           {
              //In case the gridId starts with '#' we should remove it
              gridId = gridId.substr(1,gridId.length);
           }
           
              var rows = $("#"+gridId).jqGrid('getDataIDs');
              var rowsLen = rows.length;
              if(rowsLen > 0)
              {
                     $("#"+$("#schemaChargesId_"+local_pageRef).val()).val($("#"+gridId).jqGrid('getCell', rows[0], "ctsChargesEntityVO.SCHEMA_CODE"));
              }
              
              var totalAmount = $("#"+gridId).jqGrid('getCol', 'ctsChargesEntityVO.AMOUNT', false, 'sum');
              var totalAmountFC = $("#"+gridId).jqGrid('getCol', 'ctsChargesEntityVO.AMOUNT_FC', false, 'sum');
              var totalVATAmount = $("#"+gridId).jqGrid('getCol', 'vatCtsChargesEntityVO.AMOUNT', false, 'sum');
              var totalVATAmountFC = $("#"+gridId).jqGrid('getCol', 'vatCtsChargesEntityVO.AMOUNT_FC', false, 'sum');
              var AMOUNTNbFormat, AMOUNTLeadZeros;
	          var AMOUNT_FCNbFormat, AMOUNTFCLeadZeros;
              $($("#"+gridId).jqGrid('getGridParam','colModel')).each(function(i){
             if (this.name === "ctsChargesEntityVO.AMOUNT" && typeof this.nbFormat != "undefined" && this.colType=="number") 
             {
				AMOUNTNbFormat = this.nbFormat;
              	AMOUNTLeadZeros = (typeof this.leadZeros != "undefined")? this.leadZeros : "";
              	//ABDO DCR 509649 25/04/2017
              	if($("appMultiCharges_"+local_pageRef).val() == '0' || $("appMultiCharges_"+local_pageRef).val() == "undefined" || $("#appMultiCharges_"+local_pageRef).val() == null || $("#appMultiCharges_"+local_pageRef).val() =='')
              	//if ($("#maxLosDocAmt_"+local_pageRef).val() == 0 || $("#maxLosDocAmt_"+local_pageRef).val() == "undefined" || $("#maxLosDocAmt_"+local_pageRef).val() == null || $("#maxLosDocAmt_"+local_pageRef).val() =='' )
            	{                      
              		$("#"+gridId).jqGrid('footerData', 'set', {VALUE : Total_Amount_key,"ctsChargesEntityVO.AMOUNT" :$.formatNumberNumeric( totalAmount+totalVATAmount, {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros})}, false);
				}    

			 }
             else if(this.name === "ctsChargesEntityVO.AMOUNT_FC" && typeof this.nbFormat != "undefined" && this.colType=="number")
        	{
        	 	AMOUNT_FCNbFormat = this.nbFormat;
               	AMOUNTFCLeadZeros = (typeof this.leadZeros != "undefined")? this.leadZeros : "";
             	//ABDO DCR 509649 25/04/2017
               	if($("appMultiCharges_"+local_pageRef).val() == '0' || $("appMultiCharges_"+local_pageRef).val() == "undefined" || $("#appMultiCharges_"+local_pageRef).val() == null || $("#appMultiCharges_"+local_pageRef).val() =='')
              	//if ($("#maxLosDocAmt_"+local_pageRef).val() == 0 || $("#maxLosDocAmt_"+local_pageRef).val() == "undefined" || $("#maxLosDocAmt_"+local_pageRef).val() == null || $("#maxLosDocAmt_"+local_pageRef).val() =='' )
             	{ 
              		$("#"+gridId).jqGrid('footerData', 'set', {VALUE : Total_Amount_key,"ctsChargesEntityVO.AMOUNT_FC" :$.formatNumberNumeric( totalAmountFC+totalVATAmountFC, {format: AMOUNT_FCNbFormat ,leadZeros:AMOUNTFCLeadZeros})}, false);
             	}  
          	}
            
	})
  
    var maxLosDocAmt = $("#maxLosDocAmt_"+local_pageRef).val();//ABDO DCR 509649 25/04/2017  
    var appMultCharges = $("#appMultiCharges_"+local_pageRef).val();
    
       if($("#num_of_chqbooks_"+local_pageRef).length != 0)
       {
           var footerRow    = $($("#"+gridId)[0].grid.sDiv).find("tr.footrow");
              var newFooterRow = footerRow.clone().addClass("ui-widget-content");

              var amnt = 0;
              var amntFc = 0;
              var rowsLen = rows.length;
              for(i=0;i<rowsLen;i++)
              {
                     var fixCharges = $("#"+gridId).jqGrid('getCell', rows[i], "ctsChargesVO.FIX_CHARGES");
                     var singleAmtCv = $("#"+gridId).jqGrid('getCell', rows[i], "ctsChargesEntityVO.AMOUNT");
                     var singleAmtFc = $("#"+gridId).jqGrid('getCell', rows[i], "ctsChargesEntityVO.AMOUNT_FC");
                     var singleAmtVatCv = $("#"+gridId).jqGrid('getCell', rows[i], "vatCtsChargesEntityVO.AMOUNT");
                     var singleAmtVatFc = $("#"+gridId).jqGrid('getCell', rows[i], "vatCtsChargesEntityVO.AMOUNT_FC");
                     
                     
                     var lineAmntCV = (singleAmtCv-0) + (singleAmtVatCv-0);
                     var lineAmntFC = (singleAmtFc-0) + (singleAmtVatFc-0);
                     if((fixCharges == '0' || fixCharges == '') && (appMultCharges== '0' || appMultCharges== "undefined" || appMultCharges == null || appMultCharges == ''))//ABDO DCR 509649 25/04/2017 
                     {
                           lineAmntCV = (lineAmntCV-0) * $("#num_of_chqbooks_"+local_pageRef).val();
                           lineAmntFC = (lineAmntFC-0) * $("#num_of_chqbooks_"+local_pageRef).val();
                     }
                     amnt = (amnt-0) + (lineAmntCV-0);
                     amntFc = (amntFc-0) + (lineAmntFC-0);
              }
              
              amnt = $.formatNumberNumeric(amnt, {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros});
              amntFc = $.formatNumberNumeric(amntFc, {format: AMOUNT_FCNbFormat ,leadZeros:AMOUNTFCLeadZeros});
              
              if(footerRow.length == 2)
              {
                     $(footerRow[1]).remove();
                  footerRow    = $($("#"+gridId)[0].grid.sDiv).find("tr.footrow");
                     newFooterRow = footerRow.clone().addClass("ui-widget-content");
                     newFooterRow.find(">td[aria-describedby='"+gridId+"_chargeDesc']").html("<b>"+total_All+"</b>");
              newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT']").text(amnt);
              newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT_FC']").text(amntFc);
              }
              if(footerRow.length == 1)
              {
                     newFooterRow.insertAfter(footerRow);
                     newFooterRow.find(">td[aria-describedby='"+gridId+"_chargeDesc']").html("<b>"+total_All+"</b>");
              newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT']").text(amnt);
              newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT_FC']").text(amntFc);
           }
    }
       //     confirm(app_mult_chrgs_)
       if( ( ( $("#lookuptxt_documentNo_"+local_pageRef).val() != "undefined" && $("#lookuptxt_documentNo_"+local_pageRef).val() != null )
                     || ( $("#documentNo_"+local_pageRef).val() != "undefined" && $("#documentNo_"+local_pageRef).val() != null ) ) &&
              $("#toDocumentNo_"+local_pageRef).val() != "undefined" && $("#toDocumentNo_"+local_pageRef).val() != null && $("#app_mult_chrgs_"+local_pageRef).val() =="1"       )      
              {
              
                     var footerRow    = $($("#"+gridId)[0].grid.sDiv).find("tr.footrow");
                     var newFooterRow = footerRow.clone().addClass("ui-widget-content");
                     
                     if(footerRow.length == 2)
                     {
                           $(footerRow[1]).remove();
                           footerRow    = $($("#"+gridId)[0].grid.sDiv).find("tr.footrow");
                           newFooterRow = footerRow.clone().addClass("ui-widget-content");
                           
                     }
                     if(footerRow.length == 1)
                     {
                           newFooterRow.insertAfter(footerRow);
                     }
                     
//                     if (maxLosDocAmt > 0)//ABDO DCR 509649 25/04/2017
//                     {
                     var nbOfDocuments = lostFoundMgnt_getChargeNumOfEntities(local_pageRef);
                     var amnt   = $.formatNumberNumeric( ((totalAmount+totalVATAmount))    , {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros});
                     var amntFc   = $.formatNumberNumeric( ((totalAmountFC+totalVATAmountFC))    , {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros});
//                  }
//                     else//ABDO DCR 509649 25/04/2017
//                     {
//                     var nbOfDocuments = lostFoundMgnt_getChargeNumOfEntities(local_pageRef);
//                     var amnt   = $.formatNumberNumeric( ((totalAmount+totalVATAmount)*nbOfDocuments)    , {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros});
//                     var amntFc   = $.formatNumberNumeric( ((totalAmountFC+totalVATAmountFC)*nbOfDocuments)    , {format: AMOUNTNbFormat ,leadZeros:AMOUNTLeadZeros});
//                  }
                  newFooterRow.find(">td[aria-describedby='"+gridId+"_chargeDesc']").html("<b>"+Total_for_all_documents_CVFC_key+"</b>");
                     newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT']").text(amnt);
                  newFooterRow.find(">td[aria-describedby='"+gridId+"_ctsChargesEntityVO.AMOUNT_FC']").text(amntFc);
                  
              }
              
}      

function chargesGridOnSelectRow(grid){		
	 
		var selRowId = $(grid).jqGrid("getGridParam","selrow");		 
		var myObject = $(grid).jqGrid('getRowData',selRowId);
		var vatAmount = myObject["vatCtsChargesEntityVO.AMOUNT"];
		var vatAmountFC = myObject["vatCtsChargesEntityVO.AMOUNT_FC"];
		 
		//$(grid).jqGrid('setCellReadOnly', selRowId,"vatCtsChargesEntityVO.AMOUNT",vatAmount=="");
		//$(grid).jqGrid('setCellReadOnly', selRowId,"vatCtsChargesEntityVO.AMOUNT_FC",vatAmountFC=="");
				 
			}
		 
	
  

function returnChargesGridUpdates(chargeGridId)
{
	var local_pageRef = typeof chargeGridId == 'undefined'? _pageRef : _pageRef + "" + chargeGridId
	var grid = $("#chargesGridId_hid_"+local_pageRef).val();
	var selRow = $(grid).jqGrid("getGridParam",'selrow');
	
	//Hasan Bug#431291 19/11/2016
	var editable = $($(grid).jqGrid("getInd",selRow,true)).attr("editable");
	if(selRow != "undefined" && selRow != null && selRow != "" && editable === "1")
	{
		$(grid).jqGrid("saveRow",selRow ,false, 'clientArray');
	}
	var jsonStringUpdates = $(grid).jqGrid('getAllRows'); // Grid Data
	return jsonStringUpdates;
}
 
 
