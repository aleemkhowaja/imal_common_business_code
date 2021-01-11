<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>

	<body> 
		<br/>

		
		<div>
			<ps:if test='%{callingScreen=="TFA" || callingScreen=="PMS"}'>
				<ps:url id="urlMoreAddressGrid" action="moreAddressList_loadMoreAddressGrid" namespace="/path/moreAddress" escapeAmp="false">
					<ps:param name="criteria.cifNo" value="%{cifCode}"/>
				</ps:url>
			</ps:if>
			<ps:if test='%{callingScreen=="FOM"}'>
				<ps:url id="urlMoreAddressGrid" action="moreAddressList_loadFOMMoreAddressGrid" namespace="/path/moreAddress" escapeAmp="false">
					<ps:param name="criteria.cifNo" value="%{cifCode}"/>
					<ps:param name="criteria.compCodeCif" value="%{compCodeCif}"/>
					<ps:param name="criteria.sectionKey" value="%{_pageRef}"/>
				</ps:url>
			</ps:if>
			<ps:if test='%{callingScreen=="ACCOUNT"}'>
				<ps:url id="urlMoreAddressGrid" action="AccountAddressList_loadAccountMoreAddressGrid" namespace="/path/accounts" escapeAmp="false">
					<ps:param name="criteria.branchCode" value="%{criteria.branchCode}"/>
					<ps:param name="criteria.cifNo" value="%{criteria.cifNo}"/>
					<ps:param name="criteria.slNo" value="%{criteria.slNo}"/>
					<ps:param name="criteria.glCode" value="%{criteria.glCode}"/>
					<ps:param name="criteria.cyCode" value="%{criteria.cyCode}"/>
				</ps:url>
			</ps:if>
			<ps:if test='%{callingScreen=="TFA"}'>
				<ps:url id="urlMoreAddressGrid" action="moreAddressList_loadMoreAddressGrid" namespace="/path/moreAddress" escapeAmp="false">
					<ps:param name="criteria.cifNo" value="%{cifCode}"/>
				</ps:url>
			</ps:if>
			<psjg:grid
		    	id="moreAddressGridTbl_Id_${_addressPageRef}"  
		    	dataType="json" 
		    	href="%{urlMoreAddressGrid}" 
		    	pager="true" 
				filter="false"
		    	gridModel="gridModel" 
		    	rowNum="5" 
		    	rowList="5,10,15,20"
		        viewrecords="true" 
		        navigator="true" 
		        navigatorAdd     ="${_popupBtnFlag}"
		        navigatorDelete  ="${_popupBtnFlag}"
		        navigatorEdit    ="false"
		        navigatorRefresh ="false"
		        navigatorSearch  ="false"
		        height="110"
		        altRows="true"
		        addfunc="fOMMoreAddress_onAddClicked"  
		        delfunc="fOMMoreAddress_onDeleteClicked"
		        ondblclick="moreAddressGridTbl_Id_onDbClicked()"
		        rownumbers="true"
		    >
		    	<psjg:gridColumn name="LINE_NO" title="%{getText('Line_No_key')}" index="LINE_NO" colType="number" hidden="true" editable="false" sortable="true" search="true" id="LINE_NO"/>
		   <ps:if test='%{callingScreen=="FOM" || callingScreen=="PMS" || callingScreen=="TFA"}'>
		    	<psjg:gridColumn name="CIF_NO" title="%{getText('CIF_No_key')}" index="CIF_NO" colType="number" editable="false" sortable="true" search="true" id="CIF_NO"/>
		   </ps:if>
		  <%/*
		   <ps:if test='%{callingScreen=="ACCOUNT"}'>
		   		<psjg:gridColumn name="ACC_BR" title="%{getText('Acc_Br_key')}" index="ACC_BR" colType="number" editable="false" sortable="true" search="true" id="ACC_BR"/>
		   		<psjg:gridColumn name="ACC_CIF" title="%{getText('Acc_CIF_key')}" index="ACC_CIF" colType="number" editable="false" sortable="true" search="true" id="ACC_CIF"/>
		   		<psjg:gridColumn name="ACC_CY" title="%{getText('Acc_Cy_key')}" index="ACC_CY" colType="number" editable="false" sortable="true" search="true" id="ACC_CY"/>
		   		<psjg:gridColumn name="ACC_GL" title="%{getText('Acc_GL_key')}" index="ACC_GL" colType="number" editable="false" sortable="true" search="true" id="ACC_GL"/>
		   		<psjg:gridColumn name="ACC_SL" title="%{getText('Acc_SL_key')}" index="ACC_SL" colType="number" editable="false" sortable="true" search="true" id="ACC_SL"/>
		   </ps:if>
		 */%>  
		   <ps:if test='%{callingScreen!="ACCOUNT"}'>
		    	<psjg:gridColumn name="countryDesc" title="%{getText('Country_key')}" index="countryDesc" colType="text" editable="false" sortable="true" id="countryDesc" />
		   </ps:if>	
				<psjg:gridColumn name="ADDRESS1_ENG" title="%{getText('Address_1_key')}" index="ADDRESS1_ENG" colType="text" editable="false" sortable="true" id="ADDRESS1_ENG" />
				<psjg:gridColumn name="ADDRESS2_ENG" title="%{getText('Address_2_key')}" index="ADDRESS2_ENG" colType="text" editable="false" sortable="true" id="ADDRESS3_ENG" />
				<psjg:gridColumn name="countryTelFormat" title=" " index="countryTelFormat" colType="text" editable="false" sortable="true" id="countryTelFormat" hidden="true"/>
				<psjg:gridColumn name="TEL" title="%{getText('Home_Tel_key')}" index="TEL" colType="text" editable="false" sortable="true" search="true" id="TEL" formatter="callMoreAddress_actionTypeFormatter"/>
				<psjg:gridColumn name="FAX" title="%{getText('Fax_key')}" index="FAX" colType="text" editable="false" sortable="true" id="FAX" formatter="callMoreAddress_actionTypeFormatter"/>
			</psjg:grid>
				
		</div>
		<br/>

		<ps:form id="fomMaint_fomMoreAddress_${_addressPageRef}" useHiddenProps="true">
			<div id="moreAddressListDetailDiv_id_<ps:property value="_addressPageRef" escapeHtml="true"/>" style="width: 100%;">
				<%@include file="MoreAddressDetail.jsp"%>
			</div>
		</ps:form>

	</body>

</html>