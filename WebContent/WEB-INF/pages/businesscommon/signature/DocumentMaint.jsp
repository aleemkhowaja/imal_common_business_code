<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<%@page import="com.path.bo.common.ConstantsCommon"%>
<%@page import="com.path.bo.common.PluginsConstants"%>

<script type="text/javascript">
$.struts2_jquery.require("jquery.iviewer.min.js", null, jQuery.contextPath
		+ "/common/jquery/js/plugins/");
$.struts2_jquery.require("jquery.mousewheel.min.js", null, jQuery.contextPath
		+ "/common/jquery/js/plugins/");
$.struts2_jquery.require("jquery.tools.min.js", null, jQuery.contextPath
		+ "/common/js/");
$.struts2_jquery.require("Scan.js", null, jQuery.contextPath
		+ "/common/js/scan/");
</script>

<div id="documentFormDiv_<ps:property value="_pageRef" escapeHtml="true"/><ps:property value="secondaryId" escapeHtml="true"/>"
	style="overflow: hidden">
	<ps:form id="documentFormId_${_pageRef}${secondaryId}" method="post"
		enctype="multipart/form-data" namespace="/path/signature/"
		useHiddenProps="true">
		<ps:hidden name="signatureCO.viewMode"
			id="docPageMode_${_pageRef}${secondaryId}" />
		<!-- to identify whether the page is in Add/Edit/View Mode -->
		<ps:hidden name="fileUploadContentType"
			id="docFileType_${_pageRef}${secondaryId}" />
		<!-- populated while adding a document -->
		<ps:hidden name="signTempFileName"
			id="docImportFile_temp_${_pageRef}${secondaryId}" />
		<ps:hidden name="signatureCO.cifObjectVO.OBJECT_SEQ"
			id="docObjectSeq_${_pageRef}${secondaryId}" />
		<ps:hidden name="signatureCO.cifObjectVO.OBJECT_CODE"
			id="docObjectCode_${_pageRef}${secondaryId}" />
		<ps:hidden name="signatureCO.scanVO.DOC_TYPE"
			id="docType_${_pageRef}${secondaryId}" />

		<table width="100%" border="0">
			<tr>
				<td class="fldLabelView" width="20%">
					<ps:if test='signatureCO.scanVO.DOC_TYPE.equals("D")'>
						<ps:label key="Document_Desc_key"
							id="docDescLabel_${_pageRef}${secondaryId}"
							for="docDesc_${_pageRef}${secondaryId}" />
					</ps:if>
					<ps:else>
						<ps:label key="Photo_Description_key"
							id="docDescLabel_${_pageRef}${secondaryId}"
							for="docDesc_${_pageRef}${secondaryId}" />
					</ps:else>
				</td>
				<td width="30%">
					<ps:textfield name="signatureCO.scanVO.DESCRIPTION"
						id="docDesc_${_pageRef}${secondaryId}" maxlength="40" />
				</td>
				<ps:if test='signatureCO.viewMode.equals("A")'>

					<td class="fldLabelView" width="20%">
						<ps:label key="Open_Import_from_file_key"
							id="docImportFileLabel_${_pageRef}${secondaryId}"
							for="docImportFile_${_pageRef}${secondaryId}" />
					</td>
					<td id="docImportFileContainer_${_pageRef}${secondaryId}"
						width="30%">
						<ps:file id="docImportFile_${_pageRef}${secondaryId}"
							name="fileUpload"></ps:file>
					</td>
				</ps:if>
				<ps:else>

					<td width="20%"></td>
					<td width="30%"></td>
				</ps:else>
			</tr>
			<tr>
				<td class="fldLabelView">
					<ps:if test='signatureCO.scanVO.DOC_TYPE.equals("D")'>
						<ps:label key="Document_Img_key" />
					</ps:if>
					<ps:else>
						<ps:label key="Photo_Image_key" />
					</ps:else>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">

						<tr>
							<td>
								<div id="edit_doc_viewer_<ps:property value="_pageRef" escapeHtml="true"/><ps:property value="secondaryId" escapeHtml="true"/>"
									style="width: 250px; height: 250px; border: 1px solid #CCCCCC; position: relative;"></div>
							</td>
						</tr>
					</table>
				</td>
				<ps:if test='signatureCO.scanVO.DOC_TYPE.equals("P")'>
					<td class="fldLabelView" valign="top">
						<ps:checkbox name="signatureCO.defaultPhoto"
							id="docDefaultPhoto_${_pageRef}${secondaryId}" />
						<ps:label key="Set_as_default_key" />
					</td>
				</ps:if>
			</tr>
		</table>

		<ps:if test="%{_recReadOnly!='true'}">
			<pt:toolBar id="signDocTooBar_${_pageRef}${secondaryId}">

				<psj:submit button="true" freezeOnSubmit="true">
					<ps:text name="btn.save"></ps:text>
				</psj:submit>
				<ps:if test='signatureCO.viewMode.equals("A")'>
					<object name="PathCtrl" style='display: none' id='PathCtrl'
						classid='<%=PluginsConstants.TWAIN_CLSID%>'
						codebase='../login/PathTWAINCtrl.cab#version=<%=PluginsConstants.TWAIN_AX_VERSION%>'></object>
					<psj:submit button="true" freezeOnSubmit="true" type="button"
						onclick="resetDocumentForm('%{_pageRef}%{secondaryId}');">
						<ps:text name="btn.clear"></ps:text>
					</psj:submit>
					<psj:submit button="true" freezeOnSubmit="true" type="button"
						onclick="scanSignature();">
						<ps:text name="Open_Scan_key"></ps:text>
					</psj:submit>
				</ps:if>

			</pt:toolBar>
		</ps:if>
	</ps:form>
</div>
<script>

$(document)
		.ready(
				function() {
					var url = "#"
					var objectCode = '<ps:property value="signatureCO.cifObjectVO.OBJECT_CODE"  escapeHtml="false" escapeJavaScript="true"/>'
					var objectSeq = '<ps:property value="signatureCO.cifObjectVO.OBJECT_SEQ"  escapeHtml="false" escapeJavaScript="true"/>'
					if (!objectCode == '') {
						url = jQuery.contextPath
								+ "/path/signature/Signature_loadDocumentImage?progRef="
								+ _pageRef
								+ "&signatureCO.cifObjectVO.OBJECT_CODE="+objectCode+"&signatureCO.cifObjectVO.OBJECT_SEQ="+objectSeq+"&signatureCO.cifObjectVO.BRANCH_CODE="
								+ $("#signatureBranchCode_" + _pageRef).val();
					}
					$("#edit_doc_viewer_${_pageRef}${secondaryId}").iviewer( {
						src : url
					});
					$("#docImportFile_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').die('change');
					$("#docImportFile_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>')
							.live(
									"change",
									function() {
										displayDocImg(this,
												'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>')
									});
					$("#documentFormId_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>')
							.processAfterValid("saveDocument",
									[ '<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>' ]);

				});
</script>




