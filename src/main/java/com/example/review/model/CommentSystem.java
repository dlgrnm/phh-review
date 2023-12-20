package com.example.review.model;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommentSystem {
    private Map<String, Comment> commentIdMap;

    public CommentSystem() {
        commentIdMap = new HashMap<>();
    }
    public String getEmotionFromLabel(String label) {
        if (label.equalsIgnoreCase("exited")) {
            return "😐";
        } else if (label.equalsIgnoreCase("normal")) {
            return "😊";
        } else if (label.equalsIgnoreCase("disappointed")) {
            return "😞";
        } else {
            return "😐"; // Default emoji
        }
    }
    public void addComment(String userId, String commentText) {
        String commentId = generateCommentId(userId);
        Comment comment = new Comment(userId, commentText, commentId, new Date());
        commentIdMap.put(commentId, comment);
    }

    public void printAllComments() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Map.Entry<String, Comment> entry : commentIdMap.entrySet()) {
            Comment comment = entry.getValue();
            System.out.println(comment.getCommentId() + ": " + comment.getCommentText() +
                    " (Оруулсан: " + comment.getUserId() + ") "+
                    " - Оруулсан огноо: " + dateFormat.format(comment.getCommentDate()) );
        }
    }

    private String generateCommentId(String userId) {
        return userId + "_" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        CommentSystem commentSystem = new CommentSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Мөнө:");
            System.out.println("1. Коммент нэмэх");
            System.out.println("2. Бүх Комментыг харах");
            System.out.println("3. Эможи үлдээх");
            System.out.println("4. Гарах");
            System.out.print("Таны сонголтыг оруулна уу: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Таны хэрэглэгчийн ID-г оруулна уу: ");
                    String userId = scanner.nextLine();
                    System.out.print("Таны комментыг оруулна уу: ");
                    String commentText = scanner.nextLine();
                    commentSystem.addComment(userId, commentText);
                    break;
                case 2:
                    commentSystem.printAllComments();
                    break;
                // Previous code
                case 3:
                    System.out.println("3.1. exited");
                    System.out.println("3.2. normal");
                    System.out.println("3.3. disappointed");
                    System.out.print("Эможи сонгоно уу (хэрэглэгчийн хариулт оруулна уу): ");
                    int emotionChoice = scanner.nextInt();
                    System.out.print("Таны хэрэглэгчийн ID-г оруулна уу: ");
                    String userId1 = scanner.nextLine();

                    switch (emotionChoice) {
                        case 1:
                            commentSystem.addComment(userId1, commentSystem.getEmotionFromLabel("exited"));
                            break;
                        case 2:
                            commentSystem.addComment(userId1, commentSystem.getEmotionFromLabel("normal"));
                            break;
                        case 3:
                            commentSystem.addComment(userId1, commentSystem.getEmotionFromLabel("disappointed"));
                            break;
                        default:
                            System.out.println("Буруу сонголт. Дахин оролдоно уу.");
                    }
                    break;



                case 4:
                    System.out.println("Програмаас гарлаа. Баярлалаа!");
                    System.exit(0);
                default:
                    System.out.println("Буруу сонголт. Дахин оролдоно уу.");
            }
        }
    }
}