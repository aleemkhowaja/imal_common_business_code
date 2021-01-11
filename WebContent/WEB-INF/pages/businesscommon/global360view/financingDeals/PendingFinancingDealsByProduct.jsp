<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
 
<script>	
$(document).ready(function() {	
	$("#pendingDealsSection_"+_pageRef+".collapsibleContainer").collapsiblePanel();

});

function financingDealByProductPendingGridActionFormatter(cellValue, options, rowObject){
	return "<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealDetailsClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.trsDealVO.BRANCH_CODE+",&quot;"+rowObject.appName+"&quot;);'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Deals_Details_key'/>"+"</a>"
}
</script>
<div id="pendingDealsSection_<ps:property value="_pageRef" escapeHtml="true"/>" class="collapsibleContainer" title="<ps:text name="Pending_Deals_key" />" >
<ps:url id="urlPendingFinancingDealsGridByProduct" action="financingDealsListAction_loadFinancingDealsByProductData" namespace="/path/globalview" escapeAmp="false">
	 <ps:param name="iv_crud"      			 value="iv_crud"></ps:param>
	 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
	 <ps:param name="financingDealsSC.cifNo" value="financingDealsSC.cifNo"></ps:param>
	 <ps:param name="financingDealsSC.category" value="financingDealsSC.category"></ps:param>
	 <ps:param name="financingDealsSC.status" value="'A'"></ps:param>
	 <ps:param name="financingDealsSC.appName" value="financingDealsSC.appName"></ps:param>
	 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
	 
 </ps:url>
 <psjg:grid
    	id				="pendingFinancingDealsByProductGridTbl_Id_${_pageRef}" 
  	    href            ="%{urlPendingFinancingDealsGridByProduct}"  	    
        dataType        ="json"       
    	pager           ="true"
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
        rowNum="20"         
		rowList="5,10,15,20"   
		height="230"
		onCompleteTopics="onPendingFinancingDealsGridLoad"   
		     >	 			         
      <psjg:gridColumn id="branchName"	      index="branchBriefDescEng"          name="branchBriefDescEng"         title="%{getText('Branch_key')}"         colType="text"   sortable="true" search="true"/>
      <psjg:gridColumn id="createdBy"      index="trsDealVO.USER_ID"      	name="trsDealVO.USER_ID"      	title="%{getText('Created_By_key')}"      colType="text"   sortable="true" search="true" />
      <psjg:gridColumn id="dealNo"          index="trsDealVO.SERIAL_NO"        name="trsDealVO.SERIAL_NO"       title="%{getText('Deal_No_key')}"          colType="number" sortable="true" search="true" leadZeros="12"/>
      <psjg:gridColumn id="status"	  index="status"      name="status"     title="%{getText('Status_key')}"    colType="text" sortable="false" search="true"/>
      <psjg:gridColumn id="dealType"      index="prodBriefNameEng"    name="prodBriefNameEng"   title="%{getText('Deal_Type_key')}"      colType="text" sortable="true" search="true"/>
      <psjg:gridColumn id="prodClassCode"      index="prodClassCode"    name="prodClassCode"   title="%{getText('Product_Class_key')}"      colType="text" sortable="true" search="true"/>
       <psjg:gridColumn id="CVAmt"	  index="cvAmt"      name="cvAmt"     title="%{getText('CV_Amount_key')}"     colType="number"   sortable="false" search="true"  formatter="currencyFmatter" formatCol="baseCurrDecPoint"   />
      <psjg:gridColumn id="dealDate"  index="trsDealVO.DEAL_DATE"   name="trsDealVO.DEAL_DATE"  title="%{getText('Deal_Date_key')}" colType="date" sortable="true" search="true"/>
      <psjg:gridColumn id="currencyDesc"	  index="currBriefDescEng"      name="currBriefDescEng"     title="%{getText('Currency_key')}"     colType="text" sortable="true" search="true" />      
      
      <psjg:gridColumn id="dealAmt"	      index="dealAmt"        name="dealAmt"       title="%{getText('Deal_amount_key')}"          colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"/>
      <psjg:gridColumn id="yield"	      index="yield"        name="yield"       title="%{getText('Yield_key')}"       colType="number" sortable="true" search="true" nbFormat="#,#0.000000000000"/>
      <psjg:gridColumn id="mProfit"	  index="trsDealVO.MGMT_PCNT"       name="trsDealVO.MGMT_PCNT"      title="%{getText('Modarib_Profit_key')}"      colType="number" sortable="true" search="true" nbFormat="#,#0.0000000"/>
      <psjg:gridColumn id="rate"  index="trsDealVO.DEAL_RATE"   name="trsDealVO.DEAL_RATE"  title="%{getText('Deal_Rate_key')}" colType="number" sortable="true" search="true" nbFormat="#,#0.0000000"/>
      <psjg:gridColumn id="vDate"  index="trsDealVO.VALUE_DATE"   name="trsDealVO.VALUE_DATE"  title="%{getText('Value_Date_key')}" colType="date" sortable="true" search="true"/>
      <psjg:gridColumn id="mDate"  index="trsDealVO.MATURITY_DATE"   name="trsDealVO.MATURITY_DATE"  title="%{getText('Maturity_Date_key')}" colType="date" sortable="true" search="true" />
      <psjg:gridColumn name="action"	title="%{getText('actions_key')}" index="action"  colType="custom" 	editable="false" 	sortable="false" 	search="false"	id="actionEdit" 	 formatter="financingDealByProductPendingGridActionFormatter"  width="120" />
      <psjg:gridColumn id="appName"      index="appName"             name="appName"          title="%{getText('App_name_Key')}"      colType="text"   sortable="true" search="true" hidden="true"/>
      
     
       
 </psjg:grid>
 </div>
 <script>
  $(document).ready(function () {
	   $("#pendingFinancingDealsByProductGridTbl_Id_"+_pageRef).unsubscribe("onPendingFinancingDealsGridLoad");
	   var isPendPrintStmtConstructed= false;
 		$("#pendingFinancingDealsByProductGridTbl_Id_"+_pageRef).subscribe("onPendingFinancingDealsGridLoad",function(response,html){ 		    
 			if(!isPendPrintStmtConstructed)
 			{
			 $("#pendingFinancingDealsByProductGridTbl_Id_"+_pageRef).jqGrid ('navButtonAdd', '#pendingFinancingDealsByProductGridTbl_Id_'+_pageRef+'_pager',
										      {  
					 						  caption:"<ps:text name='Print_Statement__key' />",
											  buttonicon: "ui-icon-print",
											  title: "<ps:text name='Print_Statement__key' />",
										      onClickButton: function() {
										      printGrid("pendingFinancingDealsByProductGridTbl_Id_"+_pageRef,"<ps:text name='Pending_Deals_key' />");
										  								      
										      }	
										      });		
			 isPendPrintStmtConstructed= true;
 			}
									    });
  
		});
 
 </script>
