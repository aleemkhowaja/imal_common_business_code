package com.path.bo.core.rifcttgl;

import java.util.List;

import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.rifcttgl.RifcttGlSC;

public interface RifcttGlBO
{
    public int accountListCount(RifcttGlSC criteria) throws BaseException;

    public List accountList(RifcttGlSC criteria) throws BaseException;

    public RIFCTT_GLVO returnRifcttGlById(RifcttGlSC criteria) throws BaseException;

    public int getRifMessageByCompLkpCount(RifcttGlSC criteria) throws BaseException;

    public List getRifMessageByCompLkpList(RifcttGlSC criteria) throws BaseException;
}
