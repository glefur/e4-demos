/**
 * 
 */
package e4.sample.database.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.Entity;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 * 
 */
public class TablePart {

	private TableViewer viewer;
	private List<TableColumn> columns;
	
	public TablePart() {
		columns = new ArrayList<TableColumn>();
	}

	@PostConstruct
	public void createContents(Composite parent) {
		viewer = new TableViewer(parent);
		Table table = (Table) viewer.getControl();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
	  }

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection) {
		clearColumns();
		if (selection != null) {
			if (selection instanceof StructuredSelection) {
				Object sel = ((StructuredSelection) selection).getFirstElement();
				if (sel instanceof Entity) {
					populateColumns((Entity)sel);
				}
			}
		} 
	}

	private void clearColumns() {
		for (TableColumn column : columns) {
			column.dispose();
		}
		columns.clear();
	}

	private void populateColumns(Entity entity) {
		for (Attribute attr : entity.getAttributes()) {
			TableColumn column = new TableColumn((Table) viewer.getControl(), SWT.NONE);
			column.setText(attr.getName());
			column.setWidth(150);
			columns.add(column);
		}
		viewer.refresh();
	}

}