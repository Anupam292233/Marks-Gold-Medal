import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String gender;
    String rollNo;
    int englishMarks;
    int mathsMarks;
    int physicsMarks;
    int chemistryMarks;
    int biologyMarks;
    String status;

    public Student(String name, String gender, String rollNo, int englishMarks, int mathsMarks, int physicsMarks,
                   int chemistryMarks, int biologyMarks, String status) {
        this.name = name;
        this.gender = gender;
        this.rollNo = rollNo;
        this.englishMarks = englishMarks;
        this.mathsMarks = mathsMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.biologyMarks = biologyMarks;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public int getBiologyMarks() {
        return biologyMarks;
    }

    public String getStatus() {
        return status;
    }

	public int getTotalMarks() {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class StudentDetails {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Marks.txt");

        ArrayList<Student> students = new ArrayList<>();

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] parts = data.split(",");

            String name = parts[0];
            String gender = parts[1];
            String rollNo = parts[2];

            String[] englishMarksParts = parts[3].split(":");
            int englishMarks = Integer.parseInt(englishMarksParts[1]);

            String[] mathsMarksParts = parts[4].split(":");
            int mathsMarks = Integer.parseInt(mathsMarksParts[1]);

            String[] physicsMarksParts = parts[5].split(":");
            int physicsMarks = Integer.parseInt(physicsMarksParts[1]);

            String[] chemistryMarksParts = parts[6].split(":");
            int chemistryMarks = Integer.parseInt(chemistryMarksParts[1]);

            String[] biologyMarksParts = parts[7].split(":");
            int biologyMarks = Integer.parseInt(biologyMarksParts[1]);

            String status = parts[8];

            Student student = new Student(name, gender, rollNo, englishMarks, mathsMarks, physicsMarks,
                    chemistryMarks, biologyMarks, status);
            students.add(student);
        }

        scan.close(); // Closing the scanner

        // Print student details
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("English Marks: " + student.getEnglishMarks());
            System.out.println("Maths Marks: " + student.getMathsMarks());
            System.out.println("Physics Marks: " + student.getPhysicsMarks());
            System.out.println("Chemistry Marks: " + student.getChemistryMarks());
            System.out.println("Biology Marks: " + student.getBiologyMarks());
            System.out.println("Status: " + student.getStatus());
            System.out.println();
        }

        // Find the toppers in each subject
        int maxEnglishMarks = Integer.MIN_VALUE;
        int maxMathsMarks = Integer.MIN_VALUE;
        int maxPhysicsMarks = Integer.MIN_VALUE;
        int maxChemistryMarks = Integer.MIN_VALUE;
        int maxBiologyMarks = Integer.MIN_VALUE;

        String englishTopper = "";
        String mathsTopper = "";
        String physicsTopper = "";
        String chemistryTopper = "";
        String biologyTopper = "";

        for (Student student : students) {
            // Find the topper in English
            if (student.getEnglishMarks() > maxEnglishMarks) {
                maxEnglishMarks = student.getEnglishMarks();
                englishTopper = student.getName();
            }

            // Find the topper in Maths
            if (student.getMathsMarks() > maxMathsMarks) {
                maxMathsMarks = student.getMathsMarks();
                mathsTopper = student.getName();
            }

            // Find the topper in Physics
            if (student.getPhysicsMarks() > maxPhysicsMarks) {
                maxPhysicsMarks = student.getPhysicsMarks();
                physicsTopper = student.getName();
            }

            // Find the topper in Chemistry
            if (student.getChemistryMarks() > maxChemistryMarks) {
                maxChemistryMarks = student.getChemistryMarks();
                chemistryTopper = student.getName();
            }

            // Find the topper in Biology
            if (student.getBiologyMarks() > maxBiologyMarks) {
                maxBiologyMarks = student.getBiologyMarks();
                biologyTopper = student.getName();
            }
        }

        // Find the student with the highest total marks (Gold Medalist)
        int maxTotalMarks = Integer.MIN_VALUE;
        String goldMedalist = "";

        for (Student student : students) {
            int totalMarks = student.getTotalMarks();
            if (totalMarks > maxTotalMarks) {
                maxTotalMarks = totalMarks;
                goldMedalist = student.getName();
            }
        }

        // Print the toppers in each subject
        System.out.println("Toppers in each subject:");
        System.out.println("English Topper: " + englishTopper);
        System.out.println("Maths Topper: " + mathsTopper);
        System.out.println("Physics Topper: " + physicsTopper);
        System.out.println("Chemistry Topper: " + chemistryTopper);
        System.out.println("Biology Topper: " + biologyTopper);
        System.out.println();

        // Print the Gold Medalist
        System.out.println("Gold Medalist: " + goldMedalist);
    }
    }
