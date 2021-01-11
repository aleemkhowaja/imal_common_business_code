<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>

   <script type="text/javascript">
$.struts2_jquery.require("highcharts.js", null, jQuery.contextPath + "/common/jquery/js/highchart/");
var Subscription_To_key = "<ps:text name='subscription_to_key' />";
//$.struts2_jquery.require("jquery.jqplot.js,jqplot.pieRenderer.js,jqplot.dateAxisRenderer.js,jqplot.highlighter.js,jqplot.cursor.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
//if($.browser.msie && $.browser.version <= 8)
//$.struts2_jquery.require("excanvas.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
</script>
<div id="dashboardScreen">
<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<ps:form id="dashboardFormId" namespace="/path/globalview" >

<ps:hidden id="auditTrxNbr_${_pageRef}" name="auditTrxNbr" />

<%/* 360 Degree */%>
<ps:set name="Trade_Finance_Operations_key" value="%{getEscText('Trade_Finance_Operations_key')}"/>
<ps:set name="Import_LC_key" value="%{getEscText('Import_LC_key')}"/>
<ps:set name="Export_LC_key" value="%{getEscText('Export_LC_key')}"/>
<ps:set name="Import_Bills_key" value="%{getEscText('Import_Bills_key')}"/>
<ps:set name="Export_Bills_key" value="%{getEscText('Export_Bills_key')}"/>
<ps:set name="LG_key" value="%{getEscText('LG_key')}"/>
<ps:set name="Outstanding_key" value="%{getEscText('outstanding_key')}"/>
<ps:set name="Acceptance_key" value="%{getEscText('acceptance_key')}"/>
<ps:set name="Settled_key" value="%{getEscText('settled_key')}"/>
<ps:set name="Financing_Deals_key" value="%{getEscText('Financing_Deals_key')}"/>
<ps:set name="Indirect_Liabilities_key" value="%{getEscText('Indirect_Liabilities_key')}"/>
<ps:set name="Assets_key" value="%{getEscText('assets_key')}"/>
<ps:set name="Assets_Available_key" value="%{getEscText('Assets_Available_key')}"/>
<ps:set name="Liabilities_Available_key" value="%{getEscText('Liabilities_Available_key')}"/>

