import org.springframework.data.jpa.repository.JpaRepository;
import com.yourcompany.yourapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
