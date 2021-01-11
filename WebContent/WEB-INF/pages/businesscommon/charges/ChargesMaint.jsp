<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %><html>

<div id="chargesMaintDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>">
	<ps:hidden id="srcformId_${_pageRef}"/>
	<ps:hidden id="requestCy_${_pageRef}" name="ctsRequestCO.requestCy" />
	<ps:hidden id="requestCif_${_pageRef}" name="ctsRequestCO.requestCif" />
	<table>
		<tr>
			<td width="43%" colspan="19">
				<table width="38%">
					<tr>
						<td width="23%">
							<ps:label key="Payment_Type_key" for="paymentType_${_pageRef}"/>						
						</td>
						<td>
							<ps:select id="paymentType_${_pageRef}" name="ctsRequestCO.paymentType" 
								list="paymentTypeList" listKey="code" listValue="descValue" 
								parameter="ctsRequestCO.paymentType:paymentType_${_pageRef}
										,ctsRequestCO.requestCy:requestCy_${_pageRef}
										,ctsRequestCO.requestCif:requestCif_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/path/requests/CtsRequestMaintAction_dependencyByPaymentType"
								dependency="paymentType_${_pageRef}:ctsRequestCO.paymentType,
											chr_ac_br_${_pageRef}:ctsRequestCO.amfVO.BRANCH_CODE,
											chr_ac_cy_${_pageRef}:ctsRequestCO.amfVO.CURRENCY_CODE,
											chr_ac_gl_${_pageRef}:ctsRequestCO.amfVO.GL_CODE,
											chr_ac_cif_${_pageRef}:ctsRequestCO.amfVO.CIF_SUB_NO,
											lookuptxt_chr_ac_sl_${_pageRef}:ctsRequestCO.amfVO.SL_NO,
											lookuptxt_chr_ac_add_ref_${_pageRef}:ctsRequestCO.amfVO.ADDITIONAL_REFERENCE,
											chr_ac_desc_${_pageRef}:ctsRequestCO.amfVO.BRIEF_NAME_ENG"
								afterDepEvent="requestDetRrequest_emptyOfChargeGrid()"
							/>
						</td>
					</tr>
					<tr id="charge_ac_tr_<ps:property value="_pageRef" escapeHtml="true"/>">
						<td>
						  <ps:label key="charge_ac_key"></ps:label>
						</td>
						<td colspan="2">
							<ps:account
								inputIds      ="chr_ac_br_${_pageRef}~chr_ac_cy_${_pageRef}~chr_ac_gl_${_pageRef}~chr_ac_cif_${_pageRef}~chr_ac_sl_${_pageRef}~chr_ac_add_ref_${_pageRef}~chr_ac_desc_${_pageRef}"
								inputNames    ="ctsRequestCO.amfVO.BRANCH_CODE~ctsRequestCO.amfVO.CURRENCY_CODE~ctsRequestCO.amfVO.GL_CODE~ctsRequestCO.amfVO.CIF_SUB_NO~ctsRequestCO.amfVO.SL_NO~ctsRequestCO.amfVO.ADDITIONAL_REFERENCE~ctsRequestCO.amfVO.BRIEF_NAME_ENG"
								accountLabel  ="" 
								inputSizes    ="55~55~80~110~55~N~N"
								readOnly      ="false~false~false~false~false~false~true"
								mode          ="number~number~number~number~livesearch~livesearch~text"
								rowLocation   ="1~1~1~1~1~2~3"
								colSpan       ="1~1~1~1~1~5~5"
	                            autoSearch    ="N~N~N~N~false~false~N"
	                            paramList	  ="N~N~N~N
	                            				~branchCode:chr_ac_br_${_pageRef}
	                            					,currencyCode:chr_ac_cy_${_pageRef}
	                            					,glCode:chr_ac_gl_${_pageRef}
	                            					,cifCode:chr_ac_cif_${_pageRef}
	                            					,allowInternAcc:ACCEPT_INTRN_CHQ_${_pageRef}
	                            					,GL_TYPE:GL_TYPE_${_pageRef}
	                            					,_pageRef:pageRef_${_pageRef}
	                            				~branchCode:chr_ac_br_${_pageRef}
	                            					,currencyCode:chr_ac_cy_${_pageRef}
	                            					,glCode:chr_ac_gl_${_pageRef}
	                            					,cifCode:chr_ac_cif_${_pageRef}
	                            					,allowInternAcc:ACCEPT_INTRN_CHQ_${_pageRef}
	                            					,GL_TYPE:GL_TYPE_${_pageRef}
	                            					,_pageRef:pageRef_${_pageRef}
	                            				~N"
	                            parameter     ="ctsRequestCO.amfVO.BRANCH_CODE:chr_ac_br_${_pageRef}
	                            				 ,ctsRequestCO.paymentType:paymentType_${_pageRef}
	                            				 ,ctsRequestCO.requestCif:requestCif_${_pageRef}
	                            				~amfVO.CURRENCY_CODE:chr_ac_cy_${_pageRef}
	                            				 ,ctsRequestCO.paymentType:paymentType_${_pageRef}
	                            				 ,ctsRequestCO.requestCif:requestCif_${_pageRef}
	                            				~amfVO.GL_CODE:chr_ac_gl_${_pageRef}
	                            				 ,ctsRequestCO.paymentType:paymentType_${_pageRef}
	                            				 ,ctsRequestCO.requestCif:requestCif_${_pageRef}
	                            				~N~N~N~N"
	                            dependencySrc    ="${pageContext.request.contextPath}/path/requests/CtsRequestMaintAction_dependencyAccBranch
	                            				  ~${pageContext.request.contextPath}/path/requests/CtsRequestMaintAction_dependencyAccCurrency
	                            				  ~${pageContext.request.contextPath}/path/requests/CtsRequestMaintAction_dependencyAccGl
	                            				 ~N~N~N~N"
	                            dependency    ="chr_ac_br_${_pageRef}:ctsRequestCO.amfVO.BRANCH_CODE
	                            				 ,chr_ac_cy_${_pageRef}:ctsRequestCO.amfVO.CURRENCY_CODE
	                            				 ,chr_ac_gl_${_pageRef}:ctsRequestCO.amfVO.GL_CODE
	                            				 ,chr_ac_cif_${_pageRef}:ctsRequestCO.amfVO.CIF_SUB_NO
	                            				 ,lookuptxt_chr_ac_sl_${_pageRef}:ctsRequestCO.amfVO.SL_NO
	                            				 ,lookuptxt_chr_ac_add_ref_${_pageRef}:ctsRequestCO.amfVO.ADDITIONAL_REFERENCE
	                            				 ,chr_ac_desc_${_pageRef}:ctsRequestCO.amfVO.BRIEF_NAME_ENG
												~chr_ac_cy_${_pageRef}:ctsRequestCO.amfVO.CURRENCY_CODE
	                            				 ,chr_ac_gl_${_pageRef}:ctsRequestCO.amfVO.GL_CODE
	                            				 ,chr_ac_cif_${_pageRef}:ctsRequestCO.amfVO.CIF_SUB_NO
	                            				 ,lookuptxt_chr_ac_sl_${_pageRef}:ctsRequestCO.amfVO.SL_NO
	                            				 ,lookuptxt_chr_ac_add_ref_${_pageRef}:ctsRequestCO.amfVO.ADDITIONAL_REFERENCE
	                            				 ,chr_ac_desc_${_pageRef}:ctsRequestCO.amfVO.BRIEF_NAME_ENG
	                            				~chr_ac_gl_${_pageRef}:ctsRequestCO.amfVO.GL_CODE
	                            				 ,chr_ac_cif_${_pageRef}:ctsRequestCO.amfVO.CIF_SUB_NO
	                            				 ,lookuptxt_chr_ac_sl_${_pageRef}:ctsRequestCO.amfVO.SL_NO
	                            				 ,lookuptxt_chr_ac_add_ref_${_pageRef}:ctsRequestCO.amfVO.ADDITIONAL_REFERENCE
	                            				 ,chr_ac_desc_${_pageRef}:ctsRequestCO.amfVO.BRIEF_NAME_ENG
	                            				~N~N~N~N"
	                            actionName    ="N~N~N~N~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructLookup~N"
	                            searchElement ="N~N~N~N~N~N~N"
	                            afterDepEvent ="requestDetRrequest_AccAfterDep('chr_ac_br')~requestDetRrequest_AccAfterDep('chr_ac_cy')~requestDetRrequest_AccAfterDep('chr_ac_gl')~requestDetRrequest_AccAfterDep('chr_ac_cif')~requestDetRrequest_AccAfterDep('chr_ac_sl')~requestDetRrequest_AccAfterDep('chr_ac_add_ref')~N"
	                            onOk          ="N~N~N~N~requestDetRrequest_setAccountData('chr_ac_sl')~requestDetRrequest_setAccountData('chr_ac_add_ref')~N">
	                        </ps:account>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr id="requestInfoChargesTr_<ps:property value="_pageRef" escapeHtml="true"/>">
			<td colspan="19">
			  <div id="requestInfoChargesDiv_<ps:property value="_pageRef" escapeHtml="true"/>" class="collapsibleContainer collapsed" title="<ps:text name="Charges_key"/>">
			  	<div id="requestInfoCharges_<ps:property value="_pageRef" escapeHtml="true"/>" title="Charges_key"></div>		
			  </div>
			</td>
		</tr>
	</table>
</div>


<script type="text/javascript" >
$.struts2_jquery.require("ChargesMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/entitycharges/");
$(document).ready(onLoadChargesMaint);
</script>