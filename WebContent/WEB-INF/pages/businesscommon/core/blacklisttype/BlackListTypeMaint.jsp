<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:form useHiddenProps="true" id="blackListTypeMaintFormId_${_pageRef}"
	namespace="/path/blackListType">
	
	
<ps:hidden id="saveUpdBlackListType_${_pageRef}" name="actionType" />
<ps:hidden id="date_updated_${_pageRef}"
		name="blackListTypeCO.mosBlackListTypeVO.DATE_UPDATED" />
<ps:hidden id="status_${_pageRef}"
		name="blackListTypeCO.mosBlackListTypeVO.ENTITY_STATUS" />
<ps:set name="Record_was_Deleted_Successfully_key"
		value="%{getEscText('Record_was_Deleted_Successfully_key')}" />

	<ps:hidden id="createdBy_${_pageRef}"
		name="blackListTypeCO.mosBlackListTypeVO.CREATED_BY" />
	<ps:hidden id="modifiedBy_${_pageRef}"
		name="blackListTypeCO.mosBlackListTypeVO.MODIFIED_BY" />

	<ps:set name="record_saved_Successfully_key"
		value="%{getEscText('Record_Saved_Successfully_key')}" />
	<ps:set name="record_was_Updated_Successfully_key"
		value="%{getEscText('Record_was_Updated_Successfully_key')}" />
	<ps:set name="error_msg_title" value="%{getEscText('error_title_key')}" />
	<ps:set name="success_title_key"
		value="%{getEscText('success_title_key')}" />
