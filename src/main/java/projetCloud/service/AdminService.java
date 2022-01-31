package projetCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetCloud.model.Admin;
import projetCloud.repository.AdminRepository;

@Service
public class AdminService {

  @Autowired
  private AdminRepository adminRepository;

  public AdminService() {

  }

  public void createAdmin(Admin admin){
    adminRepository.save(admin);
  }

}
