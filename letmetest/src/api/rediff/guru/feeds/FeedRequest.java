package api.rediff.guru.feeds;

import java.util.List;

public class FeedRequest {
	private String profile_id;
	private String type;
	private String totalCount;

	private List<Article> article_list;

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<Article> getArticle_list() {
		return article_list;
	}

	public void setArticle_list(List<Article> article_list) {
		this.article_list = article_list;
	}

}
