/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.api;

/**
 *
 * @author bernd_000
 */
public interface UserDAOIF {
    public boolean checkUserExistance(String username);
    
    public boolean checkPassword(String username, String password);
    
    public byte[] getSalt(String username);
}
