package mvjsp.chap17.board.service;

public class ReplyingRequest extends WritingRequest {

	public ReplyingRequest(int parentArticleId, String writerName, String password, String title, String content) {
		super(writerName, password, title, content);
		this.parentArticleId = parentArticleId;
		// TODO Auto-generated constructor stub
	}
	private int parentArticleId;

	public int getParentArticleId() {
		return parentArticleId;
	}
	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}
	
}
