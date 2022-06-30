package com.digiwin.sampleapp1.batest.dao;


import com.digiwin.sampleapp1.batest.domian.SolutionInfo;

public interface SolutionEditDao {
    int addEditOne(SolutionInfo solutionInfo);
    SolutionInfo selectEditById(String uuid);
    String selectMaxSolutionId();
}
