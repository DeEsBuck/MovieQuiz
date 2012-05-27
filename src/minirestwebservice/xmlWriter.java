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

	
	/**
	 * Erzeugt 4 Antwortmöglichkeiten, die mit der Funktion createAntwort erfasst werden. 
	 * Diese ArrayList muss in createFrage() übergeben werden.
	 * @param result
	 * @param value
	 * @param result1
	 * @param value1
	 * @param result2
	 * @param value2
	 * @param result3
	 * @param value3
	 * @return ArrayList<Antwort>
	 */
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
	
	/**
	 * Zur Verwendung in createAntwortList()
	 * @param result
	 * @param value
	 * @return Antwort
	 */
	public Antwort createAntwort (Boolean result, String value) {
		Quizgame.Quizfrage.Antwort antwort = new Antwort();
		antwort.setResult(result);
		antwort.setValue(value);
		return antwort;
	}

	/**
	 * Objekt Quizfrage muss in getQuizfrage() dem Quizgame Root eingefügt werden. Z.B. <CODE>quiz.getQuizfrage().addAll(fragen);</CODE>
	 * @param nr
	 * @param time
	 * @param link
	 * @param antwort
	 * @return Quizfrage
	 */
	public Quizfrage createFrage (int nr, XMLGregorianCalendar time, Bild link, ArrayList<Antwort> antwort) {
		Quizgame.Quizfrage frage = new Quizfrage();
		frage.setNr(nr);
		frage.setTime(time);
		frage.setBild(link);
		frage.getAntwort().addAll(antwort);
		return frage;
	}
	
	/**
	 * Objekt Player muss in setAny dem Quizgame Root eingefügt werden. Z.B. <CODE>quiz.setAny(player);</CODE
	 * @param name
	 * @param wins
	 * @param loss
	 * @param id
	 * @return Player
	 */
	public Player createPlayer (String name, int wins, int loss, int id) {
		Player player = new Player();
		player.setName(name);
		player.setId(id);
		player.setWins(wins);
		player.setLoss(loss);
		return player;
	}
	
	/**
	 * Objekt GamescoreTyp muss in setGamescore dem Quizgame Root eingefügt werden. Z.B. <CODE>quiz.setGamescore(score);</CODE>
	 * @param wins
	 * @param loss
	 * @param scorenr
	 * @return GamescoreTyp
	 */
	public GamescoreTyp createGamescore (int wins, int loss, long scorenr) {
		GamescoreTyp score = new GamescoreTyp();
		score.setWins(wins);
		score.setLoss(loss);
		score.setScore(BigInteger.valueOf(scorenr));
		return score;
	}
}
