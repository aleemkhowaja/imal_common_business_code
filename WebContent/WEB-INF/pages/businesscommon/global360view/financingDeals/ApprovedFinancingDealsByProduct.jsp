<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<script>	
$(document).ready(function() {	
	$("#approvedDealsSection_"+_pageRef+".collapsibleContainer").collapsiblePanel();

});

function financingDealByProductApprovedGridActionFormatter(cellValue, options, rowObject){
	var hyperLinks="";
	
	hyperLinks = 			"<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealRepaymentPlanClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.prodClassCode+","+rowObject.trsDealVO.DEAL_TYPE+","+rowObject.trsDealVO.BRANCH_CODE+");'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Repayment_Plan_key'/>"+"</a>"
	hyperLinks = hyperLinks+"<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealGuarantorClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.trsDealVO.BRANCH_CODE+");'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Guarantor_key'/>"+"</a>"
	hyperLinks = hyperLinks+"<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealCollateralClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.trsDealVO.BRANCH_CODE+");'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Collaterals_key'/>"+"</a>"
	hyperLinks = hyperLinks+"<a class='fg-button ui-state-default  ui-corner-all fg-button-icon-left'   href='javascript:dashboard_financialDealDetailsClicked("+rowObject.trsDealVO.SERIAL_NO+","+rowObject.trsDealVO.BRANCH_CODE+",&quot;"+rowObject.appName+"&quot;);'><span class='ui-icon ui-icon-image'/>"+"<ps:text name='Deals_Details_key'/>"+"</a>"
	return hyperLinks;
}
function financingDealByProductApprGridStatusColor(cellValue, options, rowObject){	
	var statusColor="";
    if(rowObject.status=="P")
  		statusColor = '<span class="" style=" background: black;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
  	else if(rowObject.status=="A")
  		statusColor = '<span class="" style=" background: green;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
  	else if(rowObject.status=="N")
  		statusColor = '<span class="" style=" background: red;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
  	else if(rowObject.status=="D")
  		statusColor = '<span class="" style=" background: blue;">&nbsp;&nbsp;&nbsp;&nbsp;</span>'
  	else
  		statusColor = '<span class=""  >&nbsp;&nbsp;&nbsp;&nbsp;</span>'
  	return statusColor; 
  	   	
}	
</script>
 <div id="approvedDealsSection_<ps:property value="_pageRef" escapeHtml="true"/>" class="collapsibleContainer" title="<ps:text name="Approved_Deals_key" />" >
    <table   width="100%" class="ui-state-focus">
     <tr class="ui-state-focus">
      <td width="50%">      
      </td>
      <td>
         <span class="" style="background: green;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: green"><ps:text name="Settlement_Closed_key" /></span>
      </td>
      <td>
         <span class="" style="background: red;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: red"><ps:text name="Past_Due_key" /></span>
      </td>
      <td>
         <span class="" style="background: black;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: black"><ps:text name="Not_Yet_Due_key" /></span>
      </td>
      <td>
       	 <span class="" style="background: blue;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	 <span style="color: blue"><ps:text name="Partially_Paid_key" /></span>
      </td>        
     </tr>
    
    </table>
    
    
    <ps:url id="urlApprvFinancingDealsGridByProduct" action="financingDealsListAction_loadFinancingDealsByProductData" namespace="/path/globalview" escapeAmp="false">
		 <ps:param name="iv_crud"      			 value="iv_crud"></ps:param>
		 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
		 <ps:param name="financingDealsSC.cifNo" value="financingDealsSC.cifNo"></ps:param>
		 <ps:param name="financingDealsSC.category" value="financingDealsSC.category"></ps:param>
		 <ps:param name="financingDealsSC.status" value="'P'"></ps:param>
		 <ps:param name="financingDealsSC.appName" value="financingDealsSC.appName"></ps:param>
		 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
		 
	 </ps:url>
	 <psjg:grid
	    	id				="apprvFinancingDealsByProductGridTbl_Id_${_pageRef}" 
	  	    href            ="%{urlApprvFinancingDealsGridByProduct}"  	    
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
			onCompleteTopics="onApprovedFinancingDealsGridLoad"   
	        >	 
	       <psjg:gridColumn name="statusColor" 	title=" " index="action"  colType="custom" 	editable="false" 	sortable="false" 	search="false"	id="statusColor" 	 formatter="financingDealByProductApprGridStatusColor"  width="20" /> 			         
	       <psjg:gridColumn id="branchName"	      index="branchBriefDescEng"          name="branchBriefDescEng"         title="%{getText('Branch_key')}"         colType="text"   sortable="true" search="true"  />
	       <psjg:gridColumn id="branchCode"	      index="trsDealVO.BRANCH_CODE"          name="trsDealVO.BRANCH_CODE"         title="%{getText('Branch_key')}"         colType="text"   sortable="false" search="false" hidden="true"  />
	       <psjg:gridColumn id="createdBy"      index="trsDealVO.USER_ID"      	name="trsDealVO.USER_ID"      	title="%{getText('Created_By_key')}"      colType="text"   sortable="true" search="true"   />
	       <psjg:gridColumn id="dealNo"          index="trsDealVO.SERIAL_NO"        name="trsDealVO.SERIAL_NO"       title="%{getText('Deal_No_key')}"          colType="number" sortable="true" search="true" leadZeros="12"   />
	       <psjg:gridColumn id="dealDate"      index="trsDealVO.DEAL_DATE"    name="trsDealVO.DEAL_DATE"   title="%{getText('Deal_Date_key')}"      colType="date" sortable="true" search="true"   />
	       <psjg:gridColumn id="dealType"      index="prodBriefNameEng"    name="prodBriefNameEng"   title="%{getText('Deal_Type_key')}"      colType="text" sortable="true" search="true"   />
     	   
	       <psjg:gridColumn id="CVAmt"	  index="cvAmt"      name="cvAmt"     title="%{getText('CV_Amount_key')}"     colType="number"   sortable="false" search="true"  formatter="currencyFmatter" formatCol="baseCurrDecPoint"  />
	       <psjg:gridColumn id="dealAmt"	      index="dealAmt"        name="dealAmt"       title="%{getText('Deal_amount_key')}"          colType="number" sortable="true" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints"  />
	       <psjg:gridColumn id="yield"	      index="yield"        name="yield"       title="%{getText('Yield_key')} %"       colType="number" sortable="true" search="true"   nbFormat="#,#0.000000000000"  />
	       <psjg:gridColumn id="mProfit"	  index="trsDealVO.MGMT_PCNT"       name="trsDealVO.MGMT_PCNT"      title="%{getText('Modarib_Profit_key')}"      colType="number" sortable="true" search="true" nbFormat="#,#0.0000000"  />
	       <psjg:gridColumn id="rate"  index="trsDealVO.DEAL_RATE"   name="trsDealVO.DEAL_RATE"  title="%{getText('Deal_Rate_key')}" colType="number" sortable="true" search="true" nbFormat="#,#0.0000000" />
	       <psjg:gridColumn id="vDate"  index="trsDealVO.VALUE_DATE"   name="trsDealVO.VALUE_DATE"  title="%{getText('Value_Date_key')}" colType="date" sortable="true" search="true"  />
	       <psjg:gridColumn id="mDate"  index="trsDealVO.MATURITY_DATE"   name="trsDealVO.MATURITY_DATE"  title="%{getText('Maturity_Date_key')}" colType="date" sortable="true" search="true" />
	       <psjg:gridColumn id="ecoSector"  index="trsDealVO.ECO_SECTOR"   name="trsDealVO.ECO_SECTOR"  title="%{getText('Eco_Sector_key')}" colType="number" sortable="true" search="true" />
	       <psjg:gridColumn id="subSector"  index="trsDealVO.SUB_ECO_SECTOR"   name="trsDealVO.SUB_ECO_SECTOR"  title="%{getText('Sub_Eco_Sector_key')}" colType="number" sortable="true" search="true" />
	       <psjg:gridColumn name="action"	title="%{getText('actions_key')}" index="action"  colType="custom" 	editable="false" 	sortable="false" 	search="false"	id="actionEdit" 	 formatter="financingDealByProductApprovedGridActionFormatter"  width="400" />
	       <psjg:gridColumn id="appName"      index="appName"             name="appName"          title="%{getText('App_name_Key')}"      colType="text"   sortable="true" search="true" hidden="true"/>
	       
	       
	 </psjg:grid>
 </div>
 
 

 <style>
 .circle {
    border-radius: 50%/50%; 
   
}
 </style>
 <script>
 
 $(document).ready(function () {
	   $("#apprvFinancingDealsByProductGridTbl_Id_"+_pageRef).unsubscribe("onApprovedFinancingDealsGridLoad");
	   var isNavConstructed = false;
		$("#apprvFinancingDealsByProductGridTbl_Id_"+_pageRef).subscribe("onApprovedFinancingDealsGridLoad",function(response,html){
			 if(!isNavConstructed)
			 {
				 $("#apprvFinancingDealsByProductGridTbl_Id_"+_pageRef).jqGrid ('navButtonAdd', '#apprvFinancingDealsByProductGridTbl_Id_'+_pageRef+'_pager',
											      {  
						 						  caption:"<ps:text name='Print_Statement__key' />",
												  buttonicon: "ui-icon-print",
												  title: "<ps:text name='Print_Statement__key' />",
											      onClickButton: function() {										      
											      printGrid("apprvFinancingDealsByProductGridTbl_Id_"+_pageRef,"<ps:text name='Approved_Deals_key' />",["action"]);
											      
	   				 								}
											      });	
				 isNavConstructed = true;
			 }
  });		
		});
 
 
 
 var Deal_Details_key = "<ps:text name='Deal_Details_key' />";
 </script>
 

 
 