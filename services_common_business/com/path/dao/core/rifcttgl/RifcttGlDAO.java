package com.path.dao.core.rifcttgl;

import java.util.List;

import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.rifcttgl.RifcttGlSC;

public interface RifcttGlDAO
{
    public int accountListCount(RifcttGlSC criteria) throws DAOException;

    public List accountList(RifcttGlSC criteria) throws DAOException;

    public RIFCTT_GLVO returnRifcttGlById(RifcttGlSC criteria) throws DAOException;

    public int getRifMessageByCompLkpCount(RifcttGlSC criteria) throws DAOException;

    public List getRifMessageByCompLkpList(RifcttGlSC criteria) throws DAOException;
}
