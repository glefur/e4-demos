package sample.acceleo;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import sample.acceleo.e4sampleblock.IE4sampleblockDao;


/**
 * Factory in charge of creating the appropriate instances of DAO objects by
 * using the properties in the dao.properties resource bundle.
 */
public class AcceleoDaoFactory {

    /**
     * Constant that represents the name of the bundle with the DAO mappings.
     */	
	private final static String FILE_DAO_MAPPING = "dao";
	
    /**
     * ResourceBundle that contains the mappings between interfaces and their
     * implementations.
     */
	private static ResourceBundle bundle = ResourceBundle.getBundle(FILE_DAO_MAPPING);

    /**
     * Protected constructor to prevent instantiation. See
     * <a href="http://checkstyle.sourceforge.net/config_design.html">this
     * CheckStyle site's page</a> for details (section DesignForExtension).
     */
    protected AcceleoDaoFactory() {
        // prevents subclass calls
        throw new UnsupportedOperationException();
    }


    /**
     * Factory method which provides the appropriate implementation for the
     * IE4sampleblockDao DAO interface.
     * @return Returns an instance of a class that implements
     * IE4sampleblockDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static sample.acceleo.e4sampleblock.IE4sampleblockDao getE4sampleblockE4sampleblockDao() throws DaoException {

		try {
			String className = bundle.getString(sample.acceleo.e4sampleblock.IE4sampleblockDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends sample.acceleo.e4sampleblock.IE4sampleblockDao> daoClass = 
				Class.forName(className).asSubclass(sample.acceleo.e4sampleblock.IE4sampleblockDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ sample.acceleo.e4sampleblock.IE4sampleblockDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ sample.acceleo.e4sampleblock.IE4sampleblockDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
