package dp2;

import java.util.Vector;

public class Student {
	private Vector<Transcript> transcripts;
	private String name;
	
	public Student() {	}
	
	public Student(String name) {
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
		return "Student [transcripts=" + transcripts + ", name=" + name + "]";
	}

	
	
	
	
}
