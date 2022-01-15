import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class quizMain {
    public static void main(String[] args) throws IOException, ParseException {
        getQuestion getQuestion = new getQuestion();
        addQuestion addQuestions = new addQuestion();
        removeQuestion removeQuestion = new removeQuestion();
        System.out.println("Welcome to the Quiz.");
        System.out.println("\t1.Take a Quiz\n\t2.Add new question\n\t3.Remove a question\n\t4.Exit");
        System.out.print("Enter a choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 4) {
            if (choice == 1) {
                getQuestion.readQuestions();
            } else if (choice == 2) {
                addQuestions.writeQuestions();
            } else if (choice == 3) {

                removeQuestion.getAllQuestions();
            } else {
                System.out.println("Wrong Input");
            }
            System.out.println("\nWelcome to the Quiz Project.");
            System.out.println("\t1.Take a Quiz\n\t2.Add new question\n\t3.Remove a question\n\t4.Exit");
            System.out.print("Enter a choice: ");
            choice = input.nextInt();
        }
        System.out.println("\n---Thank you for using this system---");
    }
}
