<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<table align="center" class="ui-widget-content" width="100%">
	<tr>
		<td width="50%">
			<ps:hidden name="fomCO.fomPassportInfoLoaded" id="fomPassportInfoLoaded_${_pageRef}"/>
			<div class="ui-state-active">&nbsp;<ps:label key="Passport_Information_I_key" /></div>	
			<table align="center" class="ui-widget-content" width="100%">
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label id="lbl_cifVO1_PASPORT_NO_${_pageRef}" key="Number_key" for="cifVO1_PASPORT_NO_${_pageRef}"/>
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASPORT_NO" maxlength="30" id="cifVO1_PASPORT_NO_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
						parameter="fomCO.cif1VO.PASPORT_NO:cifVO1_PASPORT_NO_${_pageRef}"
					    dependency="cifVO1_PASPORT_NO_${_pageRef}:fomCO.cif1VO.PASPORT_NO
					                ,lookuptxt_cif1VOCountryOfIssuance_${_pageRef}:fomCO.cif1VO.COUNTRY_OF_ISSUANCE
					                ,cif1VOCountryOfIssuanceDesc_${_pageRef}:fomCO.cif1VOCountryOfIssuanceDesc"
					    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_dependencyByPassportNumber"
						/>
					</td>
				</tr>
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE" id="cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE_${_pageRef},cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE,cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="true" dateLabelsKeys="Date_Of_Issuance_key,Hijri_key" />
						</td>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label id="lbl_cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}"  key="Date_Of_Issuance_key"  for="cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}"/>
						</td>
						<td class="fldDataEdit" colspan="3">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE" id="cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE_${_pageRef},cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE,cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="false"
						    />
						</td>
					</ps:else>
				</tr>
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label key="Place_Of_Issuance_key"  id="lbl_placeOfIssuance_${_pageRef}"  for="cifVO1_PASSPORT_ISSUE_PLACE_${_pageRef}" />
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASSPORT_ISSUE_PLACE" maxlength="30" id="cifVO1_PASSPORT_ISSUE_PLACE_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" />
					</td>
				</tr>
				<tr>
					<td class="fldLabelView"  style="padding-left: 5px;">
						<ps:label key="Country_Of_Issuance_key" id="lbl_cif1VOCountryOfIssuance_${_pageRef}" for="lookuptxt_cif1VOCountryOfIssuance_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch  name="fomCO.cif1VO.COUNTRY_OF_ISSUANCE" id="cif1VOCountryOfIssuance_${_pageRef}" 
						    resultList="LONG_DESC_ENG:cif1VOCountryOfIssuanceDesc_${_pageRef}" 
						    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
						    searchElement="COUNTRY_CODE"  autoSearch="true" maxlength="3" mode="number" minValue="0"
						    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
						    dependency="lookuptxt_cif1VOCountryOfIssuance_${_pageRef}:countriesVO.COUNTRY_CODE
						    ,cif1VOCountryOfIssuanceDesc_${_pageRef}:countriesVO.BRIEF_DESC_ENG"
						    parameter="COUNTRY_CODE:lookuptxt_cif1VOCountryOfIssuance_${_pageRef}"   
							readOnlyMode="${_recReadOnly}" relatedDescElt="cif1VOCountryOfIssuanceDesc_${_pageRef}"
								/>	
					</td>
					<td>
						 <ps:textfield name="fomCO.cif1VOCountryOfIssuanceDesc" id="cif1VOCountryOfIssuanceDesc_${_pageRef}" disabled="true" />
					</td>
				</tr>				
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4" rowspan="1">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE" id="cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="true" dateLabelsKeys="Expiry_Date_key,Hijri_key"/>
						</td>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label id="lbl_cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}" key="Expiry_Date_key" for="cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}" />
						</td>
						<td class="fldDataEdit" colspan="3">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE" id="cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="false"
							/>
						</td>
					</ps:else>
				</tr>
			</table>
			
		</td>
		<td width="50%">
		
			<div class="ui-state-active">&nbsp;<ps:label key="Passport_Information_II_key" /></div>	
			<table align="center" class="ui-widget-content" width="100%">
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label id="lbl_cifVO1_PASSPORT_NO2_${_pageRef}" key="Number_key" for="cifVO1_PASSPORT_NO2_${_pageRef}" />
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASSPORT_NO2" maxlength="30" id="cifVO1_PASSPORT_NO2_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="fomCO.cif1VO.PASSPORT_NO2:cifVO1_PASSPORT_NO2_${_pageRef}"
						    dependency="cifVO1_PASSPORT_NO2_${_pageRef}:fomCO.cif1VO.PASSPORT_NO2
						                ,lookuptxt_cifVO1CountryOfIssuance2_${_pageRef}:fomCO.cif1VO.COUNTRY_OF_ISSUANCE2
					                    ,cif1VOCountryOfIssuance2Desc_${_pageRef}:fomCO.cif1VOCountryOfIssuance2Desc"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_dependencyByPassportNumber2"
						 />
					</td>
				</tr>
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4" rowspan="1">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE2" id="cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="true" dateLabelsKeys="Date_Of_Issuance_key,Hijri_key"/>
						</td>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label id="lbl_cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}"  key="Date_Of_Issuance_key" for="cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}" />
						</td>
						<td class="fldDataEdit" colspan="3">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE2" id="cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="false"/>
						</td>
					</ps:else>	
				</tr>
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label key="Place_Of_Issuance_key"  id="lbl_placeOfIssuance2_${_pageRef}"  for="cifVO1_PASSPORT_ISSUE_PLACE2_${_pageRef}" />
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASSPORT_ISSUE_PLACE2" maxlength="30" id="cifVO1_PASSPORT_ISSUE_PLACE2_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" />
					</td>
				</tr>
				<tr>
					<td class="fldLabelView"  style="padding-left: 5px;">
						<ps:label key="Country_Of_Issuance_key" id="lbl_cifVO1CountryOfIssuance2_${_pageRef}" for="lookuptxt_cifVO1CountryOfIssuance2_${_pageRef}"/>					
					</td>
					<td>
						<psj:livesearch  name="fomCO.cif1VO.COUNTRY_OF_ISSUANCE2" id="cifVO1CountryOfIssuance2_${_pageRef}" 
						    resultList="LONG_DESC_ENG:cif1VOCountryOfIssuance2Desc_${_pageRef}" 
						    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
						    searchElement="COUNTRY_CODE"  autoSearch="true" maxlength="3" mode="number" minValue="0"
						    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
						    dependency="lookuptxt_cifVO1CountryOfIssuance2_${_pageRef}:countriesVO.COUNTRY_CODE,cif1VOCountryOfIssuance2Desc_${_pageRef}:countriesVO.BRIEF_DESC_ENG"
						    parameter="COUNTRY_CODE:lookuptxt_cifVO1CountryOfIssuance2_${_pageRef}"   
							readOnlyMode="${_recReadOnly}" relatedDescElt="cif1VOCountryOfIssuance2Desc_${_pageRef}"
								/>	
					</td>
					<td>
						 <ps:textfield name="fomCO.cif1VOCountryOfIssuance2Desc" id="cif1VOCountryOfIssuance2Desc_${_pageRef}" disabled="true" />
					</td>
				</tr>				
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4" rowspan="1">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE2" id="cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="true" dateLabelsKeys="Expiry_Date_key,Hijri_key"/>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label id="lbl_cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}" key="Expiry_Date_key" for="cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}" />
						</td>
						<td class="fldDataEdit" colspan="3">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE2" id="cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE2_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE2_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="false"/>
					</ps:else>
				</tr>
			</table>
			
		</td>
	</tr>
	<tr>
		<td>
		
			<div class="ui-state-active">&nbsp;<ps:label key="Passport_Information_III_key" /></div>	
			<table align="center" class="ui-widget-content" width="100%">
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label  id="lbl_cifVO1_PASSPORT_NO3_${_pageRef}" key="Number_key" for="cifVO1_PASSPORT_NO3_${_pageRef}"/>
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASSPORT_NO3" maxlength="30" id="cifVO1_PASSPORT_NO3_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="fomCO.cif1VO.PASSPORT_NO3:cifVO1_PASSPORT_NO3_${_pageRef}"
						    dependency="cifVO1_PASSPORT_NO3_${_pageRef}:fomCO.cif1VO.PASSPORT_NO3
						                ,lookuptxt_cifVO1CountryOfIssuance3_${_pageRef}:fomCO.cif1VO.COUNTRY_OF_ISSUANCE3
					                    ,cif1VOCountryOfIssuance3Desc_${_pageRef}:fomCO.cif1VOCountryOfIssuance3Desc"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_dependencyByPassportNumber3"
						/>
					</td>
				</tr>
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4" rowspan="1">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE3" id="cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="true" dateLabelsKeys="Date_Of_Issuance_key,Hijri_key"/>
						</td>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label   id="lbl_cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}" key="Date_Of_Issuance_key" for="cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}"/>
						</td>
						<td class="fldDataEdit" colspan="3">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_ISSUE_DATE3" id="cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" 
							parameter="cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}"
						    dependency="cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportIssueDate"
						    showHijri="false"/>
						</td>
					</ps:else>	
				</tr>
				<tr>
					<td class="fldLabelView" width="20%" style="padding-left: 5px;">
						<ps:label key="Place_Of_Issuance_key"  id="lbl_placeOfIssuance3_${_pageRef}"  for="cifVO1_PASSPORT_ISSUE_PLACE3_${_pageRef}" />
					</td>
					<td colspan="3">
						<ps:textfield name="fomCO.cif1VO.PASSPORT_ISSUE_PLACE3" maxlength="30" id="cifVO1_PASSPORT_ISSUE_PLACE3_${_pageRef}" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}" />
					</td>
				</tr>
					<tr>
					<td class="fldLabelView"  style="padding-left: 5px;">
						<ps:label key="Country_Of_Issuance_key" id="lbl_cifVO1CountryOfIssuance3_${_pageRef}" for="lookuptxt_cifVO1CountryOfIssuance3_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch  name="fomCO.cif1VO.COUNTRY_OF_ISSUANCE3" id="cifVO1CountryOfIssuance3_${_pageRef}" 
						    resultList="LONG_DESC_ENG:cif1VOCountryOfIssuance3Desc_${_pageRef}" 
						    actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
						    searchElement="COUNTRY_CODE"  autoSearch="true" maxlength="3" mode="number" minValue="0"
						    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
						    dependency="lookuptxt_cifVO1CountryOfIssuance3_${_pageRef}:countriesVO.COUNTRY_CODE,cif1VOCountryOfIssuance3Desc_${_pageRef}:countriesVO.BRIEF_DESC_ENG"
						    parameter="COUNTRY_CODE:lookuptxt_cifVO1CountryOfIssuance3_${_pageRef}"   
							readOnlyMode="${_recReadOnly}" relatedDescElt="cif1VOCountryOfIssuance3Desc_${_pageRef}"
								/>	
					</td>
					<td>
						 <ps:textfield name="fomCO.cif1VOCountryOfIssuance3Desc" id="cif1VOCountryOfIssuance3Desc_${_pageRef}" disabled="true" />
					</td>
				</tr>				
				<tr>
					<ps:if test="${_maintainHijriDate}">
						<td class="fldDataEdit" colspan="4" rowspan="1">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE3" id="cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="true" dateLabelsKeys="Expiry_Date_key,Hijri_key"/>
						</td>
					</ps:if>
					<ps:else>
						<td class="fldLabelView" width="20%" style="padding-left: 5px;">
							<ps:label id="lbl_cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}" key="Expiry_Date_key" for="cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}"/>
						</td>
						<td class="fldDataEdit" colspan="3" rowspan="2">
							<psj:datepicker name="fomCO.cif1VO.PASSPORT_EXPIRY_DATE3" id="cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}" buttonImageOnly="true" readonly="${_nameAddressTabPassportDetailsReadOnlyMode}"
							parameter="cifVO1.PASSPORT_EXPIRY_DATE:cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef},cifVO1.PASSPORT_ISSUE_DATE:cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}"
						    dependency="cifVO1_PASSPORT_EXPIRY_DATE3_${_pageRef}:cifVO1.PASSPORT_EXPIRY_DATE,cifVO1_PASSPORT_ISSUE_DATE3_${_pageRef}:cifVO1.PASSPORT_ISSUE_DATE"
						    dependencySrc="${pageContext.request.contextPath}/path/fom/FOMValidate_validatePassportExpiryDate"
						    showHijri="false"
							/>
						</td>
					</ps:else>	
				</tr>
			</table>
		</td>
		<td></td>
	</tr>
	
	</table>