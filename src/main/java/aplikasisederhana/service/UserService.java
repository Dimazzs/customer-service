package aplikasisederhana.service;
import aplikasisederhana.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metode-metode logika bisnis atau tambahan dapat ditambahkan di sini.
}
