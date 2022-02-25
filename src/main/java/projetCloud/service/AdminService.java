package projetCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projetCloud.model.Admin;
import projetCloud.repository.AdminRepository;

@Service
public class AdminService {

  @Autowired
  private AdminRepository adminRepository;

	// @Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

  public AdminService() {

  }

  public void createAdmin(Admin admin){
    admin.setMdp(passwordEncoder().encode(admin.getMdp()));
    adminRepository.save(admin);
  }

}
