<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>

<html>
	<body> 
		<br/>
		<div>
				<ps:url id="urlMoreAddressGrid" action="moreAddressList_loadFOMMoreAddressGrid" namespace="/path/moreAddress" escapeAmp="false">
					<ps:param name="criteria.cifNo" value="%{cifCode}"/>
					<ps:param name="criteria.fromFomKyc" value="%{fromFomKyc}"/>
				</ps:url>
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
		        addfunc="fOMMoreAddressKyc_onAddClicked"  
		        delfunc="fOMMoreAddress_onDeleteClicked"
		        ondblclick="moreAddressGridTbl_KYC_onDbClicked()"
		        rownumbers="true"
		    >
		    	<psjg:gridColumn name="LINE_NO" title="%{getText('Line_No_key')}" index="LINE_NO" colType="number" hidden="true" editable="false" sortable="true" search="true" id="LINE_NO"/>
		    	<psjg:gridColumn name="CIF_NO" title="%{getText('CIF_No_key')}" index="CIF_NO" colType="number" editable="false" sortable="true" search="true" id="CIF_NO"/>
		    	<psjg:gridColumn name="countryDesc" title="%{getText('Country_key')}" index="countryDesc" colType="text" editable="false" sortable="true" id="countryDesc" />
				<psjg:gridColumn name="ADDRESS1_ENG" title="%{getText('Address_1_key')}" index="ADDRESS1_ENG" colType="text" editable="false" sortable="true" id="ADDRESS1_ENG" />
				<psjg:gridColumn name="ADDRESS2_ENG" title="%{getText('Address_2_key')}" index="ADDRESS2_ENG" colType="text" editable="false" sortable="true" id="ADDRESS3_ENG" />
				<psjg:gridColumn name="countryTelFormat" title=" " index="countryTelFormat" colType="text" editable="false" sortable="true" id="countryTelFormat" hidden="true"/>
				<psjg:gridColumn name="TEL" title="%{getText('Home_Tel_key')}" index="TEL" colType="text" editable="false" sortable="true" search="true" id="TEL" formatter="callMoreAddress_actionTypeFormatter"/>
				<psjg:gridColumn name="FAX" title="%{getText('Fax_key')}" index="FAX" colType="text" editable="false" sortable="true" id="FAX" formatter="callMoreAddress_actionTypeFormatter"/>
			</psjg:grid>
				
		</div>
		<br/>

		<ps:form id="fomMaint_fomMoreAddressKyc_${_addressPageRef}" useHiddenProps="true">
			<div id="moreAddressKycListDetailDiv_id_${_addressPageRef}" style="width: 100%;">
				<%@include file="MoreAddressDetailKyc.jsp"%>
			</div>
		</ps:form>

	</body>

</html>