package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartEntityRepository extends JpaRepository<CartEntity, UUID> {
}
