package z_homework.basket3X3;

public class Store {
	Item[] items = new Item[6];
	int input;
	
	
	Store() {
		
		items[0] = new Item(1, 0, 0, "3점 드링크(3점 + 1)",300);
		items[1] = new Item(0, 1, 0, "2점 홍삼(2점 + 1)", 300);
		items[2] = new Item(0, 0, 1, "블락 초코바(블락 + 1)",300);
		items[3] = new Item(2, 0, 0, "3점 드링크(3점 + 2)", 600);
		items[4] = new Item(0, 2, 0, "2점 홍삼(2점 + 2)", 600);
		items[5] = new Item(0, 0, 2, "블락 초코바(블락 + 2)",600);
	
		
		
		
	
	}



	public void welcome(Player p) {
		shop:
		while(true) {
			System.out.println("========================상점==============================");
			for(int i = 0 ; i < items.length; i++) {
				System.out.printf("[%d] %s  가격 %d", i+1, items[i].getName(), items[i].getCost());
				System.out.println();
				
			}
			System.out.println("=======================================================");
			System.out.println("나가기 : 0 " );
			System.out.println("현재 가지고 있는 돈 :" + p.getMoney() );
			System.out.print("구매하실 아이탬을 누르세요 >>");
			input = ScanUtil.nextInt();
			switch(input) {
			case 1: buy(p, items[input - 1]); break;
			case 2: buy(p, items[input - 1]); break;
			case 3: buy(p, items[input - 1]); break;
			case 4: buy(p, items[input - 1]); break;
			case 5: buy(p, items[input - 1]); break;
			case 6: buy(p, items[input - 1]); break;
			case 0: break shop;
			default : break;
			
			}
			
		}
	
		
	}

 



	private void buy(Player p, Item item) {
		// TODO Auto-generated method stub
		if(p.getMoney() >= items[input-1].getCost()) {
			p.equipitem(items[input-1]);
			Title.clearScreen();
			System.out.println("아이탬을 구매하여 능력치가 상승 !");
		}
		else if(p.getMoney() <= 0 || p.getMoney() < items[input -1].getCost()) {
			Title.clearScreen();
			System.out.println("돈이 부족하여 구매 불가 ");
		}
	}
	
	
}
