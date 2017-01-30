package mii.web.service;

import java.util.List;
import mii.entity.Users;
import mii.web.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("usersService")
public class UsersService {
    private UsersDAO usersDAO;
    
    public UsersDAO getUsersDAO(){
        return usersDAO;
    }
    
    @Autowired
    public void setUsersDAO(UsersDAO usersDAO){
        this.usersDAO = usersDAO;
    }
    
    public List<Users> getAll(){
        return this.usersDAO.getAll();
    }
         
    public Users getById(Long id){
        return this.usersDAO.getById(id);
    }
    
    public void insert(Users users){
        getUsersDAO().insert(users);
    } 
    
    public void update(Users users){
        getUsersDAO().update(users);
    }

}
