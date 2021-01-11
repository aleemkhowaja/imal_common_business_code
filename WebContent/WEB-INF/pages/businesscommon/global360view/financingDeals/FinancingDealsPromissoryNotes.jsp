<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>


<ps:url id="urlFinancingDealsPromissoryNotesGrid" action="financingDealsListAction_loadFinancingDealsPromissoryNotesData" namespace="/path/globalview" escapeAmp="false">
		 <ps:param name="iv_crud"      			 value="iv_crud"></ps:param>
		 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
		 <ps:param name="financingDealsSC.cifNo" value="financingDealsSC.cifNo"></ps:param>
		 <ps:param name="financingDealsSC.category" value="financingDealsSC.category"></ps:param>	
		 <ps:param name="financingDealsSC.branchFilter" value="financingDealsSC.branchFilter"></ps:param>
	 </ps:url>
	 <psjg:grid
	    	id				="financingDealsPromissoryNotesGridTbl_Id_${_pageRef}" 
	  	    href            ="%{urlFinancingDealsPromissoryNotesGrid}"  	    
	        dataType        ="json"       
	    	pager           ="true"
	    	sortable        ="true"
			filter          ="false"
	    	gridModel       ="gridModel"    	 
			viewrecords     ="true" 
			navigator       ="false"
			altRows         ="true"
			navigatorRefresh="false" 
			navigatorAdd    ="false"
			navigatorDelete ="false"
			navigatorEdit   ="false"
			pagerButtons    ="false" 
			navigatorSearch ="false"
	        shrinkToFit     ="false"
	        rowNum="20"         
			rowList="5,10,15,20"   
			height="230"
			caption="%{getText('promissioryNotes_key')}"
			 
			
	        >	 
	        			         
	       <psjg:gridColumn id="fromFacility"	      index="fromFacility"          name="fromFacility"         title="%{getText('from_facility_key')}"         colType="text"   sortable="true" search="true"/>
	       <psjg:gridColumn id="serialNo"      index="trsDealVO.SERIAL_NO"      	name="trsDealVO.SERIAL_NO"      	title="%{getText('Deal_No_key')}"      colType="text"   sortable="true" search="true" />
	       <psjg:gridColumn id="dealCy"          index="trsDealVO.DEAL_CY"        name="trsDealVO.DEAL_CY"       title="%{getText('Deal_Currency_key')}"          colType="number" sortable="true" search="true" />
	       <psjg:gridColumn id="repaymentDate"      index="valueDate"    name="valueDate"   title="%{getText('Repayment_Date_key')}"      colType="date" sortable="true" search="true"/>
	       <psjg:gridColumn id="dealCurrAmt"      index="amount"    name="amount"   title="%{getText('Amount_in_Deal_Currency_key')}"      colType="number" sortable="true" search="true"  formatter="currencyFmatter" formatCol="currDecimalPoints" />     	   
	       <psjg:gridColumn id="comCurrAmt"	  index="cvAmt"      name="cvAmt"     title="%{getText('Amount_in_Company_Currency_key')}"     colType="number"   sortable="true" search="true"  formatter="currencyFmatter" formatCol="baseCurrDecPoint"  width="200" />
	       
	       
	       
	 </psjg:grid>
	 
	  