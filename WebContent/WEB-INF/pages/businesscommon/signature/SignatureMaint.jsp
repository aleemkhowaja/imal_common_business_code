<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@page import="com.path.bo.common.ConstantsCommon"%>
<%@page import="com.path.bo.common.CommonMethods"%>
<%@page import="com.path.bo.common.PluginsConstants"%>


	<script type="text/javascript">
		$.struts2_jquery.require("jquery.iviewer.min.js", null, jQuery.contextPath+ "/common/jquery/js/plugins/");
		$.struts2_jquery.require("jquery.mousewheel.min.js", null, jQuery.contextPath+ "/common/jquery/js/plugins/");
		$.struts2_jquery.require("jquery.tools.min.js", null, jQuery.contextPath+ "/common/js/");	
		$.struts2_jquery.require("Scan.js",null,jQuery.contextPath+ "/common/js/scan/");
	</script>

<ps:if test='%{(signatureCO.viewMode=="EC"||_recReadOnly!="true") && signatureCO.viewMode.equals("A")}'>
<%if(CommonMethods.returnActivexDownloadEnabled()){%>
<object name="PathCtrl" style='display:none' id='PathCtrl' classid='<%=ConstantsCommon.TWAIN_CLSID%>' codebase='../login/PathTWAINCtrl.cab#version=<%=ConstantsCommon.SCAN_AX_VERSION%>'></object>
<%}%>
</ps:if>

