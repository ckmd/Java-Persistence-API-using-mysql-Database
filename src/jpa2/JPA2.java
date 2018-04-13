/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;
import jpa2.dao.DaoUser;
import jpa2.model.User;
import java.util.List;
/**
 *
 * @author Rachmad
 */
public class JPA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaoUser daoUser = new DaoUser();
        
        User user = new User();
        user.setName("rachmad");
        daoUser.save(user);
        
        List<User> result = daoUser.findAll();
        for(int i = 0; i < result.size(); i++){
            User printUser = result.get(i);
            System.out.println(printUser.getId()+" - "+printUser.getName());
        }
    }
    
}
