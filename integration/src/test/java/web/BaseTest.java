package web;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.annotations.Test;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

/**
 * @author Michal Karm Babacek
 */
public class BaseTest extends Arquillian {

    private static final Logger log = Logger.getLogger(BaseTest.class.getName());

    @Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER, priority = 1)
    @OperateOnDeployment("war")
    @RunAsClient
    public void testNUmberServlet(@ArquillianResource URL context) throws Exception {
        final WebClient webClient = new WebClient();
        final WebRequest requestSettings = new WebRequest(new URL(context + "number"), HttpMethod.GET);
        Page page = webClient.getPage(requestSettings);
        assertEquals(page.getWebResponse().getStatusCode(), HttpURLConnection.HTTP_OK, "MUST be OK.");
        assertEquals(Integer.parseInt(page.getWebResponse().getContentAsString()), 0, "MUST be 0");
        page = webClient.getPage(requestSettings);
        assertEquals(Integer.parseInt(page.getWebResponse().getContentAsString()), 1, "MUST be 1");
    }

    @Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER, priority = 2)
    public void checkSessionStore() throws Exception {
        final ObjectName on = new ObjectName("Catalina:type=Manager,context=/trashdemo-web,host=localhost");
        assertEquals(ManagementFactory.getPlatformMBeanServer().getAttribute(on, "sessionCounter"), 1L);
    }
}
