<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %>

<div id = "scoringControlMain_${_pageRef}">
<ps:form useHiddenProps="true" id="scoringControlRecordMaintFormId_${_pageRef}"  namespace="/path/scoringControlRecord">

<ps:hidden id="date_updated_${_pageRef}"
		name="scoringControlRecordCO.cifControlDefineScoreRangeVO.DATE_UPDATED" />
	<ps:hidden id="statusFlags_${_pageRef}"
		name="scoringControlRecordCO.amlCifControlScoreVO.STATUS" />
		<ps:hidden id="status_${_pageRef}"
		name="scoringControlRecordCO.cifControlDefineScoreRangeVO.ENTITY_STATUS" />	
<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
	<ps:hidden id="saveUpScoringControlRecord_${_pageRef}" name="actionType" />
	
	<ps:hidden id="allControlRecordDetailsData_${_pageRef}"
		name="allControlRecordDetailsData" />
	<ps:hidden id="updatedListControlRecord_${_pageRef}"
		name="updatedListControlRecord" />

	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:set name="record_saved_Successfully_key" value="%{getEscText('Record_Saved_Successfully_key')}"/>
<ps:hidden id="createdBy_${_pageRef}"
		name="scoringControlRecordCO.cifControlDefineScoreRangeVO.CREATED_BY" />
<ps:hidden id="createdByFlags_${_pageRef}"
		name="scoringControlRecordCO.amlCifControlScoreVO.CREATED_BY" />
<ps:hidden id="createdDateFlags_${_pageRef}"
		name="scoringControlRecordCO.amlCifControlScoreVO.CREATED_DATE" />
	<ps:hidden id="modifiedBy_${_pageRef}"
		name="scoringControlRecordCO.cifControlDefineScoreRangeVO.MODIFIED_BY" />

<ps:hidden id="dual_param" name="_dualParam" />

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

<table width="100%">
		<tr>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>
			<td width="5%"></td>

		</tr>
	<tr>
	
	<td colspan="12">
	
	</td>
	<td>
	</td>
	<td>
	</td>
	<td>
	</td>
	
	<ps:if test='_dualParam == "true"'>
		<td class="fldLabelView" align="right"><ps:label
					key="status_key" for="status_desc_${_pageRef}"
					id="lbl_status_${_pageRef}"/></td>

			<td class="fldDataEdit"><ps:textfield size="20"
					id="status_desc_${_pageRef}" readonly="true" tabindex="-1"
					maxlength="20" name="scoringControlRecordCO.statusDesc" />
				<psj:a button="true" buttonIcon="ui-icon-triangle-2-s"
					onclick="scoringControlRecord_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a></td>
		</ps:if>
	</tr>
	
	<tr>
	<td class="fldLabelView" align="left" colspan="2">
		<ps:label key="profiling_based_on_key" for="scoringCalcCriteria_${_pageRef}"
							id="lbl_criteriaUsage_${_pageRef}" />
	</td>
	<td colspan="3">
		<ps:select id="scoringCalcCriteria_${_pageRef}" list="scoringCalcCriteriaList"
						listKey="code" listValue="descValue" tabindex="1"
						name="scoringControlRecordCO.amlCifControlScoreVO.SCORING_CALC_CRITERIA_LIST">
		</ps:select>
	</td>
	</tr>
	<tr>
	<td align="left" colspan="3">
		<ps:checkbox name="scoringControlRecordCO.amlCifControlScoreVO.RETAIN_HIGHEST_SCORE_YN"
		key="retain_highest_score_key" id="retain_highest_score_${_pageRef}" tabindex="2"
			cssClass="ui-widget-content" />
	</td>
	</tr>
</table>
<%@include file="ScoringControlRecordDetails.jsp"%>

