<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<ps:url id="whiteListHref" namespace="/path/blacklistmanagement" escapeAmp="false" action="BlackListWhiteListAction_loadGrid" >
	<ps:param name="iv_crud" value="iv_crud"></ps:param>
	<ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>

<div style ="width:100%">
	<table width="100%">
		<tr>
			<td>
				<psjg:grid id="whiteListGridId" 
				  	    href="%{whiteListHref}" 
				        altRows="true"
				    	caption=" " 
				    	cssStyle="width:100%"
				        dataType="json"
						filter="true"
				    	gridModel="gridModel" 
						hiddengrid="false" 
				        multiselect="true"
				        navigator="true"
				        navigatorAdd="false"
				    	navigatorDelete="false"
				        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
				        navigatorRefresh="false"  
				        navigatorEdit="false"
				        navigatorSearch="false" 
				        pager="true"
						rowNum="20" 
						rowList="20,50,100" 
				        shrinkToFit="false"
						viewrecords="true"
					>
					<psjg:gridColumn id="rowId"			colType="text" 	name="rowId"	title="%{getText('CIF_No_key')}"	hidden="true" />
					<psjg:gridColumn id="CIF_NO"		colType="text" 	name="cifVO.CIF_NO"			index="cifNO"			title="%{getText('CIF_No_key')}"	editable="false"	sortable="true" search="true"/>
					<psjg:gridColumn id="LONG_NAME"		colType="text"	name="cifVO.LONG_NAME_ENG"	index="LONG_NAME_ENG"	title="%{getText('CIF_Name_key')}"	editable="false"	sortable="true" search="true"/>
					<psjg:gridColumn id="statusDesc"	colType="text" 	name="statusDesc"			index="statusDesc"		title="%{getText('Status_key')}" 	editable="false" 	sortable="true" search="true"/>
					<psjg:gridColumn id="UN_TYPE"		colType="text"	name="un_MainVO.UN_TYPE"	index="BL_TYPE"			title="%{getText('Source_key')}"    editable="false" 	sortable="true" search="true"/>
					<psjg:gridColumn id="REFERENCE_NUMBER"	colType="text" name="REFERENCE_NUMBER" 			index="REFERENCE_NUMBER" 	title="%{getText('reference_id_key')}" 		editable="false" sortable="true" search="true"/>
				</psjg:grid>
			</td>
		</tr>
	</table>
	
	<ptt:toolBar id="blackListIntSrcToolBar_${_pageRef}" width="652px;" >
		
		<psj:submit id="blackList_whiteList_add_btn_" button="true" type="button" buttonIcon="ui-icon-disk" 
				onclick="switchCIFListStatus( 'whiteListed', 'whiteListGridId', 'BlackListWhiteListAction', 'matchedCIFListId')">
			<ps:label key="btn.add"/>
		</psj:submit>
		<psj:submit id="blackList_whiteList_block_btn_" button="true" type="button" buttonIcon="ui-icon-disk" 
				onclick="switchCIFListStatus( 'suspicious', 'whiteListGridId', 'BlackListWhiteListAction', 'matchedCIFListId')">
			<ps:label key="btn.remove"/>
		</psj:submit>
		
		
	</ptt:toolBar>

</div>

