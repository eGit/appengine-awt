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
 * @author Pavel Dolgov
 */
package com.google.code.appengine.awt.im.spi;

import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;

import com.google.code.appengine.awt.Window;
import com.google.code.appengine.awt.font.TextHitInfo;
import com.google.code.appengine.awt.im.InputMethodRequests;
import com.google.code.appengine.awt.im.spi.InputMethod;


public interface InputMethodContext extends InputMethodRequests {

    public JFrame createInputMethodJFrame(String title, boolean attachToInputContext);

    public Window createInputMethodWindow(String title, boolean attachToInputContext);

    public void dispatchInputMethodEvent(int id, AttributedCharacterIterator text, int committedCharacterCount, TextHitInfo caret, TextHitInfo visiblePosition);

    public void enableClientWindowNotification(InputMethod inputMethod, boolean enable);

}

