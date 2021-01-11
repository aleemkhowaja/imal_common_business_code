<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<div style ="width:465px">
    <psjg:grid
    	id="currencyGridTbl_Id" caption=" "
  	    href="%{url}" dataType="json" 
  	    sortable="true" filter="true"
    	gridModel="gridModel" rowList="5,10,15,20" rowNum="5"
    	pager="true" viewrecords="true" 
        altRows="true" ondblclick="returnCurrencyCode()"
        navigatorRefresh="false" 
        navigatorSearch="false"
        shrinkToFit="false" >
		<psjg:gridColumn id="CURRENCY_CODE" colType="text" name="CURRENCY_CODE" index="CURRENCY_CODE" title="%{getText('Currency_Code_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="ADDITIONAL_REFERENCE" colType="text" name="ADDITIONAL_REFERENCE" index="ADDITIONAL_REFERENCE" title="%{getText('Additional_Ref_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="BRIEF_DESC_ENG"  colType="text" name="BRIEF_DESC_ENG" index="BRIEF_DESC_ENG" title="%{getText('Brief_Description_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="LONG_DESC_ENG"  colType="text" name="LONG_DESC_ENG" index="LONG_DESC_ENG" title="%{getText('Long_Description_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="BRIEF_DESC_ARAB"  colType="text" name="BRIEF_DESC_ARAB" index="BRIEF_DESC_ARAB" title="%{getText('Brief_Desc_Arab_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="LONG_DESC_ARAB"  colType="text" name="LONG_DESC_ARAB" index="LONG_DESC_ARAB" title="%{getText('Long_Desc_Arab_key')}" editable="false" sortable="true" search="true"/>
	</psjg:grid>
</div>	
	<script type="text/javascript">
		$("#gview_currencyGridTbl_Id div.ui-jqgrid-titlebar").hide();
	    function returnCurrencyCode()
		{
			var currencyGrid = $("#currencyGridTbl_Id");
			selRow = currencyGrid.jqGrid("getGridParam", 'selrow');
			document.getElementById("returnCurrencyCode_"+_pageRef).value = currencyGrid.jqGrid('getCell', selRow,'CURRENCY_CODE');
			if(_pageRef=="D001RE")
			{
				bulkRemittance_openCurrencyChange(currencyGrid.jqGrid('getRowData',selRow));
			}
			else
			{
				$("#trsfr_method_"+_pageRef).trigger("change");
			}
			$("#dialog_div_"+_pageRef).remove();
		}
		
	</script>	
