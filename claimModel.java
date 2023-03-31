@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy policy;

    // Constructors, getters, and setters
}