package z_homework.basket3X3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Player {
	
	//농구 케릭터는 기본적으로 키 ,포지션 ,리바운드능력치, 달리기, 3점능력치, 2점능력치, 블락능력치
	private String name, position;
	private double height;
	private int rebound, threePoint, twoPoint, block, running, money;
	
	//기간제 와 전직을 위한 
	Item[] inven = new Item[2];
	
	public Player(){}// 외부에서 인스턴스 생성 방지


	public Player(String name, String position, double height, int rebound, int threePoint, int twoPoint, int block, int running) {
		this.name = name;
		this.position = position;
		this.height = height;
		this.rebound = rebound;
		this.threePoint = threePoint;
		this.twoPoint = twoPoint;
		this.block = block;
		this.running = running;
		this.setMoney(1000);
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public int getRebound() {
		return rebound;
	}


	public void setRebound(int rebound) {
		this.rebound = rebound;
	}


	public int getThreePoint() {
		return threePoint;
	}


	@Override
	public String toString() {
		return "노말선수";
	}


	public void setThreePoint(int threePoint) {
		this.threePoint += threePoint;
	}


	public int getTwoPoint() {
		return twoPoint;
	}


	public void setTwoPoint(int twoPoint) {
		this.twoPoint += twoPoint;
	}


	public int getBlock() {
		return block;
	}


	public void setBlock(int block) {
		this.block += block;
	}


	public int getRunning() {
		return running;
	}


	public void setRunning(int running) {
		this.running = running;
	}


	public String getName() {
		return name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public int twoPoint(Player p) { // 1 대 1 상대시  
		int score = 0;
		int plus = 0; 
		if(this.getTwoPoint() - p.getBlock() >= 0 ) {// 내가 2점슛 쏠때  들어갈 확률   
			 plus = 5;
			 int rn = new Random().nextInt(3) + plus;
			 if(rn > 5) {
				 score = 2;
			 }
			  else score = 0;
			 }
		 if(this.getTwoPoint() - p.getBlock() < 0) {
			 int rm = new Random().nextInt(4);
			 if(rm > 3) {
				 score = 2;
			 }
			 else score = 0;
		}
		
		return score;
		
	}
	
	public int threePoint(Player p) {
		int score = 0;
		int plus = 0; 
		if(this.getThreePoint() - p.getBlock() >= 0 ) {// 내가 2점슛 쏠때  들어갈 확률   
			 plus = 5;
			 int rn = new Random().nextInt(3) + plus;
			 if(rn > 5) {
				 score = 3;
			 
			 	}
			  else score = 0;
			 }
		 if(this.getThreePoint() - p.getBlock() < 0) {
			 int rm = new Random().nextInt(4);
			 if(rm > 3) {
				 score = 3;
			 }
			 else score = 0;
		}
		
		return score;
	}


	public int attack(Player h) {
		
		System.out.println("=============================================");
		System.out.println("상대방 " + h.getName() + "이 막고 있습니다");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println( h.getName() +" 블락 능력치 : " + h.getBlock());
		System.out.println("내 능력치 :  3점 :" + this.getThreePoint() + "\t2점:" + this.getTwoPoint());
		System.out.println("----------------------------------------------");
		System.out.println("1. 3점슛 쏘기");
		System.out.println("2. 2점슛 쏘기");
		System.out.println("3. 패스  하기 ");
		System.out.println("============================================");
		System.out.print("입력>>");
		
	    int input = ScanUtil.nextInt();
	    int n = 0;
	    
	    switch(input) {
		case 1: 	System.out.print("슛");
					for(int i = 0; i < 2; i++) {
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						}
						System.out.println();
						n = this.threePoint(h);
						if(n == 3) {this.showGoal();}
						else this.miss();
						break;
		case 2:	System.out.print("슛");
				for(int i = 0; i < 2; i++) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
						System.out.print(".");
						} 
					n = this.twoPoint(h);
		 			if(n == 2) {this.showGoal();}
		 			else this.miss();
		 			break;
		case 3: n = this.pass(); break;
	    default : System.out.println("판단을 잘못하여 상대에게 공을 뺏겼습니다."); break;
		
		}
		return n;
	}


	private void miss() {
		// TODO Auto-generated method stub
		System.out.println("                                     __      __     \r\n" + 
				"              __                    /\\ \\    /\\ \\    \r\n" + 
				"  ___ ___    /\\_\\     ____    ____  \\ \\ \\   \\ \\ \\   \r\n" + 
				"/' __` __`\\  \\/\\ \\   /',__\\  /',__\\  \\ \\ \\   \\ \\ \\  \r\n" + 
				"/\\ \\/\\ \\/\\ \\  \\ \\ \\ /\\__, `\\/\\__, `\\  \\ \\_\\   \\ \\_\\ \r\n" + 
				"\\ \\_\\ \\_\\ \\_\\  \\ \\_\\\\/\\____/\\/\\____/   \\/\\_\\   \\/\\_\\\r\n" + 
				" \\/_/\\/_/\\/_/   \\/_/ \\/___/  \\/___/     \\/_/    \\/_/\r\n" + 
				"                                                    \r\n" + 
				"                                                    ");
	}


	private void showGoal() {
		System.out.println("                             ___       __      __      __     \r\n" + 
				"                            /\\_ \\     /\\ \\    /\\ \\    /\\ \\    \r\n" + 
				"   __       ___      __     \\//\\ \\    \\ \\ \\   \\ \\ \\   \\ \\ \\   \r\n" + 
				" /'_ `\\    / __`\\  /'__`\\     \\ \\ \\    \\ \\ \\   \\ \\ \\   \\ \\ \\  \r\n" + 
				"/\\ \\L\\ \\  /\\ \\L\\ \\/\\ \\L\\.\\_    \\_\\ \\_   \\ \\_\\   \\ \\_\\   \\ \\_\\ \r\n" + 
				"\\ \\____ \\ \\ \\____/\\ \\__/.\\_\\   /\\____\\   \\/\\_\\   \\/\\_\\   \\/\\_\\\r\n" + 
				" \\/___L\\ \\ \\/___/  \\/__/\\/_/   \\/____/    \\/_/    \\/_/    \\/_/\r\n" + 
				"   /\\____/                                                    \r\n" + 
				"   \\_/__/                                                     ");
		
	}

	public int pass() {
		System.out.println("                                   \r\n" + 
				"                                   \r\n" + 
				" _____      __       ____    ____  \r\n" + 
				"/\\ '__`\\  /'__`\\    /',__\\  /',__\\ \r\n" + 
				"\\ \\ \\L\\ \\/\\ \\L\\.\\_ /\\__, `\\/\\__, `\\\r\n" + 
				" \\ \\ ,__/\\ \\__/.\\_\\\\/\\____/\\/\\____/\r\n" + 
				"  \\ \\ \\/  \\/__/\\/_/ \\/___/  \\/___/ \r\n" + 
				"   \\ \\_\\                           \r\n" + 
				"    \\/_/  ");
		return 0;
	}

	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money += money;
	}


	public void equipitem(Item item) {
		this.setThreePoint(item.getThreeUp());
		this.setTwoPoint(item.getTwoUp());
		this.setBlock(item.getBlockUp());
		this.setMoneyLeft(item.getCost());
	}


	private void setMoneyLeft(int cost) {
		this.setMoney(-cost);
		
	}


	
	public Player[] check(Player[] room, int input) {
		Player[] a = room; 
		for(int i = 0 ; i < room.length; i++) {
			 if(room[i].getPosition() == this.getPosition()) {
				 room[i] = null;
				 room[i] = this;
				
			 }
			
		 }
		
		return a;
	}


	public int checktoPlay(Player[] room) {
		  int go = 0;
		  for(int i = 0 ; i < room.length; i++) {
			  if(room[i].getName() == this.getName()) {
				   go = 1;
				 
			  }
		  }
		return go;
		
	}


	
	

}
