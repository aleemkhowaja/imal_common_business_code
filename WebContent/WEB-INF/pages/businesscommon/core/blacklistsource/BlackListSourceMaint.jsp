<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:form useHiddenProps="true"
	id="blackListSourceMaintFormId_${_pageRef}"
	namespace="/path/blackListSource">
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
	<ps:hidden id="saveUpdBlackListSource_${_pageRef}" name="actionType" />
	<ps:hidden id="date_updated_${_pageRef}"
		name="blackListSourceCO.blackSourceVO.DATE_UPDATED" />
	<ps:hidden id="status_${_pageRef}"
		name="blackListSourceCO.blackSourceVO.ENTITY_STATUS" />
	<ps:set name="Record_was_Deleted_Successfully_key"
		value="%{getEscText('Record_was_Deleted_Successfully_key')}" />

	
	<ps:set name="record_saved_Successfully_key"
		value="%{getEscText('Record_Saved_Successfully_key')}" />
	<ps:set name="record_was_Updated_Successfully_key"
		value="%{getEscText('Record_was_Updated_Successfully_key')}" />
	<ps:set name="error_msg_title" value="%{getEscText('error_title_key')}" />
	<ps:set name="success_title_key"
		value="%{getEscText('success_title_key')}" />
	<ps:hidden id="createdBy_${_pageRef}"
		name="blackListSourceCO.blackSourceVO.CREATED_BY" />
	<ps:hidden id="modifiedBy_${_pageRef}"
		name="blackListSourceCO.blackSourceVO.MODIFIED_BY" />
