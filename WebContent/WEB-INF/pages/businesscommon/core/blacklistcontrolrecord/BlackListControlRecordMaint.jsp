<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<div id = "controlRecordMaintDivId_${_pageRef}">

<ps:form useHiddenProps="true" id="controlRecordMaintFormId_${_pageRef}"
	namespace="/path/controlRecord">
	<ps:hidden id="date_updated_${_pageRef}"
		name="controlRecordCO.cifControlVO.DATE_UPDATED" />
	<ps:hidden id="status_${_pageRef}"
		name="controlRecordCO.cifControlVO.ENTITY_STATUS" />
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
	<ps:hidden id="saveBlackListControlRecord_${_pageRef}" name="actionType" />
	<ps:hidden id="_newRecord_${_pageRef}" name="controlRecordCO.saveUpdateFlag" />
	<ps:hidden id="createdBy_${_pageRef}"
		name="controlRecordCO.cifControlVO.CREATED_BY" />
	<ps:hidden id="modifiedBy_${_pageRef}"
		name="controlRecordCO.cifControlVO.MODIFIED_BY" />
	<ps:hidden id="dualParam_${_pageRef}"
		name="controlRecordCO.dualParam" />
		

<ps:set name="record_saved_Successfully_key" value="%{getEscText('Record_Saved_Successfully_key')}"/>
<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

	<table width="100%" >
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
		
		
		<tr >
			<td colspan="15" class="fldLabelView" align="right"><ps:label
					key="status_key" for="status_desc_${_pageRef}"
					id="lbl_status_${_pageRef}" /></td>

			<td class="fldDataEdit"><ps:textfield size="20"
					id="status_desc_${_pageRef}" readonly="true" tabindex="-1"
					maxlength="20" name="controlRecordCO.statusDesc" />
				<psj:a button="true" buttonIcon="ui-icon-triangle-2-s" id="status_button_${_pageRef}"
					onclick="blackListControlRecord_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a>
				</td>
		</tr>

		<tr>
			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_BNAME"
					key="brief_name_key" id="briefName_${_pageRef}" tabindex="1"
						cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_MOTHER_LNAME"
					key="Mother_Last_Name_key" id="motherLastName_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_NATION"
					key="Nationality_key" id="nationality_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>


			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_BDATE"
					key="Date_of_Birth_Establishement_key" id="nationality_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>
			
			
			<td class="fldDataEdit center" colspan="5"><ps:select
					id="on_${_pageRef}" name="controlRecordCO.cifControlVO.AND_OR"
					tabindex="4" list="andOrDropDown" emptyOption="false"
					listKey="code" listValue="descValue" 
					dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByAndOr"
					dependency="criteriaMatch1_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC"
					parameter="controlRecordCO.controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC:criteriaMatch1_${_pageRef},
					controlRecordCO.APPLY_BLKLST_ON_WALKIN_CUST_YN:applyBlklist_${_pageRef},
					controlRecordCO.cifControlVO.AND_OR:on_${_pageRef}"/></td>

		</tr>

		<tr>
			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_LNAME"
					key="long_name_key" id="longName_${_pageRef}" tabindex="1"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_MOTHER_FNAME"
					key="Mother_First_Name_key" id="motherFirstName_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_REGION"
					key="Region_key" id="region_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>


			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_BPLACE"
					key="Birth_Place_key" id="birthPlace_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

		</tr>

		<tr>
			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_FST_NAME"
					key="First_Name_key" id="firstName_${_pageRef}" tabindex="1"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_THRD_NAME"
					key="Third_Name_eng_key" id="thirdName_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_COUNTRY"
					key="Country_key" id="country_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>


			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_IDNO"
					key="registration_no_key" id="regNo_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

		</tr>

		<tr>
			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_SEC_NAME"
					key="Second_Name_eng_key" id="secondName_${_pageRef}" tabindex="1"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_LAST_NAME"
					key="last_name_key" id="lastName_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>

			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_LEGAL"
					key="legal_status_key" id="legal_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>


			<td align="left" rowspan="1" valign="center" colspan="2" width="100%">
				<ps:checkbox name="controlRecordCO.BLCKL_REGNO"
					key="Register_No_key" id="registerNo_${_pageRef}"
					cssClass="ui-widget-content" />

			</td>


		</tr>

		<tr>

			<td class="fldLabelView"><ps:label key="name_matching_key"
					id="lbl_NAME_MATCHNG_key_${_pageRef}" for="NameMatch_${_pageRef}" />
			</td>

			<td class="fldDataEdit center" colspan="2" align="right"><ps:textfield
					id="NameMatch_${_pageRef}"
					name="controlRecordCO.cifControlVO.BLCKL_NAME_MATCH_PERC"  
					mode="number" maxlength="3" minValue="1" leadZeros="3" tabindex="5"
					cssStyle="direction:rtl" 
					dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByNameMatch"
					dependency="NameMatch_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_NAME_MATCH_PERC"
					parameter="controlRecordCO.cifControlVO.BLCKL_NAME_MATCH_PERC:NameMatch_${_pageRef}" /></td>

			<td class="fldLabelView"><ps:label key="criteria_matching_key"
					id="lbl_CRITERIA_MATCHNG_key_${_pageRef}"
					for="criteriaMatch_${_pageRef}" /></td>

			<td class="fldDataEdit center" colspan="2" align="right"><ps:textfield
					id="criteriaMatch_${_pageRef}"
					name="controlRecordCO.cifControlVO.BLCKL_CRITERIA_MATCH_PERC"
					mode="number" maxlength="3" minValue="1" leadZeros="3" tabindex="5"
					cssStyle="direction:rtl"
					dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByCriteriaMatch"
					dependency="criteriaMatch_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_CRITERIA_MATCH_PERC"
					parameter="controlRecordCO.cifControlVO.BLCKL_CRITERIA_MATCH_PERC:criteriaMatch_${_pageRef}"/></td>



		</tr>

		<tr>

			<td align="left" rowspan="1" valign="center" colspan="4" width="100%">
				<ps:checkbox name="controlRecordCO.APPLY_BLKLST_ON_WALKIN_CUST_YN"
						key="apply_blklist_key" id="applyBlklist_${_pageRef}"
						cssClass="ui-widget-content"
						parameter="controlRecordCO.cifControlVO.BLCKL_WALKIN_NAME_MATCH_PERC:NameMatch1_${_pageRef},controlRecordCO.APPLY_BLKLST_ON_WALKIN_CUST_YN:applyBlklist_${_pageRef},controlRecordCO.cifControlVO.AND_OR:on_${_pageRef},controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC:criteriaMatch1_${_pageRef}"
						dependency="NameMatch1_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_WALKIN_NAME_MATCH_PERC,criteriaMatch1_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC"
						dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByApplyBlackList" />

				</td>
		</tr>
		
		<tr>

			<td class="fldLabelView"><ps:label key="name_matching1_key"
					id="lbl_NAME_MATCHNG_1_key_${_pageRef}" for="NameMatch1_${_pageRef}" 
					/>
			</td>

			<td class="fldDataEdit center" colspan="2" align="right"><ps:textfield
					id="NameMatch1_${_pageRef}"
					name="controlRecordCO.cifControlVO.BLCKL_WALKIN_NAME_MATCH_PERC"  
					mode="number" maxlength="3" minValue="1" leadZeros="3" tabindex="5"
					cssStyle="direction:rtl" 
					dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByNameMatch1"
					dependency="NameMatch1_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_WALKIN_NAME_MATCH_PERC"
					parameter="controlRecordCO.cifControlVO.BLCKL_WALKIN_NAME_MATCH_PERC:NameMatch1_${_pageRef}" /></td>

			<td class="fldLabelView"><ps:label key="criteria_matching1_key"
					id="lbl_CRITERIA_MATCHNG_key1_${_pageRef}"
					for="criteriaMatch1_${_pageRef}" /></td>

			<td class="fldDataEdit center" colspan="2" align="right"><ps:textfield
					id="criteriaMatch1_${_pageRef}"
					name="controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC"
					mode="number" maxlength="3" minValue="1" leadZeros="3" tabindex="5"
					cssStyle="direction:rtl"
					dependencySrc="${pageContext.request.contextPath}/path/controlRecord/BlackListControlRecordMaintAction_dependencyByCriteriaMatch1"
					dependency="criteriaMatch1_${_pageRef}:controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC"
					parameter="controlRecordCO.cifControlVO.BLCKL_WALKIN_CRIT_MATCH_PERC:criteriaMatch1_${_pageRef}"/></td>



		</tr>
		

	</table>
	
	
	
	<ptt:toolBar id="controlRecordMaintToolBar_${_pageRef}"
		hideInAlert="true">
		
		
		<ps:if
			test='%{(iv_crud=="R" &&  ((controlRecordCO.statusDesc =="") ||(controlRecordCO.statusDesc  == null)) && controlRecordCO.dualParam == 1) || (iv_crud=="R" &&  controlRecordCO.dualParam == 0)}'>
			<psj:submit button="true" 
				onclick="saveBlackListControlRecord('save')" tabindex="19"
				 freezeOnSubmit="true"
				buttonIcon="ui-icon-disk" id="scoringControlRecordMaint_save_${_pageRef}"
				progRef="BL004MT">
				<ps:label key="save_key" />
			</psj:submit>
		</ps:if>
		
		<ps:if
			test='%{(iv_crud=="R" && (controlRecordCO.cifControlVO.ENTITY_STATUS =="A") && controlRecordCO.dualParam ==1)}'>
			<psj:submit id="scoringControlRecord_Update_btn_${_pageRef}" button="true"
				buttonIcon="ui-icon-disk" tabindex="29"
				onclick="saveBlackListControlRecord('update')"
				freezeOnSubmit="true"
				progRef="CSC002MT">
				<ps:label for="scoringControlRecord_Update_btn_${_pageRef}" key="update_key" />
			</psj:submit>
		</ps:if>
		
		<ps:if
			test='%{(iv_crud=="P") && (controlRecordCO.cifControlVO.ENTITY_STATUS=="A")}'>
			<td><psj:submit id="approve_btn_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="saveBlackListControlRecord('approve')"
					progRef="BL004P" buttonIcon="ui-icon-circle-check">
					<ps:label key="Authorize_key" for="approve_btn_${_pageRef}" />
				</psj:submit></td>
		</ps:if>
		<ps:if
			test='%{(iv_crud == "U") && (controlRecordCO.cifControlVO.ENTITY_STATUS=="P")}'>
			<psj:submit id="update_after_approve_btn_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="saveBlackListControlRecord('updateAfterApprove')"
				progRef="BL004U" buttonIcon="ui-icon-circle-check">
				<ps:label key="Update_After_Authorize_key"
					for="update_after_approve_btn_${_pageRef}" />
			</psj:submit>
		</ps:if>
		
		<ps:if
				test='%{iv_crud == "N" && (controlRecordCO.cifControlVO.ENTITY_STATUS=="A")}'>
				<psj:submit id="cancel_btn_${_pageRef}" button="true"
					freezeOnSubmit="true"
					onclick="saveBlackListControlRecord('cancel')" progRef="BL004N"
					buttonIcon="ui-icon-seek-prev">
					<ps:label key="Cancel_key" for="cancel_btn_${_pageRef}" />
				</psj:submit>
			</ps:if>

	</ptt:toolBar>
</ps:form>
</div>
<script type="text/javascript">
	//$.struts2_jquery.require("ControlRecordMaint.js", null, jQuery.contextPath + "/path/js/controlrecord/");

	$(document).ready(function()
	{
		$.struts2_jquery.require("BlackListControlRecordMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/blacklistcontrolrecord/");
		$("#controlRecordMaintFormId_" + _pageRef).processAfterValid("blackListControlRecordMaint_processSubmit", {});
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
	var Confirm_Cancel_key = "<ps:text name='Confirm_Cancel_key'/>";
	$.struts2_jquery.require("CommonFuncExtension.js", null, "${pageContext.request.contextPath}/common/jquery/");
	$.struts2_jquery.require("Smart.js", null, "${pageContext.request.contextPath}/common/js/smart/");


</script>