package web;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;

/**
 * @author Michal Karm Babacek
 */
@ArquillianSuiteDeployment
public class DemoDeployment {
    @Deployment(name = "war", testable = true, managed = true)
    public static Archive<?> createTestArchive() {
        WebArchive war = ShrinkWrap.create(ZipImporter.class, "trashdemo-web.war").importFrom(new File("../web/target/trashdemo-web.war")).as(WebArchive.class);
        war.getAsType(JavaArchive.class, "WEB-INF/lib/trashdemo-lib.jar")
                .addClass(BaseTest.class)
                .addClass(FailingHttpStatusCodeException.class);
        return war;
    }
}
