<psjg:grid
   	id="tradeFinanceOperationsGridTbl_Id_${_pageRef}" 
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
    <psjg:gridColumn id="decimal_points"   index="decimal_points"   colType="number" name="decimal_points"  title=" "  hidden="true"/>
    <psjg:gridColumn id="inOutLC"	       index="inOutLC"          name="inOutLC"          title="%{getText('inOutLC_key')}"          colType="number" editable="false" sortable="false" search="false"  formatter="formatInOutLCLink"           formatCol="decimal_points"/>
    <psjg:gridColumn id="lgs"	           index="lgs"              name="lgs"              title="%{getText('LGs_key')}"              colType="number" editable="false" sortable="false" search="false"  formatter="formatLGLink"                formatCol="decimal_points" />
    <psjg:gridColumn id="inOutBills"	   index="inOutBills"       name="inOutBills"       title="%{getText('inOutBills_key')}"       colType="number" editable="false" sortable="false" search="false"  formatter="formatInOutBillsLink"        formatCol="decimal_points"/>
    <psjg:gridColumn id="acceptance"	   index="acceptance"       name="acceptance"       title="%{getText('acceptance_key')}"       colType="number" editable="false" sortable="false" search="false"  formatter="formatAcceptanceLink"        formatCol="decimal_points"/>  
</psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var tradeFinOperKey    = "<ps:text name='tradeFinOper_key'/>";
 $("#tradeFinanceOperationsGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
	   {startColumnName: 'inOutLC', numberOfColumns: 4, titleText: tradeFinOperKey}
	  ]
	});	

 </script>
