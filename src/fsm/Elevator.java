package fsm;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    public static void main(String[] args) {
        System.out.println(run("UACOC"));
    }

    public static List<String> run(String input) {
        String state = "IDLE";
        List<String> list = new ArrayList<>();
        for(char ch : input.toCharArray()) {
            switch (ch) {
                case 'U':
                    if(state.equals("IDLE")) {
                        state = "MOVING_UP";
                    }
                    list.add(state);
                break;
                case 'D':
                    if(state.equals("IDLE")) {
                        state = "MOVING_DOWN";
                    }
                    list.add(state);
                break;
                case 'A':
                    if(state.equals("MOVING_UP")) {
                        state = "IDLE";
                    } else if(state.equals("MOVING_DOWN")) {
                        state = "IDLE";
                    }
                    list.add(state);
                break;
                case 'O':
                    if(state.equals("IDLE")) {
                        state = "DOOR_OPEN";
                    }
                    list.add(state);
                break;
                case 'C':
                    if(state.equals("DOOR_OPEN")) {
                        state = "IDLE";
                    }
                    list.add(state);
                break;
            }
        }
        return list;
    }
}
