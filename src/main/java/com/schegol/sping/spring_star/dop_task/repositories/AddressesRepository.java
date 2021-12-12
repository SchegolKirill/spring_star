package com.schegol.sping.spring_star.dop_task.repositories;

import com.schegol.sping.spring_star.dop_task.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends CrudRepository<Address, Integer> {
}
