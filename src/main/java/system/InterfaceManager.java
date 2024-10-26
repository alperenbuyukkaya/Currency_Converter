package system;

import java.util.Scanner;

public class InterfaceManager {
    Scanner mainScanner = new Scanner(System.in);
    public <T> T getInput(Class<T> input, boolean positive, String inputMessage){
        switch(input.getSimpleName()){
            case "String":
                while (true){
                    System.out.print(inputMessage);
                    String userInput = mainScanner.next();
                    if (userInput.isEmpty()){
                        continue;
                    }
                    return input.cast(userInput);
                }
                case "Integer":
                    while (true){
                        System.out.print(inputMessage);
                        int userInput;
                        try{
                            userInput = Integer.valueOf(mainScanner.next());
                        }catch (Exception e){
                            continue;
                        }
                        if (positive && userInput < 0){
                            continue;
                        }
                        return input.cast(userInput);
                    }
            case "Double":
                while (true){
                    System.out.print(inputMessage);
                    double userInput;
                    try{
                        userInput = Double.valueOf(mainScanner.next());
                    }catch (Exception e){
                        continue;
                    }
                    if (positive && userInput < 0){
                        continue;
                    }
                    return input.cast(userInput);
                }
        }
        return null;
    }
}
