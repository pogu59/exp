import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Vending__Machine {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> coca_cola = new ArrayDeque<>();
    Queue<Integer> pepsi = new ArrayDeque<>();
    Queue<Integer> red_bull = new ArrayDeque<>();
    Queue<Integer> sprite = new ArrayDeque<>();
    public static void main(String[] args) {
        Vending__Machine machine = new Vending__Machine();
        machine.start();
    }

    public void start(){
        System.out.println("돈을 입력해주세요.");
        int insert = sc.nextInt();
        if(insert == 1){
            admin();
        }
    }
public void admin(){
    System.out.println("관리자 모드");
    System.out.println("1. 수량 확인 2. 입고 3.구매 화면");
    int choice = sc.nextInt();
    switch(choice){
        case 1:
            System.out.println("[코카콜라: "+coca_cola.size()+"개] [펩시: "+pepsi.size()+"개] [레드불: "+red_bull.size()+"개 [스프라이트: "+sprite.size()+"개]");
            break;
        case 2:
            System.out.println("1. 코카콜라 2. 펩시 3. 레드불 4. 스프라이트");
            int addstock = sc.nextInt();
            System.out.println("수량을 입력해주세요(1~20): ");
            int ea = sc.nextInt();
            switch(addstock){
                case 1:
                    addDrink(coca_cola, ea);
                    System.out.println("코카콜라 입고 후 수량"+coca_cola.size()+"개");
                    admin();
                    break;
                case 2:
                    addDrink(pepsi, ea);
                    System.out.println("펩시 입고 후 수량"+pepsi.size()+"개");
                    admin();
                    break;
                case 3:
                    addDrink(red_bull, ea);
                    System.out.println("레드불 입고 후 수량"+red_bull.size()+"개");
                    admin();
                    break;
                case 4:
                    addDrink(sprite, ea);
                    System.out.println("스프라이트 입고 후 수량"+sprite.size()+"개");
                    admin();
                    break;
            }
        case 3:
            return;
    }

}
    public static void addDrink(Queue<Integer> queue, int stock){
        for (int i = 1; i <= stock; i++) {
            queue.offer(i);
        }
    }

}