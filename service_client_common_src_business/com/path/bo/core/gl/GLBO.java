/**
 * 
 */
package com.path.bo.core.gl;

import java.math.BigDecimal;
import java.util.List;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.gl.GLCO;
import com.path.vo.core.gl.GLSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          GLBO.java used to
 */
public interface GLBO
{
    public Boolean checkGLValidation(GLSC criteria) throws BaseException;

    public GEN_LEDGERVO returnGenLedgerById(GLSC criteria) throws BaseException;

    public GEN_LEDGERVO dependencyByGlCode(GLSC criteria) throws BaseException;

    public int glListCount(GLSC glSc) throws BaseException;

    public List glList(GLSC glSc) throws BaseException;

    public BigDecimal dependencyByGlAmfRifatt(AccountSC glSc) throws BaseException;

    public int glListFromGLCount(GLSC glSc) throws BaseException;

    public List glListFromGL(GLSC glSc) throws BaseException;

    public GEN_LEDGERVO dependencyByGlFromGL(GLSC glSc) throws BaseException;

    public String getBsContra(GLSC glSc) throws BaseException;

    public int selectgenLedgerglcode(GLSC glSc) throws BaseException;

    public GEN_LEDGERVO returnGl(GLSC criteria) throws BaseException;

    public GEN_LEDGERVO dependencyByGlFromAmfRifattGL(AccountSC criteria) throws BaseException;

    public Integer glAmfListCount(GLSC glSC) throws BaseException;

    public List<GLCO> glAmfList(GLSC glSC) throws BaseException;

    /**
     * return the details of specific GL Code based on specific search criteria
     * from glSC
     * 
     * @author HanaaElJazzar
     * @param glSC
     * @return GEN_LEDGERVO
     * @throws BaseException
     */
    public GEN_LEDGERVO getGLDetailsFromGL(GLSC glSC) throws BaseException;
}
