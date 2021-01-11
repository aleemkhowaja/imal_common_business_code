<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<script>	
$(document).ready(function() {	
	$("#approvedTreasuryForexDealsSection_"+_pageRef+".collapsibleContainer").collapsiblePanel();

});

function treasuryForexDealsApprovedGridActionFormatter(cellValue, options, rowObject){
	var hyperLinks="";
	hyperLinks = "<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealDetailsClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.trsDealVO.BRANCH_CODE+",&quot;"+rowObject.appName+"&quot;);'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Deals_Details_key'/>"+"</a>"
	return hyperLinks;
}

</script>
 <div id="approvedTreasuryForexDealsSection_${_pageRef}" class="collapsibleContainer" title="<ps:text name="Approved_Deals_key" />" >
    
    <ps:url id="urlApprvTreasuryForexDealsGrid" action="financingDealsListAction_loadTreasuryForexDeals" namespace="/path/globalview" escapeAmp="false">
		 <ps:param name="iv_crud"      			 value="iv_crud"></ps:param>
		 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
		 <ps:param name="financingDealsSC.cifNo" value="financingDealsSC.cifNo"></ps:param>
		 <ps:param name="financingDealsSC.category" value="financingDealsSC.category"></ps:param>
		 <ps:param name="financingDealsSC.status" value="'P'"></ps:param>
		 <ps:param name="financingDealsSC.appName" value="financingDealsSC.appName"></ps:param>
		 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
		 <ps:param name="financingDealsSC.outstandingDealsFlag" value="'N'"></ps:param>
	 </ps:url>
	 
	 <psjg:grid
	    	id				="apprvTreasuryForexDealsGridTbl_Id_${_pageRef}" 
	  	    href            ="%{urlApprvTreasuryForexDealsGrid}"  	    
	        dataType        ="json"       
	    	pager           ="false"
	    	sortable        ="true"
			filter          ="false"
	    	gridModel       ="gridModel"    	 
			viewrecords     ="true" 
			navigator       ="true"
			altRows         ="true"
			navigatorRefresh="false" 
			navigatorAdd    ="false"			
			navigatorDelete ="false"
			navigatorEdit   ="false"			
			pagerButtons    ="true" 
			navigatorSearch ="false"
	        shrinkToFit     ="false" 
			height="230"
			onCompleteTopics="onApprovedTreasuryForexDealsGridLoad" >
				
	        <psjg:gridColumn id="branchName"	      index="branchBriefDescEng"          name="branchBriefDescEng"         title="%{getText('Branch_key')}"         colType="text"   sortable="true" search="true" width="100" align="center" />
	        <psjg:gridColumn id="branchCode"	      index="trsDealVO.BRANCH_CODE"          name="trsDealVO.BRANCH_CODE"         title="%{getText('Branch_key')}"         colType="text"   sortable="false" search="false" hidden="true"  />
	        <psjg:gridColumn id="createdBy"      index="trsDealVO.USER_ID"      	name="trsDealVO.USER_ID"      	title="%{getText('Created_By_key')}"      colType="text"   sortable="true" search="true"  width="100" align="center" />
	        <psjg:gridColumn id="status"	  index="status"      name="status"     title="%{getText('Status_key')}"    colType="text" sortable="false" search="true" width="70" align="center"/>
	        <psjg:gridColumn id="dealNo"          index="trsDealVO.SERIAL_NO"        name="trsDealVO.SERIAL_NO"       title="%{getText('Deal_No_key')}"          colType="number" sortable="true" search="true" leadZeros="12"  width="100" />
	        <psjg:gridColumn id="dealDate"      index="trsDealVO.DEAL_DATE"    name="trsDealVO.DEAL_DATE"   title="%{getText('Deal_Date_key')}"      colType="date" sortable="true" search="true"  width="100" />
	        <psjg:gridColumn id="vDate"  index="trsDealVO.VALUE_DATE"   name="trsDealVO.VALUE_DATE"  title="%{getText('Value_Date_key')}" colType="date" sortable="true" search="true" width="100" />
	        
	        <psjg:gridColumn id="forexType"      index="trsDealVO.FOREX_TYPE"      	name="trsDealVO.FOREX_TYPE"      	title="%{getText('Forex_Type_key')}"      colType="text"   sortable="true" search="true" width="100" align="center"  />
	        <psjg:gridColumn id="boughtCurrency"      index="boughtCurrency"      	name="boughtCurrency"      	title="%{getText('Bought_CY_Key')}"      colType="text"   sortable="true" search="true"  width="100" align="center" />
	        <psjg:gridColumn id="boughtAmt"          index="trsDealVO.OTHER_AMOUNT"        name="trsDealVO.OTHER_AMOUNT"       title="%{getText('Bought_Amount_key')}"          colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"   />
	        <psjg:gridColumn id="boughtVDate"  index="trsDealVO.SALES_DATE"   name="trsDealVO.SALES_DATE"  title="%{getText('bought_value_date_key')}" colType="date" sortable="true" search="true" width="100" align="center"  />
	        <psjg:gridColumn id="crossRate"          index="trsDealVO.CROSS_EXCH_RATE"        name="trsDealVO.CROSS_EXCH_RATE"       title="%{getText('Cross_Rate_key')}"          colType="number" sortable="true" search="true" width="130"  nbFormat="#,#0.000000000000"  />
	        
	        <psjg:gridColumn id="soldCurrency"      index="soldCurrency"      	name="soldCurrency"      	title="%{getText('Sold_Currency_Key')}"      colType="text"   sortable="true" search="true"  width="100" align="center" />
	        <psjg:gridColumn id="soldAmt"          index="trsDealVO.DEAL_AMOUNT"        name="trsDealVO.DEAL_AMOUNT"       title="%{getText('Sold_Amount_key')}"          colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"   />
	        <psjg:gridColumn id="prodClassCode"      index="prodClassCode"    name="prodClassCode"   title="%{getText('Product_Class_key')}"      colType="text" sortable="true" search="true" width="100" align="center" />
	        <psjg:gridColumn id="prodBriefNameEng"          index="prodBriefNameEng"        name="prodBriefNameEng"       title="%{getText('Class_Name_key')}"          colType="text" sortable="true" search="true" leadZeros="12"  width="100" align="center" />
	        <psjg:gridColumn name="action"	title="%{getText('actions_key')}" index="action"  colType="custom" 	editable="false" 	sortable="false" 	search="false"	id="actionEdit" 	 formatter="treasuryForexDealsApprovedGridActionFormatter"  width="100" />
	  </psjg:grid>
 </div>    
 
 
 

 <style>
 .circle {
    border-radius: 50%/50%; 
   
}
 </style>
 <script>
 
 $(document).ready(function () {
	   $("#apprvTreasuryForexDealsGridTbl_Id_"+_pageRef).unsubscribe("onApprovedTreasuryForexDealsGridLoad");
	   var isNavConstructed = false;
		$("#apprvTreasuryForexDealsGridTbl_Id_"+_pageRef).subscribe("onApprovedTreasuryForexDealsGridLoad",function(response,html){
			 if(!isNavConstructed)
			 {
				 $("#apprvTreasuryForexDealsGridTbl_Id_"+_pageRef).jqGrid ('navButtonAdd', '#apprvTreasuryForexDealsGridTbl_Id_'+_pageRef+'_pager',
											      {  
						 						  caption:"<ps:text name='Print_Statement__key' />",
												  buttonicon: "ui-icon-print",
												  title: "<ps:text name='Print_Statement__key' />",
											      onClickButton: function() {										      
											      printGrid("apprvTreasuryForexDealsGridTbl_Id_"+_pageRef,"<ps:text name='Approved_Deals_key' />",["action"]);
											      
	   				 								}
											      });	
				 isNavConstructed = true;
			 }
  });		
		});
 
 
 
 var Deal_Details_key = "<ps:text name='Deal_Details_key' />";
 </script>
 

 
    