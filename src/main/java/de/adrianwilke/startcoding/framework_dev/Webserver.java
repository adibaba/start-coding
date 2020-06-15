package de.adrianwilke.startcoding.framework_dev;

import java.io.IOException;

import org.rapidoid.http.Req;
import org.rapidoid.http.fast.ReqHandler;
import org.rapidoid.http.fast.ServerSetup;

public class Webserver {

	private static final ServerSetup DEFAULT_SERVER_SETUP = new ServerSetup();

	private StringBuilder stringBuilder;

	public static void go(DataProvider dataProvider) {
		Webserver webserver = new Webserver();
		StringBuilder stringBuilder = new StringBuilder();
		webserver.addHeader(stringBuilder);
		try {
			dataProvider.handle("", stringBuilder);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		webserver.addFooter(stringBuilder);
		// TODO: Configure server (port, threads,..)
		DEFAULT_SERVER_SETUP.get("/").html(stringBuilder.toString());
		DEFAULT_SERVER_SETUP.get("/param/").html(new ReqHandler() {

			@Override
			public Object handle(Req req) throws Exception {
				// TODO: This tests parameters
				// TODO: same instance used until now
				dataProvider.handle(req.param("text"), stringBuilder);
				return stringBuilder.toString();
//				return req.param("text");
			}
		}).listen();

	}

	public Webserver add(String string) {
		if (stringBuilder == null) {
			stringBuilder = new StringBuilder();
			addHeader(stringBuilder);
		}
		stringBuilder.append(string.replaceAll("\n", "<br/>"));
		return this;
	}

	public void start() {
		addFooter(stringBuilder);
		DEFAULT_SERVER_SETUP.get("/").html(stringBuilder).listen();
	}

	private void addHeader(StringBuilder stringBuilder) {
		try {
			stringBuilder.append(Utils.getResourceFileAsString("header.htm"));
			stringBuilder.append(System.lineSeparator());
			stringBuilder.append(System.lineSeparator());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void addFooter(StringBuilder stringBuilder) {
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(" </div>");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("</body>");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("</html>");
		stringBuilder.append(System.lineSeparator());
	}

}