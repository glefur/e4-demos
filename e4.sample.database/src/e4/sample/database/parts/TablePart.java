/**
 * Copyright (C) 2012 Goulwen Le Fur
 * 
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation; either version 3 
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, see <http://www.gnu.org/licenses>.
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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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

	private static final List<User> users = new ArrayList<TablePart.User>();
	static {
		users.add(new User("Dupont", "Michel", 24));
		users.add(new User("Dupond", "Thierry", 25));
		users.add(new User("Egal", "Jocelyne", 32));
		users.add(new User("Tomson", "Emma", 33));
	}
	
	private static final List<Message> messages = new ArrayList<Message>();
	static {
		messages.add(new Message("22/09/2012", "Voici un premier message"));
		messages.add(new Message("01/10/2012", "Voici un second message"));
		messages.add(new Message("12/10/2012", "Pas très vivante cette base"));
	}
	
	private TableViewer viewer;
	private List<TableColumn> columns;
	
	public TablePart() {
		columns = new ArrayList<TableColumn>();
	}

	@PostConstruct
	public void createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		viewer = new TableViewer(container);
		viewer.setLabelProvider(new LabelProvider());
		viewer.setContentProvider(new ArrayContentProvider());
		Table table = (Table) viewer.getControl();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		Composite panel = new Composite(container, SWT.NONE);
		panel.setLayout(new GridLayout(1, false));
		Button add = new Button(panel, SWT.PUSH);
		add.setText("Add");
		add.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button remove = new Button(panel, SWT.PUSH);
		remove.setText("Remove");
		remove.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
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
					Entity entity = (Entity)sel;
					populateColumns(entity);
					populateViewer(entity);
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

	private void populateViewer(Entity entity) {
		if ("User".equals(entity.getName())) {
			viewer.setInput(users);
		} else if ("Message".equals(entity.getName())) {
			viewer.setInput(messages);
		}
	}

	private static class Message {
		String date;
		String message;
		
		public Message(String date, String message) {
			this.date = date;
			this.message = message;
		}
	}
	
	private static class User {
		String lastname;
		String firstname;
		int age;
		public User(String lastname, String firstname, int age) {
			this.lastname = lastname;
			this.firstname = firstname;
			this.age = age;
		}
		
		
	}
	
	private static class LabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) { }

		@Override
		public void dispose() { 	}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) { }

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Message) {
				switch (columnIndex) {
				case 0:
					return ((Message)element).date;
				case 1:
					return ((Message)element).message;
				default:
					return ((Message)element).message;
				}
			} else if (element instanceof User) {
				switch (columnIndex) {
				case 0:
					return ((User)element).lastname;
				case 1:
					return ((User)element).firstname;
				case 2:
					return String.valueOf(((User)element).age);					
				default:
					return ((User)element).lastname;
				}
			}
			return null;
		}
		
	}
	
}