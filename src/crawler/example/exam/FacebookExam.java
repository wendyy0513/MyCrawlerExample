package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.11"
				+ "/adele/posts?fields=reactions.type(LOVE).limit(0).summary(total_count).as(reactions_love)"
				+ "&access_token=EAACEdEose0cBAOfhsZBpDmau3NT53IAA9wImEDNUZCF35tXZCZCN6bfPWWLZATDd5G6CSOgQa0s3qbkmZCZApuwjNNKTjIxnzhZC35vBViUg4e4q1i1USmxZCG1dKxmWfs2fk0N802EATKGEM4tBoWwftkB9dyhAufcLZAAig8F0cqEAWjnbnNpHZC3ZCNNbsxZAagA8ZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = data.select("reactions_love summary total_count").text();


			output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
