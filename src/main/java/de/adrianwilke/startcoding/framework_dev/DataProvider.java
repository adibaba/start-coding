package de.adrianwilke.startcoding.framework_dev;

public interface DataProvider {

	public void handle(String request, StringBuilder content) throws Exception;

}