<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
	<div id="signatureFormDiv_<ps:property value="_pageRef" escapeHtml="true"/><ps:property value="secondaryId" escapeHtml="true"/>" style="overflow: hidden">
		<ps:form id="signFormId_${_pageRef}${secondaryId}"   method="post" enctype="multipart/form-data" namespace="/path/signature/" useHiddenProps="true" >
		    <ps:hidden name="signatureCO.viewMode"  id="pageMode_${_pageRef}${secondaryId}" /> <!-- to identify whether the page is in Add/Edit/Change amount Mode -->
		    <ps:hidden name="_recReadOnly"  id="signReadOnly_${_pageRef}" />
		    <ps:hidden name="signatureCO.cifObjectVO.OBJECT_SEQ"  id="signObjectSeq_${_pageRef}${secondaryId}" />
		    <ps:hidden name="signatureCO.cifObjectVO.OBJECT_CODE"  id="signObjectCode_${_pageRef}${secondaryId}" />
		    <ps:hidden name="signatureCO.origin"  id="signOrigin_${_pageRef}${secondaryId}" />
		    <ps:hidden name="fileUploadContentType"  id="signFileType_${_pageRef}${secondaryId}" /><!-- populated while adding a signature -->
		    <ps:hidden name="signTempFileName" id="signImportFile_temp_${_pageRef}${secondaryId}" />
		    <ps:hidden name="signatureCO.scanVO.DOC_TYPE"  id="scanVODocType_${_pageRef}${secondaryId}" /><!-- populated while editing a signature -->		    
		    <ps:hidden name="signatureCO.cifObjectVO.OBJECT_TYPE"  id="objectType_${_pageRef}${secondaryId}" />
		    <ps:hidden name="signatureCO.setSignAuditTrxNbr" id="setSignAuditTrxNbr_${_pageRef}${secondaryId}" />
		    <ps:hidden name="signOption" id="signOption_${_pageRef}${secondaryId}"  value="I"/> <!-- Signature Option details -->
		    <ps:hidden name="signCaptStr" id="signCaptStr_${_pageRef}${secondaryId}" />		  <!-- Signature captured string -->
		    <ps:hidden id="idNoPrevValue_${_pageRef}" value=""></ps:hidden>

		    
		  
		    

		  
			<table width="100%"  border="0"   cellpadding="0"  cellspacing="1">
				<tr>
					<td width="65%"></td>
					<td width="35%"></td>
				 
				</tr>
				<tr>
					<td>
						<table width="100%"  border="0"   cellpadding="1"  cellspacing="2">
							<tr>
								<td width="20%"></td>
								<td width="20%"></td>
								<td width="15%"></td>
								<td width="5%"></td>
								<td width="15%"></td>
								<td width="10%"></td>
								<td width="15%"></td>						 
							</tr>
							<tr>

														   <td class="fldLabelView" >
									<ps:label key="signature_cif_key" id="authCIFNoLabel_${_pageRef}${secondaryId}" for="lookuptxt_authCIFNo_${_pageRef}${secondaryId}" />
								</td>
								<td>
									<psj:livesearch id="authCIFNo_${_pageRef}${secondaryId}"
										name="signatureCO.cifObjectVO.AUTH_CIF_NO" mode="number"
										actionName="${pageContext.request.contextPath}/pathdesktop/AuthSignatoriesLookup_constructLookup"
										resultList="cifAuthSignatoryVO.AUTH_CIF_NO:lookuptxt_authCIFNo_${_pageRef}${secondaryId},cifAuthSignatoryVO.AUTH_NAME:authCifDesc_${_pageRef}"
										searchElement="CIF_NO" readOnlyMode="true"
										maxlength="12" autoSearch="false"
										paramList="cifNo:_signCIFCode_${_pageRef}"
										parameter="signatureCO.cifObjectVO.AUTH_CIF_NO:lookuptxt_authCIFNo_${_pageRef}${secondaryId},signatureCO.cifVO.CIF_NO:_signCIFCode_${_pageRef},
												signatureCO.scanVO.SIGN_INSTRUCTIONS:signatureInstructions_${_pageRef}${secondaryId}"
										dependencySrc="${pageContext.request.contextPath}/path/signature/Signature_dependencyByAuthCifNo"
										dependency="lookuptxt_authCIFNo_${_pageRef}${secondaryId}:signatureCO.cifObjectVO.AUTH_CIF_NO,
													authCifDesc_${_pageRef}:signatureCO.authCifDesc,
													lookuptxt_scanVO_ID_TYPE_${_pageRef}:signatureCO.scanVO.ID_TYPE,
													signatureCO_idTypeDesc_${_pageRef}:signatureCO.idTypeDesc,
													scanVO_ID_NO_${_pageRef}:signatureCO.scanVO.ID_NO"
										leadZeros="8"
										>
									</psj:livesearch>
								</td>
								<td colspan="3">
									<ps:textfield id="authCifDesc_${_pageRef}${secondaryId}"
										name="signatureCO.authCifDesc" readonly="true" />
								</td>
								<td><ps:label key="cif_desc_key" id="authCIFDescLabel_${_pageRef}${secondaryId}" for="authCifDesc_${_pageRef}${secondaryId}" cssStyle="visibility:hidden"/></td>
								<td>
								<ps:if test="privilegeList.contains('SIGNAUD')">	
									<script type="text/javascript">
									$.struts2_jquery.require("SignatureMain.js" ,null,jQuery.contextPath+"/common/js/signature/"); 
									</script>
									    <span class="collapsibleIcon"> <a
										class="fg-button ui-state-default  ui-corner-all fg-button-icon-left"
										id="auditButton_<ps:property value="_pageRef" escapeHtml="true"/>" href="#"
										onclick="javascript:signature_showAuditReport(<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>);"><span
											class="ui-icon ui-icon-note"></span>
											<ps:text name="infoBar_audit_key"></ps:text>
										</a> </span>
								</ps:if>
								</td>
							</tr>	
							<tr>
							
								<td class="fldLabelView">
									<ps:label key="Signature_Description_key" id="signDescLabel_${_pageRef}${secondaryId}" for="signDesc_${_pageRef}${secondaryId}"/>
								</td>
								<td colspan="4">
									<ps:textfield name="signatureCO.scanVO.DESCRIPTION" id="signDesc_${_pageRef}${secondaryId}" maxlength="40"/>
								</td>
								<td colspan="2">								
								</td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="signature_instructions_key" id="signInstLabel_${_pageRef}${secondaryId}" for="signatureInstructions_${_pageRef}${secondaryId}"/>
								</td>
								<td width=21%>
								<ps:select id="signatureInstructions_${_pageRef}${secondaryId}" name="signatureCO.scanVO.SIGN_INSTRUCTIONS" 
								list="keySignInstructionsList" listKey="code" listValue="descValue" 
								dependencySrc="${pageContext.request.contextPath}/path/signature/Signature_signInstDependency"
								parameter="signatureCO.scanVO.SIGN_INSTRUCTIONS:signatureInstructions_${_pageRef}${secondaryId},
										   signatureSC.signatureTp:signatureTp_${_pageRef},
										   signatureSC.isAsaanAcc:is_Asaan_Acc_${_pageRef},_pageRef:_pageRef,
								   		   signatureCO.cifObjectVO.AUTH_CIF_NO:lookuptxt_authCIFNo_${_pageRef}${secondaryId},
								   		   signatureCO.cifVO.CIF_NO:_signCIFCode_${_pageRef}"
								dependency="signatureInstructions_${_pageRef}${secondaryId}:signatureCO.scanVO.SIGN_INSTRUCTIONS
								,instructionsOtherValue_${_pageRef}${secondaryId}:signatureCO.scanVO.INST_OTHER_VALUE,
								signatureCO_idTypeDesc_${_pageRef}:signatureCO.idTypeDesc,lookuptxt_scanVO_ID_TYPE_${_pageRef}:signatureCO.scanVO.ID_TYPE,
								scanVO_ID_NO_${_pageRef}:signatureCO.scanVO.ID_NO">
								</ps:select>
								</td>

								<td colspan="4" >
								<ps:label key="signature_instructions_key" for="instructionsOtherValue_${_pageRef}${secondaryId}" cssStyle="display:none" />
								<ps:textfield name="signatureCO.scanVO.INST_OTHER_VALUE" id="instructionsOtherValue_${_pageRef}${secondaryId}" maxlength="40"/>	

								</td>
								</tr>
								<tr>	
								<% /* added by maria for tp#569085 */ %>
								<td class="fldLabelView " width="75px">
									<ps:label key="Id_Type_key" id="lbl_scanVO_ID_TYPE_${_pageRef}" for="lookuptxt_scanVO_ID_TYPE_${_pageRef}"/>
								</td>
								<td>
									<psj:livesearch id="scanVO_ID_TYPE_${_pageRef}" name="signatureCO.scanVO.ID_TYPE"
									actionName="${pageContext.request.contextPath}/pathdesktop/IdType_constructLookup" 
									searchElement="CODE"  autoSearch="false" size="10" mode="number" maxlength="3" minValue="0"
									parameter="idTypeCode:lookuptxt_scanVO_ID_TYPE_${_pageRef},
											   idTypeSC.showInvalideCodeMsg:~CONST_true"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/IdTypeDependencyAction_dependencyByIdTypeCode"
									dependency="signatureCO_idTypeDesc_${_pageRef}:idTypeVO.DESC_ENG
												,lookuptxt_scanVO_ID_TYPE_${_pageRef}:idTypeVO.CODE"
									relatedDescElt="signatureCO_idTypeDesc_${_pageRef}"/>
								</td>
								<td>
									<ps:textfield name="signatureCO.idTypeDesc" id="signatureCO_idTypeDesc_${_pageRef}" readonly="true"/>
								</td>
								<td class="fldDataEdit center" colspan="3">
									<ps:textfield  name="signatureCO.scanVO.ID_NO" id="scanVO_ID_NO_${_pageRef}" maxLength="20"
									beforeDepEvent="handleIdNoPrevValue()" maxlength="20"
									parameter="idTypeCode:lookuptxt_scanVO_ID_TYPE_${_pageRef}, 
											   idNoCode:scanVO_ID_NO_${_pageRef},
											   cifCode:lookuptxt_cifNo_${_pageRef},
											   fomCO.fromSignature:~CONST_true"
									dependencySrc="${pageContext.request.contextPath}/pathdesktop/IdTypeDependencyAction_validateIdsIdNo"
									dependency="scanVO_ID_NO_${_pageRef}:idNoCode"
									afterDepEvent="onchangeIdNo()" 
									/>
									<ps:label key="Id_No_key" id="lbl_scanVO_ID_NO_${_pageRef}" for="scanVO_ID_NO_${_pageRef}" />
								</td>
								<% /* end maria */ %>
								
							</tr>
							<ps:if test='!signatureCO.viewMode.equals("E")'><!-- hide for editall mode -->
							<tr>	
								<td class="fldLabelView">
									<ps:label key="Limit_Amount_key" id="limitAmtLabel_${_pageRef}${secondaryId}" for="limitAmt_${_pageRef}${secondaryId}"/>						
								</td>	
								<td colspan="2">
									<ps:textfield name="signatureCO.cifObjectVO.AMOUNT" id="limitAmt_${_pageRef}${secondaryId}" readonly="false" mode="number" maxValue="999999999999.99" minValue="0" nbFormat="#,##0.00" maxlength="17"/>
								</td>
								<td colspan="2">
									<ps:textfield name="signatureCO.currencyDesc" id="limitAmtCurrencyDesc_${_pageRef}${secondaryId}" readonly="true"/>
								</td>
								<td colspan="2"></td>
							</tr>
							</ps:if>
							<ps:else>
								<ps:hidden name="signatureCO.cifObjectVO.AMOUNT" id="limitAmt_${_pageRef}${secondaryId}_hidden"  />
							</ps:else>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Signature_Group_key" id="signGroupLabel_${_pageRef}${secondaryId}" for="signGroupLabel_${_pageRef}${secondaryId}"/>
								</td>						
								<td colspan="2">						
									<ps:select id="signGroup_${_pageRef}${secondaryId}" list="signGroupList" listKey="code" listValue="descValue" name="signatureCO.cifObjectVO.GROUP_ID" ></ps:select>							 
								</td>	
								<td colspan="4"></td>						
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Expiry_Date_key" id="expiryDateLabel_${_pageRef}${secondaryId}" for="expirySignDate_${_pageRef}${secondaryId}"/>						
								</td>
								<td colspan="2">
									 <psj:datepicker  id="expirySignDate_${_pageRef}${secondaryId}"   name="signatureCO.scanVO.EXP_DATE"  buttonImageOnly="true" />
								</td>
								<td colspan="2">
									  	<ps:checkbox name="signatureCO.unlimitedFlag" id = "expiryUnlimited_${_pageRef}${secondaryId}" key="Unlimited_key" 
										    onchange="expiryUnlimitedCheckBoxOnChange();" cssClass="ui-widget-content checkboxheight" />
								</td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Annotation_key" id="signAnnotationLabel_${_pageRef}${secondaryId}" for="signAnnotation_${_pageRef}${secondaryId}"/>
								</td>
								<td colspan="4">
									<ps:textarea id="signAnnotation_${_pageRef}${secondaryId}" name="signatureCO.scanVO.ANNOTATION" maxlength="255"></ps:textarea>
								</td>
							 
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="general_note_key" id="signAnnotationLabel_${_pageRef}${secondaryId}" for="signAnnotation_${_pageRef}${secondaryId}"/>
								</td>
								<td colspan="4">
									<ps:textarea id="generalNote_${_pageRef}${secondaryId}" name="signatureCO.signatureAnnotationVO.ANNOTATION" rows="5" maxlength="4000"></ps:textarea>
								</td>
								 
							</tr>						 
						    						    	
								<ps:if test='signatureCO.viewMode.equals("A")'>
									<tr>
										<td class="fldLabelView">
											<ps:label key="Open_Import_from_file_key" id="importFileLabel_${_pageRef}${secondaryId}" for="signImportFile_${_pageRef}${secondaryId}"/>
										</td>
										<td id="importFileContainer_${_pageRef}${secondaryId}" colspan="4">
											<ps:file id="signImportFile_${_pageRef}${secondaryId}" name="fileUpload"          ></ps:file>
										</td>
										 
									</tr>	
								</ps:if>
							 
							 								
						</table>
					</td>
					<td  >
						 
							<table width="100%"  border="0"   cellpadding="0"  cellspacing="0"   >
						
								<tr>
									<td>
									 							 

										 <div id="edit_sign_viewer_<ps:property value="_pageRef" escapeHtml="true"/><ps:property value="secondaryId" escapeHtml="true"/>"  style=" width:250px;height: 250px;border: 1px solid #CCCCCC;position: relative;"></div> 
										 <div id="signPadViewer_<ps:property value="_pageRef" escapeHtml="true"/><ps:property value="secondaryId" escapeHtml="true"/>" style="display: none;width:250px;height: 250px;border: 1px solid #CCCCCC;position: relative;" class="signViewer"  >
										<!--
										<OBJECT classid=clsid:69A40DA3-4D42-11D0-86B0-0000C025864A   id=SigPlus1 name=SigPlus1 style="HEIGHT: 250px; WIDTH: 250px; LEFT: 0px; TOP: 0px; VIEWASTEXT">
										-->		
												<OBJECT id=STPadCapt classid=clsid:3946312B-1829-4D4F-A2DF-CD35C8908BA1 name=STPadCapt style="HEIGHT: 250px; WIDTH: 250px; LEFT: 0px; TOP: 0px; VIEWASTEXT">
												     			<PARAM NAME="_Version" VALUE="131095">
																<PARAM NAME="_ExtentX" VALUE="4842">
																<PARAM NAME="_ExtentY" VALUE="1323">
																<PARAM NAME="_StockProps" VALUE="0">
										        </OBJECT>
										        <span class="iviewer-toolbar ui-widget-header ui-corner-all">
										        	<button id="signPadClearBtn_<ps:property value="_pageRef" escapeHtml="true"/>" type="button" class="iviewer-button" onclick="clearSignPadViewer();"></button>
										        </span>
										   </div>		 			
												
									</td>
								</tr>
								 
								
							</table>
						  
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>

				
				<%--<div style="overflow: auto;" >
				<img src=" <ps:url  action="Signature_loadSignatureImage?progRef=${_pageRef}${secondaryId}&signatureCO.cifObjectVO.OBJECT_CODE=${signatureCO.cifObjectVO.OBJECT_CODE}" namespace="/path/signature"/>" />
				</div>
				--%>
				 
			
				<pt:toolBar  id="signTooBar_${_pageRef}${secondaryId}"  >
				<ps:if test="%{signatureCO.viewMode=='EC'||_recReadOnly!='true'}">				
				 	<psj:submit  button="true"  freezeOnSubmit="true" ><ps:text name="btn.save"></ps:text></psj:submit>				 	
				 	<ps:if test='privilegeList.contains("SIGN002")&&signatureCO.viewMode.equals("A")'>
				 		<psj:submit  button="true" type="button"  freezeOnSubmit="true" onclick="resetSignMaintForm();" ><ps:text name="btn.clear"></ps:text></psj:submit>
					<%
					    String isMobile = CommonMethods.isMobileDevice(request.getHeader("User-Agent"));
								    if(isMobile == null)
								    {
					%>
					 	<psj:submit  button="true" type="button"  freezeOnSubmit="true" onclick="scanSignature();" ><ps:text name="Open_Scan_key"></ps:text></psj:submit>		 	 
					 	<psj:submit  button="true" type="button" freezeOnSubmit="true" onclick="captureSignature();"><ps:text name="Open_Capture_key"/></psj:submit>
					 	<%} %>
				 	</ps:if>
				 </ps:if>
				 	<ps:if test="privilegeList.contains('SIGN001')">		 	 
				 		<psj:submit  button="true" type="button"  freezeOnSubmit="true" onclick="openViewAllSignPopup();"><ps:text name="view_all_key"/></psj:submit>
				 		<ps:if test='signatureCO.viewMode.equals("A")'><!-- show only for add mode -->
				 			<psj:submit  button="true" type="button"  freezeOnSubmit="true" onclick="viewSignature();"><ps:text name="View_Signature_key"/></psj:submit>
				 		</ps:if>
					</ps:if>
				 	
				 	
				 
				</pt:toolBar>
			
		</ps:form>
	</div>		
 <script>
