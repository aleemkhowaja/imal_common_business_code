<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

<div id="fmsFMSApprovedLinesDEtailGridDiv_Id_<ps:property value="_pageRef" escapeHtml="true"/>">
<br/>
<table width="100%" border="0" class="">
	<tr>
		<td width="95%">
			<div class="ui-state-default">&nbsp;<ps:label key="approvedLines_key" id="lbl_approvedLines_key" /></div>
		</td>
		<td width="5%" align="center">
			<span id="fmsApprovedLinesDetail_print_Grid_icon_<ps:property value="_pageRef" escapeHtml="true"/>" style="cursor:pointer;" class="ui-icon ui-icon-print" onclick="onPrintFMSGrids('fmsFMSApprovedLinesDEtailGridDiv_Id_<ps:property value="_pageRef" escapeHtml="false" escapeJavaScript="true" />','APPROVEDLINESDETAIL');"></span>
			<ps:hidden id="fmsApprovedLines_collapse_Grid_identifier_${_pageRef}" value="hidden"></ps:hidden>
		</td>
	</tr>
</table>
<script type="text/javascript">
	document.getElementById("fmsApprovedLinesDetail_print_Grid_icon_${_pageRef}").setAttribute("title","<ps:text name='Print_Statement__key' />")
</script> 
<table width="100%" border="0" class="">
	 	<tr>
		  	<td >
			  <ps:url id="urlFMSApprovedLinesDetailGrid_${_pageRef}" action="fmsApprovedLineDetailsListAction_loadFMSApprovedLinesDetailGrid?_pageRef=${_pageRef}&dashboardSC.cif_no=${dashboardSC.cif_no}&dashboardSC.branchCode=${dashboardSC.branchCode}&dashboardSC.facilityCode=${dashboardSC.facilityCode}&fmsCO.curDecimalPoints=${fmsCO.curDecimalPoints}&dashboardSC.curName=${dashboardSC.curName}" namespace="/path/globalview" escapeAmp="false">
			  </ps:url>
			    <psjg:grid
			    	id="fmsApprovedLinesDetailGridTbl_Id_${_pageRef}"  
			    	href="%{urlFMSApprovedLinesDetailGrid_${_pageRef}}" 
			    	caption="%{getText('Facility_No_key')}    :   ${dashboardSC.facilityCode}"
			    	dataType="json" 
			    	pager="false" 
					filter="false"
			    	gridModel="gridModel" 
			    	viewrecords="true" 
			        altRows="true"
			        autowidth="true"
					hiddengrid="false"
				>
					 <psjg:gridColumn name="fmsFacilityDetVO.LINE_NBR" 	 				width="10" leadZeros="4"	title="%{getText('lineNo_key')}" 			index="fmsFacilityDetVO.LINE_NBR" 		colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityDetVO.LINE_NBR" />
					 <psjg:gridColumn name="fmsFacilityDetVO.CLASS" 	 				width="10" leadZeros="4"	title=""  		index="fmsFacilityDetVO.CLASS" 			colType="text" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityDetVO.CLASS" />
					 <psjg:gridColumn name="statusDesc" 								width="15" 	title="" 						index="statusDesc" 						colType="text" 	editable="false" 	sortable="false" 	search="false"	id="statusDesc" />
					 <psjg:gridColumn name="className" 	    							width="15" 	title="%{getText('brief_Name_key')}" 			index="className" 		colType="text" 	editable="false" 	sortable="false" 	search="false"	id="className" />
				     <psjg:gridColumn name="currencyDesc" 								width="10"	title="%{getText('Currency_key')}" 				index="currencyDesc" 	colType="text" 	editable="false" 	sortable="true" 	search="false"	id="currencyDesc" />
				     <psjg:gridColumn name="fmsFacilityDetVO.FACILITY_VALUE" 	    	width="10" 	title="%{getText('Amount_key')}" 				index="fmsFacilityDetVO.FACILITY_VALUE" colType="number" 	editable="false" 	sortable="false" 	search="false"	id="fmsFacilityDetVO.FACILITY_VALUE" formatter="currencyFmatter" formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UTILIZED_AMOUNT" 	    					width="10" 	title="%{getText('Utilized_Amount_key')}" 		index="UTILIZED_AMOUNT" 				colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="UNUTILIZED_AMOUNT" 	    					width="10" 	title="%{getText('Unutilized_Amount_key')}" 	index="UNUTILIZED_AMOUNT" 				colType="number" 	editable="false" 	sortable="false" 	search="false"	id="UNUTILIZED_AMOUNT" 				formatter="currencyFmatter"  formatCol="curDecimalPoints"/>
					 <psjg:gridColumn name="fmsFacilityDetVO.GENERAL_FACILITY_TYPE" 	 			title="" 																colType="text" 		hidden="true" />
					 <psjg:gridColumn name="curDecimalPoints" 										title=""																colType="number" 		hidden="true" />
				</psjg:grid>
			</td>
	 		<td width="5%"></td>
		</tr>
	  </table>
<script type="text/javascript">
var class_key = "<ps:text name='Class_key' />";
jQuery("#fmsApprovedLinesDetailGridTbl_Id_"+ _pageRef).jqGrid('setGroupHeaders', {
	useColSpanStyle: true, groupHeaders:[{startColumnName: 'fmsFacilityDetVO.CLASS', numberOfColumns: 2, titleText:class_key}]
});
</script>
</div>