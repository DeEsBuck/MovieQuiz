package minirestwebservice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.player.xml.Player;
import de.quiz.xml.Quizgame;

@SuppressWarnings("unused")
public class xmlWriter {

	private static final String QUIZ_XML= "./././RessourceFiles/Quiz.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
		ArrayList<Quizgame.Quizfrage.Antwort> antworten = new ArrayList<Quizgame.Quizfrage.Antwort>();
		
		Player player = new Player();
		player.setName("Harald");
		player.setId(1);
		player.setWins(10);
		player.setLoss(0);
		
		Quizgame quiz = new Quizgame();
		
		quiz.setAny(player);
		
		
		
		
		

	}

}
