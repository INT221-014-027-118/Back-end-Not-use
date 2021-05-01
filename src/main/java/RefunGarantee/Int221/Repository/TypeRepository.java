package RefunGarantee.Int221.Repository;

import RefunGarantee.Int221.Model.Product;
import RefunGarantee.Int221.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
}
