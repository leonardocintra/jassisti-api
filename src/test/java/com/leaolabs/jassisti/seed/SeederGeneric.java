package com.leaolabs.jassisti.seed;

import java.util.Locale;

import com.github.javafaker.Faker;

public abstract class SeederGeneric {

	private static final Faker faker = new Faker(new Locale("pt-BR"));

	protected static Faker faker() {
		return faker;
	}
}
