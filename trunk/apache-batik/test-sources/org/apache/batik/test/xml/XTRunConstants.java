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
package org.apache.batik.test.xml;

/**
 * Contains constants for the XML Test Run (XTRun) syntax.
 *
 * @author <a href="mailto:vhardy@apache.org">Vincent Hardy</a>
 * @version $Id: XTRunConstants.java 475477 2006-11-15 22:44:28Z cam $
 */
public interface XTRunConstants {
    String XTRun_NAMESPACE_URI 
        = "http://xml.apache.org/xml-batik/test/xtrun";

    /////////////////////////////////////////////////////////////////////////
    // XTRun tags
    /////////////////////////////////////////////////////////////////////////
    String XTRun_TEST_RUN_TAG = "testRun";
    String XTRun_TEST_SUITE_TAG = "testSuite";
    String XTRun_TEST_REPORT_PROCESSOR_TAG = "testReportProcessor";

    /////////////////////////////////////////////////////////////////////////
    // XTRun attributes
    /////////////////////////////////////////////////////////////////////////
    String XTRun_HREF_ATTRIBUTE = "href";
    String XTRun_ID_ATTRIBUTE   = "id";
    String XTRun_NAME_ATTRIBUTE  = "name";
}
