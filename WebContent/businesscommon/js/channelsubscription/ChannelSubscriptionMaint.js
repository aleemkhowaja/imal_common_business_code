/**
 * @author RakanMakarem
 * Channel Subscription PopUp
 * Function used to show channel subscription dialog 
 */
function showChannelSubscriptionPopup(formId,theParams)
{
	var mySrc = jQuery.contextPath+"/path/channelSubscription/ChannelSubscriptionMaintAction_loadChannelSubscriptionPage";

	
	var detailDiv = $('<div>', {
		id : "channelSubscriptionDialog_" + _pageRef
	});

	$('body').append(detailDiv);

	var dialogOptions = {
			modal : true,
			autoOpen : false,
			show : 'slide',
			position : 'center',
			dialogClass : 'no-close',
			closeOnEscape : false,
			title : Subscription_To_key,
			'height' : returnMaxHeight(400),
			'width' : returnMaxWidth(950),
			buttons : [ {
				text : "Save",
				click : function()
				{
					channelSubscription_onSaveClicked();
				}
			} ,
			 {
				text : "Cancel",
				click : function()
				{

					$("#channelSubscriptionDialog_"+ _pageRef).dialog("close");

				}
			}]
		};

	$("#channelSubscriptionDialog_" + _pageRef).dialog(dialogOptions);
	
	$("#channelSubscriptionDialog_" + _pageRef).load(
			mySrc,
			theParams,
			function()
			{
				$("#channelSubscriptionDialog_" + _pageRef).dialog("open");
				//to resize the grid columns, web issue
				setTimeout(resizeGrids, 210);
			});
	
}

/**
 *  * saving method / submit
 * @returns
 */
function channelSubscription_onSaveClicked()
{
	var changes = $("#channelSubscriptionFormId_" + _pageRef).hasChanges(true);
	if(changes == true || changes == 'true')
	{
		 var channelSubscriptionStr;
		 var remittGrid = $("#channelSubscriptionListGridTbl_Id_" + _pageRef);
		 var rowIds = remittGrid.jqGrid('getDataIDs');
		 // to set status to changed to all grid rows
//		 for ( var i = 0; i < rowIds.length; i++)
//		 {
//			 var rowId = rowIds[i];
//			  if(typeof rowId != "undefined" && rowId != null)
//			  {
//				 $("#channelSubscriptionListGridTbl_Id_" + _pageRef).jqGrid("setGridRowStatus", rowId, 2);
//			  }
//		 }
		 //json array of all grid changed rows
		 channelSubscriptionStr=$("#channelSubscriptionListGridTbl_Id_" + _pageRef).jqGrid('getChangedRowData')
	 	
		 var obj  = {"channelSubscriptionStr" : channelSubscriptionStr}
		
		
		var actionSrc = jQuery.contextPath+"/path/channelSubscription/ChannelSubscriptionMaintAction_save";
		
		_showProgressBar(true);
		$.ajax({
			url : actionSrc,
			type : "post",
			dataType : "json",
			data : obj,
			success : function(data) 
			{
				_showProgressBar(false);
				if(typeof data["_error"] == "undefined" || data["_error"] == null)
			     {	 
					 if($("#channelSubscriptionListGridTbl_Id_"+_pageRef).html()!=null && $("#channelSubscriptionListGridTbl_Id_"+_pageRef).html()!="")
		               {
		            	 $("#channelSubscriptionListGridTbl_Id_"+_pageRef).trigger("reloadGrid");
		            	 $("#channelSubscriptionDialog_"+ _pageRef).dialog("close");
		               }
			     }
				
			
			}
		});
		
	}
}


/**
 * @Desc this function update row status to changed in the grid upon selecting a record from  the livesearch 
 * 
 */
function changeRowStatus( rowEvent, fromWhere) {
	
	var gridId = $("#channelSubscriptionListGridTbl_Id_" + _pageRef);
	var rowId = gridId.jqGrid('getGridParam', 'selrow');
		
	//component issue
	if (rowId == null) {
		if (fromWhere == "fromSlDep") {
			//work-around to get the rowId in case the row is not selected
			rowId = rowEvent;
		} else {
			return;
		}
	}
		
	 if(typeof rowId != "undefined" && rowId != null)
	  {
		 $("#channelSubscriptionListGridTbl_Id_" + _pageRef).jqGrid("setGridRowStatus", rowId, 2);
	  }
}
