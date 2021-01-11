<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>


<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/jquery/js/charting/jquery.jqplot.css" />-->

<script type="text/javascript">
$.struts2_jquery.require("highcharts.js", null, jQuery.contextPath + "/common/jquery/js/highchart/");
//$.struts2_jquery.require("jquery.jqplot.js,jqplot.pieRenderer.js,jqplot.dateAxisRenderer.js,jqplot.canvasAxisTickRenderer.js,jqplot.canvasTextRenderer.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
//if($.browser.msie && $.browser.version <= 8)
//$.struts2_jquery.require("excanvas.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
</script>

<ps:hidden id="allSecuritiesList_${_pageRef}"	name="allSecuritiesChartList"/>
<ps:hidden id="prtflPosSummaryList_${_pageRef}"	name="prtflPosSummaryList"/>
<ps:hidden id="portfolioSeq_${_pageRef}"		name="portfolioSeq"/>
<ps:hidden id="branchCode_${_pageRef}"		    name="branchCode"/>
<ps:hidden id="securityName_${_pageRef}"		name="securityName"/>
<ps:hidden id="securityCode1_${_pageRef}"		name="securityCode1"/>
<ps:hidden id="securityCode2_${_pageRef}"		name="securityCode2"/>
<ps:hidden id="asOfDateStr_${_pageRef}"			name="asOfDateStr"/>

<ps:hidden id="portfolioBaseCy_${_pageRef}"		name="portfolioBaseCy"/>
<ps:hidden id="portfolioName_${_pageRef}"		name="portfolioName"/>

<%/* added by bahaa for TP# 1042048*/%>
<ps:hidden id="cifNo_${_pageRef}"		name="cif_no"/>



