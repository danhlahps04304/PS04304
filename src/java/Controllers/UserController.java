/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Controllers;

import Bean.User;
import Model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author L.A.H.D
 */
@Controller
@RequestMapping("/account")
public class UserController {
    @RequestMapping("showall")
    public String showAll(ModelMap model){
        UserModel user = new UserModel();
        List<User> list = new ArrayList<User>();
        list = user.showUser("");
        model.addAttribute("listUser", list);
        User tk = new User();
        model.addAttribute("user", tk);
        return "account";
    }
    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("user") User user, ModelMap model){
        UserModel.insert(user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "account";
    }
    
     @RequestMapping(params="btnUpdate")
     public String update(@ModelAttribute("user") User user, ModelMap model){
         UserModel.update(user);
         List<User> list = new ArrayList<User>();
         list = UserModel.showUser("");
         model.addAttribute("listUser", list);
         return "account";
     }
     
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model){
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fn = request.getParameter("txtFN");
        User user = new User (username, password, fn);
        model.addAttribute("user", user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "account";
    }    
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("user") User user){
        String Username = request.getParameter("txtUsername");
        UserModel.delete(Username);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "account";
    }
    
    
}
