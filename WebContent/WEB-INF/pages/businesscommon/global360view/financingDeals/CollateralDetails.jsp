<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>   

 <ps:url id="urlFinancingDealsCollateralDtlsGrid" action="financingDealsListAction_loadFinancingDealsCollateralData" namespace="/path/globalview" escapeAmp="false">
				 <ps:param name="iv_crud"      			  		value="iv_crud"></ps:param>
				 <ps:param name="_pageRef"      		 		value="_pageRef"></ps:param>
				 <ps:param name="financingDealsSC.cifNo" 		value="financingDealsSC.cifNo"></ps:param>
				 <ps:param name="financingDealsSC.dealNo" 		value="financingDealsSC.dealNo"></ps:param>
				 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
				 <ps:param name="financingDealsSC.branchCode" value="financingDealsSC.branchCode"></ps:param>
				 
				
			 </ps:url>
			 <psjg:grid
			    	id				="financingDealsCollateralDtlsGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlFinancingDealsCollateralDtlsGrid}"  	    
			        dataType        ="json"       
			    	pager           ="true"
			    	sortable        ="true"
					filter          ="false"
			    	gridModel       ="gridModel"    	 
					viewrecords     ="true" 
					navigator       ="true"
					altRows         ="true"
					navigatorRefresh="false" 
					navigatorAdd    ="false"
					navigatorDelete ="false"
					navigatorEdit   ="false"
					pagerButtons    ="false" 
					navigatorSearch ="false"
			        shrinkToFit     ="false"
			        height="230"
			        caption="%{getText('Collateral_Details_key')}"
					userDataOnFooter="true"
					footerrow="true"
					onCompleteTopics="onFinancingDealsCollateralGridLoad"	  
			        >	
			     		   
				   <psjg:gridColumn id="collateralBranch"       index="trsCollateralDetVO.COLLATERAL_BRANCH"          name="trsCollateralDetVO.COLLATERAL_BRANCH"         title="%{getText('BranchCode_key')}"         colType="number"   sortable="true" search="true"/>			     		        			         
			       <psjg:gridColumn id="collateralNo"	      index="trsCollateralDetVO.COLLATERAL_NO"          name="trsCollateralDetVO.COLLATERAL_NO"         title="%{getText('Collateral_No_key')}"         colType="number"   sortable="true" search="true"/>
			       <psjg:gridColumn id="briefName"      index="fmsCollateralVO.BRIEF_NAME_ENG"      	name="fmsCollateralVO.BRIEF_NAME_ENG"      	title="%{getText('Collateral_Name_key')}"      colType="text"   sortable="true" search="true" />
			       <psjg:gridColumn id="currency"          index="fmsCollateralVO.CURRENCY"        name="fmsCollateralVO.CURRENCY"       title="%{getText('Currency_key')}"          colType="number" sortable="true" search="true"  />
			       <psjg:gridColumn id="collateralType"      index="collateralType"    name="collateralType"   title="%{getText('Collateral_Type_key')}"      colType="text" sortable="true" search="true"/>
			       <psjg:gridColumn id="appRef"	  index="fmsCollateralVO.APPL_REF"      name="fmsCollateralVO.APPL_REF"     title="%{getText('Application_Ref_key')}"     colType="text"   sortable="true" search="true"  nbFormat="#,###.##" />
			       <psjg:gridColumn id="facilityCoverage"	      index="fmsCollateralVO.FACILITY_COVERAGE"        name="fmsCollateralVO.FACILITY_COVERAGE"       title="%{getText('Facility_Coverage_percentage_key')}"          colType="number" sortable="true" search="true"/>
			       <psjg:gridColumn id="leverageRatio"	      index="fmsCollateralVO.LEVERAGE_RATIO"        name="fmsCollateralVO.LEVERAGE_RATIO"       title="%{getText('Leverage_Ratio_percentage_key')}"       colType="number" sortable="true" search="true" />
			       <psjg:gridColumn id="apprCoverage"	  index="fmsCollateralVO.APPROVED_COVERAGE"       name="fmsCollateralVO.APPROVED_COVERAGE"      title="%{getText('Approved_Coverage_percentage_key')}"      colType="text" sortable="true" search="true"/>
			       <psjg:gridColumn id="acceptValue"  index="fmsCollateralVO.ACCEPT_VALUE"   name="fmsCollateralVO.ACCEPT_VALUE"  title="%{getText('Accept_Value_key')}" colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"  />
			       <psjg:gridColumn id="marketValue"  index="fmsCollateralVO.MARKET_VALUE"   name="fmsCollateralVO.MARKET_VALUE"  title="%{getText('Market_Value_key')}" colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="actualAllocated"  index="fmsCollateralVO.ACTUAL_ALLOCATED"   name="fmsCollateralVO.ACTUAL_ALLOCATED"  title="%{getText('Actual_Allocated_key')}" colType="number" sortable="true" search="true" />
			       <psjg:gridColumn id="dealAllocated"  index="trsCollateralDetVO.DEAL_ALLOCATED"   name="trsCollateralDetVO.DEAL_ALLOCATED"  title="%{getText('Deal_Allocated_key')}" colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"  />
			       
			       
			       
			       
			 </psjg:grid>
			 
			 
		 <script>
  $(document).ready(function () {
	   $("#financingDealsCollateralDtlsGridTbl_Id_"+_pageRef).unsubscribe("onFinancingDealsCollateralGridLoad");
 		$("#financingDealsCollateralDtlsGridTbl_Id_"+_pageRef).subscribe("onFinancingDealsCollateralGridLoad",function(response,html){ 		    
			 
			 var gridModel = response.originalEvent.request.gridModel;
		     if(gridModel!=undefined&&gridModel.length>0){			
				nbFormat = returnNbFormat(gridModel[0].currDecimalPoints);				 	
				$("#financingDealsCollateralDtlsGridTbl_Id_"+_pageRef).jqGrid('footerData', 'set', {"trsCollateralDetVO.DEAL_ALLOCATED" :	$.formatNumberNumeric($("#financingDealsCollateralDtlsGridTbl_Id_"+_pageRef).jqGrid('getCol', 'trsCollateralDetVO.DEAL_ALLOCATED', false, 'sum'), {format: nbFormat,applyRounding:true}) }, false);
		
			 
									    }
  
		});
	});
 
 </script>