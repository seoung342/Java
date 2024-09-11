package mvjsp.chap17.board.service;

public class DeleteRequest {
	
	private int articleId;
	private String password;
	
	public DeleteRequest(int articleId, String password) {
		this.articleId = articleId;
		this.password = password;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
