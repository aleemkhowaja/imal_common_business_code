<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>


<ps:hidden id="_addressPageRef_${_pageRef}" name="_addressPageRef" />
<ps:hidden id="addressCO_LINE_NO_${_addressPageRef}" name="addressCO.LINE_NO" />
<ps:hidden id="_addressPageRef_${_addressPageRef}" name="_addressPageRef" />
<ps:hidden id="addressCO_CIF_NO_${_addressPageRef}" name="addressCO.CIF_NO" />
<ps:hidden id="addressCO_ACC_BR_${_addressPageRef}" name="addressCO.ACC_BR" />
<ps:hidden id="addressCO_SCREEN_NAME_${_addressPageRef}" name="addressCO.screenName" />

<ps:hidden id="moreAddress_screenMode_${_addressPageRef}" value="${_addressReadOnlyMode}" />
<ps:hidden id="addressCO_accesByTeller_${_addressPageRef}" name="addressCO.accesByTeller" />
<ps:hidden id="moreAddress_ivCrud_${_addressPageRef}" value="${iv_crud}" />
<ps:hidden id="moreAddress_SCREEN_NAME_${_addressPageRef}" value="${callingScreen}" />
<ps:hidden id="moreAddress_PageRef" value="${_addressPageRef}" />
<ps:hidden id="screenLang_${_addressPageRef}" name="screenLang" />
<ps:hidden id="forceAfterDepEvent_${_addressPageRef}" name="true" />



