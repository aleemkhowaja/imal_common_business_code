<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<script type="text/javascript">
	
	$.struts2_jquery.require("Dashboard.js",null,jQuery.contextPath+"/common/js/global360view/");
</script>

 <ps:hidden id="dealBranchCode_${_pageRef}"
	name="financingDealRepaymentPlanCO.dealBranchCode" />
 <div id="approvedDealsSection_<ps:property value="_pageRef" escapeHtml="true"/>" class="collapsibleContainer" title="<ps:text name="Approved_Deals_key" />" >

    <table width="100%">
    	<tr>
    		<td style="width: 15%;"></td>
    		<td style="width: 15%;"></td>
    		<td style="width: 5%;"></td>
    		<td style="width: 15%;"></td>
    		<td style="width: 15%;"></td>
    		<td style="width: 5%;"></td>
    		<td style="width: 15%;"></td>
    		<td style="width: 15%;"></td>
    	</tr>
    	
    	<tr>
    		 <td class="fldLabelView"   >
	         	<ps:label key="Deal_Nbr_key"/>
	         </td>
	         <td>
	         	<ps:textfield id="sett_dealNbr_${_pageRef}" name="financingDealRepaymentPlanCO.trsSetlmtVO.DEAL_NBR"
	         	 readonly="true" mode="number" leadZeros="12"></ps:textfield>
	       </td>
	       <td ></td>
	       
	       <td class="fldLabelView"   ><ps:label key="Plan_Nbr_key" /></td>
       		<td>
         	<ps:textfield id="sett_planNbr_${_pageRef}" name="financingDealRepaymentPlanCO.trsSetlmtVO.PLAN_NBR"
         		readonly="true" mode = "number" leadZeros="12" ></ps:textfield>
         	</td>
         	<td ></td>
          <td class="fldLabelView"   ><ps:label key="Plan_Seq_key" /></td>
       <td>
         <ps:textfield id="sett_planNbrSeq_${_pageRef}" name="financingDealRepaymentPlanCO.trsSetlmtVO.PLAN_SEQ"
         readonly="true" 	mode="number" leadZeros="3"></ps:textfield></td>
    	</tr>
    	
	<tr>
       
          <td class="fldLabelView" >
         <ps:label   key="Due_Date_key"/>
         </td>
         <td>
         
         <psj:datepicker name="financingDealRepaymentPlanCO.trsSetlmtVO.VALUE_DATE" id="sett_dueDate_${_pageRef}" readonly="true" buttonImageOnly="true"/>
       </td>
        
          <td ></td>
        <td class="fldLabelView" >
         <ps:label   key="amount_key"/>
         </td>
         <td>
         <ps:textfield readonly="true"  id="sett_amount_${_pageRef}" name="financingDealRepaymentPlanCO.amount" mode="number"></ps:textfield>
       </td>
         <td colspan="3"></td>
         
       </tr>
       
       </table>
       <ps:hidden id = "hdDetails_${_pageRef}" 	 	name = "financingDealRepaymentPlanCO.ViewSettlement"></ps:hidden>
    <ps:url id="urlSettlementDetailsGrid" action="financingDealsListAction_loadSettlementDetails" namespace="/path/globalview" escapeAmp="false">
    			 <ps:param name="iv_crud"      			  		value="iv_crud"></ps:param>
				 <ps:param name="_pageRef"      		 		value="_pageRef"></ps:param>
				 <ps:param name="financingDealsSC.lineNo" 		value="financingDealsSC.lineNo"></ps:param>
				 <ps:param name="financingDealsSC.planNbr" 		value="financingDealsSC.planNbr"></ps:param>
				 <ps:param name="financingDealsSC.dealbranch" 		value="financingDealsSC.dealbranch"></ps:param>
				 </ps:url>
   <psjg:grid id="dash_settlementDetailsGridTbl_Id_${_pageRef}" 
					caption=" "
			        altRows="true"
			        addfunc=""
			    	dataType="json" 
					
			    	gridModel="gridModel" 
			    	href="%{urlSettlementDetailsGrid}" 
			        height="230"
			    	hiddengrid='%{iv_crud == "R"}'
			        navigator="false" 
			        navigatorAdd="false"
			        navigatorDelete="false"
			        navigatorEdit="false"
			        navigatorRefresh="false"
			        navigatorSearch="false"
			        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
			        sortorder="asc"
			        sortname="" 
			    	pager="false" 
			    	rowNum="20" 
			    	rowList="5,10,15,20"
			        shrinkToFit="true"
			        viewrecords="true" 
					>	        
				
				<psjg:gridColumn  id="trsSetlmtVO.SETTLEMENT_DATE"	colType="date" 	   name="trsSetlmtVO.SETTLEMENT_DATE"	   title="%{getText('Settlement_Date_key')}"    align="center"	index="trsSetlmtVO.SETTLEMENT_DATE" editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="trsSetlmtVO.VALUE_DATE"	colType="date" 	   name="trsSetlmtVO.VALUE_DATE"	   title="%{getText('Value_Date_key')}"    align="center"	index="trsSetlmtVO.VALUE_DATE" editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="trsSetlmtVO.SETTLEMENT_NBR"	colType="number" 	   name="trsSetlmtVO.SETTLEMENT_NBR"	   title="%{getText('Settlement_Number_key')}"    align="center"	index="trsSetlmtVO.SETTLEMENT_NBR" editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="trsSetlmtVO.PAID_AMOUNT"	colType="number" value="View Settlement"	   name="trsSetlmtVO.PAID_AMOUNT"	   title="%{getText('Paid_Amount_key')}"    	index="trsSetlmtVO.PAID_AMOUNT" editable="false" sortable="true"  search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
    			<psjg:gridColumn name="action" 	title="%{getText('actions_key')}" index="action" colType="custom" 	editable="false" 	sortable="false" 	search="true"	id="actionEdit" formatter="dashboard_settlementDetailsActionFormatter"  width="250" />
    			<psjg:gridColumn  id="currDecimalPoints"	colType="number" 	   name="currDecimalPoints"	   title="currDecimalPoints"    	index="currDecimalPoints" editable="false" sortable="true"  hidden="true" />
    			
			</psjg:grid>
   
	
 </div>



 <ps:set name="settlement_details_key" value="%{getEscText('settlement_details_key')}"/>
 
 
<script type="text/javascript">
var settlement_details_key = "<ps:property value='settlement_details_key'  escapeHtml='false' escapeJavaScript='true'/>"
</script>

 
 