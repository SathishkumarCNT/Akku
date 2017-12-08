package com.app.akku.work.common;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static String DEV_KEY  = "8018851a7430a5d16b0fc147780c94c9";
	public static String TESTLINK_URL = "http://localhost/testlink-1.9.16/lib/api/xmlrpc/v1/xmlrpc.php";
	

	public static void reportResult(String TestProject, String TestPlan, String Testcase, String Build, String Notes, String Result) throws TestLinkAPIException {

             TestLinkAPIClient api = new TestLinkAPIClient(DEV_KEY , TESTLINK_URL);

		     api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);

	}
}
