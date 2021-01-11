<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>


<script type="text/javascript">
$.struts2_jquery.require("StatementOfAccountMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/reports/");
$(document).ready(function() {
	initLoadFunctions();
})
</script>


<ps:form id="statementOfAccountMaintForm_${_pageRef}" useHiddenProps="true" namespace="/path/reports">
	<ps:if test="#attr['showInfoBar']">
		<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
	</ps:if>


	<ps:hidden id="msg_code_${_pageRef}" name="reportsCO.rifMessageVO.MSG_CODE" />
	<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
	<ps:hidden id="_type_${_pageRef}" name="reportsCO._type" />

	<ps:hidden id="accDivison_${_pageRef}" value="0" />
	<ps:hidden id="accDepartement_${_pageRef}" value="0" />

	<ps:hidden id="trxChargesObjCode_${_pageRef}" name="trxMgntCO.ctstrsVO.OBJ_CODE" />
	<ps:hidden id="trxChargesCompCode_${_pageRef}" name="trxMgntCO.ctstrsVO.COMP_CODE" />
	<ps:hidden id="trxChargesBranchCode_${_pageRef}" name="trxMgntCO.ctstrsVO.BRANCH_CODE" />
	
	<fieldset class="ui-widget-content ui-corner-all">

		<fieldset class="ui-widget-content ui-corner-all">
			<legend><ps:text name="range_of_date_key"></ps:text></legend>
			<table>
				<tr>
					<td class="fldLabelView"><ps:label key="From_key" /></td>
					<td>
						<psj:datepicker id="from_date_${_pageRef}" name="reportsCO.from_date" buttonImageOnly="true"
							parameter="from_date:from_date_${_pageRef}
										,to_date:to_date_${_pageRef}
										,reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE:reportByDate_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_fromDateDependency"
							dependency="from_date_${_pageRef}:reportsCO.from_date,to_date_${_pageRef}:reportsCO.to_date"
						/>
						<psj:datepicker id="from_date_hijri_${_pageRef}" name="reportsCO.from_date_hijri" buttonImageOnly="true" 
							showOnlyHijri="true" showHijri="true" />
					</td>
					<td></td>
					<td class="fldLabelView"><ps:label key="To_key" /></td>
					<td>
						<psj:datepicker id="to_date_${_pageRef}" name="reportsCO.to_date" buttonImageOnly="true"
							parameter="to_date:to_date_${_pageRef}
										,from_date:from_date_${_pageRef}
										,reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE:reportByDate_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_toDateDependency"
							dependency="to_date_${_pageRef}:reportsCO.to_date"
						/>
						<psj:datepicker id="to_date_hijri_${_pageRef}" name="reportsCO.to_date_hijri" buttonImageOnly="true" 
							showOnlyHijri="true" showHijri="true"  />
					</td>
				</tr>
			</table>
		</fieldset>

	<ps:if test="%{reportsCO.isShowDateFormat()}">
		<fieldset id="date_format_fieldset_id_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>" class="ui-widget-content ui-corner-all" >
			<legend><ps:text name="date_format_key"></ps:text></legend>
			<table>
				<tr>
					<td class="fldLabelView"><ps:label id="gregoHijriDateList_lbl_${_pageRef}" key="by_key" for="gregoHijriDateList_${_pageRef}%{defaultGregoHijriDateList}" /></td>
					<td>
						<ps:radio id="gregoHijriDateList_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.SHOW_HIJRI_DATE"
							list="gregoHijriDateList" />
					</td>
				</tr>
			</table>
		</fieldset>
	</ps:if>


		<fieldset class="ui-widget-content ui-corner-all">
			<legend><ps:text name="company_n_branch_key"></ps:text></legend>
			<table>
				<tr>
					<td class="fldLabelView"><ps:label key="companyKey" /></td>
					<td>
						<psj:livesearch id="companyLkp_${_pageRef}" name="reportsCO.companiesVO.COMP_CODE"
							actionName="${pageContext.request.contextPath}/pathdesktop/CompaniesByUsrLookup_companyCurrLookup"
							resultList="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef},companiesVO.BRIEF_DESC_ENG:companyDesc_${_pageRef}"
							searchElement="" size="10" mode="number" maxlength="4"
							afterDepEvent="disEnableBranch()"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_companyDependency"
							parameter="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}" 
							dependency="lookuptxt_companyLkp_${_pageRef}:reportsCO.companiesVO.COMP_CODE,companyDesc_${_pageRef}:reportsCO.companiesVO.BRIEF_DESC_ENG,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,branchDesc_${_pageRef}:reportsCO.branchesVO.BRIEF_DESC_ENG"
						/>
					</td>
					<td>
						<ps:textfield id="companyDesc_${_pageRef}" name="reportsCO.companiesVO.BRIEF_DESC_ENG" 
							disabled="true"/>
					</td>
					<td class="fldLabelView"><ps:label key="branchKey" /></td>
					<td>
						<psj:livesearch id="branchLkp_${_pageRef}" name="reportsCO.branchesVO.BRANCH_CODE"
							actionName="${pageContext.request.contextPath}/pathdesktop/BranchesByUsrLookup_constructLookupByCompCode"
							resultList="BRANCH_CODE:lookuptxt_branchLkp_${_pageRef},BRIEF_DESC_ENG:branchDesc_${_pageRef}"
							paramList="compCode:lookuptxt_companyLkp_${_pageRef}"
							searchElement="" size="10" mode="number" maxlength="4"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_branchByCodeDependency"
							parameter="branchesVO.BRANCH_CODE:lookuptxt_branchLkp_${_pageRef},companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}"
							dependency="lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,accBrFrom_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,accBrTo_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,branchDesc_${_pageRef}:reportsCO.branchesVO.BRIEF_DESC_ENG"
						/>
					</td>
					<td>
						<ps:textfield id="branchDesc_${_pageRef}" name="reportsCO.branchesVO.BRIEF_DESC_ENG" 
							disabled="true" />
					</td>
				</tr>
			</table>
		</fieldset>


		<fieldset class="ui-widget-content ui-corner-all">
			<legend><ps:text name="range_of_account_key"></ps:text></legend>
			<table>
				<tr>
					<td>
						<ps:radio id="rangeByCriteria_${_pageRef}" name="reportsCO.rangeByCriteria" 
							list="rangeByCriteriaList" 
						/>
					</td>
				</tr>
			</table>

			<table id="criteriaIban_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>">
				<tr>
					<td class="fldLabelView"><ps:label id="fromIban_lbl_${_pageRef}" key="from_iban_key" for="lookuptxt_fromIban_${_pageRef}" /></td>
					<td>
						<psj:livesearch id="fromIban_${_pageRef}" name="reportsCO.amfVOFrom.IBAN_ACC_NO"
							actionName="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="branchCode:lookuptxt_branchLkp_${_pageRef},currencyCode:accCyFrom_${_pageRef},glCode:accGlFrom_${_pageRef},cifCode:accCifFrom_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="amfVO.IBAN_ACC_NO:lookuptxt_fromIban_${_pageRef}"
							onOk="onOkFromIban('onOk')"
							searchElement="" maxlength="35"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_fromIbanDependency"
							parameter="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}
										,amfVOFrom.IBAN_ACC_NO:lookuptxt_fromIban_${_pageRef}"
							dependency="lookuptxt_fromIban_${_pageRef}:reportsCO.amfVOFrom.IBAN_ACC_NO
										,accBrFrom_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyFrom_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE
										,accGlFrom_${_pageRef}:reportsCO.amfVOFrom.GL_CODE
										,accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO
										,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO
										,lookuptxt_toIban_${_pageRef}:reportsCO.amfVOTo.IBAN_ACC_NO
										,accBrTo_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyTo_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE
										,accGlTo_${_pageRef}:reportsCO.amfVOFrom.GL_CODE
										,accCifTo_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO
										,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOFrom.SL_NO"
						/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label id="toIban_lbl_${_pageRef}" key="to_iban_key" for="lookuptxt_toIban_${_pageRef}" /></td>
					<td>
						<psj:livesearch id="toIban_${_pageRef}" name="reportsCO.amfVOTo.IBAN_ACC_NO"
							actionName="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="branchCode:lookuptxt_branchLkp_${_pageRef},currencyCode:accCyTo_${_pageRef},glCode:accGlTo_${_pageRef},cifCode:accCifTo_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="amfVO.IBAN_ACC_NO:lookuptxt_toIban_${_pageRef}"
							onOk="onOkToIban('onOk')"
							searchElement="" maxlength="35"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_toIbanDependency"
							parameter="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}
										,amfVOFrom.IBAN_ACC_NO:lookuptxt_fromIban_${_pageRef}
										,amfVOTo.IBAN_ACC_NO:lookuptxt_toIban_${_pageRef}"
							dependency="lookuptxt_toIban_${_pageRef}:reportsCO.amfVOTo.IBAN_ACC_NO
										,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accBrTo_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyTo_${_pageRef}:reportsCO.amfVOTo.CURRENCY_CODE
										,accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE
										,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO
										,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO"
						/>
					</td>
				</tr>
			</table>
			
			<table id="criteriaAccount_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>">
				<tr>
					<td class="fldLabelView"><ps:label id="lbl_accBrFrom_${_pageRef}" key="from_Acc" for="tbl_pathAccount_fromAccount_${_pageRef}" /></td>
					<td colspan="2">
						<ps:account id="fromAccount_${_pageRef}"
							inputIds="accBrFrom_${_pageRef}~accCyFrom_${_pageRef}~accGlFrom_${_pageRef}~accCifFrom_${_pageRef}~accSlFrom_${_pageRef}"
							inputNames="reportsCO.amfVOFrom.BRANCH_CODE~reportsCO.amfVOFrom.CURRENCY_CODE~reportsCO.amfVOFrom.GL_CODE~reportsCO.amfVOFrom.CIF_SUB_NO~reportsCO.amfVOFrom.SL_NO"
							accountLabel="" inputSizes="50~50~50~60~75"
							readOnly="false~false~false~false~false" 
							mode="number~number~number~number~livesearch"
							rowLocation="1~1~1~1~1" colSpan="1~1~1~1~1"
							actionName="N~N~N~N~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="N~N~N~N~branchCode:accBrFrom_${_pageRef},currencyCode:accCyFrom_${_pageRef},glCode:accGlFrom_${_pageRef},cifCode:accCifFrom_${_pageRef},slNbr:lookuptxt_accSlFrom_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="N~N~N~N~N"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accBrFromDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accCyFromDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accGlFromDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accCifFromDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accSlFromDependency"
							parameter="amfVOFrom.BRANCH_CODE:accBrFrom_${_pageRef}
										 ~amfVOFrom.CURRENCY_CODE:accCyFrom_${_pageRef}
										 ~amfVOFrom.GL_CODE:accGlFrom_${_pageRef}
										 ~amfVOFrom.CIF_SUB_NO:accCifFrom_${_pageRef}
										 ~amfVOFrom.BRANCH_CODE:accBrFrom_${_pageRef},amfVOFrom.SL_NO:lookuptxt_accSlFrom_${_pageRef}"
							dependency="accBrFrom_${_pageRef}:reportsCO.amfVOFrom.BRANCH_CODE,accBrTo_${_pageRef}:reportsCO.amfVOTo.BRANCH_CODE,accCyFrom_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE,accCyTo_${_pageRef}:reportsCO.amfVOTo.CURRENCY_CODE,accGlFrom_${_pageRef}:reportsCO.amfVOFrom.GL_CODE,accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE,accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,branchDesc_${_pageRef}:reportsCO.branchesVO.BRIEF_DESC_ENG
										  ~accCyFrom_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE,accCyTo_${_pageRef}:reportsCO.amfVOTo.CURRENCY_CODE,accGlFrom_${_pageRef}:reportsCO.amfVOFrom.GL_CODE,accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE,accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO
										  ~accGlFrom_${_pageRef}:reportsCO.amfVOFrom.GL_CODE,accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE,accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO
										  ~accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO
										  ~lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,branchDesc_${_pageRef}:reportsCO.branchesVO.BRIEF_DESC_ENG,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE,branchDesc_${_pageRef}:reportsCO.branchesVO.BRIEF_DESC_ENG"
							searchElement="N~N~N~N~N"
							onOk="N~N~N~N~setAccountStatementValFrom()"
							autoSearch="N~N~N~N~false">
						</ps:account>
					</td>
				</tr>

				<tr>
					<td class="fldLabelView"><ps:label id="toAccount_lbl_${_pageRef}" key="to_Acc" for="tbl_pathAccount_toAccount_${_pageRef}" /></td>
					<td colspan="2">
						<ps:account id="toAccount_${_pageRef}"
							inputIds="accBrTo_${_pageRef}~accCyTo_${_pageRef}~accGlTo_${_pageRef}~accCifTo_${_pageRef}~accSlTo_${_pageRef}"
							inputNames="reportsCO.amfVOTo.BRANCH_CODE~reportsCO.amfVOTo.CURRENCY_CODE~reportsCO.amfVOTo.GL_CODE~reportsCO.amfVOTo.CIF_SUB_NO~reportsCO.amfVOTo.SL_NO"
							accountLabel="" inputSizes="50~50~50~60~75"
							readOnly="false~false~false~false~false" 
							mode="number~number~number~number~livesearch"
							rowLocation="1~1~1~1~1" colSpan="1~1~1~1~1"
							actionName="N~N~N~N~${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="N~N~N~N
										 ~branchCode:accBrTo_${_pageRef},currencyCode:accCyTo_${_pageRef},glCode:accGlTo_${_pageRef},cifCode:accCifTo_${_pageRef},slNbr:lookuptxt_accSlTo_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="N~N~N~N~N"
							dependencySrc="N
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accCyToDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accGlToDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accCifToDependency
										  ~${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_accSlToDependency"
							parameter="N
										 ~amfVOTo.CURRENCY_CODE:accCyTo_${_pageRef}
										 ~amfVOTo.GL_CODE:accGlTo_${_pageRef}
										 ~amfVOTo.CIF_SUB_NO:accCifTo_${_pageRef}
										 ~amfVOTo.SL_NO:lookuptxt_accSlTo_${_pageRef}"
							dependency="N
										  ~accCyTo_${_pageRef}:reportsCO.amfVOTo.CURRENCY_CODE
										  ~accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE
										  ~accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO
										  ~lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO"
							searchElement="N~N~N~N~N"
							onOk="N~N~N~N~setAccountStatementValTo()"
							autoSearch="N~N~N~N~false">
						</ps:account>
					</td>
				</tr>
			</table>
			
			<table id="criteriaReference_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>">
				<tr>
					<td class="fldLabelView"><ps:label id="fromReference_lbl_${_pageRef}" key="from_reference_key" for="lookuptxt_fromReference_${_pageRef}" /></td>
					<td>
						<psj:livesearch id="fromReference_${_pageRef}" name="reportsCO.amfVOFrom.ADDITIONAL_REFERENCE"
							actionName="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="currencyCode:accCyFrom_${_pageRef},glCode:accGlFrom_${_pageRef},cifCode:accCifFrom_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="amfVO.ADDITIONAL_REFERENCE:lookuptxt_fromReference_${_pageRef}"
							searchElement="" mode="text" maxlength="18"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_fromReferenceDependency"
							parameter="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}
										,amfVOFrom.ADDITIONAL_REFERENCE:lookuptxt_fromReference_${_pageRef}"
							dependency="lookuptxt_fromReference_${_pageRef}:reportsCO.amfVOFrom.ADDITIONAL_REFERENCE
										,accBrFrom_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyFrom_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE
										,accGlFrom_${_pageRef}:reportsCO.amfVOFrom.GL_CODE
										,accCifFrom_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO
										,lookuptxt_accSlFrom_${_pageRef}:reportsCO.amfVOFrom.SL_NO
										,lookuptxt_toReference_${_pageRef}:reportsCO.amfVOTo.ADDITIONAL_REFERENCE
										,accBrTo_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyTo_${_pageRef}:reportsCO.amfVOFrom.CURRENCY_CODE
										,accGlTo_${_pageRef}:reportsCO.amfVOFrom.GL_CODE
										,accCifTo_${_pageRef}:reportsCO.amfVOFrom.CIF_SUB_NO
										,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOFrom.SL_NO
										,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE"
						/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView"><ps:label id="toReference_lbl_${_pageRef}" key="to_reference_key" for="lookuptxt_toReference_${_pageRef}" /></td>
					<td>
						<psj:livesearch id="toReference_${_pageRef}" name="reportsCO.amfVOTo.ADDITIONAL_REFERENCE"
							actionName="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAMFReportCompBranch"
							paramList="currencyCode:accCyTo_${_pageRef},glCode:accGlTo_${_pageRef},cifCode:accCifTo_${_pageRef},_pageRef:pageRef_${_pageRef},accDiv:accDivison_${_pageRef},accDept:accDepartement_${_pageRef}"
							resultList="amfVO.ADDITIONAL_REFERENCE:lookuptxt_toReference_${_pageRef}"
							searchElement="" mode="text"  maxlength="18"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_toReferenceDependency"
							parameter="companiesVO.COMP_CODE:lookuptxt_companyLkp_${_pageRef}
										,amfVOTo.ADDITIONAL_REFERENCE:lookuptxt_toReference_${_pageRef}
										,amfVOFrom.ADDITIONAL_REFERENCE:lookuptxt_fromReference_${_pageRef}"
							dependency="lookuptxt_toReference_${_pageRef}:reportsCO.amfVOTo.ADDITIONAL_REFERENCE
										,lookuptxt_branchLkp_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accBrTo_${_pageRef}:reportsCO.branchesVO.BRANCH_CODE
										,accCyTo_${_pageRef}:reportsCO.amfVOTo.CURRENCY_CODE
										,accGlTo_${_pageRef}:reportsCO.amfVOTo.GL_CODE
										,accCifTo_${_pageRef}:reportsCO.amfVOTo.CIF_SUB_NO
										,lookuptxt_accSlTo_${_pageRef}:reportsCO.amfVOTo.SL_NO"
						/>
					</td>
				</tr>
			</table>

			<table id="criteriaCardNo_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>">
				<tr>
					<td class="fldLabelView"><ps:label id="lookuptxt_fromCardNo_lbl_${_pageRef}" key="Card_No_key" for="lookuptxt_fromCardNo_${_pageRef}" /></td>
					<td>
						<psj:livesearch id="fromCardNo_${_pageRef}" name="reportsCO.fromCardNo"
							actionName="${pageContext.request.contextPath}/path/cardsManagement/CardsAccLkpAction_constructCardsNoLkp"
							paramList="compCode:lookuptxt_companyLkp_${_pageRef},card_no:lookuptxt_fromCardNo_${_pageRef}"
							searchElement="" mode="number"
							onOk="simulateCardNoDependency('onOk')"
							beforeDepEvent="simulateOpenLookup_fromCardNo()"
						/>
					</td>
				</tr>
			</table>

		</fieldset>


		<fieldset class="ui-widget-content ui-corner-all">
			<table>
				<tr>
					<td class="fldLabelView">
						<ps:label id="includeStmtWithoutMvmt_lbl_${_pageRef}" key="include_stmt_without_mvmt_key" for="includeStmtWithoutMvmt_${_pageRef}%{defaultIncludeStmtWithoutMvmt}" />
					</td>
					<td class="fldDataEdit" colspan="2">
						<ps:radio id="includeStmtWithoutMvmt_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.STMT_WITHOUT_MVT_ON"
							list="yesNoRadioList"  />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label id="msgIncludeInReport_lbl_${_pageRef}" key="msg_tobe_included_in_report_key" for="msgIncludeInReport_${_pageRef}%{reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON()}" />
					</td>
					<td>
						<ps:radio id="msgIncludeInReport_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.MSG_IN_REPORT_ON" 
							list="yesNoRadioList" />
					</td>
				</tr>

				<tr>
					<td class="fldLabelView">
						<ps:label id="languageOpt_lbl_${_pageRef}" key="what_language_key" for="languageOpt_${_pageRef}%{defaultLanguageList}" />
					</td>
					<td>
						<ps:radio id="languageOpt_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE" 
							list="languageList" />
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label id="addReference_lbl_${_pageRef}" key="add_reference_key" for="addReference_${_pageRef}%{defaultAddReference}" />
					</td>
					<td class="fldDataEdit " colspan="2">
						<ps:radio id="addReference_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_ADD_REF"
							list="yesNoRadioList" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label id="printLogo_lbl_${_pageRef}" key="print_logo_key" for="printLogo_${_pageRef}%{defaultPrintLogo}" />
					</td>
					<td class="fldDataEdit " colspan="2">
						<ps:radio id="printLogo_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_PRINT_LOGO"
							list="yesNoRadioList" />
					</td>
					<td></td>
				</tr>
			</table>
		</fieldset>


		<fieldset class="ui-widget-content ui-corner-all">
			<table>
				<tr>
					<td class="fldLabelView"><ps:label key="by_key" for="reportByDate_${_pageRef}%{defaultReportByDateList}" /></td>
					<td>
						<ps:radio id="reportByDate_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE" 
							list="reportByDateList" />
					</td>
				</tr>
				<tr>
					<td class="fldDataEdit" colspan="2">
						<ps:checkbox id="includeRevaluation_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_REVAL_TRANS" />
						<ps:label key="include_revaluation_trs_key" for="includeRevaluation_${_pageRef}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldDataEdit " colspan="2">
						<ps:checkbox id="includeReverse_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.ONLINE_REVERSE_TRANS" />
						<ps:label key="include_reversed_trs_key" for="includeReverse_${_pageRef}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldDataEdit " colspan="2">
						<ps:checkbox id="consolMCECharge_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.CONSOL_MULTI_CHQ_TRS_SOA_CHRG"
							valOpt="1:0" />
						<ps:label key="consol_sr_charges_key" for="consolMCECharge_${_pageRef}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldDataEdit" colspan="2">
						<ps:checkbox id="consolMCETrs_${_pageRef}" name="reportsCO.consMCETrs" 
							valOpt="1:0" />
						<ps:label key="consol_sr_trs_key" for="consolMCETrs_${_pageRef}" />
					</td>
					<td>
					<ps:checkbox id="showOverdraftAcc_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.SHOW_OVERDRAFT_DETAILS_YN" />
						<ps:label key="SHOW_OVERDRAFT_DETAILS_YN_key" for="showOverdraftAcc_${_pageRef}" />
					</td>
				</tr>
				<tr>
					<td class="fldDataEdit " colspan="2">
						<ps:checkbox id="incrementStmtNbrPriorToPrint_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.INC_STATNO_PRIOR_ON" />
						<ps:label id="lbl_incrementStmtNbrPriorToPrint_${_pageRef}" key="inc_statno_prior_on_key" for="incrementStmtNbrPriorToPrint_${_pageRef}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="fldDataEdit " colspan="2">
						<ps:checkbox id="includeMsgFooter_${_pageRef}" name="reportsCO.ctsSoaCtrlVO.INCLUDE_MSG_FOOTER" />
						<ps:label id="lbl_includeMsgFooter_${_pageRef}" key="inc_message_footer_key" for="includeMsgFooter_${_pageRef}" />
					</td>
					<td></td>
				</tr>
			</table>

			<table>
				<tr>
					<td class="fldLabelView">
						<ps:label key="message_key" for="lookuptxt_rifMessageCode_${_pageRef}" />
					</td>
					<td>
					<psj:livesearch id="rifMessageCode_${_pageRef}" name="reportsCO.rifMessageVO.MSG_CODE"
							actionName="${pageContext.request.contextPath}/pathdesktop/RifcttGlLookup_rifMessageByCompLkp"
							resultList="MSG_CODE:lookuptxt_rifMessageCode_${_pageRef}"
							searchElement="" mode="number" cssStyle="width:120px"
							
							parameter="reportsCO.rifMessageVO.MSG_CODE:lookuptxt_rifMessageCode_${_pageRef}
										,reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE:languageOpt_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/reports/ReportsDependencyAction_rifMessageCodeDependency"
							dependency="lookuptxt_rifMessageCode_${_pageRef}:reportsCO.rifMessageVO.MSG_CODE
										,rifMessageDesc_${_pageRef}:reportsCO.rifMsgDesc"
							readOnlyMode="true">
						</psj:livesearch>
					</td>
					<td>
						<ps:textfield id="rifMessageDesc_${_pageRef}" name="reportsCO.rifMsgDesc" 
							readonly="true" cssStyle="width:200px" />
					</td>
				</tr>				
				<tr>
				    <td class="fldLabelView">
						<ps:label key="export_typekey" for="exportType_${_pageRef}" />
					</td>
				  <td>
						<ps:select id="exportType_${_pageRef}" name="reportsCO.exportType" list="exportTypeList" listKey="code" listValue="descValue" emptyOption="false"	/>
				  </td>
				</tr>
			</table>
		</fieldset>

	</fieldset>


	<ptt:toolBar id="dynFileToolbar_${_pageRef}">
		<psj:submit button="true"
			onclick="statementOfAcc_openPreview('%{_pageRef}')">
			<ps:label key="open_key" />
		</psj:submit>

		<% /* to be done later  
	   	    <psj:a button="true" onclick="">
	   	      	<ps:text name="printer_key"></ps:text>
	   	    </psj:a>
	     */ %>
	</ptt:toolBar>

</ps:form>