<ps:hidden id="dualParam_${_pageRef}"
		name="blackListTypeCO.dualParam" />
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
	<table width="100%" >
		<tr>
			<td width="7%"></td>
			<td width="10%"></td>
			<td width="22%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="7%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="30%"></td>
			<td width="8%"></td>
		</tr>

		<tr>
			<td class="fldLabelView" align="left"><ps:label key="CODE_key"
					id="lbl_Code_${_pageRef}" for="CODE_${_pageRef}" /></td>


			<td class="fldDataEdit center" colspan="1"><ps:textfield
					id="CODE_${_pageRef}" size="10" maxlength="4" minValue="0"
					leadZeros="4" name="blackListTypeCO.mosBlackListTypeVO.CODE"
					mode="number" tabindex="1"
					dependencySrc="${pageContext.request.contextPath}/path/blackListType/BlackListTypeMaintAction_dependencyByCode"
					dependency="CODE_${_pageRef}:blackListTypeCO.mosBlackListTypeVO.CODE"
					parameter="blackListTypeCO.mosBlackListTypeVO.CODE:CODE_${_pageRef}" /></td>
			<td></td>

		<td colspan="10" class="fldLabelView" align="right"><ps:label
					key="status_key" for="status_desc_${_pageRef}"
					id="lbl_status_${_pageRef}" /></td>

			<td class="fldDataEdit"><ps:textfield size="20"
					id="status_desc_${_pageRef}" readonly="true" tabindex="-1"
					maxlength="20" name="blackListTypeCO.statusDesc" />
				<psj:a button="true" buttonIcon="ui-icon-triangle-2-s" id="status_button_${_pageRef}"
					onclick="blackListType_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a></td>

		</tr>


		<tr>



			<td class="fldLabelView" align="left" colspan="1"><ps:label
					key="brief_name_en_key" id="lbl_Brief_Name_${_pageRef}"
					for="BRIEF_NAME_ENG_${_pageRef}" /></td>

			<td class="fldDataEdit center" colspan="2"><ps:textfield
					id="BRIEF_NAME_ENG_${_pageRef}" tabindex="2"
					name="blackListTypeCO.mosBlackListTypeVO.BRIEF_NAME_ENG"
					mode="text" readonly="false" maxlength="20" /></td>

		</tr>

		<tr>
			<td class="fldLabelView" align="left" colspan="1"><ps:label
					key="LONG_NAME_ENG" id="lbl_long_name_eng_${_pageRef}"
					for="LONG_NAME_ENG${_pageRef}" /></td>
			<td class="fldDataEdit center" colspan="4"><ps:textfield
					id="LONG_NAME_ENG${_pageRef}" tabindex="3"
					name="blackListTypeCO.mosBlackListTypeVO.LONG_NAME_ENG" mode="text"
					readonly="false" maxlength="40" /></td>

		</tr>

		<tr>
			<td colspan="3"></td>

			<td class="fldDataEdit center" align="right" colspan="2"><ps:textfield
					id="BRIEF_NAME_ARAB${_pageRef}" tabindex="4"
					name="blackListTypeCO.mosBlackListTypeVO.BRIEF_NAME_ARAB"
					mode="text" maxlength="20" cssStyle="direction:rtl"
					onlyArabic="false" readonly="false" /></td>
			<td class="fldLabelView" align="right"><ps:label
					key="brief_name_ar_key" id="lbl_Brief_Name_ar_${_pageRef}"
					for="BRIEF_NAME_ARAB${_pageRef}" /></td>


		</tr>

		<tr>
			<td></td>
			<td class="fldDataEdit center" colspan="4" align="right"><ps:textfield
					id="LONG_NAME_ARAB${_pageRef}"
					name="blackListTypeCO.mosBlackListTypeVO.LONG_NAME_ARAB"
					mode="text" maxlength="40" tabindex="5" cssStyle="direction:rtl"
					onlyArabic="false"  readonly="false"/></td>
			<td class="fldLabelView" align="right"><ps:label
					key="Long_Description_arab_key" id="lbl_Long_Name_ar_${_pageRef}"
					for="LONG_NAME_ARAB${_pageRef}" /></td>

		</tr>
		<tr>
			<td class="fldLabelView"><ps:label key="revision_basis_key"
					id="lbl_revision_basis_${_pageRef}" /></td>
			<td class="fldDataEdit center" colspan="2"><ps:select
					id="revision_basis_${_pageRef}"
					name="blackListTypeCO.mosBlackListTypeVO.REVISION_BASIS"
					tabindex="4" list="revisionBasisDropDown" emptyOption="false"
					listKey="code" listValue="descValue"
					dependencySrc="${pageContext.request.contextPath}/path/blackListType/BlackListTypeMaintAction_dependencyByRevisionBasis"
					dependency="revision_basis_${_pageRef}:blackListTypeCO.mosBlackListTypeVO.REVISION_BASIS,
					revision_period_${_pageRef}:blackListTypeCO.mosBlackListTypeVO.REVISION_PERIOD"
					parameter="blackListTypeCO.mosBlackListTypeVO.REVISION_BASIS:revision_basis_${_pageRef},
					blackListTypeCO.mosBlackListTypeVO.REVISION_PERIOD:revision_period_${_pageRef}" /></td>
			
			<td class="fldLabelView" align="left"><ps:label
					key="revision_period_key" id="lbl_revision_period_${_pageRef}"
					for="revision_period_${_pageRef}" /></td>
			<td class="fldDataEdit center" ><ps:textfield
					id="revision_period_${_pageRef}" size="10" maxlength="6"
					minValue="1" leadZeros="6"
					name="blackListTypeCO.mosBlackListTypeVO.REVISION_PERIOD"
					mode="number" tabindex="10" 
					/></td>
			</td>
			<td class="fldLabelView" align="left"><ps:label key="days_key"
					id="lbl_revision_days${_pageRef}" /></td>

		</tr>

	</table>
	<ptt:toolBar id="blackListTypeMaintToolBar_${_pageRef}"
		hideInAlert="true">
		<ps:if
			test='%{(iv_crud=="R" && ((blackListTypeCO.statusDesc =="") ||(blackListTypeCO.statusDesc == null)) && blackListTypeCO.dualParam==1) || (blackListTypeCO.dualParam==0 && iv_crud=="R" && blackListTypeCO.mosBlackListTypeVO.CODE==null)}'>
			<psj:submit id="blackListSourceMaint_save_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListType('save')">
				<ps:label key="Save_key" for="blackListSourceMaint_save_${_pageRef}" />
			</psj:submit>
			
		</ps:if>


		<ps:if
			test='%{((iv_crud=="R") && (blackListTypeCO.mosBlackListTypeVO.ENTITY_STATUS == "A"))|| (blackListTypeCO.dualParam==0 && iv_crud=="R" && blackListTypeCO.mosBlackListTypeVO.CODE!=null)}'>
			<psj:submit id="blackListSourceMaint_save_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListType('update')">
				<ps:label key="update_key"
					for="blackListSourceMaint_save_${_pageRef}" />
			</psj:submit>
			<ps:if test='%{XXXXXX!="false"}'>
				<psj:submit id="blackListSourceMaint_del_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveUpdBlackListType('delete')">
					<ps:label key="Delete_key"
						for="blackListSourceMaint_del_${_pageRef}" />
				</psj:submit>
			</ps:if>
		</ps:if>
		
		<ps:if
			test='%{(iv_crud=="P") && (blackListTypeCO.mosBlackListTypeVO.ENTITY_STATUS=="A") }'>
			<td><psj:submit id="approve_btn_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveUpdBlackListType('approve')"
					progRef="BL003P" buttonIcon="ui-icon-circle-check">
					<ps:label key="Authorize_key" for="approve_btn_${_pageRef}" />
				</psj:submit></td>
		</ps:if>
		<ps:if
			test='%{(iv_crud == "U") && (blackListTypeCO.mosBlackListTypeVO.ENTITY_STATUS=="P") }'>
			<psj:submit id="update_after_approve_btn_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListType('updateAfterApprove')"
				progRef="BL003U" buttonIcon="ui-icon-circle-check">
				<ps:label key="Update_After_Authorize_key"
					for="update_after_approve_btn_${_pageRef}" />
			</psj:submit>
		</ps:if>
		
		<ps:if
				test='%{iv_crud == "N" && (blackListTypeCO.mosBlackListTypeVO.ENTITY_STATUS=="A")}'>
				<psj:submit id="cancel_btn_${_pageRef}" button="true"
					freezeOnSubmit="true"
					onclick="saveUpdBlackListType('cancel')" progRef="BL003N"
					buttonIcon="ui-icon-seek-prev">
					<ps:label key="Cancel_key" for="cancel_btn_${_pageRef}" />
				</psj:submit>
			</ps:if>
		
		
	</ptt:toolBar>