<ps:set name="Liabilities_key" value="%{getEscText('liabilities_key')}"/>
<ps:set name="Liability_key" value="%{getEscText('Liability_key')}"/>
<ps:set name="Indirect_Liability_key" value="%{getEscText('Indirect_Liability_key')}"/>
<ps:set name="indirect_assets_key" value="%{getEscText('indirect_assets_key')}"/>
<ps:set name="Investments_key" value="%{getEscText('investments_key')}"/>
<ps:set name="Treasury_key" value="%{getEscText('treasury_key')}"/>
<ps:set name="Guarantees_key" value="%{getEscText('guarantees_key')}"/>
<ps:set name="Collaterals_key" value="%{getEscText('Collaterals_key')}"/>
<ps:set name="Promissory_Notes_key" value="%{getEscText('Promissory_Notes_key')}"/>
 <table width="100%">
  <tr height="1px">
     <ps:hidden id="fromDashboard_${_pageRef}" name="fromDashboard" value="fromDashboard"></ps:hidden>
      <ps:hidden id="fromGlobalView_${_pageRef}" value="1"></ps:hidden>
      <ps:hidden id="scannedCIFNo_${_pageRef}" value="${session.sesVO.scannedCIFNo}"></ps:hidden>
      <ps:hidden id="iv_crud_${_pageRef}"  name="iv_crud"></ps:hidden>
      <ps:hidden id="currentAppName_${_pageRef}"  name="dashboardCO.appName"></ps:hidden>
      <div id="dashboardScoreDescriptionList_${_pageRef}"></div>
      <ps:hidden id="cardReaderCivilID_${_pageRef}"/>
   
		<ps:div id="khatmCardReaderURLDiv_id_${_pageRef}"></ps:div>
  </tr>
  <tr>
     <td>
         <table width="100%" cellpadding="0" cellspacing="1">
            <tr>
                <td nowrap="nowrap"><ps:textfield id="cifStatus_${_pageRef}" cssStyle="text-align:center" name="dashboardCO.cif_status" readonly="true"/></td>
                <td nowrap="nowrap"><ps:label id="lbl_cif_no" key="CIF_No_key" for="lookuptxt_cif_no_${_pageRef}"></ps:label></td>
                <td nowrap="nowrap">
				      <psj:livesearch id            ="cif_no_${_pageRef}"
				                      name          ="dashboardCO.cifVO.CIF_NO"
				                      maxlength     ="8" 
				                      mode          ="number"
				                      leadZeros     ="8" dontLoadData="true"
				                      readOnlyMode  ="${_recReadOnly}"
				                      paramList     ="fromDash:fromGlobalView_${_pageRef},loginTypeByBr:loginType_${_pageRef},criteria.cardReaderCivilID:cardReaderCivilID_${_pageRef}"
				                      actionName    ="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
				                      searchElement =""
				                      resultList    ="CIF_NO:lookuptxt_cif_no_${_pageRef}"
				                      parameter     ="dashboardCO.cifVO.CIF_NO:lookuptxt_cif_no_${_pageRef},dashboardCO.loginTypeByBr:loginType_${_pageRef}
													 ,_pageRef:_pageRef"
				                      dependencySrc ="${pageContext.request.contextPath}/path/globalview/dashDependencyByCif_dashboardDependencyByCif"
				                      dependency    ="lookuptxt_cif_no_${_pageRef}:dashboardCO.cifVO.CIF_NO
				                                     ,long_name_eng_${_pageRef}:dashboardCO.cifVO.LONG_NAME_ENG
				                                     ,long_name_arab_${_pageRef}:dashboardCO.cifVO.LONG_NAME_ARAB
				                                     ,cifBranchDesc_${_pageRef}:dashboardCO.cifBranchDesc
				                                     ,creditRating_${_pageRef}:dashboardCO.creditRating
				                                     ,cifBlackList_${pageRef}:dashboardCO.cif_BlackList
				                                     ,cifStatus_${_pageRef}:dashboardCO.cif_status
				                                     ,obligorDesc_${_pageRef}:dashboardCO.obligorDesc
				                                     ,cifClassification_${_pageRef}:dashboardCO.cif_classification
				                                     ,cifBranch_${_pageRef}:dashboardCO.cifVO.BRANCH_CODE
				                                     ,auditTrxNbr_${_pageRef}:auditTrxNbr
				                                     ,dashboard_score_risk_description_${_pageRef}:dashboardCO.scoreRiskDescription"
				                      afterDepEvent ="dashboard_afterCifDependency()"
				                      size          ="10"></psj:livesearch>
                </td>
                <ps:hidden id="cifBranch_${_pageRef}" ></ps:hidden>
                <td nowrap="nowrap">
					  <ps:select id="loginType_${_pageRef}" 
					             name="dashboardCO.loginBrType"
						         list="loginBrTypeList" listKey="code" listValue="descValue" 
                                 onchange="dashboard_afterCifDependency()">
					  </ps:select>	
                </td>
                <td nowrap="nowrap"><ps:label id="lbl_cif_branch_${_pageRef}" key="cif_Branch_key" for="cifBranchDesc_${_pageRef}"></ps:label></td>
                <td nowrap="nowrap"><ps:textfield id="cifBranchDesc_${_pageRef}" name="dashboardCO.cifBranchDesc" readonly="true"/></td>
                <td nowrap="nowrap"><psj:submit id="cb_signature_${_pageRef}" type="button" cssStyle="width:75px"  button="true"  buttonIcon="ui-icon-pencil" onclick="dash_ShowSignature();">
						<ps:text name='Signature_key' />
					</psj:submit>
				</td>
				<td nowrap="nowrap"><psj:submit id="cb_oneObligor_${_pageRef}" button="true" freezeOnSubmit="true" cssStyle="width:100px"    onclick="dash_ShowOneObligor();">
						<ps:label key="One_Obligor_key" for="cb_oneObligor_${_pageRef}"/>
					</psj:submit>
				</td>
                <td class="right" >*<ps:text name='currency_dashboard_key'/><ps:property value="dashboardCO.baseCurrencyCode"/>-<ps:property value="dashboardCO.baseCurrencyName"/></td>
            </tr>
            <tr>
                <td nowrap="nowrap"><ps:textfield id="cifBlackList_${pageRef}" cssStyle="text-align:center" name="dashboardCO.cif_BlackList" readonly="true"/></td>
                <td colspan="3" nowrap="nowrap">
				      <ps:textfield name    ="dashboardCO.cifVO.LONG_NAME_ENG"
				                    readonly="true" tabindex="-1"
				                    id      ="long_name_eng_${_pageRef}">
				      </ps:textfield>
                </td>
                <td nowrap="nowrap"><ps:label id="lbl_credit_rating_${_pageRef}" key="credit_rating_key" for="creditRating_${_pageRef}"></ps:label></td>
                <td nowrap="nowrap"><ps:textfield id="creditRating_${_pageRef}" name="dashboardCO.creditRating" readonly="true"/></td>
                <td><psj:submit id="cb_refresh_${_pageRef}" type="button" cssStyle="width:75px"  button="true"  buttonIcon="ui-icon-refresh" onclick="dashboard_afterCifDependency();">
						<ps:text name='refresh_key' />
					</psj:submit></td>
                <td>
                <psj:submit id="cb_cardReader_${_pageRef}" cssStyle="width:75px"  button="true"   onclick="dashboard_onCardReaderClicked();">
						<ps:text name='cardReader_key' />
				</psj:submit>
				</td>
            </tr>
            <tr>
                <td><ps:textfield id="cifClassification_${_pageRef}" cssStyle="text-align:center" name="dashboardCO.cif_classification" readonly="true"/></td>
                <td colspan="3">
				      <ps:textfield name    ="dashboardCO.cifVO.LONG_NAME_ARAB"
				                    readonly="true" tabindex="-1"
				                    id      ="long_name_arab_${_pageRef}">
				      </ps:textfield>
                </td>
                <td><ps:label id="lbl_obligor_${_pageRef}" key="One_Obligor_key" for="obligorDesc_${_pageRef}"></ps:label></td>
                <td><ps:textfield id="obligorDesc_${_pageRef}" name="dashboardCO.obligorDesc" readonly="true"/></td>
                <td><psj:submit id="cb_back_${_pageRef}" type="button" cssStyle="width:75px"  button="true"  buttonIcon="ui-icon-circle-arrow-w" onclick="dashboard_onBackClicked();">
						<ps:text name='Back_key'/>
					</psj:submit></td>
               
                <td>
                <psj:submit button="true" buttonIcon="ui-icon-comment" type="button"  id="acc_balance_btn_${_pageRef}" onclick="accountBalanceClicked();">
				<ps:label key='Available_Balance_History_key' />
			</psj:submit>
			
			
			</td>
			 <td>
                <psj:submit button="true" buttonIcon="ui-icon-comment" type="button"  id="Channel_Subscription_btn_${_pageRef}" onclick="channelSubscriptionClicked();">
				<ps:label key='subscription_to_key' />
			</psj:submit>
			
			
			</td>
			 <td><psj:submit id="cb_childcif_${_pageRef}" type="button" cssStyle="width:75px"  button="true"  onclick="childCifClicked();">
			  <ps:text name='Child_Cif_key'/>
			  </psj:submit></td>
			
            </tr>
            
            <tr>
				<td><ps:label for="dashboard_score_risk_description_${_pageRef}" key="scoree_key"></ps:label></td>
				
				
				<td width="15%">
					<ps:textfield id="dashboard_score_risk_description_${_pageRef}" cssStyle="text-align:center" name="dashboardCO.scoreRiskDescription" readonly="true"/>
				</td>
				
				<td> 
					<psj:submit button="true" buttonIcon="ui-icon-comment" type="button" id="dashboard_more_scores_btn_${_pageRef}" onclick="dashboard_onClickMoreScoresBtn();">
				<ps:label key='more_scores_key' />
				</psj:submit>
				</td>
            
            
            </tr> <!-- falha //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen
            -->
              <tr>
           
           <td class="fldLabelView">
			<ps:label key="KYC_key"  id="lbl_dashboardCO_KYC_COMPLETED_${_pageRef}" for="dashboardCO_KYC_COMPLETED_${_pageRef}"/>
			</td>
			<td>								
			<ps:select id="dashboardCO_KYC_COMPLETED_${_pageRef}" name="dashboardCO.cifVO.KYC_COMPLETED" list="kycDropDown" disabled="true"/>
			</td>
			<td class="fldLabelView">
			<ps:label key="Ranking_key" id="lbl_cifVO_PRIORITY_CODE_${_pageRef}" for="dashboardCO_priorityDesc_${_pageRef}"/>
			</td>
			<td>
				<ps:textfield name="dashboardCO.priorityDesc" id="dashboardCO_priorityDesc_${_pageRef}" disabled="true"/>
			</td>
			<td>
                <psj:submit button="true" buttonIcon="ui-icon-comment" type="button"  id="power_of_attroney_${_pageRef}"  onclick="powerOfAttroneyClicked();">
				<ps:label key='power_of_attroney_key' />
				</psj:submit>
			</td>
            </tr>
         </table>
     </td>
  </tr>

  <tr>
  <td>
      <table width="100%" cellpadding="0" cellspacing="0"><tr><td class="ui-state-active"></td></tr></table>
  </td>
  </tr>
 </table>
	<div id="toolbarRow_${_pageRef}">
		<pt:toolBar id="dashboardCustomization_${_pageRef}"></pt:toolBar>
	</div>
