<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

	<script type="text/javascript">
		var collateral_key = "<ps:text name='Collateral_key' />";
	</script>
<div id="fmsCollateralsGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>">
  <br/>
  <ps:if test='%{fmsCOList.size==0}'> <% /*  Dummy grid to show in case no data  Business part on second grid*/%> 
  	  <div class="ui-state-default">&nbsp;<ps:label key="collaterals_key" id="lbl_Collateral" /></div>
	  <table width="100%" border="0" class="">
		   <tr>
			   <td width="100%" align="center" valign="middle">
			   		<psjg:grid
				    	id="fmsCollateralsGridTbl_Id_${_pageRef}"  
				    	caption="%{getText('collaterals_key')}"
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
						 <psjg:gridColumn name="fmsCollateralVO.BRANCH" 	    width="10" leadZeros="4"	title="%{getText('Branch_key')}" 			index="fmsCollateralVO.BRANCH" 			colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.BRANCH" />
						 <psjg:gridColumn name="fmsCollateralVO.CODE" 			width="25" leadZeros="12"	title="" 									index="fmsCollateralVO.CODE" 			colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.CODE" />
						 <psjg:gridColumn name="fmsCollateralVO.BRIEF_NAME_ENG" width="25"					title="" 									index="fmsCollateralVO.BRIEF_NAME_ENG" 	colType="text" 		editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.BRIEF_NAME_ENG" />
						 <psjg:gridColumn name="fmsFacilityVO.FROM_APPLICATION" width="15" leadZeros="10"   title="%{getText('application')}" 			index="fmsFacilityVO.FROM_APPLICATION" 	colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.FROM_APPLICATION" />
						 <psjg:gridColumn name="fmsAppCollateralVO.COVERAGE" 	width="15"					title="%{getText('Coverage_percent_key')}" 	index="fmsAppCollateralVO.COVERAGE" 	colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsAppCollateralVO.COVERAGE" />
						 <psjg:gridColumn name="calcAmount" 					width="20"					title="%{getText('Amount_key')}" 			index="calcAmount"  					colType="number"  	editable="false"  	sortable="false" 	search="false"	id="calcAmount" 	formatter="currencyFmatter" formatCol="curDecimalPoints" />
						 <psjg:gridColumn name="fmsCollateralVO.STATUS" 									title="" 									index="fmsCollateralVO.STATUS" 			colType="text" 		hidden="true" />
					 	 <psjg:gridColumn name="statusDesc" 					width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 						colType="text" 		editable="false" 	sortable="false" 	search="false"	id="statusDesc" />
					 	 <psjg:gridColumn name="curDecimalPoints" 											title=""																			colType="number" 	hidden="true" />
					  </psjg:grid>
			   </td>
		   </tr>
	   </table>
	   <script type="text/javascript">
			var gId = "fmsCollateralsGridTbl_Id_"+"<ps:property value='_pageRef' escapeHtml='false' escapeJavaScript='true' />";
			jQuery("#"+ gId).jqGrid('setGroupHeaders', {
				useColSpanStyle: true, groupHeaders:[{startColumnName: 'fmsCollateralVO.CODE', numberOfColumns: 2, titleText:collateral_key}]
			});
	   </script>
  </ps:if>
  <ps:else>
  	<table width="100%" border="0" class="">
  			<tr>
  				<td width="90%">
  					<div class="ui-state-default">&nbsp;<ps:label key="collaterals_key" id="lbl_Collateral" /></div>
  				</td>
  				<td width="5%" align="center">
  				<% /*  icon for Expanding and Collapsing All Columns */%> 
			   <span id="fmsCollaterals_collapse_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-folder-collapsed" onclick="showHideFMSGrids('fmsCollateralsGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','COLLATERALS');"></span> 
			   <ps:hidden id="fmsCollaterals_collapse_Grid_identifier_${_pageRef}" value="hidden"></ps:hidden>
  			</td>
  			<td width="5%" align="center">
  				<span id="fmsCollaterals_print_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-print" onclick="onPrintFMSGrids('fmsCollateralsGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','COLLATERALS');"></span>
  			</td>
  		</tr>
  	</table>
  	 <script type="text/javascript">
		document.getElementById("fmsCollaterals_collapse_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='colapse_all_pannels_key' />")
		document.getElementById("fmsCollaterals_print_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='Print_Statement__key' />")
	</script>
  </ps:else>
  
  <ps:iterator value="fmsCOList" var="eachCO" status="status" >
 
	 <table width="100%" border="0" class="">
	 	<tr>
	  		<td colspan="6">
		  	  <ps:url id="urlFMSCollateralsGrid_${eachCO.fmsCollateralVO.CURRENCY}" action="fmsCollateralDetailsListAction_loadFMSCollateralGrid?_pageRef=${_pageRef}&dashboardSC.cif_no=${eachCO.fmsFacilityVO.CIF}&dashboardSC.baseCurrencyCode=${eachCO.fmsCollateralVO.CURRENCY}&dashboardSC.loginTypeByBr=${dashboardSC.loginTypeByBr}" namespace="/path/globalview" escapeAmp="false">
  			  </ps:url>
			    <psjg:grid
			    	id="fmsCollateralsGridTbl_Id_${_pageRef}_${eachCO.fmsCollateralVO.CURRENCY}"  
			    	href="%{urlFMSCollateralsGrid_${eachCO.fmsCollateralVO.CURRENCY}}" 
			    	caption="%{getText('Currency_key')}    :   ${eachCO.fmsCollateralVO.CURRENCY}  -   ${eachCO.currencyDesc}"
			    	dataType="json" 
			    	pager="false" 
					filter="false"
			    	gridModel="gridModel" 
			    	viewrecords="true" 
			        altRows="true"
			        autowidth="true"
					hiddengrid="#status.first != true"
					footerrow="true"
					userDataOnFooter="true"
				>
					 <psjg:gridColumn name="fmsCollateralVO.BRANCH" 	    width="10" leadZeros="4"	title="%{getText('Branch_key')}" 			index="fmsCollateralVO.BRANCH" 			colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.BRANCH" />
					 <psjg:gridColumn name="fmsCollateralVO.CODE" 			width="25" leadZeros="12"	title="" 									index="fmsCollateralVO.CODE" 			colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.CODE" />
					 <psjg:gridColumn name="fmsCollateralVO.BRIEF_NAME_ENG" width="25"					title="" 									index="fmsCollateralVO.BRIEF_NAME_ENG" 	colType="text" 		editable="false" 	sortable="false" 	search="false"	id="fmsCollateralVO.BRIEF_NAME_ENG" />
					 <psjg:gridColumn name="fmsFacilityVO.FROM_APPLICATION" width="15" leadZeros="10"   title="%{getText('application')}" 			index="fmsFacilityVO.FROM_APPLICATION" 	colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityVO.FROM_APPLICATION" />
					 <psjg:gridColumn name="fmsAppCollateralVO.COVERAGE" 	width="15"					title="%{getText('Coverage_percent_key')}" 	index="fmsAppCollateralVO.COVERAGE" 	colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsAppCollateralVO.COVERAGE" />
					 <psjg:gridColumn name="calcAmount" 					width="20"					title="%{getText('Amount_key')}" 			index="calcAmount"  					colType="number"  	editable="false"  	sortable="false" 	search="false"	id="calcAmount" 	formatter="currencyFmatter" formatCol="curDecimalPoints" />
					 <psjg:gridColumn name="fmsCollateralVO.STATUS" 									title="" 									index="fmsCollateralVO.STATUS" 			colType="text" 		hidden="true" />
				 	 <psjg:gridColumn name="statusDesc" 					width="10"					title="%{getText('Status_key')}" 			index="statusDesc" 						colType="text" 		editable="false" 	sortable="false" 	search="false"	id="statusDesc" />
				 	 <psjg:gridColumn name="curDecimalPoints" 											title=""																			colType="number" 	hidden="true" />
				  </psjg:grid>
		  	</td>
		  	<td width="5%"></td>
	  	</tr>
	  </table>
  <br/>
<script type="text/javascript">
var gridId = "fmsCollateralsGridTbl_Id_"+"${_pageRef}"+"_"+"${eachCO.fmsCollateralVO.CURRENCY}";
jQuery("#"+ gridId).jqGrid('setGroupHeaders', {
	useColSpanStyle: true, groupHeaders:[{startColumnName: 'fmsCollateralVO.CODE', numberOfColumns: 2, titleText:collateral_key}]
});
//jQuery("#"+ gridId).jqGrid('setGridParam',{
//	gridComplete : giveDynamicHeightToFMSGrids
//});
</script>
  </ps:iterator>
</div>
