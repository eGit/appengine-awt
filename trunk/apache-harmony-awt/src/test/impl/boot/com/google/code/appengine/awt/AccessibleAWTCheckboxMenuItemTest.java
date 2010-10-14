/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * @author Dmitry A. Durnev
 */
package com.google.code.appengine.awt;


import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleValue;

import com.google.code.appengine.awt.CheckboxMenuItem;
import com.google.code.appengine.awt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem;


import junit.framework.TestCase;

public class AccessibleAWTCheckboxMenuItemTest extends TestCase {

    CheckboxMenuItem item;
    AccessibleContext ac;
    AccessibleValue value;
    AccessibleAction action;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        item = new CheckboxMenuItem();
        ac = item.getAccessibleContext();
        action = ac.getAccessibleAction();
        value = ac.getAccessibleValue();
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getAccessibleAction()'
     */
    public void testGetAccessibleAction() {
        assertSame(ac, ac.getAccessibleAction());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getAccessibleRole()'
     */
    public void testGetAccessibleRole() {
        assertSame(AccessibleRole.CHECK_BOX, ac.getAccessibleRole());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getAccessibleValue()'
     */
    public void testGetAccessibleValue() {
        assertSame(ac, ac.getAccessibleValue());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getAccessibleActionCount()'
     */
    public void testGetAccessibleActionCount() {
        assertEquals(0, action.getAccessibleActionCount());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.doAccessibleAction(int)'
     */
    public void testDoAccessibleAction() {
        assertFalse(action.doAccessibleAction(0));
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getCurrentAccessibleValue()'
     */
    public void testGetCurrentAccessibleValue() {
        assertNull(value.getCurrentAccessibleValue());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getMaximumAccessibleValue()'
     */
    public void testGetMaximumAccessibleValue() {
        assertNull(value.getMaximumAccessibleValue());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getMinimumAccessibleValue()'
     */
    public void testGetMinimumAccessibleValue() {
        assertNull(value.getMaximumAccessibleValue());
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.setCurrentAccessibleValue(Number)'
     */
    public void testSetCurrentAccessibleValue() {
        assertFalse(value.setCurrentAccessibleValue(null));
        assertFalse(value.setCurrentAccessibleValue(new Integer(1)));
    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.getAccessibleActionDescription(int)'
     */
    public void testGetAccessibleActionDescription() {
        assertNull(action.getAccessibleActionDescription(0));

    }

    /*
     * Test method for 'java.nawt.CheckboxMenuItem.AccessibleAWTCheckboxMenuItem.AccessibleAWTCheckboxMenuItem(CheckboxMenuItem)'
     */
    public void testAccessibleAWTCheckboxMenuItem() {
        assertTrue(ac instanceof AccessibleAWTCheckboxMenuItem);
    }

}
