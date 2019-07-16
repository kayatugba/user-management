package com.tugbakaya.userjob.job;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tugbakaya.userrepository.entity.UserEntity;
import com.tugbakaya.userrepository.repository.UserRepository;

@Component
public class UserTimeoutJob {

	final static Integer TIMEOUT_MINUTE = 5;

	@Autowired
	UserRepository userRepository;

	@Scheduled(fixedDelay = 60000)
	public void scheduleFixedDelayTask() {
		System.out.println("--------------cronjob time - " + new Date(System.currentTimeMillis()));
		Date beforeDate = new Date(System.currentTimeMillis() - TIMEOUT_MINUTE * 60 * 1000);
		System.out.println("---before Update from cronjob" + beforeDate.toString());
		updateOldUsers(beforeDate);

	}

	public void updateOldUsers(Date beforeDate) {
		List<UserEntity> timeoutUsers = findTimeoutUsers(beforeDate);
		System.out.println("time out user size "+ timeoutUsers.size());
		for (UserEntity user : timeoutUsers) {
			userRepository.setOldUserforUser(user.getId());
		}

	}

	public List<UserEntity> findTimeoutUsers(Date beforeDate) {
		return userRepository.findByCreationDateBeforeAndOldUser(beforeDate, false);
	}

}
