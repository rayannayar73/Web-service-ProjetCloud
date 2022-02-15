package projetCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projetCloud.model.Admin;
import projetCloud.model.Utilisateur;
import projetCloud.repository.AdminRepository;
import projetCloud.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AdminRepository adminRepository;
    
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    public UtilisateurService() {

    }

    public Admin createAdmin(Admin user) throws Exception{
        String[] listeAccent = {"é","è","à","ù","â","Ä"};
        Boolean containsAccent = false;
        String regexEmail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if(!user.getEmail().matches(regexEmail))throw new Exception("format email incorrect");
        if(user.getMdp().length()<8)throw new Exception("nombre de caractère doit etre superieur à 8");
        for (String lettre : listeAccent) {
            if(user.getMdp().contains(lettre))containsAccent = true;
        }
        if(containsAccent)throw new Exception("format mot de passe incorrect");
        else {
            user.setMdp(passwordEncoder().encode(user.getMdp()));
            adminRepository.save(user);return user;
        }
    }

}
