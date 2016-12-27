package manju;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import manju.query.article.Article;
import manju.query.article.ArticleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

	@Autowired
	ArticleRepository repository;
	
	@Test
	public void test() {
		
		Article article = new Article();
		article.setId(UUID.randomUUID().toString());
		article.setAuthor("0123456789012");
		article.setTitle("BBB");
		article.setBody("今日の天気は快晴です。明日はどうでしょう？");
		article.setPublicationTarget(Arrays.asList("0123456789012", "test"));
		article.setTags(Arrays.asList("java", "spring"));
		article.setStatus("PUBLISHED");
		article.setPublishedDateTime(new Date());
//		repository.save(article);
		Iterable<Article> result = repository.findByTag("java", Arrays.asList("test"), "0123456789012", new PageRequest(0, 20)); 
				//repository.findByTitleOrBody("Spring", "Spring", new PageRequest(0, 20));
		Article article2 = repository.findById("58d01fe6-efa4-45c2-a54e-79605d80f984", Arrays.asList("test"), "0123456789012");
		for(Article a: result){
			System.out.println(a.getBody());
		}
		
	}

}
