<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<script type="text/javascript">
$(document).ready(
		function() {
			$("div#queryDefinitionTab_" + _pageRef + " .collapsibleContainer")
					.collapsiblePanel();
			$("#queryDefinitionTab_" + _pageRef).sortable( {
				handle : '.collapsibleContainerTitle'
			});
			
			$("div#procedureDefinitionTab_" + _pageRef
							+ " .collapsibleContainer").collapsiblePanel();
			$("#procedureDefinitionTab_" + _pageRef).sortable( {
				handle : '.collapsibleContainerTitle'
			});
			
			//by bilal for BUG#974272
			$("#criteriaDefFormId_" + _pageRef).processAfterValid("criteria_save", {});
			
		});


var procedure_key_trans = "<ps:text name='procedure_key'/>";
var parameters_key_trans = "<ps:text name='parameters_key'/>";
var param_details_key = "<ps:text name='param_details_key' />"; 
var Query_key ="<ps:text name='Query_key' />"; 
var ok_key ="<ps:text name='ok_key' />"; 
var save_key ="<ps:text name='save_key' />"; 
var cancel_key ="<ps:text name='cancel_key' />"; 
var missing_value_key = "<ps:text name='missing_value_key' />"; // added by bilal for BUG#974752


</script>

<ps:form id="criteriaDefFormId_${_pageRef}" useHiddenProps="true"
	namespace="/path/criteria">
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="crud_${_pageRef}" name="iv_crud"></ps:hidden>
	<ps:hidden id="editMode_${_pageRef}" name="criteriaCO.editMode" />
	<ps:hidden id="branchCode_${_pageRef}" name="criteriaCO.ctsCriteriaVO.BRANCH_CODE" />
	<ps:hidden id="compCode_${_pageRef}" name="criteriaCO.ctsCriteriaVO.COMP_CODE" />
	<ps:hidden id="entityName_${_pageRef}" name="criteriaSC.entityName" />
	<ps:hidden id="methodName_${_pageRef}" />
	<ps:hidden id="paramName_${_pageRef}" />
	<ps:hidden id="criteriaParamEntityType_${_pageRef}" />


	<ps:hidden id="proceduresParamCOsStr_${_pageRef}" name="criteriaCO.proceduresParamCOsStr"></ps:hidden>
	<ps:hidden id="queriesParamCOsStr_${_pageRef}" name="criteriaCO.queriesParamCOsStr"></ps:hidden>

	<table width="100%" cellpadding="0" cellspacing="3" >

		<tr>
			<td width="10%">
				<ps:label id="Criteria_Id_${_pageRef}" key="criteria_code_key" for="criteriaId_${_pageRef}" />
			</td>
			<td width="10%">
				<ps:hidden id="oldCriteriaId_${_pageRef}" name="criteriaCO.oldCriteriaCode"></ps:hidden>
				<ps:textfield mode="number" id="criteriaId_${_pageRef}"
					maxlength="8" leadZeros="8"
					name="criteriaCO.ctsCriteriaVO.CRITERIA_CODE"
					readonly="${_recReadOnly}" disabled="true"
					dependencySrc="${pageContext.request.contextPath}/path/criteria/criteriaMaint_dependencyByCriteriaCode"
					parameter="criteriaCO.ctsCriteriaVO.CRITERIA_CODE:criteriaId_${_pageRef}"
					dependency="criteriaId_${_pageRef}:criteriaCO.ctsCriteriaVO.CRITERIA_CODE" />
			</td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>		
			<td width="8%">
				<ps:label id="Criteria_reference_${_pageRef}" key="Reference_key" for="criteriaReference_${_pageRef}" />
			</td>
			<td width="20%">
			<ps:textfield mode="text" id="criteriaReference_${_pageRef}"
					maxlength="50" 
					name="criteriaCO.ctsCriteriaVO.CRITERIA_REFERENCE"
					readonly="${_recReadOnly}"
					parameter="criteriaCO.ctsCriteriaVO.CRITERIA_REFERENCE:criteriaReference_${_pageRef},
							   criteriaCO.ctsCriteriaVO.CRITERIA_USAGE:criteriaUsage_${_pageRef},
							   criteriaCO.ctsCriteriaVO.CRITERIA_CODE:criteriaId_${_pageRef}"
					dependency="criteriaReference_${_pageRef}:criteriaCO.ctsCriteriaVO.CRITERIA_REFERENCE"
					dependencySrc="${pageContext.request.contextPath}/path/criteria/criteriaMaint_dependencyByCriteriaReference"
					/>
			</td>
			
			<td width="37%" colspan="3">
			</td>
		</tr>
		<tr>
			<td width="10%">
				<ps:label key="description_english_key"
							for="descriptionEng_${_pageRef}"
							id="lbl_descriptionEng_${_pageRef}" />
			</td>
			<td width="20%" colspan="3">
				<ps:textfield id="descriptionEng_${_pageRef}" 
							name="criteriaCO.ctsCriteriaVO.CRITERIA_DESC" maxlength="15"></ps:textfield>
			</td>	
			<td width="5%"></td>			
			<td width="8%">
				<ps:label key="criteria_usage_key" for="criteriaUsage_${_pageRef}"
							id="lbl_criteriaUsage_${_pageRef}" />
			</td>
			<td width="20%">
				<ps:select id="criteriaUsage_${_pageRef}" list="criteriaUsageList"
						listKey="code" listValue="descValue"
						name="criteriaCO.ctsCriteriaVO.CRITERIA_USAGE" onchange="criteriaUsage_afterDepEvent()" disabled="${_disabled}">
				</ps:select>
			</td>
			<td width="5%"></td>	
			<td width="5%">
				<ps:label key="Score" for="scoreValue_${_pageRef}" id="lbl_scoreValue_${_pageRef}" />
			</td>
			<td width="10%">		
				<ps:textfield mode="number" id="scoreValue_${_pageRef}"
					maxLength="10" name="criteriaCO.ctsCriteriaVO.SCORE"
					dependencySrc="${pageContext.request.contextPath}/path/criteria/criteriaMaint_dependencyByScoreValue"
					parameter="criteriaCO.ctsCriteriaVO.SCORE:scoreValue_${_pageRef}"
					dependency="scoreValue_${_pageRef}:criteriaCO.ctsCriteriaVO.SCORE"  minValue = "1"
					readonly="${_recReadOnly}"></ps:textfield>
			</td>
			<td width="17%"></td>
		</tr>
	</table>


	<div id="queryDefinitionTab_${_pageRef}"class="connectedSortable ui-helper-reset" style="width:95% ">
		<br />
		<div class="collapsibleContainer"   title="<ps:text name='Query_Definition'/>" >
			<table width="100%" border="0">
				<tr>
					<td width="5%">
						<ps:label key="query_id_key" id="lbl_query_${_pageRef}"
							for="lookuptxt_query_id_${_pageRef}"></ps:label>
					</td>
					<td width="10%">
						<psj:livesearch id="query_id_${_pageRef}" 
							name="criteriaCO.ctsCriteriaVO.QUERY_ID" mode="number" maxlength="10" 
							actionName="${pageContext.request.contextPath}/pathdesktop/QueryIdLookup_constructLookup"
							searchElement="QUERY_ID" readOnlyMode="${_recReadOnly}"
							resultList="queryId:lookuptxt_query_id_${_pageRef}"
							parameter="queryId:lookuptxt_query_id_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/QueryIdDependencyAction_dependencyByQueryId"
							dependency="lookuptxt_query_id_${_pageRef}:queryIdCO.queryId,query_name_${_pageRef}:queryIdCO.queryName"
							size="10"
							afterDepEvent="clearParamsHtmlsEvent('Q')">
						</psj:livesearch>
					</td>
					<td width="10%">
						<ps:textfield id="query_name_${_pageRef}" size="30"
							name="criteriaCO.queryIdCO.queryName" disabled="true" />
					</td>
					<td width="2%">
					</td>
					<td width="10%">
						<psj:submit button="true" buttonIcon="ui-icon-comment"
							type="button" id="new_query_btn_${_pageRef}"
							onclick="newQueryBtnClicked();">
							<ps:label key='new_query_key' />
						</psj:submit>
					</td>
					
 					<td width="10%"> 
						<psj:submit button="true" buttonIcon="ui-icon-comment" 
 							type="button" id="view_query_btn_${_pageRef}" name="view_query_btn" 
 							onclick="editSelectedQuery();"> 
 							<ps:label key='view_query_key' /> 
						</psj:submit> 
 				</td> 
					 
					<td width="10%">
						<psj:submit button="true" buttonIcon="ui-icon-comment"
							type="button" id="query_param_btn_${_pageRef}"
							onclick="criteriaMaint_onParamBtnClicked('Q');">
							<ps:label key='query_param_key' />
						</psj:submit>
					</td>
					<td width="43%">
					</td>
					<div id="queryParamsDivId_${_pageRef}" ></div>
				</tr>
				
				<tr><td colspan="5"></td></tr>

			</table>
		</div>
	</div>

	<div id="procedureDefinitionTab_${_pageRef}" class="connectedSortable ui-helper-reset" style="width:95%" >
		<br />
		<div class="collapsibleContainer" title="<ps:text name='Procedure_Definition'/>">

			<table width="100%" border="0">
				<tr>
					<td width="8%">
						<ps:label key="procedure_id_key" id="lbl_procedure_${_pageRef}"
							for="lookuptxt_proc_id_${_pageRef}"></ps:label>
					</td>
					<td width="10%">
						<psj:livesearch id="proc_id_${_pageRef}"
							name="criteriaCO.ctsCriteriaVO.PROCEDURE_ID" mode="number" maxlength="10" 
							actionName="${pageContext.request.contextPath}/pathdesktop/ProcedureIdLookup_constructLookup"
							searchElement="procId" readOnlyMode="${_recReadOnly}"
							resultList="procId:lookuptxt_proc_id_${_pageRef}"
							parameter="procId:lookuptxt_proc_id_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/ProcedureIdDependencyAction_dependencyByProcId"
							dependency="lookuptxt_proc_id_${_pageRef}:procedureIdCO.procId,proc_name_${_pageRef}:procedureIdCO.procName"
							afterDepEvent="clearParamsHtmlsEvent('P')"
							size="10"></psj:livesearch>
					</td>
					<td width="10%">
						<ps:textfield id="proc_name_${_pageRef}" size="30"
							name="criteriaCO.procedureIdCO.procName" disabled="true" />
					</td>
					<td width="2%">
					</td>
					<td width="10%">
						<psj:submit button="true" buttonIcon="ui-icon-comment"
							type="button" id="new_proc_btn_${_pageRef}"
							onclick="onNewProcClicked();">
							<ps:label key='new_proc_key' />
						</psj:submit>
					</td>

					<td width="63%">
						<psj:submit button="true" buttonIcon="ui-icon-comment"
							type="button" id="proc_param_btn_${_pageRef}"
							onclick="criteriaMaint_onParamBtnClicked('P');">
							<ps:label key='proc_param_key' />
						</psj:submit>
					</td>
					<div id="procedureParamsDivId_${_pageRef}" ></div>
					
				</tr>
			</table>



			<ps:if test="%{popupMode !='true'}" >
			<table>
				<ptt:toolBar id="criteriaMaintToolBar_${_pageRef}"
					hideInAlert="true">
					<psj:submit id="criteriaMaint_save_${_pageRef}" button="true"
						freezeOnSubmit="true" >
						<ps:label key="save_key" for="criteriaMaint_save_${_pageRef}" />
					</psj:submit>

				</ptt:toolBar>
			</table>
			</ps:if>
			<div id="procedureDivId_${_pageRef}"></div>
			
		</div>
	</div>

</ps:form>
<script type="text/javascript" src="${pageContext.request.contextPath}/businesscommon/js/core/criteria/CriteriaMaint.js">
</script>

