<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<script type="text/javascript">

   $.struts2_jquery.require("highcharts.js", null, jQuery.contextPath + "/common/jquery/js/highchart/");
   
   $(document).ready(function (){
	//PATH130194
	 var userKey = "<ps:text name='userKey'/>";
     var does_not_have_access_to_view_all_cif_detls_key = "<ps:text name ='does_not_have_access_to_view_all_cif_detls_key'/>";
		
	 var userRestrictionOnCIFDetls = $("#userRestrictionOnCIFDetls_"+_pageRef).val();
		if(userRestrictionOnCIFDetls == "true")
		{
			var userId = $("#userID_"+_pageRef).val();
			var message = userKey+" "+userId+" "+does_not_have_access_to_view_all_cif_detls_key;
			var userCIFDetlsAccessRestriction_lbl = $("<label id='lbl_userCIFDetlsAccessRestriction_"+_pageRef+"' style='color:red'>"+message+"</label>");
			var gridDiv = $("#gridsDiv_"+_pageRef);
			var userCIFDetlsAccessRestriction = $(userCIFDetlsAccessRestriction_lbl);
			gridDiv.append(userCIFDetlsAccessRestriction);
			userCIFDetlsAccessRestriction.insertAfter(gridDiv);
		}
		
	});
	//PATH130194
   

   
