<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:form id="segmentGroupingFormId_${_pageRef}" action=""
	target="_blank" applyChangeTrack="true" useHiddenProps="false">
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />

	<ps:hidden name="iv_crud" id="iv_crud_${_pageRef}" />
	<ps:hidden id="methodName_${_pageRef}" />
	<ps:hidden id="dateUpdated_${_pageRef}" name="segmentGroupingCO.ctsSegmentGroupingVO.DATE_UPDATED" />
	<ps:hidden id="oldStatus_${_pageRef}" name="segmentGroupingCO.ctsSegmentGroupingVO.OLD_STATUS" />
	
	<table width="100%" cellpadding="0" border="0" cellspacing="5">

		<tr>
			<td width="5%"><ps:label id="group_code_lbl_id_${_pageRef}"
					key="code_key" for="group_code_${_pageRef}" />
			<td width="10%"><ps:textfield mode="number"
					id="group_code_${_pageRef}" maxlength="4" leadZeros="4"
					name="segmentGroupingCO.ctsSegmentGroupingVO.GROUP_CODE"
					readonly="${_recReadOnly}" required = "true"
					dependencySrc="${pageContext.request.contextPath}/path/grouping/SegmentGroupingMaintAction_dependencyByGroupCode"
					parameter="segmentGroupingSC.groupCode:group_code_${_pageRef}"
					dependency="group_code_${_pageRef}:segmentGroupingCO.ctsSegmentGroupingVO.GROUP_CODE" />
			</td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td width="10%"></td>
			<td colspan="3"></td>
			<td width="25%"><ps:label key="current_status_key"
					id="lbl_status_${_pageRef}" for="status_${_pageRef}" /> <ps:hidden
					id="statusId_${_pageRef}"
					name="segmentGroupingCO.ctsSegmentGroupingVO.STATUS"></ps:hidden> <ps:textfield
					id="status_${_pageRef}" name="segmentGroupingCO.statusDesc"
					readonly="true" cssStyle="width:100px" /> <psj:a button="true"
					href="#" buttonIcon="ui-icon-triangle-2-s"
					onclick="segmentGrouping_onStatusClicked()">
					<ps:text name='status_key' />
				</psj:a></td>
		</tr>


		<tr>
			<td width="5%"><ps:label key="description_English_key"
					for="descriptionEng_${_pageRef}"
					id="lbl_descriptionEng_${_pageRef}" /></td>
			<td colspan="3"><ps:textfield id="descriptionEng_${_pageRef}"
					name="segmentGroupingCO.ctsSegmentGroupingVO.DESCRIPTION"
					maxlength="40"></ps:textfield></td>

		</tr>

		<tr>
			<td width="5%"><ps:label key="priority_key"
					for="priority_${_pageRef}" id="lbl_priority_${_pageRef}" /></td>
			<td><ps:textfield id="priority_${_pageRef}" mode="number" required = "true"
					name="segmentGroupingCO.ctsSegmentGroupingVO.PRIORITY"
					dependencySrc="${pageContext.request.contextPath}/path/grouping/SegmentGroupingMaintAction_dependencyByPriority"
					parameter="segmentGroupingSC.groupCode:group_code_${_pageRef},segmentGroupingSC.priority:priority_${_pageRef}"
					dependency="priority_${_pageRef}:segmentGroupingCO.ctsSegmentGroupingVO.PRIORITY"
					maxlength="4"></ps:textfield></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>


	<ptt:toolBar id="segmentGroupingMaintToolBar_${_pageRef}"
		hideInAlert="true">
		<ps:if test='%{#ivcrud_${_pageRef}=="R"}'>
			<psj:submit id="segmentGroupingMaint_save_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="setMethodName('saveGroup')">
				<ps:label key="Save_key" for="segmentGroupingMaint_save_${_pageRef}" />
			</psj:submit>

			<psj:submit id="segmentGroupingMaint_del_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="setMethodName('deleteGroup')">
				<ps:label key="Delete_key"
					for="segmentGroupingMaint_del_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="P"}'>
			<psj:submit id="segmentGroupingMaint_approve_${_pageRef}"
				button="true" freezeOnSubmit="true"
				onclick="setMethodName( 'approveGroup')"
				progRef="${menuButtonAccess}">
				<ps:label key="Approve_key"
					for="segmentGroupingMaint_approve_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="UP"}'>
			<psj:submit
				id="segmentGroupingMaint_update_after_approve_${_pageRef}"
				button="true" freezeOnSubmit="true" progRef="${menuButtonAccess}"
				onclick="setMethodName('saveGroup')">
				<ps:label key="update_key"
					for="segmentGroupingMaint_update_after_approve_${_pageRef}" />
			</psj:submit>
		</ps:if>

		<ps:if test='%{#ivcrud_${_pageRef}=="P"}'>
			<psj:submit id="segmentGroupingMaint_del_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="setMethodName( 'rejectGroup')"
				progRef="${menuButtonAccess}">
				<ps:label key="Reject_key"
					for="segmentGroupingMaint_del_${_pageRef}" />
			</psj:submit>
		</ps:if>
	</ptt:toolBar>
</ps:form>
<script type="text/javascript">
	var Saved_Successfully_key = "<ps:text name='saved_successfully_key' />";

	$(document).ready(function()
	{
		$.struts2_jquery.require("SegmentGroupingMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/grouping/");

		$("#segmentGroupingFormId_" + _pageRef).processAfterValid("saveSegmentGroup", {});
	});
</script>