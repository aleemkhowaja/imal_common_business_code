<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<ps:form useHiddenProps="true"
	id="custSegmentationMaintFormId_${_pageRef}"
	namespace="/path/segmentation">

	<ps:hidden id="custSegmentationDetailList_Id_gridUpdate_${_pageRef}"
		name="custSegmentationDetailList_Id_gridUpdate" />
	<ps:hidden
		id="custSegmentationDetailList_Id_gridAllRecords_${_pageRef}"
		name="custSegmentationDetailList_Id_gridAllRecords" />

	<ps:hidden id="methodName_${_pageRef}" />
	<ps:hidden name="iv_crud" id="iv_crud_${_pageRef}" />
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
	<ps:hidden id="_newRecord_${_pageRef}" name="_newRecord" />
	<ps:hidden id="dateUpdated_${_pageRef}"
		name="custSegmentationCO.ctsSegmentVO.DATE_UPDATED" />
	<ps:hidden id="excludeCifGridUpdates_${_pageRef}"
		name="custSegmentationCO.excludeCifGridUpdates"></ps:hidden>
	<ps:hidden id="excludeCifGridRowId_${_pageRef}" />
	<ps:hidden id="criteriaParamEntityType_${_pageRef}" />
	<ps:hidden id="paramIsOpen_${_pageRef}"
		name="custSegmentationCO.paramIsOpen" />

	<ps:hidden id="isSegmentationScore_${_pageRef}"
		name="custSegmentationCO.isSegmentationScore" />


	<ps:hidden id="statusId_${_pageRef}"
		name="custSegmentationCO.ctsSegmentVO.STATUS" />
	<!-- added by nour for #864398 -->
	<ps:hidden id="record_was_Suspended_Successfully_key_id"
		value="%{getText('Record_was_Suspended_Successfully_key')}" />
		
	<ps:hidden id="record_was_approve_suspended_sucessfully_key_id"
		value="%{getText('record_was_approve_suspended_sucessfully_key')}" />

	<ps:hidden id="Record_was_reactivated_successfully_key_id"
		value="%{getText('Record_was_reactivated_successfully_key')}" />

	<ps:hidden id="Record_was_approve_reactivated_successfully_key_id"
		value="%{getText('Record_was_approve_reactivated_successfully_key')}" />
	
	<ps:hidden id="_rowId" name ="custSegmentationSC.rowId"/>
	<ps:hidden id="createdBy_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.CREATED_BY"/>
	<ps:hidden id="modifiedDate_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.DATE_CREATED"/>
	<ps:hidden id="modifiedBy_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.MODIFIED_BY"/>
	<ps:hidden id="oldStatus_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.OLD_STATUS"/>
	<ps:hidden id="approvedBy_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.APPROVED_BY"/>
	<ps:hidden id="approvedDate_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.DATE_APPROVED"/>
		
	
	<!-- end nour -->
	<div id="excludeCifDiv_${_pageRef}"></div>
	<div id="cifTrialSegmentationPopupDiv_${_pageRef}"></div>

	<br />
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

			<td class="fldLabelView" align="left" colspan="2"><ps:label
					key="Code_key" id="lbl_code_${_pageRef}" for="code_${_pageRef}" /></td>


			<td class="fldDataEdit center" colspan="2"><ps:textfield
					id="code_${_pageRef}"
					name="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" mode="number"
					nbFormat="####" maxlength="4" tabindex="1"
					cssClass="ui-widget-content textCompSize ui-corner-all"
					parameter="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE:code_${_pageRef},_pageRef:_pageRef"
					dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyBySegmentCode"
					dependency="code_${_pageRef}:custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" /></td>

			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="fldLabelView" align="right" colspan="1"><ps:label
					key="current_status_key" for="status_${_pageRef}"
					id="lbl_status_${_pageRef}" /></td>

			<td class="fldDataEdit" colspan="2"><ps:textfield size="20"
					id="status_${_pageRef}" readonly="true" tabindex="-1"
					maxlength="20" name="custSegmentationCO.statusdesc" /> <psj:a
					button="true" buttonIcon="ui-icon-triangle-2-s"
					onclick="custSegmentation_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a></td>
			<td></td>

		</tr>

		<ps:if test='session.sesVO.currentAppName != "AML"'>
			<ps:if
				test='%{iv_crud=="S" && custSegmentationCO.ctsSegmentVO.STATUS == "P"}'>
				<tr>
					<td colspan="19" style="border-bottom: 0.5px #dddddd solid;">
						&nbsp;</td>
				</tr>
				<tr>
					<td colspan="19">&nbsp;</td>
				</tr>

			</ps:if>

		</ps:if>

		<ps:if
			test='%{iv_crud=="R" && custSegmentationCO.ctsSegmentVO.STATUS == "P"}'>
			<tr>
				<td colspan="19" style="border-bottom: 0.5px #dddddd solid;">
					&nbsp;</td>
			</tr>
			<tr>
				<td colspan="19">&nbsp;</td>
			</tr>

		</ps:if>
		<tr>

			<td class="fldLabelView" align="left" colspan="2"><ps:if
					test='custSegmentationCO.isSegmentationScore!="BR"'>
					<ps:label key="Description_key"
						id="lbl_segment_Description_${_pageRef}"
						for="segmentDesc_${_pageRef}" />
				</ps:if> <ps:if test='custSegmentationCO.isSegmentationScore=="BR"'>
					<ps:label key="brief_desc_key"
						id="lbl_segment_Description_${_pageRef}"
						for="segmentDesc_${_pageRef}" />
				</ps:if></td>
			<td class="fldDataEdit center" colspan="4"><ps:textfield
					id="segmentDesc_${_pageRef}" tabindex="2"
					name="custSegmentationCO.ctsSegmentVO.SEGMENT_DESC" mode="text"
					readonly="false" maxlength="20" /></td>
			<ps:if test='session.sesVO.currentAppName != "AML"'>
				<tr>
					<td><ps:label key="app_name_key" id="lbl_APP_NAME_${_pageRef}"
							for="APP_NAME_${_pageRef}" /></td>
					<td><psj:livesearch id="APP_NAME_${_pageRef}"
							relatedDescElt="theme_appDesc"
							cssStyle="text-transform:uppercase; float:left;" size="8"
							name="custSegmentationCO.ctsSegmentVO.APP_NAME"
							paramList="webAppsOnly:labeling_web_apps_only_filter"
							actionName="${pageContext.request.contextPath}/pathdesktop/ApplicationsLookup_constructLookup"
							resultList="APP_NAME:APP_NAME_${_pageRef}"
							searchElement="APP_NAME" autoSearch="false" maxlength="4"
							dependencySrc="${pageContext.request.contextPath}/pathdesktop/ApplicationDependencyAction_applicationDepend"
							parameter="appVO.APP_NAME:lookuptxt_APP_NAME_${_pageRef}"
							dependency="lookuptxt_APP_NAME_${_pageRef}:appVO.APP_NAME,appDesc:appVO.APP_DESC" />
					</td>
					<ps:textfield id="appDesc${_pageRef}" name="appDesc"
						readonly="true"></ps:textfield>

				</tr>
			</ps:if>
			<ps:if
				test='custSegmentationCO.isSegmentationScore!="SC" && custSegmentationCO.isSegmentationScore!="BR"'>

				<td colspan="4" align="right"><ps:label key="group_code_key"
						id="lbl_group_code_${_pageRef}"
						for="lookuptxt_group_code_${_pageRef}" align="left" /></td>

				<td colspan="3" align="middle"><psj:livesearch
						id="group_code_${_pageRef}"
						name="custSegmentationCO.ctsSegmentVO.GROUP_CODE" mode="number"
						required="true"
						actionName="${pageContext.request.contextPath}/pathdesktop/SegmentGroupingCodeLookupAction_constructSegmentGroupingCodeLookup"
						searchElement=""
						resultList="GROUP_CODE:lookuptxt_group_code_${_pageRef}"
						parameter="custSegmentationSC.groupCode:lookuptxt_group_code_${_pageRef}"
						dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByGroupCode"
						dependency="lookuptxt_group_code_${_pageRef}:custSegmentationSC.groupCode,groupDesc_${_pageRef}:custSegmentationSC.groupDesc"></psj:livesearch>
				</td>

				<ps:textfield id="groupDesc_${_pageRef}"
					name="custSegmentationCO.groupDesc" readonly="true"></ps:textfield>
			</ps:if>

		</tr>
		
		<ps:if test='session.sesVO.currentAppName == "AML" && custSegmentationCO.isSegmentationScore=="SC"'>
			<tr>
				<td align="left" colspan="8">
					<ps:checkbox name="custSegmentationCO.ctsSegmentVO.MAIN_SCORE_YN"
					key="main_score_key" id="main_score_${_pageRef}" tabindex="3"
						cssClass="ui-widget-content" />
				</td>
			</tr>
		</ps:if>

		<tr>
			<ps:if test='custSegmentationCO.isSegmentationScore=="BR"'>
				<td class="fldLabelView" align="left" colspan="2"><ps:label
						key="Long_Description_key"
						id="lbl_segment_Long_Description_${_pageRef}"
						for="longSegmentDesc_${_pageRef}" /></td>
				<td class="fldDataEdit center" colspan="8"><ps:textfield
						id="LONG_DESC_ENG_${_pageRef}" tabindex="3"
						name="custSegmentationCO.ctsSegmentVO.LONG_DESC_ENG" mode="text"
						readonly="false" maxlength="40" /></td>
			</ps:if>



		</tr>


		<tr>
	
			<ps:if test='custSegmentationCO.isSegmentationScore=="BR"'>
					<td colspan="1" class="fldLabelView" align="right"><ps:label 
						key="Suspend_Reason_key" 
 						for="suspend_reason_${_pageRef}"></ps:label></td> 
 				<td>
 				</td>
 						
				<td class="fldDataEdit  right" colspan="8"><ps:textfield id="suspend_reason_${_pageRef}"
					name="custSegmentationCO.ctsSegmentVO.SUSPEND_REASON_REF"
					mode="text" readonly="false" maxlength="50"/></td>
			</ps:if>
		</tr>
		<tr>
			<ps:if
				test='session.sesVO.currentAppName == "AML" && custSegmentationCO.isSegmentationScore=="BR"'>
				<td class="fldLabelView"><ps:label key="periodicity_key"
						id="lbl_Periodicity_${_pageRef}" /></td>
				<td></td>
				<td class="fldDataEdit center" colspan="2"><ps:select
						id="periodicity_${_pageRef}"
						name="custSegmentationCO.ctsSegmentVO.PERIODICITY" tabindex="4"
						list="periodicityDropDown" emptyOption="false" listKey="code"
						listValue="descValue"
						dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByPeriodicity"
						parameter="custSegmentationCO.ctsSegmentVO.PERIODICITY:periodicity_${_pageRef},custSegmentationCO.ctsSegmentVO.DAY:day_${_pageRef}"
						dependency="periodicity_${_pageRef}:custSegmentationCO.ctsSegmentVO.PERIODICITY,day_${_pageRef}:custSegmentationCO.ctsSegmentVO.DAY" /></td>
				<td class="fldLabelView"><ps:label key="on_key"
						id="lbl_On_${_pageRef}" /></td>
				<td class="fldDataEdit center" colspan="2"><ps:select
						id="day_${_pageRef}" name="custSegmentationCO.ctsSegmentVO.DAY"
						tabindex="4" list="dayDropDown" emptyOption="false" listKey="code"
						listValue="descValue" /></td>

			</ps:if>
		</tr>

		<tr>
			<ps:if
				test='custSegmentationCO.isSegmentationScore!="SC" && custSegmentationCO.isSegmentationScore!="BR"'>
				<td class="fldDataEdit center" align="left" colspan="2"><ps:label
						key="priority_key" id="lbl_priority_${_pageRef}"
						for="priority_${_pageRef}" /></td>
				<td colspan="4"><ps:textfield id="priority_${_pageRef}"
						name="custSegmentationCO.ctsSegmentVO.PRIORITY" mode="number"
						nbFormat="####" maxlength="4"
						cssClass="ui-widget-content textCompSize ui-corner-all"
						readonly="true" /></td>
			</ps:if>

			<td colspan="1"></td>

			<td colspan="1"></td>

			<ps:hidden id="chargesWaiverGridUpdates_${_pageRef}"
				name="custSegmentationCO.chargesWaiverGridUpdates" />
			<ps:div id="custSegmentationChargesWaiverDiv_id_${_pageRef}"></ps:div>

			<%-- <ps:if test='custSegmentationCO.isSegmentationScore!="SC"'>
				<td width="20%" colspan="2">
					<psj:submit button="true" buttonIcon="ui-icon-comment" type="button"
						disabled="${_buttonDisabled}"
						id="custSegmentation_waiver_Charges_btn_${_pageRef}"
						onclick="custSegmentation_onChargesWaiverClick();"
						cssStyle="width: 100%; height: 50px;">
						<ps:label key='Waiver_Charges_key' />
					</psj:submit>
				</td>
			</ps:if> --%>
			<td width="3"></td>
		</tr>


	</table>
	<br />

	<div id="custSegmentationSubGridTabs_${_pageRef}" style="width: 99%">
		<%@include file="CustomerSegmentationSubGrid.jsp"%>
	</div>

	<br />

	<table width="99%">
		<tr>
			<td width="10%"></td>
			<td width="70%" align="center"><ps:textarea
					id="CombinationDetails_${_pageRef}"
					name="custSegmentationCO.displayExpression" mode="text"
					cssStyle="width:800px; height:100px" readonly="true"
					cssClass="ui-widget-content textCompSize ui-corner-all" /></td>
			<td width="20%">
				<psj:submit  id="trialProcess_${_pageRef}"  button="true" type="button" style="width:100px; height:40px"
								onclick="custSegmentationDetailList_trialProcess()" freezeOnSubmit="true">
			    	<ps:label key="Trial_Process_key"/>
			   	</psj:submit>
			   	<br />
			   	<psj:submit  id="excludeCif_${_pageRef}" button="true" buttonIcon="ui-icon-comment" type="button" style="width:100px; height:40px"
			   					onclick="custSegmentationDetailList_excludeCif()">
						<ps:label key="exclude_cif_key"/>
				</psj:submit>
			</td>
			<td width="10%"></td>
		</tr>
	</table>
	<br />

	<ptt:toolBar id="custSegmentationMaintToolBar_${_pageRef}"
		hideInAlert="true" width="99%">


		<ps:if test='%{#ivcrud_${_pageRef}=="R" }'>

			<ps:if test='%{custSegmentationCO.ctsSegmentVO.SEGMENT_CODE ==null }'>
				<psj:submit id="custSegmentationMaint_save_${_pageRef}"
					button="true" freezeOnSubmit="true"
					onclick="amendMethodName('saveSegment')"
					progRef="${menuButtonAccess}">
					<ps:label key="Save_key"
						for="custSegmentationMaint_save_${_pageRef}" />
				</psj:submit>
			</ps:if>


			<ps:if test='%{(custSegmentationCO.isSegmentationScore=="BR" && custSegmentationCO.ctsSegmentVO.STATUS == "P")}'>
				<psj:submit id="Segment_Copy_btn_${_pageRef}" button="true"
					onclick="amendMethodName('copySegment')" freezeOnSubmit="true"
					progRef="${menuButtonAccess}">
					<ps:label for="Segment_Copy_btn_${_pageRef}" key="copy_key" />
				</psj:submit>

			</ps:if>

			<ps:if
				test='%{(custSegmentationCO.isSegmentationScore =="S" || (custSegmentationCO.isSegmentationScore=="BR" && custSegmentationCO.ctsSegmentVO.STATUS == "A" && custSegmentationCO.ctsSegmentVO.SEGMENT_CODE!=null) || (custSegmentationCO.isSegmentationScore=="SC" && custSegmentationCO.ctsSegmentVO.STATUS == "A" && custSegmentationCO.ctsSegmentVO.SEGMENT_CODE!=null) && #ivcrud_${_pageRef} == "R") }'>
				<psj:submit id="custSegmentationMaint_del_${_pageRef}" button="true"
					freezeOnSubmit="true" onclick="amendMethodName('deleteSegment')">
					<ps:label key="Delete_key"
						for="custSegmentationMaint_del_${_pageRef}" />
				</psj:submit>
			</ps:if>
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="P"}'>
			<psj:submit id="custSegmentationMaint_approve_${_pageRef}"
				button="true" freezeOnSubmit="true"
				onclick="amendMethodName( 'approveSegment')"
				progRef="${menuButtonAccess}">
				<ps:label key="Approve_key"
					for="custSegmentationMaint_approve_${_pageRef}" />
			</psj:submit>
		</ps:if>
		<ps:if
			test='%{#ivcrud_${_pageRef}=="P"} && custSegmentationCO.isSegmentationScore!="BR"'>
			<psj:submit id="custSegmentationMaint_del_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="amendMethodName( 'rejectSegment')"
				progRef="${menuButtonAccess}">
				<ps:label key="Reject_key"
					for="custSegmentationMaint_del_${_pageRef}" />
			</psj:submit>
		</ps:if>
		<ps:if
			test='%{(#ivcrud_${_pageRef}=="UP" && custSegmentationCO.isSegmentationScore=="BR" && custSegmentationCO.ctsSegmentVO.SEGMENT_CODE!=null) ||  #ivcrud_${_pageRef}=="UP" || ((custSegmentationCO.isSegmentationScore=="BR" || custSegmentationCO.isSegmentationScore=="SC") && custSegmentationCO.ctsSegmentVO.STATUS == "A" && custSegmentationCO.ctsSegmentVO.SEGMENT_CODE!=null) &&#ivcrud_${_pageRef}=="R"}'>
			<psj:submit
				id="custSegmentationMaint_update_after_approve_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('saveSegment')">
				<ps:label key="update_key"
					for="custSegmentationMaint_update_after_approve_${_pageRef}" />
			</psj:submit>
		</ps:if>






		<ps:if test='%{#ivcrud_${_pageRef}=="S"}'>
			<psj:submit id="custSegmentationMaint_suspend_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('suspendSegment')">
				<ps:label key="suspend_key"
					for="custSegmentationMaint_suspend_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="SP"}'>
			<psj:submit id="custSegmentationMaint_approve_suspend_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('approveSuspendSegment')">
				<ps:label key="approve_suspend_key"
					for="custSegmentationMaint_approve_suspend_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="RE"}'>
			<psj:submit id="custSegmentationMaint_reactivate_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('reactivateSegment')">
				<ps:label key="reactivate_key"
					for="custSegmentationMaint_reactivate_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="RP"}'>
			<psj:submit id="custSegmentationMaint_approve_reactivate_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('approveReactivateSegment')">
				<ps:label key="approve_reactivate_key"
					for="custSegmentationMaint_approve_reactivate_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="C"}'>
			<psj:submit id="custSegmentationMaint_cancel_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('cancelSegment')">
				<ps:label key="cancel_key"
					for="custSegmentationMaint_cancel_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="CP"}'>
			<psj:submit id="custSegmentationMaint_approve_cancel_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="amendMethodName('approveCancelSegment')">
				<ps:label key="approve_cancel_key"
					for="custSegmentationMaint_approve_cancel_${_pageRef}" />
			</psj:submit>
		</ps:if>

	</ptt:toolBar>

	<div id="segmentCriteriaDivId_${_pageRef}"></div>

