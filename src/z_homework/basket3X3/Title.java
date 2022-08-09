package z_homework.basket3X3;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Title {
	
	String[] pos =  {"C", "F", "G", "SC", "SF","PF" ,"SG", "PG"};
	PlayerInitialize a = new PlayerInitialize();  // 상대방 선수들 초기값 
    int input;
    String name;
	Player p = createCharacter(); // 리롤 
	
	public void start() {
		game:
			while(true) {
				System.out.println("================================================");
				System.out.println( ".___  ___.  _______ .__   __.  __    __  \r\n" + 
									"|   \\/   | |   ____||  \\ |  | |  |  |  | \r\n" + 
									"|  \\  /  | |  |__   |   \\|  | |  |  |  | \r\n" + 
								    "|  |\\/|  | |   __|  |  . `  | |  |  |  | \r\n" + 
									"|  |  |  | |  |____ |  |\\   | |  `--'  | \r\n" + 
									"|__|  |__| |_______||__| \\__|  \\______/  \r\n" + 
									"                                         ");
				System.out.println("1. 빠른 매칭      2.방찾기       " );
				System.out.println("3. 내정보         4. 상점         0.종료 ");
				System.out.println("================================================");
				System.out.print("번호 입력>>");
				String input = ScanUtil.nextLine();
				
				clearScreen();
				switch(input) {
				case "1": startMatch(); 
						break; // 빠른 매칭
				
				case "2": searchRoom(); break; // 방찾기 
					
				case "3":    // 내정보 
					showInfo();
					break;
				case "4": new Store().welcome(p); break; // 상점
					
				case "0":  // 종료
					 System.out.println("게임을 종료합니다");
					 break game;
					 
				 default : // 잘 못 입력시 
					 System.out.println("잘못입력하셧습니다.");
					 break;
				}
			}
			
		
	}
	
	private void searchRoom() {  // 방찾기 
		Player[][] room = new Player[5][3];
		
		
		for(int i = 0; i < room.length; i++) {
			   for(int k =0 ; k < room[i].length; k++) {
				  int s = new Random().nextInt(3);
				  int t = new Random().nextInt(11);
				  room[i][k] = a.players[s][t];
			   }
		}
		waiting :
			while(true) {
				System.out.println("=====================대기실=====================");
				System.out.println("내포지션 :" + p.getPosition());
				for(int i = 0; i < room.length; i++) {
					 
					System.out.println(i+1 +"번방 [" + room[i][0].getPosition() + ", " + room[i][1].getPosition() + ", " + room[i][2].getPosition() +"]");
					  
				}
				System.out.println("==================================================");
				System.out.println("나가기 : 0");
				System.out.print("들어갈 방을 누르세요 (포지션에 맞지않으면 들어가지 못합니다) >>");		
				input = ScanUtil.nextInt();
				
				switch(input) {
				case 1: room[input-1] = p.check(room[input -1], input); if(p.checktoPlay(room[input -1]) == 1) { startMatch(room[input -1]);} break waiting;
				case 2: room[input-1] = p.check(room[input -1], input); if(p.checktoPlay(room[input -1]) == 1) { startMatch(room[input -1]);} break waiting;
				case 3: room[input-1] = p.check(room[input -1], input); if(p.checktoPlay(room[input -1]) == 1) { startMatch(room[input -1]);} break waiting;
				case 4: room[input-1] = p.check(room[input -1], input); if(p.checktoPlay(room[input -1]) == 1) { startMatch(room[input -1]);} break waiting;
				case 5: room[input-1] = p.check(room[input -1], input); if(p.checktoPlay(room[input -1]) == 1) { startMatch(room[input -1]);} break waiting;
				case 0: break waiting;
					default : System.out.println("잘못 누르셧습니다");break; 
				}
				
				
			}
		
	
		
	}

	

	private void startMatch(Player[] players) {
	    Player[] away = players;
	    System.out.print("게임 찾는중.");
		for(int i = 0 ; i < 4 ; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		clearScreen();
		
		Player[] home = {a.setPlayer(), a.setPlayer(), a.setPlayer()};
		
		// 홈 어웨이 인터페이스 
		
		System.out.println("==========================HOME=======================================");
		System.out.println();
		for(int i = 0 ; i < home.length; i++) {
			System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", home[i].getName(), home[i].getPosition(), home[i].getThreePoint(),home[i].getTwoPoint(),home[i].getBlock() );
		    System.out.println();
		}
		
		System.out.println();
		System.out.println("                          vs                                ");
		System.out.println();
		System.out.println("==========================AWAY=======================================");
		for(int i = 0 ; i < away.length; i++) {
			if(away[i] == p) {
				System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", away[i].getName(), away[i].getPosition(), away[i].getThreePoint(), away[i].getTwoPoint(), away[i].getBlock() );
			    System.out.println();
			}else {
				System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", away[i].getName(), away[i].getPosition(), away[i].getThreePoint(), away[i].getTwoPoint(), away[i].getBlock() );
			    System.out.println();
			}
			
		}
		System.out.println();
		System.out.print("게임을 시작하겠습니까?(Y/N)");
		String input = ScanUtil.nextLine();
		clearScreen();
		 if(input.equals("Y") || input.equals("y")) {
			 inGame(away,home);
		 }else System.out.println("도망갑니다");
			 
		
	    
		
	}

	private void startMatch() { //  빠른 매칭 
		System.out.print("게임 찾는중.");
		for(int i = 0 ; i < 4 ; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		clearScreen();
		
		
		Player[] away = {p, a.setPlayer(), a.setPlayer()};
		Player[] home = {a.setPlayer(), a.setPlayer(), a.setPlayer()};
		
		// 홈 어웨이 인터페이스 
		
		System.out.println("==========================HOME=======================================");
		System.out.println();
		for(int i = 0 ; i < home.length; i++) {
			System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", home[i].getName(), home[i].getPosition(), home[i].getThreePoint(),home[i].getTwoPoint(),home[i].getBlock() );
		    System.out.println();
		}
		
		System.out.println();
		System.out.println("                          vs                                ");
		System.out.println();
		System.out.println("==========================AWAY=======================================");
		for(int i = 0 ; i < away.length; i++) {
			if(away[i] == p) {
				System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", away[i].getName(), away[i].getPosition(), away[i].getThreePoint(), away[i].getTwoPoint(), away[i].getBlock() );
			    System.out.println();
			}else {
				System.out.printf("선수 : %s  포지션 :  %2s\t3점 : %d   2점 : %d  블락 : %d ", away[i].getName(), away[i].getPosition(), away[i].getThreePoint(), away[i].getTwoPoint(), away[i].getBlock() );
			    System.out.println();
			}
			
		}
		System.out.println();
		System.out.print("게임을 시작하겠습니까?(Y/N)");
		String input = ScanUtil.nextLine();
		clearScreen();
		 if(input.equals("Y") || input.equals("y")) {
			 inGame(away,home);
		 }else System.out.println("도망갑니다");
			 
		
		
		
	}

	

	

	private void inGame(Player[] away, Player[] home) { //게임 
		
		int count = 0;
		int awayScore = 0, homeScore = 0;
		
		ingame: 
			while(true) {
				System.out.print("게임중");
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
					
						
				Player a = away[new Random().nextInt(3)];
				Player h = home[new Random().nextInt(3)];
				
				int input = new Random().nextInt(4);
		
				
				// 플레이어에게 찬스가 왔을 때 
				if(a == p){
					System.out.println("======================현재 스코어============================");
					  System.out.println("[홈팀 : " + homeScore + "]" + "[우리팀 : " + awayScore + "]" );	
					  
					  awayScore += a.attack(h);  //내가 공격할 때
				} // a== p end
				
				
				
			    //내가 아닐 때 
				switch(input) {
				case 0: awayScore += a.threePoint(h); break;  
				case 1:	awayScore += a.twoPoint(h);   break; 
				case 2: homeScore += h.threePoint(a); break; 
				case 3:	homeScore += h.twoPoint(a);   break;  
			
				}
				
				count += 2;
				
				if(count == 20) {
					clearScreen();
					System.out.println("  ============최종 점수=============== ");
					System.out.println("[홈팀 : " + homeScore + "]\t" + "[어웨이팀 : " + awayScore + "]" );
					if(awayScore > homeScore) {
						System.out.println("승리하셔서 100원을 획득합니다");
						p.setMoney(100);
					}
					else {
						System.out.println("패배!");
					}
					
					break ingame; 
				} // if(count) end
				
			} //loop end 
		
	} // ingame() end
	

	private void showInfo() {
		System.out.println("=============================================================");
		System.out.println(" 이름 :" + p.getName());
		System.out.println(" 포지션 :" + p.getPosition());
		System.out.println(" 리바운드 :" + p.getRebound());
		System.out.println(" 3점슛 :" + p.getThreePoint());
		System.out.println(" 2점슛 :" + p.getTwoPoint() );
		System.out.println(" 달리기:" + p.getRunning());
		System.out.println(" 블록 :" + p.getBlock());
		System.out.println(" 선수특징 :" + p.toString());
		System.out.println("==============================================================");
		System.out.println("현재 돈 :" + p.getMoney());
		System.out.print("나가기 : 엔터  ");
		@SuppressWarnings("unused")
		String input = ScanUtil.nextLine();
		clearScreen();
		
	}

	public Player createCharacter() { // 케릭터 초기 생성 
		System.out.println("=====================포지션 선택========================");
		System.out.println("원하는 포지션을 선택해주세요");
		System.out.println("1.센터     2.포워드       3.가드");
		System.out.print("입력>>");
		input = ScanUtil.nextInt();
		System.out.print("생성할 이름: ");
		name = ScanUtil.nextLine();
		System.out.println("======================================================");
		System.out.println("능력치 랜덤 주사위 시작"); 
			
		int count = 3 ;	
		Random rn = new Random();	
		int[] ability = new int[5];	
		double height = 0;
		while(count >= 0) {
				
				double height1 = rn.nextInt(10) + 190;
				height = height1;
				for(int i = 0; i < ability.length; i++) {
					ability[i] = rn.nextInt(50) + 40;
				}
				
				System.out.println("랜덤 능력치");
				System.out.println("============================================");
				System.out.println("키:" + height1);
				System.out.println("리바운드:"+ ability[0] );
				System.out.println("블락:" + ability[1]);
				System.out.println("2점슛:"+ ability[2] );
				System.out.println("3점슛:"+ ability[3] );
				System.out.println("달리기:"+ ability[4] );
				System.out.println("다시 돌리시겠습니까?(y/n)  기회 : " + count);
				System.out.println("============================================");
				String input = ScanUtil.nextLine();
				if(input.equals("y") || input.equals("Y")) {
					count--;
					if(count == 0) {
						System.out.println("리롤을 다하셧습니다 케릭터 생성완료");
						clearScreen();
						break;
					}
				}	
				else {
					System.out.println("케릭터 생성완료");
					clearScreen();
				     break;
					}
					
				}
				
		 	  Player myPlayer = new Player(name, pos[input-1], height, ability[0], ability[1], ability[2], ability[3], ability[4]);
		 	  return myPlayer;
	
		} // createCharacter
		
			public static void clearScreen() {  // 콘솔창 지저분한거 clear
				for(int i = 0 ; i < 100; i++) {
						System.out.println();
					}
				}
	} // title

	

				
  


