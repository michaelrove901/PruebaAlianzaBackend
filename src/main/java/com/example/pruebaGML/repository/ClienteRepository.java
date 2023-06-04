package com.example.pruebaGML.repository;

import com.example.pruebaGML.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Optional<Cliente> findByKeyClient(String keyClient);
    @Query("SELECT c FROM Cliente c WHERE (:name IS NULL OR c.name LIKE %:name%) AND (:email IS NULL OR c.email LIKE %:email%) AND (:phone IS NULL OR c.phone LIKE %:phone%)AND (:keyClient IS NULL OR c.keyClient LIKE %:keyClient%)")
    List<Cliente> advancedSearchClientes(@Param("name") String name, @Param("email") String email, @Param("phone") String phone,@Param("keyClient") String keyClient);
}