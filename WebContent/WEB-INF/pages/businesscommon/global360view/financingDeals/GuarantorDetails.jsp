<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>   

 <ps:url id="urlFinancingDealsGuarantorDtlsGrid" action="financingDealsListAction_loadFinancingDealsGuarantorData" namespace="/path/globalview" escapeAmp="false">
				 <ps:param name="iv_crud"      			  		value="iv_crud"></ps:param>
				 <ps:param name="_pageRef"      		 		value="_pageRef"></ps:param>
				 <ps:param name="financingDealsSC.cifNo" 		value="financingDealsSC.cifNo"></ps:param>				
				 <ps:param name="financingDealsSC.dealNo" value="financingDealsSC.dealNo"></ps:param>
				 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
				 <ps:param name="financingDealsSC.branchCode" value="financingDealsSC.branchCode"></ps:param>
				
			 </ps:url>
			 <psjg:grid
			    	id				="financingDealsGuarantorDtlsGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlFinancingDealsGuarantorDtlsGrid}"  	    
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
					caption="%{getText('Guarantor_Details_key')}"
					userDataOnFooter="true"	
					onCompleteTopics="onFinancingDealsGuarantorGridLoad"   
					footerrow="true" 
			        >	
			      		        			         
			       <psjg:gridColumn id="guarantorNo"	      index="trsDealGuarantorVO.GUARANTOR_CIF"          name="trsDealGuarantorVO.GUARANTOR_CIF"         title="%{getText('Guarantor_No_key')}"         colType="number"   sortable="true" search="true"  />
			       <psjg:gridColumn id="guarantorName"      index="guarantorName"      	name="guarantorName"      	title="%{getText('Guarantor_Name_key')}"      colType="text"   sortable="true" search="true" />
			       <psjg:gridColumn id="amount"          index="trsDealGuarantorVO.GUARANTOR_AMOUNT"        name="trsDealGuarantorVO.GUARANTOR_AMOUNT"       title="%{getText('Amount_key')}"          colType="number" sortable="true" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints" />
			       <psjg:gridColumn id="amountWithComp"      index="trsDealGuarantorVO.AMOUNT_WITH_COMPANY"    name="trsDealGuarantorVO.AMOUNT_WITH_COMPANY"   title="%{getText('Amount_With_Company_key')}"      colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"/>
			       <psjg:gridColumn id="amountWithClient"      index="trsDealGuarantorVO.AMOUNT_WITH_CLIENT"    name="trsDealGuarantorVO.AMOUNT_WITH_CLIENT"   title="%{getText('Amount_With_Client_key')}"      colType="number" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"/>
			       <psjg:gridColumn id="branch"	  index="trsDealGuarantorVO.ACC_BRANCH"      name="trsDealGuarantorVO.ACC_BRANCH"     title="%{getText('BR_key')}"     colType="number"   sortable="true" search="true"  nbFormat="#,###.##" />
			       <psjg:gridColumn id="currency"	      index="trsDealGuarantorVO.ACC_CURRENCY"        name="trsDealGuarantorVO.ACC_CURRENCY"       title="%{getText('CY_key')}"          colType="number" sortable="true" search="true"/>
			       <psjg:gridColumn id="gl"	      index="trsDealGuarantorVO.ACC_GL_CODE"        name="trsDealGuarantorVO.ACC_GL_CODE"       title="%{getText('GL_key')}"       colType="number" sortable="true" search="true" />
			       <psjg:gridColumn id="cif"	  index="trsDealGuarantorVO.ACC_CIF_NO"       name="trsDealGuarantorVO.ACC_CIF_NO"      title="%{getText('CIF_key')}"      colType="number" sortable="true" search="true"/>
			       <psjg:gridColumn id="sl"  index="trsDealGuarantorVO.ACC_SL_NO"   name="trsDealGuarantorVO.ACC_SL_NO"  title="%{getText('SL_key')}" colType="number" sortable="true" search="true" />
			       <psjg:gridColumn id="accountName"  index="accName"   name="accName"  title="%{getText('Account_Name_key')}" colType="text" sortable="true" search="true"/>
			       
			       
			 </psjg:grid>
			 
			 
 <script>
  $(document).ready(function () {
	   $("#financingDealsGuarantorDtlsGridTbl_Id_"+_pageRef).unsubscribe("onFinancingDealsGuarantorGridLoad");
 		$("#financingDealsGuarantorDtlsGridTbl_Id_"+_pageRef).subscribe("onFinancingDealsGuarantorGridLoad",function(response,html){ 		    
			 
			 var gridModel = response.originalEvent.request.gridModel;
		     if(gridModel!=undefined&&gridModel.length>0){			
				nbFormat = returnNbFormat(gridModel[0].currDecimalPoints);				 	
				$("#financingDealsGuarantorDtlsGridTbl_Id_"+_pageRef).jqGrid('footerData', 'set', {"trsDealGuarantorVO.GUARANTOR_AMOUNT" :	$.formatNumberNumeric($("#financingDealsGuarantorDtlsGridTbl_Id_"+_pageRef).jqGrid('getCol', 'trsDealGuarantorVO.GUARANTOR_AMOUNT', false, 'sum'), {format: nbFormat,applyRounding:true}) }, false);
		
			 
									    }
  
		});
	});
 
 </script>