function oneObligor_showObligorTrendsDetls()
{
  	var mySrc  = jQuery.contextPath+"/path/globalview/dashOneObligorMaintAction_loadMoneyLaudOneObligTrendsPage";
  	var oneObligorCode = $("#obligoreCode_"+_pageRef).val();
	var currencyCode = $("#currencyCode_"+_pageRef).val();
  	
	var params={"dashOneObligorCO.rifOBTVO.OBLIGOR_CODE":oneObligorCode,"currenciesVO.currencyCode":currencyCode,"_pageRef":_pageRef,"iv_crud":"R"};
	_showProgressBar(true); 

	var dialogOptions={modal:true,
			title:moneyLaunderingTrendsDetl_key,
			height : returnMaxHeight(500),
						width : returnMaxWidth(855),
						autoOpen : false,
						show : 'slide',
						close : function(event, ui) {
						},
						buttons : {
							"OK" : function() {
									$("#oneObligorTrendsDetlsDiv_id_"+_pageRef).dialog("close");
							}
						}
		};
	   $("#oneObligorTrendsDetlsDiv_id_"+_pageRef).load(mySrc,params,function(){
				_showProgressBar(false);
					});
		
		$("#oneObligorTrendsDetlsDiv_id_"+_pageRef).dialog(dialogOptions);
		$("#oneObligorTrendsDetlsDiv_id_"+_pageRef).dialog("open");
	
	_showProgressBar(false);
}

