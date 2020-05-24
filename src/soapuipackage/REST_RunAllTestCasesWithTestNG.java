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

public class REST_RunAllTestCasesWithTestNG {

	@Test
	public void runAllTests() throws XmlException, IOException, SoapUIException {

		WsdlProject project = new WsdlProject(
				"C://Users//emrba//OneDrive//Belgeler/Framework_REST_Project.xml");

		WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {

			WsdlTestCase testCase = testSuite.getTestCaseAt(i);

			TestRunner runner = testCase.run(new PropertiesMap(), false);
			System.out.println("TestCase " + (i + 1) + "  " + runner.getStatus());
			Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
			// Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}
	}
}
