package services;

import model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, UserModel> users = new HashMap<>();
    private Long nextId = 1L;

    public List<UserModel> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public UserModel getUserById(Long id) {
        return users.get(id);
    }

    public UserModel createUser(UserModel user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }

    public UserModel updateUser(Long id, UserModel updatedUser) {
        UserModel user = users.get(id);
        if (user != null) {
            updatedUser.setId(id);
            users.put(id, updatedUser);
            return updatedUser;
        }
        return null;
    }

    public void deleteUser(Long id) {
        users.remove(id);
    }
}
