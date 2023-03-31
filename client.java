@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private String address;
	private String contactInfo;
	// getters and setters
}