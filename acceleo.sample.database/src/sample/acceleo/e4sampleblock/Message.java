package sample.acceleo.e4sampleblock;

// Start of user code for imports
import java.io.Serializable;
import java.util.Date;

// End of user code for imports

/**
 * 
 */
public class Message implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field date.
     */
	public static final String PROP_DATE = "date";
	
	/**
     * Constant representing the name of the field message.
     */
	public static final String PROP_MESSAGE = "message";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field date.
     */
	protected Date date;

    /**
     * Field message.
     */
	protected String message;

	/**
	 * Default constructor.
	 */
	public Message() {
		super();
	}
	
	/**
	 * Return the identifier.
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Set a value to parameter id.
	 * @param id Value of the identifier.
	 */
	public void setId(final String id) {
		this.id = id;
	}	

	/**
	 * Constructor with all parameters initialized.
	 * @param date. 
	 * @param message. 
	 */
	public Message(Date date, String message) {
		this.date = date;
		this.message = message;
	}

	/**
	 * Return date.
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set a value to parameter date.
	 * @param date
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * Return message.
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set a value to parameter message.
	 * @param message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * Message and the given object has the same PK as this
     * if the PK is not null or their ids are equal.
	 */
	public boolean equals(final Object other) {
	 	// Start of user code for equals
		if (this == other) {
			return true;
		}
		if (id==null) {
			return false;
		}
		if (!(other instanceof Message)) {
			return false;
		}
		
		final Message castedOther = (Message) other;
		if (id != null && castedOther.getId() != null) {
			return id.equals(castedOther.getId());
		}
		return true;
		
		 // End of user code for equals
	}

	/** 
	 * HashTable code based on identifier hash codes.
	 * @return hash value.
	 */
	public int hashCode() {
		return id==null ? System.identityHashCode(this) : id.hashCode();
	}
   
	// Start of user code for private methods
	// TODO Remove this line and add your private methods here
	// End of user code for private methods
   
}
