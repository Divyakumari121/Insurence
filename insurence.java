@Entity
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String policyNumber;
	private String type;
	private Double coverageAmount;
	private Double premium;
	private LocalDate startDate;
	private LocalDate endDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	// getters and setters
}