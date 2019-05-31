package restaurantCMS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/clients")
public interface ClientRepository extends JpaRepository<Clients,Integer>, ClientRepositoryCustom {

}
