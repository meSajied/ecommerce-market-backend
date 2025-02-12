package org.ecommerce.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
  // private final AdminService adminService;

  // public AdminController(AdminService adminService) {
  //   this.adminService = adminService;
  // }

   @PostMapping("/login")
   public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) {
    if(admin.getUsername().equals("admin") && admin.getPassword().equals("Admin123")) {
      admin.setUsername("admin");
      admin.setPassword("Admin123");
      return ResponseEntity.ok(admin);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   
}
