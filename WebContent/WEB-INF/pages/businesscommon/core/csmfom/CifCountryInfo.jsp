<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>
<ps:set name="deleteConfirm" value="%{getEscText('delete_selected_record_key')}" />
<ps:set name="deleteTitle" value="%{getEscText('delete_key')}" />
<ps:set name="yes_confirm" value="%{getEscText('yes_confirm')}" />
<ps:set name="no_confirm" value="%{getEscText('no_confirm')}" />
	<div id="cifCountryInfoDiv_${_pageRef}" style="width:100%" class="connectedSortable ui-helper-reset">
		<div  style="width:100%;" title=" " class="collapsibleContainer" id="cifCountryInfoSubDiv_${_pageRef}">
			<ps:url id="urlGrid" action="fomYmcLookupsAction_loadCifCountryInfoGrid" namespace="/path/fom" escapeAmp="false">
				<ps:param name="update" value="update"/>
				<ps:param name="updates" value="updates"/>
				<ps:param name="financialType" value="financialType"/>
			</ps:url>
			<psjg:grid id="ymcCifCountryInfoGrid_${_pageRef}" dataType="json"
				href="%{urlGrid}" gridModel="gridModel" pager="false"
				navigator="true" navigatorSearch="false" editinline="true"
				editurl="%{urlGrid}" rowNum="5" addfunc="ymc_cifCountryInfo_onAddClicked" delfunc="ymc_cifCountryInfo_onDelClicked"
				navigatorEdit="false" navigatorAdd="true" navigatorDelete="true"
				navigatorRefresh="true" viewrecords="true" rowList="5,10,15,20"
				sortable="true" shrinkToFit="true">
				<psjg:gridColumn name="cifCountryInfoVO.CIF_NO" index="cifCountryInfoVO.CIF_NO"
					colType="text" title="cifCountryInfoVO.CIF_NO" editable="false"
					sortable="true" search="false" hidden="true" />
				<psjg:gridColumn
					name="cifCountryInfoVO.COMP_CODE" index="cifCountryInfoVO.COMP_CODE"
					colType="numeric" title="cifCountryInfoVO.COMP_CODE" hidden="true" editable="true"  search="false"/>		
				<psjg:gridColumn name="cifCountryInfoVO.COUNTRY_CODE"
					title="%{getText('Country_Code_key')}"
					index="cifCountryInfoVO.COUNTRY_CODE"
					colType="liveSearch" editable="true" id="cifCountryInfoVO.COUNTRY_CODE" mode="number"
					editoptions="{maxlength:'8',dataEvents: [{ type: 'change', fn: function(e) {  checkDuplicateCountry() } }]}"  nbFormat="########"
					dataAction="${pageContext.request.contextPath}/path/fom/fomYmcLookupsAction_ymcCountriesLookup.action"
					resultList="COUNTRY_CODE:cifCountryInfoVO.COUNTRY_CODE_lookuptxt,LONG_DESC_ENG:YMC_COUNTRY_DESC" 
					searchElement="CIF_NO"	required="true" 			
					params="update:cifCountryInfoVO.COUNTRY_CODE"
					dependencySrc="${pageContext.request.contextPath}/path/fom/fomYmcLookupsAction_ymcCountriesLookupDependency.action"
					dependency="cifKycFinancialInfoCO.cifKycFinancialInfoVO.KYC_FINANCIAL_BIRTH_COUNTRY:cifCountryInfoVO.COUNTRY_CODE,
					cifKycFinancialInfoCO.KYC_FINANCIAL_BIRTH_COUNTRY_DESC:KYC_FINANCIAL_COUNTRY_DESC"/>	
				<psjg:gridColumn name="KYC_FINANCIAL_COUNTRY_DESC" index="KYC_FINANCIAL_COUNTRY_DESC" colType="text" title="%{getText('Country_key')}" editable="false" search="false"/>	
				<psjg:gridColumn  name="cifCountryInfoVO.ID_NO" index="cifCountryInfoVO.ID_NO"  colType="text" title="%{getText('ID_Number_key')}" editable="true" sortable="true" search="false" hidden="false" editoptions="{maxlength:'20'}" required="true" />
			</psjg:grid>
		</div>
	</div>
