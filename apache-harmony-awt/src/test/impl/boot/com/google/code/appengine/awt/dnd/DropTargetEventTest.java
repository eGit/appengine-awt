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

package com.google.code.appengine.awt.dnd;

import com.google.code.appengine.awt.dnd.DropTarget;
import com.google.code.appengine.awt.dnd.DropTargetEvent;

import junit.framework.TestCase;

public class DropTargetEventTest extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(DropTargetEventTest.class);
    }

    /**
     * Test method for
     * {@link com.google.code.appengine.awt.dnd.DropTargetEvent#DropTargetEvent(com.google.code.appengine.awt.dnd.DropTargetContext)}.
     */
    public void testDropTargetEventDropTargetContext() {
        // Regression test for HARMONY-2430
        try {
            new DropTargetEvent(null);
            fail("NPE was not thrown");
        } catch (NullPointerException ex) {
            // passed
        }

        final DropTarget dt = new DropTarget();
        final DropTargetEvent e = new DropTargetEvent(dt.getDropTargetContext());

        assertSame(dt, e.getSource());
    }
}
