<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %>

<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:set name="dynTempConvStatus_${_pageRef}" value="dynTemplateCO.dynTempConvVO.STATUS" />
<ps:set name="Confirm_Save_Process_key_id" value="%{getEscText('Confirm_Save_Process_key')}"/>

<script type="text/javascript">

var Confirm_Save_Process_key='${Confirm_Save_Process_key_id}';

$(document).ready(function() {					
	$.struts2_jquery
	.require("DynamicTemplateConventionMaint.js", null,
			jQuery.contextPath
					+ "/businesscommon/js/dynamictemplate/");
							$("#dynamicTemplateConventionMaintFormId_"+_pageRef).processAfterValid("dynamicTemplateConventionMaint_processSubmit",{});
							dynamicTemplateConvListloadDivs();
							displaySpan();
						});
</script>

<ps:form useHiddenProps="true" id="dynamicTemplateConventionMaintFormId_${_pageRef}"  namespace="/path/dynamicTemplate">
<ps:hidden id="dynTempConvStatus_${_pageRef}" name="dynTemplateCO.dynTempConvVO.STATUS" />	
<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<table width="100%" cellpadding="0" cellspacing="0"	class="headerPortionContent ui-widget-content" border="0">
	<tr>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
	</tr>	
	<tr>
		<td colspan="1">
			<ps:label value="%{getText('convention_number_key')}" for="Code_${_pageRef}" hidden = "false"/>
		</td>
		<td colspan="1">
			<ps:textfield name="dynTemplateCO.dynTempConvVO.CONVENTION_NUMBER"
			id="Code_${_pageRef}" readonly="true" hidden = "true">
			</ps:textfield>
		</td>
		<td colspan="5"></td>
		<td colspan="1">
			<ps:textfield name="dynTemplateCO.statusDesc"
			id="statusDesc_${_pageRef}" readonly="true"
			cssStyle="text-align:center" hidden = "true">
			</ps:textfield>
		</td>
		<%-- <td colspan="1"><psj:a button="true" href="#"
				buttonIcon="ui-icon-triangle-2-s"
				onclick="dynamicTemplateConvention_onStatusClicked()">
				<ps:text name='status_key'  />
			</psj:a>
		</td> --%>
		<td colspan="1"></td>
	</tr>
	<tr>
		<td colspan="1"><ps:label
				key="entity_type_key" for="entity_type_${_pageRef}" />
		</td>
		<td class="fldDataEdit center" colspan="1"><ps:select
				id="entity_type_${_pageRef}"
				name="dynTemplateCO.dynTempConvVO.ENTITY_TYPE" list="entityTypelist"
				listValue="descValue" listKey="code" emptyOption="false"
				dependencySrc="" parameter="" dependency=""
				onchange="displaySpan(this.value)">
			</ps:select>
		</td>
		<td colspan="1"></td>
		<td colspan = "4">
			<span id ="dynTempConvAcc_${_pageRef}" >
				<table>
					<tr>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
					</tr>
					<tr>
						<td colspan ="1">
							<ps:label
							key="Account_No_key"
							for="accBr_${_pageRef}"
							id="label_Account_no_${_pageRef}"/>
						</td>
						<td colspan ="7">
							<ps:account
								inputIds      ="accBr_${_pageRef}~accCy_${_pageRef}~accGl_${_pageRef}~accCif_${_pageRef}~accSl_${_pageRef}~accAddRef_${_pageRef}~accName_${_pageRef}"
								inputNames    ="dynTemplateCO.dynTempConvVO.ACC_BR~dynTemplateCO.dynTempConvVO.ACC_CY~dynTemplateCO.dynTempConvVO.ACC_GL~dynTemplateCO.dynTempConvVO.ACC_CIF~dynTemplateCO.dynTempConvVO.ACC_SL~dynTemplateCO.accAddRef~dynTemplateCO.accountName"
								accountLabel  ="convention_account_key" 
								inputSizes    ="60~60~60~60~80~N~N"
								readOnly      ="false~false~false~false~false~false~true"
								mode          ="number~number~number~number~livesearch~livesearch~text"
								rowLocation   ="1~1~1~1~1~2~3" 
								colSpan       ="1~1~1~1~1~5~5" 
								leadZeros	  ="4~3~6~8~3~N~N"
								parameter     ="N
											    ~N
												~N
												~N
												~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},slNbr:lookuptxt_accSl_${_pageRef}
												~currencyCode:accCy_${_pageRef},addRef:lookuptxt_accAddRef_${_pageRef},criteria.displayMsg:CONST_1
												~N"
	                            onblur	      ="N~N~N~N~N~N~N"
	                            dependencySrc ="N
	                            				~N
	                            				~N
	                            				~N
	                            				~${pageContext.request.contextPath}/pathdesktop/AccountDependencyAction_returnAMFBySrlNbr?displayMsg=1
	                            				~${pageContext.request.contextPath}/pathdesktop/AccountDependencyAction_dependencyByAddRef?displayMsg=1
	                            				~N"
	                            dependency    ="accBr_${_pageRef}:account.BRANCH_CODE,accGl_${_pageRef}:account.GL_CODE,
	                                            lookuptxt_accSl_${_pageRef}:account.SL_NO,lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accName_${_pageRef}:account.BRIEF_NAME_ENG
	                            				~N
	                            				~accGl_${_pageRef}:account.GL_CODE,lookuptxt_accSl_${_pageRef}:account.SL_NO,
	                            				lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accName_${_pageRef}:account.BRIEF_NAME_ENG
	                            				~N
	                            				~lookuptxt_accSl_${_pageRef}:account.SL_NO,
	                                             lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accName_${_pageRef}:account.BRIEF_NAME_ENG
	                            				~accBr_${_pageRef}:account.BRANCH_CODE,accGl_${_pageRef}:account.GL_CODE,accCy_${_pageRef}:account.CURRENCY_CODE,accCif_${_pageRef}:account.CIF_SUB_NO,
	                                             lookuptxt_accSl_${_pageRef}:account.SL_NO,
	                                             lookuptxt_accAddRef_${_pageRef}:account.ADDITIONAL_REFERENCE,accName_${_pageRef}:account.BRIEF_NAME_ENG
	                            				~N"
	                            actionName    ="N~N~N~N~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~N" 
	                            paramList	  ="N~N~N~N~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},_pageRef:pageRef_${_pageRef}~branchCode:accBr_${_pageRef},currencyCode:accCy_${_pageRef},glCode:accGl_${_pageRef},cifCode:accCif_${_pageRef},_pageRef:pageRef_${_pageRef}~N"
	                            searchElement ="N~N~N~N~amfVO.SL_NO~amfVO.ADDITIONAL_REFERENCE~N"  
	                            onOk          ="N~N~N~N~onOkAccountNumber('accSl')~onOkAccountNumber('accAddRef')~N"
	                            autoSearch    ="N~N~N~N~false~false~N"  
	                            afterDepEvent="N~N~N~N~dynamicTemplateConvListloadDivs()~dynamicTemplateConvListloadDivs()~N"
	                            >
	                    </ps:account>	
						</td>
					</tr>
				</table>
			</span>
			<span id ="dynTempConvCif_${_pageRef}" style="display: none">
				<table>
					<tr>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
					</tr>	
					<tr>
						<td colspan ="1">
							<ps:label
							key="CIF_No_key"
							for="lookuptxt_cif_no_liveSearch_${_pageRef}"
							id="label_CIF_No_${_pageRef}" />
						</td>
						<td colspan ="2">
							<psj:livesearch 
							 id="cif_no_liveSearch_${_pageRef}" 
							 name="dynTemplateCO.dynTempConvVO.CIF_NO"
		                     actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
		                     resultList="SHORT_NAME_ENG:cif_no_liveSearch_Name_${_pageRef}"
		                     searchElement="CIF_NO"  
		                     autoSearch="false" 
		                     size="10" 
		                     mode="number" 
		                     maxlength="8" 
		                     parameter="cifVO.CIF_NO:lookuptxt_cif_no_liveSearch_${_pageRef}" 
		                     dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCif"
		                     dependency="cif_no_liveSearch_Name_${_pageRef}:cifVO.SHORT_NAME_ENG,lookuptxt_cif_no_liveSearch_${_pageRef}:cifVO.CIF_NO"
		                     afterDepEvent="dynamicTemplateConvListloadDivs()"
		                     />
						</td>
						<td colspan ="4">
							<ps:textfield
							id="cif_no_liveSearch_Name_${_pageRef}"
							name="dynTemplateCO.cifName"
							readonly="true" />
						</td>
					</tr>
				</table>
			</span>
			<span id ="dynTempConvSegment_${_pageRef}" style="display: none">
				<table>
					<tr>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"></td>
					</tr>	
					<tr>
						<td colspan ="1">
							<ps:label
							key="segment_no_key"
							for="lookuptxt_segment_no_liveSearch_${_pageRef}"
							id="label_segment_no_${_pageRef}" />
						</td>
						<td colspan ="2">
							<psj:livesearch 
							 id="segment_no_liveSearch_${_pageRef}" 
							 name="dynTemplateCO.dynTempConvVO.SEGMENT_CODE"
		                     actionName="${pageContext.request.contextPath}/pathdesktop/SegmentationCodeLookupAction_constructSegmentationCodeLookup" 
		                     resultList="SEGMENT_DESC:segment_no_liveSearch_Name_${_pageRef},SEGMENT_CODE:lookuptxt_segment_no_liveSearch_${_pageRef}"
		                     paramList="isSegmentationScore:~CONST_S"
		                     searchElement="SEGMENT_CODE"  
		                     autoSearch="false" 
		                     size="10" 
		                     mode="number" 
		                     maxlength="8" 
		                     parameter="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE:lookuptxt_segment_no_liveSearch_${_pageRef},custSegmentationCO.ctsSegmentVO.SEGMENT_TYPE:~CONST_S,_pageRef:pageRef_${_pageRef}" 
		                     dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyBySegmentCode"
		                     dependency="segment_no_liveSearch_Name_${_pageRef}:custSegmentationCO.ctsSegmentVO.SEGMENT_DESC,lookuptxt_segment_no_liveSearch_${_pageRef}:custSegmentationCO.ctsSegmentVO.SEGMENT_CODE"
		                     afterDepEvent="dynamicTemplateConvListloadDivs()"
		                     />
						</td>
						<td colspan ="4">
							<ps:textfield
							id="segment_no_liveSearch_Name_${_pageRef}"
							name="dynTemplateCO.segmentName"
							readonly="true" />
						</td>
					</tr>
				</table>
			</span>
		</td>
		<td colspan="1"><ps:label
				key="Start_date_key" for="start_date_${_pageRef}" /></td>
		<td colspan = "1">
			<psj:datepicker id="start_date_${_pageRef}" name="dynTemplateCO.dynTempConvVO.START_DATE"/>		
		</td>
		<td colspan="1"></td>
	</tr>