<table  id="addrTbl_<ps:property value="_addressPageRef" escapeHtml="true"/>" border="0" align="center" class="ui-widget-content" width="100%">
				<tr>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="5%"></td>
					<td width="5%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="3%"></td>
					<td width="10%"></td>
				</tr>
				
				<tr>
					<td colspan="9"></td>
					<td align="center"> 
						<ps:checkbox name="addressCO.printAddrFlag" id="addressCO_PRINT_STAT_${_addressPageRef}" disabled="${_addressReadOnlyMode}" />
					</td>
					<td class="fldLabelView">
						<ps:label key="Print_Statement__key" id="lbl_addressCO_PRINT_STAT_${_addressPageRef}" for="addressCO_PRINT_STAT_${_addressPageRef}"/>
					</td>
					<%--
					<td class="fldLabelView">
						<ps:label key="Area_key" id="lbl_addressCO_REGION_${_addressPageRef}" for="lookuptxt_addressCO_REGION_${_addressPageRef}"/>
					</td>
					<td class="fldDataEdit">
						<ps:hidden id="addressCO_REGION_depCall_${_addressPageRef}" value="REGION" />
						<psj:livesearch name="addressCO.REGION" id="addressCO_REGION_${_addressPageRef}"
		                    resultList="BRIEF_DESC_ENG:addressCO_regionDesc_${_addressPageRef}"
		                    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesRegion_constructLookup" 
		                    searchElement="REGION_CODE" size="10" autoSearch="true" mode="number" maxlength="6"
		                    paramList="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
		                    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')" 
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesRegionDependencyAction_dependencyByRegionCode"
		                    dependency="addressCO_regionDesc_${_addressPageRef}:countriesRegionVO.BRIEF_DESC_ENG,lookuptxt_addressCO_REGION_${_addressPageRef}:countriesRegionVO.REGION_CODE"
		                	parameter="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},callingField:addressCO_REGION_depCall_${_addressPageRef},screenReference:_addressPageRef_${_addressPageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
		               		afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}')"
		               		readOnlyMode="${_addressReadOnlyMode}"
		               	/>
					</td>
					<td class="fldDataEdit center"  colspan="2">
						<ps:textfield name="addressCO.regionDesc" id="addressCO_regionDesc_${_addressPageRef}" disabled="true"/>
					</td>
					 --%>
				</tr>
				
				
				<tr>
					<td colspan="4" valign="top">
					<ps:hidden name="addressCO.addrScreenLang" id="addressCO_addrScreenLang_${_addressPageRef}" />
					<%-- 
						<ps:if test='%{addressCO.addrScreenLang!="A"}'>
					--%>
						
							<table border="0" width="100%" id="addressSectionTbl_Id_ENG_<ps:property value="_addressPageRef" escapeHtml="true"/>">
								<tr>
									<td width="25%"></td>
									<td width="20%"></td>
									<td width="20%"></td>
									<td width="35%"></td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Address_Description_Eng_key" id="lbl_addressCO_ADDRESS_DESC_${_addressPageRef}" for="addressCO_ADDRESS_DESC_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS_DESC" id="addressCO_ADDRESS_DESC_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Contact_Name_Eng_key" id="lbl_addressCO_CONTACT_NAME_${_addressPageRef}" for="addressCO_CONTACT_NAME_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.CONTACT_NAME" id="addressCO_CONTACT_NAME_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Salutation_Eng_key" id="lbl_addressCO_SALUTATION_ENG_${_addressPageRef}" for="addressCO_SALUTATION_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.SALUTATION_ENG" id="addressCO_SALUTATION_ENG_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Block_key" id="lbl_addressCO_ADDRESS1_ENG_${_addressPageRef}"  for="addressCO_ADDRESS1_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS1_ENG" id="addressCO_ADDRESS1_ENG_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
					                	parameter="fomCO.addressField:addressCO_ADDRESS1_ENG_${_addressPageRef}"
					                    dependency="addressCO_ADDRESS1_ENG_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_key" id="lbl_addressCO_ADDRESS2_ENG_${_addressPageRef}" for="addressCO_ADDRESS2_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS2_ENG" id="addressCO_ADDRESS2_ENG_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
					                	parameter="fomCO.addressField:addressCO_ADDRESS2_ENG_${_addressPageRef}"
					                    dependency="addressCO_ADDRESS2_ENG_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Jada_key" id="lbl_addressCO_ADDRESS3_ENG_${_addressPageRef}" for="addressCO_ADDRESS3_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS3_ENG" id="addressCO_ADDRESS3_ENG_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
					                	parameter="fomCO.addressField:addressCO_ADDRESS3_ENG_${_addressPageRef}"
					                    dependency="addressCO_ADDRESS3_ENG_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="House_Building_key" id="lbl_addressCO_ADDRESS4_ENG_${_addressPageRef}" for="addressCO_ADDRESS4_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS4_ENG" id="addressCO_ADDRESS4_ENG_${_addressPageRef}" maxlength="50" 
											readonly="${_addressReadOnlyMode}"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
						                	parameter="fomCO.addressField:addressCO_ADDRESS4_ENG_${_addressPageRef}"
						                    dependency="addressCO_ADDRESS4_ENG_${_addressPageRef}:fomCO.addressField"
											/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_Details_Eng_key" id="lbll_addressCO_STREET_DETAILS_ENG_${_addressPageRef}" for="addressCO_STREET_DETAILS_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.STREET_DETAILS_ENG" id="addressCO_STREET_DETAILS_ENG_${_addressPageRef}" maxlength="40" 
											readonly="${_addressReadOnlyMode}"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
						                	parameter="fomCO.addressField:addressCO_STREET_DETAILS_ENG_${_addressPageRef}"
						                    dependency="addressCO_STREET_DETAILS_ENG_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="City_Eng_key" id="lbl_addressCO_CITY_ENG_${_addressPageRef}" for="addressCO_CITY_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.CITY_ENG" id="addressCO_CITY_ENG_${_addressPageRef}" maxlength="40" 
											readonly="${_addressReadOnlyMode}"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
						                	parameter="fomCO.addressField:addressCO_CITY_ENG_${_addressPageRef}"
						                    dependency="addressCO_CITY_ENG_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Country_Eng_key" id="lbl_addressCO_GOVERNERATE_ENG_${_addressPageRef}" for="addressCO_GOVERNERATE_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.GOVERNERATE_ENG" id="addressCO_GOVERNERATE_ENG_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
								</tr>
								<tr>
									<td colspan="4"></td>
								</tr>
							</table>
					<%-- 	
						</ps:if>
						<ps:else>
					--%>
							<table style="direction:rtl;" border="0" width="100%" id="addressSectionTbl_Id_ARAB_<ps:property value="_addressPageRef" escapeHtml="true"/>">
								<tr>
									<td width="25%"></td>
									<td width="20%"></td>
									<td width="20%"></td>
									<td width="35%"></td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Contact_Name_Arab_key" id="lbl_addressCO_CONTACT_NAME_ARAB_${_addressPageRef}" for="addressCO_CONTACT_NAME_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.CONTACT_NAME_ARAB" id="addressCO_CONTACT_NAME_ARAB_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
										parameter="fomCO.addressField:addressCO_CONTACT_NAME_ARAB_${_addressPageRef}"
										dependency="addressCO_CONTACT_NAME_ARAB_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Salutation_Arab_key" id="lbl_addressCO_SALUTATION_ARAB_${_addressPageRef}" for="addressCO_SALUTATION_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.SALUTATION_ARAB" id="addressCO_SALUTATION_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
										parameter="fomCO.addressField:addressCO_SALUTATION_ARAB_${_addressPageRef}"
										dependency="addressCO_SALUTATION_ARAB_${_addressPageRef}:fomCO.addressField"
										/>
									</td>
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Block_Arb_key" id="lbl_addressCO_ADDRESS1_ARAB_${_addressPageRef}" for="addressCO_ADDRESS1_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS1_ARAB" id="addressCO_ADDRESS1_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
										parameter="fomCO.addressField:addressCO_ADDRESS1_ARAB_${_addressPageRef}"
										dependency="addressCO_ADDRESS1_ARAB_${_addressPageRef}:fomCO.addressField"										
										/>
									</td>
									<td></td>
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_Arb_key" id="lbl_addressCO_ADDRESS2_ARAB_${_addressPageRef}" for="addressCO_ADDRESS2_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS2_ARAB" id="addressCO_ADDRESS2_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Jada_Arb_key" id="lbl_addressCO_ADDRESS3_ARAB_${_addressPageRef}" for="addressCO_ADDRESS3_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS3_ARAB" id="addressCO_ADDRESS3_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl" 
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
										parameter="fomCO.addressField:addressCO_ADDRESS3_ARAB_${_addressPageRef}"
										dependency="addressCO_ADDRESS3_ARAB_${_addressPageRef}:fomCO.addressField"										
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="House_Building_Arb_key" id="lbl_addressCO_ADDRESS4_ARAB_${_addressPageRef}" for="addressCO_ADDRESS4_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS4_ARAB" id="addressCO_ADDRESS4_ARAB_${_addressPageRef}" maxlength="50" 
											readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
											parameter="fomCO.addressField:addressCO_ADDRESS4_ARAB_${_addressPageRef}"
											dependency="addressCO_ADDRESS4_ARAB_${_addressPageRef}:fomCO.addressField"											
											/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_Details_Arb_key" id="lbl_addressCO_STREET_DETAILS_ARAB_${_addressPageRef}" for="addressCO_STREET_DETAILS_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.STREET_DETAILS_ARAB" id="addressCO_STREET_DETAILS_ARAB_${_addressPageRef}" maxlength="40" 
											readonly="${_addressReadOnlyMode}"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
											parameter="fomCO.addressField:addressCO_STREET_DETAILS_ARAB_${_addressPageRef}"
											dependency="addressCO_STREET_DETAILS_ARAB_${_addressPageRef}:fomCO.addressField"											
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="City_Arb_key" id="lbl_addressCO_CITY_ARAB_${_addressPageRef}" for="addressCO_CITY_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.CITY_ARAB" id="addressCO_CITY_ARAB_${_addressPageRef}" maxlength="40" 
											readonly="${_addressReadOnlyMode}" cssStyle="direction:rtl"
											dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
											parameter="fomCO.addressField:addressCO_CITY_ARAB_${_addressPageRef}"
											dependency="addressCO_CITY_ARAB_${_addressPageRef}:fomCO.addressField"											
										/>
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Country_Arab_key" id="lbl_addressCO_GOVERNERATE_ARAB_${_addressPageRef}" for="addressCO_GOVERNERATE_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.GOVERNERATE_ARAB" id="addressCO_GOVERNERATE_ARAB_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
										parameter="fomCO.addressField:addressCO_GOVERNERATE_ARAB_${_addressPageRef}"
										dependency="addressCO_GOVERNERATE_ARAB_${_addressPageRef}:fomCO.addressField"										
										/>
									</td>
								</tr>
								<tr>
									<td colspan="4"></td>
								</tr>
							</table>
					<%-- 
						</ps:else>
					--%>	
					</td>
					<td colspan="3" valign="top">
						<table border="0" width="100%">
							<tr>
								<td width="25%"></td>
								<td width="20%"></td>
								<td width="25%"></td>
								<td width="30%"></td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Home_Tel_key" id="lbl_addressCO_TEL_${_addressPageRef}" for="addressCO_TEL_${_addressPageRef}"/>
								</td>
								
								<ps:hidden id="hidden_tel_${_addressPageRef}" name="addressCO.HIDDEN_TEL"> </ps:hidden>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.TEL" id="addressCO_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23" dir="ltr"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Work_Tel_key" id="lbl_addressCO_WORK_TEL_${_addressPageRef}" for="addressCO_WORK_TEL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.WORK_TEL" id="addressCO_WORK_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"  dir="ltr"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Mobile_key" id="lbl_addressCO_MOBILE_${_addressPageRef}" for="addressCO_MOBILE_${_addressPageRef}"/>
								</td>
								<ps:hidden id="hidden_mobile_${_addressPageRef}" name="addressCO.HIDDEN_MOBILE"> </ps:hidden>
								<ps:hidden id="hidden_old_mobile_${_addressPageRef}" name="addressCO.OLD_MOBILE"> </ps:hidden>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.MOBILE" id="addressCO_MOBILE_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"  dir="ltr"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Other_Tel_key" id="lbl_addressCO_OTHER_TEL_${_addressPageRef}" for="addressCO_OTHER_TEL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.OTHER_TEL" id="addressCO_OTHER_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"  dir="ltr"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Fax_key" id="lbl_addressCO_FAX_${_addressPageRef}" for="addressCO_FAX_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.FAX" id="addressCO_FAX_${_addressPageRef}"
									readonly="${_addressReadOnlyMode}" maxlength="23"  dir="ltr"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Email_key" id="lbl_addressCO_EMAIL_${_addressPageRef}" for="addressCO_EMAIL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textarea name="addressCO.EMAIL" id="addressCO_EMAIL_${_addressPageRef}" 
									cssClass="textCompSize ui-state-focus ui-corner-all" cssStyle="height:50px;"
									readonly="${_addressReadOnlyMode}" maxlength="255"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
				                	parameter="fomCO.addressField:addressCO_EMAIL_${_addressPageRef}"
				                    dependency="addressCO_EMAIL_${_addressPageRef}:fomCO.addressField"
				                     onchange="validateEmail('%{_addressPageRef}')"
									/>
								</td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Telex_key" id="lbl_addressCO_TELEX_${_addressPageRef}" for="addressCO_TELEX_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textarea name="addressCO.TELEX" id="addressCO_TELEX_${_addressPageRef}" 
									cssClass="textCompSize ui-state-focus ui-corner-all" cssStyle="height:50px;"
									readonly="${_addressReadOnlyMode}" maxlength="255" 
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
				                	parameter="fomCO.addressField:addressCO_TELEX_${_addressPageRef}"
				                    dependency="addressCO_TELEX_${_addressPageRef}:fomCO.addressField"
				                    onchange = "validateTelex();"
									/>
								</td>
							</tr>
						</table>
					</td>
					<td colspan="4"  valign="top">
					
						<table border="0" width="100%">
							<tr>
								<td width="25%"></td>
								<td width="25%"></td>
								<td width="25%"></td>
								<td width="25%"></td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Area_key" id="lbl_addressCO_REGION_${_addressPageRef}" for="lookuptxt_addressCO_REGION_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit">
									<ps:hidden id="addressCO_REGION_depCall_${_addressPageRef}" value="REGION" />
									<psj:livesearch name="addressCO.REGION" id="addressCO_REGION_${_addressPageRef}"
					                    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesRegion_constructLookup" 
					                    searchElement="REGION_CODE" size="10" autoSearch="true" mode="number" maxlength="6"
					                    paramList="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
					                    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')" 
					                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesRegionDependencyAction_dependencyByRegionCode"
					                	parameter="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},
					                	callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},callingField:addressCO_REGION_depCall_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef},
					                	screenReference:_addressPageRef_${_addressPageRef},_pageRef:pageRef_${_pageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
					                    dependency="lookuptxt_addressCO_REGION_${_addressPageRef}:countriesRegionVO.REGION_CODE,addressCO_regionDesc_${_addressPageRef}:countriesRegionVO.BRIEF_DESC_ENG"
					               		afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}'),fomNameAddressLanguageDropDown_onChange('${_addressPageRef}')"
					               		readOnlyMode="${_addressReadOnlyMode}"
					               	/>
								</td>
								<td class="fldDataEdit center"  colspan="2">
									<ps:textfield name="addressCO.regionDesc" id="addressCO_regionDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Country_key" id="lbl_addressCO_COUNTRY_${_addressPageRef}" for="lookuptxt_addressCO_COUNTRY_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center">
								<psj:livesearch name="addressCO.COUNTRY" id="addressCO_COUNTRY_${_addressPageRef}"
								    resultList="LONG_DESC_ENG:addressCO_countryDesc_${_addressPageRef}"
								    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
								    searchElement="COUNTRY_CODE" size="10" autoSearch="true" maxlength="3" mode="number" 
								    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')" 
								    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
								    dependency="addressCO_countryDesc_${_addressPageRef}:countriesVO.LONG_DESC_ENG,
										lookuptxt_addressCO_COUNTRY_${_addressPageRef}:countriesVO.COUNTRY_CODE"
								    parameter="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},
										REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},
										POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},
										callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},
										screenReference:_addressPageRef_${_addressPageRef},
										_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef},
										cifLanguage:cifVO_LANGUAGE_${_pageRef},
										_pageRef:pageRef_${_pageRef},
										CIF_TYPE:lookuptxt_cifVO_CIF_TYPE_${_pageRef},
										fromAddressCountry:1,
										DEP_SRC:mainCountry"
									readOnlyMode="${_addressReadOnlyMode}"
									afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}'),fomNameAddressLanguageDropDown_onChange('${_addressPageRef}')"
								/>
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.countryDesc" id="addressCO_countryDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<tr >
								<td class="fldLabelView">
									<ps:label key="City_Code_key" id="lbl_addressCO_CITY_CODE_${_addressPageRef}" for="lookuptxt_addressCO_CITY_CODE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center">
									<psj:livesearch name="addressCO.CITY_CODE" id="addressCO_CITY_CODE_${_addressPageRef}"
					                    resultList="BRIEF_DESC_ENG:addressCO_cityDesc_${_addressPageRef}"
					                    actionName="${pageContext.request.contextPath}/pathdesktop/CityLookup_constructLookup" 
					                    searchElement="CITY_CODE" size="10" autoSearch="true" maxlength="4" mode="number" 
					                    paramList="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef}"
					                    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')"   
					                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CityDependencyAction_dependencyByCityCode"
					                    dependency="addressCO_cityDesc_${_addressPageRef}:citiesVO.BRIEF_DESC_ENG,lookuptxt_addressCO_CITY_CODE_${_addressPageRef}:citiesVO.CITY_CODE"
					                	parameter="CITY_CODE:lookuptxt_addressCO_CITY_CODE_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef},screenReference:_addressPageRef_${_addressPageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
					                	afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}'),fomNameAddressLanguageDropDown_onChange('${_addressPageRef}')"
					                	readOnlyMode="${_addressReadOnlyMode}"
					                />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.cityDesc" id="addressCO_cityDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<tr >
								<td class="fldLabelView">
									<ps:label key="Sector__key" id="lbl_addressCO_SECTOR_CODE_${_addressPageRef}" for="lookuptxt_addressCO_SECTOR_CODE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center">
									<psj:livesearch name="addressCO.SECTOR_CODE" id="addressCO_SECTOR_CODE_${_addressPageRef}"
					                    resultList="BRIEF_DESC_ENG:addressCO_sectorDesc_${_addressPageRef}"
					                    actionName="${pageContext.request.contextPath}/pathdesktop/SectorLookup_constructLookup" 
					                    searchElement="SECTOR_CODE" size="10" autoSearch="true" maxlength="4" mode="number" 
					                    paramList="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},CITY_CODE:lookuptxt_addressCO_CITY_CODE_${_addressPageRef}"
					                    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')"    
					                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/SectorDependencyAction_dependencyBySectorCode"
					                    dependency="addressCO_sectorDesc_${_addressPageRef}:sectorsVO.BRIEF_DESC_ENG,lookuptxt_addressCO_SECTOR_CODE_${_addressPageRef}:sectorsVO.SECTOR_CODE"
					                	parameter="SECTOR_CODE:lookuptxt_addressCO_SECTOR_CODE_${_addressPageRef},CITY_CODE:lookuptxt_addressCO_CITY_CODE_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
					                	afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}'),fomNameAddressLanguageDropDown_onChange('${_addressPageRef}')"
					                	readOnlyMode="${_addressReadOnlyMode}"
					                />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.sectorDesc" id="addressCO_sectorDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="P.O.Box_key" id="lbl_addressCO_POBOX_AREA_${_addressPageRef}" for="lookuptxt_addressCO_POBOX_AREA_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center" >
									<ps:hidden id="addressCO_POBOX_AREA_depCall_${_addressPageRef}" value="POBOX_AREA" />
									<psj:livesearch name="addressCO.POBOX_AREA" id="addressCO_POBOX_AREA_${_addressPageRef}"
					                    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesRegion_constructLookup" 
					                    searchElement="REGION_CODE" size="10" autoSearch="true" mode="number" maxlength="6" readOnlyMode="${_addressReadOnlyMode}"
					                    paramList="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
					                    beforeDepEvent="setCustomPageRefToSession('${_addressPageRef}')"   
					                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesRegionDependencyAction_dependencyByRegionCode"
					                    dependency="lookuptxt_addressCO_POBOX_AREA_${_addressPageRef}:countriesRegionVO.REGION_CODE
					                    			,addressCO_poBoxAreaDesc_${_addressPageRef}:countriesRegionVO.BRIEF_DESC_ENG
					                    			,lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}:,addressCO_postalcodeDesc_${_addressPageRef}:"
					                	parameter="REGION_CODE:lookuptxt_addressCO_POBOX_AREA_${_addressPageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef},callingField:addressCO_POBOX_AREA_depCall_${_addressPageRef},screenReference:_addressPageRef_${_addressPageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
					                	afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}'),fomNameAddressLanguageDropDown_onChange('${_addressPageRef}')"
					                />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.poBoxAreaDesc" id="addressCO_poBoxAreaDesc_${_addressPageRef}" disabled="true"
									readonly="${_addressReadOnlyMode}"
									/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.PO_BOX" id="addressCO_PO_BOX_${_addressPageRef}" maxlength="30" 
									readonly="${_addressReadOnlyMode}"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateSpecialCharInFields"
				                	parameter="fomCO.addressField:addressCO_PO_BOX_${_addressPageRef}"
				                    dependency="addressCO_PO_BOX_${_addressPageRef}:fomCO.addressField"
									/>
								</td>
								<td ></td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="" id="lbl_addressCO_POSTAL_CODE_${_addressPageRef}" for="lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}"/>
								</td>
								<ps:if test='%{addressCO.postalCodeType == "A"}'>
									<td class="fldDataEdit center" >
										<psj:livesearch name="addressCO.POSTAL_CODE1" id="addressCO_POSTAL_CODE_${_addressPageRef}"
						                    resultList="POST_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}"
						                    actionName="${pageContext.request.contextPath}/pathdesktop/PostalCodeLookup_constructLookup" 
						                    searchElement="POST_CODE" size="10" autoSearch="true" maxlength="10" readOnlyMode="${_addressReadOnlyMode}"
						                    paramList="regionCode:lookuptxt_addressCO_REGION_${_addressPageRef},countryCode:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
						                	parameter="POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
						                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/PostalCodeDependencyAction_dependencyByPostalCode"
						                    dependency="addressCO_postalcodeDesc_${_addressPageRef}:postalCodeVO.BRIEF_NAME_ENG,lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}:postalCodeVO.POST_CODE"
						                />
									</td>
								</ps:if>
								<ps:else>
									<td class="fldDataEdit center" >
										<psj:livesearch name="addressCO.POSTAL_CODE" id="addressCO_POSTAL_CODE_${_addressPageRef}"
						                    resultList="POST_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}"
						                    actionName="${pageContext.request.contextPath}/pathdesktop/PostalCodeLookup_constructLookup" 
						                    searchElement="POST_CODE" size="10" autoSearch="true" mode="number" maxlength="10" readOnlyMode="${_addressReadOnlyMode}"
						                    paramList="regionCode:lookuptxt_addressCO_REGION_${_addressPageRef},countryCode:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
						                	parameter="POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef}"
						                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/PostalCodeDependencyAction_dependencyByPostalCode"
						                    dependency="addressCO_postalcodeDesc_${_addressPageRef}:postalCodeVO.BRIEF_NAME_ENG,lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}:postalCodeVO.POST_CODE"
						                />
						             </td>
								</ps:else>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.postalcodeDesc" id="addressCO_postalcodeDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Address_Description_key" id="lbl_addressCO_ADDRESS_DESCRIPTION_${_addressPageRef}" for="lookuptxt_addressCO_ADDRESS_DESCRIPTION_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center" >
									<psj:livesearch name="addressCO.ADDRESS_DESCRIPTION" id="addressCO_ADDRESS_DESCRIPTION_${_addressPageRef}"
				                      resultList="BRIEF_DESC_ENG:fomCO_residenceTypeDesc_${_addressPageRef}"
				                      actionName="${pageContext.request.contextPath}/pathdesktop/ResidenceTypes_constructLookup" 
				                      searchElement="CODE"  autoSearch="false" size="10" mode="number" maxlength="3"
				                      
				                      dependencySrc="${pageContext.request.contextPath}/pathdesktop/ResidenceTypesDependencyAction_dependencyByCode"
				                      dependency="addressCO_residenceTypeDesc_${_addressPageRef}:residenceTypesVO.BRIEF_DESC_ENG,lookuptxt_addressCO_ADDRESS_DESCRIPTION_${_addressPageRef}:residenceTypesVO.CODE"
				                      parameter="residenceTypesSC.code:lookuptxt_addressCO_ADDRESS_DESCRIPTION_${_addressPageRef},cifLanguage:cifVO_LANGUAGE_${_pageRef}"
				                      readOnlyMode="${_addressReadOnlyMode}"
				                    />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.residenceTypeDesc" id="addressCO_residenceTypeDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<!-- MARIA proof of address -->
							<tr>
								<td class="fldLabelView">
									<ps:label key="Proof_of_Address_key" id="lbl_addressCO_PROF_ADDRESS_CODE_${_addressPageRef}" for="lookuptxt_addressCO_PROF_ADDRESS_CODE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit center" >
									<psj:livesearch name="addressCO.PROF_ADDRESS_CODE" id="addressCO_PROF_ADDRESS_CODE_${_addressPageRef}"
				                      resultList="BRIEF_DESC_ENG:addressCO_proofAddressDesc_${_addressPageRef}"
				                      actionName="${pageContext.request.contextPath}/pathdesktop/ProofAddressLookup_constructLookup" 
				                      searchElement="PROF_ADDRESS_CODE"  autoSearch="false" size="10" mode="number" maxlength="8"
				                      relatedDescElt="addressCO_proofAddressDesc_${_pageRef}"
				                      dependencySrc="${pageContext.request.contextPath}/pathdesktop/ProofAddressLookup_dependencyByProofAddressCode"
				                      dependency="addressCO_proofAddressDesc_${_addressPageRef}:ctsProofAddressVO.BRIEF_DESC_ENG,lookuptxt_addressCO_PROF_ADDRESS_CODE_${_addressPageRef}:ctsProofAddressVO.PROF_ADDRESS_CODE"
				                      parameter="PROF_ADDRESS_CODE:lookuptxt_addressCO_PROF_ADDRESS_CODE_${_addressPageRef}"
				                      readOnlyMode="${_addressReadOnlyMode}"
				                    />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.proofAddressDesc" id="addressCO_proofAddressDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
						</table>
					
					</td>
				</tr>
				<tr>
 					<td colspan="11" valign="top">
 						<table width="100%" border="0">
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
								<td class="fldLabelView">
									<ps:label key="Expiry_Date_key" id="lbl_addressCO_EXPIRY_DATE_${_addressPageRef}" for="addressCO_EXPIRY_DATE_${_addressPageRef}"/>
								</td>
							    <td class="fldDataEdit" colspan="2">
								    <psj:datepicker name="addressCO.EXPIRY_DATE" id="addressCO_EXPIRY_DATE_${_addressPageRef}" buttonImageOnly="true" 
								    readonly="${_addressReadOnlyMode}"
								    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionExpiryDate"
				                    dependency="addressCO_EXPIRY_DATE_${_addressPageRef}:addressCommonCO.EXPIRY_DATE"
				                    parameter="addressCommonCO.EXPIRY_DATE:addressCO_EXPIRY_DATE_${_addressPageRef}"
								    />
							    </td>
								<td class="fldLabelView">
									<ps:label key="From_Date_key" id="lbl_addressCO_FROM_DATE_${_addressPageRef}" for="addressCO_FROM_DATE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="2">
									<ps:hidden id="addressCO_FROM_DATE_depCall_${_addressPageRef}" value="FROM_DATE" />
									<psj:datepicker name="addressCO.FROM_DATE" id="addressCO_FROM_DATE_${_addressPageRef}" buttonImageOnly="true" 
									readonly="${_addressReadOnlyMode}"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDates"
				                    dependency="addressCO_FROM_DATE_${_addressPageRef}:addressCommonCO.FROM_DATE,addressCO_TO_DATE_${_addressPageRef}:addressCommonCO.TO_DATE"
				                    parameter="addressCommonCO.FROM_DATE:addressCO_FROM_DATE_${_addressPageRef},addressCommonCO.TO_DATE:addressCO_TO_DATE_${_addressPageRef},addressCommonCO.dependencyCallSource:addressCO_FROM_DATE_depCall_${_addressPageRef}"
									/>
								</td>
								<td class="fldLabelView">
									<ps:label key="To_Date_key" id="lbl_addressCO_TO_DATE_${_addressPageRef}" for="addressCO_TO_DATE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="2">
									<ps:hidden id="addressCO_TO_DATE_depCall_${_addressPageRef}" value="TO_DATE" />
									<psj:datepicker name="addressCO.TO_DATE" id="addressCO_TO_DATE_${_addressPageRef}" buttonImageOnly="true" 
									readonly="${_addressReadOnlyMode}"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDates"
				                    dependency="addressCO_FROM_DATE_${_addressPageRef}:addressCommonCO.FROM_DATE,addressCO_TO_DATE_${_addressPageRef}:addressCommonCO.TO_DATE"
				                    parameter="addressCommonCO.FROM_DATE:addressCO_FROM_DATE_${_addressPageRef},addressCommonCO.TO_DATE:addressCO_TO_DATE_${_addressPageRef},addressCommonCO.dependencyCallSource:addressCO_TO_DATE_depCall_${_addressPageRef}"
									/>
								</td>
								<td align="center" colspan="2">
									<ps:checkbox name="addressCO.permnAddrFlag" id="addressCO_PERM_ADDRESS_${_addressPageRef}" disabled="${_addressReadOnlyMode}" 
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressPermanentAddress?addressCommonCO.opt=${_addressPageRef}"
				                    dependency="addressCO_PERM_ADDRESS_${_addressPageRef}:addressCommonCO.permnAddrFlag"
				                    parameter="addressCommonCO.permnAddrFlag:addressCO_PERM_ADDRESS_${_addressPageRef},addressCommonCO.CIF_NO:addressCO_CIF_NO_${_addressPageRef},addressCommonCO.LINE_NO:addressCO_LINE_NO_${_addressPageRef}"
									key="Permanent_Address_key" 
									/>
								</td>
								<td align="center" colspan="2">
									<ps:checkbox name="addressCO.defaultAddrFlag" id="addressCO_DEFAULT_ADD_${_addressPageRef}" 
									disabled="${_addressReadOnlyMode}"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDefaultAddress?addressCommonCO.opt=${_addressPageRef}"
				                    dependency="addressCO_DEFAULT_ADD_${_addressPageRef}:addressCommonCO.defaultAddrFlag"
				                    parameter="addressCommonCO.defaultAddrFlag:addressCO_DEFAULT_ADD_${_addressPageRef},addressCommonCO.CIF_NO:addressCO_CIF_NO_${_addressPageRef},addressCommonCO.LINE_NO:addressCO_LINE_NO_${_addressPageRef}"
									key="Default_Address_key"
									/>
				                </td>
				                <td align="center" colspan="2">
									<ps:checkbox name="addressCO.eWalletFlag" id="addressCO_E_WALLET_${_addressPageRef}"
									dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionWalletAddress?addressCommonCO.opt=${_addressPageRef}"
				                    dependency="addressCO_E_WALLET_${_addressPageRef}:addressCommonCO.eWalletFlag"
				                    parameter="addressCommonCO.eWalletFlag:addressCO_E_WALLET_${_addressPageRef},addressCommonCO.CIF_NO:addressCO_CIF_NO_${_addressPageRef},addressCommonCO.LINE_NO:addressCO_LINE_NO_${_addressPageRef},_pageRef:pageRef_${_pageRef},screenReference:_addressPageRef_${_addressPageRef},addressCommonCO.cifVO.LANGUAGE:cifVO_LANGUAGE_${_pageRef},addressCommonCO.MOBILE:addressCO_MOBILE_${_addressPageRef},addressCommonCO.COUNTRY:lookuptxt_cifVO_COUNTRY_${_pageRef},addressCommonCO.REGION:lookuptxt_cifExtendedVO_region_ofBirth_${_pageRef}" 
									disabled="${_addressReadOnlyMode}" key="wallet_key"/>
				                </td>
							</tr>
 						</table>
 					</td>
 				</tr>
