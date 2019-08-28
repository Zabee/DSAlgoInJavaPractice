package com.zabee.just.java8.practice;

import java.util.function.Function;

public class Java8AdvancedCurrying {

	public static void main(String[] args) {
		Letter letter1 = createLetter("To me", "To you", "Mr.", " Long time no call", "Nothing much");
		System.out.println(letter1);

		Function<String, Function<String, Function<String, Function<String, Function<String, Letter>>>>> LETTER_BUILDER//
				= returningAddress -> insideAddress -> salutation -> body -> closing -> new Letter(returningAddress,
						insideAddress, salutation, body, closing);
		Letter letter2 = LETTER_BUILDER.apply("To me")//
				.apply("To you")//
				.apply("Mr.")//
				.apply(" Long time no call")//
				.apply("Nothing much");
		System.out.println(letter2);

		Letter letter3 = new Letter();
		letter3.setReturningAddress("To me")//
		.setInsideAddress("To you")//
		.setSalutation("Mr.")//
		.setBody(" Long time no call")//
		.setClosing("Nothing much");
		System.out.println(letter3);
		
	}

	private static Letter createLetter(String returningAddress, String insideAddress, String salutation, String body,
			String closing) {
		return new Letter(returningAddress, insideAddress, salutation, body, closing);
	}

	private static class Letter {
		private String returningAddress;
		private String insideAddress;
		private String salutation;
		private String body;
		private String closing;
		
		private Letter() {
			
		}

		private Letter(String returningAddress, String insideAddress, String salutation, String body, String closing) {
			this.returningAddress = returningAddress;
			this.insideAddress = insideAddress;
			this.salutation = salutation;
			this.body = body;
			this.closing = closing;
		}

		@Override
		public String toString() {
			return returningAddress + ":" + insideAddress + ":" + salutation + ":" + body + ":" + closing;
		}
		
		public String getReturningAddress() {
			return returningAddress;
		}

		public Letter setReturningAddress(String returningAddress) {
			this.returningAddress = returningAddress;
			return this;
		}

		public String getInsideAddress() {
			return insideAddress;
		}

		public Letter setInsideAddress(String insideAddress) {
			this.insideAddress = insideAddress;
			return this;
		}

		public String getSalutation() {
			return salutation;
		}

		public Letter setSalutation(String salutation) {
			this.salutation = salutation;
			return this;
		}

		public String getBody() {
			return body;
		}

		public Letter setBody(String body) {
			this.body = body;
			return this;
		}

		public String getClosing() {
			return closing;
		}

		public Letter setClosing(String closing) {
			this.closing = closing;
			return this;
		}

	}
}
