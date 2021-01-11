package com.path.core.actions.grouping;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.grouping.SegmentGroupingBO;
import com.path.bo.core.grouping.SegmentGroupingConstant;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.grouping.SegmentGroupingCO;
import com.path.vo.core.grouping.SegmentGroupingSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingMaintAction.java used to
 */
public class SegmentGroupingMaintAction extends BaseAction
{

	private SegmentGroupingBO segmentGroupingBO;
	private SegmentGroupingCO segmentGroupingCO = new SegmentGroupingCO();
	private SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();
	private boolean _newRecord = true;
	private List gridModel;

	/**
	 * make a loop on the list names to generate them
	 */

	public Object getModel()
	{
		return segmentGroupingCO;
	}

	private List<SelectCO> status = new ArrayList<SelectCO>();

	public List<SelectCO> getStatus()
	{
		return status;
	}

	public void setStatus(List<SelectCO> status)
	{
		this.status = status;
	}

	public String loadSegmentGroupingPage()
	{
		try
		{
			initializeMethod();
			set_searchGridId("segmentGroupingListGridTbl_Id");
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "segmentGroupingList";
	}

	public String initialize()
	{
		try
		{
			initializeMethod();
		}
		catch (BaseException e)
		{
			handleException(e, null, null);
		}
		return "success";
	}

	public String saveGroup()
	{
		try
		{
			fillSessionVariables();

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CTS_SEGMENT_GROUPING_KEY_REF);
			segmentGroupingCO.setAuditRefCO(refCO);

			if (is_newRecord())
			{
				refCO.setOperationType(AuditConstant.CREATED);
				segmentGroupingCO = segmentGroupingBO.saveNewGroup(segmentGroupingCO);
			}
			else
			{
				refCO.setOperationType(AuditConstant.UPDATE);
				segmentGroupingCO.setAuditObj(returnAuditObject(segmentGroupingCO.getClass()));

				segmentGroupingCO = segmentGroupingBO.updateGroup(segmentGroupingCO);
			}
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successJson";
	}

	public String deleteGroup()
	{
		try
		{
			fillSessionVariables();

			segmentGroupingBO.deleteGroup(segmentGroupingCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "successJson";
	}

	public String dependencyByGroupCode()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			segmentGroupingCO.getCtsSegmentGroupingVO().setGROUP_CODE(NumberUtil.emptyDecimalToNull(segmentGroupingSC.getGroupCode()));
			segmentGroupingSC.setCompCode(sessionCO.getCompanyCode());

			segmentGroupingBO.returnSegmentGroupCount(segmentGroupingSC);
		}
		catch (Exception e)
		{
			segmentGroupingCO.getCtsSegmentGroupingVO().setGROUP_CODE(null);
			handleException(e, null, null);
		}
		return "successJson";

	}

	public String dependencyByPriority()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();

			segmentGroupingCO.getCtsSegmentGroupingVO().setPRIORITY(NumberUtil.emptyDecimalToNull(segmentGroupingSC.getPriority()));
			segmentGroupingSC.setCompCode(sessionCO.getCompanyCode());

			segmentGroupingBO.returnPriorityCountByCompany(segmentGroupingSC);
		}
		catch (Exception e)
		{
			segmentGroupingCO.getCtsSegmentGroupingVO().setPRIORITY(null);
			handleException(e, null, null);
		}
		return "successJson";
	}

	private void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		segmentGroupingCO.setCrud(getIv_crud());
		segmentGroupingCO.setLanguage(sessionCO.getLanguage());
		segmentGroupingCO.setLoginCompCode(sessionCO.getCompanyCode());
		segmentGroupingCO.setLoginBraCode(sessionCO.getBranchCode());
		segmentGroupingCO.setRunningDate(sessionCO.getRunningDateRET());
		segmentGroupingCO.setLoginUserId(sessionCO.getUserName());
		segmentGroupingCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		segmentGroupingCO.setOpt(get_pageRef());
		segmentGroupingCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		segmentGroupingCO.setAppName(sessionCO.getCurrentAppName());
	}

	private void showCrudButtonsByAccess() throws BaseException
	{
		String[] optDetailsArr = returnCommonLibBO().returnOptDetailsList(returnSessionObject().getCurrentAppName(), get_pageRef());
		String parentOpt = "";
		if (optDetailsArr != null && optDetailsArr.length > 3)
		{
			parentOpt = StringUtil.nullToEmpty(optDetailsArr[3]);
		}

		String menuButtonAccess = "";

		if (ConstantsCommon.CRUD_MAINTAIN.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(SegmentGroupingConstant.MAINT_IVCRUD);
		}

		else if (ConstantsCommon.CRUD_APPROVE.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(ConstantsCommon.CRUD_APPROVE);
		}
		else if (SegmentGroupingConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
		{
			menuButtonAccess = parentOpt.concat(SegmentGroupingConstant.UPDATE_AFTER_APPROVE_IVCRUD);
		}

		ServletActionContext.getRequest().setAttribute("menuButtonAccess", menuButtonAccess);
	}

	private void initializeMethod() throws BaseException
	{
		fillSessionVariables();
		showCrudButtonsByAccess();

		segmentGroupingCO = segmentGroupingBO.initialiseData(segmentGroupingCO, _newRecord);
		setAdditionalScreenParams(segmentGroupingCO.getBuisnessElement());

		if ("R".equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.TRUE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.FALSE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}
		else if ("P".equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.FALSE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.TRUE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}
		else if (SegmentGroupingConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
		{
			set_showNewInfoBtn(ConstantsCommon.FALSE);
			set_showSmartInfoBtn(ConstantsCommon.FALSE);
			set_recReadOnly(ConstantsCommon.FALSE);
			set_showRecordLogsBtn(ConstantsCommon.FALSE);
		}

		segmentGroupingCO.getCtsSegmentGroupingVO().setSTATUS("A");
		segmentGroupingCO.setStatusDesc(getText("Active_key"));
	}

	public String retrieveSegmentGroup()
	{
		try
		{
			applyRetrieveAudit(AuditConstant.CTS_SEGMENT_GROUPING_KEY_REF, segmentGroupingCO, segmentGroupingCO);

			fillSessionVariables();
			showCrudButtonsByAccess();

			SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();

			segmentGroupingCO = segmentGroupingBO.initialiseData(segmentGroupingCO, _newRecord);
			setAdditionalScreenParams(segmentGroupingCO.getBuisnessElement());

			if (segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE() != null)
			{
				segmentGroupingSC.setCompCode(segmentGroupingCO.getLoginCompCode());
				segmentGroupingSC.setCrudMode(getIv_crud());
				segmentGroupingSC.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
				segmentGroupingSC.setLovTypeId(SegmentGroupingConstant.LOV_TYPE);
				segmentGroupingSC.setLanguage(segmentGroupingCO.getLanguage());
				segmentGroupingCO.setCrud(getIv_crud());

				segmentGroupingCO = segmentGroupingBO.returnSegmentGroupingForm(segmentGroupingSC);
				
				setAdditionalScreenParams(segmentGroupingCO.getBuisnessElement());
			}

			if ("R".equals(getIv_crud()) && ("".equals(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS())
					|| "A".equals(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS())))
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
			}
			else if ("R".equals(getIv_crud()) && !("".equals(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS())
					|| "A".equals(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS())))
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.TRUE);
			}
			else if ("P".equals(getIv_crud()))
			{
				set_showNewInfoBtn(ConstantsCommon.FALSE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.TRUE);
			}
			else if (SegmentGroupingConstant.UPDATE_AFTER_APPROVE_IVCRUD.equals(getIv_crud()))
			{
				set_showNewInfoBtn(ConstantsCommon.TRUE);
				set_showSmartInfoBtn(ConstantsCommon.FALSE);
				set_recReadOnly(ConstantsCommon.FALSE);
			}

			applyRetrieveAudit(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF, segmentGroupingCO.getCtsSegmentGroupingVO(), segmentGroupingCO);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return "success";
	}

	public String approveGroup()
	{
		try
		{
			fillSessionVariables();
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CTS_SEGMENT_GROUPING_KEY_REF);
			segmentGroupingCO.setAuditRefCO(refCO);
			refCO.setOperationType(AuditConstant.UPDATE);

			if (segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED() != null)
			{
				segmentGroupingCO = segmentGroupingBO.checkGroupDateUpdated(segmentGroupingCO);
			}
			segmentGroupingCO = segmentGroupingBO.approveGroup(segmentGroupingCO);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return "successJson";
	}

	public String rejectGroup()
	{
		try
		{
			fillSessionVariables();

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CUST_SEGMENTATION_SCREEN_KEY_REF);
			segmentGroupingCO.setAuditRefCO(refCO);
			refCO.setOperationType(AuditConstant.UPDATE);
			segmentGroupingCO = segmentGroupingBO.rejectGroup(segmentGroupingCO);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return "successJson";
	}

	public void setSegmentGroupingBO(SegmentGroupingBO segmentGroupingBO)
	{
		this.segmentGroupingBO = segmentGroupingBO;
	}

	public SegmentGroupingSC getSegmentGroupingSC()
	{
		return segmentGroupingSC;
	}

	public void setSegmentGroupingSC(SegmentGroupingSC segmentGroupingSC)
	{
		this.segmentGroupingSC = segmentGroupingSC;
	}

	public SegmentGroupingCO getSegmentGroupingCO()
	{
		return segmentGroupingCO;
	}

	public void setSegmentGroupingCO(SegmentGroupingCO segmentGroupingCO)
	{
		this.segmentGroupingCO = segmentGroupingCO;
	}

	public boolean is_newRecord()
	{
		return _newRecord;
	}

	public void set_newRecord(boolean _newRecord)
	{
		this._newRecord = _newRecord;
	}

	public List getGridModel()
	{
		return gridModel;
	}

	public void setGridModel(List gridModel)
	{
		this.gridModel = gridModel;
	}
}
