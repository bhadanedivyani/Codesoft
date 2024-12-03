import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    static int score = 0; 
    static boolean answered = false;
    static Timer timer; 
    public static void main(String[] args) {
                String[] questions = {
                "What is the capital of France?",
                "Which programming language is platform-independent?",
                "What is the square root of 64?"
        };

        String[][] options = {
                {"1. Rome", "2. Berlin", "3. Paris", "4. Madrid"},
                {"1. Python", "2. C++", "3. Java", "4. JavaScript"},
                {"1. 6", "2. 7", "3. 8", "4. 9"}
        };

        int[] answers = {3, 3, 3}; // Correct options (1-indexed)

        Scanner sc = new Scanner(System.in);

                for (int i = 0; i < questions.length; i++) {
            answered = false;
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
             for (String option : opti
           ons[i]) {
                System.out.println(option);
            }

            
            startTimer();

            
            int userAnswer = -1;
            try {
                userAnswer = sc.nextInt();
                answered = true; 
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.next(); // Clear invalid input
            }

           
            timer.cancel();

            
            if (answered) {
                if (userAnswer == answers[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            } else {
                System.out.println("Time's up! Moving to the next question.");
            }
        }

        
        System.out.println("\nQuiz Over! Your score is: " + score + "/" + questions.length);
        sc.close();
    }

       public static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int seconds = 10; 
            @Override
            public void run() {
                if (seconds > 0) {
                    System.out.print("\rTime left: " + seconds + " seconds ");
                    seconds--;
                } else {
                    System.out.println("\nTime's up!");
                    answered = false;
                    timer.cancel(); // Stop the timer
                }
            }
        }, 0, 1000);
    }
}
