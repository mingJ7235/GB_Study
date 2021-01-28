package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import vo.BoxOfficeVo;

public class BoxOfficeDao {
	
	//private 추가 (랭킹이 전달되지 않았을 때)
	private boolean append(BoxOfficeVo film) throws IOException {
		
		//외부에서 전달된 영화 정보가 없을 때 
		if(film == null) {return false;}
		
		//랭킹을 가져오는 것
		BufferedReader br = DBConnecter.getReader(); //null인지 판단해야함
		//해당 경로에 읽어올 파일이 없을때
		if(br==null) {return false;}
		
		//메모장 각 줄(라인) 문자열을 저장할 변수
		String line = null;
		
		//마지막 랭킹 번호를 저장할 변수
		int lastRanking = 0;
		
		//while문 종료 시 lastRanking에는 마지막 영화 순위가 저장된다. 500회면 500회까지 증가하여 마지막 랭킹을 구하는 것이다.  
		while((line = br.readLine()) != null) {
			//마지막 랭킹을 알아야 한다.
			lastRanking++ ; //마지막 순위가 담기게됨
		}
		br.close();
		
		//텍스트 파일에서 각 컬럼의 구분은 \t로 구성되어 있다. 
		//파일의 가장 마지막 문자가 \n인지 검사 (readAllBytes() 사용)
		
		String contents = new String (Files.readAllBytes(Paths.get(DBConnecter.getPath()))); //메모장 전체내용을 다 가지고옴
		
		//메모장 양식에 맞춰서 추가할 요소를 담아 줄 임시 저장공간
		String temp = ""; 
		
		//문자 배열의 인덱스에 접근함
		//가장 마지막에 줄바꿈이 있는지 검사하기 위해서 하는 것임. 
		//contents.length()는 전체의 길이인데 여기서 -1을 빼줘야 마지막 배열의 값에 찾아가는것임
		if(contents.charAt(contents.length() -1 ) != '\n') { //마지막 방. \n인지 검사
			//줄바꿈이 없다면 \n을 추가하고 시작한다. 왜냐? 새롭게 밑에 추가해야하니까!
			temp += "\n";
		}
		
		//새롭게 추가될 영화순위는 마지막 순위 +1이 된다. 
		temp += lastRanking + 1 + "\t"
				+ film.getFilmName() + "\t"
				+ film.getReleaseDate() +"\t"
				+ film.getIncome() + "\t"
				+ film.getGuestCnt() + "\t"
				+ film.getScreenCnt() + "\n"; //마지막 \n은 추가해도되고 빼도 된다. 
		
		BufferedWriter bw = DBConnecter.getAppend(); //이어 쓸 준비
		bw.write(temp);
		bw.close();
		
		return true;
	}
	
	
	
	//private 삽입 (랭킹이 전달되었을 때)
	private boolean insert(BoxOfficeVo film) throws IOException {
		if(film == null) {return false;}
		
		int newRanking = film.getRanking(); //삽입은 랭킹이 전달되었다고 가정하고 구현하는 것임.
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		String temp = "";
		boolean check = false;
		
		while ( (line = br.readLine()) != null ) {
			//한줄씩 불러온건 원본, newRanking은 신규 
			
			//삽입할 순위를 기존 데이터와 비교
			//각각의 모든 영화의 순위를 불러와서 new Ranking과 비교
			if (Integer.parseInt(line.split("\t")[0]) == newRanking) {
				temp += film.getRanking() + "\t"
					+ film.getFilmName() + "\t"
					+ film.getReleaseDate() +"\t"
					+ film.getIncome() + "\t"
					+ film.getGuestCnt() + "\t"
					+ film.getScreenCnt() + "\n";
				//이걸 film의 toString을 재정의해서 가져오면 temp += film으로 할수있음. (나중에할것)
				
				check = true;
			}
			if (check) {
				//삽입 후 나머지 랭킹에 모두 +1을 하여 수정해준다. 
				temp += ++newRanking + line.substring(line.indexOf("\t")) + "\n"; //readline은 줄바꿈을 안가져오므로 "\n"해야함
			}else { //삽입이 안된경우
				//삽입 전에는 순위를 그대로 유지해야 한다. 
				temp += line + "\n";
			}
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
		
		return true;
	}
	
	
	
	
	
	//INSERT
	//추가와 삽입을 메소드 하나에 넣기 -> 랭킹을 전달하느냐 않느냐를 기준으로 메소드를 구분  
	public boolean insertOrAppend(BoxOfficeVo film) throws IOException{
		//랭킹 유무 판단
		if(film.getRanking() == 0) {
			//추가 
		}else {
			//삽입
		}
		
		return false;
	}
	
	//수정
	
	//삭제
	
	//검색
	
	//목록

}
