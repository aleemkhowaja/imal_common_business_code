<psjg:grid
   	id="finAppAndAprvdLinesGridTbl_Id_${_pageRef}" 
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
    <psjg:gridColumn id="approvedLines"	   index="approvedLines"    name="approvedLines"    title="%{getText('approvedLines_key')}"    colType="number"  editable="false" sortable="false" search="false" formatter="formatAprvdLinesLink"        formatCol="decimal_points"/>
    <psjg:gridColumn id="newApplications"  index="newApplications"  name="newApplications"  title="%{getText('newApp_key')}"           colType="number" editable="false" sortable="false" search="false"  formatter="formatNewAppLink"            formatCol="decimal_points"/>
    <psjg:gridColumn id="blockedOrSuspFac" index="blockedOrSuspFac" name="blockedOrSuspFac" title="%{getText('blockedOrSuspFac_key')}" colType="number" editable="false" sortable="false" search="false"  formatter="formatSuspendedFacilityLink" formatCol="decimal_points"/>
    <psjg:gridColumn id="collaterals"	   index="collaterals"      name="collaterals"      title="%{getText('collaterals_key')}"      colType="number" editable="false" sortable="false" search="false"  formatter="formatCollateralsLink"       formatCol="decimal_points"/>
    <psjg:gridColumn id="guarantees"	   index="guarantees"       name="guarantees"       title="%{getText('guarantees_key')}"       colType="number" editable="false" sortable="false" search="false"  formatter="formatGuaranteesLink"        formatCol="decimal_points"/>
    <psjg:gridColumn id="drawdowns"        index="drawdowns"        name="drawdowns"        title="%{getText('drawdowns_key')}"        colType="number" editable="false" sortable="false" search="false" formatter="formatDrawDownsLink" 		  formatCol="decimal_points"/>
</psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var finAppAndAprvdKey 	= "<ps:text name='finAppAndApproveLines_key'/>";
 $("#finAppAndAprvdLinesGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'approvedLines', numberOfColumns: 6, titleText: finAppAndAprvdKey}
	  ]
	});	

 </script>
