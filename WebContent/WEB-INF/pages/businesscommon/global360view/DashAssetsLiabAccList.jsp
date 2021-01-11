<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
	
	<script type="text/javascript">
$.struts2_jquery.require("highcharts.js", null, jQuery.contextPath + "/common/jquery/js/highchart/");
//$.struts2_jquery.require("jquery.jqplot.js,jqplot.pieRenderer.js,jqplot.dateAxisRenderer.js,jqplot.highlighter.js,jqplot.cursor.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
//if($.browser.msie && $.browser.version <= 8)
//$.struts2_jquery.require("excanvas.js", null, jQuery.contextPath + "/common/jquery/js/charting/");
</script>
	
	  <psjg:grid  
		    	id="assetsLiabAccGridTbl_Id_${_pageRef}" 
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
		           <psjg:gridColumn id="decimal_points"     index="decimal_points"   colType="number" name="decimal_points"  title=" "  hidden="true"/>	 			         
			       <psjg:gridColumn id="categoryId"	        index="categoryId"         name="categoryId"        title=" "                                  colType="number" editable="false" sortable="false" search="false" hidden="true" />
			       <psjg:gridColumn id="category"	        index="category"           name="category"          title="%{getText('Category_key')}"         colType="text"   editable="false" sortable="false" search="false"/>
			       <psjg:gridColumn id="totalNbrAcc"	    index="totalNbrAcc"        name="totalNbrAcc"       title="%{getText('totNumOfAcc_key')}"      colType="number" editable="false" sortable="false" search="false" formatter="openParams"/>
			       <psjg:gridColumn id="currentBalance"	    index="currentBalance"     name="currentBalance"    title="%{getText('currentBalance_key')}"   colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			       <psjg:gridColumn id="availableBalance"   index="availableBalance"   name="availableBalance"  title="%{getText('availableBalance_key')}" colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			       <psjg:gridColumn id="blockedAmount"	    index="blockedAmount"      name="blockedAmount"     title="%{getText('blockedAmount_key')}"    colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			       <psjg:gridColumn id="overdrawLimit"	    index="overdrawLimit"      name="overdrawLimit"     title="%{getText('overdrawLimit_key')}"    colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter"     formatCol="decimal_points"/>
			       <psjg:gridColumn id="duesAssetLiablAmt"	index="duesAssetLiablAmt"  name="duesAssetLiablAmt" title="%{getText('Dues_Amount_key')}"      colType="number" editable="false" sortable="false" search="false" formatter="currencyFmatter"     formatCol="decimal_points"/>
	   </psjg:grid>
	  
 <script type="text/javascript">

 var gridHeaderKey 	= "<ps:text name='assetsAndLiabilitiesAcc_key'/>";
 $("#assetsLiabAccGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'category', numberOfColumns: 6, titleText: gridHeaderKey}
	  ]
	});								
 </script>
