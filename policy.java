@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {
    
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;
    
    // Fetch all insurance policies
    @GetMapping
    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }
    
    // Fetch a specific insurance policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id) {
        Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(id);
        if (policyOptional.isPresent()) {
            return ResponseEntity.ok(policyOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Create a new insurance policy
    @PostMapping
    public ResponseEntity<InsurancePolicy> createInsurancePolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy savedPolicy = insurancePolicyRepository.save(policy);
        return ResponseEntity.created(URI.create("/api/policies/" + savedPolicy.getId())).body(savedPolicy);
    }
    
    // Update an insurance policy
    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
        Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(id);
        if (policyOptional.isPresent()) {
            policy.setId(id);
            InsurancePolicy savedPolicy = insurancePolicyRepository.save(policy);
            return ResponseEntity.ok(savedPolicy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Delete an insurance policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePolicy(@PathVariable Long id) {
        Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById