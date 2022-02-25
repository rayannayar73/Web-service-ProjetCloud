package projetCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetCloud.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

    Admin findByEmail(String Email);
}
