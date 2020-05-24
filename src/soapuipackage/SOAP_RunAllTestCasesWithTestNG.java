package soapuipackage;

import java.io.IOException;
import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class SOAP_RunAllTestCasesWithTestNG {

	@Test	
	public void runTestSuite() throws XmlException, IOException, SoapUIException  {

		WsdlProject project = new WsdlProject(
				"C://Users//emrba//OneDrive//Belgeler/EmployeeAutomationWithGroovyScript.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {

			WsdlTestCase testCase = testSuite.getTestCaseAt(i);

			TestRunner runner = testCase.run(new PropertiesMap(), false); 
			Assert.assertEquals(Status.FINISHED, runner.getStatus()); 		
		}
	}
}
