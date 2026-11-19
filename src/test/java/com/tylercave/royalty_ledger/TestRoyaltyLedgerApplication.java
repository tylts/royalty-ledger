package com.tylercave.royalty_ledger;

import org.springframework.boot.SpringApplication;

public class TestRoyaltyLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.from(RoyaltyLedgerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
