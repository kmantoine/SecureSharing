package SecureShareServer;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.Calendar;
import com.twilio.type.PhoneNumber;
import com.twilio.exception.ApiException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arkane
 */
public class SMS {

    public static final String ACCOUNT_SID = "AC788b51144dd24af8f0191d60a2070936";
    private static final String AUTH_TOKEN = "4232e2246cb9a0a912a7d5b63501edcd"; //Please note token used in this example is for testing purposes only. This will not send a SMS to a phone number.

    public static void SendPassword(String number, String key) {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String sender = "15005550006";
        String body = key;

        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(new PhoneNumber("+1" + number), new PhoneNumber(sender), key).create();

            Logger.getLogger (SMS.class.getName()).log (Level.INFO, "Text message sent:", body + timeStamp + message.getSid());
            System.exit(0);

        } catch (ApiException ex) {
            Logger.getLogger (SMS.class.getName()).log (Level.WARNING, "Message has not been sent", ex + timeStamp);
            System.exit(0);
        }
    }

}
