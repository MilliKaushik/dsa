package design;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class RateLimiter {

	private class BucketToken {
		private long currentBucket;
		private int currentToken;

		public BucketToken(long currentBucket, int currentToken) {
			this.currentBucket = currentBucket;
			this.currentToken = currentToken;
		}
	}

	private int tokensAllowed;
	private int windowSize;
	private Map<Integer, BucketToken> customerMapping;
	private Date referenceTime;

	public RateLimiter(int tokenNo, int windowSize) {
		this.tokensAllowed = tokenNo;
		this.windowSize = windowSize;
		customerMapping = new HashMap<>();
		referenceTime = new Date();

	}

	public boolean rateLimit(int customerId) {
		long custBucket = getCurrentBucket(new Date());
		BucketToken currBuckTok = customerMapping.get(customerId);

		if (currBuckTok == null)
			currBuckTok = addCustomer(customerId, custBucket);

		if (custBucket == currBuckTok.currentBucket && currBuckTok.currentToken > 0) {
			customerMapping.put(customerId, new BucketToken(currBuckTok.currentBucket, currBuckTok.currentToken - 1));
			return true;
		} else if (custBucket != currBuckTok.currentBucket) {
			customerMapping.put(customerId, new BucketToken(custBucket, tokensAllowed - 1));
			return true;
		}
		return false;
	}

	private BucketToken addCustomer(int customerId, long custBucket) {
		customerMapping.put(customerId, new BucketToken(custBucket, tokensAllowed));
		return customerMapping.get(customerId);
	}

	private long getCurrentBucket(Date currentTime) {
		return (currentTime.getTime() - referenceTime.getTime()) / windowSize;
	}

}

//c1 -> (timestamp - the last time that this customer made a request, token)
// 11 c1 -> 10 -> 9
// 11.05 -> 0 -> false
// 12.10 -> timestamp - 11.30 and token 5 -> timestamp, token 9

// 11th 11.00
// 12.09

// Perform rate limiting logic for provided customer ID. Return true if the
// request is allowed, and false if it is not.

// if(diff in time <= 60 && sameMinute(t1,t2) && token != 0) {
// update map
// return true
// } else return false

// c1 -> (bucket no, token) - 4 c1 latest request calculate bucket no
// if its diff -> re-initialze and update token and bucket no
// else check if token available and update only the token, no need to change
// the bucket