<table width="100%">
  <tr>
     <td width="70%" valign="top">
		<table width="100%">
		<%/*
		  <tr>
		     <td>
		          <table width="100%">
		              <tr>
		                  <td>
		                      <fieldset class="display:none">
		                         <legend><ps:text name="portfolio_current_month_key"></ps:text></legend>
		                         <table>
		                            <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="sales_key"></ps:text>
											</psj:submit>
		                                </td>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="purchases_key"></ps:text>
											</psj:submit>
		                                </td>
		                            </tr>
		                         </table>
		                      </fieldset>  
		                  </td>
		                  <td>
		                      <fieldset  class="display:none">
		                         <legend><ps:text name="transactions_key"></ps:text></legend>
		                         <table>
		                            <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="history_key"></ps:text>
											</psj:submit>                                
		                                </td>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="futures_key"></ps:text>
											</psj:submit>
		                                </td>
		                            </tr>
		                         </table>                      
		                      </fieldset>
		                  </td>
		                  <td>
		                      <fieldset  class="display:none">
		                         <legend><ps:text name="position_details_key"></ps:text></legend>
		                         <table>
		                            <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="holding_key"></ps:text>
											</psj:submit>
		                                </td>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100;display:none" buttonIcon="ui-icon-comment" onclick="lnkMgnt_openAlertsClicked()">
												<ps:text name="cash_key"></ps:text>
											</psj:submit>
		                                </td>
		                            </tr>
		                         </table>
		                      </fieldset>
		                  </td>
		              </tr>
		          </table>
		     </td>
		  </tr>
		  */%>
		  <tr>
		     <td>
		         <table width="100%">
		              <tr>
		                 <td>
		                     <ps:label key="portfolio_no_key" id="lbl_portfolio_no_${_pageRef}" for="portfolio_no_${_pageRef}"/>
		                 </td>
		                 <td>
		                     <ps:textfield id="portfolio_no_${_pageRef}" name="dashPrtfCashPosHoldPosCO.portfolioNo" readonly="true"/>                     
		                 </td>
		                 <td align="right">
		                    <ps:label key="Name_key" id="lbl_name_${_pageRef}" for="portfolio_name_${_pageRef}"/>
		                 </td>
		                 <td>
		                    <ps:textfield id="portfolio_name_${_pageRef}" name="dashPrtfCashPosHoldPosCO.portfolioName" readonly="true"/>
		                 </td>
		              </tr>
		              <tr>
		              	<td>
		              		<ps:label key="Base_CY_key" id="lbl_base_cy_${_pageRef}" for="base_cy_${_pageRef}"/>
		              	</td>
		              	<td>
		              		<ps:textfield id="base_cy_${_pageRef}" name="portfolioBaseCy" readonly="true"/>
		              	</td>
		              	<td  align="right">
		              		<ps:label key="CIF_key" id="lbl_portfolio_CIF_${_pageRef}" for="portfolio_cif_${_pageRef}"/>
		              	</td>
		              	<td>
		              		<ps:textfield id="portfolio_cif_${_pageRef}" name="portfolioName" readonly="true"/>
		              	</td>
		              </tr>
		         </table>
		     </td>
		  </tr>
		  <tr>
		     <td>
					<ps:url id="urlCashPositionGrid_${_pageRef}" 
					        namespace="/path/globalview" escapeAmp="false"
						    action="dashPrtfCashPosHoldPosListAction_loadCashPositionGridData?_pageRef=${_pageRef}">
					   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
					   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
					   <ps:param name="portfolioSeq"  value="criteria.portfolioSeq"></ps:param>
					   <ps:param name="branchCode"    value="criteria.branchCode"></ps:param>
					   <ps:param name="asOfDateStr"    value="criteria.asOfDateStr"></ps:param>
					</ps:url>
				    <psjg:grid id="cashPositionListGridTbl_Id_${_pageRef}" 
							caption="%{getText('portfolio_cash_position_key') + ' ' + getText('As_Of_key') + ' : ' +  asOfDateStr}"
					        altRows="true"
					    	dataType="json" 
							filter="true"
					    	gridModel="gridModel" 
					    	href="%{urlCashPositionGrid_${_pageRef}}"
					        navigator="true" 
					        navigatorAdd="false"
					        navigatorDelete="false"
					        navigatorEdit="false"
					        navigatorRefresh="false"
					        navigatorSearch="true" 
					        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
					    	pager="true"
					    	rowNum="5" 
					    	rowList="5,10,15,20"
					        shrinkToFit="true"
					        sortable="true"
					        ondblclick="${ondblclickCashPosition}"
					        viewrecords="true">
                        <psjg:gridColumn id="acc_cy" index="acc_cy" colType="number" name="acc_cy" title="" hidden="true" />
                        <psjg:gridColumn id="acc_gl" index="acc_gl" colType="number" name="acc_gl" title="" hidden="true" />
		                <psjg:gridColumn id="decimal_points" index="decimal_points" colType="number" name="decimal_points" title=" "  hidden="true"/>
						<psjg:gridColumn id="account_type"   index="account_type"   colType="text"   name="account_type"   title="%{getText('Account_Type_key')}"      editable="false" sortable="true" search="true"/>
						<psjg:gridColumn id="currency"       index="currency"       colType="text"   name="currency" 	   title="%{getText('Currency_key')}"	       editable="false" sortable="true" search="true"/>
						<psjg:gridColumn id="value_trade_cy" index="value_trade_cy" colType="number" name="value_trade_cy" title="%{getText('value_in_trade_cy_key')}" editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
						<psjg:gridColumn id="value_base_cy"  index="value_base_cy"  colType="number" name="value_base_cy"  title="%{getText('Value_in_Base_CY_key')}"  editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
					</psjg:grid>     
		     </td>
		  </tr>
		  <tr>
		     <td>
					<ps:url id="urlHoldingPositionGrid_${_pageRef}" 
					        namespace="/path/globalview" escapeAmp="false"
						    action="dashPrtfCashPosHoldPosListAction_loadHoldingPositionGridData?_pageRef=${_pageRef}">
					   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
					   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
					   <ps:param name="portfolioSeq"  value="criteria.portfolioSeq"></ps:param>
					   <ps:param name="branchCode"    value="criteria.branchCode"></ps:param>
						<ps:param name="asOfDateStr"    value="criteria.asOfDateStr"></ps:param>
					</ps:url>
				    <psjg:grid id="holdingPositionListGridTbl_Id_${_pageRef}" 
							caption="%{getText('security_holding_position_key') + ' ' + getText('As_of_key') + ' : ' +  asOfDateStr}"
					        altRows="true"
					    	dataType="json" 
							filter="true"
					    	gridModel="gridModel" 
					    	href="%{urlHoldingPositionGrid_${_pageRef}}"
					        navigator="true" 
					        navigatorAdd="false"
					        navigatorDelete="false"
					        navigatorEdit="false"
					        navigatorRefresh="false"
					        navigatorSearch="true" 
					        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
					    	pager="true"
					    	rowNum="5" 
					    	rowList="5,10,15,20"
					        shrinkToFit="true"
					        sortable="true"
					        ondblclick="${ondblclickHoldingPosition}"
					        viewrecords="true">
					    <psjg:gridColumn id="secType" index="secType" colType="number" name="secType" title="" hidden="true"/>
                        <psjg:gridColumn id="tradeCy" index="tradeCy" colType="number" name="tradeCy" title="" hidden="true"/>
		                <psjg:gridColumn id="decimal_points"       index="decimal_points"       colType="number" name="decimal_points"       title=" "  hidden="true"/>
						<psjg:gridColumn id="security_type"        index="security_type"        colType="text"   name="security_type"        title="%{getText('security_type_key')}"     editable="false" sortable="true" search="true"/>
						<psjg:gridColumn id="cyDesc"               index="cyDesc"               colType="text"   name="cyDesc" 	             title="%{getText('Currency_key')}"	         editable="false" sortable="true" search="true"/>
						<psjg:gridColumn id="book_value"           index="book_value"           colType="number" name="book_value"           title="%{getText('value_in_trade_cy_key')}" editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
						<psjg:gridColumn id="market_value"         index="market_value"         colType="number" name="market_value"         title="%{getText('Market_Value_key')}"      editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
						<psjg:gridColumn id="market_value_base_cy" index="market_value_base_cy" colType="number" name="market_value_base_cy" title="%{getText('Value_in_Base_CY_key')}"  editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
					</psjg:grid>
		     </td>
		  </tr>
		  <tr>
		     <td>
		         <table width="100%">
		                <tr>
		                  <% /*  <td>
		                       <table>
		                             <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100" buttonIcon="ui-icon-comment">
												<ps:text name="Close_key"></ps:text>
											</psj:submit>
		                                </td>
		                             </tr>
		                             <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100" buttonIcon="ui-icon-comment">
												<ps:text name="btn.print"></ps:text>
											</psj:submit>
		                                </td>
		                             </tr>
		                             <tr>
		                                <td>
											<psj:submit button="true" type="button" disabled="true" cssStyle="width:100" buttonIcon="ui-icon-comment">
												<ps:text name="printer_setup_key"></ps:text>
											</psj:submit>
		                                </td>
		                             </tr>
		                       </table>
		                   </td>
		                   */ %>
		                   <td>
		                       <table>
		                           <tr>
		                              <td>
		                                  <ps:label key="total_unrealized_gain_loss_key" id="lbl_total_unrealized_gain_loss_${_pageRef}" for="total_unrealized_gain_loss_${_pageRef}"/>
		                              </td>
		                              <td width="70%">
		                                  <ps:textfield id="total_unrealized_gain_loss_${_pageRef}" name="dashPrtfCashPosHoldPosCO.totalUnrealizedGainLossFrmtd" readonly="true"/>
		                              </td>
		                           </tr>
		                           <tr>
		                              <td>
		                                 <ps:label key="total_realized_gain_loss_key" id="lbl_total_realized_gain_loss_${_pageRef}" for="total_realized_gain_loss_${_pageRef}"/>
		                              </td>
		                              <td>
		                                 <ps:textfield id="total_realized_gain_loss_${_pageRef}" name="dashPrtfCashPosHoldPosCO.totalRealizedGainLossFrmtd" readonly="true"/>
		                              </td>
		                           </tr>
		                           <tr>
		                              <td>
		                                <ps:label key="unrealized_CY_gain_loss_key" id="lbl_unrealized_CY_gain_loss_key_${_pageRef}" for="unrealized_CY_gain_loss_${_pageRef}"/>
		                              </td>
		                              <td>
		                                <ps:textfield id="unrealized_CY_gain_loss_${_pageRef}" name="dashPrtfCashPosHoldPosCO.unrealizedCyGainLossFrmtd" readonly="true"/>
		                              </td>
		                           </tr>
		                           <tr>
		                              <td>
		                               <ps:label key="total_assets_key" id="lbl_total_assets_${_pageRef}" for="total_assets_${_pageRef}"/>
		                              </td>
		                              <td>
		                               <ps:textfield id="total_assets_${_pageRef}" name="dashPrtfCashPosHoldPosCO.totalAssetsFrmtd" readonly="true"/>
		                              </td>
		                           </tr>
		                       </table>
		                   </td>
		                </tr>
		         </table>
		     </td>
		  </tr>
		</table>
     </td>
  </tr>
  <tr valign="top">
     	<table width="100%">
            	<td colspan="0" rowspan="0" width="50%">
                	<table width="100%">
                    	<tr>
                        	<td nowrap="nowrap">
                            	<ps:label id="lbl_securities" for="lookuptxt_securities_${_pageRef}"></ps:label>
                            </td>
                        </tr>
                        <tr>
                        <%/* changed lookuptxt_cif_no_${_pageRef} to cifNo_${_pageRef} by bahaa for TP# 1042048*/%>
                			<td nowrap="nowrap">
						    	<psj:livesearch id          ="securities_${_pageRef}"
						                      name          ="dashPrtfCashPosHoldPosCO.securityName" 
						                      mode          ="text"
						                      cssStyle="width:50%;"
						                      readOnlyMode  ="${_recReadOnly}"
						                       paramList     ="criteria.cif_no:cifNo_${_pageRef},criteria.portfolioSeq:portfolioSeq_${_pageRef},criteria.branchCode:branchCode_${_pageRef}"
						                      actionName    ="${pageContext.request.contextPath}/pathdesktop/DashboardLookup_constructSecuritiesLookup" 
						                      searchElement =""
						                      resultList    ="SECURITY_NAME:lookuptxt_securities_${_pageRef}"
				                      		  parameter     ="securityName:lookuptxt_securities_${_pageRef}
				                      		  				,cif_no:cifNo_${_pageRef}
				                      		  				,portfolioSeq:portfolioSeq_${_pageRef}
				                      		  				,branchCode:branchCode_${_pageRef}"
				                      		  dependencySrc ="${pageContext.request.contextPath}/path/globalview/dashDependencyByCif_dashboardDependencyBySecurities"
				                      		  dependency    ="lookuptxt_securities_${_pageRef}:pmsPortfolioPostitionTmpVO.SECURITY_NAME
				                      		  				,securityCode1_${_pageRef}:pmsPortfolioPostitionTmpVO.SECURITY_CODE1
															,securityCode2_${_pageRef}:pmsPortfolioPostitionTmpVO.SECURITY_CODE2"
				                              afterDepEvent ="dashboard_drawGridOnSecuritiesChange()"
						      				  size          ="10">
								</psj:livesearch>
							</td>
						</tr>
                        <tr>
                            <td>
                                <div id="allSecuritiesChart"></div>
                            </td>
                        </tr>
                    </table>
               </td>
               <td colspan="0" rowspan="0" width="50%">
                   <table width="100%" >
                      <tr>
                          <td>
							<ps:select id   ="holdingBySecurity_${_pageRef}" 
							           name ="dashPrtfCashPosHoldPosCO.holdingBySecurity" onchange="dashboard_drawGridOnHoldingBySecurityChange()"
								       list ="holdingBySecurityList" listKey="code" listValue="descValue"
								       cssStyle="width:50%;">
							</ps:select>
                          </td>
                      </tr>
                      <tr>
                          <td>
                          
                             <div id="prtflPosSummaryChart"></div>
                          </td>
                      </tr>
                   </table>
               </td>
         </table>
     </tr>
</table>
<script type="text/javascript"> 
 $(document).ready(function(){
	 onLoadPortfolioPositionCharts()
 });
</script>