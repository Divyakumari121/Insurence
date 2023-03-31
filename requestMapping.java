@RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private ClientRepository clientRepository;
    
    // Fetch all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    // Fetch a specific client by ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            return ResponseEntity.ok(clientOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Create a new client
@PostMapping
public void ResponseEntity<Client> createClient(@RequestBody Client client) {
    Client savedClient = clientRepository.save(client);
    return ResponseEntity.created(URI.create("/api/clients/" + savedClient.getId())).body(savedClient);
}
 // Update a client's information
 @PutMapping("/{id}")
 public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
     Optional<Client> clientOptional = clientRepository.findById(id);
     if (clientOptional.isPresent()) {
         client.setId(id);
         Client savedClient = clientRepository.save(client);
         return ResponseEntity.ok(savedClient);
     } else {
         return ResponseEntity.notFound().build();
     }
 }
  // Delete a client
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
      Optional<Client> clientOptional = clientRepository.findById(id);
      if (clientOptional.isPresent()) {
          clientRepository.delete(clientOptional.get());
          return ResponseEntity.noContent().build();
      } else {
          return ResponseEntity.notFound().build();
      }
  }
}
 

    