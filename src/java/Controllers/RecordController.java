/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Controllers;

import Bean.Record;
import Model.RecordModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author L.A.H.D
 */
@Controller 
@RequestMapping("/record/")
public class RecordController {
    @RequestMapping("showall")
    public String showall(ModelMap model){
        RecordModel user = new RecordModel();
        List<Record> list = new ArrayList<Record>();
        list = user.showRecord("");
        model.addAttribute("listRecord", list);
        Record staffs = new Record();
        model.addAttribute("record", staffs);
        return "record";
    }
}
