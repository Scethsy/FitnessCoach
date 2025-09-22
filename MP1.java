//authored by Nathan Valeriano
//A program that creates a health fitness program with tweaks according to specifications.
import java.util.Scanner;

class InputValidation {
    public static int inputValidation(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int x;

        while (true) {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                if (x < min || x > max) {
                    System.out.println ("Error! Invalid input. Please enter a number from the choices ("+min+"-"+max+") only.");
                } else {
                    return x;
                }
            } else {
                System.out.println("Error! Invalid input. Please enter a valid integer number only.");
                scanner.next();
            }
        }
    }
    public static int inputValidationNoParameter() {
        Scanner scanner = new Scanner(System.in);
        int x;

        while (true) {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                return x;
            } else {
                System.out.println("Error! Invalid input. Please enter a valid integer number only.");
                scanner.next();
            }
        }
    }
    public static int inputValidationDouble() {
        Scanner scanner = new Scanner(System.in);
        double x;

        while (true) {
            if (scanner.hasNextDouble()) {
                x = scanner.nextDouble();
                if (x < 0) {
                    System.out.println ("Error! Invalid input. Please enter a valid positive value.");
                } else {
                    return x;
                }
            } else {
                System.out.println("Error! Invalid input. Please enter a valid integer number only.");
                scanner.next();
            }
        }
    }
}

