<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

 <ps:hidden id="investTreasuryCash_${_pageRef}" value="%{getText('cash_key')}"	name="investTreasuryCash"/>
 <ps:hidden id="investTreasuryHolding_${_pageRef}" value="%{getText('holding_key')}"	name="investTreasuryHolding"/>
	 
 <div id="investmentTreasuryChart" chartName='<ps:text name="investments_key" />'></div>


	  <psjg:grid
		    	id="investTreasuryGridTbl_Id_${_pageRef}" 
                dataType        ="json"
                hiddengrid      ="false"
		    	pager           ="false"
		    	sortable        ="false"
				filter          ="false"
		    	gridModel       ="gridModel"
		    	rowNum          ="5"
				rowList         ="5,10,15,20"
				viewrecords     ="true" 
				navigator       ="false"
				altRows         ="true"
				navigatorRefresh="false" 
				navigatorAdd    ="false"
				navigatorDelete ="false"
				navigatorEdit   ="false"
				pagerButtons    ="false" 
				navigatorSearch ="false"
		        shrinkToFit     ="true">
		           <psjg:gridColumn id="decimal_points"    index="decimal_points"   colType="number" name="decimal_points"  title=" "  hidden="true"/>	 			         
			       <psjg:gridColumn id="cash"	            index="investTreasury_cash"               name="investTreasury_cash"               title="%{getText('cash_key')}"               colType="number" editable="false" sortable="false" search="false" formatter="investmentsDetails"  formatCol="decimal_points"/>
			       <psjg:gridColumn id="holding"            index="investTreasury_holding"            name="investTreasury_holding"            title="%{getText('holding_key')}"            colType="number" editable="false" sortable="false" search="false" formatter="investmentsDetails"  formatCol="decimal_points"/>
			       <ps:if test='${dashboardCO.treasuryOpt == "true"}'>
			          <psjg:gridColumn id="forex"              index="investTreasury_forex"              name="investTreasury_forex"              title="%{getText('forex_key')}"              colType="number" editable="false" sortable="false" search="false" formatter="treasuryForexDetails"             formatCol="decimal_points"/>
			          <psjg:gridColumn id="moneyMarket"        index="investTreasury_moneyMarket"        name="investTreasury_moneyMarket"        title="%{getText('moneyMarket_key')}"        colType="number" editable="false" sortable="false" search="false" formatter="treasuryMoneyMarketDetails"  formatCol="decimal_points" />
			          <psjg:gridColumn id="islamicDerivatives" index="investTreasury_islamicDerivatives" name="investTreasury_islamicDerivatives" title="%{getText('islamicDerivatives_key')}" colType="number" editable="false" sortable="false" search="false"  formatter="treasuryDerivativesDetails" formatCol="decimal_points"/>
	               </ps:if>
	   </psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var investKey 	 = "<ps:text name='investments_key'/>";
 var treasuryKey = "<ps:text name='treasury_key'/>";
 var treasuryOpt = $("#treasuryOpt_"+_pageRef).val();
 if(treasuryOpt == "true")
	 {	 
		 $("#investTreasuryGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
			  useColSpanStyle: true, 
			  groupHeaders:[
				{startColumnName: 'investTreasury_cash', numberOfColumns: 2, titleText: investKey},{startColumnName: 'investTreasury_forex', numberOfColumns: 3, titleText: treasuryKey}
			  ]
			});								
	 }
 else
	 {
		 $("#investTreasuryGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
			  useColSpanStyle: true, 
			  groupHeaders:[{startColumnName: 'investTreasury_cash', numberOfColumns: 2, titleText: investKey}]
			});
	 }
 </script>
