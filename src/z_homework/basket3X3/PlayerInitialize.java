package z_homework.basket3X3;

import java.util.Random;

public class PlayerInitialize {
	

    Player[][] players = new Player[3][11]; // 포지션별 선수 모음 
    
	PlayerInitialize() {

		//수정 사항                                키  리바 삼점 2점 블락 달리기
		players[0][0] = new Player("함진호", "C", 200.0, 85, 56, 67, 67, 55);
		players[0][1] = new Player("이지후", "C", 200.0, 82, 54, 54, 53, 55);
		players[0][2] = new Player("김법쿠", "C", 204.0, 79, 57, 55, 62, 55);
		players[0][3] = new Player("신수주", "C", 211.0, 88, 56, 59, 66, 55);
		players[0][4] = new Player("부가치", "C", 200.0, 81, 34, 52, 68, 55);
		players[0][5] = new Player("수비초","SC", 197.0, 85, 50, 61, 61, 55);
		players[0][6] = new Player("가비지", "C", 203.0, 77, 40, 59, 62, 55);
		players[0][7] = new Player("순대가", "SC", 201.0, 82, 51, 65, 59, 55);
		players[0][8] = new SpecialPlayer("리바왕", "C", 202.0, 90, 59, 55, 65, 55);
		players[0][9] = new SpecialPlayer("거미손", "C", 204.0, 89, 54, 51, 75, 55);
		players[0][10] = new SpecialPlayer("화이팅","SC", 203.0, 82, 60, 67, 60, 55);
		
		players[1][0] = new Player("박호박", "F", 198.4, 66, 62, 58, 59, 62);
		players[1][1] = new Player("김순대", "F", 198.4, 66, 50, 56, 55, 62);
		players[1][2] = new Player("지진쿠", "PF", 198.4, 66, 42, 76, 50, 62);
		players[1][3] = new Player("암행어", "PF", 198.4, 66, 52, 70, 52, 62);
		players[1][4] = new Player("대한민", "SF", 198.4, 66, 52, 85, 51, 62);
		players[1][5] = new Player("JOHNS", "SF", 198.4, 66, 52, 83, 52, 62);
		players[1][6]= new Player("최수", "PF", 198.4, 66, 52, 86, 76, 62);
		players[1][7] = new Player("이인후", "SF", 198.4, 66, 62, 66, 53, 62);
		players[1][8] = new SpecialPlayer("덩크왕", "PF", 198.4, 86, 42, 66, 57, 62);
		players[1][9] = new SpecialPlayer("고물상", "PF", 198.4, 86, 52, 66, 57, 62);
		players[1][10] = new SpecialPlayer("다들가", "SF", 198.4, 56, 52, 66, 57, 62);
	
		players[2][0] = new Player("호랭이", "G", 182.4, 30, 68, 71, 42, 89);
		players[2][1]= new Player("박박", "SG", 182.4, 32, 71, 70, 62, 89);
		players[2][2]= new Player("진후", "SG", 182.4, 32, 77, 81, 42, 89);
		players[2][3] = new Player("순삭패", "PG", 182.4, 32, 57, 71, 42, 89);
		players[2][4]= new Player("포카리", "PG", 182.4, 32, 67, 71, 32, 89);
		players[2][5] = new Player("화이바", "PG", 182.4, 32, 62, 69, 32, 89);
		players[2][6] = new Player("나훈아", "G", 182.4, 32, 76, 71, 42, 89);
		players[2][7]= new Player("김진", "G", 182.4, 32, 67, 54, 22, 89);
		players[2][8] = new SpecialPlayer("지크", "SG", 182.4, 32, 87, 73, 22, 89);
		players[2][9]= new SpecialPlayer("오공", "SG", 182.4, 32, 84, 72, 22, 89);
		players[2][10] = new SpecialPlayer("삼점왕", "SG", 182.4, 32, 85, 74, 22, 89);
		
		
		
		
	
		
	}
	
	public Player setPlayer() {
		int rn = new Random().nextInt(3);
		int rn2 =  new Random().nextInt(11);
		Player p = players[rn][rn2];
		
		return p;
	}
	
	
	
}
