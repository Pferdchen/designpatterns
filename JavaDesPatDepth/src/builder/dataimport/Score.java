package builder.dataimport;

public class Score {
	private String studno;

	private String name;

	private int score;

	public Score(String studno, String name, int score) {
		this.studno = studno;
		this.name = name;
		this.score = score;
	}

	public String getStudno() {
		return studno;
	}

	public void setStudno(String studno) {
		this.studno = studno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
