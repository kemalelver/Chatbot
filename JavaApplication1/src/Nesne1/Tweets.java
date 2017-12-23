/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nesne1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tweets
{
  public static void getTweets(String  hashtag,String marka) throws Exception 
  {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("K4jb3TT2BgdeycwBwidg4zedT")
      .setOAuthConsumerSecret("TE960xcC8607lFGGQUM2qNghP6G3I2z7Jdtp3rNu0mqd7Vnffi")
      .setOAuthAccessToken("4106909355-9PtDj5X5zTEBdJoiyhjvxX5z59scer0EHKaTU8H")
      .setOAuthAccessTokenSecret("doaesUqBm0pC0E8OcBYNsBAgiTOhuLbpAmMC3sfHnP4QR");
    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
    Query query = new Query("#"+hashtag);
    int numberOfTweets = 300;
    long lastID = Long.MAX_VALUE;
    
    System.out.println(hashtag+" için tweetler toplanýyor...");
    ArrayList<Status> tweets = new ArrayList<Status>();
    int deneme=0;
    ///query.setSince("2017-06-01");/// daha eski tweetleri çekmeyi denedim fakat olmadý.
   /// query.setUntil("2017-11-01");
    		
    while (tweets.size () < numberOfTweets) {
      if (numberOfTweets - tweets.size() > 100)
        query.setCount(100);
      else 
        query.setCount(numberOfTweets - tweets.size());
      
      if(deneme==7)/// 7 denemeden sonra yeterli tweet(200'ün üstünde) toplayamadýysa hashtag aramasýnda markayý kullanýyor
      {
    	   query = new Query("#"+marka);	   
      }
     
      try {
        QueryResult result = twitter.search(query);
        tweets.addAll(result.getTweets());
       System.out.println("Gathered " + tweets.size() + " tweets"+"\n");
       deneme++;
        for (Status t: tweets) 
          if(t.getId() < lastID) 
              lastID = t.getId();
        
      }

      catch (TwitterException te) {
        System.out.println("Couldn't connect: " + te);
      }; 
      query.setMaxId(lastID-1);
      if(deneme==17)/// toplam 17 denemeden sonra hala yeterli tweet yoksa toplamayý sonlandýrýyor.
			/// daha fazla deneme yapmaya twitter apisi izin vermiyor 
    	  break;
    }
    
    Jedis jedis=new Jedis("127.0.0.1", 6379);
    ///System.out.println("Connection to server succcessfully"); 
    ///System.out.println("Server is running: "+jedis.ping()); 
    int tweetCount=0;

    for (int i = 0; i < tweets.size(); i++) {
      Status t = (Status) tweets.get(i);

      if(t.getLang().equals("en"))///Dili ingilizce olan tweetler redis'te hashtagleri key olacak þekilde tutuluyor.
      {
    	jedis.sadd(hashtag, t.getText());
    
    	 //// System.out.println(t.getText());///tweetleri konsola yazdýrmak için kullandým
    	  tweetCount++;
      }
   
    }
    ///System.out.println(hashtag +" için "+tweetCount+" adet tweet toplandi.");
    jedis.close();
  }
}
