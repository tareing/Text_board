import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class Text {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sdf.format(now);
        System.out.println(nowTime);
        Scanner scan = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>(); // 여기 하나 밖에 저장을 못하는게 문제
//        ArrayList<String> contents = new ArrayList<>();
        ArrayList<Article> articles = new ArrayList<>();
        int lastArticleId = 1;


        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = scan.nextLine();

                Article article = new Article(lastArticleId, title, content);
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;
            } else if (command.equals("list")) {
                System.out.println("==================");
                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());


                    System.out.println("==================");
                }
            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();


                scan.nextLine();

                boolean isExist = false;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    if (targetId == article.getId()) {
                        System.out.print("제목 : ");
                        String newTitle = scan.nextLine();
                        System.out.print("내용 : ");
                        String newContent = scan.nextLine();

                        Article newArticle = new Article(targetId, newTitle, newContent);
                        articles.set(i, newArticle);

                        System.out.println("수정이 완료되었습니다.");
                        isExist = true;
                    }
                }

                if (isExist == false) {
                    System.out.println("없는 게시물입니다.");
                }


            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                boolean isExist = false;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    if (targetId == article.getId()) {
                        articles.remove(i);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetId);
                        isExist = true;
                    }
                }

                if (isExist == false) {
                    System.out.println("없는 게시물입니다.");
                }
            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 :");

                int targetId = scan.nextInt();

                scan.nextLine();
                if (targetId >= 0 && targetId <= articles.size()) {
                    Article article = articles.get(targetId - 1);
                    System.out.println("게시물 상세 제목 :" + article.getTitle());
                    System.out.println("게시물 상세 내용 :" + article.getContent());
                    System.out.println("현재날짜시간" + nowTime);
                    article.setViews();
                    System.out.println("조회수" + article.getViews());
                }
                while (true) {
                    System.out.println("1. 댓글 등록, 2. 추천, 3. 수정, 4.삭제, 5.목록으로");
                    int detaCommand = scan.nextInt();
                    scan.nextLine();

                    switch (detaCommand) {
                        case 1:


                            break;
                        case 2:


                            break;
                        case 3:


                            break;
                        case 4:


                            break;

                        case 5:

                            System.out.println("메인 메뉴로 돌아갑니다.");
                            break;
                        default:
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    }
                    if (detaCommand == 5) {
                        break;
                    } else {
                        System.out.println("존재하지 않는 게시물 번호입니다.");
                    }

                }
            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 :");
                String ketword = scan.nextLine();

                System.out.println("검색결과");
                System.out.println("==========================");

                boolean found = false;
                for (Article article : articles) {

                    if (article.getTitle().contains(ketword)) {
                        System.out.println("게시물 번호" + article.getId());
                        System.out.println("게시물 제목" + article.getTitle());
                        System.out.println("게시물 내용" + article.getContent());
                        found = true;
                    }
                    if (!found) {
                        System.out.println("검색 결과가 없습니다");
                    }
                }
            }
        }
    }
}