<ptt:toolBar id="scoringControlRecordMaintToolBar_${_pageRef}" hideInAlert="true">
			
		<ps:if test='_dualParam == "false"'>
			<ps:if test='scoringControlRecordCO.amlCifControlScoreVO.STATUS == null'>
				<psj:submit button="true" 
				onclick="saveUpScoringControlRecord('save')" tabindex="19"
				 freezeOnSubmit="true"
				buttonIcon="ui-icon-disk" id="scoringControlRecordMaint_save_${_pageRef}"
				progRef="CSC002MT">
				<ps:label key="save_key" />
				</psj:submit>
			</ps:if>
			<ps:else>
				<psj:submit button="true" 
				onclick="saveUpScoringControlRecord('update')" tabindex="19"
				 freezeOnSubmit="true"
				buttonIcon="ui-icon-disk" id="scoringControlRecordMaint_save_${_pageRef}"
				progRef="CSC002MT">
				<ps:label key="save_key" />
				</psj:submit>
			</ps:else>	
		</ps:if>
		<ps:else>
			<ps:if
				test='%{iv_crud=="R" &&  ((scoringControlRecordCO.statusDesc =="") ||(scoringControlRecordCO.statusDesc  == null))}'>
				<psj:submit button="true" 
					onclick="saveUpScoringControlRecord('save')" tabindex="19"
					 freezeOnSubmit="true"
					buttonIcon="ui-icon-disk" id="scoringControlRecordMaint_save_${_pageRef}"
					progRef="CSC002MT">
					<ps:label key="save_key" />
				</psj:submit>
			</ps:if>
			<ps:if
				test='%{iv_crud=="R" && (scoringControlRecordCO.amlCifControlScoreVO.STATUS =="A") }'>
				<psj:submit id="scoringControlRecord_Update_btn_${_pageRef}" button="true"
					buttonIcon="ui-icon-disk" tabindex="29"
					onclick="saveUpScoringControlRecord('update')"
					freezeOnSubmit="true"
					progRef="CSC002MT">
					<ps:label for="scoringControlRecord_Update_btn_${_pageRef}" key="update_key" />
				</psj:submit>
			</ps:if>
			
			<ps:if
				test='%{(iv_crud=="P") && (scoringControlRecordCO.amlCifControlScoreVO.STATUS=="A")}'>
				<td><psj:submit id="approve_btn_${_pageRef}" button="true"
						freezeOnSubmit="true" onclick="saveUpScoringControlRecord('approve')"
						progRef="CSC002P" buttonIcon="ui-icon-circle-check">
						<ps:label key="Authorize_key" for="approve_btn_${_pageRef}" />
					</psj:submit></td>
			</ps:if>
			<ps:if
				test='%{(iv_crud == "U") && (scoringControlRecordCO.amlCifControlScoreVO.STATUS=="P")}'>
				<psj:submit id="update_after_approve_btn_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveUpScoringControlRecord('updateAfterApprove')"
					progRef="CSC002U" buttonIcon="ui-icon-circle-check">
					<ps:label key="Update_After_Authorize_key"
						for="update_after_approve_btn_${_pageRef}" />
				</psj:submit>
			</ps:if>
			
			<ps:if
					test='%{iv_crud == "N" && (scoringControlRecordCO.amlCifControlScoreVO.STATUS=="A")}'>
					<psj:submit id="cancel_btn_${_pageRef}" button="true"
						freezeOnSubmit="true"
						onclick="saveUpScoringControlRecord('cancel')" progRef="CSC002N"
						buttonIcon="ui-icon-seek-prev">
						<ps:label key="Cancel_key" for="cancel_btn_${_pageRef}" />
					</psj:submit>
			</ps:if>
		</ps:else>	
	</ptt:toolBar>

 
</ps:form>
</div>
<script type="text/javascript">

$(document).ready(function() {																						
							$.struts2_jquery.require("ScoringControlRecordMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/core/scoringcontrolrecord/");
							$("#scoringControlRecordMaintFormId_"+_pageRef).processAfterValid("scoringControlRecordMaint_processSubmit",{});
						});
						
var Confirm_Delete_key = "<ps:text name='Confirm_Delete_Process_key'/>";
var Confirm_Delete_Process_key = "<ps:text name='Confirm_Delete_Process_key'/>";
var Confirm_Save_key = "<ps:text name='	Confirm_Save_msg_key' />";
var Confirm_Delete_Process_key = "<ps:text name='Confirm_Delete_Process_key' />";
var record_was_approved_Successfully_key = "<ps:text name='record_was_Approved_Successfully_key'/>";
var Confirm_Approve_Record_key = "<ps:text name='Confirm_Approve_Record_key'/>";
var cannot_Proceed_key = "${Cannot_Proceed_var}";
var record_saved_successfully_key = "${record_saved_Successfully_key}"; 
var To_Score_Cannot_Be_Greater_Than_From_Score_key= "<ps:text name='To_Score_Cannot_Be_Greater_Than_From_Score_key'/>";
var To_Score_Cannot_Be_Less_Than_Or_Equal_From_Score_key= "<ps:text name='to_score_cannot_be_less_than_eq_from_score_key'/>";
var To_Score_Cannot_Be_Empty_key = "<ps:text name='to_score_cannot_be_empty_key'/>";
var to_from_Score_Cannot_Be_Empty_key = "<ps:text name='to_from_score_cannot_be_empty_key'/>";
var Record_Was_Cancelled_Successfully = "<ps:text name='Record_Was_Cancelled_Successfully'/>";
var Confirm_Cancel_key = "<ps:text name='Confirm_Cancel_key'/>";


						
						
</script>