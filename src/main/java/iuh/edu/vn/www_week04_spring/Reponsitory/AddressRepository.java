package iuh.edu.vn.www_week04_spring.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import iuh.edu.vn.www_week04_spring.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
