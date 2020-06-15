package de.adrianwilke.startcoding.framework_dev;

public class Example implements DataProvider {

	public static void main(String[] args) {
		Webserver.go(new Example());
	}

	public void handle(String request, StringBuilder response) throws Exception {
		response.append("Hi ");
		response.append(request);
	}

}