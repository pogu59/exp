import java.util.*;

public class Vending__Machine {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> coca_cola = new ArrayDeque<>();
    Queue<Integer> pepsi = new ArrayDeque<>();
    Queue<Integer> red_bull = new ArrayDeque<>();
    Queue<Integer> sprite = new ArrayDeque<>();
    int insertCoin = 0;

    //프로그램 시작과 동시 자판기 시작
    public static void main(String[] args) {
        Vending__Machine machine = new Vending__Machine();
            machine.start();//로프를 어디로 걸어야 될지 다시 고민
    }

    public void start() {
        System.out.println("돈을 입력해주세요.");
        int insert = sc.nextInt();
        // 1원을 관리자 선택창으로 만듦
        if (insert == 1) {
            admin();
        } else if (insert >= 500) {
            insertCoin += insert;
            while(true){
                menu();
            }
        }
    }
    public void menu(){
        System.out.println("메뉴를 선택해주세요");
        System.out.println("1.코카 콜라[2100원] 2. 펩시[2000원] 3. 레드불[2200원] 4. 스프라이트[1900원]"); //메뉴 선택
        int menuChoice = sc.nextInt();
        System.out.println("수량을 입력해주세요.");
        int ea = sc.nextInt();

        switch (menuChoice){
            case 1:
                checkOut(coca_cola, ea);
                break;
            case 2:
                checkOut(pepsi, ea);
                break;
            case 3:
                checkOut(red_bull, ea);
                break;
            case 4:
                checkOut(sprite, ea);
                break;
        }

    }
    public void checkOut(Queue<Integer> Queue, int Ea){
        if (Ea > Queue.size()){
            System.out.println("재고가 부족합니다");
        }else if(insertCoin < 0) {
            //잔액 검사
            System.out.println("잔액이 부족합니다.");
        }else if(Ea < Queue.size() && insertCoin >= 0){
            System.out.println("이용해 주셔서 감사합니다.");
        }
    }

    //재고 수량 확인과 입고 등 관리를 위한 코드
    public void admin() {
        System.out.println("관리자 모드");
        System.out.println("1. 수량 확인 2. 입고 3. 시스템 종료");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("[코카콜라: " + coca_cola.size() + "개] [펩시: " + pepsi.size() + "개] [레드불: " + red_bull.size() + "개 [스프라이트: " + sprite.size() + "개]");
                break;
            case 2:
                System.out.println("1. 코카콜라 2. 펩시 3. 레드불 4. 스프라이트");
                int addstock = sc.nextInt();
                System.out.println("수량을 입력해주세요(1~20): ");
                int ea = sc.nextInt();
                switch (addstock) {
                    case 1:
                        addDrink(coca_cola, ea);
                        System.out.println("코카콜라 입고 후 수량" + coca_cola.size() + "개");
                        break;
                    case 2:
                        addDrink(pepsi, ea);
                        System.out.println("펩시 입고 후 수량" + pepsi.size() + "개");
                        break;
                    case 3:
                        addDrink(red_bull, ea);
                        System.out.println("레드불 입고 후 수량" + red_bull.size() + "개");
                        break;
                    case 4:
                        addDrink(sprite, ea);
                        System.out.println("스프라이트 입고 후 수량" + sprite.size() + "개");
                        break;
                }
            case 3:
                System.out.println("시스템을 종료합니다.");
                //명령어를 실행한 후 다시 어드민 화면으로 넘어가는 코드 짜기
        }

    }

    public static void addDrink(Queue<Integer> queue, int stock) {
        for (int i = 1; i <= stock; i++) {
            queue.offer(i);
        }
    }

 }