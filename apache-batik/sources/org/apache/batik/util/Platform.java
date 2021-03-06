/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.util;

import com.google.code.appengine.awt.Frame;
import java.lang.reflect.Method;

/**
 * Platform specific functionality.
 *
 * @author <a href="mailto:cam%40mcc%2eid%2eau">Cameron McCormack</a>
 * @version $Id: Platform.java 713578 2008-11-13 00:28:21Z cam $
 */
public abstract class Platform {

    /**
     * Whether we are running on Mac OS X.
     */
    public static boolean isOSX =
        System.getProperty("os.name").equals("Mac OS X");
}
