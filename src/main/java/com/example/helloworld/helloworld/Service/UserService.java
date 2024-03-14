package com.example.helloworld.helloworld.Service;
import com.example.helloworld.helloworld.Dao.UserDao;
import com.example.helloworld.helloworld.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    UserDao user;

    public List<Users> getUser(){
        return user.findAll();
    }

    public List<Users> getUserList(){
        return user.findAll();
    }

    public Optional<Users> getUserById(int id){
        return user.findById(id);
    }


    public ResponseEntity<String> addUser(@RequestBody Users user1){
        try {
            user.save(user1);
            System.out.println("here"+user1);
            return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateUser(Users updatedUser) {
        try {

            if (!user.existsById(updatedUser.getUser_id())) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            user.save(updatedUser);

            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteUser(int userId) {
        try {
            // Check if the expense with the given ID exists
            if (!user.existsById(userId)) {
                return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
            }
            user.deleteById(userId);

            return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

