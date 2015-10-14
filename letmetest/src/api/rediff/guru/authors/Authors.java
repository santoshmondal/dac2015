package api.rediff.guru.authors;

import javax.xml.bind.annotation.XmlElement;

public class Authors {
	private String id;
	private String byline_source;
	private String emailid;
	private String name;
	private String prcid;

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getByline_source() {
		return byline_source;
	}

	public void setByline_source(String byline_source) {
		this.byline_source = byline_source;
	}

	@XmlElement
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getPrcid() {
		return prcid;
	}

	public void setPrcid(String prcid) {
		this.prcid = prcid;
	}

}
