<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>


<ps:hidden id="_addressPageRef_${_pageRef}" name="_addressPageRef" />
<ps:hidden id="addressCO_LINE_NO_${_addressPageRef}" name="addressCO.LINE_NO" />
<ps:hidden id="_addressPageRef_${_addressPageRef}" name="_addressPageRef" />
<ps:hidden id="addressCO_CIF_NO_${_addressPageRef}" name="addressCO.CIF_NO" />
<ps:hidden id="addressCO_SCREEN_NAME_${_addressPageRef}" name="addressCO.screenName" />

<ps:hidden id="moreAddress_screenMode_${_addressPageRef}" value="${_addressReadOnlyMode}" />
<ps:hidden id="addressCO_accesByTeller_${_addressPageRef}" name="addressCO.accesByTeller" />
<ps:hidden id="moreAddress_ivCrud_${_addressPageRef}" value="${iv_crud}" />
<ps:hidden id="moreAddress_SCREEN_NAME_${_addressPageRef}" value="${callingScreen}" />
<ps:hidden id="moreAddress_PageRef" value="${_addressPageRef}" />
<ps:hidden id="screenLang_${_addressPageRef}" name="screenLang" />
<ps:hidden id="forceAfterDepEvent_${_addressPageRef}" name="true" />



<table  id="addrTbl_${_addressPageRef}" border="0" align="center" class="ui-widget-content" width="100%">
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
					<td colspan="4" valign="top">
					<ps:hidden name="addressCO.addrScreenLang" id="addressCO_addrScreenLang_${_addressPageRef}" />
							<table border="0" width="100%" >
							<tr>
									<td width="25%"></td>
									<td width="20%"></td>
									<td width="20%"></td>
									<td width="35%"></td>
									
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
										_pageRef:pageRef_${_pageRef}"
									readOnlyMode="${_addressReadOnlyMode}"
									afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}')"
								/>
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.countryDesc" id="addressCO_countryDesc_${_addressPageRef}" disabled="true"/>
								</td>
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
					                	parameter="COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},callingScreen:addressCO_SCREEN_NAME_${_addressPageRef},callingField:addressCO_REGION_depCall_${_addressPageRef},screenReference:_addressPageRef_${_addressPageRef},_pageRef:pageRef_${_pageRef},_forceAfterDepEvent:forceAfterDepEvent_${_addressPageRef}"
					                    dependency="lookuptxt_addressCO_REGION_${_addressPageRef}:countriesRegionVO.REGION_CODE,addressCO_regionDesc_${_addressPageRef}:countriesRegionVO.BRIEF_DESC_ENG"
					               		afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}')"
					               		readOnlyMode="${_addressReadOnlyMode}"
					               	/>
								</td>
								<td class="fldDataEdit center"  colspan="2">
									<ps:textfield name="addressCO.regionDesc" id="addressCO_regionDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							</table>
							<table border="0" width="100%" id="addressSectionTbl_Id_ENG_${_addressPageRef}">
								<tr>
									<td width="25%"></td>
									<td width="20%"></td>
									<td width="20%"></td>
									<td width="35%"></td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="governerate_key" id="lbl_addressCO_GOVERNERATE_ENG_${_addressPageRef}" for="addressCO_GOVERNERATE_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.GOVERNERATE_ENG" id="addressCO_GOVERNERATE_ENG_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										/>	
									</td>
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="state_key" id="lbl_addressCO_STATE_ENG_${_addressPageRef}" for="addressCO_STATE_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.STATE_ENG" id="addressCO_STATE_ENG_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
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
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="avenue_key" id="lbl_addressCO_ADDRESS3_ENG_KYC_${_addressPageRef}" for="addressCO_ADDRESS3_ENG_KYC_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS3_ENG" id="addressCO_ADDRESS3_ENG_KYC_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="Address_Eng_key" id="lbl_addressCO_ADDRESS1_ENG_${_addressPageRef}"  for="addressCO_ADDRESS1_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS1_ENG" id="addressCO_ADDRESS1_ENG_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
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
											/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_Details_Eng_key" id="lbl_addressCO_STREET_DETAILS_ENG_${_addressPageRef}" for="addressCO_STREET_DETAILS_ENG_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.STREET_DETAILS_ENG" id="addressCO_STREET_DETAILS_ENG_${_addressPageRef}" maxlength="40" 
											readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr>
									<td colspan="4"></td>
								</tr>
							</table>
							<table style="direction:rtl;" border="0" width="100%" id="addressSectionTbl_Id_ARAB_${_addressPageRef}">
								<tr>
									<td width="25%"></td>
									<td width="20%"></td>
									<td width="20%"></td>
									<td width="35%"></td>
									
								</tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="governerate_arab_key" id="lbl_addressCO_GOVERNERATE_ARAB_${_addressPageRef}" for="addressCO_GOVERNERATE_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.GOVERNERATE_ARAB" id="addressCO_GOVERNERATE_ARAB_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
								</tr>
								<tr>
								<tr>
									<td class="fldLabelView">
										<ps:label key="state_arab_key" id="lbl_addressCO_STATE_ARAB_${_addressPageRef}" for="addressCO_STATE_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.STATE_ARAB" id="addressCO_STATE_ARAB_${_addressPageRef}" maxlength="40" 
										readonly="${_addressReadOnlyMode}"
										/>	
									</td>
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Street_Arb_key" id="lbl_addressCO_ADDRESS2_ARAB_${_addressPageRef}" for="addressCO_ADDRESS2_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS2_ARAB" id="addressCO_ADDRESS2_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Jada_Arb_key" id="lbl_addressCO_ADDRESS3_ARAB_${_addressPageRef}" for="addressCO_ADDRESS3_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS3_ARAB" id="addressCO_ADDRESS3_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="Block_Arb_key" id="lbl_addressCO_ADDRESS1_ARAB_${_addressPageRef}" for="addressCO_ADDRESS1_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS1_ARAB" id="addressCO_ADDRESS1_ARAB_${_addressPageRef}" maxlength="50" 
										readonly="${_addressReadOnlyMode}"
										/>
									</td>
									<td></td>
								</tr>
								<tr >
									<td class="fldLabelView">
										<ps:label key="House_Building_Arb_key" id="lbl_addressCO_ADDRESS4_ARAB_${_addressPageRef}" for="addressCO_ADDRESS4_ARAB_${_addressPageRef}"/>
									</td>
									<td class="fldDataEdit" colspan="3">
										<ps:textfield name="addressCO.ADDRESS4_ARAB" id="addressCO_ADDRESS4_ARAB_${_addressPageRef}" maxlength="50" 
											readonly="${_addressReadOnlyMode}"
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
										/>
									</td>
									
								</tr>
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
									<ps:label key="Tel_key" id="lbl_addressCO_TEL_${_addressPageRef}" for="addressCO_TEL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.TEL" id="addressCO_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Work_Tel_key" id="lbl_addressCO_WORK_TEL_${_addressPageRef}" for="addressCO_WORK_TEL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.WORK_TEL" id="addressCO_WORK_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Mobile_key" id="lbl_addressCO_MOBILE_${_addressPageRef}" for="addressCO_MOBILE_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.MOBILE" id="addressCO_MOBILE_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Other_Tel_key" id="lbl_addressCO_OTHER_TEL_${_addressPageRef}" for="addressCO_OTHER_TEL_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.OTHER_TEL" id="addressCO_OTHER_TEL_${_addressPageRef}" readonly="${_addressReadOnlyMode}" maxlength="23"
									/>
								</td>
								
							</tr>
							<tr>
								<td class="fldLabelView">
									<ps:label key="Fax_key" id="lbl_addressCO_FAX_${_addressPageRef}" for="addressCO_FAX_${_addressPageRef}"/>
								</td>
								<td class="fldDataEdit" colspan="3">
									<ps:textfield name="addressCO.FAX" id="addressCO_FAX_${_addressPageRef}"
									readonly="${_addressReadOnlyMode}" maxlength="23"
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
									readonly="${_addressReadOnlyMode}" maxlength="255" onchange="validateEmail('%{_addressPageRef}')"
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
					                	afterDepEvent="reSetOriginalPageRefToSession('${_addressPageRef}')"
					                />
								</td>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.poBoxAreaDesc" id="addressCO_poBoxAreaDesc_${_addressPageRef}" disabled="true"
									readonly="${_addressReadOnlyMode}"
									/>
								</td>
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
						                	parameter="POSTAL_CODE:lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef},REGION_CODE:lookuptxt_addressCO_REGION_${_addressPageRef},COUNTRY_CODE:lookuptxt_addressCO_COUNTRY_${_addressPageRef}"
						                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/PostalCodeDependencyAction_dependencyByPostalCode"
						                    dependency="addressCO_postalcodeDesc_${_addressPageRef}:postalCodeVO.BRIEF_NAME_ENG,lookuptxt_addressCO_POSTAL_CODE_${_addressPageRef}:postalCodeVO.POST_CODE"
						                />
						             </td>
								</ps:else>
								<td class="fldDataEdit center" colspan="2">
									<ps:textfield name="addressCO.postalcodeDesc" id="addressCO_postalcodeDesc_${_addressPageRef}" disabled="true"/>
								</td>
							</tr>
							<ps:hidden id="addressCO_PERM_ADDRESS_${_addressPageRef}" name="addressCO.permnAddrFlag"  />
							<ps:hidden id="addressCO_DEFAULT_ADD_${_addressPageRef}" name="addressCO.defaultAddrFlag"  />
							<ps:hidden id="ddressCO_PRINT_STAT_${_addressPageRef}" name="addressCO.printAddrFlag"  />
						</table>
					
					</td>
				</tr>
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