</ps:form>
<script type="text/javascript">
	$(document).ready(function()
	{
		$.struts2_jquery.require("BlackListTypeMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/blacklisttype/");
		$("#blackListTypeMaintFormId_" + _pageRef).processAfterValid("blackListTypeMaint_processSubmit", {});
	});
	var Confirm_Delete_key = "<ps:text name='Confirm_Delete_Process_key'/>";
	var Confirm_Delete_Process_key = "<ps:text name='Confirm_Delete_Process_key'/>";
	var Confirm_Save_key = "<ps:text name='Confirm_Save_msg_key' />";
	var Confirm_Delete_Process_key = "<ps:text name='Confirm_Delete_Process_key' />";
	var record_was_approved_Successfully_key = "<ps:text name='record_was_Approved_Successfully_key'/>";
	var Confirm_Approve_Record_key = "<ps:text name='Confirm_Approve_Record_key'/>";
	var cannot_Proceed_key = "${Cannot_Proceed_var}";
	var record_saved_successfully_key = "${record_saved_Successfully_key}"; 
	var To_Score_Cannot_Be_Greater_Than_From_Score_key= "<ps:text name='To_Score_Cannot_Be_Greater_Than_From_Score_key'/>";
	var Record_Was_Cancelled_Successfully = "<ps:text name='Record_Was_Cancelled_Successfully'/>";
	var Record_was_Deleted_Successfully_key = "${Record_was_Deleted_Successfully_key}";

	var Confirm_Cancel_key = "<ps:text name='Confirm_Cancel_key'/>";$.struts2_jquery.require("CommonFuncExtension.js", null, "${pageContext.request.contextPath}/common/jquery/");
	$.struts2_jquery.require("CommonFuncExtension.js", null, "${pageContext.request.contextPath}/common/jquery/");
	$.struts2_jquery.require("Smart.js", null, "${pageContext.request.contextPath}/common/js/smart/");

</script>