package de.adrianwilke.startcoding;

import java.util.ArrayList;

import org.fastily.jwiki.core.Wiki;

@SuppressWarnings("unused")
public class WikipediaBeispiel {

	public static void main(String[] args) {

		Wiki wiki = new Wiki.Builder().withDomain("de.wikipedia.org").withDefaultLogger(false).build();

		String hauptseite = "Wikipedia:Hauptseite";
		String jugendkultur = "Jugendkultur";
		String kategorieJugendUndMedien = "Kategorie:Jugend_und_Medien";
		String kategorieJugendzeitschrift = "Kategorie:Jugendzeitschrift_(Deutschland)";
		String kategorieJugendFilm = "Kategorie:Jugendfilm";

		// https://de.wikipedia.org/wiki/Portal:Kinder_und_Jugendliche
		// https://de.wikipedia.org/wiki/Kategorie:Musik_nach_Genre

		if (Boolean.FALSE) {
			System.out.println(wiki.getPageText(hauptseite));
		}

		if (Boolean.FALSE) {
			System.out.println(wiki.getPageText(jugendkultur));
		}

		if (Boolean.FALSE) {
			ArrayList<String> titles = wiki.getCategoryMembers(kategorieJugendUndMedien);
			for (int i = 0; i < titles.size(); i++) {
				System.out.println(titles.get(i));
			}
		}

		if (Boolean.TRUE) {
			System.out.println(wiki.getCategoryMembers(kategorieJugendFilm).size());
		}

		if (Boolean.FALSE) {
			ArrayList<String> titles = wiki.search(jugendkultur, -1);
			for (String title : titles) {
				System.out.println(title);
			}
		}
	}
}