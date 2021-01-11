<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<script type="text/javascript">
var moneyLaunderingTrendsDetl_key ="<ps:text name='moneyLaunderingTrendsDetl_key' />";
</script>

<ps:form id="incidentFormId_${_pageRef}" namespace="/path/incident"
	action="IncidentReportMaint_saveNew" useHiddenProps="true" cssStyle="width:98%;">
	<%-- Main Table --%>
	<table width="99%">
		<tr>
			<td class="ui-state-active" colspan="6"></td>
		</tr>
		<tr>
			<td width="70%">
				<table>
					<tr>
						<td width="14%">
							<ps:label key="code_key" for="obligoreCode_${_pageRef}" />
						</td>
						<td width="20%">
							<ps:textfield id="obligoreCode_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.OBLIGOR_CODE" mode="number"
								nbFormat="####" readonly="false" />
						</td>
						<td width="20%">
							<ps:label key="Additional_Reference_key"
								for="additionalRef_${_pageRef}" />
						</td>
						<td width="40%">
							<ps:textfield id="additionalRef_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.ADDITIONAL_REFERENCE" mode="text"
								nbFormat="####" readonly="false" />
						</td>

					</tr>

					<tr>
						<td>
							<ps:label key="Limit_key" for="limit_${_pageRef}" />
						</td>
						<td>
								<ps:textfield id="limit_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.LIMIT" mode="number"
								 readonly="false"/>
						</td>
						<td>
						<%--This is the :CURRENCIES.BRIEF_DESC_ENG FROM CURRENCIES WHERE COMP_CODE = #{loginCompCode} --%>
						    <ps:hidden id="currencyCode_${_pageRef}" 							name="dashOneObligorCO.currenciesVO.CURRENCY_CODE"/>
							<ps:textfield id="limitDesc_${_pageRef}"
								name="dashOneObligorCO.currenciesVO.BRIEF_DESC_ENG" mode="text"
								nbFormat="####" readonly="true" size="5px" />
						</td>
						<td>
						</td>

					</tr>
					<tr>
						<td>
							<ps:label key="estimatedGrossAmountOfCash_key"
								for="mlGrossAmount_${_pageRef}" />
						</td>
						<td>
						<%--This is the :CURRENCIES.BRIEF_DESC_ENG FROM CURRENCIES WHERE COMP_CODE = #{loginCompCode} --%>
							<ps:textfield id="mlGrossAmount_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.ML_GROSS_AMOUNT" mode="number"
								  readonly="false" />
						</td>
						<td>
							<ps:textfield id="mlGrossAmountDesc_${_pageRef}"
								name="dashOneObligorCO.currenciesVO.BRIEF_DESC_ENG" mode="text"
								nbFormat="####" readonly="true" size="5px" />
						</td>
						<td>
						</td>

					</tr>
				</table>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td class="ui-state-active" colspan="6"></td>
		</tr>
		<tr>
			<td width="50%">
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td width="17%">
							<ps:label key="brief_name_en_key"
								for="briefNameDescEng_${_pageRef}" />
						</td>
						<td width="27%">
							<ps:textfield id="briefNameDescEng_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.BRIEF_DESC_ENG" mode="text"
								nbFormat="####" readonly="false" />
						</td>
						<td width="27%">

						</td>
						<td width="">
						</td>
					</tr>
					<tr>
						<td>
							<ps:label key="long_name_en_key" for="longNameDescEng_${_pageRef}" />
						</td>
						<td colspan="2">
							<ps:textfield id="longNameDescEng_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.LONG_DESC_ENG" mode="text"
								nbFormat="####" readonly="false" />
						</td>

					</tr>
					<tr>
						<td>
						</td>
						<td>
						</td>
						<td>
							<ps:textfield id="briefDescArab_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.BRIEF_DESC_ARAB" mode="text"
								nbFormat="####" readonly="false" />
						</td>
						<td>
							<ps:label key="Brief_Name_Arab_key" for="briefDescArab_${_pageRef}" />
						</td>

					</tr>
					<tr>
						<td>
						</td>
						<td colspan="2">
							<ps:textfield id="longDescArab_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.LONG_DESC_ARAB" mode="text"
								nbFormat="####" readonly="false" />
						</td>
						<td>
							<ps:label key="Long_Name_Arab_key" for="longDescArab_${_pageRef}" />
						</td>
					</tr>
				</table>

			</td>
		</tr>
		<tr>
			<td class="ui-state-active" colspan="6"></td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td width="13%">
							<ps:label key="Credit_Rating_key"
								for="lookuptxt_creditRating_${_pageRef}" />
						</td>
						<td width="20%">
							<psj:livesearch id="creditRating_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.CREDIT_RATING" mode="number"
								actionName="${pageContext.request.contextPath}/pathdesktop/UserLookup_constructLookup"
								searchElement="USER_ID"
								resultList="userDesc:userDesc_${_pageRef},lookuptxt_userId_${_pageRef}:userId_${_pageRef}"
									readOnlyMode="${_recReadOnly}" maxlength="8" autoSearch="false"
								parameter="dashOneObligorCO.ctsIncidentVO.USER_ID:lookuptxt_userId_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/path/incident/IncidentReportMaint_dependencyByUserId"
								dependency="lookuptxt_userId_${_pageRef}:dashOneObligorCO.ctsIncidentVO.USER_ID,userDesc_${_pageRef}:dashOneObligorCO.userDesc">
							</psj:livesearch>
						</td>
						<td width="10%">
							<ps:textfield id="creditRatingDesc_${_pageRef}"
								name="dashOneObligorCO.creditRatingVO.BRIEF_NAME_ENG" mode="text"
								nbFormat="####" readonly="true" size="5px" />
						</td>
						<td width="5%" >


						</td>
						<td width="10%">
							<ps:label key="profile_key" for="lookuptxt_profile_${_pageRef}" />
						</td>
						<td width="20%">
							<psj:livesearch id="profile_${_pageRef}"
								name="dashOneObligorCO.rifOBTVO.PROFILE" mode="number"
								actionName="${pageContext.request.contextPath}/pathdesktop/UserLookup_constructLookup"
								searchElement="USER_ID"
								resultList="userDesc:userDesc_${_pageRef},lookuptxt_userId_${_pageRef}:userId_${_pageRef}"
								readOnlyMode="${_recReadOnly}" maxlength="8" autoSearch="false"
								parameter="dashOneObligorCO.ctsIncidentVO.USER_ID:lookuptxt_userId_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/path/incident/IncidentReportMaint_dependencyByUserId"
								dependency="lookuptxt_userId_${_pageRef}:dashOneObligorCO.ctsIncidentVO.USER_ID,userDesc_${_pageRef}:dashOneObligorCO.userDesc">
							</psj:livesearch>

						</td>
						<td width="10%">
							<ps:textfield id="profileDesc_${_pageRef}"
								name="dashOneObligorCO.cifProfileVO.BRIEF_NAME_ENG" mode="text"
								nbFormat="####" readonly="true" size="5px" />
						</td>
					</tr>
					<tr>
						<td>
						  <ps:label key="Comments_key" for="commment_${_pageRef}" />
						</td>
						<td colspan="6">
						<ps:textarea id="commment_${_pageRef}" name="dashOneObligorCO.rifOBTVO.COMENT" dir="rtl" maxlength="100" rows="5" readonly="false" ></ps:textarea>
						</td>

					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td class="ui-state-active" colspan="6"></td>
		</tr>
	</table>
	<%--Main Table --%>
	<div id="oneObligorTrendsDetlsDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>"></div>
	<ptt:toolBar id="oneobligorToolBar_${_pageRef}" hideInAlert="true">
		<psj:submit id="onObligore_moneyLauderingShowDetls_${_pageRef}" button="true"
			freezeOnSubmit="true" 
			onclick="oneObligor_showObligorTrendsDetls()">
			<ps:label key="moneyLaunderingTrendsDetl_key" for="onObligore_moneyLauderingShowDetls_${_pageRef}" />
		</psj:submit>
	</ptt:toolBar>
</ps:form>
<script type="text/javascript">
$.struts2_jquery.require("DashOneObligorMaint.js", null, jQuery.contextPath	+ "/businesscommon/js/global360view/oneobligor/");
var oneObligorKey = "<ps:text name='One_Obligor_key'/>" ;
</script>

