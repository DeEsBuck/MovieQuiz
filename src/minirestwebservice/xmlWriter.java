package minirestwebservice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import de.player.xml.Player;
import de.quiz.xml.GamescoreTyp;
import de.quiz.xml.Quizgame;
import de.quiz.xml.Quizgame.Quizfrage;
import de.quiz.xml.Quizgame.Quizfrage.Antwort;
import de.quiz.xml.Quizgame.Quizfrage.Bild;

@SuppressWarnings("unused")
public class xmlWriter {

	private static final String QUIZ_XML= "./././RessourceFiles/Quiz.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	/**
	 * @param args
	 * @return 
	 */
	//Erzeuegen von neuen XML Daten soll vom Client aus steuerbar sein, siehe mvqService.java 
	/*
	public static void main(String[] args) throws JAXBException, IOException {
		ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
		
		Quizgame quiz = new Quizgame();
		
		//Spieler benennen und Spielstand für aktuelles Spiel
		Player player = createPlayer("Harald",1,299,1);
		GamescoreTyp score = createGamescore(1,4,900);
		
		//Elemente für Quizfrage deklarieren
		//XMLGregorianCalendar time = new GregorianCalendar();
		Quizgame.Quizfrage.Bild link = new Bild();
		link.setLink(LINK);
		
		//Antwortliste mit bis zu 4 Möglichkeiten
		ArrayList<Antwort> antworten = createAntwortList(true, "Die Vögel", false, "Drakula", false, "Hanni und Nanni", false, "Pokemon");
		ArrayList<Antwort> antworten2 = createAntwortList(true, "Dragonball Z", false, "Bones", false, "Zombie Land", false, "sDuck Tales");
		
		//Einzelne Filme mit Antwortauswahl von darüber
		Quizgame.Quizfrage frage = createFrage(1,null,link,antworten);
		fragen.add(frage);
		Quizgame.Quizfrage frage2 = createFrage(2,null,link,antworten2);
		fragen.add(frage2);
		
		//Zuweisung der Element an das Root Quizgame
		quiz.setAny(player);
		quiz.setGamescore(score);
		quiz.getQuizfrage().addAll(fragen);
		
		//in XML umwandeln und in Quiz.xml schreiben
		JAXBContext context = JAXBContext.newInstance(Quizgame.class,Player.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(quiz, System.out);
		
		Writer wr = null;
		try {
			wr = new FileWriter(QUIZ_XML);
			m.marshal(quiz, wr);
		}
		finally {
			try {
				wr.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}*/
	
	public ArrayList<Antwort> createAntwortList (Boolean result, String value, Boolean result1, String value1, Boolean result2, String value2, Boolean result3, String value3) {
		ArrayList<Quizgame.Quizfrage.Antwort> antworten = new ArrayList<Quizgame.Quizfrage.Antwort>();
		Quizgame.Quizfrage.Antwort antwort = createAntwort(result, value);
		antworten.add(antwort);
		Quizgame.Quizfrage.Antwort antwort1 = createAntwort(result1, value1);
		antworten.add(antwort1);
		Quizgame.Quizfrage.Antwort antwort2 = createAntwort(result2, value2);
		antworten.add(antwort2);
		Quizgame.Quizfrage.Antwort antwort3 = createAntwort(result3, value3);
		antworten.add(antwort3);
		return antworten;
	}
	
	public Antwort createAntwort (Boolean result, String value) {
		Quizgame.Quizfrage.Antwort antwort = new Antwort();
		antwort.setResult(result);
		antwort.setValue(value);
		return antwort;
	}

	public Quizfrage createFrage (int nr, XMLGregorianCalendar time, Bild link, ArrayList<Antwort> antwort) {
		Quizgame.Quizfrage frage = new Quizfrage();
		frage.setNr(nr);
		frage.setTime(time);
		frage.setBild(link);
		frage.getAntwort().addAll(antwort);
		return frage;
	}
	
	public Player createPlayer (String name, int wins, int loss, int id) {
		Player player = new Player();
		player.setName(name);
		player.setId(id);
		player.setWins(wins);
		player.setLoss(loss);
		return player;
	}
	public GamescoreTyp createGamescore (int wins, int loss, long scorenr) {
		GamescoreTyp score = new GamescoreTyp();
		score.setWins(wins);
		score.setLoss(loss);
		score.setScore(BigInteger.valueOf(scorenr));
		return score;
	}
}
