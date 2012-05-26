package minirestwebservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.player.xml.Player;
import de.quiz.xml.GamescoreTyp;
import de.quiz.xml.Quizgame;
import de.quiz.xml.Quizgame.Quizfrage;
import de.quiz.xml.Quizgame.Quizfrage.Antwort;
import de.quiz.xml.Quizgame.Quizfrage.Bild;

@SuppressWarnings("unused")
@Path( "/quiz" )
public class mvqService {
	private static final String QUIZ_XML= "./././RessourceFiles/Quiz.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	
		//Funktioniert noch nicht oder ich stell mich wieder blöd an :\
		//DAten Ändern mittels Query Parameter in URI: http://localhost:4434/quiz/player?id=1&name=Bernd&wins=100&loss=200
		//Vielleicht wäre hier ein anderer Anwendungsfall sinnvoller, anstatt den Player zu ändern.
		@PUT 
		@Consumes(MediaType.APPLICATION_XML)
		@Produces( "application/xml" )
		@Path("player/{id}")
		public Quizgame newXML(
				@PathParam("id") int id
//				@FormParam("name") String name,
//				@FormParam("wins") int wins,
//				@FormParam("loss") int loss
				) throws JAXBException, IOException {
			
			xmlWriter creator = new xmlWriter();
			ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
			
			Quizgame quiz = new Quizgame();
			
			//Spieler benennen und Spielstand für aktuelles Spiel
			Player player = creator.createPlayer("name",1,11,id); // hier sind die Parameter
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
			
			return quiz;
			
		}
		
		
		@GET @Produces( "application/xml" )
		public Quizgame getAll() throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj1 = new de.quiz.xml.ObjectFactory();
			
			Quizgame quiz = new Quizgame();
			JAXBContext context = JAXBContext.newInstance(Quizgame.class);
			Unmarshaller um = context.createUnmarshaller();
			um.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
			
			try {
				quiz = (Quizgame) um.unmarshal(new FileReader(QUIZ_XML));
			}
			catch (FileNotFoundException e) {
				System.err.println("File not Found");
			}
			catch (Exception e) {
				System.out.println("Fehler");
				e.printStackTrace();
				System.out.println(context.toString());
				
			}
			return quiz;
		}
		
		@Path("/frage")
		@GET @Produces( "application/xml" )
		public Quizgame getFrage(@QueryParam("nr") int i) throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj = new de.quiz.xml.ObjectFactory();
			Quizgame quiz = new Quizgame();
			JAXBContext context = JAXBContext.newInstance(Quizgame.class);
			Unmarshaller um = context.createUnmarshaller();
			try {
				quiz = (Quizgame) um.unmarshal(new FileReader(QUIZ_XML));
			}
			catch (FileNotFoundException e) {
				System.err.println("File not Found");
			}
			catch (Exception e) {
				System.out.println("Fehler");
				e.printStackTrace();
				System.out.println(context.toString());
				
			}
			
			Quizgame frage = obj.createQuizgame();
			frage.getQuizfrage().add(quiz.getQuizfrage().get(i-1));
			return frage;
		}
		
		
	
}
