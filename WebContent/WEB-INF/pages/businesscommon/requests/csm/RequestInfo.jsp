<%@taglib uri="/path-struts-tags" prefix="ps"%>
<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<script type="text/javascript">
$.struts2_jquery.require("RequestInfo.js", null, jQuery.contextPath + "/businesscommon/js/requests/csm/");
</script>
	
<div id="requestInfo" class="collapsibleContainer" title="Request Details">
	
<fieldset class="ui-widget-content ui-corner-all" >
	<table border="0" width="100%" cellpadding="0" id="requestInfoTbl_<ps:property value="_pageRef" escapeHtml="true"/>">
	
		<tr>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
			<td width="5%" ></td><td width="5%" ></td>
		</tr>
			<ps:hidden id="request_ivcrud_${_pageRef}"  value="${iv_crud}"/>
			<ps:hidden id="chargesGridEmptied_${_pageRef}" 		name="ctsRequestCO.isEmptied" />
			<ps:hidden id="chargesGridWaived_${_pageRef}" 		name="ctsRequestCO.isWaived" />
			<ps:hidden id="requestDetRequestCompCode_${_pageRef}" name="ctsRequestCO.ctsRequestVO.COMP_CODE" />
			<ps:hidden id="requestDetRequestBranch_${_pageRef}"  name="ctsRequestCO.ctsRequestVO.BRANCH" />
			<ps:hidden id="requestDetRequestAppName_${_pageRef}"  name="ctsRequestCO.ctsRequestVO.APP_NAME" />
			<ps:hidden id="_recReadOnly_${_pageRef}"  			 name="_recReadOnly" />
		<tr>
			<td class="fldLabelView" colspan="3">
				<ps:label key="Request_No_key" for="requestDetRequestNo_${_pageRef}" />
			</td>
			<td  class="fldDataEdit" colspan="4">
				<ps:textfield id="requestDetRequestNo_${_pageRef}"
					name="ctsRequestCO.ctsRequestVO.REQ_NO" readonly="true"
					mode="number"
					leadZeros="10">
				</ps:textfield>
			</td>
			<td colspan="3"></td>
			
			<td class="fldLabelView" colspan="3">
				<ps:label key="Request_Status_key" id="requestStatus_label" for="requestDetRequestStatusDesc_${_pageRef}"/>
			</td>
			<td class="fldDataEdit" colspan="3">
				<ps:hidden id="requestDetRequestStatus_${_pageRef}"
					name="ctsRequestCO.ctsRequestVO.STATUS" />
				<ps:textfield id="requestDetRequestStatusDesc_${_pageRef}"
					name="ctsRequestCO.requestStatusDesc" readonly="true"
					>
				</ps:textfield>
			</td>
			<td class="fldLabelView" colspan="3">
				<table border="0" width="100%" cellpadding="0">
					<tr>
						<td>
							<psj:submit id="requestDetRrequest_status_btn_${_pageRef}"
								button="true" onclick="requestDetRrequest_onStatusClicked()"
								type="button" buttonIcon="ui-icon-script" >
								<ps:text name="Status_Details_key"></ps:text>
							</psj:submit>
						</td>
					</tr>
				</table>
			</td>
			<td ></td>

		</tr>
		
		<tr>
			<td class="fldLabelView" colspan="3">
				<ps:label key="Request Date" for="requestDetRequestDate_${_pageRef}" />
			</td>
			<td colspan="3">
				<table border="0" width="100%" cellpadding="0">
					<tr>
						<td>
							<psj:datepicker id="requestDetRequestDate_${_pageRef}" name="ctsRequestCO.ctsRequestVO.REQ_DATE" 
								buttonImageOnly="true" readonly="true"
							/>
						</td>
					</tr>
				</table>
			</td>
			<td colspan="4"></td>
			
			<td class="fldLabelView" colspan="3">
				<ps:label key="Expiry_Date_key" for="requestDetRequestExpiryDate_${_pageRef}" />
			</td>
			
			
			<td class="fldDataEdit" colspan="3">
				<table border="0" width="100%" cellpadding="0">
					<tr>
						<td>
							<psj:datepicker id="requestDetRequestExpiryDate_${_pageRef}" name="ctsRequestCO.ctsRequestVO.REQ_EXP_DATE" 
								buttonImageOnly="true" 
								parameter="ctsRequestVO.REQ_EXP_DATE:requestDetRequestExpiryDate_${_pageRef}
										,ctsRequestCO.ctsRequestVO.REQ_DATE:requestDetRequestDate_${_pageRef}
										,ctsRequestCO.ctsRequestVO.TYPE:lookuptxt_requestDetRrequestType_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/path/requests/CtsRequestMaintAction_dependencyByExpiryDate"
								dependency="requestDetRequestExpiryDate_${_pageRef}:ctsRequestCO.ctsRequestVO.REQ_EXP_DATE"
							/>
						</td>
					</tr>
				</table>
			</td>
			<td class="fldLabelView" colspan="3">
				<table border="0" width="100%" cellpadding="0">
					<tr>
						<td>
							<psj:submit id="requestDetRrequest_Charge_btn_${_pageRef}"
							button="true" onclick="requestDetRrequest_onChargeDetClicked('${formId}')"
								type="button" buttonIcon="ui-icon-comment" >
								<ps:text name="Charges_Details_key"></ps:text>
							</psj:submit>
						</td>
					</tr>
				</table>
			</td>
			<td ></td>
		</tr>
		
		
		<tr>
			
				<td class="fldLabelView" colspan="3">
					<ps:label key="Request_Type_key" for="lookuptxt_requestDetRrequestType_${_pageRef}" />
				</td>
				<td class="fldDataEdit" colspan="2">
					<psj:livesearch id="requestDetRrequestType_${_pageRef}" name="ctsRequestCO.ctsRequestVO.TYPE"
						actionName="${pageContext.request.contextPath}/pathdesktop/CtsRequestTypeLookup_constructLookup"
						searchElement="CODE" autoSearch="false" leadZeros="6"
						mode="number" maxlength="6" required="true"
						dependencySrc="${pageContext.request.contextPath}/pathdesktop/CtsRequestTypeDependencyAction_ctsRequestById"
						parameter="code:lookuptxt_requestDetRrequestType_${_pageRef}"
						dependency="lookuptxt_requestDetRrequestType_${_pageRef}:ctsRequestTypeVO.CODE,requestDetRrequestTypeDesc_${_pageRef}:ctsRequestTypeVO.BRIEF_NAME_ENG">
					</psj:livesearch>
				</td>

				<td class="fldDataEdit"  colspan="4">
				<ps:textfield id="requestDetRrequestTypeDesc_${_pageRef}" name="ctsRequestCO.requestTypeDesc" readonly="true" />
			</td>
			<td></td>
				<td class="fldLabelView" colspan="3">
					<ps:label key="Processing_Branch_key" for="lookuptxt_requestDetRrequestProcessBranch_${_pageRef}" />
				</td>
				<td class="fldDataEdit" colspan="2">
					<psj:livesearch id="requestDetRrequestProcessBranch_${_pageRef}" name="ctsRequestCO.ctsRequestVO.PROCESS_BRANCH"
						actionName="${pageContext.request.contextPath}/pathdesktop/BranchesByUsrLookup_constructVaultBranchLookup"
						mode="number" size="5" leadZeros="4"
						maxlength="4" required="true"
						parameter="BRANCH_CODE:lookuptxt_requestDetRrequestProcessBranch_${_pageRef}"
						dependency="lookuptxt_requestDetRrequestProcessBranch_${_pageRef}:branchesVO.BRANCH_CODE,requestDetRrequestProcessBranchDesc_${_pageRef}:branchesVO.BRIEF_DESC_ENG"
						dependencySrc="${pageContext.request.contextPath}/pathdesktop/BranchesDependencyAction_branchDescByCode"
						searchElement="BRANCH_CODE" >
					</psj:livesearch>
				</td>


				<td class="fldLabelView" colspan="4" ><ps:textfield id="requestDetRrequestProcessBranchDesc_${_pageRef}"
					name="ctsRequestCO.processBranchDesc" readonly="true" >
				</ps:textfield>
			</td>
			<td ></td>
		</tr>
		<tr>
			<td class="fldLabelView" colspan="3" >
				<ps:label key="Description_key" />
			</td>
			<td class="fldDataEdit" colspan="6" >
				<ps:textfield id="requestDetRrequestReqDesc_${_pageRef}" name="ctsRequestCO.ctsRequestVO.REQ_DESC" 
					maxlength="50">
				</ps:textfield>
			</td>
			<td ></td>
			<td class="fldLabelView" colspan="3">
				<ps:label key="reference_key" />
			</td>
			
			<td class="fldDataEdit" colspan="6">
				<ps:textfield id="requestDetRrequestReqRef_${_pageRef}" name="ctsRequestCO.ctsRequestVO.REQ_REF" 
					maxlength="20">
				</ps:textfield>
			</td>
			<td ></td>
		</tr>
	</table>
	</fieldset>
	<div class="ui-state-active">
		<ps:label />
	</div>
</div>
	
<script type="text/javascript">
	var charges_key = "<ps:text name='Charges_key' />";
	$(document).ready(function () 
	{ 
		$("#requestInfo").collapsiblePanel();
		$("#chargesDetailDiv_id_"+_pageRef).remove();
		$("<div>", {id: "chargesDetailDiv_id_"+_pageRef}).insertAfter($("#requestInfoTbl_" + _pageRef));
	});
</script>