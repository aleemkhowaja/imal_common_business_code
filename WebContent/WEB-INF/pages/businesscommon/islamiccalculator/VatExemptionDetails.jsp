<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
	<%--TP#396091;Roshin;27/04/2016	START	--%>									
								<tr>							
									<td colspan="4">
										<ps:checkbox name="islamicCalculatorEventMgmtCO.exemptedFromVatYn" id = "exemptedFromVatYn_${_pageRef}" key="exempted_From_VatYn_key" 
										onchange="onChangeExemptedFromVatYn();" valOpt="Y:N" cssClass="ui-widget-content checkboxheight" />
									</td>	
									<td class="fldLabelView" colspan="5">
										<ps:label key="VAT_Exemption_certificate_key"  id="lbl_VAT_Exemption_certificate_${_pageRef}" for="VATExemptioncertificate_${_pageRef}"/>
									</td>
									<td colspan="6">
										<ps:textfield id = "VATExemptioncertificate_${_pageRef}" name="islamicCalculatorEventMgmtCO.vatExemptionCertificateNo" maxlength="20"  />
									</td>		
									<td class="fldLabelView" colspan="2">
										<ps:label key="VAT_Exemption_ExpiryDate_key"  id="lbl_VAT_Exemption_ExpiryDate_${_pageRef}" for="vatExemptionExpiryDate_${_pageRef}"/>
									</td>
									<td>
										<psj:datepicker id="vatExemptionExpiryDate_${_pageRef}" name="islamicCalculatorEventMgmtCO.vatExemptionExpiryDate" 
										buttonImageOnly="true"  onchange="onChangeVatExemptionExpiryDate()"  />
									</td>
								</tr>
								<%--TP#396091;Roshin;27/04/2016	END	--%>
