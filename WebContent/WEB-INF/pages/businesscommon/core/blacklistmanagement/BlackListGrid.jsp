<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<ps:hidden id="iv_crud_${_pageRef}"  name="iv_crud"/>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />
<div>
		<ps:url id="blackListGrid"  escapeAmp="false" 
			action="BlackListMgntGrid_loadBlackListGrid" namespace="/path/blackList">
			<ps:param name="iv_crud" value="iv_crud" />
			<ps:param name="_pageRef" value="_pageRef" />
		</ps:url>
	<psjg:grid
    	id="blackListGridTbl_Id_${_pageRef}" 
    	caption="%{getText('Black_List_Management_key')}"
    	href="%{blackListGrid}" 
    	dataType="json" 
    	hiddengrid='%{iv_crud == "R"}'
    	pager="true" 
    	sortable="true"
		filter="true"
    	gridModel="gridModel" 
    	rowNum="5" 
    	rowList="5,10,15,20"
        viewrecords="true" 
        navigator="true" 
        navigatorAdd     ="false"
        navigatorDelete  ="false"
        navigatorEdit    ="false"
        navigatorRefresh ="false"
        navigatorSearch  ="false"
        altRows="true"
        ondblclick="blackListGridTbl_Id_onDbClicked()"
        addfunc="blackListGridTbl_Id_onAddClicked"  
        shrinkToFit="false"
        height="130"
    >
    	<psjg:gridColumn name="blackListVO.CODE"   				colType="number"  	index="blackListVO.CODE"   				title="%{getText('Code__key')}"    			align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="blackListVO.BRIEF_NAME_ENG"   	colType="text"  	index="blackListVO.BRIEF_NAME_ENG"   	title="%{getText('brief_desc_key')}"    	align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="blackListVO.LONG_NAME_ENG"   	colType="text"  	index="blackListVO.LONG_NAME_ENG"   	title="%{getText('long_desc_key')}"    		align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="blackListVO.CIF"   		   		colType="number"  	index="blackListVO.CIF"   				title="%{getText('CIF_key')}"    			align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="cifDesc"   		   				colType="text"  	index="cifDesc"   						title="%{getText('CIF_Short_Name_key')}"    align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="blackListVO.OID_DOCUMENT_NBR"    colType="text"  	index="blackListVO.OID_DOCUMENT_NBR"   	title="%{getText('Document_Nbr._key')}"    	align="left"	editable="false"    sortable="true"    search="true"  />
		<psjg:gridColumn name="blackListVO.STATUS"   		    colType="text"  	index="blackListVO.STATUS"   			title="%{getText('Status_key')}"    		align="left"	editable="false"    sortable="true"    search="true" hidden="true" />
		<psjg:gridColumn name="statusDesc"   		   			colType="text"  	index="statusDesc"   					title="%{getText('Status_key')}"    		align="left"	editable="false"    sortable="true"    search="true"  />
	</psjg:grid>
</div>

<div id="blackListDetailDiv_id_${_pageRef}" style="width:100%;" >
	<ps:if test='iv_crud == "R"'>
	    <%@include file="BlackListMaint.jsp"%>
	</ps:if>  
</div>

<script  type="text/javascript">
$.struts2_jquery.require("BlackListMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/blacklistmanagement/");
$("#gview_blackListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();

</script>
