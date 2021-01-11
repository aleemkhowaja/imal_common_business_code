<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<div id="fmsGuarantorGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>">
  <br/>
  <ps:if test='%{fmsCOList.size==0}'><% /*  Dummy grid to show in case no data  Business part on second grid*/%> 
  	   <div class="ui-state-default">&nbsp;<ps:label key="guarantees_key" id="lbl_Guarantor" /></div>
	   <table width="100%" border="0" class="">
		   <tr>
			   <td width="100%" align="center" valign="middle">
			   		<psjg:grid
				    	id="fmsGuarantorGridTbl_Id_${_pageRef}"  
				    	caption="%{getText('guarantees_key')}"
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
					 <psjg:gridColumn name="fmsCategoryVO.BRIEF_NAME_ENG" 		width="15" 					title="%{getText('Category_key')}" 			index="fmsCategoryVO.BRIEF_NAME_ENG" 		colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsCategoryVO.BRIEF_NAME_ENG" />
					 <psjg:gridColumn name="fmsFacilityVO.CODE" 				width="15"	leadZeros="10"	title="%{getText('Facility_key')}" 			index="fmsFacilityVO.CODE"  				colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityVO.CODE" />
					 <psjg:gridColumn name="fmsFacilityVO.STATUS" 											title="" 									index="fmsFacilityVO.STATUS" 				colType="text" 		hidden="true" />
					 <psjg:gridColumn name="statusDesc" 						width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="statusDesc" />
					 <psjg:gridColumn name="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	width="15"					title="%{getText('Facility_Type_key')}" 	index="fmsFacilityTypeVO.BRIEF_NAME_ENG"  	colType="text"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityTypeVO.BRIEF_NAME_ENG" />
					 <psjg:gridColumn name="currencyDesc" 						width="10"					title="%{getText('Currency_key')}" 			index="currencyDesc" 						colType="text" 		editable="false" 	sortable="true" 	search="false"	id="currencyDesc" />
					 <%/*
					 <psjg:gridColumn name="fmsFacilityVO.FACILITY_VALUE" 		width="15"					title="%{getText('Value_key')}" 			index="fmsFacilityVO.FACILITY_VALUE"  		colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityVO.FACILITY_VALUE" formatter="currencyFmatter" formatCol="curDecimalPoints" />
					 */%> 
					 <psjg:gridColumn name="INDICATOR_AMOUNT" 					width="15"					title="%{getText('Value_key')}" 			index="INDICATOR_AMOUNT"  					colType="number"  	editable="false"  	sortable="true" 	search="false"	id="INDICATOR_AMOUNT" 			  formatter="currencyFmatter" formatCol="curDecimalPoints" />
					 <psjg:gridColumn name="fmsFacilityVO.DATE_CREATED" 		width="15"					title="%{getText('Latest_Info_Date_key')}" 	index="fmsFacilityVO.DATE_CREATED" 			colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.DATE_CREATED"  />
					 <psjg:gridColumn name="curDecimalPoints" 												title=""																				colType="number" 	hidden="true" />
					</psjg:grid>
			   </td>
		   </tr>
	   </table>
  </ps:if>
  <ps:else>
  		<table width="100%" border="0" class="">
  		<tr>
  			<td width="90%">
  				<div class="ui-state-default">&nbsp;<ps:label key="guarantees_key" id="lbl_Guarantor" /></div>
  			</td>
  			<td width="5%" align="center">
  				<% /*  icon for Expanding and Collapsing All Columns */%> 
			    <span id="fmsGuarantor_collapse_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" class="ui-icon ui-icon-folder-collapsed" onclick="showHideFMSGrids('fmsGuarantorGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','GUARANTOR'); "></span> 
				<ps:hidden id="fmsGuarantor_collapse_Grid_identifier_${_pageRef}" value="hidden"></ps:hidden>
  			</td>
  			<td width="5%" align="center">
  				<span id="fmsGuarantor_print_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-print" onclick="onPrintFMSGrids('fmsGuarantorGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','GUARANTOR');"></span>
  			</td>
  		</tr>
  		</table>
  		<script type="text/javascript">
			document.getElementById("fmsGuarantor_collapse_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='colapse_all_pannels_key' />")
			document.getElementById("fmsGuarantor_print_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='Print_Statement__key' />")
		</script>
  	</ps:else>
  
  <ps:iterator value="fmsCOList" var="eachCO" status="status" >
 
	 <table width="100%" border="0" class="">
	  	<tr>
	  		<td colspan="6">
		  	  <ps:url id="urlFMSGuarantorGrid_${eachCO.fmsFacilityVO.CURRENCY}" action="fmsGuarantorDetailsListAction_loadFMSGuarantorGrid?_pageRef=${_pageRef}&dashboardSC.cif_no=${eachCO.fmsFacilityVO.CIF}&dashboardSC.baseCurrencyCode=${eachCO.fmsFacilityVO.CURRENCY}&dashboardSC.loginTypeByBr=${dashboardSC.loginTypeByBr}" namespace="/path/globalview" escapeAmp="false">
  			  </ps:url>
			    <psjg:grid
			    	id="fmsGuarantorGridTbl_Id_${_pageRef}_${eachCO.fmsFacilityVO.CURRENCY}"  
			    	href="%{urlFMSGuarantorGrid_${eachCO.fmsFacilityVO.CURRENCY}}" 
			    	caption="%{getText('Currency_key')}    :   ${eachCO.fmsFacilityVO.CURRENCY}  -   ${eachCO.currencyDesc}"
			    	dataType="json" 
			    	pager="false" 
			    	pagerButtons="false"
					filter="false"
			    	gridModel="gridModel" 
			    	viewrecords="true" 
			        altRows="true"
			        autowidth="true"
			        shrinkToFit="true"
					hiddengrid="#status.first != true"
					footerrow="true"
					userDataOnFooter="true"
				>
				 <psjg:gridColumn name="fmsCategoryVO.BRIEF_NAME_ENG" 		width="15" 					title="%{getText('Category_key')}" 			index="fmsCategoryVO.BRIEF_NAME_ENG" 		colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsCategoryVO.BRIEF_NAME_ENG" />
				 <psjg:gridColumn name="fmsFacilityVO.CODE" 				width="15"	leadZeros="10"	title="%{getText('Facility_key')}" 			index="fmsFacilityVO.CODE"  				colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityVO.CODE" />
				 <psjg:gridColumn name="fmsFacilityVO.STATUS" 											title="" 									index="fmsFacilityVO.STATUS" 				colType="text" 		hidden="true" />
				 <psjg:gridColumn name="statusDesc" 						width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="statusDesc" />
				 <psjg:gridColumn name="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	width="15"					title="%{getText('Facility_Type_key')}" 	index="fmsFacilityTypeVO.BRIEF_NAME_ENG"  	colType="text"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityTypeVO.BRIEF_NAME_ENG" />
				 <psjg:gridColumn name="currencyDesc" 						width="10"					title="%{getText('Currency_key')}" 			index="currencyDesc" 						colType="text" 		editable="false" 	sortable="true" 	search="false"	id="currencyDesc" />
				 <%/*
				 <psjg:gridColumn name="fmsFacilityVO.FACILITY_VALUE" 		width="15"					title="%{getText('Value_key')}" 			index="fmsFacilityVO.FACILITY_VALUE"  		colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsFacilityVO.FACILITY_VALUE" formatter="currencyFmatter" formatCol="curDecimalPoints" />
				 */%> 
				 <psjg:gridColumn name="INDICATOR_AMOUNT" 					width="15"					title="%{getText('Value_key')}" 			index="INDICATOR_AMOUNT"  					colType="number"  	editable="false"  	sortable="true" 	search="false"	id="INDICATOR_AMOUNT" 			  formatter="currencyFmatter" formatCol="curDecimalPoints" />
				 <psjg:gridColumn name="fmsFacilityVO.DATE_CREATED" 		width="15"					title="%{getText('Latest_Info_Date_key')}" 	index="fmsFacilityVO.DATE_CREATED" 			colType="date" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityVO.DATE_CREATED"  />
				 <psjg:gridColumn name="curDecimalPoints" 												title=""																				colType="number" 	hidden="true" />
				</psjg:grid>
		  	</td>
		  	<td width="5%"></td>
	  	</tr>
	  </table>
  <br/>
<script type="text/javascript">
//var gridId = "fmsGuarantorGridTbl_Id_"+"${_pageRef}"+"_"+"${eachCO.fmsFacilityVO.CURRENCY}";
//jQuery("#"+ gridId).jqGrid('setGridParam',{
//	gridComplete : giveDynamicHeightToFMSGrids,
//});
</script>
</ps:iterator>
</div>
