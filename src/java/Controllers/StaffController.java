/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Controllers;

import Bean.Staff;
import Model.StaffModel;
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
@RequestMapping("/staff")
public class StaffController {
    @RequestMapping("showall")
    public String showall(ModelMap model){
        StaffModel user = new StaffModel();
        List<Staff> list = new ArrayList<Staff>();
        list = user.showStaff("");
        model.addAttribute("listStaff", list);
        Staff staffs = new Staff();
        model.addAttribute("staff", staffs);
        return "staff";
    }
    
    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("staff") Staff staff, ModelMap model){
        StaffModel.insert(staff);
        List<Staff> list = new ArrayList<Staff>();
        list = StaffModel.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }
    
     @RequestMapping(params="btnUpdate")
     public String update(@ModelAttribute("user") Staff staff, ModelMap model){
         StaffModel.update(staff);
         List<Staff> list = new ArrayList<Staff>();
         list = StaffModel.showStaff("");
         model.addAttribute("listUser", list);
         return "staff";
     }
     
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model){
        String Id = request.getParameter("txtMaNV");
        
        String Name = request.getParameter("txtName");
        boolean Gender = Boolean.parseBoolean("txtGender");
        String Date = request.getParameter("txtDate");
        String Photo = request.getParameter("txtPhoto");
        String Email = request.getParameter("txtEmail");
        String Phone = request.getParameter("txtPhone");
        float Salary = Float.parseFloat("txtSalary");
        String Notes = request.getParameter("txtNotes");
        String DepartId = request.getParameter("txtDepartId");
        Staff staff = new Staff(Id, Name, Gender, Date, Photo, Email, Phone, Salary, Notes, DepartId);
        model.addAttribute("staff", staff);
        
        List<Staff> list = new ArrayList<Staff>();
        list = StaffModel.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }     
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("staff") Staff staff){
        String Id = request.getParameter("txtMaNV");
        StaffModel.delete(Id);
        List<Staff> list = new ArrayList<Staff>();
        list = StaffModel.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }
    
}
