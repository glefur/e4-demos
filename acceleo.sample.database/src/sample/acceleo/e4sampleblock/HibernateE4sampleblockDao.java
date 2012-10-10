package sample.acceleo.e4sampleblock;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import sample.acceleo.e4sampleblock.User;
import sample.acceleo.e4sampleblock.Message;
import sample.acceleo.e4sampleblock.IE4sampleblockDao;

// End of user code

/**
 * Implementation of DAO interface IE4sampleblockDao based on the hibernate
 * persistence framework.
 * @see sample.acceleo.e4sampleblock.IE4sampleblockDao
 */
public class HibernateE4sampleblockDao implements IE4sampleblockDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateE4sampleblockDao.class);

	/**
	 * Create a new element
	 * @param user Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IUserDao.createUser
     */
	public void createUser(User user) throws DaoException {
		LOG.debug("Create a new User entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(user);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param user
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IUserDao.updateUser
     */
	public void updateUser(User user) throws DaoException {
		LOG.debug("Update the entity User with id =" + user.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(user);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param user Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IUserDao.deleteUser
   	 */
	public void deleteUser(User user) throws DaoException {
		LOG.debug("Delete the entity User with id =" + user.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(user);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IUserDao.findAllUsers
     */
	public Collection<User> findAllUsers() throws DaoException {
		LOG.debug("Find all instance of User entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(User.class);
			Collection<User> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of User entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IUserDao.findUserById
     */
	public User findUserById(String id) throws DaoException {
		LOG.debug("Find one instance of User entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("id", id));
			User result = (User)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param message Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IMessageDao.createMessage
     */
	public void createMessage(Message message) throws DaoException {
		LOG.debug("Create a new Message entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(message);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param message
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IMessageDao.updateMessage
     */
	public void updateMessage(Message message) throws DaoException {
		LOG.debug("Update the entity Message with id =" + message.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(message);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param message Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IMessageDao.deleteMessage
   	 */
	public void deleteMessage(Message message) throws DaoException {
		LOG.debug("Delete the entity Message with id =" + message.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(message);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IMessageDao.findAllMessages
     */
	public Collection<Message> findAllMessages() throws DaoException {
		LOG.debug("Find all instance of Message entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Message.class);
			Collection<Message> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Message entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see sample.acceleo.e4sampleblock.IMessageDao.findMessageById
     */
	public Message findMessageById(String id) throws DaoException {
		LOG.debug("Find one instance of Message entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Message.class)
				.add(Restrictions.eq("id", id));
			Message result = (Message)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

