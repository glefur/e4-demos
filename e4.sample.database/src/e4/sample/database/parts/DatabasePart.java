/**
 * 
 */
package e4.sample.database.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Root;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class DatabasePart {

	private TreeViewer viewer;
	private AdapterFactory adapterFactory;
	
	@Inject
	private ESelectionService selectionService;


	@PostConstruct
	public void createControls(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label tablesLabel = new Label(container, SWT.NONE);
		tablesLabel.setText("Tables:");
		viewer = new TreeViewer(container);
		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()) {

			@Override
			public Object[] getElements(Object object) {
				if (object instanceof Root || object instanceof Block) {
					List<Entity> result = new ArrayList<Entity>();
					TreeIterator<EObject> eAllContents = ((EObject)object).eAllContents();
					while (eAllContents.hasNext()) {
						EObject next = eAllContents.next();
						if (next instanceof Entity) {
							result.add((Entity) next);
						}
					}
					return result.toArray();
				}
				return super.getElements(object);
			}

			@Override
			public boolean hasChildren(Object object) {
				return false;
			}
			
		});
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selectionService.setSelection(event.getSelection());
			}
		});
		
		
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createPlatformPluginURI("e4.sample.database/resources/base.entity", true), true);
		EObject eObject = resource.getContents().get(0);
		viewer.setInput(eObject);
		
	}
	
	private AdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return adapterFactory;
	}
	
	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
