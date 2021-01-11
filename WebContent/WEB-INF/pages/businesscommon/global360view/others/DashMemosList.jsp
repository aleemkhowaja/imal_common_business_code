<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

   <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>

	<ps:url id="urlMemosGrid_${_pageRef}" 
	        namespace="/path/globalview" escapeAmp="false"
		    action="dashMemosListAction?_pageRef=${_pageRef}">
	   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
	   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
	</ps:url>
	<div>
	    <psjg:grid id="memosListGridTbl_Id_${_pageRef}" 
				caption="%{getText('Memos_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlMemosGrid_${_pageRef}}"
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
		        shrinkToFit="false"
		        sortable="true"
		        viewrecords="true">	
			<psjg:gridColumn id="BRANCH_CODE"    	index="BRANCH_CODE"    	colType="number" name="ctsMemoDetVO.BRANCH_CODE"    title="%{getText('Branch_code_key')}"  					editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="TRX_NO"         	index="TRX_NO"			colType="number" name="ctsMemoDetVO.TRX_NO"			title="%{getText('Trx_No_key')}"	   					editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ENG_COMENT"		index="ENG_COMENT"      colType="text"   name="ctsMemoDetVO.ENG_COMENT"     title="%{getText('Eng_Comment_key')}"     				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="COMMON_DESC_ENG"   index="COMMON_DESC_ENG"	colType="text"   name="ctsMemoVO.COMMON_DESC_ENG"   title="%{getText('Common_Description_Eng_key')}"     	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="BRIEF_DESC_ENG"    index="BRIEF_DESC_ENG"  colType="text"   name="ctsMemoVO.BRIEF_DESC_ENG"    title="%{getText('legal_status_brief_desc_eng_key')}"   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LONG_DESC_ENG"     index="LONG_DESC_ENG"   colType="text"   name="ctsMemoVO.LONG_DESC_ENG"     title="%{getText('legal_status_long_desc_eng_key')}"    editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="BRIEF_DESC_ARAB"   index="BRIEF_DESC_ARAB" colType="text"   name="ctsMemoVO.BRIEF_DESC_ARAB"   title="%{getText('legal_status_brief_desc_arab_key')}"  editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LONG_DESC_ARAB"    index="LONG_DESC_ARAB"  colType="text"   name="ctsMemoVO.LONG_DESC_ARAB"    title="%{getText('long_desc_arab_key')}"     			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ARAB_COMENT"       index="ARAB_COMENT"     colType="text"   name="ctsMemoDetVO.ARAB_COMENT"    title="%{getText('Arab_Comment_key')}"     				editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</div>
</body>	