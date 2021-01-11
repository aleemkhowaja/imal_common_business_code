
<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlTresuryDerivativesGrid" action="treasuryListAction_loadTreasuryDerivativesData" namespace="/path/globalview" escapeAmp="false">	 
	 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
	 <ps:param name="treasurySC.cifNo" 		 value="treasurySC.cifNo"></ps:param>
	 <ps:param name="treasurySC.branchFilter" value="treasurySC.branchFilter"></ps:param>
 </ps:url>
 <psjg:grid
    	id				="tresuryDerivatesGridTbl_Id_${_pageRef}" 
  	    href            ="%{urlTresuryDerivativesGrid}"
        dataType        ="json"
        hiddengrid      ="false"
    	pager           ="false"
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
        shrinkToFit     ="true">	 			         
       <psjg:gridColumn id="currency"	  	   index="currencyDesc"     name="currencyDesc"     title="%{getText('Currency_key')}"     	   			  colType="String" editable="false" sortable="true" search="true" />
       <psjg:gridColumn id="profitRateSwap"    index="profitRateSwap"   name="profitRateSwap"   title="%{getText('Islamic_Profit_Rate_Swap_key')}"    colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
       <psjg:gridColumn id="promissoryFX"      index="promissoryFX"     name="promissoryFX"     title="%{getText('Islamic_Promissory_FX_key')}"       colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints" />
       <psjg:gridColumn id="crossCYSwap"       index="crossCYSwap"      name="crossCYSwap"      title="%{getText('Islamic_Cross_Currency_Swap_key')}" colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatter" formatCol="currDecimalPoints"/>       
 </psjg:grid>
  