var AX_ERROR_KEY = "<ps:text name='AX_ERROR_KEY' />";
//Bug # 338150
var please_select_a_signature_key = "<ps:text name='please_select_a_signature_key' />";
var cannot_proceed_title = '<ps:text name="Cannot_Proceed" />';
 $(document).ready(function () {
 			$( "#signPadClearBtn_"+_pageRef).button({icons: {primary: "ui-icon-refresh"},text: false})  		  		 
 			var url = "#"
 		
 				var objectCode = '<ps:property value="signatureCO.cifObjectVO.OBJECT_CODE"  escapeHtml="false" escapeJavaScript="true"/>';
 			var origin = '<ps:property value="signatureCO.origin"  escapeHtml="false" escapeJavaScript="true"/>';
 			var objectSeq ='<ps:property value="signatureCO.cifObjectVO.OBJECT_SEQ"  escapeHtml="false" escapeJavaScript="true"/>';
 			var originObject = '<ps:property value="signatureCO.originObjectCode"  escapeHtml="false" escapeJavaScript="true"/>';
			
 			if(!"${signatureCO.cifObjectVO.OBJECT_CODE}"==''){
					url =  jQuery.contextPath +"/path/signature/Signature_loadSignatureImage?progRef="+_pageRef+"&signatureCO.cifObjectVO.OBJECT_CODE=${signatureCO.cifObjectVO.OBJECT_CODE}&signatureCO.origin=${signatureCO.origin}&signatureCO.cifObjectVO.OBJECT_SEQ=${signatureCO.cifObjectVO.OBJECT_SEQ}&signatureCO.originObjectCode=${signatureCO.originObjectCode}&signatureCO.cifObjectVO.BRANCH_CODE=${signatureCO.cifObjectVO.BRANCH_CODE}&signatureSC.branchCode="+$("#signatureBranchCode_"+_pageRef).val();			
				}
								
			$("#edit_sign_viewer_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').iviewer({src:url})	 			
			$("#signImportFile_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').die('change');
			$("#signImportFile_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').live("change", function(){ displaySignImg(this)});
			if($("#signReadOnly_"+_pageRef).val()!="true")  
			{
				expiryUnlimitedCheckBoxOnChange();
			}
			$("#signFormId_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').processAfterValid("saveSignature",[]);
		
    }); 
</script>	

 
	 
		
	 
	 