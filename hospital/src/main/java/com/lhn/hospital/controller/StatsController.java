//package com.lhn.hospital.controller;
//
//import com.lhn.hospital.entity.User;
//import com.lhn.hospital.service.StatsService;
//import com.lhn.hospital.service.UserService;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// *
// * @author LAPTOP
// */
//@Controller
//public class StatsController {
//
//    @Autowired
//    private StatsService statsService;
//    @Autowired
//    private UserService userService;
//    //Xem lại permisstion viết ở controller có hợp lý không ?
//
//
//    @GetMapping("/stats")
//    public String stats(Model model ,  @RequestParam Map<String, String> params , @AuthenticationPrincipal User user){
//
//        List<Object[]> stats_admin = statsService.statsCountExaminedTotalAmount(params);
//        List<Object[]> stats_doctor = statsService.statsDiagnosedCountExamined(params);
//
//        model.addAttribute("stats_admin",stats_admin);
//        model.addAttribute("stats_doctor",stats_doctor);
//        model.addAttribute("params",params);
//
//
//        return "stats";
//
//
//    }
//
//
//}
