<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
    
    <ps:hidden id="isCifCif_${_pageRef}" name="isCifCif"/>
	<ps:hidden id="isAccAcc_${_pageRef}" name="isAccAcc"/>
	<ps:hidden id="isCifAcc_${_pageRef}" name="isCifAcc"/>	
	<ps:hidden id="isAccCif_${_pageRef}" name="isAccCif"/>	
	
    <ps:if test="isCifCif > 0">
    	<ps:url id="urlCifCifLinksGrid_${_pageRef}"
    			namespace="/path/globalview" escapeAmp="false"
				action="dashLinksListAction_linksListCifCifGrid?_pageRef=${_pageRef}">
				<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	
	
		<psjg:grid id="linksListCifCifGridTbl_Id_${_pageRef}" 
					caption="%{getText('CIF_CIF_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlCifCifLinksGrid_${_pageRef}}"
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
			        autowidth="true"
			        sortable="true"
			        viewrecords="true">
				<psjg:gridColumn id="CODE"			index="CODE"			colType="number"	name="sLinkCifAmfVO.LINK_CODE"		title="%{getText('Code__key')}"			editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="SERIAL"		index="SERIAL"			colType="number" 	name="sLinkCifAmfVO.LINK_SERIAL"	title="%{getText('Serial_key')}"		editable="false" sortable="true" search="true" formatter="dashboard_linksCIFCIFBtn"/>
				<psjg:gridColumn id="BRIEF_NAME"	index="BRIEF_NAME"		colType="text"		name="sLinkCifAmfVO.BRIEF_DESC_ENG"	title="%{getText('Brief_Name_key')}"	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF_NO"	index="FROM_CIF_NO"		colType="number"	name="sLinkCifAmfVO.FROM_CIF"		title="%{getText('CIF_No_key')}"		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF_NAME"	index="FROM_CIF_NAME"	colType="text"		name="cifVO.SHORT_NAME_ENG"			title="%{getText('CIF_Name_key')}"		editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="TO_CIF_NO"		index="TO_CIF_NO"		colType="number"	name="sLinkCifAmfVO.TO_CIF"			title="%{getText('CIF_No_key')}"		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CIF_NAME"	index="TO_CIF_NAME"		colType="text"		name="cifVO1.SHORT_NAME_ENG"		title="%{getText('CIF_Name_key')}"		editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="STATUS"		index="STATUS"			colType="text"		name="sLinkCifAmfVO.STATUS"			title="%{getText('Status_key')}"		editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</ps:if>
	
    <ps:if test="isAccAcc > 0">
    	<ps:url id="urlAccAccLinksGrid_${_pageRef}"
    			namespace="/path/globalview" escapeAmp="false"
				action="dashLinksListAction_linksListAccAccGrid?_pageRef=${_pageRef}">
				<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
		<psjg:grid id="linksListAccAccGridTbl_Id_${_pageRef}" 
					caption="%{getText('AMF_AMF_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlAccAccLinksGrid_${_pageRef}}"
			        navigator="true" 
			        navigatorAdd="false"
			        navigatorDelete="false"
			        navigatorEdit="false"
			        navigatorRefresh="false"
			        navigatorSearch="true" 
			        autowidth="true"
			        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
			    	pager="true"
			    	rowNum="10" 
			    	rowList="5,10,15,20"
			        shrinkToFit="false"
			        sortable="true"
			        viewrecords="true">
				<psjg:gridColumn id="CODE"				   index="CODE"					colType="number"	name="sLinkCifAmfVO.LINK_CODE"		title="%{getText('Code__key')}"				   editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="SERIAL"			   index="SERIAL"				colType="number" 	name="sLinkCifAmfVO.LINK_SERIAL"	title="%{getText('Serial_key')}"			   editable="false" sortable="true" search="true"  formatter="dashboard_linksAccAccBtn"/>
				<psjg:gridColumn id="BRIEF_NAME"		   index="BRIEF_NAME"			colType="text"		name="sLinkCifAmfVO.BRIEF_DESC_ENG"	title="%{getText('Brief_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_BRANCH"		   index="FROM_BRANCH"			colType="number"	name="sLinkCifAmfVO.FROM_BR"		title="%{getText('branchKey')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CURRENCY"		   index="FROM_CURRENCY"		colType="number"	name="sLinkCifAmfVO.FROM_CY"		title="%{getText('Currency_key')}"			   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="FROM_GL"			   index="FROM_GL"				colType="number"	name="sLinkCifAmfVO.FROM_GL"		title="%{getText('GL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF"			   index="FROM_CIF"				colType="number"	name="sLinkCifAmfVO.FROM_CIF"		title="%{getText('CIF_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_SL"			   index="FROM_SL"				colType="number"	name="sLinkCifAmfVO.FROM_SL"		title="%{getText('SL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_NAME"			   index="FROM_NAME"			colType="text"		name="amfVO.BRIEF_NAME_ENG"			title="%{getText('Account_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_BRANCH"			   index="TO_BRANCH"			colType="number"	name="sLinkCifAmfVO.TO_BR"			title="%{getText('branchKey')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CURRENCY"		   index="TO_CURRENCY"			colType="number"	name="sLinkCifAmfVO.TO_CY"			title="%{getText('Currency_key')}"			   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="TO_GL"				   index="TO_GL"				colType="number"	name="sLinkCifAmfVO.TO_GL"			title="%{getText('GL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CIF"			   index="TO_CIF"				colType="number"	name="sLinkCifAmfVO.TO_CIF"			title="%{getText('CIF_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_SL"				   index="TO_SL"				colType="number"	name="sLinkCifAmfVO.TO_SL"			title="%{getText('SL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_ADD_REFERENCE"     index="TO_ADD_REFERENCE"     colType="text"   	name="to_add_reference" 			title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_NAME"			   index="TO_NAME"				colType="text"		name="amfVO1.BRIEF_NAME_ENG"		title="%{getText('Account_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="STATUS"			   index="STATUS"				colType="text"		name="sLinkCifAmfVO.STATUS"			title="%{getText('Status_key')}"			   editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</ps:if>

    <ps:if test="isAccCif > 0">
    	<ps:url id="urlAccCifLinksGrid_${_pageRef}"
    			namespace="/path/globalview" escapeAmp="false"
				action="dashLinksListAction_linksListAccCifGrid?_pageRef=${_pageRef}">
				<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
		<psjg:grid id="linksListAccCifGridTbl_Id_${_pageRef}" 
					caption="%{getText('AMF_CIF_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlAccCifLinksGrid_${_pageRef}}"
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
			        autowidth="true"
			        sortable="true"
			        viewrecords="true">
				<psjg:gridColumn id="CODE"				   index="CODE"					colType="number"	name="sLinkCifAmfVO.LINK_CODE"		title="%{getText('Code__key')}"				   editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="SERIAL"			   index="SERIAL"				colType="number" 	name="sLinkCifAmfVO.LINK_SERIAL"	title="%{getText('Serial_key')}"			   editable="false" sortable="true" search="true"  formatter="dashboard_linksAccCIFBtn"/>
				<psjg:gridColumn id="BRIEF_NAME"		   index="BRIEF_NAME"			colType="text"		name="sLinkCifAmfVO.BRIEF_DESC_ENG"	title="%{getText('Brief_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_BRANCH"		   index="FROM_BRANCH"			colType="number"	name="sLinkCifAmfVO.FROM_BR"		title="%{getText('branchKey')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CURRENCY"		   index="FROM_CURRENCY"		colType="number"	name="sLinkCifAmfVO.FROM_CY"		title="%{getText('Currency_key')}"			   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="FROM_GL"			   index="FROM_GL"				colType="number"	name="sLinkCifAmfVO.FROM_GL"		title="%{getText('GL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF"			   index="FROM_CIF"				colType="number"	name="sLinkCifAmfVO.FROM_CIF"		title="%{getText('CIF_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_SL"			   index="FROM_SL"				colType="number"	name="sLinkCifAmfVO.FROM_SL"		title="%{getText('SL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_ADD_REFERENCE"   index="FROM_ADD_REFERENCE"   colType="text"   	name="from_add_reference" 			title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_NAME"			   index="FROM_NAME"			colType="text"		name="amfVO.BRIEF_NAME_ENG"			title="%{getText('Account_Name_key')}"		   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="TO_CIF_NO"			   index="TO_CIF_NO"			colType="number"	name="sLinkCifAmfVO.TO_CIF"			title="%{getText('CIF_No_key')}"			   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CIF_NAME"		   index="TO_CIF_NAME"			colType="text"		name="cifVO1.SHORT_NAME_ENG"		title="%{getText('CIF_Name_key')}"			   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="STATUS"			   index="STATUS"				colType="text"		name="sLinkCifAmfVO.STATUS"			title="%{getText('Status_key')}"			   editable="false" sortable="true" search="true"/>
		</psjg:grid>
		<br/>
	</ps:if>

    <ps:if test="isCifAcc > 0">
    	<ps:url id="urlCifAccLinksGrid_${_pageRef}"
    			namespace="/path/globalview" escapeAmp="false"
				action="dashLinksListAction_linksListCifAccGrid?_pageRef=${_pageRef}">
				<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
		<psjg:grid id="linksListCifAccGridTbl_Id_${_pageRef}" 
					caption="%{getText('CIF_AMF_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlCifAccLinksGrid_${_pageRef}}"
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
			        autowidth="true"
			        sortable="true"
			        viewrecords="true">
				<psjg:gridColumn id="CODE"				   index="CODE"					colType="number"	name="sLinkCifAmfVO.LINK_CODE"		title="%{getText('Code__key')}"				   editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="SERIAL"			   index="SERIAL"				colType="number" 	name="sLinkCifAmfVO.LINK_SERIAL"	title="%{getText('Serial_key')}"			   editable="false" sortable="true" search="true"  formatter="dashboard_linksCIFAccBtn"/>
				<psjg:gridColumn id="BRIEF_NAME"		   index="BRIEF_NAME"			colType="text"		name="sLinkCifAmfVO.BRIEF_DESC_ENG"	title="%{getText('Brief_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF_NO"		   index="FROM_CIF_NO"			colType="number"	name="sLinkCifAmfVO.FROM_CIF"		title="%{getText('CIF_No_key')}"		       editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_CIF_NAME"		   index="FROM_CIF_NAME"		colType="text"		name="cifVO.SHORT_NAME_ENG"			title="%{getText('CIF_Name_key')}"			   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="TO_BRANCH"			   index="TO_BRANCH"			colType="number"	name="sLinkCifAmfVO.TO_BR"			title="%{getText('branchKey')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CURRENCY"		   index="TO_CURRENCY"			colType="number"	name="sLinkCifAmfVO.TO_CY"			title="%{getText('Currency_key')}"			   editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="TO_GL"				   index="TO_GL"				colType="number"	name="sLinkCifAmfVO.TO_GL"			title="%{getText('GL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_CIF"			   index="TO_CIF"				colType="number"	name="sLinkCifAmfVO.TO_CIF"			title="%{getText('CIF_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_SL"				   index="TO_SL"				colType="number"	name="sLinkCifAmfVO.TO_SL"			title="%{getText('SL_key')}"				   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_ADD_REFERENCE" 	   index="TO_ADD_REFERENCE" 	colType="text"   	name="to_add_reference" 			title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TO_NAME"			   index="TO_NAME"				colType="text"		name="amfVO1.BRIEF_NAME_ENG"		title="%{getText('Account_Name_key')}"		   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="STATUS"			   index="status"				colType="text"		name="sLinkCifAmfVO.STATUS"			title="%{getText('Status_key')}"			   editable="false" sortable="true" search="true"/>
		</psjg:grid>
	</ps:if>
 <script type="text/javascript">
  //Setting multi header columns
 var from_cif_Key = "<ps:text name='From_CIF_key'/>";
 var to_cif_Key = "<ps:text name='To_CIF_key'/>";
 var from_acc_Key = "<ps:text name='from_Acc'/>";
 var to_acc_Key = "<ps:text name='to_Acc'/>";
 var linksMgmtKey = "<ps:text name='Links_Management_key'/>";
 
 $(document).ready(function(){formatLinksGrids(from_cif_Key, to_cif_Key, from_acc_Key, to_acc_Key)});
 </script>