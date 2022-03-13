package com.project.app.user.Controller;

import java.util.List;

import com.project.app.user.Entity.Product;
import com.project.app.user.Entity.Message;
import com.project.app.user.Entity.RoleType;
import com.project.app.user.Entity.User;
import com.project.app.user.Entity.UserInfo;
import com.project.app.user.Entity.UserName;
import com.project.app.user.Exception.ErrorDetails;
import com.project.app.user.Exception.ResourceNotFoundException;
import com.project.app.user.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService service;


    // Create a new user.

    @PostMapping("/create")
    public ResponseEntity<Message> createUser(@RequestBody User user)
    {
        return new ResponseEntity<Message>(service.saveUser(user), HttpStatus.CREATED);
    }


    // Display all users.

    @GetMapping("/display")
    public ResponseEntity<List<User>> showAllUsers()
    {
        return new ResponseEntity<List<User>>(service.showAll(), HttpStatus.OK);
    }

    
    // Display UserName by user id.
    
    @GetMapping("/name/{id}")
    public ResponseEntity<UserName> getUserNameByUserId(@PathVariable("id") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<UserName>(service.getUserNameByUserId(id), HttpStatus.OK);
    }

   
    // Display RoleType by user id.

    @GetMapping("/role/{id}")
    public ResponseEntity<RoleType> getRoleByUserId(@PathVariable("id") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<RoleType>(service.getRoleByUserId(id), HttpStatus.OK);
    }


    // Display UserInfo by user id.
    
    @GetMapping("/info/{id}")
    public ResponseEntity<UserInfo> getUserInfobyUserId(@PathVariable("id") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<UserInfo>(service.getUserInfobyUserId(id),HttpStatus.OK);
    }


    // Disply all products of an user by user id.

    @GetMapping("/products/{uid}")
    public ResponseEntity<List<Product>> getUserAllProductsByUserId(@PathVariable("uid") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<List<Product>>(service.getAllProductsByUserId(id),HttpStatus.OK);
    }


    // Add product by user id.

    @PutMapping("/add/product/{id}")
    public ResponseEntity<Message> addProductbyUserId(@PathVariable("id") long id, @RequestBody Product product) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<Message>(service.addProductbyUserId(id, product), HttpStatus.CREATED);
    }


    // Edit product by product id.

    @PutMapping("/edit/product/{pid}")
    public ResponseEntity<Message> editProductByProductId(@PathVariable("pid") long pid, @RequestBody Product product) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<Message>(service.editProductByProductId(pid, product),HttpStatus.OK);
    }


    // Delete product from user by product id.
    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<Message> deleteProductbyProductId(@PathVariable("id") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<Message>(service.deleteProductbyProductId(id) ,HttpStatus.OK);
    }


    // Delete user by user id.

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<Message> deleteUserbyUserId(@PathVariable("id") long id) throws ResourceNotFoundException, Exception
    {
        return new ResponseEntity<Message>(service.deleteUserbyUserId(id),HttpStatus.OK);
    }


    // Show all errors occoured.
    @GetMapping("/errors")
    public ResponseEntity<List<ErrorDetails>> getAllErrorsOccoured()
    {
        return new ResponseEntity<>(service.getAllErrorsOccoured(),HttpStatus.OK);
    }


    // Show all products. (Using SQL Query)
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllUserProducts()
    {
        return new ResponseEntity<List<Product>>(service.getAllUserProducts(), HttpStatus.OK);
    }


    // Show all users with the provided first name pattern. (Using SQL Query)
    @GetMapping("/fname/{pattern}")
    public ResponseEntity<List<User>> getAllUsersWithFirstNamePattern(@PathVariable("pattern") String pattern)
    {
        return new ResponseEntity<List<User>>(service.getAllUsersWithFirstNamePattern(pattern), HttpStatus.OK);
    }


    // Show all users with the provided first name pattern. (Using SQL Query)
    @GetMapping("name/{f}/{l}")
    public ResponseEntity<List<User>> getAllUsersWithNamePattern(@PathVariable("f") String f, @PathVariable("l") String l)
    {
        return new ResponseEntity<List<User>>(service.getAllUsersWithNamePattern(f, l), HttpStatus.OK);
    }

}
