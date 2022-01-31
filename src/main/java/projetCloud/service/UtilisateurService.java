package projetCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projetCloud.model.Utilisateur;
import projetCloud.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    
    public UtilisateurService() {

    }

    public void createAdmin(Utilisateur user) throws Exception{
        String[] listeAccent = {"é","è","à","ù","â","Ä"};
        Boolean containsAccent = false;
        String regexEmail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if(!user.getEmail().matches(regexEmail))throw new Exception("format email incorrect");
        if(user.getMdp().length()<8)throw new Exception("nombre de caractère doit etre superieur à 8");
        for (String lettre : listeAccent) {
            user.getMdp().contains(lettre);
        }
        if(!containsAccent)throw new Exception("format mot de passe incorrect");
        else utilisateurRepository.save(user);
    }

}
