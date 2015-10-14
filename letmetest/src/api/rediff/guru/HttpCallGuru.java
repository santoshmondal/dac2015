package api.rediff.guru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import api.rediff.guru.authors.AuthorRequestRoot;
import api.rediff.guru.authors.Authors;
import api.rediff.guru.feeds.Article;
import api.rediff.guru.feeds.FeedRequest;

public class HttpCallGuru {
	private static final Logger log = LogManager.getLogger(HttpCallGuru.class);
	
	private static final Map<String, String> params = new HashMap<>();
	private static final OkHttpClient client = new OkHttpClient();
	
	private static final String AUTHORS_URL = "http://www.rediff.com/rss/authors.xml";
	private static final String FEED_URL = "https://rps.rediff.com/backyardApps/listRestFeedPost.action?";
	//private static final String FEED_URL = "http://119.252.154.134:8080/backyardApps//listRestFeedPost.action?";

	public static void main(String[] args) throws Exception {
		AuthorRequestRoot authors = getAuthors();
		getAuthorsFeed(authors);
		//feedCall("3539086");
		
	}

	public static AuthorRequestRoot getAuthors() throws Exception {
		AuthorRequestRoot authors = null;
		Request.Builder rBuilder = new Request.Builder();
		Request request = rBuilder.url(AUTHORS_URL).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			log.error("AUTHORS_URL_ERROR");
			throw new IOException("Unexpected code " + response);
		} else {
			String strResponse = response.body().string();
			authors = (AuthorRequestRoot)JaxbUtil.convertXmlToObject(AuthorRequestRoot.class.getName(), strResponse, null);
			System.out.println(authors);
		}

		return authors;
	}

	public static void getAuthorsFeed(AuthorRequestRoot authors) {
		try{
			if(authors != null && authors.getAuthors() != null) {
				for(Authors author : authors.getAuthors()) {
					if(author.getPrcid() != null) {
						feedCall(author.getPrcid());
					}
				}
			}
		} catch(Exception e) {
			log.error("ERROR ", e);
		}
	}
	
	public static void feedCall(String profile_id) {
		params.put("type", "published");
		
		try{
			params.put("profile_id", profile_id);
			String postParams = getPostDataString(params);
			
			Request.Builder rBuilder = new Request.Builder();
			Request request = rBuilder.url(FEED_URL + postParams).build();

			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				log.error("AUTHOR_FEED_ERROR :: " + profile_id);
			} else {
				String json = response.body().string();
				try {
					FeedRequest authorFeed = (FeedRequest)JsonUtil.jsonToObject(json, FeedRequest.class);
					writeToFile(authorFeed);
					log.info("AUTHR_FEED_SUCCESS :: " + profile_id);
				} catch(Exception e) {
					log.error("AUTHOR_FEED_JSON_PARSE_ERROR :: " + profile_id);
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile(FeedRequest authorFeed) {
		try {
			if(authorFeed != null && authorFeed.getArticle_list() != null) {
				File file = new File("/home/santoshm/Desktop/author_url.txt");
				FileWriter writer = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(writer);

				for(Article article : authorFeed.getArticle_list()) {
					String topics = article.getTopics();
					String topic = "";
					if(topics != null && !topics.isEmpty()) {
						String temp[] = topics.split(",");
						if(temp.length > 0) {
							topic = temp[0];
						}
					}
					
					String url = "";
					if(article.getLive_url() != null && !article.getLive_url().trim().isEmpty()) {
						url = article.getLive_url();
					}
					
					bw.write(authorFeed.getProfile_id() + ", "+ topic + ", " + url);
					bw.write("\n");
				}
				
				bw.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first) {
				first = false;
			} else {
				result.append("&");
			}

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return result.toString();
	}
}
