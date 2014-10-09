package drugExpertSystem.User.Services;

import drugExpertSystem.User.Repository.UserRepository;
import drugExpertSystem.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public User createUser(User user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {

        try{
            User userfromDb = this.getUserById(user.getId());
            userfromDb.setPassword(user.getPassword());
            userfromDb.setName(user.getName());
            userfromDb.setAddress(user.getAddress());
            userfromDb.setTelno(user.getTelno());
            userRepository.save(userfromDb);

        }catch (Exception e){
            return null;
        }
        return user;
    }

    @Override
    @Transactional
    public User updateUserType(User user) {
        try{
            User userFromDb = this.getUserById(user.getId());
            userFromDb.setType(user.getType());
            userRepository.save(userFromDb);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    @Override
    @Transactional
    public User deleteUser(User user) {
        try{
            userRepository.delete(user);
        }catch (Exception e){
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findOne(id);
    }
}
