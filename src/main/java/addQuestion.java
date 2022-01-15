import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class addQuestion {
    public void writeQuestions() throws IOException, ParseException {
        String fileName = "./src/main/resources/Questions.json";
        String q, o1, o2, o3, o4, c;
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject questionObj = new JSONObject();
        Scanner input = new Scanner(System.in);
        System.out.println("Input Question: ");
        q = input.nextLine();
        System.out.println("Input option A : ");
        o1 = input.nextLine();
        System.out.println("Input option B : ");
        o2 = input.nextLine();
        System.out.println("Input option C : ");
        o3 = input.nextLine();
        System.out.println("Input  option D : ");
        o4 = input.nextLine();
        System.out.println("Input correct option (A/B/C/D): ");
        c = input.nextLine();
        c = c.toUpperCase();
        if (c.equals("A") || c.equals("B") || c.equals("C") || c.equals("D")) {
            questionObj.put("question", q);
            questionObj.put("optionOne", "A) " + o1);
            questionObj.put("optionTwo", "B) " + o2);
            questionObj.put("optionThree", "C) " + o3);
            questionObj.put("optionFour", "D) " + o4);
            questionObj.put("optionCorrect", c);
            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(questionObj);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
        } else {
            System.out.println("Invalid input. Start Over.");
        }
    }
}
