package com.eoutletz.mail;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component
public class NotificationService {

	@Inject
	private JavaMailSender javaMailSender;
	
	@Inject
	private VelocityEngine velocityEngine;
	
	public void sendForgotPasswordEmail(String token, String email, String forgotPasswordBaseUrl) 
	{
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("token", token);
		data.put("forgotPasswordBaseUrl", forgotPasswordBaseUrl);
		String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/forgot-pwd-template.vm", "UTF-8", data);
		sendEmail(email, null, "eoutletzalpha@gmail.com", "Reset Password Email", emailText);
	}
	
	
	private void sendEmail(final String to, final String cc, final String from, final String subject, final String body)
	{
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			 public void prepare(MimeMessage mimeMessage) throws Exception {
				 MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
		         message.setTo(to);
		         if(StringUtils.isNotEmpty(cc)){
		        	 message.setCc(cc);
		         }
		         message.setFrom(from); 
		         message.setSubject(subject);
		         message.setText(body, true);
	         }
		};
	    
		try {
            this.javaMailSender.send(preparator);
	    }
	    catch (MailException ex) {
	    	ex.printStackTrace();
	    }
	}
	
}
