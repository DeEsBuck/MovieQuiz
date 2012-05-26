package minirestwebservice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;

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
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
		ArrayList<Quizgame.Quizfrage.Antwort> antworten = new ArrayList<Quizgame.Quizfrage.Antwort>();
		
		Quizgame quiz = new Quizgame();
		
		Player player = new Player();
		player.setName("Harald");
		player.setId(1);
		player.setWins(10);
		player.setLoss(0);
		quiz.setAny(player);
		
		GamescoreTyp score = new GamescoreTyp();
		score.setWins(2);
		score.setLoss(100);
		score.setScore(BigInteger.valueOf(0));
		quiz.setGamescore(score);
				
		Quizgame.Quizfrage.Antwort antwort = new Antwort();
		antwort.setResult(true);
		antwort.setValue("Die Vögel");
		antworten.add(antwort);
		Quizgame.Quizfrage.Antwort antwort1 = new Antwort();
		antwort1.setResult(false);
		antwort1.setValue("The Crow");
		antworten.add(antwort1);
		Quizgame.Quizfrage.Antwort antwort2 = new Antwort();
		antwort2.setResult(false);
		antwort2.setValue("Pokemon der Film");
		antworten.add(antwort2);
		Quizgame.Quizfrage.Antwort antwort3 = new Antwort();
		antwort3.setResult(false);
		antwort3.setValue("Das Schweigen der Lämmer");
		antworten.add(antwort3);
				
		//XMLGregorianCalendar time = new GregorianCalendar();
		Quizgame.Quizfrage.Bild link = new Bild();
		link.setLink(LINK);
		
		Quizgame.Quizfrage frage = new Quizfrage();
		frage.setNr(1);
		frage.setTime(null);
		frage.setBild(link);
		frage.getAntwort().addAll(antworten);
		fragen.add(frage);
		
		Quizgame.Quizfrage frage2 = new Quizfrage();
		frage2.setNr(2);
		frage2.setTime(null);
		frage2.setBild(link);
		frage2.getAntwort().addAll(antworten);
		fragen.add(frage2);
		
		quiz.getQuizfrage().addAll(fragen);
		
		
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
		
		
	}

}
