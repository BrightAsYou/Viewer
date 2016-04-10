package prs.rfh.thread;

public class Deal {
	
	@Override
	public String toString() {
		return "Deal [name=" + name + ", isFinished=" + isFinished + "]";
	}
	Deal(String name,String isFinished){
		this.name = name;
		this.isFinished = isFinished ;
	}
	
	private String name;
	private String isFinished;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
	
	public void setFinish(){
		this.setIsFinished("0");
	}
}
