<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>
<ps:form id="proceduresForm_${_pageRef}" useHiddenProps="true" >
<ps:url id="urlProcedureGrid"	action="criteriaMaint_loadProcedureGrid" namespace="/path/criteria" escapeAmp="false">

</ps:url>
<div>
<table width="100%" border="0">
	<tr>
		<td>

		<psjg:grid id="procedureGridTbl_Id_${_pageRef}" 
				altRows="true" 
				addfunc="addRowProcedureGrid" 
				caption=" "
				dataType="json" 
				delfunc="deleteRowProcedureGrid"
				editurl="TTT"
				editinline="true"
				filter="false" 
				gridModel="gridModel" 
				href="%{urlProcedureGrid}" 
				height="150" 						
				loadonce="false"
				multiselect="false"
				navigator="true" 
				navigatorAdd="true"
				navigatorDelete="true"
				navigatorEdit="false" 
				navigatorRefresh="true" 
				navigatorSearch="true"
				navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				pager="true" 
				pagerButtons="false"
				rownumbers="true"
				rowNum="20"
				rowList="5,10,15,20"
				shrinkToFit="true"  
				viewrecords="true"
			>
				    
				<psjg:gridColumn id="procNames" colType="liveSearch"  width="120"
					name="procNames" index="procNames" 
					title="%{getText('proc_name_key')}" sortable="true" search="true" editable="true"
					editoptions="{ maxlength:'30'}"
					
					paramList="lookupCallingScreen:PROCEDURE"
					dataAction="${pageContext.request.contextPath}/pathdesktop/ProcedureIdLookup_constructProcedureLookup"
					resultList="procNames:procNames_lookuptxt"
					
					params="procNames:procNames"
				    dependencySrc ="${pageContext.request.contextPath}/pathdesktop/ProcedureIdDependencyAction_dependencyByProcedure"
				    dependency  ="procedureIdCO.procNames:procNames,procedureIdCO.procNames:procDesc" 
				/>
				    
				<psjg:gridColumn id="PROC_DESC_${_pageRef}" colType="text"  width="200"
					name="procDesc" disabled="true"
					title="%{getText('proc_desc_key')}"  sortable="false" search="false"
					editoptions="{ maxlength:'20'}" 
					/>

				
			</psjg:grid>
		</td>
	</tr>
	</table>

			<psj:submit id="procedure_save_${_pageRef}" button="true" freezeOnSubmit="true" onclick="procedure_setActionType('save')" progRef="${saveProgRef}" >
				<ps:label key="Save_key" for="procedure_save_${_pageRef}" />
			</psj:submit>

</div>
</ps:form>
			
<script type="text/javascript">
	$("#gview_procedureGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
	
	function procedure_setActionType(actionType)
{	
	$("#actionType_"+_pageRef).val(actionType);
}
</script>