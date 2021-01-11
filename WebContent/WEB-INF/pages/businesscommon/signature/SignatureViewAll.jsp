<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>




 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/iviewer/jquery.iviewer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/scrollable/scrollable-buttons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/style/scrollable/scrollable-horizontal.css">

<div style="margin:0px auto;" class="no-print">
    <div id='sign_viewer_<ps:property value="_pageRef" escapeHtml="true"/>' class="viewer"> </div> 
	<a class="prev browse left"></a><!-- "previous page" action --> 
	<ps:hidden value="%{signatureCOList.isEmpty()}" cssClass="test11" id="isViewAllSignListEmpty_${_pageRef}"></ps:hidden>
	<div class="scrollable " id='sign_scrollable_<ps:property value="_pageRef" escapeHtml="true"/>'><!-- root element for scrollable -->
  		<div class="items" id='sign_items_<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'> <!-- root element for the items -->
			  <ps:set var="pageFirstIndex" value="%{1}" />
			  <ps:set var="signPerPage"  value="%{6}"/>	 
			 	   
			  	<ps:iterator   var="signCO"  value="signatureCOList"    status="rowStatus" > 	 
			  	 <ps:if test="%{#rowStatus.count==#pageFirstIndex}">
			  		<ps:set var="pageFirstIndex" value="%{#pageFirstIndex+#signPerPage}" />	 	
			  	  	<div>
			  	 </ps:if>     			 
			  	 	<span>  
			  	 		<table>	
			  	 		<tr>
			  	 		<td  > 		
			  		 		<img  alt="<ps:url  action="Signature_loadSignatureImage?signatureCO.cifObjectVO.OBJECT_CODE=${signCO.cifObjectVO.OBJECT_CODE}&signatureCO.cifObjectVO.BRANCH_CODE=${signatureCO.cifObjectVO.BRANCH_CODE}" namespace="/path/signature"/>"  src=" <ps:url  action="Signature_loadSignatureImage?signatureCO.cifObjectVO.OBJECT_CODE=${signCO.cifObjectVO.OBJECT_CODE}&signatureCO.cifObjectVO.BRANCH_CODE=${signatureCO.cifObjectVO.BRANCH_CODE}" namespace="/path/signature"/>"      />
			  		 	</td>
			  		 	</tr>
			  		 	<!--<tr>  		 	 
			  		 	<td >			  		 		  		 		 	 	
			  		 		<ps:checkbox fieldValue="${signCO.cifObjectVO.OBJECT_CODE}" cssClass="ui-widget-content checkboxheight _viewAllSignChckBox"   onclick="setSignAsViewed(this,${signCO.cifObjectVO.OBJECT_CODE})"   key="Viewed" />
			  		 	</td>
			  		 	</tr> -->
			  		 
			  		 	</table>
			  		</span>
			   	 <ps:if test="%{#rowStatus.count==(#pageFirstIndex-1)||#rowStatus.last}">   	 
			  	  	</div>
			  	  </ps:if> 		  		 
			  	</ps:iterator>
			  </div>
     </div> 
	<a class="next browse right"></a><!-- "next page" action -->
</div>

<style>
.viewer
      {
          width: 50%;
          height: 300px;
          border: 1px solid #CCCCCC;
          position: relative;
          text-align:left;          
          margin: 0px auto;
          
      }
</style>
<script>
 
 $(document).ready(function () {
     initializeSignScrollable();
    });
 
</script>

 