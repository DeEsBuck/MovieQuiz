package minirestwebservice;

import javax.ws.rs.*;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.player.xml.Player;
import de.quiz.xml.Quizgame;
import de.quiz.xml.Quizgame.Quizfrage;

@SuppressWarnings("unused")
@Path( "/quiz" )
public class mvqService {
	private static final String QUIZ_XML= "/home/doro/workspace/Aufgabe7/Quiz.xml";
	
		@GET @Produces( "application/xml" )
		public Quizgame getAll() throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj1 = new de.quiz.xml.ObjectFactory();
			de.player.xml.ObjectFactory obj2 = new de.player.xml.ObjectFactory();
			
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
