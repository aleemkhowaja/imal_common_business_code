<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<div style="width:100%;"> 
	
	<ps:url id="urlBlackListIdsGrid" action="BlackListMgntGrid_loadBlackListIdsGrid" namespace="/path/blackList" escapeAmp="false">
		<ps:param name="criteria.code" value="%{blackListCO.blackListVO.CODE}"/>
		<ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
		<ps:param name="_pageRef" value="_pageRef"></ps:param>
	</ps:url>
    <psjg:grid
    	id="blackListIdsGridTbl_Id_${_pageRef}"  
    	caption="%{getText('Black_List_ID_No_key')}"
    	dataType="json" 
    	href="%{urlBlackListIdsGrid}" 
    	pager="true" 
		filter="false"
    	gridModel="gridModel" 
    	rowNum="5" 
    	rowList="5,10,15,20"
        viewrecords="true" 
        navigator="true" 
        navigatorAdd    ="${subGridButtonMode}"
        navigatorDelete  ="${subGridButtonMode}"
        navigatorEdit="false"
		navigatorRefresh="false" 
		navigatorSearch="false" 
        height="110"
        altRows="true"
		pagerButtons="false"
		editinline	="${subGridButtonMode}"
        editurl="asfd"
        rownumbers="true"
        addfunc="blackListIdsGridTbl_Id_addId"  
        delfunc="blackListIdsGridTbl_Id_deleteId"
        hiddengrid="false"
    >
    	<psjg:gridColumn name="blackListIdVO.ID_TYPE" title="%{getText('Id_Type_key')}"	index="blackListIdVO.ID_TYPE" colType="liveSearch" 
    		editable="true" sortable="true" id="blackListIdVO.ID_TYPE"  
			dataAction="${pageContext.request.contextPath}/pathdesktop/IdType_constructLookup" 
			resultList="DESC_ENG:idTypeDesc" searchElement="CODE"
			beforeDepEvent="fillIDGridData()"
			dependencySrc="${pageContext.request.contextPath}/pathdesktop/IdTypeDependencyAction_dependencyByIdTypeCode"
			params="idTypeCode:blackListIdVO.ID_TYPE_lookuptxt,blackListIdsStr:blackListIdsStr_${_pageRef}"
			dependency="idTypeVO.CODE:blackListIdVO.ID_TYPE_lookuptxt,idTypeVO.DESC_ENG:idTypeDesc,idTypeSC.idNoCode:blackListIdVO.ID_NO"
			editoptions="{ dataEvents: [{ type: 'keypress', fn: function(e) { setColTypeNumber(e)}} ], maxlength:'8' }"
			
		/>
		
		<psjg:gridColumn name="idTypeDesc" 	title="%{getText('Id_Type_key')}" 	index="idTypeDesc" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="idTypeDesc" />

		<psjg:gridColumn id="blackListIdVO.ID_NO" name="blackListIdVO.ID_NO"
			title="%{getText('ID_No_key')}" index="blackListIdVO.ID_NO"
			colType="text" editable="true" sortable="true" search="false"
			editoptions="{ maxlength:'20' }"
			beforeDepEvent="fillIDGridData()"
			dependencySrc="${pageContext.request.contextPath}/pathdesktop/IdTypeDependencyAction_dependencyByIdNo"
			params="idTypeSC.idNoCode:blackListIdVO.ID_NO,blackListIdsStr:blackListIdsStr_${_pageRef}"
			dependency="idTypeSC.idNoCode:blackListIdVO.ID_NO" />
	</psjg:grid>

</div>
	
	