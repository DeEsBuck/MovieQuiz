package minirestwebservice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import de.player.xml.Player;
import de.quiz.xml.GamescoreTyp;
import de.quiz.xml.Quizgame;
import de.quiz.xml.Quizgame.Quizfrage.Antwort;
import de.quiz.xml.Quizgame.Quizfrage.Bild;

public class testXMLWriter {
	private static final String QUIZ_XML= "./././RessourceFiles/Quiz.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	
	/**
	 * @param args
	 * @return 
	 */
	//Erzeuegen von neuen XML Daten soll vom Client aus steuerbar sein, siehe mvqService.java 
	
	public static void main(String[] args) throws JAXBException, IOException {
		ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
		
		Quizgame quiz = new Quizgame();
		xmlWriter creator = new xmlWriter();
		
		//Spieler benennen und Spielstand für aktuelles Spiel
		Player player = creator.createPlayer("Harald",1,299,1);
		GamescoreTyp score = creator.createGamescore(1,4,900);
		
		//Elemente für Quizfrage deklarieren
		//XMLGregorianCalendar time = new GregorianCalendar();
		Quizgame.Quizfrage.Bild link = new Bild();
		link.setLink(LINK);
		
		//Antwortliste mit bis zu 4 Möglichkeiten
		ArrayList<Antwort> antworten = creator.createAntwortList(true, "Die Vögel", false, "Drakula", false, "Hanni und Nanni", false, "Pokemon");
		ArrayList<Antwort> antworten2 = creator.createAntwortList(true, "Dragonball Z", false, "Bones", false, "Zombie Land", false, "sDuck Tales");
		
		//Einzelne Filme mit Antwortauswahl von darüber
		Quizgame.Quizfrage frage = creator.createFrage(1,null,link,antworten);
		fragen.add(frage);
		Quizgame.Quizfrage frage2 = creator.createFrage(2,null,link,antworten2);
		fragen.add(frage2);
		
		//Zuweisung der Element an das Root Quizgame
		quiz.setId(1);
		quiz.setThema("Spökes");
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
		
	}
}
