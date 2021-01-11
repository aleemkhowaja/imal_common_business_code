<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

	<script type="text/javascript">
		var collateral_key = "<ps:text name='Collateral_key' />";
	</script>
<div id="fmsFMSApprovedLinesGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>">
  <br/>
  <ps:if test='%{fmsCOList.size==0}'> <% /*  Dummy grid to show in case no data  Business part on second grid*/%> 
  	  <div class="ui-state-default">&nbsp;<ps:label key="approvedLines_key" id="lbl_approvedLines_key" /></div>
	  <table width="100%" border="0" class="">
		   <tr>
			   <td width="100%" align="center" valign="middle">
			   	 <psjg:grid
			    	id="fmsApprovedLinesGridTbl_Id_${_pageRef}"  
			    	caption="%{getText('approvedLines_key')}"
			    	dataType="local" 
			    	pager="true" 
			    	pagerButtons="false"
					filter="false"
			    	gridModel="gridModel" 
			    	viewrecords="true" 
			        altRows="true"
			        autowidth="true"
					hiddengrid="false"
					height="50"
				>
					 <psjg:gridColumn name="fmsFacilityVO.BRANCH" 	    		width="10" leadZeros="4"	title="%{getText('Branch_key')}" 				index="fmsFacilityVO.BRANCH" 				colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.BRANCH" />
					 <psjg:gridColumn name="fmsFacilityVO.CODE" 				width="20" leadZeros="12"	title="%{getText('Facility_No_key')}"  			index="fmsFacilityVO.CODE" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.CODE" 			formatter="fmsFacilityVO_CODE_Formatter" />
					 <psjg:gridColumn name="fmsFacilityVO.DATE_EFFECTIVE_UNTIL" width="15"					title="%{getText('Expiry_Date_key')}" 			index="fmsFacilityVO.DATE_EFFECTIVE_UNTIL" 	colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.DATE_EFFECTIVE_UNTIL"  />
					 <psjg:gridColumn name="fmsFacilityVO.REVIEW_DATE" 			width="15"					title="%{getText('Review_Date_key')}" 			index="fmsFacilityVO.REVIEW_DATE" 			colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.REVIEW_DATE"  />
					 <psjg:gridColumn name="fmsFacilityVO.FACILITY_VALUE" 	    width="15" 					title="%{getText('Facility_Amount_key')}" 		index="fmsFacilityVO.FACILITY_VALUE" 		colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.FACILITY_VALUE" 	formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UTILIZED_AMOUNT" 	    			width="15" 					title="%{getText('Utilized_Amount_key')}" 		index="UTILIZED_AMOUNT" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UNUTILIZED_AMOUNT" 	    			width="17" 					title="%{getText('Unutilized_Amount_key')}" 	index="UNUTILIZED_AMOUNT" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UNUTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="BLOCKED_AMOUNT" 	    			width="15" 					title="%{getText('blockedAmount_key')}" 		index="BLOCKED_AMOUNT" 						colType="number" 	editable="false" 	sortable="false" 	search="false"	id="BLOCKED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="revolveOnOff" 						width="20"					title="%{getText('Revolving_One_Off_key')}" 	index="revolveOnOff" 						colType="text" 		editable="false" 	sortable="false" 	search="false"	id="revolveOnOff" />
					 <psjg:gridColumn name="fmsFacilityVO.CIF" 												title=""																							colType="number" 	hidden="true" />
					 <psjg:gridColumn name="fmsFacilityVO.CURRENCY" 										title=""																					colType="number" 	hidden="true" />
					 <psjg:gridColumn name="curDecimalPoints" 												title=""																							colType="number" 	hidden="true" />
				  </psjg:grid>
			   </td>
		   </tr>
	   </table>
  </ps:if>
  <ps:else>
	  
	  	<table width="100%" border="0" class="">
  			<tr>
  				<td width="90%">
  					<div class="ui-state-default">&nbsp;<ps:label key="approvedLines_key" id="lbl_approvedLines_key" /></div>
  				</td>
  			<td width="5%" align="center">
  				<% /*  icon for Expanding and Collapsing All Columns */%> 
			   <span id="fmsApprovedLines_collapse_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-folder-collapsed" onclick="showHideFMSGrids('fmsFMSApprovedLinesGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','APPROVEDLINES');"></span> 
			   
	  		   <ps:hidden id="fmsApprovedLines_collapse_Grid_identifier_${_pageRef}" value="hidden"></ps:hidden>
  			</td>
  			<td width="5%" align="center">
  				<span id="fmsApprovedLines_print_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-print" onclick="onPrintFMSGrids('fmsFMSApprovedLinesGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','APPROVEDLINES');"></span>
  			</td>
  		</tr>
  		</table>
  		<script type="text/javascript">
			document.getElementById("fmsApprovedLines_collapse_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='colapse_all_pannels_key' />")
			document.getElementById("fmsApprovedLines_print_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='Print_Statement__key' />")
		</script>
  </ps:else>
 
