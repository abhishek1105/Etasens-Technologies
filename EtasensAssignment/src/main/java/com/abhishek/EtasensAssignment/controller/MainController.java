package com.abhishek.EtasensAssignment.controller;

import com.abhishek.EtasensAssignment.entity.User;
import com.abhishek.EtasensAssignment.repos.UserRepo;
import com.abhishek.EtasensAssignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/showFormForAdd")
    private String showFormForAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping()
    public String getUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("usersList", userList);
        return "homepage";
    }

    @GetMapping("/showFormForUpdate/{firstName}")
    public String getDetailsByFirstName(@PathVariable String firstName, Model model) {
        User user = userService.findByFirstName(firstName);
        model.addAttribute("updatedUser", user);
        //if user's status is true only then update will occur
        if (user.isEnabled()) return "user-details";
            //otherwise it will redirect to the same page
        else return "redirect:/users";
    }

    //    @GetMapping("/option/{id}/{type}")
//    public String disableEnable(@PathVariable Integer id, @PathVariable boolean type, Model model) {
//        System.out.println(type);
//        Optional<User> user = userRepo.findById(id);
//        if (user.isPresent() && type==true) {
//            User user1 = user.get();
//            System.out.println(user1);
//            user1.setEnabled(false);
//            userRepo.save(user1);
//        }
//        else{
//            User user1 = user.get();
//            System.out.println(user1);
//            user1.setEnabled(true);
//            userRepo.save(user1);
//        }
//        return "redirect:/users";
//
//    }
    @GetMapping("/option/{id}/{type}")
    public String disableEnable(@PathVariable Integer id, @PathVariable boolean type, Model model) {
        Optional<User> userOptional = userRepo.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEnabled(!type);
            userRepo.save(user);
        } else {
            System.out.println("User with ID " + id + " not found.");
        }

        return "redirect:/users";
    }

}
