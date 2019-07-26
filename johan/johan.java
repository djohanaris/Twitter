import java.io.IOException;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class johan {
    private final static String CONSUMER_KEY = "bDrbFqMAvaPo1OADAQlenpxQm";
    private final static String CONSUMER_KEY_SECRET = "y9ND9uyUk6tYNhsjIC6BeP2w0GKalld3nqfeWTPRGNDrhToYcq";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("kepyohhhhhhhh");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "NN2JdNCmD5v3V1PnBsUifP2ayjK71AsKm6n5FrKkVRFY9";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1139542192492408834-JRseX3g86NgxpSATsgiLlZrkrB3qaZ";
    }

    public static void main(String[] args) throws Exception {
	new johan().start();
    }
}
