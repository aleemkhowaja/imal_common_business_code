
function onEditInlineBeforeTopcics_addParamClass(entityType)
{

	var entityType = $("#entityType_"+_pageRef).val();
	if(entityType == "Q"){
		
		var queryParamGridId = $('#queryGridId').val();
		var criteriaParamGridTbl = $("#" + queryParamGridId + _pageRef)
	}
	
	
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);

	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_CLASS");
	  if (paramVal == "F" || paramVal == "D")
			  {
			    criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.SESSION_ATTR_NAME",null);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", false);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
			  }
  if(paramVal == "S"  )
        	 {
                criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_VALUE",null);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", false);
	         }

}

function criteriaParam_onEditInlineBeforeTopics(entityType)
{
	//var entityType = $("#entityType_"+_pageRef).val();
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);
	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_CLASS");
	if(paramVal == "S" )
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", false);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);

	}
	else
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", false);
	}
}
