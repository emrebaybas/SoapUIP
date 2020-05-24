package soapuipackage;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

import junit.framework.Assert;

public class SOAP_RunAllTestCases {

	public static void main(String[] args) throws XmlException, IOException, SoapUIException {

		WsdlProject project = new WsdlProject(
				"C://Users//emrba//OneDrive//Belgeler/EmployeeAutomationWithGroovyScript.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {

			WsdlTestCase testCase = testSuite.getTestCaseAt(i);

			// Run the Test case
			// Since we don't get the data/properties from anywhere else, we just pass false
			// properties comes from soapUI as designed
			TestRunner runner = testCase.run(new PropertiesMap(), false); 
			// Assert.assertEquals(Status.FINISHED, runner.getStatus()); // to make sure
			// test is passed
		}

	}

}
