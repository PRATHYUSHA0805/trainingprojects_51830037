package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public User addUser(User user) {
	
		return userRepository.save(user);
	}

	

	@Override
	public void blockUser(Long userId) {
	
		
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Long userId) {
		
		return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public User updateUser(Long userId, User user) {
		User userToBeUpdated=userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
		userToBeUpdated.setAddress(user.getAddress());
		userToBeUpdated.setPhone(user.getPhone());
		return userRepository.save(userToBeUpdated);
	}

	

	

}
