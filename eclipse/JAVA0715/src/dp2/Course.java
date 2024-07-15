package dp2;

import java.util.Vector;

public class Course {
	private Vector<Transcript> transcripts;
	private String name;
	private int numOfStudent = 0;
	
	public Course(String name) {
		this.name = name;
		this.transcripts = new Vector<Transcript>();
	}
	

	public Vector<Transcript> getTranscripts() {
		return transcripts;
	}

	public void setTranscripts(Vector<Transcript> transcripts) {
		this.transcripts = transcripts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [transcripts=" + transcripts + ", name=" + name + ", numOfStudent=" + numOfStudent + "]";
	}

	
	
}
