<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/iviewer/jquery.iviewer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/scrollable/scrollable-buttons.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/scrollable/scrollable-horizontal.css">

	<script type="text/javascript">
		$.struts2_jquery.require("jquery.iviewer.min.js", null, jQuery.contextPath+ "/common/jquery/js/plugins/");
		$.struts2_jquery.require("jquery.mousewheel.min.js", null, jQuery.contextPath+ "/common/jquery/js/plugins/");
		$.struts2_jquery.require("jquery.tools.min.js", null, jQuery.contextPath+ "/common/js/");	
		$.struts2_jquery.require("Scan.js",null,jQuery.contextPath+ "/common/js/scan/");
	</script>
	<script type="text/javascript">  
		$(document).ready(function(){ 
				signatureMain_onDocReady();
		});
	</script>

   	<ps:hidden id="_signCYCode_${_pageRef}" name="signatureSC.currencyCode"></ps:hidden>
	<ps:hidden  id="_signGLCode_${_pageRef}" name="signatureSC.glCode"></ps:hidden>
	<ps:hidden  id="_signCIFCode_${_pageRef}" name="signatureSC.cifNo"></ps:hidden>
		<ps:hidden  id="_signCIFDesc_${_pageRef}" name="signatureSC.signCIFDesc"></ps:hidden>
		<ps:hidden  id="_signScreenName_${_pageRef}" name="signatureSC.screenName"></ps:hidden>
	<ps:hidden  id="_signSLCode_${_pageRef}" name="signatureSC.slNo"></ps:hidden>
	<ps:hidden id="signatureBranchCode_${_pageRef}"  name="signatureSC.branchCode"  />
	<ps:hidden  id="_signCifType_${_pageRef}" name="signatureSC.cifType"></ps:hidden>
	<ps:hidden id="isSignReadOnly_${_pageRef}"  name="signatureSC.readOnly"  />
	<ps:hidden  id="signatureTp_${_pageRef}" name="signatureSC.signatureTp"   />	
	<ps:hidden  id="viewSelectedSignMessage_${_pageRef}" name="signatureSC.viewSelectedSignMessage"   />	
	<%/*NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry*/%>	
	<ps:hidden id="expiryDateRequired_${_pageRef}"  name="signatureSC.expiryDateRequired"/>
	<ps:hidden id="signatureAutoApprove_${_pageRef}"  name="signatureSC.autoApprove"/>
	
	<psj:tabbedpanel id="signatureMainTabs_${_pageRef}" sortable="true">
		<ps:if test="signTabVisible">
			<psj:tab id="signatureTab1_${_pageRef}" target="signatureTab-1_${_pageRef}" key="signature_key" />
		</ps:if>
		<ps:if test="limitSchemaTabVisible">
			<psj:tab id="schemaTab2_${_pageRef}" key="Schema_key" 
			    href="${pageContext.request.contextPath}/path/limitSchema/limitSchema_populateLimitSchemaPopup.action?cifSubNo=${signatureSC.cifNo}&_pageRef=${_pageRef}&iv_crud=${signatureSC.parentIvCrud}&branchCode=${signatureSC.branchCode}&showToolBar=true&currencyCode=${signatureSC.currencyCode}&glCode=${signatureSC.glCode}&slNo=${signatureSC.slNo}&limitSchemaSC.openedFromSign=true" />
		</ps:if>
		<ps:if test="signTabVisible">
			<psj:tab id="generalInformation3_${_pageRef}" target="generalInformation-3_${_pageRef}" key="General_Information_key" />
		</ps:if>
		<ps:if test="copySignTabVisible">
			<psj:tab id="copySignature4_${_pageRef}" key="Copy_Signature_key"
			     href="${pageContext.request.contextPath}/path/signature/Signature_populateCopySignature.action?signatureSC.cifNo=${signatureSC.cifNo}&_pageRef=${_pageRef}&iv_crud=A&signatureSC.branchCode=${signatureSC.branchCode}&signatureSC.currencyCode=${signatureSC.currencyCode}&signatureSC.glCode=${signatureSC.glCode}&signatureSC.slNo=${signatureSC.slNo}" />
		</ps:if>
		<ps:if test="docTabVisible">
			<psj:tab id="documentTab5_${_pageRef}" key="documents_key"
				href="${pageContext.request.contextPath}/path/signature/Signature_loadDocumentList.action?signatureSC.signatureTp=${signatureSC.signatureTp}&signatureSC.cifNo=${signatureSC.cifNo}&_pageRef=${_pageRef}&iv_crud=A&signatureSC.branchCode=${signatureSC.branchCode}&signatureSC.currencyCode=${signatureSC.currencyCode}&signatureSC.glCode=${signatureSC.glCode}&signatureSC.slNo=${signatureSC.slNo}&signatureSC.docType=D&signatureSC.readOnly=${signatureSC.readOnly}" />
		</ps:if>
		<ps:if test="photoTabVisible">
			<psj:tab id="photosTabs6_${_pageRef}" key="Photos_key"
				href="${pageContext.request.contextPath}/path/signature/Signature_loadDocumentList.action?signatureSC.signatureTp=${signatureSC.signatureTp}&signatureSC.cifNo=${signatureSC.cifNo}&_pageRef=${_pageRef}&iv_crud=A&signatureSC.branchCode=${signatureSC.branchCode}&signatureSC.currencyCode=${signatureSC.currencyCode}&signatureSC.glCode=${signatureSC.glCode}&signatureSC.slNo=${signatureSC.slNo}&signatureSC.docType=P&signatureSC.readOnly=${signatureSC.readOnly}" />
		</ps:if>
	
		<ps:if test="signTabVisible">
		  <div id="signatureTab-1_${_pageRef}" >
		  	<div id="signatureTab-1_content_${_pageRef}" style="width: 100%">
		  		<jsp:include page="SignaturesList.jsp"></jsp:include>
		  	</div>
		  </div>
			 
		  <div id="generalInformation-3_${_pageRef}" >
		  	<div id="generalInformation-3_content_${_pageRef}" style="width: 100%">
		  		<jsp:include page="GeneralAnnotation.jsp"></jsp:include>
		  	</div>
		  </div> 
		</ps:if>
	</psj:tabbedpanel>
