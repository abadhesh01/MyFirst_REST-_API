package com.project.app.user.Service;

import java.util.List;

import com.project.app.user.Entity.Product;
import com.project.app.user.Entity.Message;
import com.project.app.user.Entity.RoleType;
import com.project.app.user.Entity.User;
import com.project.app.user.Entity.UserInfo;
import com.project.app.user.Entity.UserName;
import com.project.app.user.Exception.ErrorDetails;
import com.project.app.user.Exception.ResourceNotFoundException;
import com.project.app.user.Repository.ErrorRepository;
import com.project.app.user.Repository.ProductRepository;
import com.project.app.user.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ErrorRepository errorRepository;

    
    public Message saveUser(User user)
    {
       userRepository.save(user);
       return new Message("User created successfully!");
    }

    public List<User> showAll()
    {
        return userRepository.findAll();
    }
    
    public UserName getUserNameByUserId(long id) throws ResourceNotFoundException, Exception
    {
        //User user = userRepository.getById(id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User",id));
        return new UserName(user.getFname(),user.getLname());
    } 

    public RoleType getRoleByUserId(long id) throws ResourceNotFoundException, Exception
    {
        //User user = userRepository.getById(id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
        return new RoleType(user.getRole().getRole());
    }

    public UserInfo getUserInfobyUserId(long id) throws ResourceNotFoundException, Exception
    {
        //User user = userRepository.getById(id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
        UserInfo userInfo = new UserInfo(
                            user.getFname(), 
                            user.getLname(), 
                            user.getRole().getRole(), 
                            user.getPersonalInfo().getEmail(),
                            user.getPersonalInfo().getState(), 
                            user.getPersonalInfo().getCountry(),
                            user.getProducts());
        return userInfo;
    }

    public List<Product> getAllProductsByUserId(long id) throws ResourceNotFoundException, Exception
    {
        //return userRepository.getById(id).getProducts();
         User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
         return user.getProducts();
    }

    public Message addProductbyUserId(long id, Product product) throws ResourceNotFoundException, Exception
    {   
        //User user = userRepository.getById(id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
        List<Product> products = user.getProducts();
        products.add(product);
        user.setProducts(products);
        userRepository.save(user);
        return new Message("Product added to uid="+id+" successfully!");
    }

    public Message editProductByProductId(long pid, Product product) throws ResourceNotFoundException, Exception
    {
        //Product existProduct = productRepository.getById(pid);
        Product existProduct = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product", pid));
        existProduct.setPname(product.getPname());
        existProduct.setPtype(product.getPtype());
        productRepository.save(existProduct);
        return new Message("Product with pid="+pid+" edited successfully! :)");
    }

    public Message deleteProductbyProductId(long pid) throws ResourceNotFoundException, Exception
    {
            productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product", pid));
            productRepository.deleteById(pid);
            return new Message("Product with pid="+pid+" was deleted successfully!"); 
    }

    public Message deleteUserbyUserId(long id) throws ResourceNotFoundException, Exception
    {
            userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
            userRepository.deleteById(id);
            return new Message("User with uid="+id+" was deleted successfully!"); 
    }

    public List<ErrorDetails> getAllErrorsOccoured()
    {
         return errorRepository.findAll();
    }

    public List<Product> getAllUserProducts()
    {
        return productRepository.getAllUserProducts();
    }

    public List<User> getAllUsersWithFirstNamePattern(String pattern)
    {
        return userRepository.getAllUsersWithFirstNamePattern(pattern);
    }

    public List<User> getAllUsersWithNamePattern(String f, String l)
    {
        return userRepository.getAllUsersWithNamePattern(f, l);
    }

}
