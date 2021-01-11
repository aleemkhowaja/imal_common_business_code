<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>   

			 <ps:url id="urlFinancingDealsLimitUtilizationDtlsGrid" action="financingDealsListAction_loadFinancingDealsLimitUtilizationData" namespace="/path/globalview" escapeAmp="false">
				 <ps:param name="iv_crud"      			  		value="iv_crud"></ps:param>
				 <ps:param name="_pageRef"      		 		value="_pageRef"></ps:param>
				 <ps:param name="financingDealsSC.cifNo" 		value="financingDealsSC.cifNo"></ps:param>		
				 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>		
			 </ps:url>
			 <psjg:grid
			    	id				="financingDealsLimitUtilizationDtlsGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlFinancingDealsLimitUtilizationDtlsGrid}"  	    
			        dataType        ="json"       
			    	pager           ="true"
			    	sortable        ="true"
					filter          ="true"
			    	gridModel       ="gridModel"    	 
					viewrecords     ="true" 
					navigator       ="false"
					altRows         ="true"
					navigatorRefresh="false" 
					navigatorAdd    ="false"
					navigatorDelete ="false"
					navigatorEdit   ="false"
					pagerButtons    ="true" 
					navigatorSearch ="false"
			         
			        rowNum="20"         
					rowList="5,10,15,20"   
					height="230"
					caption = "Limit Utilization Details"
			        >	
			      		        			         
			       <psjg:gridColumn id="limitAmt"	      index="globalLimit"          name="globalLimit"         title="%{getText('Limit_Amount_key')}"         colType="number"   sortable="true" search="true" formatter="financingDealsLimitUtilizationLimitAmt" formatCol="decimalPoints"   />
			       <psjg:gridColumn id="utilizedAmt"      index="utilizedAmt"      	name="utilizedAmt"      	title="%{getText('Utilized_Amount_key')}"      colType="number"   sortable="true" search="true" formatter="currencyFmatter" formatCol="decimalPoints" />
			       <psjg:gridColumn id="outStandingAmt"   index="outstandingAmt"        name="outstandingAmt"       title="%{getText('outstanding_amount_key')}"          colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="decimalPoints"  />
			       <psjg:gridColumn id="currencyDesc"     index="currencyDesc"    name="currencyDesc"   title="%{getText('Currency_key')}"      colType="text" sortable="true" search="true"/>
			       <psjg:gridColumn id="currDecPoints"     index="decimalPoints"    name="decimalPoints"   title="%{getText('Currency_Decimal_Points_key')}"      colType="text" sortable="true" search="true" hidden="true"/>
			       
			       
			       
			 </psjg:grid>