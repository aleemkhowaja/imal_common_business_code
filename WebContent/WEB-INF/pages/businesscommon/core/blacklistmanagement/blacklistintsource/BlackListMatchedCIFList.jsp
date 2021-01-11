<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %>

<ps:url id="matchedCIFListHref"
	action="BlackListMatchedCIFListAction_loadGrid"
	namespace="/path/blacklistmanagement" escapeAmp="false">
	<ps:param name="_pageRef" value="_pageRef" />
	<ps:param name="iv_crud" value="iv_crud" />
</ps:url>

<div style ="width:100%">
	<table width="100%">
		<tr>
			<td>
				<psjg:grid id="matchedCIFListId" 
				  	    href="%{matchedCIFListHref}" 
				        altRows="true"
				    	caption=" " 
				    	cssStyle="width:100%"
				        dataType="json"
						filter="true"
				    	gridModel="gridModel" 
						height="490" 
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
					<psjg:gridColumn id="rowId"		colType="text" 	name="rowId" title="hiddenRow"	hidden="true"/>
					<psjg:gridColumn id="CIF_NO"			colType="text" name="cifVO.CIF_NO"    			index="cifNO"    		title="%{getText('CIF_No_key')}"    		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="LONG_NAME_ENG"		colType="text" name="cifVO.LONG_NAME_ENG"   	index="LONG_NAME_ENG"   title="%{getText('CIF_Name_key')}"    		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="statusDesc"		colType="text" name="statusDesc"    			index="statusDesc"    	title="%{getText('Status_key')}"    		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="BL_TYPE"			colType="text" name="un_MainVO.UN_TYPE"    		index="BL_TYPE"    		title="%{getText('Source_key')}"    		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="BL_CODE"			colType="text" name="cif_BlackListVO.BL_CODE"   index="BL_CODE"    		title="%{getText('BL_Code_key')}"    		editable="false" sortable="true" search="true" hidden="true"/>
					<psjg:gridColumn id="REFERENCE_NUMBER"	colType="text" name="REFERENCE_NUMBER" 			index="REFERENCE_NUMBER" 	title="%{getText('reference_id_key')}" 		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="LONG_NAME"			colType="text" name="LONG_NAME" 				index="LONG_NAME" 		title="%{getText('BL_Name_key')}" 			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="NATIONALITY"		colType="text" name="un_MainVO.NATIONALITY" 	index="nationality" 	title="%{getText('Nationality_key')}" 		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="PASSPORT_NO"		colType="text" name="un_MainVO.PASSPORT_NO" 	index="PASSPORT_NO" 	title="%{getText('Passport_No_key')}" 		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="STR_DOB"			colType="text" name="STR_DOB" 					index="STR_DOB" 		title="%{getText('DOB_key')}" 				editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="LONG_NAME_ARAB"	colType="text" name="cifVO.LONG_NAME_ARAB" 		index="LONG_NAME_AR" 	title="%{getText('Long_Description_key')}" 		editable="false" sortable="true" search="true"/>
				</psjg:grid>
			</td>
		</tr>
	</table>
	
	<ptt:toolBar id="blackListIntSrcToolBar_${_pageRef}">
		
		<psj:submit id="blackList_block_btn_" button="true" type="button" buttonIcon="ui-icon-disk" 
				onclick="switchCIFListStatus( 'blackListed', 'matchedCIFListId', 'BlackListMatchedCIFListAction', 'whiteListGridId')" >
			<ps:label key="block_btn_key"/>
		</psj:submit>
		
		<psj:submit id="blackList_unBlock_btn_" button="true" type="button" buttonIcon="ui-icon-disk" 
				onclick="switchCIFListStatus( 'suspicious', 'matchedCIFListId', 'BlackListMatchedCIFListAction', 'whiteListGridId')">
			<ps:label key="UnBlock_key"/>
		</psj:submit>
		
	</ptt:toolBar>
</div>