</script>
   
     <ps:hidden id="assetsLiabList_${_pageRef}"        name="dashboardCO.assetsAndLiabList"/>
     <ps:hidden id="finAppAndAppList_${_pageRef}"      name="dashboardCO.finAppAndAppList"/>
     <ps:hidden id="financeDealsList_${_pageRef}"      name="dashboardCO.financeDealsList"/>
     <ps:hidden id="investAndTreasuryList_${_pageRef}" name="dashboardCO.investAndTreasuryList"/>
     <ps:hidden id="treasuryOpt_${_pageRef}"           name="dashboardCO.treasuryOpt"/>
     <ps:hidden id="totalAssLiabOpt_${_pageRef}"       name="dashboardCO.totalAssLiabOpt"/>
     <ps:hidden id="finAppAprLineOpt_${_pageRef}"      name="dashboardCO.finAppAprLineOpt"/>
     <ps:hidden id="financingDealsOpt_${_pageRef}"     name="dashboardCO.financingDealsOpt"/>
     <ps:hidden id="investmentsOpt_${_pageRef}"        name="dashboardCO.investmentsOpt"/>
     <ps:hidden id="liability_${_pageRef}"             name="liabilityValues"/>
     <ps:hidden id="assets_${_pageRef}"                name="assetsValues"/>
     <ps:hidden id="categ_${_pageRef}"                 name="categValues"/>
     <ps:hidden id="finAppList_${_pageRef}"            name="finAppList"/>
     <ps:hidden id="nbAccountAssets_${_pageRef}"       name="nbAccountAssets"/>
     <ps:hidden id="nbAccountLiabl_${_pageRef}"       name="nbAccountLiabl"/>
     
     
     <ps:hidden id="userID_${_pageRef}"            name="dashboardCO.loginUserId"/>
	<ps:hidden id="userRestrictionOnCIFDetls_${_pageRef}"   name="dashboardCO.userRestrictionOnCIFDetls"/>
     
     
     
	 <%-- Elie Achkar TFA  --%>
     <ps:hidden id="tradeFinanceList_${_pageRef}"   name="dashboardCO.tradeFinanceList"/>
     
     <table width="100%" cellpadding="0"  cellspacing="0">
        <tr>
            <td>
                <table width="100%"  cellpadding="0" cellspacing="0">
                  <tr>
                
                     <ps:if test='${dashboardCO.productsOpt != "true" && dashboardCO.chequesOpt != "true" 
                                 && dashboardCO.otherOpt != "true" && dashboardCO.totalAssLiabOpt != "true"
                                 && dashboardCO.finAppAprLineOpt != "true" && dashboardCO.financingDealsOpt != "true"
                                 && dashboardCO.investmentsOpt != "true"}'>
                        <td align="center">
                           <ps:label key="access_denied_key" cssClass="required"></ps:label>
                        </td>
                     </ps:if>
                     <ps:if test='${dashboardCO.productsOpt == "true" && (dashboardCO.safeBoxNbr > 0 || dashboardCO.cardsNbr > 0 || dashboardCO.chequeBooksNbr > 0 || dashboardCO.passBooksNbr > 0 || dashboardCO.lostDocsNbr > 0 || dashboardCO.smsSubscriptionNbr > 0)}'>
	                     <td>
			                  <fieldset id="fldSet_products_${_pageRef}">
			                      <legend><ps:label key="products_key"></ps:label></legend>
			                      <ps:if test='${dashboardCO.safeBoxNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('safeboxes')"><ps:text name="safe_boxes_key"/> <ps:property value="dashboardCO.safeBoxNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.cardsNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('cards')"><ps:text name="cards_key"/> <ps:property value="dashboardCO.cardsNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.chequeBooksNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('chequebooks')"><ps:text name="chequeBooks_key"/> <ps:property value="dashboardCO.chequeBooksNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.passBooksNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('passbooks')"><ps:text name="Passbooks_key"/> <ps:property value="dashboardCO.passBooksNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.lostDocsNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('lostDocuments')"><ps:text name="lostDocuments_key"/> <ps:property value="dashboardCO.lostDocsNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.smsSubscriptionNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('smsSubscriptions')"><ps:text name="sms_subscription_key"/> <ps:property value="dashboardCO.smsSubscriptionNbr"/></ps:a> |
			                      </ps:if>
			                  </fieldset>
	                     </td>
                     </ps:if>
                     <ps:if test='${dashboardCO.chequesOpt == "true" && (dashboardCO.bankersChqNbr > 0 || dashboardCO.voidedChqsNbr > 0 || dashboardCO.chequesForCollNbr > 0 || dashboardCO.postDatedChqWdrawalNbr > 0 || dashboardCO.postDatedChqDpNbr > 0)}'>
	                     <td >
			                  <fieldset id="fldSet_cheques_${_pageRef}">
			                      <legend><ps:label key="Cheques_key"></ps:label></legend>
			                      <ps:if test='${dashboardCO.bankersChqNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('bankersCheques')"><ps:text name="bankers_cheques_key"/> <ps:property value="dashboardCO.bankersChqNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.voidedChqsNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('voidedCheques')"><ps:text name="voided_cheques_key"/> <ps:property value="dashboardCO.voidedChqsNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.chequesForCollNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('chequesForCol')"><ps:text name="cheques_for_coll_key"/> <ps:property value="dashboardCO.chequesForCollNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.postDatedChqWdrawalNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('postDatedChqWDrawal')"><ps:text name="post_dated_chq_wdrawal_key"/> <ps:property value="dashboardCO.postDatedChqWdrawalNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.postDatedChqDpNbr > 0}'>
			                      	<ps:a href="#" onclick="dashboard_onLinkClicked('postDatedChqDep')"><ps:text name="post_dated_chq_deposit_key"/> <ps:property value="dashboardCO.postDatedChqDpNbr"/></ps:a> |
			                      </ps:if>
			                  </fieldset>
	                     </td>
                     </ps:if>
                     <ps:if test='${dashboardCO.otherOpt == "true" && (dashboardCO.specialConditionsNbr > 0 || dashboardCO.standingOrdersNbr > 0 || dashboardCO.remittancesNbr > 0 || dashboardCO.memosNbr > 0 || dashboardCO.authSignatoriesNbr > 0 || dashboardCO.linksNbr > 0)}'>
	                     <td >
			                  <fieldset id="fldSet_others_${_pageRef}">
			                      <legend><ps:label key="Others_key"></ps:label></legend>
			                      <ps:if test='${dashboardCO.specialConditionsNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('specialConditions')"><ps:text name="specialConditions_key"/> <ps:property value="dashboardCO.specialConditionsNbr"/></ps:a> |                             
			                      </ps:if>
			                      <ps:if test='${dashboardCO.standingOrdersNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('standingOrder')"><ps:text name="standingOrders_key"/> <ps:property value="dashboardCO.standingOrdersNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.remittancesNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('remittances')"><ps:text name="remittances_key"/> <ps:property value="dashboardCO.remittancesNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.memosNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('memos')"><ps:text name="Memos_key"/> <ps:property value="dashboardCO.memosNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.authSignatoriesNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('authorizedSig')"><ps:text name="authSignatories_key"/> <ps:property value="dashboardCO.authSignatoriesNbr"/></ps:a> |
			                      </ps:if>
			                      <ps:if test='${dashboardCO.linksNbr > 0}'>
			                        <ps:a href="#" onclick="dashboard_onLinkClicked('links')"><ps:text name="links_key"/><ps:property value="dashboardCO.linksNbr"/></ps:a> |
			                      </ps:if>
			                  </fieldset>                              
	                     </td>
                     </ps:if>
                    <td width="8%">
                     <psj:submit button="true" buttonIcon="ui-icon-refresh" type="button"  id="view_chart_btn_${_pageRef}" onclick="dashboard_onViewChartClicked();">
							<ps:label key='View_Chart_key' /> 
					</psj:submit>
					</td>
					 <td width="8%">
					 <psj:submit button="true" buttonIcon="ui-icon-refresh" type="button"  id="view_grid_btn_${_pageRef}" onclick="dashboard_onViewGridClicked();">
							<ps:label key='View_Grid_key' /> 
					</psj:submit>
					</td> 
					
					<td width="8%">
					 <psj:submit button="true" buttonIcon="ui-icon-print" type="button"  id="print_grid_btn_${_pageRef}" onclick="dashboard_printView();">
							<ps:label key='btn.print' /> 
					</psj:submit>
					</td> 
					
                  </tr>
                </table>

            </td>
        </tr>
        </table>
         <div id="gridsDiv_<ps:property value="_pageRef" escapeHtml="true"/>">
                 <ps:if test='${dashboardCO.totalAssLiabOpt == "true"}'>
                          <div id="assetsLiabAccDivId_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;">
                              <%@include file="DashAssetsLiabAccList.jsp"%>                                           
                          </div>
                 </ps:if>
                 <ps:if test='${dashboardCO.finAppAprLineOpt == "true"}'>
                           <div id="finAppAppLinesDivId_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;" chartName='<ps:text name="finAppAndApproveLines_key" />' >
                              <%@include file="FinAppAndApprvdLinesList.jsp"%>
                          </div>
                          
                          <!-- Elie Achkar added the below for TFA -->
                          <div id="tradeFinanceOperationsDivId_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;">
		                     <%@include file="TradeFinanceOperations.jsp"%>
		                 </div>
                 </ps:if>
				
                 <ps:if test='${dashboardCO.financingDealsOpt == "true"}'>
                          <div id="financingDealsDivId_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;">
                              <%@include file="FinancingDealsList.jsp"%>
                          </div>
                 </ps:if>
                 <ps:if test='${dashboardCO.investmentsOpt == "true"}'>
                          <div id="invstTreasuryDivId_<ps:property value="_pageRef" escapeHtml="true"/>" style="width:100%;">
                              <%@include file="InvestTreasuryList.jsp"%>
                          </div>
                 </ps:if>    
                 
         </div>
