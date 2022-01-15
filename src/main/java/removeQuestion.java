import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class removeQuestion {
    public void getAllQuestions() throws IOException, ParseException {
        String fileName = "./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        System.out.println("List of all saved Questions..");
        int count =1;
        for (int i=0;i<jsonArray.toArray().length;i++) {
            JSONObject json = (JSONObject) jsonArray.get(i);
            String question = (String) json.get("question");
            System.out.println(count+". "+question);
            count++;
        }
        System.out.print("\nInput Question number to remove: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        if(index>jsonArray.toArray().length){
            System.out.println("Invalid Input. Start Over.");
        }
        else {
            removeQuestions((index - 1));
        }
    }
    public void removeQuestions(int index) throws IOException, ParseException {
        String fileName = "./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.remove(index);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Deleted!");
    }
}
