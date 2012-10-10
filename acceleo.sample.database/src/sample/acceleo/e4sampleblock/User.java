package sample.acceleo.e4sampleblock;

// Start of user code for imports
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;	

// End of user code for imports

/**
 * 
 */
public class User implements Serializable {

	/**
     * serialVersionUID is used for serialization.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constant representing the name of the automatic primary key field.
     */
	public static final String PROP_ID = "id";
	
	/**
     * Constant representing the name of the field lastname.
     */
	public static final String PROP_LASTNAME = "lastname";
	
	/**
     * Constant representing the name of the field age.
     */
	public static final String PROP_AGE = "age";
	
	/**
     * Constant representing the name of the field firstname.
     */
	public static final String PROP_FIRSTNAME = "firstname";
	
	/**
     * Constant representing the name of the field messages.
     */
	public static final String PROP_MESSAGES = "messages";
	
    /**
     * Automatic primary key.
     */
    private String id;
    
    /**
     * Field lastname.
     */
	protected String lastname;

    /**
     * Field age.
     */
	protected Integer age;

    /**
     * Field firstname.
     */
	protected String firstname;

    /**
     * Field messages.
     */
	protected Collection<Message> messages;

	/**
	 * Default constructor.
	 */
	public User() {
		super();
		this.messages = new HashSet<Message>();
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
	 * @param lastname. 
	 * @param age. 
	 * @param firstname. 
	 * @param messages. 
	 */
	public User(String lastname, Integer age, String firstname, Collection<Message> messages) {
		this();
		this.lastname = lastname;
		this.age = age;
		this.firstname = firstname;
		this.messages.addAll(messages);
	}

	/**
	 * Return lastname.
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Set a value to parameter lastname.
	 * @param lastname
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Return firstname.
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set a value to parameter firstname.
	 * @param firstname
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Return age.
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Set a value to parameter age.
	 * @param age
	 */
	public void setAge(final Integer age) {
		this.age = age;
	}

	/**
	 * Return messages.
	 * @return messages
	 */
	public Collection<Message> getMessages() {
		return messages;
	}

	/**
	 * Set a value to parameter messages.
	 * @param messages
	 */
	public void setMessages(final Collection<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * Add a messages to the messages collection.
	 * @param messagesElt Element to add.
	 */
	 public void addMessages(final Message messagesElt) {
	 	this.messages.add(messagesElt);
	 }
	 
	/**
	 * Remove a messages to the messages collection.
	 * @param messagesElt Element to remove.
	 */
	 public void removeMessages(final Message messagesElt) {
	 	this.messages.remove(messagesElt);
	 }

	/** 
	 * Equality test based on identifiers.
	 * @param value Value to compare.
	 * @return Returns true if and only if given object is an instance of
     * User and the given object has the same PK as this
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
		if (!(other instanceof User)) {
			return false;
		}
		
		final User castedOther = (User) other;
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
