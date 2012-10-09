/**
 * 
 */
package e4.sample.database.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class ConnectHandler {

	@Execute
	public void execute(ESelectionService service) {
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createPlatformPluginURI("e4.sample.database/resources/base.entity", true), true);
		EObject eObject = resource.getContents().get(0);
		service.setSelection(eObject);
	}
	
}
