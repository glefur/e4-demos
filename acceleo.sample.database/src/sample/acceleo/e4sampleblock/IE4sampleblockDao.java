package sample.acceleo.e4sampleblock;

// Start of user code for import
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import sample.acceleo.e4sampleblock.User;
import sample.acceleo.e4sampleblock.Message;

// End of user code

/**
 * This class provides the data access layer to the e4.sample.block entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IE4sampleblockDao {

	/**
	 * Create a new element.
	 * @param user Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createUser(User user) throws DaoException;

	/**
	 * Update an existing element.
	 * @param user Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateUser(User user) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param user Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteUser(User user) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<User> findAllUsers() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public User findUserById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param message Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createMessage(Message message) throws DaoException;

	/**
	 * Update an existing element.
	 * @param message Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateMessage(Message message) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param message Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteMessage(Message message) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Message> findAllMessages() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Message findMessageById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
