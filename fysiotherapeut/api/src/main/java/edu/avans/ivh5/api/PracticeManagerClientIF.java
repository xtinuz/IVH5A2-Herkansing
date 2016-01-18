/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.api;

import edu.avans.ivh5.shared.model.domain.PhysioPractice;

/**
 *
 * @author Sjonn
 */
public interface PracticeManagerClientIF {
    
    public boolean saveCompanyInfo(PhysioPractice practice);
    
}