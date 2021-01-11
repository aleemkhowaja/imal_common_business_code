package com.path.core.bo.transferentity;

import java.util.List;
import com.path.vo.core.transferentity.TransferEntityCO;
import com.path.vo.core.transferentity.TransferEntityGridCO;
import com.path.vo.core.transferentity.TransferEntitySC;
import com.path.dbmaps.vo.CTS_TRANSFER_ENTITYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;

public interface TransferEntityBO
{

	public TransferEntityCO hideFields(TransferEntityCO transferEntityCO) throws BaseException;

	public TransferEntityCO dependencyByFromApp(TransferEntityCO transferEntityCO) throws BaseException;

	public TransferEntityCO dependencyByToApp(TransferEntityCO transferEntityCO) throws BaseException;

	public List<TransferEntityGridCO> transferEntityGridList(TransferEntitySC transferEntitySC) throws BaseException;

	public TransferEntityCO save(TransferEntityCO transferEntityCO) throws BaseException;
	public TransferEntityCO updateRecordStatus(TransferEntityCO transferEntityCO) throws BaseException;

	public Integer loadTransferEntityListCount(TransferEntitySC transferEntitySC) throws BaseException;

	public List<TransferEntityCO> loadTransferEntityList(TransferEntitySC transferEntitySC) throws BaseException;

	public TransferEntityCO returnTransferEntityRecord(TransferEntitySC transferEntitySC) throws BaseException;

	public void checkTransferEntityStatus(TransferEntityCO transferEntityCO) throws BaseException;

	public TransferEntityCO rejectTransferEntity(TransferEntityCO transferEntityCO) throws BaseException;
    
	public int retFmsApplicationListCount(TransferEntitySC transferEntitySC) throws BaseException;

    public List retFmsApplicationList(TransferEntitySC transferEntitySC) throws BaseException;
    
	public int retRelationManagerListCount(TransferEntitySC transferEntitySC) throws BaseException;

    public List retRelationManagerList(TransferEntitySC transferEntitySC) throws BaseException;

    public TransferEntityCO dependencyByRelationManager(TransferEntityCO transferEntityCO) throws BaseException;
	
}