<ps:hidden id="dualParam_${_pageRef}"
		name="blackListSourceCO.dualParam" />
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<table width="100%">
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
					leadZeros="4" name="blackListSourceCO.blackSourceVO.CODE"
					mode="number" tabindex="1"
					dependencySrc="${pageContext.request.contextPath}/pathdesktop/BlackSourceDependencyAction_dependencyByBlackSourceCode"
					dependency="CODE_${_pageRef}:CODE"
					parameter="CODE:CODE_${_pageRef},isMainScreen:~CONST_1" /></td>
			<td></td>


			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="blackListSourceCO.CENTRAL_BANK"
					key="central_bank_key" id="centraloBank_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>
			
			<td class="fldLabelView" align="right"><ps:label
					key="status_key" for="status_desc_${_pageRef}"
					id="lbl_status_${_pageRef}" /></td>

			<td class="fldDataEdit"><ps:textfield size="20"
					id="status_desc_${_pageRef}" readonly="true" tabindex="-1"
					maxlength="20" name="blackListSourceCO.statusDesc" />
				<psj:a button="true" buttonIcon="ui-icon-triangle-2-s" id="status_button_${_pageRef}"
					onclick="blackListSource_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a></td>




		</tr>
		<tr>
		
		
		<td class="fldLabelView">
					<ps:label key="CIF_key" id="lbl_Cif_${_pageRef}"
						for="lookuptxt_CIF_${_pageRef}" />
				</td>
				<td colspan="1">										
					<psj:livesearch
						actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructMemoDtlsCifLookup"
						id="CIF_NO_${_pageRef}" tabindex="11"
						name="blackListSourceCO.blackSourceVO.CIF_NO" size="10"
						searchElement="CIF_NO" autoSearch="true"
						resultList="CIF_NO:lookuptxt_CIF_NO_${_pageRef}"
						mode="number"
						maxlength="8" leadZeros="8"
						dependencySrc="${pageContext.request.contextPath}/path/blackListSource/BlackListSourceMaintAction_dependencyByCifCode"
						dependency="lookuptxt_CIF_NO_${_pageRef}:blackListSourceCO.blackSourceVO.CIF_NO,
						BRIEF_DESC_ENG_${_pageRef}:blackListSourceCO.blackSourceVO.BRIEF_DESC_ENG,
						LONG_DESC_ENG_${_pageRef}:blackListSourceCO.blackSourceVO.LONG_DESC_ENG,
						BRIEF_DESC_ARAB_${_pageRef}:blackListSourceCO.blackSourceVO.BRIEF_DESC_ARAB,
					    LONG_DESC_ARAB_${_pageRef}:blackListSourceCO.blackSourceVO.LONG_DESC_ARAB"
						parameter="blackListSourceCO.blackSourceVO.CIF_NO:lookuptxt_CIF_NO_${_pageRef},
						blackListSourceCO.blackSourceVO.BRIEF_DESC_ENG:BRIEF_DESC_ENG_${_pageRef},
						blackListSourceCO.blackSourceVO.LONG_DESC_ENG:LONG_DESC_ENG_${_pageRef},
						blackListSourceCO.blackSourceVO.BRIEF_DESC_ARAB:BRIEF_DESC_ARAB_${_pageRef},
						blackListSourceCO.blackSourceVO.LONG_DESC_ARAB:LONG_DESC_ARAB_${_pageRef}">
					</psj:livesearch>
				</td>
		</tr>

		<tr>
		
		
		
			<td class="fldLabelView" align="left" colspan="1"><ps:label
					key="brief_name_en_key" id="lbl_Brief_Name_${_pageRef}"
					for="BRIEF_DESC_ENG_${_pageRef}" /></td>

			<td class="fldDataEdit center" colspan="2"><ps:textfield
					id="BRIEF_DESC_ENG_${_pageRef}" tabindex="2"
					name="blackListSourceCO.blackSourceVO.BRIEF_DESC_ENG" mode="text"
					readonly="false" maxlength="20" /></td>

		</tr>

		<tr>
			<td class="fldLabelView" align="left" colspan="1"><ps:label
					key="Long_Name_key" id="lbl_long_name_eng_${_pageRef}"
					for="LONG_DESC_ENG_${_pageRef}" /></td>
			<td class="fldDataEdit center"  colspan="4"><ps:textfield
					id="LONG_DESC_ENG_${_pageRef}" tabindex="3"
					name="blackListSourceCO.blackSourceVO.LONG_DESC_ENG" mode="text"
					readonly="false" maxlength="40"  /></td>

		</tr>

		<tr>
			<td colspan="3"></td>

			<td class="fldDataEdit center" align="right" colspan="2"><ps:textfield
					id="BRIEF_DESC_ARAB_${_pageRef}" tabindex="4"
					name="blackListSourceCO.blackSourceVO.BRIEF_DESC_ARAB" mode="text"
					maxlength="20" cssStyle="direction:rtl" onlyArabic="false" readonly="false" /></td>
			<td class="fldLabelView" align="right"><ps:label
					key="brief_name_ar_key" id="lbl_Brief_Name_ar_${_pageRef}"
					for="BRIEF_DESC_ARAB_${_pageRef}" /></td>


		</tr>

		<tr>
			<td></td>
			<td class="fldDataEdit center" colspan="4" align="right"><ps:textfield
					id="LONG_DESC_ARAB_${_pageRef}"
					name="blackListSourceCO.blackSourceVO.LONG_DESC_ARAB" mode="text"
					maxlength="40" tabindex="5" cssStyle="direction:rtl"
					onlyArabic="false" readonly="false" /></td>
			<td class="fldLabelView" align="right"><ps:label
					key="Long_Description_arab_key" id="lbl_Long_Name_ar_${_pageRef}"
					for="LONG_DESC_ARAB_${_pageRef}" /></td>

		</tr>





	</table>
	<ptt:toolBar id="blackListSourceMaintToolBar_${_pageRef}"
		hideInAlert="true">
		<ps:if
			test='%{(iv_crud=="R" && ((blackListSourceCO.statusDesc =="") ||(blackListSourceCO.statusDesc == null)) && blackListSourceCO.dualParam==1 )||(iv_crud=="R" && blackListSourceCO.blackSourceVO.CODE==null && blackListSourceCO.dualParam==0)}'>
			<psj:submit id="blackListSourceMaint_save_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListSource('save')">
				<ps:label key="Save_key" for="blackListSourceMaint_save_${_pageRef}" />
			</psj:submit>
			
		</ps:if>


		<ps:if
			test='%{((iv_crud=="R") && (blackListSourceCO.blackSourceVO.ENTITY_STATUS == "A"))||((iv_crud=="R" && blackListSourceCO.blackSourceVO.CODE!=null && blackListSourceCO.dualParam==0))}'>
			<psj:submit id="blackListSourceMaint_save_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListSource('update')">
				<ps:label key="update_key"
					for="blackListSourceMaint_save_${_pageRef}" />
			</psj:submit>
			<ps:if test='%{XXXXXX!="false"}'>
				<psj:submit id="blackListSourceMaint_del_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveUpdBlackListSource('delete')">
					<ps:label key="Delete_key"
						for="blackListSourceMaint_del_${_pageRef}" />
				</psj:submit>
			</ps:if>
		</ps:if>
		
		<ps:if
			test='%{(iv_crud=="P") && (blackListSourceCO.blackSourceVO.ENTITY_STATUS=="A") }'>
			<td><psj:submit id="approve_btn_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveUpdBlackListSource('approve')"
					progRef="BL002P" buttonIcon="ui-icon-circle-check">
					<ps:label key="Authorize_key" for="approve_btn_${_pageRef}" />
				</psj:submit></td>
		</ps:if>
		<ps:if
			test='%{(iv_crud == "U") && (blackListSourceCO.blackSourceVO.ENTITY_STATUS=="P") }'>
			<psj:submit id="update_after_approve_btn_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveUpdBlackListSource('updateAfterApprove')"
				progRef="BL002U" buttonIcon="ui-icon-circle-check">
				<ps:label key="Update_After_Authorize_key"
					for="update_after_approve_btn_${_pageRef}" />
			</psj:submit>
		</ps:if>
		
		<ps:if
				test='%{iv_crud == "N" && (blackListSourceCO.blackSourceVO.ENTITY_STATUS=="A")}'>
				<psj:submit id="cancel_btn_${_pageRef}" button="true"
					freezeOnSubmit="true"
					onclick="saveUpdBlackListSource('cancel')" progRef="BL002N"
					buttonIcon="ui-icon-seek-prev">
					<ps:label key="Cancel_key" for="cancel_btn_${_pageRef}" />
				</psj:submit>
			</ps:if>
	</ptt:toolBar>
</ps:form>
<script type="text/javascript">
	$(document).ready(function()
	{
		$.struts2_jquery.require("BlackListSourceMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/blacklistsource/");
		$("#blackListSourceMaintFormId_" + _pageRef).processAfterValid("blackListSourceMaint_processSubmit", {});
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

	$.struts2_jquery.require("Smart.js", null, "${pageContext.request.contextPath}/common/js/smart/");

</script>