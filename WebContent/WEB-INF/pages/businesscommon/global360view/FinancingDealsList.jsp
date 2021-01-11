
<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

 <psjg:grid
    	id				="financingDealsGridTbl_Id_${_pageRef}" 
        dataType        ="json"
        hiddengrid      ="false"
    	pager           ="false"
    	sortable        ="false"
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
        shrinkToFit     ="true">	 			         
       <psjg:gridColumn id="decimalPoints"    index="decimalPoints"   colType="number" name="decimalPoints"  title=" "  hidden="true"/>
       <psjg:gridColumn id="category"	      index="category"          name="category"         title="%{getText('Category_key')}"     colType="String" editable="false" sortable="false" search="false" />
       <psjg:gridColumn id="totalAmount"      index="totalAmt"      	name="totalAmt"      	title="%{getText('total_amount_key')}"      colType="number" editable="false" sortable="false" search="false" formatter="financingDealsLink" formatCol="decimalPoints"/>
       <psjg:gridColumn id="settled"          index="settledAmt"        name="settledAmt"       title="%{getText('settled_key')}"          colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="outstanding"      index="outstandingAmt"    name="outstandingAmt"   title="%{getText('outstanding_key')}"      colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="earnedProfit"	  index="earnedProfit"      name="earnedProfit"     title="%{getText('earnedProfit_key')}"     colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="overdue"	      index="overdueAmt"        name="overdueAmt"       title="%{getText('overdue_key')}"          colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="guarantees"	      index="guarantees"        name="guarantees"       title="%{getText('guarantees_key')}"       colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="collaterals"	  index="collaterals"       name="collaterals"      title="%{getText('collaterals_key')}"      colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter" formatCol="decimalPoints"/>
       <psjg:gridColumn id="promissioryNotes" index="promissoryNotes"   name="promissoryNotes"  title="%{getText('promissioryNotes_key')}" colType="number" editable="false" sortable="false" search="false" formatter="financingDealsPromissoryNotesLink" formatCol="decimalPoints"/>
 </psjg:grid>
 <script type="text/javascript">


  //Setting multi header columns
 var financingDealsKey 	= "<ps:text name='finDeals_key'/>";
 $("#financingDealsGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'category', numberOfColumns: 9, titleText: financingDealsKey}
	  ]
	});								
 </script>
