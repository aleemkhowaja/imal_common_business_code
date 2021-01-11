<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<ps:set name="SigCapUnavailable_key" value="%{getEscText('SigCapUnavailable_key')}"/>
<ps:set name="sigCapUrlPthCtrl_key" value="%{getEscText('sigCapUrlPthCtrl')}"/>

<script>
//var SigCapUnavailable='${SigCapUnavailable_key}';
//var sigCapUrlPthCtrl='${sigCapUrlPthCtrl_key}';

var SigCapUnavailable='<ps:property value="SigCapUnavailable_key"  escapeHtml="false" escapeJavaScript="true"/>'
var sigCapUrlPthCtrl='<ps:property value="sigCapUrlPthCtrl_key"  escapeHtml="false" escapeJavaScript="true"/>'

$.struts2_jquery.require("SigCapSignature.js" ,null,jQuery.contextPath+"/businesscommon/js/signature/");
$(document).ready(sigCap_onLoadFunc);
</script>

<ps:hidden name="sigCapSignatureCO.sigCapUrl" id="sigCapUrl_${_pageRef}"/>
<div id="sigCapMainDiv_<ps:property value="_pageRef" escapeHtml="true"/>">
	<table style="width: 100%">
		<tr>
			<td align="right"><ps:label key="Account_no_key"></ps:label></td>
			<td><ps:textfield name="sigCapSignatureCO.sigAaccountReference" id="accNo_${_pageRef}"/></td>
		</tr>
		<tr>
			<td align="right"><ps:label key="Amount_Key" id="amtSigCapLbl_${_pageRef}"></ps:label></td>
			<td><ps:textfield name="sigCapSignatureCO.sigCapAmount" id="sigAmt_${_pageRef}"/></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	<table style="width: 100%">
		<tr>
			<td width="25%"></td>
			<td width="25%">
			    <psj:submit button="true" type="button" id="viewSigCapBtn_${_pageRef}" onclick="accounts_openSigCapUrl()">
					<ps:label key='view_signature_key' />
				</psj:submit></td>
			<td width="25%">
			     <psj:submit button="true" type="button" id="acceptSigCapBtn_${_pageRef}" onclick="acceptSigCapSignature()">
					<ps:label key='Accept_key' />
				 </psj:submit>
			</td>
			<td width="25%"></td>
		</tr>
		<tr>
			<td></td>
			<td>
			    <psj:submit button="true" type="button" id="cancelSigCapBtn_${_pageRef}" onclick="sigCapClose()">
					<ps:label key='Cancel_key' />
				</psj:submit>
			</td>
			<td>
			     <psj:submit button="true" type="button" id="rejectSigCapBtn_${_pageRef}" onclick="rejectSigCapSignature()">
					<ps:label key='Reject_key' />
				</psj:submit>
			</td>
			<td></td>
		</tr>
	</table>
</div>