<%-- 
				<tr>
					<td align="center">
						<ps:checkbox name="addressCO.permnAddrFlag" id="addressCO_PERM_ADDRESS_${_addressPageRef}" disabled="${_addressReadOnlyMode}" 
						dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressPermanentAddress"
	                    dependency="addressCO_PERM_ADDRESS_${_addressPageRef}:addressCommonCO.permnAddrFlag"
	                    parameter="addressCommonCO.permnAddrFlag:addressCO_PERM_ADDRESS_${_addressPageRef},addressCommonCO.CIF_NO:addressCO_CIF_NO_${_addressPageRef},addressCommonCO.LINE_NO:addressCO_LINE_NO_${_addressPageRef}"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="Permanent_Address_key" id="lbl_addressCO_PERM_ADDRESS_${_addressPageRef}" for="addressCO_PERM_ADDRESS_${_addressPageRef}"/>
					</td>
					<td align="center">
						<ps:checkbox name="addressCO.defaultAddrFlag" id="addressCO_DEFAULT_ADD_${_addressPageRef}" 
						disabled="${_addressReadOnlyMode}" />
						
						<!-- dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDefaultAddress"
	                    dependency="addressCO_DEFAULT_ADD_${_addressPageRef}:addressCommonCO.defaultAddrFlag"
	                    parameter="addressCommonCO.defaultAddrFlag:addressCO_DEFAULT_ADD_${_addressPageRef},addressCommonCO.CIF_NO:addressCO_CIF_NO_${_addressPageRef},addressCommonCO.LINE_NO:addressCO_LINE_NO_${_addressPageRef}" -->
	                </td>
					<td class="fldLabelView">
						<ps:label key="Default_Address_key" id="lbl_addressCO_DEFAULT_ADD_${_addressPageRef}" for="addressCO_DEFAULT_ADD_${_addressPageRef}"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Expiry_Date_key" id="lbl_addressCO_EXPIRY_DATE_${_addressPageRef}" for="addressCO_EXPIRY_DATE_${_addressPageRef}"/>
					</td>
				    <td class="fldDataEdit" colspan="2">
					    <psj:datepicker name="addressCO.EXPIRY_DATE" id="addressCO_EXPIRY_DATE_${_addressPageRef}" buttonImageOnly="true" 
					    readonly="${_addressReadOnlyMode}"
					    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionExpiryDate"
	                    dependency="addressCO_EXPIRY_DATE_${_addressPageRef}:addressCommonCO.EXPIRY_DATE"
	                    parameter="addressCommonCO.EXPIRY_DATE:addressCO_EXPIRY_DATE_${_addressPageRef}"
					    />
				    </td>
					<td class="fldLabelView">
						<ps:label key="From_Date_key" id="lbl_addressCO_FROM_DATE_${_addressPageRef}" for="addressCO_FROM_DATE_${_addressPageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="2">
						<ps:hidden id="addressCO_FROM_DATE_depCall_${_addressPageRef}" value="FROM_DATE" />
						<psj:datepicker name="addressCO.FROM_DATE" id="addressCO_FROM_DATE_${_addressPageRef}" buttonImageOnly="true" 
						readonly="${_addressReadOnlyMode}"
						dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDates"
	                    dependency="addressCO_FROM_DATE_${_addressPageRef}:addressCommonCO.FROM_DATE,addressCO_TO_DATE_${_addressPageRef}:addressCommonCO.TO_DATE"
	                    parameter="addressCommonCO.FROM_DATE:addressCO_FROM_DATE_${_addressPageRef},addressCommonCO.TO_DATE:addressCO_TO_DATE_${_addressPageRef},addressCommonCO.dependencyCallSource:addressCO_FROM_DATE_depCall_${_addressPageRef}"
						/>
					</td>
					<td class="fldLabelView">
						<ps:label key="To_Date_key" id="lbl_addressCO_TO_DATE_${_addressPageRef}" for="addressCO_TO_DATE_${_addressPageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="2">
						<ps:hidden id="addressCO_TO_DATE_depCall_${_addressPageRef}" value="TO_DATE" />
						<psj:datepicker name="addressCO.TO_DATE" id="addressCO_TO_DATE_${_addressPageRef}" buttonImageOnly="true" 
						readonly="${_addressReadOnlyMode}"
						dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validateAddressSectionDates"
	                    dependency="addressCO_FROM_DATE_${_addressPageRef}:addressCommonCO.FROM_DATE,addressCO_TO_DATE_${_addressPageRef}:addressCommonCO.TO_DATE"
	                    parameter="addressCommonCO.FROM_DATE:addressCO_FROM_DATE_${_addressPageRef},addressCommonCO.TO_DATE:addressCO_TO_DATE_${_addressPageRef},addressCommonCO.dependencyCallSource:addressCO_TO_DATE_depCall_${_addressPageRef}"
						/>
					</td>
					<td></td>
				</tr>
--%>
		</table>
		

<script type="text/javascript">
var Invalid_Entry_key = "<ps:text name='Invalid_Entry_key'/>";
$.struts2_jquery.require("MoreAddress.js" ,null,jQuery.contextPath+"/businesscommon/js/address/");
</script>
<ps:if test='%{addressCO.addrScreenMode=="P"}'> <%/* Method called only if called from Popup */%> 
	<script type="text/javascript">
		moreAddress_onDocReady('${_addressPageRef}');// only called from popup
	</script>
</ps:if>
