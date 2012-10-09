/**
 * 
 */
package e4.sample.database.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class ExitHandler {

	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}
	
	@CanExecute
	public boolean canExecute() {
		return true;
	}
	
}
