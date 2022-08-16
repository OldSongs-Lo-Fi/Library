package ua.library.pak.Library.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.library.pak.Library.models.User;
import ua.library.pak.Library.represitory.BookRepr;
import ua.library.pak.Library.represitory.UserRepr;

import java.util.ArrayList;

@Controller
public class MainController {


    private User curreentUser;
    final
    BookRepr bookRepr;
    final
    UserRepr allUser;

    public MainController(BookRepr bookRepr, UserRepr user) {
        this.bookRepr = bookRepr;
        this.allUser = user;
    }


    @GetMapping
    public String MainPage(Model model){
        System.out.println("Hueta");
        //Check Of Autorization
        if(curreentUser == null){
            return "redirect:/loginScreen";
        }
        model.addAttribute("user", curreentUser);
        return "mainPage";
    }




    //LoginScreen
    @GetMapping("/loginScreen")
    public String loginScreen(Model model){
        return "loginScreen";
    }


    @PostMapping("/loginScreen")
    public String loginScreenSingIn(Model model,
                                    @RequestParam("login") String login,
                                    @RequestParam("password") String password){
        curreentUser = null;
        Iterable<User> users = allUser.findAll();
        System.out.println("Lol" + login + password);
        users.forEach(user -> {
            System.out.println(user.getLogin());
            System.out.println(user.getPassword());
            if(password.equals(user.getPassword()) && login.equals(user.getLogin())){
                curreentUser = user;
                System.out.println(user);

                System.out.println("Success!");
            }else{

                System.out.println("Wrong...");
            }
        });
        if(curreentUser == null){
            return "/loginScreen";
        }
        return "redirect:/";
    }




    //Registration
    @GetMapping("/registrationScreen")
    public String registration(){
        return "/registrationScreen";
    }


    private boolean canBeUsed;
    @PostMapping("/registrationScreen")
    public String registrationPost(Model model,
                                   @RequestParam("login") String login,
                                   @RequestParam("password") String password){
        Iterable<User> users = allUser.findAll();
        User newUser;
        canBeUsed =true;
        users.forEach(user -> {
            System.out.println(user.getLogin());
            if(login.equals(user.getLogin())){
                System.out.println("This e-mail is already in use!");
                canBeUsed = false;
            }
        });
        if(canBeUsed){
            allUser.save(new User(login,password));
            return "redirect:/loginScreen";
        }
        else {
            return "redirect:/registrationScreen";
        }

    }

}
