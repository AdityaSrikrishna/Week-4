import java.io.*;
import java.util.Scanner;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Writing student data to file
        try (
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.print("How many students? ");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");
                System.out.print("Roll Number: ");
                int roll = Integer.parseInt(scanner.nextLine());

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("GPA: ");
                double gpa = Double.parseDouble(scanner.nextLine());

                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }

            System.out.println("\nStudent details written to '" + fileName + "'.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading student data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student details from file:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