<ps:iterator value="fmsCOList" var="eachCO" status="status" >
 
	  <table width="100%" border="0" class="">
	 	<tr>
		  	<td >
			  <ps:url id="urlFMSApprovedLinesGrid_${eachCO.fmsFacilityVO.CURRENCY}" action="fmsApprovedLineDetailsListAction_loadFMSApprovedLinesGrid?_pageRef=${_pageRef}&dashboardSC.cif_no=${eachCO.fmsFacilityVO.CIF}&dashboardSC.baseCurrencyCode=${eachCO.fmsFacilityVO.CURRENCY}&dashboardSC.curName=${eachCO.currencyDesc}&dashboardSC.loginTypeByBr=${dashboardSC.loginTypeByBr}" namespace="/path/globalview" escapeAmp="false">
			  </ps:url>
			    <psjg:grid
			    	id="fmsApprovedLinesGridTbl_Id_${_pageRef}_${eachCO.fmsFacilityVO.CURRENCY}"  
			    	href="%{urlFMSApprovedLinesGrid_${eachCO.fmsFacilityVO.CURRENCY}}" 
			    	caption="%{getText('Currency_key')}    :   ${eachCO.fmsFacilityVO.CURRENCY}  -   ${eachCO.currencyDesc}"
			    	dataType="json"    
			    	pager="false" 
			    	rowNum="500" 
					filter="false"
			    	gridModel="gridModel" 
			    	viewrecords="true" 
			        altRows="true"
			        autowidth="true"
					hiddengrid="#status.first != true"
				>
					 <psjg:gridColumn name="fmsFacilityVO.BRANCH" 	    		width="10" leadZeros="4"	title="%{getText('Branch_key')}" 				index="fmsFacilityVO.BRANCH" 				colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.BRANCH" />
					 <psjg:gridColumn name="fmsFacilityVO.CODE" 				width="20" leadZeros="12"	title="%{getText('Facility_No_key')}"  			index="fmsFacilityVO.CODE" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.CODE" 			formatter="fmsFacilityVO_CODE_Formatter" />
					 <psjg:gridColumn name="fmsFacilityVO.DATE_EFFECTIVE_UNTIL" width="15"					title="%{getText('Expiry_Date_key')}" 			index="fmsFacilityVO.DATE_EFFECTIVE_UNTIL" 	colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.DATE_EFFECTIVE_UNTIL"  />
					 <psjg:gridColumn name="fmsFacilityVO.REVIEW_DATE" 			width="15"					title="%{getText('Review_Date_key')}" 			index="fmsFacilityVO.REVIEW_DATE" 			colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.REVIEW_DATE"  />
					 <psjg:gridColumn name="fmsFacilityVO.FACILITY_VALUE" 	    width="15" 					title="%{getText('Facility_Amount_key')}" 		index="fmsFacilityVO.FACILITY_VALUE" 		colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.FACILITY_VALUE" 	formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UTILIZED_AMOUNT" 	    			width="15" 					title="%{getText('Utilized_Amount_key')}" 		index="UTILIZED_AMOUNT" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UNUTILIZED_AMOUNT" 	    			width="17" 					title="%{getText('Unutilized_Amount_key')}" 	index="UNUTILIZED_AMOUNT" 					colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UNUTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="BLOCKED_AMOUNT" 	    			width="15" 					title="%{getText('blockedAmount_key')}" 		index="BLOCKED_AMOUNT" 						colType="number" 	editable="false" 	sortable="false" 	search="false"	id="BLOCKED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="revolveOnOff" 						width="20"					title="%{getText('Revolving_One_Off_key')}" 	index="revolveOnOff" 						colType="text" 		editable="false" 	sortable="false" 	search="false"	id="revolveOnOff" />
					 <psjg:gridColumn name="fmsFacilityVO.CIF" 												title=""																					colType="number" 	hidden="true" />
					 <psjg:gridColumn name="fmsFacilityVO.CURRENCY" 										title=""																					colType="number" 	hidden="true" />
					 <psjg:gridColumn name="currencyDesc" 													title=""																					colType="text" 		hidden="true" />
					 <psjg:gridColumn name="curDecimalPoints" 												title=""																					colType="number" 	hidden="true" />
				  </psjg:grid>
			</td>
	 		<td width="5%"></td>
		</tr>
	  </table>
	  <br/>
<script type="text/javascript">
//var gridId = "fmsApprovedLinesGridTbl_Id_"+"${_pageRef}"+"_"+"${eachCO.fmsFacilityVO.CURRENCY}";
//jQuery("#"+ gridId).jqGrid('setGridParam',{
//	gridComplete : giveDynamicHeightToFMSGrids
//});
</script>
</ps:iterator>
</div>
