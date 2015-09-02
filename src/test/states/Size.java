package test.states;

/**
 * @author : Chen
 * @fileName : test.states.Size.java
 * 
 * @date: Aug 30, 2015 11:59:49 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public enum Size {

	small("s"), medium("m"), large("l"), extra_large("xl");
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	private String abbreviation;

}
