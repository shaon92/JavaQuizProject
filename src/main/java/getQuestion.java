import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class getQuestion {
    public void readQuestions() throws IOException, ParseException {
        int count = 1, points = 0;
        JSONArray jsonArray = null;
        while (count <= 5) {
            String fileName = "./src/main/resources/Questions.json";
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            jsonArray = (JSONArray) obj;
            if (jsonArray.isEmpty()) {
                System.out.println("No questions available. Add questions.");
                break;
            } else {
                int pos = new Random().nextInt(((JSONArray) obj).toArray().length);
                JSONObject json = (JSONObject) jsonArray.get(pos);
                String question = (String) json.get("question");
                String op1 = (String) json.get("optionOne");
                String op2 = (String) json.get("optionTwo");
                String op3 = (String) json.get("optionThree");
                String op4 = (String) json.get("optionFour");
                String corr = (String) json.get("optionCorrect");
                corr = corr.toUpperCase();
                System.out.println("\nQ." + count + " " + question);
                System.out.println(op1 + "\t\t\t" + op2);
                System.out.println(op3 + "\t\t\t" + op4);
                System.out.print("\nInput Option(A/B/C/D): ");
                Scanner input = new Scanner(System.in);
                String ans = input.next();
                ans = ans.toUpperCase();
                if (ans.equals("A") || ans.equals("B") || ans.equals("C") || ans.equals("D")) {
                    if (corr.equals(ans)) {
                        points += 1;
                        System.out.println("Correct Answer.");
                    } else {
                        System.out.println("Wrong answer. Correct Ans is: " + corr);
                    }
                } else {
                    System.out.println("Invalid Input.");
                }
                count++;
            }
        }
        if (!jsonArray.isEmpty()) {
            System.out.println("\nTotal Points Obtained: " + points);
        }
    }
}