</ps:form>
<div id="mainDivId_<ps:property value="_pageRef" escapeHtml="true"/>">
</div>
<div id="detailDiv_<ps:property value="_pageRef" escapeHtml="true"/>" style="display:none">
</div>
<div id="subDetailDiv_<ps:property value="_pageRef" escapeHtml="true"/>" style="display:none">
</div>
<div id="subSettlmentDetailDiv_<ps:property value="_pageRef" escapeHtml="true"/>" style="display:none">
</div>
<div id="oneObligorMaintDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>"></div>
<div id="accBalViewLineChartDialog_<ps:property value="_pageRef" escapeHtml="true"/>"></div>
</div>
<div id="khatmCardReaderURLDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>"></div>
<div id="childCifMaintDiv_id_<ps:property value="_pageRef" escapeHtml="true"/>"></div>
<script type="text/javascript">
// in order to be able to properly call the 360 view from landing page or any place outside menu.
if(typeof _pageRef === undefined || _pageRef === ""){_pageRef = "${_pageRef}";}
$(document).ready(function (){
    $.struts2_jquery.require("Dashboard.js",null,jQuery.contextPath+"/businesscommon/js/global360view/");
        $.struts2_jquery.require("SignatureMain.js" ,null,jQuery.contextPath+"/businesscommon/js/signature/");
        
        var scannedCIFNo = $("#scannedCIFNo_"+_pageRef).val();
        if(scannedCIFNo != undefined && scannedCIFNo != null && scannedCIFNo != '')
        {
        	$("#lookuptxt_cif_no_"+_pageRef).valChange(scannedCIFNo);
        }
        else if($("#lookuptxt_cif_no_"+_pageRef).val()!=""){
       	 	$("#lookuptxt_cif_no_"+_pageRef).trigger('change');
        }
});
var Available_Balance_History_key="<ps:text name='Available_Balance_History_key' />";
var assets_available_key="<ps:text name='assets_available_key' />";
var liabilities_available_key="<ps:text name='liabilities_available_key' />";
var Child_Cif_key="<ps:text name='Child_Cif_key' />";
var Liability_Account = "<ps:text name='Liability_Account'/>";
var Asset_Account = "<ps:text name='Asset_Account'/>";
var Assets_And_Liabilities_key = "<ps:text name='Assets_And_Liabilities_key'/>";
var values_key = "<ps:text name='values_key'/>";
var oneObligorKey = "<ps:text name='One_Obligor_key'/>";
var Trade_Finance_Operations_key = "<ps:property value='Trade_Finance_Operations_key' escapeHtml='false' escapeJavaScript='true' />";   
var Import_LC_key = "<ps:property value='Import_LC_key' escapeHtml='false' escapeJavaScript='true' />";
var Export_LC_key = "<ps:property value='Export_LC_key' escapeHtml='false' escapeJavaScript='true' />";
var Import_Bills_key = "<ps:property value='Import_Bills_key' escapeHtml='false' escapeJavaScript='true' />";
var Export_Bills_key = "<ps:property value='Export_Bills_key' escapeHtml='false' escapeJavaScript='true' />";
var LG_key = "<ps:property value='LG_key' escapeHtml='false' escapeJavaScript='true' />";
var Outstanding_key = "<ps:property value='Outstanding_key' escapeHtml='false' escapeJavaScript='true' />";
var Acceptance_key = "<ps:property value='Acceptance_key' escapeHtml='false' escapeJavaScript='true' />";
var Settled_key = "<ps:property value='Settled_key' escapeHtml='false' escapeJavaScript='true' />";
var Financing_Deals_key = "<ps:property value='Financing_Deals_key' escapeHtml='false' escapeJavaScript='true' />";
var Indirect_Liabilities_key = "<ps:property value='Indirect_Liabilities_key' escapeHtml='false' escapeJavaScript='true' />";
var indirect_assets_key = "${indirect_assets_key}";//DBU190980
var Assets_Available = "${Assets_Available_key}";
var Liabilities_Available = "${Liabilities_Available_key}";
var Assets_key = "<ps:property value='Assets_key' escapeHtml='false' escapeJavaScript='true' />";
var Liabilities_key = "<ps:property value='Liabilities_key' escapeHtml='false' escapeJavaScript='true' />";
var Liability_key = "<ps:property value='Liability_key' escapeHtml='false' escapeJavaScript='true' />";
var Indirect_Liability_key = "<ps:property value='Indirect_Liability_key' escapeHtml='false' escapeJavaScript='true' />";
var Investments_key = "<ps:property value='Investments_key' escapeHtml='false' escapeJavaScript='true' />";
var Treasury_key = "<ps:property value='Treasury_key' escapeHtml='false' escapeJavaScript='true' />";
var Guarantees_key = "<ps:property value='Guarantees_key' escapeHtml='false' escapeJavaScript='true' />";
var Collaterals_key = "<ps:property value='Collaterals_key' escapeHtml='false' escapeJavaScript='true' />";
var Promissory_Notes_key = "<ps:property value='Promissory_Notes_key' escapeHtml='false' escapeJavaScript='true' />";
var query_position_key = "<ps:text name='query_position_key' />"; //tp id 610138
var finAppAndApproveLines_key= "<ps:text name='finAppAndApproveLines_key'/>";
</script>


