package project.booksearch;

// 필요한 동작들에 대한 설계하기 위해  --> 추상메소드 사용이유
public interface Controller {
	
	// url 크롤링 --> InfoStore 를 생성하는 메소드 만들기
	// 검색어(search) 를 받아서 . 특정 서점(store) 크롤링 결과를 리턴(InfoStore)
	// 필요하다면, 크롤링 끝나고 수행하는 코드 지정 가능
	
	public abstract InfoStore crawlStore(String search, String bookStore,
			OnCompleteListener completeListener);
	
	// SearchResult --> FILE 로 저장하겠습니다
	public abstract void saveData(String path, SearchResult result);  // 검색결과는 path 에다가 저장하겠다
	
	// FILE --> SearchResult 읽어오기
	public abstract SearchResult loadData(String path); // path 에서부터 읽어들여서 SearchResult 로 복원시키는 인터페이스를 만든 것. 

}

// 크롤링이 완료되면 수행하는 리스너  -> 크롤링이 완료되는 시점을 모르기 때문에 종료될 때 실행하는 코드 설정해놓자.
interface OnCompleteListener{
	public abstract void complete(InfoStore infoStore);
	
	
	
}


























