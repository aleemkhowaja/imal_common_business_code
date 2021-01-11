<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

<script type="text/javascript">
	var facility_type_key = "<ps:text name='Facility_Type_key' />";
</script>
<div id="fmsNewAppGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>">
  <br/>
  <ps:if test='%{fmsCOList.size==0}'> <% /*  Dummy grid to show in case no data  Business part on second grid*/%>  
  	  <div class="ui-state-default">&nbsp;<ps:label key="newApp_key" id="lbl_Facility" /></div>
	  <table width="100%" border="0" class="">
		   <tr>
			   <td width="100%" align="center" valign="middle">
			   		<psjg:grid
				    	id="fmsNewAppGridTbl_Id_${_pageRef}"  
				    	caption="%{getText('newApp_key')}"
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
					 <psjg:gridColumn name="fmsApplVO.BRANCH" 					width="10" leadZeros="4"	title="%{getText('Branch_key')}" 			index="fmsApplVO.BRANCH" 					colType="number" 	editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.BRANCH" />
					 <psjg:gridColumn name="fmsApplVO.CODE" 					width="15" leadZeros="10"	title="%{getText('Application_Ref_key')}" 	index="fmsApplVO.CODE" 						colType="number" 	editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.CODE" />
					 <psjg:gridColumn name="currencyDesc" 						width="10"					title="%{getText('Currency_key')}" 			index="currencyDesc" 						colType="text" 		editable="false" 	sortable="true" 	search="false"	id="currencyDesc" />
					 <psjg:gridColumn name="fmsApplVO.VALUE" 					width="15"					title="%{getText('FC_Amount_key')}" 		index="fmsApplVO.VALUE"  					colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsApplVO.VALUE" 				formatter="currencyFmatter" formatCol="curDecimalPoints" />
					 <psjg:gridColumn name="cvAmount" 							width="15"					title="%{getText('CV_Amount_key')}" 		index="cvAmount"  							colType="number"  	editable="false"  	sortable="true" 	search="false"	id="cvAmount" 						formatter="currencyFmatter" formatCol="baseCurrDecPoint" />
					 <psjg:gridColumn name="appForDesc" 						width="10"					title="%{getText('Application_For_key')}" 	index="appForDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="appForDesc" />
					 <psjg:gridColumn name="fmsApplVO.APPLICATION_FOR" 										title="" 									index="fmsApplVO.APPLICATION_FOR" 			colType="text" 		hidden="true" />
					 <psjg:gridColumn name="fmsApplVO.STATUS" 												title="" 									index="fmsApplVO.STATUS" 					colType="text" 		hidden="true" />
					 <psjg:gridColumn name="statusDesc" 						width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="statusDesc" />
					 <psjg:gridColumn name="newAppMaxDate" 						width="15"					title="%{getText('Latest_Info_Date_key')}" 	index="newAppMaxDate" 						colType="date" 		editable="false" 	sortable="true" 	search="false"	id="newAppMaxDate" />
					 <psjg:gridColumn name="fmsApplVO.LOAN_TYPE" 				width="15"					title="" 									index="fmsApplVO.LOAN_TYPE" 				colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.LOAN_TYPE" />
					 <psjg:gridColumn name="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	width="15"					title="" 									index="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityTypeVO.BRIEF_NAME_ENG" />
					 <psjg:gridColumn name="curDecimalPoints" 												title=""																				colType="number" 	hidden="true" />
					 <psjg:gridColumn name="baseCurrDecPoint" 												title=""																				colType="number" 	hidden="true" />
					</psjg:grid>
			   </td>
		   </tr>
	  </table>
	  <script type="text/javascript">
			var gId = "fmsNewAppGridTbl_Id_"+"<ps:property value='_pageRef' escapeHtml='false' escapeJavaScript='true' />";
			jQuery("#"+ gId).jqGrid('setGroupHeaders', {
				useColSpanStyle: true, groupHeaders:[{startColumnName: 'fmsApplVO.LOAN_TYPE', numberOfColumns: 2, titleText:facility_type_key}]
			});
	  </script>
  </ps:if>
  <ps:else>
  	<table width="100%" border="0" class="">
 		<tr>
 			<td width="90%">
 				<div class="ui-state-default">&nbsp;<ps:label key="newApp_key" id="lbl_Facility" /></div>
 			</td>
 			<td width="5%" align="center">
 				<% /*  icon for Expanding and Collapsing All Columns */%> 
		   <span id="fmsNewApp_collapse_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-folder-collapsed" onclick="showHideFMSGrids('fmsNewAppGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','NEWAPP');"></span> 
		   <ps:hidden id="fmsNewApp_collapse_Grid_identifier_${_pageRef}" value="hidden"></ps:hidden>
 			</td>
 			<td width="5%" align="center">
 				<span id="fmsNewApp_print_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-print" onclick="onPrintFMSGrids('fmsNewAppGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','NEWAPP');"></span>
 			</td>
  		</tr>
  	</table>
  	<script type="text/javascript">
		document.getElementById("fmsNewApp_collapse_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='colapse_all_pannels_key' />")
		document.getElementById("fmsNewApp_print_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='Print_Statement__key' />")
	</script>
   </ps:else>
  
  <ps:iterator value="fmsCOList" var="eachCO" status="status" >
 
	 <table width="100%" border="0" class="">
	 	<tr>
	  		<td colspan="6">
		  	  <ps:url id="urlFMSNewAppGrid_${eachCO.fmsApplVO.CURRENCY}" action="fmsNewAppDetailsListAction_loadFMSNewAppGrid?_pageRef=${_pageRef}&dashboardSC.cif_no=${eachCO.fmsApplVO.CIF}&dashboardSC.baseCurrencyCode=${eachCO.fmsApplVO.CURRENCY}&dashboardSC.loginTypeByBr=${dashboardSC.loginTypeByBr}" namespace="/path/globalview" escapeAmp="false">
  			  </ps:url>
			    <psjg:grid
			    	id="fmsNewAppGridTbl_Id_${_pageRef}_${eachCO.fmsApplVO.CURRENCY}"  
			    	href="%{urlFMSNewAppGrid_${eachCO.fmsApplVO.CURRENCY}}" 
			    	caption="%{getText('Currency_key')}    :   ${eachCO.fmsApplVO.CURRENCY}  -   ${eachCO.currencyDesc}"
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
					userDataOnFooter="true" onCompleteTopics="footerFormatting"
				>
				 <psjg:gridColumn name="fmsApplVO.BRANCH" 					width="10" leadZeros="4"	title="%{getText('Branch_key')}" 			index="fmsApplVO.BRANCH" 					colType="number" 	editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.BRANCH" />
				 <psjg:gridColumn name="fmsApplVO.CODE" 					width="15" leadZeros="10"	title="%{getText('Application_Ref_key')}" 	index="fmsApplVO.CODE" 						colType="number" 	editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.CODE" />
				 <psjg:gridColumn name="currencyDesc" 						width="10"					title="%{getText('Currency_key')}" 			index="currencyDesc" 						colType="text" 		editable="false" 	sortable="true" 	search="false"	id="currencyDesc" />
				 <psjg:gridColumn name="fmsApplVO.VALUE" 					width="15"					title="%{getText('FC_Amount_key')}" 		index="fmsApplVO.VALUE"  					colType="number"  	editable="false"  	sortable="true" 	search="false"	id="fmsApplVO.VALUE" 				formatter="currencyFmatter" formatCol="curDecimalPoints" />
				 <psjg:gridColumn name="cvAmount" 							width="15"					title="%{getText('CV_Amount_key')}" 		index="cvAmount"  							colType="number"  	editable="false"  	sortable="false" 	search="false"	id="cvAmount" 						formatter="currencyFmatter" formatCol="baseCurrDecPoint" />
				 <psjg:gridColumn name="appForDesc" 						width="15"					title="%{getText('Application_For_key')}" 	index="appForDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="appForDesc" />
				 <psjg:gridColumn name="fmsApplVO.APPLICATION_FOR" 										title="" 									index="fmsApplVO.APPLICATION_FOR" 			colType="text" 		hidden="true" />
				 <psjg:gridColumn name="fmsApplVO.STATUS" 												title="" 									index="fmsApplVO.STATUS" 					colType="text" 		hidden="true" />
				 <psjg:gridColumn name="statusDesc" 						width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 							colType="text" 		editable="false" 	sortable="true" 	search="false"	id="statusDesc" />
				 <psjg:gridColumn name="newAppMaxDate" 						width="15"					title="%{getText('Latest_Info_Date_key')}" 	index="newAppMaxDate" 						colType="date" 		editable="false" 	sortable="true" 	search="false"	id="newAppMaxDate" />
				 <psjg:gridColumn name="fmsApplVO.LOAN_TYPE" 				width="15"					title="" 									index="fmsApplVO.LOAN_TYPE" 				colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsApplVO.LOAN_TYPE" />
				 <psjg:gridColumn name="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	width="15"					title="" 									index="fmsFacilityTypeVO.BRIEF_NAME_ENG" 	colType="text" 		editable="false" 	sortable="true" 	search="false"	id="fmsFacilityTypeVO.BRIEF_NAME_ENG" />
				 <psjg:gridColumn name="curDecimalPoints" 												title=""																				colType="number" 	hidden="true" />
				 <psjg:gridColumn name="baseCurrDecPoint" 												title=""																				colType="number" 	hidden="true" />
				</psjg:grid>
		  	</td>
		  	<td width="5%"></td>
	  	</tr>
	  </table>
  <br/>

