package drugExpertSystem.User.Services;

import drugExpertSystem.User.Token;
import drugExpertSystem.User.User;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */

public interface UserService<T extends Object> {
    public T createUser(User user);
    public User updateUserPass(User user);
    public T updateUserType(User user);
    public T deleteUser(User user);
    public List<T> getAllUsers();
    public T getUserById(String id);
    public Token autherization(String userName,String password);
}
