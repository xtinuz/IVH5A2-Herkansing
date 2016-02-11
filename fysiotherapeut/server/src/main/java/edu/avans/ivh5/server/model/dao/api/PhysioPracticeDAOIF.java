/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;

import edu.avans.ivh5.shared.model.domain.PhysioPractice;


public interface PhysioPracticeDAOIF {
    public boolean savePhysioPractice(PhysioPractice physiopractice);   
    public PhysioPractice getCompanyInfo();
    
}
