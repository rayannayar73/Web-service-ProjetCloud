package projetCloud.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projetCloud.model.Admin;
import projetCloud.repository.AdminRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(email);
		Collection<SimpleGrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		// auth.add(new SimpleGrantedAuthority("ADMIN"));
		// auth.add(new SimpleGrantedAuthority("USER"));
		if (admin != null) {
			return new User(admin.getEmail(), admin.getMdp(),auth
				);
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
}