package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, UUID> {

    List<ProductEntity> findProductEntitiesByIdIn(@NonNull final List<UUID> ids);
}