</table>

<%-- <ptt:toolBar id="dynamicTemplateConvMaintToolBar_${_pageRef}" hideInAlert="true">
   <ps:if test='%{#ivcrud_${_pageRef}=="R"}'>
			<ps:if
				test='%{#dynTempConvStatus_${_pageRef}==null || #dynTempConvStatus_${_pageRef}=="A"}'>
				<psj:submit id="dynamicTemplateConvMaint_save_${_pageRef}" button="true"
					freezeOnSubmit="true">
					<ps:label key="Save_key" for="dynamicTemplateConvMaint_save_${_pageRef}" />
				</psj:submit>
			</ps:if>

			<ps:if test='%{#dynTempConvStatus_${_pageRef}=="A"}'>
				<psj:submit id="dynamicTemplateConvMaint_delete_${_pageRef}" button="true"
					type="button" freezeOnSubmit="true"
					onclick="dynamicTemplateConvMaint_onDelClicked()">
					<ps:label key="Delete_key"
						for="dynamicTemplateConvMaint_delete_${_pageRef}" />
				</psj:submit>
			</ps:if>
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="P"}'>
			<psj:submit id="dynamicTemplateConvMaint_approve_${_pageRef}" button="true"
				freezeOnSubmit="true" onclick="dynamicTemplateConvMaint_processApprove()">
				<ps:label key="Approve_key"
					for="dynamicTemplateConvMaint_approve_${_pageRef}" />
			</psj:submit>
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="P"}'>	
			<psj:submit id="dynamicTemplateConvMaint_Reject_${_pageRef}" button="true" freezeOnSubmit="true"  onclick="dynamicTemplateConvMaint_processReject()">
		    	<ps:label key="Reject_key" for="dynamicTemplateConvMaint_Reject_${_pageRef}"/>
		    </psj:submit>	
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="UP"}'>
			<psj:submit id="dynamicTemplateConvMaint_UpdateAfterApprove_${_pageRef}"
				button="true" freezeOnSubmit="true">
				<ps:label key="Update_After_Approve_key"
					for="dynamicTemplateConvMaint_UpdateAfterApprove_${_pageRef}" />
			</psj:submit>
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="S"}'>	
			<psj:submit id="dynamicTemplateConvMaint_Suspend_${_pageRef}" button="true" freezeOnSubmit="true"  onclick="dynamicTemplateConvMaint_processSuspend()">
		    	<ps:label key="Suspend_key" for="dynamicTemplateConvMaint_Suspend_${_pageRef}"/>
		    </psj:submit>	
		</ps:if>
		<ps:if test='%{#ivcrud_${_pageRef}=="RA"}'>	
			<psj:submit id="dynamicTemplateConvMaint_Reactivate_${_pageRef}" button="true" freezeOnSubmit="true"  onclick="dynamicTemplateConvMaint_processReactivate()">
		    	<ps:label key="Reactivate_key" for="dynamicTemplateConvMaint_Reactivate_${_pageRef}"/>
		    </psj:submit>	
		</ps:if>
</ptt:toolBar> --%>


</ps:form>
<div id="dynamicTemplateConvListMaintDiv_id_${_pageRef}" style="width:100%;">
</div>
