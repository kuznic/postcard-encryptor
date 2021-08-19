package com.meedra;

import com.meedra.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostcardEncryptorApplication implements CommandLineRunner {

	@Autowired
	AccountVelocitiesService accountVelService;

	@Autowired
	PanAccountEncryptorService panAccountEncryptorService;

	@Autowired
	CardVelocitiesService cardVelocitiesService;

	@Autowired
	ExtendedVelocitiesService extendedVelocitiesService;

	@Autowired
	CardActivityService cardActivityService;

	public static void main(String[] args) {
		SpringApplication.run(PostcardEncryptorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountVelService.updateAccountIds(panAccountEncryptorService.encryptPanOrAccount(accountVelService.fetchAccountIds()));
		cardVelocitiesService.updateCards(panAccountEncryptorService.encryptPanOrAccount(cardVelocitiesService.fetchCards()));
		extendedVelocitiesService.updateCards(panAccountEncryptorService.encryptPanOrAccount(extendedVelocitiesService.fetchCards()));
		cardActivityService.updateCards(panAccountEncryptorService.encryptPanOrAccount(cardActivityService.fetchCards()));

	}
}