public class FitnessCoach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        //Health Condition Checker
        System.out.print("Do you have any existing health conditions? yes/no: ");
        String healthConditionInput = scanner.nextLine().trim().toLowerCase();
        if (healthConditionInput.equals("yes")) {
            System.out.println("\nDue to existing health conditions, it is important to consult a healthcare professional before starting any fitness practices, Safety is a number one priority.");
            scanner.close();
            return; // Exit
        }
        //Inputs from User
        System.out.println("(Please Provide Necessary Information for accurate results.)");
        System.out.println("What is your age: ");
        int age = InputValidation.inputValidation(1, 120);
        System.out.println("What is your weight(kg): ");
        double weight = InputValidation.inputValidationDouble();
        System.out.println("What is your height(cm): ");
        double height = InputValidation.inputValidationDouble();

        System.out.println("What is your fitness goal? Please indicate your answer by the number beside them. ");
        System.out.printf("Choices(1-3): %n 1. Lose Weight %n 2. Build %n 3. Maintain %n");
        int goal = InputValidation.inputValidation(1, 3);
        System.out.println("Do you have any Dietary Restrictions? Please indicate your answer by the number beside them.");
        System.out.printf("Choices(1-6): %n 1. None %n 2. Vegan %n 3. Vegetarian %n 4. Pescatarian %n 5. Gluten-free %n 6. Keto %n");
        int restriction = InputValidation.inputValidation(1, 6);
        System.out.println("How much time are you free for physical activity? (State in hours per week only) ");
        int exercise_time = InputValidation.inputValidationNoParameter();
        System.out.println("Enter your preferred Workout Intensity. ");
        System.out.printf("Choices(1-3): %n 1. Low %n 2. Moderate %n 3. High %n");
        int exercise_intensity = InputValidation.inputValidation(1, 3);
        System.out.println("Enter your preferred Workout Environment. ");
        System.out.printf("Choices(1-3): %n 1. Gym %n 2. Home %n 3. Outdoor %n");
        int exercise_place = InputValidation.inputValidation(1, 3);

        System.out.println("\nCalculating Results... \n");
        /* Legend 
            goal, 1 = Lose, 2 = Build, 3 = Maintain
            restriction, 1 = None, 2 = Vegan, 3 = Vegetarian, 4 = Pescatarian, 5 = Gluten-free, 6 = Keto
            time = hrs
            intensity, 1 = Low, 2 = Moderate, 3 = High
            place, 1 = gym, 2 = home, 3 = outdoor
        */

       //BMI
       double heightM = height/100;
       String bmi_class = "";
       double bmi = weight / (heightM*heightM);
       if (bmi < 18.5) {
            bmi_class = "Underweight";
       } else if (bmi < 25) {
            bmi_class = "Normal Weight";
       } else if (bmi < 30) {
            bmi_class = "Overweight";
       } else {
            bmi_class = "Obese";
       }

       //Age-Dependent Caloric Adjustment
       int calories = 2000;
       if (age < 25) {
            calories += 300;
       } else if (age > 50) {
            calories -= 300;
       }
        //Exercise Recommendation
        String reco = "";
        switch (goal) {
            case 1: //Lose
                if (bmi <= 25) {
                    reco = "Intense cardio and strength training is suggested";
                    calories -= 500;
                } else {
                    reco = "Moderate cardio and light weight training";
                    calories -= 250;
                } break;
            case 2: //Build
                if (exercise_time > 7) {
                    reco = "Heavy weight training with minimal cardio is advised";
                    calories += 500;
                } else {
                    reco = "Moderate weight training with some cardio is recommended";
                    if (exercise_time < 7) {
                        calories -= 250;
                    }
                } break;
            case 3: //Maintain
                break;
            default:
                System.out.println("If you see this something went wrong");
                break;
        }
        //Environment Preference
        String reco_loc = "";
        switch (exercise_place) {
            case 1: //Gym
                reco_loc = "Balanced mix of cardio and weight-training regimes";
                break;
            case 2: //Home
                reco_loc = "Body-weight exercises and yoga";
                break;
            case 3: //Outdoor
                reco_loc = "Running and outdoor activities";
                break;
            default:
                System.out.println("Something went wrong if you see this");
                break;
        }
        //Exercise Intensity
        double water = 2.0; //Daily intake in liters based on Better Health Channel
        switch (exercise_intensity) {
            case 1: //Low
                water += 0.5;
                if (goal == 2) {
                    calories -= 100;
                }
                break;
            case 2: //Moderate
                water += 1;
                if (goal == 2) {
                    calories += 100;
                }
                break;
            case 3: //High
                water += 1.5;
                if (goal == 2) {
                    calories += 200;
                }
                break;
            default:
                System.out.println("Something went wrong if you see this");
                break;
        }
        /*Dietary Conditions 
        restriction,
        1 = None
        2 = Vegan
        3 = Vegetarian
        4 = Pescatarian
        5 = Gluten-free
        6 = Keto*/
        String reco_dietary = "";
        switch (restriction) {
            case 1://None
                reco_dietary = "Focuses on lean meats, fish, whole grains, and vegetables. Also encourages a balance of healthy fats, adequate hydration, and limited" +
                                "processed foods and sugars";
                break;
            case 2://Vegan
                reco_dietary = "Focuses on plant-based proteins, whole grains, ample vegetables, fortified foods to counter possible nutrient deficiencies and plant-based calcium sources";
                break;
            case 3://Vegetarian
                reco_dietary = "Focuses dairy and eggs for protein, whole grains and vegetables, now include recommendations onsourcing B12 either through fortified foods or supplements."+ 
                                "Additionally, providesguidance on getting Omega-3 fatty acids from non-fish sources like walnuts and flaxseeds";
                break;
            case 4://Pescatarian
                reco_dietary = " Focuses on fish as the primary protein source. Recommends fatty fish for Omega-3s, and also includes vegetarian proteins, whole grains, and vegetables";
                break;
            case 5://Gluten-free
                reco_dietary = "Emphasizes foods naturally free from gluten, cautions about potential cross-contamination in manufacturing, and encourages whole, unprocessed foods for"+ 
                                "nutrient adequacy";
                break;
            case 6://Keto
                reco_dietary = "Emphasizes Low carb, highfat dietary recommendation. Focuses on meats, fatty fish, eggs, butter and cream, cheese, nuts and seeds, healthy oils, avocados,"+ 
                                "and low-carb vegetables. Advises against sugar and grains";
                break;
            default:
                System.out.println("Something went wrong if you see this");
                break;
        }

        //Output
        System.out.println("----FitnessCoach's Plan----");
        System.out.printf("BMI: %.2f \t BMI Category: %s %n", bmi, bmi_class);
        System.out.println("Recommended Daily Calories: "+ calories);
        System.out.printf("Recommended Daily Water Intake: %.1f liters %n", water);

        System.out.println("----Exercise Routine Plan----");
        System.out.println("* "+reco);
        System.out.println("* "+reco_loc);

        System.out.println("----Diet Plan----");
        System.out.println("* "+ reco_dietary);
        System.out.println("\n(Please do note that these are general recommendations. For a more precise plan for your health you may consider consulting with certified professionals.)");

        scanner.close();
    }
}
