package com.sda.javapoz11.hellospring.hellospring.Service;

import com.sda.javapoz11.hellospring.hellospring.Entity.User;
import com.sda.javapoz11.hellospring.hellospring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService {
   @Autowired
    private UsersRepository usersRepository;

   public UserService (UsersRepository usersRepository){
       this.usersRepository=usersRepository;
   }


    public User findById(long id){
        return usersRepository.findById(id)
                .orElse(null);
    }
    public List<User> findAll(){
        List<User>users=new ArrayList<>();
         usersRepository.findAll()
                 .forEach(x->users.add(x));
                return users;
    }
@PostConstruct
private void init (){
        usersRepository.save(User.builder().firstName("Jan").lastName("Nowak").age(24).build());
        usersRepository.save(User.builder().firstName("xas").lastName("fasas").age(14).build());
        usersRepository.save(User.builder().firstName("fswqfe").lastName("vsafas").age(12).build());
        usersRepository.save(User.builder().firstName("Adam").lastName("Nowak").age(32).build());

}


public List<User> findByLastName(String lastName){
        return usersRepository.findByLastName(lastName);
}



}