<script type="text/javascript">
var gridId = "fmsNewAppGridTbl_Id_"+"<ps:property value='_pageRef' escapeHtml='false' escapeJavaScript='true'/>"+"_"+"<ps:property value='eachCO.fmsApplVO.CURRENCY' escapeHtml='false' escapeJavaScript='true'/>";   
jQuery("#"+ gridId).jqGrid('setGroupHeaders', {
	useColSpanStyle: true, groupHeaders:[{startColumnName: 'fmsApplVO.LOAN_TYPE', numberOfColumns: 2, titleText:facility_type_key}]
});

$(document).ready(
		function() {$("#" + gridId).subscribe("footerFormatting",
				function() {
					var gridId1 = "fmsNewAppGridTbl_Id_"+ "<ps:property value='_pageRef' escapeHtml='false' escapeJavaScript='true'/>"+ "_"+ "<ps:property value='eachCO.fmsApplVO.CURRENCY' escapeHtml='false' escapeJavaScript='true'/>";
					var fcValueSum = $("#" + gridId1).jqGrid('getCol','fmsApplVO.VALUE',false, 'sum');
					var cvValueSum = $("#" + gridId1).jqGrid('getCol','cvAmount',false, 'sum');
					var curDecPoints = $("#" + gridId1).jqGrid('getCell', 1,'curDecimalPoints');
					var baseDecPoints = $("#" + gridId1).jqGrid('getCell', 1,'baseCurrDecPoint');
					$("#" + gridId1).jqGrid('footerData',
							'set',{
									'currencyDesc' : "Total"
								  }, false);
					$("#" + gridId1).jqGrid('footerData',
							'set',{
									'fmsApplVO.VALUE' : formatToCurrencyDecimal(fcValueSum,curDecPoints)
								  }, false);
					$("#" + gridId1).jqGrid('footerData',
							'set',{
									'cvAmount' : formatToCurrencyDecimal(cvValueSum,baseDecPoints)
								  }, false);
						});
					});
	//jQuery("#"+ gridId).jqGrid('setGridParam',
	//	{
	//		gridComplete : giveDynamicHeightToFMSGrids
	//	});
function formatToCurrencyDecimal(num, decimal) {
	var nbFormat = returnNbFormat(decimal);
	return $.formatNumberNumeric(num, {
		format : nbFormat,
		applyRounding : true
	});
}
</script>
  </ps:iterator>
</div>