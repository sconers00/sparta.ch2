import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int num1, num2, mark;
        float result;
        String arithmetic, question;
        Scanner sc = new Scanner(System.in);
        while (true) {
            //입력기
            System.out.print("1번째 정수를 입력해 주세요 ");
            num1 = sc.nextInt();
            sc.nextLine();
            System.out.print("2번째 정수를 입력해 주세요 : ");
            num2 = sc.nextInt();
            sc.nextLine();
            System.out.print("다음중 원하는 연산기호를 입력해 주세요 : +, -, *, /");
            arithmetic = sc.nextLine();
            //연산기호 전환
            if (arithmetic.equals("+")) {
                mark = 1;
            } else if (arithmetic.equals("-")) {
                mark = 2;
            } else if (arithmetic.equals("*")) {
                mark = 3;
            } else if (arithmetic.equals("/")) {
                mark = 4;
            } else {
                System.out.println("연산기호가 아닙니다.");
                continue;
            }
            //계산
            switch (mark) {
                case 1:
                    result = num1 + num2;
                    System.out.println("결과 : " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("결과 : " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("결과 : " + result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = (float)num1 / num2;
                        System.out.println("결과 : " + result);
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
            }
            System.out.println("계산 종료를 원하시면 exit 을 입력해 주십시오.");
            question = sc.nextLine();
            if (question.equals("exit")) {
                break;
            }
        }
    }
}
// lv1 완성햇으니 이걸 베이스로 lv2 랑 lv3도 만들것...... 기한은 앞으로 8일