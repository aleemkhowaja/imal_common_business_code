<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>
		<ps:url id="urlAuthorizedSigGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashAuthorizedSigListAction?_pageRef=${_pageRef}">
		   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="authorizedSigListGridTbl_Id_${_pageRef}" 
				caption="%{getText('Authorized_signatory_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlAuthorizedSigGrid_${_pageRef}}"
		        navigator="true" 
		        navigatorAdd="false"
		        navigatorDelete="false"
		        navigatorEdit="false"
		        navigatorRefresh="false"
		        navigatorSearch="true" 
		        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
		    	pager="true"
		    	rowNum="10" 
		    	rowList="5,10,15,20"
		        shrinkToFit="true"
		        sortable="true"
		        viewrecords="true">
		    <psjg:gridColumn id="BRANCH_CODE" index="BRANCH_CODE"	colType="number" name="cifVO.BRANCH_CODE"	title="" editable="false" sortable="true" search="true" hidden = "true"/>
			<psjg:gridColumn id="NAME"		  index="NAME"			colType="text"	 name="cifVO.AUTH_NAME"		title="%{getText('Name_key')}"		     editable="false" sortable="true" search="true" formatter="dashboard_authSignatureCIFBtn"/>
			<psjg:gridColumn id="ID_TYPE"	  index="ID_TYPE"		colType="text"	 name="idTypesVO.DESC_ENG"	title="%{getText('Id_Type_key')}"		 editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="ID"		  index="ID"			colType="text"   name="cifVO.AUTH_ID"		title="%{getText('ID_key')}"			 editable="false" sortable="true" search="true" />
		</psjg:grid>
</body>
<script type="text/javascript">
var Fom_key = "<ps:text name='fom.fom' />";

</script>