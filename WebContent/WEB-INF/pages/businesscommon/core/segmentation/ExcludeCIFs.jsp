<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
		
<ps:set name="delete_selected_record_key" value="%{getEscText('app.deleteConfirm')}"/>

		<table border="0" align="center" class="ui-widget-content" width="100%">
			<tr>
				<td class="fldLabelView" width="20%">
					<ps:label key="Code_key"/>
				</td>
				<td class="fldDataEdit center" width="10%" colspan="2">
					<ps:textfield id="popExcludeCIFSegCode_${_pageRef}"
					name="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" mode="number"  disabled="true"
					cssClass="ui-widget-content textCompSize ui-corner-all"/>
				</td>
				<td class="fldLabelView" width="20%">
					<ps:label key="Description_key"/>
				</td>
				
				<td class="fldDataEdit center" width="40%">
					<ps:textfield id="popExcludeCIFSegDesc_${_pageRef}"
						name="custSegmentationCO.segmentDesc"  mode="text" disabled="true"
						maxlength="100"/>
				</td>
				
			</tr>
		</table>
		
		<div style="width:100%;"> 
			<ps:url id="urlExcludeCifsGrid" action="CustSegmentationMaintAction_loadExcludeCifGrid" namespace="/path/segmentation" escapeAmp="false">
				<ps:param name="segmentCode" value="custSegmentationCO.ctsSegmentVO.SEGMENT_CODE" ></ps:param>
				<ps:param name="custSegmentationCO.isSegmentationScore" value="custSegmentationCO.isSegmentationScore" ></ps:param>
			</ps:url>

				<psjg:grid id="excludeCifsGridTbl_Id_${_pageRef}" 
				    dataType="json"
					href="%{urlExcludeCifsGrid}"
					 pager="true" 
					 filter="false"
					gridModel="gridModel" 
					rowNum="5" 
					rowList="5,10,15,20"
					viewrecords="true" 
					navigator="true"
					 navigatorAdd="#attr['showAddDeleteBtn']"
					navigatorDelete="#attr['showAddDeleteBtn']"
					 navigatorEdit="false"
					navigatorRefresh="false" 
					navigatorSearch="false" 
					height="110"
					altRows="true" 
					pagerButtons="true" 
					editinline="true"
					editurl="asfd" 
					rownumbers="true"
					 addfunc="excludeCifs_addId"
					delfunc="excludeCifs_deleteId"
					onEditInlineBeforeTopics="excludeCifsOnEditLoad">

					<psjg:gridColumn id="CIF_NO_${_pageRef}" colType="liveSearch"
						name="ctsSegmentCifExcludeVO.CIF_NO" index="CIF_NO"
						resultList="CIF_NO:ctsSegmentCifExcludeVO.CIF_NO_lookuptxt"
						editable="true" sortable="false" search="false" mode="number"
						width="70"
						dataAction="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup"
						paramList="_pageRef:pageRef_${_pageRef},criteria.segmentCode:popExcludeCIFSegCode_${_pageRef},fromWhere:~CONST_%{fromWhere}"
						title="%{getText('CIF_NO')}"
						searchElement="ctsSegmentCifExcludeVO.CIF_NO" leadZeros="8"
						editoptions="{ dataEvents: [{ type: 'change', fn: function(e) { onChangingExcludeCif(e) } }], maxlength: '8' }" 
						params="cifVO.CIF_NO:ctsSegmentCifExcludeVO.CIF_NO"
						dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifDependencyAction_dependencyByCif"
						dependency="cifVO.CIF_NO:ctsSegmentCifExcludeVO.CIF_NO"
					/>
						
				</psjg:grid>

			</div>
			
<script  type="text/javascript">
var delete_selected_record_key='<ps:property value="delete_selected_record_key"  escapeHtml="false" escapeJavaScript="true"/>';

 $.struts2_jquery.require("ExcludeCifList.js" ,null,jQuery.contextPath+"/path/js/customersegmentation/");
</script>
