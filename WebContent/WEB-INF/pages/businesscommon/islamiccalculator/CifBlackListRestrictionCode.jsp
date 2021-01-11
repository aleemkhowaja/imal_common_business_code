<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<%@taglib prefix="ptt" uri="/path-toolbar-tags"%>

<div id="iis_cifBlackListRestrictionDet_${_pageRef}" style="width: 100%">

<table width="100%" class="headerPortionContent ui-widget-content">
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
									<td width="10%"></td>
								</tr>
								
								<tr>
								
			<td class="fldLabelView" colspan="1" align="left">
				<ps:label key="blacklist_reason_key" id="lbl_blacklist_reason_code_${_pageRef}"
					for="lookuptxt_blacklist_reason_code_${_pageRef}" />
			</td>
			<td colspan="1">
				<psj:livesearch id="blacklist_reason_code_${_pageRef}"
								name="cifBlackListRestrictCO.blackListOverrideReasonVO.REASON_CODE"
								actionName="${pageContext.request.contextPath}/pathdesktop/ReasonLookup_drawingReasonGrid"
								paramList="reasonCode:'true',criteria.reason_type:'27'"
								searchElement="CODE" autoSearch="true" mode="number"
								leadZeros="4" maxlength="4"
								resultList="CODE:lookuptxt_blacklist_reason_code_${_pageRef}"
								parameter="islamicCalculatorEventMgmtCO.reasonCode:lookuptxt_blacklist_reason_code_${_pageRef}"
								dependencySrc="${pageContext.request.contextPath}/path/islamicCalculator/islamicCalculatorEventMgmt_onchangeBlackListRestrictionReasonCode"
								dependency="lookuptxt_blacklist_reason_code_${_pageRef}:islamicCalculatorEventMgmtCO.reasonCode,blacklist_reason_desc_${_pageRef}:islamicCalculatorEventMgmtCO.reasonDesc"
								readOnlyMode="true"
								>
				</psj:livesearch>
			</td>
							
			<td colspan="3">
				<ps:textfield id="blacklist_reason_desc_${_pageRef}" readonly="true"
					name="cifBlackListRestrictCO.blacklist_reason_desc" />
			</td>
			
			<psj:datepicker cssStyle="display:none" name="cifBlackListRestrictCO.blackListOverrideReasonVO.DATE_UPDATED" 
			id="hidden_restriction_updated_date_${_pageRef}"/>
			<ps:hidden id="hidden_modifiedYN_${_pageRef}" name="cifBlackListRestrictCO.modifiedYN"></ps:hidden>
			</tr>
			</table>
</div>