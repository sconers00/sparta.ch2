import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class Calculator {
    public int[] getinput(int[] arr) {
        Scanner sc2 = new Scanner(System.in);
        String arithmetic;

        for (int i = 0; i < 3; i++) {//이전기록 제거용
            arr[i] = 0;
        }
//오류발생가능-입력타입 불일치
        System.out.println("1번째 정수를 입력해 주세요 : ");
        arr[0] = sc2.nextInt();
        sc2.nextLine();
        System.out.println("2번째 정수를 입력해 주세요 : ");
        arr[1] = sc2.nextInt();
        sc2.nextLine();
        System.out.println("다음중 원하는 연산기호를 입력해 주세요 +, -, *, / : ");
        arithmetic = sc2.nextLine();
        switch (arithmetic) {
            case "+" -> arr[2] = 1;
            case "-" -> arr[2] = 2;
            case "*" -> arr[2] = 3;
            case "/" -> arr[2] = 4;
            default -> {
                arr[2] = 0;
                System.out.println("연산기호가 아닙니다.\n프로그램을 재시작합니다.\n");
            }
        }
        return arr;
    }

    public int[] calculate(int[] arr) {
        int[] arrs = new int[3]; // result,rest,divider
        switch (arr[2]) {
            case 1:
                arrs[0] = arr[0] + arr[1];
                break;
            case 2:
                arrs[0] = arr[0] - arr[1];
                break;
            case 3:
                arrs[0] = arr[0] * arr[1];
                break;
            case 4: //오류발생가능 - div0산술오류
                if (arr[1] != 0) {
                    arrs[0] = arr[0] / arr[1];
                    arrs[1] = arr[0] % arr[1];
                    arrs[2] = arr[1];
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
        }
        return arrs;
    }

    private ArrayList<Double> resultmemory = new ArrayList<>();

    public void getResultMemory() {
        System.out.println(resultmemory);
    }

    public void addResultMemory(double result) {
        resultmemory.add(result);
        System.out.println("계산결과 : " + resultmemory.getLast());
    }

    public void deleteFirstResult() {
        resultmemory.removeFirst();
    }
}

public class App {
    public static void main(String[] args) {
        double result;
        String question;
        int[] arr = new int[3];
        Scanner sc1 = new Scanner(System.in);
        Calculator reciever = new Calculator();
        st:
        while (true) {
            //입력기
            arr = reciever.getinput(arr);
            if (arr[2] == 0) {  //기호입력 잘못됫을때 재시작용
                continue;
            }
            //계산결과종합기
            arr = reciever.calculate(arr);
            if (arr[1] != 0) {
                result = (double) (arr[0] * arr[2] + arr[1]) / arr[2];
            } else {
                result = arr[0];
            }
            reciever.addResultMemory(result);
            System.out.println("계산 종료를 원하시면 exit 을 입력해 주십시오.\n계산결과 기록을 보시려면 memory 를 입력해주십시오.\n다른 계산을 원하시면 아무값이나 입력해주십시오.");
            question = sc1.nextLine();
            if (question.equals("exit")) {
                break;
            } else if (question.equals("memory")) {
                while (true) {
                    System.out.println("작업을 선택하여 주십시오.\n1. 계산 기록 열람\n2. 가장 오래된 기록 제거\n3. 계산기로 돌아가기\n4. 종료");
                    question = sc1.nextLine();
                    switch (parseInt(question)) {
                        case 1:
                            reciever.getResultMemory();
                            continue;
                        case 2:
                            reciever.deleteFirstResult();
                            continue;
                        case 3:
                            continue st;
                        case 4:
                            break st;
                    }
                }
            } else {
                System.out.println("재기동합니다\n");
            }
        }
    }
}
// lv1 완성햇으니 이걸 베이스로 lv2 랑 lv3도 만들것...... 기한은 앞으로 8일