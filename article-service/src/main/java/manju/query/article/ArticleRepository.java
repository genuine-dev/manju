package manju.query.article;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String>{
	@Query( "{"
			+ "    \"filtered\": {"
			+ "      \"filter\": {"
			+ "        \"bool\": {"
			+ "          \"must\" :["
//			+ "            {"
//			+ "              \"bool\": {"
//			+ "                \"should\":["
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"publicationTarget\": \"?0\""
//			+ "                    }"
//			+ "                  },"
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"author\": \"?1\""
//			+ "                    }"
//			+ "                  }"
//			+ "                ]"
//			+ "              }"
//			+ "            },"
			+ "            {"
			+ "              \"term\": {"
			+ "                \"status\": \"PUBLISHED\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      }"
			+ "    }"
			+ "  }"
			+ "}"
	)
	Page<Article> findAll(List<String> target, String me, Pageable pageable);

	@Query( "{"
			+ "    \"filtered\": {"
			+ "      \"query\": {"
			+ "        \"bool\": {"
			+ "          \"must\":{"
			+ "            \"term\":{"
			+ "              \"id\":\"?0\""
			+ "            }"
			+ "          }"
			+ "        }"
			+ "      },"
			+ "      \"filter\": {"
			+ "        \"bool\": {"
			+ "          \"must\" :["
//			+ "            {"
//			+ "              \"bool\": {"
//			+ "                \"should\":["
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"publicationTarget\": \"?1\""
//			+ "                    }"
//			+ "                  },"
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"author\": \"?2\""
//			+ "                    }"
//			+ "                  }"
//			+ "                ]"
//			+ "              }"
//			+ "            },"
			+ "            {"
			+ "              \"term\": {"
			+ "                \"status\": \"PUBLISHED\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      }"
			+ "    }"
			+ "  }"
			+ "}"
	)
	Article findById(String id,  List<String> target, String me);
	
	@Query( "{"
			+ "    \"filtered\": {"
			+ "      \"query\": {"
			+ "        \"bool\": {"
			+ "          \"must\":{"
			+ "            \"term\":{"
			+ "              \"author\":\"?0\""
			+ "            }"
			+ "          }"
			+ "        }"
			+ "      },"
			+ "      \"filter\": {"
			+ "        \"bool\": {"
			+ "          \"must\" :["
//			+ "            {"
//			+ "              \"bool\": {"
//			+ "                \"should\":["
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"publicationTarget\": \"?1\""
//			+ "                    }"
//			+ "                  },"
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"author\": \"?2\""
//			+ "                    }"
//			+ "                  }"
//			+ "                ]"
//			+ "              }"
//			+ "            },"
			+ "            {"
			+ "              \"term\": {"
			+ "                \"status\": \"PUBLISHED\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      }"
			+ "    }"
			+ "  }"
			+ "}"
	)
	Page<Article> findByAuthor(String author,  List<String> target, String me,Pageable pageable);
	
	@Query( "{"
			+ "    \"filtered\": {"
			+ "      \"query\": {"
			+ "        \"bool\": {"
			+ "          \"must\":{"
			+ "            \"term\":{"
			+ "              \"tags\":\"?0\""
			+ "            }"
			+ "          }"
			+ "        }"
			+ "      },"
			+ "      \"filter\": {"
			+ "        \"bool\": {"
			+ "          \"must\" :["
//			+ "            {"
//			+ "              \"bool\": {"
//			+ "                \"should\":["
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"publicationTarget\": \"?1\""
//			+ "                    }"
//			+ "                  },"
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"author\": \"?2\""
//			+ "                    }"
//			+ "                  }"
//			+ "                ]"
//			+ "              }"
//			+ "            },"
			+ "            {"
			+ "              \"term\": {"
			+ "                \"status\": \"PUBLISHED\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      }"
			+ "    }"
			+ "  }"
			+ "}"
	)
	Page<Article> findByTag(String tag, List<String> target, String me, Pageable pageable);
	
	@Query(   "{"
			+ "  \"query\": {"
			+ "    \"filtered\": {"
			+ "      \"query\": {"
			+ "        \"bool\": {"
			+ "          \"should\": ["
			+ "            {"
			+ "              \"match\": {"
			+ "                \"title\": \"?0\""
			+ "              }"
			+ "            },"
			+ "            {"
			+ "              \"match\": {"
			+ "                \"body\": \"?0\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      },"
			+ "      \"filter\": {"
			+ "        \"bool\": {"
			+ "          \"must\" :["
//			+ "            {"
//			+ "              \"bool\": {"
//			+ "                \"should\":["
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"publicationTarget\": \"?1\""
//			+ "                    }"
//			+ "                  },"
//			+ "                  {"
//			+ "                    \"term\": {"
//			+ "                      \"author\": \"?2\""
//			+ "                    }"
//			+ "                  }"
//			+ "                ]"
//			+ "              }"
//			+ "            },"
			+ "            {"
			+ "              \"term\": {"
			+ "                \"status\": \"PUBLISHED\""
			+ "              }"
			+ "            }"
			+ "          ]"
			+ "        }"
			+ "      }"
			+ "    }"
			+ "  }"
			+ "}"
	)
	Page<Article> findByKeyword(String keyword,  List<String> target, String me, Pageable pageable);

	@Query( "{"
			+ "    \"filtered\": {"
			+ "      \"query\": {"
			+ "        \"bool\": {"
			+ "          \"must\":{"
			+ "            \"term\":{"
			+ "              \"author\":\"?0\""
			+ "            }"
			+ "          }"
			+ "        }"
			+ "      }"
			+ "  }"
			+ "}"
	)
	Page<Article> findMine(String me, Pageable pageable);

}
