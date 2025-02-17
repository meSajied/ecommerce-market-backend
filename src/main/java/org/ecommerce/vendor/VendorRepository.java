package org.ecommerce.vendor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
   
}
