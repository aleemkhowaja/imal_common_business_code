<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>
 <!-- @author: tonyelkhoury 2017 -->
 <html>
<body>
		<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
		<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
       <div id="criteriaDiv_id">
	    <ps:url id="urlCriteriaGrid" action="criteriaList_loadCriteriaGrid" namespace="/path/criteria" escapeAmp="false">
	
				<ps:param name="iv_crud" value="iv_crud"></ps:param>
				<ps:param name="_pageRef" value="_pageRef"></ps:param>
			</ps:url>
			
			<psjg:grid
				id="criteriaGridTbl_Id_${_pageRef}"
				caption=" "
				href="%{urlCriteriaGrid}"
				dataType="json"
				hiddengrid='%{iv_crud == "R"}'
				pager="true"
				filter="true"
				gridModel="gridModel"
				viewrecords="true"
				rowNum="5"
				navigator="true"
				height="115"
				rowList="5,10,15,20"
				altRows="true"
				navigatorRefresh="false"
				navigatorDelete="false"
				navigatorEdit="false"
				navigatorAdd="false"
				navigatorSearch  ="true"
    			navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				shrinkToFit="true"
				sortorder="desc"
				ondblclick="criteria_onDbClickedEvent()"
				addfunc   ="criteria_onAddClicked" >
				
				<psjg:gridColumn name="ctsCriteriaVO.CRITERIA_CODE"			title="%{getText('criteria_code_key')}" 	  	index="CRITERIA_CODE"		colType="number" editable="false" sortable="true" search="true"	id="CRITERIA_CODE_${_pageRef}"  />
				<psjg:gridColumn name="ctsCriteriaVO.CRITERIA_DESC"			title="%{getText('criteria_desc_key')}"	  		index="CRITERIA_DESC"		colType="text" editable="false" sortable="true" search="true"	id="CRITERIA_DESC_${_pageRef}" />
				<psjg:gridColumn name="ctsCriteriaVO.CRITERIA_REFERENCE"	title="%{getText('Reference_key')}"	  		index="CRITERIA_REFERENCE"		colType="text" editable="false" sortable="true" search="true"	id="CRITERIA_REFERENCE_${_pageRef}" />
				
				</psjg:grid>
		</div>
		
		<div id="criteriaDiv_id_${_pageRef}" class="collapsibleContainer">
			<ps:if test='iv_crud == "R"'>
				<%@include file="CriteriaMaint.jsp"%>
			</ps:if>
		</div>

 
</body>
<script type="text/javascript">
    var criteriaKey = "<ps:text name='criteria.criteriaList' />";
    $.struts2_jquery.require("CriteriaList.js", null, jQuery.contextPath+ "/businesscommon/js/core/criteria/");
	$(document).ready(criteria_ListLoad);
</script>
</html> 


				