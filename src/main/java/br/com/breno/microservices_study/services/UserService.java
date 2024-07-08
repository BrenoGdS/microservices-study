package br.com.breno.microservices_study.services;

import br.com.breno.microservices_study.models.UserModel;
import br.com.breno.microservices_study.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUser(UUID id){
        return userRepository.findById(id).get();
    }

    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }
}
