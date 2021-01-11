<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 
	
	
	 <jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
	 
	  	<ps:hidden id="iv_crud_${_pageRef}"  		 name="iv_crud"></ps:hidden>
	  	
	  	<ps:url id="urlOneObligorTrendsGrid" escapeAmp="false" action="dashOneObligorListAction_loadOneObligorTrendsDetlsGrid" namespace="/path/globalview/">
	  		<ps:param name="iv_crud" value="iv_crud"></ps:param>
	  		<ps:param name="_pageRef" value="_pageRef"></ps:param>
	  		<ps:param name="dashOneObligorSC.oneObligorCode" value="dashOneObligorCO.rifOBTVO.OBLIGOR_CODE"></ps:param>
	  	</ps:url> 
	  	<ps:url id="editurl" escapeAmp="false" namespace="/path/manualbatching" action="ManualBatchingMaint_dependencyBankCIF"/>
	  	
	  <psjg:grid
		  id="oneObligorTrendsDetlsGridTbl_Id_${_pageRef}"
		  href="%{urlOneObligorTrendsGrid}"
		  dataType="json"
		  hiddengrid="false"
		  pager="true" 
		  filter="true"
		  gridModel="gridModel" 
		  rowNum="5"
		  rowList="5,10,15,20"
		  viewrecords="true" 
		  navigator="true" 
		  height="150"
	      sortable="true"
		  altRows="true"
		  navigatorAdd="false"
		  navigatorDelete="false"
		  navigatorRefresh="false"
		  navigatorSearch="true"
		  shrinkToFit="true"
		  editinline="true"
		  rownumbers="true"
		  navigatorEdit="false"
		  editurl=" "
		  navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
		  addfunc=""
		  ondblclick=""
		  multiboxonly="false" 
		  footerrow="true">
		  
	    <psjg:gridColumn id="CTSTRX_TYPE"       colType="liveSearch" name="rifOBTTrendsDetVO.CTSTRX_TYPE" 		     index="CTSTRX_TYPE"       title="%{getText('Transaction_key')}" 						 editable="false"  mode="number"    sortable="true"/>
	    <psjg:gridColumn id="CTSTRXTYPE_DESC"   colType="text"       name="ctsTrxTypeDesc"                           index="CTSTRXTYPE_DESC"   title="%{getText('Trx_Type_Desc_key')}" 						 editable="false"  mode="number"    sortable="true"/> 
	  	<psjg:gridColumn id="PERIODICITY_TYPE" 	colType="text"       name="rifOBTTrendsDetVO.PERIODICITY_TYPE" 	     index="PERIODICITY_TYPE"  title="%{getText('Periodicity_Type_key')}" 					 editable="false" sortable="true" search="true"/>
	  	<psjg:gridColumn id="PERIODICITY" 		colType="number"     name="rifOBTTrendsDetVO.PERIODICITY" 	   	     index="PERIODICITY" 	  title="%{getText('Periodicity__key')}" 						 editable="false" sortable="true" search="true"/>
	  	<psjg:gridColumn id="DECIMAL_POINTS"    colType="number"	 name="decimalPts"     					         index="DECIMAL_POINTS"	  title="hidden"  			                                     editable="false"	sortable="true" 	search="true"  hidden="true"/>
	  	<psjg:gridColumn id="SINGLE_TRX_AMT" colType="number"     name="rifOBTTrendsDetVO.SINGLE_TRX_AMT"      index="SINGLE_TRX_AMT" title="%{getText('Single_Transaction_Amount_in_Base_CY_key')}"  editable="false" sortable="true" search="true" nbFormat="${dashOneObligorCO.currecnyFormatter}"/>
	  	<psjg:gridColumn id="TOTAL_TRX_AMT" 	colType="number"     name="rifOBTTrendsDetVO.TOTAL_TRX_AMT" 	     index="TOTAL_TRX_AMT"  title="%{getText('Total_Transaction_Amount_in_Base_CY_key')}"  editable="false" sortable="true" search="true" nbFormat="${dashOneObligorCO.currecnyFormatter}" />
	  </psjg:grid> 	

