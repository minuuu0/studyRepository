package org.example.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        MongoClient myclient = new MongoClient();
        MongoDatabase mydb = myclient.getDatabase("mwkimDB");
        MongoCollection<Document> mycol = mydb.getCollection("mwkimCol");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("<< 학생 정보 관리 프로그램 >>");
            System.out.println(" 1) 학생 정보 삽입");
            System.out.println(" 2) 학생 정보 삭제");
            System.out.println(" 3) 학생 정보 수정");
            System.out.println(" 4) 학생 정보 검색 (전체)");
            System.out.println(" 5) 학생 정보 검색 (조건)");
            System.out.println(" 6) 종료");
            System.out.println(" ---------------------");
            System.out.print(" 메뉴 선택 : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    insertStudent(mycol, scanner);
                    break;
                case 2:
                    deleteStudent(mycol, scanner);
                    break;
                case 3:
                    updateStudent(mycol, scanner);
                    break;
                case 4:
                    searchAllStudents(mycol);
                    break;
                case 5:
                    searchStudentsByCondition(mycol, scanner);
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

        myclient.close();
        scanner.close();
    }

    public static void insertStudent(MongoCollection<Document> mycol, Scanner scanner) {
        System.out.print("학생 학번: ");
        String id = scanner.nextLine();
        System.out.print("학생 이름: ");
        String name = scanner.nextLine();
        System.out.print("학생 학과명: ");
        String department = scanner.nextLine();
        System.out.print("학생 학년: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거
        System.out.print("학생 성별: ");
        String gender = scanner.nextLine();
        System.out.print("학생 이메일: ");
        String email = scanner.nextLine();

        List<String> hobbies = new ArrayList<>();
        System.out.println("학생 취미 (종료하려면 'exit' 입력): ");
        while (true) {
            String hobby = scanner.nextLine();
            if (hobby.equalsIgnoreCase("exit")) {
                break;
            }
            hobbies.add(hobby);
        }

        Document student = new Document("id", id)
                .append("name", name)
                .append("department", department)
                .append("year", year)
                .append("gender", gender)
                .append("email", email)
                .append("hobbies", hobbies);
        mycol.insertOne(student);
        System.out.println("학생 정보가 삽입되었습니다.");
    }

    public static void deleteStudent(MongoCollection<Document> mycol, Scanner scanner) {
        System.out.print("삭제할 학생 학번: ");
        String id = scanner.nextLine();

        Document student = mycol.find(Filters.eq("id", id)).first();
        if (student != null) {
            mycol.deleteOne(Filters.eq("id", id));
            System.out.println("학생 정보가 삭제되었습니다.");
        } else {
            System.out.println("해당 학번을 가진 학생이 존재하지 않습니다.");
        }
    }

    public static void updateStudent(MongoCollection<Document> mycol, Scanner scanner) {
        System.out.print("수정할 학생 학번: ");
        String id = scanner.nextLine();

        Document student = mycol.find(Filters.eq("id", id)).first();
        if (student != null) {
            System.out.print("새로운 학년: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            System.out.print("새로운 이메일: ");
            String email = scanner.nextLine();

            List<String> hobbies = new ArrayList<>();
            System.out.println("새로운 취미 (종료하려면 'exit' 입력): ");
            while (true) {
                String hobby = scanner.nextLine();
                if (hobby.equalsIgnoreCase("exit")) {
                    break;
                }
                hobbies.add(hobby);
            }

            Document updatedData = new Document("year", year)
                    .append("email", email)
                    .append("hobbies", hobbies);
            mycol.updateOne(Filters.eq("id", id), new Document("$set", updatedData));
            System.out.println("학생 정보가 수정되었습니다.");
        } else {
            System.out.println("해당 학번을 가진 학생이 존재하지 않습니다.");
        }
    }

    public static void searchAllStudents(MongoCollection<Document> mycol) {
        long studentCount = mycol.countDocuments();
        System.out.println("현재까지 입력된 학생 수: " + studentCount);
        System.out.println("모든 학생 정보:");

        for (Document doc : mycol.find()) {
            System.out.println("학번: " + doc.getString("id"));
            System.out.println("이름: " + doc.getString("name"));
            System.out.println("학과명: " + doc.getString("department"));
            System.out.println("학년: " + doc.getInteger("year"));
            System.out.println("성별: " + doc.getString("gender"));
            System.out.println("이메일: " + doc.getString("email"));
            List<String> hobbies = (List<String>) doc.get("hobbies");
            System.out.println("취미: " + String.join(", ", hobbies));
            System.out.println("----------------------");
        }
    }

    public static void searchStudentsByCondition(MongoCollection<Document> mycol, Scanner scanner) {
        System.out.println("<< 세부 검색 메뉴 >>");
        System.out.println(" 1) 이름으로 검색");
        System.out.println(" 2) 취미로 검색");
        System.out.println(" 3) 이름과 취미로 검색");
        System.out.println(" ---------------------");
        System.out.print("메뉴 선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        Bson filter = null;

        switch (subChoice) {
            case 1:
                System.out.print("검색할 학생 이름: ");
                String name = scanner.nextLine();
                filter = Filters.eq("name", name);
                break;
            case 2:
                System.out.println("검색할 취미를 쉼표로 구분하여 입력 (예: 독서,운동): ");
                String hobbiesInput = scanner.nextLine();
                List<String> hobbies = new ArrayList<>(Arrays.asList(hobbiesInput.split("\\s*,\\s*")));
                filter = Filters.all("hobbies", hobbies);
                break;
            case 3:
                System.out.print("검색할 학생 이름: ");
                name = scanner.nextLine();
                System.out.println("검색할 취미를 쉼표로 구분하여 입력 (예: 독서,운동): ");
                hobbiesInput = scanner.nextLine();
                hobbies = new ArrayList<>(Arrays.asList(hobbiesInput.split("\\s*,\\s*")));
                filter = Filters.and(Filters.eq("name", name), Filters.all("hobbies", hobbies));
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        if (filter != null) {
            for (Document doc : mycol.find(filter)) {
                System.out.println("학번: " + doc.getString("id"));
                System.out.println("이름: " + doc.getString("name"));
                System.out.println("학과명: " + doc.getString("department"));
                System.out.println("학년: " + doc.getInteger("year"));
                System.out.println("성별: " + doc.getString("gender"));
                System.out.println("이메일: " + doc.getString("email"));
                List<String> studentHobbies = (List<String>) doc.get("hobbies");
                System.out.println("취미: " + String.join(", ", studentHobbies));
                System.out.println("----------------------");
            }
        }
    }
}