</ps:form>

<script type="text/javascript">
	var Details_key = "<ps:text name='details_key' />";
	var param_details_key = "<ps:text name='param_details_key' />"; // added by nour

	var ok_key = "<ps:text name='ok_key' />";
	var Mandatory_Field_key = '<ps:text name="Mandatory_Field_key"/>';
	var excludecifs_key = "<ps:text name='excludecif_key' />";
	var cancel_key = "<ps:text name='cancel_key' />";
	var save_key = "<ps:text name='save_key' />";

	// added by nour for #864398
	var Confirm_Delete_Process_key = "<ps:text name='Confirm_Delete_Process_key'/>";
	var record_was_Suspended_Successfully_key = document.getElementById("record_was_Suspended_Successfully_key_id").value;
	var record_was_approve_suspended_sucessfully_key = document.getElementById("record_was_approve_suspended_sucessfully_key_id").value;
	var Record_was_reactivated_successfully_key = "${Record_was_reactivated_successfully_key}";
	var Record_was_approve_reactivated_successfully_key = "${Record_was_approve_reactivated_successfully_key}";
	var Confirm_Reactivate_Process_key = "<ps:text name='Confirm_Reactivate_Process_key'/>";
	var Record_was_reactivated_successfully_key = document.getElementById("Record_was_reactivated_successfully_key_id").value;
	var Record_was_approve_reactivated_successfully_key = document.getElementById("Record_was_approve_reactivated_successfully_key_id").value;
	var Confirm_Copy_key  = "<ps:text name='confirm_copy_key'/>";
	$.struts2_jquery.require("CommonFuncExtension.js", null, "${pageContext.request.contextPath}/common/jquery/");
	$.struts2_jquery.require("Smart.js", null, "${pageContext.request.contextPath}/common/js/smart/");

	
	$(document).ready(function()
	{
		//							$.struts2_jquery.require("CustSegmentationMaint.js" ,null,jQuery.contextPath+"/path/js/customersegmentation/");
		$("#custSegmentationMaintFormId_" + _pageRef).processAfterValid("saveCustSegmentation", {});
	});
</script>