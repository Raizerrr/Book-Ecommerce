package fpoly.edu.assignment_java5.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.respository.UserRepository;
import fpoly.edu.assignment_java5.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
	
		List<User> result = userRepository.findAll();
		
		return result;
	}

	
	
}
