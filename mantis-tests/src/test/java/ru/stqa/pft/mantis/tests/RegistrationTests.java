package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRegistration() throws InterruptedException, MessagingException, IOException {
    long now = System.currentTimeMillis();
    String email =String.format("user%s@localhost.localdomain"+now);
    String user = String.format("user%s"+now);
    app.registration().start(user,email);
    List<MailMessage> mailMessages = app.mail().waitForEmail(2,10000);
    String confrimationLink = findConfirmationLink(mailMessages,email);
    String password = "password";
    app.registration().finish(confrimationLink, password);
    Assert.assertTrue(app.newSession().login(user,password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
     MailMessage mailMessage = mailMessages.stream().filter((m)-> m.to.equals(email)).findFirst().get();
     VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
     return  regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
