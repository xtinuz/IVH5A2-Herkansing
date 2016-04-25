/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.client.view.ui.AddSessionScreen;
import edu.avans.ivh5.client.view.ui.SchedulePanel;
import edu.avans.ivh5.client.view.ui.TreatmentPanel;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Treatment;
import edu.avans.ivh5.shared.model.domain.TreatmentType;
import edu.avans.ivh5.shared.models.ClientDTO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michel
 */
public class TreatmentAndSessionControllerTest {
    
    public TreatmentAndSessionControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setUIRef method, of class TreatmentAndSessionController.
     */
    @Test
    public void testSetUIRef_TreatmentPanel() {
        System.out.println("setUIRef");
        TreatmentPanel parentPanel = null;
        TreatmentAndSessionController instance = null;
        instance.setUIRef(parentPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUIRef method, of class TreatmentAndSessionController.
     */
    @Test
    public void testSetUIRef_AddSessionScreen() {
        System.out.println("setUIRef");
        AddSessionScreen sessionScreen = null;
        TreatmentAndSessionController instance = null;
        instance.setUIRef(sessionScreen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUIRef method, of class TreatmentAndSessionController.
     */
    @Test
    public void testSetUIRef_SchedulePanel() {
        System.out.println("setUIRef");
        SchedulePanel scheduleScreen = null;
        TreatmentAndSessionController instance = null;
        instance.setUIRef(scheduleScreen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveTreatment method, of class TreatmentAndSessionController.
     */
    @Test
    public void testSaveTreatment() {
        System.out.println("saveTreatment");
        Treatment treatment = null;
        TreatmentAndSessionController instance = null;
        instance.saveTreatment(treatment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TreatmentAndSessionController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyTyped method, of class TreatmentAndSessionController.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.keyTyped(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class TreatmentAndSessionController.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.keyPressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class TreatmentAndSessionController.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.keyReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseClicked method, of class TreatmentAndSessionController.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.mouseClicked(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class TreatmentAndSessionController.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseReleased method, of class TreatmentAndSessionController.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.mouseReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseEntered method, of class TreatmentAndSessionController.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.mouseEntered(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseExited method, of class TreatmentAndSessionController.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        TreatmentAndSessionController instance = null;
        instance.mouseExited(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployees method, of class TreatmentAndSessionController.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        TreatmentAndSessionController instance = null;
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = instance.getEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTreatmentTypes method, of class TreatmentAndSessionController.
     */
    @Test
    public void testGetTreatmentTypes() {
        System.out.println("getTreatmentTypes");
        TreatmentAndSessionController instance = null;
        ArrayList<TreatmentType> expResult = null;
        ArrayList<TreatmentType> result = instance.getTreatmentTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTreatments method, of class TreatmentAndSessionController.
     */
    @Test
    public void testAddTreatments() {
        System.out.println("addTreatments");
        TreatmentAndSessionController instance = null;
        instance.addTreatments();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClient method, of class TreatmentAndSessionController.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        TreatmentAndSessionController instance = null;
        ClientDTO expResult = null;
        ClientDTO result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
