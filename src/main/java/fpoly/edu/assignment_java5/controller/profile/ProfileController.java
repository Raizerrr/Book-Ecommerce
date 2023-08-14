package fpoly.edu.assignment_java5.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

	@GetMapping("/profile")
	public String goToProfile() {
		
		
		 return "/user/profile";
		
	}
	
	
}
