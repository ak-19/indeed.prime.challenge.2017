package hr.st.ante;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Encircular {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileInputStream("files/Encircular.txt"));
        String[] res;
        int commands_size = 0;
        commands_size = Integer.parseInt(in.nextLine().trim());

        String[] commands = new String[commands_size];
        for (int i = 0; i < commands_size; i++) {
            String commands_item;
            try {
                commands_item = in.nextLine();
            } catch (Exception e) {
                commands_item = null;
            }
            commands[i] = commands_item;
        }

        res = doesCircleExist(commands);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }

    private static String[] doesCircleExist(String[] commands) {
        int N = commands.length;
        String[] results = new String[N];

        for (int i = 0; i < N; i++) {
            results[i] = findAnswerForLine(commands[i]);
        }

        return results;
    }

    private static String findAnswerForLine(String commandLine) {
        int x = 0, y = 0;
        int N = commandLine.length();
        Robot robot = new Robot(0, 0, Direction.North);
        for (int fullTour = 0; fullTour < 4; fullTour++) {
            for (int command = 0; command < N; command++) {
                char c = commandLine.charAt(command);
                modifyRobotWithCommand(robot, c);
            }

            if (robot.x == 0 && robot.y == 0) {
                return "YES";
            }
        }
        return "NO";
    }

    private static void modifyRobotWithCommand(Robot robot, char command) {
        if (robot.direction == Direction.North){
            if (command == 'R'){
                robot.direction = Direction.East;
            }else if (command == 'L'){
                robot.direction = Direction.West;
            }else{
                robot.y--;
            }
        }else if (robot.direction == Direction.South){
            if (command == 'R'){
                robot.direction = Direction.West;
            }else if (command == 'L'){
                robot.direction = Direction.East;
            }else{
                robot.y++;
            }
        }else if (robot.direction == Direction.West){
            if (command == 'R'){
                robot.direction = Direction.North;
            }else if (command == 'L'){
                robot.direction = Direction.South;
            }else{
                robot.x--;
            }
        }else{ //Direction.East
            if (command == 'R'){
                robot.direction = Direction.South;
            }else if (command == 'L'){
                robot.direction = Direction.North;
            }else{
                robot.x++;
            }
        }
    }

    private static enum Direction {
        North, East, West, South
    }

    private static class Robot {
        int x, y;
        Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
