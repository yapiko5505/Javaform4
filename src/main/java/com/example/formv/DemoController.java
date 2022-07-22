package com.example.formv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types = DemoForm.class)

public class DemoController {
    @ModelAttribute("demoForm")
    public DemoForm createDemoForm() {
        DemoForm demoForm = new DemoForm();

        demoForm.setName("テスト　名前");
        demoForm.setSex("1");
        return demoForm;
    }

    @GetMapping("/")
    public String index(DemoForm demoForm){
        return "input";
    }

    @PostMapping("/confirm")
    public String confirm(DemoForm demoForm) {
        return "confirm";
    }

    @PostMapping("/send")
    public String send(){
        return "redirect:/complete";
    }

    @GetMapping("/complete")
    public String complate(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "complete";
    }

}
